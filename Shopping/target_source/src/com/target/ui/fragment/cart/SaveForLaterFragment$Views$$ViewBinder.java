// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .tainer = (View)viewbinder.emptyListContainer(obj, 0x7f1001ff, "field 'emptyListContainer'");
        .maryHint = (TextView)viewbinder.emptyListPrimaryHint((View)viewbinder.emptyListPrimaryHint(obj, 0x7f100411, "field 'emptyListPrimaryHint'"), 0x7f100411, "field 'emptyListPrimaryHint'");
        .ondaryHint = (TextView)viewbinder.emptyListSecondaryHint((View)viewbinder.emptyListSecondaryHint(obj, 0x7f100412, "field 'emptyListSecondaryHint'"), 0x7f100412, "field 'emptyListSecondaryHint'");
        .ondaryHint = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f100200, "field 'errorView'"), 0x7f100200, "field 'errorView'");
        .ondaryHint = (RecyclerView)viewbinder.list((View)viewbinder.list(obj, 0x7f100201, "field 'list'"), 0x7f100201, "field 'list'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.tainer = null;
        bind1.maryHint = null;
        bind1.ondaryHint = null;
        bind1.ondaryHint = null;
        bind1.ondaryHint = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
