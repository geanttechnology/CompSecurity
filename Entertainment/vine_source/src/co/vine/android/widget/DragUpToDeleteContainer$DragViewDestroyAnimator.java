// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.animation.SmoothAnimator;

// Referenced classes of package co.vine.android.widget:
//            DragUpToDeleteContainer

private class this._cls0 extends SmoothAnimator
{

    private int mDeltaY;
    private int mStartY;
    final DragUpToDeleteContainer this$0;

    public void onStart()
    {
        mStartY = DragUpToDeleteContainer.access$000(DragUpToDeleteContainer.this);
        mDeltaY = DragUpToDeleteContainer.access$000(DragUpToDeleteContainer.this) + DragUpToDeleteContainer.access$100(DragUpToDeleteContainer.this);
        DragUpToDeleteContainer.access$202(DragUpToDeleteContainer.this, true);
    }

    public void onStop()
    {
        DragUpToDeleteContainer.access$302(DragUpToDeleteContainer.this, 0.0F);
        DragUpToDeleteContainer.access$202(DragUpToDeleteContainer.this, false);
        DragUpToDeleteContainer.access$400(DragUpToDeleteContainer.this);
        if (DragUpToDeleteContainer.access$500(DragUpToDeleteContainer.this) != null)
        {
            DragUpToDeleteContainer.access$500(DragUpToDeleteContainer.this).oyFinished();
        }
        invalidate();
    }

    public void onUpdate(float f, float f1)
    {
        DragUpToDeleteContainer.access$002(DragUpToDeleteContainer.this, (int)((float)mStartY - (float)mDeltaY * f1));
        invalidate();
    }

    public (float f, int i)
    {
        this$0 = DragUpToDeleteContainer.this;
        super(DragUpToDeleteContainer.this, f, i);
    }
}
