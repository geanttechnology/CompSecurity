// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a extends AsyncTask
{

    final ChatDialogActivity a;
    private MessageObj b;

    a(ChatDialogActivity chatdialogactivity, MessageObj messageobj)
    {
        a = chatdialogactivity;
        super();
        b = messageobj;
    }

    protected transient Boolean a(Void avoid[])
    {
        Thread.currentThread().setName("[CancelSendMediaTask] AsyncTask");
        if (b != null)
        {
            avoid = b.b();
            e.d().e(avoid);
        }
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        boolean1 = ((Boolean) (ChatDialogActivity.p(a)));
        boolean1;
        JVM INSTR monitorenter ;
        Object obj = b;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = b.b();
        obj = (MessageObj)ChatDialogActivity.w(a).get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Exception exception;
        try
        {
            if (ChatDialogActivity.a(a) != null)
            {
                ChatDialogActivity.a(a).e(((MessageObj) (obj)));
            }
        }
        catch (Exception exception1) { }
        boolean1;
        JVM INSTR monitorexit ;
        b = null;
        return;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
