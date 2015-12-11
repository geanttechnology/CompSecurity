// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package netswipe:
//            al, an

public class cz
{

    private al a;
    private an b;
    private Activity c;
    private int d;
    private int e;
    private boolean f;

    public cz(Activity activity, al al1)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        super();
        c = activity;
        a = al1;
        f = a(activity);
        e = a(activity);
        if (a(al.b))
        {
            al1 = c;
            int k;
            if (f && i() == 2)
            {
                k = 0;
            } else
            {
                k = 1;
            }
            al1.setRequestedOrientation(k);
        }
        b = a();
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
        h();
        return;
_L2:
        if (d != -1 && d != 2)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        if (android.provider.Settings.System.getInt(c.getContentResolver(), "accelerometer_rotation", 0) != 0) goto _L4; else goto _L3
_L3:
        ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 224
    //                   0 235
    //                   1 258
    //                   2 285
    //                   3 312;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        int l = ((flag) ? 1 : 0);
_L10:
        d = l;
        continue; /* Loop/switch isn't completed */
_L6:
        if (f)
        {
            l = ((flag) ? 1 : 0);
            if (e == 2)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        l = 1;
        continue; /* Loop/switch isn't completed */
_L7:
        l = ((flag) ? 1 : 0);
        if (f)
        {
            l = ((flag) ? 1 : 0);
            if (e == 2)
            {
                l = 9;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (f && e == 2)
        {
            l = 8;
        } else
        {
            l = 9;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (f && e == 2)
        {
            l = ((flag1) ? 1 : 0);
        } else
        {
            l = 8;
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
        int k = windowmanager.getDefaultDisplay().getRotation();
        return (k != 0 && k != 2 || ((Configuration) (activity)).orientation != 2) && (k != 1 && k != 3 || ((Configuration) (activity)).orientation != 1) ? 1 : 2;
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

    public an a()
    {
        an an1 = an.a;
        switch (((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default:
            return an1;

        case 0: // '\0'
            if (f && e == 2)
            {
                return an.b;
            } else
            {
                return an.a;
            }

        case 1: // '\001'
            if (f && e == 2)
            {
                return an.c;
            } else
            {
                return an.b;
            }

        case 2: // '\002'
            if (f && e == 2)
            {
                return an.d;
            } else
            {
                return an.c;
            }

        case 3: // '\003'
            break;
        }
        if (f && e == 2)
        {
            return an.a;
        } else
        {
            return an.d;
        }
    }

    public boolean a(al al1)
    {
        return a.equals(al1);
    }

    public boolean a(an an1)
    {
        return b.equals(an1);
    }

    public boolean b()
    {
        return f;
    }

    public an c()
    {
        return b;
    }

    public void d()
    {
        b = a();
    }

    public boolean e()
    {
        return b == an.a || b == an.c;
    }

    public boolean f()
    {
        return b == an.b || b == an.d;
    }

    public boolean g()
    {
        return b == an.c || b == an.d;
    }

    public void h()
    {
        c.setRequestedOrientation(d);
    }

    public int i()
    {
        return e;
    }

    public boolean j()
    {
        boolean flag1 = false;
        int ai[] = new int[4];
        int[] _tmp = ai;
        ai[0] = 4;
        ai[1] = 10;
        ai[2] = 7;
        ai[3] = 6;
        int l = ai.length;
        int k = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (k < l)
                {
                    if (ai[k] != d)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k++;
        } while (true);
    }
}
