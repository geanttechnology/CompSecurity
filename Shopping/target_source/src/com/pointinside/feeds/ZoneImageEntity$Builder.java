// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            ZoneImageEntity

public static final class e extends e
{

    private float baseRatioX;
    private float baseRatioY;
    private float feetHeight;
    private float feetWidth;
    private int height;
    e imageType;
    private String imageUrl;
     mimeType;
    private int point1PixelX;
    private int point1PixelY;
    private int point2PixelX;
    private int point2PixelY;
    private int point3PixelX;
    private int point3PixelY;
    private int point4PixelX;
    private int point4PixelY;
    private int width;
    private String zoneId;

    public ZoneImageEntity build()
    {
        return new ZoneImageEntity(this, null);
    }

    public e setBaseRatioX(float f)
    {
        baseRatioX = f;
        return this;
    }

    public baseRatioX setBaseRatioY(float f)
    {
        baseRatioY = f;
        return this;
    }

    public volatile baseRatioY setCreatedDate(long l)
    {
        return super.eatedDate(l);
    }

    public eatedDate setFeetHeight(float f)
    {
        feetHeight = f;
        return this;
    }

    public feetHeight setFeetWidth(float f)
    {
        feetWidth = f;
        return this;
    }

    public feetWidth setHeight(int i)
    {
        height = i;
        return this;
    }

    public volatile height setId(String s)
    {
        return super.(s);
    }

    public e setImageType(e e)
    {
        imageType = e;
        return this;
    }

    public imageType setImageUrl(String s)
    {
        imageUrl = s;
        return this;
    }

    public  setMimeType( )
    {
        mimeType = ;
        return this;
    }

    public volatile mimeType setModifiedDate(long l)
    {
        return super.difiedDate(l);
    }

    public volatile difiedDate setName(String s)
    {
        return super.me(s);
    }

    public me setPoint1PixelX(int i)
    {
        point1PixelX = i;
        return this;
    }

    public point1PixelX setPoint1PixelY(int i)
    {
        point1PixelY = i;
        return this;
    }

    public point1PixelY setPoint2PixelX(int i)
    {
        point2PixelX = i;
        return this;
    }

    public point2PixelX setPoint2PixelY(int i)
    {
        point2PixelY = i;
        return this;
    }

    public point2PixelY setPoint3PixelX(int i)
    {
        point3PixelX = i;
        return this;
    }

    public point3PixelX setPoint3PixelY(int i)
    {
        point3PixelY = i;
        return this;
    }

    public point3PixelY setPoint4PixelX(int i)
    {
        point4PixelX = i;
        return this;
    }

    public point4PixelX setPoint4PixelY(int i)
    {
        point4PixelY = i;
        return this;
    }

    public volatile point4PixelY setServerAction(point4PixelY point4pixely)
    {
        return super.rverAction(point4pixely);
    }

    public rverAction setWidth(int i)
    {
        width = i;
        return this;
    }

    public width setZoneId(String s)
    {
        zoneId = s;
        return this;
    }

    public volatile zoneId seteTag(String s)
    {
        return super.ag(s);
    }

















    public ()
    {
        zoneId = null;
        imageUrl = null;
        width = 0x80000000;
        height = 0x80000000;
        point1PixelX = 0x80000000;
        point1PixelY = 0x80000000;
        point2PixelX = 0x80000000;
        point2PixelY = 0x80000000;
        point3PixelX = 0x80000000;
        point3PixelY = 0x80000000;
        point4PixelX = 0x80000000;
        point4PixelY = 0x80000000;
        feetWidth = (0.0F / 0.0F);
        feetHeight = (0.0F / 0.0F);
        baseRatioX = (0.0F / 0.0F);
        baseRatioY = (0.0F / 0.0F);
        imageType = e.DEFAULT;
        mimeType = null;
    }

    public mimeType(ZoneImageEntity zoneimageentity)
    {
        super(zoneimageentity);
        zoneId = null;
        imageUrl = null;
        width = 0x80000000;
        height = 0x80000000;
        point1PixelX = 0x80000000;
        point1PixelY = 0x80000000;
        point2PixelX = 0x80000000;
        point2PixelY = 0x80000000;
        point3PixelX = 0x80000000;
        point3PixelY = 0x80000000;
        point4PixelX = 0x80000000;
        point4PixelY = 0x80000000;
        feetWidth = (0.0F / 0.0F);
        feetHeight = (0.0F / 0.0F);
        baseRatioX = (0.0F / 0.0F);
        baseRatioY = (0.0F / 0.0F);
        imageType = e.DEFAULT;
        mimeType = null;
        zoneId = zoneimageentity.zoneId;
        feetWidth = zoneimageentity.feetWidth;
        feetHeight = zoneimageentity.feetHeight;
        width = zoneimageentity.width;
        height = zoneimageentity.height;
        baseRatioX = zoneimageentity.baseRatioX;
        baseRatioY = zoneimageentity.baseRatioY;
        point1PixelX = zoneimageentity.point1PixelX;
        point1PixelY = zoneimageentity.point1PixelY;
        point2PixelX = zoneimageentity.point2PixelX;
        point2PixelY = zoneimageentity.point2PixelY;
        point3PixelX = zoneimageentity.point3PixelX;
        point3PixelY = zoneimageentity.point3PixelY;
        point4PixelX = zoneimageentity.point4PixelX;
        point4PixelY = zoneimageentity.point4PixelY;
        mimeType = zoneimageentity.mimeType;
        imageUrl = zoneimageentity.imageUrl;
        imageType = zoneimageentity.imageType;
    }
}
