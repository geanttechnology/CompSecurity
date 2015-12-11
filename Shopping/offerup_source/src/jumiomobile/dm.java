// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.os.Vibrator;
import android.view.OrientationEventListener;
import android.view.TextureView;
import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

// Referenced classes of package jumiomobile:
//            fd, fk, s, ea, 
//            dw, dy, ao, v, 
//            g, fe, cs, fx, 
//            dl, fl, an, dn, 
//            aa, ab, dz, fs, 
//            ds, do, cb, dp, 
//            dx, du, dt, dv, 
//            dq, dr, ew, by, 
//            l

public class dm
    implements fd, fk, s
{

    protected dy A;
    protected NetswipeCustomScanInterface B;
    protected ArrayList C;
    protected InternalCardInformation D;
    protected dz E;
    protected TextureView F;
    protected ew G;
    protected final Object H = new Object();
    protected final Object I = new Object();
    private dw J;
    protected boolean a;
    protected boolean b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected int i;
    protected String j;
    protected String k;
    protected String l;
    protected ArrayList m;
    protected ea n;
    protected fl o;
    protected g p;
    protected ao q;
    protected OrientationEventListener r;
    protected boolean s;
    protected fe t;
    protected boolean u;
    protected boolean v;
    protected boolean w;
    protected aa x;
    protected long y;
    protected Activity z;

    public dm(Activity activity, NetswipeCustomScanInterface netswipecustomscaninterface, Bundle bundle, dy dy1)
    {
        a = true;
        b = false;
        c = true;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = -1;
        j = "";
        k = "";
        l = "";
        n = ea.a;
        s = false;
        u = false;
        v = false;
        w = false;
        x = null;
        y = 0L;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        J = new dw(this);
        z = activity;
        B = netswipecustomscaninterface;
        A = dy1;
        a = bundle.getBoolean("INTENT_EXTRA_EXPIRY_REQUIRED", true);
        b = bundle.getBoolean("INTENT_EXTRA_EXPIRY_EDITABLE", false);
        c = bundle.getBoolean("INTENT_EXTRA_CVV_REQUIRED", true);
        d = bundle.getBoolean("INTENT_EXTRA_VIBRATION_ENABLED", false);
        e = bundle.getBoolean("INTENT_EXTRA_CARD_HOLDER_NAME_REQUIRED", false);
        f = bundle.getBoolean("INTENT_EXTRA_SORTCODE_ACCOUNTNUMBER_REQUIRED", false);
        i = bundle.getInt("INTENT_EXTRA_SOUND_RESOURCE_ID", -1);
        j = bundle.getString("INTENT_EXTRA_REPORTING_CRITERIA");
        m = (ArrayList)bundle.getSerializable("INTENT_EXTRA_SUPPORTED_CREDIT_CARD_TYPES");
        netswipecustomscaninterface = bundle.getString("INTENT_EXTRA_NAME_TO_COMPARE");
        g = bundle.getBoolean("INTENT_EXTRA_FLASH_ON_STARTUP");
        h = bundle.getBoolean("INTENT_EXTRA_CAMERA_FACING_FRONT");
        l = bundle.getString("INTENT_EXTRA_ADYEN_PUBLIC_KEY", "");
        F = dy1.getTextureView();
        G = dy1.getScanOverlayView();
        q = new ao(activity, v.a);
        q.k();
        n = ea.b;
        p = new g(F, this, q, h);
        t = new fe(activity, q, this);
        t.b(a);
        t.c(e);
        t.d(f);
        if (cs.a())
        {
            t.a(fx.f());
            fx.d();
        }
        D = new InternalCardInformation();
        bundle = D;
        if (!e)
        {
            netswipecustomscaninterface = null;
        }
        bundle.b(netswipecustomscaninterface);
        C = new ArrayList();
        o = (fl)dl.d().a(activity, fl.d);
        if (!o.k())
        {
            o.a(j);
        }
        o.a(this);
        y = System.currentTimeMillis();
        r = new dn(this, activity, 1);
    }

    private void a(Message message)
    {
        if (z != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (message.what != 111 && message.what != 112)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (E != null) goto _L1; else goto _L3
_L3:
        if (message.what == 111)
        {
            u = true;
        }
        if (message.what == 112)
        {
            v = true;
        }
        if (!u || !v) goto _L1; else goto _L4
_L4:
        J.removeMessages(113);
        J.sendEmptyMessage(113);
        return;
        if (message.what != 113) goto _L1; else goto _L5
_L5:
        message = ((Message) (I));
        message;
        JVM INSTR monitorenter ;
        if (!A.doAdditionalStep(D))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (D != null && u && v)
        {
            A.performAdditionalStep(D);
        }
        n = ea.d;
_L6:
        return;
        Exception exception;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
        a(false, false);
          goto _L6
    }

    private void a(String s1, long l1)
    {
        if (x == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        x.put(s1, l1);
        return;
        s1;
        ab.a(s1);
        return;
    }

    static void a(dm dm1, Message message)
    {
        dm1.a(message);
    }

    static void a(dm dm1, String s1, long l1)
    {
        dm1.a(s1, l1);
    }

    public dz a(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, StringBuilder stringbuilder, boolean flag, long l1)
    {
label0:
        {
            synchronized (I)
            {
                if (D != null)
                {
                    break label0;
                }
                fieldname = dz.j;
            }
            return fieldname;
        }
        if (cs.a())
        {
            StringBuilder stringbuilder1 = fx.f();
            stringbuilder1.append(fieldname.toString()).append("\r\n");
            fx.a(stringbuilder1, "value: ", stringbuilder.toString());
            fx.a(stringbuilder1, "time: ", Long.toString(l1));
            fx.a(stringbuilder1, "accepted: ", Boolean.toString(flag));
            stringbuilder1.append("coordinates: \r\n");
            fx.a(fieldname, stringbuilder1);
            stringbuilder1.append("\r\n");
        }
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER)) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        fieldname = dz.j;
        obj;
        JVM INSTR monitorexit ;
        return fieldname;
        fieldname;
        obj;
        JVM INSTR monitorexit ;
        throw fieldname;
        if (fs.c(stringbuilder))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        fieldname = dz.j;
        obj;
        JVM INSTR monitorexit ;
        return fieldname;
        D.clear();
        u = false;
        v = false;
        x = new aa();
        t.c();
        D.a(stringbuilder);
        a("ocrCardNumber", l1);
        if (m.contains(D.getCardType()))
        {
            break MISSING_BLOCK_LABEL_236;
        }
        fieldname = dz.a;
        obj;
        JVM INSTR monitorexit ;
        return fieldname;
        if (!a)
        {
            f();
        }
_L3:
        obj;
        JVM INSTR monitorexit ;
        return null;
_L2:
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY))
        {
            break MISSING_BLOCK_LABEL_408;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        fieldname = Pattern.compile(fs.a());
        StringBuilder stringbuilder2 = new StringBuilder();
        stringbuilder2.append(stringbuilder.subSequence(0, 2));
        stringbuilder2.append(" / ");
        stringbuilder2.append(stringbuilder.subSequence(stringbuilder.length() - 2, stringbuilder.length()));
        if (fieldname.matcher(stringbuilder2).matches())
        {
            break MISSING_BLOCK_LABEL_344;
        }
        fieldname = dz.c;
        obj;
        JVM INSTR monitorexit ;
        return fieldname;
        D.e(new StringBuilder(stringbuilder.subSequence(0, 2)));
        D.f(new StringBuilder(stringbuilder.subSequence(stringbuilder.length() - 2, stringbuilder.length())));
        a("ocrExpiryDate", l1);
        f();
          goto _L3
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE))
        {
            break MISSING_BLOCK_LABEL_477;
        }
        fieldname = D;
        if (!f)
        {
            break MISSING_BLOCK_LABEL_464;
        }
