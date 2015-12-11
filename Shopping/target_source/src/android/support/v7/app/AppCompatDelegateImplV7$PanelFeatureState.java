// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.internal.view.b;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.m;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

private static final class q
{
    private static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return SavedState.a(parcel);
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
        int a;
        boolean b;
        Bundle c;

        static SavedState a(Parcel parcel)
        {
            return b(parcel);
        }

        private static SavedState b(Parcel parcel)
        {
            boolean flag = true;
            SavedState savedstate = new SavedState();
            savedstate.a = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            savedstate.b = flag;
            if (savedstate.b)
            {
                savedstate.c = parcel.readBundle();
            }
            return savedstate;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(a);
            if (b)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (b)
            {
                parcel.writeBundle(c);
            }
        }


        private SavedState()
        {
        }
    }


    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    f j;
    e k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;

    m a(android.support.v7.internal.view.menu.t> t>)
    {
        if (j == null)
        {
            return null;
        }
        if (k == null)
        {
            k = new e(l, android.support.v7.a.e.l);
            k.a(t>);
            j.a(k);
        }
        return k.a(g);
    }

    void a(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.te te = context.getResources().newTheme();
        te.te(context.getTheme());
        te.te(android.support.v7.a.e, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        }
        te.te(android.support.v7.a.e, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        } else
        {
            te.te(android.support.v7.a.e, true);
        }
        context = new b(context, 0);
        context.getTheme().te(te);
        l = context;
        context = context.obtainStyledAttributes(android.support.v7.a.e.l);
        b = context.getResourceId(android.support.v7.a.e.b, 0);
        f = context.getResourceId(android.support.v7.a.e.f, 0);
        context.recycle();
    }

    void a(f f1)
    {
        if (f1 != j)
        {
            if (j != null)
            {
                j.b(k);
            }
            j = f1;
            if (f1 != null && k != null)
            {
                f1.a(k);
                return;
            }
        }
    }

    public boolean a()
    {
        boolean flag1 = true;
        boolean flag;
        if (h == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (i == null)
            {
                flag = flag1;
                if (k.d().getCount() <= 0)
                {
                    return false;
                }
            }
        }
        return flag;
    }

    SavedState(int i1)
    {
        a = i1;
        q = false;
    }
}
