// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.Map;

public class arn
{

    private final Map a;
    private final wk b;

    public Map a()
    {
        return Collections.unmodifiableMap(a);
    }

    public void a(String s, wk wk)
    {
        a.put(s, wk);
    }

    public wk b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Properties: ").append(a()).append(" pushAfterEvaluate: ").append(b).toString();
    }
}
