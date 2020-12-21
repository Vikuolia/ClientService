package com.example.client.api;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import com.example.instructor.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class GrpcClientController extends ClientServiceGrpc.ClientServiceImplBase {

    @Autowired
    private ClientService clientService;

    @Override
    public void add(ClientRequest request, StreamObserver<ClientResponse> responseObserver) {
        String name = request.getName();
        String surname = request.getSurname();
        int age = request.getAge();
        int back = request.getBackground();
        boolean student = request.getStudent();

        Client clientAdd = new Client(name, surname, age, back, student);
        Client clientResponse = clientService.addClient(clientAdd);

        ClientResponse response = ClientResponse.newBuilder()
                                                .setId(clientResponse.getClientId())
                                                .setName(clientResponse.getName())
                                                .setSurname(clientResponse.getSurname())
                                                .setAge(clientResponse.getAge())
                                                .setBackground(clientResponse.getBackground())
                                                .setStudent(clientResponse.isStudent())
                                                .setFreqBuyer(clientResponse.isFrequentBuyer())
                                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllClientsRequest request, StreamObserver<AllClientsResponse> responseObserver) {
        List<Client> clients = clientService.getAll();
        List<ClientResponse> responses = new ArrayList<>();

        for (Client client: clients){
            ClientResponse oneResponse = ClientResponse.newBuilder()
                                                       .setId(client.getClientId())
                                                       .setName(client.getName())
                                                       .setSurname(client.getSurname())
                                                       .setAge(client.getAge())
                                                       .setBackground(client.getBackground())
                                                       .setStudent(client.isStudent())
                                                       .setFreqBuyer(client.isFrequentBuyer())
                                                       .build();
            responses.add(oneResponse);
        }
        AllClientsResponse response = AllClientsResponse.newBuilder().addAllClients(responses).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(ClientByIdRequest request, StreamObserver<ClientResponse> responseObserver) {
        Client client = clientService.getById(request.getId());
        ClientResponse response = ClientResponse.newBuilder()
                                                .setId(client.getClientId())
                                                .setName(client.getName())
                                                .setSurname(client.getSurname())
                                                .setAge(client.getAge())
                                                .setBackground(client.getBackground())
                                                .setStudent(client.isStudent())
                                                .setFreqBuyer(client.isFrequentBuyer())
                                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(ClientByIdRequest request, StreamObserver<DeleteClientResponse> responseObserver) {
        clientService.deleteById(request.getId());
        DeleteClientResponse response = DeleteClientResponse.newBuilder()
                .setResponse("Client with id " + request.getId() + " was deleted").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}