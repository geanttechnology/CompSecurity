// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import java.util.ArrayList;

// Referenced classes of package android.support.v13.app:
//            k

public final class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private Context b;
    private FragmentManager c;
    private int d;
    private android.widget.TabHost.OnTabChangeListener e;
    private k f;
    private boolean g;

    private FragmentTransaction a(String s, FragmentTransaction fragmenttransaction)
    {
        k k1 = null;
        for (int i = 0; i < a.size(); i++)
        {
            k k2 = (k)a.get(i);
            if (k2.a.equals(s))
            {
                k1 = k2;
            }
        }

        if (k1 == null)
        {
            throw new IllegalStateException((new StringBuilder("No tab known for tag ")).append(s).toString());
        }
        s = fragmenttransaction;
        if (f != k1)
        {
            s = fragmenttransaction;
            if (fragmenttransaction == null)
            {
                s = c.beginTransaction();
            }
            if (f != null && f.d != null)
            {
                s.detach(f.d);
            }
            if (k1 != null)
            {
                if (k1.d == null)
                {
                    k1.d = Fragment.instantiate(b, k1.b.getName(), k1.c);
                    s.add(d, k1.d, k1.a);
                } else
                {
                    s.attach(k1.d);
                }
            }
            f = k1;
        }
        return s;
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        int i = 0;
        while (i < a.size()) 
        {
            k k1 = (k)a.get(i);
            k1.d = c.findFragmentByTag(k1.a);
            FragmentTransaction fragmenttransaction1 = fragmenttransaction;
            if (k1.d != null)
            {
                fragmenttransaction1 = fragmenttransaction;
                if (!k1.d.isDetached())
                {
                    if (k1.a.equals(s))
                    {
                        f = k1;
                        fragmenttransaction1 = fragmenttransaction;
                    } else
                    {
                        fragmenttransaction1 = fragmenttransaction;
                        if (fragmenttransaction == null)
                        {
                            fragmenttransaction1 = c.beginTransaction();
                        }
                        fragmenttransaction1.detach(k1.d);
                    }
                }
            }
            i++;
            fragmenttransaction = fragmenttransaction1;
        }
        g = true;
        fragmenttransaction = a(s, fragmenttransaction);
        if (fragmenttransaction != null)
        {
            fragmenttransaction.commit();
            c.executePendingTransactions();
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
            FragmentTransaction fragmenttransaction = a(s, null);
            if (fragmenttransaction != null)
            {
                fragmenttransaction.commit();
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

        public static final android.os.Parcelable.Creator CREATOR = new j();
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
