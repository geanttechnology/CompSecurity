// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;


// Referenced classes of package org.apache.commons.httpclient.methods:
//            EntityEnclosingMethod

public class PutMethod extends EntityEnclosingMethod
{

    public PutMethod()
    {
    }

    public PutMethod(String s)
    {
        super(s);
    }

    public String getName()
    {
        return "PUT";
    }
}
