// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.TabIndicator;
import co.vine.android.widget.tabs.TabsAdapter;
import co.vine.android.widget.tabs.ViewPagerScrollBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            FindFriendsBaseActivity, FindFriendsNUXAddressFragment, FindFriendsTwitterFragment, Friendships, 
//            StartActivity

public class FindFriendsNUXActivity extends FindFriendsBaseActivity
    implements TextWatcher, co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener, android.widget.TextView.OnEditorActionListener, android.view.View.OnClickListener
{
    public static interface FilterableFriendsList
    {

        public abstract void onTextChanged(CharSequence charsequence, int i, int j, int k);

        public abstract boolean shouldShowSearchIcon();
    }

    private class FindFriendsNUXListener extends AppSessionListener
    {

        final FindFriendsNUXActivity this$0;

        public void onBulkFollowComplete(String s, int i, String s1)
        {
            dismissDialog();
            StartActivity.toStart(FindFriendsNUXActivity.this, true);
            finish();
        }

        private FindFriendsNUXListener()
        {
            this$0 = FindFriendsNUXActivity.this;
            super();
        }

    }


    public static final String ARG_FROM_SIGN_UP = "from_sign_up";
    public static final String ARG_TAKE_FOCUS = "take_focus";
    private ImageButton mClear;
    private boolean mIsTwitterReg;
    private EditText mQuery;
    private MenuItem mSearch;
    private HashSet mUserIdsToFollow;

    public FindFriendsNUXActivity()
    {
    }

    private void addContactsTab()
    {
        android.widget.TabHost.TabSpec tabspec = mTabHost.newTabSpec("address");
        tabspec.setIndicator(getTabIndicator(0x7f0e008f, 0x7f09004a));
        Bundle bundle = new Bundle();
        if (mIsTwitterReg)
        {
            bundle.putBoolean("take_focus", false);
        }
        bundle.putInt("empty_desc", 0x7f0e00e1);
        mTabsAdapter.addTab(tabspec, co/vine/android/FindFriendsNUXAddressFragment, bundle);
    }

    private void addTwitterTab()
    {
        android.widget.TabHost.TabSpec tabspec = mTabHost.newTabSpec("twitter");
        tabspec.setIndicator(getTabIndicator(0x7f0e0250, 0x7f09004c));
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_sign_up", true);
        bundle.putInt("empty_desc", 0x7f0e00ef);
        mTabsAdapter.addTab(tabspec, co/vine/android/FindFriendsTwitterFragment, bundle);
    }

    private TabIndicator getTabIndicator(int i, int j)
    {
        TabIndicator tabindicator = TabIndicator.newTextIndicator(LayoutInflater.from(this), 0x7f030062, mTabHost, i, false);
        android.content.res.ColorStateList colorstatelist = TabIndicator.createTextColorList(getResources().getColor(j), getResources().getColor(0x7f090057));
        TextView textview = tabindicator.getIndicatorText();
        textview.setTypeface(Typefaces.get(this).boldContent);
        textview.setTextColor(colorstatelist);
        return tabindicator;
    }

    public static void start(Context context)
    {
        context.startActivity(new Intent(context, co/vine/android/FindFriendsNUXActivity));
    }

    public void addUserToFollow(long l)
    {
        mUserIdsToFollow.add(String.valueOf(l));
    }

    public void addUsersToFollow(ArrayList arraylist, Friendships friendships)
    {
        VineUser vineuser;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); friendships.addFollowing(vineuser.userId))
        {
            vineuser = (VineUser)arraylist.next();
            mUserIdsToFollow.add(String.valueOf(vineuser.userId));
        }

    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void clearSearch()
    {
        mQuery.setText("");
        mClear.setVisibility(8);
        mQuery.clearFocus();
        getSupportActionBar().getCustomView().setVisibility(8);
        Util.setSoftKeyboardVisibility(this, mQuery, false);
    }

    public void onBackPressed()
    {
        if (!TextUtils.isEmpty(mQuery.getText().toString()) || mQuery.hasFocus())
        {
            clearSearch();
        } else
        if (mViewPager.getCurrentItem() > 0)
        {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362281: 
            clearSearch();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setupActionBar(Boolean.valueOf(false), Boolean.valueOf(true), 0x7f0e00de, Boolean.valueOf(false));
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayShowCustomEnabled(true);
            bundle.setCustomView(0x7f03008a);
            bundle = bundle.getCustomView();
            bundle.setVisibility(8);
            EditText edittext = (EditText)bundle.findViewById(0x7f0a01a9);
            ViewUtil.reduceTextSizeViaFontScaleIfNeeded(this, 1.1F, 12F, new TextView[] {
                edittext
            });
            edittext.setOnEditorActionListener(this);
            edittext.addTextChangedListener(this);
            edittext.setInputType(0x80000);
            mQuery = edittext;
            bundle = (ImageButton)bundle.findViewById(0x7f0a01e9);
            bundle.setOnClickListener(this);
            mClear = bundle;
        }
        mAppSessionListener = new FindFriendsNUXListener();
        bundle = mTabHost;
        mScrollBar.setRange(2);
        mViewPager.setOffscreenPageLimit(1);
        mTabsAdapter = new TabsAdapter(this, bundle, mViewPager, mScrollBar);
        Intent intent = getIntent();
        if (intent != null)
        {
            mIsTwitterReg = intent.getBooleanExtra("is_twitter_reg", false);
        }
        bundle.setOnTabChangedListener(this);
        bundle.setOnTabClickedListener(this);
        if (mIsTwitterReg)
        {
            addTwitterTab();
            addContactsTab();
        } else
        {
            addContactsTab();
            addTwitterTab();
        }
        mUserIdsToFollow = new HashSet();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        mViewPager.getCurrentItem();
        JVM INSTR tableswitch 1 1: default 24
    //                   1 87;
           goto _L1 _L2
_L1:
        getMenuInflater().inflate(0x7f10000d, menu);
_L4:
        menu = menu.findItem(0x7f0a00e4);
        android.support.v4.app.Fragment fragment = mTabsAdapter.getCurrentFragment();
        if ((fragment instanceof FilterableFriendsList) && menu != null)
        {
            menu.setVisible(((FilterableFriendsList)fragment).shouldShowSearchIcon());
        }
        mSearch = menu;
        return true;
_L2:
        getMenuInflater().inflate(0x7f10000c, menu);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCurrentTabClicked()
    {
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
        if (i == 3 || keyevent != null && keyevent.getKeyCode() == 66)
        {
            mQuery.clearFocus();
            Util.setSoftKeyboardVisibility(this, mQuery, false);
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            if (!mUserIdsToFollow.isEmpty())
            {
                menuitem = new ProgressDialog(this, 0x7f0f0037);
                mProgressDialog = menuitem;
                menuitem.setProgressStyle(0);
                menuitem.setMessage(getString(0x7f0e0103));
                try
                {
                    menuitem.show();
                }
                // Misplaced declaration of an exception variable
                catch (MenuItem menuitem) { }
                menuitem = new ArrayList(mUserIdsToFollow);
                mAppController.bulkFollowUsers(mAppController.getActiveSession(), menuitem);
                return true;
            } else
            {
                StartActivity.toStart(this, true);
                finish();
                return true;
            }

        case 2131362020: 
            menuitem.setVisible(false);
            getSupportActionBar().getCustomView().setVisibility(0);
            mClear.setVisibility(0);
            mQuery.requestFocus();
            Util.setSoftKeyboardVisibility(this, mQuery, true);
            return true;

        case 2131362374: 
            mViewPager.setCurrentItem(1);
            return true;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        android.support.v4.app.Fragment fragment = mTabsAdapter.getCurrentFragment();
        if (fragment instanceof FilterableFriendsList)
        {
            ((FilterableFriendsList)fragment).onTextChanged(charsequence, i, j, k);
        }
    }

    public void removeUserToFollow(long l)
    {
        mUserIdsToFollow.remove(String.valueOf(l));
    }

    void setCurrentTabByTag(String s)
    {
        IconTabHost icontabhost = mTabHost;
        if (!s.equals(icontabhost.getCurrentTabTag()))
        {
            icontabhost.setCurrentTabByTag(s);
        }
        mScrollBar.setPosition(mViewPager.getCurrentItem());
    }

    public void showSearchIcon(boolean flag)
    {
        if (mSearch != null)
        {
            mSearch.setVisible(flag);
        }
    }

    public void toggleFollowAll(boolean flag, ArrayList arraylist, Friendships friendships)
    {
        if (flag)
        {
            addUsersToFollow(arraylist, friendships);
        } else
        {
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                VineUser vineuser = (VineUser)arraylist.next();
                mUserIdsToFollow.remove(String.valueOf(vineuser.userId));
                friendships.removeFollowing(vineuser.userId);
            }
        }
    }
}
