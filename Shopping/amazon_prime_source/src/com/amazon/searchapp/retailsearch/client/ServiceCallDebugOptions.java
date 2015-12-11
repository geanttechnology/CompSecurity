// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.ArrayList;
import java.util.List;

public class ServiceCallDebugOptions
{
    public static class DebugOption
    {

        private String key;
        private String value;

        public String getKey()
        {
            return key;
        }

        public String getValue()
        {
            return value;
        }

        public DebugOption(String s, String s1)
        {
            key = s;
            value = s1;
        }
    }


    private static volatile ServiceCallDebugOptions instance;
    private String searchDebugOptions;

    private ServiceCallDebugOptions()
    {
    }

    public static ServiceCallDebugOptions getInstance()
    {
        com/amazon/searchapp/retailsearch/client/ServiceCallDebugOptions;
        JVM INSTR monitorenter ;
        ServiceCallDebugOptions servicecalldebugoptions;
        if (instance == null)
        {
            instance = new ServiceCallDebugOptions();
        }
        servicecalldebugoptions = instance;
        com/amazon/searchapp/retailsearch/client/ServiceCallDebugOptions;
        JVM INSTR monitorexit ;
        return servicecalldebugoptions;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSearchDebugOptions()
    {
        this;
        JVM INSTR monitorenter ;
        String s = searchDebugOptions;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public List getSearchDebugOptionsList()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = searchDebugOptions;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        ArrayList arraylist;
        String as1[];
        int j;
        arraylist = new ArrayList();
        as1 = searchDebugOptions.split("&");
        j = as1.length;
        int i = 0;
_L5:
        obj = arraylist;
        if (i >= j) goto _L4; else goto _L3
_L3:
        String as[] = as1[i].split("=", 2);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (as.length < 2 || as[0] == null || as[1] == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        arraylist.add(new DebugOption(as[0], as[1]));
        break MISSING_BLOCK_LABEL_115;
        Exception exception;
        exception;
        throw exception;
        i++;
          goto _L5
    }

    public void setSearchDebugOptions(String s)
    {
        this;
        JVM INSTR monitorenter ;
        searchDebugOptions = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
