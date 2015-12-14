// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersBottomSheet

class this._cls0 extends AnimatorListenerAdapter
{

    final FoldersBottomSheet this$0;

    public void onAnimationStart(Animator animator)
    {
        FoldersBottomSheet.access$000(FoldersBottomSheet.this).setVisibility(0);
    }

    ()
    {
        this$0 = FoldersBottomSheet.this;
        super();
    }
}
