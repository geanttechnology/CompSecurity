// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.inmobi.rendering.mraid:
//            f, b, g

public final class MraidMediaProcessor
{
    public final class HeadphonesPluggedChangeReceiver extends BroadcastReceiver
    {

        final MraidMediaProcessor a;
        private String b;

        public void onReceive(Context context, Intent intent)
        {
            boolean flag = true;
            if (intent != null && "android.intent.action.HEADSET_PLUG".equals(intent.getAction()))
            {
                int l = intent.getIntExtra("state", 0);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.j(), (new StringBuilder()).append("Headphone plugged state changed: ").append(l).toString());
                context = a;
                intent = b;
                if (1 != l)
                {
                    flag = false;
                }
                MraidMediaProcessor.b(context, intent, flag);
            }
        }

        public HeadphonesPluggedChangeReceiver(String s)
        {
            a = MraidMediaProcessor.this;
            super();
            b = s;
        }
    }

    public static final class MediaContentType extends Enum
    {

        private static final MediaContentType $VALUES[];
        public static final MediaContentType MEDIA_CONTENT_TYPE_AUDIO;
        public static final MediaContentType MEDIA_CONTENT_TYPE_AUDIO_VIDEO;

        public static MediaContentType valueOf(String s)
        {
            return (MediaContentType)Enum.valueOf(com/inmobi/rendering/mraid/MraidMediaProcessor$MediaContentType, s);
        }

        public static MediaContentType[] values()
        {
            return (MediaContentType[])$VALUES.clone();
        }

        static 
        {
            MEDIA_CONTENT_TYPE_AUDIO = new MediaContentType("MEDIA_CONTENT_TYPE_AUDIO", 0);
            MEDIA_CONTENT_TYPE_AUDIO_VIDEO = new MediaContentType("MEDIA_CONTENT_TYPE_AUDIO_VIDEO", 1);
            $VALUES = (new MediaContentType[] {
                MEDIA_CONTENT_TYPE_AUDIO, MEDIA_CONTENT_TYPE_AUDIO_VIDEO
            });
        }

        private MediaContentType(String s, int l)
        {
            super(s, l);
        }
    }

    public final class RingerModeChangeReceiver extends BroadcastReceiver
    {

        final MraidMediaProcessor a;
        private String b;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && "android.media.RINGER_MODE_CHANGED".equals(intent.getAction()))
            {
                int l = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.j(), (new StringBuilder()).append("Ringer mode action changed: ").append(l).toString());
                context = a;
                intent = b;
                boolean flag;
                if (2 != l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.inmobi.rendering.mraid.MraidMediaProcessor.a(context, intent, flag);
            }
        }

        public RingerModeChangeReceiver(String s)
        {
            a = MraidMediaProcessor.this;
            super();
            b = s;
        }
    }

    public static final class a
    {

        private static final String a = com/inmobi/rendering/mraid/MraidMediaProcessor$a.getSimpleName();
        private static final int b[] = {
            8000, 11025, 22050, 44100
        };
        private static double f = 4.9406564584124654E-324D;
        private HandlerThread c;
        private b d;
        private AudioRecord e;
        private List g;
        private boolean h;

        public static double a()
        {
            return f;
        }

        static void a(a a1)
        {
            a1.e();
        }

        private void b()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Start sampling audio levels ...");
            c = new HandlerThread("audioSampler");
            c.start();
            d = new b(c.getLooper(), this);
            e = d();
            Message message = Message.obtain();
            message.what = 1;
            d.sendMessage(message);
        }

        private void c()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Stop sampling audio levels ...");
            if (e != null)
            {
                if (h)
                {
                    h = false;
                }
                d.removeMessages(1);
                try
                {
                    e.stop();
                    e.release();
                }
                catch (IllegalStateException illegalstateexception)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Invalid recorder state: ").append(illegalstateexception.getMessage()).toString());
                }
                c.getLooper().quit();
                c.interrupt();
                c = null;
            }
        }

        private AudioRecord d()
        {
            int ai[] = b;
            int k1 = ai.length;
            for (int l = 0; l < k1; l++)
            {
                int l1 = ai[l];
                short aword0[] = new short[2];
                short[] _tmp = aword0;
                aword0[0] = 3;
                aword0[1] = 2;
                int i2 = aword0.length;
                for (int i1 = 0; i1 < i2; i1++)
                {
                    short word0 = aword0[i1];
                    short aword1[] = new short[2];
                    short[] _tmp1 = aword1;
                    aword1[0] = 16;
                    aword1[1] = 12;
                    int j2 = aword1.length;
                    for (int j1 = 0; j1 < j2; j1++)
                    {
                        short word1 = aword1[j1];
                        int k2 = AudioRecord.getMinBufferSize(l1, word1, word0);
                        if (k2 == -2)
                        {
                            continue;
                        }
                        AudioRecord audiorecord = new AudioRecord(0, l1, word1, word0, k2);
                        if (audiorecord.getState() == 1)
                        {
                            return audiorecord;
                        }
                    }

                }

            }

            return null;
        }

        private void e()
        {
            if (e != null && 1 == e.getState())
            {
                short aword0[] = new short[512];
                float af[] = new float[3];
                h = true;
                e.startRecording();
                int i1 = e.read(aword0, 0, aword0.length);
                int l = 0;
                float f1;
                float f2;
                for (f1 = 0.0F; l < i1; f1 = f2)
                {
                    short word0 = (short)(aword0[l] | aword0[l + 1]);
                    f2 = f1;
                    if (word0 != 0)
                    {
                        f2 = f1 + (float)(Math.abs(word0) / i1);
                    }
                    l += 2;
                }

                af[0] = f1;
                l = 0;
                f1 = 0.0F;
                for (; l < 3; l++)
                {
                    f1 += af[l];
                }

                f = f1 / (float)i1 / 32F;
                Iterator iterator = g.iterator();
                while (iterator.hasNext()) 
                {
                    a a1 = (a)iterator.next();
                    if (a1 != null)
                    {
                        a1.a(f);
                    }
                }
            }
        }

        public void a(a a1)
        {
            g.add(a1);
            if (1 == g.size())
            {
                b();
            }
        }

        public void b(a a1)
        {
            g.remove(a1);
            if (g.size() == 0)
            {
                c();
            }
        }


        public a()
        {
            g = new ArrayList();
        }
    }

    public static interface a.a
    {

        public abstract void a(double d1);
    }

    static final class a.b extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                super.handleMessage(message);
                return;

            case 1: // '\001'
                message = (a)a.get();
                break;
            }
            if (message != null)
            {
                com.inmobi.rendering.mraid.a.a(message);
            }
            message = Message.obtain();
            message.what = 1;
            sendMessageDelayed(message, 1000L);
        }

        public a.b(Looper looper, a a1)
        {
            super(looper);
            a = new WeakReference(a1);
        }
    }

    public final class b extends ContentObserver
    {

        final MraidMediaProcessor a;
        private Context b;
        private int c;
        private String d;

        public void onChange(boolean flag)
        {
            super.onChange(flag);
            if (b != null)
            {
                int l = ((AudioManager)b.getSystemService("audio")).getStreamVolume(3);
                if (l != c)
                {
                    c = l;
                    com.inmobi.rendering.mraid.MraidMediaProcessor.a(a, d, l);
                }
            }
        }

        public b(String s, Context context, Handler handler)
        {
            a = MraidMediaProcessor.this;
            super(handler);
            d = s;
            b = context;
            c = -1;
        }
    }


    private static final String a = com/inmobi/rendering/mraid/MraidMediaProcessor.getSimpleName();
    private RenderView b;
    private g c;
    private a d;
    private RingerModeChangeReceiver e;
    private b f;
    private HeadphonesPluggedChangeReceiver g;
    private f h;
    private com.inmobi.rendering.mraid.b i;
    private boolean j;
    private Hashtable k;

    public MraidMediaProcessor(RenderView renderview)
    {
        k = new Hashtable();
        b = renderview;
        d = new a();
        h = new f();
        i = new com.inmobi.rendering.mraid.b();
        j = false;
    }

    static g a(MraidMediaProcessor mraidmediaprocessor)
    {
        return mraidmediaprocessor.c;
    }

    static g a(MraidMediaProcessor mraidmediaprocessor, g g1)
    {
        mraidmediaprocessor.c = g1;
        return g1;
    }

    static void a(MraidMediaProcessor mraidmediaprocessor, String s, int l)
    {
        mraidmediaprocessor.a(s, l);
    }

    static void a(MraidMediaProcessor mraidmediaprocessor, String s, boolean flag)
    {
        mraidmediaprocessor.a(s, flag);
    }

    private void a(String s, int l)
    {
        if (b != null)
        {
            b.a(s, (new StringBuilder()).append("fireDeviceVolumeChangeEvent(").append(l).append(");").toString());
        }
    }

    private void a(String s, boolean flag)
    {
        if (b != null)
        {
            b.a(s, (new StringBuilder()).append("fireDeviceMuteChangeEvent(").append(flag).append(");").toString());
        }
    }

    private boolean a(String s, String s1, String s2, MediaContentType mediacontenttype, Activity activity)
    {
        if (s1.length() != 0 && !URLUtil.isValidUrl(s1) || s1.length() == 0 && !k.containsKey(s2))
        {
            activity = b;
            s2 = (new StringBuilder()).append("Invalid ID (").append(s2).append("); no playback URL for this ID").toString();
            if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediacontenttype)
            {
                s1 = "playVideo";
            } else
            {
                s1 = "playAudio";
            }
            activity.a(s, s2, s1);
            return false;
        }
        if (k.size() == 5)
        {
            s2 = b;
            if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediacontenttype)
            {
                s1 = "playVideo";
            } else
            {
                s1 = "playAudio";
            }
            s2.a(s, "Cannot create media player - limit on number of media players reached", s1);
            return false;
        }
        mediacontenttype = (g)k.remove(s2);
        if (mediacontenttype == null)
        {
            if (c != null && h.a())
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Only a single instance of full-screen media playback is allowed. Releasing the current active player ...");
                k.remove(c.f);
                c.a(false);
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Creating a new media player instance!");
            c = new g(activity, b);
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Reusing media player (").append(s2).append(") from the pool").toString());
            c = mediacontenttype;
        }
        if (s1.length() == 0 && mediacontenttype != null)
        {
            c.a(s, ((g) (mediacontenttype)).g, ((g) (mediacontenttype)).e, ((g) (mediacontenttype)).d);
            c.d = ((g) (mediacontenttype)).d;
        }
        return true;
    }

    static RenderView b(MraidMediaProcessor mraidmediaprocessor)
    {
        return mraidmediaprocessor.b;
    }

    static void b(MraidMediaProcessor mraidmediaprocessor, String s, boolean flag)
    {
        mraidmediaprocessor.b(s, flag);
    }

    private void b(String s, boolean flag)
    {
        if (b != null)
        {
            b.a(s, (new StringBuilder()).append("fireHeadphonePluggedEvent(").append(flag).append(");").toString());
        }
    }

    private boolean b(String s, String s1, MediaContentType mediacontenttype, Activity activity)
    {
        boolean flag1 = false;
        if (c != null && c.f.equalsIgnoreCase(h.a)) goto _L2; else goto _L1
_L1:
        boolean flag = a(s, s1, h.a, mediacontenttype, activity);
_L4:
        return flag;
_L2:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Reusing media player (").append(c.f).append(") from the pool").toString());
        flag = flag1;
        if (!c.f.equalsIgnoreCase(h.a)) goto _L4; else goto _L3
_L3:
        if (s1.length() != 0 && !c.g.equalsIgnoreCase(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Player state: ").append(c.c).toString());
        static class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[com.inmobi.rendering.mraid.g.d.values().length];
                try
                {
                    a[g.d.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.inmobi.rendering.mraid.g.d.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[g.d.f.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[g.d.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.inmobi.rendering.mraid._cls4.a[c.c.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            c.start();
            k();
            return false;

        case 2: // '\002'
            if (c.h)
            {
                c.start();
            } else
            {
                h.d = true;
                c.e = h;
            }
            k();
            return false;

        case 3: // '\003'
            flag = flag1;
            if (h.f)
            {
                c.start();
                k();
                return false;
            }
            break;

        case 4: // '\004'
            k();
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
        c.a(s, s1, h, i);
        c.g();
        return false;
    }

    static Hashtable c(MraidMediaProcessor mraidmediaprocessor)
    {
        return mraidmediaprocessor.k;
    }

    private g d(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Checking for media player with ID: ").append(s).toString());
        if (c != null && (s == null || s.length() == 0))
        {
            if ("anonymous".equalsIgnoreCase(h.a))
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Returning media render view with ID: ").append(h.a).append(" (state: ").append(c.c).append(")").toString());
                return c;
            } else
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot find ID to look up the media render view");
                return null;
            }
        }
        g g1 = (g)k.get(s);
        if (g1 != null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Returning media render view with ID: ").append(s).append(" (state: ").append(g1.c).append(")").toString());
            return g1;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "No media render view found!");
            return g1;
        }
    }

    static String j()
    {
        return a;
    }

    private void k()
    {
        if (!h.a())
        {
            RelativeLayout relativelayout = (RelativeLayout)c.f();
            if (relativelayout != null)
            {
                relativelayout.setOnTouchListener(null);
                relativelayout.setBackgroundColor(0);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i.c, i.d);
                android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)relativelayout.getLayoutParams();
                if (0xfffe7961 == i.a || 0xfffe7961 == i.b)
                {
                    layoutparams.leftMargin = layoutparams1.leftMargin;
                    layoutparams.topMargin = layoutparams1.topMargin;
                } else
                {
                    layoutparams.leftMargin = i.a;
                    layoutparams.topMargin = i.b;
                }
                relativelayout.setLayoutParams(layoutparams);
            }
        }
    }

    public void a(com.inmobi.rendering.mraid.b b1)
    {
        i = b1;
    }

    public void a(f f1)
    {
        h = f1;
        j = true;
    }

    public void a(String s)
    {
        if (e == null)
        {
            e = new RingerModeChangeReceiver(s);
            com.inmobi.commons.a.a.b().registerReceiver(e, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        }
    }

    public void a(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "pauseMedia");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (((g) (s1)).c != g.d.b && (com.inmobi.rendering.mraid.g.d.a == ((g) (s1)).c || g.d.d == ((g) (s1)).c))
        {
            if (!((g) (s1)).h)
            {
                h.d = false;
                s1.e = h;
                return;
            } else
            {
                b.a(s, "Invalid player state", "pauseMedia");
                return;
            }
        } else
        {
            s1.pause();
            return;
        }
    }

    public void a(String s, String s1, int l)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "seekMedia");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || com.inmobi.rendering.mraid.g.d.a == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "seekMedia");
            return;
        } else
        {
            s1.a(l * 1000);
            return;
        }
    }

    public void a(String s, String s1, MediaContentType mediacontenttype, Activity activity)
    {
        if (!b(s, s1, mediacontenttype, activity))
        {
            return;
        }
        f f1 = h;
        com.inmobi.rendering.mraid.b b1 = i;
        b.setAdActiveFlag(true);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(c.c).toString());
        if (s1.length() != 0)
        {
            c.a(s, s1, f1, b1);
        } else
        {
            c.a(s, c.g, f1, b1);
        }
        if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediacontenttype && s1.startsWith("http") && !s1.endsWith("mp4") && !s1.endsWith("avi") && !s1.endsWith("m4v"))
        {
            c.c(3);
            return;
        }
        if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO == mediacontenttype && s1.startsWith("http") && !s1.endsWith("mp3"))
        {
            c.c(3);
            return;
        }
        k.put(h.a, c);
        if (g.d.d == c.c)
        {
            c.b();
            return;
        }
        if (f1.a())
        {
            s = (ViewGroup)activity.findViewById(0x1020002);
            s1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            s1.addRule(13);
            c.setLayoutParams(s1);
            s1 = new RelativeLayout(activity);
            s1.setOnTouchListener(new android.view.View.OnTouchListener() {

                final MraidMediaProcessor a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                a = MraidMediaProcessor.this;
                super();
            }
            });
            s1.setBackgroundColor(0xff000000);
            s1.addView(c);
            s.addView(s1, new android.view.ViewGroup.LayoutParams(-1, -1));
            c.a(s1);
            c.requestFocus();
            c.setOnKeyListener(new android.view.View.OnKeyListener() {

                final MraidMediaProcessor a;

                public boolean onKey(View view, int l, KeyEvent keyevent)
                {
                    if (4 == l && keyevent.getAction() == 0)
                    {
                        com.inmobi.rendering.mraid.MraidMediaProcessor.a(a).a(true);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                a = MraidMediaProcessor.this;
                super();
            }
            });
        } else
        {
            s = (ViewGroup)activity.findViewById(0x1020002);
            s1 = new RelativeLayout(activity);
            mediacontenttype = new android.widget.FrameLayout.LayoutParams(b1.c, b1.d);
            mediacontenttype.leftMargin = b1.a;
            mediacontenttype.topMargin = b1.b;
            mediacontenttype.width = b1.c;
            mediacontenttype.height = b1.d;
            activity = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            activity.addRule(10);
            activity.addRule(12);
            activity.addRule(9);
            activity.addRule(11);
            c.setLayoutParams(activity);
            c.a(s1);
            s1.addView(c);
            s.addView(s1, mediacontenttype);
            c.clearFocus();
        }
        c.a(new g.c() {

            final MraidMediaProcessor a;

            public void a(g g1)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.j(), ">>> onPlayerCompleted");
                MraidMediaProcessor.b(a).setAdActiveFlag(false);
                ViewGroup viewgroup = g1.f();
                if (viewgroup != null)
                {
                    ((ViewGroup)viewgroup.getParent()).removeView(viewgroup);
                }
                g1.a(null);
                this;
                JVM INSTR monitorenter ;
                if (com.inmobi.rendering.mraid.MraidMediaProcessor.a(a) != null && g1.f.equalsIgnoreCase(com.inmobi.rendering.mraid.MraidMediaProcessor.a(a).f))
                {
                    MraidMediaProcessor.c(a).remove(com.inmobi.rendering.mraid.MraidMediaProcessor.a(a).f);
                    com.inmobi.rendering.mraid.MraidMediaProcessor.a(a, null);
                }
                this;
                JVM INSTR monitorexit ;
                return;
                g1;
                this;
                JVM INSTR monitorexit ;
                throw g1;
            }

            public void b(g g1)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.j(), ">>> onPlayerPrepared");
            }

            
            {
                a = MraidMediaProcessor.this;
                super();
            }
        });
        c.a();
    }

    public void a(String s, String s1, boolean flag)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "closeMedia");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "closeMedia");
            return;
        } else
        {
            s1.a(flag);
            return;
        }
    }

    public boolean a()
    {
        return j;
    }

    public void b()
    {
        if (c != null)
        {
            k.put(c.f, c);
        }
        g g1;
        for (Iterator iterator = k.keySet().iterator(); iterator.hasNext(); g1.a(true))
        {
            g1 = (g)k.get(iterator.next());
            iterator.remove();
        }

        k.clear();
        c = null;
    }

    public void b(String s)
    {
        if (f == null)
        {
            Context context = com.inmobi.commons.a.a.b();
            f = new b(s, context, new Handler());
            context.getContentResolver().registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, f);
        }
    }

    public void b(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "muteMedia");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || com.inmobi.rendering.mraid.g.d.a == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "muteMedia");
            return;
        } else
        {
            s1.d();
            return;
        }
    }

    public void b(String s, String s1, int l)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "setMediaVolume");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "setMediaVolume");
            return;
        } else
        {
            s1.b(l);
            return;
        }
    }

    public void c()
    {
        if (c != null && g.d.g != c.c)
        {
            k.put(c.f, c);
            c.c();
        }
    }

    public void c(String s)
    {
        if (g == null)
        {
            g = new HeadphonesPluggedChangeReceiver(s);
            com.inmobi.commons.a.a.b().registerReceiver(g, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        }
    }

    public void c(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "unMuteMedia");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || com.inmobi.rendering.mraid.g.d.a == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "unMuteMedia");
            return;
        } else
        {
            s1.e();
            return;
        }
    }

    public a d()
    {
        return d;
    }

    public boolean d(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "isMediaMuted");
            return false;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
        if (g.d.g == ((g) (s1)).c || com.inmobi.rendering.mraid.g.d.a == ((g) (s1)).c || g.d.d == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "isMediaMuted");
            return false;
        } else
        {
            return ((g) (s1)).b;
        }
    }

    public int e(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "getMediaVolume");
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Media player state: ").append(((g) (s1)).c).toString());
            if (g.d.g == ((g) (s1)).c)
            {
                b.a(s, "Invalid player state", "getMediaVolume");
                return 0;
            }
            if (!((g) (s1)).b)
            {
                return ((g) (s1)).a;
            }
        }
        return 0;
    }

    public boolean e()
    {
        return 2 != ((AudioManager)com.inmobi.commons.a.a.b().getSystemService("audio")).getRingerMode();
    }

    public void f()
    {
        if (e != null)
        {
            com.inmobi.commons.a.a.b().unregisterReceiver(e);
            e = null;
        }
    }

    public void f(String s, String s1)
    {
        s1 = d(s1);
        if (s1 == null)
        {
            b.a(s, "Invalid property ID", "hideMedia");
            return;
        }
        if (g.d.g == ((g) (s1)).c)
        {
            b.a(s, "Invalid player state", "hideMedia");
            return;
        }
        if (g.d.d == ((g) (s1)).c)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Media player is already hidden");
            return;
        } else
        {
            s1.c();
            return;
        }
    }

    public void g()
    {
        if (f != null)
        {
            com.inmobi.commons.a.a.b().getContentResolver().unregisterContentObserver(f);
            f = null;
        }
    }

    public void g(String s, String s1)
    {
        g g1 = d(s1);
        if (g1 == null)
        {
            b.a(s, "Invalid property ID", "showMedia");
            return;
        }
        if (g.d.g == g1.c)
        {
            b.a(s, "Invalid player state", "showMedia");
            return;
        }
        if (!h.a.equalsIgnoreCase(s1))
        {
            b.a(s, "Show failed. There is already a video playing", "showMedia");
            return;
        }
        if (g.d.e == g1.c)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Media player is already showing");
            return;
        } else
        {
            k.remove(s1);
            c = g1;
            g1.b();
            return;
        }
    }

    public boolean h()
    {
        return ((AudioManager)com.inmobi.commons.a.a.b().getSystemService("audio")).isWiredHeadsetOn();
    }

    public void i()
    {
        if (g != null)
        {
            com.inmobi.commons.a.a.b().unregisterReceiver(g);
            g = null;
        }
    }

}
