// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import gu;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.castandcrew:
//            CrewMember

public class CastAndCrew
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List castMembers;
    private CrewMember crewMembers;

    public CastAndCrew()
    {
    }

    public List getCastMembers()
    {
        return castMembers;
    }

    public CrewMember getCrewMembers()
    {
        return crewMembers;
    }

    public void setCastMembers(List list)
    {
        castMembers = list;
    }

    public void setCrewMembers(CrewMember crewmember)
    {
        crewMembers = crewmember;
    }
}
