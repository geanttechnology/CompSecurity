// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.PageItemCollection;
import com.target.ui.analytics.a.av;
import com.target.ui.f.c;
import com.target.ui.util.ai;
import com.target.ui.util.y;
import com.target.ui.view.ToolbarSpinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public class ChildPageItemFragment extends PageItemFragment
{
    private class a
        implements com.target.ui.view.ToolbarSpinner.a
    {

        final ChildPageItemFragment this$0;

        public void a(int i)
        {
            Object obj = (PageItem)ChildPageItemFragment.a(ChildPageItemFragment.this).get(i);
            if (y.a(ChildPageItemFragment.b(ChildPageItemFragment.this), ((PageItem) (obj))))
            {
                return;
            }
            obj = y.a(((PageItem) (obj)), q(), ChildPageItemFragment.a(ChildPageItemFragment.this), p());
            if (obj == null)
            {
                ai.a(getActivity(), "Unable to navigate to category");
                return;
            } else
            {
                m().d(((android.support.v4.app.Fragment) (obj)));
                return;
            }
        }

        private a()
        {
            this$0 = ChildPageItemFragment.this;
            super();
        }

    }


    private static final String ARG_CURRENT_PAGE = "currentPage";
    private static final String ARG_SIBLING_PAGES = "siblingPages";
    private static final int MINIMUM_SIBLINGS_FOR_DROPDOWN = 1;
    private PageItem mCurrentPage;
    private List mSiblingPages;

    public ChildPageItemFragment()
    {
        mSiblingPages = new ArrayList();
    }

    public static ChildPageItemFragment a(PageItem pageitem, List list)
    {
        a(pageitem);
        ChildPageItemFragment childpageitemfragment = new ChildPageItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("currentPage", pageitem);
        if (list != null)
        {
            bundle.putParcelableArrayList("siblingPages", new ArrayList(list));
        }
        childpageitemfragment.setArguments(bundle);
        childpageitemfragment.a(false);
        return childpageitemfragment;
    }

    static List a(ChildPageItemFragment childpageitemfragment)
    {
        return childpageitemfragment.mSiblingPages;
    }

    private static void a(PageItem pageitem)
    {
        if (!pageitem.c().b())
        {
            throw new IllegalArgumentException("currentPage must have child items");
        } else
        {
            return;
        }
    }

    static PageItem b(ChildPageItemFragment childpageitemfragment)
    {
        return childpageitemfragment.mCurrentPage;
    }

    private void d()
    {
        av.a(p()).e();
    }

    protected void a(ToolbarSpinner toolbarspinner)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mSiblingPages.iterator(); iterator.hasNext(); arraylist.add(y.a((PageItem)iterator.next()))) { }
        toolbarspinner.setItems(arraylist);
        toolbarspinner.setSelectedItem(y.a(mSiblingPages, mCurrentPage));
        toolbarspinner.setListener(new a());
    }

    protected boolean aa()
    {
        return mSiblingPages != null && mSiblingPages.size() > 1;
    }

    protected PageItemFragment.b b()
    {
        return PageItemFragment.b.CATEGORIES;
    }

    protected void c()
    {
        if (mSiblingPages != null && mSiblingPages.size() > 1)
        {
            j("");
            return;
        }
        String s = y.a(mCurrentPage);
        if (s.equals("") && ((PageItemCollection)mCurrentPage.c().c()).b().b())
        {
            s = (String)((PageItemCollection)mCurrentPage.c().c()).b().c();
        }
        j(s);
    }

    public void e()
    {
        d();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mCurrentPage = (PageItem)getArguments().getParcelable("currentPage");
        mSiblingPages = y.a(getArguments().getParcelableArrayList("siblingPages"));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f120005, menu);
            super.onCreateOptionsMenu(menu, menuinflater);
            b(false);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            S();
            break;
        }
        return true;
    }

    protected void y_()
    {
        a(((PageItemCollection)mCurrentPage.c().c()).a());
        d();
    }
}
