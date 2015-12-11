// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ao, al

public final class ar
{
    static final class a
    {

        double a;
        double b;
        int c;
        boolean d;

        public final void a()
        {
            b = 0.0D;
            c = 0;
            d = false;
        }

        public a()
        {
            a();
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/millennialmedia/android/ar$b, s1);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("Add", 0);
            b = new b("Remove", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public static interface c
    {

        public abstract void a(double d1);

        public abstract void a(e e1);
    }

    public final class d
    {
    }

    public static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final e e;
        private static final e g[];
        private String f;

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(com/millennialmedia/android/ar$e, s1);
        }

        public static e[] values()
        {
            return (e[])g.clone();
        }

        public final String toString()
        {
            return f;
        }

        static 
        {
            a = new e("ERROR", 0, "error");
            b = new e("VOCALIZING", 1, "vocalizing");
            c = new e("RECORDING", 2, "recording");
            d = new e("READY", 3, "ready");
            e = new e("PROCESSING", 4, "processing");
            g = (new e[] {
                a, b, c, d, e
            });
        }

        private e(String s1, int i1, String s2)
        {
            super(s1, i1);
            f = s2;
        }
    }


    private static String t = null;
    WeakReference a;
    public d b[];
    Vocalizer c;
    SpeechKit d;
    Handler e;
    com.nuance.nmdp.speechkit.Vocalizer.Listener f;
    Recognizer g;
    e h;
    a i;
    DataUploadCommand j;
    Runnable k;
    Runnable l;
    v.b m;
    private com.nuance.nmdp.speechkit.Recognizer.Listener n;
    private b o;
    private String p;
    private com.nuance.nmdp.speechkit.GenericCommand.Listener q;
    private com.nuance.nmdp.speechkit.DataUploadCommand.Listener r;
    private c s;
    private String u;

