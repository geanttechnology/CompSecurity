// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.dragsort.DragSortWidget;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls1
    implements Runnable
{

    final stFirstItem this$1;

    public void run()
    {
        if (VineRecorder.access$4400(_fld0) == -1)
        {
            DragSortWidget dragsortwidget = VineRecorder.access$2600(_fld0);
            if (dragsortwidget != null)
            {
                dragsortwidget.setFocused(stFirstItem);
            }
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
