// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.rendering.mraid:
//            f, b

final class g extends VideoView
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    static class a extends MediaController
    {

        Context a;

        public void show(int i1)
        {
            super.show(i1);
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                break MISSING_BLOCK_LABEL_218;
            }
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            int ai[];
            try
            {
                obj = android/widget/MediaController.getDeclaredField("mAnchor");
                ((Field) (obj)).setAccessible(true);
                obj = (View)((Field) (obj)).get(this);
                obj1 = android/widget/MediaController.getDeclaredField("mDecor");
                ((Field) (obj1)).setAccessible(true);
                obj1 = (View)((Field) (obj1)).get(this);
                obj2 = android/widget/MediaController.getDeclaredField("mDecorLayoutParams");
                ((Field) (obj2)).setAccessible(true);
                obj2 = (android.view.WindowManager.LayoutParams)((Field) (obj2)).get(this);
                obj3 = android/widget/MediaController.getDeclaredField("mWindowManager");
                ((Field) (obj3)).setAccessible(true);
                obj3 = (WindowManager)((Field) (obj3)).get(this);
                ai = new int[2];
                ((View) (obj)).getLocationOnScreen(ai);
                ((View) (obj1)).measure(android.view.View.MeasureSpec.makeMeasureSpec(((View) (obj)).getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(((View) (obj)).getHeight(), 0x80000000));
                ((View) (obj1)).setPadding(0, 0, 0, 0);
                obj2.verticalMargin = 0.0F;
                obj2.horizontalMargin = 0.0F;
                obj2.width = ((View) (obj)).getWidth();
                obj2.gravity = 0x800033;
                obj2.x = ai[0];
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }
            i1 = ai[1];
            obj2.y = (((View) (obj)).getHeight() + i1) - ((View) (obj1)).getMeasuredHeight();
            ((WindowManager) (obj3)).updateViewLayout(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
        }

        public a(Context context)
        {
            super(context);
            a = context;
        }
    }

    static final class b extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            g g1 = (g)a.get();
            if (g1 == null) goto _L2; else goto _L1
_L1:
            message.what;
            JVM INSTR tableswitch 1 1: default 36
        //                       1 42;
               goto _L2 _L3
_L2:
            super.handleMessage(message);
_L5:
            return;
_L3:
            if (d.b != g1.c) goto _L5; else goto _L4
_L4:
            int i1 = Math.round((float)g1.getCurrentPosition() / 1000F);
            int j1 = Math.round((float)g1.getDuration() / 1000F);
            if (g1.i != i1)
            {
                g1.a(i1, j1);
                g1.i = i1;
                g1.j = i1;
            }
            sendEmptyMessageDelayed(1, 1000L);
            if (true) goto _L2; else goto _L6
_L6:
        }

        public b(g g1)
        {
            a = new WeakReference(g1);
        }
    }

    static interface c
    {

        public abstract void a(g g1);

        public abstract void b(g g1);
    }

    static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        private static final d h[];

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/inmobi/rendering/mraid/g$d, s1);
        }

        public static d[] values()
        {
            return (d[])h.clone();
        }

        static 
        {
            a = new d("INITIALIZED", 0);
            b = new d("PLAYING", 1);
            c = new d("PAUSED", 2);
            d = new d("HIDDEN", 3);
            e = new d("SHOWING", 4);
            f = new d("COMPLETED", 5);
            g = new d("RELEASED", 6);
            h = (new d[] {
                a, b, c, d, e, f, g
            });
        }

        private d(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    final class e extends BroadcastReceiver
    {

        final g a;
        private final String b = com/inmobi/rendering/mraid/g$e.getSimpleName();

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null)
            {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Screen OFF");
                    if (d.b == a.c)
                    {
                        com.inmobi.rendering.mraid.g.a(a, true);
                        a.pause();
                    }
                } else
                if ("android.intent.action.SCREEN_ON".equals(intent.getAction()))
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Screen ON");
                    if (com.inmobi.rendering.mraid.g.a(a) && d.c == a.c)
                    {
                        com.inmobi.rendering.mraid.g.a(a, false);
                        a.a();
                        return;
                    }
                }
            }
        }

        e()
        {
            a = g.this;
            super();
        }
    }


    private static final String k = com/inmobi/rendering/mraid/g.getSimpleName();
    int a;
    boolean b;
    d c;
    com.inmobi.rendering.mraid.b d;
    f e;
    String f;
    String g;
    boolean h;
    int i;
    int j;
    private MediaPlayer l;
    private a m;
    private RenderView n;
    private Bitmap o;
    private ViewGroup p;
    private c q;
    private b r;
    private e s;
    private String t;
    private boolean u;
    private boolean v;

    public g(Context context, RenderView renderview)
    {
        super(context);
        n = renderview;
        setZOrderOnTop(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDrawingCacheEnabled(true);
        a = 100;
        i = -1;
        j = 0;
        c = com.inmobi.rendering.mraid.d.a;
        u = false;
        b = false;
        v = false;
    }

    static a a(g g1, a a1)
    {
        g1.m = a1;
        return a1;
    }

    private String a(byte byte0)
    {
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        return new String(new char[] {
            ac[byte0 >> 4 & 0xf], ac[byte0 & 0xf]
        });
    }

    static boolean a(g g1)
    {
        return g1.v;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.v = flag;
        return flag;
    }

    static a b(g g1)
    {
        return g1.m;
    }

    private String b(String s1)
    {
        s1 = s1.getBytes();
        StringBuilder stringbuilder = new StringBuilder();
        int j1 = s1.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            byte byte0 = s1[i1];
            if ((byte0 & 0x80) > 0)
            {
                stringbuilder.append("%").append(a(byte0));
            } else
            {
                stringbuilder.append((char)byte0);
            }
            i1++;
        }
        try
        {
            s1 = new String(stringbuilder.toString().getBytes(), "ISO-8859-1");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return "";
        }
        return s1;
    }

    private Bitmap c(String s1)
    {
        try
        {
            s1 = (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[] {
                java/lang/String, Integer.TYPE
            }).invoke(null, new Object[] {
                s1, Integer.valueOf(1)
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        return s1;
    }

    static String i()
    {
        return k;
    }

    private void j()
    {
        if (p != null)
        {
            ViewGroup viewgroup = (ViewGroup)p.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(p);
            }
            viewgroup = (ViewGroup)getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(this);
            }
            setBackgroundColor(0);
            p = null;
        }
    }

    private boolean k()
    {
        return d.c == c || d.d == c;
    }

    public void a()
    {
        setVideoPath(g);
        setOnCompletionListener(this);
        setOnPreparedListener(this);
        setOnErrorListener(this);
        if (m == null && e.e && android.os.Build.VERSION.SDK_INT >= 19)
        {
            m = new a(getContext());
            m.setAnchorView(this);
            setMediaController(m);
        }
        if (s == null)
        {
            s = new e();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            intentfilter.addAction("android.intent.action.SCREEN_ON");
            com.inmobi.commons.a.a.b().registerReceiver(s, intentfilter);
        }
    }

    public void a(int i1)
    {
        if (i1 < getDuration())
        {
            j = i1;
            seekTo(i1);
        }
    }

    void a(int i1, int j1)
    {
        if (n != null)
        {
            String s1 = (new StringBuilder()).append("fireMediaTimeUpdateEvent('").append(e.a).append("',").append(i1).append(",").append(j1).append(");").toString();
            n.a(t, s1);
        }
    }

    public void a(ViewGroup viewgroup)
    {
        p = viewgroup;
    }

    public void a(c c1)
    {
        q = c1;
    }

    void a(String s1)
    {
        if (n != null)
        {
            s1 = (new StringBuilder()).append("fireMediaTrackingEvent('").append(s1).append("','").append(e.a).append("');").toString();
            n.a(t, s1);
        }
    }

    public void a(String s1, String s2, f f1, com.inmobi.rendering.mraid.b b1)
    {
        t = s1;
        r = new b(this);
        g = b(s2.trim());
        e = f1;
        f = f1.a;
        d = b1;
        if (o == null)
        {
            o = Bitmap.createBitmap(24, 24, android.graphics.Bitmap.Config.ARGB_8888);
            o = c(g);
        }
    }

    public void a(boolean flag)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append("Media render view state: ").append(c).toString());
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, "Release the media render view");
        if (s != null)
        {
            com.inmobi.commons.a.a.b().unregisterReceiver(s);
            s = null;
        }
        c = d.g;
        int i1;
        if (i != -1)
        {
            i1 = i;
        } else
        {
            i1 = Math.round(getCurrentPosition() / 1000);
        }
        a(flag, i1);
        stopPlayback();
        r.removeMessages(1);
        j();
        super.setMediaController(null);
        m = null;
        if (q != null)
        {
            q.a(this);
        }
    }

    void a(boolean flag, int i1)
    {
        if (n != null)
        {
            String s1 = (new StringBuilder()).append("fireMediaCloseEvent('").append(e.a).append("',").append(flag).append(",").append(i1).append(");").toString();
            n.a(t, s1);
        }
    }

    public void b()
    {
        if (d.e != c)
        {
            p.setVisibility(0);
            setVisibility(0);
            requestFocus();
            c = d.e;
            a("showing");
        }
    }

    public void b(int i1)
    {
        boolean flag;
label0:
        {
            flag = false;
            if (l != null && (b || i1 != a))
            {
                if (!b || i1 != 0)
                {
                    break label0;
                }
                a = 0;
            }
            return;
        }
        if (i1 == 0)
        {
            flag = true;
        }
        b = flag;
        a = i1;
        float f1 = 1.0F - (float)(Math.log(101 - i1) / Math.log(101D));
        l.setVolume(f1, f1);
        h();
    }

    public void c()
    {
        if (d.d != c)
        {
            setVisibility(4);
            p.setVisibility(4);
            c = d.d;
            a("hidden");
        }
    }

    void c(int i1)
    {
        if (n != null)
        {
            String s1 = (new StringBuilder()).append("fireMediaErrorEvent('").append(e.a).append("',").append(i1).append(");").toString();
            n.a(t, s1);
        }
    }

    public void d()
    {
        if (l != null && !b)
        {
            b = true;
            l.setVolume(0.0F, 0.0F);
            h();
        }
    }

    public void e()
    {
        if (l != null && b)
        {
            b(a);
        }
    }

    public ViewGroup f()
    {
        return p;
    }

    void g()
    {
        if (d.e != c) goto _L2; else goto _L1
_L1:
        d d1;
        if (u)
        {
            d1 = d.f;
        } else
        {
            d1 = d.c;
        }
        c = d1;
        if (!h) goto _L4; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT >= 21) goto _L6; else goto _L5
