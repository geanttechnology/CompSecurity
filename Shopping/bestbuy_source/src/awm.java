// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.data.DataHolder;

public final class awm extends rl
    implements atv
{

    private final int c;

    public awm(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        c = j;
    }

    public Object a()
    {
        return d();
    }

    public atx b()
    {
        return new aws(a, b, c);
    }

    public int c()
    {
        return a("event_type");
    }

    public atv d()
    {
        return new awl(this);
    }
}
