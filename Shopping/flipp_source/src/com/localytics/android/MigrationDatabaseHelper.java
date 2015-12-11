// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, Constants, DatapointHelper

final class MigrationDatabaseHelper extends SQLiteOpenHelper
{

    private static final String CLOSE_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "close"
    });
    private static final String EVENTS_SORT_ORDER = String.format("CAST(%s as TEXT)", new Object[] {
        "_id"
    });
    private static final String EVENT_FORMAT = "%s:%s";
    private static final String FLOW_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "flow"
    });
    private static final String JOINER_ARG_UPLOAD_EVENTS_COLUMNS[] = {
        "_id"
    };
    private static final String OPEN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "open"
    });
    private static final String OPT_IN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_in"
    });
    private static final String OPT_OUT_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_out"
    });
    private static final String PROJECTION_UPLOAD_BLOBS[] = {
        "events_key_ref"
    };
    private static final String PROJECTION_UPLOAD_EVENTS[] = {
        "_id", "event_name", "wall_time"
    };
    private static final String SELECTION_UPLOAD_NULL_BLOBS = String.format("%s IS NULL", new Object[] {
        "processed_in_blob"
    });
    private static final String UPLOAD_BLOBS_EVENTS_SORT_ORDER = String.format("CAST(%s AS TEXT)", new Object[] {
        "events_key_ref"
    });
    private LocalyticsDao mLocalyticsDao;

    MigrationDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
    {
        super(localyticsdao.getAppContext(), s, null, i);
        mLocalyticsDao = localyticsdao;
    }

    private static JSONObject convertAttributesToJson(SQLiteDatabase sqlitedatabase, Context context, long l)
    {
        JSONObject jsonobject = null;
        Cursor cursor = sqlitedatabase.query("attributes", null, String.format("%s = ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ?", new Object[] {
            "events_key_ref", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", 
            "attribute_key"
        }), new String[] {
            Long.toString(l), AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9, 
            AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10
        }, null, null, null);
        int i = cursor.getCount();
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        sqlitedatabase = null;
_L5:
        return sqlitedatabase;
_L2:
        jsonobject = new JSONObject();
        int j = cursor.getColumnIndexOrThrow("attribute_key");
        int k = cursor.getColumnIndexOrThrow("attribute_value");
        String s;
        for (; cursor.moveToNext(); jsonobject.put(sqlitedatabase.substring(context.getPackageName().length() + 1, sqlitedatabase.length()), s))
        {
            sqlitedatabase = cursor.getString(j);
            s = cursor.getString(k);
        }

          goto _L3
        sqlitedatabase;
        context = cursor;
_L6:
        if (context != null)
        {
            context.close();
        }
        throw sqlitedatabase;
_L3:
        sqlitedatabase = jsonobject;
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return jsonobject;
        sqlitedatabase;
        context = jsonobject;
          goto _L6
    }

    static List convertDatabaseToJson(Context context, SQLiteDatabase sqlitedatabase, String s)
    {
        LinkedList linkedlist = new LinkedList();
        Cursor cursor = sqlitedatabase.query("upload_blobs", null, null, null, null, null, null);
        int i;
        int j;
        long l;
        l = getApiKeyCreationTime(sqlitedatabase, s);
        i = cursor.getColumnIndexOrThrow("_id");
        j = cursor.getColumnIndexOrThrow("uuid");
_L2:
        boolean flag = cursor.moveToNext();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        JSONObject jsonobject;
        Object obj1;
        jsonobject = new JSONObject();
        jsonobject.put("dt", "h");
        jsonobject.put("pa", l);
        jsonobject.put("seq", cursor.getLong(i));
        jsonobject.put("u", cursor.getString(j));
        obj1 = getAttributesFromSession(sqlitedatabase, s, getSessionIdForBlobId(sqlitedatabase, cursor.getLong(i)));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (cursor != null)
        {
            cursor.close();
        }
        Localytics.Log.v(String.format("JSON result is %s", new Object[] {
            linkedlist.toString()
        }));
        return linkedlist;
        jsonobject.put("attrs", obj1);
        obj1 = getIdentifiers(sqlitedatabase);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        jsonobject.put("ids", obj1);
        linkedlist.add(jsonobject);
        Localytics.Log.w(linkedlist.toString());
        String s1 = String.format("%s = ?", new Object[] {
            "upload_blobs_key_ref"
        });
        obj1 = Long.toString(cursor.getLong(i));
        obj1 = sqlitedatabase.query("upload_blob_events", new String[] {
            "_id", "events_key_ref"
        }, s1, new String[] {
            obj1
        }, null, null, "events_key_ref");
        int k = ((Cursor) (obj1)).getColumnIndexOrThrow("events_key_ref");
        for (; ((Cursor) (obj1)).moveToNext() && linkedlist.size() < 100; sqlitedatabase.delete("upload_blob_events", String.format("%s = ?", new Object[] {
    "_id"
}), new String[] {
    Integer.toString(((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("_id")))
}))
        {
            linkedlist.add(convertEventToJson(sqlitedatabase, context, ((Cursor) (obj1)).getLong(k), cursor.getLong(i), s));
        }

          goto _L1
        Object obj;
        obj;
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_430;
        }
        ((Cursor) (obj1)).close();
        throw obj;
        obj;
        Localytics.Log.w("Caught exception", ((Throwable) (obj)));
          goto _L2
        context;
        sqlitedatabase = cursor;
_L4:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        throw context;
_L1:
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
          goto _L2
        context;
        sqlitedatabase = null;
          goto _L4
        obj;
        obj1 = null;
          goto _L5
    }

    private static JSONObject convertEventToJson(SQLiteDatabase sqlitedatabase, Context context, long l, long l1, String s)
    {
        JSONObject jsonobject = new JSONObject();
        Cursor cursor = sqlitedatabase.query("events", null, String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Long.toString(l)
        }, null, null, "_id");
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        long l2;
        long l3;
        obj = cursor.getString(cursor.getColumnIndexOrThrow("event_name"));
        l2 = getSessionIdForEventId(sqlitedatabase, l);
        s1 = getSessionUuid(sqlitedatabase, l2);
        l3 = getSessionStartTime(sqlitedatabase, l2);
        if (!OPEN_EVENT.equals(obj)) goto _L4; else goto _L3
