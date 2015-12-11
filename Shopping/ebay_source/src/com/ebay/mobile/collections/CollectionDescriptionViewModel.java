// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionItemViewModel

public class CollectionDescriptionViewModel extends CollectionItemViewModel
{

    public final String description;
    public final String headline;

    public CollectionDescriptionViewModel(int i, String s, String s1, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        this(i, null, s, s1, onclicklistener);
    }

    public CollectionDescriptionViewModel(int i, List list, String s, String s1, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, list, onclicklistener);
        description = s;
        headline = s1;
    }
}
