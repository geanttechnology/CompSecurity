// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.ImageView;
import com.target.ui.view.RecyclerViewScroll;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListItemSuggestionsView

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        .iew = (View)viewbinder.ew(obj, 0x7f100454, "field 'mListDetailView'");
        .ext = (TargetImeEditText)viewbinder.addItemEditText((View)viewbinder.ew(obj, 0x7f100457, "field 'addItemEditText'"), 0x7f100457, "field 'addItemEditText'");
        .ext = (View)viewbinder.ew(obj, 0x7f10045d, "field 'progressBar'");
        .w = (View)viewbinder.ew(obj, 0x7f100458, "field 'clearTextView'");
        .estionView = (ListItemSuggestionsView)viewbinder.ew((View)viewbinder.ew(obj, 0x7f10045c, "field 'listItemSuggestionView'"), 0x7f10045c, "field 'listItemSuggestionView'");
        .w = (ImageView)viewbinder.scanImageView((View)viewbinder.ew(obj, 0x7f10045a, "field 'scanImageView'"), 0x7f10045a, "field 'scanImageView'");
        . = (RecyclerViewScroll)viewbinder.recyclerView((View)viewbinder.ew(obj, 0x7f100187, "field 'recyclerView'"), 0x7f100187, "field 'recyclerView'");
        .w = (View)viewbinder.ew(obj, 0x7f100455, "field 'itemsMaskView'");
        .ingView = (View)viewbinder.ew(obj, 0x7f10045b, "field 'addItemBlockingView'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.iew = null;
        bind1.ext = null;
        bind1.ext = null;
        bind1.w = null;
        bind1.estionView = null;
        bind1.w = null;
        bind1. = null;
        bind1.w = null;
        bind1.ingView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
