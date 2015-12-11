// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.core.ScanCardActivity;
import com.jumio.netswipe.sdk.enums.ErrorCase;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

// Referenced classes of package netswipe:
//            cd, ck, i, am, 
//            r, t, u, v, 
//            w, x, y, z, 
//            cz, al, c, ce, 
//            cl, p, de, aa, 
//            ab, cw, ad, ae, 
//            af, au, ai, ar, 
//            aq, dh, ag, ah, 
//            q, ac, h

public class o
    implements cd, ck, i
{

    private ai A;
    private ScanCardActivity B;
    private MenuItem C;
    private ArrayList D;
    private NetswipeCardInformation E;
    private ErrorCase F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.MenuItem.OnMenuItemClickListener J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private android.view.View.OnClickListener M;
    private Handler N;
    private String a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private String k;
    private String l;
    private ArrayList m;
    private ArrayList n;
    private am o;
    private cl p;
    private c q;
    private cz r;
    private OrientationEventListener s;
    private boolean t;
    private ce u;
    private boolean v;
    private boolean w;
    private boolean x;
    private de y;
    private long z;

    public o(ScanCardActivity scancardactivity)
    {
        a = "";
        b = "";
        c = true;
        d = true;
        e = true;
        f = false;
        g = false;
        h = false;
        i = false;
        j = -1;
        k = "";
        l = "";
        o = am.a;
        t = false;
        v = false;
        w = false;
        x = false;
        y = null;
        z = 0L;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = new r(this);
        H = new t(this);
        I = new u(this);
        J = new v(this);
        K = new w(this);
        L = new x(this);
        M = new y(this);
        N = new z(this);
        B = scancardactivity;
        Intent intent = scancardactivity.getIntent();
        a = intent.getStringExtra("INTENT_EXTRA_API_TOKEN");
        b = intent.getStringExtra("INTENT_EXTRA_API_SECRET");
        c = intent.getBooleanExtra("INTENT_EXTRA_MANUAL_ENTRY", true);
        d = intent.getBooleanExtra("INTENT_EXTRA_EXPIRY_REQUIRED", true);
        e = intent.getBooleanExtra("INTENT_EXTRA_CVV_REQUIRED", true);
        f = intent.getBooleanExtra("INTENT_EXTRA_VIBRATION_ENABLED", false);
        g = intent.getBooleanExtra("INTENT_EXTRA_CARD_HOLDER_NAME_REQUIRED", false);
        h = intent.getBooleanExtra("INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE", false);
        i = intent.getBooleanExtra("INTENT_EXTRA_SORTCODE_ACCOUNTNUMBER_REQUIRED", false);
        j = intent.getIntExtra("INTENT_EXTRA_SOUND_RESOURCE_ID", -1);
        k = intent.getStringExtra("INTENT_EXTRA_REPORTING_CRITERIA");
        n = (ArrayList)intent.getSerializableExtra("INTENT_EXTRA_CUSTOM_FIELDS");
        m = (ArrayList)intent.getSerializableExtra("INTENT_EXTRA_SUPPORTED_CREDIT_CARD_TYPES");
        scancardactivity.initLayout(m, H, I);
        r = new cz(scancardactivity, al.a);
        q = new c(scancardactivity, scancardactivity.textureView, scancardactivity.blurView, this, r);
        u = new ce(scancardactivity, r, this);
        u.a(d);
        u.b(g);
        u.c(i);
        p = new cl(scancardactivity, a, b, this);
        p.a(k);
        z = System.currentTimeMillis();
        s = new p(this, scancardactivity, 1);
        E = new NetswipeCardInformation();
        D = new ArrayList();
    }

    static long a(o o1, long l1)
    {
        o1.z = l1;
        return l1;
    }

    static NetswipeCardInformation a(o o1, NetswipeCardInformation netswipecardinformation)
    {
        o1.E = netswipecardinformation;
        return netswipecardinformation;
    }

    static ErrorCase a(o o1, ErrorCase errorcase)
    {
        o1.F = errorcase;
        return errorcase;
    }

    static String a(o o1, String s1)
    {
        o1.l = s1;
        return s1;
    }

    static am a(o o1, am am1)
    {
        o1.o = am1;
        return am1;
    }

    static cz a(o o1)
    {
        return o1.r;
    }

    private void a(String s1, long l1)
    {
        if (y == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        y.put(s1, l1);
        return;
        s1;
        s1.printStackTrace();
        return;
    }

    static void a(o o1, String s1, long l1)
    {
        o1.a(s1, l1);
    }

    static boolean a(o o1, boolean flag)
    {
        o1.v = flag;
        return flag;
    }

    static c b(o o1)
    {
        return o1.q;
    }

    static boolean b(o o1, boolean flag)
    {
        o1.w = flag;
        return flag;
    }

    static ScanCardActivity c(o o1)
    {
        return o1.B;
    }

    static boolean d(o o1)
    {
        return o1.g;
    }

    static boolean e(o o1)
    {
        return o1.i;
    }

    static NetswipeCardInformation f(o o1)
    {
        return o1.E;
    }

    static MenuItem g(o o1)
    {
        return o1.C;
    }

    static android.view.View.OnClickListener h(o o1)
    {
        return o1.L;
    }

    private void h()
    {
        B.runOnUiThread(new aa(this));
        MediaPlayer mediaplayer;
        Exception exception;
        if (f)
        {
            try
            {
                ((Vibrator)B.getSystemService("vibrator")).vibrate(100L);
            }
            catch (Exception exception1) { }
        }
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mediaplayer = MediaPlayer.create(B, j);
        mediaplayer.setOnCompletionListener(new ab(this));
        mediaplayer.start();
        return;
        exception;
    }

    static android.view.View.OnClickListener i(o o1)
    {
        return o1.M;
    }

    static ce j(o o1)
    {
        return o1.u;
    }

    static String k(o o1)
    {
        return o1.l;
    }

    static cl l(o o1)
    {
        return o1.p;
    }

    static long m(o o1)
    {
        return o1.z;
    }

    static de n(o o1)
    {
        return o1.y;
    }

    static boolean o(o o1)
    {
        return o1.d;
    }

    static ai p(o o1)
    {
        return o1.A;
    }

    static android.view.View.OnClickListener q(o o1)
    {
        return o1.K;
    }

    static boolean r(o o1)
    {
        return o1.e;
    }

    static ArrayList s(o o1)
    {
        return o1.n;
    }

    static ArrayList t(o o1)
    {
        return o1.m;
    }

    static boolean u(o o1)
    {
        return o1.c;
    }

    static String v(o o1)
    {
        return o1.k;
    }

    static Handler w(o o1)
    {
        return o1.N;
    }

    static boolean x(o o1)
    {
        return o1.v;
    }

    static boolean y(o o1)
    {
        return o1.w;
    }

    static boolean z(o o1)
    {
        return o1.h;
    }

    public ErrorCase a(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, StringBuilder stringbuilder, boolean flag, long l1)
    {
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER)) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            return ErrorCase.CARD_NOT_DETECTED;
        }
        if (!cw.c(stringbuilder))
        {
            return ErrorCase.CARD_NOT_DETECTED;
        }
        E.clear();
        v = false;
        w = false;
        y = new de();
        B.runOnUiThread(new ad(this));
        E.setCardNumber(stringbuilder);
        a("ocrCardNumber", l1);
        if (!d)
        {
            h();
        }
        if (!m.contains(E.getCardType()))
        {
            return ErrorCase.CREDIT_CARD_NOT_SUPPORTED;
        }
          goto _L3
