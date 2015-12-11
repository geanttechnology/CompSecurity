// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListOfEventsViewModel

public class ListOfEventGroupsViewModel extends ViewModel
{

    private static int MAX_EVENTS_IN_GROUP = 3;
    public final List eventGroups = new ArrayList();
    public String eventsTitle;

    public ListOfEventGroupsViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        eventsTitle = null;
    }

    public static List createEventGroup(int i, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1, boolean flag)
    {
        contentgroup = contentgroup.contents;
        ArrayList arraylist = new ArrayList();
        int k = contentgroup.size();
        for (int j = 0; j < k;)
        {
            int l = Math.min(k - j, MAX_EVENTS_IN_GROUP);
            Object obj = contentgroup.subList(j, j + l);
            j += l;
            ListOfEventGroupsViewModel listofeventgroupsviewmodel = new ListOfEventGroupsViewModel(i, onclicklistener1);
            listofeventgroupsviewmodel.eventsTitle = s;
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); listofeventgroupsviewmodel.eventGroups.add(ListOfEventsViewModel.createFromRppGroupEvents(i, contentrecord.rppEventGroup, onclicklistener, onclicklistener1, flag)))
            {
                contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
            }

            arraylist.add(listofeventgroupsviewmodel);
        }

        return arraylist;
    }

}
