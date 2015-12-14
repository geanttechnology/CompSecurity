// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.graphics.Bitmap;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            AdAdapter

public abstract class NativeAdapter extends AdAdapter
{
    public static class ComponentInfo
    {

        public List clickTrackerUrls;
        public String clickUrl;

        public ComponentInfo()
        {
        }
    }

    public static class ImageComponentInfo extends ComponentInfo
    {

        public Bitmap bitmap;
        public String bitmapUrl;
        public int height;
        public int width;

        public ImageComponentInfo()
        {
        }
    }

    public static interface NativeAdapterListener
    {

        public abstract void initFailed(Throwable throwable);

        public abstract void initSucceeded();
    }

    public static class TextComponentInfo extends ComponentInfo
    {

        public String value;

        public TextComponentInfo()
        {
        }
    }


    public NativeAdapter()
    {
    }

    public abstract List getBodyList();

    public abstract List getCallToActionList();

    public abstract String getDefaultAction();

    public abstract List getDisclaimerList();

    public abstract List getIconImageList();

    public abstract List getMainImageList();

    public abstract List getRatingList();

    public abstract List getTitleList();

    public abstract String getType();

    public abstract void init(NativeAdapterListener nativeadapterlistener);
}
