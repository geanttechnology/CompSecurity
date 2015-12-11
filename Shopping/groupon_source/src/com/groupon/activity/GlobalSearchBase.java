// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity

public abstract class GlobalSearchBase extends GrouponFragmentActivity
{

    protected final String SEARCH_TERM = "search_term";
    protected LoggingUtils loggingUtils;
    protected View searchBarContainer;
    protected String searchTerm;
    protected ImageView textSearchClearButton;
    protected EditText textSearchEditText;

    public GlobalSearchBase()
    {
        searchTerm = "";
    }

    protected void clearSearchText()
    {
        onTextClearClicked();
        textSearchEditText.setText("");
        textSearchEditText.requestFocus();
        ViewUtils.setSoftKeyboardState(this, false, textSearchEditText);
    }

    protected String getHintText()
    {
        return getString(0x7f080204);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    protected void initializeTextSearchView()
    {
        if (textSearchEditText == null)
        {
            View view = ActionBarUtil.setCustomView(getSupportActionBar(), 0x7f030108);
            searchBarContainer = view.findViewById(0x7f100306);
            configureShoppingCartIcon();
            textSearchClearButton = (ImageView)view.findViewById(0x7f10009b);
            textSearchClearButton.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchBase this$0;

                public void onClick(View view1)
                {
                    clearSearchText();
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText = (EditText)view.findViewById(0x7f100308);
            textSearchEditText.setHint(getHintText());
            textSearchEditText.addTextChangedListener(new TextWatcher() {

                final GlobalSearchBase this$0;

                public void afterTextChanged(Editable editable)
                {
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                    if (charsequence.toString().isEmpty())
                    {
                        textSearchClearButton.setVisibility(4);
                    } else
                    {
                        textSearchClearButton.setVisibility(0);
                    }
                    onSearchTextChanged(charsequence);
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchBase this$0;

                public void onClick(View view1)
                {
                    onSearchTextBoxClicked();
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final GlobalSearchBase this$0;

                public void onFocusChange(View view1, boolean flag)
                {
                    onFocusChanged(flag);
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

                final GlobalSearchBase this$0;

                public boolean onKey(View view1, int i, KeyEvent keyevent)
                {
                    return onKeyPress(view1, i, keyevent);
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final GlobalSearchBase this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 3)
                    {
                        textSearchEditText.clearFocus();
                        onSearchExecuted(textSearchEditText.getText().toString());
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            });
            textSearchEditText.onWindowFocusChanged(true);
            textSearchEditText.setText(searchTerm);
            if (requestFocusOnInitialize())
            {
                textSearchEditText.requestFocus();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        onRestoreSaveInstanceState(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        initializeTextSearchView();
        return super.onCreateOptionsMenu(menu);
    }

    protected void onFocusChanged(boolean flag)
    {
        if (flag)
        {
            textSearchEditText.postDelayed(new Runnable() {

                final GlobalSearchBase this$0;

                public void run()
                {
                    ViewUtils.setSoftKeyboardState(getApplicationContext(), false, textSearchEditText);
                }

            
            {
                this$0 = GlobalSearchBase.this;
                super();
            }
            }, 500L);
        } else
        {
            ViewUtils.setSoftKeyboardState(getApplicationContext(), true, textSearchEditText);
        }
        onTextSearchFocusChanged(flag);
    }

    protected boolean onKeyPress(View view, int i, KeyEvent keyevent)
    {
        if (i == 66)
        {
            textSearchEditText.clearFocus();
            onSearchExecuted(textSearchEditText.getText().toString());
            return true;
        } else
        {
            return false;
        }
    }

    public void onRestoreSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            searchTerm = bundle.getString("search_term", "");
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("search_term", textSearchEditText.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    protected abstract void onSearchExecuted(String s);

    protected void onSearchTextBoxClicked()
    {
    }

    protected abstract void onSearchTextChanged(CharSequence charsequence);

    protected void onTextClearClicked()
    {
    }

    protected void onTextSearchFocusChanged(boolean flag)
    {
    }

    protected boolean requestFocusOnInitialize()
    {
        return true;
    }
}
