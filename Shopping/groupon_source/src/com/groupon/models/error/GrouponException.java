// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.error;

import com.groupon.network.HttpResponseException;
import java.util.HashMap;
import java.util.Map;

public class GrouponException extends HttpResponseException
{

    public Map mapErrorFieldToErrorList;

    public GrouponException(int i, String s)
    {
        super(i, s);
        mapErrorFieldToErrorList = new HashMap();
    }

    public GrouponException(String s)
    {
        super(0, s);
        mapErrorFieldToErrorList = new HashMap();
    }
}
