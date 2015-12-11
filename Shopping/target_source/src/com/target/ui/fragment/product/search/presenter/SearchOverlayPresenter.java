// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.g.a;
import com.target.ui.helper.o.b;
import com.target.ui.service.provider.q;
import java.util.ArrayList;
import java.util.List;

public class SearchOverlayPresenter
    implements com.target.ui.fragment.product.dialog.SearchHistoryClearDialog.b, a, com.target.ui.helper.o.a.c, com.target.ui.helper.o.b.a, com.target.ui.view.search.ExtendedSearchHistoryView.a, com.target.ui.view.search.SearchOverlayView.a, com.target.ui.view.search.SearchSuggestionCardView.b
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        String savedSearchTerm;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(savedSearchTerm);
        }


        public SavedState()
        {
        }

        private SavedState(Parcel parcel)
        {
            savedSearchTerm = parcel.readString();
        }

    }


    private String mInitialSearchTerm;
    private com.target.ui.fragment.product.search.a.a mPresentation;
    private com.target.ui.helper.o.a mProductSearchHistoryDataHelper;
    private b mProductSuggestionDataHelper;
    private q mRelevantStoreProvider;
    private String mSavedSearchTerm;

    public SearchOverlayPresenter(b b1, com.target.ui.helper.o.a a1, q q1, String s, Parcelable parcelable)
    {
        mProductSuggestionDataHelper = b1;
        mProductSearchHistoryDataHelper = a1;
        mRelevantStoreProvider = q1;
        mInitialSearchTerm = s;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    private ProductSummaryParam a(String s, Store store)
    {
        return new ProductSummaryParam(store, null, null, s);
    }

    private void d(String s)
    {
        mSavedSearchTerm = s;
        mPresentation.a(s);
        mProductSuggestionDataHelper.a(s, this);
    }

    private void f()
    {
        mProductSearchHistoryDataHelper.a(this);
    }

    public void a()
    {
        mPresentation.b();
    }

    public void a(int i, List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (i != -1)
        {
            mPresentation.a(0x7f0904ee);
            return;
        }
        if (list == null || list.isEmpty())
        {
            mPresentation.a(0x7f0904ee);
            return;
        } else
        {
            mPresentation.a((String)list.get(0));
            return;
        }
    }

    public void a(Parcelable parcelable)
    {
        mSavedSearchTerm = ((SavedState)parcelable).savedSearchTerm;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(x x, String s)
    {
    }

    public void a(com.target.ui.fragment.product.search.a.a a1)
    {
        b(a1);
        if (mSavedSearchTerm != null)
        {
            d(mSavedSearchTerm);
            return;
        }
        if (mInitialSearchTerm != null)
        {
            d(mInitialSearchTerm);
            return;
        } else
        {
            f();
            return;
        }
    }

    public void a(com.target.ui.model.search.a a1)
    {
        if (mPresentation == null)
        {
            return;
        }
        Object obj = a1.a();
        mProductSearchHistoryDataHelper.a(((String) (obj)));
        obj = a(((String) (obj)), (Store)mRelevantStoreProvider.a().d());
        if (a1.f().b())
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(a1.f().c());
            ((ProductSummaryParam) (obj)).a(arraylist);
        }
        mPresentation.a(((ProductSummaryParam) (obj)));
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.search.a.a)obj);
    }

    public void a(String s)
    {
        if (o.c(s))
        {
            return;
        } else
        {
            mProductSearchHistoryDataHelper.a(s);
            mPresentation.a(a(s, (Store)mRelevantStoreProvider.a().d()));
            return;
        }
    }

    public void a(List list)
    {
        if (o.f(mSavedSearchTerm))
        {
            return;
        }
        if (list.isEmpty())
        {
            mPresentation.a(false);
            mPresentation.b(false);
            mPresentation.c(false);
            return;
        } else
        {
            mPresentation.a(true);
            mPresentation.b(true);
            mPresentation.a(list);
            mPresentation.c(false);
            return;
        }
    }

    public void a(List list, String s)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (o.e(mSavedSearchTerm))
        {
            f();
            return;
        }
        if (list.isEmpty())
        {
            mPresentation.a(false);
            mPresentation.b(false);
            mPresentation.c(false);
            return;
        } else
        {
            mPresentation.a(true);
            mPresentation.b(false);
            mPresentation.c(true);
            mPresentation.b(list);
            return;
        }
    }

    public void a_(String s)
    {
        mPresentation.a(a(s, (Store)mRelevantStoreProvider.a().d()));
    }

    void b(com.target.ui.fragment.product.search.a.a a1)
    {
        mPresentation = a1;
    }

    public void b(String s)
    {
        mPresentation.a(s);
    }

    public void b_(String s)
    {
        mSavedSearchTerm = s;
        if (o.e(s))
        {
            f();
            return;
        } else
        {
            mProductSuggestionDataHelper.a(s, this);
            return;
        }
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mProductSearchHistoryDataHelper.b();
            mPresentation.a(new ArrayList());
            mPresentation.b(false);
            return;
        }
    }

    public void c(String s)
    {
    }

    public void c_(String s)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(s);
            return;
        }
    }

    public void d()
    {
        mPresentation.a(false);
        mPresentation.b(false);
    }

    public Parcelable e()
    {
        SavedState savedstate = new SavedState();
        savedstate.savedSearchTerm = mSavedSearchTerm;
        return savedstate;
    }

    public void u_()
    {
        mPresentation.f();
    }

    public void v_()
    {
    }

    public void w_()
    {
        mPresentation.a((Store)mRelevantStoreProvider.a().d());
    }

    public void x_()
    {
        mPresentation.a();
    }

    public void z_()
    {
        mProductSearchHistoryDataHelper.a();
        mProductSuggestionDataHelper.a();
        mPresentation = null;
    }
}
