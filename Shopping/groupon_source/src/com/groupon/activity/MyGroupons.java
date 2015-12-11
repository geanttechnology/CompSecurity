// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.adapter.mygroupons.MyGrouponsViewPagerAdapter;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ActionBarUtil;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class MyGroupons extends GrouponActivity
{

    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private IntentFactory intentFactory;
    boolean isFromCancelOrder;
    boolean isFromThankYou;
    int myGrouponsExternalTabPosition;
    GrouponViewPager myGrouponsViewPager;
    PagerSlidingTabStrip tabStrip;
    TextView toolbarTitle;

    public MyGroupons()
    {
        isFromThankYou = false;
        isFromCancelOrder = false;
        myGrouponsExternalTabPosition = -1;
    }

    private Channel getNavigateToChannel()
    {
        return Channel.FEATURED;
    }

    private void navigateToCarousel()
    {
        Channel channel = getNavigateToChannel();
        ActionBarUtil.navigateUpTo(this, channel, intentFactory.newCarouselChannelIntent(channel, new String[0]), intentFactory.newCarouselIntent());
    }

    private void startParentActivity()
    {
        Intent intent = getDeepLinkUpIntent();
        intent.setFlags(intent.getFlags() | 0x10000000 | 0x8000);
        startActivity(intent);
    }

    public int getCurrentTabPosition()
    {
        return myGrouponsViewPager.getCurrentItem();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        configureShoppingCartIcon();
        bundle = toolbarTitle;
        int i;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            i = 0x7f080284;
        } else
        {
            i = 0x7f08027e;
        }
        bundle.setText(getString(i));
    }

    public void onBackPressed()
    {
        if (isFromThankYou || isFromCancelOrder)
        {
            navigateToCarousel();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030171);
        myGrouponsViewPager.setAdapter(new MyGrouponsViewPagerAdapter(this, getFragmentManager()));
        tabStrip.setViewPager(myGrouponsViewPager);
        if (myGrouponsExternalTabPosition != -1)
        {
            myGrouponsViewPager.setCurrentItem(myGrouponsExternalTabPosition);
        }
        abTestService.isVariantEnabled("AAonMyGrouponPage1510", "On");
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            startParentActivity();
            break;
        }
        return true;
    }
}
