// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.jumio.mobile.sdk.enums.JumioCameraPosition;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import jumiomobile.ab;
import jumiomobile.an;
import jumiomobile.cc;
import jumiomobile.ch;
import jumiomobile.ci;
import jumiomobile.cl;
import jumiomobile.cm;
import jumiomobile.cs;
import jumiomobile.dk;
import jumiomobile.dl;
import jumiomobile.dm;
import jumiomobile.fv;
import jumiomobile.fw;

// Referenced classes of package com.jumio.netswipe.sdk:
//            NetswipeCustomScanPresenter, NetswipeCustomScanInterface, NetswipeCustomScanView

public final class NetswipeSDK extends cc
{

    public static final String EXTRA_CARD_INFORMATION = "EXTRA_CARD_INFORMATION";
    public static final String EXTRA_ERROR_CODE = "EXTRA_ERROR_CODE";
    public static final String EXTRA_ERROR_MESSAGE = "EXTRA_ERROR_MESSAGE";
    public static final String EXTRA_SCAN_ATTEMPTS = "EXTRA_SCAN_ATTEMPTS";
    public static int REQUEST_CODE = 100;
    private static NetswipeSDK a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private String n;
    private boolean o;
    private ArrayList p;
    private ArrayList q;
    private String r;
    private String s;

    private NetswipeSDK(Activity activity, String s1, String s2, String s3, JumioDataCenter jumiodatacenter)
    {
        c = true;
        d = true;
        e = false;
        f = true;
        g = false;
        h = false;
        i = false;
        j = false;
        k = true;
        l = false;
        m = -1;
        n = "";
        o = false;
        if (activity == null)
        {
            throw new NullPointerException("rootActivity is null");
        } else
        {
            checkSDKRequirements();
            checkResource(activity, "com.jumio.netswipe.resources.NSImageResources", "NetswipeResource");
            ab.a("SDK Build Version: JMSDK 1.7.0 (1441790640-34), OCR Build Version: 1.82.0", true);
            Environment.checkOcrVersion(activity);
            b = activity;
            q = new ArrayList();
            setMerchantReportingCriteria(s3);
            dl.a(activity, s1, s2, jumiodatacenter);
            dl.b(activity, s3);
            return;
        }
    }

    private static void a()
    {
        com/jumio/netswipe/sdk/NetswipeSDK;
        JVM INSTR monitorenter ;
        a = null;
        com/jumio/netswipe/sdk/NetswipeSDK;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean a(String s1)
    {
        Object obj = null;
        Object obj1;
        obj1 = Runtime.getRuntime().exec((new StringBuilder("ls -la ")).append(s1).toString());
        ((Process) (obj1)).waitFor();
        obj1 = new BufferedReader(new InputStreamReader(((Process) (obj1)).getInputStream()));
        obj = obj1;
        String s2 = ((BufferedReader) (obj1)).readLine();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = obj1;
        boolean flag = s2.matches("-[r|-][w|-]s[r|-][w|-][x|s|-].*");
        if (flag)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                ab.a(s1);
            }
            return true;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ab.a(((Throwable) (obj)));
        }
_L1:
        ab.b((new StringBuilder()).append(s1).append(" is not set-user-ID").toString());
        return false;
        Exception exception;
        exception;
        obj1 = null;
_L4:
        obj = obj1;
        ab.a(exception);
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ab.a(((Throwable) (obj)));
            }
        }
          goto _L1
        s1;
_L3:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ab.a(ioexception);
            }
        }
        throw s1;
        s1;
        if (true) goto _L3; else goto _L2
