// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ProgressBar)viewbinder.progressBar((View)viewbinder.progressBar(obj, 0x7f1004ab, "field 'progressBar'"), 0x7f1004ab, "field 'progressBar'");
        .ner = (View)viewbinder.buttonContainer(obj, 0x7f1004ac, "field 'buttonContainer'");
        .ner = (ImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f1004ad, "field 'imageView'"), 0x7f1004ad, "field 'imageView'");
        .ner = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1004ae, "field 'title'"), 0x7f1004ae, "field 'title'");
        .ner = (TextView)viewbinder.subTitle((View)viewbinder.subTitle(obj, 0x7f1004af, "field 'subTitle'"), 0x7f1004af, "field 'subTitle'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.ner = null;
        bind1.ner = null;
        bind1.ner = null;
        bind1.ner = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
