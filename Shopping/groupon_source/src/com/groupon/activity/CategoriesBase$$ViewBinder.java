// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            CategoriesBase, GrouponListActivity

public class nder extends nder
{

    public void bind(butterknife.ewBinder ewbinder, CategoriesBase categoriesbase, Object obj)
    {
        super.bind(ewbinder, categoriesbase, obj);
        categoriesbase.listView = (ListView)ewbinder.((View)ewbinder.iredView(obj, 0x102000a, "field 'listView'"), 0x102000a, "field 'listView'");
        categoriesbase.progress = (ProgressBar)ewbinder.((View)ewbinder.iredView(obj, 0x7f100186, "field 'progress'"), 0x7f100186, "field 'progress'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        bind(ewbinder, (CategoriesBase)grouponlistactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (CategoriesBase)obj, obj1);
    }

    public void unbind(CategoriesBase categoriesbase)
    {
        super.unbind(categoriesbase);
        categoriesbase.listView = null;
        categoriesbase.progress = null;
    }

    public volatile void unbind(GrouponListActivity grouponlistactivity)
    {
        unbind((CategoriesBase)grouponlistactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((CategoriesBase)obj);
    }

    public nder()
    {
    }
}
