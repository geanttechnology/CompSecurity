// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import com.jumio.netswipe.sdk.core.ScanCardActivity;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import com.jumio.netswipe.sdk.environment.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import netswipe.cy;
import netswipe.dh;

// Referenced classes of package com.jumio.netswipe.sdk:
//            PlatformNotSupportedException

public final class NetswipeSDK
{

    public static final String EXTRA_CARD_INFORMATION = "EXTRA_CARD_INFORMATION";
    public static final String EXTRA_ERROR_CODE = "EXTRA_ERROR_CODE";
    public static final String EXTRA_ERROR_MESSAGE = "EXTRA_ERROR_MESSAGE";
    public static final String EXTRA_SCAN_ATTEMPTS = "EXTRA_SCAN_ATTEMPTS";
    public static int REQUEST_CODE = 100;
    private static int a = 0x100000;
    private static int b = 16;
    private Activity c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private String n;
    private ArrayList o;
    private ArrayList p;

    public NetswipeSDK(Activity activity, String s, String s1)
        throws PlatformNotSupportedException
    {
        d = "";
        e = "";
        f = true;
        g = true;
        h = true;
        i = false;
        j = false;
        k = false;
        l = false;
        m = -1;
        n = "";
        dh.a("SDK Build Version: 2.0.3, OCR Build Version: 1.19.2", true);
        if (a(activity))
        {
            c = activity;
            d = s;
            e = s1;
            p = new ArrayList();
        }
    }

    private static void a()
    {
        Runtime runtime = Runtime.getRuntime();
        long l1 = runtime.totalMemory() / (long)a;
        long l2 = runtime.maxMemory() / (long)a;
        long l3 = l2 - l1;
        if (l3 < (long)b)
        {
            dh.c((new StringBuilder()).append("Critical memory warning: Heap situation ").append(l1).append("/").append(l2).append("MB , free ").append(l3).append("MB").toString());
        }
    }

    private static boolean a(Activity activity)
        throws PlatformNotSupportedException
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            throw new PlatformNotSupportedException("SDK Version 14 required");
        }
        if (Camera.getNumberOfCameras() == 0)
        {
            throw new PlatformNotSupportedException("No useable camera present");
        }
        if (!Environment.isSupportedPlatform(activity))
        {
            throw new PlatformNotSupportedException("ARMv7 CPU Architecture with NEON Intrinsics required");
        } else
        {
            a();
            return true;
        }
    }

    private static boolean a(String s)
    {
        Object obj = null;
        Object obj1;
        obj1 = Runtime.getRuntime().exec((new StringBuilder()).append("ls -la ").append(s).toString());
        ((Process) (obj1)).waitFor();
        obj1 = new BufferedReader(new InputStreamReader(((Process) (obj1)).getInputStream()));
        obj = obj1;
        String s1 = ((BufferedReader) (obj1)).readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        obj = obj1;
        boolean flag = s1.matches("-[r|-][w|-]s[r|-][w|-][x|s|-].*");
        if (flag)
        {
            if (obj1 != null)
            {
                try
                {
                    ((BufferedReader) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
_L1:
        dh.b((new StringBuilder()).append(s).append(" is not set-user-ID").toString());
        return false;
        Exception exception;
        exception;
        obj1 = null;
_L4:
        obj = obj1;
        exception.printStackTrace();
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
          goto _L1
        s;
_L3:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw s;
        s;
        if (true) goto _L3; else goto _L2
_L2:
        exception;
          goto _L4
    }

    public static String getVersion()
    {
        return "2.0.3";
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
                    dh.b((new StringBuilder()).append("Found adequate su binary at ").append(((File) (obj)).getAbsolutePath()).toString());
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public static boolean isSupportedPlatform(Activity activity)
    {
        boolean flag;
        try
        {
            flag = a(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return flag;
    }

    public void addCustomField(String s, String s1, String s2)
    {
        addCustomField(s, s1, s2, -1, null);
    }

    public void addCustomField(String s, String s1, String s2, int i1)
    {
        addCustomField(s, s1, s2, i1, null);
    }

    public void addCustomField(String s, String s1, String s2, int i1, String s3)
    {
        if (s3 != null && !s3.trim().equals(""))
        {
            p.add(new cy(s, s1, s2, i1, Pattern.compile(s3)));
            return;
        } else
        {
            p.add(new cy(s, s1, s2, i1, null));
            return;
        }
    }

    public void clearCustomFields()
    {
        p.clear();
    }

    public void setCardHolderNameEditable(boolean flag)
    {
        j = flag;
    }

    public void setCardHolderNameRequired(boolean flag)
    {
        i = flag;
    }

    public void setCvvRequired(boolean flag)
    {
        h = flag;
    }

    public void setDebugLog(boolean flag)
    {
        dh.a(flag);
    }

    public void setExpiryRequired(boolean flag)
    {
        g = flag;
    }

    public void setManualEntryEnabled(boolean flag)
    {
        f = flag;
    }

    public void setMerchantReportingCriteria(String s)
    {
        if (s == null)
        {
            n = "";
            return;
        }
        String s1 = s;
        if (s.length() > 100)
        {
            s1 = s.substring(0, 100);
        }
        n = s1;
    }

    public void setSortCodeAndAccountNumberRequired(boolean flag)
    {
        k = flag;
    }

    public void setSoundEffect(int i1)
    {
        m = i1;
    }

    public void setSupportedCreditCardTypes(ArrayList arraylist)
    {
        o = arraylist;
    }

    public void setVibrationEffectEnabled(boolean flag)
    {
        l = flag;
    }

    public void start()
    {
        if (o == null)
        {
            o = new ArrayList();
            o.add(CreditCardType.VISA);
            o.add(CreditCardType.MASTER_CARD);
            o.add(CreditCardType.AMERICAN_EXPRESS);
            o.add(CreditCardType.DINERS_CLUB);
            o.add(CreditCardType.DISCOVER);
            o.add(CreditCardType.JCB);
            o.add(CreditCardType.CHINA_UNIONPAY);
        }
        Intent intent = new Intent(c, com/jumio/netswipe/sdk/core/ScanCardActivity);
        intent.putExtra("INTENT_EXTRA_API_SECRET", e);
        intent.putExtra("INTENT_EXTRA_API_TOKEN", d);
        intent.putExtra("INTENT_EXTRA_SUPPORTED_CREDIT_CARD_TYPES", o);
        intent.putExtra("INTENT_EXTRA_MANUAL_ENTRY", f);
        intent.putExtra("INTENT_EXTRA_EXPIRY_REQUIRED", g);
        intent.putExtra("INTENT_EXTRA_CVV_REQUIRED", h);
        intent.putExtra("INTENT_EXTRA_CARD_HOLDER_NAME_REQUIRED", i);
        intent.putExtra("INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE", j);
        intent.putExtra("INTENT_EXTRA_SORTCODE_ACCOUNTNUMBER_REQUIRED", k);
        intent.putExtra("INTENT_EXTRA_VIBRATION_ENABLED", l);
        intent.putExtra("INTENT_EXTRA_SOUND_RESOURCE_ID", m);
        intent.putExtra("INTENT_EXTRA_CUSTOM_FIELDS", p);
        intent.putExtra("INTENT_EXTRA_REPORTING_CRITERIA", n);
        c.startActivityForResult(intent, REQUEST_CODE);
    }

}
