// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public abstract class AmazonWebSettings
{
    public static final class LayoutAlgorithm extends Enum
    {

        private static final LayoutAlgorithm $VALUES[];
        public static final LayoutAlgorithm NARROW_COLUMNS;
        public static final LayoutAlgorithm NORMAL;
        public static final LayoutAlgorithm SINGLE_COLUMN;

        public static LayoutAlgorithm valueOf(String s)
        {
            return (LayoutAlgorithm)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$LayoutAlgorithm, s);
        }

        public static LayoutAlgorithm[] values()
        {
            return (LayoutAlgorithm[])$VALUES.clone();
        }

        static 
        {
            NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 0);
            NORMAL = new LayoutAlgorithm("NORMAL", 1);
            SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 2);
            $VALUES = (new LayoutAlgorithm[] {
                NARROW_COLUMNS, NORMAL, SINGLE_COLUMN
            });
        }

        private LayoutAlgorithm(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PluginState extends Enum
    {

        private static final PluginState $VALUES[];
        public static final PluginState OFF;
        public static final PluginState ON;
        public static final PluginState ON_DEMAND;

        public static PluginState valueOf(String s)
        {
            return (PluginState)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$PluginState, s);
        }

        public static PluginState[] values()
        {
            return (PluginState[])$VALUES.clone();
        }

        static 
        {
            ON = new PluginState("ON", 0);
            ON_DEMAND = new PluginState("ON_DEMAND", 1);
            OFF = new PluginState("OFF", 2);
            $VALUES = (new PluginState[] {
                ON, ON_DEMAND, OFF
            });
        }

        private PluginState(String s, int i)
        {
            super(s, i);
        }
    }

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


    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    protected AmazonWebSettings()
    {
    }

    public abstract boolean enableSmoothTransition();

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowRunningInsecureContent();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public abstract String getCursiveFontFamily();

    public abstract boolean getDatabaseEnabled();

    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    public abstract ZoomDensity getDefaultZoom();

    public abstract boolean getDisplayZoomControls();

    public abstract boolean getDomStorageEnabled();

    public abstract String getFantasyFontFamily();

    public abstract String getFixedFontFamily();

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public abstract LayoutAlgorithm getLayoutAlgorithm();

    public abstract boolean getLightTouchEnabled();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract PluginState getPluginState();

    public abstract String getSansSerifFontFamily();

    public abstract boolean getSaveFormData();

    public abstract boolean getSavePassword();

    public abstract String getSerifFontFamily();

    public abstract String getStandardFontFamily();

    public abstract TextSize getTextSize();

    public abstract int getTextZoom();

    public abstract boolean getUseWideViewPort();

    public abstract int getUserAgent();

    public abstract String getUserAgentString();

    public abstract boolean isDoubleTapToZoomEnabled();

    public abstract void setAllowContentAccess(boolean flag);

    public abstract void setAllowFileAccess(boolean flag);

    public abstract void setAllowFileAccessFromFileURLs(boolean flag);

    public abstract void setAllowRunningInsecureContent(boolean flag);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean flag);

    public abstract void setAppCacheEnabled(boolean flag);

    public abstract void setAppCacheMaxSize(long l);

    public abstract void setAppCachePath(String s);

    public abstract void setBlockNetworkImage(boolean flag);

    public void setBlockNetworkLoads(boolean flag)
    {
    }

    public abstract void setBuiltInZoomControls(boolean flag);

    public abstract void setCacheMode(int i);

    public abstract void setCursiveFontFamily(String s);

    public abstract void setDatabaseEnabled(boolean flag);

    public abstract void setDatabasePath(String s);

    public abstract void setDefaultFixedFontSize(int i);

    public abstract void setDefaultFontSize(int i);

    public abstract void setDefaultTextEncodingName(String s);

    public abstract void setDefaultZoom(ZoomDensity zoomdensity);

    public abstract void setDisplayZoomControls(boolean flag);

    public abstract void setDomStorageEnabled(boolean flag);

    public abstract void setDoubleTapToZoomEnabled(boolean flag);

    public abstract void setEnableSmoothTransition(boolean flag);

    public abstract void setFantasyFontFamily(String s);

    public abstract void setFixedFontFamily(String s);

    public abstract void setGeolocationDatabasePath(String s);

    public abstract void setGeolocationEnabled(boolean flag);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean flag);

    public abstract void setJavaScriptEnabled(boolean flag);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutalgorithm);

    public abstract void setLightTouchEnabled(boolean flag);

    public abstract void setLoadWithOverviewMode(boolean flag);

    public abstract void setLoadsImagesAutomatically(boolean flag);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean flag);

    public abstract void setMinimumFontSize(int i);

    public abstract void setMinimumLogicalFontSize(int i);

    public abstract void setNavDump(boolean flag);

    public abstract void setNeedInitialFocus(boolean flag);

    public abstract void setPageCacheCapacity(int i);

    public abstract void setPluginState(PluginState pluginstate);

    public abstract void setPrerenderTimeout(int i);

    public abstract void setProperty(String s, String s1);

    public abstract void setRenderPriority(RenderPriority renderpriority);

    public abstract void setSansSerifFontFamily(String s);

    public abstract void setSaveFormData(boolean flag);

    public abstract void setSavePassword(boolean flag);

    public abstract void setSerifFontFamily(String s);

    public abstract void setStandardFontFamily(String s);

    public abstract void setSupportMultipleWindows(boolean flag);

    public abstract void setSupportZoom(boolean flag);

    public abstract void setTextSize(TextSize textsize);

    public abstract void setTextZoom(int i);

    public abstract void setUseWideViewPort(boolean flag);

    public abstract void setUserAgent(int i);

    public abstract void setUserAgentString(String s);

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();
}
