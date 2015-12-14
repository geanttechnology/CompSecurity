// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.view.View;

// Referenced classes of package com.millennialmedia.internal:
//            SizableStateManager

class zableState
    implements android.view.tener
{

    final SizableStateManager this$0;
    final zableState val$deferredState;
    final View val$view;

    public void onLayoutChange(View view1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        i = k - i;
        j = l - j;
        if (i > 0 && j > 0)
        {
            val$view.removeOnLayoutChangeListener(this);
            if (val$deferredState == zableState.STATE_RESIZED)
            {
                SizableStateManager.access$300(SizableStateManager.this).onResized(i, j);
            } else
            {
                if (val$deferredState == zableState.STATE_EXPANDED)
                {
                    SizableStateManager.access$300(SizableStateManager.this).onExpanded();
                    return;
                }
                if (val$deferredState == zableState.STATE_UNRESIZED)
                {
                    SizableStateManager.access$300(SizableStateManager.this).onUnresized(i, j);
                    return;
                }
                if (val$deferredState == zableState.STATE_COLLAPSED)
                {
                    SizableStateManager.access$300(SizableStateManager.this).onCollapsed();
                    return;
                }
            }
        }
    }

    zableState()
    {
        this$0 = final_sizablestatemanager;
        val$view = view1;
        val$deferredState = zableState.this;
        super();
    }
}
