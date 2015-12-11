// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;


public class ApiFavoriteReported
{

    private final boolean isFavorite;
    private final boolean isReported;

    public ApiFavoriteReported(boolean flag, boolean flag1)
    {
        isReported = flag;
        isFavorite = flag1;
    }

    public boolean isFavorite()
    {
        return isFavorite;
    }

    public boolean isReported()
    {
        return isReported;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ApiFavoriteReported{isReported=").append(isReported).append(", isFavorite=").append(isFavorite).append('}').toString();
    }
}
