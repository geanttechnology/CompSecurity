// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.DisplaySettings;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DisplaySettingsEntity extends RetailSearchEntity
    implements DisplaySettings
{

    private String resultLayout;

    public DisplaySettingsEntity()
    {
    }

    public String getResultLayout()
    {
        return resultLayout;
    }

    public void setResultLayout(String s)
    {
        resultLayout = s;
    }
}
