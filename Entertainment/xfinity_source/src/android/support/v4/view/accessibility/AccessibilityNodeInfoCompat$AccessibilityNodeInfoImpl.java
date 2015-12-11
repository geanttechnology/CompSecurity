// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.graphics.Rect;

// Referenced classes of package android.support.v4.view.accessibility:
//            AccessibilityNodeInfoCompat

static interface a
{

    public abstract void addAction(Object obj, int i);

    public abstract int getActions(Object obj);

    public abstract void getBoundsInParent(Object obj, Rect rect);

    public abstract void getBoundsInScreen(Object obj, Rect rect);

    public abstract CharSequence getClassName(Object obj);

    public abstract CharSequence getContentDescription(Object obj);

    public abstract CharSequence getPackageName(Object obj);

    public abstract CharSequence getText(Object obj);

    public abstract String getViewIdResourceName(Object obj);

    public abstract boolean isCheckable(Object obj);

    public abstract boolean isChecked(Object obj);

    public abstract boolean isClickable(Object obj);

    public abstract boolean isEnabled(Object obj);

    public abstract boolean isFocusable(Object obj);

    public abstract boolean isFocused(Object obj);

    public abstract boolean isLongClickable(Object obj);

    public abstract boolean isPassword(Object obj);

    public abstract boolean isScrollable(Object obj);

    public abstract boolean isSelected(Object obj);

    public abstract void setClassName(Object obj, CharSequence charsequence);

    public abstract void setClickable(Object obj, boolean flag);

    public abstract void setLongClickable(Object obj, boolean flag);

    public abstract void setScrollable(Object obj, boolean flag);

    public abstract void setSelected(Object obj, boolean flag);
}
