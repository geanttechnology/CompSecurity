// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
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
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.item.d;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.util.c;
import myobfuscated.bq.a;
import myobfuscated.bq.b;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class FrameEditorView extends EditorView
{

    public TransformingItem i;
    public ImageItem j;
    public boolean k;
    private RectF l;
    private FrameBackgroundItemGizmo m;
    private a n;
    private com.socialin.android.colorpicker.c o;
    private boolean p;
    private Bitmap q;

    public FrameEditorView(Context context)
    {
        this(context, null);
    }

    public FrameEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FrameEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        k = false;
        p = false;
        l = new RectF();
        n = new a(getResources(), new b() {

            private FrameEditorView a;

            public final int a(int j1, int k1)
            {
                return com.picsart.studio.editor.view.FrameEditorView.a(a).getPixel(Math.min(Math.max(j1 / 2, 0), com.picsart.studio.editor.view.FrameEditorView.a(a).getWidth() - 1), Math.min(Math.max(k1 / 2, 0), com.picsart.studio.editor.view.FrameEditorView.a(a).getHeight() - 1));
            }

            
            {
                a = FrameEditorView.this;
                super();
            }
        });
    }

    static Bitmap a(FrameEditorView frameeditorview)
    {
        return frameeditorview.q;
    }

    static TransformingItem b(FrameEditorView frameeditorview)
    {
        return frameeditorview.i;
    }

    private void g()
    {
        if (i != null && j != null)
        {
            g g1 = i.r();
            g g2 = j.r();
            g1.a(0.0F, 0.0F);
            g1.b(1.0F, 1.0F);
            g1.e(0.0F);
            g2.a(0.0F, 0.0F);
            g2.b(1.0F, 1.0F);
            g2.e(0.0F);
            if (i instanceof SvgItem)
            {
                g1.b(j.i() / i.i(), j.j() / i.j());
                m.a(0.25F, 4F);
            } else
            {
                float f1 = Math.max(i.i() / j.i(), i.j() / j.j());
                g2.b(f1, f1);
                m.a(f1 * 0.25F, f1 * 4F);
            }
            a(true);
            invalidate();
        }
    }

    public final void a(int i1)
    {
        if (j != null)
        {
            g g1 = j.r();
            g1.e(g1.e() + (float)i1);
            invalidate();
        }
    }

    protected final void a(Canvas canvas)
    {
        canvas.save();
        canvas.clipRect(l);
        c.a(canvas);
        b(canvas);
        canvas.restore();
        if (!p && k)
        {
            n.a(canvas);
        }
    }

    public final void a(boolean flag)
    {
        if (i != null && j != null)
        {
            float f1 = getWidth();
            float f2 = getHeight();
            Object obj = new RectF(getPaddingLeft(), getPaddingTop(), f1 - (float)getPaddingRight(), f2 - (float)getPaddingBottom());
            c.a(f1, f2);
            f1 = i.s();
            f2 = i.t();
            float f3 = i.i();
            float f4 = i.j();
            f1 = ((RectF) (obj)).width() / f1;
            f2 = ((RectF) (obj)).height() / f2;
            c.b(0.0F, 0.0F);
            obj = c;
            PointF pointf;
            g g1;
            if (f1 >= f2)
            {
                f1 = f2;
            }
            ((Camera) (obj)).a(f1);
            obj = new PointF(-f3 / 2.0F, -f4 / 2.0F);
            pointf = new PointF(f3 / 2.0F, f4 / 2.0F);
            g1 = i.a(c);
            g1.a(((PointF) (obj)));
            g1.a(pointf);
            l.set(((PointF) (obj)).x, ((PointF) (obj)).y, pointf.x, pointf.y);
        }
    }

    public final void b(Canvas canvas)
    {
        if (i != null && j != null)
        {
            j.a(canvas);
            if (!k && !p)
            {
                i.a(canvas);
            }
        }
    }

    protected final boolean d()
    {
        return false;
    }

    public final void e()
    {
        p = true;
        q = c.a(getWidth() / 2, getHeight() / 2, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(q);
        canvas.scale(0.5F, 0.5F);
        draw(canvas);
        p = false;
        k = true;
        n.a(q.getWidth(), q.getHeight());
        n.a = q.getPixel(q.getWidth() / 2, q.getHeight() / 2);
    }

    public final int f()
    {
        if (i != null)
        {
            return i.k();
        } else
        {
            return -1;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        if (com.picsart.studio.editor.view.SavedState.a(parcelable) != null)
        {
            setFrameItem(com.picsart.studio.editor.view.SavedState.a(parcelable));
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
            g();
        }
        if (i1 != 0 && j1 != 0 && k)
        {
            e();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (k)
        {
            if (motionevent.getActionMasked() == 1)
            {
                o.a(n.a);
                q.recycle();
                k = false;
            } else
            {
                float f1 = motionevent.getX();
                float f2 = motionevent.getY();
                n.a(motionevent.getActionMasked(), f1, f2);
            }
            invalidate();
        } else
        if (m != null)
        {
            super.onTouchEvent(motionevent);
            m.a(motionevent, c, true);
            return true;
        }
        return true;
    }

    public void setColorSelectedListener(com.socialin.android.colorpicker.c c1)
    {
        o = c1;
    }

    public void setEyeDropperActive(boolean flag)
    {
        k = flag;
        if (!k && q != null && !q.isRecycled())
        {
            q.recycle();
        }
    }

    public void setFrameItem(TransformingItem transformingitem)
    {
        TransformingItem transformingitem1 = i;
        i = transformingitem;
        if (transformingitem1 != null)
        {
            i.b(transformingitem1.k());
        }
        if (transformingitem instanceof SvgItem)
        {
            ((SvgItem)transformingitem).b(true);
        }
        i.n = new d() {

            private FrameEditorView a;

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
                a = FrameEditorView.this;
                super();
            }
        };
        if (getWidth() != 0 && getHeight() != 0 || transformingitem1 != null && transformingitem != transformingitem1)
        {
            g();
        }
    }

    public void setImage(Bitmap bitmap)
    {
        super.setImage(bitmap);
        if (j == null)
        {
            j = ImageItem.a(bitmap);
            j.n = new d() {

                private FrameEditorView a;

                public final void a(Item item)
                {
                    a.invalidate();
                }

            
            {
                a = FrameEditorView.this;
                super();
            }
            };
            m = FrameBackgroundItemGizmo.a(j);
        } else
        {
            j.b(bitmap);
        }
        g();
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
                ((SvgItem)i).q();
            }
            invalidate();
        }
    }

    public void setOverlayOpacity(int i1)
    {
        if (i != null)
        {
            if (i instanceof SvgItem)
            {
                i.c(i1);
            } else
            {
                i.c(255);
            }
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

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private TransformingItem b;

        static TransformingItem a(SavedState savedstate)
        {
            return savedstate.b;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(b, i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = (TransformingItem)parcel.readParcelable(com/picsart/studio/editor/item/TransformingItem.getClassLoader());
        }

        public SavedState(Parcelable parcelable, FrameEditorView frameeditorview)
        {
            super(parcelable);
            b = com.picsart.studio.editor.view.FrameEditorView.b(frameeditorview);
        }
    }

}
