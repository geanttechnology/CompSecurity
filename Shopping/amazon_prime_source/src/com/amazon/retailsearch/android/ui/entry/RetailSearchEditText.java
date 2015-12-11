// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.ClearableEditText;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            DisplayStateChangeListener, RetailSearchEditTextWatcher

public class RetailSearchEditText extends ClearableEditText
{
    static interface DoSearchListener
    {

        public abstract void doSearch(String s);
    }


    private DisplayStateChangeListener displayStateChangeListener;
    private DoSearchListener doSearchListener;
    private QuerySubmitListener listener;
    protected RetailSearchEditTextWatcher mWatcher;
    RetailSearchAndroidPlatform platform;
    private RetailSearchLogger retailSearchLogger;

    public RetailSearchEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        setClearTextButtonPadding(0, getCompoundDrawablePadding());
    }

    private void showKeyboard()
    {
        platform.invokeLater(new Runnable() {

            final RetailSearchEditText this$0;

            public void run()
            {
                ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(RetailSearchEditText.this, 0);
            }

            
            {
                this$0 = RetailSearchEditText.this;
                super();
            }
        });
    }

    public void addTextChangedListener(RetailSearchEditTextWatcher retailsearchedittextwatcher)
    {
        super.addTextChangedListener(retailsearchedittextwatcher);
        mWatcher = retailsearchedittextwatcher;
    }

    public RetailSearchEditTextWatcher getTextChangedListener()
    {
        return mWatcher;
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (flag)
        {
            showKeyboard();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i != 66 && i != 23) goto _L2; else goto _L1
_L1:
        String s = getText().toString().trim();
        if (TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        if (doSearchListener == null) goto _L6; else goto _L5
_L5:
        doSearchListener.doSearch(s);
_L7:
        return true;
_L6:
        return super.onKeyUp(i, keyevent);
_L4:
        if (i == 66) goto _L7; else goto _L2
_L2:
        return super.onKeyUp(i, keyevent);
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (displayStateChangeListener == null)
        {
            return;
        }
        if (i != 0)
        {
            displayStateChangeListener.onHide();
            return;
        } else
        {
            displayStateChangeListener.onShow();
            return;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            showKeyboard();
        }
    }

    public void setDisplayStateChangeListener(DisplayStateChangeListener displaystatechangelistener)
    {
        displayStateChangeListener = displaystatechangelistener;
    }

    public void setDoSearchListener(DoSearchListener dosearchlistener)
    {
        doSearchListener = dosearchlistener;
    }

    public void setListener(QuerySubmitListener querysubmitlistener)
    {
        listener = querysubmitlistener;
    }
}