_L3:
        jsonobject.put("dt", "s");
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        jsonobject.put("u", s1);
        l1 = getElapsedTimeSinceLastSession(sqlitedatabase, l2);
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        jsonobject.put("sl", Math.round(l1 / 1000L));
        double d;
        double d1;
        jsonobject.put("nth", l2);
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")) || cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_324;
        }
        d = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        d1 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d == 0.0D || d1 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        jsonobject.put("lat", d);
        jsonobject.put("lng", d1);
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            context = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
            s = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
            jsonobject.put("cid", context);
            jsonobject.put("utp", s);
        }
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        }
        sqlitedatabase = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        int i;
        int j;
        i = sqlitedatabase.getColumnIndexOrThrow("attribute_key");
        j = sqlitedatabase.getColumnIndexOrThrow("attribute_value");
_L9:
        if (!sqlitedatabase.moveToNext()) goto _L6; else goto _L5
_L5:
        context = sqlitedatabase.getString(i);
        s = sqlitedatabase.getString(j);
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(context)) goto _L8; else goto _L7
_L7:
        jsonobject.put(getCustomDimensionKey(1), s);
          goto _L9
        s;
        context = sqlitedatabase;
        sqlitedatabase = s;
_L52:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        context.close();
        throw sqlitedatabase;
        sqlitedatabase;
        context = cursor;
_L46:
        if (context != null)
        {
            context.close();
        }
        throw sqlitedatabase;
_L8:
label0:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(context))
            {
                break label0;
            }
            jsonobject.put(getCustomDimensionKey(2), s);
        }
          goto _L9
label1:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(context))
            {
                break label1;
            }
            jsonobject.put(getCustomDimensionKey(3), s);
        }
          goto _L9
label2:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(context))
            {
                break label2;
            }
            jsonobject.put(getCustomDimensionKey(4), s);
        }
          goto _L9
label3:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(context))
            {
                break label3;
            }
            jsonobject.put(getCustomDimensionKey(5), s);
        }
          goto _L9
label4:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(context))
            {
                break label4;
            }
            jsonobject.put(getCustomDimensionKey(6), s);
        }
          goto _L9
label5:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(context))
            {
                break label5;
            }
            jsonobject.put(getCustomDimensionKey(7), s);
        }
          goto _L9
label6:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(context))
            {
                break label6;
            }
            jsonobject.put(getCustomDimensionKey(8), s);
        }
          goto _L9
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(context)) goto _L11; else goto _L10
_L10:
        jsonobject.put(getCustomDimensionKey(9), s);
          goto _L9
_L11:
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(context)) goto _L9; else goto _L12
_L12:
        jsonobject.put(getCustomDimensionKey(10), s);
          goto _L9
_L6:
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_837;
        }
        sqlitedatabase.close();
_L27:
        if (cursor != null)
        {
            cursor.close();
        }
        return jsonobject;
_L4:
        if (!CLOSE_EVENT.equals(obj)) goto _L14; else goto _L13
