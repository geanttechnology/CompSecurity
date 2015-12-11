// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import com.target.ui.adapter.b.d;
import com.target.ui.util.a;
import com.target.ui.util.al;
import java.util.ArrayList;
import java.util.List;

public class QuantitySpinnerView extends Spinner
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i);
    }


    private static final int DEFAULT_MAXIMUM_QUANTITY = 99;
    private static final int DEFAULT_MINIMUM_QUANTITY = 1;
    private static final int NOT_SET = -1;
    private d mAdapter;
    private int mLastQuantity;
    private int mMaximumQuantity;
    private int mMinimumQuantity;
    private ListPopupWindow mPopup;
    private a mQuantityChangedListener;

    public QuantitySpinnerView(Context context)
    {
        super(context);
        a(context, null);
    }

    public QuantitySpinnerView(Context context, int i)
    {
        super(context, i);
        a(context, null);
    }

    public QuantitySpinnerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public QuantitySpinnerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    public QuantitySpinnerView(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        a(context, attributeset);
    }

    static ListPopupWindow a(QuantitySpinnerView quantityspinnerview)
    {
        return quantityspinnerview.mPopup;
    }

    private void a()
    {
        mPopup = new ListPopupWindow(getContext());
        mAdapter = b();
        mPopup.setAdapter(mAdapter);
        mPopup.setAnchorView(this);
        mPopup.setModal(true);
        int i = (int)getContext().getResources().getDimension(0x7f0a0289);
        mPopup.setWidth(i);
        mPopup.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final QuantitySpinnerView this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                setSelection(j);
                com.target.ui.view.QuantitySpinnerView.a(QuantitySpinnerView.this).dismiss();
            }

            
            {
                this$0 = QuantitySpinnerView.this;
                super();
            }
        });
        mPopup.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {

            final QuantitySpinnerView this$0;

            public void onDismiss()
            {
                if (QuantitySpinnerView.b(QuantitySpinnerView.this) != null)
                {
                    getSelectedItem().toString();
                    QuantitySpinnerView.b(QuantitySpinnerView.this).a();
                    al.b(QuantitySpinnerView.this);
                }
            }

            
            {
                this$0 = QuantitySpinnerView.this;
                super();
            }
        });
    }

    private void a(int i)
    {
        String s = String.format(getResources().getString(0x7f0903a1), new Object[] {
            Integer.valueOf(i)
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.QuantitySpinnerView);
        mMinimumQuantity = context.getInt(0, 1);
        mMaximumQuantity = context.getInt(1, 99);
        mLastQuantity = -1;
        a();
    }

    private d b()
    {
        Object obj = new ArrayList();
        for (int i = mMinimumQuantity; i <= mMaximumQuantity; i++)
        {
            ((List) (obj)).add(Integer.toString(i));
        }

        obj = new d(getContext(), ((List) (obj)));
        ((d) (obj)).setDropDownViewResource(0x1090009);
        setAdapter(((android.widget.SpinnerAdapter) (obj)));
        return ((d) (obj));
    }

    static a b(QuantitySpinnerView quantityspinnerview)
    {
        return quantityspinnerview.mQuantityChangedListener;
    }

    public boolean performClick()
    {
        mPopup.show();
        al.c(this);
        return true;
    }

    public void setQuantityChangedListener(a a1)
    {
        mQuantityChangedListener = a1;
    }

    public void setSelection(int i)
    {
        super.setSelection(i);
        i = Integer.valueOf((String)getItemAtPosition(i)).intValue();
        if (mQuantityChangedListener != null)
        {
            if (i != mLastQuantity)
            {
                mLastQuantity = -1;
                mQuantityChangedListener.a(i);
                a(i);
                setupContentDescription(getSelectedItem().toString());
            }
            mQuantityChangedListener.a();
        }
        mLastQuantity = i;
    }

    public void setValue(int i)
    {
        if (i <= mMaximumQuantity) goto _L2; else goto _L1
_L1:
        int j = mMaximumQuantity;
_L4:
        setupContentDescription(Integer.toString(j));
        super.setSelection(mAdapter.getPosition(Integer.toString(j)));
        return;
_L2:
        j = i;
        if (i < mMinimumQuantity)
        {
            j = mMinimumQuantity;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setupContentDescription(String s)
    {
        setContentDescription(String.format(getResources().getString(0x7f0903a0), new Object[] {
            s
        }));
    }
}
