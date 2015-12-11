// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.ui.model.list.ListCollectionItem;

public class g
{

    private static final String TAG = com/target/ui/service/g.getSimpleName();
    private static g sInstance;
    private ListCollectionItem mListCollectionItem;

    private g()
    {
    }

    public static g a()
    {
        if (sInstance == null)
        {
            sInstance = new g();
        }
        return sInstance;
    }

    public void a(ListCollectionItem listcollectionitem)
    {
        mListCollectionItem = listcollectionitem;
    }

    public void b()
    {
        mListCollectionItem = null;
    }

}
