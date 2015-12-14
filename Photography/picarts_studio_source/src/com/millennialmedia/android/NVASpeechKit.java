// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMLog, MMSDK, HttpMMHeaders

public class NVASpeechKit
{

    private static String s = null;
    public Result _results[];
    SpeechKit a;
    private WeakReference b;
    private Vocalizer c;
    private Handler d;
    private com.nuance.nmdp.speechkit.Recognizer.Listener e;
    private com.nuance.nmdp.speechkit.Vocalizer.Listener f;
    private Recognizer g;
    private State h;
    private AudioLevelTracker i;
    private DataUploadCommand j;
    private CustomWordsOp k;
    private String l;
    private Runnable m;
    private Runnable n;
    private com.nuance.nmdp.speechkit.GenericCommand.Listener o;
    private com.nuance.nmdp.speechkit.DataUploadCommand.Listener p;
    private Listener q;
    private HandShake.NuanceCredentials r;
    private String t;

    public NVASpeechKit(MMWebView mmwebview)
    {
        _results = null;
        i = new AudioLevelTracker();
        m = new Runnable() {

            private NVASpeechKit a;

            public void run()
            {
                a.endRecording();
            }

            
            {
                a = NVASpeechKit.this;
                super();
            }
        };
        n = new Runnable() {

            private NVASpeechKit a;

            public void run()
            {
                if (NVASpeechKit.a(a) != null)
                {
                    double d1 = AudioLevelTracker.a(NVASpeechKit.a(a).getAudioLevel());
                    MMLog.b("NVASpeechKit", (new StringBuilder("audiolevel changed: level=")).append(d1).toString());
                    if (NVASpeechKit.b(a).update(d1) && NVASpeechKit.c(a) != null)
                    {
                        NVASpeechKit.c(a).onAudioLevelUpdate(d1);
                    }
                    if (NVASpeechKit.d(a) == State.RECORDING || NVASpeechKit.b(a).b)
                    {
                        NVASpeechKit.f(a).postDelayed(NVASpeechKit.e(a), 50L);
                    }
                }
            }

            
            {
                a = NVASpeechKit.this;
                super();
            }

            private class Listener
            {

                public abstract void onAudioLevelUpdate(double d1);

                public abstract void onAudioSampleUpdate(double d1);

                public abstract void onCustomWordsAdded();

                public abstract void onCustomWordsDeleted();

                public abstract void onError();

                public abstract void onResults();

                public abstract void onStateChange(State state);
            }

        };
        o = new com.nuance.nmdp.speechkit.GenericCommand.Listener() {

            private NVASpeechKit a;

            public void onComplete(GenericCommand genericcommand, GenericResult genericresult, SpeechError speecherror)
            {
                if (speecherror != null)
                {
                    MMLog.e("NVASpeechKit", (new StringBuilder("GenericCommand listener. Error: ")).append(speecherror.getErrorDetail()).toString());
                } else
                {
                    MMLog.b("NVASpeechKit", (new StringBuilder("GenericCommand listener. Success: ")).append(genericresult.getQueryResult()).toString());
                }
                NVASpeechKit.g(a);
            }

            
            {
                a = NVASpeechKit.this;
                super();
            }
        };
        p = new com.nuance.nmdp.speechkit.DataUploadCommand.Listener() {

            private NVASpeechKit a;

            private void a(DataUploadCommand datauploadcommand)
            {
                if (NVASpeechKit.c(a) != null && NVASpeechKit.h(a) == datauploadcommand)
                {
                    if (NVASpeechKit.i(a) == CustomWordsOp.Add)
                    {
                        NVASpeechKit.c(a).onCustomWordsAdded();
                    } else
                    {
                        NVASpeechKit.c(a).onCustomWordsDeleted();
                    }
                }
                NVASpeechKit.j(a);
            }

            public void onError(DataUploadCommand datauploadcommand, SpeechError speecherror)
            {
                MMLog.e("NVASpeechKit", (new StringBuilder("DataUploadCommand listener error. command:")).append(datauploadcommand.toString()).append(" Error:").append(speecherror.getErrorDetail()).toString());
                a(datauploadcommand);
            }

            public void onResults(DataUploadCommand datauploadcommand, DataUploadResult datauploadresult)
            {
                MMLog.b("NVASpeechKit", (new StringBuilder("DataUploadCommand listener successful command:")).append(datauploadcommand.toString()).append(" isVocRegenerated:").append(datauploadresult.isVocRegenerated()).append(" results:").append(datauploadresult.toString()).toString());
                a(datauploadcommand);
            }

            
            {
                a = NVASpeechKit.this;
                super();
            }

            private class CustomWordsOp extends Enum
            {

                private static final CustomWordsOp $VALUES[];
                public static final CustomWordsOp Add;
                public static final CustomWordsOp Remove;

                public static CustomWordsOp valueOf(String s1)
                {
                    return (CustomWordsOp)Enum.valueOf(com/millennialmedia/android/NVASpeechKit$CustomWordsOp, s1);
                }

                public static CustomWordsOp[] values()
                {
                    return (CustomWordsOp[])$VALUES.clone();
                }

                static 
                {
                    Add = new CustomWordsOp("Add", 0);
                    Remove = new CustomWordsOp("Remove", 1);
                    $VALUES = (new CustomWordsOp[] {
                        Add, Remove
                    });
                }

                private CustomWordsOp(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        q = new Listener() {

            private NVASpeechKit a;

            public void onAudioLevelUpdate(double d1)
            {
                MMWebView mmwebview1 = a.a();
                if (mmwebview1 != null)
                {
                    mmwebview1.loadUrl((new StringBuilder("javascript:MMJS.sdk.audioLevelChange(")).append(d1).append(")").toString());
                }
            }

            public void onAudioSampleUpdate(double d1)
            {
                MMWebView mmwebview1 = a.a();
                if (mmwebview1 != null)
                {
                    mmwebview1.loadUrl((new StringBuilder("javascript:MMJS.sdk.backgroundAudioLevel(")).append(d1).append(")").toString());
                }
            }

            public void onCustomWordsAdded()
            {
            }

            public void onCustomWordsDeleted()
            {
            }

            public void onError()
            {
            }

            public void onResults()
            {
                Object obj1 = NVASpeechKit.a(a.getResults());
                Object obj = a;
                obj1 = ((JSONArray) (obj1)).toString();
                obj = ((NVASpeechKit) (obj)).a();
                if (obj != null)
                {
                    ((MMWebView) (obj)).loadUrl((new StringBuilder("javascript:MMJS.sdk.recognitionResult(")).append(((String) (obj1))).append(")").toString());
                }
            }

            public void onStateChange(State state)
            {
                class _cls8
                {

                    static final int a[];

                    static 
                    {
                        a = new int[State.values().length];
                        try
                        {
                            a[State.ERROR.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[State.PROCESSING.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[State.READY.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[State.RECORDING.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[State.VOCALIZING.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls8.a[state.ordinal()];
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
                if ((state = a.a()) != null)
                {
                    state.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                state = a.a();
                if (state != null)
                {
                    state.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
                    return;
                }
                if (true) goto _L1; else goto _L4
_L4:
                state = a.a();
                if (state != null)
                {
                    state.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
                    return;
                }
                if (true)
                {
                    continue; /* Loop/switch isn't completed */
                }
_L5:
                state = a.a();
                if (state != null)
                {
                    state.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
                state = a.a();
                if (state != null)
                {
                    state.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
                    return;
                }
                if (true) goto _L1; else goto _L7
_L7:
            }

            
            {
                a = NVASpeechKit.this;
                super();
            }
        };
        if (mmwebview != null)
        {
            b = new WeakReference(mmwebview);
            mmwebview = mmwebview.getContext().getApplicationContext();
            if (t == null)
            {
                t = mmwebview.getApplicationContext().getPackageName();
            }
        }
        h = State.READY;
    }

    static Recognizer a(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.g;
    }

    static String a(NVASpeechKit nvaspeechkit, String s1)
    {
        nvaspeechkit.l = s1;
        return s1;
    }

    static JSONArray a(Result aresult[])
    {
        return b(aresult);
    }

    private void a(State state)
    {
        this;
        JVM INSTR monitorenter ;
        MMLog.b("NVASpeechKit", (new StringBuilder("recording results returned. state=")).append(state).toString());
        State state1 = h;
        h = state;
        if (q != null && h != state1)
        {
            q.onStateChange(state);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        state;
        throw state;
    }

    static void a(NVASpeechKit nvaspeechkit, State state)
    {
        nvaspeechkit.a(state);
    }

    static void a(NVASpeechKit nvaspeechkit, SpeechError speecherror)
    {
        switch (speecherror.getErrorCode())
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            if (nvaspeechkit.q != null)
            {
                nvaspeechkit.q.onError();
                nvaspeechkit.a(State.ERROR);
                if (speecherror == null)
                {
                    speecherror = "No Error given";
                } else
                {
                    speecherror = (new StringBuilder("Speech Kit Error code:")).append(speecherror.getErrorCode()).append(" detail:").append(speecherror.getErrorDetail()).append(" suggestions:").append(speecherror.getSuggestion()).toString();
                }
                nvaspeechkit = nvaspeechkit.a();
                if (nvaspeechkit != null)
                {
                    nvaspeechkit.loadUrl((new StringBuilder("javascript:MMJS.sdk.voiceError('")).append(speecherror).append("')").toString());
                }
            }
            return;

        case 2: // '\002'
            if (!nvaspeechkit.i.b)
            {
                nvaspeechkit.a(State.PROCESSING);
            }
            nvaspeechkit._results = new Result[0];
            nvaspeechkit.c();
            return;

        case 5: // '\005'
            nvaspeechkit.a(State.READY);
            nvaspeechkit.g = null;
            return;
        }
    }

    static void a(NVASpeechKit nvaspeechkit, List list)
    {
        MMLog.b("NVASpeechKit", "processResults called.");
        nvaspeechkit._results = new Result[list.size()];
        list = list.iterator();
        for (int i1 = 0; list.hasNext(); i1++)
        {
            DetailedResult detailedresult = (DetailedResult)list.next();
            nvaspeechkit._results[i1] = nvaspeechkit. new Result(detailedresult.toString(), detailedresult.getConfidenceScore());
        }

    }

    static AudioLevelTracker b(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.i;
    }

    private String b()
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj = s;
_L10:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        if (b == null) goto _L4; else goto _L3
_L3:
        obj = (MMWebView)b.get();
        if (obj == null) goto _L4; else goto _L5
_L5:
        obj = ((MMWebView) (obj)).getContext();
          goto _L6
_L8:
        obj = android.provider.Settings.Secure.getString(((Context) (obj)).getContentResolver(), "android_id");
        if (obj == null)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        obj = MMSDK.a(MessageDigest.getInstance("SHA1").digest(((String) (obj)).getBytes()));
        s = ((String) (obj));
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        obj;
        MMLog.a("NVASpeechKit", "Problem with nuanceid", ((Throwable) (obj)));
        obj = null;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = null;
_L6:
        if (obj != null) goto _L8; else goto _L7
_L7:
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static JSONArray b(Result aresult[])
    {
        JSONArray jsonarray = new JSONArray();
        int i1 = 0;
        do
        {
            if (i1 >= aresult.length)
            {
                break;
            }
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("score", (new StringBuilder()).append(aresult[i1].getResultScore()).toString());
                jsonobject.put("result", aresult[i1].getResultString());
                jsonarray.put(jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (Result aresult[])
            {
                MMLog.a("NVASpeechKit", "JSON creation error.", aresult);
                return null;
            }
            i1++;
        } while (true);
        return jsonarray;
    }

    static Listener c(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.q;
    }

    private void c()
    {
        if (q != null && _results != null)
        {
            if (i.b)
            {
                q.onAudioSampleUpdate(i.a);
                i.reset();
            } else
            {
                q.onResults();
            }
        }
        a(State.READY);
        g = null;
    }

    static State d(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.h;
    }

    private void d()
    {
        if (d != null)
        {
            d.removeCallbacks(m);
            d.removeCallbacks(n);
        }
    }

    static Runnable e(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.n;
    }

    static Handler f(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.d;
    }

    static void g(NVASpeechKit nvaspeechkit)
    {
        nvaspeechkit.c();
    }

    static DataUploadCommand h(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.j;
    }

    static CustomWordsOp i(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.k;
    }

    static DataUploadCommand j(NVASpeechKit nvaspeechkit)
    {
        nvaspeechkit.j = null;
        return null;
    }

    static void k(NVASpeechKit nvaspeechkit)
    {
        nvaspeechkit.d.removeCallbacks(nvaspeechkit.n);
        nvaspeechkit.d.postDelayed(nvaspeechkit.n, 50L);
    }

    static Runnable l(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.m;
    }

    static void m(NVASpeechKit nvaspeechkit)
    {
        nvaspeechkit.d();
    }

    static SpeechKit n(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.a;
    }

    static Recognizer o(NVASpeechKit nvaspeechkit)
    {
        nvaspeechkit.g = null;
        return null;
    }

    static String p(NVASpeechKit nvaspeechkit)
    {
        return nvaspeechkit.l;
    }

    final MMWebView a()
    {
        if (b != null)
        {
            return (MMWebView)b.get();
        } else
        {
            return null;
        }
    }

    public void cancelRecording()
    {
        if (g != null)
        {
            MMLog.b("NVASpeechKit", "cancel RECORDING");
            g.cancel();
            g = null;
            a(State.READY);
        }
    }

    public boolean endRecording()
    {
        if (g != null)
        {
            MMLog.b("NVASpeechKit", "end RECORDING");
            g.stopRecording();
            g = null;
            return true;
        } else
        {
            return false;
        }
    }

    public Result[] getResults()
    {
        return _results;
    }

    public State getState()
    {
        this;
        JVM INSTR monitorenter ;
        State state = h;
        this;
        JVM INSTR monitorexit ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean initialize(HandShake.NuanceCredentials nuancecredentials, Context context)
    {
        MMLog.b("NVASpeechKit", "initialize called.");
        if (nuancecredentials == null || context == null)
        {
            return false;
        }
        r = nuancecredentials;
        if (a != null)
        {
            try
            {
                a.connect();
            }
            catch (IllegalStateException illegalstateexception)
            {
                a = null;
            }
        }
        if (a == null)
        {
            MMLog.b("NVASpeechKit", nuancecredentials.toString());
            a = SpeechKit.initialize(context, "1.0", null, null, 0, false, null, com.nuance.nmdp.speechkit.SpeechKit.CmdSetType.NVC);
            f = new com.nuance.nmdp.speechkit.Vocalizer.Listener() {

                private NVASpeechKit a;

                public void onSpeakingBegin(Vocalizer vocalizer, String s1, Object obj)
                {
                    MMLog.b("NVASpeechKit", (new StringBuilder("Vocalization begins. text=")).append(s1).toString());
                    NVASpeechKit.a(a, State.VOCALIZING);
                }

                public void onSpeakingDone(Vocalizer vocalizer, String s1, SpeechError speecherror, Object obj)
                {
                    MMLog.b("NVASpeechKit", "Vocalization has ended.");
                    if (speecherror != null)
                    {
                        MMLog.e("NVASpeechKit", (new StringBuilder("Vocalizer error: ")).append(speecherror.getErrorDetail()).toString());
                        NVASpeechKit.a(a, speecherror);
                        return;
                    } else
                    {
                        NVASpeechKit.a(a, State.READY);
                        return;
                    }
                }

            
            {
                a = NVASpeechKit.this;
                super();
            }
            };
            e = new com.nuance.nmdp.speechkit.Recognizer.Listener() {

                private NVASpeechKit a;

                public void onError(Recognizer recognizer, SpeechError speecherror)
                {
                    MMLog.b("NVASpeechKit", (new StringBuilder("Speech Kit Error code:")).append(speecherror.getErrorCode()).append(" detail:").append(speecherror.getErrorDetail()).append(" suggestions:").append(speecherror.getSuggestion()).toString());
                    NVASpeechKit.m(a);
                    NVASpeechKit.a(a, speecherror);
                    NVASpeechKit.o(a);
                    if (NVASpeechKit.n(a) != null)
                    {
                        MMLog.b("NVASpeechKit", (new StringBuilder("Recognizer.Listener.onError: session id [")).append(NVASpeechKit.n(a).getSessionId()).append("]").toString());
                    }
                }

                public void onRecordingBegin(Recognizer recognizer)
                {
                    MMLog.b("NVASpeechKit", "recording begins");
                    a._results = null;
                    if (!NVASpeechKit.b(a).isTrackingAudioSample())
                    {
                        NVASpeechKit.a(a, State.RECORDING);
                    }
                    NVASpeechKit.k(a);
                    if (NVASpeechKit.b(a).isTrackingAudioSample())
                    {
                        NVASpeechKit.f(a).removeCallbacks(NVASpeechKit.l(a));
                        NVASpeechKit.f(a).postDelayed(NVASpeechKit.l(a), 2000L);
                    }
                }

                public void onRecordingDone(Recognizer recognizer)
                {
                    MMLog.b("NVASpeechKit", "recording has ended");
                    NVASpeechKit.m(a);
                    if (!NVASpeechKit.b(a).isTrackingAudioSample())
                    {
                        NVASpeechKit.a(a, State.PROCESSING);
                    }
                    if (NVASpeechKit.n(a) != null)
                    {
                        NVASpeechKit.a(a, NVASpeechKit.n(a).getSessionId());
                    }
                }

                public void onResults(Recognizer recognizer, Recognition recognition)
                {
                    MMLog.b("NVASpeechKit", "recording results returned.");
                    NVASpeechKit.m(a);
                    if (!NVASpeechKit.b(a).b)
                    {
                        NVASpeechKit.a(a, recognition.getDetailedResults());
                        if (NVASpeechKit.p(a) != null)
                        {
                            MMLog.b("NVASpeechKit", (new StringBuilder("Recognizer.Listener.onResults: session id [")).append(NVASpeechKit.p(a)).append("]").toString());
                        }
                        a.logEvent();
                        return;
                    } else
                    {
                        a._results = new Result[0];
                        NVASpeechKit.g(a);
                        return;
                    }
                }

            
            {
                a = NVASpeechKit.this;
                super();
            }
            };
            d = new Handler(Looper.getMainLooper());
            a.connect();
            a(State.READY);
            return true;
        } else
        {
            MMLog.b("NVASpeechKit", "Already initialized. Skipping.");
            return false;
        }
    }

    public void logEvent()
    {
        if (a == null)
        {
            return;
        }
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        dictionary.put("nva_ad_network_id", "MillenialMedia");
        dictionary.put("nva_device_id", b());
        dictionary.put("nva_ad_publisher_id", t);
        Object obj;
        String s1;
        if (r != null && !TextUtils.isEmpty(null))
        {
            dictionary.put("nva_ad_session_id", null);
            s1 = null;
        } else
        {
            s1 = "";
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        obj = (MMWebView)b.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        if (((MMWebView) (obj)).j != null && !TextUtils.isEmpty(((MMWebView) (obj)).j.acid))
        {
            obj = ((MMWebView) (obj)).j.acid;
        } else
        {
            obj = "DEFAULT_AD_ID";
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            dictionary.put("nva_ad_id", ((String) (obj)));
        }
        if (l != null)
        {
            dictionary.put("nva_nvc_session_id", l);
            l = null;
        } else
        {
            a.getSessionId();
        }
        MMLog.b("NVASpeechKit", (new StringBuilder("Sending log revision command to server. sessionId[")).append(a.getSessionId()).append("] deviceId[").append(b()).append("] adId[").append(((String) (obj))).append("] mmSessionId[").append(s1).append("]").toString());
        a.createLogRevisionCmd("NVA_LOG_EVENT", dictionary, a.getSessionId(), o, d).start();
        return;
        obj = "DEFAULT_AD_ID";
        break MISSING_BLOCK_LABEL_122;
    }

    public void release()
    {
        MMLog.b("NVASpeechKit", "release called.");
        stopActions();
        d();
        if (a != null)
        {
            a.release();
            a(State.READY);
            a = null;
        }
        j = null;
        if (a() != null)
        {
            b.clear();
        }
    }

    public void setSpeechKitListener(Listener listener)
    {
        q = listener;
    }

    public boolean startRecording(String s1)
    {
        MMLog.b("NVASpeechKit", "RECORDING INVOKED.");
        if (h == State.READY && a != null)
        {
            l = null;
            g = a.createRecognizer("dictation", 1, s1, e, d);
            MMLog.b("NVASpeechKit", "START RECORDING");
            g.start();
            return true;
        } else
        {
            return false;
        }
    }

    public void startSampleRecording()
    {
        i.startTrackingAudioSample();
        startRecording("en_US");
    }

    public void stopActions()
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        a.cancelCurrent();
        return;
        Exception exception;
        exception;
        MMLog.a("NVASpeechKit", "No speech kit to disconnect.", exception);
        return;
    }

    public boolean textToSpeech(String s1, String s2)
    {
        MMLog.b("NVASpeechKit", "TTS INVOKED.");
        if (h == State.READY && a != null)
        {
            c = a.createVocalizerWithLanguage(s2, f, d);
            c.speakString(s1, this);
            return true;
        } else
        {
            return false;
        }
    }

    public void updateCustomWords(CustomWordsOp customwordsop, String as[])
    {
        if (a == null)
        {
            return;
        }
        DataBlock datablock = new DataBlock();
        Object obj1 = new StringBuilder("Creating dataupload command and ");
        Object obj;
        int k1;
        if (customwordsop == CustomWordsOp.Add)
        {
            obj = "adding";
        } else
        {
            obj = "deleting";
        }
        MMLog.b("NVASpeechKit", ((StringBuilder) (obj1)).append(((String) (obj))).append(" words.").toString());
        obj1 = new Data("nva_custom_word_uploads", com.nuance.nmdp.speechkit.util.dataupload.Data.DataType.CUSTOMWORDS);
        if (customwordsop == CustomWordsOp.Add)
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
            MMLog.b("NVASpeechKit", (new StringBuilder("\tword: '")).append(s1).append("'").toString());
        }

        ((Data) (obj1)).addAction(((Action) (obj)));
        datablock.addData(((Data) (obj1)));
        int j1 = datablock.getChecksum();
        k = customwordsop;
        j = a.createDataUploadCmd(datablock, j1, j1, p, d);
        j.start();
    }


    private class AudioLevelTracker
    {

        double a;
        boolean b;
        private double c;
        private int d;

        static double a(double d1)
        {
            return Math.min(9.9900000000000002D, Math.max(Math.floor(d1 - 40D) / 4.0040040040040044D, 0.0D));
        }

        public boolean isTrackingAudioSample()
        {
            return b;
        }

        public void reset()
        {
            a = 0.0D;
            d = 0;
            b = false;
        }

        public void startTrackingAudioSample()
        {
            reset();
            b = true;
        }

        public boolean update(double d1)
        {
            double d2 = a;
            double d3 = c;
            c = d1;
            d = d + 1;
            for (a = (d2 * (double)(d - 1) + d1) / (double)d; b || c == d3;)
            {
                return false;
            }

            return true;
        }

        public AudioLevelTracker()
        {
            reset();
        }
    }


    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State ERROR;
        public static final State PROCESSING;
        public static final State READY;
        public static final State RECORDING;
        public static final State VOCALIZING;
        private String name;

        public static State valueOf(String s1)
        {
            return (State)Enum.valueOf(com/millennialmedia/android/NVASpeechKit$State, s1);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        public final String toString()
        {
            return name;
        }

        static 
        {
            ERROR = new State("ERROR", 0, "error");
            VOCALIZING = new State("VOCALIZING", 1, "vocalizing");
            RECORDING = new State("RECORDING", 2, "recording");
            READY = new State("READY", 3, "ready");
            PROCESSING = new State("PROCESSING", 4, "processing");
            $VALUES = (new State[] {
                ERROR, VOCALIZING, RECORDING, READY, PROCESSING
            });
        }

        private State(String s1, int i1, String s2)
        {
            super(s1, i1);
            name = s2;
        }
    }


    private class Result
    {

        public final int resultScore;
        public final String resultString;

        public int getResultScore()
        {
            return resultScore;
        }

        public String getResultString()
        {
            return resultString;
        }

        public Result(String s1, double d1)
        {
            resultString = s1;
            resultScore = (int)d1;
        }
    }

}
