// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.views:
//            a, b

public class PhotoStripView extends LinearLayout
{

    private List a;
    private ArrayList b;
    private int c;
    private int d;
    private int e;
    private int f;
    private b g;

    public PhotoStripView(Context context)
    {
        super(context);
        a(((AttributeSet) (null)));
    }

    public PhotoStripView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(attributeset);
    }

    public PhotoStripView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(attributeset);
    }

    public PhotoStripView(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        a(attributeset);
    }

    private void a(AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            attributeset = getContext().obtainStyledAttributes(attributeset, com.offerup.R.styleable.photostrip);
            c = attributeset.getDimensionPixelSize(0, 0);
            d = attributeset.getResourceId(1, 0);
            Drawable drawable = android.support.v4.b.a.a(getContext(), d);
            e = drawable.getIntrinsicWidth();
            f = drawable.getIntrinsicHeight();
            attributeset.recycle();
        }
        int l = com.offerup.android.c.a.a() - 1;
        a = new ArrayList(l);
        b = new ArrayList(l);
        int i = 0;
        while (i < l) 
        {
            attributeset = new ImageButton(getContext());
            android.widget.LinearLayout.LayoutParams layoutparams;
            int j;
            int k;
            if (i > 0)
            {
                j = c / 2;
            } else
            {
                j = 0;
            }
            if (i < b.size() - 1)
            {
                k = c / 2;
            } else
            {
                k = 0;
            }
            layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.setMargins(j, 0, k, 0);
            attributeset.setLayoutParams(layoutparams);
            attributeset.setPadding(0, 0, 0, 0);
            attributeset.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                attributeset.setBackground(null);
            } else
            {
                attributeset.setBackgroundDrawable(null);
            }
            attributeset.setTag(Integer.valueOf(i));
            attributeset.setOnClickListener(new com.offerup.android.views.a(this));
            attributeset.setImageDrawable(android.support.v4.b.a.a(getContext(), d));
            if (i != 0)
            {
                attributeset.setVisibility(4);
            }
            addView(attributeset);
            a.add(attributeset);
            i++;
        }
    }

    static void a(PhotoStripView photostripview, View view)
    {
        int i;
label0:
        {
            if (photostripview.g != null)
            {
                i = ((Integer)view.getTag()).intValue();
                if (i < photostripview.b.size())
                {
                    break label0;
                }
                photostripview.g.f(i);
            }
            return;
        }
        photostripview.g.g(i);
    }

    private void b(int i)
    {
        while (i < a.size()) 
        {
            Uri uri;
            ImageButton imagebutton;
            if (i < b.size())
            {
                uri = (Uri)b.get(i);
            } else
            {
                uri = null;
            }
            imagebutton = (ImageButton)a.get(i);
            if (uri != null)
            {
                imagebutton.setVisibility(0);
                Picasso.with(getContext().getApplicationContext()).load(uri).resize(e, f).skipMemoryCache().centerCrop().into(imagebutton);
            } else
            {
                imagebutton.setImageDrawable(android.support.v4.b.a.a(getContext(), d));
                if (i == 0 || i > 0 && i <= b.size())
                {
                    imagebutton.setVisibility(0);
                } else
                {
                    imagebutton.setVisibility(4);
                }
            }
            i++;
        }
    }

    public final void a()
    {
        b.clear();
        b(0);
    }

    public final void a(int i)
    {
        if (i < b.size())
        {
            b.remove(i);
            b(i);
        }
    }

    public final void a(int i, Uri uri)
    {
        if (i < b.size())
        {
            b.set(i, uri);
            b(i);
        }
    }

    public final void a(Uri uri)
    {
        b.add(uri);
        b(b.size() - 1);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        } else
        {
            parcelable = (SavedState)parcelable;
            b = com.offerup.android.views.SavedState.a(parcelable);
            b(0);
            super.onRestoreInstanceState(parcelable.getSuperState());
            return;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), b);
    }

    public void setAddPhotoClickListener(b b1)
    {
        g = b1;
    }

    public void setImages(List list)
    {
        b.clear();
        b.addAll(list);
        b(0);
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new c();
        private ArrayList a;

        static ArrayList a(SavedState savedstate)
        {
            return savedstate.a;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeList(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.createTypedArrayList(Uri.CREATOR);
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable, ArrayList arraylist)
        {
            super(parcelable);
            a = arraylist;
        }
    }

}
