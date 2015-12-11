// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import co.vine.android.views.HorizontalListView;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

class this._cls1
    implements android.animation.torUpdateListener
{

    final alidate this$1;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        DragSortWidget.access$000(_fld0).invalidate();
    }

    l.swapViewStartLeft()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class co/vine/android/dragsort/DragSortWidget$1

/* anonymous class */
    class DragSortWidget._cls1
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final DragSortWidget this$0;
        final ViewTreeObserver val$observer;
        final int val$swapViewStartLeft;
        final int val$to;

        public boolean onPreDraw()
        {
            observer.removeOnPreDrawListener(this);
            Object obj = DragSortWidget.access$000(DragSortWidget.this).getChildAt(to - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
            if (obj != null)
            {
                int i = ((View) (obj)).getLeft();
                ((View) (obj)).setTranslationX(swapViewStartLeft - i);
                obj = ObjectAnimator.ofFloat(obj, View.TRANSLATION_X, new float[] {
                    0.0F
                });
                ((ObjectAnimator) (obj)).setDuration(100L);
                ((ObjectAnimator) (obj)).addUpdateListener(new DragSortWidget._cls1._cls1());
                ((ObjectAnimator) (obj)).start();
            }
            return true;
        }

            
            {
                this$0 = final_dragsortwidget;
                observer = viewtreeobserver;
                to = i;
                swapViewStartLeft = I.this;
                super();
            }
    }

}
