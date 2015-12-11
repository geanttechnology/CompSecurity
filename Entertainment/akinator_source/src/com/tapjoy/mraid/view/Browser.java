// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tapjoy.TapjoyLog;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.JarFile;

public class Browser extends Activity
{

    public static final String SHOW_BACK_EXTRA = "open_show_back";
    public static final String SHOW_FORWARD_EXTRA = "open_show_forward";
    public static final String SHOW_REFRESH_EXTRA = "open_show_refresh";
    public static final String URL_EXTRA = "extra_url";

    public Browser()
    {
    }

    static Bitmap a(Browser browser, String s)
    {
        return browser.a(s);
    }

    private Bitmap a(String s)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        s = Base64.decode(s, 0);
        Bitmap bitmap = BitmapFactory.decodeByteArray(s, 0, s.length);
        s = bitmap;
        if (bitmap != null)
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            float f = displaymetrics.scaledDensity;
            float f1 = displaymetrics.scaledDensity;
            s = new Matrix();
            s.postScale(f, f1);
            s = Bitmap.createBitmap(bitmap, 0, 0, i, j, s, true);
        }
        return s;
    }

    public Bitmap bitmapFromJar(String s)
    {
        Object obj2 = null;
        Object obj1 = com/tapjoy/mraid/view/Browser.getClassLoader().getResource(s).getFile();
        Object obj = obj1;
        int i;
        if (((String) (obj1)).startsWith("file:"))
        {
            obj = ((String) (obj1)).substring(5);
        }
        i = ((String) (obj)).indexOf("!");
        obj1 = obj;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj1 = ((String) (obj)).substring(0, i);
        obj = new JarFile(((String) (obj1)));
        s = ((JarFile) (obj)).getInputStream(((JarFile) (obj)).getJarEntry(s));
        obj = s;
        obj1 = BitmapFactory.decodeStream(s);
        obj = obj1;
        obj1 = obj;
        if (s != null)
        {
            Exception exception1;
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return ((Bitmap) (obj));
            }
            obj1 = obj;
        }
        return ((Bitmap) (obj1));
        exception1;
        s = null;
_L4:
        obj = s;
        exception1.printStackTrace();
        exception1 = obj2;
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return null;
        } else
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s;
        obj = null;
