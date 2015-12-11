// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.Vocalizer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.millennialmedia.android:
//            ai, ao, ar, v, 
//            aj, a, al

public final class q extends ai
    implements android.media.MediaPlayer.OnCompletionListener, o.a.b
{
    private static final class a
    {

        public static final b a = new b((byte)0);

    }

    private static final class b
    {

        ar a;

        public final boolean a()
        {
            if (a == null)
            {
                return false;
            } else
            {
                au.c.a(new Runnable(this) {

                    final b a;

                    public final void run()
                    {
                        synchronized (a)
                        {
                            if (a.a != null)
                            {
                                ar ar1 = a.a;
                                if (ar1.g != null)
                                {
                                    al.b();
                                    ar1.g.cancel();
                                    ar1.g = null;
                                    ar1.a(ar.e.d);
                                }
                                ar1 = a.a;
                                al.b();
                                ar1.c();
                                if (ar1.e != null)
                                {
                                    ar1.e.removeCallbacks(ar1.k);
                                    ar1.e.removeCallbacks(ar1.l);
                                }
                                if (ar1.d != null)
                                {
                                    ar1.d.release();
                                    ar1.a(ar.e.d);
                                    ar1.d = null;
                                }
                                ar1.j = null;
                                if (ar1.a() != null)
                                {
                                    ar1.a.clear();
                                }
                                a.a = null;
                            }
                        }
                        return;
                        exception;
                        b1;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                a = b1;
                super();
            }
                });
                return true;
            }
        }

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }


    private String a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    q()
    {
        a = "startRecording";
        d = "endRecording";
        e = "cacheAudio";
        f = "getSessionId";
        g = "playAudio";
        h = "textToSpeech";
        i = "stopAudio";
        j = "sampleBackgroundAudioLevel";
        k = "releaseVoice";
        l = "addCustomVoiceWords";
        m = "deleteCustomVoiceWords";
    }

    static boolean a()
    {
        return a.a.a();
    }

    private void b(String s)
    {
        ao ao1 = (ao)c.get();
        if (ao1 != null)
        {
            ao1.loadUrl(s);
        }
    }

    private ar c()
    {
        boolean flag = true;
        Object obj = (ao)c.get();
        if (obj != null)
        {
            if (((ao) (obj)).o)
            {
                flag = ((ao) (obj)).r();
            } else
            {
                obj.o = true;
                if (!((ao) (obj)).s() || !((ao) (obj)).m)
                {
                    flag = false;
                }
            }
            if (flag)
            {
                if (a.a.a != null)
                {
                    return a.a.a;
                }
                Context context = ((ao) (obj)).getContext();
                if (context != null)
                {
                    obj = new ar(((ao) (obj)));
                    a.a.a();
                    a.a.a = ((ar) (obj));
                    v.b b1 = v.a(context).j;
                    if (b1 != null)
                    {
                        ((ar) (obj)).a(b1, context.getApplicationContext());
                    }
                    return ((ar) (obj));
                }
            }
        }
        return null;
    }

    private ar d()
    {
        ao ao1 = (ao)c.get();
        if (ao1 != null && ao1.r())
        {
            return a.a.a;
        } else
        {
            return null;
        }
    }

    private aj e()
    {
        ar ar1;
        ar1 = d();
        if (ar1 == null)
        {
            return aj.b("Unable to get speech kit");
        }
        ar1;
        JVM INSTR monitorenter ;
        aj aj1;
        if (!ar1.b())
        {
            break MISSING_BLOCK_LABEL_39;
        }
        aj1 = aj.a("Success.");
        return aj1;
        Exception exception;
        exception;
        ar1;
        JVM INSTR monitorexit ;
        throw exception;
        ar1;
        JVM INSTR monitorexit ;
        return aj.b("Failed in speechKit");
    }

    final aj a(String s, Map map)
    {
        Object obj;
        ar ar1;
        Object obj1;
        ar1 = null;
        obj1 = null;
        obj = null;
        if (!a.equals(s)) goto _L2; else goto _L1
_L1:
        obj = c();
        if (obj != null) goto _L4; else goto _L3
_L3:
        map = aj.b("Unable to create speech kit");
_L24:
        return map;
_L4:
        map = (String)map.get("language");
        s = map;
        if (TextUtils.isEmpty(map))
        {
            s = "en_GB";
        }
        if (((ar) (obj)).a(s))
        {
            return aj.a("Success.");
        } else
        {
            return aj.b("Failed in speechKit");
        }
_L2:
        if (!d.equals(s)) goto _L6; else goto _L5
_L5:
        s = e();
_L22:
        return s;
_L6:
        if (e.equals(s))
        {
            s = (String)map.get("url");
            if (!URLUtil.isValidUrl(s))
            {
                return aj.b("Invalid url");
            }
            if (b != null && (Context)b.get() != null && com.millennialmedia.android.a.a(s, s.substring(s.lastIndexOf("/") + 1)))
            {
                b("javascript:MMJS.sdk.audioCached()");
                return aj.a((new StringBuilder("Successfully cached audio at ")).append(s).toString());
            } else
            {
                return aj.b((new StringBuilder("Failed to cache audio at")).append(s).toString());
            }
        }
        if (f.equals(s))
        {
            s = d();
            if (s != null)
            {
                if (((ar) (s)).d != null)
                {
                    s = ((ar) (s)).d.getSessionId();
                } else
                {
                    s = "";
                }
                if (!TextUtils.isEmpty(s))
                {
                    return aj.a(s);
                }
            }
            return aj.b("No SpeechKit session open.");
        }
        if (!g.equals(s))
        {
            break MISSING_BLOCK_LABEL_618;
        }
        if (c() == null)
        {
            return aj.b("Unable to create speech kit");
        }
        if (!URLUtil.isValidUrl((String)map.get("url")))
        {
            return aj.b("Invalid url");
        }
        s = (String)map.get("url");
        if (TextUtils.isEmpty(s)) goto _L8; else goto _L7
_L7:
        obj = (Context)b.get();
        if (obj == null) goto _L8; else goto _L9
_L9:
        obj = o.a.a(((Context) (obj)));
        if (obj != null)
        {
            if (((o.a) (obj)).a == null)
            {
                obj.a = new CopyOnWriteArrayList();
            }
            if (!((o.a) (obj)).a.contains(this))
            {
                ((o.a) (obj)).a.add(this);
            }
            if (((o.a) (obj)).b == null)
            {
                obj.b = new CopyOnWriteArrayList();
            }
            if (!((o.a) (obj)).b.contains(this))
            {
                ((o.a) (obj)).b.add(this);
            }
        }
        map.put("path", s);
        obj = (Context)b.get();
        s = (String)map.get("path");
        if (obj == null || s == null) goto _L11; else goto _L10
_L10:
        obj = o.a.a(((Context) (obj)));
        if (obj == null) goto _L11; else goto _L12
_L12:
        if (!((o.a) (obj)).a()) goto _L14; else goto _L13
_L13:
        s = aj.b("Audio already playing.");
_L15:
        map = s;
        if (s != null)
        {
            map = s;
            if (((aj) (s)).c == 1)
            {
                b("javascript:MMJS.sdk.audioStarted()");
                return s;
            }
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (s.startsWith("http"))
        {
            s = ((o.a) (obj)).a(Uri.parse(s), Boolean.parseBoolean((String)map.get("repeat")));
            continue; /* Loop/switch isn't completed */
        }
        s = com.millennialmedia.android.a.a(s);
        if (s.exists())
        {
            s = ((o.a) (obj)).a(Uri.fromFile(s), Boolean.parseBoolean((String)map.get("repeat")));
            continue; /* Loop/switch isn't completed */
        }
_L11:
        s = null;
        if (true) goto _L15; else goto _L8
_L8:
        return null;
        if (h.equals(s))
        {
            al.b();
            ar1 = c();
            if (ar1 == null)
            {
                return aj.b("Unable to create speech kit");
            }
            obj = (String)map.get("language");
            map = (String)map.get("text");
            s = ((String) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                s = "en_GB";
            }
            ar1.c();
            al.b();
            boolean flag;
            if (ar1.h == ar.e.d && ar1.d != null)
            {
                ar1.c = ar1.d.createVocalizerWithLanguage(s, ar1.f, ar1.e);
                ar1.c.speakString(map, ar1);
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return aj.a("Success.");
            } else
            {
                return aj.b("Failed in speechKit");
            }
        }
        if (i.equals(s))
        {
            s = d();
            if (s == null)
            {
                return aj.b("Unable to get speech kit");
            }
            s.c();
            if (b != null)
            {
                s = o.a.a((Context)b.get());
                if (s != null)
                {
                    return s.b();
                }
            }
            return aj.a("Success.");
        }
        if (j.equals(s))
        {
            s = c();
            if (s == null)
            {
                s = aj.b("Unable to create speech kit");
            } else
            {
                map = ((ar) (s)).i;
                map.a();
                map.d = true;
                s.a("en_US");
                s = ar1;
            }
            return s;
        }
        if (k.equals(s))
        {
            if (a.a.a())
            {
                return aj.b("Unable to get speech kit");
            } else
            {
                return aj.a("released speechkit");
            }
        }
        if (!l.equals(s)) goto _L17; else goto _L16
_L16:
        obj = c();
        if (obj != null) goto _L19; else goto _L18
_L18:
        s = aj.b("Unable to create speech kit");
_L20:
        return s;
_L19:
        map = (String)map.get("words");
        s = obj1;
        if (!TextUtils.isEmpty(map))
        {
            s = map.split(",");
            ((ar) (obj)).a(ar.b.a, s);
            b("javascript:MMJS.sdk.customVoiceWordsAdded()");
            s = aj.a((new StringBuilder("Added ")).append(map).toString());
        }
        if (true) goto _L20; else goto _L17
_L17:
        if (!m.equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        ar ar2 = c();
        if (ar2 == null)
        {
            s = aj.b("Unable to create speech kit");
        } else
        {
            map = (String)map.get("words");
            s = ((String) (obj));
            if (!TextUtils.isEmpty(map))
            {
                s = map.split(",");
                ar2.a(ar.b.b, s);
                b("javascript:MMJS.sdk.customVoiceWordsDeleted()");
                s = aj.a((new StringBuilder("Deleted ")).append(map).toString());
            }
        }
        if (true) goto _L22; else goto _L21
_L21:
        return null;
        if (true) goto _L24; else goto _L23
_L23:
    }

    public final void a(int i1)
    {
        b((new StringBuilder("javascript:MMJS.sdk.audioPositionChange(")).append(i1).append(")").toString());
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        b("javascript:MMJS.sdk.audioCompleted()");
        mediaplayer = (Context)b.get();
        if (mediaplayer != null)
        {
            mediaplayer = o.a.a(mediaplayer);
            if (mediaplayer != null)
            {
                if (((o.a) (mediaplayer)).a != null)
                {
                    ((o.a) (mediaplayer)).a.remove(this);
                }
                if (((o.a) (mediaplayer)).b != null)
                {
                    ((o.a) (mediaplayer)).b.remove(this);
                }
            }
        }
    }
}
