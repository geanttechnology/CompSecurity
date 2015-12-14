// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oi extends ViewGroup
    implements android.view.SurfaceHolder.Callback
{

    SurfaceView a;
    SurfaceHolder b;
    android.hardware.Camera.Size c;
    List d;
    Camera e;
    public android.hardware.Camera.Size f;
    public android.hardware.Camera.Size g;
    public ArrayList h;
    final ActivityCameraNoRealtime i;
    private final String j = "Preview";
    private boolean k;
    private String l[] = {
        "off", "on", "auto"
    };
    private int m;
    private android.hardware.Camera.Size n;

    public oi(ActivityCameraNoRealtime activitycameranorealtime, Context context)
    {
        i = activitycameranorealtime;
        super(context);
        k = false;
        f = null;
        g = null;
        h = new ArrayList();
        n = null;
        a = new SurfaceView(context);
        addView(a);
        b = a.getHolder();
        b.addCallback(this);
        b.setType(3);
        m = 0;
    }

    private boolean a(android.hardware.Camera.Parameters parameters)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (parameters.getSupportedFlashModes() != null)
        {
            flag = flag1;
            if (parameters.getSupportedFlashModes().contains("off"))
            {
                flag = flag1;
                if (parameters.getSupportedFlashModes().contains("on"))
                {
                    flag = flag1;
                    if (parameters.getSupportedFlashModes().contains("auto"))
                    {
                        flag = true;
                    }
                }
            }
        }
        System.out.println((new StringBuilder()).append("flashstate:").append(flag).toString());
        return flag;
    }

    private void c()
    {
        android.hardware.Camera.Parameters parameters = e.getParameters();
        float f1;
        char c1;
        char c2;
        char c3;
        char c4;
        if (a(parameters))
        {
            parameters.setFlashMode(l[b()]);
            ActivityCameraNoRealtime.w(i).setVisibility(0);
        } else
        {
            ActivityCameraNoRealtime.w(i).setVisibility(4);
        }
        f = a(parameters.getSupportedPreviewSizes(), 800, 600);
        if (f != null)
        {
            parameters.setPreviewSize(f.width, f.height);
            ActivityCameraNoRealtime.a(i, f);
        }
        f1 = a();
        if (f1 > 0.7F && f1 < 1.7F)
        {
            c1 = '\u0640';
            c2 = '\u04B0';
        } else
        if (f1 > 1.7F)
        {
            c1 = '\u0960';
            c2 = '\u0708';
        } else
        {
            c1 = '\u0320';
            c2 = '\u0258';
        }
        c4 = c1;
        c3 = c2;
        if (c2 * c1 > 0x2dc6c0)
        {
            c3 = '\u05DC';
            c4 = '\u07D0';
        }
        if (ActivityCameraNoRealtime.c(i))
        {
            g = a(parameters.getSupportedPictureSizes(), c4, c3);
        } else
        if ((double)f1 < 1.5D)
        {
            g = bzv.a(parameters.getSupportedPictureSizes(), 800, 600);
        } else
        {
            g = bzv.a(parameters.getSupportedPictureSizes(), (int)((double)800 * 1.5D), (int)((double)600 * 1.5D));
        }
        if (g == null) goto _L2; else goto _L1
_L1:
        Log.e("Preview", (new StringBuilder()).append("takePictureSize:").append(g.width).append(",").append(g.height).append(",previewSize:").append(f.width).append(",").append(f.height).toString());
        parameters.setPictureSize(g.width, g.height);
        pt.a(g, InstaBeautyApplication.a);
        if (n != null) goto _L4; else goto _L3
_L3:
        n = g;
        h.add(n);
_L2:
        e.setParameters(parameters);
        return;
_L4:
        if (n.height != g.height && n.width != g.width)
        {
            h.add(g);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public float a()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityManager activitymanager = (ActivityManager)InstaBeautyApplication.a.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            activitymanager.getMemoryInfo(memoryinfo);
            return (float)memoryinfo.totalMem / 1.073742E+09F;
        }
        float f1;
        BufferedReader bufferedreader;
        String s;
        String as[];
        String s1;
        int i1;
        int j1;
        try
        {
            bufferedreader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            s = bufferedreader.readLine();
            as = s.split("\\s+");
            j1 = as.length;
        }
        catch (IOException ioexception)
        {
            return -1F;
        }
        i1 = 0;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = as[i1];
        Log.i(s, (new StringBuilder()).append(s1).append("\t").toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_86;
_L1:
        f1 = (float)Integer.valueOf(as[1]).intValue() / 1048576F;
        bufferedreader.close();
        return f1;
    }

    public android.hardware.Camera.Size a(List list, int i1, int j1)
    {
        double d5;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        d5 = (double)i1 / (double)j1;
        if (list != null) goto _L2; else goto _L1
_L1:
        return ((android.hardware.Camera.Size) (obj1));
_L2:
        double d1 = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            obj1 = (android.hardware.Camera.Size)iterator.next();
            if (Math.abs((double)((android.hardware.Camera.Size) (obj1)).width / (double)((android.hardware.Camera.Size) (obj1)).height - d5) <= 0.050000000000000003D && (double)Math.abs(((android.hardware.Camera.Size) (obj1)).height - j1) < d1)
            {
                d1 = Math.abs(((android.hardware.Camera.Size) (obj1)).height - j1);
                obj = obj1;
            }
        } while (true);
        obj1 = obj;
        if (obj != null)
        {
            continue;
        }
        iterator = list.iterator();
        double d3 = 1.7976931348623157E+308D;
        double d2 = d1;
        d1 = d3;
        do
        {
            obj1 = obj;
            if (!iterator.hasNext())
            {
                continue;
            }
            list = (android.hardware.Camera.Size)iterator.next();
            double d4 = (double)((android.hardware.Camera.Size) (list)).width / (double)((android.hardware.Camera.Size) (list)).height;
            if (Math.abs(d4 - d5) <= d1 && d4 > 1.0D)
            {
                if ((double)Math.abs(((android.hardware.Camera.Size) (list)).height - j1) < d2)
                {
                    d1 = Math.abs(d4 - d5);
                    d2 = Math.abs(((android.hardware.Camera.Size) (list)).height - j1);
                } else
                {
                    list = ((List) (obj));
                }
                obj = list;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(int i1)
    {
        m = i1;
    }

    public void a(Camera camera)
    {
        e = camera;
        if (e != null)
        {
            d = e.getParameters().getSupportedPreviewSizes();
            c();
            try
            {
                camera.setPreviewDisplay(b);
            }
            // Misplaced declaration of an exception variable
            catch (Camera camera)
            {
                Log.e("Preview", "IOException caused by setPreviewDisplay()", camera);
            }
            e.startPreview();
            k = true;
        }
    }

    public int b()
    {
        return m;
    }

    public void b(Camera camera)
    {
        a(camera);
        ((ImageView)(ImageView)((Activity)getContext()).findViewById(0x7f0d004f)).setVisibility(4);
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
label0:
        {
            if (flag && getChildCount() > 0)
            {
                View view = getChildAt(0);
                k1 -= i1;
                l1 -= j1;
                if (c != null)
                {
                    j1 = c.height;
                    i1 = c.width;
                } else
                {
                    i1 = l1;
                    j1 = k1;
                }
                if (k1 * i1 <= l1 * j1)
                {
                    break label0;
                }
                i1 = (j1 * l1) / i1;
                view.layout((k1 - i1) / 2, 0, (i1 + k1) / 2, l1);
            }
            return;
        }
        i1 = (i1 * k1) / j1;
        view.layout(0, (l1 - i1) / 2, k1, (i1 + l1) / 2);
    }

    protected void onMeasure(int i1, int j1)
    {
        setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), i1), resolveSize(getSuggestedMinimumHeight(), j1));
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        System.out.println("camera_surface,changed!");
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        System.out.println("camera_surface,created!");
        try
        {
            if (e != null)
            {
                e.setPreviewDisplay(surfaceholder);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Crashlytics.logException(surfaceholder);
        }
        Log.e("Preview", "IOException caused by setPreviewDisplay()", surfaceholder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        System.out.println("camera_surface,destroyed!");
        if (!k)
        {
            return;
        }
        if (e != null)
        {
            e.stopPreview();
        }
        k = false;
    }
}
