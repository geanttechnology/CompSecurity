// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.MraidViewListener;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements android.media.ErrorListener
{

    final oViewCleanup a;

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        TapjoyLog.i("MRAIDView", "** ON ERROR **");
        a.a.videoViewCleanup();
        return false;
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class com/tapjoy/mraid/view/MraidView$5

/* anonymous class */
    final class MraidView._cls5 extends WebChromeClient
    {

        final MraidView a;

        public final void onCloseWindow(WebView webview)
        {
            super.onCloseWindow(webview);
            MraidView.g(a);
        }

        public final boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            if (MraidView.a(a) != null)
            {
                return MraidView.a(a).onConsoleMessage(consolemessage);
            } else
            {
                return super.onConsoleMessage(consolemessage);
            }
        }

        public final void onHideCustomView()
        {
            super.onHideCustomView();
        }

        public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            TapjoyLog.d("MRAIDView", s1);
            return false;
        }

        public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
label0:
            {
                TapjoyLog.i("MRAIDView", "-- onShowCustomView --");
                super.onShowCustomView(view, customviewcallback);
                MraidView.a(a, customviewcallback);
                if (view instanceof FrameLayout)
                {
                    customviewcallback = (FrameLayout)view;
                    if ((customviewcallback.getFocusedChild() instanceof VideoView) && (MraidView.i(a) instanceof Activity))
                    {
                        break label0;
                    }
                }
                return;
            }
            view = (Activity)MraidView.i(a);
            MraidView.a(a, (VideoView)customviewcallback.getFocusedChild());
            customviewcallback.removeView(MraidView.j(a));
            if (MraidView.k(a) == null)
            {
                MraidView.a(a, new RelativeLayout(MraidView.i(a)));
                MraidView.k(a).setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                MraidView.k(a).setBackgroundColor(0xff000000);
            }
            customviewcallback = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            customviewcallback.addRule(13);
            MraidView.j(a).setLayoutParams(customviewcallback);
            MraidView.a(a, new ProgressBar(MraidView.i(a), null, 0x101007a));
            MraidView.l(a).setVisibility(0);
            customviewcallback = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            customviewcallback.addRule(13);
            MraidView.l(a).setLayoutParams(customviewcallback);
            MraidView.k(a).addView(MraidView.j(a));
            MraidView.k(a).addView(MraidView.l(a));
            view.getWindow().addContentView(MraidView.k(a), new android.view.ViewGroup.LayoutParams(-1, -1));
            (new Thread(new MraidView.c(a))).start();
            a.setVisibility(8);
            MraidView.j(a).setOnPreparedListener(new MraidView._cls5._cls1());
            MraidView.j(a).setOnCompletionListener(new MraidView._cls5._cls2());
            MraidView.j(a).setOnErrorListener(new MraidView._cls5._cls3(this));
            MraidView.j(a).start();
        }

            
            {
                a = mraidview;
                super();
            }

        // Unreferenced inner class com/tapjoy/mraid/view/MraidView$5$1

/* anonymous class */
        final class MraidView._cls5._cls1
            implements android.media.MediaPlayer.OnPreparedListener
        {

            final MraidView._cls5 a;

            public final void onPrepared(MediaPlayer mediaplayer)
            {
                TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                TapjoyLog.i("MRAIDView", (new StringBuilder("isPlaying: ")).append(mediaplayer.isPlaying()).toString());
                if (!mediaplayer.isPlaying())
                {
                    mediaplayer.start();
                }
            }

                    
                    {
                        a = MraidView._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/tapjoy/mraid/view/MraidView$5$2

/* anonymous class */
        final class MraidView._cls5._cls2
            implements android.media.MediaPlayer.OnCompletionListener
        {

            final MraidView._cls5 a;

            public final void onCompletion(MediaPlayer mediaplayer)
            {
                TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                a.a.videoViewCleanup();
            }

                    
                    {
                        a = MraidView._cls5.this;
                        super();
                    }
        }

    }

}
