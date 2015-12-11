// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal

public class Video
{

    public String asset;
    public String format;
    public Deal parentDeal;
    public Long primaryKey;
    public String provider;

    public Video()
    {
        provider = "";
        asset = "";
        format = "";
    }
}
