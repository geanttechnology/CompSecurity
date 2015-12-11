// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.support.v4.view.f;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsSpinnerCompat, q, p

class SpinnerCompat extends AbsSpinnerCompat
    implements android.content.DialogInterface.OnClickListener
{
    static class SavedState extends AbsSpinnerCompat.SavedState
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
        boolean c;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            if (c)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c = flag;
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    private class a
        implements android.content.DialogInterface.OnClickListener, d
    {

        final SpinnerCompat a;
        private AlertDialog b;
        private ListAdapter c;
        private CharSequence d;

        public void a(CharSequence charsequence)
        {
            d = charsequence;
        }

        public void dismiss()
        {
            if (b != null)
            {
                b.dismiss();
                b = null;
            }
        }

        public boolean isShowing()
        {
            if (b != null)
            {
                return b.isShowing();
            } else
            {
                return false;
            }
        }

        public void onClick(DialogInterface dialoginterface, int i)
        {
            a.setSelection(i);
            if (a.s != null)
            {
                a.a(null, i, c.getItemId(i));
            }
            dismiss();
        }

        public void setAdapter(ListAdapter listadapter)
        {
            c = listadapter;
        }

        public void show()
        {
            if (c == null)
            {
                return;
            }
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a.getContext());
            if (d != null)
            {
                builder.setTitle(d);
            }
            b = builder.setSingleChoiceItems(c, a.getSelectedItemPosition(), this).create();
            b.show();
        }

        private a()
        {
            a = SpinnerCompat.this;
            super();
        }

    }

    private static class b
        implements ListAdapter, SpinnerAdapter
    {

        private SpinnerAdapter a;
        private ListAdapter b;

        public boolean areAllItemsEnabled()
        {
            ListAdapter listadapter = b;
            if (listadapter != null)
            {
                return listadapter.areAllItemsEnabled();
            } else
            {
                return true;
            }
        }

        public int getCount()
        {
            if (a == null)
            {
                return 0;
            } else
            {
                return a.getCount();
            }
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            if (a == null)
            {
                return null;
            } else
            {
                return a.getDropDownView(i, view, viewgroup);
            }
        }

        public Object getItem(int i)
        {
            if (a == null)
            {
                return null;
            } else
            {
                return a.getItem(i);
            }
        }

        public long getItemId(int i)
        {
            if (a == null)
            {
                return -1L;
            } else
            {
                return a.getItemId(i);
            }
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            return getDropDownView(i, view, viewgroup);
        }

        public int getViewTypeCount()
        {
            return 1;
        }

        public boolean hasStableIds()
        {
            return a != null && a.hasStableIds();
        }

        public boolean isEmpty()
        {
            return getCount() == 0;
        }

        public boolean isEnabled(int i)
        {
            ListAdapter listadapter = b;
            if (listadapter != null)
            {
                return listadapter.isEnabled(i);
            } else
            {
                return true;
            }
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver)
        {
            if (a != null)
            {
                a.registerDataSetObserver(datasetobserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver)
        {
            if (a != null)
            {
                a.unregisterDataSetObserver(datasetobserver);
            }
        }

        public b(SpinnerAdapter spinneradapter)
        {
            a = spinneradapter;
            if (spinneradapter instanceof ListAdapter)
            {
                b = (ListAdapter)spinneradapter;
            }
        }
    }

    private class c extends ListPopupWindow
        implements d
    {

        final SpinnerCompat a;
        private CharSequence b;
        private ListAdapter c;

        static ListAdapter a(c c1)
        {
            return c1.c;
        }

        public void a(CharSequence charsequence)
        {
            b = charsequence;
        }

        public void setAdapter(ListAdapter listadapter)
        {
            super.setAdapter(listadapter);
            c = listadapter;
        }

        public c(Context context, AttributeSet attributeset, int i)
        {
            a = SpinnerCompat.this;
            super(context, attributeset, i);
            setAnchorView(SpinnerCompat.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new _cls1(this, SpinnerCompat.this));
        }
    }

    private static interface d
    {

        public abstract void a(CharSequence charsequence);

        public abstract void dismiss();

        public abstract boolean isShowing();

        public abstract void setAdapter(ListAdapter listadapter);

        public abstract void show();
    }


    int E;
    private android.support.v7.widget.ListPopupWindow.ForwardingListener F;
    private d G;
    private b H;
    private int I;
    private boolean J;
    private Rect K;
    private final p L;

    SpinnerCompat(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, -1);
    }

    SpinnerCompat(Context context, AttributeSet attributeset, int i, int j)
    {
        q q1;
        int k;
        super(context, attributeset, i);
        K = new Rect();
        q1 = q.a(context, attributeset, android.support.v7.br.k.Spinner, i, 0);
        if (q1.e(android.support.v7.br.k.Spinner_android_background))
        {
            setBackgroundDrawable(q1.a(android.support.v7.br.k.Spinner_android_background));
        }
        k = j;
        if (j == -1)
        {
            k = q1.a(android.support.v7.br.k.Spinner_spinnerMode, 0);
        }
        k;
        JVM INSTR tableswitch 0 1: default 100
    //                   0 184
    //                   1 200;
           goto _L1 _L2 _L3
_L1:
        I = q1.a(android.support.v7.br.k.Spinner_android_gravity, 17);
        G.a(q1.d(android.support.v7.br.k.Spinner_prompt));
        J = q1.a(android.support.v7.br.k.Spinner_disableChildrenWhenDisabled, false);
        q1.b();
        if (H != null)
        {
            G.setAdapter(H);
            H = null;
        }
        L = q1.c();
        return;
_L2:
        G = new a();
        continue; /* Loop/switch isn't completed */
_L3:
        context = new c(context, attributeset, i);
        E = q1.e(android.support.v7.br.k.Spinner_android_dropDownWidth, -2);
        context.setBackgroundDrawable(q1.a(android.support.v7.br.k.Spinner_android_popupBackground));
        G = context;
        F = new android.support.v7.widget.ListPopupWindow.ForwardingListener(this, context) {

            final c a;
            final SpinnerCompat b;

            public ListPopupWindow getPopup()
            {
                return a;
            }

            public boolean onForwardingStarted()
            {
                if (!SpinnerCompat.a(b).isShowing())
                {
                    SpinnerCompat.a(b).show();
                }
                return true;
            }

            
            {
                b = SpinnerCompat.this;
                a = c1;
                super(view);
            }
        };
        if (true) goto _L1; else goto _L4
_L4:
    }

    static d a(SpinnerCompat spinnercompat)
    {
        return spinnercompat.G;
    }

    private void a(View view, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = generateDefaultLayoutParams();
        }
        if (flag)
        {
            addViewInLayout(view, 0, layoutparams);
        }
        view.setSelected(hasFocus());
        if (J)
        {
            view.setEnabled(isEnabled());
        }
        int i = ViewGroup.getChildMeasureSpec(b, h.top + h.bottom, layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(c, h.left + h.right, layoutparams.width), i);
        i = h.top + (getMeasuredHeight() - h.bottom - h.top - view.getMeasuredHeight()) / 2;
        int j = view.getMeasuredHeight();
        view.layout(0, i, view.getMeasuredWidth() + 0, j + i);
    }

    private View c(int i, boolean flag)
    {
        if (!u)
        {
            View view = this.i.a(i);
            if (view != null)
            {
                a(view, flag);
                return view;
            }
        }
        View view1 = a.getView(i, null, this);
        a(view1, flag);
        return view1;
    }

    int a(SpinnerAdapter spinneradapter, Drawable drawable)
    {
        if (spinneradapter == null)
        {
            return 0;
        }
        int i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i = Math.max(0, getSelectedItemPosition());
        int k1 = Math.min(spinneradapter.getCount(), i + 15);
        int j = Math.max(0, i - (15 - (k1 - i)));
        View view = null;
        int k = 0;
        i = 0;
        for (; j < k1; j++)
        {
            int l = spinneradapter.getItemViewType(j);
            if (l != i)
            {
                view = null;
                i = l;
            }
            view = spinneradapter.getView(j, view, this);
            if (view.getLayoutParams() == null)
            {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(i1, j1);
            k = Math.max(k, view.getMeasuredWidth());
        }

        if (drawable != null)
        {
            drawable.getPadding(K);
            return K.left + K.right + k;
        } else
        {
            return k;
        }
    }

    void a(int i, boolean flag)
    {
        int j;
        i = h.left;
        j = getRight() - getLeft() - h.left - h.right;
        if (u)
        {
            g();
        }
        if (z == 0)
        {
            a();
            return;
        }
        if (v >= 0)
        {
            setSelectedPositionInt(v);
        }
        b();
        removeAllViewsInLayout();
        this.j = x;
        if (a == null) goto _L2; else goto _L1
_L1:
        View view;
        int k;
        int l;
        view = c(x, true);
        k = view.getMeasuredWidth();
        l = ah.g(this);
        f.a(I, l) & 7;
        JVM INSTR lookupswitch 2: default 156
    //                   1: 195
    //                   5: 210;
           goto _L3 _L4 _L5
_L3:
        view.offsetLeftAndRight(i);
_L2:
        this.i.a();
        invalidate();
        h();
        u = false;
        o = false;
        setNextSelectedPositionInt(x);
        return;
_L4:
        i = (i + j / 2) - k / 2;
        continue; /* Loop/switch isn't completed */
_L5:
        i = (i + j) - k;
        if (true) goto _L3; else goto _L6
_L6:
    }

    void a(e.b b1)
    {
        super.setOnItemClickListener(b1);
    }

    public void a(SpinnerAdapter spinneradapter)
    {
        super.a(spinneradapter);
        i.a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinneradapter != null && spinneradapter.getViewTypeCount() != 1)
        {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        }
        if (G != null)
        {
            G.setAdapter(new b(spinneradapter));
            return;
        } else
        {
            H = new b(spinneradapter);
            return;
        }
    }

    public int getBaseline()
    {
        Object obj;
        byte byte0;
        byte0 = -1;
        obj = null;
        if (getChildCount() <= 0) goto _L2; else goto _L1
_L1:
        View view = getChildAt(0);
_L4:
        int i = byte0;
        if (view != null)
        {
            int j = view.getBaseline();
            i = byte0;
            if (j >= 0)
            {
                i = view.getTop() + j;
            }
        }
        return i;
_L2:
        view = obj;
        if (a != null)
        {
            view = obj;
            if (a.getCount() > 0)
            {
                view = c(0, false);
                this.i.a(0, view);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        setSelection(i);
        dialoginterface.dismiss();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (G != null && G.isShowing())
        {
            G.dismiss();
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        q = true;
        a(0, false);
        q = false;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (G != null && android.view.View.MeasureSpec.getMode(i) == 0x80000000)
        {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(c(), getBackground())), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (((SavedState) (parcelable)).c)
        {
            parcelable = getViewTreeObserver();
            if (parcelable != null)
            {
                parcelable.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final SpinnerCompat a;

                    public void onGlobalLayout()
                    {
                        if (!SpinnerCompat.a(a).isShowing())
                        {
                            SpinnerCompat.a(a).show();
                        }
                        ViewTreeObserver viewtreeobserver = a.getViewTreeObserver();
                        if (viewtreeobserver != null)
                        {
                            viewtreeobserver.removeGlobalOnLayoutListener(this);
                        }
                    }

            
            {
                a = SpinnerCompat.this;
                super();
            }
                });
            }
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        boolean flag;
        if (G != null && G.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        savedstate.c = flag;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (F != null && F.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public boolean performClick()
    {
        boolean flag1 = super.performClick();
        boolean flag = flag1;
        if (!flag1)
        {
            boolean flag2 = true;
            flag = flag2;
            if (!G.isShowing())
            {
                G.show();
                flag = flag2;
            }
        }
        return flag;
    }

    public void setAdapter(Adapter adapter)
    {
        a((SpinnerAdapter)adapter);
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        if (J)
        {
            int j = getChildCount();
            for (int i = 0; i < j; i++)
            {
                getChildAt(i).setEnabled(flag);
            }

        }
    }

    public void setOnItemClickListener(e.b b1)
    {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    // Unreferenced inner class android/support/v7/internal/widget/SpinnerCompat$c$1

/* anonymous class */
    class c._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SpinnerCompat a;
        final c b;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            b.a.setSelection(i);
            if (b.a.s != null)
            {
                b.a.a(view, i, c.a(b).getItemId(i));
            }
            b.dismiss();
        }

            
            {
                b = c1;
                a = spinnercompat;
                super();
            }
    }

}