    public ar(ao ao1)
    {
        b = null;
        i = new a();
        k = new Runnable() {

            final ar a;

            public final void run()
            {
                a.b();
            }

            
            {
                a = ar.this;
                super();
            }
        };
        l = new Runnable() {

            final ar a;

            public final void run()
            {
                if (ar.a(a) != null)
                {
                    double d1 = Math.min(9.9900000000000002D, Math.max(Math.floor((double)ar.a(a).getAudioLevel() - 40D) / 4.0040040040040044D, 0.0D));
                    al.b();
                    a a1 = ar.b(a);
                    double d2 = a1.b;
                    double d3 = a1.a;
                    a1.a = d1;
                    a1.c = a1.c + 1;
                    a1.b = (d2 * (double)(a1.c - 1) + d1) / (double)a1.c;
                    boolean flag;
                    if (!a1.d && a1.a != d3)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag && ar.c(a) != null)
                    {
                        ar.c(a).a(d1);
                    }
                    if (ar.d(a) == e.c || ar.b(a).d)
                    {
                        ar.f(a).postDelayed(ar.e(a), 50L);
                    }
                }
            }

            
            {
                a = ar.this;
                super();
            }
        };
        q = new com.nuance.nmdp.speechkit.GenericCommand.Listener() {

            final ar a;

            
            {
                a = ar.this;
                super();
            }
        };
        r = new com.nuance.nmdp.speechkit.DataUploadCommand.Listener() {

            final ar a;

            
            {
                a = ar.this;
                super();
            }
        };
        s = new c() {

            final ar a;

            public final void a(double d1)
            {
                ao ao2 = a.a();
                if (ao2 != null)
                {
                    ao2.loadUrl((new StringBuilder("javascript:MMJS.sdk.audioLevelChange(")).append(d1).append(")").toString());
                }
            }

            public final void a(e e1)
            {
                static final class _cls8
                {

                    static final int a[];

                    static 
                    {
                        a = new int[e.values().length];
                        try
                        {
                            a[e.a.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[e.e.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[e.d.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[e.c.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[e.b.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls8.a[e1.ordinal()];
                JVM INSTR tableswitch 1 5: default 44
            //                           1 45
            //                           2 64
            //                           3 83
            //                           4 102
            //                           5 121;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                return;
_L2:
                if ((e1 = a.a()) != null)
                {
                    e1.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                e1 = a.a();
                if (e1 != null)
                {
                    e1.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
                    return;
                }
                if (true) goto _L1; else goto _L4
_L4:
                e1 = a.a();
                if (e1 != null)
                {
                    e1.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
                    return;
                }
                if (true)
                {
                    continue; /* Loop/switch isn't completed */
                }
_L5:
                e1 = a.a();
                if (e1 != null)
                {
                    e1.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
                e1 = a.a();
                if (e1 != null)
                {
                    e1.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
                    return;
                }
                if (true) goto _L1; else goto _L7
_L7:
            }

            
            {
                a = ar.this;
                super();
            }
        };
        if (ao1 != null)
        {
            a = new WeakReference(ao1);
            ao1 = ao1.getContext().getApplicationContext();
            if (u == null)
            {
                u = ao1.getApplicationContext().getPackageName();
            }
        }
        h = e.d;
    }

    static Recognizer a(ar ar1)
    {
        return ar1.g;
    }

    static a b(ar ar1)
    {
        return ar1.i;
    }

    static c c(ar ar1)
    {
        return ar1.s;
    }

    static e d(ar ar1)
    {
        return ar1.h;
    }

    static Runnable e(ar ar1)
    {
        return ar1.l;
    }

    static Handler f(ar ar1)
    {
        return ar1.e;
    }

    final ao a()
    {
        if (a != null)
        {
            return (ao)a.get();
        } else
        {
            return null;
        }
    }

    public final void a(b b1, String as[])
    {
        if (d == null)
        {
            return;
        }
        DataBlock datablock = new DataBlock();
        Object obj1 = new StringBuilder("Creating dataupload command and ");
        Object obj;
        int k1;
        if (b1 == b.a)
        {
            obj = "adding";
        } else
        {
            obj = "deleting";
        }
        ((StringBuilder) (obj1)).append(((String) (obj))).append(" words.");
        al.b();
        obj1 = new Data("nva_custom_word_uploads", com.nuance.nmdp.speechkit.util.dataupload.Data.DataType.CUSTOMWORDS);
        if (b1 == b.a)
        {
            obj = com.nuance.nmdp.speechkit.util.dataupload.Action.ActionType.ADD;
        } else
        {
            obj = com.nuance.nmdp.speechkit.util.dataupload.Action.ActionType.REMOVE;
        }
        obj = new Action(((com.nuance.nmdp.speechkit.util.dataupload.Action.ActionType) (obj)));
        k1 = as.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            String s1 = as[i1];
            ((Action) (obj)).addWord(s1);
            (new StringBuilder("\tword: '")).append(s1).append("'");
            al.b();
        }

        ((Data) (obj1)).addAction(((Action) (obj)));
        datablock.addData(((Data) (obj1)));
        int j1 = datablock.getChecksum();
        o = b1;
        j = d.createDataUploadCmd(datablock, j1, j1, r, e);
        j.start();
    }

    final void a(e e1)
    {
        this;
        JVM INSTR monitorenter ;
        (new StringBuilder("recording results returned. state=")).append(e1);
        al.b();
        e e2 = h;
        h = e1;
        if (s != null && h != e2)
        {
            s.a(e1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        e1;
        throw e1;
    }

    public final boolean a(v.b b1, Context context)
    {
        byte abyte0[];
        String s1;
        abyte0 = null;
        al.b();
        if (b1 == null || context == null)
        {
            return false;
        }
        m = b1;
        if (d != null)
        {
            try
            {
                d.connect();
            }
            catch (IllegalStateException illegalstateexception)
            {
                d = null;
            }
        }
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        s1 = b1.b;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        b1.toString();
        al.b();
        d = SpeechKit.initialize(context, "1.0", b1.a, b1.c, b1.d, false, abyte0, com.nuance.nmdp.speechkit.SpeechKit.CmdSetType.NVC);
        f = new com.nuance.nmdp.speechkit.Vocalizer.Listener() {

            final ar a;

            
            {
                a = ar.this;
                super();
            }
        };
        n = new com.nuance.nmdp.speechkit.Recognizer.Listener() {

            final ar a;

            
            {
                a = ar.this;
                super();
            }
        };
        e = new Handler(Looper.getMainLooper());
        d.connect();
        a(e.d);
        return true;
_L2:
        byte abyte1[] = new byte[s1.length() / 2];
        int i1 = 0;
        do
        {
            abyte0 = abyte1;
            if (i1 >= abyte1.length)
            {
                break;
            }
            abyte1[i1] = (byte)Integer.parseInt(s1.substring(i1 * 2, i1 * 2 + 2), 16);
            i1++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        al.b();
        return false;
    }

    public final boolean a(String s1)
    {
        al.b();
        if (h == e.d && d != null)
        {
            p = null;
            g = d.createRecognizer("dictation", 1, s1, n, e);
            al.b();
            g.start();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean b()
    {
        if (g != null)
        {
            al.b();
            g.stopRecording();
            g = null;
            return true;
        } else
        {
            return false;
        }
    }

    public final void c()
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        d.cancelCurrent();
        return;
        Exception exception;
        exception;
        al.a("NVASpeechKit", "No speech kit to disconnect.", exception);
        return;
    }

}
