// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

final class mi
{

    private static final String a = mi.getSimpleName();
    private static final Pattern b = Pattern.compile(",");
    private final Context c;
    private Point d;
    private Point e;
    private int f;
    private String g;

    mi(Context context)
    {
        c = context;
    }

    private static int a(CharSequence charsequence, int i)
    {
        charsequence = b.split(charsequence);
        int i1 = charsequence.length;
        int k = 0;
        int j = 0;
        while (k < i1) 
        {
            String s = charsequence[k].trim();
            double d1;
            int l;
            try
            {
                d1 = Double.parseDouble(s);
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                return i;
            }
            l = (int)(10D * d1);
            if (Math.abs((double)i - d1) < (double)Math.abs(i - j))
            {
                j = l;
            }
            k++;
        }
        return j;
    }

    private static Point a(android.hardware.Camera.Parameters parameters, Point point)
    {
        Object obj = parameters.get("preview-size-values");
        if (obj == null)
        {
            obj = parameters.get("preview-size-value");
        }
        parameters = null;
        if (obj != null)
        {
            parameters = a(((CharSequence) (obj)), point);
        }
        obj = parameters;
        if (parameters == null)
        {
            obj = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return ((Point) (obj));
    }

    private static Point a(CharSequence charsequence, Point point)
    {
        int i;
        int j;
        int l;
        int i1;
        int l1;
        charsequence = b.split(charsequence);
        l1 = charsequence.length;
        l = 0;
        j = 0;
        i = 0;
        i1 = 0x7fffffff;
_L2:
        String s;
        int k;
        if (l >= l1)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        s = charsequence[l].trim();
        k = s.indexOf('x');
        if (k >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        j = i;
        i = k;
_L5:
        l++;
        k = j;
        j = i;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = Integer.parseInt(s.substring(0, k));
        k = Integer.parseInt(s.substring(k + 1));
        int k1 = Math.abs(j1 - point.x) + Math.abs(k - point.y);
        if (k1 != 0) goto _L4; else goto _L3
_L3:
        NumberFormatException numberformatexception;
        if (j1 > 0 && k > 0)
        {
            return new Point(j1, k);
        } else
        {
            return null;
        }
        numberformatexception;
        k = i;
        i = j;
        j = k;
          goto _L5
_L4:
        if (k1 < i1)
        {
            i1 = k1;
            j = j1;
            i = k;
        } else
        {
            k = i;
            i = j;
            j = k;
        }
          goto _L5
        k = j;
        j1 = i;
          goto _L3
    }

    private void a(android.hardware.Camera.Parameters parameters)
    {
        if (Build.MODEL.contains("Behold II") && mj.a == 3)
        {
            parameters.set("flash-value", 1);
        } else
        {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    private void b(android.hardware.Camera.Parameters parameters)
    {
        String s = parameters.get("zoom-supported");
        if (s == null || Boolean.parseBoolean(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            int j = 27;
            String s1 = parameters.get("max-zoom");
            int i = j;
            if (s1 == null)
            {
                break label0;
            }
            double d1;
            String s2;
            String s3;
            String s4;
            int k;
            try
            {
                d1 = Double.parseDouble(s1);
            }
            catch (NumberFormatException numberformatexception)
            {
                i = j;
                break label0;
            }
            i = (int)(d1 * 10D);
            NumberFormatException numberformatexception1;
            NumberFormatException numberformatexception2;
            if (27 <= i)
            {
                i = 27;
            }
        }
        s2 = parameters.get("taking-picture-zoom-max");
        j = i;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        k = Integer.parseInt(s2);
        j = i;
        if (i > k)
        {
            j = k;
        }
_L3:
        s3 = parameters.get("mot-zoom-values");
        i = j;
        if (s3 != null)
        {
            i = a(s3, j);
        }
        s4 = parameters.get("mot-zoom-step");
        j = i;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        k = (int)(Double.parseDouble(s4.trim()) * 10D);
        j = i;
        if (k > 1)
        {
            j = i - i % k;
        }
_L4:
        if (s1 != null || s3 != null)
        {
            parameters.set("zoom", String.valueOf((double)j / 10D));
        }
        if (s2 != null)
        {
            parameters.set("taking-picture-zoom", j);
            return;
        }
          goto _L1
        numberformatexception1;
        j = i;
          goto _L3
        numberformatexception2;
        j = i;
          goto _L4
    }

    Point a()
    {
        return e;
    }

    void a(Camera camera)
    {
        camera = camera.getParameters();
        f = camera.getPreviewFormat();
        g = camera.get("preview-format");
        Display display = ((WindowManager)c.getSystemService("window")).getDefaultDisplay();
        d = new Point(display.getWidth(), display.getHeight());
        e = a(((android.hardware.Camera.Parameters) (camera)), d);
    }

    Point b()
    {
        return d;
    }

    void b(Camera camera)
    {
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(e.x, e.y);
        parameters.set("orientation", "portrait");
        a(parameters);
        b(parameters);
        camera.setParameters(parameters);
        camera.setDisplayOrientation(90);
    }

    int c()
    {
        return f;
    }

    String d()
    {
        return g;
    }

}
