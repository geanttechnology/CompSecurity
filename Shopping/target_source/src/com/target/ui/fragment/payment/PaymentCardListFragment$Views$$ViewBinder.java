// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        .er = (TargetErrorView)viewbinder.errorContainer((View)viewbinder.errorContainer(obj, 0x7f1001a9, "field 'errorContainer'"), 0x7f1001a9, "field 'errorContainer'");
        .tainer = (View)viewbinder.emptyListContainer(obj, 0x7f1001aa, "field 'emptyListContainer'");
        .r = (View)viewbinder.listContainer(obj, 0x7f1001ab, "field 'listContainer'");
        .maryHint = (TextView)viewbinder.emptyListPrimaryHint((View)viewbinder.emptyListPrimaryHint(obj, 0x7f100411, "field 'emptyListPrimaryHint'"), 0x7f100411, "field 'emptyListPrimaryHint'");
        .ondaryHint = (TextView)viewbinder.emptyListSecondaryHint((View)viewbinder.emptyListSecondaryHint(obj, 0x7f100412, "field 'emptyListSecondaryHint'"), 0x7f100412, "field 'emptyListSecondaryHint'");
        .ist = (ListView)viewbinder.paymentCardList((View)viewbinder.paymentCardList(obj, 0x7f1001ac, "field 'paymentCardList'"), 0x7f1001ac, "field 'paymentCardList'");
        .ist = (Button)viewbinder.doneButton((View)viewbinder.doneButton(obj, 0x7f1001ad, "field 'doneButton'"), 0x7f1001ad, "field 'doneButton'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.er = null;
        bind1.tainer = null;
        bind1.r = null;
        bind1.maryHint = null;
        bind1.ondaryHint = null;
        bind1.ist = null;
        bind1.ist = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
