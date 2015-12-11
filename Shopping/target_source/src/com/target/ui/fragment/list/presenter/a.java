// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.fragment.list.a.b;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.service.g;
import java.util.List;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.j.c, com.target.ui.helper.j.e, com.target.ui.helper.j.f, com.target.ui.helper.j.g
{

    private boolean mIsEditMode;
    private com.target.ui.helper.j.a mListDataHelper;
    private b mPresentation;

    public a(com.target.ui.helper.j.a a1)
    {
        mListDataHelper = a1;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0903b3);
    }

    public void a(com.target.mothership.model.list.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(a1.g());
            return;
        }
    }

    public void a(b b1)
    {
        mPresentation = b1;
        mListDataHelper.a(this);
    }

    public void a(ListCollectionItem listcollectionitem)
    {
    }

    public void a(ListCollectionItem listcollectionitem, int i)
    {
        mPresentation.d(listcollectionitem, i);
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(List list)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(list);
            return;
        }
    }

    public void a(boolean flag)
    {
        mIsEditMode = flag;
        mPresentation.c(flag);
    }

    public void b(ListSummary listsummary)
    {
    }

    public void b(ListCollectionItem listcollectionitem)
    {
        try
        {
            mListDataHelper.a(listcollectionitem, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ListCollectionItem listcollectionitem)
        {
            mPresentation.b(0x7f0900e1);
        }
    }

    public void b(ListCollectionItem listcollectionitem, int i)
    {
        mPresentation.c(listcollectionitem, i);
        mPresentation.e(listcollectionitem);
    }

    public void c()
    {
    }

    public void c(ListCollectionItem listcollectionitem)
    {
        ListSummary listsummary = listcollectionitem.d();
        mListDataHelper.a(listsummary, listcollectionitem.b(), this);
    }

    public void c(ListCollectionItem listcollectionitem, int i)
    {
        mListDataHelper.a(listcollectionitem, i, this);
    }

    public void d()
    {
        g.a().b();
    }

    public boolean e()
    {
        return mIsEditMode;
    }

    public void f()
    {
        if (!mIsEditMode)
        {
            mPresentation.c();
        }
    }

    public void v_()
    {
        mListDataHelper = null;
    }

    public void z_()
    {
        mListDataHelper.a();
        mPresentation = null;
    }
}
