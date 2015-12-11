// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.ho;
import android.support.v7.ia;
import android.support.v7.ie;
import android.support.v7.is;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.models.Category;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.ui.widgets.SellButtonLayout;
import com.abtnprojects.ambatana.ui.widgets.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public class CategoryListingActivity extends b
    implements com.abtnprojects.ambatana.ui.widgets.SellButtonLayout.a
{

    private ie A;
    private int B;
    private ho C;
    List n;
    RecyclerView recyclerView;
    SellButtonLayout sellButtonLayout;

    public CategoryListingActivity()
    {
    }

    private List C()
    {
        int i = 0;
        String as[] = getResources().getStringArray(0x7f0e0001);
        ArrayList arraylist = new ArrayList(as.length);
        int j = 1;
        int j1 = as.length;
        int i1 = 0;
        for (; i < j1; i++)
        {
            arraylist.add(i1, new Category(j, as[i]));
            i1++;
            j++;
        }

        return arraylist;
    }

    private void D()
    {
        n = C();
        E();
    }

    private void E()
    {
        C = new ho(this, n);
        recyclerView.setAdapter(C);
        recyclerView.addOnItemTouchListener(new ia(new android.support.v7.ia.a() {

            final CategoryListingActivity a;

            public void a(View view, int i)
            {
                view = new ArrayList();
                view.add(Integer.valueOf(((Category)a.n.get(i)).getId()));
                a.v.setCategoryIds(view);
                is.a(a, a.v);
                a.setResult(-1);
                a.finish();
            }

            
            {
                a = CategoryListingActivity.this;
                super();
            }
        }, this));
    }

    static ho a(CategoryListingActivity categorylistingactivity)
    {
        return categorylistingactivity.C;
    }

    static int b(CategoryListingActivity categorylistingactivity)
    {
        return categorylistingactivity.B;
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            A = new ie(this);
            a(0x7f0200d1);
            b(0x7f040019);
            ButterKnife.bind(this);
            B = getResources().getInteger(0x7f0d0000);
            recyclerView.setHasFixedSize(false);
            recyclerView.addItemDecoration(new a(this));
            bundle = new GridLayoutManager(this, B, 1, false);
            bundle.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                final CategoryListingActivity a;

                public int getSpanSize(int i)
                {
                    switch (com.abtnprojects.ambatana.ui.activities.CategoryListingActivity.a(a).getItemViewType(i))
                    {
                    default:
                        return -1;

                    case 1: // '\001'
                        return CategoryListingActivity.b(a);

                    case 0: // '\0'
                        return 1;
                    }
                }

            
            {
                a = CategoryListingActivity.this;
                super();
            }
            });
            recyclerView.setLayoutManager(bundle);
            if (sellButtonLayout != null)
            {
                sellButtonLayout.setTapHandler(this);
            }
            D();
        }
    }

    protected void k()
    {
        setContentView(0x7f04001a);
    }

    public void l()
    {
        if (A != null)
        {
            A.a();
        }
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onResume()
    {
        super.onResume();
        if (n == null || n.isEmpty())
        {
            D();
        }
    }
}
