// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.util.HashSet;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            SongPurchaseMethods

public class SongDetail
{

    public int duration;
    public String format;
    public String formatVersion;
    public String genre;
    public boolean hasAccompaniment;
    public boolean hasControl;
    public String infoLine;
    public boolean isConsumable;
    public boolean isFree;
    public boolean isHidden;
    public boolean isNew;
    public boolean isOnSale;
    public boolean isOwned;
    public int listingId;
    public int position;
    public String productIdentifier;
    public String productUid;
    public SongPurchaseMethods purchaseMethods;
    public HashSet resources;
    public int revision;

    public SongDetail()
    {
    }
}