_L13:
        jsonobject.put("dt", "c");
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        jsonobject.put("su", s1);
        jsonobject.put("ss", Math.round((double)l3 / 1000D));
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        context = String.format("%s = ?", new Object[] {
            "_id"
        });
        s = Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow("session_key_ref")));
        context = sqlitedatabase.query("sessions", new String[] {
            "session_start_wall_time"
        }, context, new String[] {
            s
        }, null, null, null);
        if (!context.moveToFirst()) goto _L16; else goto _L15
_L15:
        jsonobject.put("ctl", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D) - Math.round((double)context.getLong(context.getColumnIndexOrThrow("session_start_wall_time")) / 1000D));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1106;
        }
        context.close();
        context = String.format("%s = ? AND %s = ?", new Object[] {
            "session_key_ref", "type"
        });
        s = Long.toString(l2);
        obj = Integer.toString(1);
        context = sqlitedatabase.query("event_history", new String[] {
            "name"
        }, context, new String[] {
            s, obj
        }, null, null, "_id");
        s = new JSONArray();
        for (; context.moveToNext(); s.put(context.getString(context.getColumnIndexOrThrow("name")))) { }
          goto _L17
        sqlitedatabase;
_L50:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1232;
        }
        context.close();
        throw sqlitedatabase;
_L16:
        throw new RuntimeException("Session didn't exist");
        sqlitedatabase;
_L51:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1256;
        }
        context.close();
        throw sqlitedatabase;
_L17:
        if (s.length() > 0)
        {
            jsonobject.put("fl", s);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1287;
        }
        context.close();
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")) || cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_1401;
        }
        d = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        d1 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d == 0.0D || d1 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_1401;
        }
        jsonobject.put("lat", d);
        jsonobject.put("lng", d1);
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            context = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
            s = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
            jsonobject.put("cid", context);
            jsonobject.put("utp", s);
        }
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        }
        sqlitedatabase = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        i = sqlitedatabase.getColumnIndexOrThrow("attribute_key");
        j = sqlitedatabase.getColumnIndexOrThrow("attribute_value");
_L22:
        if (!sqlitedatabase.moveToNext()) goto _L19; else goto _L18
_L18:
        context = sqlitedatabase.getString(i);
        s = sqlitedatabase.getString(j);
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(context)) goto _L21; else goto _L20
_L20:
        jsonobject.put(getCustomDimensionKey(1), s);
          goto _L22
        s;
        context = sqlitedatabase;
        sqlitedatabase = s;
_L49:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1656;
        }
        context.close();
        throw sqlitedatabase;
_L21:
label7:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(context))
            {
                break label7;
            }
            jsonobject.put(getCustomDimensionKey(2), s);
        }
          goto _L22
label8:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(context))
            {
                break label8;
            }
            jsonobject.put(getCustomDimensionKey(3), s);
        }
          goto _L22
label9:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(context))
            {
                break label9;
            }
            jsonobject.put(getCustomDimensionKey(4), s);
        }
          goto _L22
label10:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(context))
            {
                break label10;
            }
            jsonobject.put(getCustomDimensionKey(5), s);
        }
          goto _L22
label11:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(context))
            {
                break label11;
            }
            jsonobject.put(getCustomDimensionKey(6), s);
        }
          goto _L22
label12:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(context))
            {
                break label12;
            }
            jsonobject.put(getCustomDimensionKey(7), s);
        }
          goto _L22
label13:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(context))
            {
                break label13;
            }
            jsonobject.put(getCustomDimensionKey(8), s);
        }
          goto _L22
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(context)) goto _L24; else goto _L23
_L23:
        jsonobject.put(getCustomDimensionKey(9), s);
          goto _L22
_L24:
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(context)) goto _L22; else goto _L25
_L25:
        jsonobject.put(getCustomDimensionKey(10), s);
          goto _L22
_L19:
        if (sqlitedatabase == null) goto _L27; else goto _L26
_L26:
        sqlitedatabase.close();
          goto _L27
_L14:
        if (!OPT_IN_EVENT.equals(obj) && !OPT_OUT_EVENT.equals(obj))
        {
            break MISSING_BLOCK_LABEL_2018;
        }
        jsonobject.put("dt", "o");
        jsonobject.put("u", s);
        if (!OPT_OUT_EVENT.equals(obj))
        {
            break MISSING_BLOCK_LABEL_2008;
        }
        sqlitedatabase = Boolean.TRUE.toString();
_L28:
        jsonobject.put("out", sqlitedatabase);
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
          goto _L27
        sqlitedatabase = Boolean.FALSE.toString();
          goto _L28
        if (!FLOW_EVENT.equals(obj)) goto _L30; else goto _L29
