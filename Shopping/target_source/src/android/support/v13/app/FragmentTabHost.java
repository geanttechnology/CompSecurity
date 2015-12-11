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

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private Context b;
    private FragmentManager c;
    private int d;
    private android.widget.TabHost.OnTabChangeListener e;
    private a f;
    private boolean g;

    private FragmentTransaction a(String s, FragmentTransaction fragmenttransaction)
    {
        a a1 = null;
    /* block-local class not found */
    class a {}

        for (int i = 0; i < a.size(); i++)
        {
            a a2 = (a)a.get(i);
            if (a.b(a2).equals(s))
            {
                a1 = a2;
            }
        }

        if (a1 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s).toString());
        }
        s = fragmenttransaction;
        if (f != a1)
        {
            s = fragmenttransaction;
            if (fragmenttransaction == null)
            {
                s = c.beginTransaction();
            }
            if (f != null && a.a(f) != null)
            {
                s.detach(a.a(f));
            }
            if (a1 != null)
            {
                if (a.a(a1) == null)
                {
                    a.a(a1, Fragment.instantiate(b, a.c(a1).getName(), a.d(a1)));
                    s.add(d, a.a(a1), a.b(a1));
                } else
                {
                    s.attach(a.a(a1));
                }
            }
            f = a1;
        }
        return s;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        int i = 0;
        while (i < a.size()) 
        {
            a a1 = (a)a.get(i);
            a.a(a1, c.findFragmentByTag(a.b(a1)));
            FragmentTransaction fragmenttransaction1 = fragmenttransaction;
            if (a.a(a1) != null)
            {
                fragmenttransaction1 = fragmenttransaction;
                if (!a.a(a1).isDetached())
                {
                    if (a.b(a1).equals(s))
                    {
                        f = a1;
                        fragmenttransaction1 = fragmenttransaction;
                    } else
                    {
                        fragmenttransaction1 = fragmenttransaction;
                        if (fragmenttransaction == null)
                        {
                            fragmenttransaction1 = c.beginTransaction();
                        }
                        fragmenttransaction1.detach(a.a(a1));
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

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
    /* block-local class not found */
    class SavedState {}

        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setCurrentTabByTag(((SavedState) (parcelable)).a);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = getCurrentTabTag();
        return savedstate;
    }

    public void onTabChanged(String s)
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

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        e = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
