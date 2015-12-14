// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.picsart.studio.editor.utils.UserSavedState;
import myobfuscated.ay.a;

public class StickerPreviewView extends View
{

    private Bitmap a;
    private Paint b;
    private ColorMatrix c;
    private int d;

    public StickerPreviewView(Context context)
    {
        this(context, null);
    }

    public StickerPreviewView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StickerPreviewView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static Bitmap a(StickerPreviewView stickerpreviewview)
    {
        return stickerpreviewview.a;
    }

    private void a()
    {
        c = new ColorMatrix();
        b = new Paint(2);
        b.setColorFilter(new ColorMatrixColorFilter(c));
    }

    static int b(StickerPreviewView stickerpreviewview)
    {
        return stickerpreviewview.d;
    }

    static Paint c(StickerPreviewView stickerpreviewview)
    {
        return stickerpreviewview.b;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a == null || a.isRecycled())
        {
            return;
        } else
        {
            float f = (float)getWidth() / 2.0F;
            float f1 = (float)getHeight() / 2.0F;
            float f2 = (float)Math.min(getWidth(), getHeight()) / (float)Math.max(a.getWidth(), a.getHeight());
            canvas.translate(f - ((float)a.getWidth() * f2) / 2.0F, f1 - ((float)a.getHeight() * f2) / 2.0F);
            canvas.scale(f2, f2);
            canvas.drawBitmap(a, 0.0F, 0.0F, b);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        a();
        setBitmap(com.socialin.android.photo.view.SavedState.a(parcelable), false);
        setHue(SavedState.b(parcelable), false);
        setOpacity(SavedState.c(parcelable), false);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    public void setBitmap(Bitmap bitmap)
    {
        setBitmap(bitmap, true);
    }

    public void setBitmap(Bitmap bitmap, boolean flag)
    {
        a = bitmap;
        if (flag)
        {
            invalidate();
        }
    }

    public void setHue(int i)
    {
        setHue(i, true);
    }

    public void setHue(int i, boolean flag)
    {
        d = i;
        myobfuscated.ay.a.a(4, i, c);
        b.setColorFilter(new ColorMatrixColorFilter(c));
        if (flag)
        {
            invalidate();
        }
    }

    public void setOpacity(int i)
    {
        setOpacity(i, true);
    }

    public void setOpacity(int i, boolean flag)
    {
        b.setAlpha(i);
        if (flag)
        {
            invalidate();
        }
    }

    private class SavedState extends UserSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i)
            {
                return new SavedState[i];
            }

        };
        private Bitmap b;
        private int c;
        private int d;

        static Bitmap a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static int b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static int c(SavedState savedstate)
        {
            return savedstate.d;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(b, i);
            parcel.writeInt(c);
            parcel.writeInt(d);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
            c = parcel.readInt();
            d = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, StickerPreviewView stickerpreviewview)
        {
            super(parcelable);
            b = com.socialin.android.photo.view.StickerPreviewView.a(stickerpreviewview);
            c = StickerPreviewView.b(stickerpreviewview);
            d = StickerPreviewView.c(stickerpreviewview).getAlpha();
        }
    }

}
