// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.internal.a;
import android.support.design.internal.b;
import android.support.design.internal.f;
import android.support.v4.view.bi;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            ak, al

public class NavigationView extends f
{

    private static final int a[] = {
        0x10100a0
    };
    private static final int b[] = {
        0xfefeff62
    };
    private final a c;
    private final b d;
    private al e;
    private int f;
    private MenuInflater g;

    public NavigationView(Context context)
    {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NavigationView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d = new b();
        c = new a(context);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.design.a.R, i, 0x7f0c0195);
        setBackgroundDrawable(typedarray.getDrawable(android.support.design.a.S));
        if (typedarray.hasValue(android.support.design.a.V))
        {
            bi.f(this, typedarray.getDimensionPixelSize(android.support.design.a.V, 0));
        }
        bi.a(this, typedarray.getBoolean(android.support.design.a.T, false));
        f = typedarray.getDimensionPixelSize(android.support.design.a.U, 0);
        ColorStateList colorstatelist;
        Object obj;
        boolean flag;
        if (typedarray.hasValue(android.support.design.a.Y))
        {
            colorstatelist = typedarray.getColorStateList(android.support.design.a.Y);
        } else
        {
            colorstatelist = a(0x1010038);
        }
        if (typedarray.hasValue(android.support.design.a.Z))
        {
            i = typedarray.getResourceId(android.support.design.a.Z, 0);
            flag = true;
        } else
        {
            i = 0;
            flag = false;
        }
        attributeset = null;
        if (typedarray.hasValue(android.support.design.a.aa))
        {
            attributeset = typedarray.getColorStateList(android.support.design.a.aa);
        }
        obj = attributeset;
        if (!flag)
        {
            obj = attributeset;
            if (attributeset == null)
            {
                obj = a(0x1010036);
            }
        }
        attributeset = typedarray.getDrawable(android.support.design.a.X);
        c.a(new ak(this));
        d.a(1);
        d.initForMenu(context, c);
        d.a(colorstatelist);
        if (flag)
        {
            d.c(i);
        }
        d.b(((ColorStateList) (obj)));
        d.a(attributeset);
        c.a(d);
        addView((View)d.a(this));
        if (typedarray.hasValue(android.support.design.a.ab))
        {
            i = typedarray.getResourceId(android.support.design.a.ab, 0);
            d.a(true);
            getMenuInflater().inflate(i, c);
            d.a(false);
            d.updateMenuView(false);
        }
        if (typedarray.hasValue(android.support.design.a.W))
        {
            i = typedarray.getResourceId(android.support.design.a.W, 0);
            d.b(i);
        }
        typedarray.recycle();
    }

    private ColorStateList a(int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedvalue, true))
        {
            ColorStateList colorstatelist = getResources().getColorStateList(typedvalue.resourceId);
            if (getContext().getTheme().resolveAttribute(0x7f01010b, typedvalue, true))
            {
                i = typedvalue.data;
                int j = colorstatelist.getDefaultColor();
                int ai[] = b;
                int ai1[] = a;
                int ai2[] = EMPTY_STATE_SET;
                int k = colorstatelist.getColorForState(b, j);
                return new ColorStateList(new int[][] {
                    ai, ai1, ai2
                }, new int[] {
                    k, i, j
                });
            }
        }
        return null;
    }

    static al a(NavigationView navigationview)
    {
        return navigationview.e;
    }

    private MenuInflater getMenuInflater()
    {
        if (g == null)
        {
            g = new SupportMenuInflater(getContext());
        }
        return g;
    }

    public Drawable getItemBackground()
    {
        return d.c();
    }

    public ColorStateList getItemIconTintList()
    {
        return d.a();
    }

    public ColorStateList getItemTextColor()
    {
        return d.b();
    }

    public Menu getMenu()
    {
        return c;
    }

    protected void onMeasure(int i, int j)
    {
        int k = i;
        android.view.View.MeasureSpec.getMode(i);
        JVM INSTR lookupswitch 3: default 40
    //                   -2147483648: 49
    //                   0: 70
    //                   1073741824: 42;
           goto _L1 _L2 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        k = i;
_L6:
        super.onMeasure(k, j);
        return;
_L2:
        k = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(android.view.View.MeasureSpec.getSize(i), f), 0x40000000);
        continue; /* Loop/switch isn't completed */
_L3:
        k = android.view.View.MeasureSpec.makeMeasureSpec(f, 0x40000000);
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        c.b(((SavedState) (parcelable)).a);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = new Bundle();
        c.a(savedstate.a);
        return savedstate;
    }

    public void setCheckedItem(int i)
    {
        android.view.MenuItem menuitem = c.findItem(i);
        if (menuitem != null)
        {
            d.a((m)menuitem);
        }
    }

    public void setItemBackground(Drawable drawable)
    {
        d.a(drawable);
    }

    public void setItemBackgroundResource(int i)
    {
        setItemBackground(android.support.v4.b.a.a(getContext(), i));
    }

    public void setItemIconTintList(ColorStateList colorstatelist)
    {
        d.a(colorstatelist);
    }

    public void setItemTextAppearance(int i)
    {
        d.c(i);
    }

    public void setItemTextColor(ColorStateList colorstatelist)
    {
        d.b(colorstatelist);
    }

    public void setNavigationItemSelectedListener(al al)
    {
        e = al;
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new am();
        public Bundle a;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
