// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


public class AuctionFormat
{

    public final int auctionFormat;
    public final boolean isBestOffer;
    public final String item;

    public AuctionFormat(int i, boolean flag)
    {
        this("", i, flag);
    }

    public AuctionFormat(String s, int i, boolean flag)
    {
        item = s;
        auctionFormat = i;
        isBestOffer = flag;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (AuctionFormat)obj;
            if (auctionFormat != ((AuctionFormat) (obj)).auctionFormat)
            {
                return false;
            }
            if (isBestOffer != ((AuctionFormat) (obj)).isBestOffer)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i = auctionFormat;
        char c;
        if (isBestOffer)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return (i + 31) * 31 + c;
    }

    public String toString()
    {
        return item;
    }
}
