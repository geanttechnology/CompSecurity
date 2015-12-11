// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import java.util.Date;

// Referenced classes of package com.xfinity.playerlib.model:
//            Favorite, MerlinId

public class VideoFavorite extends Favorite
{

    private MerlinId merlinId;

    public VideoFavorite(MerlinId merlinid, String s)
    {
        super(s);
        merlinId = merlinid;
    }

    public VideoFavorite(MerlinId merlinid, String s, boolean flag)
    {
        super(s, flag);
        merlinId = merlinid;
    }

    public VideoFavorite(MerlinId merlinid, String s, boolean flag, Date date)
    {
        super(s, flag, date);
        merlinId = merlinid;
    }

    public MerlinId getMerlinId()
    {
        return merlinId;
    }

    public void setMerlinId(MerlinId merlinid)
    {
        merlinId = merlinid;
    }
}
