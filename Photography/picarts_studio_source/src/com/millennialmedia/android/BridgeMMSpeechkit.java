// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.nuance.nmdp.speechkit.SpeechKit;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMWebView, NVASpeechKit, HandShake, 
//            MMJSResponse, AdCache, MMLog

public class BridgeMMSpeechkit extends MMJSObject
    implements android.media.MediaPlayer.OnCompletionListener, BridgeMMMedia.Audio.PeriodicListener
{

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

    BridgeMMSpeechkit()
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
        return SingletonHolder.INSTANCE.release();
    }

    private void b(String s)
    {
        MMWebView mmwebview = (MMWebView)c.get();
        if (mmwebview != null)
        {
            mmwebview.loadUrl(s);
        }
    }

    private NVASpeechKit c()
    {
        boolean flag = true;
        Object obj = (MMWebView)c.get();
        if (obj != null)
        {
            if (((MMWebView) (obj)).k)
            {
                flag = ((MMWebView) (obj)).q();
            } else
            {
                obj.k = true;
                if (!((MMWebView) (obj)).r() || !((MMWebView) (obj)).i)
                {
                    flag = false;
                }
            }
            if (flag)
            {
                if (SingletonHolder.INSTANCE.getSpeechKit() != null)
                {
                    return SingletonHolder.INSTANCE.getSpeechKit();
                }
                Context context = ((MMWebView) (obj)).getContext();
                if (context != null)
                {
                    obj = new NVASpeechKit(((MMWebView) (obj)));
                    SingletonHolder.INSTANCE.release();
                    SingletonHolder.INSTANCE.setSpeechKit(((NVASpeechKit) (obj)));
                    HandShake.NuanceCredentials nuancecredentials = HandShake.a(context).g;
                    if (nuancecredentials != null)
                    {
                        ((NVASpeechKit) (obj)).initialize(nuancecredentials, context.getApplicationContext());
                    }
                    return ((NVASpeechKit) (obj));
                }
            }
        }
        return null;
    }

    private NVASpeechKit d()
    {
        MMWebView mmwebview = (MMWebView)c.get();
        if (mmwebview != null && mmwebview.q())
        {
            return SingletonHolder.INSTANCE.getSpeechKit();
        } else
        {
            return null;
        }
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if (a.equals(s))
        {
            mmjsresponse = startRecording(map);
        } else
        {
            if (d.equals(s))
            {
                return endRecording(map);
            }
            if (e.equals(s))
            {
                return cacheAudio(map);
            }
            if (f.equals(s))
            {
                return getSessionId(map);
            }
            if (g.equals(s))
            {
                return playAudio(map);
            }
            if (h.equals(s))
            {
                return textToSpeech(map);
            }
            if (i.equals(s))
            {
                return stopAudio(map);
            }
            if (j.equals(s))
            {
                return sampleBackgroundAudioLevel(map);
            }
            if (k.equals(s))
            {
                return releaseVoice(map);
            }
            if (l.equals(s))
            {
                return addCustomVoiceWords(map);
            }
            if (m.equals(s))
            {
                return deleteCustomVoiceWords(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse addCustomVoiceWords(Map map)
    {
        NVASpeechKit nvaspeechkit = c();
        if (nvaspeechkit == null)
        {
            return MMJSResponse.b("Unable to create speech kit");
        }
        map = (String)map.get("words");
        if (!TextUtils.isEmpty(map))
        {
            String as[] = map.split(",");
            nvaspeechkit.updateCustomWords(NVASpeechKit.CustomWordsOp.Add, as);
            b("javascript:MMJS.sdk.customVoiceWordsAdded()");
            return MMJSResponse.a((new StringBuilder("Added ")).append(map).toString());
        } else
        {
            return null;
        }
    }

    public MMJSResponse cacheAudio(Map map)
    {
        map = (String)map.get("url");
        if (!URLUtil.isValidUrl(map))
        {
            return MMJSResponse.b("Invalid url");
        }
        if (b != null && (Context)b.get() != null && AdCache.b(map, map.substring(map.lastIndexOf("/") + 1)))
        {
            b("javascript:MMJS.sdk.audioCached()");
            return MMJSResponse.a((new StringBuilder("Successfully cached audio at ")).append(map).toString());
        } else
        {
            return MMJSResponse.b((new StringBuilder("Failed to cache audio at")).append(map).toString());
        }
    }

    public MMJSResponse deleteCustomVoiceWords(Map map)
    {
        NVASpeechKit nvaspeechkit = c();
        if (nvaspeechkit == null)
        {
            return MMJSResponse.b("Unable to create speech kit");
        }
        map = (String)map.get("words");
        if (!TextUtils.isEmpty(map))
        {
            String as[] = map.split(",");
            nvaspeechkit.updateCustomWords(NVASpeechKit.CustomWordsOp.Remove, as);
            b("javascript:MMJS.sdk.customVoiceWordsDeleted()");
            return MMJSResponse.a((new StringBuilder("Deleted ")).append(map).toString());
        } else
        {
            return null;
        }
    }

    public MMJSResponse endRecording(Map map)
    {
        map = d();
        if (map == null)
        {
            return MMJSResponse.b("Unable to get speech kit");
        }
        map;
        JVM INSTR monitorenter ;
        MMJSResponse mmjsresponse;
        if (!map.endRecording())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        mmjsresponse = MMJSResponse.a();
        return mmjsresponse;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
        return MMJSResponse.b("Failed in speechKit");
    }

    public MMJSResponse getSessionId(Map map)
    {
        map = d();
        if (map == null)
        {
            return MMJSResponse.b("No SpeechKit session open.");
        }
        if (((NVASpeechKit) (map)).a != null)
        {
            map = ((NVASpeechKit) (map)).a.getSessionId();
        } else
        {
            map = "";
        }
        if (!TextUtils.isEmpty(map))
        {
            return MMJSResponse.a(map);
        } else
        {
            return MMJSResponse.b("No SpeechKit session open.");
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        b("javascript:MMJS.sdk.audioCompleted()");
        mediaplayer = (Context)b.get();
        if (mediaplayer != null)
        {
            mediaplayer = BridgeMMMedia.Audio.a(mediaplayer);
            if (mediaplayer != null)
            {
                if (((BridgeMMMedia.Audio) (mediaplayer)).a != null)
                {
                    ((BridgeMMMedia.Audio) (mediaplayer)).a.remove(this);
                }
                if (((BridgeMMMedia.Audio) (mediaplayer)).b != null)
                {
                    ((BridgeMMMedia.Audio) (mediaplayer)).b.remove(this);
                }
            }
        }
    }

    public void onUpdate(int i1)
    {
        b((new StringBuilder("javascript:MMJS.sdk.audioPositionChange(")).append(i1).append(")").toString());
    }

    public MMJSResponse playAudio(Map map)
    {
        if (c() != null) goto _L2; else goto _L1
_L1:
        Object obj = MMJSResponse.b("Unable to create speech kit");
_L4:
        return ((MMJSResponse) (obj));
_L2:
        Object obj1;
        if (!URLUtil.isValidUrl((String)map.get("url")))
        {
            return MMJSResponse.b("Invalid url");
        }
        obj = (String)map.get("url");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_329;
        }
        obj1 = (Context)b.get();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        obj1 = BridgeMMMedia.Audio.a(((Context) (obj1)));
        if (obj1 != null)
        {
            if (((BridgeMMMedia.Audio) (obj1)).a == null)
            {
                obj1.a = new CopyOnWriteArrayList();
            }
            if (!((BridgeMMMedia.Audio) (obj1)).a.contains(this))
            {
                ((BridgeMMMedia.Audio) (obj1)).a.add(this);
            }
            if (((BridgeMMMedia.Audio) (obj1)).b == null)
            {
                obj1.b = new CopyOnWriteArrayList();
            }
            if (!((BridgeMMMedia.Audio) (obj1)).b.contains(this))
            {
                ((BridgeMMMedia.Audio) (obj1)).b.add(this);
            }
        }
        map.put("path", obj);
        obj1 = (Context)b.get();
        obj = (String)map.get("path");
        if (obj1 == null || obj == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        obj1 = BridgeMMMedia.Audio.a(((Context) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        if (!((BridgeMMMedia.Audio) (obj1)).a())
        {
            break; /* Loop/switch isn't completed */
        }
        map = MMJSResponse.b("Audio already playing.");
_L5:
        obj = map;
        if (map != null)
        {
            obj = map;
            if (((MMJSResponse) (map)).c == 1)
            {
                b("javascript:MMJS.sdk.audioStarted()");
                return map;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).startsWith("http"))
        {
            map = ((BridgeMMMedia.Audio) (obj1)).a(Uri.parse(((String) (obj))), Boolean.parseBoolean((String)map.get("repeat")));
        } else
        {
            obj = AdCache.a(((String) (obj)));
            if (!((File) (obj)).exists())
            {
                break MISSING_BLOCK_LABEL_324;
            }
            map = ((BridgeMMMedia.Audio) (obj1)).a(Uri.fromFile(((File) (obj))), Boolean.parseBoolean((String)map.get("repeat")));
        }
          goto _L5
        map = null;
          goto _L5
        return null;
    }

    public MMJSResponse releaseVoice(Map map)
    {
        if (SingletonHolder.INSTANCE.release())
        {
            return MMJSResponse.b("Unable to get speech kit");
        } else
        {
            return MMJSResponse.a("released speechkit");
        }
    }

    public MMJSResponse sampleBackgroundAudioLevel(Map map)
    {
        map = c();
        if (map == null)
        {
            return MMJSResponse.b("Unable to create speech kit");
        } else
        {
            map.startSampleRecording();
            return null;
        }
    }

    public MMJSResponse startRecording(Map map)
    {
        NVASpeechKit nvaspeechkit = c();
        if (nvaspeechkit == null)
        {
            return MMJSResponse.b("Unable to create speech kit");
        }
        String s = (String)map.get("language");
        map = s;
        if (TextUtils.isEmpty(s))
        {
            map = "en_GB";
        }
        if (nvaspeechkit.startRecording(map))
        {
            return MMJSResponse.a();
        } else
        {
            return MMJSResponse.b("Failed in speechKit");
        }
    }

    public MMJSResponse stopAudio(Map map)
    {
        map = d();
        if (map == null)
        {
            return MMJSResponse.b("Unable to get speech kit");
        }
        map.stopActions();
        if (b != null)
        {
            map = BridgeMMMedia.Audio.a((Context)b.get());
            if (map != null)
            {
                return map.b();
            }
        }
        return MMJSResponse.a();
    }

    public MMJSResponse textToSpeech(Map map)
    {
        MMLog.b("BridgeMMSpeechkit", "@@-Calling textToSpeech");
        NVASpeechKit nvaspeechkit = c();
        if (nvaspeechkit == null)
        {
            return MMJSResponse.b("Unable to create speech kit");
        }
        String s = (String)map.get("language");
        String s1 = (String)map.get("text");
        map = s;
        if (TextUtils.isEmpty(s))
        {
            map = "en_GB";
        }
        nvaspeechkit.stopActions();
        if (nvaspeechkit.textToSpeech(s1, map))
        {
            return MMJSResponse.a();
        } else
        {
            return MMJSResponse.b("Failed in speechKit");
        }
    }

    private class SingletonHolder
    {

        public static final SpeechKitHolder INSTANCE = new SpeechKitHolder((byte)0);


        private SingletonHolder()
        {
        }
    }


    private class SpeechKitHolder
    {

        private NVASpeechKit a;

        static NVASpeechKit a(SpeechKitHolder speechkitholder)
        {
            return speechkitholder.a;
        }

        static NVASpeechKit b(SpeechKitHolder speechkitholder)
        {
            speechkitholder.a = null;
            return null;
        }

        public NVASpeechKit getSpeechKit()
        {
            return a;
        }

        public boolean release()
        {
            if (a == null)
            {
                return false;
            } else
            {
                Utils.ThreadUtils.a(new Runnable() {

                    private SpeechKitHolder a;

                    public void run()
                    {
                        synchronized (a)
                        {
                            if (SpeechKitHolder.a(a) != null)
                            {
                                SpeechKitHolder.a(a).cancelRecording();
                                SpeechKitHolder.a(a).release();
                                SpeechKitHolder.b(a);
                            }
                        }
                        return;
                        exception;
                        speechkitholder;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

                
                {
                    a = SpeechKitHolder.this;
                    super();
                }
                });
                return true;
            }
        }

        public void setSpeechKit(NVASpeechKit nvaspeechkit)
        {
            a = nvaspeechkit;
        }

        private SpeechKitHolder()
        {
        }

        SpeechKitHolder(byte byte0)
        {
            this();
        }
    }

}
