// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.acra.ACRA;
import org.acra.log.ACRALog;

// Referenced classes of package org.acra.collector:
//            Compatibility

final class DisplayManagerCollector
{

    static final SparseArray mDensities = new SparseArray();
    static final SparseArray mFlagsNames = new SparseArray();

    DisplayManagerCollector()
    {
    }

    private static String activeFlags(SparseArray sparsearray, int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < sparsearray.size(); j++)
        {
            int k = i & sparsearray.keyAt(j);
            if (k <= 0)
            {
                continue;
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('+');
            }
            stringbuilder.append((String)sparsearray.get(k));
        }

        return stringbuilder.toString();
    }

    private static String collectCurrentSizeRange(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            Method method = display.getClass().getMethod("getCurrentSizeRange", new Class[] {
                android/graphics/Point, android/graphics/Point
            });
            Point point = new Point();
            Point point1 = new Point();
            method.invoke(display, new Object[] {
                point, point1
            });
            stringbuilder.append(display.getDisplayId()).append(".currentSizeRange.smallest=[").append(point.x).append(',').append(point.y).append(']').append('\n');
            stringbuilder.append(display.getDisplayId()).append(".currentSizeRange.largest=[").append(point1.x).append(',').append(point1.y).append(']').append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
    }

    private static Object collectDisplayData(Display display)
    {
        display.getMetrics(new DisplayMetrics());
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(collectCurrentSizeRange(display));
        stringbuilder.append(collectFlags(display));
        stringbuilder.append(display.getDisplayId()).append(".height=").append(display.getHeight()).append('\n');
        stringbuilder.append(collectMetrics(display, "getMetrics"));
        stringbuilder.append(collectName(display));
        stringbuilder.append(display.getDisplayId()).append(".orientation=").append(display.getOrientation()).append('\n');
        stringbuilder.append(display.getDisplayId()).append(".pixelFormat=").append(display.getPixelFormat()).append('\n');
        stringbuilder.append(collectMetrics(display, "getRealMetrics"));
        stringbuilder.append(collectSize(display, "getRealSize"));
        stringbuilder.append(collectRectSize(display));
        stringbuilder.append(display.getDisplayId()).append(".refreshRate=").append(display.getRefreshRate()).append('\n');
        stringbuilder.append(collectRotation(display));
        stringbuilder.append(collectSize(display, "getSize"));
        stringbuilder.append(display.getDisplayId()).append(".width=").append(display.getWidth()).append('\n');
        stringbuilder.append(collectIsValid(display));
        return stringbuilder.toString();
    }

    public static String collectDisplays(Context context)
    {
        WindowManager windowmanager = null;
        StringBuilder stringbuilder = new StringBuilder();
        int j;
        if (Compatibility.getAPILevel() < 17)
        {
            windowmanager = (WindowManager)context.getSystemService("window");
            context = new Display[1];
            context[0] = windowmanager.getDefaultDisplay();
        } else
        {
            try
            {
                context = ((Context) (context.getSystemService((String)(String)context.getClass().getField("DISPLAY_SERVICE").get(null))));
                context = (Display[])(Display[])context.getClass().getMethod("getDisplays", new Class[0]).invoke(context, new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ACRA.log.w(ACRA.LOG_TAG, "Error while collecting DisplayManager data: ", context);
                context = windowmanager;
            }
        }
        j = context.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(collectDisplayData(context[i]));
        }

        return stringbuilder.toString();
    }

    private static String collectFlags(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Field afield[];
        int j;
        int k;
        j = ((Integer)display.getClass().getMethod("getFlags", new Class[0]).invoke(display, new Object[0])).intValue();
        afield = display.getClass().getFields();
        k = afield.length;
        int i = 0;
_L2:
        Field field;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        field = afield[i];
        if (field.getName().startsWith("FLAG_"))
        {
            mFlagsNames.put(field.getInt(null), field.getName());
        }
        break MISSING_BLOCK_LABEL_150;
        try
        {
            stringbuilder.append(display.getDisplayId()).append(".flags=").append(activeFlags(mFlagsNames, j)).append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Object collectIsValid(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            Boolean boolean1 = (Boolean)display.getClass().getMethod("isValid", new Class[0]).invoke(display, new Object[0]);
            stringbuilder.append(display.getDisplayId()).append(".isValid=").append(boolean1).append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
    }

    private static Object collectMetrics(Display display, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        DisplayMetrics displaymetrics;
        Field afield[];
        int j;
        displaymetrics = (DisplayMetrics)display.getClass().getMethod(s, new Class[0]).invoke(display, new Object[0]);
        afield = android/util/DisplayMetrics.getFields();
        j = afield.length;
        int i = 0;
_L2:
        Field field;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        field = afield[i];
        if (field.getType().equals(java/lang/Integer) && field.getName().startsWith("DENSITY_") && !field.getName().equals("DENSITY_DEFAULT"))
        {
            mDensities.put(field.getInt(null), field.getName());
        }
        break MISSING_BLOCK_LABEL_409;
        try
        {
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".density=").append(displaymetrics.density).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".densityDpi=").append(displaymetrics.getClass().getField("densityDpi")).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append("scaledDensity=x").append(displaymetrics.scaledDensity).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".widthPixels=").append(displaymetrics.widthPixels).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".heightPixels=").append(displaymetrics.heightPixels).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".xdpi=").append(displaymetrics.xdpi).append('\n');
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append(".ydpi=").append(displaymetrics.ydpi).append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String collectName(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            String s = (String)display.getClass().getMethod("getName", new Class[0]).invoke(display, new Object[0]);
            stringbuilder.append(display.getDisplayId()).append(".name=").append(s).append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
    }

    private static Object collectRectSize(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            Method method = display.getClass().getMethod("getRectSize", new Class[] {
                android/graphics/Rect
            });
            Rect rect = new Rect();
            method.invoke(display, new Object[] {
                rect
            });
            stringbuilder.append(display.getDisplayId()).append(".rectSize=[").append(rect.top).append(',').append(rect.left).append(',').append(rect.width()).append(',').append(rect.height()).append(']').append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
    }

    private static Object collectRotation(Display display)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i;
        i = ((Integer)display.getClass().getMethod("getRotation", new Class[0]).invoke(display, new Object[0])).intValue();
        stringbuilder.append(display.getDisplayId()).append(".rotation=");
        i;
        JVM INSTR tableswitch 0 3: default 154
    //                   0 102
    //                   1 113
    //                   2 124
    //                   3 135;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        stringbuilder.append(i);
_L6:
        stringbuilder.append('\n');
_L7:
        return stringbuilder.toString();
_L2:
        stringbuilder.append("ROTATION_0");
          goto _L6
_L3:
        stringbuilder.append("ROTATION_90");
          goto _L6
_L4:
        stringbuilder.append("ROTATION_180");
          goto _L6
_L5:
        stringbuilder.append("ROTATION_270");
          goto _L6
        display;
          goto _L7
        display;
          goto _L7
        display;
          goto _L7
        display;
          goto _L7
        display;
          goto _L7
    }

    private static Object collectSize(Display display, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            Method method = display.getClass().getMethod(s, new Class[] {
                android/graphics/Point
            });
            Point point = new Point();
            method.invoke(display, new Object[] {
                point
            });
            stringbuilder.append(display.getDisplayId()).append('.').append(s).append("=[").append(point.x).append(',').append(point.y).append(']').append('\n');
        }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        // Misplaced declaration of an exception variable
        catch (Display display) { }
        return stringbuilder.toString();
    }

}
