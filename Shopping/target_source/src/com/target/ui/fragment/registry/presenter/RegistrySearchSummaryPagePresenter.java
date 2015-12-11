// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.registries.interfaces.RegistrySearchSummary;
import com.target.mothership.model.registries.interfaces.RegistrySearchWrapper;
import com.target.mothership.services.x;
import com.target.ui.fragment.registry.a.f;
import com.target.ui.g.a;
import com.target.ui.model.registry.RegistryRefineModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistrySearchSummaryPagePresenter
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

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        int currentPageNumber;
        RegistryRefineModel model;
        int pageSize;
        String registrySearchName;
        List registrySummaryList;
        RegistrySearchParam searchParam;
        int totalRecordCount;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(pageSize);
            parcel.writeInt(totalRecordCount);
            parcel.writeInt(currentPageNumber);
            parcel.writeString(registrySearchName);
            parcel.writeList(registrySummaryList);
            parcel.writeParcelable(searchParam, 0);
            parcel.writeParcelable(model, 0);
        }


        public SavedState()
        {
            pageSize = 0;
            totalRecordCount = 0;
            currentPageNumber = 0;
        }

        protected SavedState(Parcel parcel)
        {
            pageSize = 0;
            totalRecordCount = 0;
            currentPageNumber = 0;
            pageSize = parcel.readInt();
            totalRecordCount = parcel.readInt();
            currentPageNumber = parcel.readInt();
            registrySearchName = parcel.readString();
            registrySummaryList = new ArrayList();
            parcel.readList(registrySummaryList, com/target/mothership/model/registries/interfaces/RegistryProductDetails.getClassLoader());
            searchParam = (RegistrySearchParam)parcel.readParcelable(com/target/mothership/common/params/RegistrySearchParam.getClassLoader());
            model = (RegistryRefineModel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel.getClassLoader());
        }
    }

    private class a
        implements com.target.ui.helper.l.a.c
    {

        final RegistrySearchSummaryPagePresenter this$0;

        public void a()
        {
            if (com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this) == null)
            {
                return;
            } else
            {
                RegistrySearchSummaryPagePresenter.c(RegistrySearchSummaryPagePresenter.this);
                return;
            }
        }

        public void a(RegistrySearchWrapper registrysearchwrapper)
        {
            if (com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this) == null)
            {
                return;
            }
            if (registrysearchwrapper == null)
            {
                com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this).a(0x7f0904b4, 0x7f0904b3, true);
                return;
            } else
            {
                com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this, registrysearchwrapper);
                RegistrySearchSummaryPagePresenter.b(RegistrySearchSummaryPagePresenter.this);
                return;
            }
        }

        public void a(x x)
        {
            if (com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter.a(RegistrySearchSummaryPagePresenter.this, x);
                return;
            }
        }

        private a()
        {
            this$0 = RegistrySearchSummaryPagePresenter.this;
            super();
        }

    }


    private static final int DEFAULT_LIMIT = 20;
    private static final int DEFAULT_OFFSET = 0;
    public static final int INVALID_RES = 0;
    private com.target.ui.helper.l.a mDataHelper;
    private f mPresentation;
    private int mSavedCurrentPageNumber;
    private int mSavedPageSize;
    private RegistryRefineModel mSavedRegistryRefineModel;
    private String mSavedRegistrySearchName;
    private RegistrySearchParam mSavedRegistrySearchParam;
    private List mSavedRegistrySummaryList;
    private int mSavedTotalRecordCount;

    public RegistrySearchSummaryPagePresenter(com.target.ui.helper.l.a a1, RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel, Parcelable parcelable)
    {
        mSavedPageSize = 0;
        mSavedTotalRecordCount = 0;
        mSavedCurrentPageNumber = 0;
        mSavedRegistrySummaryList = new ArrayList();
        mDataHelper = a1;
        mSavedRegistrySearchParam = registrysearchparam;
        mSavedRegistryRefineModel = registryrefinemodel;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    static f a(RegistrySearchSummaryPagePresenter registrysearchsummarypagepresenter)
    {
        return registrysearchsummarypagepresenter.mPresentation;
    }

    private void a(int i1)
    {
        mPresentation.a(true);
        mSavedRegistrySearchParam.b(Integer.valueOf(b(i1)));
        mSavedRegistrySearchParam.a(Integer.valueOf(h()));
        a(mSavedRegistrySearchParam);
    }

    private void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedPageSize = ((SavedState) (parcelable)).pageSize;
        mSavedTotalRecordCount = ((SavedState) (parcelable)).totalRecordCount;
        mSavedCurrentPageNumber = ((SavedState) (parcelable)).currentPageNumber;
        mSavedRegistrySearchName = ((SavedState) (parcelable)).registrySearchName;
        mSavedRegistrySummaryList = ((SavedState) (parcelable)).registrySummaryList;
        mSavedRegistrySearchParam = ((SavedState) (parcelable)).searchParam;
        mSavedRegistryRefineModel = ((SavedState) (parcelable)).model;
    }

    private void a(RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.p().b() && ((Integer)registrysearchparam.p().c()).intValue() > 0)
        {
            mPresentation.a(true);
        }
        mDataHelper.a(registrysearchparam, new a());
    }

    private void a(RegistrySearchWrapper registrysearchwrapper)
    {
        StringBuilder stringbuilder;
        mSavedPageSize = registrysearchwrapper.a().intValue();
        mSavedTotalRecordCount = registrysearchwrapper.b().intValue();
        mSavedCurrentPageNumber = registrysearchwrapper.c().intValue();
        stringbuilder = new StringBuilder();
        stringbuilder.append(mSavedRegistrySearchParam.a());
        stringbuilder.append(" ");
        stringbuilder.append(mSavedRegistrySearchParam.b());
        mSavedRegistrySearchName = stringbuilder.toString();
        this;
        JVM INSTR monitorenter ;
        RegistrySearchSummary registrysearchsummary;
        for (registrysearchwrapper = registrysearchwrapper.d().iterator(); registrysearchwrapper.hasNext(); mSavedRegistrySummaryList.add(registrysearchsummary))
        {
            registrysearchsummary = (RegistrySearchSummary)registrysearchwrapper.next();
        }

        break MISSING_BLOCK_LABEL_138;
        registrysearchwrapper;
        this;
        JVM INSTR monitorexit ;
        throw registrysearchwrapper;
        this;
        JVM INSTR monitorexit ;
    }

    private void a(x x)
    {
        if (mSavedCurrentPageNumber > 0)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(0x7f0904b4, 0x7f0904b3, false);
            return;
        }
    }

    static void a(RegistrySearchSummaryPagePresenter registrysearchsummarypagepresenter, RegistrySearchWrapper registrysearchwrapper)
    {
        registrysearchsummarypagepresenter.a(registrysearchwrapper);
    }

    static void a(RegistrySearchSummaryPagePresenter registrysearchsummarypagepresenter, x x)
    {
        registrysearchsummarypagepresenter.a(x);
    }

    private boolean a(int i1, int j1, int k1)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        if (k1 < i())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (j1 > 0)
        {
            flag1 = flag3;
            if (flag)
            {
                if (i1 + j1 >= k1 - j() / 2)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0 && !k())
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

    private int b(int i1)
    {
        return mSavedPageSize * i1;
    }

    static void b(RegistrySearchSummaryPagePresenter registrysearchsummarypagepresenter)
    {
        registrysearchsummarypagepresenter.m();
    }

    static void c(RegistrySearchSummaryPagePresenter registrysearchsummarypagepresenter)
    {
        registrysearchsummarypagepresenter.n();
    }

    private void g()
    {
        mPresentation.b();
        mPresentation.d(false);
        mSavedRegistrySearchParam.b(Integer.valueOf(0));
        mSavedRegistrySearchParam.a(Integer.valueOf(20));
        a(mSavedRegistrySearchParam);
    }

    private int h()
    {
        return mSavedPageSize;
    }

    private int i()
    {
        return mSavedTotalRecordCount;
    }

    private int j()
    {
        return mSavedPageSize;
    }

    private boolean k()
    {
        return mDataHelper.c();
    }

    private boolean l()
    {
        return mSavedRegistrySummaryList != null && !mSavedRegistrySummaryList.isEmpty();
    }

    private void m()
    {
        mPresentation.a(false);
        mPresentation.d(true);
        mPresentation.a(mSavedRegistrySummaryList);
        mPresentation.a(mSavedTotalRecordCount, mSavedRegistrySearchName);
    }

    private void n()
    {
        if (mSavedCurrentPageNumber > 0)
        {
            mPresentation.c(true);
            return;
        } else
        {
            mPresentation.a();
            return;
        }
    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        if (i2 >= 0);
        if (a(i1, j1, k1))
        {
            a(mSavedCurrentPageNumber);
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900cf);
    }

    public void a(RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel)
    {
        mSavedRegistrySearchParam = registrysearchparam;
        mSavedRegistryRefineModel = registryrefinemodel;
        mSavedRegistrySummaryList.clear();
        mSavedTotalRecordCount = 0;
        mSavedCurrentPageNumber = 0;
        mSavedPageSize = 0;
        mSavedRegistrySearchName = null;
        if (mPresentation == null)
        {
            return;
        } else
        {
            g();
            return;
        }
    }

    public void a(RegistrySearchSummary registrysearchsummary)
    {
        mPresentation.a(registrysearchsummary);
    }

    public void a(f f1)
    {
        mPresentation = f1;
        mPresentation.c();
        if (l())
        {
            mPresentation.d(true);
            mPresentation.a(mSavedRegistrySummaryList);
            mPresentation.a(mSavedTotalRecordCount, mSavedRegistrySearchName);
            return;
        } else
        {
            mPresentation.b();
            g();
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((f)obj);
    }

    public void c()
    {
        mPresentation.b();
        a(mSavedRegistrySearchParam);
    }

    public void d()
    {
        mPresentation.a(true);
        a(mSavedRegistrySearchParam);
    }

    public void e()
    {
        mPresentation.a(mSavedRegistryRefineModel);
    }

    public Parcelable f()
    {
        SavedState savedstate = new SavedState();
        savedstate.pageSize = mSavedPageSize;
        savedstate.totalRecordCount = mSavedTotalRecordCount;
        savedstate.currentPageNumber = mSavedCurrentPageNumber;
        savedstate.registrySearchName = mSavedRegistrySearchName;
        savedstate.registrySummaryList = mSavedRegistrySummaryList;
        savedstate.searchParam = mSavedRegistrySearchParam;
        savedstate.model = mSavedRegistryRefineModel;
        return savedstate;
    }

    public void v_()
    {
    }

    public void z_()
    {
        mDataHelper.a();
        mPresentation = null;
    }
}
