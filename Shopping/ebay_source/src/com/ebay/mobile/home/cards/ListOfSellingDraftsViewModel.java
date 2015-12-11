// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingDraftViewModel

public class ListOfSellingDraftsViewModel extends ViewModel
{

    public final List drafts = new ArrayList();
    public final String groupTitle;

    public ListOfSellingDraftsViewModel(int i, String s, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        groupTitle = s;
    }

    public static ListOfSellingDraftsViewModel createFromSellingDrafts(int i, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1)
    {
        s = new ListOfSellingDraftsViewModel(i, s, onclicklistener1);
        if (contentgroup.contents != null)
        {
            for (contentgroup = contentgroup.contents.iterator(); contentgroup.hasNext(); ((ListOfSellingDraftsViewModel) (s)).drafts.add(new SellingDraftViewModel(i, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener1)).listingDraft, onclicklistener)))
            {
                onclicklistener1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
            }

        }
        return s;
    }
}
