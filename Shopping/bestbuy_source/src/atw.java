// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class atw extends rn
    implements qt
{

    private final Status b;

    public atw(DataHolder dataholder)
    {
        super(dataholder);
        b = new Status(dataholder.e());
    }

    protected Object a(int i, int j)
    {
        return b(i, j);
    }

    protected atv b(int i, int j)
    {
        return new awm(a, i, j);
    }

    public Status b()
    {
        return b;
    }

    protected String d()
    {
        return "path";
    }
}
