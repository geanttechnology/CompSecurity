// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;

import java.io.Serializable;

public class SynchInfo
    implements Serializable
{
    public static class Builder
    {

        public float frequencySkew;
        public float offset;
        public float timeSkew;

        static float a(Builder builder)
        {
            return builder.offset;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static float b(Builder builder)
        {
            return builder.timeSkew;
        }

        static float c(Builder builder)
        {
            return builder.frequencySkew;
        }

        public Builder()
        {
        }
    }


    private float frequencySkew;
    public float offset;
    private float timeSkew;

    private SynchInfo()
    {
    }

    private SynchInfo(Builder builder)
    {
        offset = Builder.a(builder);
        timeSkew = Builder.b(builder);
        frequencySkew = Builder.c(builder);
    }

}
