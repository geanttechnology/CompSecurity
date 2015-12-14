// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;


// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements Runnable
{

    final ChatDialogActivity a;

    public void run()
    {
        synchronized (ChatDialogActivity.p(a))
        {
            if (ChatDialogActivity.a(a) != null)
            {
                ChatDialogActivity.a(a).notifyDataSetChanged();
            }
            ChatDialogActivity.F(a);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
