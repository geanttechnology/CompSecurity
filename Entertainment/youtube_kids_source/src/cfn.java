// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;
import java.util.concurrent.Callable;

final class cfn
    implements Callable
{

    private String a;
    private Map b;
    private cfm c;

    cfn(cfm cfm1, String s, Map map)
    {
        c = cfm1;
        a = s;
        b = map;
        super();
    }

    public final Object call()
    {
        cfm.a(c, a, b);
        return null;
    }
}
