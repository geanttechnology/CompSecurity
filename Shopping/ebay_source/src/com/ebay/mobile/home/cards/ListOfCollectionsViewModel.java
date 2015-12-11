// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.collections.CollectionViewModel;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOfCollectionsViewModel extends ViewModel
{

    public final List collections = new ArrayList();
    public final String title;

    public ListOfCollectionsViewModel(int i, String s, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        title = s;
    }

    public static ListOfCollectionsViewModel createFromCollectionList(int i, String s, List list, boolean flag, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1)
    {
        s = new ListOfCollectionsViewModel(i, s, onclicklistener1);
        for (list = list.iterator(); list.hasNext(); ((ListOfCollectionsViewModel) (s)).collections.add(onclicklistener1))
        {
            onclicklistener1 = new CollectionViewModel(i, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection)list.next(), onclicklistener);
            onclicklistener1.isCollectionOwnerShown = flag;
        }

        return s;
    }
}
