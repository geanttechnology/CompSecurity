// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.imageservice;


public class ImageCdnUrlBuilder
{
    public static final class Format extends Enum
    {

        private static final Format $VALUES[];
        public static final Format GIF;
        public static final Format JPG;
        public static final Format PNG;
        private String extension;

        public static Format valueOf(String s)
        {
            return (Format)Enum.valueOf(com/groupon/util/imageservice/ImageCdnUrlBuilder$Format, s);
        }

        public static Format[] values()
        {
            return (Format[])$VALUES.clone();
        }

        static 
        {
            GIF = new Format("GIF", 0, ".gif");
            JPG = new Format("JPG", 1, ".jpg");
            PNG = new Format("PNG", 2, ".png");
            $VALUES = (new Format[] {
                GIF, JPG, PNG
            });
        }


        private Format(String s, int i, String s1)
        {
            super(s, i);
            extension = s1;
        }
    }

    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode CROP;
        public static final Mode THUMBNAIL;
        private String prefix;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/groupon/util/imageservice/ImageCdnUrlBuilder$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            THUMBNAIL = new Mode("THUMBNAIL", 0, "t");
            CROP = new Mode("CROP", 1, "c");
            $VALUES = (new Mode[] {
                THUMBNAIL, CROP
            });
        }


        private Mode(String s, int i, String s1)
        {
            super(s, i);
            prefix = s1;
        }
    }


    public static final String CDN_REGEX_CHECK = "^https?:\\/\\/img\\.grouponcdn\\.com\\/.*((\\/v1\\/)|(\\.(jpg|gif|png)))$";
    private static final int DEFAULT_IMAGE_QUALITY = 70;
    private Format format;
    private int height;
    private Mode mode;
    private final String originalUrl;
    private String pattern;
    private int quality;
    private int width;

    public ImageCdnUrlBuilder(String s)
    {
        format = Format.JPG;
        mode = Mode.THUMBNAIL;
        quality = -1;
        pattern = "^https?:\\/\\/img\\.grouponcdn\\.com\\/.*((\\/v1\\/)|(\\.(jpg|gif|png)))$";
        originalUrl = s;
    }

    public String build()
    {
        if (originalUrl == null || !originalUrl.matches(pattern))
        {
            return originalUrl;
        }
        int i = originalUrl.lastIndexOf("/v1/");
        StringBuilder stringbuilder;
        if (i == -1)
        {
            if (originalUrl.lastIndexOf('.') > originalUrl.lastIndexOf('/'))
            {
                stringbuilder = new StringBuilder(originalUrl.substring(0, originalUrl.lastIndexOf('.')));
            } else
            {
                stringbuilder = new StringBuilder(originalUrl);
            }
            stringbuilder.append("/v1/");
        } else
        {
            stringbuilder = new StringBuilder(originalUrl.substring(0, i + 4));
        }
        stringbuilder.append(mode.prefix);
        if (width != 0 && height != 0)
        {
            stringbuilder.append((new StringBuilder()).append(width).append("x").append(height).toString());
            if (format == Format.JPG)
            {
                if (quality == -1)
                {
                    quality = 70;
                }
                stringbuilder.append((new StringBuilder()).append("q").append(quality).toString());
            }
            stringbuilder.append(format.extension);
            return stringbuilder.toString();
        } else
        {
            return originalUrl;
        }
    }

    public ImageCdnUrlBuilder format(Format format1)
    {
        format = format1;
        return this;
    }

    public ImageCdnUrlBuilder mode(Mode mode1)
    {
        mode = mode1;
        return this;
    }

    public ImageCdnUrlBuilder pattern(String s)
    {
        pattern = s;
        return this;
    }

    public ImageCdnUrlBuilder quality(int i)
    {
        quality = i;
        return this;
    }

    public ImageCdnUrlBuilder size(int i, int j)
    {
        width = i;
        height = j;
        return this;
    }
}
