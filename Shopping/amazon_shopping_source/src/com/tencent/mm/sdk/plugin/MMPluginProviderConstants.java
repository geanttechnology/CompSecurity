// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginProviderConstants
{
    public static final class Resolver
    {

        public static int getType(Object obj)
        {
            if (obj == null)
            {
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                return 0;
            }
            if (obj instanceof Integer)
            {
                return 1;
            }
            if (obj instanceof Long)
            {
                return 2;
            }
            if (obj instanceof String)
            {
                return 3;
            }
            if (obj instanceof Boolean)
            {
                return 4;
            }
            if (obj instanceof Float)
            {
                return 5;
            }
            if (obj instanceof Double)
            {
                return 6;
            } else
            {
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", (new StringBuilder()).append("unresolve failed, unknown type=").append(obj.getClass().toString()).toString());
                return 0;
            }
        }

        public static Object resolveObj(int i, String s)
        {
            String s1 = s;
            i;
            JVM INSTR tableswitch 1 6: default 40
        //                       1 50
        //                       2 55
        //                       3 84
        //                       4 60
        //                       5 65
        //                       6 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
            return Integer.valueOf(s);
_L3:
            return Long.valueOf(s);
_L5:
            return Boolean.valueOf(s);
_L6:
            return Float.valueOf(s);
_L7:
            s = Double.valueOf(s);
            return s;
_L1:
            try
            {
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            s1 = null;
_L4:
            return s1;
        }

        public static boolean unresolveObj(ContentValues contentvalues, Object obj)
        {
            int i = getType(obj);
            if (i == 0)
            {
                return false;
            } else
            {
                contentvalues.put("type", Integer.valueOf(i));
                contentvalues.put("value", obj.toString());
                return true;
            }
        }

        private Resolver()
        {
        }
    }

    public static final class SharedPref
        implements BaseColumns
    {

        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");


        private SharedPref()
        {
        }
    }


    public MMPluginProviderConstants()
    {
    }
}
