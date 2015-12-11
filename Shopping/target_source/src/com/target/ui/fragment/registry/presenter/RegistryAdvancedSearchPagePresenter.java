// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.common.registries.c;
import com.target.mothership.util.o;
import com.target.ui.fragment.registry.a.b;
import com.target.ui.g.a;
import com.target.ui.util.validation.a.k;
import java.util.Calendar;
import java.util.Date;

public class RegistryAdvancedSearchPagePresenter
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
        Date endDate;
        String firstName;
        boolean isEmailValid;
        String lastName;
        Date startDate;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            long l2 = -1L;
            parcel.writeString(firstName);
            parcel.writeString(lastName);
            byte byte0;
            long l1;
            if (isEmailValid)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            if (startDate != null)
            {
                l1 = startDate.getTime();
            } else
            {
                l1 = -1L;
            }
            parcel.writeLong(l1);
            l1 = l2;
            if (endDate != null)
            {
                l1 = endDate.getTime();
            }
            parcel.writeLong(l1);
        }


        SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            Object obj = null;
            super();
            firstName = parcel.readString();
            lastName = parcel.readString();
            Date date;
            long l1;
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isEmailValid = flag;
            l1 = parcel.readLong();
            if (l1 == -1L)
            {
                date = null;
            } else
            {
                date = new Date(l1);
            }
            startDate = date;
            l1 = parcel.readLong();
            if (l1 == -1L)
            {
                parcel = obj;
            } else
            {
                parcel = new Date(l1);
            }
            endDate = parcel;
        }
    }


    private final com.target.ui.util.validation.validator.a mFirstNameValidator;
    private final com.target.ui.util.validation.validator.a mLastNameValidator;
    private b mPresentation;
    private Date mSavedEndDate;
    private String mSavedFirstName;
    private boolean mSavedIsEmailValid;
    private String mSavedLastName;
    private Date mSavedStartDate;

    public RegistryAdvancedSearchPagePresenter(com.target.ui.util.validation.validator.a a1, com.target.ui.util.validation.validator.a a2, String s, String s1, Parcelable parcelable)
    {
        mSavedIsEmailValid = true;
        mFirstNameValidator = a1;
        mLastNameValidator = a2;
        mSavedFirstName = s;
        mSavedLastName = s1;
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
        mSavedIsEmailValid = ((SavedState) (parcelable)).isEmailValid;
        mSavedStartDate = ((SavedState) (parcelable)).startDate;
        mSavedEndDate = ((SavedState) (parcelable)).endDate;
    }

    private void a(k k1)
    {
        if (c(k1))
        {
            mPresentation.a(k1.b());
            return;
        } else
        {
            mPresentation.a();
            return;
        }
    }

    private void a(String s, String s1)
    {
        boolean flag = b(s, s1);
        s = mPresentation;
        if (flag && n())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.a(flag);
    }

    private void b(k k1)
    {
        if (c(k1))
        {
            mPresentation.b(k1.b());
            return;
        } else
        {
            mPresentation.b();
            return;
        }
    }

    private boolean b(String s, String s1)
    {
        boolean flag = c(s).a();
        boolean flag1 = d(s1).a();
        return flag && flag1;
    }

    private k c(String s)
    {
        return mFirstNameValidator.a(s);
    }

    private Date c(Date date)
    {
        if (date != null)
        {
            return date;
        } else
        {
            return Calendar.getInstance().getTime();
        }
    }

    private static boolean c(k k1)
    {
        return !k1.a();
    }

    private k d(String s)
    {
        return mLastNameValidator.a(s);
    }

    private void h()
    {
        if (l())
        {
            mPresentation.b(0x7f09049e);
            return;
        }
        if (m())
        {
            mPresentation.b(0x7f0904a0);
            return;
        } else
        {
            mPresentation.e();
            mPresentation.g();
            return;
        }
    }

    private void i()
    {
        if (l())
        {
            mPresentation.c(0x7f090499);
            return;
        }
        if (m())
        {
            mPresentation.b(0x7f0904a0);
            return;
        } else
        {
            mPresentation.e();
            mPresentation.g();
            return;
        }
    }

    private void j()
    {
        a(c(mSavedFirstName));
        b(d(mSavedLastName));
        mPresentation.a(mSavedFirstName, mSavedLastName);
    }

    private boolean k()
    {
        return o.g(mSavedFirstName) || o.g(mSavedLastName);
    }

    private boolean l()
    {
        return mSavedStartDate != null && mSavedEndDate == null || mSavedStartDate == null && mSavedEndDate != null;
    }

    private boolean m()
    {
        if (mSavedStartDate == null || mSavedEndDate == null)
        {
            return false;
        } else
        {
            return mSavedStartDate.after(mSavedEndDate);
        }
    }

    private boolean n()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (o.g(mSavedFirstName) && o.g(mSavedLastName))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = l();
        flag3 = mSavedIsEmailValid;
        if (!m())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag3 && !flag2 && flag1;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900d0);
    }

    public void a(b b1)
    {
        mPresentation = b1;
        mPresentation.c();
        if (k())
        {
            j();
        }
        mPresentation.a(n());
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(String s)
    {
        mSavedFirstName = s;
        a(c(s));
        a(mSavedFirstName, mSavedLastName);
    }

    public void a(String s, String s1, c c1, String s2, String s3, Date date, Date date1, 
            String s4)
    {
        s = new RegistrySearchParam(s, s1);
        if (!c1.equals(c.UNKNOWN))
        {
            s.a(c1);
        }
        if (o.g(s2))
        {
            s.c(s2);
        }
        if (o.g(s3))
        {
            s.b(s3);
        }
        if (date != null && date1 != null)
        {
            s.a(date);
            s.b(date1);
        }
        if (o.g(s4))
        {
            s.a(s4);
        }
        mPresentation.a(s);
    }

    public void a(String s, boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            a(c(s));
            return;
        }
    }

    public void a(Date date)
    {
        mSavedStartDate = date;
        mPresentation.a(n());
        mPresentation.c(date);
        i();
    }

    public void a(boolean flag)
    {
        mSavedIsEmailValid = flag;
        mPresentation.a(n());
    }

    public void b(String s)
    {
        mSavedLastName = s;
        b(c(s));
        a(mSavedFirstName, mSavedLastName);
    }

    public void b(String s, boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            b(d(s));
            return;
        }
    }

    public void b(Date date)
    {
        mSavedEndDate = date;
        mPresentation.a(n());
        mPresentation.d(date);
        h();
    }

    public void c()
    {
        mSavedStartDate = null;
        mPresentation.a(n());
        mPresentation.d();
        h();
    }

    public void d()
    {
        mPresentation.a(c(mSavedStartDate));
    }

    public void e()
    {
        mSavedEndDate = null;
        mPresentation.a(n());
        mPresentation.f();
        i();
    }

    public void f()
    {
        mPresentation.b(c(mSavedEndDate));
    }

    public Parcelable g()
    {
        SavedState savedstate = new SavedState();
        savedstate.firstName = mSavedFirstName;
        savedstate.lastName = mSavedLastName;
        savedstate.isEmailValid = mSavedIsEmailValid;
        savedstate.startDate = mSavedStartDate;
        savedstate.endDate = mSavedEndDate;
        return savedstate;
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