_L2:
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY)) goto _L5; else goto _L4
_L4:
        if (flag)
        {
            fieldname = Pattern.compile(cw.a());
            StringBuilder stringbuilder1 = new StringBuilder();
            stringbuilder1.append(stringbuilder.subSequence(0, 2));
            stringbuilder1.append(" / ");
            stringbuilder1.append(stringbuilder.subSequence(stringbuilder.length() - 2, stringbuilder.length()));
            if (!fieldname.matcher(stringbuilder1).matches())
            {
                return ErrorCase.CREDIT_CARD_EXPIRED;
            }
            E.setExpiryDateMonth(new StringBuilder(stringbuilder.subSequence(0, 2)));
            E.setExpiryDateYear(new StringBuilder(stringbuilder.subSequence(stringbuilder.length() - 2, stringbuilder.length())));
        }
        a("ocrExpiryDate", l1);
        h();
_L3:
        return null;
_L5:
        if (fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE))
        {
            NetswipeCardInformation netswipecardinformation = E;
            if (flag)
            {
                fieldname = stringbuilder;
            } else
            {
                fieldname = new StringBuilder("");
            }
            netswipecardinformation.setSortCode(fieldname);
            B.runOnUiThread(new ae(this, flag, stringbuilder));
            a("ocrSortCode", l1);
        } else
        if (fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM))
        {
            fieldname = E;
            if (!flag)
            {
                stringbuilder = new StringBuilder("");
            }
            fieldname.setAccountNumber(stringbuilder);
            a("ocrAccountNumber", l1);
        } else
        if (fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME))
        {
            E.setCardHolderName(stringbuilder);
            B.runOnUiThread(new af(this));
            a("ocrCardHolderName", l1);
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void a()
    {
        B.bottomButtonBar.setCameraButtonEnabled(q.e());
        B.bottomButtonBar.setOnClickListener(G);
        boolean flag = q.a();
        B.bottomButtonBar.setFlashButtonEnabled(flag);
        B.bottomButtonBar.b();
        if (flag)
        {
            A = new ai(this, B.bottomButtonBar.getFlashGlower());
            A.start();
        }
    }

    public void a(Configuration configuration)
    {
        boolean flag = true;
        if (q != null)
        {
            c c1 = q;
            if (configuration.orientation != 1)
            {
                flag = false;
            }
            c1.d(flag);
        }
    }

    public void a(Menu menu)
    {
        C = menu.add(1, 1, 1, ar.a(B, "activity_title_manual_entry"));
        C.setEnabled(c);
        C.setVisible(c);
        C.setIcon(aq.b(B, "icon_manual_entry"));
        C.setShowAsAction(2);
        C.setOnMenuItemClickListener(J);
    }

    public void a(ErrorCase errorcase)
    {
        b(errorcase);
        dh.a((new StringBuilder()).append("RemoteManager error thrown: ").append(errorcase).toString());
    }

    public void a(String s1)
    {
        l = s1;
        D.add(s1);
        o = am.b;
        dh.b((new StringBuilder()).append("Scan reference: ").append(s1).toString());
    }

    public void a(h h1)
    {
        if (u != null)
        {
            u.b();
            u.d(false);
            u.a(h1);
        }
        s.enable();
        t = true;
    }

    public void a(boolean flag)
    {
        if (flag && F == null)
        {
            B.runOnUiThread(new ag(this));
            N.sendEmptyMessageDelayed(112, 10000L);
        } else
        if (F != null)
        {
            B.runOnUiThread(new ah(this));
            return;
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        if (!x)
        {
            x = true;
            Intent intent = new Intent();
            intent.putStringArrayListExtra("EXTRA_SCAN_ATTEMPTS", D);
            if (flag)
            {
                if (flag1)
                {
                    intent.putExtra("EXTRA_ERROR_CODE", ErrorCase.CANCEL_TYPE_BACKGROUND.code());
                    intent.putExtra("EXTRA_ERROR_MESSAGE", "");
                } else
                if (F != null)
                {
                    intent.putExtra("EXTRA_ERROR_CODE", F.code());
                    intent.putExtra("EXTRA_ERROR_MESSAGE", ar.a(B, F.message()));
                } else
                {
                    intent.putExtra("EXTRA_ERROR_CODE", ErrorCase.CANCEL_TYPE_USER.code());
                    intent.putExtra("EXTRA_ERROR_MESSAGE", "");
                }
                if (o == am.c && (flag1 || F == null))
                {
                    p.a(l, E.getCardHolderName());
                }
                B.setResult(0, intent);
            } else
            {
                p.a(l, E.getCardHolderName());
                intent.putExtra("EXTRA_CARD_INFORMATION", E);
                B.setResult(-1, intent);
            }
            B.finish();
            return;
        } else
        {
            dh.b("closeSDK already called!");
            return;
        }
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        B.runOnUiThread(new q(this, flag, flag1, flag2, flag3, flag4, flag5));
    }

    public void b()
    {
        u.d(true);
    }

    public void b(ErrorCase errorcase)
    {
        if (F != null)
        {
            return;
        } else
        {
            F = errorcase;
            o = am.e;
            B.runOnUiThread(new ac(this, errorcase));
            return;
        }
    }

    public void b(String s1)
    {
        if (l.equals(s1))
        {
            v = true;
        }
    }

    public void c()
    {
        if (t)
        {
            s.enable();
        }
        q.h();
    }

    public void c(String s1)
    {
        if (l.equals(s1))
        {
            w = true;
            if (v && F == null)
            {
                N.sendEmptyMessage(111);
            }
        }
    }

    public void d()
    {
        p.a();
        u.a();
        N.removeMessages(112);
        q.b(false);
        s.disable();
        a(true, true);
    }

    public void e()
    {
        if (p != null)
        {
            p.a();
        }
        if (q != null)
        {
            q.j();
        }
        if (A != null)
        {
            A.interrupt();
        }
        if (E != null)
        {
            E.clear();
        }
        p = null;
        q = null;
        A = null;
        E = null;
        aq.a();
    }

    public boolean f()
    {
        return c;
    }

    public boolean g()
    {
        return r.f();
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        q.i();
        if (u != null && camera != null)
        {
            u.a(abyte0, o);
        }
    }
}
