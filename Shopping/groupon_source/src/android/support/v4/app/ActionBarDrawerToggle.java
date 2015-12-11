// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v4.app:
//            ActionBarDrawerToggleHoneycomb, ActionBarDrawerToggleJellybeanMR2

public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{
    private static interface ActionBarDrawerToggleImpl
    {

        public abstract Object setActionBarDescription(Object obj, Activity activity, int i);
    }

    private static class ActionBarDrawerToggleImplBase
        implements ActionBarDrawerToggleImpl
    {

        public Object setActionBarDescription(Object obj, Activity activity, int i)
        {
            return obj;
        }

        private ActionBarDrawerToggleImplBase()
        {
        }

    }

    private static class ActionBarDrawerToggleImplHC
        implements ActionBarDrawerToggleImpl
    {

        public Object setActionBarDescription(Object obj, Activity activity, int i)
        {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(obj, activity, i);
        }

        private ActionBarDrawerToggleImplHC()
        {
        }

    }

    private static class ActionBarDrawerToggleImplJellybeanMR2
        implements ActionBarDrawerToggleImpl
    {

        public Object setActionBarDescription(Object obj, Activity activity, int i)
        {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(obj, activity, i);
        }

        private ActionBarDrawerToggleImplJellybeanMR2()
        {
        }

    }

    public static interface Delegate
    {

        public abstract void setActionBarDescription(int i);
    }

    private class SlideDrawable extends InsetDrawable
        implements android.graphics.drawable.Drawable.Callback
    {

        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final ActionBarDrawerToggle this$0;

        public void draw(Canvas canvas)
        {
            int i = 1;
            copyBounds(mTmpRect);
            canvas.save();
            boolean flag;
            int j;
            if (ViewCompat.getLayoutDirection(mActivity.getWindow().getDecorView()) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                i = -1;
            }
            j = mTmpRect.width();
            canvas.translate(-mOffset * (float)j * mPosition * (float)i, 0.0F);
            if (flag && !mHasMirroring)
            {
                canvas.translate(j, 0.0F);
                canvas.scale(-1F, 1.0F);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition()
        {
            return mPosition;
        }

        public void setPosition(float f)
        {
            mPosition = f;
            invalidateSelf();
        }
    }


    private static final ActionBarDrawerToggleImpl IMPL;
    private final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private boolean mDrawerIndicatorEnabled;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;

    public void onDrawerClosed(View view)
    {
        mSlider.setPosition(0.0F);
        if (mDrawerIndicatorEnabled)
        {
            setActionBarDescription(mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view)
    {
        mSlider.setPosition(1.0F);
        if (mDrawerIndicatorEnabled)
        {
            setActionBarDescription(mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f)
    {
        float f1 = mSlider.getPosition();
        if (f > 0.5F)
        {
            f = Math.max(f1, Math.max(0.0F, f - 0.5F) * 2.0F);
        } else
        {
            f = Math.min(f1, f * 2.0F);
        }
        mSlider.setPosition(f);
    }

    public void onDrawerStateChanged(int i)
    {
    }

    void setActionBarDescription(int i)
    {
        if (mActivityImpl != null)
        {
            mActivityImpl.setActionBarDescription(i);
            return;
        } else
        {
            mSetIndicatorInfo = IMPL.setActionBarDescription(mSetIndicatorInfo, mActivity, i);
            return;
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 18)
        {
            IMPL = new ActionBarDrawerToggleImplJellybeanMR2();
        } else
        if (i >= 11)
        {
            IMPL = new ActionBarDrawerToggleImplHC();
        } else
        {
            IMPL = new ActionBarDrawerToggleImplBase();
        }
    }

}
