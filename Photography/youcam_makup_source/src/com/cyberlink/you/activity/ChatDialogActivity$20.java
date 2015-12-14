// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a extends AsyncTask
{

    final long a;
    final ChatDialogActivity b;

    protected transient Group a(Void avoid[])
    {
        return e.f().a(String.valueOf(a));
    }

    public void a(Group group)
    {
        if (group != null)
        {
            ChatDialogActivity.a(b, group);
            return;
        } else
        {
            b.c();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((Group)obj);
    }

    (ChatDialogActivity chatdialogactivity, long l)
    {
        b = chatdialogactivity;
        a = l;
        super();
    }
}
