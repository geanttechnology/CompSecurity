// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.foound.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;

// Referenced classes of package com.foound.widget:
//            AmazingListView, b

public abstract class a extends BaseAdapter
    implements android.widget.AbsListView.OnScrollListener, SectionIndexer
{

    public static final String a = com/foound/widget/a.getSimpleName();
    int b;
    int c;
    boolean d;
    b e;

    public a()
    {
        b = 1;
        c = 1;
        d = false;
    }

    public int a(int i)
    {
        if (i < 0 || getCount() == 0)
        {
            return 0;
        }
        int j = getPositionForSection(getSectionForPosition(i) + 1);
        return j == -1 || i != j - 1 ? 1 : 2;
    }

    public abstract View a(int i, View view, ViewGroup viewgroup);

    public abstract void a(View view, int i, int j);

    protected abstract void a(View view, int i, boolean flag);

    void a(b b1)
    {
        e = b1;
    }

    protected abstract void b(int i);

    public abstract int getPositionForSection(int i);

    public abstract int getSectionForPosition(int i);

    public abstract Object[] getSections();

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = a(i, view, viewgroup);
        if (i == getCount() - 1 && d)
        {
            b(b + 1);
        }
        boolean flag;
        if (getPositionForSection(getSectionForPosition(i)) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view, i, flag);
        return view;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (abslistview instanceof AmazingListView)
        {
            ((AmazingListView)abslistview).c(i);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

}
