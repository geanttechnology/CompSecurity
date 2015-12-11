// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;


public class ContentSwitcherModel
{

    private Class desiredChildViewClass;
    private Object desiredChildViewModel;
    private int desiredChildViewType;

    public ContentSwitcherModel(int i, Class class1, Object obj)
    {
        desiredChildViewType = -1;
        desiredChildViewType = i;
        desiredChildViewClass = class1;
        desiredChildViewModel = obj;
    }

    public void copy(ContentSwitcherModel contentswitchermodel)
    {
        desiredChildViewClass = contentswitchermodel.getDesiredChildViewClass();
        desiredChildViewModel = contentswitchermodel.getDesiredChildViewModel();
        desiredChildViewType = contentswitchermodel.getDesiredChildViewType();
    }

    public Class getDesiredChildViewClass()
    {
        return desiredChildViewClass;
    }

    public Object getDesiredChildViewModel()
    {
        return desiredChildViewModel;
    }

    public int getDesiredChildViewType()
    {
        return desiredChildViewType;
    }

    public boolean isValid()
    {
        return desiredChildViewClass != null && desiredChildViewModel != null && desiredChildViewType >= 0 && desiredChildViewType < 25;
    }

    public void setDesiredChildViewClass(Class class1)
    {
        desiredChildViewClass = class1;
    }

    public void setDesiredChildViewModel(Object obj)
    {
        desiredChildViewModel = obj;
    }

    public void setDesiredChildViewType(int i)
    {
        desiredChildViewType = i;
    }
}
