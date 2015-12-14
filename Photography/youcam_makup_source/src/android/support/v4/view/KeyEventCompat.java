// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

public class KeyEventCompat
{

    static final KeyEventVersionImpl IMPL;

    public KeyEventCompat()
    {
    }

    public static boolean dispatch(KeyEvent keyevent, android.view.KeyEvent.Callback callback, Object obj, Object obj1)
    {
        return IMPL.dispatch(keyevent, callback, obj, obj1);
    }

    public static Object getKeyDispatcherState(View view)
    {
        return IMPL.getKeyDispatcherState(view);
    }

    public static boolean hasModifiers(KeyEvent keyevent, int i)
    {
        return IMPL.metaStateHasModifiers(keyevent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyevent)
    {
        return IMPL.metaStateHasNoModifiers(keyevent.getMetaState());
    }

    public static boolean isTracking(KeyEvent keyevent)
    {
        return IMPL.isTracking(keyevent);
    }

    public static boolean metaStateHasModifiers(int i, int j)
    {
        return IMPL.metaStateHasModifiers(i, j);
    }

    public static boolean metaStateHasNoModifiers(int i)
    {
        return IMPL.metaStateHasNoModifiers(i);
    }

    public static int normalizeMetaState(int i)
    {
        return IMPL.normalizeMetaState(i);
    }

    public static void startTracking(KeyEvent keyevent)
    {
        IMPL.startTracking(keyevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else
        {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }

    /* member class not found */
    class KeyEventVersionImpl {}


    /* member class not found */
    class HoneycombKeyEventVersionImpl {}


    /* member class not found */
    class BaseKeyEventVersionImpl {}

}
