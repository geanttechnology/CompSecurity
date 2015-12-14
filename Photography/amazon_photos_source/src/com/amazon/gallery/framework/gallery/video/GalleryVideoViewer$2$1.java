// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import com.amazon.gallery.framework.network.exceptions.TerminalException;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer, GalleryVideoView

class val.url
    implements Runnable
{

    final val.url this$1;
    final String val$url;

    public void run()
    {
        onURLLoadSuccess(val$url);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$url = String.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/video/GalleryVideoViewer$2

/* anonymous class */
    class GalleryVideoViewer._cls2
        implements com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler
    {

        final GalleryVideoViewer this$0;

        public void onFailure(TerminalException terminalexception)
        {
            GalleryVideoViewer.access$000(GalleryVideoViewer.this).post(new GalleryVideoViewer._cls2._cls2());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((String)obj);
        }

        public void onSuccess(String s)
        {
            GalleryVideoViewer.access$000(GalleryVideoViewer.this).post(s. new GalleryVideoViewer._cls2._cls1());
        }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }

        // Unreferenced inner class com/amazon/gallery/framework/gallery/video/GalleryVideoViewer$2$2

/* anonymous class */
        class GalleryVideoViewer._cls2._cls2
            implements Runnable
        {

            final GalleryVideoViewer._cls2 this$1;

            public void run()
            {
                onURLLoadFailure();
            }

                    
                    {
                        this$1 = GalleryVideoViewer._cls2.this;
                        super();
                    }
        }

    }

}
