// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class akn extends BroadcastReceiver
{

    private akj a;

    akn(akj akj1)
    {
        a = akj1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        context = cgi.a(intent.getAction());
        switch (akm.b[context.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            akj.g(a).a(alu.f);
            return;

        case 3: // '\003'
            break;
        }
        if (!akj.j(a).a())
        {
            akj.g(a).a(alu.f);
            return;
        } else
        {
            akj.g(a).a(alu.e);
            return;
        }
    }
}
