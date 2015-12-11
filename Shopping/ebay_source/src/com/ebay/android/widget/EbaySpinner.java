// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;

// Referenced classes of package com.ebay.android.widget:
//            Spinner

public class EbaySpinner extends Spinner
{
    public static interface OnPerformClick
    {

        public abstract void onSpinnerClick(int i);
    }

    public static interface OnUserSelectionChanged
    {

        public abstract void onChange(int i, Object obj);
    }


    private OnPerformClick clickListener;
    private OnUserSelectionChanged listener;

    public EbaySpinner(Context context)
    {
        this(context, null);
    }

    public EbaySpinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010081);
    }

    public EbaySpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (listener != null)
        {
            Object obj = getAdapter();
            if ((obj instanceof BaseAdapter) && !((BaseAdapter)obj).isEnabled(i))
            {
                return;
            }
            obj = getSelectedItem();
            Object obj1 = getItemAtPosition(i);
            if (obj == null || obj1 == null || !obj.equals(obj1))
            {
                listener.onChange(getId(), obj1);
            }
        }
        super.onClick(dialoginterface, i);
    }

    public boolean performClick()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        if (clickListener != null)
        {
            clickListener.onSpinnerClick(getId());
        }
        return super.performClick();
    }

    public void setChangeListener(OnUserSelectionChanged onuserselectionchanged)
    {
        listener = onuserselectionchanged;
    }

    public void setClickListener(OnPerformClick onperformclick)
    {
        clickListener = onperformclick;
    }
}
