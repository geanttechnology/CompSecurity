// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.databerries:
//            MySQLiteHelper, LocationData, DataBerriesLocation

public class LocationDataHandler
{

    private String TAG;
    private String allColumns[] = {
        "_id", "_date", "longitude", "latitude", "accuracy", "uuid"
    };
    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public LocationDataHandler(Context context)
    {
        TAG = "DataBerriesLocationDataHandler";
        dbHelper = new MySQLiteHelper(context);
    }

    private LocationData cursorToLocation(Cursor cursor)
    {
        LocationData locationdata = new LocationData();
        locationdata.set_id(cursor.getLong(0));
        locationdata.set_date(cursor.getInt(1));
        locationdata.set_longitude(cursor.getDouble(2));
        locationdata.set_latitude(cursor.getDouble(3));
        locationdata.set_accuracy(cursor.getInt(4));
        locationdata.set_uuid(cursor.getString(5));
        return locationdata;
    }

    void addLocation(double d, double d1, float f, int i, String s)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("longitude", Double.valueOf(d));
        contentvalues.put("latitude", Double.valueOf(d1));
        contentvalues.put("accuracy", Integer.valueOf((int)f));
        contentvalues.put("_date", Integer.valueOf(i));
        contentvalues.put("uuid", s);
        db.insert("locations", null, contentvalues);
    }

    void affAllLocations()
    {
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        Log.d(TAG, "hello, here is the list of all the Locations stocked in the base");
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            LocationData locationdata = cursorToLocation(cursor);
            Log.d(TAG, locationdata.toString());
        }

        cursor.close();
    }

    void close()
    {
        dbHelper.close();
    }

    int countLocations()
    {
        int i = 0;
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            i++;
        }

        cursor.close();
        return i;
    }

    void deleteAllLocations()
    {
        db.execSQL("DROP TABLE IF EXISTS locations");
        dbHelper.createLocationTable(db);
        try
        {
            open();
            return;
        }
        catch (SQLException sqlexception)
        {
            Log.e(TAG, "error deleteAllLocations failed hard !");
        }
    }

    void deleteLocation(LocationData locationdata)
    {
        long l = locationdata.get_id();
        db.delete("locations", (new StringBuilder()).append("_id = ").append(l).toString(), null);
    }

    void deleteSomeLocations()
    {
        for (int i = DataBerriesLocation.getEventModulo(); i >= 0; i--)
        {
            getNextLocation();
        }

    }

    String[] getAllColumns()
    {
        return allColumns;
    }

    List getAllLocations()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            arraylist.add(cursorToLocation(cursor));
        }

        cursor.close();
        return arraylist;
    }

    int getFirstDate()
    {
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        LocationData locationdata = cursorToLocation(cursor);
        cursor.close();
        return locationdata.get_date();
    }

    int getLastDate()
    {
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToLast();
        LocationData locationdata = cursorToLocation(cursor);
        cursor.close();
        return locationdata.get_date();
    }

    LocationData getNextLocation()
    {
        Cursor cursor = db.query("locations", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        LocationData locationdata = cursorToLocation(cursor);
        cursor.close();
        deleteLocation(locationdata);
        return locationdata;
    }

    void open()
        throws SQLException
    {
        db = dbHelper.getWritableDatabase();
    }
}
