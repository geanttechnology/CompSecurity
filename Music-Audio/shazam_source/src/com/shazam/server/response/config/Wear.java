// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class Wear
    implements Serializable
{
    public static class Builder
    {

        private boolean showLyrics;

        public static Builder wear()
        {
            return new Builder();
        }

        public Wear build()
        {
            return new Wear(this, null);
        }

        public Builder withShowLyrics(boolean flag)
        {
            showLyrics = flag;
            return this;
        }


        public Builder()
        {
        }
    }


    private boolean showLyrics;

    private Wear()
    {
    }

    private Wear(Builder builder)
    {
        showLyrics = builder.showLyrics;
    }

    Wear(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public boolean isShowLyrics()
    {
        return showLyrics;
    }
}
