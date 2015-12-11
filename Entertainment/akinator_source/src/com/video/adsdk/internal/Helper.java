// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.video.adsdk.internal:
//            JavascriptCode

public class Helper
{

    static int ID_BUTTONCLOSE;
    static int ID_UIVIEWCONTAINER;
    static int ID_VIDEOVIEW;
    static int ID_VIDEOVIEWCONTAINER;
    static int ID_WEBVIEW;
    static int ID_WEBVIEWCONTAINER;

    public Helper()
    {
    }

    public static String SHA1(String s)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        messagedigest.update(s.getBytes("iso-8859-1"), 0, s.length());
        return convertToHex(messagedigest.digest());
    }

    public static String convertStreamToString(InputStream inputstream)
        throws IOException
    {
        Object obj;
        char ac[];
        obj = new StringWriter();
        ac = new char[2048];
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L1:
        int i = bufferedreader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ((Writer) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        inputstream.close();
        throw obj;
        inputstream.close();
        return obj.toString();
    }

    private static String convertToHex(byte abyte0[])
    {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = 0;
_L2:
        int j;
        int k;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        k = abyte0[i] >>> 4 & 0xf;
        j = 0;
_L3:
        if (k >= 0 && k <= 9)
        {
            stringbuilder.append((char)(k + 48));
        } else
        {
            stringbuilder.append((char)((k - 10) + 97));
        }
        k = abyte0[i] & 0xf;
        if (j < 1)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
        j++;
          goto _L3
    }

    static ViewGroup createAdVideoView(Context context)
    {
        RelativeLayout relativelayout = new RelativeLayout(context);
        relativelayout.setBackgroundColor(0);
        relativelayout.setId(ID_VIDEOVIEWCONTAINER);
        VideoView videoview = new VideoView(context);
        videoview.setBackgroundColor(0);
        videoview.setId(ID_VIDEOVIEW);
        RelativeLayout relativelayout1 = new RelativeLayout(context);
        relativelayout1.setBackgroundColor(0);
        relativelayout1.setId(ID_WEBVIEWCONTAINER);
        RelativeLayout relativelayout2 = new RelativeLayout(context);
        relativelayout2.setBackgroundColor(0);
        relativelayout2.setId(ID_UIVIEWCONTAINER);
        ImageButton imagebutton = new ImageButton(context);
        imagebutton.setBackgroundResource(context.getResources().getIdentifier("closebox", "drawable", context.getPackageName()));
        imagebutton.setContentDescription("Close");
        imagebutton.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(11);
        context.topMargin = 5;
        imagebutton.setLayoutParams(context);
        imagebutton.setId(ID_BUTTONCLOSE);
        relativelayout2.addView(imagebutton, context);
        relativelayout.addView(videoview, createFillCenterLayoutParams());
        relativelayout.addView(relativelayout1, createFillCenterLayoutParams());
        relativelayout.addView(relativelayout2, createFillCenterLayoutParams());
        return relativelayout;
    }

    static RelativeLayout createFakeAdVideoView(Context context)
    {
        RelativeLayout relativelayout = new RelativeLayout(context);
        relativelayout.setBackgroundColor(0);
        relativelayout.setId(ID_VIDEOVIEWCONTAINER);
        RelativeLayout relativelayout1 = new RelativeLayout(context);
        relativelayout1.setBackgroundColor(0);
        relativelayout1.setId(ID_UIVIEWCONTAINER);
        TextView textview = new TextView(context);
        textview.setBackgroundColor(0);
        textview.setId(ID_VIDEOVIEW);
        textview.setText("AD NOT AVAILABLE IN EMULATOR");
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        ImageButton imagebutton = new ImageButton(context);
        imagebutton.setBackgroundResource(context.getResources().getIdentifier("closebox", "drawable", context.getPackageName()));
        imagebutton.setContentDescription("Close");
        imagebutton.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        int i = (int)TypedValue.applyDimension(1, 64F, context.getResources().getDisplayMetrics());
        context = new android.widget.RelativeLayout.LayoutParams(i, i);
        context.addRule(11);
        context.topMargin = 5;
        imagebutton.setLayoutParams(context);
        imagebutton.setId(ID_BUTTONCLOSE);
        relativelayout1.addView(imagebutton, context);
        relativelayout.addView(textview, layoutparams);
        relativelayout.addView(relativelayout1, createFillCenterLayoutParams());
        return relativelayout;
    }

    private static android.widget.RelativeLayout.LayoutParams createFillCenterLayoutParams()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        return layoutparams;
    }

    public static WebView createWebViewForJavascriptInteraction(Context context)
    {
        context = new WebView(context);
        context.setId(ID_WEBVIEW);
        context.getSettings().setJavaScriptEnabled(true);
        context.getSettings().setBuiltInZoomControls(true);
        context.getSettings().setDomStorageEnabled(true);
        context.setHorizontalScrollBarEnabled(false);
        context.setVerticalScrollBarEnabled(false);
        context.setOnTouchListener(new _cls1());
        context.requestFocusFromTouch();
        setTransparentWebviewBackground(context);
        context.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        return context;
    }

    public static String getJavascriptContentToInject(Context context)
        throws IOException
    {
        return JavascriptCode.jsCode;
    }

    public static String md5(String s)
    {
        Object obj;
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).update(s.getBytes("UTF-8"));
        s = ((MessageDigest) (obj)).digest();
        obj = new StringBuffer();
        int i = 0;
_L2:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuffer) (obj)).append(Integer.toHexString(s[i] & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s = ((StringBuffer) (obj)).toString();
        return s;
        s;
        s.printStackTrace();
_L4:
        return "";
        s;
        Log.e("VIDEOADSDK", "UTF-8 not supported as encoding");
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String readTextFromResource(Context context, int i)
        throws IOException
    {
        context = context.getResources().openRawResource(i);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        for (i = context.read(); i != -1; i = context.read())
        {
            bytearrayoutputstream.write(i);
        }

        context.close();
        return bytearrayoutputstream.toString();
    }

    public static Boolean saveTextToSD(String s, String s1)
        throws IOException
    {
        File file = Environment.getExternalStorageDirectory();
        if (file.canWrite())
        {
            s1 = new File(file, s1);
            if (s1.exists())
            {
                s1.delete();
            }
            s1 = new FileWriter(s1, true);
            s1.write(s);
            s1.flush();
            s1.close();
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    private static void setTransparentWebviewBackground(WebView webview)
    {
        webview.setBackgroundColor(0x1000000);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webview.setLayerType(1, null);
        }
    }

    static 
    {
        ID_VIDEOVIEWCONTAINER = 0x1e240;
        ID_VIDEOVIEW = ID_VIDEOVIEWCONTAINER + 1;
        ID_WEBVIEWCONTAINER = ID_VIDEOVIEWCONTAINER + 2;
        ID_UIVIEWCONTAINER = ID_VIDEOVIEWCONTAINER + 3;
        ID_BUTTONCLOSE = ID_VIDEOVIEWCONTAINER + 4;
        ID_WEBVIEW = ID_VIDEOVIEWCONTAINER + 5;
    }

    /* member class not found */
    class _cls1 {}

}
