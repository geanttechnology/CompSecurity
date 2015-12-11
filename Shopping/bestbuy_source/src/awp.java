// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.data.DataHolder;

public class awp extends rl
    implements aty
{

    public awp(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    public Object a()
    {
        return d();
    }

    public String b()
    {
        return b("asset_id");
    }

    public String c()
    {
        return b("asset_key");
    }

    public aty d()
    {
        return new awn(this);
    }
}
