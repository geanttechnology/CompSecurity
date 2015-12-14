// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import java.util.Locale;

public final class AviaryCds
{
    public static final class ContentType extends Enum
    {

        private static final ContentType $VALUES[];
        public static final ContentType CONTENT;
        public static final ContentType DETAIL_IMAGE;
        public static final ContentType FEATURED_IMAGE;
        public static final ContentType MESSAGE;
        public static final ContentType PREVIEW;

        public static ContentType valueOf(String s)
        {
            return (ContentType)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$ContentType, s);
        }

        public static ContentType[] values()
        {
            return (ContentType[])$VALUES.clone();
        }

        static 
        {
            PREVIEW = new ContentType("PREVIEW", 0);
            CONTENT = new ContentType("CONTENT", 1);
            MESSAGE = new ContentType("MESSAGE", 2);
            DETAIL_IMAGE = new ContentType("DETAIL_IMAGE", 3);
            FEATURED_IMAGE = new ContentType("FEATURED_IMAGE", 4);
            $VALUES = (new ContentType[] {
                PREVIEW, CONTENT, MESSAGE, DETAIL_IMAGE, FEATURED_IMAGE
            });
        }

        private ContentType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MessageType extends Enum
    {

        private static final MessageType $VALUES[];
        public static final MessageType LAUNCH;

        public static MessageType valueOf(String s)
        {
            return (MessageType)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$MessageType, s);
        }

        public static MessageType[] values()
        {
            return (MessageType[])$VALUES.clone();
        }

        static 
        {
            LAUNCH = new MessageType("LAUNCH", 0);
            $VALUES = (new MessageType[] {
                LAUNCH
            });
        }

        private MessageType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PackType extends Enum
    {

        private static final PackType $VALUES[];
        public static final PackType EFFECT;
        public static final PackType FRAME;
        public static final PackType OVERLAY;
        public static final PackType STICKER;

        public static PackType fromString(String s)
        {
            if ("effect".equals(s))
            {
                return EFFECT;
            }
            if ("frame".equals(s))
            {
                return FRAME;
            }
            if ("sticker".equals(s))
            {
                return STICKER;
            }
            if ("overlay".equals(s))
            {
                return OVERLAY;
            } else
            {
                return null;
            }
        }

        public static PackType valueOf(String s)
        {
            return (PackType)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$PackType, s);
        }

        public static PackType[] values()
        {
            return (PackType[])$VALUES.clone();
        }

        public String toCdsString()
        {
            return name().toLowerCase(Locale.US);
        }

        static 
        {
            FRAME = new PackType("FRAME", 0);
            EFFECT = new PackType("EFFECT", 1);
            STICKER = new PackType("STICKER", 2);
            OVERLAY = new PackType("OVERLAY", 3);
            $VALUES = (new PackType[] {
                FRAME, EFFECT, STICKER, OVERLAY
            });
        }

        private PackType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Permission extends Enum
    {

        private static final Permission $VALUES[];
        public static final Permission hires;
        public static final Permission kill;
        public static final Permission whitelabel;

        public static Permission valueOf(String s)
        {
            return (Permission)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$Permission, s);
        }

        public static Permission[] values()
        {
            return (Permission[])$VALUES.clone();
        }

        static 
        {
            hires = new Permission("hires", 0);
            whitelabel = new Permission("whitelabel", 1);
            kill = new Permission("kill", 2);
            $VALUES = (new Permission[] {
                hires, whitelabel, kill
            });
        }

        private Permission(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Size extends Enum
    {

        private static final Size $VALUES[];
        public static final Size Large;
        public static final Size Medium;
        public static final Size Small;

        public static Size valueOf(String s)
        {
            return (Size)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$Size, s);
        }

        public static Size[] values()
        {
            return (Size[])$VALUES.clone();
        }

        static 
        {
            Small = new Size("Small", 0);
            Medium = new Size("Medium", 1);
            Large = new Size("Large", 2);
            $VALUES = (new Size[] {
                Small, Medium, Large
            });
        }

        private Size(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String DEFAULT_EFFECT_IDENTIFIER = "com.aviary.effectpack.04";
    public static final String DEFAULT_FRAME_IDENTIFIER = "com.aviary.framepack.00";
    public static final String DEFAULT_STICKER_IDENTIFIER = "com.aviary.stickerpack.00";
    public static final String PACKTYPE_EFFECT = "effect";
    public static final String PACKTYPE_FRAME = "frame";
    public static final String PACKTYPE_OVERLAY = "overlay";
    public static final String PACKTYPE_STICKER = "sticker";
    public static final String SUBSCRIPTION_TYPE_ALL = "all";
    public static final String SUBSCRIPTION_TYPE_EFFECT = "effect";
    public static final String SUBSCRIPTION_TYPE_FRAME = "frame";
    public static final String SUBSCRIPTION_TYPE_STICKER = "sticker";

    private AviaryCds()
    {
    }

    private static String getOverlayFilename(String s, Size size)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[];
            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$Size[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$Size = new int[Size.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$Size[Size.Large.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$Size[Size.Medium.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$Size[Size.Small.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType = new int[PackType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[PackType.STICKER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[PackType.OVERLAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.Size[size.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return (new StringBuilder()).append(s).append("-large.png").toString();

        case 2: // '\002'
            return (new StringBuilder()).append(s).append("-medium.png").toString();

        case 3: // '\003'
            return (new StringBuilder()).append(s).append("-small.png").toString();
        }
    }

    public static String getPackItemFilename(String s, PackType packtype, Size size)
    {
        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.PackType[packtype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getStickerFilename(s, size);

        case 2: // '\002'
            return getOverlayFilename(s, size);
        }
    }

    public static String getPreviewItemExt(PackType packtype)
    {
        if (packtype == PackType.EFFECT)
        {
            return ".jpg";
        } else
        {
            return ".png";
        }
    }

    public static String getPreviewItemExt(String s)
    {
        if ("effect".equals(s))
        {
            return ".jpg";
        } else
        {
            return ".png";
        }
    }

    private static String getStickerFilename(String s, Size size)
    {
        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.Size[size.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return (new StringBuilder()).append(s).append("-large.png").toString();

        case 2: // '\002'
            return (new StringBuilder()).append(s).append("-medium.png").toString();

        case 3: // '\003'
            return (new StringBuilder()).append(s).append("-small.png").toString();
        }
    }
}
