// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.apprupt.sdk:
//            Logger

public class CvViewHelper
{

    private static float displayMultiplier = 1.0F;
    static final Point displaySize = new Point();
    static final Point dpDisplaySize = new Point();
    static boolean initialized = false;
    private static Handler mHandler = null;

    public CvViewHelper()
    {
    }

    public static int dp2px(float f)
    {
        if (!initialized)
        {
            throw new InternalError("CvSDK has not been initialized! Call CvSDK.initialize(Content context) first.");
        } else
        {
            return (int)(displayMultiplier * f);
        }
    }

    static void init(Context context)
    {
        displayMultiplier = (float)context.getApplicationContext().getResources().getDisplayMetrics().densityDpi / 160F;
        setupDisplaySize(context);
        mHandler = new Handler(context.getMainLooper());
        initialized = true;
    }

    static boolean isHardwareAccelerated(View view)
    {
        boolean flag2 = false;
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        boolean flag4;
        flag4 = view.isHardwareAccelerated();
        flag1 = false;
        flag2 = flag4;
        flag = flag1;
        if (!flag4) goto _L4; else goto _L3
_L3:
        if (view.getLayerType() != 1) goto _L6; else goto _L5
_L5:
        flag = true;
        flag2 = false;
_L4:
        view = Logger.get("HW");
        boolean flag3;
        if (!flag)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        view.e(new Object[] {
            "HW Acceleration:", Boolean.valueOf(flag4), Boolean.valueOf(flag3)
        });
_L2:
        return flag2;
_L6:
        view = view.getParent();
_L7:
        flag2 = flag4;
        flag = flag1;
        if (view != null)
        {
label0:
            {
                if (!(view instanceof View) || ((View)view).getLayerType() != 1)
                {
                    break label0;
                }
                flag2 = false;
                flag = true;
            }
        }
          goto _L4
        view = view.getParent();
          goto _L7
    }

    public static int parseColor(String s)
    {
        Logger.log log = Logger.get("COLOR");
        if (!s.matches("^#?[0-9a-fA-F]{3,8}$")) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj1 = s;
        obj = obj1;
        if (((String) (obj1)).charAt(0) == '#')
        {
            obj = ((String) (obj1)).substring(1);
        }
        if (((String) (obj)).length() == 3)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj1 = obj;
        if (((String) (obj)).length() != 4)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj1 = new StringBuilder();
        int i = 0;
_L4:
        if (i >= 3)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj1)).append(((String) (obj)).charAt(i));
        ((StringBuilder) (obj1)).append(((String) (obj)).charAt(i));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        obj1 = ((StringBuilder) (obj1)).toString();
        if (((String) (obj1)).length() != 6) goto _L6; else goto _L5
_L5:
        obj = (new StringBuilder()).append("ff").append(((String) (obj1))).toString();
_L9:
        if (((String) (obj)).length() != 8)
        {
            log.e(new Object[] {
                "cannot transform color to understandable version", s, obj
            });
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid color string ").append(s).toString());
        }
          goto _L7
        obj;
        log.e(((Throwable) (obj)), new Object[] {
            "error while parsing color"
        });
        Logger.get().e(new Object[] {
            (new StringBuilder()).append("Cannot parse color: ").append(s).toString()
        });
_L10:
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid color value: ").append(s).toString());
_L6:
        obj = obj1;
        if (((String) (obj1)).length() != 8) goto _L9; else goto _L8
_L8:
        obj = (new StringBuilder()).append(((String) (obj1)).substring(6)).append(((String) (obj1)).substring(0, 6)).toString();
          goto _L9
_L7:
        log.e(new Object[] {
            "parsing color as hex", s, (new StringBuilder()).append("#").append(((String) (obj))).toString(), Integer.valueOf(Color.parseColor((new StringBuilder()).append("#").append(((String) (obj))).toString()))
        });
        return Color.parseColor((new StringBuilder()).append("#").append(((String) (obj))).toString());
_L2:
        int j;
        int k;
        int l;
        obj = Pattern.compile("rgba?\\((\\d+),(\\d+),(\\d+)(,([0-9\\.]+))?\\)", 2).matcher(s);
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_690;
        }
        log.e(new Object[] {
            "parsing color as rgba", s
        });
        j = Math.max(Math.min(Integer.valueOf(((Matcher) (obj)).group(1)).intValue(), 255), 0);
        k = Math.max(Math.min(Integer.valueOf(((Matcher) (obj)).group(2)).intValue(), 255), 0);
        l = Math.max(Math.min(Integer.valueOf(((Matcher) (obj)).group(3)).intValue(), 255), 0);
        char c;
        c = '\377';
        i = c;
        if (((Matcher) (obj)).groupCount() <= 4)
        {
            break MISSING_BLOCK_LABEL_608;
        }
        obj1 = ((Matcher) (obj)).group(5);
        i = c;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_608;
        }
        i = c;
        if (((String) (obj1)).length() > 0)
        {
            log.e(new Object[] {
                "alpha found...", ((Matcher) (obj)).group(5)
            });
            i = Math.max(Math.min(Math.round(Float.valueOf(((Matcher) (obj)).group(5)).floatValue() * 255F), 255), 0);
        }
        log.e(new Object[] {
            "parsing color as rgba", s, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i), Integer.valueOf(Color.argb(i, j, k, l))
        });
        return Color.argb(i, j, k, l);
        log.e(new Object[] {
            "color pattern not found", s
        });
          goto _L10
    }

    public static float px2dp(float f)
    {
        if (!initialized)
        {
            throw new InternalError("CvSDK has not been initialized! Call CvSDK.initialize(Content context) first.");
        } else
        {
            return f / displayMultiplier;
        }
    }

    static void runOnUIThread(Runnable runnable)
    {
        runOnUIThread(runnable, true);
    }

    static void runOnUIThread(Runnable runnable, boolean flag)
    {
        if (!flag || Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            mHandler.post(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            view.setBackgroundDrawable(drawable);
            return;
        } else
        {
            view.setBackground(drawable);
            return;
        }
    }

    static void setupDisplaySize(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            displaySize.x = context.getWidth();
            displaySize.y = context.getHeight();
        } else
        {
            context.getSize(displaySize);
        }
        dpDisplaySize.x = (int)((float)displaySize.x / displayMultiplier);
        dpDisplaySize.y = (int)((float)displaySize.y / displayMultiplier);
    }

}
