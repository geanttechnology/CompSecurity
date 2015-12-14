// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat
{

    private static final Object DEFAULT_DELEGATE;
    private static final AccessibilityDelegateImpl IMPL;
    final Object mBridge;

    public AccessibilityDelegateCompat()
    {
        mBridge = IMPL.newAccessiblityDelegateBridge(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, view);
    }

    Object getBridge()
    {
        return mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, view, accessibilitynodeinfocompat);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, viewgroup, view, accessibilityevent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            IMPL = new AccessibilityDelegateJellyBeanImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new AccessibilityDelegateIcsImpl();
        } else
        {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }

    /* member class not found */
    class AccessibilityDelegateImpl {}


    /* member class not found */
    class AccessibilityDelegateJellyBeanImpl {}


    /* member class not found */
    class AccessibilityDelegateIcsImpl {}


    /* member class not found */
    class AccessibilityDelegateStubImpl {}

}
