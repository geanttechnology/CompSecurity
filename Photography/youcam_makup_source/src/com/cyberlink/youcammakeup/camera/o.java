// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import android.os.Build;
import android.util.Pair;
import com.pf.common.utility.m;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            r, p, q

public class o
{

    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final r d[] = {
        new r("HTC", "HTC_M8x"), new r("htc", "HTC One 801e"), new r("htc", "HTC One 801s"), new r("htc", "HTC One 801n")
    };
    public static final r e[] = {
        new r("htc", "HTC Butterfly"), new r("Xiaomi", null), new r("Lenovo", "Lenovo A880"), new r("LGE", "LG-P880"), new r("Amazon", "KFJWI")
    };
    public static final r f[] = {
        new r("htc", "HTC Desire HD"), new r("Xiaomi", null), new r("samsung", "SCH-I699I"), new r("Lenovo", "Lenovo A880"), new r("LGE", "LG-P880"), new r("FIH", "SH530U"), new r("asus", "ME173X")
    };
    public static final p g[] = {
        new p("samsung", "GT-I9200", new q(1920, 1080)), new p("samsung", "GT-I9190", new q(1920, 1080))
    };
    public static final p h[] = new p[0];
    public static final p i[] = new p[0];
    public static final p j[] = {
        new p("asus", "ASUS_T00G", new q(1920, 1080))
    };
    public static final Comparator k = new Comparator() {

        public int a(android.hardware.Camera.Size size, android.hardware.Camera.Size size1)
        {
            int l = size.width * size.height;
            int i1 = size1.width * size1.height;
            if (l > i1)
            {
                return -1;
            }
            return l >= i1 ? 0 : 1;
        }

        public int compare(Object obj, Object obj1)
        {
            return a((android.hardware.Camera.Size)obj, (android.hardware.Camera.Size)obj1);
        }

    };

    public static int a(int l)
    {
        return b(l).facing;
    }

    public static int a(int l, int i1)
    {
        do
        {
            int j1 = l;
            if (j1 != 0 && i1 != 0)
            {
                l = i1;
                i1 = j1 % i1;
            } else
            {
                return j1 + i1;
            }
        } while (true);
    }

    public static void a(Camera camera, android.hardware.Camera.Parameters parameters)
    {
        try
        {
            camera.setParameters(parameters);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Camera camera)
        {
            m.b("CameraUtils", "", camera);
        }
    }

    public static boolean a()
    {
        boolean flag = false;
        int l;
        try
        {
            l = Camera.getNumberOfCameras();
        }
        catch (Exception exception)
        {
            return false;
        }
        if (l > 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(android.hardware.Camera.Parameters parameters)
    {
        boolean flag1 = false;
        parameters = parameters.getSupportedFlashModes();
        boolean flag = flag1;
        if (parameters != null)
        {
            flag = flag1;
            if (parameters.contains("auto"))
            {
                flag = flag1;
                if (parameters.contains("on"))
                {
                    flag = flag1;
                    if (parameters.contains("off"))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public static boolean a(Camera camera)
    {
        boolean flag;
        try
        {
            flag = b(camera.getParameters());
        }
        // Misplaced declaration of an exception variable
        catch (Camera camera)
        {
            m.b("CameraUtils", "isSupportAutoFocus(Camera)", camera);
            return false;
        }
        return flag;
    }

    public static android.hardware.Camera.CameraInfo b(int l)
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(l, camerainfo);
        return camerainfo;
    }

    public static boolean b()
    {
        boolean flag1 = false;
        r ar[] = d;
        int i1 = ar.length;
        int l = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (l < i1)
                {
                    r r1 = ar[l];
                    if (!Build.MANUFACTURER.equalsIgnoreCase(r1.b) || r1.c != null && !Build.MODEL.equalsIgnoreCase(r1.c))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            l++;
        } while (true);
    }

    public static boolean b(android.hardware.Camera.Parameters parameters)
    {
        for (parameters = parameters.getSupportedFocusModes().iterator(); parameters.hasNext();)
        {
            String s = (String)parameters.next();
            if (s.equals("auto") || s.equals("continuous-picture"))
            {
                return true;
            }
        }

        return false;
    }

    public static Pair c(int l)
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j1 = Camera.getNumberOfCameras();
        if (j1 == 0)
        {
            throw new RuntimeException("No physical camera can be used.");
        }
        for (int i1 = 0; i1 < j1; i1++)
        {
            Camera.getCameraInfo(i1, camerainfo);
            if (camerainfo.facing == l)
            {
                return new Pair(camerainfo, Integer.valueOf(i1));
            }
        }

        return null;
    }

    public static int d(int l)
    {
        Pair pair = c(l);
        if (pair == null)
        {
            return 0;
        } else
        {
            return ((Integer)pair.second).intValue();
        }
    }

    public static boolean e(int l)
    {
        return Camera.getNumberOfCameras() > 0 && l == a(d(l));
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (Build.MANUFACTURER.equalsIgnoreCase("asus") && Build.MODEL.equalsIgnoreCase("Nexus 7"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (Build.MANUFACTURER.equalsIgnoreCase("Amazon") && Build.MODEL.equalsIgnoreCase("KFJWI"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
