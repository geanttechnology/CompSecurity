// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;

public class DeleteMethod extends HttpMethodBase
{

    public DeleteMethod()
    {
    }

    public DeleteMethod(String s)
    {
        super(s);
    }

    public String getName()
    {
        return "DELETE";
    }
}
