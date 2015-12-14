// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.helper.Sticker;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.util.Geom;
import com.socialin.android.util.d;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.ay.a;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class StickerEditorView extends EditorView
{

    public int i;
    public int j;
    public int k;
    public float l;
    public Bitmap m;
    public boolean n;
    private float o;
    private Paint p;
    private Canvas q;
    private List r;
    private boolean s;
    private PointF t;
    private PointF u;

    public StickerEditorView(Context context)
    {
        this(context, null);
    }

    public StickerEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StickerEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = 0;
        j = 255;
        k = -1;
        l = 1.0F;
        r = new ArrayList();
        t = new PointF();
        u = new PointF();
        p = new Paint();
        o = TypedValue.applyDimension(1, 5F, getResources().getDisplayMetrics());
        setSinglePointerGestureEnabled(false);
    }

    static List a(StickerEditorView stickereditorview)
    {
        return stickereditorview.r;
    }

    static Bitmap b(StickerEditorView stickereditorview)
    {
        return stickereditorview.m;
    }

    static int c(StickerEditorView stickereditorview)
    {
        return stickereditorview.i;
    }

    static int d(StickerEditorView stickereditorview)
    {
        return stickereditorview.j;
    }

    static int e(StickerEditorView stickereditorview)
    {
        return stickereditorview.k;
    }

    static float f(StickerEditorView stickereditorview)
    {
        return stickereditorview.l;
    }

    private void g()
    {
        if (e != null)
        {
            float f1 = (float)e.getWidth() / (float)f.getWidth();
            q = new Canvas(f);
            q.scale(1.0F / f1, 1.0F / f1);
            for (Iterator iterator = r.iterator(); iterator.hasNext(); ((Sticker)iterator.next()).a(q)) { }
            invalidate();
        }
    }

    protected final void a(Canvas canvas)
    {
        if (e != null)
        {
            c.b(canvas);
            canvas.scale((float)e.getWidth() / (float)f.getWidth(), (float)e.getHeight() / (float)f.getHeight());
            canvas.drawBitmap(f, 0.0F, 0.0F, a);
            canvas.restore();
            if (n && m != null)
            {
                float f1 = (float)getWidth() / 2.0F;
                float f2 = (float)getHeight() / 2.0F;
                float f3 = l * c.e;
                canvas.save();
                canvas.translate(f1 - ((float)m.getWidth() * f3) / 2.0F, f2 - ((float)m.getHeight() * f3) / 2.0F);
                canvas.scale(f3, f3);
                canvas.drawColor(0x44000000);
                canvas.drawBitmap(m, 0.0F, 0.0F, p);
                canvas.restore();
            }
        }
    }

    public final void e()
    {
        if (!r.isEmpty())
        {
            r.remove(r.size() - 1);
            f = w.a(e, 2048, true);
            g();
        }
    }

    public final Bitmap f()
    {
        if (e != null)
        {
            Bitmap bitmap = e.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(bitmap);
            for (Iterator iterator = r.iterator(); iterator.hasNext(); ((Sticker)iterator.next()).a(canvas)) { }
            return bitmap;
        } else
        {
            return null;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        r = com.picsart.studio.editor.view.SavedState.a(parcelable);
        m = SavedState.b(parcelable);
        i = SavedState.c(parcelable);
        j = com.picsart.studio.editor.view.SavedState.d(parcelable);
        k = SavedState.e(parcelable);
        l = SavedState.f(parcelable);
        p.setColorFilter(new ColorMatrixColorFilter(myobfuscated.ay.a.b(4, i)));
        p.setAlpha(j);
        p.setXfermode(com.socialin.android.util.d.a(i));
        if (e != null && !e.isRecycled())
        {
            g();
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 5: default 44
    //                   0 50
    //                   1 121
    //                   2 73
    //                   3 44
    //                   4 44
    //                   5 246;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        s = true;
        t.set(motionevent.getX(), motionevent.getY());
        continue; /* Loop/switch isn't completed */
_L4:
        if (s && Geom.b(t.x, t.y, motionevent.getX(), motionevent.getY()) > o)
        {
            s = false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s)
        {
            u.set(motionevent.getX(), motionevent.getY());
            Camera camera = c;
            PointF pointf = u;
            camera.a(pointf, pointf);
            float f1 = u.x;
            float f2 = u.y;
            if (q != null)
            {
                Sticker sticker = new Sticker(m, i, j, k, f1, f2, l);
                sticker.a(q);
                invalidate();
                r.add(sticker);
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        s = false;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setImage(Bitmap bitmap)
    {
label0:
        {
            super.setImage(bitmap);
            if (bitmap != null)
            {
                if (f == bitmap)
                {
                    f = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                }
                if (!r.isEmpty())
                {
                    break label0;
                }
                float f1 = (float)bitmap.getWidth() / (float)f.getWidth();
                q = new Canvas(f);
                q.scale(1.0F / f1, 1.0F / f1);
            }
            return;
        }
        g();
    }

    public void setStickerBitmap(Bitmap bitmap)
    {
        m = bitmap;
        if (m != null && e != null)
        {
            l = ((float)Math.min(e.getWidth(), e.getHeight()) * 0.2F) / (float)m.getWidth();
        }
        if (l > 1.0F)
        {
            l = 1.0F;
        }
    }

    public void setStickerBlendingMode(int i1)
    {
        k = i1;
        p.setXfermode(com.socialin.android.util.d.a(i1));
    }

    public void setStickerHue(int i1)
    {
        char c1 = '\u0168';
        if (i1 < 0)
        {
            i1 = 0;
        }
        if (i1 > 360)
        {
            i1 = c1;
        }
        i = i1;
        p.setColorFilter(new ColorMatrixColorFilter(myobfuscated.ay.a.b(4, i1)));
    }

    public void setStickerOpacity(int i1)
    {
        j = i1;
        p.setAlpha(i1);
    }

    public void setStickerScale(float f1)
    {
        float f2 = f1;
        if (f1 <= 0.0F)
        {
            f2 = 0.01F;
        }
        l = f2;
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
        private List b;
        private Bitmap c;
        private int d;
        private int e;
        private int f;
        private float g;

        static List a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static Bitmap b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static int c(SavedState savedstate)
        {
            return savedstate.d;
        }

        static int d(SavedState savedstate)
        {
            return savedstate.e;
        }

        static int e(SavedState savedstate)
        {
            return savedstate.f;
        }

        static float f(SavedState savedstate)
        {
            return savedstate.g;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelableArray((Parcelable[])b.toArray(new Sticker[b.size()]), i1);
            parcel.writeParcelable(c, i1);
            parcel.writeInt(d);
            parcel.writeInt(e);
            parcel.writeInt(f);
            parcel.writeFloat(g);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            Parcelable aparcelable[] = parcel.readParcelableArray(com/picsart/studio/editor/helper/Sticker.getClassLoader());
            if (aparcelable == null || aparcelable.length == 0)
            {
                b = new ArrayList();
            } else
            {
                b = new ArrayList(aparcelable.length);
                int j1 = aparcelable.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    Parcelable parcelable = aparcelable[i1];
                    b.add((Sticker)parcelable);
                    i1++;
                }
            }
            c = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
            d = parcel.readInt();
            e = parcel.readInt();
            f = parcel.readInt();
            g = parcel.readFloat();
        }

        public SavedState(Parcelable parcelable, StickerEditorView stickereditorview)
        {
            super(parcelable);
            b = com.picsart.studio.editor.view.StickerEditorView.a(stickereditorview);
            c = StickerEditorView.b(stickereditorview);
            d = StickerEditorView.c(stickereditorview);
            e = com.picsart.studio.editor.view.StickerEditorView.d(stickereditorview);
            f = StickerEditorView.e(stickereditorview);
            g = StickerEditorView.f(stickereditorview);
        }
    }

}