_L2:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (Exception exception) { }
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new RelativeLayout(this);
        WebView webview = new WebView(this);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        Intent intent = getIntent();
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(0);
        linearlayout.setId(100);
        linearlayout.setWeightSum(100F);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 100);
        linearlayout.setBackgroundDrawable(new BitmapDrawable(a("iVBORw0KGgoAAAANSUhEUgAAAAEAAAAsCAIAAAArRUU2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAEFJREFUeNpicPP0Zvr3/z/T/3//gDQQg+i//5j+gum/QBqIQXwg+x+Y\njckH6fkL0/f3NwMPHz8jKxsbAw0AQIABAGYHPKslk98oAAAAAElFTkSuQmCC")));
        bundle.addView(webview, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        bundle.addView(linearlayout, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new android.widget.LinearLayout.LayoutParams(-2, -1);
        obj.weight = 25F;
        obj.gravity = 16;
        Object obj1 = new ImageButton(this);
        ((ImageButton) (obj1)).setBackgroundColor(getResources().getColor(0x106000d));
        ((ImageButton) (obj1)).setId(103);
        linearlayout.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj)));
        if (!intent.getBooleanExtra("open_show_back", true))
        {
            ((ImageButton) (obj1)).setVisibility(8);
        }
        ((ImageButton) (obj1)).setImageBitmap(a("iVBORw0KGgoAAAANSUhEUgAAABIAAAAUCAYAAACAl21KAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAApVJREFUeNqUVEuLkmEYfT6/9/MejjjeRhvvOo7XomLIzRTChEQU0Sa6\nLdoEA21azN6NzG9oIGE2bdwERYggrdqI2SLb5G5o0VwYRZGZ0a/zig5WNo4PHF4+5DnvOed9Htnq\n6irNUuVymeHQARbA5XA4vDirbAYCBQ4NYAIuarXacDQafbK0tJRqNBr32TkIBBxKwAgsKBQKTzgc\nfgCCO36/XxOPx6lYLBKbQsB/vwDYuI3FxcWby8vLDwOBwEIkEiFO4vV6qVarTSYCiYhDC5g5gdFo\nTMLGs2AwGIeSAUEoFCKLxUJqtZpEUfyTaJiDapiDU6lUBmKx2CM03YAKiRNAESFg0ul0BJunvWzM\nhgTMAXauAs13gXsgmOMEUEQul4sMBgMx9q8RNnxOPWDlBHa7/TpufQobbn47J0GoZDKZCApJEISJ\nmbKhEpter78GGy+gYgUklEgkiOdhs9lIo9H8l+CUCDcJaHjsdDpf+nw+3cgGvgnkgyDPU2xvb6+L\n5D96PJ4MpjwJVTQ/Pz8xh7NKgea+SqX6lMvlruzs7DxvtVq/jo6OSJblmYhEt9tNvV6PoETe3Nz8\ncnx8/BoKJazAZVzAuLVp+ZRKpbeDQej3+9RsNimdTsu7u7sHmUzmVT6fT1YqlQ/7+/t0cnIy3dr4\nB29AZrS2tibX6/XvqVTqdqFQuPUNBcuDC8+09ndxq7wR+yRD6Q+o28IDHMDuCmyr+UOM2+XWJhKN\nCnnR4eEhYdd62Wz2MxRtYaYMWI9LyE8YjcZUIl789brdLmFVuLXOxsbGe6vV+g7CglDokSSJqtXq\nm6lEo+L5dDodPu1yu93+ub6+vo3/pa8gu4px2RZm/asdvBC2nm8/9pLMZrMK1sXfAgwAtiLartJw\n+UAAAAAASUVORK5CYII="));
        ((ImageButton) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Browser a;

            public final void onClick(View view)
            {
                view = (WebView)a.findViewById(101);
                if (view.canGoBack())
                {
                    view.goBack();
                    return;
                } else
                {
                    a.finish();
                    return;
                }
            }

            
            {
                a = Browser.this;
                super();
            }
        });
        obj = new ImageButton(this);
        ((ImageButton) (obj)).setBackgroundColor(getResources().getColor(0x106000d));
        ((ImageButton) (obj)).setId(102);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -1);
        obj1.weight = 25F;
        obj1.gravity = 16;
        linearlayout.addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj1)));
        if (!intent.getBooleanExtra("open_show_forward", true))
        {
            ((ImageButton) (obj)).setVisibility(8);
        }
        ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final Browser a;

            public final void onClick(View view)
            {
                ((WebView)a.findViewById(101)).goForward();
            }

            
            {
                a = Browser.this;
                super();
            }
        });
        obj = new ImageButton(this);
        ((ImageButton) (obj)).setImageBitmap(a("iVBORw0KGgoAAAANSUhEUgAAABMAAAAUCAYAAABvVQZ0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAA2NJREFUeNqMVF1Ik1EYPm7TpsIca84pGs6VrboYaeRPpFgXKUzBH4S8\nsLoIMVCpRERCAgfSZXpR2ZVJCEIgaIQm+MdCIkXRTTTnQG0qorCFm21zp+f9+IQ5NHvh4eP7vnOe\n877Ped5Xyv4dEYAMSK2rq/tkt9tlXq83Cu9BwC8+zyQ4B5wHLgAG4M7IyAgfHR31FhcXv8F7EXAZ\nUADSo43SMCLKQimS0GKDTqfLys7OvlldXZ2Vnp4uy8nJuZGWlmacnp52ejyeANZ4AB/AQ4kigSQg\nT6/XPzebzd8pk4WFBb6+vs6xkVP4/X6+s7PDx8bGPJWVlWasTxGTOJZRInC3oaHh88zMjLDh4OCA\n+3w+4RkIBPhRHB4e8u3tbd7f38+rqqpM2CcJ1YhKu4Vsvq2urnKIzN1uN3c4HHxqaso1Pj7+Y3d3\nVyAicqfTyaHhenNzc1Eo0VF5F2traz+srKwIRFtbW3xoaMjW1tZ2X9Q12WazcZfLxefn53lXV9fb\niooKjZjIsVAkJSXdIw1IFyqvt7d3pLy8PCFksXJgYIAPDg5aGxsbs8OzCY2E+vr692tra4LIFovl\nd15eXmrYqbKmpiZzuNAnRXJ3d7eVStjc3OQo7ZXos7OC5ImjZAA1EE0nSbRarUYulzNoxeCfb/gW\n+A+yGEAvuoC8ZieyoFKpVEulUgYPMVy3Qyzn8IwuiYWNXl5FQB4/9r0gIf+gxG34iEVFRbH8/HwS\nOPakmwovMTMz81JZWZm+oKDAkJiYGENk3o2NjSVYgsXFxbHc3NxCMXX5KYRkFRU2XzEajQZUxSQS\nCdvb2/tJZAfLy8uDyI4pFApmMpkKNRpNJr7rxEaWiaS0NhrQAuk1NTVPoDWDiRmS2RweHrYK9aO0\nFPjMvb+/z3EC7+vr+6VWqx/j321xauhEsa8DJjR9NxIQDI6xxFtbW58emx4tLS0PFhcXhT4kwomJ\nCS/67qNKparH/4fAo4yMDHNHR8c8EdDB1J8w+NRJVors7Ox8t7S0JCwkIH1utVr57Owsn5ub49Ru\ndBAdSC2HG7SVlJRoT7ssaXt7e+3k5KSLiIiQJgRFMBgUmpzIqE97enq+lJaWhrbciYwRKE+NW32G\nIVgcHx9/TSaTMfAxkLsx2ywge40J8zV8bP8VYACAQuluULZPjQAAAABJRU5ErkJggg=="));
        ((ImageButton) (obj)).setBackgroundColor(getResources().getColor(0x106000d));
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.weight = 25F;
        obj1.gravity = 16;
        linearlayout.addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj1)));
        if (!intent.getBooleanExtra("open_show_refresh", true))
        {
            ((ImageButton) (obj)).setVisibility(8);
        }
        ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final Browser a;

            public final void onClick(View view)
            {
                ((WebView)a.findViewById(101)).reload();
            }

            
            {
                a = Browser.this;
                super();
            }
        });
        obj = new ImageButton(this);
        ((ImageButton) (obj)).setBackgroundColor(getResources().getColor(0x106000d));
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.weight = 25F;
        obj1.gravity = 16;
        linearlayout.addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj1)));
        ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final Browser a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = Browser.this;
                super();
            }
        });
        getWindow().requestFeature(2);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(intent.getStringExtra("extra_url"));
        webview.setId(101);
        webview.setWebViewClient(new WebViewClient() {

            final Browser a;

            public final void onPageFinished(WebView webview1, String s)
            {
                super.onPageFinished(webview1, s);
                ImageButton imagebutton = (ImageButton)a.findViewById(102);
                TapjoyLog.i("Mraid Browser", (new StringBuilder("onPageFinished: ")).append(s).toString());
                if (webview1.canGoForward())
                {
                    imagebutton.setImageBitmap(Browser.a(a, "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAq5JREFUeNqUlN9LmmEUx4++/ihKy6yZGEMjlExdEjgqQmm78ioGu41g\nu7Ftt+5mBF0Go8sIBvsTtggqGgODboK66aIwNi0lJ7p+2TT89b7Pvo/LaKucHTj4+LzP+bzne855\nXpnVan0ZiUSSoiimiCgBP4UXfD4fozpsbW2NhP7+/vdDQ0MvFLBkMnmBfQEuHhwclOHMbDbXhOAM\nCQ6HY8Lr9Tr8fv9ji8Xy6PDw8CKTyUh4LoNzUBkg9l/I4OCg2ePxkNPpfOB2u0cbGhoeQuJZsVjk\nWbHLrMTbYBVIb2/vhMvlMttsNurs7CSj0Si32+0W7D0BRMthOKuAS5cw6brEvyCQQk1NTdTY2Eht\nbW3U1dWlxr6rp6dnJJVKldLpdBEx8kuJYrVeNyAcwE0QBGpubqb29nbq7u7WDgwMjABs39/fz+Ry\nOV4rVoXx9a0QbjKZjJRKJWm1WjIYDIRRMKJeT/ECQzQazZTLZZ4Vb0D5Tsh1mFqtJp1ORyaTSejr\n67MixouMFLFY7AeOnCuoTsMYkV6vJ41GwxugR1cnNzY2POvr66/qhlzPChlRS0tLHuuv6F74XpCq\nYRg/7e7uvh0eHo7wwsrvE5zP53cQPIr6PMcV+T41NVUZvrog6MTPeDz+BoXn1yI0MzMjLS8v09bW\n1p961QpmjJWOj48/rKysvBsfHz+bm5tji4uLBBBls1nCzaeamUD3F1Tf3dHR8RoFPQ0GgywUCtHe\n3h5/dgWoQtg/ur+Fw+Fnra2tfoz7zvT0NFtdXaXt7W06Ojri0m68UI7+5/lCkqRfiUQiGAgEnPj9\nPDs7K3Ldm5ubhP9UKBS4vFuzlqtUqnPo+7i0tGTFpeMfqALXjSEijHdF+13BV/MzNjamWVhYyM7P\nzzOMcSXw5OSESqUS1ft5/C3AAL39YeI2ufApAAAAAElFTkSuQmCC"));
                    return;
                } else
                {
                    imagebutton.setImageBitmap(Browser.a(a, "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyK\nIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4\n/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhc\npBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/Yg\nWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyY\nOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAUR\ny3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gR\nr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1n\nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2\nY3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+N\nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3n\nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/\nY/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg=="));
                    return;
                }
            }

            public final void onPageStarted(WebView webview1, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview1, s, bitmap);
                ((ImageButton)a.findViewById(102)).setImageBitmap(Browser.a(a, "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyK\nIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4\n/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhc\npBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/Yg\nWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyY\nOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAUR\ny3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gR\nr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1n\nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2\nY3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+N\nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3n\nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/\nY/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg=="));
            }

            public final void onReceivedError(WebView webview1, int i, String s, String s1)
            {
                TapjoyLog.i("Mraid Browser", (new StringBuilder("WebView error: ")).append(s).toString());
            }

            public final boolean shouldOverrideUrlLoading(WebView webview1, String s)
            {
                webview1.loadUrl(s);
                return true;
            }

            
            {
                a = Browser.this;
                super();
            }
        });
        setContentView(bundle);
        webview.setWebChromeClient(new WebChromeClient() {

            final Browser a;

            public final void onProgressChanged(WebView webview1, int i)
            {
                Activity activity = (Activity)webview1.getContext();
                activity.setTitle("Loading...");
                activity.setProgress(i * 100);
                if (i == 100)
                {
                    activity.setTitle(webview1.getUrl());
                }
            }

            
            {
                a = Browser.this;
                super();
            }
        });
    }

    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }
}
