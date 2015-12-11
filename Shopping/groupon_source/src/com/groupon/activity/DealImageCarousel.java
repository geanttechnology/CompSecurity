// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.groupon.Channel;
import com.groupon.adapter.widget.DealImageAdapter;
import com.groupon.models.country.Country;
import com.groupon.models.nst.DealImageCarouselMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ShareHelper;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class DealImageCarousel extends GrouponActivity
{

    public static final int DEFAULT_IMAGE_POSITION = 0;
    public static final int REQUEST_CODE = 10149;
    String DEAL_IMAGE_CAROUSEL_ACTION_BAR_TITLE;
    protected Channel channel;
    private CurrentCountryManager currentCountryManager;
    protected String dealId;
    protected ViewPager dealImagePager;
    protected String dealTitle;
    protected JsonEncodedNSTField jsonEncodedNSTField;
    private LoggingUtils loggingUtils;

    public DealImageCarousel()
    {
    }

    protected DealImageAdapter getDealImageAdapter(List list)
    {
        return new DealImageAdapter(this, list, dealId, channel.name());
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        bundle = getIntent().getParcelableArrayListExtra("deal_image_big_urls");
        setToolbarTitle(String.format(DEAL_IMAGE_CAROUSEL_ACTION_BAR_TITLE, new Object[] {
            Integer.valueOf(dealImagePager.getCurrentItem() + 1), Integer.valueOf(bundle.size())
        }));
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(0x7f020238));
    }

    public void onBackPressed()
    {
        setResult(-1, (new Intent()).putExtra("image_carousel_current_position", dealImagePager.getCurrentItem()));
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300cb);
        bundle = getIntent();
        Object obj = bundle.getParcelableArrayListExtra("deal_image_big_urls");
        int i = bundle.getIntExtra("deal_details_image_current_position", 0);
        final int count = ((ArrayList) (obj)).size();
        bundle = getDealImageAdapter(((List) (obj)));
        dealImagePager.setAdapter(bundle);
        dealImagePager.setCurrentItem(i);
        dealImagePager.setPageMargin(getResources().getDimensionPixelSize(0x7f0b00e7));
        bundle = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final DealImageCarousel this$0;
            final int val$count;

            public void onPageScrollStateChanged(int j)
            {
            }

            public void onPageScrolled(int j, float f, int k)
            {
            }

            public void onPageSelected(int j)
            {
                j++;
                LoggingUtils loggingutils = loggingUtils;
                String s1 = (new StringBuilder()).append(j).append(":").append(count).toString();
                Object obj1;
                if (jsonEncodedNSTField != null)
                {
                    obj1 = jsonEncodedNSTField;
                } else
                {
                    obj1 = new DealImageCarouselMetadata(channel);
                }
                loggingutils.logImpression("", "deal_image", "image_carousel", s1, ((JsonEncodedNSTField) (obj1)));
                getSupportActionBar().setTitle(String.format(DEAL_IMAGE_CAROUSEL_ACTION_BAR_TITLE, new Object[] {
                    Integer.valueOf(j), Integer.valueOf(count)
                }));
            }

            
            {
                this$0 = DealImageCarousel.this;
                count = i;
                super();
            }
        };
        dealImagePager.setOnPageChangeListener(bundle);
        obj = loggingUtils;
        String s = (new StringBuilder()).append(i + 1).append(":").append(count).toString();
        if (jsonEncodedNSTField != null)
        {
            bundle = jsonEncodedNSTField;
        } else
        {
            bundle = new DealImageCarouselMetadata(channel);
        }
        ((LoggingUtils) (obj)).logImpression("", "deal_image", "image_carousel", s, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (Strings.notEmpty(dealTitle))
        {
            menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        dealImagePager.setOnPageChangeListener(null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (isDeepLinked) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755037 2131755037: default 32
    //                   2131755037 38;
           goto _L2 _L3
_L2:
        return super.onOptionsItemSelected(menuitem);
_L3:
        if (dealId != null)
        {
            String s = String.format("http://www.groupon.com/dispatch/%s/deal/%s", new Object[] {
                currentCountryManager.getCurrentCountry().shortName, dealId
            });
            (new ShareHelper(this, dealTitle, s)).shareDeal();
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

}
