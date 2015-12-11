// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.events.EventViewModel;
import java.util.ArrayList;
import java.util.List;

public class ListOfEventsViewModel extends ViewModel
{

    public final List events = new ArrayList();

    public ListOfEventsViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
    }

    public static ListOfEventsViewModel createFromRppGroupEvents(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEventGroup rppeventgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1, boolean flag)
    {
        onclicklistener1 = new ListOfEventsViewModel(i, onclicklistener1);
        List list = rppeventgroup.rppEvents;
        int k = list.size();
        for (i = 0; i < k; i++)
        {
            boolean flag1 = false;
            int j = ((flag1) ? 1 : 0);
            if (flag)
            {
                j = ((flag1) ? 1 : 0);
                if (i == 0)
                {
                    j = ((flag1) ? 1 : 0);
                    if (1 == (k & 1))
                    {
                        j = 1;
                    }
                }
            }
            ((ListOfEventsViewModel) (onclicklistener1)).events.add(new EventViewModel(j, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEvent)list.get(i), rppeventgroup.groupId, flag, onclicklistener));
        }

        return onclicklistener1;
    }
}
