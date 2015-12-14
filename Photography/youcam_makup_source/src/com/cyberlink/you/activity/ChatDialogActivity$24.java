// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import java.util.Timer;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e, j

class b extends AsyncTask
{

    final MessageObj a;
    final String b;
    final ChatDialogActivity c;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("insert_messageObj");
        e.d().a(a);
        return null;
    }

    protected void a(Void void1)
    {
        if (ChatDialogActivity.a(c) != null)
        {
            ChatDialogActivity.a(c).c(a);
            ChatDialogActivity.m(c);
        }
        ChatDialogActivity.a(c, b, a);
        if (ChatDialogActivity.O(c) != null)
        {
            ChatDialogActivity.O(c).schedule(new j(c), 1000L);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (ChatDialogActivity chatdialogactivity, MessageObj messageobj, String s)
    {
        c = chatdialogactivity;
        a = messageobj;
        b = s;
        super();
    }
}
