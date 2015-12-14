// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import ay;
import bm;
import cb;
import cc;
import cd;
import ce;
import cg;
import cj;
import db;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsSpinnerCompat

public class SpinnerCompat extends AbsSpinnerCompat
    implements android.content.DialogInterface.OnClickListener
{

    int j;
    private db k;
    private ce l;
    private cc m;
    private int n;
    private boolean o;
    private Rect p;
    private final cg q;

    SpinnerCompat(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, -1);
    }

    SpinnerCompat(Context context, AttributeSet attributeset, int i, int i1)
    {
        cj cj1;
        int j1;
        super(context, attributeset, i);
        p = new Rect();
        cj1 = cj.a(context, attributeset, android.support.v7.appcompat.R.styleable.Spinner, i, 0);
        setBackgroundDrawable(cj1.a(android.support.v7.appcompat.R.styleable.Spinner_android_background));
        j1 = i1;
        if (i1 == -1)
        {
            j1 = cj1.a(android.support.v7.appcompat.R.styleable.Spinner_spinnerMode, 0);
        }
        j1;
        JVM INSTR tableswitch 0 1: default 88
    //                   0 172
    //                   1 188;
           goto _L1 _L2 _L3
_L1:
        n = cj1.a(android.support.v7.appcompat.R.styleable.Spinner_android_gravity, 17);
        l.a(cj1.c(android.support.v7.appcompat.R.styleable.Spinner_prompt));
        o = cj1.a(android.support.v7.appcompat.R.styleable.Spinner_disableChildrenWhenDisabled, false);
        cj1.b();
        if (m != null)
        {
            l.a(m);
            m = null;
        }
        q = cj1.c();
        return;
_L2:
        l = new cb(this);
        continue; /* Loop/switch isn't completed */
_L3:
        context = new cd(this, context, attributeset, i);
        j = cj1.e(android.support.v7.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
        context.a(cj1.a(android.support.v7.appcompat.R.styleable.Spinner_android_popupBackground));
        l = context;
        k = new db(this, context) {

            final cd a;
            final SpinnerCompat b;

            public ListPopupWindow a()
            {
                return a;
            }

            public boolean b()
            {
                if (!SpinnerCompat.a(b).b())
                {
                    SpinnerCompat.a(b).c();
                }
                return true;
            }

            
            {
                b = SpinnerCompat.this;
                a = cd1;
                super(view);
            }
        };
        if (true) goto _L1; else goto _L4
_L4:
    }

    static ce a(SpinnerCompat spinnercompat)
    {
        return spinnercompat.l;
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
        if (o)
        {
            view.setEnabled(isEnabled());
        }
        int i = ViewGroup.getChildMeasureSpec(b, h.top + h.bottom, layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(c, h.left + h.right, layoutparams.width), i);
        i = h.top + (getMeasuredHeight() - h.bottom - h.top - view.getMeasuredHeight()) / 2;
        int i1 = view.getMeasuredHeight();
        view.layout(0, i, view.getMeasuredWidth() + 0, i1 + i);
    }

    private View b(int i, boolean flag)
    {
        if (!mDataChanged)
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
        int l1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i = Math.max(0, getSelectedItemPosition());
        int j2 = Math.min(spinneradapter.getCount(), i + 15);
        int i1 = Math.max(0, i - (15 - (j2 - i)));
        View view = null;
        int j1 = 0;
        i = 0;
        for (; i1 < j2; i1++)
        {
            int k1 = spinneradapter.getItemViewType(i1);
            if (k1 != i)
            {
                view = null;
                i = k1;
            }
            view = spinneradapter.getView(i1, view, this);
            if (view.getLayoutParams() == null)
            {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(l1, i2);
            j1 = Math.max(j1, view.getMeasuredWidth());
        }

        if (drawable != null)
        {
            drawable.getPadding(p);
            return p.left + p.right + j1;
        } else
        {
            return j1;
        }
    }

    void a(int i, boolean flag)
    {
        int i1;
        i = h.left;
        i1 = getRight() - getLeft() - h.left - h.right;
        if (mDataChanged)
        {
            handleDataChanged();
        }
        if (mItemCount == 0)
        {
            a();
            return;
        }
        if (mNextSelectedPosition >= 0)
        {
            setSelectedPositionInt(mNextSelectedPosition);
        }
        b();
        removeAllViewsInLayout();
        mFirstPosition = mSelectedPosition;
        if (a == null) goto _L2; else goto _L1
_L1:
        View view;
        int j1;
        int k1;
        view = b(mSelectedPosition, true);
        j1 = view.getMeasuredWidth();
        k1 = ViewCompat.getLayoutDirection(this);
        GravityCompat.getAbsoluteGravity(n, k1) & 7;
        JVM INSTR lookupswitch 2: default 156
    //                   1: 195
    //                   5: 210;
           goto _L3 _L4 _L5
_L3:
        view.offsetLeftAndRight(i);
_L2:
        this.i.a();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        return;
_L4:
        i = (i + i1 / 2) - j1 / 2;
        continue; /* Loop/switch isn't completed */
_L5:
        i = (i + i1) - j1;
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void a(SpinnerAdapter spinneradapter)
    {
        super.a(spinneradapter);
        i.a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinneradapter != null && spinneradapter.getViewTypeCount() != 1)
        {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        }
        if (l != null)
        {
            l.a(new cc(spinneradapter));
            return;
        } else
        {
            m = new cc(spinneradapter);
            return;
        }
    }

    void a(bm bm)
    {
        super.setOnItemClickListener(bm);
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
            int i1 = view.getBaseline();
            i = byte0;
            if (i1 >= 0)
            {
                i = view.getTop() + i1;
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
                view = b(0, false);
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
        if (l != null && l.b())
        {
            l.a();
        }
    }

    protected void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        super.onLayout(flag, i, i1, j1, k1);
        mInLayout = true;
        a(0, false);
        mInLayout = false;
    }

    protected void onMeasure(int i, int i1)
    {
        super.onMeasure(i, i1);
        if (l != null && android.view.View.MeasureSpec.getMode(i) == 0x80000000)
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
                        if (!SpinnerCompat.a(a).b())
                        {
                            SpinnerCompat.a(a).c();
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
        if (l != null && l.b())
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
        if (k != null && k.onTouch(this, motionevent))
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
            if (!l.b())
            {
                l.c();
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
        if (o)
        {
            int i1 = getChildCount();
            for (int i = 0; i < i1; i++)
            {
                getChildAt(i).setEnabled(flag);
            }

        }
    }

    public void setOnItemClickListener(bm bm)
    {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    private class SavedState extends AbsSpinnerCompat.SavedState
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

}
