// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ViewItemDataManager;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemFragmentSellerUtil

static final class val.resources
    implements android.content.er
{

    final Fragment val$fragment;
    final Item val$item;
    final Resources val$resources;
    final ViewItemDataManager val$viewItemDataManager;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ViewItemFragmentSellerUtil.access$000(val$item, val$fragment, val$viewItemDataManager, val$resources);
    }

    (Item item1, Fragment fragment1, ViewItemDataManager viewitemdatamanager, Resources resources1)
    {
        val$item = item1;
        val$fragment = fragment1;
        val$viewItemDataManager = viewitemdatamanager;
        val$resources = resources1;
        super();
    }
}
