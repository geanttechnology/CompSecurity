// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;

final class clc extends cld
{

    private clb a;

    clc(clb clb1)
    {
        a = clb1;
        super(clb1);
    }

    protected final boolean a()
    {
        return false;
    }

    public final boolean handleMessage(Message message)
    {
        if (!a.d) goto _L2; else goto _L1
_L1:
        if (message.what != 7 && message.what != 4) goto _L4; else goto _L3
_L3:
        a.a.f();
        a.o();
_L2:
        return super.handleMessage(message);
_L4:
        if (message.what == 3)
        {
            a.a.e();
            a.o();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
