// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper
{

    private ViewHelper()
    {
    }

    public static float getAlpha(View view)
    {
    /* block-local class not found */
    class Honeycomb {}

        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getAlpha();
        } else
        {
            return Honeycomb.getAlpha(view);
        }
    }

    public static float getPivotX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getPivotX();
        } else
        {
            return Honeycomb.getPivotX(view);
        }
    }

    public static float getPivotY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getPivotY();
        } else
        {
            return Honeycomb.getPivotY(view);
        }
    }

    public static float getRotation(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotation();
        } else
        {
            return Honeycomb.getRotation(view);
        }
    }

    public static float getRotationX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotationX();
        } else
        {
            return Honeycomb.getRotationX(view);
        }
    }

    public static float getRotationY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotationY();
        } else
        {
            return Honeycomb.getRotationY(view);
        }
    }

    public static float getScaleX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getScaleX();
        } else
        {
            return Honeycomb.getScaleX(view);
        }
    }

    public static float getScaleY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getScaleY();
        } else
        {
            return Honeycomb.getScaleY(view);
        }
    }

    public static float getScrollX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return (float)AnimatorProxy.wrap(view).getScrollX();
        } else
        {
            return Honeycomb.getScrollX(view);
        }
    }

    public static float getScrollY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return (float)AnimatorProxy.wrap(view).getScrollY();
        } else
        {
            return Honeycomb.getScrollY(view);
        }
    }

    public static float getTranslationX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getTranslationX();
        } else
        {
            return Honeycomb.getTranslationX(view);
        }
    }

    public static float getTranslationY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getTranslationY();
        } else
        {
            return Honeycomb.getTranslationY(view);
        }
    }

    public static float getX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getX();
        } else
        {
            return Honeycomb.getX(view);
        }
    }

    public static float getY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getY();
        } else
        {
            return Honeycomb.getY(view);
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

    public static void setRotation(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotation(f);
            return;
        } else
        {
            Honeycomb.setRotation(view, f);
            return;
        }
    }

    public static void setRotationX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotationX(f);
            return;
        } else
        {
            Honeycomb.setRotationX(view, f);
            return;
        }
    }

    public static void setRotationY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotationY(f);
            return;
        } else
        {
            Honeycomb.setRotationY(view, f);
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

    public static void setScrollX(View view, int i)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScrollX(i);
            return;
        } else
        {
            Honeycomb.setScrollX(view, i);
            return;
        }
    }

    public static void setScrollY(View view, int i)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScrollY(i);
            return;
        } else
        {
            Honeycomb.setScrollY(view, i);
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

    public static void setX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setX(f);
            return;
        } else
        {
            Honeycomb.setX(view, f);
            return;
        }
    }

    public static void setY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setY(f);
            return;
        } else
        {
            Honeycomb.setY(view, f);
            return;
        }
    }
}
