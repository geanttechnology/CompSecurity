// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class px
{

    private final qe a;
    private final qf b;
    private final ArrayList c;

    public transient px(qe qe, qf qf, Scope ascope[])
    {
        a = qe;
        b = qf;
        c = new ArrayList(Arrays.asList(ascope));
    }

    public qe a()
    {
        return a;
    }

    public List b()
    {
        return c;
    }

    public qf c()
    {
        return b;
    }
}
