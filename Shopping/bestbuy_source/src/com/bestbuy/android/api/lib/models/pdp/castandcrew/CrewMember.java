// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import gu;
import java.io.Serializable;
import java.util.List;

public class CrewMember
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List directors;
    private List otherCrew;
    private List writers;

    public CrewMember()
    {
    }

    public List getDirectors()
    {
        return directors;
    }

    public List getOtherCrew()
    {
        return otherCrew;
    }

    public List getWriters()
    {
        return writers;
    }

    public void setDirectors(List list)
    {
        directors = list;
    }

    public void setOtherCrew(List list)
    {
        otherCrew = list;
    }

    public void setWriters(List list)
    {
        writers = list;
    }
}
