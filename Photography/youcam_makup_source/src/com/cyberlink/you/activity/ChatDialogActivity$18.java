// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.chat.j;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.friends.l;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a extends AsyncTask
{

    final ChatDialogActivity a;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("onCreate");
        a.a = new l(ChatDialogActivity.g(a));
        ChatDialogActivity.v(a);
        n.a().a(ChatDialogActivity.z(a));
        return null;
    }

    public void a(Void void1)
    {
        if (j.c())
        {
            a.b(true);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
