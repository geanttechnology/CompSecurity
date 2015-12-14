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

class val.uri extends Thread
{

    private String htmlString;
    final GifPlayerWebView this$0;
    final Uri val$uri;

    public void run()
    {
        try
        {
            htmlString = GifPlayerWebView.convertStreamToString(getContext().getAssets().open("gif_page.html"));
            htmlString = htmlString.replace("%img_src%", val$uri.toString());
            GifPlayerWebView.access$300(GifPlayerWebView.this).post(new Runnable() {

                final GifPlayerWebView._cls1 this$1;

                public void run()
                {
                    setWebChromeClient(new WebChromeClient());
                    loadDataWithBaseURL("file:///android_asset/", htmlString, "text/html", "utf-8", null);
                    if (GifPlayerWebView.access$100(this$0) != null)
                    {
                        GifPlayerWebView.access$100(this$0).onMediaReady(GifPlayerWebView.access$200(this$0));
                    }
                }

            
            {
                this$1 = GifPlayerWebView._cls1.this;
                super();
            }
            });
            return;
        }
        catch (IOException ioexception)
        {
            Log.e(GifPlayerWebView.TAG, "Caught error loading webview");
        }
    }


    _cls1.this._cls1()
    {
        this$0 = final_gifplayerwebview;
        val$uri = Uri.this;
        super();
    }
}