_L5:
        super.start();
        try
        {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedexception) { }
        super.pause();
_L4:
        return;
_L6:
        super.start();
        super.pause();
        return;
_L2:
        if (com.inmobi.rendering.mraid.d.a == c)
        {
            if (e.g)
            {
                d();
            }
            if (e.d)
            {
                start();
                return;
            }
            if (h)
            {
                if (android.os.Build.VERSION.SDK_INT < 21)
                {
                    super.start();
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException interruptedexception1) { }
                    super.pause();
                    return;
                } else
                {
                    super.start();
                    super.pause();
                    return;
                }
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    void h()
    {
        int i1;
        if (b)
        {
            i1 = 0;
        } else
        {
            i1 = a;
        }
        if (n != null)
        {
            String s1 = (new StringBuilder()).append("fireMediaVolumeChangeEvent('").append(e.a).append("',").append(i1).append(",").append(b).append(");").toString();
            n.a(t, s1);
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, ">>> onCompletion");
        c = d.f;
        u = true;
        a("ended");
        r.removeMessages(1);
        if (!e.f)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        this;
        JVM INSTR monitorenter ;
        if (!k())
        {
            j = 0;
            start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        mediaplayer;
        this;
        JVM INSTR monitorexit ;
        throw mediaplayer;
        if (e.b())
        {
            a(false);
        }
        return;
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append(">>> onError (").append(i1).append(", ").append(j1).append(")").toString());
        a(false);
        j1 = -1;
        if (100 == i1)
        {
            j1 = 2;
        }
        c(j1);
        return false;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        getHolder().setSizeFromLayout();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, ">>> onPrepared");
        mediaplayer.setOnVideoSizeChangedListener(new android.media.MediaPlayer.OnVideoSizeChangedListener() {

            final g a;

            public void onVideoSizeChanged(MediaPlayer mediaplayer1, int i1, int j1)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, g.i(), ">>> onVideoSizeChanged");
                if (g.b(a) == null && a.e.e)
                {
                    com.inmobi.rendering.mraid.g.a(a, new a(a.getContext()));
                    g.b(a).setAnchorView(a);
                    a.setMediaController(g.b(a));
                    a.requestLayout();
                    a.requestFocus();
                }
            }

            
            {
                a = g.this;
                super();
            }
        });
        l = mediaplayer;
        a(j * 1000);
        h = true;
        q.b(this);
        g();
    }

    protected void onVisibilityChanged(View view, int i1)
    {
label0:
        {
            super.onVisibilityChanged(view, i1);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append(">>> onVisibilityChanged (").append(i1).append(")").toString());
            if (i1 == 0)
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    break label0;
                }
                setBackground(new BitmapDrawable(com.inmobi.commons.a.a.b().getResources(), o));
            }
            return;
        }
        setBackgroundDrawable(new BitmapDrawable(o));
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append(">>> onWindowVisibilityChanged (").append(i1).append(")").toString());
    }

    public void pause()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append("Media render view state: ").append(c).toString());
        if (d.c == c)
        {
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, "Pause media playback");
            r.removeMessages(1);
            super.pause();
            c = d.c;
            a("pause");
            return;
        }
    }

    public void start()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, (new StringBuilder()).append("Media render view state: ").append(c).toString());
        if (d.b == c)
        {
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, k, "Start media playback");
        a(j * 1000);
        c = d.b;
        super.start();
        if (h)
        {
            a("play");
        }
        r.sendEmptyMessage(1);
    }

}
