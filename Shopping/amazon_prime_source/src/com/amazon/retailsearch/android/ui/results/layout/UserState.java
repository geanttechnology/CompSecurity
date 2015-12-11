// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;


// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElementModel

public class UserState
{

    private LayoutElementModel currentDataInFocus;
    private String entryAsin;
    private int entryIndex;
    private Object selectedModel;

    public UserState()
    {
    }

    public LayoutElementModel getCurrentDataInFocus()
    {
        return currentDataInFocus;
    }

    public String getEntryAsin()
    {
        return entryAsin;
    }

    public int getEntryIndex()
    {
        return entryIndex;
    }

    protected Object getSelectedModel()
    {
        return selectedModel;
    }

    public void setCurrentDataInFocus(LayoutElementModel layoutelementmodel)
    {
        currentDataInFocus = layoutelementmodel;
    }

    public void setEntryAsin(String s)
    {
        entryAsin = s;
    }

    public void setEntryIndex(int i)
    {
        entryIndex = i;
    }

    protected void setSelectedModel(Object obj)
    {
        selectedModel = obj;
    }
}
