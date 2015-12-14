// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

class this._cls0 extends AnimatorListenerAdapter
{

    final AndroidNavigationUploadView this$0;

    public void onAnimationEnd(Animator animator)
    {
        AndroidNavigationUploadView.access$100(AndroidNavigationUploadView.this, false);
        AndroidNavigationUploadView.access$200(AndroidNavigationUploadView.this, ewState.REST, true);
    }

    ewState()
    {
        this$0 = AndroidNavigationUploadView.this;
        super();
    }
}
