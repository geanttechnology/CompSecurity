// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;


public class BaseBean
{

    private String actionId;
    private String doActionId;
    private String type;

    public BaseBean()
    {
    }

    public String getActionId()
    {
        return actionId;
    }

    public String getDoActionId()
    {
        return doActionId;
    }

    public String getType()
    {
        return type;
    }

    public void setActionId(String s)
    {
        actionId = s;
    }

    public void setDoActionId(String s)
    {
        doActionId = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
