// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class PaypalEmailAutoComplete extends AppCompatAutoCompleteTextView
{

    private boolean isClearingFocus;

    public PaypalEmailAutoComplete(Context context)
    {
        super(context);
    }

    public PaypalEmailAutoComplete(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOnClickListener(new android.view.View.OnClickListener() {

            final PaypalEmailAutoComplete this$0;

            public void onClick(View view)
            {
                if (!isPopupShowing())
                {
                    forceSuggestionQuery();
                }
            }

            
            {
                this$0 = PaypalEmailAutoComplete.this;
                super();
            }
        });
        setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final PaypalEmailAutoComplete this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    forceSuggestionQuery();
                }
            }

            
            {
                this$0 = PaypalEmailAutoComplete.this;
                super();
            }
        });
        setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final PaypalEmailAutoComplete this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 6)
                {
                    clearFocus();
                    dismissDropDown();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = PaypalEmailAutoComplete.this;
                super();
            }
        });
    }

    public PaypalEmailAutoComplete(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void hideIme()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
        if (inputmethodmanager != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void clearFocus()
    {
        isClearingFocus = true;
        hideIme();
        super.clearFocus();
        isClearingFocus = false;
    }

    public boolean enoughToFilter()
    {
        return true;
    }

    protected void forceSuggestionQuery()
    {
        android.text.Editable editable = getText();
        setTextKeepState((new StringBuilder()).append(editable).append(".").toString());
        setTextKeepState(editable);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
                if (dispatcherstate != null)
                {
                    dispatcherstate.startTracking(keyevent, this);
                }
                return true;
            }
            if (keyevent.getAction() == 1)
            {
                android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
                if (dispatcherstate1 != null)
                {
                    dispatcherstate1.handleUpEvent(keyevent);
                }
                if (keyevent.isTracking() && !keyevent.isCanceled())
                {
                    clearFocus();
                    dismissDropDown();
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void performCompletion()
    {
    }

    protected void replaceText(CharSequence charsequence)
    {
        super.replaceText(charsequence);
        clearFocus();
    }

    public boolean requestFocus(int i, Rect rect)
    {
        if (isClearingFocus)
        {
            return false;
        } else
        {
            return super.requestFocus(i, rect);
        }
    }
}
