// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, AccessibilityDelegateCompat

static interface t
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
