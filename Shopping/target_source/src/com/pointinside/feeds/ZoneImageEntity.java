// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntity

public final class ZoneImageEntity extends BaseEntity
{
    public static final class Builder extends BaseEntity.Builder
    {

        private float baseRatioX;
        private float baseRatioY;
        private float feetHeight;
        private float feetWidth;
        private int height;
        ImageType imageType;
        private String imageUrl;
        MimeType mimeType;
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
            return new ZoneImageEntity(this);
        }

        public Builder setBaseRatioX(float f)
        {
            baseRatioX = f;
            return this;
        }

        public Builder setBaseRatioY(float f)
        {
            baseRatioY = f;
            return this;
        }

        public volatile BaseEntity.Builder setCreatedDate(long l)
        {
            return super.setCreatedDate(l);
        }

        public Builder setFeetHeight(float f)
        {
            feetHeight = f;
            return this;
        }

        public Builder setFeetWidth(float f)
        {
            feetWidth = f;
            return this;
        }

        public Builder setHeight(int i)
        {
            height = i;
            return this;
        }

        public volatile BaseEntity.Builder setId(String s)
        {
            return super.setId(s);
        }

        public Builder setImageType(ImageType imagetype)
        {
            imageType = imagetype;
            return this;
        }

        public Builder setImageUrl(String s)
        {
            imageUrl = s;
            return this;
        }

        public Builder setMimeType(MimeType mimetype)
        {
            mimeType = mimetype;
            return this;
        }

        public volatile BaseEntity.Builder setModifiedDate(long l)
        {
            return super.setModifiedDate(l);
        }

        public volatile BaseEntity.Builder setName(String s)
        {
            return super.setName(s);
        }

        public Builder setPoint1PixelX(int i)
        {
            point1PixelX = i;
            return this;
        }

        public Builder setPoint1PixelY(int i)
        {
            point1PixelY = i;
            return this;
        }

        public Builder setPoint2PixelX(int i)
        {
            point2PixelX = i;
            return this;
        }

        public Builder setPoint2PixelY(int i)
        {
            point2PixelY = i;
            return this;
        }

        public Builder setPoint3PixelX(int i)
        {
            point3PixelX = i;
            return this;
        }

        public Builder setPoint3PixelY(int i)
        {
            point3PixelY = i;
            return this;
        }

        public Builder setPoint4PixelX(int i)
        {
            point4PixelX = i;
            return this;
        }

        public Builder setPoint4PixelY(int i)
        {
            point4PixelY = i;
            return this;
        }

        public volatile BaseEntity.Builder setServerAction(BaseEntity.ServerAction serveraction)
        {
            return super.setServerAction(serveraction);
        }

        public Builder setWidth(int i)
        {
            width = i;
            return this;
        }

        public Builder setZoneId(String s)
        {
            zoneId = s;
            return this;
        }

        public volatile BaseEntity.Builder seteTag(String s)
        {
            return super.seteTag(s);
        }

















        public Builder()
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
            imageType = ImageType.DEFAULT;
            mimeType = null;
        }

        public Builder(ZoneImageEntity zoneimageentity)
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
            imageType = ImageType.DEFAULT;
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

    public static final class ImageType extends Enum
    {

        private static final ImageType $VALUES[];
        public static final ImageType DEFAULT;
        public static final ImageType DEFAULT4;
        public static final ImageType PLM_VIEW;
        public static final ImageType PLM_VIEW4;

        public static ImageType valueOf(String s)
        {
            return (ImageType)Enum.valueOf(com/pointinside/feeds/ZoneImageEntity$ImageType, s);
        }

        public static ImageType[] values()
        {
            return (ImageType[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new ImageType("DEFAULT", 0);
            PLM_VIEW = new ImageType("PLM_VIEW", 1);
            DEFAULT4 = new ImageType("DEFAULT4", 2);
            PLM_VIEW4 = new ImageType("PLM_VIEW4", 3);
            $VALUES = (new ImageType[] {
                DEFAULT, PLM_VIEW, DEFAULT4, PLM_VIEW4
            });
        }

        private ImageType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MimeType extends Enum
    {

        private static final MimeType $VALUES[];
        public static final MimeType PNG;
        public static final MimeType SVG;

        public static MimeType valueOf(String s)
        {
            return (MimeType)Enum.valueOf(com/pointinside/feeds/ZoneImageEntity$MimeType, s);
        }

        public static MimeType[] values()
        {
            return (MimeType[])$VALUES.clone();
        }

        static 
        {
            SVG = new MimeType("SVG", 0);
            PNG = new MimeType("PNG", 1);
            $VALUES = (new MimeType[] {
                SVG, PNG
            });
        }

        private MimeType(String s, int i)
        {
            super(s, i);
        }
    }


    public final float baseRatioX;
    public final float baseRatioY;
    public final float feetHeight;
    public final float feetWidth;
    public final int height;
    public final ImageType imageType;
    public final String imageUrl;
    public final MimeType mimeType;
    public final int point1PixelX;
    public final int point1PixelY;
    public final int point2PixelX;
    public final int point2PixelY;
    public final int point3PixelX;
    public final int point3PixelY;
    public final int point4PixelX;
    public final int point4PixelY;
    public final int width;
    public final String zoneId;

    private ZoneImageEntity(Builder builder)
    {
        super(builder);
        zoneId = builder.zoneId;
        feetWidth = builder.feetWidth;
        feetHeight = builder.feetHeight;
        width = builder.width;
        height = builder.height;
        baseRatioX = builder.baseRatioX;
        baseRatioY = builder.baseRatioY;
        point1PixelX = builder.point1PixelX;
        point1PixelY = builder.point1PixelY;
        point2PixelX = builder.point2PixelX;
        point2PixelY = builder.point2PixelY;
        point3PixelX = builder.point3PixelX;
        point3PixelY = builder.point3PixelY;
        point4PixelX = builder.point4PixelX;
        point4PixelY = builder.point4PixelY;
        mimeType = builder.mimeType;
        imageUrl = builder.imageUrl;
        imageType = builder.imageType;
    }


    public static ZoneImageEntity copy(ZoneImageEntity zoneimageentity)
    {
        return (new Builder(zoneimageentity)).build();
    }
}
