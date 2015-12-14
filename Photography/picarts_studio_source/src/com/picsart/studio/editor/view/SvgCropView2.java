// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.gizmo.FrameBackgroundItemGizmo;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.d;
import com.socialin.android.photo.svg.Svg;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class SvgCropView2 extends EditorView
{

    private SvgItem i;
    private ImageItem j;
    private RectF k;
    private FrameBackgroundItemGizmo l;
    private Paint m;
    private boolean n;

    public SvgCropView2(Context context)
    {
        this(context, null);
    }

    public SvgCropView2(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SvgCropView2(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        n = true;
        k = new RectF();
        m = new Paint(1);
        m.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        m.setStyle(android.graphics.Paint.Style.FILL);
    }

    static SvgItem a(SvgCropView2 svgcropview2)
    {
        return svgcropview2.i;
    }

    private void a(SvgItem svgitem)
    {
        i = svgitem;
        i.n = new d() {

            private SvgCropView2 a;

            public final void a(Item item)
            {
                int i1 = item.n();
                if (i1 == 3 || i1 == 4 || i1 == 2 || i1 == 1 && (item instanceof SvgItem))
                {
                    a.setLayerType(1, null);
                    return;
                } else
                {
                    a.setLayerType(2, null);
                    return;
                }
            }

            
            {
                a = SvgCropView2.this;
                super();
            }
        };
        if (getWidth() != 0 && getHeight() != 0)
        {
            e();
        }
    }

    private void e()
    {
        if (i != null && j != null)
        {
            Object obj = i.r();
            g g1 = i.a(c);
            Object obj1 = j.r();
            ((g) (obj)).a(0.0F, 0.0F);
            ((g) (obj)).b(1.0F, 1.0F);
            float f = Math.max(i.i() / j.i(), i.j() / j.j());
            ((g) (obj1)).a(0.0F, 0.0F);
            ((g) (obj1)).b(f, f);
            f = i.i();
            float f1 = i.j();
            obj = new PointF(-f / 2.0F, -f1 / 2.0F);
            obj1 = new PointF(f / 2.0F, f1 / 2.0F);
            a(true);
            g1.a(((PointF) (obj)));
            g1.a(((PointF) (obj1)));
            k.set(((PointF) (obj)).x, ((PointF) (obj)).y, ((PointF) (obj1)).x, ((PointF) (obj1)).y);
            invalidate();
        }
    }

    protected final void a(Canvas canvas)
    {
        if (i != null && j != null && n)
        {
            canvas.save();
            c.a(canvas);
            j.a(canvas);
            canvas.restore();
            canvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
            canvas.drawColor(0xaa000000);
            c.a(canvas);
            i.r().a(canvas);
            canvas.translate(-i.i() / 2.0F, -i.j() / 2.0F);
            canvas.restore();
            c.b(canvas);
            i.a(canvas);
            canvas.restore();
        }
    }

    public final void a(boolean flag)
    {
        if (i != null)
        {
            float f = getWidth();
            float f2 = getHeight();
            Object obj = new RectF(getPaddingLeft(), getPaddingTop(), f - (float)getPaddingRight(), f2 - (float)getPaddingBottom());
            c.a(f, f2);
            if (flag)
            {
                float f1 = i.s();
                float f3 = i.t();
                f1 = ((RectF) (obj)).width() / f1;
                f3 = ((RectF) (obj)).height() / f3;
                c.b(0.0F, 0.0F);
                obj = c;
                if (f1 >= f3)
                {
                    f1 = f3;
                }
                ((Camera) (obj)).a(f1);
            }
        }
    }

    protected final boolean d()
    {
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (SavedState.a(parcelable) != null)
        {
            a(SavedState.a(parcelable));
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i != null && k1 == 0 && l1 == 0)
        {
            e();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        if (l != null)
        {
            l.a(motionevent, c, true);
        }
        return true;
    }

    public void setFrameResource(int i1)
    {
        a(SvgItem.p().a(new Svg(getContext(), i1)));
    }

    public void setImage(Bitmap bitmap)
    {
        super.setImage(bitmap);
        if (j == null)
        {
            j = ImageItem.a(bitmap);
            j.n = new d() {

                private SvgCropView2 a;

                public final void a(Item item)
                {
                    a.invalidate();
                }

            
            {
                a = SvgCropView2.this;
                super();
            }
            };
            l = FrameBackgroundItemGizmo.a(j);
        } else
        {
            j.b(bitmap);
        }
        e();
    }

    public void setOverlayBlendingMode(int i1)
    {
        if (i != null)
        {
            i.d(i1);
            invalidate();
        }
    }

    public void setOverlayColor(int i1)
    {
        if (i != null)
        {
            i.b(i1);
            if (i instanceof SvgItem)
            {
                i.q();
            }
            invalidate();
        }
    }

    public void setOverlayOpacity(int i1)
    {
        if (i != null)
        {
            i.c(i1);
            invalidate();
        }
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
        private SvgItem a;

        static SvgItem a(SavedState savedstate)
        {
            return savedstate.a;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(a, i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = (SvgItem)parcel.readParcelable(com/picsart/studio/editor/item/TransformingItem.getClassLoader());
        }

        public SavedState(Parcelable parcelable, SvgCropView2 svgcropview2)
        {
            super(parcelable);
            a = SvgCropView2.a(svgcropview2);
        }
    }

}
