// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.a;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.dialog.b;
import com.socialin.android.util.Geom;
import com.socialin.android.util.w;
import java.util.Set;

// Referenced classes of package com.picsart.studio.editor.view:
//            f

public class EditorView extends View
{

    protected static final Paint a = new Paint(3);
    protected static final Paint b = new Paint();
    protected Camera c;
    protected RectF d;
    protected Bitmap e;
    protected Bitmap f;
    protected int g;
    protected int h;
    private boolean i;
    private RectF j;
    private RectF k;
    private d l;
    private boolean m;
    private BitmapDrawable n;
    private final a o;

    public EditorView(Context context)
    {
        this(context, null);
    }

    public EditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public EditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        j = new RectF();
        d = new RectF();
        k = new RectF();
        o = new a(this);
        if (c == null)
        {
            c = Camera.a();
        }
        c.a(o);
        i = false;
        m = true;
        attributeset = new f(this, (byte)0);
        context = new g(attributeset);
        context.a = 0.0F;
        attributeset = new com.socialin.android.brushlib.input.gesture.a(attributeset);
        l = new d();
        l.a(context);
        l.a(attributeset);
        n = (BitmapDrawable)getResources().getDrawable(0x7f02011f);
        if (n != null)
        {
            n.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
        }
        new Rect();
    }

    private void a(RectF rectf)
    {
        float f4 = 0.0F;
        if (e != null)
        {
            d.set(0.0F, 0.0F, e.getWidth(), e.getHeight());
            c.a(d);
            float f1;
            float f2;
            float f3;
            if (d.left > j.left)
            {
                f1 = Geom.a((d.left - j.left) / (j.width() / 4F), 0.0F, 1.0F);
            } else
            {
                f1 = 0.0F;
            }
            if (d.right < j.right)
            {
                f2 = Geom.a((j.right - d.right) / (j.width() / 4F), 0.0F, 1.0F);
            } else
            {
                f2 = 0.0F;
            }
            if (d.top > j.top)
            {
                f3 = Geom.a((d.top - j.top) / (j.height() / 4F), 0.0F, 1.0F);
            } else
            {
                f3 = 0.0F;
            }
            if (d.bottom < j.bottom)
            {
                f4 = Geom.a((j.bottom - d.bottom) / (j.height() / 4F), 0.0F, 1.0F);
            }
            rectf.top = f3;
            rectf.left = f1;
            rectf.right = f2;
            rectf.bottom = f4;
        }
    }

    static void a(EditorView editorview, float f1)
    {
label0:
        {
            if (editorview.d())
            {
                editorview.a(editorview.k);
                if (f1 >= 1.0F)
                {
                    break label0;
                }
                float f2 = Math.max(Math.max(Math.max(editorview.k.left, editorview.k.top), editorview.k.right), editorview.k.bottom);
                editorview = editorview.c;
                editorview.e = (f2 + (1.0F - f2) * f1) * ((Camera) (editorview)).e;
                editorview.c();
                f1 = ((Camera) (editorview)).e;
            }
            return;
        }
        editorview.c.a(Math.min(editorview.c.e * f1, 5F));
    }

    static void a(EditorView editorview, float f1, float f2)
    {
        if (editorview.d())
        {
            editorview.a(editorview.k);
            Camera camera;
            if (f1 >= 0.0F)
            {
                f1 = (1.0F - editorview.k.left) * f1;
            } else
            {
                f1 = (1.0F - editorview.k.right) * f1;
            }
            if (f2 >= 0.0F)
            {
                f2 = (1.0F - editorview.k.top) * f2;
            } else
            {
                f2 = (1.0F - editorview.k.bottom) * f2;
            }
            camera = editorview.c;
            f1 = -f1 / editorview.c.e;
            f2 = -f2 / editorview.c.e;
            camera.c = f1 + camera.c;
            camera.d = f2 + camera.d;
            camera.b();
        }
    }

    static boolean a(EditorView editorview)
    {
        return editorview.m;
    }

    public final int a()
    {
        return g;
    }

    protected void a(Canvas canvas)
    {
        if (e != null)
        {
            c.b(canvas);
            canvas.scale((float)e.getWidth() / (float)f.getWidth(), (float)e.getHeight() / (float)f.getHeight());
            canvas.drawBitmap(f, 0.0F, 0.0F, null);
            canvas.restore();
        }
    }

    public void a(boolean flag)
    {
        float f1 = getWidth();
        float f3 = getHeight();
        RectF rectf = new RectF(getPaddingLeft(), getPaddingTop(), f1 - (float)getPaddingRight(), f3 - (float)getPaddingBottom());
        c.a(f1, f3);
        if (e != null)
        {
            RectF rectf1 = new RectF(0.0F, 0.0F, e.getWidth(), e.getHeight());
            float f2 = c.c;
            float f4 = c.d;
            float f5 = c.e;
            c.a(rectf1, rectf, com.picsart.studio.editor.Camera.ScaleToFit.CENTER);
            j.set(rectf1);
            c.a(j);
            c.a(Math.min(c.e, 5F));
            if (!flag)
            {
                c.b(f2, f4);
                c.a(f5);
            }
            i = true;
        }
    }

    public final int b()
    {
        return h;
    }

    public final Camera c()
    {
        return c;
    }

    protected boolean d()
    {
        return true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (c != null)
        {
            Camera camera = c;
            a a1 = o;
            camera.f.remove(a1);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isInEditMode())
        {
            canvas.drawColor(0xffff0000);
        } else
        if (e != null)
        {
            a(canvas);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        if (com.picsart.studio.editor.view.SavedState.a(parcelable) != null)
        {
            c = com.picsart.studio.editor.view.SavedState.a(parcelable);
            c.a(o);
            i = true;
        }
        g = com.picsart.studio.editor.view.SavedState.b(parcelable);
        h = SavedState.c(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        boolean flag;
        if (!i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        l.a(motionevent);
        return true;
    }

    public void setImage(Bitmap bitmap)
    {
        boolean flag;
        if (e != null && bitmap != null && e.getWidth() == bitmap.getWidth() && e.getHeight() == bitmap.getHeight())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        e = bitmap;
        if (bitmap != null)
        {
            g = bitmap.getWidth();
            h = bitmap.getHeight();
            try
            {
                f = w.f(bitmap, 2048);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                bitmap = new b();
                bitmap.b = getResources().getString(0x7f08094d);
                bitmap = bitmap.a(getContext().getString(0x7f080311), new android.view.View.OnClickListener() {

                    private EditorView a;

                    public final void onClick(View view)
                    {
                        try
                        {
                            a.f = w.f(a.e, 1024);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view = new b();
                        }
                        view.b = a.getResources().getString(0x7f08094e);
                        view.h = false;
                        view.a().show(((Activity)a.getContext()).getFragmentManager(), null);
                        a.f = a.e;
                        System.gc();
                    }

            
            {
                a = EditorView.this;
                super();
            }
                });
                bitmap.h = false;
                bitmap.a().show(((Activity)getContext()).getFragmentManager(), null);
                System.gc();
            }
        }
        if (flag && getWidth() > 0 && getHeight() > 0)
        {
            a(true);
        }
    }

    public void setSinglePointerGestureEnabled(boolean flag)
    {
        m = flag;
    }

    static 
    {
        com/picsart/studio/editor/view/EditorView.getSimpleName();
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
        private Camera b;
        private int c;
        private int d;

        static Camera a(SavedState savedstate)
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

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(b, i1);
            parcel.writeInt(c);
            parcel.writeInt(d);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = (Camera)parcel.readParcelable(com/picsart/studio/editor/Camera.getClassLoader());
            c = parcel.readInt();
            d = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, EditorView editorview)
        {
            super(parcelable);
            b = editorview.c;
            c = editorview.g;
            d = editorview.h;
        }
    }

}
