// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.animation.SimpleAnimationListener;
import co.vine.android.util.FloatingViewUtils;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, DraftFragment

class ener extends SimpleAnimationListener
{

    final AbstractRecordingActivity this$0;
    final int val$margin;
    final int val$offset;
    final DraftFragment val$prevFragment;
    final View val$prevView;
    final int val$previewLocation[];

    public void onAnimationEnd(Animation animation)
    {
        FloatingViewUtils.buildFloatingViewFor(AbstractRecordingActivity.this, val$prevView, AbstractRecordingActivity.access$3400(AbstractRecordingActivity.this), val$prevView.getWidth(), val$previewLocation[0], val$previewLocation[1] - val$offset);
        AbstractRecordingActivity.access$3400(AbstractRecordingActivity.this).setVisibility(0);
        (new MoveResizeAnimator(3, AbstractRecordingActivity.access$3400(AbstractRecordingActivity.this), AbstractRecordingActivity.access$3400(AbstractRecordingActivity.this), (int)((float)AbstractRecordingActivity.access$3300(AbstractRecordingActivity.this).x * (1.0F - mPreviewRatio)) - val$margin * 5, val$previewLocation[1] - val$offset, 1.0D, 1.0D, 300, AbstractRecordingActivity.this, val$prevFragment.getView())).start();
    }

    ener()
    {
        this$0 = final_abstractrecordingactivity;
        val$prevView = view;
        val$previewLocation = ai;
        val$offset = i;
        val$margin = j;
        val$prevFragment = DraftFragment.this;
        super();
    }
}
