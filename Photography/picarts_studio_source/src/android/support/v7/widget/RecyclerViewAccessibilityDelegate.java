// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat
{

    final AccessibilityDelegateCompat mItemDelegate = new _cls1();
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerview)
    {
        mRecyclerView = recyclerview;
    }

    AccessibilityDelegateCompat getItemDelegate()
    {
        return mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if (view instanceof RecyclerView)
        {
            view = (RecyclerView)view;
            if (view.getLayoutManager() != null)
            {
                view.getLayoutManager().onInitializeAccessibilityEvent(accessibilityevent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
        accessibilitynodeinfocompat.setClassName(android/support/v7/widget/RecyclerView.getName());
        if (mRecyclerView.getLayoutManager() != null)
        {
            mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilitynodeinfocompat);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (mRecyclerView.getLayoutManager() != null)
        {
            return mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
        } else
        {
            return false;
        }
    }

    /* member class not found */
    class _cls1 {}

}
