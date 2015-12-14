// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static interface StrobeLightDetection
{
    public static final class CompulsoryMode extends Enum
    {

        private static final CompulsoryMode $VALUES[];
        public static final CompulsoryMode AUTO;
        public static final CompulsoryMode FIRING;
        public static final CompulsoryMode SUPPRESSION;
        public static final CompulsoryMode UNKNOWN;

        public static CompulsoryMode valueOf(String s)
        {
            return (CompulsoryMode)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$CompulsoryMode, s);
        }

        public static CompulsoryMode[] values()
        {
            return (CompulsoryMode[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new CompulsoryMode("UNKNOWN", 0);
            FIRING = new CompulsoryMode("FIRING", 1);
            SUPPRESSION = new CompulsoryMode("SUPPRESSION", 2);
            AUTO = new CompulsoryMode("AUTO", 3);
            $VALUES = (new CompulsoryMode[] {
                UNKNOWN, FIRING, SUPPRESSION, AUTO
            });
        }

        private CompulsoryMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FlashFired extends Enum
    {

        private static final FlashFired $VALUES[];
        public static final FlashFired NO;
        public static final FlashFired YES;

        public static FlashFired valueOf(String s)
        {
            return (FlashFired)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFired, s);
        }

        public static FlashFired[] values()
        {
            return (FlashFired[])$VALUES.clone();
        }

        static 
        {
            NO = new FlashFired("NO", 0);
            YES = new FlashFired("YES", 1);
            $VALUES = (new FlashFired[] {
                NO, YES
            });
        }

        private FlashFired(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FlashFunction extends Enum
    {

        private static final FlashFunction $VALUES[];
        public static final FlashFunction FUNCTION_NOR_PRESENT;
        public static final FlashFunction FUNCTION_PRESENT;

        public static FlashFunction valueOf(String s)
        {
            return (FlashFunction)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFunction, s);
        }

        public static FlashFunction[] values()
        {
            return (FlashFunction[])$VALUES.clone();
        }

        static 
        {
            FUNCTION_PRESENT = new FlashFunction("FUNCTION_PRESENT", 0);
            FUNCTION_NOR_PRESENT = new FlashFunction("FUNCTION_NOR_PRESENT", 1);
            $VALUES = (new FlashFunction[] {
                FUNCTION_PRESENT, FUNCTION_NOR_PRESENT
            });
        }

        private FlashFunction(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RedEyeMode extends Enum
    {

        private static final RedEyeMode $VALUES[];
        public static final RedEyeMode NONE;
        public static final RedEyeMode SUPPORTED;

        public static RedEyeMode valueOf(String s)
        {
            return (RedEyeMode)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$RedEyeMode, s);
        }

        public static RedEyeMode[] values()
        {
            return (RedEyeMode[])$VALUES.clone();
        }

        static 
        {
            NONE = new RedEyeMode("NONE", 0);
            SUPPORTED = new RedEyeMode("SUPPORTED", 1);
            $VALUES = (new RedEyeMode[] {
                NONE, SUPPORTED
            });
        }

        private RedEyeMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class StrobeLightDetection extends Enum
    {

        private static final StrobeLightDetection $VALUES[];
        public static final StrobeLightDetection LIGHT_DETECTED;
        public static final StrobeLightDetection LIGHT_NOT_DETECTED;
        public static final StrobeLightDetection NO_DETECTION;
        public static final StrobeLightDetection RESERVED;

        public static StrobeLightDetection valueOf(String s)
        {
            return (StrobeLightDetection)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$StrobeLightDetection, s);
        }

        public static StrobeLightDetection[] values()
        {
            return (StrobeLightDetection[])$VALUES.clone();
        }

        static 
        {
            NO_DETECTION = new StrobeLightDetection("NO_DETECTION", 0);
            RESERVED = new StrobeLightDetection("RESERVED", 1);
            LIGHT_NOT_DETECTED = new StrobeLightDetection("LIGHT_NOT_DETECTED", 2);
            LIGHT_DETECTED = new StrobeLightDetection("LIGHT_DETECTED", 3);
            $VALUES = (new StrobeLightDetection[] {
                NO_DETECTION, RESERVED, LIGHT_NOT_DETECTED, LIGHT_DETECTED
            });
        }

        private StrobeLightDetection(String s, int i)
        {
            super(s, i);
        }
    }

}
