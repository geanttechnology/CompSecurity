// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public abstract class AmazonWebSettings
{
    public static final class RenderPriority extends Enum
    {

        private static final RenderPriority $VALUES[];
        public static final RenderPriority HIGH;
        public static final RenderPriority LOW;
        public static final RenderPriority NORMAL;

        public static RenderPriority valueOf(String s)
        {
            return (RenderPriority)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$RenderPriority, s);
        }

        public static RenderPriority[] values()
        {
            return (RenderPriority[])$VALUES.clone();
        }

        static 
        {
            HIGH = new RenderPriority("HIGH", 0);
            NORMAL = new RenderPriority("NORMAL", 1);
            LOW = new RenderPriority("LOW", 2);
            $VALUES = (new RenderPriority[] {
                HIGH, NORMAL, LOW
            });
        }

        private RenderPriority(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TextSize extends Enum
    {

        private static final TextSize $VALUES[];
        public static final TextSize LARGER;
        public static final TextSize LARGEST;
        public static final TextSize NORMAL;
        public static final TextSize SMALLER;
        public static final TextSize SMALLEST;

        public static TextSize valueOf(String s)
        {
            return (TextSize)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$TextSize, s);
        }

        public static TextSize[] values()
        {
            return (TextSize[])$VALUES.clone();
        }

        static 
        {
            LARGER = new TextSize("LARGER", 0);
            LARGEST = new TextSize("LARGEST", 1);
            NORMAL = new TextSize("NORMAL", 2);
            SMALLER = new TextSize("SMALLER", 3);
            SMALLEST = new TextSize("SMALLEST", 4);
            $VALUES = (new TextSize[] {
                LARGER, LARGEST, NORMAL, SMALLER, SMALLEST
            });
        }

        private TextSize(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ZoomDensity extends Enum
    {

        private static final ZoomDensity $VALUES[];
        public static final ZoomDensity CLOSE;
        public static final ZoomDensity FAR;
        public static final ZoomDensity MEDIUM;

        public static ZoomDensity valueOf(String s)
        {
            return (ZoomDensity)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$ZoomDensity, s);
        }

        public static ZoomDensity[] values()
        {
            return (ZoomDensity[])$VALUES.clone();
        }

        static 
        {
            CLOSE = new ZoomDensity("CLOSE", 0);
            MEDIUM = new ZoomDensity("MEDIUM", 1);
            FAR = new ZoomDensity("FAR", 2);
            $VALUES = (new ZoomDensity[] {
                CLOSE, MEDIUM, FAR
            });
        }

        private ZoomDensity(String s, int i)
        {
            super(s, i);
        }
    }


    protected AmazonWebSettings()
    {
    }

    public abstract String getUserAgentString();

    public abstract void setBuiltInZoomControls(boolean flag);

    public abstract void setDatabaseEnabled(boolean flag);

    public abstract void setDefaultZoom(ZoomDensity zoomdensity);

    public abstract void setDomStorageEnabled(boolean flag);

    public abstract void setDoubleTapToZoomEnabled(boolean flag);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean flag);

    public abstract void setJavaScriptEnabled(boolean flag);

    public abstract void setRenderPriority(RenderPriority renderpriority);

    public abstract void setSaveFormData(boolean flag);

    public abstract void setSavePassword(boolean flag);

    public abstract void setSupportZoom(boolean flag);

    public abstract void setTextSize(TextSize textsize);

    public abstract void setTextZoom(int i);

    public abstract void setUserAgentString(String s);
}
