package com.sarang.ecsfin.CRUD_Sample.crud;

import javax.inject.Singleton; 

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Singleton
public class ConnectToDB {
	private static ConnectToDB mongoDb;
	private static MongoClient mongoClient;
	private static MongoDatabase db;
	
	private static final String dbHost = "localhost";
	private static final int dbPort = 27017;
	private static final String dbName = "studentcrud";
	
	private static CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	
	private ConnectToDB() {
		
	}
	
	public static MongoDatabase getDb() {
		if(mongoClient == null) 
			mongoClient = new MongoClient(dbHost, dbPort);
		if (db == null)
			db = mongoClient.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);
		
		return db;
		
	}
	

	public static ConnectToDB getInstance() {
		if (mongoDb == null) {
			mongoDb = new ConnectToDB();
		}
		return mongoDb;
	}
	

}
