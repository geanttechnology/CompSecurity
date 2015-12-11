// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity, TaskInfo

class this._cls0
    implements android.widget.ItemClickListener
{

    final RubActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
label0:
        {
            adapterview = ((AdapterView) (RubActivity.access$5(RubActivity.this).getItemAtPosition(i)));
            if (adapterview instanceof TaskInfo)
            {
                RubActivity.access$23(RubActivity.this, (CheckBox)view.findViewById(0x7f070131));
                adapterview = (TaskInfo)adapterview;
                if (!"com.allinone.free".equals(adapterview.getPackageName()) && !"system".equals(adapterview.getPackageName()) && !"android.process.media".equals(adapterview.getPackageName()))
                {
                    break label0;
                }
                RubActivity.access$24(RubActivity.this).setVisibility(4);
            }
            return;
        }
        if (adapterview.isCheck())
        {
            adapterview.setCheck(false);
            RubActivity.access$24(RubActivity.this).setChecked(false);
            return;
        } else
        {
            adapterview.setCheck(true);
            RubActivity.access$24(RubActivity.this).setChecked(true);
            return;
        }
    }

    tener()
    {
        this$0 = RubActivity.this;
        super();
    }
}
