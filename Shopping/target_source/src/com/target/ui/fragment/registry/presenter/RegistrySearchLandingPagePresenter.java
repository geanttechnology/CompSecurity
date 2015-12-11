// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.util.o;
import com.target.ui.fragment.registry.a.e;
import com.target.ui.g.a;
import com.target.ui.util.validation.a.k;

public class RegistrySearchLandingPagePresenter
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
        String firstName;
        String lastName;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(firstName);
            parcel.writeString(lastName);
        }


        SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            firstName = parcel.readString();
            lastName = parcel.readString();
        }
    }


    private final com.target.ui.util.validation.validator.a mFirstNameValidator;
    private final com.target.ui.util.validation.validator.a mLastNameValidator;
    private e mPresentation;
    private String mSavedFirstName;
    private String mSavedLastName;

    public RegistrySearchLandingPagePresenter(com.target.ui.util.validation.validator.a a1, com.target.ui.util.validation.validator.a a2, Parcelable parcelable)
    {
        mFirstNameValidator = a1;
        mLastNameValidator = a2;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    private void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedFirstName = ((SavedState) (parcelable)).firstName;
        mSavedLastName = ((SavedState) (parcelable)).lastName;
    }

    public static boolean a(k k1)
    {
        return !k1.a();
    }

    private void b(k k1)
    {
        if (a(k1))
        {
            mPresentation.a(k1.b());
            return;
        } else
        {
            mPresentation.b();
            return;
        }
    }

    private k c(String s)
    {
        return mFirstNameValidator.a(s);
    }

    private void c(k k1)
    {
        if (a(k1))
        {
            mPresentation.b(k1.b());
            return;
        } else
        {
            mPresentation.c();
            return;
        }
    }

    private k d(String s)
    {
        return mLastNameValidator.a(s);
    }

    private void d()
    {
        b(c(mSavedFirstName));
        c(d(mSavedLastName));
        mPresentation.b(mSavedFirstName, mSavedLastName);
    }

    private void d(String s, String s1)
    {
        mPresentation.a(c(s, s1));
    }

    private boolean e()
    {
        return o.g(mSavedFirstName) || o.g(mSavedLastName);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900d0);
    }

    public void a(e e1)
    {
        mPresentation = e1;
        mPresentation.a();
        if (e())
        {
            d();
        }
        mPresentation.a(false);
        mPresentation.d();
    }

    public volatile void a(Object obj)
    {
        a((e)obj);
    }

    public void a(String s)
    {
        mSavedFirstName = s;
        b(c(s));
        d(mSavedFirstName, mSavedLastName);
    }

    public void a(String s, String s1)
    {
        s = new RegistrySearchParam(s, s1);
        mPresentation.a(s);
    }

    public void a(String s, boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            b(c(s));
            return;
        }
    }

    public void b(String s)
    {
        mSavedLastName = s;
        c(c(s));
        d(mSavedFirstName, mSavedLastName);
    }

    public void b(String s, String s1)
    {
        mPresentation.a(s, s1);
    }

    public void b(String s, boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            c(d(s));
            return;
        }
    }

    public Parcelable c()
    {
        SavedState savedstate = new SavedState();
        savedstate.firstName = mSavedFirstName;
        savedstate.lastName = mSavedLastName;
        return savedstate;
    }

    public boolean c(String s, String s1)
    {
        boolean flag = c(s).a();
        boolean flag1 = d(s1).a();
        return flag && flag1;
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
