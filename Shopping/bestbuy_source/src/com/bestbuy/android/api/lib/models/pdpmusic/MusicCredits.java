// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicCredits
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList performer;

    public MusicCredits()
    {
    }

    public ArrayList getPerformer()
    {
        return performer;
    }

    public void setPerformer(ArrayList arraylist)
    {
        performer = arraylist;
    }
}
