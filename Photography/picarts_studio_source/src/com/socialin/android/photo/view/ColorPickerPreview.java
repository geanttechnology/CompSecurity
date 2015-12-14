// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;

public class ColorPickerPreview extends View
{

    private final int a = getResources().getDimensionPixelSize(0x7f0b00a6);
    private final int b = getResources().getDimensionPixelSize(0x7f0b00a5);
    private final Paint c = new Paint(3);
    private final Paint d = new Paint(1);
    private final Paint e = new Paint(1);
    private final Paint f = new Paint(1);
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final Bitmap j;
    private int k;
    private boolean l;

    public ColorPickerPreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        j = BitmapFactory.decodeResource(context.getResources(), 0x7f02012a);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setColor(-1);
        d.setStrokeWidth(a);
        e.setStyle(android.graphics.Paint.Style.STROKE);
        e.setColor(0xff000000);
        e.setStrokeWidth(b);
        f.setStyle(android.graphics.Paint.Style.FILL);
    }

    public final void a()
    {
        l = false;
        invalidate();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        j.recycle();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (l)
        {
            f.setColor(k);
            canvas.drawRect(g, f);
            canvas.drawRect(h, d);
            canvas.drawRect(i, e);
            return;
        } else
        {
            canvas.drawBitmap(j, null, g, c);
            canvas.drawRect(h, d);
            canvas.drawRect(i, e);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        k = SavedState.a(parcelable);
        l = SavedState.b(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        SavedState.a(savedstate, k);
        SavedState.a(savedstate, l);
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        g.set(0, 0, i1, j1);
        h.set(g);
        h.inset(a / 2, a / 2);
        i.set(g);
        i.inset(a, a);
        i.inset(b / 2, b / 2);
    }

    public final void setColor(int i1)
    {
        k = i1;
        l = true;
        invalidate();
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private int a;
        private boolean b;

        static int a(SavedState savedstate)
        {
            return savedstate.a;
        }

        static int a(SavedState savedstate, int i1)
        {
            savedstate.a = i1;
            return i1;
        }

        static boolean a(SavedState savedstate, boolean flag)
        {
            savedstate.b = flag;
            return flag;
        }

        static boolean b(SavedState savedstate)
        {
            return savedstate.b;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            if (b)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        public SavedState(Parcel parcel)
        {
            boolean flag = true;
            super(parcel);
            a = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            b = flag;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
