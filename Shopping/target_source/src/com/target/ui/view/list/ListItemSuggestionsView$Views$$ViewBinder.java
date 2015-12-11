// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;

// Referenced classes of package com.target.ui.view.list:
//            RecentItemsCardView

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        .View = (RecentItemsCardView)viewbinder.autoCompleteView((View)viewbinder.autoCompleteView(obj, 0x7f10045f, "field 'autoCompleteView'"), 0x7f10045f, "field 'autoCompleteView'");
        .onView = (View)viewbinder.listSuggestionView(obj, 0x7f10045e, "field 'listSuggestionView'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.View = null;
        bind1.onView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
