// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.droidparts.adapter.widget;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.droidparts.Injector;
import org.droidparts.contract.AlterableContent;

public class ArrayAdapter extends android.widget.ArrayAdapter
    implements AlterableContent
{

    private LayoutInflater layoutInflater;

    public ArrayAdapter(Context context)
    {
        this(context, ((List) (new ArrayList())));
    }

    public ArrayAdapter(Context context, int i, int j, List list)
    {
        super(context, i, j, list);
        Injector.inject(context, this);
    }

    public ArrayAdapter(Context context, int i, List list)
    {
        this(context, i, 0x1020014, list);
    }

    public ArrayAdapter(Context context, List list)
    {
        this(context, 0x1090003, list);
    }

    protected LayoutInflater getLayoutInflater()
    {
        return layoutInflater;
    }

    public volatile void setContent(Object obj)
    {
        setContent((Collection)obj);
    }

    public void setContent(Collection collection)
    {
        setNotifyOnChange(false);
        clear();
        for (collection = collection.iterator(); collection.hasNext(); add(collection.next())) { }
        notifyDataSetChanged();
    }
}
