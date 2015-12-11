// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.barcode;

import android.app.Activity;
import android.content.Intent;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.netverify.barcode.enums.BarcodeFormat;
import com.jumio.netverify.sdk.activity.NetverifyActivity;
import com.jumio.netverify.sdk.core.BarcodeScannerModel;
import java.util.ArrayList;
import jumiomobile.an;
import jumiomobile.ba;
import jumiomobile.cc;
import jumiomobile.ch;
import jumiomobile.cj;
import jumiomobile.cl;
import jumiomobile.cn;
import jumiomobile.cs;
import jumiomobile.ga;
import jumiomobile.hh;
import jumiomobile.hk;

// Referenced classes of package com.jumio.netverify.barcode:
//            JumioBarcodeScannerInterface

public class JumioBarcodeScanner extends cc
{

    public static int REQUEST_CODE = 0;
    public static final String RESULT_BARCODE_DATA = "barcodeData";
    public static final String RESULT_BARCODE_FORMAT = "barcodeFormat";
    public static final int RESULT_CODE_CANCEL = 101;
    public static final int RESULT_CODE_SUCCESS = 100;
    public static final String RESULT_DATA_ERROR_CODE = "errorCode";
    public static final String RESULT_DATA_ERROR_MESSAGE = "errorMessage";
    private static JumioBarcodeScanner a;
    private BarcodeScannerModel b;
    private BarcodeFormat c;
    private Activity d;

    private JumioBarcodeScanner(Activity activity, String s, String s1, JumioBarcodeScannerInterface jumiobarcodescannerinterface, JumioDataCenter jumiodatacenter)
    {
        if (activity == null)
        {
            throw new NullPointerException("rootActivity is null");
        } else
        {
            checkSDKRequirements();
            checkResource(activity, "com.jumio.netverify.resources.NVImageResources", "NetverifyResources");
            d = activity;
            hk.b(activity);
            b = BarcodeScannerModel.a(new ga(this, null));
            b.a = activity;
            b.g = s;
            b.h = s1;
            b.O = jumiodatacenter;
            b.e = false;
            b.P = jumiobarcodescannerinterface;
            b.b = new hh(b);
            return;
        }
    }

    private static void a()
    {
        com/jumio/netverify/barcode/JumioBarcodeScanner;
        JVM INSTR monitorenter ;
        a = null;
        com/jumio/netverify/barcode/JumioBarcodeScanner;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static JumioBarcodeScanner create(Activity activity, String s, String s1, JumioBarcodeScannerInterface jumiobarcodescannerinterface, JumioDataCenter jumiodatacenter)
    {
        com/jumio/netverify/barcode/JumioBarcodeScanner;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new JumioBarcodeScanner(activity, s, s1, jumiobarcodescannerinterface, jumiodatacenter);
        }
        activity = a;
        com/jumio/netverify/barcode/JumioBarcodeScanner;
        JVM INSTR monitorexit ;
        return activity;
        activity;
        throw activity;
    }

    public void destroy()
    {
        this;
        JVM INSTR monitorenter ;
        hk.d().c();
        ba.a();
        BarcodeScannerModel.a();
        a();
        super.destroy();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Intent getIntent()
    {
        if (c == null)
        {
            throw new IllegalArgumentException("Barcodeformat has to be set!");
        } else
        {
            b.c();
            b.K = c;
            b.n = new ArrayList();
            Intent intent = new Intent(d, com/jumio/netverify/sdk/activity/NetverifyActivity);
            intent.putExtra(hh.a, true);
            ch.a(new cj());
            cl.a(new cn());
            hk.b(d);
            return intent;
        }
    }

    public boolean hasLoaded()
    {
        return b.e;
    }

    public void setBarcodeFormat(BarcodeFormat barcodeformat)
    {
        c = barcodeformat;
    }

    public void start()
    {
        if (cs.a())
        {
            cs.a(cs.a(d, ""), String.format("logcat_bc_%d.log", new Object[] {
                Long.valueOf(System.currentTimeMillis())
            }));
        }
        d.startActivityForResult(getIntent(), REQUEST_CODE);
    }

    static 
    {
        REQUEST_CODE = 300;
    }
}
