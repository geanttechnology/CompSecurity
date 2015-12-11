// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Stores
    implements Serializable
{
    public static class Builder
    {

        private List choices;

        public static Builder stores()
        {
            return new Builder();
        }

        public Stores build()
        {
            return new Stores(this, null);
        }

        public Builder withChoices(List list)
        {
            choices = list;
            return this;
        }


        public Builder()
        {
        }
    }


    List choices;

    private Stores()
    {
    }

    private Stores(Builder builder)
    {
        choices = builder.choices;
    }

    Stores(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getChoices()
    {
        if (choices != null)
        {
            return choices;
        } else
        {
            return Collections.emptyList();
        }
    }
}
