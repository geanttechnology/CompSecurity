// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.os.Handler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.ftue.ShowOverlayListener;

public interface NoContentOverlay
    extends ViewStateListener
{
    public static final class ContentMode extends Enum
    {

        private static final ContentMode $VALUES[];
        public static final ContentMode ALBUM;
        public static final ContentMode ALL;
        public static final ContentMode CAMERA;
        public static final ContentMode CLOUD;
        public static final ContentMode DEVICE;
        public static final ContentMode HIDDEN;
        public static final ContentMode VIDEOS;

        public static ContentMode valueOf(String s)
        {
            return (ContentMode)Enum.valueOf(com/amazon/gallery/framework/kindle/ui/NoContentOverlay$ContentMode, s);
        }

        public static ContentMode[] values()
        {
            return (ContentMode[])$VALUES.clone();
        }

        static 
        {
            CLOUD = new ContentMode("CLOUD", 0);
            DEVICE = new ContentMode("DEVICE", 1);
            ALL = new ContentMode("ALL", 2);
            CAMERA = new ContentMode("CAMERA", 3);
            VIDEOS = new ContentMode("VIDEOS", 4);
            ALBUM = new ContentMode("ALBUM", 5);
            HIDDEN = new ContentMode("HIDDEN", 6);
            $VALUES = (new ContentMode[] {
                CLOUD, DEVICE, ALL, CAMERA, VIDEOS, ALBUM, HIDDEN
            });
        }

        private ContentMode(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void attach(BeanAwareActivity beanawareactivity, Handler handler, ShowOverlayListener showoverlaylistener);

    public abstract void detach();

    public abstract int getNoContentViewId();

    public abstract void hide();

    public abstract boolean isAttached();

    public abstract void scheduleRefresh();

    public abstract void setNoContentMode(ContentMode contentmode);

    public abstract void show();

    public abstract void showNoContentMode(long l);
}
