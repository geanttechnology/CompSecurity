// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import com.google.android.gms.common.api.Status;

final class bay extends baz
{

    private Integer a;
    private Long c;
    private Integer d;
    private Integer e;
    private Bundle f;

    bay(baw baw, awd awd, Integer integer, Long long1, Integer integer1, Integer integer2, Bundle bundle)
    {
        a = integer;
        c = long1;
        d = integer1;
        e = integer2;
        f = bundle;
        super(awd);
    }

    protected final void a(awb awb)
    {
        awb = (bax)awb;
        Bundle bundle = new Bundle();
        if (a != null)
        {
            bundle.putInt("latency_micros", a.intValue());
        }
        if (c != null)
        {
            bundle.putLong("latency_bps", c.longValue());
        }
        if (d != null)
        {
            bundle.putInt("latitude_e6", d.intValue());
        }
        if (e != null)
        {
            bundle.putInt("longitude_e6", e.intValue());
        }
        if (!bundle.isEmpty() || f != null && !f.isEmpty())
        {
            awb.a(bundle, f);
        }
        a(((awn) (Status.a)));
    }
}
