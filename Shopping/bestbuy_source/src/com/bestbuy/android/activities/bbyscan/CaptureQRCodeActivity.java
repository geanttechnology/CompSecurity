// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.bbyscan;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import br;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.managers.bbyscan.ViewfinderView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.ChatSDK;
import iv;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import kf;
import ll;
import lu;
import lv;
import lw;
import ly;
import mb;
import mc;
import mj;
import nb;
import p;

public final class CaptureQRCodeActivity extends Activity
    implements android.view.SurfaceHolder.Callback
{

    private static final String a = com/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity.getSimpleName();
    private static final Set b;
    private lw c;
    private ViewfinderView d;
    private BBYTextView e;
    private View f;
    private Result g;
    private boolean h;
    private br i;
    private String j;
    private String k;
    private Vector l;
    private String m;
    private mc n;
    private lv o;
    private String p;
    private String q;
    private String r;
    private RelativeLayout s;
    private SurfaceView t;
    private boolean u;
    private LinearLayout v;
    private LinearLayout w;

    public CaptureQRCodeActivity()
    {
        u = false;
    }

    private void a(Bitmap bitmap, Result result)
    {
        int i1 = 0;
        ResultPoint aresultpoint[] = result.getResultPoints();
        if (aresultpoint != null && aresultpoint.length > 0)
        {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(0x7f0b0063));
            paint.setStrokeWidth(3F);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawRect(new Rect(2, 2, bitmap.getWidth() - 2, bitmap.getHeight() - 2), paint);
            paint.setColor(getResources().getColor(0x7f0b0007));
            if (aresultpoint.length != 2)
            {
                if (aresultpoint.length == 4 && result.getBarcodeFormat().equals(BarcodeFormat.UPC_A) || result.getBarcodeFormat().equals(BarcodeFormat.EAN_13))
                {
                    a(canvas, paint, aresultpoint[0], aresultpoint[1]);
                    a(canvas, paint, aresultpoint[2], aresultpoint[3]);
                    return;
                }
                paint.setStrokeWidth(10F);
                int j1 = aresultpoint.length;
                while (i1 < j1) 
                {
                    bitmap = aresultpoint[i1];
                    canvas.drawPoint(bitmap.getX(), bitmap.getY(), paint);
                    i1++;
                }
            }
        }
    }

    private void a(Canvas canvas, Paint paint, ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        canvas.drawLine(resultpoint.getX(), resultpoint.getY(), resultpoint1.getX(), resultpoint1.getY(), paint);
    }

    private void a(SurfaceHolder surfaceholder)
    {
        try
        {
            mj.a().a(surfaceholder);
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            kf.a(a, "Unexpected error initializating camera", surfaceholder);
            f();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            kf.d(a, (new StringBuilder()).append("IOException Error : ").append(surfaceholder).toString());
            f();
            return;
        }
        if (c == null)
        {
            c = new lw(this, l, m);
        }
    }

    private void a(String s1, Result result)
    {
        if (!s1.equals("LIFE_EVENTS_PRODUCT_SCAN"))
        {
            s1 = new Intent(getIntent().getAction());
            s1.addFlags(0x80000);
            s1.putExtra("SCAN_RESULT", result.toString());
            s1.putExtra("SCAN_RESULT_FORMAT", result.getBarcodeFormat().toString());
        }
    }

    static boolean a(CaptureQRCodeActivity captureqrcodeactivity)
    {
        return captureqrcodeactivity.u;
    }

    static boolean a(CaptureQRCodeActivity captureqrcodeactivity, boolean flag)
    {
        captureqrcodeactivity.u = flag;
        return flag;
    }

    private void b(Result result, Bitmap bitmap)
    {
        d.a(bitmap);
        i = br.a;
        if (i != br.a) goto _L2; else goto _L1
_L1:
        if (!k.equals("GIFT_CARD")) goto _L4; else goto _L3
_L3:
        if (result.toString().length() != 16) goto _L6; else goto _L5
_L5:
        a(k, result);
        bitmap = new Intent();
        bitmap.putExtra("gift_id", result.toString());
        setResult(BBYBaseFragmentActivity.GC_SCAN_SUCCESS, bitmap);
        finish();
_L8:
        return;
_L6:
        d();
        return;
_L4:
        if (k.equals("CODE_SCAN"))
        {
            if (result.toString().contains("?c="))
            {
                a(k, result);
                bitmap = new Intent();
                bitmap.putExtra("ProductScan", result.toString());
                setResult(BBYBaseFragmentActivity.PRODUCT_SCAN, bitmap);
                finish();
                return;
            } else
            {
                (new iv(this, null, result)).execute(new Void[0]);
                return;
            }
        }
        if (k.equals("LIFE_EVENTS_PRODUCT_SCAN"))
        {
            bitmap = result.toString();
            if (bitmap.contains("?c="))
            {
                bitmap = bitmap.substring(bitmap.indexOf("?c="), bitmap.length()).replace("?c=", "");
                bitmap.substring(0, 7);
                a(result, bitmap.substring(7, bitmap.length()));
                return;
            } else
            {
                (new iv(this, null, result, true)).execute(new Void[0]);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == br.b)
        {
            result = Message.obtain(c, 0x7f0c0004);
            c.sendMessageDelayed(result, 0L);
            return;
        }
        if (i == br.c)
        {
            result = Message.obtain(c, 0x7f0c0004);
            c.sendMessageDelayed(result, 0L);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void f()
    {
        if (this == null || isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(getString(0x7f0800b4));
            builder.setMessage(getString(0x7f08023c));
            builder.setPositiveButton(0x7f080284, new mb(this));
            builder.setOnCancelListener(new mb(this));
            builder.show();
            return;
        }
    }

    private void g()
    {
        f.setVisibility(8);
        e.setVisibility(0);
        d.setVisibility(0);
        g = null;
    }

    public ViewfinderView a()
    {
        return d;
    }

    public void a(Result result, Bitmap bitmap)
    {
        n.a();
        g = result;
        o.b();
        a(bitmap, result);
        b(result, bitmap);
    }

    public void a(Result result, String s1)
    {
        if (s1 == null)
        {
            d();
            return;
        } else
        {
            a(k, result);
            Intent intent = new Intent();
            intent.putExtra("ProductScan", result.toString());
            intent.putExtra("skuid", s1);
            intent.putExtra("uuid", q);
            intent.putExtra("type", r);
            intent.putExtra("fromLifeEventsProductScan", true);
            setResult(BBYBaseFragmentActivity.PRODUCT_SCAN, intent);
            finish();
            return;
        }
    }

    public void a(Result result, String s1, String s2)
    {
        a(k, result);
        Intent intent = new Intent();
        intent.putExtra("ProductScan", result.toString());
        intent.putExtra("SkuId", s1);
        intent.putExtra("ProductId", s2);
        setResult(BBYBaseFragmentActivity.PRODUCT_SCAN, intent);
        finish();
    }

    public Handler b()
    {
        return c;
    }

    public void c()
    {
        d.a();
    }

    public void d()
    {
        ll.b(w);
        c.sendEmptyMessageDelayed(0x7f0c0006, 5000L);
    }

    public void e()
    {
        Toast.makeText(getApplicationContext(), "Item Added", 0).show();
        ll.b(v);
        nb nb1 = nb.a();
        if (r.equalsIgnoreCase("weddingregistrylists"))
        {
            nb1.l(true);
        } else
        {
            nb1.j(true);
        }
        nb1.k(true);
        c.sendEmptyMessageDelayed(0x7f0c0006, 5000L);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        switch (i1)
        {
        default:
            return;

        case 2222: 
            finish();
            break;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            if (bundle.containsKey("screen_name"))
            {
                k = bundle.getString("screen_name");
            }
            if (bundle.containsKey("screen_title"))
            {
                p = bundle.getString("screen_title");
            }
            if (bundle.containsKey("uuid"))
            {
                q = bundle.getString("uuid");
            }
            if (bundle.containsKey("type"))
            {
                r = bundle.getString("type");
            }
        }
        if (k.equals("GIFT_CARD"))
        {
            setContentView(0x7f03001e);
            bundle = (Button)findViewById(0x7f0c009c);
            bundle.getBackground().setAlpha(64);
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final CaptureQRCodeActivity a;

                public void onClick(View view)
                {
                    a.setResult(BBYBaseFragmentActivity.MANUAL_ENTER);
                    a.finish();
                }

            
            {
                a = CaptureQRCodeActivity.this;
                super();
            }
            });
        } else
        if (k.equals("LIFE_EVENTS_PRODUCT_SCAN"))
        {
            setContentView(0x7f03001d);
            bundle = (Button)findViewById(0x7f0c009c);
            ((TextView)findViewById(0x7f0c0097)).setText(Html.fromHtml(getString(0x7f080204)));
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final CaptureQRCodeActivity a;

                public void onClick(View view)
                {
                    a.setResult(0);
                    a.finish();
                }

            
            {
                a = CaptureQRCodeActivity.this;
                super();
            }
            });
        } else
        {
            setContentView(0x7f03001c);
        }
        mj.a(getApplication());
        d = (ViewfinderView)findViewById(0x7f0c0087);
        v = (LinearLayout)findViewById(0x7f0c0038);
        w = (LinearLayout)findViewById(0x7f0c0098);
        f = findViewById(0x7f0c0088);
        e = (BBYTextView)findViewById(0x7f0c0097);
        findViewById(0x7f0c0096).setOnClickListener(new android.view.View.OnClickListener() {

            final CaptureQRCodeActivity a;

            public void onClick(View view)
            {
                if (CaptureQRCodeActivity.a(a))
                {
                    CaptureQRCodeActivity.a(a, false);
                    mj.a().d();
                    return;
                } else
                {
                    CaptureQRCodeActivity.a(a, mj.a().c());
                    return;
                }
            }

            
            {
                a = CaptureQRCodeActivity.this;
                super();
            }
        });
        c = null;
        g = null;
        h = false;
        n = new mc(this);
        o = new lv(this);
        if (k.equals("GAMING_SCAN"))
        {
            e.setText(0x7f0800c4);
        }
    }

    protected void onDestroy()
    {
        p.d(this);
        n.b();
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 != 4) goto _L2; else goto _L1
_L1:
        if (i != br.a) goto _L4; else goto _L3
