// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import com.poshmark.utils.FilterResultsManager;

// Referenced classes of package com.poshmark.ui:
//            PMContainerActivity

public class PMSearchActivity extends PMContainerActivity
{

    FilterResultsManager searchManager;

    public PMSearchActivity()
    {
        searchManager = new FilterResultsManager();
    }

    public FilterResultsManager getSearchManager()
    {
        return searchManager;
    }
}
