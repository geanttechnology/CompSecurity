// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;

import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.library.services.drag:
//            DragView, DropTarget

class this._cls0
    implements com.nineoldandroids.animation.imatorListener
{

    final DragView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        DragView.access$002(DragView.this, false);
        if (DragView.access$100(DragView.this) != null)
        {
            DragView.access$100(DragView.this).onDragViewDropAnimationFinished(DragView.access$200(DragView.this), DragView.this);
        }
        remove(false);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    A()
    {
        this$0 = DragView.this;
        super();
    }
}
