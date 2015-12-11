// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            aq, ah, ar, Fragment

public final class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private Context b;
    private ah c;
    private int d;
    private android.widget.TabHost.OnTabChangeListener e;
    private aq f;
    private boolean g;

    private ar a(String s, ar ar1)
    {
        aq aq1 = null;
        for (int i = 0; i < a.size(); i++)
        {
            aq aq2 = (aq)a.get(i);
            if (aq2.a.equals(s))
            {
                aq1 = aq2;
            }
        }

        if (aq1 == null)
        {
            throw new IllegalStateException((new StringBuilder("No tab known for tag ")).append(s).toString());
        }
        s = ar1;
        if (f != aq1)
        {
            s = ar1;
            if (ar1 == null)
            {
                s = c.a();
            }
            if (f != null && f.d != null)
            {
                s.b(f.d);
            }
            if (aq1 != null)
            {
                if (aq1.d == null)
                {
                    aq1.d = Fragment.instantiate(b, aq1.b.getName(), aq1.c);
                    s.a(d, aq1.d, aq1.a);
                } else
                {
                    s.c(aq1.d);
                }
            }
            f = aq1;
        }
        return s;
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        ar ar1 = null;
        int i = 0;
        while (i < a.size()) 
        {
            aq aq1 = (aq)a.get(i);
            aq1.d = c.a(aq1.a);
            ar ar2 = ar1;
            if (aq1.d != null)
            {
                ar2 = ar1;
                if (!aq1.d.isDetached())
                {
                    if (aq1.a.equals(s))
                    {
                        f = aq1;
                        ar2 = ar1;
                    } else
                    {
                        ar2 = ar1;
                        if (ar1 == null)
                        {
                            ar2 = c.a();
                        }
                        ar2.b(aq1.d);
                    }
                }
            }
            i++;
            ar1 = ar2;
        }
        g = true;
        ar1 = a(s, ar1);
        if (ar1 != null)
        {
            ar1.a();
            c.b();
        }
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        g = false;
    }

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setCurrentTabByTag(((SavedState) (parcelable)).a);
    }

    protected final Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = getCurrentTabTag();
        return savedstate;
    }

    public final void onTabChanged(String s)
    {
        if (g)
        {
            ar ar1 = a(s, null);
            if (ar1 != null)
            {
                ar1.a();
            }
        }
        if (e != null)
        {
            e.onTabChanged(s);
        }
    }

    public final void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        e = ontabchangelistener;
    }

    public final void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new ap();
        String a;

        public String toString()
        {
            return (new StringBuilder("FragmentTabHost.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readString();
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
