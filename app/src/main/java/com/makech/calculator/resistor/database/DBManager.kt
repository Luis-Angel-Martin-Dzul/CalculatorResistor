package com.makech.calculator.resistor.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(context : Context) : SQLiteOpenHelper(context, "calculator_resistor", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE BandOfColor (" +
                "Id INTEGER NOT NULL PRIMARY KEY, " +
                "Name TEXT NOT NULL)")

        db.execSQL("CREATE TABLE BandMultiplier (" +
                "Id INTEGER NOT NULL PRIMARY KEY, " +
                "FkColor INT NOT NULL, " +
                "OMS REAL NOT NULL, " +
                "FOREIGN KEY (FkColor) REFERENCES BandOfColor(Id))")

        db.execSQL("CREATE TABLE BandTolerance (" +
                "Id INTEGER NOT NULL PRIMARY KEY, " +
                "FkColor INTEGER NOT NULL, " +
                "Value REAL NOT NULL, " +
                "FOREIGN KEY (FkColor) REFERENCES BandOfColor(Id))")

        db.execSQL("CREATE TABLE BandPPM (" +
                "Id INTEGER NOT NULL PRIMARY KEY, " +
                "FkColor INTEGER NOT NULL, " +
                "Value TEXT NOT NULL, " +
                "FOREIGN KEY (FkColor) REFERENCES BandOfColor(Id))")

        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (0, 'Black');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (1, 'Brown');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (2, 'Red');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (3, 'Orange');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (4, 'Yellow');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (5, 'Green');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (6, 'Blue');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (7, 'Violet');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (8, 'Grey');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (9, 'White');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (10, 'Gold');")
        db.execSQL("INSERT INTO BandOfColor(Id, Name) VALUES (11, 'Silver');")

        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (0, 0, 1);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (1, 1, 10);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (2, 2, 100);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (3, 3, 1000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (4, 4, 10000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (5, 5, 100000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (6, 6, 1000000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (7, 7, 10000000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (8, 8, 100000000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (9, 9, 1000000000);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (10, 10, 0.1);")
        db.execSQL("INSERT INTO BandMultiplier(Id, FkColor, OMS) VALUES (11, 11, 0.01);")

        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (0, 1, 1);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (1, 2, 2);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (2, 5, 0.5);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (3, 6, 0.25);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (4, 7, 0.1);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (5, 8, 0.05)")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (7, 10, 5);")
        db.execSQL("INSERT INTO BandTolerance(Id, FkColor, Value) VALUES (8, 11, 10);")

        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (1, 1, 100);")
        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (2, 2, 50);")
        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (3, 3, 15);")
        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (4, 4, 25);")
        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (5, 6, 10);")
        db.execSQL("INSERT INTO BandPPM(Id, FkColor, Value) VALUES (6, 7, 5);")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS BandOfColor")
        db.execSQL("DROP TABLE IF EXISTS BandMultiplier")
        db.execSQL("DROP TABLE IF EXISTS BandTolerance")
        db.execSQL("DROP TABLE IF EXISTS BandPPM")
        onCreate(db)
    }


}