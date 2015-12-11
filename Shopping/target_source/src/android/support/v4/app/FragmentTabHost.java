// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            h, l, Fragment

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private Context b;
    private h c;
    private int d;
    private android.widget.TabHost.OnTabChangeListener e;
    private a f;
    private boolean g;

    public FragmentTabHost(Context context)
    {
        super(context, null);
        a = new ArrayList();
        a(context, ((AttributeSet) (null)));
    }

    public FragmentTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        a(context, attributeset);
    }

    private l a(String s, l l1)
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
        s = l1;
        if (f != a1)
        {
            s = l1;
            if (l1 == null)
            {
                s = c.a();
            }
            if (f != null && a.a(f) != null)
            {
                s.b(a.a(f));
            }
            if (a1 != null)
            {
                if (a.a(a1) == null)
                {
                    a.a(a1, Fragment.instantiate(b, a.c(a1).getName(), a.d(a1)));
                    s.a(d, a.a(a1), a.b(a1));
                } else
                {
                    s.c(a.a(a1));
                }
            }
            f = a1;
        }
        return s;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x10100f3
        }, 0, 0);
        d = context.getResourceId(0, 0);
        context.recycle();
        super.setOnTabChangedListener(this);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        l l1 = null;
        int i = 0;
        while (i < a.size()) 
        {
            a a1 = (a)a.get(i);
            a.a(a1, c.a(a.b(a1)));
            l l2 = l1;
            if (a.a(a1) != null)
            {
                l2 = l1;
                if (!a.a(a1).isDetached())
                {
                    if (a.b(a1).equals(s))
                    {
                        f = a1;
                        l2 = l1;
                    } else
                    {
                        l2 = l1;
                        if (l1 == null)
                        {
                            l2 = c.a();
                        }
                        l2.b(a.a(a1));
                    }
                }
            }
            i++;
            l1 = l2;
        }
        g = true;
        l1 = a(s, l1);
        if (l1 != null)
        {
            l1.a();
            c.b();
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
            l l1 = a(s, ((l) (null)));
            if (l1 != null)
            {
                l1.a();
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
