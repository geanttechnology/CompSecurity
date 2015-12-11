// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoriesViewModel extends ViewModel
{

    public final List categories = new ArrayList();
    public final String name;

    public CategoriesViewModel(int i, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        name = s;
        if (contentgroup != null && !contentgroup.contents.isEmpty())
        {
            s = contentgroup.contents.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                contentgroup = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)s.next();
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (contentgroup)).category != null)
                {
                    categories.add(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (contentgroup)).category);
                }
            } while (true);
        }
    }
}
