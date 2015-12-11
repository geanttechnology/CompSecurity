// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.graphics.Rect;

// Referenced classes of package android.support.v4.view.accessibility:
//            AccessibilityNodeInfoCompat, AccessibilityNodeInfoCompatIcs

static class  extends 
{

    public void addAction(Object obj, int i)
    {
        AccessibilityNodeInfoCompatIcs.addAction(obj, i);
    }

    public int getActions(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.getActions(obj);
    }

    public void getBoundsInParent(Object obj, Rect rect)
    {
        AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
    }

    public void getBoundsInScreen(Object obj, Rect rect)
    {
        AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
    }

    public CharSequence getClassName(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.getClassName(obj);
    }

    public CharSequence getContentDescription(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
    }

    public CharSequence getPackageName(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.getPackageName(obj);
    }

    public CharSequence getText(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.getText(obj);
    }

    public boolean isCheckable(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isCheckable(obj);
    }

    public boolean isChecked(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isChecked(obj);
    }

    public boolean isClickable(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isClickable(obj);
    }

    public boolean isEnabled(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isEnabled(obj);
    }

    public boolean isFocusable(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isFocusable(obj);
    }

    public boolean isFocused(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isFocused(obj);
    }

    public boolean isLongClickable(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
    }

    public boolean isPassword(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isPassword(obj);
    }

    public boolean isScrollable(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isScrollable(obj);
    }

    public boolean isSelected(Object obj)
    {
        return AccessibilityNodeInfoCompatIcs.isSelected(obj);
    }

    public void setClassName(Object obj, CharSequence charsequence)
    {
        AccessibilityNodeInfoCompatIcs.setClassName(obj, charsequence);
    }

    public void setClickable(Object obj, boolean flag)
    {
        AccessibilityNodeInfoCompatIcs.setClickable(obj, flag);
    }

    public void setLongClickable(Object obj, boolean flag)
    {
        AccessibilityNodeInfoCompatIcs.setLongClickable(obj, flag);
    }

    public void setScrollable(Object obj, boolean flag)
    {
        AccessibilityNodeInfoCompatIcs.setScrollable(obj, flag);
    }

    public void setSelected(Object obj, boolean flag)
    {
        AccessibilityNodeInfoCompatIcs.setSelected(obj, flag);
    }

    ()
    {
    }
}
