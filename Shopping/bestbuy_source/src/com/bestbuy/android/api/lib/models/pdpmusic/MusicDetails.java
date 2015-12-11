// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmusic:
//            MusicCredits

public class MusicDetails
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private MusicCredits credits;
    private ArrayList specifications;

    public MusicDetails()
    {
    }

    public MusicCredits getCredits()
    {
        return credits;
    }

    public ArrayList getSpecifications()
    {
        return specifications;
    }

    public void setCredits(MusicCredits musiccredits)
    {
        credits = musiccredits;
    }

    public void setSpecifications(ArrayList arraylist)
    {
        specifications = arraylist;
    }
}
