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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            AccessTokenSource, LoggingBehavior

final class LegacyTokenHelper
{

    private static final String TAG = com/facebook/LegacyTokenHelper.getSimpleName();
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
        obj = new JSONObject(cache.getString(s, "{}"));
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

}
