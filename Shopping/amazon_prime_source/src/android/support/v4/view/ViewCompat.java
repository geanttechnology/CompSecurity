// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            AccessibilityDelegateCompat, ScrollingView, NestedScrollingChild, ViewCompatEclairMr1, 
//            ViewCompatGingerbread, ViewCompatHC, ViewCompatICS, ViewCompatJB, 
//            ViewCompatJellybeanMr1, ViewCompatLollipop

public class ViewCompat
{
    static class BaseViewCompatImpl
        implements ViewCompatImpl
    {

        WeakHashMap mViewPropertyAnimatorCompatMap;

        private boolean canScrollingViewScrollHorizontally(ScrollingView scrollingview, int i)
        {
            int j;
            int k;
            boolean flag;
            flag = true;
            j = scrollingview.computeHorizontalScrollOffset();
            k = scrollingview.computeHorizontalScrollRange() - scrollingview.computeHorizontalScrollExtent();
            if (k != 0) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if (i >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j > 0) goto _L4; else goto _L3
_L3:
            return false;
            if (j < k - 1) goto _L4; else goto _L5
_L5:
            return false;
        }

        private boolean canScrollingViewScrollVertically(ScrollingView scrollingview, int i)
        {
            int j;
            int k;
            boolean flag;
            flag = true;
            j = scrollingview.computeVerticalScrollOffset();
            k = scrollingview.computeVerticalScrollRange() - scrollingview.computeVerticalScrollExtent();
            if (k != 0) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if (i >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j > 0) goto _L4; else goto _L3
_L3:
            return false;
            if (j < k - 1) goto _L4; else goto _L5
_L5:
            return false;
        }

        public boolean canScrollHorizontally(View view, int i)
        {
            return (view instanceof ScrollingView) && canScrollingViewScrollHorizontally((ScrollingView)view, i);
        }

        public boolean canScrollVertically(View view, int i)
        {
            return (view instanceof ScrollingView) && canScrollingViewScrollVertically((ScrollingView)view, i);
        }

        public float getElevation(View view)
        {
            return 0.0F;
        }

        public boolean getFitsSystemWindows(View view)
        {
            return false;
        }

        long getFrameTime()
        {
            return 10L;
        }

        public int getImportantForAccessibility(View view)
        {
            return 0;
        }

        public int getLayerType(View view)
        {
            return 0;
        }

        public int getLayoutDirection(View view)
        {
            return 0;
        }

        public int getOverScrollMode(View view)
        {
            return 2;
        }

        public ViewParent getParentForAccessibility(View view)
        {
            return view.getParent();
        }

        public float getScaleX(View view)
        {
            return 0.0F;
        }

        public boolean hasOverlappingRendering(View view)
        {
            return true;
        }

        public boolean isNestedScrollingEnabled(View view)
        {
            if (view instanceof NestedScrollingChild)
            {
                return ((NestedScrollingChild)view).isNestedScrollingEnabled();
            } else
            {
                return false;
            }
        }

        public boolean isOpaque(View view)
        {
            boolean flag1 = false;
            view = view.getBackground();
            boolean flag = flag1;
            if (view != null)
            {
                flag = flag1;
                if (view.getOpacity() == -1)
                {
                    flag = true;
                }
            }
            return flag;
        }

        public void postInvalidateOnAnimation(View view)
        {
            view.invalidate();
        }

        public void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
        {
            view.invalidate(i, j, k, l);
        }

        public void postOnAnimation(View view, Runnable runnable)
        {
            view.postDelayed(runnable, getFrameTime());
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
        {
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup viewgroup, boolean flag)
        {
        }

        public void setElevation(View view, float f)
        {
        }

        public void setImportantForAccessibility(View view, int i)
        {
        }

        public void setLayerPaint(View view, Paint paint)
        {
        }

        public void setLayerType(View view, int i, Paint paint)
        {
        }

        public void setSaveFromParentEnabled(View view, boolean flag)
        {
        }

        public void setScaleX(View view, float f)
        {
        }

        public void setScaleY(View view, float f)
        {
        }

        public void stopNestedScroll(View view)
        {
            if (view instanceof NestedScrollingChild)
            {
                ((NestedScrollingChild)view).stopNestedScroll();
            }
        }

        BaseViewCompatImpl()
        {
            mViewPropertyAnimatorCompatMap = null;
        }
    }

    static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl
    {

        public boolean isOpaque(View view)
        {
            return ViewCompatEclairMr1.isOpaque(view);
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup viewgroup, boolean flag)
        {
            ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewgroup, flag);
        }

        EclairMr1ViewCompatImpl()
        {
        }
    }

