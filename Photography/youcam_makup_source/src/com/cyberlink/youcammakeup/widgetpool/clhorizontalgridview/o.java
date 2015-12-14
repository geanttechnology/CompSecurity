// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AdapterView

class o extends AccessibilityDelegateCompat
{

    final AdapterView a;

    o(AdapterView adapterview)
    {
        a = adapterview;
        super();
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(com/cyberlink/youcammakeup/widgetpool/clhorizontalgridview/AdapterView.getName());
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            accessibilityevent.setScrollable(AdapterView.d(a));
        }
        view = a.getSelectedView();
        if (view != null)
        {
            accessibilityevent.setEnabled(view.isEnabled());
        }
        accessibilityevent.setCurrentItemIndex(a.getSelectedItemPosition());
        accessibilityevent.setFromIndex(a.getFirstVisiblePosition());
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            accessibilityevent.setToIndex(a.getLastVisiblePosition());
        }
        accessibilityevent.setItemCount(a.getCount());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
        accessibilitynodeinfocompat.setClassName(com/cyberlink/youcammakeup/widgetpool/clhorizontalgridview/AdapterView.getName());
        accessibilitynodeinfocompat.setScrollable(AdapterView.d(a));
        view = a.getSelectedView();
        if (view != null)
        {
            accessibilitynodeinfocompat.setEnabled(view.isEnabled());
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if (super.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent))
        {
            AccessibilityEvent accessibilityevent1 = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(viewgroup, accessibilityevent1);
            view.dispatchPopulateAccessibilityEvent(accessibilityevent1);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                accessibilityevent.appendRecord(accessibilityevent1);
            }
            return true;
        } else
        {
            return false;
        }
    }
}
