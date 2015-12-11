// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.control.search.AdvSearchResultsBrowser;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.voice.MShopVoicePackageProxy;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity

public abstract class SearchBar extends LinearLayout
{

    private static final String TAG = com/amazon/mShop/SearchBar.getSimpleName();
    private AmazonActivity mActivity;
    private boolean mIsFirstTimeEnter;
    private boolean mIsTapped;
    private View mSearchBar;
    private View mSearchBarPlate;
    private ImageView mSearchBarcode;
    private EditText mSearchInput;

    public SearchBar(Context context)
    {
        super(context);
        mIsTapped = false;
        mActivity = (AmazonActivity)context;
        mIsFirstTimeEnter = true;
        initSearchBar();
    }

    public SearchBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsTapped = false;
        mActivity = (AmazonActivity)context;
        mIsFirstTimeEnter = true;
    }

    private void setupVoiceSearch()
    {
        if (!voiceAllowed() || !MShopVoiceModule.getInstance().voiceSearchInNavEnabled()) goto _L2; else goto _L1
_L1:
        Object obj = (ViewStub)findViewById(com.amazon.mShop.android.lib.R.id.vs_nav_voice_btn_stub);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        ((ViewStub) (obj)).inflate();
        obj = findViewById(com.amazon.mShop.android.lib.R.id.vs_nav_voice_btn);
        if (obj != null) goto _L4; else goto _L3
_L3:
        Log.e(TAG, "Voice button not found");
_L5:
        if (mSearchBarcode == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        if (voiceAllowed() && !MShopVoiceModule.getInstance().barcodeSearchEnabled())
        {
            mSearchBarcode.setVisibility(8);
            return;
        }
        break MISSING_BLOCK_LABEL_143;
_L4:
        try
        {
            ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final SearchBar this$0;

                public void onClick(View view)
                {
                    if (view == null)
                    {
                        break MISSING_BLOCK_LABEL_14;
                    }
                    if (view.getContext() instanceof Activity)
                    {
                        break MISSING_BLOCK_LABEL_24;
                    }
                    Log.e(SearchBar.TAG, "Invalid context");
                    return;
                    try
                    {
                        MShopVoicePackageProxy.getInstance().openVoiceSearch((Activity)view.getContext(), false);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        Log.e(SearchBar.TAG, "Error", view);
                    }
                    return;
                }

            
            {
                this$0 = SearchBar.this;
                super();
            }
            });
            ((View) (obj)).setVisibility(0);
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to setup voice in search bar", exception);
            return;
        }
          goto _L5
_L2:
        exception = findViewById(com.amazon.mShop.android.lib.R.id.vs_nav_voice_btn);
        if (exception == null) goto _L5; else goto _L6