_L29:
        jsonobject.put("dt", "f");
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        jsonobject.put("ss", Math.round((double)l3 / 1000D));
        context = String.format("%s = ? AND %s <= ?", new Object[] {
            "session_key_ref", "processed_in_blob"
        });
        s = Long.toString(l2);
        obj = Long.toString(l1);
        sqlitedatabase = sqlitedatabase.query("event_history", new String[] {
            "type", "processed_in_blob", "name"
        }, context, new String[] {
            s, obj
        }, null, null, "_id");
        s = new JSONArray();
        obj = new JSONArray();
_L35:
        if (!sqlitedatabase.moveToNext()) goto _L32; else goto _L31
_L31:
        s1 = sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow("name"));
        if (sqlitedatabase.getInt(sqlitedatabase.getColumnIndexOrThrow("type")) == 0)
        {
            context = "e";
        } else
        {
            context = "s";
        }
        if (l1 != sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("processed_in_blob"))) goto _L34; else goto _L33
_L33:
        s.put((new JSONObject()).put(context, s1));
          goto _L35
        s;
        context = sqlitedatabase;
        sqlitedatabase = s;
_L48:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_2292;
        }
        context.close();
        throw sqlitedatabase;
_L34:
        ((JSONArray) (obj)).put((new JSONObject()).put(context, s1));
          goto _L35
_L32:
        jsonobject.put("nw", s);
        jsonobject.put("od", obj);
        if (sqlitedatabase == null) goto _L27; else goto _L36
_L36:
        sqlitedatabase.close();
          goto _L27
_L30:
        jsonobject.put("dt", "e");
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        jsonobject.put("su", s1);
        jsonobject.put("n", ((String) (obj)).substring(context.getPackageName().length() + 1, ((String) (obj)).length()));
        l1 = cursor.getLong(cursor.getColumnIndex("clv_increase"));
        if (l1 == 0L)
        {
            break MISSING_BLOCK_LABEL_2502;
        }
        jsonobject.put("v", l1);
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")) || cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_2616;
        }
        d = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        d1 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d == 0.0D || d1 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_2616;
        }
        jsonobject.put("lat", d);
        jsonobject.put("lng", d1);
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            s = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
            obj = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
            jsonobject.put("cid", s);
            jsonobject.put("utp", obj);
        }
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        }
        s = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        i = s.getColumnIndexOrThrow("attribute_key");
        j = s.getColumnIndexOrThrow("attribute_value");
_L41:
        if (!s.moveToNext()) goto _L38; else goto _L37
_L37:
        obj = s.getString(i);
        s1 = s.getString(j);
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(obj)) goto _L40; else goto _L39
_L39:
        jsonobject.put(getCustomDimensionKey(1), s1);
          goto _L41
        sqlitedatabase;
_L47:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_2877;
        }
        s.close();
        throw sqlitedatabase;
_L40:
label14:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(obj))
            {
                break label14;
            }
            jsonobject.put(getCustomDimensionKey(2), s1);
        }
          goto _L41
label15:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(obj))
            {
                break label15;
            }
            jsonobject.put(getCustomDimensionKey(3), s1);
        }
          goto _L41
label16:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(obj))
            {
                break label16;
            }
            jsonobject.put(getCustomDimensionKey(4), s1);
        }
          goto _L41
label17:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(obj))
            {
                break label17;
            }
            jsonobject.put(getCustomDimensionKey(5), s1);
        }
          goto _L41
label18:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(obj))
            {
                break label18;
            }
            jsonobject.put(getCustomDimensionKey(6), s1);
        }
          goto _L41
label19:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(obj))
            {
                break label19;
            }
            jsonobject.put(getCustomDimensionKey(7), s1);
        }
          goto _L41
label20:
        {
            if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(obj))
            {
                break label20;
            }
            jsonobject.put(getCustomDimensionKey(8), s1);
        }
          goto _L41
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(obj)) goto _L43; else goto _L42
_L42:
        jsonobject.put(getCustomDimensionKey(9), s1);
          goto _L41
_L43:
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(obj)) goto _L41; else goto _L44
_L44:
        jsonobject.put(getCustomDimensionKey(10), s1);
          goto _L41
_L38:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_3130;
        }
        s.close();
        sqlitedatabase = convertAttributesToJson(sqlitedatabase, context, l);
        if (sqlitedatabase == null) goto _L27; else goto _L45
_L45:
        jsonobject.put("attrs", sqlitedatabase);
          goto _L27
