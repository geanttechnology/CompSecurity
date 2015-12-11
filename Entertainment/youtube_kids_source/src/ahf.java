// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.google.android.speech.Recognizer;
import com.google.android.speech.RecognizerImpl;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.audio.AudioController;
import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.audio.MicrophoneInputStreamFactory;
import com.google.android.speech.embedded.Greco3DataManager;
import com.google.android.speech.embedded.Greco3EngineManager;
import com.google.android.speech.embedded.Greco3Mode;
import com.google.android.speech.internal.DefaultCallbackFactory;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.params.NetworkRequestProducerParams;
import com.google.android.speech.params.RecognitionEngineParams;
import com.google.android.speech.utils.NetworkInformation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ahf
{

    private static final int c[] = {
        2, 3, 4, 5, 7, 8
    };
    private static eyc f;
    private static ahf x;
    public aho a;
    public boolean b;
    private final Context d;
    private ahp e;
    private List g;
    private String h;
    private String i;
    private String j;
    private AudioController k;
    private AudioInputStreamFactory l;
    private Greco3EngineManager m;
    private NetworkInformation n;
    private NetworkRequestProducerParams o;
    private RecognitionEngineParams p;
    private com.google.android.speech.params.RecognitionEngineParams.EmbeddedParams q;
    private com.google.android.speech.params.RecognitionEngineParams.NetworkParams r;
    private Recognizer s;
    private ScheduledExecutorService t;
    private dax u;
    private agw v;
    private SpeechSettings w;
    private RecognitionEventListener y;

    private ahf(Context context, ScheduledExecutorService scheduledexecutorservice)
    {
        a = null;
        y = new ahn(this);
        d = context;
        t = scheduledexecutorservice;
        g = new ArrayList();
        e = new ahp(this, context);
        b(d);
        context = a.b("GrecoExecutor", false);
        if (k == null)
        {
            scheduledexecutorservice = new ahg(this);
            ahh ahh1 = new ahh(this);
            k = new AudioController(d, f(), g(), scheduledexecutorservice, ahh1, d().buildSpeechLibLogger(), new dbg(h()));
            AudioController audiocontroller = k;
            if (l == null)
            {
                l = new MicrophoneInputStreamFactory(16000, false, scheduledexecutorservice, ahh1, d().buildSpeechLibLogger(), false);
            }
            audiocontroller.setRawInputStreamFactory(l);
        }
        s = RecognizerImpl.create(context, k, d());
    }

    public static ahf a(Context context)
    {
        if (x == null)
        {
            x = new ahf(context, Executors.newScheduledThreadPool(5));
        }
        return x;
    }

    static Context a(ahf ahf1)
    {
        return ahf1.d;
    }

    static String a(ahf ahf1, ewk ewk1)
    {
        if (ewk1.e != null)
        {
            ahf1 = ewk1.e;
            if (ahf1.d() > 0)
            {
                ahf1 = ahf1.a(0);
                if (((ewh) (ahf1)).a)
                {
                    return ((ewh) (ahf1)).b;
                }
            }
        }
        return "";
    }

    static String a(ahf ahf1, String s1)
    {
        ahf1.h = s1;
        return s1;
    }

    private static eyc b(Context context)
    {
        if (f == null)
        {
            try
            {
                context = emm.a(context.getResources().openRawResource(0x7f080005));
                f = (eyc)(new eyc()).a(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Unable to load configuration", context);
            }
        }
        return f;
    }

    static String b(ahf ahf1)
    {
        return ahf1.h;
    }

    static String b(ahf ahf1, ewk ewk1)
    {
        if (ewk1.i != null)
        {
            ahf1 = ewk1.i;
            if (ahf1.d() > 0)
            {
                ahf1 = ahf1.a(0);
                if (((ewh) (ahf1)).a)
                {
                    return ((ewh) (ahf1)).b;
                }
            }
        }
        return "";
    }

    static String b(ahf ahf1, String s1)
    {
        ahf1.i = s1;
        return s1;
    }

    static String c(ahf ahf1)
    {
        return ahf1.i;
    }

    static String c(ahf ahf1, String s1)
    {
        ahf1.j = s1;
        return s1;
    }

    static String d(ahf ahf1)
    {
        return ahf1.j;
    }

    static aho e(ahf ahf1)
    {
        return ahf1.a;
    }

    static eyc e()
    {
        return f;
    }

    private SpeechSettings f()
    {
        if (w == null)
        {
            w = new ahq(d, b(d));
        }
        return w;
    }

    private dax g()
    {
        if (u == null)
        {
            u = new dax();
        }
        return u;
    }

    private NetworkInformation h()
    {
        this;
        JVM INSTR monitorenter ;
        NetworkInformation networkinformation;
        if (n == null)
        {
            n = new NetworkInformation((TelephonyManager)d.getSystemService("phone"), (ConnectivityManager)d.getSystemService("connectivity"));
        }
        networkinformation = n;
        this;
        JVM INSTR monitorexit ;
        return networkinformation;
        Exception exception;
        exception;
        throw exception;
    }

    private void i()
    {
        if (a != null)
        {
            a.c();
        }
    }

    public final void a()
    {
        b = true;
        j = "";
        h = "";
        i = "";
        Object obj = g();
        g.clear();
        if (a != null)
        {
            a.a(((dax) (obj)));
        }
        Recognizer recognizer = s;
        com.google.android.speech.params.AudioInputParams.Builder builder = new com.google.android.speech.params.AudioInputParams.Builder();
        builder.setPlayBeepEnabled(false);
        builder.setSamplingRate(16000);
        builder.setEncoding(9);
        String s1 = d.getPackageName();
        if (a.d(d))
        {
            if (a.e(d))
            {
                obj = String.valueOf(s1).concat("/dev");
            } else
            {
                obj = String.valueOf(s1).concat("/dogfood");
            }
        } else
        {
            obj = s1;
        }
        recognizer.startListening((new com.google.android.speech.params.SessionParams.Builder()).setTriggerApplication(s1).setApplicationIdOverride(((String) (obj))).setAudioInputParams(builder.build()).setGreco3Grammar(null).setPartialResultsEnabled(true).setProfanityFilterEnabled(true).setServiceOverride("recognizer").setGreco3Mode(Greco3Mode.ENDPOINTER_VOICESEARCH).setMode(2).setNoSpeechDetectedEnabled(true).build(), y, e, null);
    }

    public final void b()
    {
        b = false;
        s.stopListening(y);
        i();
    }

    public final void c()
    {
        b = false;
        s.cancel(y);
        i();
    }

    public agw d()
    {
        if (v == null)
        {
            if (p == null)
            {
                if (q == null)
                {
                    ahi ahi1 = new ahi(this);
                    DefaultCallbackFactory defaultcallbackfactory = new DefaultCallbackFactory();
                    if (m == null)
                    {
                        Greco3DataManager greco3datamanager = new Greco3DataManager(d, null, c, t, e);
                        greco3datamanager.setPathDeleter(new ahj(this));
                        m = new Greco3EngineManager(greco3datamanager, null, new agk(d.getResources()));
                    }
                    q = new com.google.android.speech.params.RecognitionEngineParams.EmbeddedParams(defaultcallbackfactory, m, ahi1, g(), f(), 2, 16000);
                }
                com.google.android.speech.params.RecognitionEngineParams.EmbeddedParams embeddedparams = q;
                if (r == null)
                {
                    dab dab1 = new dab(new ahk(this), new czp(new ahl(this)));
                    ahm ahm1 = new ahm(this);
                    if (o == null)
                    {
                        SpeechSettings speechsettings = f();
                        NetworkInformation networkinformation = h();
                        o = new NetworkRequestProducerParams(new ags(), networkinformation, new agt(), new ago(), speechsettings, new agp(), new agq(), new agr());
                    }
                    r = new com.google.android.speech.params.RecognitionEngineParams.NetworkParams(dab1, dab1, ahm1, o);
                }
                p = new RecognitionEngineParams(embeddedparams, r, null, null);
            }
            v = new agw(p, f());
        }
        return v;
    }

    static 
    {
        ahf.getSimpleName();
    }
}
