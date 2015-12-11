// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


public final class Placement
{

    public final String caption;
    public final long placementId;

    public Placement()
    {
        this(0L, null);
    }

    public Placement(long l, String s)
    {
        placementId = l;
        if (s == null)
        {
            s = "";
        }
        caption = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Placement))
            {
                return false;
            }
            if (((Placement)obj).hashCode() != hashCode())
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Long.valueOf(placementId).hashCode();
    }
}
