// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            SingularSQLiteHelper, SingularLog, KeyNotFoundException

class KeyValueStore
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type BOOLEAN;
        public static final Type LONG;
        public static final Type STRING;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(net/singular/sdk/KeyValueStore$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            STRING = new Type("STRING", 0);
            LONG = new Type("LONG", 1);
            BOOLEAN = new Type("BOOLEAN", 2);
            $VALUES = (new Type[] {
                STRING, LONG, BOOLEAN
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String JSON_VALUE_KEY = "value";
    private static final String KEY_COLUMN = "key";
    private static final String KEY_VALUE_TABLE = "key_value_table";
    private static final String NAMESPACE_COLUMN = "namespace";
    private static final String ONLY_VALUE_COLUMN[] = {
        "value"
    };
    private static final String TYPE_COLUMN = "type";
    private static final String VALUE_COLUMN = "value";
    private final SingularLog log;
    private final String namespace;
    private final SingularSQLiteHelper singularSQLiteHelper;

    public KeyValueStore(SingularLog singularlog, SingularSQLiteHelper singularsqlitehelper, String s)
    {
        log = singularlog;
        namespace = s;
        singularSQLiteHelper = singularsqlitehelper;
    }

    private String encodeObject(Type type, Object obj)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        static class _cls1
        {

            static final int $SwitchMap$net$singular$sdk$KeyValueStore$Type[];

            static 
            {
                $SwitchMap$net$singular$sdk$KeyValueStore$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$net$singular$sdk$KeyValueStore$Type[Type.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$net$singular$sdk$KeyValueStore$Type[Type.LONG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$net$singular$sdk$KeyValueStore$Type[Type.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.net.singular.sdk.KeyValueStore.Type[type.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            jsonobject.put("value", (String)obj);
            if (!(jsonobject instanceof JSONObject))
            {
                return jsonobject.toString();
            } else
            {
                return JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }

        case 2: // '\002'
            jsonobject.put("value", (Long)obj);
            if (!(jsonobject instanceof JSONObject))
            {
                return jsonobject.toString();
            } else
            {
                return JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }

        case 3: // '\003'
            jsonobject.put("value", (Boolean)obj);
            break;
        }
        if (!(jsonobject instanceof JSONObject))
        {
            return jsonobject.toString();
        } else
        {
            return JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
    }

    private boolean exists(String s)
        throws SQLiteException
    {
        SQLiteDatabase sqlitedatabase = singularSQLiteHelper.getReadableDatabase();
        String as[] = ONLY_VALUE_COLUMN;
        String as1[] = new String[2];
        as1[0] = namespace;
        as1[1] = s;
        int i;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            s = sqlitedatabase.query("key_value_table", as, "namespace=? AND key=?", as1, null, null, null);
        } else
        {
            s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "key_value_table", as, "namespace=? AND key=?", as1, null, null, null);
        }
        i = s.getCount();
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.close();
        return flag;
        Exception exception;
        exception;
        s.close();
        throw exception;
    }

    private Object innerGet(String s, Type type)
    {
        Object obj;
        String as[];
        String as1[];
        int i;
        try
        {
            obj = singularSQLiteHelper.getReadableDatabase();
            as = ONLY_VALUE_COLUMN;
            as1 = new String[3];
            as1[0] = namespace;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.e("singular_sdk", "KeyValueStoreHelper get failed", s);
            return Boolean.valueOf(false);
        }
        as1[1] = s;
        as1[2] = type.toString();
        if (obj instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        type = ((SQLiteDatabase) (obj)).query("key_value_table", as, "namespace=? AND key=? AND type=?", as1, null, null, null);
_L1:
        i = type.getCount();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        type.close();
        return null;
        type = SQLiteInstrumentation.query((SQLiteDatabase)obj, "key_value_table", as, "namespace=? AND key=? AND type=?", as1, null, null, null);
          goto _L1
        type.moveToFirst();
        obj = type.getString(0);
        obj = JSONObjectInstrumentation.init(((String) (obj))).get("value");
        type.close();
        return obj;
        JSONException jsonexception;
        jsonexception;
        delete(s);
        type.close();
        return null;
        s;
        type.close();
        throw s;
    }

    private boolean innerPut(String s, Type type, Object obj)
    {
        ContentValues contentvalues;
        String s1;
        int i;
        long l;
        try
        {
            s1 = encodeObject(type, obj);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        obj = singularSQLiteHelper.getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("namespace", namespace);
        contentvalues.put("type", type.toString());
        contentvalues.put("key", s);
        contentvalues.put("value", s1);
        if (!exists(s)) goto _L2; else goto _L1
_L1:
        type = new String[2];
        type[0] = namespace;
        type[1] = s;
        if (obj instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        i = ((SQLiteDatabase) (obj)).update("key_value_table", contentvalues, "namespace=? AND key=?", type);
          goto _L5
_L4:
        try
        {
            i = SQLiteInstrumentation.update((SQLiteDatabase)obj, "key_value_table", contentvalues, "namespace=? AND key=?", type);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.e("singular_sdk", "KeyValueStoreHelper put failed", s);
            return false;
        }
          goto _L5
_L2:
        if (obj instanceof SQLiteDatabase) goto _L7; else goto _L6
_L6:
        l = ((SQLiteDatabase) (obj)).insert("key_value_table", null, contentvalues);
          goto _L8
_L7:
        l = SQLiteInstrumentation.insert((SQLiteDatabase)obj, "key_value_table", null, contentvalues);
          goto _L8
_L10:
        return false;
_L5:
        return i == 1;
_L8:
        if (l == -1L) goto _L10; else goto _L9
_L9:
        return true;
    }

    public static void onCreate(SQLiteDatabase sqlitedatabase, SingularLog singularlog)
    {
        singularlog.d("singular_sdk", String.format("KeyValueStoreHelper onCreate", new Object[0]));
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table key_value_table(namespace TEXT not null, type INTEGER, key TEXT not null, value TEXT not null);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table key_value_table(namespace TEXT not null, type INTEGER, key TEXT not null, value TEXT not null);");
            return;
        }
    }

    public static void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j, SingularLog singularlog)
    {
        singularlog.d("singular_sdk", String.format("KeyValueStoreHelper onUpgrade", new Object[0]));
        if (i != j)
        {
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS key_value_table;");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS key_value_table;");
            }
            onCreate(sqlitedatabase, singularlog);
        }
    }

    public void delete(String s)
    {
        SQLiteDatabase sqlitedatabase;
        String as[];
        try
        {
            sqlitedatabase = singularSQLiteHelper.getWritableDatabase();
            as = new String[2];
            as[0] = namespace;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        as[1] = s;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.delete("key_value_table", "namespace=? AND key=?", as);
            return;
        }
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "key_value_table", "namespace=? AND key=?", as);
        return;
    }

    public boolean getBoolean(String s)
        throws KeyNotFoundException
    {
        s = (Boolean)innerGet(s, Type.BOOLEAN);
        if (s == null)
        {
            throw new KeyNotFoundException();
        } else
        {
            return s.booleanValue();
        }
    }

    public long getLong(String s)
        throws KeyNotFoundException
    {
        s = ((String) (innerGet(s, Type.LONG)));
        if (s == null)
        {
            throw new KeyNotFoundException();
        }
        if (s instanceof Long)
        {
            return ((Long)s).longValue();
        }
        if (s instanceof Integer)
        {
            return (long)((Integer)s).intValue();
        } else
        {
            throw new RuntimeException("shouldn't happen");
        }
    }

    public String getString(String s)
        throws KeyNotFoundException
    {
        s = (String)innerGet(s, Type.STRING);
        if (s == null)
        {
            throw new KeyNotFoundException();
        } else
        {
            return s;
        }
    }

    public boolean put(String s, long l)
    {
        return innerPut(s, Type.LONG, Long.valueOf(l));
    }

    public boolean put(String s, String s1)
    {
        return innerPut(s, Type.STRING, s1);
    }

    public boolean put(String s, boolean flag)
    {
        return innerPut(s, Type.BOOLEAN, Boolean.valueOf(flag));
    }

}
