// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Context;
import com.facebook.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.b:
//            t, o, c

public final class b
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/facebook/b/b$a, s1);
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

        private a(String s1, int i)
        {
            super(s1, i);
        }
    }


    private static final Map a = new HashMap() {

            
            {
                put(a.a, "MOBILE_APP_INSTALL");
                put(a.b, "CUSTOM_APP_EVENTS");
            }
    };

    public static JSONObject a(a a1, c c, String s1, boolean flag, Context context)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("event", a.get(a1));
        t.a(jsonobject, c, s1, flag);
        try
        {
            t.a(jsonobject, context);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            o.a(s.e, "AppEvents", "Fetching extended device info parameters failed: '%s'", new Object[] {
                a1.toString()
            });
        }
        jsonobject.put("application_package_name", context.getPackageName());
        return jsonobject;
    }

}
