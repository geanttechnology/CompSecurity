// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.parse.ParseUser;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            gi, jg

public class hk
    implements gi
{

    private jg a;

    public hk()
    {
    }

    public void a()
    {
    }

    public void a(Activity activity)
    {
    }

    public void a(Application application)
    {
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        context = jg.b(context);
        parseuser = new Bundle();
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); parseuser.putString((String)entry.getKey(), entry.getValue().toString()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        context.a(s, parseuser);
    }

    public void a(ParseUser parseuser)
    {
    }

    public void b()
    {
    }

    public void b(Activity activity)
    {
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        if (a == null)
        {
            a = jg.b(context);
        }
        parseuser = new Bundle();
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                context = (java.util.Map.Entry)map.next();
                String s1 = (String)context.getKey();
                if (context.getValue() != null)
                {
                    context = context.getValue().toString();
                } else
                {
                    context = "";
                }
                parseuser.putString(s1, context);
            }
        }
        a.a(s, parseuser);
    }

    public void c(Activity activity)
    {
    }

    public void d(Activity activity)
    {
        jg.a(activity, activity.getString(0x7f0901d8));
    }

    public void e(Activity activity)
    {
        jg.a(activity);
    }

    public void f(Activity activity)
    {
    }
}
