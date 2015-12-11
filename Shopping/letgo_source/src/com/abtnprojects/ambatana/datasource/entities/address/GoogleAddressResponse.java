// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;

import java.util.ArrayList;
import java.util.List;

public class GoogleAddressResponse
{

    private List results;
    private String status;

    public GoogleAddressResponse()
    {
        results = new ArrayList();
    }

    public List getResults()
    {
        return results;
    }

    public String getStatus()
    {
        return status;
    }

    public void setResults(List list)
    {
        results = list;
    }

    public void setStatus(String s)
    {
        status = s;
    }
}
