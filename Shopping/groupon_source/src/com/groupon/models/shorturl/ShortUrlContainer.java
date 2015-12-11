// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shorturl;


// Referenced classes of package com.groupon.models.shorturl:
//            Data

public class ShortUrlContainer
{

    public Data data;
    public int statusCode;

    public ShortUrlContainer()
    {
        data = new Data();
        statusCode = 200;
    }
}
