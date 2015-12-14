// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.hardware.Camera;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.o;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class r extends AsyncTask
{

    final SplashActivity a;

    private r(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }

    r(SplashActivity splashactivity, SplashActivity._cls1 _pcls1)
    {
        this(splashactivity);
    }

    private android.hardware.Camera.Parameters a(int i)
    {
        Object obj;
        Object obj3;
        obj3 = null;
        obj = null;
        int j = o.d(i);
        if (o.a(j) != i) goto _L2; else goto _L1
_L1:
        obj = Camera.open(j);
        Object obj1 = obj;
        Object obj2 = ((Camera) (obj)).getParameters();
        obj1 = obj;
        obj = obj2;
_L9:
        obj2 = obj;
        if (obj1 != null)
        {
            ((Camera) (obj1)).release();
            obj2 = obj;
        }
_L4:
        return ((android.hardware.Camera.Parameters) (obj2));
        Exception exception1;
        exception1;
        obj = null;
_L7:
        obj1 = obj;
        m.e("SplashActivity", (new StringBuilder()).append("getCameraParameter() fail. e=").append(exception1.toString()).toString());
        exception1 = obj3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Camera) (obj)).release();
        return null;
        Exception exception;
        exception;
        obj1 = null;
_L6:
        if (obj1 != null)
        {
            ((Camera) (obj1)).release();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
          goto _L7
_L2:
        obj1 = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected transient Void a(Void avoid[])
    {
        m.b("SplashActivity", "do CollectCameraInfoTask");
        avoid = a(1);
        int j;
        if (avoid != null)
        {
            avoid = avoid.getSupportedPictureSizes();
            int i;
            if (avoid != null && avoid.size() > 0)
            {
                Collections.sort(avoid, o.k);
                avoid = (android.hardware.Camera.Size)avoid.get(0);
            } else
            {
                avoid = null;
            }
            if (((android.hardware.Camera.Size) (avoid)).width > ((android.hardware.Camera.Size) (avoid)).height)
            {
                i = ((android.hardware.Camera.Size) (avoid)).width;
            } else
            {
                i = ((android.hardware.Camera.Size) (avoid)).height;
            }
            j = i;
        } else
        {
            j = 0;
        }
        avoid = a(0);
        if (avoid != null)
        {
            avoid = avoid.getSupportedPictureSizes();
            if (avoid != null && avoid.size() > 0)
            {
                Collections.sort(avoid, o.k);
                avoid = (android.hardware.Camera.Size)avoid.get(0);
            } else
            {
                avoid = null;
            }
            if (((android.hardware.Camera.Size) (avoid)).width > ((android.hardware.Camera.Size) (avoid)).height)
            {
                i = ((android.hardware.Camera.Size) (avoid)).width;
            } else
            {
                i = ((android.hardware.Camera.Size) (avoid)).height;
            }
        } else
        {
            i = 0;
        }
        z.a(true);
        if (i <= j)
        {
            i = j;
        }
        z.a("CAMERA_MAX_SIZE", i, Globals.d());
        return null;
    }

    protected void a(Void void1)
    {
        SplashActivity.a(a).e = Boolean.valueOf(true);
        SplashActivity.b(a);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
