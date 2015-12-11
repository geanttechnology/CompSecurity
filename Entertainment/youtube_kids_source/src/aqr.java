// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public final class aqr extends aqp
{

    public final Uri e;
    public final long f;
    public final aqo g;

    public aqr(long l, long l1, String s, long l2, 
            app app, aqx aqx1, long l3)
    {
        super(l, l1, s, l2, app, aqx1, (byte)0);
        e = aqx1.d;
        g = new aqo(aqx1.d, null, aqx1.e, aqx1.f);
        f = l3;
    }

    public final aqo a()
    {
        return g;
    }
}
