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
import com.target.ui.fragment.registry.a.d;
import com.target.ui.g.a;
import com.target.ui.model.registry.RegistryRefineModel;

public class RegistryRefinePagePresenter
    implements a
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
        com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel eventLabel;
        RegistryRefineModel refineModel;
        RegistrySearchParam searchParam;
        com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel sortLabel;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(searchParam, 0);
            parcel.writeParcelable(refineModel, 0);
            parcel.writeParcelable(sortLabel, 0);
            parcel.writeParcelable(eventLabel, 0);
        }


        SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            searchParam = (RegistrySearchParam)parcel.readParcelable(com/target/mothership/common/params/RegistrySearchParam.getClassLoader());
            refineModel = (RegistryRefineModel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel.getClassLoader());
            sortLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel$RegistrySortLabel.getClassLoader());
            eventLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel$RegistryEventLabel.getClassLoader());
        }
    }


    private d mPresentation;
    private com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel mSavedEventLabel;
    private RegistryRefineModel mSavedRefineModel;
    private RegistrySearchParam mSavedSearchParam;
    private com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel mSavedSortLabel;

    public RegistryRefinePagePresenter(RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel, Parcelable parcelable)
    {
        mSavedSearchParam = registrysearchparam;
        mSavedRefineModel = registryrefinemodel;
        mSavedSortLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)mSavedRefineModel.c().d();
        mSavedEventLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)mSavedRefineModel.d().d();
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    private void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedSortLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)((SavedState) (parcelable)).refineModel.c().d();
        mSavedEventLabel = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)((SavedState) (parcelable)).refineModel.d().d();
        mSavedSearchParam = ((SavedState) (parcelable)).searchParam;
        mSavedRefineModel = ((SavedState) (parcelable)).refineModel;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900ce);
    }

    public void a(d d1)
    {
        mPresentation = d1;
        mPresentation.a();
        mPresentation.a(mSavedRefineModel);
    }

    public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        mSavedEventLabel = registryeventlabel;
    }

    public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        mSavedSortLabel = registrysortlabel;
    }

    public volatile void a(Object obj)
    {
        a((d)obj);
    }

    public void c()
    {
        mPresentation.c();
    }

    public void d()
    {
        mSavedSortLabel = null;
        mSavedEventLabel = null;
        mPresentation.b();
    }

    public void e()
    {
        mSavedRefineModel.a(mSavedEventLabel);
        mSavedRefineModel.a(mSavedSortLabel);
        mPresentation.b(mSavedRefineModel);
    }

    public void f()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d();
            return;
        }
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
