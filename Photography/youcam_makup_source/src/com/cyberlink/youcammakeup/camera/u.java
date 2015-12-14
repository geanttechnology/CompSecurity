// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.x;
import com.cyberlink.youcammakeup.venus.CommonShare;
import com.cyberlink.youcammakeup.venus.InternalModelState;
import com.cyberlink.youcammakeup.venus.MutableInteger;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            v, x, w

public class u
{

    protected final String a = (new StringBuilder()).append(CommonShare.openTempFolder()).append("/FaceBeautify").toString();
    protected final String b;
    private BeautifierManager c;
    private GLSurfaceView d;
    private x e;
    private boolean f;
    private float g;
    private w h;

    public u(GLSurfaceView glsurfaceview, w w)
    {
        c = BeautifierManager.a();
        d = null;
        e = null;
        b = (new StringBuilder()).append(a).append("/composite").toString();
        f = false;
        g = 0.0F;
        h = null;
        d = glsurfaceview;
        h = w;
        d.setEGLContextClientVersion(2);
        e = new x();
        d.setRenderer(e);
        e.a(d);
    }

    static float a(u u1, float f1)
    {
        u1.g = f1;
        return f1;
    }

    static GLSurfaceView a(u u1)
    {
        return u1.d;
    }

    public static v a(List list, int i, int j, float f1)
    {
        v v1 = b(list, 1280, 960, f1);
        if (v1 == null) goto _L2; else goto _L1
_L1:
        return v1;
_L2:
        v v2 = b(list, 1280, 720, f1);
        v1 = v2;
        if (v2 != null)
        {
            continue;
        }
        v2 = b(list, 1024, 768, f1);
        v1 = v2;
        if (v2 != null)
        {
            continue;
        }
        v2 = b(list, 960, 720, f1);
        v1 = v2;
        if (v2 != null)
        {
            continue;
        }
        v2 = b(list, 800, 600, f1);
        v1 = v2;
        if (v2 != null)
        {
            continue;
        }
        v2 = b(list, 640, 480, f1);
        v1 = v2;
        if (v2 != null)
        {
            continue;
        }
        i = 0x7fffffff;
        int l = list.size();
        j = 0;
        do
        {
            v1 = v2;
            if (j >= l)
            {
                continue;
            }
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)list.get(j);
            int k = Math.abs(size.width * size.height - 0x4b000);
            if (k < i)
            {
                v1 = new v();
                v1.a = size;
                i = k;
            } else
            {
                v1 = v2;
            }
            j++;
            v2 = v1;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    static void a(u u1, String s)
    {
        u1.a(s);
    }

    private void a(String s)
    {
label0:
        {
            synchronized (c)
            {
                if (c.a(Globals.d().m(), Globals.d().n()))
                {
                    break label0;
                }
            }
            return;
        }
        s;
        JVM INSTR monitorexit ;
        do
        {
            MutableInteger mutableinteger = new MutableInteger();
            synchronized (c)
            {
                c.a(mutableinteger);
            }
            if (mutableinteger.value != InternalModelState.INTERNAL_MODEL_READY.ordinal() && mutableinteger.value != InternalModelState.INTERNAL_MODEL_LOAD_ERROR.ordinal())
            {
                try
                {
                    Thread.sleep(100L);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
            } else
            {
                return;
            }
        } while (true);
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        s;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    static boolean a(u u1, boolean flag)
    {
        u1.f = flag;
        return flag;
    }

    static float b(u u1)
    {
        return u1.c();
    }

    private static v b(List list, int i, int j, float f1)
    {
        int l = list.size();
        for (int k = 0; k < l; k++)
        {
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)list.get(k);
            if (size.width != i || size.height != j)
            {
                continue;
            }
            float f2 = (921600F * f1) / (float)(i * j);
            if (f2 >= 15F)
            {
                list = new v();
                list.a = size;
                list.b = f2;
                return list;
            }
        }

        return null;
    }

    private float c()
    {
        e.a(1280, 720);
        e.a();
        try
        {
            Thread.sleep(1500L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        return ((float)e.b() / 1.5F) * 0.35F;
    }

    static w c(u u1)
    {
        return u1.h;
    }

    static float d(u u1)
    {
        return u1.g;
    }

    public boolean a()
    {
        return f;
    }

    public void b()
    {
        boolean flag = c.j();
        while (!flag) 
        {
            try
            {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            flag = c.j();
        }
        f = false;
        (new com.cyberlink.youcammakeup.camera.x(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