    static class GBViewCompatImpl extends EclairMr1ViewCompatImpl
    {

        public int getOverScrollMode(View view)
        {
            return ViewCompatGingerbread.getOverScrollMode(view);
        }

        GBViewCompatImpl()
        {
        }
    }

    static class HCViewCompatImpl extends GBViewCompatImpl
    {

        long getFrameTime()
        {
            return ViewCompatHC.getFrameTime();
        }

        public int getLayerType(View view)
        {
            return ViewCompatHC.getLayerType(view);
        }

        public float getScaleX(View view)
        {
            return ViewCompatHC.getScaleX(view);
        }

        public void setLayerPaint(View view, Paint paint)
        {
            setLayerType(view, getLayerType(view), paint);
            view.invalidate();
        }

        public void setLayerType(View view, int i, Paint paint)
        {
            ViewCompatHC.setLayerType(view, i, paint);
        }

        public void setSaveFromParentEnabled(View view, boolean flag)
        {
            ViewCompatHC.setSaveFromParentEnabled(view, flag);
        }

        public void setScaleX(View view, float f)
        {
            ViewCompatHC.setScaleX(view, f);
        }

        public void setScaleY(View view, float f)
        {
            ViewCompatHC.setScaleY(view, f);
        }

        HCViewCompatImpl()
        {
        }
    }

    static class ICSViewCompatImpl extends HCViewCompatImpl
    {

        static boolean accessibilityDelegateCheckFailed = false;

        public boolean canScrollHorizontally(View view, int i)
        {
            return ViewCompatICS.canScrollHorizontally(view, i);
        }

        public boolean canScrollVertically(View view, int i)
        {
            return ViewCompatICS.canScrollVertically(view, i);
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
        {
            if (accessibilitydelegatecompat == null)
            {
                accessibilitydelegatecompat = null;
            } else
            {
                accessibilitydelegatecompat = ((AccessibilityDelegateCompat) (accessibilitydelegatecompat.getBridge()));
            }
            ViewCompatICS.setAccessibilityDelegate(view, accessibilitydelegatecompat);
        }


        ICSViewCompatImpl()
        {
        }
    }

    static class JBViewCompatImpl extends ICSViewCompatImpl
    {

        public boolean getFitsSystemWindows(View view)
        {
            return ViewCompatJB.getFitsSystemWindows(view);
        }

        public int getImportantForAccessibility(View view)
        {
            return ViewCompatJB.getImportantForAccessibility(view);
        }

        public ViewParent getParentForAccessibility(View view)
        {
            return ViewCompatJB.getParentForAccessibility(view);
        }

        public boolean hasOverlappingRendering(View view)
        {
            return ViewCompatJB.hasOverlappingRendering(view);
        }

        public void postInvalidateOnAnimation(View view)
        {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }

        public void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
        {
            ViewCompatJB.postInvalidateOnAnimation(view, i, j, k, l);
        }

        public void postOnAnimation(View view, Runnable runnable)
        {
            ViewCompatJB.postOnAnimation(view, runnable);
        }

        public void setImportantForAccessibility(View view, int i)
        {
            int j = i;
            if (i == 4)
            {
                j = 2;
            }
            ViewCompatJB.setImportantForAccessibility(view, j);
        }

        JBViewCompatImpl()
        {
        }
    }

    static class JbMr1ViewCompatImpl extends JBViewCompatImpl
    {

        public int getLayoutDirection(View view)
        {
            return ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        public void setLayerPaint(View view, Paint paint)
        {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        JbMr1ViewCompatImpl()
        {
        }
    }

    static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl
    {

        JbMr2ViewCompatImpl()
        {
        }
    }

    static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl
    {

        public void setImportantForAccessibility(View view, int i)
        {
            ViewCompatJB.setImportantForAccessibility(view, i);
        }

        KitKatViewCompatImpl()
        {
        }
    }

    static class LollipopViewCompatImpl extends KitKatViewCompatImpl
    {

        public float getElevation(View view)
        {
            return ViewCompatLollipop.getElevation(view);
        }

        public boolean isNestedScrollingEnabled(View view)
        {
            return ViewCompatLollipop.isNestedScrollingEnabled(view);
        }

        public void setElevation(View view, float f)
        {
            ViewCompatLollipop.setElevation(view, f);
        }

        public void stopNestedScroll(View view)
        {
            ViewCompatLollipop.stopNestedScroll(view);
        }

        LollipopViewCompatImpl()
        {
        }
    }

    static interface ViewCompatImpl
    {

        public abstract boolean canScrollHorizontally(View view, int i);

        public abstract boolean canScrollVertically(View view, int i);

        public abstract float getElevation(View view);

        public abstract boolean getFitsSystemWindows(View view);

        public abstract int getImportantForAccessibility(View view);

        public abstract int getLayerType(View view);

        public abstract int getLayoutDirection(View view);

        public abstract int getOverScrollMode(View view);

        public abstract ViewParent getParentForAccessibility(View view);

        public abstract float getScaleX(View view);

        public abstract boolean hasOverlappingRendering(View view);

        public abstract boolean isNestedScrollingEnabled(View view);

        public abstract boolean isOpaque(View view);

        public abstract void postInvalidateOnAnimation(View view);

        public abstract void postInvalidateOnAnimation(View view, int i, int j, int k, int l);

        public abstract void postOnAnimation(View view, Runnable runnable);

        public abstract void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat);

        public abstract void setChildrenDrawingOrderEnabled(ViewGroup viewgroup, boolean flag);

        public abstract void setElevation(View view, float f);

        public abstract void setImportantForAccessibility(View view, int i);

        public abstract void setLayerPaint(View view, Paint paint);

        public abstract void setLayerType(View view, int i, Paint paint);

        public abstract void setSaveFromParentEnabled(View view, boolean flag);

        public abstract void setScaleX(View view, float f);

        public abstract void setScaleY(View view, float f);

        public abstract void stopNestedScroll(View view);
    }


