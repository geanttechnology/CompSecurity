// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.adapter.DateTimePickerAdapter;
import com.groupon.view.FixedPositionListView;

// Referenced classes of package com.groupon.fragment:
//            DateTimeFilterDialog, RapiSearchResultFragmentPresenter

class val.currentTime
    implements Runnable
{

    final DateTimeFilterDialog this$0;
    final DateTimePickerAdapter val$adapter;
    final long val$currentTime;
    final int val$oldPos;
    final int val$position;

    public void run()
    {
        if (val$adapter == DateTimeFilterDialog.access$400(DateTimeFilterDialog.this))
        {
            int i = DateTimeFilterDialog.access$900(DateTimeFilterDialog.this).getDefaultPositionForList2(true);
            if (val$oldPos == i && val$position != i || i == val$position)
            {
                DateTimeFilterDialog.access$500(DateTimeFilterDialog.this).setDataList(DateTimeFilterDialog.access$900(DateTimeFilterDialog.this).getListValuePair3());
                list3.invalidate();
                if (DateTimeFilterDialog.access$900(DateTimeFilterDialog.this).isToday())
                {
                    int j = DateTimeFilterDialog.access$900(DateTimeFilterDialog.this).findMappingIndexInListValuePair3ForToday();
                    if (j == -1)
                    {
                        DateTimeFilterDialog.access$800(DateTimeFilterDialog.this, Long.valueOf(val$currentTime));
                        return;
                    } else
                    {
                        DateTimeFilterDialog.access$602(DateTimeFilterDialog.this, 1);
                        DateTimeFilterDialog.access$500(DateTimeFilterDialog.this).setSelectedPosition(j, false);
                        list3.setSelection(j);
                        return;
                    }
                } else
                {
                    DateTimeFilterDialog.access$602(DateTimeFilterDialog.this, 1);
                    int k = DateTimeFilterDialog.access$900(DateTimeFilterDialog.this).findMappingIndexInListValuePair3FromToday();
                    DateTimeFilterDialog.access$500(DateTimeFilterDialog.this).setSelectedPosition(k, false);
                    list3.setSelection(k);
                    return;
                }
            } else
            {
                DateTimeFilterDialog.access$800(DateTimeFilterDialog.this, Long.valueOf(val$currentTime));
                return;
            }
        } else
        {
            DateTimeFilterDialog.access$800(DateTimeFilterDialog.this, Long.valueOf(val$currentTime));
            return;
        }
    }

    tPresenter()
    {
        this$0 = final_datetimefilterdialog;
        val$adapter = datetimepickeradapter;
        val$oldPos = i;
        val$position = j;
        val$currentTime = J.this;
        super();
    }
}
