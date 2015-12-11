// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.Locale;

public final class ZoomUriBuilder
{
    public static final class HAlign extends Enum
    {

        private static final HAlign $VALUES[];
        public static final HAlign CENTER;
        public static final HAlign LEFT;
        public static final HAlign RIGHT;
        protected final String designator;

        public static HAlign valueOf(String s)
        {
            return (HAlign)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$HAlign, s);
        }

        public static HAlign[] values()
        {
            return (HAlign[])$VALUES.clone();
        }

        static 
        {
            LEFT = new HAlign("LEFT", 0, "l");
            CENTER = new HAlign("CENTER", 1, "c");
            RIGHT = new HAlign("RIGHT", 2, "r");
            $VALUES = (new HAlign[] {
                LEFT, CENTER, RIGHT
            });
        }

        private HAlign(String s, int i, String s1)
        {
            super(s, i);
            designator = s1;
        }
    }

    public static final class ImageFormat extends Enum
    {

        private static final ImageFormat $VALUES[];
        public static final ImageFormat BMP;
        public static final ImageFormat GIF;
        public static final ImageFormat JPEG;
        public static final ImageFormat PNG;
        public static final ImageFormat WEBP;
        protected final String extension;

        public static ImageFormat valueOf(String s)
        {
            return (ImageFormat)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ImageFormat, s);
        }

        public static ImageFormat[] values()
        {
            return (ImageFormat[])$VALUES.clone();
        }

        static 
        {
            JPEG = new ImageFormat("JPEG", 0, ".jpg");
            GIF = new ImageFormat("GIF", 1, ".gif");
            PNG = new ImageFormat("PNG", 2, ".png");
            BMP = new ImageFormat("BMP", 3, ".bmp");
            WEBP = new ImageFormat("WEBP", 4, ".webp");
            $VALUES = (new ImageFormat[] {
                JPEG, GIF, PNG, BMP, WEBP
            });
        }

        private ImageFormat(String s, int i, String s1)
        {
            super(s, i);
            extension = s1;
        }
    }

    public static final class Quality extends Enum
    {

        private static final Quality $VALUES[];
        public static final Quality NORMAL;
        public static final Quality _40;
        public static final Quality _50;
        public static final Quality _60;
        public static final Quality _70;
        protected final int level;

        public static Quality valueOf(String s)
        {
            return (Quality)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$Quality, s);
        }

        public static Quality[] values()
        {
            return (Quality[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new Quality("NORMAL", 0, 80);
            _70 = new Quality("_70", 1, 70);
            _60 = new Quality("_60", 2, 60);
            _50 = new Quality("_50", 3, 50);
            _40 = new Quality("_40", 4, 40);
            $VALUES = (new Quality[] {
                NORMAL, _70, _60, _50, _40
            });
        }

        private Quality(String s, int i, int j)
        {
            super(s, i);
            level = j;
        }
    }

    public static final class ResourceIdType extends Enum
    {

        private static final ResourceIdType $VALUES[];
        public static final ResourceIdType ATMOS_ID;
        public static final ResourceIdType GUID;
        public static final ResourceIdType ITEM_ID;
        public static final ResourceIdType MD5_HASH;
        protected final String designator;

        public static ResourceIdType valueOf(String s)
        {
            return (ResourceIdType)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ResourceIdType, s);
        }

        public static ResourceIdType[] values()
        {
            return (ResourceIdType[])$VALUES.clone();
        }

        static 
        {
            ITEM_ID = new ResourceIdType("ITEM_ID", 0, "i");
            MD5_HASH = new ResourceIdType("MD5_HASH", 1, "m");
            GUID = new ResourceIdType("GUID", 2, "g");
            ATMOS_ID = new ResourceIdType("ATMOS_ID", 3, "a");
            $VALUES = (new ResourceIdType[] {
                ITEM_ID, MD5_HASH, GUID, ATMOS_ID
            });
        }

        private ResourceIdType(String s, int i, String s1)
        {
            super(s, i);
            designator = s1;
        }
    }

    public static final class ScaleBy extends Enum
    {

        private static final ScaleBy $VALUES[];
        public static final ScaleBy BOTH;
        public static final ScaleBy HEIGHT;
        public static final ScaleBy LONGEST;
        public static final ScaleBy WIDTH;
        protected final String formatString;
        protected final byte parameterCount;

        public static ScaleBy valueOf(String s)
        {
            return (ScaleBy)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ScaleBy, s);
        }

        public static ScaleBy[] values()
        {
            return (ScaleBy[])$VALUES.clone();
        }

        static 
        {
            WIDTH = new ScaleBy("WIDTH", 0, "s-w%1$d", (byte)1);
            HEIGHT = new ScaleBy("HEIGHT", 1, "s-h%1$d", (byte)1);
            BOTH = new ScaleBy("BOTH", 2, "s-b%1$dx%2$d", (byte)2);
            LONGEST = new ScaleBy("LONGEST", 3, "s-l%1$d", (byte)1);
            $VALUES = (new ScaleBy[] {
                WIDTH, HEIGHT, BOTH, LONGEST
            });
        }

        private ScaleBy(String s, int i, String s1, byte byte0)
        {
            super(s, i);
            formatString = s1;
            parameterCount = byte0;
        }
    }

    public static final class VAlign extends Enum
    {

        private static final VAlign $VALUES[];
        public static final VAlign BOTTOM;
        public static final VAlign CENTER;
        public static final VAlign TOP;
        protected final String designator;

        public static VAlign valueOf(String s)
        {
            return (VAlign)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$VAlign, s);
        }

        public static VAlign[] values()
        {
            return (VAlign[])$VALUES.clone();
        }

        static 
        {
            TOP = new VAlign("TOP", 0, "t");
            CENTER = new VAlign("CENTER", 1, "c");
            BOTTOM = new VAlign("BOTTOM", 2, "b");
            $VALUES = (new VAlign[] {
                TOP, CENTER, BOTTOM
            });
        }

        private VAlign(String s, int i, String s1)
        {
            super(s, i);
            designator = s1;
        }
    }


    private static final String ITEM_ID_FORMAT = "%1$d-%2$d-%3$d";
    private static final String ITEM_ID_VARIATION_FORMAT = "%1$d-%2$d-%3$d-%4$d";
    private static final String PADDING_ALIGNMENT_FORMAT = "-v%1$s-h%2$s";
    private static final String PADDING_BASE = "p";
    private static final String PADDING_COLOR_FORMAT = "-bg%1$s";
    private static final String PROGRESSIVE_RENDERING = "r";
    private static final String QUALITY_FORMAT = "q-%1$d";
    private static final String SCHEME = "http://";
    private static final String SERVICE_NAME = "images";
    private static final String SLASH = "/";
    private Integer backgroundColor;
    private HAlign horizontalPaddingAlignment;
    private String hostName;
    private ImageFormat imageFormat;
    private boolean progressiveRendering;
    private Quality qualityPercent;
    private String resourceId;
    private ResourceIdType resourceIdType;
    private ScaleBy scaleBy;
    private Object scaleByParams[];
    private boolean showPadding;
    private VAlign verticalPaddingAlignment;

    public ZoomUriBuilder()
    {
        reset();
    }

    public static ImageFormat imageFormatFromString(String s)
    {
        ImageFormat imageformat1 = ImageFormat.JPEG;
        ImageFormat aimageformat[] = ImageFormat.values();
        int j = aimageformat.length;
        int i = 0;
        do
        {
label0:
            {
                ImageFormat imageformat = imageformat1;
                if (i < j)
                {
                    imageformat = aimageformat[i];
                    if (!imageformat.extension.contains(s.toLowerCase(Locale.US)))
                    {
                        break label0;
                    }
                }
                return imageformat;
            }
            i++;
        } while (true);
    }

    private void reset()
    {
        hostName = null;
        resourceIdType = null;
        resourceId = null;
        imageFormat = ImageFormat.JPEG;
        showPadding = false;
        horizontalPaddingAlignment = null;
        verticalPaddingAlignment = null;
        backgroundColor = null;
        scaleBy = null;
        scaleByParams = null;
        progressiveRendering = false;
        qualityPercent = Quality.NORMAL;
    }

    public String build()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (hostName == null)
        {
            throw new IllegalStateException("Host name not specified");
        }
        if (resourceIdType == null || resourceId == null)
        {
            throw new IllegalStateException("Resource not specified");
        }
        if (imageFormat == null)
        {
            throw new IllegalStateException("Image format not specified");
        }
        stringbuilder.append("http://").append(hostName).append("/").append("images").append("/");
        stringbuilder.append(resourceIdType.designator).append("/").append(resourceId).append("/");
        if (scaleBy != null && scaleByParams != null)
        {
            stringbuilder.append(String.format(Locale.US, scaleBy.formatString, scaleByParams)).append("/");
        }
        if (showPadding)
        {
            String s1 = "p";
            String s = s1;
            if (horizontalPaddingAlignment != null)
            {
                s = s1;
                if (verticalPaddingAlignment != null)
                {
                    s = (new StringBuilder()).append("p").append(String.format(Locale.US, "-v%1$s-h%2$s", new Object[] {
                        horizontalPaddingAlignment.designator, verticalPaddingAlignment.designator
                    })).toString();
                }
            }
            s1 = s;
            if (backgroundColor != null)
            {
                s1 = (new StringBuilder()).append(s).append(String.format(Locale.US, "-bg%1$s", new Object[] {
                    Integer.toHexString(backgroundColor.intValue())
                })).toString();
            }
            stringbuilder.append(s1).append("/");
        }
        if (progressiveRendering)
        {
            stringbuilder.append("r").append("/");
        }
        if (qualityPercent != Quality.NORMAL)
        {
            stringbuilder.append(String.format(Locale.US, "q-%1$d", new Object[] {
                Integer.valueOf(qualityPercent.level)
            })).append("/");
        }
        stringbuilder.setLength(stringbuilder.length() - 1);
        stringbuilder.append(imageFormat.extension);
        reset();
        return stringbuilder.toString();
    }

    public ZoomUriBuilder withAtmosId(String s)
    {
        return withResourceId(ResourceIdType.ATMOS_ID, s);
    }

    public ZoomUriBuilder withGuid(String s)
    {
        return withResourceId(ResourceIdType.GUID, s);
    }

    public ZoomUriBuilder withHost(String s)
    {
        hostName = s;
        return this;
    }

    public ZoomUriBuilder withImageFormat(ImageFormat imageformat)
    {
        imageFormat = imageformat;
        return this;
    }

    public ZoomUriBuilder withImageQuality(int i)
    {
        Quality aquality[] = Quality.values();
        int k = aquality.length;
        int j = 0;
        do
        {
label0:
            {
                if (j < k)
                {
                    Quality quality = aquality[j];
                    if (i < quality.level)
                    {
                        break label0;
                    }
                    qualityPercent = quality;
                }
                return this;
            }
            j++;
        } while (true);
    }

    public ZoomUriBuilder withItemId(long l, int i, int j)
    {
        return withResourceId(ResourceIdType.ITEM_ID, String.format(Locale.US, "%1$d-%2$d-%3$d", new Object[] {
            Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j)
        }));
    }

    public ZoomUriBuilder withItemId(long l, int i, int j, int k)
    {
        return withResourceId(ResourceIdType.ITEM_ID, String.format(Locale.US, "%1$d-%2$d-%3$d-%4$d", new Object[] {
            Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
        }));
    }

    public ZoomUriBuilder withMd5(String s)
    {
        return withResourceId(ResourceIdType.MD5_HASH, s);
    }

    public ZoomUriBuilder withPadding()
    {
        showPadding = true;
        return this;
    }

    public ZoomUriBuilder withPadding(int i)
    {
        showPadding = true;
        backgroundColor = Integer.valueOf(i);
        return this;
    }

    public ZoomUriBuilder withPadding(HAlign halign, VAlign valign)
    {
        showPadding = true;
        horizontalPaddingAlignment = halign;
        verticalPaddingAlignment = valign;
        return this;
    }

    public ZoomUriBuilder withPadding(HAlign halign, VAlign valign, int i)
    {
        showPadding = true;
        horizontalPaddingAlignment = halign;
        verticalPaddingAlignment = valign;
        backgroundColor = Integer.valueOf(i);
        return this;
    }

    public ZoomUriBuilder withProgressiveRendering(boolean flag)
    {
        progressiveRendering = flag;
        return this;
    }

    public ZoomUriBuilder withResourceId(ResourceIdType resourceidtype, String s)
    {
        if (resourceIdType != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Resource type already set to ").append(resourceIdType.name()).toString());
        } else
        {
            resourceIdType = resourceidtype;
            resourceId = s;
            return this;
        }
    }

    public transient ZoomUriBuilder withScaling(ScaleBy scaleby, Integer ainteger[])
    {
        if (scaleby.parameterCount != ainteger.length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("ScaleBy.").append(scaleby.name()).append("takes ").append(scaleby.parameterCount).append("parameters. ").append(ainteger.length).append("provided.").toString());
        } else
        {
            scaleBy = scaleby;
            scaleByParams = (Object[])ainteger.clone();
            return this;
        }
    }
}
