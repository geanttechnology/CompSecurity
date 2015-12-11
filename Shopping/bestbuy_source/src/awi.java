// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import com.google.android.gms.common.api.Status;

final class awi extends awf
{

    private att b;
    private IntentFilter c[];

    private awi(qm qm, att att, IntentFilter aintentfilter[])
    {
        super(qm);
        b = att;
        c = aintentfilter;
    }

    awi(qm qm, att att, IntentFilter aintentfilter[], awh._cls1 _pcls1)
    {
        this(qm, att, aintentfilter);
    }

    public qt a(Status status)
    {
        return c(status);
    }

    protected void a(awc awc1)
    {
        awc1.a(this, b, c);
        b = null;
        c = null;
    }

    protected void b(qd qd)
    {
        a((awc)qd);
    }

    public Status c(Status status)
    {
        b = null;
        c = null;
        return status;
    }
}
