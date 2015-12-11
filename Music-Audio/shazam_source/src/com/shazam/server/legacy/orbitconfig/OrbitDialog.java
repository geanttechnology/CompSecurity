// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            Type

public class OrbitDialog
    implements Serializable
{

    private String id;
    private Type type;

    private OrbitDialog()
    {
    }

    private OrbitDialog(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.access._mth000(builder);
        type = Builder.access._mth100(builder);
    }

    OrbitDialog(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getId()
    {
        return id;
    }

    public Type getType()
    {
        return type;
    }
}
