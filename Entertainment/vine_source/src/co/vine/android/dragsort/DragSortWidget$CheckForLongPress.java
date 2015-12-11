// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;


// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

public class this._cls0
    implements Runnable
{

    final DragSortWidget this$0;

    public void run()
    {
        if (DragSortWidget.access$2900(DragSortWidget.this) == DragSortWidget.access$3000(DragSortWidget.this))
        {
            if (DragSortWidget.access$2900(DragSortWidget.this) != DragSortWidget.access$2200(DragSortWidget.this))
            {
                DragSortWidget.access$3100(DragSortWidget.this, DragSortWidget.access$2900(DragSortWidget.this), false);
            }
            DragSortWidget.access$102(DragSortWidget.this, DragSortWidget.access$2900(DragSortWidget.this));
            if (DragSortWidget.access$3200(DragSortWidget.this, DragSortWidget.access$2900(DragSortWidget.this)))
            {
                DragSortWidget.access$702(DragSortWidget.this, DragSortWidget.access$200(DragSortWidget.this) - DragSortWidget.access$1600(DragSortWidget.this));
                DragSortWidget.access$802(DragSortWidget.this, DragSortWidget.access$1800(DragSortWidget.this) - DragSortWidget.access$1700(DragSortWidget.this));
            }
        }
    }

    public ()
    {
        this$0 = DragSortWidget.this;
        super();
    }
}
