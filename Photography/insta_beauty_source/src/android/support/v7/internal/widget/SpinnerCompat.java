// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import ab;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import bw;
import cv;
import dl;
import dm;
import dn;
import do;
import dp;
import ds;
import du;
import dx;
import ez;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsSpinnerCompat

public class SpinnerCompat extends AbsSpinnerCompat
    implements android.content.DialogInterface.OnClickListener
{

    int j;
    private ez k;
    private ds l;
    private do m;
    private int n;
    private boolean o;
    private Rect p;
    private final du q;

    SpinnerCompat(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, -1);
    }

    SpinnerCompat(Context context, AttributeSet attributeset, int i, int i1)
    {
        dx dx1;
        int j1;
        super(context, attributeset, i);
        p = new Rect();
        dx1 = dx.a(context, attributeset, ab.Spinner, i, 0);
        setBackgroundDrawable(dx1.a(ab.Spinner_android_background));
        j1 = i1;
        if (i1 == -1)
        {
            j1 = dx1.a(ab.Spinner_spinnerMode, 0);
        }
        j1;
        JVM INSTR tableswitch 0 1: default 88
    //                   0 172
    //                   1 188;
           goto _L1 _L2 _L3
_L1:
        n = dx1.a(ab.Spinner_android_gravity, 17);
        l.a(dx1.c(ab.Spinner_prompt));
        o = dx1.a(ab.Spinner_disableChildrenWhenDisabled, false);
        dx1.b();
        if (m != null)
        {
            l.a(m);
            m = null;
        }
        q = dx1.c();
        return;
_L2:
        l = new dn(this, null);
        continue; /* Loop/switch isn't completed */
_L3:
        context = new dp(this, context, attributeset, i);
        j = dx1.e(ab.Spinner_android_dropDownWidth, -2);
        context.a(dx1.a(ab.Spinner_android_popupBackground));
        l = context;
        k = new dl(this, this, context);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static ds a(SpinnerCompat spinnercompat)
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
            l.a(new do(spinneradapter));
            return;
        } else
        {
            m = new do(spinneradapter);
            return;
        }
    }

    void a(cv cv)
    {
        super.setOnItemClickListener(cv);
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
                parcelable.addOnGlobalLayoutListener(new dm(this));
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

    public void setOnItemClickListener(cv cv)
    {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    private class SavedState extends AbsSpinnerCompat.SavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new dr();
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

        public SavedState(Parcel parcel, dl dl1)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
