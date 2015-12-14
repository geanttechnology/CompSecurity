// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper
{
    private static final class Honeycomb
    {

        static float getAlpha(View view)
        {
            return view.getAlpha();
        }

        static void setAlpha(View view, float f)
        {
            view.setAlpha(f);
        }

        static void setPivotX(View view, float f)
        {
            view.setPivotX(f);
        }

        static void setPivotY(View view, float f)
        {
            view.setPivotY(f);
        }

        static void setScaleX(View view, float f)
        {
            view.setScaleX(f);
        }

        static void setScaleY(View view, float f)
        {
            view.setScaleY(f);
        }

        static void setTranslationX(View view, float f)
        {
            view.setTranslationX(f);
        }

        static void setTranslationY(View view, float f)
        {
            view.setTranslationY(f);
        }
    }


    public static float getAlpha(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getAlpha();
        } else
        {
            return Honeycomb.getAlpha(view);
        }
    }

    public static void setAlpha(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setAlpha(f);
            return;
        } else
        {
            Honeycomb.setAlpha(view, f);
            return;
        }
    }

    public static void setPivotX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setPivotX(f);
            return;
        } else
        {
            Honeycomb.setPivotX(view, f);
            return;
        }
    }

    public static void setPivotY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setPivotY(f);
            return;
        } else
        {
            Honeycomb.setPivotY(view, f);
            return;
        }
    }

    public static void setScaleX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScaleX(f);
            return;
        } else
        {
            Honeycomb.setScaleX(view, f);
            return;
        }
    }

    public static void setScaleY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScaleY(f);
            return;
        } else
        {
            Honeycomb.setScaleY(view, f);
            return;
        }
    }

    public static void setTranslationX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setTranslationX(f);
            return;
        } else
        {
            Honeycomb.setTranslationX(view, f);
            return;
        }
    }

    public static void setTranslationY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setTranslationY(f);
            return;
        } else
        {
            Honeycomb.setTranslationY(view, f);
            return;
        }
    }
}