_L2:
        throw new RuntimeException();
        sqlitedatabase;
        context = null;
          goto _L46
        sqlitedatabase;
        s = null;
          goto _L47
        sqlitedatabase;
        context = null;
          goto _L48
        sqlitedatabase;
        context = null;
          goto _L49
        sqlitedatabase;
        context = null;
          goto _L50
        sqlitedatabase;
        context = null;
          goto _L51
        sqlitedatabase;
        context = null;
          goto _L52
    }

    private static long getApiKeyCreationTime(SQLiteDatabase sqlitedatabase, String s)
    {
        s = sqlitedatabase.query("api_keys", null, String.format("%s = ?", new Object[] {
            "api_key"
        }), new String[] {
            s
        }, null, null, null);
        int i;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        i = Math.round((float)s.getLong(s.getColumnIndexOrThrow("created_time")) / 1000F);
        long l = i;
        if (s != null)
        {
            s.close();
        }
        return l;
        throw new RuntimeException("API key entry couldn't be found");
        sqlitedatabase;
_L2:
        if (s != null)
        {
            s.close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static JSONObject getAttributesFromSession(SQLiteDatabase sqlitedatabase, String s, long l)
    {
        Object obj = null;
        Cursor cursor = sqlitedatabase.query("sessions", null, String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("av", cursor.getString(cursor.getColumnIndexOrThrow("app_version")));
        jsonobject.put("dac", cursor.getString(cursor.getColumnIndexOrThrow("network_type")));
        obj = cursor.getString(cursor.getColumnIndexOrThrow("device_android_id_hash"));
        if (!"".equals(obj))
        {
            jsonobject.put("du", obj);
        }
        jsonobject.put("dc", cursor.getString(cursor.getColumnIndexOrThrow("device_country")));
        jsonobject.put("dma", cursor.getString(cursor.getColumnIndexOrThrow("device_manufacturer")));
        jsonobject.put("dmo", cursor.getString(cursor.getColumnIndexOrThrow("device_model")));
        jsonobject.put("dov", cursor.getString(cursor.getColumnIndexOrThrow("android_version")));
        jsonobject.put("dp", "Android");
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("device_serial_number_hash"))) goto _L4; else goto _L3
_L3:
        obj = JSONObject.NULL;
_L14:
        jsonobject.put("dms", obj);
        jsonobject.put("dsdk", cursor.getString(cursor.getColumnIndexOrThrow("android_sdk")));
        jsonobject.put("au", s);
        jsonobject.put("lv", cursor.getString(cursor.getColumnIndexOrThrow("localytics_library_version")));
        jsonobject.put("dt", "a");
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("device_android_id"))) goto _L6; else goto _L5
_L5:
        s = ((String) (JSONObject.NULL));
_L9:
        jsonobject.put("caid", s);
        if (!cursor.isNull(cursor.getColumnIndexOrThrow("device_advertising_id"))) goto _L8; else goto _L7
_L7:
        s = ((String) (JSONObject.NULL));
_L10:
        jsonobject.put("gcadid", s);
        s = cursor.getString(cursor.getColumnIndexOrThrow("iu"));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        jsonobject.put("iu", s);
        jsonobject.put("dlc", cursor.getString(cursor.getColumnIndexOrThrow("locale_country")));
        jsonobject.put("dll", cursor.getString(cursor.getColumnIndexOrThrow("locale_language")));
        jsonobject.put("nca", cursor.getString(cursor.getColumnIndexOrThrow("network_carrier")));
        jsonobject.put("nc", cursor.getString(cursor.getColumnIndexOrThrow("network_country")));
        s = getStringFromAppInfo(sqlitedatabase, "fb_attribution");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_605;
        }
        jsonobject.put("fbat", s);
        s = getStringFromAppInfo(sqlitedatabase, "play_attribution");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_627;
        }
        jsonobject.put("aurl", s);
        s = getStringFromAppInfo(sqlitedatabase, "registration_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_649;
        }
        jsonobject.put("push", s);
        s = getStringFromAppInfo(sqlitedatabase, "first_android_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_671;
        }
        jsonobject.put("aid", s);
        s = getStringFromAppInfo(sqlitedatabase, "first_advertising_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_693;
        }
        jsonobject.put("gadid", s);
        sqlitedatabase = getStringFromAppInfo(sqlitedatabase, "package_name");
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_715;
        }
        jsonobject.put("pkg", sqlitedatabase);
        if (cursor != null)
        {
            cursor.close();
        }
        return jsonobject;
_L4:
        obj = cursor.getString(cursor.getColumnIndexOrThrow("device_serial_number_hash"));
        continue; /* Loop/switch isn't completed */
_L6:
        s = cursor.getString(cursor.getColumnIndexOrThrow("device_android_id"));
          goto _L9
_L8:
        s = cursor.getString(cursor.getColumnIndexOrThrow("device_advertising_id"));
          goto _L10
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
          goto _L9
        sqlitedatabase;
        s = ((String) (obj));
