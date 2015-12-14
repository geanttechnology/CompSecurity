// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity, VideoAd, VideoImage, MMLog, 
//            MMWebView, HttpGetRequest, AdCache, MMActivity, 
//            InterstitialWebViewClient, VideoLogEvent

class CachedVideoPlayerActivity extends VideoPlayerActivity
    implements android.os.Handler.Callback
{

    boolean a;
    private Handler j;
    private VideoAd k;
    private MMWebView l;
    private TextView m;
    private TextView n;
    private RelativeLayout o;
    private int p;
    private boolean q;
    private boolean r;

    CachedVideoPlayerActivity()
    {
        r = true;
    }

    static MMWebView a(CachedVideoPlayerActivity cachedvideoplayeractivity)
    {
        return cachedvideoplayeractivity.l;
    }

    static void a(CachedVideoPlayerActivity cachedvideoplayeractivity, String s)
    {
        if (cachedvideoplayeractivity.f != null && cachedvideoplayeractivity.k != null && !cachedvideoplayeractivity.f.isPlaying() && cachedvideoplayeractivity.k.webOverlayURL != null && s.equalsIgnoreCase(cachedvideoplayeractivity.k.webOverlayURL))
        {
            cachedvideoplayeractivity.a(0);
        }
    }

    private static void b(VideoImage videoimage)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(videoimage.fromAlpha, videoimage.toAlpha);
        alphaanimation.setDuration(videoimage.fadeDuration);
        alphaanimation.setFillEnabled(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillAfter(true);
        videoimage.button.startAnimation(alphaanimation);
    }

    private void c(String s)
    {
        (new FetchWebViewContentTask(s)).execute(new Void[0]);
    }

    private void n()
    {
        if (k != null && k.buttons != null)
        {
            for (int i1 = 0; i1 < k.buttons.size(); i1++)
            {
                VideoImage videoimage = (VideoImage)k.buttons.get(i1);
                if (!videoimage.isLeaveBehind)
                {
                    a(videoimage.button, videoimage.fromAlpha);
                }
                if (videoimage.button.getParent() == null)
                {
                    o.addView(videoimage.button, videoimage.layoutParams);
                }
                for (int j1 = 0; j1 < k.buttons.size(); j1++)
                {
                    o.bringChildToFront(((VideoImage)k.buttons.get(j1)).button);
                }

                MMLog.a("CachedVideoPlayerActivity", String.format("Button: %d alpha: %f", new Object[] {
                    Integer.valueOf(i1), Float.valueOf(videoimage.fromAlpha)
                }));
            }

        }
    }

    private void o()
    {
        if (k != null)
        {
            m.setText(String.valueOf(k.duration / 1000L));
        }
        n.setVisibility(0);
        m.setVisibility(0);
    }

    private void p()
    {
        if (n != null)
        {
            n.setVisibility(4);
        }
        if (m != null)
        {
            m.setVisibility(4);
        }
    }

    protected final void a()
    {
        super.a();
        if (l != null)
        {
            l.bringToFront();
        }
        if (o != null)
        {
            o.bringToFront();
        }
    }

    protected final void a(int i1)
    {
        if (k == null)
        {
            Toast.makeText(b, "Sorry. There was a problem playing the video", 1).show();
            return;
        }
        if (!j.hasMessages(2) && k != null)
        {
            j.sendMessageDelayed(Message.obtain(j, 2), 1000L);
        }
        super.a(i1);
    }

    protected final void a(Bundle bundle)
    {
        bundle.putParcelable("videoAd", k);
        super.a(bundle);
    }

    protected final void a(String s)
    {
        if (k != null)
        {
            HttpGetRequest.a(k.videoError);
        }
        if (l != null)
        {
            l.loadUrl((new StringBuilder("javascript:MMJS.cachedVideo.setError(")).append(s).append(");").toString());
        }
        super.a(s);
    }

    protected final void b(Bundle bundle)
    {
        k = (VideoAd)bundle.getParcelable("videoAd");
        super.b(bundle);
    }

    protected final void c(Bundle bundle)
    {
        super.c(bundle);
        if (bundle == null)
        {
            bundle = getIntent().getStringExtra("videoId");
            k = (VideoAd)AdCache.g(b, bundle);
            if (k != null)
            {
                c = k.showControls;
                r = k.showCountdown;
            }
            return;
        } else
        {
            k = (VideoAd)bundle.getParcelable("videoAd");
            c = bundle.getBoolean("shouldShowBottomBar");
            p = bundle.getInt("lastVideoPosition");
            d = bundle.getInt("currentVideoPosition");
            r = k.showCountdown;
            return;
        }
    }

    protected final void d()
    {
        super.d();
        if (!q && k != null && k.stayInPlayer && e)
        {
            n();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (k != null)
        {
            if (j != null)
            {
                j.removeMessages(1);
            }
            if (!q)
            {
                int i1 = 0;
                while (i1 < k.buttons.size()) 
                {
                    VideoImage videoimage = (VideoImage)k.buttons.get(i1);
                    a(videoimage.button, videoimage.fromAlpha);
                    if (videoimage.inactivityTimeout > 0L)
                    {
                        Message message = Message.obtain(j, 1, videoimage);
                        j.sendMessageDelayed(message, videoimage.inactivityTimeout);
                    } else
                    if (motionevent.getAction() == 1)
                    {
                        if (j())
                        {
                            AlphaAnimation alphaanimation = new AlphaAnimation(videoimage.fromAlpha, videoimage.toAlpha);
                            alphaanimation.setDuration(videoimage.fadeDuration);
                            alphaanimation.setFillEnabled(true);
                            alphaanimation.setFillBefore(true);
                            alphaanimation.setFillAfter(true);
                            videoimage.button.startAnimation(alphaanimation);
                        }
                    } else
                    if (motionevent.getAction() == 0)
                    {
                        a(videoimage.button, videoimage.fromAlpha);
                    }
                    i1++;
                }
            }
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected final RelativeLayout e()
    {
        RelativeLayout relativelayout;
        relativelayout = super.e();
        j = new Handler(this);
        setRequestedOrientation(0);
        if (r)
        {
            n = new TextView(b);
            n.setText(" seconds remaining ...");
            n.setTextColor(-1);
            n.setPadding(0, 0, 5, 0);
            n.setId(402);
            n.setShadowLayer(1.0F, 0.0F, 0.0F, 0xff000000);
            Object obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            relativelayout.addView(n, ((android.view.ViewGroup.LayoutParams) (obj)));
            m = new TextView(b);
            TextView textview = m;
            if (d != 0)
            {
                obj = String.valueOf(d / 1000);
            } else
            if (k != null)
            {
                obj = String.valueOf(k.duration / 1000L);
            } else
            {
                obj = "";
            }
            textview.setText(((CharSequence) (obj)));
            m.setTextColor(-1);
            m.setId(401);
            m.setShadowLayer(1.0F, 0.0F, 0.0F, 0xff000000);
            obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, 402);
            relativelayout.addView(m, ((android.view.ViewGroup.LayoutParams) (obj)));
            o();
        }
        if (k == null || k.webOverlayURL == null) goto _L2; else goto _L1
_L1:
        l = new MMWebView(b, b.b);
        l.setId(413);
        obj = new CachedVideoWebViewClientListener();
        l.setWebViewClient(new InterstitialWebViewClient(((MMWebViewClient.MMWebViewClientListener) (obj)), g));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        l.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        l.setBackgroundColor(0);
        c(k.webOverlayURL);
        if (l != null)
        {
            relativelayout.addView(l);
            q = true;
        }
_L6:
        return relativelayout;
_L2:
        q = false;
        o = new RelativeLayout(b);
        o.setId(1000);
        ArrayList arraylist;
        Object obj1;
        File file;
        VideoImage videoimage;
        ImageButton imagebutton;
        int i1;
        if (k != null)
        {
            arraylist = k.buttons;
        } else
        {
            arraylist = null;
        }
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_1034;
        }
        file = AdCache.g(b);
        i1 = 0;
        if (i1 >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_1017;
        }
        videoimage = (VideoImage)arraylist.get(i1);
        imagebutton = new ImageButton(b);
        videoimage.button = imagebutton;
        obj1 = BitmapFactory.decodeFile((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(k.getId()).append(Uri.parse(videoimage.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")).toString());
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            imagebutton.setImageBitmap(((android.graphics.Bitmap) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            MMLog.a("CachedVideoPlayerActivity", "Problem creating layout with bitmap buttons: ", ((Throwable) (obj1)));
        }
        a(imagebutton, videoimage.fromAlpha);
        imagebutton.setId(i1 + 1);
        imagebutton.setPadding(0, 0, 0, 0);
        if (videoimage.isLeaveBehind)
        {
            imagebutton.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            imagebutton.setBackgroundColor(0xff000000);
            obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else
        {
            imagebutton.setBackgroundColor(0);
            obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            MMLog.a("CachedVideoPlayerActivity", String.format("Button: %d Anchor: %d Position: %d Anchor2: %d Position2: %d", new Object[] {
                Integer.valueOf(imagebutton.getId()), Integer.valueOf(videoimage.anchor), Integer.valueOf(videoimage.position), Integer.valueOf(videoimage.anchor2), Integer.valueOf(videoimage.position2)
            }));
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(videoimage.position, videoimage.anchor);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(videoimage.position2, videoimage.anchor2);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(videoimage.paddingLeft, videoimage.paddingTop, videoimage.paddingRight, videoimage.paddingBottom);
        }
        if (!TextUtils.isEmpty(videoimage.linkUrl))
        {
            imagebutton.setOnClickListener(new android.view.View.OnClickListener(imagebutton, videoimage) {

                private ImageButton a;
                private VideoImage b;
                private CachedVideoPlayerActivity c;

                public void onClick(View view)
                {
                    if (a != null)
                    {
                        a.setEnabled(false);
                    }
                    c.g.d = b.overlayOrientation;
                    c.b(b.linkUrl);
                    CachedVideoPlayerActivity.a(b);
                }

            
            {
                c = CachedVideoPlayerActivity.this;
                a = imagebutton;
                b = videoimage;
                super();
            }
            });
        }
        if (videoimage.appearanceDelay > 0L)
        {
            videoimage.layoutParams = ((android.widget.RelativeLayout.LayoutParams) (obj1));
            obj1 = Message.obtain(j, 3, videoimage);
            j.sendMessageDelayed(((Message) (obj1)), videoimage.appearanceDelay);
        } else
        {
            o.addView(imagebutton, ((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        if (videoimage.inactivityTimeout > 0L)
        {
            obj1 = Message.obtain(j, 1, videoimage);
            j.sendMessageDelayed(((Message) (obj1)), videoimage.inactivityTimeout + videoimage.appearanceDelay + videoimage.fadeDuration);
        }
        i1++;
        if (false)
        {
            break MISSING_BLOCK_LABEL_780;
        } else
        {
            break MISSING_BLOCK_LABEL_478;
        }
_L4:
        imagebutton.setImageURI(Uri.parse((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(k.getId()).append(Uri.parse(videoimage.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")).toString()));
        break MISSING_BLOCK_LABEL_593;
        relativelayout.addView(o, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (o != null)
        {
            relativelayout.bringChildToFront(o);
        }
        if (l != null)
        {
            relativelayout.bringChildToFront(l);
            return relativelayout;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final void f()
    {
        super.f();
        j.removeMessages(1);
        j.removeMessages(2);
        j.removeMessages(3);
    }

    protected final void g()
    {
        if (k != null)
        {
            if (!j.hasMessages(2))
            {
                j.sendMessageDelayed(Message.obtain(j, 2), 1000L);
            }
            if (!q)
            {
                if (r)
                {
                    long l1 = (k.duration - (long)d) / 1000L;
                    VideoImage videoimage;
                    Message message;
                    int i1;
                    long l3;
                    if (l1 > 0L)
                    {
                        if (m != null)
                        {
                            m.setText(String.valueOf(l1));
                        }
                    } else
                    {
                        p();
                    }
                }
                if (k.buttons != null)
                {
                    i1 = 0;
                    while (i1 < k.buttons.size()) 
                    {
                        videoimage = (VideoImage)k.buttons.get(i1);
                        long l2;
                        if (videoimage.appearanceDelay > 0L && o.indexOfChild(videoimage.button) == -1)
                        {
                            message = Message.obtain(j, 3, videoimage);
                            l3 = videoimage.appearanceDelay - (long)d;
                            l2 = l3;
                            if (l3 < 0L)
                            {
                                l2 = 500L;
                            }
                            j.sendMessageDelayed(message, l2);
                        } else
                        {
                            l2 = 0L;
                        }
                        if (videoimage.inactivityTimeout > 0L)
                        {
                            message = Message.obtain(j, 1, videoimage);
                            j.sendMessageDelayed(message, l2 + videoimage.inactivityTimeout + videoimage.fadeDuration);
                        }
                        i1++;
                    }
                }
            }
        }
        super.g();
    }

    protected final void h()
    {
        if (k != null)
        {
            if ((a || k.reloadNonEndOverlayOnRestart) && k.webOverlayURL != null && l != null)
            {
                c(k.webOverlayURL);
                a = false;
            }
            ArrayList arraylist = k.buttons;
            j.removeMessages(1);
            j.removeMessages(2);
            j.removeMessages(3);
            p = 0;
            if (!q && o != null && arraylist != null)
            {
                for (int i1 = 0; i1 < arraylist.size(); i1++)
                {
                    VideoImage videoimage = (VideoImage)arraylist.get(i1);
                    if (videoimage == null)
                    {
                        continue;
                    }
                    if (videoimage.appearanceDelay > 0L)
                    {
                        Object obj = videoimage.button;
                        o.removeView(((View) (obj)));
                        obj = Message.obtain(j, 3, videoimage);
                        j.sendMessageDelayed(((Message) (obj)), videoimage.appearanceDelay);
                    }
                    if (videoimage.inactivityTimeout > 0L)
                    {
                        Message message = Message.obtain(j, 1, videoimage);
                        j.sendMessageDelayed(message, videoimage.inactivityTimeout + videoimage.appearanceDelay + videoimage.fadeDuration);
                    }
                }

            }
            if (j != null)
            {
                j.sendMessageDelayed(Message.obtain(j, 2), 1000L);
            }
            if (r)
            {
                o();
            }
        }
        super.h();
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 34
    //                   2 164
    //                   3 53;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        if (j())
        {
            b((VideoImage)message.obj);
            return true;
        }
          goto _L1
_L4:
        message = (VideoImage)message.obj;
        try
        {
            if (o.indexOfChild(((VideoImage) (message)).button) == -1)
            {
                o.addView(((VideoImage) (message)).button, ((VideoImage) (message)).layoutParams);
            }
        }
        catch (IllegalStateException illegalstateexception)
        {
            MMLog.a("CachedVideoPlayerActivity", "Problem adding buttons", illegalstateexception);
        }
        if (!j()) goto _L1; else goto _L5
_L5:
        b(message);
        MMLog.a("CachedVideoPlayerActivity", String.format("Beginning animation to visibility. Fade duration: %d Button: %d Time: %d", new Object[] {
            Long.valueOf(((VideoImage) (message)).fadeDuration), Integer.valueOf(((VideoImage) (message)).button.getId()), Long.valueOf(System.currentTimeMillis())
        }));
        return true;
_L3:
        if (f == null || !f.isPlaying()) goto _L7; else goto _L6
_L6:
        int k1 = f.getCurrentPosition();
        if (k1 <= p) goto _L9; else goto _L8
_L8:
        if (k == null) goto _L11; else goto _L10
_L10:
        if (p == 0)
        {
            k.logBeginEvent();
        }
          goto _L12
_L20:
        int i1;
        if (i1 >= k.activities.size()) goto _L11; else goto _L13
_L13:
        message = (VideoLogEvent)k.activities.get(i1);
        if (message == null) goto _L15; else goto _L14
_L14:
        if (((VideoLogEvent) (message)).position >= (long)p && ((VideoLogEvent) (message)).position < (long)k1)
        {
            int j1 = 0;
            do
            {
                long l1;
                try
                {
                    if (j1 >= ((VideoLogEvent) (message)).activities.length)
                    {
                        break;
                    }
                    MMSDK.Event.a(((VideoLogEvent) (message)).activities[j1]);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    MMLog.a("CachedVideoPlayerActivity", "Error with video check", message);
                    return true;
                }
                j1++;
            } while (true);
        }
          goto _L15
_L11:
        p = k1;
_L9:
        if (q && l != null)
        {
            l.loadUrl((new StringBuilder("javascript:MMJS.cachedVideo.updateVideoSeekTime(")).append((float)Math.floor((float)k1 / 1000F)).append(");").toString());
        }
        if (!r) goto _L7; else goto _L16
_L16:
        l1 = (k.duration - (long)k1) / 1000L;
        if (l1 <= 0L) goto _L18; else goto _L17
_L17:
        if (m != null)
        {
            m.setText(String.valueOf(l1));
        }
_L7:
        j.sendMessageDelayed(Message.obtain(j, 2), 500L);
        return true;
_L18:
        p();
          goto _L7
_L12:
        i1 = 0;
        continue; /* Loop/switch isn't completed */
_L15:
        i1++;
        if (true) goto _L20; else goto _L19
_L19:
    }

    protected final void i()
    {
        super.i();
        if (!q && k != null && k.buttons != null)
        {
            Iterator iterator = k.buttons.iterator();
            while (iterator.hasNext()) 
            {
                VideoImage videoimage = (VideoImage)iterator.next();
                if (videoimage.button != null)
                {
                    videoimage.button.setEnabled(true);
                }
            }
        }
    }

    protected final boolean j()
    {
        return !k.stayInPlayer || !super.j();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
label0:
        {
            super.onCompletion(mediaplayer);
            if (r)
            {
                p();
            }
            if (k != null)
            {
                mediaplayer = k.onCompletionUrl;
                if (mediaplayer != null)
                {
                    b(mediaplayer);
                }
                if (k != null)
                {
                    k.logEndEvent();
                    if (k.stayInPlayer)
                    {
                        break label0;
                    }
                    l();
                }
            }
            return;
        }
        if (!q && k.buttons != null)
        {
            n();
            if (!k.hasEndCard())
            {
                l();
            }
        }
        if (l == null || TextUtils.isEmpty(k.endOverlayURL)) goto _L2; else goto _L1
_L1:
        c(k.endOverlayURL);
        l.bringToFront();
_L4:
        if (k.closeDelayMillis != 0L)
        {
            long l1 = k.closeDelayMillis;
            j.postDelayed(new Runnable() {

                private CachedVideoPlayerActivity a;

                public void run()
                {
                    a.l();
                }

            
            {
                a = CachedVideoPlayerActivity.this;
                super();
            }
            }, l1);
        }
        j.removeMessages(1);
        j.removeMessages(2);
        j.removeMessages(3);
        return;
_L2:
        if (q)
        {
            l();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MMLog.a("CachedVideoPlayerActivity", "Is Cached Ad");
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        a(String.format("Error while playing, %d - %d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1)
        }));
        return super.onError(mediaplayer, i1, j1);
    }

    private class FetchWebViewContentTask extends AsyncTask
    {

        private String a;
        private boolean b;
        private CachedVideoPlayerActivity c;

        private transient String a()
        {
            Object obj;
            StatusLine statusline;
            obj = (new HttpGetRequest()).a(a);
            statusline = ((HttpResponse) (obj)).getStatusLine();
            if (obj == null || statusline == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            if (statusline.getStatusCode() == 404)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            obj = ((HttpResponse) (obj)).getEntity();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            return HttpGetRequest.a(((HttpEntity) (obj)).getContent());
            b = true;
_L2:
            return null;
            Exception exception;
            exception;
            MMLog.a("CachedVideoPlayerActivity", "Error with http web overlay", exception);
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected void onPostExecute(Object obj)
        {
            String s = (String)obj;
            if (b)
            {
                c.l();
            }
            if (s != null && CachedVideoPlayerActivity.a(c) != null)
            {
                MMWebView mmwebview = CachedVideoPlayerActivity.a(c);
                String s1 = a;
                obj = c.b;
                if (s != null && s1 != null)
                {
                    String s2 = s1.substring(0, s1.lastIndexOf("/") + 1);
                    mmwebview.d();
                    if (MRaid.a(((android.content.Context) (obj))))
                    {
                        obj = MRaid.a(((android.content.Context) (obj)), s);
                    } else
                    {
                        MMLog.e("MMWebView", "MMJS is not downloaded");
                        obj = s;
                    }
                    if (MMSDK.a >= 5)
                    {
                        MMLog.a("MMWebView", String.format("Received ad with base url %s.", new Object[] {
                            s1
                        }));
                        MMLog.a("MMWebView", s);
                    }
                    MMSDK.a(new MMWebView._cls2(mmwebview, s2, ((String) (obj))));
                }
                c.a = true;
            }
        }

        public FetchWebViewContentTask(String s)
        {
            c = CachedVideoPlayerActivity.this;
            super();
            a = s;
        }
    }


    private class CachedVideoWebViewClientListener extends MMWebViewClient.MMWebViewClientListener
    {

        private WeakReference a;

        public void onPageFinished(String s)
        {
            MMLog.b("CachedVideoPlayerActivity", (new StringBuilder("@@ ON PAGE FINISHED")).append(s).toString());
            CachedVideoPlayerActivity cachedvideoplayeractivity = (CachedVideoPlayerActivity)a.get();
            if (cachedvideoplayeractivity != null)
            {
                CachedVideoPlayerActivity.a(cachedvideoplayeractivity, s);
            }
        }

        CachedVideoWebViewClientListener()
        {
            a = new WeakReference(CachedVideoPlayerActivity.this);
        }
    }

}
