// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatIcs
{

    public static void addAction(Object obj, int i)
    {
        ((AccessibilityNodeInfo)obj).addAction(i);
    }

    public static int getActions(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getActions();
    }

    public static void getBoundsInParent(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInParent(rect);
    }

    public static void getBoundsInScreen(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInScreen(rect);
    }

    public static CharSequence getClassName(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getClassName();
    }

    public static CharSequence getContentDescription(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getContentDescription();
    }

    public static CharSequence getPackageName(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getPackageName();
    }

    public static CharSequence getText(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getText();
    }

    public static boolean isCheckable(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isCheckable();
    }

    public static boolean isChecked(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isChecked();
    }

    public static boolean isClickable(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isClickable();
    }

    public static boolean isEnabled(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isEnabled();
    }

    public static boolean isFocusable(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocusable();
    }

    public static boolean isFocused(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocused();
    }

    public static boolean isLongClickable(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isLongClickable();
    }

    public static boolean isPassword(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isPassword();
    }

    public static boolean isScrollable(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isScrollable();
    }

    public static boolean isSelected(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isSelected();
    }

    public static void setClassName(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setClassName(charsequence);
    }

    public static void setClickable(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setClickable(flag);
    }

    public static void setLongClickable(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setLongClickable(flag);
    }

    public static void setScrollable(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setScrollable(flag);
    }

    public static void setSelected(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setSelected(flag);
    }
}
