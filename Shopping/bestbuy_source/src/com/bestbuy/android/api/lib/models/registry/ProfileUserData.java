// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;
import java.util.List;

public class ProfileUserData
    implements gu, Serializable
{

    private String action;
    private List entities;
    private String status;

    public ProfileUserData()
    {
    }

    public String getAction()
    {
        return action;
    }

    public List getEntities()
    {
        return entities;
    }

    public String getStatus()
    {
        return status;
    }

    public void setAction(String s)
    {
        action = s;
    }

    public void setEntities(List list)
    {
        entities = list;
    }

    public void setStatus(String s)
    {
        status = s;
    }
}
