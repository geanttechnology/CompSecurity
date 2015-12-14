// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.os.AsyncTask;
import com.cyberlink.you.ChatListHandler;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            t, u

class a extends AsyncTask
{

    final t a;

    protected transient Boolean a(Void avoid[])
    {
        avoid = t.a(a).b();
        if (!avoid.isEmpty())
        {
            for (avoid = avoid.iterator(); avoid.hasNext(); ChatListHandler.a(((com.cyberlink.beautycircle.model.el.UGroup)avoid.next()).groupId.longValue())) { }
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            a.c();
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    (t t1)
    {
        a = t1;
        super();
    }
}
