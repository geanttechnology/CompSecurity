// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.webkit.WebView;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package com.medialets.advertising:
//            aa, a, ae, AdView, 
//            y

public class AdWebView extends WebView
{

    private HashMap a;
    private HashMap b;
    private ae c;

    public AdWebView(Context context)
    {
        super(context);
    }

    public AdWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AdWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private static String a(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(8192);
        try
        {
            aa.a(new RandomAccessFile(s, "r"), bytearrayoutputstream);
        }
        catch (Exception exception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Exception loading webview: ").append(s).append(": ").append(exception.toString()).toString());
            return null;
        }
        return bytearrayoutputstream.toString();
    }

    public void load(String s)
    {
        s = a(s);
        Object aobj[] = a.keySet().toArray();
        for (int i = 0; i < aobj.length; i++)
        {
            String s3 = (String)aobj[i];
            String s4 = (String)a.get(s3);
            if (s3 != null && s4 != null)
            {
                s = s.replaceAll(String.format("(?i)%s", new Object[] {
                    s3
                }).replace("$", "\\$"), s4);
            }
        }

        String s1;
        if (b != null && !b.equals(""))
        {
            Object aobj1[] = b.keySet().toArray();
            int j = 0;
            while (j < aobj1.length) 
            {
                String s5 = (String)aobj1[j];
                String s6 = (String)b.get(s5);
                String s2 = s;
                if (s5 != null)
                {
                    s2 = s;
                    if (s6 != null)
                    {
                        s2 = s.replaceAll(String.format("(?i)%s", new Object[] {
                            s5
                        }).replace("$", "\\$"), s6);
                    }
                }
                j++;
                s = s2;
            }
        }
        s1 = String.format("file:///%s/%s/%s/mmbridge.js", new Object[] {
            getContext().getFilesDir(), "medialytics", c.d()
        });
        clearView();
        clearHistory();
        loadDataWithBaseURL(s1, s, "text/html", "utf-8", null);
    }

    public void onDraw(Canvas canvas)
    {
        AdView adview = (AdView)getParent();
        if (adview.getSlotType() != 1 && y.f() == 2)
        {
            Display display = y.c();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            float f1 = (new Integer(displaymetrics.heightPixels)).floatValue();
            float f2 = (new Integer(displaymetrics.widthPixels)).floatValue();
            float f = adview.mAdvertisement.k();
            float f3 = displaymetrics.density;
            if (adview.getSlotType() == 2)
            {
                f = (float)adview.mAdvertisement.i() * displaymetrics.density;
            } else
            {
                f *= f3;
            }
            canvas.save();
            canvas.translate((f2 - f) / 2.0F, f1);
            canvas.rotate(-90F);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (((AdView)getParent()).getSlotType() != 1 && y.f() == 2)
        {
            Display display = y.c();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            motionevent.setLocation((float)displaymetrics.heightPixels - motionevent.getRawY(), motionevent.getRawX());
        }
        return super.onTouchEvent(motionevent);
    }

    public void setAdvertisement(ae ae1)
    {
        c = ae1;
    }

    public void setCustomMacros(HashMap hashmap)
    {
        b = hashmap;
    }

    public void setStandardMacros(HashMap hashmap)
    {
        a = hashmap;
    }
}
