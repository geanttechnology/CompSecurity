// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.app.SearchManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.view.q;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.common.TabbedFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.scan.SearchScanUpcFragment;
import com.target.ui.helper.o.c;
import com.target.ui.service.k;
import com.target.ui.util.ah;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.util.j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.search:
//            a, b

public class SearchContainerFragment extends TabbedFragment
{
    private class a
        implements android.support.v7.widget.SearchView.b
    {

        final SearchContainerFragment this$0;

        public boolean a()
        {
            com.target.ui.fragment.product.search.SearchContainerFragment.a(SearchContainerFragment.this);
            return true;
        }

        private a()
        {
            this$0 = SearchContainerFragment.this;
            super();
        }

    }

    private class b
        implements android.view.View.OnFocusChangeListener
    {

        final SearchContainerFragment this$0;

        public void onFocusChange(View view, boolean flag)
        {
            while (getView() == null || flag || SearchContainerFragment.b(SearchContainerFragment.this).length() == 1) 
            {
                return;
            }
            com.target.ui.util.e.a.a(SearchContainerFragment.this);
        }

        private b()
        {
            this$0 = SearchContainerFragment.this;
            super();
        }

    }

    private class c
        implements android.support.v7.widget.SearchView.c
    {

        final SearchContainerFragment this$0;

        public boolean a(String s)
        {
            com.target.ui.fragment.product.search.SearchContainerFragment.a(SearchContainerFragment.this, s);
            return false;
        }

        public boolean b(String s)
        {
            if (SearchContainerFragment.b(SearchContainerFragment.this).length() == 1 && com.target.mothership.util.o.c(s))
            {
                SearchContainerFragment.b(SearchContainerFragment.this, s);
                com.target.ui.fragment.product.search.SearchContainerFragment.c(SearchContainerFragment.this);
            } else
            if (SearchContainerFragment.b(SearchContainerFragment.this).length() <= 1 || !com.target.mothership.util.o.c(s))
            {
                com.target.ui.fragment.product.search.SearchContainerFragment.c(SearchContainerFragment.this, s);
                return false;
            }
            return false;
        }

        private c()
        {
            this$0 = SearchContainerFragment.this;
            super();
        }

    }

    private class d
        implements a.a
    {

        final SearchContainerFragment this$0;

        public void a()
        {
        }

        public void a(String s)
        {
        }

        public void b(String s)
        {
            SearchContainerFragment.d(SearchContainerFragment.this).a(s, false);
        }

        public void c(String s)
        {
            SearchContainerFragment.b(SearchContainerFragment.this, s);
            if (SearchContainerFragment.d(SearchContainerFragment.this) != null)
            {
                SearchContainerFragment.d(SearchContainerFragment.this).postDelayed(new Runnable() {

                    final d this$1;

                    public void run()
                    {
                        if (SearchContainerFragment.d(_fld0) == null)
                        {
                            return;
                        } else
                        {
                            com.target.ui.util.e.a.c(SearchContainerFragment.d(_fld0).findFocus());
                            return;
                        }
                    }

            
            {
                this$1 = d.this;
                super();
            }
                }, 500L);
                SearchContainerFragment.d(SearchContainerFragment.this).a(SearchContainerFragment.b(SearchContainerFragment.this), false);
            }
        }

        private d()
        {
            this$0 = SearchContainerFragment.this;
            super();
        }

    }


    private static final int ACTION_BAR_UPDATE_DELAY = 50;
    private static final float CLOSE_BUTTON_ALPHA = 0.5F;
    private static final String EVERYWHERE_TAG = "Everywhere";
    private static final String IN_STORE_TAG = "InStore";
    private static final int KEYBOARD_DELAY = 500;
    private static final int MIN_QUERY_LENGTH = 1;
    public static final String TAG = com/target/ui/fragment/product/search/SearchContainerFragment.getSimpleName();
    private boolean mHideActionMenu;
    private String mQueryText;
    private a.b mSearchBroadcastReceiverInstanceWrapper;
    private com.target.ui.helper.o.c mSearchDataHelper;
    private SearchView mSearchView;

    public SearchContainerFragment()
    {
        mQueryText = "";
        mHideActionMenu = false;
    }

    public static SearchContainerFragment a()
    {
        return new SearchContainerFragment();
    }

