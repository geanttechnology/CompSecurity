// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.redlaser;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.ebay.redlasersdk.BarcodeResult;
import com.ebay.redlasersdk.BarcodeScanActivity;
import com.ebay.redlasersdk.BarcodeTypes;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class RedLaserScannerActivity extends BarcodeScanActivity
{

    public static final String EXTRA_ENABLE_CODE128 = "code128";
    public static final String EXTRA_ENABLE_CODE39 = "code39";
    public static final String EXTRA_ENABLE_EAN13 = "ean13";
    public static final String EXTRA_ENABLE_EAN8 = "ean8";
    public static final String EXTRA_ENABLE_QRCODE = "qrcode";
    public static final String EXTRA_ENABLE_UPCE = "upce";
    public static final String EXTRA_PRODUCTID = "productid";
    public static final String EXTRA_PRODUCTID_TYPE = "productidtype";
    private static final String TYPE_CODE128 = "128";
    private static final String TYPE_CODE39 = "39";
    private static final String TYPE_EAN = "EAN";
    private static final String TYPE_OTHER = "OTH";
    private static final String TYPE_QRCODE = "QRC";
    private static final String TYPE_UPC = "UPC";
    private final Runnable closeActivity = new Runnable() {

        final RedLaserScannerActivity this$0;

        public void run()
        {
            finish();
        }

            
            {
                this$0 = RedLaserScannerActivity.this;
                super();
            }
    };
    private TextView hintText;
    private boolean orientationLandscape;
    private final Handler timeoutHandler = new Handler();
    private View viewfinder;

    public RedLaserScannerActivity()
    {
        orientationLandscape = false;
    }

    private static String getTypeString(int i)
    {
        switch (i)
        {
        default:
            return "OTH";

        case 1: // '\001'
        case 4: // '\004'
        case 4096: 
        case 8192: 
            return "EAN";

        case 2: // '\002'
            return "UPC";

        case 16: // '\020'
            return "QRC";

        case 32: // ' '
            return "128";

        case 64: // '@'
            return "39";
        }
    }

    private static String stripRightBracket(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("]C1"))
            {
                s1 = s;
                if (s.length() >= 4)
                {
                    s1 = s.substring(3);
                }
            }
        }
        return s1;
    }

    public String getOrientationSetting()
    {
        if (orientationLandscape)
        {
            return "orientationLandscape";
        } else
        {
            return "orientationPortrait";
        }
    }

    public void onBackPressed()
    {
        setResult(0);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag7 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag8 = true;
        boolean flag = true;
        boolean flag6 = true;
        boolean flag2 = true;
        boolean flag9 = true;
        boolean flag5 = flag9;
        if (getIntent().getExtras() != null)
        {
            boolean flag10 = getIntent().getExtras().getBoolean("qrcode");
            boolean flag11 = getIntent().getExtras().getBoolean("code128");
            boolean flag12 = getIntent().getExtras().getBoolean("code39");
            if (getIntent().getExtras().containsKey("upce"))
            {
                flag = getIntent().getExtras().getBoolean("upce");
            }
            if (getIntent().getExtras().containsKey("ean8"))
            {
                flag2 = getIntent().getExtras().getBoolean("ean8");
            }
            flag3 = flag11;
            flag4 = flag12;
            flag5 = flag9;
            flag6 = flag2;
            flag7 = flag10;
            flag8 = flag;
            if (getIntent().getExtras().containsKey("ean13"))
            {
                flag5 = getIntent().getExtras().getBoolean("ean13");
                flag8 = flag;
                flag7 = flag10;
                flag6 = flag2;
                flag4 = flag12;
                flag3 = flag11;
            }
        }
        Point point;
        if (flag4 || android.os.Build.VERSION.SDK_INT < 8)
        {
            orientationLandscape = true;
        } else
        {
            boolean flag1;
            if (getResources().getConfiguration().orientation == 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            orientationLandscape = flag1;
        }
        super.onCreate(bundle);
        enabledTypes.setUpce(flag8);
        enabledTypes.setEan2(false);
        enabledTypes.setEan5(false);
        enabledTypes.setEan8(flag6);
        enabledTypes.setEan13(flag5);
        enabledTypes.setQRCode(flag7);
        enabledTypes.setCode128(flag3);
        enabledTypes.setCode39(flag4);
        enabledTypes.setCode93(false);
        enabledTypes.setDataMatrix(false);
        enabledTypes.setITF(false);
        enabledTypes.setRSS14(false);
        enabledTypes.setSticky(false);
        enabledTypes.setCodabar(false);
        getWindow().setFlags(1024, 1024);
        if (orientationLandscape)
        {
            setContentView(R.layout.preview_overlay_landscape);
        } else
        {
            setContentView(R.layout.preview_overlay_portait);
        }
        viewfinder = findViewById(0x1020002).findViewById(R.id.view_finder);
        hintText = (TextView)findViewById(R.id.hint_text);
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        point = new Point();
        bundle.getSize(point);
        bundle = new android.widget.LinearLayout.LayoutParams((int)((float)point.x * 0.75F), (int)((float)point.y * 0.33F));
        bundle.gravity = 17;
        viewfinder.setLayoutParams(bundle);
        timeoutHandler.postDelayed(closeActivity, 0x493e0L);
    }

    protected void onError(int i)
    {
        Log.e(getClass().getSimpleName(), (new StringBuilder()).append("Android camera error: ").append(i).toString());
    }

    protected void onScanStatusUpdate(Map map)
    {
label0:
        {
            Object obj = (HashSet)map.get("FoundBarcodes");
            if (obj != null && ((HashSet) (obj)).size() > 0)
            {
                MediaPlayer.create(this, R.raw.com_ebay_mobile_redlaser_beep).start();
                Intent intent = new Intent();
                obj = (BarcodeResult)((HashSet) (obj)).iterator().next();
                intent.putExtra("productid", stripRightBracket(((BarcodeResult) (obj)).barcodeString));
                intent.putExtra("productidtype", getTypeString(((BarcodeResult) (obj)).barcodeType));
                setResult(-1, intent);
                finish();
            }
            map = (Boolean)map.get("InRange");
            if (map != null)
            {
                if (!map.booleanValue())
                {
                    break label0;
                }
                hintText.setText(getString(R.string.com_ebay_mobile_redlaser_hold_still));
                viewfinder.setBackground(getResources().getDrawable(R.drawable.com_ebay_mobile_redlaser_viewfinder_green));
            }
            return;
        }
        hintText.setText(getString(R.string.com_ebay_mobile_redlaser_align_barcode));
        viewfinder.setBackground(getResources().getDrawable(R.drawable.com_ebay_mobile_redlaser_viewfinder_white));
    }

    public boolean onSearchRequested()
    {
        return false;
    }
}