_L3:
        setResult(0);
        finish();
_L6:
        return true;
_L4:
        if (i != br.d && i != br.c || g == null)
        {
            break; /* Loop/switch isn't completed */
        }
        g();
        if (c == null) goto _L6; else goto _L5
_L5:
        c.sendEmptyMessage(0x7f0c0006);
        return true;
_L2:
        if (i1 == 80 || i1 == 27) goto _L6; else goto _L7
_L7:
        return super.onKeyDown(i1, keyevent);
    }

    protected void onPause()
    {
        p.g(this);
        super.onPause();
        lu.a();
        if (c != null)
        {
            c.a();
            c = null;
        }
        mj.a().b();
        if (HelpMenuActivity.a)
        {
            stopService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        }
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    protected void onResume()
    {
        p.f(this);
        super.onResume();
        lu.a(this);
        g();
        s = (RelativeLayout)findViewById(0x7f0c0086);
        Object obj = (RelativeLayout)findViewById(0x7f0c009d);
        t = new SurfaceView(this);
        Object obj1 = t.getHolder();
        Intent intent;
        if (h)
        {
            a(((SurfaceHolder) (obj1)));
        } else
        {
            ((SurfaceHolder) (obj1)).addCallback(this);
            ((SurfaceHolder) (obj1)).setType(3);
        }
        if (t != null && s != null)
        {
            s.addView(t);
            if (obj != null)
            {
                ((RelativeLayout) (obj)).bringToFront();
            }
        }
        intent = getIntent();
        if (intent == null)
        {
            obj = null;
        } else
        {
            obj = intent.getAction();
        }
        if (intent == null)
        {
            obj1 = null;
        } else
        {
            obj1 = intent.getDataString();
        }
        if (intent != null && obj != null)
        {
            if (((String) (obj)).equals("com.google.zxing.client.android.SCAN"))
            {
                i = br.a;
                l = ly.a(intent);
            } else
            if (obj1 != null && ((String) (obj1)).contains("http://www.google") && ((String) (obj1)).contains("/m/products/scan"))
            {
                i = br.b;
                j = ((String) (obj1));
                l = ly.a;
            } else
            {
                i = br.d;
                l = null;
            }
            m = intent.getStringExtra("CHARACTER_SET");
        } else
        {
            i = br.d;
            l = null;
            m = null;
        }
        o.a();
        if (ChatRunningStatus.getChatRunning())
        {
            ChatSDK.getSDKInstance().addChat(this);
        }
        if (HelpMenuActivity.a)
        {
            startService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        }
    }

    protected void onStart()
    {
        super.onStart();
        p.b(this);
    }

    protected void onStop()
    {
        super.onStop();
        p.c(this);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (!h)
        {
            h = true;
            a(surfaceholder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        h = false;
    }

    static 
    {
        b = new HashSet(5);
        b.add(ResultMetadataType.ISSUE_NUMBER);
        b.add(ResultMetadataType.SUGGESTED_PRICE);
        b.add(ResultMetadataType.ERROR_CORRECTION_LEVEL);
        b.add(ResultMetadataType.POSSIBLE_COUNTRY);
    }
}
