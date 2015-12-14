// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.chat.ab;
import com.cyberlink.you.chat.j;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a extends AsyncTask
{

    final ChatDialogActivity a;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("onCreate");
        ChatDialogActivity.v(a);
        ChatDialogActivity.b(a, ChatDialogActivity.b(a));
        j.a(a.c);
        ab.a().a(a.d);
        return null;
    }

    public void a(Void void1)
    {
        ChatDialogActivity.A(a);
        ChatDialogActivity.B(a);
        ChatDialogActivity.C(a);
        ChatDialogActivity.D(a);
        ChatDialogActivity.E(a);
        ChatDialogActivity.F(a);
        ChatDialogActivity.G(a);
        ChatDialogActivity.H(a);
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
