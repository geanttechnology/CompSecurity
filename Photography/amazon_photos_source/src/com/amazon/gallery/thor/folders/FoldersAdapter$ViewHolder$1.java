// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersAdapter

class this._cls0 extends AnimatorListenerAdapter
{

    final onSelectedBackground this$0;

    public void onAnimationEnd(Animator animator)
    {
        onSelectedBackground.setVisibility(8);
    }

    A()
    {
        this$0 = this._cls0.this;
        super();
    }
}
