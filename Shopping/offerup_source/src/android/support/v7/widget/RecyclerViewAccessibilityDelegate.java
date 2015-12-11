// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public class RecyclerViewAccessibilityDelegate extends a
{

    final a mItemDelegate = new _cls1();
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerview)
    {
        mRecyclerView = recyclerview;
    }

    private boolean shouldIgnore()
    {
        return mRecyclerView.hasPendingAdapterUpdates();
    }

    a getItemDelegate()
    {
        return mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if ((view instanceof RecyclerView) && !shouldIgnore())
        {
            view = (RecyclerView)view;
            if (view.getLayoutManager() != null)
            {
                view.getLayoutManager().onInitializeAccessibilityEvent(accessibilityevent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, f f1)
    {
        super.onInitializeAccessibilityNodeInfo(view, f1);
        f1.b(android/support/v7/widget/RecyclerView.getName());
        if (!shouldIgnore() && mRecyclerView.getLayoutManager() != null)
        {
            mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(f1);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (!shouldIgnore() && mRecyclerView.getLayoutManager() != null)
        {
            return mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
        } else
        {
            return false;
        }
    }


    private class _cls1 extends a
    {

        final RecyclerViewAccessibilityDelegate this$0;

        public void onInitializeAccessibilityNodeInfo(View view, f f1)
        {
            super.onInitializeAccessibilityNodeInfo(view, f1);
            if (!shouldIgnore() && mRecyclerView.getLayoutManager() != null)
            {
                mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, f1);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle)
        {
            if (super.performAccessibilityAction(view, i, bundle))
            {
                return true;
            }
            if (!shouldIgnore() && mRecyclerView.getLayoutManager() != null)
            {
                return mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
            } else
            {
                return false;
            }
        }

        _cls1()
        {
            this$0 = RecyclerViewAccessibilityDelegate.this;
            super();
        }
    }

}
