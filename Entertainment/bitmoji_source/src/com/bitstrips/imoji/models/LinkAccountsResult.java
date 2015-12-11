// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;


public class LinkAccountsResult
{

    private Boolean linked;

    public LinkAccountsResult(Boolean boolean1)
    {
        linked = boolean1;
    }

    public Boolean success()
    {
        return linked;
    }
}
