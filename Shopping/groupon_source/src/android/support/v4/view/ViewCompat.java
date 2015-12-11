// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ViewPropertyAnimatorCompat, AccessibilityDelegateCompat, OnApplyWindowInsetsListener, ViewCompatApi21, 
//            ViewCompatJB, ViewCompatJellybeanMr1, ViewCompatICS, ViewCompatHC, 
//            ViewCompatGingerbread, ViewCompatEclairMr1

public class ViewCompat
{
    static class Api21ViewCompatImpl extends KitKatViewCompatImpl
    {

        public void requestApplyInsets(View view)
        {
            ViewCompatApi21.requestApplyInsets(view);
        }

        public void setElevation(View view, float f)
        {
            ViewCompatApi21.setElevation(view, f);
        }

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onapplywindowinsetslistener)
        {
            ViewCompatApi21.setOnApplyWindowInsetsListener(view, onapplywindowinsetslistener);
        }

        Api21ViewCompatImpl()
        {
        }
    }

    static class BaseViewCompatImpl
        implements ViewCompatImpl
    {

        WeakHashMap mViewPropertyAnimatorCompatMap;

        public ViewPropertyAnimatorCompat animate(View view)
        {
            return new ViewPropertyAnimatorCompat(view);
        }

        public boolean canScrollHorizontally(View view, int i)
        {
            return false;
        }

        public boolean canScrollVertically(View view, int i)
        {
            return false;
        }

        public float getAlpha(View view)
        {
            return 1.0F;
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

        public int getMeasuredState(View view)
        {
            return 0;
        }

        public int getMinimumHeight(View view)
        {
            return 0;
        }

        public int getMinimumWidth(View view)
        {
            return 0;
        }

        public int getOverScrollMode(View view)
        {
            return 2;
        }

        public int getPaddingEnd(View view)
        {
            return view.getPaddingRight();
        }

        public int getPaddingStart(View view)
        {
            return view.getPaddingLeft();
        }

        public ViewParent getParentForAccessibility(View view)
        {
            return view.getParent();
        }

        public float getScaleX(View view)
        {
            return 0.0F;
        }

        public float getTranslationX(View view)
        {
            return 0.0F;
        }

        public float getTranslationY(View view)
        {
            return 0.0F;
        }

        public int getWindowSystemUiVisibility(View view)
        {
            return 0;
        }

        public boolean hasAccessibilityDelegate(View view)
        {
            return false;
        }

        public boolean hasTransientState(View view)
        {
            return false;
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

        public void jumpDrawablesToCurrentState(View view)
        {
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

        public void postOnAnimationDelayed(View view, Runnable runnable, long l)
        {
            view.postDelayed(runnable, getFrameTime() + l);
        }

        public void requestApplyInsets(View view)
        {
        }

        public int resolveSizeAndState(int i, int j, int k)
        {
            return View.resolveSize(i, j);
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
        {
        }

        public void setAlpha(View view, float f)
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

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onapplywindowinsetslistener)
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

        public void setTranslationX(View view, float f)
        {
        }

        public void setTranslationY(View view, float f)
        {
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

        public float getAlpha(View view)
        {
            return ViewCompatHC.getAlpha(view);
        }

        long getFrameTime()
        {
            return ViewCompatHC.getFrameTime();
        }

        public int getLayerType(View view)
        {
            return ViewCompatHC.getLayerType(view);
        }

        public int getMeasuredState(View view)
        {
            return ViewCompatHC.getMeasuredState(view);
        }

        public float getScaleX(View view)
        {
            return ViewCompatHC.getScaleX(view);
        }

        public float getTranslationX(View view)
        {
            return ViewCompatHC.getTranslationX(view);
        }

        public float getTranslationY(View view)
        {
            return ViewCompatHC.getTranslationY(view);
        }

        public void jumpDrawablesToCurrentState(View view)
        {
            ViewCompatHC.jumpDrawablesToCurrentState(view);
        }

        public int resolveSizeAndState(int i, int j, int k)
        {
            return ViewCompatHC.resolveSizeAndState(i, j, k);
        }

        public void setAlpha(View view, float f)
        {
            ViewCompatHC.setAlpha(view, f);
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

        public void setTranslationX(View view, float f)
        {
            ViewCompatHC.setTranslationX(view, f);
        }

        public void setTranslationY(View view, float f)
        {
            ViewCompatHC.setTranslationY(view, f);
        }

        HCViewCompatImpl()
        {
        }
    }

    static class ICSViewCompatImpl extends HCViewCompatImpl
    {

        static boolean accessibilityDelegateCheckFailed = false;
        static Field mAccessibilityDelegateField;

        public ViewPropertyAnimatorCompat animate(View view)
        {
            if (mViewPropertyAnimatorCompatMap == null)
            {
                mViewPropertyAnimatorCompatMap = new WeakHashMap();
            }
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat1 = (ViewPropertyAnimatorCompat)mViewPropertyAnimatorCompatMap.get(view);
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = viewpropertyanimatorcompat1;
            if (viewpropertyanimatorcompat1 == null)
            {
                viewpropertyanimatorcompat = new ViewPropertyAnimatorCompat(view);
                mViewPropertyAnimatorCompatMap.put(view, viewpropertyanimatorcompat);
            }
            return viewpropertyanimatorcompat;
        }

        public boolean canScrollHorizontally(View view, int i)
        {
            return ViewCompatICS.canScrollHorizontally(view, i);
        }

        public boolean canScrollVertically(View view, int i)
        {
            return ViewCompatICS.canScrollVertically(view, i);
        }

        public boolean hasAccessibilityDelegate(View view)
        {
            boolean flag = true;
            if (accessibilityDelegateCheckFailed)
            {
                return false;
            }
            if (mAccessibilityDelegateField == null)
            {
                try
                {
                    mAccessibilityDelegateField = android/view/View.getDeclaredField("mAccessibilityDelegate");
                    mAccessibilityDelegateField.setAccessible(true);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    accessibilityDelegateCheckFailed = true;
                    return false;
                }
            }
            try
            {
                view = ((View) (mAccessibilityDelegateField.get(view)));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                accessibilityDelegateCheckFailed = true;
                return false;
            }
            if (view == null)
            {
                flag = false;
            }
            return flag;
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

        public int getMinimumHeight(View view)
        {
            return ViewCompatJB.getMinimumHeight(view);
        }

        public int getMinimumWidth(View view)
        {
            return ViewCompatJB.getMinimumWidth(view);
        }

        public ViewParent getParentForAccessibility(View view)
        {
            return ViewCompatJB.getParentForAccessibility(view);
        }

        public boolean hasTransientState(View view)
        {
            return ViewCompatJB.hasTransientState(view);
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

        public void postOnAnimationDelayed(View view, Runnable runnable, long l)
        {
            ViewCompatJB.postOnAnimationDelayed(view, runnable, l);
        }

        public void requestApplyInsets(View view)
        {
            ViewCompatJB.requestApplyInsets(view);
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

        public int getPaddingEnd(View view)
        {
            return ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        public int getPaddingStart(View view)
        {
            return ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        public int getWindowSystemUiVisibility(View view)
        {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
        }

        public void setLayerPaint(View view, Paint paint)
        {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        JbMr1ViewCompatImpl()
        {
        }
    }

    static class KitKatViewCompatImpl extends JbMr1ViewCompatImpl
    {

        public void setImportantForAccessibility(View view, int i)
        {
            ViewCompatJB.setImportantForAccessibility(view, i);
        }

        KitKatViewCompatImpl()
        {
        }
    }

    static interface ViewCompatImpl
    {

        public abstract ViewPropertyAnimatorCompat animate(View view);

        public abstract boolean canScrollHorizontally(View view, int i);

        public abstract boolean canScrollVertically(View view, int i);

        public abstract float getAlpha(View view);

        public abstract boolean getFitsSystemWindows(View view);

        public abstract int getImportantForAccessibility(View view);

        public abstract int getLayerType(View view);

        public abstract int getLayoutDirection(View view);

        public abstract int getMeasuredState(View view);

        public abstract int getMinimumHeight(View view);

        public abstract int getMinimumWidth(View view);

        public abstract int getOverScrollMode(View view);

        public abstract int getPaddingEnd(View view);

        public abstract int getPaddingStart(View view);

        public abstract ViewParent getParentForAccessibility(View view);

        public abstract float getScaleX(View view);

        public abstract float getTranslationX(View view);

        public abstract float getTranslationY(View view);

        public abstract int getWindowSystemUiVisibility(View view);

        public abstract boolean hasAccessibilityDelegate(View view);

        public abstract boolean hasTransientState(View view);

        public abstract boolean isOpaque(View view);

        public abstract void jumpDrawablesToCurrentState(View view);

        public abstract void postInvalidateOnAnimation(View view);

        public abstract void postInvalidateOnAnimation(View view, int i, int j, int k, int l);

        public abstract void postOnAnimation(View view, Runnable runnable);

        public abstract void postOnAnimationDelayed(View view, Runnable runnable, long l);

        public abstract void requestApplyInsets(View view);

        public abstract int resolveSizeAndState(int i, int j, int k);

        public abstract void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat);

        public abstract void setAlpha(View view, float f);

        public abstract void setChildrenDrawingOrderEnabled(ViewGroup viewgroup, boolean flag);

        public abstract void setElevation(View view, float f);

        public abstract void setImportantForAccessibility(View view, int i);

        public abstract void setLayerPaint(View view, Paint paint);

        public abstract void setLayerType(View view, int i, Paint paint);

        public abstract void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onapplywindowinsetslistener);

        public abstract void setSaveFromParentEnabled(View view, boolean flag);

        public abstract void setScaleX(View view, float f);

        public abstract void setScaleY(View view, float f);

        public abstract void setTranslationX(View view, float f);

        public abstract void setTranslationY(View view, float f);
    }


    static final ViewCompatImpl IMPL;

    public static ViewPropertyAnimatorCompat animate(View view)
    {
        return IMPL.animate(view);
    }

    public static boolean canScrollHorizontally(View view, int i)
    {
        return IMPL.canScrollHorizontally(view, i);
    }

    public static boolean canScrollVertically(View view, int i)
    {
        return IMPL.canScrollVertically(view, i);
    }

    public static float getAlpha(View view)
    {
        return IMPL.getAlpha(view);
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

    public static int getMeasuredState(View view)
    {
        return IMPL.getMeasuredState(view);
    }

    public static int getMinimumHeight(View view)
    {
        return IMPL.getMinimumHeight(view);
    }

    public static int getMinimumWidth(View view)
    {
        return IMPL.getMinimumWidth(view);
    }

    public static int getOverScrollMode(View view)
    {
        return IMPL.getOverScrollMode(view);
    }

    public static int getPaddingEnd(View view)
    {
        return IMPL.getPaddingEnd(view);
    }

    public static int getPaddingStart(View view)
    {
        return IMPL.getPaddingStart(view);
    }

    public static ViewParent getParentForAccessibility(View view)
    {
        return IMPL.getParentForAccessibility(view);
    }

    public static float getScaleX(View view)
    {
        return IMPL.getScaleX(view);
    }

    public static float getTranslationX(View view)
    {
        return IMPL.getTranslationX(view);
    }

    public static float getTranslationY(View view)
    {
        return IMPL.getTranslationY(view);
    }

    public static int getWindowSystemUiVisibility(View view)
    {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    public static boolean hasAccessibilityDelegate(View view)
    {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasTransientState(View view)
    {
        return IMPL.hasTransientState(view);
    }

    public static boolean isOpaque(View view)
    {
        return IMPL.isOpaque(view);
    }

    public static void jumpDrawablesToCurrentState(View view)
    {
        IMPL.jumpDrawablesToCurrentState(view);
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

    public static void postOnAnimationDelayed(View view, Runnable runnable, long l)
    {
        IMPL.postOnAnimationDelayed(view, runnable, l);
    }

    public static void requestApplyInsets(View view)
    {
        IMPL.requestApplyInsets(view);
    }

    public static int resolveSizeAndState(int i, int j, int k)
    {
        return IMPL.resolveSizeAndState(i, j, k);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        IMPL.setAccessibilityDelegate(view, accessibilitydelegatecompat);
    }

    public static void setAlpha(View view, float f)
    {
        IMPL.setAlpha(view, f);
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

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onapplywindowinsetslistener)
    {
        IMPL.setOnApplyWindowInsetsListener(view, onapplywindowinsetslistener);
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

    public static void setTranslationX(View view, float f)
    {
        IMPL.setTranslationX(view, f);
    }

    public static void setTranslationY(View view, float f)
    {
        IMPL.setTranslationY(view, f);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            IMPL = new Api21ViewCompatImpl();
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
