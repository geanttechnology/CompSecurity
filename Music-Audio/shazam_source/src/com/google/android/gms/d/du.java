// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            eb, he

public final class du extends eb
{

    final Context a;
    String b;
    long c;
    long d;
    String e;
    String f;
    private final Map g;

    public du(he he1, Map map)
    {
        super(he1, "createCalendarEvent");
        g = map;
        a = he1.c();
        b = c("description");
        e = c("summary");
        c = d("start_ticks");
        d = d("end_ticks");
        f = c("location");
    }

    private String c(String s)
    {
        if (TextUtils.isEmpty((CharSequence)g.get(s)))
        {
            return "";
        } else
        {
            return (String)g.get(s);
        }
    }

    private long d(String s)
    {
        s = (String)g.get(s);
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    // Unreferenced inner class com/google/android/gms/d/du$1

/* anonymous class */
    final class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final du a;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface = a;
            Intent intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
            intent.putExtra("title", ((du) (dialoginterface)).b);
            intent.putExtra("eventLocation", ((du) (dialoginterface)).f);
            intent.putExtra("description", ((du) (dialoginterface)).e);
            if (((du) (dialoginterface)).c > -1L)
            {
                intent.putExtra("beginTime", ((du) (dialoginterface)).c);
            }
            if (((du) (dialoginterface)).d > -1L)
            {
                intent.putExtra("endTime", ((du) (dialoginterface)).d);
            }
            intent.setFlags(0x10000000);
            a.a.startActivity(intent);
        }

            
            {
                a = du.this;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/d/du$2

/* anonymous class */
    final class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final du a;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            a.a("Operation denied by user.");
        }

            
            {
                a = du.this;
                super();
            }
    }

}
