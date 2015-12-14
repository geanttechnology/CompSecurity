// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.idunnololz.widgets.AnimatedExpandableListView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements android.view.xtraDownloadActivity._cls1
{

    final ExtraDownloadActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag1;
label0:
        {
label1:
            {
                boolean flag2 = false;
                boolean flag = false;
                flag1 = flag2;
                if (ExtraDownloadActivity.a(a) == null)
                {
                    break label0;
                }
                flag1 = flag2;
                if (ExtraDownloadActivity.a(a).getVisibility() != 0)
                {
                    break label0;
                }
                if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                {
                    int i = 0;
                    while (i < ExtraDownloadActivity.a(a).getChildCount()) 
                    {
                        view = ExtraDownloadActivity.a(a).getChildAt(i);
                        if (view instanceof DownloadGridItem)
                        {
                            view = (DownloadGridItem)view;
                        } else
                        {
                            view = null;
                        }
                        if (view != null && !view.a(motionevent.getRawX(), motionevent.getRawY()))
                        {
                            view.setLookTemplateMenuVisibility(4);
                        }
                        i++;
                    }
                }
                int j = ((flag) ? 1 : 0);
                if (motionevent.getAction() != 2)
                {
                    if (motionevent.getAction() != 8)
                    {
                        break label1;
                    }
                    j = ((flag) ? 1 : 0);
                }
                while (j < ExtraDownloadActivity.a(a).getChildCount()) 
                {
                    view = ExtraDownloadActivity.a(a).getChildAt(j);
                    if (view instanceof DownloadGridItem)
                    {
                        view = (DownloadGridItem)view;
                    } else
                    {
                        view = null;
                    }
                    if (view != null)
                    {
                        view.setLookTemplateMenuVisibility(4);
                    }
                    j++;
                }
            }
            ExtraDownloadActivity.a(a).dispatchTouchEvent(motionevent);
            flag1 = true;
        }
        return flag1;
    }

    A(ExtraDownloadActivity extradownloadactivity)
    {
        a = extradownloadactivity;
        super();
    }
}
