// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

private class <init>
    implements Runnable
{

    private int mOriginalAttachCount;
    final HorizontalListView this$0;

    public void rememberWindowAttachCount()
    {
        mOriginalAttachCount = HorizontalListView.access$1300(HorizontalListView.this);
    }

    public void run()
    {
label0:
        {
            int i = HorizontalListView.access$200(HorizontalListView.this);
            View view = getChildAt(i - HorizontalListView.access$800(HorizontalListView.this));
            if (view != null)
            {
                int j = HorizontalListView.access$200(HorizontalListView.this);
                long l = HorizontalListView.access$500(HorizontalListView.this).getItemId(HorizontalListView.access$200(HorizontalListView.this));
                boolean flag1 = false;
                boolean flag = flag1;
                if (sameWindow())
                {
                    flag = flag1;
                    if (!HorizontalListView.access$100(HorizontalListView.this))
                    {
                        flag = HorizontalListView.access$1500(HorizontalListView.this, view, j, l);
                    }
                }
                if (!flag)
                {
                    break label0;
                }
                HorizontalListView.access$002(HorizontalListView.this, -1);
                setPressed(false);
                view.setPressed(false);
            }
            return;
        }
        HorizontalListView.access$002(HorizontalListView.this, 2);
    }

    public boolean sameWindow()
    {
        return hasWindowFocus() && HorizontalListView.access$1400(HorizontalListView.this) == mOriginalAttachCount;
    }

    private ()
    {
        this$0 = HorizontalListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