_L4:
        fieldname.c(stringbuilder);
        fieldname = D;
        if (!f)
        {
            flag = false;
        }
        fieldname.c(flag);
        a("ocrSortCode", l1);
          goto _L3
        stringbuilder = new StringBuilder("");
          goto _L4
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM)) goto _L6; else goto _L5
_L5:
        fieldname = D;
        if (!f)
        {
            break MISSING_BLOCK_LABEL_533;
        }
_L7:
        fieldname.d(stringbuilder);
        fieldname = D;
        if (!f)
        {
            flag = false;
        }
        fieldname.d(flag);
        a("ocrAccountNumber", l1);
          goto _L3
        stringbuilder = new StringBuilder("");
          goto _L7
_L6:
        if (!fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME)) goto _L3; else goto _L8
_L8:
        D.b(stringbuilder);
        a("ocrCardHolderName", l1);
          goto _L3
    }

    public void a()
    {
    }

    public void a(float f1)
    {
        synchronized (H)
        {
            if (p != null)
            {
                p.j();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i1, byte abyte0[], int j1, int k1)
    {
label0:
        {
            ab.a("OcrTask", (new StringBuilder("invoking ImageDumpService for ")).append(k).toString());
            d("sending to IDS");
            boolean flag = o.a(abyte0, j1, k1, i1);
            if (cs.a())
            {
                if (!flag)
                {
                    break label0;
                }
                d("image sent to IDS");
            }
            return;
        }
        d("image request failed");
    }

    public void a(String s1)
    {
        k = s1;
        if (s1 == null || s1.equals(""))
        {
            if (cs.a())
            {
                k = Long.toString(System.currentTimeMillis());
            }
            C.add("");
        } else
        {
            C.add(s1);
        }
        if (o.i())
        {
            t.e(o.g());
        }
        t.f(o.f());
        t.g(o.j());
        z.runOnUiThread(new ds(this));
        n = ea.c;
    }

    public void a(Throwable throwable)
    {
        b(dz.i);
    }

    public void a(by by)
    {
        if (n == ea.a)
        {
            return;
        }
        synchronized (H)
        {
            if (p != null)
            {
                p.a(by);
            }
        }
        return;
        by;
        obj;
        JVM INSTR monitorexit ;
        throw by;
    }

    public void a(dz dz1)
    {
        b(dz1);
        ab.a((new StringBuilder("RemoteManager error thrown: ")).append(dz1).toString());
    }

    public void a(l l1)
    {
        if (t != null)
        {
            t.a(l1);
        }
        r.enable();
        s = true;
    }

    public void a(boolean flag)
    {
        synchronized (H)
        {
            if (E == null)
            {
                p.c(g);
                B.onNetswipeCameraAvailable();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(boolean flag, boolean flag1)
    {
        if (w) goto _L2; else goto _L1
_L1:
        w = true;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (!flag1) goto _L6; else goto _L5
_L5:
        E = dz.b;
_L10:
        if (o != null)
        {
            o.d();
        }
        z.runOnUiThread(new do(this));
_L8:
        d();
_L2:
        return;
_L6:
        if (E == null)
        {
            E = dz.h;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        synchronized (I)
        {
            if (D != null)
            {
                o.a(k, D.getCardExpiryDateMonth(), D.getCardExpiryDateYear(), D.getCardHolderName());
            }
        }
        cb.b();
        z.runOnUiThread(new dp(this));
        if (true) goto _L8; else goto _L7
_L7:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a(boolean flag, byte abyte0[], int i1, int j1, byte abyte1[], int k1, int l1, 
            boolean flag1, aa aa1, aa aa2)
    {
        if (n != ea.e) goto _L2; else goto _L1
_L1:
        ab.a(getClass().getSimpleName(), (new StringBuilder("Discard OCR result (passed=")).append(flag).append("), because manual entry was active").toString());
_L4:
        return;
_L2:
        InternalCardInformation internalcardinformation;
        synchronized (I)
        {
            internalcardinformation = D.a();
        }
        if (flag && E == null)
        {
            z.runOnUiThread(new dx(this, internalcardinformation, flag1, flag, aa1, aa2));
            J.sendEmptyMessageDelayed(113, 10000L);
        } else
        if (E != null)
        {
            z.runOnUiThread(new dx(this, internalcardinformation, flag1, flag, aa1, aa2));
        }
        if (!flag || !cs.a()) goto _L4; else goto _L3
_L3:
        try
        {
            fx.a(fx.f().toString(), fx.a(z, k), String.format("%s.txt", new Object[] {
                k
            }));
            fx.a(abyte0, fx.a(z, k), String.format("%s.rgb", new Object[] {
                k
            }));
            fx.a(z, abyte0, i1, j1, k);
            fx.a(z, abyte1, k1, l1, k, aa1, aa2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return;
        }
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void a(byte abyte0[], int i1, int j1)
    {
        z.runOnUiThread(new du(this, abyte0, i1, j1));
    }

    public void b()
    {
        if (s)
        {
            r.enable();
        }
        p.k();
    }

    public void b(String s1)
    {
        if (s1 == null || s1 != null && s1.equals(k))
        {
            J.sendEmptyMessage(111);
        }
    }

    public void b(dz dz1)
    {
        while (E != null || n == ea.e) 
        {
            return;
        }
        E = dz1;
        n = ea.f;
        z.runOnUiThread(new dt(this, dz1));
    }

    public void b(boolean flag, boolean flag1)
    {
        z.runOnUiThread(new dv(this, flag, flag1));
    }

    public void c()
    {
        if (n != ea.a)
        {
            d();
            a(true, true);
        }
    }

    public void c(String s1)
    {
        if (s1 == null || s1 != null && s1.equals(k))
        {
            J.sendEmptyMessage(112);
        }
    }

    public void d()
    {
        if (t != null)
        {
            t.a();
        }
        if (J != null)
        {
            J.removeMessages(113);
        }
        if (p != null)
        {
            p.d(true);
        }
        r.disable();
        n = ea.a;
    }

    public void d(String s1)
    {
        if (cs.a())
        {
            A.setDebugText(s1);
        }
    }

    public void e()
    {
        if (n != ea.a)
        {
            d();
        }
        if (p != null)
        {
            p.m();
        }
        synchronized (I)
        {
            if (D != null)
            {
                D.clear();
            }
            D = null;
        }
        if (o != null)
        {
            o.a(null);
        }
        synchronized (H)
        {
            p = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected void f()
    {
        synchronized (H)
        {
            if (p != null)
            {
                p.d(true);
            }
        }
        z.runOnUiThread(new dq(this));
        Exception exception;
        if (d)
        {
            try
            {
                ((Vibrator)z.getSystemService("vibrator")).vibrate(100L);
            }
            catch (Exception exception1) { }
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = MediaPlayer.create(z, i);
        ((MediaPlayer) (obj)).setOnCompletionListener(new dr(this));
        ((MediaPlayer) (obj)).start();
        return;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        exception;
    }

    public ea g()
    {
        return n;
    }

    public void h()
    {
        if (E != null && !E.d())
        {
            throw new UnsupportedOperationException((new StringBuilder("Retry not possible after receiving error: ")).append(E.a()).toString());
        }
        E = null;
        w = false;
        n = ea.b;
        k = "";
        u = false;
        v = false;
        A.restoreScanView();
        synchronized (H)
        {
            if (p != null)
            {
                p.o();
                p.k();
            }
        }
        t.b();
        G.setVisibility(0);
        G.setTextVisible(true);
        o.a(this);
        o.a(j);
        y = System.currentTimeMillis();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean i()
    {
        boolean flag = false;
        if (n == ea.a)
        {
            return false;
        }
        synchronized (H)
        {
            if (p != null)
            {
                flag = p.b();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean j()
    {
        boolean flag = false;
        if (n == ea.a)
        {
            return false;
        }
        synchronized (H)
        {
            if (p != null)
            {
                flag = p.d();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void k()
    {
        if (n == ea.a)
        {
            return;
        }
        synchronized (H)
        {
            if (p != null)
            {
                p.h();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean l()
    {
        boolean flag = false;
        if (n == ea.a)
        {
            return false;
        }
        synchronized (H)
        {
            if (p != null)
            {
                flag = p.g();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean m()
    {
        boolean flag = false;
        if (n == ea.a)
        {
            return false;
        }
        synchronized (H)
        {
            if (p != null)
            {
                flag = p.c();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n()
    {
        if (n == ea.a)
        {
            return;
        }
        synchronized (H)
        {
            if (p != null)
            {
                p.n();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean o()
    {
        return c;
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        cb.e();
        Object obj = H;
        obj;
        JVM INSTR monitorenter ;
        if (p == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (t == null || camera == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        camera = t;
        boolean flag;
        if (!p.c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        camera.a(abyte0, flag);
        p.l();
        obj;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public boolean p()
    {
        return e;
    }

    public boolean q()
    {
        return a;
    }

    public boolean r()
    {
        return b;
    }

    public boolean s()
    {
        return g;
    }

    public ArrayList t()
    {
        return m;
    }

    public Object u()
    {
        return I;
    }

    public InternalCardInformation v()
    {
        return D;
    }

    public void w()
    {
        o.d();
        n = ea.e;
        synchronized (H)
        {
            if (p != null)
            {
                p.d(false);
                p.m();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean x()
    {
        return q.g();
    }
}
