// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.log:
//            Attribute, Event

public class AnalyticsDatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "eventBatcher";
    private static final int DATABASE_VERSION = 2;
    private static final String KEY_ATTRIBUTE_NAME = "attributeName";
    private static final String KEY_ATTRIBUTE_TYPE = "attributeType";
    private static final String KEY_ATTRIBUTE_VALUE = "attributeValue";
    private static final String KEY_DATA = "data";
    private static final String KEY_EVENT_ID = "eventId";
    private static final String KEY_ID = "id";
    private static final String KEY_SESSION_ID = "sessionId";
    private static final String KEY_TIMESTAMP = "timeStamp";
    public static final String TABLE_ATTRIBUTES = "attributes";
    public static final String TABLE_EVENTS = "events";
    public static final String TAG = "AnalyticsDatabaseHelper";
    private static AnalyticsDatabaseHelper sInstance;

    private AnalyticsDatabaseHelper(Context context)
    {
        super(context, "eventBatcher", null, 2);
    }

    public static AnalyticsDatabaseHelper getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new AnalyticsDatabaseHelper(context);
        }
        return sInstance;
    }

    public void addAttribute(Attribute attribute)
    {
        try
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("sessionId", attribute.getSessionId());
            contentvalues.put("attributeName", attribute.getAttributeName());
            contentvalues.put("attributeType", attribute.getAttributeType());
            contentvalues.put("attributeValue", attribute.getAttributeValue().toString());
            sqlitedatabase.insert("attributes", null, contentvalues);
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Attribute attribute)
        {
            attribute.getMessage();
        }
    }

    public void addEvent(Event event)
    {
        try
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("sessionId", event.getSessionId());
            contentvalues.put("eventId", event.getEventId());
            contentvalues.put("data", event.getParameters());
            contentvalues.put("timeStamp", event.getTimeStamp());
            sqlitedatabase.insert("events", null, contentvalues);
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Event event)
        {
            event.getMessage();
        }
    }

    public void deleteItemsByIds(String s, ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(");
        Iterator iterator = arraylist.iterator();
        arraylist = "";
        String s1;
        for (; iterator.hasNext(); stringbuilder.append(s1))
        {
            s1 = (String)iterator.next();
            stringbuilder.append(arraylist);
            arraylist = ",";
        }

        stringbuilder.append(")");
        arraylist = stringbuilder.toString();
        try
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            sqlitedatabase.delete(s, (new StringBuilder("id in ")).append(arraylist).toString(), null);
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
        }
    }

    public List getAttributesBySessionId(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = (new StringBuilder("SELECT  * FROM attributes WHERE sessionId = \"")).append(s).append("\"").toString();
        s = getWritableDatabase().rawQuery(s, null);
        if (s != null && s.moveToFirst())
        {
            do
            {
                Attribute attribute = new Attribute();
                attribute.setId(Integer.parseInt(s.getString(0)));
                attribute.setSessionId(s.getString(1));
                attribute.setAttributeName(s.getString(2));
                attribute.setAttributeType(s.getString(3));
                try
                {
                    attribute.setAttributeValue(new JSONObject(s.getString(4)));
                }
                catch (JSONException jsonexception)
                {
                    Log.e("AnalyticsDatabaseHelper", jsonexception.getMessage());
                }
                arraylist.add(attribute);
            } while (s.moveToNext());
            s.close();
        }
        return arraylist;
    }

    public List getEventsBySessionId(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = (new StringBuilder("SELECT  * FROM events WHERE sessionId = \"")).append(s).append("\"").toString();
        s = getWritableDatabase().rawQuery(s, null);
        if (s != null && s.moveToFirst())
        {
            do
            {
                Event event = new Event();
                event.setId(Integer.parseInt(s.getString(0)));
                event.setSessionId(s.getString(1));
                event.setEventId(s.getString(2));
                event.setParameters(s.getString(3));
                event.setTimeStamp(Long.valueOf(Long.parseLong(s.getString(4))));
                arraylist.add(event);
            } while (s.moveToNext());
            s.close();
        }
        return arraylist;
    }

    public ArrayList getSessionIds()
    {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT sessionId FROM events UNION  SELECT sessionId FROM attributes", null);
        ArrayList arraylist = new ArrayList();
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                arraylist.add(cursor.getString(cursor.getColumnIndex("sessionId")));
            }

            cursor.close();
        }
        return arraylist;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE events(id INTEGER PRIMARY KEY,sessionId TEXT,eventId TEXT,data TEXT,timeStamp INTEGER)");
        sqlitedatabase.execSQL("CREATE TABLE attributes(id INTEGER PRIMARY KEY,sessionId TEXT,attributeName TEXT,attributeType TEXT,attributeValue TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS events");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS attributes");
        onCreate(sqlitedatabase);
    }
}
