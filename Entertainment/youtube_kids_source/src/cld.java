// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;

class cld
    implements android.os.Handler.Callback
{

    private clb a;

    cld(clb clb1)
    {
        a = clb1;
        super();
    }

    protected boolean a()
    {
        return true;
    }

    public boolean handleMessage(Message message)
    {
        boolean flag;
        if (a() == a.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.c.a(message);
        }
        return true;
    }
}
