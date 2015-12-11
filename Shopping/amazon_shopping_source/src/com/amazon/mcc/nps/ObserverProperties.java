// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps;


public class ObserverProperties
{
    public static class Builder
    {

        private int priority;

        public int getPriority()
        {
            return priority;
        }

        public Builder()
        {
            priority = 0;
        }
    }


    private final int priority;

    public ObserverProperties()
    {
        this(new Builder());
    }

    public ObserverProperties(Builder builder)
    {
        priority = builder.getPriority();
    }

    public int getPriority()
    {
        return priority;
    }
}
