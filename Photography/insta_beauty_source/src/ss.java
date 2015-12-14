// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.view.Display;
import android.view.WindowManager;

public class ss
{

    private final st a;

    public ss(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new sw();
            return;
        } else
        {
            a = new sv(context);
            return;
        }
    }

    public int a()
    {
        return a.c(1);
    }

    public int a(Activity activity, int i)
    {
        int j;
        boolean flag;
        flag = false;
        j = ((flag) ? 1 : 0);
        activity.getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 48
    //                   0 51
    //                   1 84
    //                   2 90
    //                   3 97;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_97;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        j = ((flag) ? 1 : 0);
_L6:
        activity = new su();
        a(i, ((su) (activity)));
        if (((su) (activity)).a == 1)
        {
            return (j + ((su) (activity)).b) % 360;
        } else
        {
            return ((((su) (activity)).b - j) + 360) % 360;
        }
_L3:
        j = 90;
          goto _L6
_L4:
        j = 180;
          goto _L6
        j = 270;
          goto _L6
    }

    public Camera a(int i)
    {
        return a.a(i);
    }

    public void a(int i, su su1)
    {
        a.a(i, su1);
    }

    public int b()
    {
        return a.d(0);
    }

    public int c()
    {
        return a.a();
    }

    public boolean d()
    {
        return a.b(1);
    }

    public boolean e()
    {
        return a.b(0);
    }
}
