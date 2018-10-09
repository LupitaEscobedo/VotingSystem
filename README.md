# VotingSystem

Description

This is a client-server application to simulate a voting system developed to accredit the course of Distributed Systems in the semester Jan - June 2018

Database

This application uses MySQL to store the information about the users and about the candidates. Each user must be unique and needs to login to vote. The table Candidates contains all the information about each candidate, including the name, political party, a picture and the proposals they offer.

Server

Manages the database and validate that each user can vote only once. The server also manages the conexion with the DropBox API to get the pictures of the candidates stored in the DropBox account.

Client

Interact with the users by displaying a window with all the information they need to know about the candidates, so that they can choose the best option for them.

Conexion

The clients stablish the conexion with the server using CORBA arquitecture. The IDL files are stored with the others classes in each the server folder and the client folder.

