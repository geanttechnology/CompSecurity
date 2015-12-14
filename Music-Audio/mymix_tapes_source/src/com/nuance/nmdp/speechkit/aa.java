// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import aq;
import ay;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import g;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            Vocalizer, v, SpeechError

final class aa
    implements Vocalizer
{
    final class a
    {

        private final boolean a;
        private final String b;
        private final String c;
        private final String d;
        private final Object e;

        static String a(a a1)
        {
            return a1.b;
        }

        static Object b(a a1)
        {
            return a1.e;
        }

        static String c(a a1)
        {
            return a1.c;
        }

        static String d(a a1)
        {
            return a1.d;
        }

        static boolean e(a a1)
        {
            return a1.a;
        }

        public a(boolean flag, String s, String s1, String s2, Object obj)
        {
            a = flag;
            b = s;
            c = s1;
            d = s2;
            e = obj;
        }
    }


    private String a;
    private String b;
    private final Vocalizer.Listener c;
    private final m d;
    private final aq e = new aq() {

        private aa a;

        public final void a(g g1)
        {
            if (aa.a(a) != null)
            {
                if (com.nuance.nmdp.speechkit.aa.b(a) == g1)
                {
                    aa.a(a, a.a(aa.c(a)), com.nuance.nmdp.speechkit.a.b(aa.c(a)), aa.a(a));
                    aa.d(a);
                    aa.e(a);
                    aa.a(a, null);
                }
            } else
            if (com.nuance.nmdp.speechkit.aa.b(a) == g1)
            {
                aa.f(a).onSpeakingDone(a, a.a(aa.c(a)), null, com.nuance.nmdp.speechkit.a.b(aa.c(a)));
                if (aa.g(a).c() > 0)
                {
                    g1 = (a)aa.g(a).a();
                    aa.a(a, g1);
                    return;
                } else
                {
                    aa.d(a);
                    aa.e(a);
                    return;
                }
            }
        }

        public final void a(g g1, int j, String s2, String s3)
        {
            if (com.nuance.nmdp.speechkit.aa.b(a) == g1)
            {
                aa.a(a, new v(j, s2, s3));
            }
        }

        public final void b(g g1)
        {
            if (com.nuance.nmdp.speechkit.aa.b(a) == g1)
            {
                aa.f(a).onSpeakingBegin(a, a.a(aa.c(a)), com.nuance.nmdp.speechkit.a.b(aa.c(a)));
            }
        }

            
            {
                a = aa.this;
                super();
            }
    };
    private g f;
    private a g;
    private SpeechError h;
    private final ay i = new ay();

    aa(m m1, String s, String s1, Vocalizer.Listener listener)
    {
        a = s;
        b = s1;
        c = listener;
        d = m1;
        f = null;
        g = null;
        h = null;
    }

    static SpeechError a(aa aa1)
    {
        return aa1.h;
    }

    static SpeechError a(aa aa1, SpeechError speecherror)
    {
        aa1.h = speecherror;
        return speecherror;
    }

    private void a(a a1)
    {
        if (d.b())
        {
            h = null;
            f = d.a(a.a(a1), a.c(a1), a.d(a1), a.e(a1), e);
            if (f == null)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create TTS transaction");
                a(a.a(a1), com.nuance.nmdp.speechkit.a.b(a1), ((SpeechError) (new v(0, null, null))));
                return;
            } else
            {
                g = a1;
                f.a();
                return;
            }
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create TTS transaction. Transaction runner is invalid.");
            a(a.a(a1), com.nuance.nmdp.speechkit.a.b(a1), ((SpeechError) (new v(0, null, null))));
            return;
        }
    }

    static void a(aa aa1, a a1)
    {
        aa1.a(a1);
    }

    static void a(aa aa1, String s, Object obj, SpeechError speecherror)
    {
        aa1.a(s, obj, speecherror);
    }

    private void a(String s, Object obj, SpeechError speecherror)
    {
        c.onSpeakingDone(this, s, speecherror, obj);
        int k = i.c();
        for (int j = 0; j < k; j++)
        {
            s = (a)i.a(j);
            c.onSpeakingDone(this, a.a(s), speecherror, com.nuance.nmdp.speechkit.a.b(s));
        }

        i.b();
    }

    static g b(aa aa1)
    {
        return aa1.f;
    }

    static a c(aa aa1)
    {
        return aa1.g;
    }

    static g d(aa aa1)
    {
        aa1.f = null;
        return null;
    }

    static a e(aa aa1)
    {
        aa1.g = null;
        return null;
    }

    static Vocalizer.Listener f(aa aa1)
    {
        return aa1.c;
    }

    static ay g(aa aa1)
    {
        return aa1.i;
    }

    public final void cancel()
    {
        if (f != null)
        {
            f.b();
        }
    }

    public final void setLanguage(String s)
    {
        b = s;
        a = null;
    }

    public final void setListener(Vocalizer.Listener listener)
    {
    }

    public final void setVoice(String s)
    {
        b = null;
        a = s;
    }

    public final void speakMarkupString(String s, Object obj)
    {
        s = new a(true, s, a, b, obj);
        if (f == null)
        {
            a(s);
            return;
        } else
        {
            i.a(s);
            return;
        }
    }

    public final void speakString(String s, Object obj)
    {
        s = new a(false, s, a, b, obj);
        if (f == null)
        {
            a(s);
            return;
        } else
        {
            i.a(s);
            return;
        }
    }
}
