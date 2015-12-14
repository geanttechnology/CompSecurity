// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.cyberlink.you.activity.SelectGroupActivity;
import com.cyberlink.you.friends.l;

// Referenced classes of package com.cyberlink.you:
//            g, v

public class u
{

    private static final String a = com/cyberlink/you/u.getSimpleName();

    public u()
    {
    }

    static String a()
    {
        return a;
    }

    public static void a(Application application)
    {
        g.a().a(application);
    }

    public static void a(Context context)
    {
        a(context, null, true);
    }

    public static void a(Context context, String s)
    {
        a(context, s, false);
    }

    public static void a(Context context, String s, boolean flag)
    {
        Log.d(a, (new StringBuilder()).append("[init] start BC token=").append(s).toString());
        if (context == null)
        {
            Log.d(a, "[init] context is null");
        } else
        {
            boolean flag1;
            if (s != null && !s.isEmpty())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            g.b(context);
            if (flag1)
            {
                g.a().a(s);
            }
            if (!flag && flag1 && !l.a())
            {
                Log.d(a, "[init] start load API");
                l.a(s, new v(s), true);
                return;
            }
        }
    }

    public static void a(String s)
    {
        l.d = s;
        Log.d(a, (new StringBuilder()).append("[setSearchPeopleUrl] searchPeopleUrl=").append(s).toString());
    }

    public static void b(Context context, String s)
    {
        Intent intent = new Intent(context, com/cyberlink/you/activity/ChatDialogActivity);
        intent.putExtra("sendPost", s);
        s = new Intent(context, com/cyberlink/you/activity/SelectGroupActivity);
        s.putExtra("nextIntent", intent);
        context.startActivity(s);
    }

}
