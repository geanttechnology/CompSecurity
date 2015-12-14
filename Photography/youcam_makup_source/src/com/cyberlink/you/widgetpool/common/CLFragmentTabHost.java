// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.common:
//            b, a

public class CLFragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private FrameLayout b;
    private Context c;
    private FragmentManager d;
    private int e;
    private android.widget.TabHost.OnTabChangeListener f;
    private b g;
    private boolean h;

    public CLFragmentTabHost(Context context)
    {
        super(context, null);
        a = new ArrayList();
        a(context, ((AttributeSet) (null)));
    }

    public CLFragmentTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        a(context, attributeset);
    }

    private FragmentTransaction a(String s, FragmentTransaction fragmenttransaction)
    {
        b b1 = null;
        for (int i = 0; i < a.size(); i++)
        {
            b b2 = (b)a.get(i);
            if (com.cyberlink.you.widgetpool.common.b.b(b2).equals(s))
            {
                b1 = b2;
            }
        }

        if (b1 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s).toString());
        }
        s = fragmenttransaction;
        if (g != b1)
        {
            s = fragmenttransaction;
            if (fragmenttransaction == null)
            {
                s = d.beginTransaction();
            }
            if (g != null && com.cyberlink.you.widgetpool.common.b.a(g) != null)
            {
                s.detach(com.cyberlink.you.widgetpool.common.b.a(g));
            }
            if (b1 != null)
            {
                if (com.cyberlink.you.widgetpool.common.b.a(b1) == null)
                {
                    com.cyberlink.you.widgetpool.common.b.a(b1, Fragment.instantiate(c, com.cyberlink.you.widgetpool.common.b.c(b1).getName(), com.cyberlink.you.widgetpool.common.b.d(b1)));
                    s.add(e, com.cyberlink.you.widgetpool.common.b.a(b1), com.cyberlink.you.widgetpool.common.b.b(b1));
                } else
                {
                    s.attach(com.cyberlink.you.widgetpool.common.b.a(b1));
                }
            }
            g = b1;
        }
        return s;
    }

    private void a()
    {
        if (b == null)
        {
            b = (FrameLayout)findViewById(e);
            if (b == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("No tab content FrameLayout found for id ").append(e).toString());
            }
        }
    }

    private void a(Context context)
    {
        if (findViewById(0x1020013) == null)
        {
            LinearLayout linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(1);
            addView(linearlayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            Object obj = new TabWidget(context);
            ((TabWidget) (obj)).setId(0x1020013);
            ((TabWidget) (obj)).setOrientation(0);
            linearlayout.addView(((android.view.View) (obj)), new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
            obj = new FrameLayout(context);
            ((FrameLayout) (obj)).setId(0x1020011);
            linearlayout.addView(((android.view.View) (obj)), new android.widget.LinearLayout.LayoutParams(0, 0, 0.0F));
            context = new FrameLayout(context);
            b = context;
            b.setId(e);
            linearlayout.addView(context, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
        }
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x10100f3
        }, 0, 0);
        e = context.getResourceId(0, 0);
        context.recycle();
        super.setOnTabChangedListener(this);
    }

    public void a(Context context, FragmentManager fragmentmanager, int i)
    {
        a(context);
        super.setup();
        c = context;
        d = fragmentmanager;
        e = i;
        a();
        b.setId(i);
        if (getId() == -1)
        {
            setId(0x1020012);
        }
    }

    public void a(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle)
    {
        tabspec.setContent(new a(c));
        String s = tabspec.getTag();
        class1 = new b(s, class1, bundle);
        if (h)
        {
            com.cyberlink.you.widgetpool.common.b.a(class1, d.findFragmentByTag(s));
            if (com.cyberlink.you.widgetpool.common.b.a(class1) != null && !com.cyberlink.you.widgetpool.common.b.a(class1).isDetached())
            {
                bundle = d.beginTransaction();
                bundle.detach(com.cyberlink.you.widgetpool.common.b.a(class1));
                bundle.commit();
            }
        }
        a.add(class1);
        addTab(tabspec);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        int i = 0;
        while (i < a.size()) 
        {
            b b1 = (b)a.get(i);
            com.cyberlink.you.widgetpool.common.b.a(b1, d.findFragmentByTag(com.cyberlink.you.widgetpool.common.b.b(b1)));
            FragmentTransaction fragmenttransaction1 = fragmenttransaction;
            if (com.cyberlink.you.widgetpool.common.b.a(b1) != null)
            {
                fragmenttransaction1 = fragmenttransaction;
                if (!com.cyberlink.you.widgetpool.common.b.a(b1).isDetached())
                {
                    if (com.cyberlink.you.widgetpool.common.b.b(b1).equals(s))
                    {
                        g = b1;
                        fragmenttransaction1 = fragmenttransaction;
                    } else
                    {
                        fragmenttransaction1 = fragmenttransaction;
                        if (fragmenttransaction == null)
                        {
                            fragmenttransaction1 = d.beginTransaction();
                        }
                        fragmenttransaction1.detach(com.cyberlink.you.widgetpool.common.b.a(b1));
                    }
                }
            }
            i++;
            fragmenttransaction = fragmenttransaction1;
        }
        h = true;
        fragmenttransaction = a(s, fragmenttransaction);
        if (fragmenttransaction != null)
        {
            try
            {
                fragmenttransaction.commit();
            }
            catch (IllegalStateException illegalstateexception)
            {
                Log.e("CLFragmentTabHost", "[onAttachedToWindow] IllegalStateException!!!!");
                illegalstateexception.printStackTrace();
            }
            d.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        h = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
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
        if (h)
        {
            FragmentTransaction fragmenttransaction = a(s, ((FragmentTransaction) (null)));
            if (fragmenttransaction != null)
            {
                fragmenttransaction.commit();
            }
        }
        if (f != null)
        {
            f.onTabChanged(s);
        }
    }

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        f = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    private class SavedState extends android.view.View.BaseSavedState
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
        String a;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(a).append("}").toString();
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


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
