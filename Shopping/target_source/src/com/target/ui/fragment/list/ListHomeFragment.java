// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.list.a.b;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.util.a;
import com.target.ui.util.ai;
import com.target.ui.util.k;
import com.target.ui.view.RecyclerViewScroll;
import com.target.ui.view.common.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDetailFragment, ListDialogFragment

public class ListHomeFragment extends BaseNavigationFragment
    implements com.target.mothership.model.list.k.b, com.target.ui.adapter.list.b.a, ListDialogFragment.b, b
{
    static class Views extends com.target.ui.view.a
    {

        RecyclerViewScroll mRecyclerView;

        Views(View view)
        {
            super(view);
        }
    }


    public static final String TAG = "ListHomeFragment";
    private com.target.ui.adapter.list.b mAdapter;
    private com.target.mothership.model.list.k mListSyncService;
    private com.target.ui.fragment.list.presenter.a mPresenter;
    private h mSnackBar;
    private Views mViews;

    static com.target.ui.fragment.list.presenter.a a(ListHomeFragment listhomefragment)
    {
        return listhomefragment.mPresenter;
    }

    private void d()
    {
        String s = getResources().getString(0x7f0903b4);
        int i = mAdapter.a();
        s = String.format(s, new Object[] {
            getResources().getQuantityString(0x7f110005, i, new Object[] {
                Integer.valueOf(i)
            })
        });
        if (getView() != null)
        {
            getView().setContentDescription(s);
        }
        mViews.mRecyclerView.setContentDescription(s);
        mViews.mRecyclerView.requestFocus();
    }

    private void e()
    {
        String s = getResources().getString(0x7f0903b5);
        int i = mAdapter.a();
        s = String.format(s, new Object[] {
            getResources().getQuantityString(0x7f110005, i, new Object[] {
                Integer.valueOf(i)
            })
        });
        mViews.mRecyclerView.setContentDescription(s);
        mViews.mRecyclerView.requestFocus();
    }

    private void f(ListCollectionItem listcollectionitem)
    {
        listcollectionitem = String.format(getString(0x7f090390), new Object[] {
            listcollectionitem.b()
        });
        com.target.ui.util.a.a(getActivity(), mViews.mRecyclerView, listcollectionitem);
    }

    public void a(int i)
    {
        j(getActivity().getApplicationContext().getString(i));
    }

    public void a(ListSummary listsummary)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            listsummary = new ListCollectionItem(listsummary, getActivity());
            mAdapter.a(listsummary);
            return;
        }
    }

    public void a(ListCollectionItem listcollectionitem)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            listcollectionitem = com.target.ui.fragment.list.ListDetailFragment.a(listcollectionitem);
            m().d(listcollectionitem);
            return;
        }
    }

    public void a(ListCollectionItem listcollectionitem, int i)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mPresenter.a(listcollectionitem, i);
            return;
        }
    }

    public void a(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            ai.b(this, s);
            return;
        }
    }

    public void a(List list)
    {
        if (mViews == null)
        {
            return;
        }
        mAdapter.h();
        for (list = list.iterator(); list.hasNext(); a((ListSummary)list.next())) { }
        d();
    }

    public void a(boolean flag)
    {
        mPresenter.a(flag);
    }

    public boolean a()
    {
        return mPresenter.e();
    }

    public void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            e();
            return;
        }
    }

    public void b(int i)
    {
        a(getString(i));
    }

    public void b(ListCollectionItem listcollectionitem)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mPresenter.c(listcollectionitem);
            return;
        }
    }

    public void b(ListCollectionItem listcollectionitem, int i)
    {
        mPresenter.c(listcollectionitem, i);
    }

    public void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.a.CREATE, null, this).show(getFragmentManager(), getActivity().getString(0x7f0900d1));
            return;
        }
    }

    public void c(ListCollectionItem listcollectionitem)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mAdapter.a(listcollectionitem);
            e();
            return;
        }
    }

    public void c(ListCollectionItem listcollectionitem, int i)
    {
        mAdapter.a(listcollectionitem, i);
    }

    public void c(boolean flag)
    {
        mViews.mRecyclerView.b(flag);
    }

    public void d(ListCollectionItem listcollectionitem)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mAdapter.d(listcollectionitem);
            return;
        }
    }

    public void d(final ListCollectionItem item, final int position)
    {
        e();
        String s = String.format(getString(0x7f0903b2), new Object[] {
            item.b()
        });
        mSnackBar.a(s, getString(0x7f09051e), new com.target.ui.view.common.h.b() {

            final ListHomeFragment this$0;
            final ListCollectionItem val$item;
            final int val$position;

            public void a()
            {
                com.target.ui.fragment.list.ListHomeFragment.a(ListHomeFragment.this).b(item, position);
            }

            public void b()
            {
                com.target.ui.fragment.list.ListHomeFragment.a(ListHomeFragment.this).b(item);
            }

            
            {
                this$0 = ListHomeFragment.this;
                item = listcollectionitem;
                position = i;
                super();
            }
        });
        f(item);
    }

    public void e(ListCollectionItem listcollectionitem)
    {
        listcollectionitem = String.format(getString(0x7f090392), new Object[] {
            listcollectionitem.b()
        });
        com.target.ui.util.a.a(getActivity(), mViews.mRecyclerView, listcollectionitem);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.list.presenter.a(new com.target.ui.helper.j.a());
        mPresenter.d();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f12000e, menu);
            mPresenter.a(menu, menuinflater);
            b(true);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030062, viewgroup, false);
        mViews = new Views(layoutinflater);
        mAdapter = new com.target.ui.adapter.list.b(new ArrayList(), this, mViews.mRecyclerView);
        mViews.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mViews.mRecyclerView.setAdapter(mAdapter);
        mViews.mRecyclerView.setItemAnimator(new com.target.ui.a.a());
        mViews.mRecyclerView.a(new k(getActivity(), 1));
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
        mPresenter.z_();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756554: 
            mPresenter.f();
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (mSnackBar != null)
        {
            mSnackBar.a();
            mSnackBar = null;
        }
    }

    public void onResume()
    {
        super.onResume();
        mSnackBar = new h(getActivity());
    }
}