_L6:
        exception.setVisibility(8);
          goto _L5
        mSearchBarcode.setVisibility(0);
    }

    protected void checkPreviousSearchTerm()
    {
        Object obj = SearchActivity.getPreviousSearchTerm();
        if (obj != null)
        {
            mSearchInput.setTextKeepState(((CharSequence) (obj)));
            obj = mSearchInput.getText();
            Selection.setSelection(((android.text.Spannable) (obj)), ((Editable) (obj)).length());
        }
    }

    protected void doBarcodeScan()
    {
        Intent intent = getBarcodeScanIntent();
        mActivity.startActivity(intent);
    }

    protected Intent getBarcodeScanIntent()
    {
        Intent intent = new Intent(getContext(), com/amazon/mShop/search/SearchActivity);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("BARCODE_SEARCH_QUERY_KEYWORD"));
        return intent;
    }

    public View getSearchBar()
    {
        return mSearchBar;
    }

    public ImageView getSearchBarcodeView()
    {
        return mSearchBarcode;
    }

    public EditText getSearchInputView()
    {
        return mSearchInput;
    }

    public TextWatcher getTextWatcher()
    {
        return new TextWatcher() {

            final SearchBar this$0;

            public void afterTextChanged(Editable editable)
            {
                if (editable.length() == 0)
                {
                    SearchActivity.setPreviousSearchTerm("");
                } else
                if (!editable.toString().equals(SearchActivity.getPreviousSearchTerm()))
                {
                    goToSearchEntry(editable.toString(), false);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SearchBar.this;
                super();
            }
        };
    }

    protected void goToSearchEntry(String s, boolean flag)
    {
        mActivity.onSearchRequested(s, flag);
    }

    protected void initSearchBar()
    {
        mSearchBar = LayoutInflater.from(mActivity).inflate(com.amazon.mShop.android.lib.R.layout.search_bar, null);
        mSearchBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        addView(mSearchBar);
        ((ImageView)mSearchBar.findViewById(com.amazon.mShop.android.lib.R.id.search_mag_glass)).setImageResource(com.amazon.mShop.android.lib.R.drawable.search_bar_mag_glass);
        mSearchBarPlate = mSearchBar.findViewById(com.amazon.mShop.android.lib.R.id.search_bar_plate);
        mSearchInput = (EditText)mSearchBar.findViewById(com.amazon.mShop.android.lib.R.id.search_edit_text);
        mSearchBarcode = (ImageView)mSearchBar.findViewById(com.amazon.mShop.android.lib.R.id.search_right_barcode_btn);
        setupVoiceSearch();
        mSearchBarPlate.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchBar this$0;

            public void onClick(View view)
            {
                goToSearchEntry(null, true);
                logRefMarker();
                mIsTapped = true;
            }

            
            {
                this$0 = SearchBar.this;
                super();
            }
        });
        mSearchBarcode.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SearchBar this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    doBarcodeScan();
                    mSearchBarcode.setBackgroundResource(com.amazon.mShop.android.lib.R.color.transparent);
                    return true;
                } else
                {
                    mSearchBarcode.setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.action_bar_icon_round_corner_pressed);
                    return true;
                }
            }

            
            {
                this$0 = SearchBar.this;
                super();
            }
        });
        mSearchInput.setOnKeyListener(new android.view.View.OnKeyListener() {

            final SearchBar this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                boolean flag = false;
                if (66 == i || 23 == i)
                {
                    if (1 == keyevent.getAction())
                    {
                        view = mSearchInput.getEditableText().toString();
                        if (!Util.isEmpty(view) && 66 == i)
                        {
                            startSearch();
                        } else
                        {
                            goToSearchEntry(view, true);
                        }
                        logRefMarker();
                        mSearchBarPlate.setPressed(false);
                        mIsTapped = true;
                    } else
                    {
                        mSearchBarPlate.setPressed(true);
                    }
                    flag = true;
                }
                return flag;
            }

            
            {
                this$0 = SearchBar.this;
                super();
            }
        });
        mSearchInput.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SearchBar this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    goToSearchEntry(null, true);
                    logRefMarker();
                    mSearchBarPlate.setPressed(false);
                    mIsTapped = true;
                    return true;
                } else
                {
                    mSearchBarPlate.setPressed(true);
                    return true;
                }
            }

            
            {
                this$0 = SearchBar.this;
                super();
            }
        });
        mSearchInput.addTextChangedListener(getTextWatcher());
        checkPreviousSearchTerm();
    }

    public abstract void logRefMarker();

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initSearchBar();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (flag)
        {
            if (mIsFirstTimeEnter)
            {
                mIsFirstTimeEnter = false;
                requestFocus();
            }
            checkPreviousSearchTerm();
            setupVoiceSearch();
        }
    }

    protected void startSearch()
    {
        Object obj = mSearchInput.getText();
        if (obj != null)
        {
            obj = AdvSearchResultsBrowser.validateQuery(obj.toString());
            if (!Util.isEmpty(((String) (obj))))
            {
                AmazonActivity amazonactivity = (AmazonActivity)getContext();
                SearchIntentBuilder searchintentbuilder = new SearchIntentBuilder(amazonactivity);
                searchintentbuilder.query(((String) (obj)));
                amazonactivity.startActivity(searchintentbuilder.build());
            }
        }
    }

    protected boolean voiceAllowed()
    {
        return true;
    }



/*
    static boolean access$002(SearchBar searchbar, boolean flag)
    {
        searchbar.mIsTapped = flag;
        return flag;
    }

*/




}