_L12:
        if (s != null)
        {
            s.close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        s = cursor;
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L14; else goto _L13
_L13:
    }

    private static String getCustomDimensionKey(int i)
    {
        return String.format("%s%s", new Object[] {
            "c", String.valueOf(i - 1)
        });
    }

    private static long getElapsedTimeSinceLastSession(SQLiteDatabase sqlitedatabase, long l)
    {
        Object obj;
        obj = String.format("%s = ?", new Object[] {
            "_id"
        });
        String s = Long.toString(l);
        obj = sqlitedatabase.query("sessions", new String[] {
            "elapsed"
        }, ((String) (obj)), new String[] {
            s
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("elapsed"));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return l;
        throw new RuntimeException();
        sqlitedatabase;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static JSONObject getIdentifiers(SQLiteDatabase sqlitedatabase)
    {
        Object obj = null;
        sqlitedatabase = sqlitedatabase.query("identifiers", null, null, null, null, null, null);
_L3:
        if (!sqlitedatabase.moveToNext()) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put(sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow("key")), sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow("value")));
        obj = obj1;
          goto _L3
        Exception exception;
        exception;
        obj = sqlitedatabase;
        sqlitedatabase = exception;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L2:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return ((JSONObject) (obj));
        sqlitedatabase;
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static long getSessionIdForBlobId(SQLiteDatabase sqlitedatabase, long l)
    {
        Object obj1 = null;
        Object obj;
        obj = String.format("%s = ?", new Object[] {
            "upload_blobs_key_ref"
        });
        String s = Long.toString(l);
        obj = sqlitedatabase.query("upload_blob_events", new String[] {
            "events_key_ref"
        }, ((String) (obj)), new String[] {
            s
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst()) goto _L2; else goto _L1
_L1:
        l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("events_key_ref"));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj = obj1;
        String s1 = String.format("%s = ?", new Object[] {
            "_id"
        });
        obj = obj1;
        String s2 = Long.toString(l);
        obj = obj1;
        sqlitedatabase = sqlitedatabase.query("events", new String[] {
            "session_key_ref"
        }, s1, new String[] {
            s2
        }, null, null, null);
        obj = sqlitedatabase;
        if (!sqlitedatabase.moveToFirst()) goto _L4; else goto _L3
_L3:
        obj = sqlitedatabase;
        l = sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("session_key_ref"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return l;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return -1L;
        sqlitedatabase;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L4:
        obj = sqlitedatabase;
        throw new RuntimeException("No session associated with event");
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static long getSessionIdForEventId(SQLiteDatabase sqlitedatabase, long l)
    {
        Object obj;
        obj = String.format("%s = ?", new Object[] {
            "_id"
        });
        String s = Long.toString(l);
        obj = sqlitedatabase.query("events", new String[] {
            "session_key_ref"
        }, ((String) (obj)), new String[] {
            s
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("session_key_ref"));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return l;
        throw new RuntimeException();
        sqlitedatabase;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static long getSessionStartTime(SQLiteDatabase sqlitedatabase, long l)
    {
        Object obj;
        obj = String.format("%s = ?", new Object[] {
            "_id"
        });
        String s = Long.toString(l);
        obj = sqlitedatabase.query("sessions", new String[] {
            "session_start_wall_time"
        }, ((String) (obj)), new String[] {
            s
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("session_start_wall_time"));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return l;
        throw new RuntimeException();
        sqlitedatabase;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String getSessionUuid(SQLiteDatabase sqlitedatabase, long l)
    {
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        String s1 = Long.toString(l);
        sqlitedatabase = sqlitedatabase.query("sessions", new String[] {
            "uuid"
        }, s, new String[] {
            s1
        }, null, null, null);
        Object obj;
        if (!sqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow("uuid"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return ((String) (obj));
        throw new RuntimeException();
        Exception exception;
        exception;
        obj = sqlitedatabase;
        sqlitedatabase = exception;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String getStringFromAppInfo(SQLiteDatabase sqlitedatabase, String s)
    {
        Object obj = null;
        sqlitedatabase = sqlitedatabase.query("info", null, null, null, null, null, null);
        if (!sqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        s = sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow(s));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return s;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return null;
        sqlitedatabase;
        s = obj;
_L2:
        if (s != null)
        {
            s.close();
        }
        throw sqlitedatabase;
        Exception exception;
        exception;
        s = sqlitedatabase;
        sqlitedatabase = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void preUploadBuildBlobs(SQLiteDatabase sqlitedatabase)
    {
        Object obj1;
        HashSet hashset;
        obj1 = null;
        hashset = new HashSet();
        Object obj = sqlitedatabase.query("events", PROJECTION_UPLOAD_EVENTS, null, null, null, null, EVENTS_SORT_ORDER);
        Cursor cursor = sqlitedatabase.query("upload_blob_events", PROJECTION_UPLOAD_BLOBS, null, null, null, null, UPLOAD_BLOBS_EVENTS_SORT_ORDER);
        int i;
        i = ((Cursor) (obj)).getColumnIndexOrThrow("_id");
        obj1 = (new CursorJoiner(((Cursor) (obj)), JOINER_ARG_UPLOAD_EVENTS_COLUMNS, cursor, PROJECTION_UPLOAD_BLOBS)).iterator();
_L4:
        android.database.CursorJoiner.Result result;
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        result = (android.database.CursorJoiner.Result)((Iterator) (obj1)).next();
        _cls1..SwitchMap.android.database.CursorJoiner.Result[result.ordinal()];
        JVM INSTR tableswitch 1 1: default 389
    //                   1 124;
           goto _L1 _L2
_L1:
        continue; /* Loop/switch isn't completed */
_L2:
        if (!CLOSE_EVENT.equals(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("event_name"))) || System.currentTimeMillis() - ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("wall_time")) >= Constants.SESSION_EXPIRATION)
        {
            hashset.add(Long.valueOf(((Cursor) (obj)).getLong(i)));
        }
        if (true) goto _L4; else goto _L3
        sqlitedatabase;
        obj1 = obj;
        obj = cursor;
_L6:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (cursor != null)
        {
            cursor.close();
        }
        if (hashset.size() > 0)
        {
            obj = new ContentValues();
            ((ContentValues) (obj)).put("uuid", UUID.randomUUID().toString());
            obj1 = Long.valueOf(sqlitedatabase.insert("upload_blobs", null, ((ContentValues) (obj))));
            ((ContentValues) (obj)).clear();
            for (Iterator iterator = hashset.iterator(); iterator.hasNext(); ((ContentValues) (obj)).clear())
            {
                Long long1 = (Long)iterator.next();
                ((ContentValues) (obj)).put("upload_blobs_key_ref", ((Long) (obj1)));
                ((ContentValues) (obj)).put("events_key_ref", long1);
                sqlitedatabase.insert("upload_blob_events", null, ((ContentValues) (obj)));
            }

            ((ContentValues) (obj)).put("processed_in_blob", ((Long) (obj1)));
            sqlitedatabase.update("event_history", ((ContentValues) (obj)), SELECTION_UPLOAD_NULL_BLOBS, null);
            ((ContentValues) (obj)).clear();
        }
        return;
        sqlitedatabase;
        obj = null;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase;
        Object obj2 = null;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            throw new IllegalArgumentException("db cannot be null");
        } else
        {
            return;
        }
    }

    public final void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        Localytics.Log.v(String.format("SQLite library version is: %s", new Object[] {
            DatabaseUtils.stringForQuery(sqlitedatabase, "select sqlite_version()", null)
        }));
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i < 3)
        {
            sqlitedatabase.delete("upload_blob_events", null, null);
            sqlitedatabase.delete("event_history", null, null);
            sqlitedatabase.delete("upload_blobs", null, null);
            sqlitedatabase.delete("attributes", null, null);
            sqlitedatabase.delete("events", null, null);
            sqlitedatabase.delete("sessions", null, null);
        }
        if (i < 4)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "iu"
            }));
        }
        if (i < 5)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_wifi_mac_hash"
            }));
        }
        if (i >= 6) goto _L2; else goto _L1
