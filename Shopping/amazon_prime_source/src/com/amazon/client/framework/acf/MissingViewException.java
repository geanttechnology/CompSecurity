// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.view.View;

// Referenced classes of package com.amazon.client.framework.acf:
//            Components

public class MissingViewException extends RuntimeException
{

    private static final long serialVersionUID = 0x8bf35ec7d43724bcL;
    private final int mMissingResourceId;

    public MissingViewException(int i)
    {
        mMissingResourceId = i;
    }

    public MissingViewException(int i, String s)
    {
        super(s);
        mMissingResourceId = i;
    }

    public MissingViewException(int i, String s, Throwable throwable)
    {
        super(s, throwable);
        mMissingResourceId = i;
    }

    public MissingViewException(int i, Throwable throwable)
    {
        super(throwable);
        mMissingResourceId = i;
    }

    private static Object checkAndCastResult(Object obj, int i, Class class1)
    {
        if (obj == null)
        {
            throw new MissingViewException(i, "Required view was not found for the given view.");
        }
        try
        {
            obj = class1.cast(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new MissingViewException(i, "Required view was not of the expected type.", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new MissingViewException(i, "Required view type class definition was not found.", ((Throwable) (obj)));
        }
        return obj;
    }

    public static Object findFragmentByIdOrThrow(Activity activity, int i, Class class1)
    {
        return checkAndCastResult(activity.getFragmentManager().findFragmentById(i), i, class1);
    }

    public static Object findFragmentByIdOrThrow(Context context, int i, Class class1)
    {
        if (!(context instanceof Activity))
        {
            throw new MissingViewException(i, "Must provide an Activity Context to search for Fragments.");
        } else
        {
            return findFragmentByIdOrThrow((Activity)context, i, class1);
        }
    }

    public static Object findViewByIdOrThrow(Activity activity, int i, Class class1)
    {
        return checkAndCastResult(activity.findViewById(i), i, class1);
    }

    public static Object findViewByIdOrThrow(Dialog dialog, int i, Class class1)
    {
        return checkAndCastResult(dialog.findViewById(i), i, class1);
    }

    public static Object findViewByIdOrThrow(Context context, int i, Class class1)
    {
        return findViewByIdOrThrow((Activity)Components.required(context, android/app/Activity), i, class1);
    }

    public static Object findViewByIdOrThrow(View view, int i, Class class1)
    {
        return checkAndCastResult(view.findViewById(i), i, class1);
    }

    public int getMissingResourceId()
    {
        return mMissingResourceId;
    }
}
