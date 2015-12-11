// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StoreAction
    implements Serializable
{

    private List defaultActions;
    private List staticActions;

    private StoreAction()
    {
    }

    private StoreAction(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        staticActions = Builder.access._mth000(builder);
        defaultActions = Builder.access._mth100(builder);
    }

    StoreAction(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getDefaultActions()
    {
        if (defaultActions != null)
        {
            return defaultActions;
        } else
        {
            return Collections.emptyList();
        }
    }

    public List getStaticActions()
    {
        if (staticActions != null)
        {
            return staticActions;
        } else
        {
            return Collections.emptyList();
        }
    }
}
