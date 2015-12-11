// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.cachelib.Normalizer;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

private static class <init>
    implements Normalizer
{

    private final String namespace;

    public String normalize(String s)
    {
        return (new StringBuilder()).append(namespace).append(".").append(s).toString();
    }

    private (String s)
    {
        namespace = s;
    }

    namespace(String s, namespace namespace1)
    {
        this(s);
    }
}
