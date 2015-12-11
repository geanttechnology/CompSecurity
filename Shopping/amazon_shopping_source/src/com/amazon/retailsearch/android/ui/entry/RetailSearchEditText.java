// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.ClearableEditText;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher

public class RetailSearchEditText extends ClearableEditText
{

    private String currentDepartmentName;
    private boolean hasSnapIt;
    private boolean isFlowEnabled;
    private QuerySubmitListener listener;
    protected RetailSearchEditTextWatcher mWatcher;
    RetailSearchAndroidPlatform platform;
    private boolean showBarcodeEntry;
    private boolean showVisualScan;
    private boolean voiceEnabled;

    public RetailSearchEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        showBarcodeEntry = false;
        hasSnapIt = false;
        isFlowEnabled = false;
        RetailSearchDaggerGraphController.inject(this);
        setClearTextButtonPadding(0, getCompoundDrawablePadding());
    }

    public void addTextChangedListener(RetailSearchEditTextWatcher retailsearchedittextwatcher)
    {
        super.addTextChangedListener(retailsearchedittextwatcher);
        mWatcher = retailsearchedittextwatcher;
    }

    protected void doSearch(String s)
    {
        if (listener != null)
        {
            listener.onQuerySubmit(new RetailSearchQuery(s));
        }
    }

    public String getCurrentDepartmentName()
    {
        return currentDepartmentName;
    }

    public RetailSearchEditTextWatcher getTextChangedListener()
    {
        return mWatcher;
    }

    public boolean hasSnapIt()
    {
        return hasSnapIt;
    }

    public boolean isFlowEnabled()
    {
        return isFlowEnabled;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i != 66 && i != 23) goto _L2; else goto _L1
_L1:
        String s = getText().toString().trim();
        if (TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        doSearch(s);
_L5:
        return true;
_L4:
        if (i == 66) goto _L5; else goto _L2
_L2:
        return super.onKeyUp(i, keyevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
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
    }

    public void setCurrentDepartmentName(String s)
    {
        currentDepartmentName = s;
    }

    public void setFlowEnabled(boolean flag)
    {
        isFlowEnabled = flag;
    }

    public void setHasSnapIt(boolean flag)
    {
        hasSnapIt = flag;
    }

    public void setListener(QuerySubmitListener querysubmitlistener)
    {
        listener = querysubmitlistener;
    }

    public void setShowBarcodeEntry(boolean flag)
    {
        showBarcodeEntry = flag;
    }

    public void setShowVisualScan(boolean flag)
    {
        showVisualScan = flag;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public boolean showBarcodeEntry()
    {
        return showBarcodeEntry;
    }

    public boolean showVisualScan()
    {
        return showVisualScan;
    }

    public boolean voiceEnabled()
    {
        return voiceEnabled;
    }
}
