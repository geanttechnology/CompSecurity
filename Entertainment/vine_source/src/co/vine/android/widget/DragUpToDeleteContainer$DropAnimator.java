// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.animation.SmoothAnimator;

// Referenced classes of package co.vine.android.widget:
//            DragUpToDeleteContainer

private class this._cls0 extends SmoothAnimator
{

    private float mDeltaX;
    private float mDeltaY;
    private int mTargetX;
    private int mTargetY;
    final DragUpToDeleteContainer this$0;

    public void onStart()
    {
        DragUpToDeleteContainer.access$602(DragUpToDeleteContainer.this, true);
        if (DragUpToDeleteContainer.access$700(DragUpToDeleteContainer.this) != null)
        {
            mTargetY = (int)(DragUpToDeleteContainer.access$800(DragUpToDeleteContainer.this) - DragUpToDeleteContainer.access$900(DragUpToDeleteContainer.this));
        }
        mTargetX = DragUpToDeleteContainer.access$1000(DragUpToDeleteContainer.this);
        mDeltaX = DragUpToDeleteContainer.access$1000(DragUpToDeleteContainer.this) - mTargetX;
        mDeltaY = DragUpToDeleteContainer.access$000(DragUpToDeleteContainer.this) - mTargetY;
    }

    public void onStop()
    {
        if (DragUpToDeleteContainer.access$500(DragUpToDeleteContainer.this) != null)
        {
            DragUpToDeleteContainer.access$500(DragUpToDeleteContainer.this).viewLanded();
        }
        DragUpToDeleteContainer.access$400(DragUpToDeleteContainer.this);
        invalidate();
    }

    public void onUpdate(float f, float f1)
    {
        f = 1.0F - f1;
        DragUpToDeleteContainer.access$1002(DragUpToDeleteContainer.this, mTargetX + (int)(mDeltaX * f));
        DragUpToDeleteContainer.access$002(DragUpToDeleteContainer.this, mTargetY + (int)(mDeltaY * f));
        invalidate();
    }

    public r(float f, int i)
    {
        this$0 = DragUpToDeleteContainer.this;
        super(DragUpToDeleteContainer.this, f, i);
    }
}
