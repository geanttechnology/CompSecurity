// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            ak, ac, al, VideoAd, 
//            au

final class y extends VideoView
    implements Serializable
{
    static final class a
    {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        String g;
        String h;
        String i;
        String j;
        boolean k;
        boolean l;
        float m;
        boolean n;
        int o;
        a p;
        b q;

        public final String a()
        {
            Object obj;
            try
            {
                obj = new JSONObject();
                ((JSONObject) (obj)).put("x", a);
                ((JSONObject) (obj)).put("expanded", n);
                ((JSONObject) (obj)).put("y", b);
                ((JSONObject) (obj)).put("bodyWidth", c);
                ((JSONObject) (obj)).put("bodyHeight", d);
                ((JSONObject) (obj)).put("width", e);
                ((JSONObject) (obj)).put("height", f);
                ((JSONObject) (obj)).put("currentPosition", o);
                ((JSONObject) (obj)).put("playerState", p.ordinal());
                ((JSONObject) (obj)).put("videoState", q.ordinal());
                ((JSONObject) (obj)).put("streamVideoURI", g);
                ((JSONObject) (obj)).put("cachedVideoURI", h);
                ((JSONObject) (obj)).put("cachedVideoID", i);
                ((JSONObject) (obj)).put("touchCallBack", j);
                ((JSONObject) (obj)).put("autoPlay", k);
                ((JSONObject) (obj)).put("showControls", l);
                ((JSONObject) (obj)).put("scaleFactor", m);
                obj = ((JSONObject) (obj)).toString();
            }
            catch (JSONException jsonexception)
            {
                al.a("InlineVideoView", "Error converting InlineParams to json string", jsonexception);
                return null;
            }
            return ((String) (obj));
        }

        public final String toString()
        {
            return String.format(Locale.ENGLISH, "cached video id: %s, x: %d, y: %d, body width: %d, body height: %d, current position: %d, auto play: %b, player state: %d, video state: %d", new Object[] {
                i, Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(o), Boolean.valueOf(k), Integer.valueOf(p.ordinal()), Integer.valueOf(q.ordinal())
            });
        }

        public a(String s)
        {
            p = a.a;
            q = b.a;
            try
            {
                s = new JSONObject(s);
                a = au.a(s, "x");
                b = au.a(s, "y");
                c = au.a(s, "bodyWidth");
                d = au.a(s, "bodyHeight");
                e = au.a(s, "width");
                f = au.a(s, "height");
                n = au.c(s, "expanded");
                o = au.a(s, "currentPosition");
                int i1 = au.a(s, "playerState");
                p = a.values()[i1];
                i1 = au.a(s, "videoState");
                q = b.values()[i1];
                g = au.a(s, "streamVideoURI", "");
                h = au.a(s, "cachedVideoURI", "");
                i = au.a(s, "cachedVideoID", "");
                j = au.a(s, "touchCallBack", "");
                k = au.c(s, "autoPlay");
                l = au.c(s, "showControls");
                m = (float)au.b(s, "scaleFactor");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                al.a("InlineVideoView", "Error creating inline param object", s);
            }
        }

        a(Map map, Context context)
        {
            p = a.a;
            q = b.a;
            if (map.get("x") != null)
            {
                a = (int)Float.parseFloat((String)map.get("x"));
            }
            if (map.get("y") != null)
            {
                b = (int)Float.parseFloat((String)map.get("y"));
            }
            if (map.get("width") != null)
            {
                e = (int)Float.parseFloat((String)map.get("width"));
            }
            if (map.get("height") != null)
            {
                f = (int)Float.parseFloat((String)map.get("height"));
            }
            g = (String)map.get("streamVideoURI");
            h = (String)map.get("cachedVideoURI");
            i = (String)map.get("cachedVideoID");
            if (map.get("autoPlay") != null)
            {
                k = Boolean.parseBoolean((String)map.get("autoPlay"));
            }
            if (map.get("showControls") != null)
            {
                l = Boolean.parseBoolean((String)map.get("showControls"));
            }
            if (map.get("bodyWidth") != null)
            {
                c = (int)Float.parseFloat((String)map.get("bodyWidth"));
            }
            if (map.get("bodyHeight") != null)
            {
                d = (int)Float.parseFloat((String)map.get("bodyHeight"));
            }
            j = (String)map.get("touchCallback");
            m = context.getResources().getDisplayMetrics().density;
        }
    }

    static final class a.a extends Enum
    {

        public static final a.a a;
        public static final a.a b;
        public static final a.a c;
        public static final a.a d;
        public static final a.a e;
        private static final a.a f[];

        public static a.a valueOf(String s)
        {
            return (a.a)Enum.valueOf(com/millennialmedia/android/y$a$a, s);
        }

        public static a.a[] values()
        {
            return (a.a[])f.clone();
        }

        static 
        {
            a = new a.a("DEFAULT", 0);
            b = new a.a("STOP", 1);
            c = new a.a("PLAY", 2);
            d = new a.a("PAUSE", 3);
            e = new a.a("RESUME", 4);
            f = (new a.a[] {
                a, b, c, d, e
            });
        }

        private a.a(String s, int i1)
        {
            super(s, i1);
        }
    }

    static final class a.b extends Enum
    {

        public static final a.b a;
        public static final a.b b;
        public static final a.b c;
        private static final a.b d[];

        public static a.b valueOf(String s)
        {
            return (a.b)Enum.valueOf(com/millennialmedia/android/y$a$b, s);
        }

        public static a.b[] values()
        {
            return (a.b[])d.clone();
        }

        static 
        {
            a = new a.b("DEFAULT", 0);
            b = new a.b("PREPARING", 1);
            c = new a.b("PREPARED", 2);
            d = (new a.b[] {
                a, b, c
            });
        }

        private a.b(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static final class b extends MediaController
    {

        private WeakReference a;
        private BitmapDrawable b;
        private BitmapDrawable c;

        static WeakReference a(b b1)
        {
            return b1.a;
        }

        public final void setAnchorView(View view)
        {
            super.setAnchorView(view);
            if (c != null && b != null) goto _L2; else goto _L1
_L1:
            al.a("InlineVideoView", "Not adding collapse / expand button to media controls overlay, no drawables available");
_L4:
            return;
_L2:
            y y1;
            view = new Button(getContext());
            y1 = (y)a.get();
            if (y1 == null) goto _L4; else goto _L3
_L3:
            if (!y.a(y1).n || c == null) goto _L6; else goto _L5
_L5:
            view.setBackgroundDrawable(c);
_L8:
            view.setOnClickListener(new android.view.View.OnClickListener(this) {

                final b a;

                public final void onClick(View view)
                {
                    view = (y)b.a(a).get();
                    if (view == null)
                    {
                        return;
                    }
                    a a1 = y.a(view);
                    boolean flag;
                    if (!y.a(view).n)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    a1.n = flag;
                    y.b(view);
                }

            
            {
                a = b1;
                super();
            }
            });
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2, 5);
            layoutparams.setMargins(0, 20, 10, 0);
            addView(view, layoutparams);
            return;
_L6:
            if (b != null)
            {
                view.setBackgroundDrawable(b);
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

        public b(y y1)
        {
            super(y1.getContext());
            a = new WeakReference(y1);
            try
            {
                b = au.a(y1.getContext(), "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC");
                c = au.a(y1.getContext(), "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (y y1)
            {
                al.a("InlineVideoView", "Unable to load collaps and expand drawables for media controls overlay", y1);
            }
        }
    }

    private static final class c
        implements Runnable
    {

        WeakReference a;
        Double b;
        boolean c;

        public final void run()
        {
            Object obj;
            y y1;
            if (!c)
            {
                (new StringBuilder("Reporting disabled, shutting down seek reporting runnable <")).append(this).append(">");
                al.b();
                return;
            }
            y1 = (y)a.get();
            if (y1 == null)
            {
                al.a("InlineVideoView", (new StringBuilder("Video view instance is null, shutting down seek reporting runnable <")).append(this).append(">").toString());
                return;
            }
            obj = null;
            if (!y1.isPlaying()) goto _L2; else goto _L1
_L1:
            double d1 = Math.floor((float)y1.getCurrentPosition() / 1000F);
            obj = Double.valueOf(d1);
_L4:
            if (obj == null)
            {
                (new StringBuilder("No valid seek time found, shutting down seek reporting runnable <")).append(this).append(">");
                al.b();
                return;
            }
            break MISSING_BLOCK_LABEL_188;
_L2:
            if (!y1.e) goto _L4; else goto _L3
_L3:
            d1 = Math.ceil((float)y1.g / 1000F);
            obj = Double.valueOf(d1);
              goto _L4
            obj;
            al.a("InlineVideoView", (new StringBuilder("Illegal exception encountered when trying to get play state, shutting down seek reporting runnable <")).append(this).append(">").toString());
            return;
            if (!y1.i)
            {
                if (y.c(y1) && y.d(y1))
                {
                    y.e(y1);
                } else
                if (!y.c(y1))
                {
                    y.e(y1);
                }
            }
            if (b == null || Double.compare(((Double) (obj)).doubleValue(), b.doubleValue()) != 0)
            {
                ak ak1 = (ak)y.f(y1).get();
                if (ak1 == null)
                {
                    al.a("InlineVideoView", (new StringBuilder("Unable to send video seek time, no valid layout.  Shutting down seek reporting runnable <")).append(this).append(">").toString());
                    return;
                }
                ak1.a((new StringBuilder("javascript:MMJS.inlineVideo.updateVideoSeekTime(")).append(obj).append(");").toString());
                b = ((Double) (obj));
            }
            y.g(y1).postDelayed(this, 1000L);
            return;
        }

        c(y y1)
        {
            b = null;
            c = true;
            if (y1 == null)
            {
                al.a("InlineVideoView", "Created seek reporting runnable with a null video view instance");
            }
            a = new WeakReference(y1);
        }
    }


    private static WeakReference j = new WeakReference(null);
    a a;
    WeakReference b;
    RelativeLayout c;
    ProgressBar d;
    boolean e;
    boolean f;
    int g;
    boolean h;
    boolean i;
    private Handler k;
    private b l;
    private boolean m;
    private boolean n;

    public y(ak ak1, a a1)
    {
        super(ak1.getContext());
        m = false;
        n = false;
        c = null;
        e = false;
        h = false;
        i = false;
        ak1.getContext();
        ac.c();
        b = new WeakReference(ak1);
        a = a1;
        k = new Handler(Looper.getMainLooper());
        setId(0x86c5ad);
        setFocusable(true);
        setClickable(true);
        if (a.l)
        {
            l = new b(this);
            setMediaController(l);
        }
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            m = true;
        }
        setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

            final y a;

            public final void onPrepared(MediaPlayer mediaplayer)
            {
                if (y.c(a))
                {
                    mediaplayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener(this) {

                        final _cls1 a;

                        public final boolean onInfo(MediaPlayer mediaplayer, int i1, int j1)
                        {
                            if (i1 == 3)
                            {
                                y.h(a.a);
                            }
                            return false;
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
                y.a(a).q = a.b.c;
                if (y.a(a).k && y.a(a).p == a.a.a)
                {
                    y.a(a).p = a.a.c;
                }
                a.d.setVisibility(8);
                a.g = a.getDuration();
                a.seekTo(y.a(a).o);
                y.i(a);
            }

            
            {
                a = y.this;
                super();
            }
        });
        setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final y a;

            public final void onCompletion(MediaPlayer mediaplayer)
            {
                a.pause();
                a.seekTo(0);
                a.e = true;
            }

            
            {
                a = y.this;
                super();
            }
        });
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final y a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    view = (ak)y.f(a).get();
                    if (view == null)
                    {
                        al.a("InlineVideoView", "Unable to handle touch event, MMLayout weak reference broken");
                        return false;
                    }
                    if (!TextUtils.isEmpty(y.a(a).j))
                    {
                        view.a(String.format((new StringBuilder("javascript:")).append(y.a(a).j).append("(%f,%f)").toString(), new Object[] {
                            Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
                        }));
                    }
                    if (y.j(a) != null && !y.j(a).isShowing())
                    {
                        y.j(a).show();
                        return true;
                    }
                }
                return true;
            }

            
            {
                a = y.this;
                super();
            }
        });
        setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final y a;

            public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                mediaplayer = (ak)y.f(a).get();
                if (mediaplayer == null)
                {
                    al.a("InlineVideoView", "Unable to handle error, MMLayout weak reference broken");
                    return true;
                } else
                {
                    mediaplayer.a((new StringBuilder("javascript:MMJS.setError(")).append(String.format("Error while playing, %d - %d", new Object[] {
                        Integer.valueOf(i1), Integer.valueOf(j1)
                    })).append(");").toString());
                    return true;
                }
            }

            
            {
                a = y.this;
                super();
            }
        });
        c = new RelativeLayout(getContext());
        c.setBackgroundColor(0xff000000);
        c.setOnTouchListener(new android.view.View.OnTouchListener() {

            final y a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = y.this;
                super();
            }
        });
        ak1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ak1.addRule(13, -1);
        c.addView(this, ak1);
        d = new ProgressBar(((ak)b.get()).getContext());
        d.setIndeterminate(true);
        d.setVisibility(8);
        ak1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ak1.addRule(13, -1);
        c.addView(d, ak1);
        g();
    }

    static a a(y y1)
    {
        return y1.a;
    }

    static void b(y y1)
    {
        y1.d();
    }

    static boolean c(y y1)
    {
        return y1.m;
    }

    private void d()
    {
        f();
        c.setLayoutParams(a());
        b();
    }

    static boolean d(y y1)
    {
        return y1.n;
    }

    private void e()
    {
        setBackgroundColor(0xff000000);
        i = false;
    }

    static void e(y y1)
    {
        y1.setBackgroundColor(0);
        y1.i = true;
    }

    static WeakReference f(y y1)
    {
        return y1.b;
    }

    private void f()
    {
        if (!isPlaying())
        {
            al.d();
            return;
        } else
        {
            super.pause();
            return;
        }
    }

    static Handler g(y y1)
    {
        return y1.k;
    }

    private void g()
    {
        if (!TextUtils.isEmpty(a.h))
        {
            au.c.a(new Runnable() {

                final y a;

                public final void run()
                {
                    a.getContext();
                    VideoAd.a(y.a(a).h, y.a(a).i);
                }

            
            {
                a = y.this;
                super();
            }
            });
        }
        if (TextUtils.isEmpty(a.i)) goto _L2; else goto _L1
_L1:
        getContext();
        if (!VideoAd.b(a.i)) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L9:
        if (!flag) goto _L5; else goto _L4
_L4:
        Uri uri;
        f = false;
        getContext();
        uri = VideoAd.c(a.i);
_L7:
        e();
        d.setVisibility(0);
        a.q = a.b.b;
        setVideoURI(uri);
        return;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if (TextUtils.isEmpty(a.g))
        {
            break; /* Loop/switch isn't completed */
        }
        f = true;
        uri = Uri.parse(a.g);
        if (true) goto _L7; else goto _L6
_L6:
        al.a("InlineVideoView", "Unable to set video source, no valid video source found");
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static void h()
    {
        c c1 = (c)j.get();
        if (c1 != null)
        {
            c1.c = false;
        }
    }

    static boolean h(y y1)
    {
        y1.n = true;
        return true;
    }

    static void i(y y1)
    {
        y1.b();
    }

    static b j(y y1)
    {
        return y1.l;
    }

    final android.widget.RelativeLayout.LayoutParams a()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (a.n)
        {
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else
        {
            layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(a.m * (float)a.e), (int)(a.m * (float)a.f));
            layoutparams.topMargin = (int)(a.m * (float)a.b);
            layoutparams.leftMargin = (int)(a.m * (float)a.a);
        }
        (new StringBuilder("Layout params for video view: ")).append(layoutparams.toString());
        al.b();
        return layoutparams;
    }

    final void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        a.a = a1.a;
        a.b = a1.b;
        a.e = a1.e;
        a.f = a1.f;
        if (c != null) goto _L2; else goto _L1
_L1:
        al.d();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d();
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw a1;
    }

    final void a(String s)
    {
        if (isPlaying())
        {
            c();
        }
        a.i = "";
        a.h = "";
        a.g = s;
        a.o = 0;
        g();
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isPlaying()) goto _L2; else goto _L1
_L1:
        al.d();
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!h)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        al.d();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        if (a.q != a.b.c) goto _L5; else goto _L4
_L4:
        if (a.p == a.a.c)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        al.d();
          goto _L3
        e = false;
        h();
        c c1 = new c(this);
        j = new WeakReference(c1);
        k.postDelayed(c1, 1000L);
        super.start();
          goto _L3
_L5:
        if (a.q != a.b.a) goto _L3; else goto _L6
_L6:
        g();
          goto _L3
    }

    final void c()
    {
        super.stopPlayback();
        e();
        a.q = a.b.a;
        h();
        if (m)
        {
            n = false;
        }
    }

    public final void pause()
    {
        a.p = a.a.d;
        f();
    }

    public final void start()
    {
        a.p = a.a.c;
        b();
    }

    public final void stopPlayback()
    {
        a.p = a.a.b;
        a.o = 0;
        c();
    }

}
