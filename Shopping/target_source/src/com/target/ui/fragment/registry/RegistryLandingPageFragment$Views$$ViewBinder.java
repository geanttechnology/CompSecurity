// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.registry.RegistryAdvancedSearchButton;
import com.target.ui.view.registry.RegistryNameView;

public class 
    implements butterknife.t.Views..ViewBinder
{

    public void bind(butterknife.t.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (RegistryNameView)viewbinder.nameView((View)viewbinder.nameView(obj, 0x7f1001e4, "field 'nameView'"), 0x7f1001e4, "field 'nameView'");
        .chButtonView = (RegistryAdvancedSearchButton)viewbinder.advancedSearchButtonView((View)viewbinder.advancedSearchButtonView(obj, 0x7f1001e5, "field 'advancedSearchButtonView'"), 0x7f1001e5, "field 'advancedSearchButtonView'");
        .View = (Button)viewbinder.searchButtonView((View)viewbinder.searchButtonView(obj, 0x7f1001e7, "field 'searchButtonView'"), 0x7f1001e7, "field 'searchButtonView'");
        .ageRegistry = (TextView)viewbinder.createAndManageRegistry((View)viewbinder.createAndManageRegistry(obj, 0x7f1001e8, "field 'createAndManageRegistry'"), 0x7f1001e8, "field 'createAndManageRegistry'");
    }

    public volatile void bind(butterknife.t.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.chButtonView = null;
        bind1.View = null;
        bind1.ageRegistry = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