    private void a(SearchView searchview)
    {
        if (searchview == null)
        {
            return;
        } else
        {
            mSearchView = searchview;
            searchview.setSearchableInfo(((SearchManager)getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
            searchview.setIconifiedByDefault(false);
            searchview.setIconified(false);
            searchview.setSelected(true);
            searchview.setQueryHint(getString(0x7f0904ef));
            b(searchview);
            c(searchview);
            d(searchview);
            e(searchview);
            b();
            return;
        }
    }

    private void a(Menu menu, boolean flag)
    {
        Object obj = menu.findItem(0x7f1005ff);
        menu = menu.findItem(0x7f100615);
        if (obj == null || menu == null)
        {
            return;
        }
        obj = (SearchView)q.a(((MenuItem) (obj)));
        View view = ((SearchView) (obj)).findViewById(0x7f10009e);
        if (flag)
        {
            ((SearchView) (obj)).setIconified(false);
            ((SearchView) (obj)).setSelected(true);
            menu.setVisible(false);
            al.b(view);
            return;
        } else
        {
            menu.setVisible(true);
            al.c(view);
            ((SearchView) (obj)).setMaxWidth(getResources().getDimensionPixelSize(0x7f0a003e));
            return;
        }
    }

    static void a(SearchContainerFragment searchcontainerfragment)
    {
        searchcontainerfragment.o();
    }

    static void a(SearchContainerFragment searchcontainerfragment, String s)
    {
        searchcontainerfragment.a(s);
    }

    private void a(String s)
    {
        com.target.ui.util.e.a.a(this);
        mSearchDataHelper.a(s);
        s = new ProductSummaryParam(n(), null, null, s);
        m().d(ProductSummaryPageFragment.a(s, com.target.ui.util.g.a.a(false)));
    }

    static String b(SearchContainerFragment searchcontainerfragment)
    {
        return searchcontainerfragment.mQueryText;
    }

    static String b(SearchContainerFragment searchcontainerfragment, String s)
    {
        searchcontainerfragment.mQueryText = s;
        return s;
    }

    private void b()
    {
        mSearchView.setOnCloseListener(new a());
        mSearchView.setOnQueryTextListener(new c());
        mSearchView.setOnQueryTextFocusChangeListener(new b());
    }

    private void b(SearchView searchview)
    {
        searchview.a(mQueryText, false);
    }

    private void b(String s)
    {
        mQueryText = s;
        if (com.target.mothership.util.o.g(s))
        {
            if (s.length() == 1)
            {
                mHideActionMenu = true;
                getActivity().d();
            }
            com.target.ui.fragment.product.search.a.b(getActivity(), s);
            return;
        } else
        {
            p();
            return;
        }
    }

    private void c(SearchView searchview)
    {
        ((ImageView)searchview.findViewById(0x7f10009b)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, 0));
    }

    static void c(SearchContainerFragment searchcontainerfragment)
    {
        searchcontainerfragment.p();
    }

    static void c(SearchContainerFragment searchcontainerfragment, String s)
    {
        searchcontainerfragment.b(s);
    }

    static SearchView d(SearchContainerFragment searchcontainerfragment)
    {
        return searchcontainerfragment.mSearchView;
    }

    private void d(SearchView searchview)
    {
        searchview = searchview.findViewById(0x7f10009e);
        al.c(searchview);
        searchview.setAlpha(0.5F);
        searchview.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchContainerFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.product.search.SearchContainerFragment.a(SearchContainerFragment.this);
            }

            
            {
                this$0 = SearchContainerFragment.this;
                super();
            }
        });
    }

    private void e(SearchView searchview)
    {
        searchview = (AutoCompleteTextView)searchview.findViewById(0x7f10009d);
        searchview.setTypeface(ah.a(getActivity(), com.target.ui.util.ah.a.REGULAR));
        searchview.setLongClickable(false);
        searchview.setInputType(0x10000);
        if (j.b())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Field field = android/widget/TextView.getDeclaredField("mCursorDrawableRes");
        field.setAccessible(true);
        field.set(searchview, Integer.valueOf(0x7f02021d));
        return;
        searchview;
        com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Error when setting SearchView cursor by reflection : ").append(searchview.getMessage()).toString());
        return;
    }

    private void k()
    {
        if (mSearchView == null)
        {
            return;
        } else
        {
            mSearchView.setOnCloseListener(null);
            mSearchView.setOnQueryTextListener(null);
            mSearchView.setOnQueryTextFocusChangeListener(null);
            return;
        }
    }

    private void l()
    {
        com.target.ui.util.e.a.a(this);
        m().d(SearchScanUpcFragment.a(n()));
    }

    private Store n()
    {
        return (Store)com.target.ui.service.k.a().c().d();
    }

    private void o()
    {
        if (mSearchView == null || getActivity() == null)
        {
            return;
        } else
        {
            mQueryText = "";
            p();
            return;
        }
    }

    private void p()
    {
        mHideActionMenu = false;
        getActivity().d();
        com.target.ui.fragment.product.search.a.a(getActivity());
    }

    protected List c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new com.target.ui.fragment.common.TabbedFragment.b(com.target.ui.fragment.product.search.b.a(b.a.PRODUCTS), getString(0x7f0904eb)));
        return arraylist;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSearchDataHelper = new com.target.ui.helper.o.c();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j("");
            menuinflater.inflate(0x7f120017, menu);
            a((SearchView)q.a(menu.findItem(0x7f1005ff)));
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSearchDataHelper = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        k();
        mSearchView = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131756565 2131756565: default 24
    //                   2131756565 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        l();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        a(menu, mHideActionMenu);
        super.onPrepareOptionsMenu(menu);
    }

    public void onStart()
    {
        super.onStart();
        mSearchBroadcastReceiverInstanceWrapper = com.target.ui.fragment.product.search.a.a(getActivity(), new d());
    }

    public void onStop()
    {
        super.onStop();
        com.target.ui.fragment.product.search.a.a(getActivity(), mSearchBroadcastReceiverInstanceWrapper);
    }

}