_L1:
        Object obj = sqlitedatabase.query("attributes", new String[] {
            "_id", "attribute_key"
        }, null, null, null, null, null);
        j = ((Cursor) (obj)).getColumnIndexOrThrow("_id");
        int k = ((Cursor) (obj)).getColumnIndexOrThrow("attribute_key");
        ContentValues contentvalues = new ContentValues();
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        String as[] = new String[1];
        ((Cursor) (obj)).moveToPosition(-1);
        for (; ((Cursor) (obj)).moveToNext(); contentvalues.clear())
        {
            contentvalues.put("attribute_key", String.format("%s:%s", new Object[] {
                mLocalyticsDao.getAppContext().getPackageName(), ((Cursor) (obj)).getString(k)
            }));
            as[0] = Long.toString(((Cursor) (obj)).getLong(j));
            sqlitedatabase.update("attributes", contentvalues, s, as);
        }

          goto _L3
        sqlitedatabase;
_L12:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L2:
        if (i < 7)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER);", new Object[] {
                "info", "fb_attribution", "first_run"
            }));
            obj = new ContentValues();
            ((ContentValues) (obj)).putNull("fb_attribution");
            ((ContentValues) (obj)).put("first_run", Boolean.FALSE);
            sqlitedatabase.insertOrThrow("info", null, ((ContentValues) (obj)));
        }
        if (i < 8)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);", new Object[] {
                "identifiers", "_id", "key", "value"
            }));
        }
        if (i < 9)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL DEFAULT 0;", new Object[] {
                "events", "clv_increase"
            }));
        }
        if (i < 10)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "play_attribution"
            }));
        }
        if (i < 11)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "registration_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "registration_version"
            }));
        }
        if (i < 12)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_android_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_telephony_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "package_name"
            }));
            obj = new ContentValues();
            ((ContentValues) (obj)).put("first_android_id", DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext()));
            ((ContentValues) (obj)).put("first_telephony_id", DatapointHelper.getTelephonyDeviceIdOrNull(mLocalyticsDao.getAppContext()));
            ((ContentValues) (obj)).put("package_name", mLocalyticsDao.getAppContext().getPackageName());
            sqlitedatabase.update("info", ((ContentValues) (obj)), null, null);
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_android_id"
            }));
        }
        if (i < 13)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s REAL;", new Object[] {
                "events", "event_lat"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s REAL;", new Object[] {
                "events", "event_lng"
            }));
        }
        if (i < 14)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
                "amp_rules", "_id", "campaign_id", "expiration", "display_seconds", "display_session", "version", "phone_location", "phone_size_width", "phone_size_height", 
                "tablet_location", "tablet_size_width", "tablet_size_height", "time_to_display", "internet_required", "ab_test", "rule_name", "location", "devices"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_ruleevent", "_id", "event_name", "rule_id_ref", "amp_rules", "_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL);", new Object[] {
                "amp_displayed", "_id", "displayed", "campaign_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_conditions", "_id", "attribute_name", "operator", "rule_id_ref", "amp_rules", "_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_condition_values", "_id", "value", "condition_id_ref", "amp_conditions", "_id"
            }));
        }
        if (i < 15)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);", new Object[] {
                "custom_dimensions", "_id", "custom_dimension_key", "custom_dimension_value"
            }));
        }
        if (i < 16)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_advertising_id"
            }));
            ContentValues contentvalues1 = new ContentValues();
            obj = DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext());
            String s1;
            JSONObject jsonobject;
            Exception exception;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((DatapointHelper.AdvertisingInfo) (obj)).id;
            }
            contentvalues1.put("first_advertising_id", ((String) (obj)));
            sqlitedatabase.update("info", contentvalues1, null, null);
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_advertising_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER;", new Object[] {
                "info", "push_disabled"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "sender_id"
            }));
        }
        if (i < 17)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER)", new Object[] {
                "profile", "_id", "attribute", "action"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "customer_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "user_type"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "ids"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER", new Object[] {
                "info", "last_session_open_time"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL CHECK (%s >= 0) DEFAULT 0", new Object[] {
                "sessions", "elapsed", "elapsed"
            }));
        }
        if (i >= 18) goto _L5; else goto _L4
