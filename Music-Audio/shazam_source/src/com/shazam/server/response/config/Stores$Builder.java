// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.List;

// Referenced classes of package com.shazam.server.response.config:
//            Stores

public static class 
{

    private List choices;

    public static  stores()
    {
        return new <init>();
    }

    public Stores build()
    {
        return new Stores(this, null);
    }

    public <init> withChoices(List list)
    {
        choices = list;
        return this;
    }


    public ()
    {
    }
}