    static final ViewCompatImpl IMPL;

    public ViewCompat()
    {
    }

    public static boolean canScrollHorizontally(View view, int i)
    {
        return IMPL.canScrollHorizontally(view, i);
    }

    public static boolean canScrollVertically(View view, int i)
    {
        return IMPL.canScrollVertically(view, i);
    }

    public static float getElevation(View view)
    {
        return IMPL.getElevation(view);
    }

    public static boolean getFitsSystemWindows(View view)
    {
        return IMPL.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(View view)
    {
        return IMPL.getImportantForAccessibility(view);
    }

    public static int getLayerType(View view)
    {
        return IMPL.getLayerType(view);
    }

    public static int getLayoutDirection(View view)
    {
        return IMPL.getLayoutDirection(view);
    }

    public static int getOverScrollMode(View view)
    {
        return IMPL.getOverScrollMode(view);
    }

    public static ViewParent getParentForAccessibility(View view)
    {
        return IMPL.getParentForAccessibility(view);
    }

    public static float getScaleX(View view)
    {
        return IMPL.getScaleX(view);
    }

    public static boolean hasOverlappingRendering(View view)
    {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean isNestedScrollingEnabled(View view)
    {
        return IMPL.isNestedScrollingEnabled(view);
    }

    public static boolean isOpaque(View view)
    {
        return IMPL.isOpaque(view);
    }

    public static void postInvalidateOnAnimation(View view)
    {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
    {
        IMPL.postInvalidateOnAnimation(view, i, j, k, l);
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        IMPL.setAccessibilityDelegate(view, accessibilitydelegatecompat);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewgroup, boolean flag)
    {
        IMPL.setChildrenDrawingOrderEnabled(viewgroup, flag);
    }

    public static void setElevation(View view, float f)
    {
        IMPL.setElevation(view, f);
    }

    public static void setImportantForAccessibility(View view, int i)
    {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static void setLayerPaint(View view, Paint paint)
    {
        IMPL.setLayerPaint(view, paint);
    }

    public static void setLayerType(View view, int i, Paint paint)
    {
        IMPL.setLayerType(view, i, paint);
    }

    public static void setSaveFromParentEnabled(View view, boolean flag)
    {
        IMPL.setSaveFromParentEnabled(view, flag);
    }

    public static void setScaleX(View view, float f)
    {
        IMPL.setScaleX(view, f);
    }

    public static void setScaleY(View view, float f)
    {
        IMPL.setScaleY(view, f);
    }

    public static void stopNestedScroll(View view)
    {
        IMPL.stopNestedScroll(view);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            IMPL = new LollipopViewCompatImpl();
        } else
        if (i >= 19)
        {
            IMPL = new KitKatViewCompatImpl();
        } else
        if (i >= 17)
        {
            IMPL = new JbMr1ViewCompatImpl();
        } else
        if (i >= 16)
        {
            IMPL = new JBViewCompatImpl();
        } else
        if (i >= 14)
        {
            IMPL = new ICSViewCompatImpl();
        } else
        if (i >= 11)
        {
            IMPL = new HCViewCompatImpl();
        } else
        if (i >= 9)
        {
            IMPL = new GBViewCompatImpl();
        } else
        if (i >= 7)
        {
            IMPL = new EclairMr1ViewCompatImpl();
        } else
        {
            IMPL = new BaseViewCompatImpl();
        }
    }
}
