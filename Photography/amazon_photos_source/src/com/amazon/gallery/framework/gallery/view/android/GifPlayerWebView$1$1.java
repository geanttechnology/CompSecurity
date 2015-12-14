// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import java.io.IOException;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            GifPlayerWebView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        setWebChromeClient(new WebChromeClient());
        loadDataWithBaseURL("file:///android_asset/", mlString, "text/html", "utf-8", null);
        if (GifPlayerWebView.access$100(_fld0) != null)
        {
            GifPlayerWebView.access$100(_fld0).onMediaReady(GifPlayerWebView.access$200(_fld0));
        }
    }

    l.uri()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/view/android/GifPlayerWebView$1

/* anonymous class */
    class GifPlayerWebView._cls1 extends Thread
    {

        private String htmlString;
        final GifPlayerWebView this$0;
        final Uri val$uri;

        public void run()
        {
            try
            {
                htmlString = GifPlayerWebView.convertStreamToString(getContext().getAssets().open("gif_page.html"));
                htmlString = htmlString.replace("%img_src%", uri.toString());
                GifPlayerWebView.access$300(GifPlayerWebView.this).post(new GifPlayerWebView._cls1._cls1());
                return;
            }
            catch (IOException ioexception)
            {
                Log.e(GifPlayerWebView.TAG, "Caught error loading webview");
            }
        }


            
            {
                this$0 = final_gifplayerwebview;
                uri = Uri.this;
                super();
            }
    }

}
