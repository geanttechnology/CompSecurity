// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.groupon.Channel;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.fragment.GlobalSearchFragment;
import com.groupon.getaways.search.GetawaysSearchFragment;
import com.groupon.models.country.Country;
import com.groupon.models.nst.GlobalSearchClickToPerformSearchMetadata;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.SearchInterfaceProvider;
import com.groupon.util.TabHelper;
import com.groupon.util.ViewUtils;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchBase, IntentFactory

public class GlobalSearch extends GlobalSearchBase
    implements SearchInterfaceProvider
{

    private static final String CURRENT_CHANNEL = "current_channel";
    private static final String GETAWAYS_SEARCH_FRAGMENT_TAG = "getaways_search_fragment_tag";
    private static final String LOGGING_CLICK_TYPE_PREFILTER_CLICK = "prefilter_click";
    private static final int REQUEST_CODE = 100;
    public static final String SHOW_NEARBY_TONIGHT_HOTELS = "show_nearby_tonight";
    private static final String SINGLE_FRAGMENT_TAG = "single_fragment_tag";
    public static final String WAS_DEEP_LINKED = "wasDeepLinked";
    private Channel currentChannel;
    private Fragment currentSearchFragment;
    private GetawaysSearchFragment getawaysSearchFragment;
    private GlobalSearchFragment globalSearchFragment;
    private GlobalSearchUtil globalSearchUtil;
    boolean isBrowseByCategory;
    RadioGroup radioTabGroup;
    boolean showNearbyTonight;
    private Channel sourceChannel;
    private TabHelper tabHelper;
    boolean wasDeepLinked;

    public GlobalSearch()
    {
    }

    private void ensureGetawaysSearchFragment()
    {
        if (getawaysSearchFragment == null)
        {
            if (showNearbyTonight)
            {
                getawaysSearchFragment = GetawaysSearchFragment.newInstanceWithSearchNearbyTonightResults();
            } else
            {
                getawaysSearchFragment = GetawaysSearchFragment.newInstance(getQueryText().toString());
            }
            getFragmentManager().beginTransaction().add(0x7f1002fd, getawaysSearchFragment, "getaways_search_fragment_tag").commit();
            return;
        } else
        {
            getawaysSearchFragment.setQuery(getQueryText().toString());
            return;
        }
    }

    private void ensureGlobalSearchFragment(Channel channel)
    {
        if (globalSearchFragment == null)
        {
            globalSearchFragment = new GlobalSearchFragment();
            Bundle bundle = getIntent().getExtras();
            bundle.putParcelable("carousel_origin_channel", sourceChannel);
            globalSearchFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().add(0x7f1002fd, globalSearchFragment, "single_fragment_tag").commit();
        }
        globalSearchFragment.setSearchFilterChannel(globalSearchUtil.filterStringForChannel(channel));
        globalSearchFragment.updateSourceChannelAndRefresh(channel);
    }

    private void initializeRadioTabGroup()
    {
        if (isRadioTabGroupVisible())
        {
            radioTabGroup.setVisibility(0);
            for (int i = 0; i < tabHelper.getNumChannels(); i++)
            {
                RadioButton radiobutton = (RadioButton)getLayoutInflater().inflate(0x7f0301ba, radioTabGroup, false);
                radiobutton.setId(i);
                radiobutton.setText(tabHelper.getPageTitle(i));
                radiobutton.setOnClickListener(new android.view.View.OnClickListener() {

                    final GlobalSearch this$0;

                    public void onClick(View view)
                    {
                        onRadioButtonClicked(view);
                    }

            
            {
                this$0 = GlobalSearch.this;
                super();
            }
                });
                radioTabGroup.addView(radiobutton);
            }

        } else
        {
            radioTabGroup.setVisibility(8);
        }
    }

    private boolean isRadioTabGroupVisible()
    {
        return searchAbTestHelper.isUniversalSearchChannelSelectorEnabled() && !isBrowseByCategory;
    }

    private void setCurrentChannel(Channel channel)
    {
        currentChannel = channel;
        if (channel == Channel.GETAWAYS && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            ensureGetawaysSearchFragment();
            channel = getFragmentManager().beginTransaction();
            if (getawaysSearchFragment.isHidden())
            {
                channel.show(getawaysSearchFragment);
            }
            if (globalSearchFragment != null)
            {
                channel.hide(globalSearchFragment);
            }
            channel.commit();
            currentSearchFragment = getawaysSearchFragment;
            channel = getString(0x7f0801fd, new Object[] {
                getString(0x7f080224)
            });
        } else
        {
            ensureGlobalSearchFragment(channel);
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            if (globalSearchFragment.isHidden())
            {
                fragmenttransaction.show(globalSearchFragment);
            }
            if (getawaysSearchFragment != null)
            {
                fragmenttransaction.hide(getawaysSearchFragment);
            }
            fragmenttransaction.commit();
            currentSearchFragment = globalSearchFragment;
            if (channel == Channel.ALL_CHANNELS || channel == Channel.FEATURED)
            {
                channel = getString(0x7f080203);
            } else
            {
                channel = getString(0x7f0801fd, new Object[] {
                    tabHelper.getPageTitle(tabHelper.getPositionForChannel(currentChannel))
                });
            }
        }
        textSearchEditText.setHint(channel);
    }

    public void clearFocus()
    {
        textSearchEditText.clearFocus();
    }

    protected void clearSearchText()
    {
        super.clearSearchText();
        if (currentSearchFragment == globalSearchFragment)
        {
            globalSearchFragment.onClearSearch();
        }
    }

    public int getMeasuredWidth()
    {
        return textSearchEditText.getMeasuredWidth();
    }

    public String getQueryText()
    {
        return textSearchEditText.getText().toString();
    }

    public boolean hasFocus()
    {
        return textSearchEditText.hasFocus();
    }

    public void hideKeyboard(final boolean hideKeyboard)
    {
        textSearchEditText.postDelayed(new Runnable() {

            final GlobalSearch this$0;
            final boolean val$hideKeyboard;

            public void run()
            {
                ViewUtils.setSoftKeyboardState(GlobalSearch.this, hideKeyboard, textSearchEditText);
            }

            
            {
                this$0 = GlobalSearch.this;
                hideKeyboard = flag;
                super();
            }
        }, 200L);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    public boolean isInitialized()
    {
        return textSearchEditText != null;
    }

    public boolean menuOptionSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 16908332: 
            break;
        }
        if (wasDeepLinked)
        {
            startActivity(((IntentFactory)intentFactory.get()).newCarouselChannelIntent(Channel.FEATURED, new String[0]));
        } else
        {
            menuitem = ((IntentFactory)intentFactory.get()).newCarouselChannelIntent(sourceChannel, new String[0]);
            menuitem.putExtra("refreshCarousel", isDeepLinked);
            navigateUpTo(menuitem);
        }
        ViewUtils.forceShowKeyboard(this, false);
        return true;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 100 && j == -1 && currentSearchFragment != null && currentSearchFragment == globalSearchFragment)
        {
            globalSearchFragment.onFinishedWithResults();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (currentSearchFragment != null && currentSearchFragment == globalSearchFragment)
        {
            globalSearchFragment.onBackButtonPress();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030103);
        tabHelper = new TabHelper(this);
        initializeTextSearchView();
        initializeRadioTabGroup();
        sourceChannel = (Channel)getIntent().getParcelableExtra("sourceChannel");
        if (bundle != null)
        {
            globalSearchFragment = (GlobalSearchFragment)getFragmentManager().findFragmentByTag("single_fragment_tag");
            getawaysSearchFragment = (GetawaysSearchFragment)getFragmentManager().findFragmentByTag("getaways_search_fragment_tag");
            bundle = (Channel)bundle.getSerializable("current_channel");
        } else
        if (sourceChannel == Channel.HOTELS)
        {
            bundle = Channel.GETAWAYS;
        } else
        {
            bundle = sourceChannel;
        }
        setCurrentChannel(bundle);
        if (isRadioTabGroupVisible())
        {
            radioTabGroup.check(tabHelper.getPositionForChannel(bundle));
        }
    }

    protected void onFocusChanged(boolean flag)
    {
        while (currentSearchFragment == null || currentSearchFragment != globalSearchFragment) 
        {
            return;
        }
        globalSearchFragment.onSearchBarFocusChanged(flag);
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return menuOptionSelected(menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onRadioButtonClicked(View view)
    {
        int i = radioTabGroup.indexOfChild(view);
        view = tabHelper.channelInPosition(i);
        setCurrentChannel(view);
        logger.logClick("", "prefilter_click", globalSearchUtil.loggingNameForChannel(view), Logger.NULL_NST_FIELD);
    }

    protected void onResume()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
        {
            Toast.makeText(this, 0x7f080199, 0).show();
            finish();
        }
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("current_channel", currentChannel);
    }

    protected void onSearchExecuted(String s)
    {
        if (Strings.notEmpty(s))
        {
            if (searchAbTestHelper.isUniversalSearchChannelSelectorEnabled())
            {
                GlobalSearchClickToPerformSearchMetadata globalsearchclicktoperformsearchmetadata = new GlobalSearchClickToPerformSearchMetadata(globalSearchUtil.loggingNameForChannelString(currentChannel.toString()), s);
                logger.logClick("", "search_button_click", "global_search", Logger.NULL_NST_FIELD, globalsearchclicktoperformsearchmetadata);
            } else
            {
                loggingUtils.logClick("", "search_button_click", "global_search", s);
            }
        }
        if (currentSearchFragment == globalSearchFragment)
        {
            globalSearchFragment.onSearchExecuted(s);
        } else
        if (currentSearchFragment == getawaysSearchFragment)
        {
            getawaysSearchFragment.search();
            return;
        }
    }

    protected void onSearchTextBoxClicked()
    {
        loggingUtils.logClick("", "search_icon_click", "global_search", currentChannel.toString());
        if (currentSearchFragment == globalSearchFragment)
        {
            globalSearchFragment.onSearchBarClicked();
        }
    }

    protected void onSearchTextChanged(CharSequence charsequence)
    {
        if (currentSearchFragment != null)
        {
            if (currentSearchFragment == globalSearchFragment)
            {
                globalSearchFragment.onTextChanged(charsequence);
                return;
            }
            if (currentSearchFragment == getawaysSearchFragment)
            {
                getawaysSearchFragment.setQuery(charsequence.toString());
                return;
            }
        }
    }

    public void requestTextFocus()
    {
        textSearchEditText.requestFocus();
    }

    public void setQueryHint(String s)
    {
        textSearchEditText.setHint(s);
    }

    public void setQueryText(String s)
    {
        textSearchEditText.setText(s);
    }

    public void setRadioTabGroupVisibility(int i)
    {
        radioTabGroup.setVisibility(i);
    }

    public void setSearchBarVisibility(int i)
    {
        searchBarContainer.setVisibility(i);
    }

    public void setSelection(int i)
    {
        textSearchEditText.setSelection(i);
    }

    public void showClearSearchButton(boolean flag)
    {
        ImageView imageview = textSearchClearButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        imageview.setVisibility(i);
    }
}
