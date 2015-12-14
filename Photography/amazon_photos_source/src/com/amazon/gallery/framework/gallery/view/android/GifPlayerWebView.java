// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.disk.ContentLoadCallback;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            SingleViewMediaPlayer

public class GifPlayerWebView extends WebView
    implements SingleViewMediaPlayer
{

    public static final String TAG = com/amazon/gallery/framework/gallery/view/android/GifPlayerWebView.getName();
    private DiskStore diskStore;
    private Handler handler;
    private MediaItem mediaItem;
    private NetworkStore networkStore;
    private SingleViewMediaPlayer.PlayerObserver playerObserver;

    public GifPlayerWebView(Context context)
    {
        super(context.getApplicationContext());
        initialize();
    }

    public GifPlayerWebView(Context context, AttributeSet attributeset)
    {
        super(context.getApplicationContext(), attributeset);
        initialize();
    }

    public GifPlayerWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context.getApplicationContext(), attributeset, i);
        initialize();
    }

    static String convertStreamToString(InputStream inputstream)
    {
        inputstream = (new Scanner(inputstream)).useDelimiter("\\A");
        if (inputstream.hasNext())
        {
            return inputstream.next();
        } else
        {
            return "";
        }
    }

    private void initialize()
    {
        setBackgroundColor(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setOverScrollMode(2);
        handler = new Handler();
    }

    private void loadGifFromCloud(final MediaItem mediaItem)
    {
        networkStore.loadContent(mediaItem, new ContentLoadCallback() {

            final GifPlayerWebView this$0;
            final MediaItem val$mediaItem;

            public void onContentLoadFailure()
            {
                GLogger.w(GifPlayerWebView.TAG, "Cannot retrieve original GIF from cloud for MediaItem %s", new Object[] {
                    mediaItem.toString()
                });
            }

            public void onContentLoadSuccess()
            {
                File file = diskStore.getOriginal(mediaItem);
                if (file.exists())
                {
                    setImageUri(Uri.parse(file.toString()));
                }
            }

            
            {
                this$0 = GifPlayerWebView.this;
                mediaItem = mediaitem;
                super();
            }
        }, true);
    }

    private void setupWebviewAsync(final Uri uri)
    {
        (new Thread() {

            private String htmlString;
            final GifPlayerWebView this$0;
            final Uri val$uri;

            public void run()
            {
                try
                {
                    htmlString = GifPlayerWebView.convertStreamToString(getContext().getAssets().open("gif_page.html"));
                    htmlString = htmlString.replace("%img_src%", uri.toString());
                    handler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            setWebChromeClient(new WebChromeClient());
                            loadDataWithBaseURL("file:///android_asset/", htmlString, "text/html", "utf-8", null);
                            if (playerObserver != null)
                            {
                                playerObserver.onMediaReady(mediaItem);
                            }
                        }

            
            {
                this$1 = _cls1.this;
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


            
            {
                this$0 = GifPlayerWebView.this;
                uri = uri1;
                super();
            }
        }).start();
    }

    public int getDisplayDelayMS()
    {
        return 0;
    }

    public MediaItem getMediaItem()
    {
        return mediaItem;
    }

    public void onConfigChanged(Configuration configuration)
    {
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public void setDiskStore(DiskStore diskstore)
    {
        diskStore = diskstore;
    }

    public void setImageUri(Uri uri)
    {
        setupWebviewAsync(uri);
    }

    public void setMediaItem(MediaItem mediaitem)
    {
        mediaItem = mediaitem;
        Object obj = mediaitem.getLocalPath();
        if (obj == null)
        {
            obj = diskStore.getOriginal(mediaitem);
            if (((File) (obj)).exists())
            {
                setImageUri(Uri.parse(((File) (obj)).toString()));
                return;
            } else
            {
                loadGifFromCloud(mediaitem);
                return;
            }
        } else
        {
            setImageUri(Uri.parse(((String) (obj))));
            return;
        }
    }

    public void setNetworkStore(NetworkStore networkstore)
    {
        networkStore = networkstore;
    }

    public void setPlayerObserver(SingleViewMediaPlayer.PlayerObserver playerobserver)
    {
        playerObserver = playerobserver;
    }

    public void shutDown()
    {
    }





}
