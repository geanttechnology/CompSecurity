// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import com.facebook.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.internal:
//            o, j, b

public class com.facebook.internal.a
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/internal/a$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("MOBILE_INSTALL_EVENT", 0);
            b = new a("CUSTOM_APP_EVENTS", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map a = new HashMap() {

            
            {
                put(a.a, "MOBILE_APP_INSTALL");
                put(a.b, "CUSTOM_APP_EVENTS");
            }
    };

    public static JSONObject a(a a1, b b, String s, boolean flag, Context context)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("event", a.get(a1));
        o.a(jsonobject, b, s, flag);
        try
        {
            o.a(jsonobject, context);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            j.a(q.e, "AppEvents", "Fetching extended device info parameters failed: '%s'", new Object[] {
                a1.toString()
            });
        }
        jsonobject.put("application_package_name", context.getPackageName());
        return jsonobject;
    }

}
