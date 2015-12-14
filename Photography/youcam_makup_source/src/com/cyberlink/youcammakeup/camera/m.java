// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            o, n, FocusAreaView, ah

public class m
    implements android.hardware.Camera.AutoFocusCallback
{

    private Camera a;
    private List b;
    private Rect c;
    private Rect d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private ah k;
    private FocusAreaView l;
    private float m;
    private n n;

    public m(Context context, ah ah1, FocusAreaView focusareaview)
    {
        b = new ArrayList();
        c = new Rect();
        d = new Rect();
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        k = ah1;
        l = focusareaview;
        m = context.getResources().getDimensionPixelSize(0x7f0802b5);
        b.add(new android.hardware.Camera.Area(d, 1000));
    }

    private int a(int i1, int j1, int k1)
    {
        if (k1 > j1)
        {
            return j1;
        }
        if (k1 < i1)
        {
            return i1;
        } else
        {
            return k1;
        }
    }

    private void a(int i1, int j1)
    {
        Object obj;
        try
        {
            obj = a.getParameters();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.pf.common.utility.m.b("CameraTouchFocusListener", "", ((Throwable) (obj)));
            CameraActivity.b(false);
            return;
        }
        if (((android.hardware.Camera.Parameters) (obj)).getMaxNumFocusAreas() == 0)
        {
            CameraActivity.b(false);
        } else
        {
            d.set((c.left * 2000) / i1 - 1000, (c.top * 2000) / j1 - 1000, (c.right * 2000) / i1 - 1000, (c.bottom * 2000) / j1 - 1000);
            ((android.hardware.Camera.Parameters) (obj)).setFocusAreas(b);
            o.a(a, ((android.hardware.Camera.Parameters) (obj)));
            if (e && f && !i)
            {
                if (n != null)
                {
                    n.c();
                    return;
                }
            } else
            {
                l.c();
                try
                {
                    a.autoFocus(this);
                    return;
                }
                catch (Exception exception)
                {
                    onAutoFocus(false, a);
                }
                return;
            }
        }
    }

    public void a(Camera camera)
    {
        a = camera;
        if (camera != null)
        {
            h = o.a(camera);
            return;
        } else
        {
            h = false;
            return;
        }
    }

    protected void a(View view, float f1, float f2, boolean flag)
    {
        if (!g)
        {
            CameraActivity.b(false);
            return;
        }
        i = flag;
        int j1 = view.getWidth();
        int i1 = view.getHeight();
        l.a(f1, f2);
        int k1;
        if (j == 90)
        {
            float f4 = view.getWidth() - 1;
            float f3 = f2;
            f2 = f4 - f1;
            f1 = f3;
            k1 = i1;
            i1 = j1;
        } else
        if (j == 180)
        {
            f1 = (float)(view.getWidth() - 1) - f1;
            f2 = (float)(view.getHeight() - 1) - f2;
            k1 = j1;
        } else
        {
            k1 = j1;
        }
        c.set(a(0, k1 - 1, (int)(f1 - m)), a(0, i1 - 1, (int)(f2 - m)), a(0, k1 - 1, (int)(m + f1)), a(0, i1 - 1, (int)(m + f2)));
        a(k1, i1);
    }

    public void a(n n1)
    {
        n = n1;
    }

    public void a(boolean flag)
    {
        g = flag;
    }

    public boolean a(View view, MotionEvent motionevent)
    {
        if (motionevent.getActionMasked() != 0 || !CameraActivity.a(false, true)) goto _L2; else goto _L1
_L1:
        if (!h || !g) goto _L4; else goto _L3
_L3:
        a(view, motionevent.getX(), motionevent.getY(), false);
_L2:
        return true;
_L4:
        if (!e)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (!f)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n == null) goto _L2; else goto _L5
_L5:
        n.b();
        return true;
        if (n == null) goto _L2; else goto _L6
_L6:
        n.a();
        return true;
        CameraActivity.b(false);
        return true;
    }

    public void b(boolean flag)
    {
        e = flag;
    }

    public void c(boolean flag)
    {
        f = flag;
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        com.pf.common.utility.m.e("onAutoFocus", String.valueOf(flag));
        l.a(flag);
        if (e && !i)
        {
            if (n != null)
            {
                n.a();
            }
            return;
        } else
        {
            k.a(1);
            CameraActivity.b(false);
            return;
        }
    }
}
