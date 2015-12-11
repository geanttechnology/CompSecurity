// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            AccessTokenSource, LoggingBehavior

final class LegacyTokenHelper
{

    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = 0x8000000000000000L;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = com/facebook/LegacyTokenHelper.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context)
    {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String s)
    {
        Validate.notNull(context, "context");
        String s1 = s;
        if (Utility.isNullOrEmpty(s))
        {
            s1 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        cacheKey = s1;
        s = context.getApplicationContext();
        if (s != null)
        {
            context = s;
        }
        cache = context.getSharedPreferences(cacheKey, 0);
    }

    private void deserializeKey(String s, Bundle bundle)
        throws JSONException
    {
        Object obj;
        Object obj1;
        obj = JSONObjectInstrumentation.init(cache.getString(s, "{}"));
        obj1 = ((JSONObject) (obj)).getString("valueType");
        if (!((String) (obj1)).equals("bool")) goto _L2; else goto _L1
_L1:
        bundle.putBoolean(s, ((JSONObject) (obj)).getBoolean("value"));
_L4:
        return;
_L2:
        if (((String) (obj1)).equals("bool[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new boolean[((JSONArray) (obj)).length()];
            for (int i = 0; i < obj1.length; i++)
            {
                obj1[i] = ((JSONArray) (obj)).getBoolean(i);
            }

            bundle.putBooleanArray(s, ((boolean []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("byte"))
        {
            bundle.putByte(s, (byte)((JSONObject) (obj)).getInt("value"));
            return;
        }
        if (((String) (obj1)).equals("byte[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new byte[((JSONArray) (obj)).length()];
            for (int j = 0; j < obj1.length; j++)
            {
                obj1[j] = (byte)((JSONArray) (obj)).getInt(j);
            }

            bundle.putByteArray(s, ((byte []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("short"))
        {
            bundle.putShort(s, (short)((JSONObject) (obj)).getInt("value"));
            return;
        }
        if (((String) (obj1)).equals("short[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new short[((JSONArray) (obj)).length()];
            for (int k = 0; k < obj1.length; k++)
            {
                obj1[k] = (short)((JSONArray) (obj)).getInt(k);
            }

            bundle.putShortArray(s, ((short []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("int"))
        {
            bundle.putInt(s, ((JSONObject) (obj)).getInt("value"));
            return;
        }
        if (((String) (obj1)).equals("int[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new int[((JSONArray) (obj)).length()];
            for (int l = 0; l < obj1.length; l++)
            {
                obj1[l] = ((JSONArray) (obj)).getInt(l);
            }

            bundle.putIntArray(s, ((int []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("long"))
        {
            bundle.putLong(s, ((JSONObject) (obj)).getLong("value"));
            return;
        }
        if (((String) (obj1)).equals("long[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new long[((JSONArray) (obj)).length()];
            for (int i1 = 0; i1 < obj1.length; i1++)
            {
                obj1[i1] = ((JSONArray) (obj)).getLong(i1);
            }

            bundle.putLongArray(s, ((long []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("float"))
        {
            bundle.putFloat(s, (float)((JSONObject) (obj)).getDouble("value"));
            return;
        }
        if (((String) (obj1)).equals("float[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new float[((JSONArray) (obj)).length()];
            for (int j1 = 0; j1 < obj1.length; j1++)
            {
                obj1[j1] = (float)((JSONArray) (obj)).getDouble(j1);
            }

            bundle.putFloatArray(s, ((float []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("double"))
        {
            bundle.putDouble(s, ((JSONObject) (obj)).getDouble("value"));
            return;
        }
        if (((String) (obj1)).equals("double[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new double[((JSONArray) (obj)).length()];
            for (int k1 = 0; k1 < obj1.length; k1++)
            {
                obj1[k1] = ((JSONArray) (obj)).getDouble(k1);
            }

            bundle.putDoubleArray(s, ((double []) (obj1)));
            return;
        }
        if (!((String) (obj1)).equals("char"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((JSONObject) (obj)).getString("value");
        if (obj != null && ((String) (obj)).length() == 1)
        {
            bundle.putChar(s, ((String) (obj)).charAt(0));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (((String) (obj1)).equals("char[]"))
        {
            obj = ((JSONObject) (obj)).getJSONArray("value");
            obj1 = new char[((JSONArray) (obj)).length()];
            for (int l1 = 0; l1 < obj1.length; l1++)
            {
                String s1 = ((JSONArray) (obj)).getString(l1);
                if (s1 != null && s1.length() == 1)
                {
                    obj1[l1] = s1.charAt(0);
                }
            }

            bundle.putCharArray(s, ((char []) (obj1)));
            return;
        }
        if (((String) (obj1)).equals("string"))
        {
            bundle.putString(s, ((JSONObject) (obj)).getString("value"));
            return;
        }
        if (((String) (obj1)).equals("stringList"))
        {
            obj1 = ((JSONObject) (obj)).getJSONArray("value");
            int j2 = ((JSONArray) (obj1)).length();
            ArrayList arraylist = new ArrayList(j2);
            int i2 = 0;
            while (i2 < j2) 
            {
                obj = ((JSONArray) (obj1)).get(i2);
                if (obj == JSONObject.NULL)
                {
                    obj = null;
                } else
                {
                    obj = (String)obj;
                }
                arraylist.add(i2, obj);
                i2++;
            }
            bundle.putStringArrayList(s, arraylist);
            return;
        }
        if (((String) (obj1)).equals("enum"))
        {
            try
            {
                bundle.putSerializable(s, Enum.valueOf(Class.forName(((JSONObject) (obj)).getString("enumType")), ((JSONObject) (obj)).getString("value")));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static String getApplicationId(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    static Date getDate(Bundle bundle, String s)
    {
        long l;
        if (bundle != null)
        {
            if ((l = bundle.getLong(s, 0x8000000000000000L)) != 0x8000000000000000L)
            {
                return new Date(l);
            }
        }
        return null;
    }

    public static Date getExpirationDate(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static long getExpirationMilliseconds(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static Date getLastRefreshDate(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static long getLastRefreshMilliseconds(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static Set getPermissions(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        bundle = bundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
        if (bundle == null)
        {
            return null;
        } else
        {
            return new HashSet(bundle);
        }
    }

    public static AccessTokenSource getSource(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource"))
        {
            return (AccessTokenSource)bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        if (bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO"))
        {
            return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
        } else
        {
            return AccessTokenSource.WEB_VIEW;
        }
    }

    public static String getToken(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static boolean hasTokenInformation(Bundle bundle)
    {
        String s;
        if (bundle != null)
        {
            if ((s = bundle.getString("com.facebook.TokenCachingStrategy.Token")) != null && s.length() != 0 && bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) != 0L)
            {
                return true;
            }
        }
        return false;
    }

    public static void putApplicationId(Bundle bundle, String s)
    {
        Validate.notNull(bundle, "bundle");
        bundle.putString("com.facebook.TokenCachingStrategy.ApplicationId", s);
    }

    static void putDate(Bundle bundle, String s, Date date)
    {
        bundle.putLong(s, date.getTime());
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection collection)
    {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(collection));
    }

    public static void putExpirationDate(Bundle bundle, Date date)
    {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", date);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long l)
    {
        Validate.notNull(bundle, "bundle");
        bundle.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", l);
    }

    public static void putLastRefreshDate(Bundle bundle, Date date)
    {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", date);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long l)
    {
        Validate.notNull(bundle, "bundle");
        bundle.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", l);
    }

    public static void putPermissions(Bundle bundle, Collection collection)
    {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(collection));
    }

    public static void putSource(Bundle bundle, AccessTokenSource accesstokensource)
    {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", accesstokensource);
    }

    public static void putToken(Bundle bundle, String s)
    {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(s, "value");
        bundle.putString("com.facebook.TokenCachingStrategy.Token", s);
    }

    private void serializeKey(String s, Bundle bundle, android.content.SharedPreferences.Editor editor)
        throws JSONException
    {
        Object obj1;
        int i;
        int j;
        int k;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        j = 0;
        k = 0;
        flag = false;
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        i = 0;
        obj1 = bundle.get(s);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        JSONObject jsonobject;
        bundle = null;
        obj = null;
        jsonobject = new JSONObject();
        if (!(obj1 instanceof Byte)) goto _L4; else goto _L3
_L3:
        bundle = "byte";
        jsonobject.put("value", ((Byte)obj1).intValue());
_L5:
        if (bundle != null)
        {
            jsonobject.put("valueType", bundle);
            if (obj != null)
            {
                jsonobject.putOpt("value", obj);
            }
            JSONArray jsonarray;
            String s1;
            if (!(jsonobject instanceof JSONObject))
            {
                bundle = jsonobject.toString();
            } else
            {
                bundle = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            editor.putString(s, bundle);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (obj1 instanceof Short)
        {
            bundle = "short";
            jsonobject.put("value", ((Short)obj1).intValue());
        } else
        if (obj1 instanceof Integer)
        {
            bundle = "int";
            jsonobject.put("value", ((Integer)obj1).intValue());
        } else
        if (obj1 instanceof Long)
        {
            bundle = "long";
            jsonobject.put("value", ((Long)obj1).longValue());
        } else
        if (obj1 instanceof Float)
        {
            bundle = "float";
            jsonobject.put("value", ((Float)obj1).doubleValue());
        } else
        if (obj1 instanceof Double)
        {
            bundle = "double";
            jsonobject.put("value", ((Double)obj1).doubleValue());
        } else
        if (obj1 instanceof Boolean)
        {
            bundle = "bool";
            jsonobject.put("value", ((Boolean)obj1).booleanValue());
        } else
        if (obj1 instanceof Character)
        {
            bundle = "char";
            jsonobject.put("value", obj1.toString());
        } else
        if (obj1 instanceof String)
        {
            bundle = "string";
            jsonobject.put("value", (String)obj1);
        } else
        {
label0:
            {
                if (!(obj1 instanceof Enum))
                {
                    break label0;
                }
                bundle = "enum";
                jsonobject.put("value", obj1.toString());
                jsonobject.put("enumType", obj1.getClass().getName());
            }
        }
          goto _L5
        jsonarray = new JSONArray();
        if (!(obj1 instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_477;
        }
        s1 = "byte[]";
        obj1 = (byte[])(byte[])obj1;
        j = obj1.length;
_L7:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L6
_L6:
        jsonarray.put(obj1[i]);
        i++;
          goto _L7
        if (!(obj1 instanceof short[]))
        {
            break MISSING_BLOCK_LABEL_542;
        }
        s1 = "short[]";
        obj1 = (short[])(short[])obj1;
        k = obj1.length;
        i = j;
_L9:
        obj = jsonarray;
        bundle = s1;
        if (i >= k) goto _L5; else goto _L8
_L8:
        jsonarray.put(obj1[i]);
        i++;
          goto _L9
        if (!(obj1 instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_607;
        }
        s1 = "int[]";
        obj1 = (int[])(int[])obj1;
        j = obj1.length;
        i = k;
_L11:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L10
_L10:
        jsonarray.put(obj1[i]);
        i++;
          goto _L11
        if (!(obj1 instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_672;
        }
        s1 = "long[]";
        obj1 = (long[])(long[])obj1;
        j = obj1.length;
        i = ((flag) ? 1 : 0);
_L13:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L12
_L12:
        jsonarray.put(obj1[i]);
        i++;
          goto _L13
        if (!(obj1 instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_738;
        }
        s1 = "float[]";
        obj1 = (float[])(float[])obj1;
        j = obj1.length;
        i = ((flag1) ? 1 : 0);
_L15:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L14
_L14:
        jsonarray.put(obj1[i]);
        i++;
          goto _L15
        if (!(obj1 instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_803;
        }
        s1 = "double[]";
        obj1 = (double[])(double[])obj1;
        j = obj1.length;
        i = ((flag2) ? 1 : 0);
_L17:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L16
_L16:
        jsonarray.put(obj1[i]);
        i++;
          goto _L17
        if (!(obj1 instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_868;
        }
        s1 = "bool[]";
        obj1 = (boolean[])(boolean[])obj1;
        j = obj1.length;
        i = ((flag3) ? 1 : 0);
_L19:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L18
_L18:
        jsonarray.put(obj1[i]);
        i++;
          goto _L19
        if (!(obj1 instanceof char[]))
        {
            break MISSING_BLOCK_LABEL_936;
        }
        s1 = "char[]";
        obj1 = (char[])(char[])obj1;
        j = obj1.length;
        i = ((flag4) ? 1 : 0);
_L21:
        obj = jsonarray;
        bundle = s1;
        if (i >= j) goto _L5; else goto _L20
_L20:
        jsonarray.put(String.valueOf(obj1[i]));
        i++;
          goto _L21
        if (!(obj1 instanceof List))
        {
            break MISSING_BLOCK_LABEL_1011;
        }
        s1 = "stringList";
        obj1 = ((List)obj1).iterator();
_L23:
        obj = jsonarray;
        bundle = s1;
        if (!((Iterator) (obj1)).hasNext()) goto _L5; else goto _L22
_L22:
        obj = (String)((Iterator) (obj1)).next();
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            bundle = ((Bundle) (JSONObject.NULL));
        }
        jsonarray.put(bundle);
          goto _L23
        obj = null;
          goto _L5
    }

    public void clear()
    {
        cache.edit().clear().apply();
    }

    public Bundle load()
    {
        Bundle bundle;
        Iterator iterator;
        bundle = new Bundle();
        iterator = cache.getAll().keySet().iterator();
_L2:
        Object obj;
        obj = bundle;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        deserializeKey(((String) (obj)), bundle);
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        Logger.log(LoggingBehavior.CACHE, 5, TAG, (new StringBuilder()).append("Error reading cached value for key: '").append(((String) (obj))).append("' -- ").append(jsonexception).toString());
        obj = null;
_L1:
        return ((Bundle) (obj));
    }

    public void save(Bundle bundle)
    {
        Validate.notNull(bundle, "bundle");
        android.content.SharedPreferences.Editor editor = cache.edit();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            try
            {
                serializeKey(s, bundle, editor);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, (new StringBuilder()).append("Error processing value for key: '").append(s).append("' -- ").append(bundle).toString());
                return;
            }
        } while (true);
        editor.apply();
    }

}
