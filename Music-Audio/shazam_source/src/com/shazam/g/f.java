// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.g;


public interface f
{
    public static final class a
        implements f
    {

        public final void onDataFailedToLoad()
        {
        }

        public final void onDataFetched(Object obj)
        {
        }

        public a()
        {
        }
    }


    public abstract void onDataFailedToLoad();

    public abstract void onDataFetched(Object obj);
}
