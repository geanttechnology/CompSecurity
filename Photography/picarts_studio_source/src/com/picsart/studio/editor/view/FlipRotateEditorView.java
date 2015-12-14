// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.helper.d;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class FlipRotateEditorView extends EditorView
{

    public Matrix i;
    private ValueAnimator j;
    private Matrix k;
    private Matrix l;
    private Rect m;

    public FlipRotateEditorView(Context context)
    {
        this(context, null);
    }

    public FlipRotateEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FlipRotateEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        new Rect();
        m = new Rect();
        i = new Matrix();
        k = new Matrix();
        l = new Matrix();
    }

    static Matrix a(FlipRotateEditorView fliprotateeditorview)
    {
        return fliprotateeditorview.i;
    }

    static Matrix a(FlipRotateEditorView fliprotateeditorview, Matrix matrix)
    {
        fliprotateeditorview.i = matrix;
        return matrix;
    }

    private void a(Matrix matrix, Matrix matrix1)
    {
        j = ValueAnimator.ofObject(new d(), new Object[] {
            matrix, matrix1
        });
        j.setDuration(300L);
        j.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            private FlipRotateEditorView a;

            public final void onAnimationUpdate(ValueAnimator valueanimator)
            {
                FlipRotateEditorView.a(a, (Matrix)valueanimator.getAnimatedValue());
                a.invalidate();
            }

            
            {
                a = FlipRotateEditorView.this;
                super();
            }
        });
        j.start();
    }

    public final void a(float f1)
    {
        if (e != null && (j == null || !j.isRunning()))
        {
            k.set(i);
            l.set(i);
            l.postRotate(f1);
            a(k, l);
        }
    }

    public final void e()
    {
        if (e != null && (j == null || !j.isRunning()))
        {
            k.set(i);
            l.set(i);
            l.postScale(-1F, 1.0F);
            a(k, l);
        }
    }

    public final void f()
    {
        if (e != null && (j == null || !j.isRunning()))
        {
            k.set(i);
            l.set(i);
            l.postScale(1.0F, -1F);
            a(k, l);
        }
    }

    public final Bitmap g()
    {
        if (e != null && !i.isIdentity())
        {
            return Bitmap.createBitmap(e, 0, 0, e.getWidth(), e.getHeight(), l, false);
        } else
        {
            return e;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (e != null)
        {
            d.set(0.0F, 0.0F, e.getWidth(), e.getHeight());
            c.a(d);
            int i1 = (int)Math.ceil(d.width() / 2.0F);
            int j1 = (int)Math.ceil(d.height() / 2.0F);
            m.set(-i1, -j1, i1, j1);
            canvas.save();
            canvas.translate(d.centerX(), d.centerY());
            canvas.concat(i);
            canvas.drawBitmap(f, null, m, a);
            canvas.restore();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        i = SavedState.a(parcelable);
        k.set(i);
        l.set(i);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    private class SavedState extends UserSavedState
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
        private Matrix b;

        static Matrix a(SavedState savedstate)
        {
            return savedstate.b;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            float af[] = new float[9];
            b.getValues(af);
            parcel.writeFloatArray(af);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            float af[] = new float[9];
            parcel.readFloatArray(af);
            b = new Matrix();
            b.setValues(af);
        }

        public SavedState(Parcelable parcelable, FlipRotateEditorView fliprotateeditorview)
        {
            super(parcelable);
            b = FlipRotateEditorView.a(fliprotateeditorview);
        }
    }

}
