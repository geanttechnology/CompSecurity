// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.tabs.FragmentTabHost;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, BaseSearchFragment, UserSearchFragment, TagSearchFragment

public class SearchActivity extends BaseControllerActionBarActivity
    implements android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, TextWatcher
{

    public static final String TAB_TAGS = "tags";
    public static final String TAB_USERS = "users";
    private ImageButton mClear;
    private WeakReference mCurrentFragment;
    private EditText mQuery;
    private FragmentTabHost mTabHost;

    public SearchActivity()
    {
    }

    private void performSearch()
    {
        mQuery.clearFocus();
        Util.setSoftKeyboardVisibility(this, mQuery, false);
        if (mCurrentFragment != null && mCurrentFragment.get() != null)
        {
            ((BaseSearchFragment)mCurrentFragment.get()).setQueryText(mQuery.getText().toString());
            ((BaseSearchFragment)mCurrentFragment.get()).performSearch();
        }
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void clearQueryText()
    {
        mQuery.setText("");
        mQuery.requestFocus();
        Util.setSoftKeyboardVisibility(this, mQuery, true);
    }

    public String getQueryText()
    {
        return mQuery.getText().toString();
    }

    protected void modernShowDivider()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mTabHost.getTabWidget().setShowDividers(0);
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131362217: 49
    //                   2131362281: 59
    //                   2131362284: 118
    //                   2131362286: 118;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        return;
_L2:
        Util.setSoftKeyboardVisibility(this, mQuery, true);
        return;
_L3:
        mClear.setVisibility(8);
        clearQueryText();
        if (mCurrentFragment != null && mCurrentFragment.get() != null)
        {
            ((BaseSearchFragment)mCurrentFragment.get()).setQueryText("");
            ((BaseSearchFragment)mCurrentFragment.get()).cleanSearchResults();
            return;
        }
          goto _L1
_L4:
        performSearch();
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f03008b, true);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        Object obj = getSupportActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setDisplayShowCustomEnabled(true);
            ((ActionBar) (obj)).setCustomView(0x7f03008a);
        }
        obj = (EditText)((ActionBar) (obj)).getCustomView().findViewById(0x7f0a01a9);
        ViewUtil.reduceTextSizeViaFontScaleIfNeeded(this, 1.1F, 12F, new TextView[] {
            obj
        });
        ((EditText) (obj)).setOnEditorActionListener(this);
        ((EditText) (obj)).addTextChangedListener(this);
        ((EditText) (obj)).setInputType(0x80000);
        ((EditText) (obj)).requestFocus();
        mQuery = ((EditText) (obj));
        obj = (ImageButton)findViewById(0x7f0a01e9);
        ((ImageButton) (obj)).setOnClickListener(this);
        mClear = ((ImageButton) (obj));
        if (bundle == null)
        {
            mTabHost = (FragmentTabHost)findViewById(0x7f0a01ea);
            mTabHost.setup(this, getSupportFragmentManager(), 0x7f0a01eb);
            bundle = LayoutInflater.from(this);
            Bundle bundle1 = new Bundle();
            bundle1.putInt("empty_desc", 0x7f0e0154);
            bundle1.putBoolean("refresh", false);
            android.widget.TabHost.TabSpec tabspec = mTabHost.newTabSpec("users");
            View view = bundle.inflate(0x7f03008d, mTabHost.getTabWidget(), false);
            ((TextView)view.findViewById(0x7f0a01f0)).setText(getString(0x7f0e0173).toUpperCase());
            ((ImageView)view.findViewById(0x7f0a01ef)).setImageDrawable(getResources().getDrawable(0x7f020267));
            tabspec.setIndicator(view);
            mTabHost.addTab(tabspec, co/vine/android/UserSearchFragment, bundle1);
            bundle1 = new Bundle();
            bundle1.putInt("empty_desc", 0x7f0e0155);
            bundle1.putBoolean("refresh", false);
            tabspec = mTabHost.newTabSpec("tags");
            bundle = bundle.inflate(0x7f03008d, mTabHost.getTabWidget(), false);
            ((TextView)bundle.findViewById(0x7f0a01f0)).setText(getString(0x7f0e0241).toUpperCase());
            ((ImageView)bundle.findViewById(0x7f0a01ef)).setImageDrawable(getResources().getDrawable(0x7f02026d));
            tabspec.setIndicator(bundle);
            mTabHost.addTab(tabspec, co/vine/android/TagSearchFragment, bundle1);
            modernShowDivider();
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        mTabHost = null;
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        textview.getId();
        JVM INSTR tableswitch 2131362217 2131362217: default 24
    //                   2131362217 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        byte byte0 = 2;
        int j = byte0;
        if (mCurrentFragment != null)
        {
            j = byte0;
            if (mCurrentFragment.get() != null)
            {
                j = ((BaseSearchFragment)mCurrentFragment.get()).getMinimumSearchQueryLength();
            }
        }
        if (i == 3 && mQuery.getText().length() >= j)
        {
            performSearch();
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
label0:
        {
            ImageButton imagebutton = (ImageButton)findViewById(0x7f0a01e9);
            if (charsequence.length() > 0)
            {
                imagebutton.setVisibility(0);
            } else
            {
                imagebutton.setVisibility(8);
            }
            if (mCurrentFragment != null && mCurrentFragment.get() != null)
            {
                if (charsequence.length() < ((BaseSearchFragment)mCurrentFragment.get()).getMinimumSearchQueryLength())
                {
                    break label0;
                }
                ((BaseSearchFragment)mCurrentFragment.get()).showSearchHint(getResources(), charsequence.toString());
            }
            return;
        }
        ((BaseSearchFragment)mCurrentFragment.get()).hideSearchHint();
    }

    public void restoreQueryText(String s)
    {
        mQuery.setText(s);
        mQuery.clearFocus();
        Util.setSoftKeyboardVisibility(this, mQuery, false);
    }

    public void setCurrentTab(BaseSearchFragment basesearchfragment)
    {
        mCurrentFragment = new WeakReference(basesearchfragment);
    }
}
