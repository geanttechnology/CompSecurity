// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            RichMessage

public class Badge
{

    private RichMessage meta;
    private String type;

    public Badge()
    {
    }

    public RichMessage getMeta()
    {
        return meta;
    }

    public String getType()
    {
        return type;
    }

    public void setMeta(RichMessage richmessage)
    {
        meta = richmessage;
    }

    public void setType(String s)
    {
        type = s;
    }
}