_L2:
        exception;
          goto _L4
    }

    public static NetswipeSDK create(Activity activity, String s1, String s2, String s3, JumioDataCenter jumiodatacenter)
    {
        com/jumio/netswipe/sdk/NetswipeSDK;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new NetswipeSDK(activity, s1, s2, s3, jumiodatacenter);
        }
        activity = a;
        com/jumio/netswipe/sdk/NetswipeSDK;
        JVM INSTR monitorexit ;
        return activity;
        activity;
        throw activity;
    }

    public static boolean isRooted()
    {
        boolean flag1 = false;
        String as[] = System.getenv("PATH").split(":");
        int j1 = as.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    Object obj = as[i1];
                    obj = new File((new StringBuilder()).append(((String) (obj))).append("/su").toString());
                    if (!((File) (obj)).exists() || !a(((File) (obj)).getAbsolutePath()))
                    {
                        break label0;
                    }
                    ab.b((new StringBuilder("Found adequate su binary at ")).append(((File) (obj)).getAbsolutePath()).toString());
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public final void addCustomField(String s1, String s2, String s3)
    {
        addCustomField(s1, s2, s3, -1, ((String) (null)));
    }

    public final void addCustomField(String s1, String s2, String s3, int i1)
    {
        addCustomField(s1, s2, s3, i1, ((String) (null)));
    }

    public final void addCustomField(String s1, String s2, String s3, int i1, String s4)
    {
        if (s4 != null && !s4.trim().equals(""))
        {
            q.add(new fv(s1, s2, s3, i1, Pattern.compile(s4)));
            return;
        } else
        {
            q.add(new fv(s1, s2, s3, i1, null));
            return;
        }
    }

    public final void addCustomField(String s1, String s2, String s3, ArrayList arraylist)
    {
        addCustomField(s1, s2, s3, arraylist, false, "");
    }

    public final void addCustomField(String s1, String s2, String s3, ArrayList arraylist, boolean flag)
    {
        q.add(new fw(s1, s2, s3, arraylist, flag, ""));
    }

    public final void addCustomField(String s1, String s2, String s3, ArrayList arraylist, boolean flag, String s4)
    {
        q.add(new fw(s1, s2, s3, arraylist, flag, s4));
    }

    public final void clearCustomFields()
    {
        q.clear();
    }

    public final void destroy()
    {
        this;
        JVM INSTR monitorenter ;
        dl.d().c();
        a();
        super.destroy();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final ArrayList getCustomFields()
    {
        if (q == null)
        {
            return new ArrayList();
        } else
        {
            return q;
        }
    }

    public final Intent getIntent()
    {
        if (p == null)
        {
            p = new ArrayList();
            p.add(CreditCardType.VISA);
            p.add(CreditCardType.MASTER_CARD);
            p.add(CreditCardType.AMERICAN_EXPRESS);
            p.add(CreditCardType.DINERS_CLUB);
            p.add(CreditCardType.DISCOVER);
            p.add(CreditCardType.JCB);
            p.add(CreditCardType.CHINA_UNIONPAY);
            p.add(CreditCardType.PRIVATE_LABEL);
        }
        Intent intent = new Intent(b, com/jumio/netswipe/sdk/activity/ScanCardActivity);
        intent.putExtra("INTENT_EXTRA_SUPPORTED_CREDIT_CARD_TYPES", p);
        intent.putExtra("INTENT_EXTRA_MANUAL_ENTRY", c);
        intent.putExtra("INTENT_EXTRA_EXPIRY_REQUIRED", d);
        intent.putExtra("INTENT_EXTRA_EXPIRY_EDITABLE", e);
        intent.putExtra("INTENT_EXTRA_CVV_REQUIRED", f);
        intent.putExtra("INTENT_EXTRA_CARD_HOLDER_NAME_REQUIRED", g);
        intent.putExtra("INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE", h);
        intent.putExtra("INTENT_EXTRA_CARD_NUMBER_MASKING_ENABLED", k);
        intent.putExtra("INTENT_EXTRA_SORTCODE_ACCOUNTNUMBER_REQUIRED", i);
        intent.putExtra("INTENT_EXTRA_VIBRATION_ENABLED", j);
        intent.putExtra("INTENT_EXTRA_SOUND_RESOURCE_ID", m);
        intent.putExtra("INTENT_EXTRA_CUSTOM_FIELDS", q);
        intent.putExtra("INTENT_EXTRA_REPORTING_CRITERIA", n);
        intent.putExtra("INTENT_EXTRA_NAME_TO_COMPARE", r);
        intent.putExtra("INTENT_EXTRA_FLASH_ON_STARTUP", l);
        intent.putExtra("INTENT_EXTRA_CAMERA_FACING_FRONT", o);
        intent.putExtra("INTENT_EXTRA_ADYEN_PUBLIC_KEY", s);
        return intent;
    }

    public final void setAdyenPublicKey(String s1)
    {
        s = s1;
    }

    public final void setCameraPosition(JumioCameraPosition jumiocameraposition)
    {
        boolean flag;
        if (jumiocameraposition == JumioCameraPosition.FRONT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
    }

    public final void setCardHolderNameEditable(boolean flag)
    {
        h = flag;
    }

    public final void setCardHolderNameRequired(boolean flag)
    {
        g = flag;
    }

    public final void setCardNumberMaskingEnabled(boolean flag)
    {
        k = flag;
    }

    public final void setCvvRequired(boolean flag)
    {
        f = flag;
    }

    public final void setEnableFlashOnScanStart(boolean flag)
    {
        l = flag;
    }

    public final void setExpiryEditable(boolean flag)
    {
        e = flag;
    }

    public final void setExpiryRequired(boolean flag)
    {
        d = flag;
    }

    public final void setManualEntryEnabled(boolean flag)
    {
        c = flag;
    }

    public final void setMerchantReportingCriteria(String s1)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        String s2 = "";
_L4:
        n = s2;
        return;
_L2:
        s2 = s1;
        if (s1.length() > 100)
        {
            s2 = s1.substring(0, 100);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void setName(String s1)
    {
        r = s1;
    }

    public final void setSortCodeAndAccountNumberRequired(boolean flag)
    {
        i = flag;
    }

    public final void setSoundEffect(int i1)
    {
        m = i1;
    }

    public final void setSupportedCreditCardTypes(ArrayList arraylist)
    {
        p = arraylist;
    }

    public final void setVibrationEffectEnabled(boolean flag)
    {
        j = flag;
    }

    public final NetswipeCustomScanPresenter start(NetswipeCustomScanInterface netswipecustomscaninterface, NetswipeCustomScanView netswipecustomscanview)
    {
        if (p == null)
        {
            p = new ArrayList();
            p.add(CreditCardType.VISA);
            p.add(CreditCardType.MASTER_CARD);
            p.add(CreditCardType.AMERICAN_EXPRESS);
            p.add(CreditCardType.DINERS_CLUB);
            p.add(CreditCardType.DISCOVER);
            p.add(CreditCardType.JCB);
            p.add(CreditCardType.CHINA_UNIONPAY);
            p.add(CreditCardType.PRIVATE_LABEL);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_SUPPORTED_CREDIT_CARD_TYPES", p);
        bundle.putBoolean("INTENT_EXTRA_EXPIRY_REQUIRED", d);
        bundle.putBoolean("INTENT_EXTRA_EXPIRY_EDITABLE", e);
        bundle.putBoolean("INTENT_EXTRA_CVV_REQUIRED", f);
        bundle.putBoolean("INTENT_EXTRA_CARD_HOLDER_NAME_REQUIRED", g);
        bundle.putBoolean("INTENT_EXTRA_SORTCODE_ACCOUNTNUMBER_REQUIRED", i);
        bundle.putBoolean("INTENT_EXTRA_VIBRATION_ENABLED", j);
        bundle.putInt("INTENT_EXTRA_SOUND_RESOURCE_ID", m);
        bundle.putString("INTENT_EXTRA_REPORTING_CRITERIA", n);
        bundle.putString("INTENT_EXTRA_NAME_TO_COMPARE", r);
        bundle.putBoolean("INTENT_EXTRA_FLASH_ON_STARTUP", l);
        bundle.putBoolean("INTENT_EXTRA_CAMERA_FACING_FRONT", o);
        bundle.putString("INTENT_EXTRA_ADYEN_PUBLIC_KEY", s);
        cl.a(new cm());
        ch.a(new ci());
        netswipecustomscanview = new dk(netswipecustomscanview, netswipecustomscaninterface);
        netswipecustomscaninterface = new dm(b, netswipecustomscaninterface, bundle, netswipecustomscanview);
        netswipecustomscaninterface.b();
        return new NetswipeCustomScanPresenter(netswipecustomscaninterface);
    }

    public final void start()
    {
        if (cs.a())
        {
            cs.a(cs.a(b, ""), String.format("logcat_ns_%d.log", new Object[] {
                Long.valueOf(System.currentTimeMillis())
            }));
        }
        b.startActivityForResult(getIntent(), REQUEST_CODE);
    }

}
