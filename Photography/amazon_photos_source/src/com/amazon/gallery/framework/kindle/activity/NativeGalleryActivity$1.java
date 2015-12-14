// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            NativeGalleryActivity

class this._cls0 extends AccessibilityDelegateCompat
{

    final AccessibilityNodeProviderCompat emptyProvider = new AccessibilityNodeProviderCompat();
    final NativeGalleryActivity this$0;

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        if (fragmentController != null && fragmentController.isFragmentOpen())
        {
            return emptyProvider;
        } else
        {
            return super.getAccessibilityNodeProvider(view);
        }
    }

    ()
    {
        this$0 = NativeGalleryActivity.this;
        super();
    }
}
