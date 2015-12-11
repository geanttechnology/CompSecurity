// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            ViewPropertyAnimatorListener, ViewPropertyAnimatorUpdateListener

public class ViewPropertyAnimatorCompat
{

    static final ViewPropertyAnimatorCompatImpl IMPL;
    static final int LISTENER_TAG_ID = 0x7e000000;
    private static final String TAG = "ViewAnimatorCompat";
    private Runnable mEndAction;
    private int mOldLayerType;
    private Runnable mStartAction;
    private WeakReference mView;

    ViewPropertyAnimatorCompat(View view)
    {
        mStartAction = null;
        mEndAction = null;
        mOldLayerType = -1;
        mView = new WeakReference(view);
    }

    public ViewPropertyAnimatorCompat alpha(float f)
    {
        View view = (View)mView.get();
    /* block-local class not found */
    class ViewPropertyAnimatorCompatImpl {}

        if (view != null)
        {
            IMPL.alpha(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.alphaBy(this, view, f);
        }
        return this;
    }

    public void cancel()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.cancel(this, view);
        }
    }

    public long getDuration()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            return IMPL.getDuration(this, view);
        } else
        {
            return 0L;
        }
    }

    public Interpolator getInterpolator()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            return IMPL.getInterpolator(this, view);
        } else
        {
            return null;
        }
    }

    public long getStartDelay()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            return IMPL.getStartDelay(this, view);
        } else
        {
            return 0L;
        }
    }

    public ViewPropertyAnimatorCompat rotation(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotation(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotationBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.rotationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.scaleX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.scaleXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.scaleY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.scaleYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long l)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.setDuration(this, view, l);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewpropertyanimatorlistener)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.setListener(this, view, viewpropertyanimatorlistener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long l)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.setStartDelay(this, view, l);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewpropertyanimatorupdatelistener)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.setUpdateListener(this, view, viewpropertyanimatorupdatelistener);
        }
        return this;
    }

    public void start()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.start(this, view);
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationZ(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.translationZBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.x(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.xBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.y(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.yBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.z(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            IMPL.zBy(this, view, f);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
    /* block-local class not found */
    class BaseViewPropertyAnimatorCompatImpl {}

    /* block-local class not found */
    class ICSViewPropertyAnimatorCompatImpl {}

    /* block-local class not found */
    class JBMr2ViewPropertyAnimatorCompatImpl {}

    /* block-local class not found */
    class JBViewPropertyAnimatorCompatImpl {}

    /* block-local class not found */
    class KitKatViewPropertyAnimatorCompatImpl {}

    /* block-local class not found */
    class LollipopViewPropertyAnimatorCompatImpl {}

        if (i >= 21)
        {
            IMPL = new LollipopViewPropertyAnimatorCompatImpl();
        } else
        if (i >= 19)
        {
            IMPL = new KitKatViewPropertyAnimatorCompatImpl();
        } else
        if (i >= 18)
        {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else
        if (i >= 16)
        {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else
        if (i >= 14)
        {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else
        {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }



/*
    static Runnable access$002(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, Runnable runnable)
    {
        viewpropertyanimatorcompat.mEndAction = runnable;
        return runnable;
    }

*/



/*
    static Runnable access$102(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, Runnable runnable)
    {
        viewpropertyanimatorcompat.mStartAction = runnable;
        return runnable;
    }

*/



/*
    static int access$402(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, int i)
    {
        viewpropertyanimatorcompat.mOldLayerType = i;
        return i;
    }

*/
}
