// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import java.util.List;

public class MatchBase
{

    private List contains;
    private List matches;
    private List startsWith;

    public MatchBase()
    {
    }

    public List getContains()
    {
        return contains;
    }

    public List getMatches()
    {
        return matches;
    }

    public List getStartsWith()
    {
        return startsWith;
    }

    public void setContains(List list)
    {
        contains = list;
    }

    public void setMatches(List list)
    {
        matches = list;
    }

    public void setStartsWith(List list)
    {
        startsWith = list;
    }
}
