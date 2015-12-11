// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

public class PrimaryMessages
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xdaa1056931a6b6ceL;
    private List primaryMessages;

    public PrimaryMessages()
    {
    }

    public List getPrimaryMessages()
    {
        return primaryMessages;
    }

    public void setPrimaryMessages(List list)
    {
        primaryMessages = list;
    }
}
