// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NavigationBar

class this._cls0 extends AnimatorListenerAdapter
{

    final NavigationBar this$0;

    public void onAnimationEnd(Animator animator)
    {
        NavigationBar.access$000(NavigationBar.this).setVisibility(4);
    }

    ()
    {
        this$0 = NavigationBar.this;
        super();
    }
}
