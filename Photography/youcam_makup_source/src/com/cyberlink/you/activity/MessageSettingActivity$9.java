// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a extends AsyncTask
{

    final Group a;
    final MessageSettingActivity b;

    private boolean b(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((Friend)list.next()).a())
            {
                return false;
            }
        }

        return true;
    }

    protected transient List a(Void avoid[])
    {
        avoid = e.g().a(a.b);
        if (b(avoid))
        {
            return avoid;
        } else
        {
            return null;
        }
    }

    public void a(List list)
    {
        if (list != null)
        {
            MessageSettingActivity.a(b, list);
            return;
        } else
        {
            MessageSettingActivity.a(b, a, 1);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((List)obj);
    }

    _cls9(MessageSettingActivity messagesettingactivity, Group group)
    {
        b = messagesettingactivity;
        a = group;
        super();
    }
}
