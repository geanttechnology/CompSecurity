// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package jumiomobile:
//            v, w

public class ao
{

    private v a;
    private w b;
    private Activity c;
    private int d;
    private int e;
    private boolean f;

    public ao(Activity activity, v v1)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        super();
        c = activity;
        a = v1;
        f = a(activity);
        e = a(activity);
        if (a(v.b))
        {
            v1 = c;
            int i1;
            if (f && l() == 2)
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
            v1.setRequestedOrientation(i1);
        }
        b = b();
        try
        {
            d = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).screenOrientation;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            d = -1;
        }
        if (d != 3 && d != 10) goto _L2; else goto _L1
_L1:
        d = 4;
_L12:
        e();
        return;
_L2:
        if (d == 11)
        {
            d = 6;
            continue; /* Loop/switch isn't completed */
        }
        if (d == 12)
        {
            d = 7;
            continue; /* Loop/switch isn't completed */
        }
        if (d != -1 && d != 2)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        if (android.provider.Settings.System.getInt(c.getContentResolver(), "accelerometer_rotation", 0) != 0) goto _L4; else goto _L3
_L3:
        ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 260
    //                   0 271
    //                   1 294
    //                   2 321
    //                   3 348;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        int j1 = ((flag) ? 1 : 0);
_L10:
        d = j1;
        continue; /* Loop/switch isn't completed */
_L6:
        if (f)
        {
            j1 = ((flag) ? 1 : 0);
            if (e == 2)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j1 = 1;
        continue; /* Loop/switch isn't completed */
_L7:
        j1 = ((flag) ? 1 : 0);
        if (f)
        {
            j1 = ((flag) ? 1 : 0);
            if (e == 2)
            {
                j1 = 9;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (f && e == 2)
        {
            j1 = 8;
        } else
        {
            j1 = 9;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (f && e == 2)
        {
            j1 = ((flag1) ? 1 : 0);
        } else
        {
            j1 = 8;
        }
        if (true) goto _L10; else goto _L4
_L4:
        if (f)
        {
            d = 10;
        } else
        {
            d = 4;
        }
        continue; /* Loop/switch isn't completed */
        if (d == 7)
        {
            d = 1;
        } else
        if (d == 6)
        {
            d = 0;
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    private int a(Activity activity)
    {
        WindowManager windowmanager = (WindowManager)activity.getSystemService("window");
        activity = activity.getResources().getConfiguration();
        int i1 = windowmanager.getDefaultDisplay().getRotation();
        return (i1 != 0 && i1 != 2 || ((Configuration) (activity)).orientation != 2) && (i1 != 1 && i1 != 3 || ((Configuration) (activity)).orientation != 1) ? 1 : 2;
    }

    private static boolean a(Context context)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            if (context.getResources().getConfiguration().smallestScreenWidthDp >= 600)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if ((context.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            if (displaymetrics.densityDpi == 160 || displaymetrics.densityDpi == 240 || displaymetrics.densityDpi == 160 || displaymetrics.densityDpi == 213 || displaymetrics.densityDpi == 320)
            {
                return true;
            }
        }
        return false;
    }

    public int a()
    {
        return ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public boolean a(v v1)
    {
        return a.equals(v1);
    }

    public w b()
    {
        w w1 = w.a;
        switch (((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default:
            return w1;

        case 0: // '\0'
            if (f && e == 2)
            {
                return w.b;
            } else
            {
                return w.a;
            }

        case 1: // '\001'
            if (f && e == 2)
            {
                return w.c;
            } else
            {
                return w.b;
            }

        case 2: // '\002'
            if (f && e == 2)
            {
                return w.d;
            } else
            {
                return w.c;
            }

        case 3: // '\003'
            break;
        }
        if (f && e == 2)
        {
            return w.a;
        } else
        {
            return w.d;
        }
    }

    public boolean c()
    {
        return f;
    }

    public w d()
    {
        return b;
    }

    public void e()
    {
        b = b();
    }

    public boolean f()
    {
        return b == w.a || b == w.c;
    }

    public boolean g()
    {
        return b == w.b || b == w.d;
    }

    public boolean h()
    {
        w w1 = b();
        return w1 == w.a || w1 == w.c;
    }

    public boolean i()
    {
        return b == w.c || b == w.d;
    }

    public void j()
    {
        int i1;
        i1 = 1;
        if (!a(v.a))
        {
            return;
        }
        if (b != w.a) goto _L2; else goto _L1
_L1:
        c.setRequestedOrientation(i1);
        return;
_L2:
        if (b == w.c)
        {
            if (c())
            {
                i1 = 9;
            }
        } else
        if (b == w.b)
        {
            i1 = 0;
        } else
        if (b == w.d)
        {
            i1 = 8;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void k()
    {
        c.setRequestedOrientation(d);
        e();
    }

    public int l()
    {
        return e;
    }

    public boolean m()
    {
        boolean flag1 = false;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < 4)
                {
                    if ((new int[] {
    4, 10, 7, 6
})[i1] != d)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }
}
