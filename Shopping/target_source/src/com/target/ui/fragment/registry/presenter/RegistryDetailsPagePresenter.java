// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.model.registries.interfaces.RegistryDetailWrapper;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.c.d.d;
import com.target.ui.fragment.registry.a.c;
import com.target.ui.g.a;
import com.target.ui.view.BitmapImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistryDetailsPagePresenter
    implements com.target.ui.g.a
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int l)
            {
                return new SavedState[l];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int l)
            {
                return a(l);
            }

        };
        private int currentPageNumber;
        private int pageSize;
        private RegistryDetails registryDetails;
        private List registryProductDetailsList;
        private int totalRecordCount;

        static int a(SavedState savedstate)
        {
            return savedstate.pageSize;
        }

        static int a(SavedState savedstate, int l)
        {
            savedstate.pageSize = l;
            return l;
        }

        static RegistryDetails a(SavedState savedstate, RegistryDetails registrydetails)
        {
            savedstate.registryDetails = registrydetails;
            return registrydetails;
        }

        static List a(SavedState savedstate, List list)
        {
            savedstate.registryProductDetailsList = list;
            return list;
        }

        static int b(SavedState savedstate)
        {
            return savedstate.totalRecordCount;
        }

        static int b(SavedState savedstate, int l)
        {
            savedstate.totalRecordCount = l;
            return l;
        }

        static int c(SavedState savedstate)
        {
            return savedstate.currentPageNumber;
        }

        static int c(SavedState savedstate, int l)
        {
            savedstate.currentPageNumber = l;
            return l;
        }

        static RegistryDetails d(SavedState savedstate)
        {
            return savedstate.registryDetails;
        }

        static List e(SavedState savedstate)
        {
            return savedstate.registryProductDetailsList;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int l)
        {
            parcel.writeInt(pageSize);
            parcel.writeInt(totalRecordCount);
            parcel.writeInt(currentPageNumber);
            parcel.writeParcelable(registryDetails, 0);
            parcel.writeList(registryProductDetailsList);
        }


        public SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            pageSize = parcel.readInt();
            totalRecordCount = parcel.readInt();
            currentPageNumber = parcel.readInt();
            registryDetails = (RegistryDetails)parcel.readParcelable(com/target/mothership/model/registries/interfaces/RegistryDetails.getClassLoader());
            registryProductDetailsList = new ArrayList();
            parcel.readList(registryProductDetailsList, com/target/mothership/model/registries/interfaces/RegistryProductDetails.getClassLoader());
        }
    }

    private class a
        implements com.target.ui.helper.l.a.b
    {

        final RegistryDetailsPagePresenter this$0;

        public void a()
        {
            if (com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.a(RegistryDetailsPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.c(RegistryDetailsPagePresenter.this);
                return;
            }
        }

        public void a(RegistryDetailWrapper registrydetailwrapper)
        {
            if (com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.a(RegistryDetailsPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.a(RegistryDetailsPagePresenter.this, registrydetailwrapper);
                RegistryDetailsPagePresenter.b(RegistryDetailsPagePresenter.this);
                return;
            }
        }

        public void a(x x1)
        {
            if (com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.a(RegistryDetailsPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter.a(RegistryDetailsPagePresenter.this, x1);
                return;
            }
        }

        private a()
        {
            this$0 = RegistryDetailsPagePresenter.this;
            super();
        }

    }


    private static final int FIRST_PAGE = 1;
    public static final int INVALID_RES = 0;
    private com.target.ui.helper.l.a mDataHelper;
    private c mPresentation;
    private RegistryDetailsParam mRegistryDetailsParam;
    private int mSavedCurrentPageNumber;
    private int mSavedPageSize;
    private RegistryDetails mSavedRegistryDetails;
    private List mSavedRegistryProductDetailsList;
    private int mSavedTotalRecordCount;

    public RegistryDetailsPagePresenter(com.target.ui.helper.l.a a1, RegistryDetailsParam registrydetailsparam, Parcelable parcelable)
    {
        mSavedRegistryProductDetailsList = new ArrayList();
        mDataHelper = a1;
        mRegistryDetailsParam = registrydetailsparam;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    static c a(RegistryDetailsPagePresenter registrydetailspagepresenter)
    {
        return registrydetailspagepresenter.mPresentation;
    }

    private void a(int l)
    {
        mPresentation.a(true);
        mRegistryDetailsParam.a(l);
        a(mRegistryDetailsParam);
    }

    private void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedPageSize = com.target.ui.fragment.registry.presenter.SavedState.a(parcelable);
        mSavedTotalRecordCount = SavedState.b(parcelable);
        mSavedCurrentPageNumber = com.target.ui.fragment.registry.presenter.SavedState.c(parcelable);
        mSavedRegistryDetails = com.target.ui.fragment.registry.presenter.SavedState.d(parcelable);
        mSavedRegistryProductDetailsList = SavedState.e(parcelable);
    }

    private void a(RegistryDetailsParam registrydetailsparam)
    {
        mDataHelper.a(registrydetailsparam, new a());
    }

    private void a(RegistryDetailWrapper registrydetailwrapper)
    {
        mSavedPageSize = registrydetailwrapper.d();
        mSavedTotalRecordCount = registrydetailwrapper.e();
        mSavedCurrentPageNumber = registrydetailwrapper.c();
        mSavedRegistryDetails = registrydetailwrapper.a();
        this;
        JVM INSTR monitorenter ;
        RegistryProductDetails registryproductdetails;
        for (registrydetailwrapper = registrydetailwrapper.b().iterator(); registrydetailwrapper.hasNext(); mSavedRegistryProductDetailsList.add(registryproductdetails))
        {
            registryproductdetails = (RegistryProductDetails)registrydetailwrapper.next();
        }

        break MISSING_BLOCK_LABEL_92;
        registrydetailwrapper;
        this;
        JVM INSTR monitorexit ;
        throw registrydetailwrapper;
        this;
        JVM INSTR monitorexit ;
    }

    private void a(x x1)
    {
        if (mSavedCurrentPageNumber >= 1)
        {
            return;
        }
        if (x1 != null && z.NOT_FOUND.equals(x1.b()))
        {
            mPresentation.a(0x7f0904b4, 0, false);
            return;
        } else
        {
            mPresentation.a(0x7f0904b4, 0x7f0904b3, false);
            return;
        }
    }

    static void a(RegistryDetailsPagePresenter registrydetailspagepresenter, RegistryDetailWrapper registrydetailwrapper)
    {
        registrydetailspagepresenter.a(registrydetailwrapper);
    }

    static void a(RegistryDetailsPagePresenter registrydetailspagepresenter, x x1)
    {
        registrydetailspagepresenter.a(x1);
    }

    private boolean a(int l, int i1, int j1)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        if (j1 < g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (i1 > 0)
        {
            flag1 = flag3;
            if (flag)
            {
                if (l + i1 >= j1 - h() / 2)
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                if (l != 0 && !f())
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
            }
        }
        return flag1;
    }

    static void b(RegistryDetailsPagePresenter registrydetailspagepresenter)
    {
        registrydetailspagepresenter.j();
    }

    static void c(RegistryDetailsPagePresenter registrydetailspagepresenter)
    {
        registrydetailspagepresenter.k();
    }

    private boolean f()
    {
        return mDataHelper.b();
    }

    private int g()
    {
        return mSavedTotalRecordCount;
    }

    private int h()
    {
        return mSavedPageSize;
    }

    private boolean i()
    {
        return mSavedRegistryDetails != null && mSavedRegistryProductDetailsList != null && !mSavedRegistryProductDetailsList.isEmpty();
    }

    private void j()
    {
        if (mSavedCurrentPageNumber <= 1)
        {
            mPresentation.a(mSavedRegistryDetails.g());
            mPresentation.a(mSavedRegistryDetails, mSavedTotalRecordCount);
            mPresentation.b(mSavedRegistryDetails.g());
        }
        mPresentation.a(mSavedRegistryProductDetailsList);
        mPresentation.a(false);
    }

    private void k()
    {
        if (mSavedCurrentPageNumber < 1)
        {
            mPresentation.a();
            return;
        } else
        {
            mPresentation.c(true);
            return;
        }
    }

    public void a(int l, int i1, int j1, int k1, int l1)
    {
        if (a(l, i1, j1))
        {
            a(mSavedCurrentPageNumber);
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        if (i())
        {
            mPresentation.a(mSavedRegistryDetails.g());
            return;
        } else
        {
            mPresentation.a(0x7f0904a5);
            return;
        }
    }

    public void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, BitmapImageView bitmapimageview, Store store)
    {
        registryproductdetails = new d(registryproductdetails, registrydetails);
        registryproductdetails.a(bitmapimageview);
        registryproductdetails.a(store);
        mPresentation.a(registryproductdetails);
    }

    public void a(c c1)
    {
        mPresentation = c1;
        if (i())
        {
            mPresentation.a(mSavedRegistryProductDetailsList);
            mPresentation.a(mSavedRegistryDetails, mSavedTotalRecordCount);
            return;
        } else
        {
            mPresentation.b();
            a(mRegistryDetailsParam);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((c)obj);
    }

    public Parcelable c()
    {
        SavedState savedstate = new SavedState();
        com.target.ui.fragment.registry.presenter.SavedState.a(savedstate, mSavedPageSize);
        SavedState.b(savedstate, mSavedTotalRecordCount);
        com.target.ui.fragment.registry.presenter.SavedState.c(savedstate, mSavedCurrentPageNumber);
        com.target.ui.fragment.registry.presenter.SavedState.a(savedstate, mSavedRegistryDetails);
        com.target.ui.fragment.registry.presenter.SavedState.a(savedstate, mSavedRegistryProductDetailsList);
        return savedstate;
    }

    public void d()
    {
        mPresentation.b();
        a(mRegistryDetailsParam);
    }

    public void e()
    {
        mPresentation.a(true);
        a(mRegistryDetailsParam);
    }

    public void v_()
    {
        mDataHelper = null;
    }

    public void z_()
    {
        mDataHelper.a();
        mPresentation = null;
    }
}