_L4:
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", new Object[] {
            "profile", "customer_id"
        }));
        contentvalues1 = new ContentValues();
        obj = sqlitedatabase.query("profile", null, null, null, null, null, null);
_L8:
        if (!((Cursor) (obj)).moveToNext()) goto _L7; else goto _L6
_L6:
        s1 = String.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id")));
        jsonobject = new JSONObject(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("attribute")));
        contentvalues1.put("attribute", jsonobject.getString("attributes"));
        contentvalues1.put("customer_id", jsonobject.getString("id"));
        sqlitedatabase.update("profile", contentvalues1, String.format("%s = %s", new Object[] {
            "_id", s1
        }), null);
        contentvalues1.clear();
          goto _L8
        exception;
        sqlitedatabase.delete("profile", String.format("%s = %s", new Object[] {
            "_id", s1
        }), null);
          goto _L8
        sqlitedatabase;
_L10:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L7:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L5:
        return;
        sqlitedatabase;
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
        sqlitedatabase;
        obj = null;
        if (true) goto _L12; else goto _L11
_L11:
    }


    private class AttributesDbColumns
        implements BaseColumns
    {

        static final String ATTRIBUTE_CUSTOM_DIMENSION_1 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_0"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_10 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_9"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_2 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_1"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_3 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_2"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_4 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_3"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_5 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_4"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_6 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_5"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_7 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_6"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_8 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_7"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_9 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_8"
        });
        static final String ATTRIBUTE_FORMAT = "%s:%s";
        static final String ATTRIBUTE_KEY = "attribute_key";
        static final String ATTRIBUTE_VALUE = "attribute_value";
        static final String EVENTS_KEY_REF = "events_key_ref";
        static final String TABLE_NAME = "attributes";


        private AttributesDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$android$database$CursorJoiner$Result[];

        static 
        {
            $SwitchMap$android$database$CursorJoiner$Result = new int[android.database.CursorJoiner.Result.values().length];
            try
            {
                $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.LEFT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.BOTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.RIGHT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
