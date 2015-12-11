// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.db.events.CouponUpdateEvent;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.loader.CouponLoaderCallbacks;
import com.groupon.manager.GrouponPaginatedSyncManager;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.CouponSyncManagerProcess;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.service.LocationService;
import com.groupon.service.coupondetails.CouponDetailResponse;
import com.groupon.service.coupondetails.CouponDetailService;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ShareHelper;
import com.groupon.util.TransparentToolBarHelper;
import com.groupon.view.CouponMapSlice;
import com.groupon.view.UrlImageView;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import commonlib.manager.SyncManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase, IntentFactory

public class CouponDetails extends AbstractDetailsBase
{
    private class AffiliateUrlLoader extends AsyncTask
    {

        private CouponDetail coupon;
        private String eventId;
        final CouponDetails this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            double d;
            double d1;
            Location location;
            try
            {
                avoid = MediaType.parse("application/x-www-form-urlencoded");
                location = locationService.getLocation();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Ln.e(avoid);
                return null;
            }
            d = 0.0D;
            d1 = 0.0D;
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_41;
            }
            d = location.getLatitude();
            d1 = location.getLongitude();
            avoid = RequestBody.create(avoid, String.format("coupon_uuid=%s&bcookie=%s&event_id=%s&locn=%s,%s&source=android", new Object[] {
                coupon.remoteId, consumerDeviceSettings.getBcookie(), eventId, Double.toString(d), Double.toString(d1)
            }));
            avoid = ((CouponDetailResponse)(new CouponDetailService(CouponDetails.this, avoid)).call()).targetUrl;
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (!Strings.notEmpty(s)) goto _L2; else goto _L1
_L1:
            String s1;
            String s2;
            byte byte0;
            logCouponClick(eventId);
            s2 = "";
            String s3 = couponDetail.displayType;
            s1 = s3;
            if (s3 == null)
            {
                s1 = "";
            }
            byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 5: default 100
        //                       -997631434: 232
        //                       -27932576: 202
        //                       814094796: 247
        //                       1494517706: 217
        //                       1932946569: 262;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            byte0;
            JVM INSTR tableswitch 0 4: default 136
        //                       0 277
        //                       1 277
        //                       2 277
        //                       3 309
        //                       4 309;
               goto _L9 _L10 _L10 _L10 _L11 _L11
_L9:
            s1 = getString(0x7f080106);
_L14:
            if (!Strings.notEmpty(s)) goto _L13; else goto _L12
_L12:
            new URL(s);
            try
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                try
                {
                    Toast.makeText(CouponDetails.this, getString(0x7f0800cc), 1).show();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Toast.makeText(CouponDetails.this, getString(0x7f0800da), 1).show();
                    return;
                }
            }
            if (Strings.notEmpty(s1))
            {
                Toast.makeText(CouponDetails.this, s1, 1).show();
            }
_L13:
            return;
_L5:
            if (s1.equals("instore_promo_code"))
            {
                byte0 = 0;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (s1.equals("instore_sale"))
            {
                byte0 = 1;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (s1.equals("online_instore_sale"))
            {
                byte0 = 2;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (s1.equals("online_instore_promo_code"))
            {
                byte0 = 3;
            }
            continue; /* Loop/switch isn't completed */
_L8:
            if (s1.equals("online_promo_code"))
            {
                byte0 = 4;
            }
            continue; /* Loop/switch isn't completed */
_L10:
            if (Strings.notEmpty(coupon.productImageUrl))
            {
                s1 = getString(0x7f080106);
            } else
            {
                s1 = "";
            }
            continue; /* Loop/switch isn't completed */
_L11:
            s1 = s2;
            if (Strings.notEmpty(couponDetail.code))
            {
                s1 = getString(0x7f080105);
                ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Coupon Code", couponDetail.code));
            }
            if (true) goto _L14; else goto _L2
_L2:
            Toast.makeText(CouponDetails.this, getString(0x7f0800da), 1).show();
            return;
            if (true) goto _L3; else goto _L15
_L15:
        }

        public AffiliateUrlLoader(CouponDetail coupondetail)
        {
            this$0 = CouponDetails.this;
            super();
            eventId = UUID.randomUUID().toString();
            coupon = coupondetail;
        }
    }


    private final String COUPON_CODE = "Coupon Code";
    private final String COUPON_SHARE_URL = "https://www.groupon.com/coupons/stores/%s?s=1&c=%s";
    protected TextView aboutDate;
    protected TextView aboutText;
    protected TextView aboutTitle;
    protected Button buyBarButtonDualOne;
    protected Button buyBarButtonDualTwo;
    protected Button buyBarButtonSingle;
    private ConsumerDeviceSettings consumerDeviceSettings;
    protected View contentView;
    private CouponDetail couponDetail;
    protected String couponId;
    protected CouponMapSlice couponMapSlice;
    protected LinearLayout coupon_about_section;
    private String dbChannel;
    protected LinearLayout dualBuyBar;
    protected TextView exclusiveFlag;
    protected UrlImageView headerImage;
    protected TextView headerSubtitle;
    protected TextView headerTitle;
    protected TextView instoreCount;
    protected TextView instructionText;
    protected TextView instructionTitle;
    private IntentFactory intentFactory;
    private CouponLoaderCallbacks loaderCallbacks;
    private LocationService locationService;
    private CouponMerchant merchant;
    protected View moreSection;
    protected View moreSectionDivider;
    protected View moreSectionInstore;
    protected View moreSectionOnline;
    protected TextView moreTitle;
    protected TextView onlineCount;
    protected View progress;
    protected LinearLayout singleBuyBar;
    protected TextView toolbarTitleText;
    private TransparentToolBarHelper transparentToolBarHelper;
    private UniversalSyncManager universalSyncManager;

    public CouponDetails()
    {
        dbChannel = Channel.COUPON_DETAIL.name();
    }

    private void handleCouponClickSingle()
    {
        String s;
        byte byte0;
        String s1 = couponDetail.displayType;
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 64
    //                   -997631434: 143
    //                   -27932576: 101
    //                   814094796: 129
    //                   1494517706: 115;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_143;
_L6:
        switch (byte0)
        {
        default:
            launchCouponInWeb();
            return;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            handleInstoreCoupon();
            break;
        }
        break MISSING_BLOCK_LABEL_161;
_L3:
        if (s.equals("instore_promo_code"))
        {
            byte0 = 0;
        }
          goto _L6
_L5:
        if (s.equals("instore_sale"))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s.equals("online_instore_promo_code"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("online_instore_sale"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    private void handleInstoreCoupon()
    {
        if (Strings.isEmpty(couponDetail.productImageUrl))
        {
            launchCouponInWeb();
            return;
        } else
        {
            launchCouponImage();
            return;
        }
    }

    private void launchCouponImage()
    {
        logCouponClick(UUID.randomUUID().toString());
        String s = couponDetail.displayType;
        ArrayList arraylist;
        CouponGenericMetadata coupongenericmetadata;
        if (Strings.equals(s, "instore_sale") || Strings.equals(s, "online_instore_sale"))
        {
            String s1 = getString(0x7f080104);
            String s2 = couponDetail.prettyEndsOn;
            s = s1;
            if (Strings.notEmpty(s2))
            {
                s = (new StringBuilder()).append(s1).append("\n").append(getString(0x7f0804d1, new Object[] {
                    s2
                })).toString();
            }
        } else
        {
            s = getString(0x7f080103);
        }
        Toast.makeText(this, s, 1).show();
        arraylist = new ArrayList();
        arraylist.add(new ImageUrl(couponDetail.getImageUrl()));
        coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.couponId = couponId;
        startActivity(intentFactory.newCouponDetailsDealImageCarouselIntent(arraylist, 0, s, coupongenericmetadata, channel));
    }

    private void launchCouponInWeb()
    {
        (new AffiliateUrlLoader(couponDetail)).execute(new Void[0]);
    }

    private void logCouponClick(String s)
    {
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.couponId = couponId;
        coupongenericmetadata.merchantId = merchant.getRemoteId();
        coupongenericmetadata.eventId = s;
        loggingUtils.logClickWithMetadata("", "get_code_click", Channel.COUPONS.toString(), coupongenericmetadata);
    }

    private void openShareDialog()
    {
        if (couponDetail != null)
        {
            String s = String.format("https://www.groupon.com/coupons/stores/%s?s=1&c=%s", new Object[] {
                couponDetail.couponMerchant.getSlug(), couponDetail.remoteId
            });
            (new ShareHelper(this, couponDetail.title, s)).shareAndLog(getString(0x7f080112), (new StringBuilder()).append(getString(0x7f080111)).append(" ").append(couponDetail.title).append("\n").append(s).toString());
        }
    }

    private void setAboutSection(String s, String s1)
    {
        if (Strings.notEmpty(s) || Strings.notEmpty(s1))
        {
            coupon_about_section.setVisibility(0);
        }
        if (Strings.notEmpty(s))
        {
            aboutText.setVisibility(0);
            aboutText.setText(s);
        }
        if (Strings.notEmpty(s1))
        {
            aboutDate.setVisibility(0);
            aboutDate.setText(getString(0x7f0800f0, new Object[] {
                s1
            }));
        }
    }

    private void setCoupon(final CouponDetail responseDetail)
    {
        String s;
        String s1;
        int i;
        couponDetail = responseDetail;
        merchant = responseDetail.couponMerchant;
        if (responseDetail.instoreOffer)
        {
            couponMapSlice.setVisibility(0);
            couponMapSlice.setMapLocationsContainer(merchant);
            couponMapSlice.setCouponId(responseDetail.remoteId);
        }
        if (!responseDetail.isExclusive)
        {
            exclusiveFlag.setVisibility(8);
        }
        headerTitle.setText(responseDetail.title);
        instoreCount.setText(String.format("%d", new Object[] {
            Integer.valueOf(merchant.instoreCouponsCount)
        }));
        onlineCount.setText(String.format("%d", new Object[] {
            Integer.valueOf(merchant.onlineCouponsCount)
        }));
        moreTitle.setText(getString(0x7f0800f4, new Object[] {
            merchant.name
        }));
        if (responseDetail.instoreOffer)
        {
            s = responseDetail.getImageUrl();
        } else
        {
            s = responseDetail.getImageUrlOnline();
        }
        headerImage.setImageUrl(s);
        s1 = responseDetail.displayType;
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = merchant.name;
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 8: default 288
    //                   -1835309887: 623
    //                   -997631434: 654
    //                   -27932576: 577
    //                   464109235: 686
    //                   814094796: 639
    //                   1494517706: 592
    //                   1617612823: 607
    //                   1932946569: 669;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        i;
        JVM INSTR tableswitch 0 7: default 336
    //                   0 703
    //                   1 783
    //                   2 875
    //                   3 955
    //                   4 1035
    //                   5 1125
    //                   6 1215
    //                   7 1307;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L10:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f0800d6);
        headerSubtitle.setText(getString(0x7f0800fb, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800dc);
        s = getString(0x7f080102, new Object[] {
            s1
        });
_L19:
        buyBarButtonSingle.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;

            public void onClick(View view)
            {
                handleCouponClickSingle();
            }

            
            {
                this$0 = CouponDetails.this;
                super();
            }
        });
        buyBarButtonDualOne.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;

            public void onClick(View view)
            {
                launchCouponInWeb();
            }

            
            {
                this$0 = CouponDetails.this;
                super();
            }
        });
        buyBarButtonDualTwo.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;

            public void onClick(View view)
            {
                handleInstoreCoupon();
            }

            
            {
                this$0 = CouponDetails.this;
                super();
            }
        });
        headerImage.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;
            final CouponDetail val$responseDetail;

            public void onClick(View view)
            {
                if (Strings.notEmpty(responseDetail.productImageUrl))
                {
                    handleCouponClickSingle();
                }
            }

            
            {
                this$0 = CouponDetails.this;
                responseDetail = coupondetail;
                super();
            }
        });
        i = merchant.onlineCouponsCount;
        int j = merchant.instoreCouponsCount;
        if (i == 0 && j == 0)
        {
            moreSection.setVisibility(8);
        } else
        if (i == 0)
        {
            moreSectionDivider.setVisibility(8);
            moreSectionOnline.setVisibility(8);
        } else
        if (j == 0)
        {
            moreSectionDivider.setVisibility(8);
            moreSectionInstore.setVisibility(8);
        }
        moreSectionInstore.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;

            public void onClick(View view)
            {
                startActivity(intentFactory.newCouponMerchantFilterPageIntent(merchant, CouponInstoreOnlinePage.PageType.INSTORE));
            }

            
            {
                this$0 = CouponDetails.this;
                super();
            }
        });
        moreSectionOnline.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponDetails this$0;

            public void onClick(View view)
            {
                startActivity(intentFactory.newCouponMerchantFilterPageIntent(merchant, CouponInstoreOnlinePage.PageType.ONLINE));
            }

            
            {
                this$0 = CouponDetails.this;
                super();
            }
        });
        toolbarTitleText.setText(s);
        progress.setVisibility(8);
        contentView.setVisibility(0);
        setAboutSection(responseDetail.restrictions, responseDetail.prettyEndsOn);
        return;
_L4:
        if (s.equals("instore_promo_code"))
        {
            i = 0;
        }
          goto _L1
_L7:
        if (s.equals("instore_sale"))
        {
            i = 1;
        }
          goto _L1
_L8:
        if (s.equals("mobile_download_promo_code"))
        {
            i = 2;
        }
          goto _L1
_L2:
        if (s.equals("mobile_download_sale"))
        {
            i = 3;
        }
          goto _L1
_L6:
        if (s.equals("online_instore_promo_code"))
        {
            i = 4;
        }
          goto _L1
_L3:
        if (s.equals("online_instore_sale"))
        {
            i = 5;
        }
          goto _L1
_L9:
        if (s.equals("online_promo_code"))
        {
            i = 6;
        }
          goto _L1
_L5:
        if (s.equals("online_sale"))
        {
            i = 7;
        }
          goto _L1
_L11:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f0800d5);
        headerSubtitle.setText(getString(0x7f0800f8, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800dd);
        aboutTitle.setText(0x7f0800f2);
        s = getString(0x7f080100, new Object[] {
            s1
        });
          goto _L19
_L12:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f0800d5);
        headerSubtitle.setText(getString(0x7f0800f9, new Object[] {
            s1
        }));
        instructionText.setText(getString(0x7f0800de, new Object[] {
            s1
        }));
        s = getString(0x7f080102, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f3);
          goto _L19
_L13:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f080437);
        headerSubtitle.setText(getString(0x7f0800fa, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800df);
        s = getString(0x7f080101, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f1);
          goto _L19
_L14:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f080437);
        headerSubtitle.setText(getString(0x7f0800fa, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800e0);
        s = getString(0x7f080101, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f1);
          goto _L19
_L15:
        singleBuyBar.setVisibility(8);
        buyBarButtonDualOne.setText(0x7f0800d4);
        buyBarButtonDualTwo.setText(0x7f0800d5);
        headerSubtitle.setText(getString(0x7f0800fe, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800e1);
        s = getString(0x7f080100, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f2);
          goto _L19
_L16:
        singleBuyBar.setVisibility(8);
        buyBarButtonDualOne.setText(0x7f0800d4);
        buyBarButtonDualTwo.setText(0x7f0800d5);
        headerSubtitle.setText(getString(0x7f0800ff, new Object[] {
            s1
        }));
        instructionText.setText(0x7f0800e2);
        s = getString(0x7f080102, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f3);
          goto _L19
_L17:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f0800d1);
        headerSubtitle.setText(getString(0x7f0800fc, new Object[] {
            s1
        }));
        instructionText.setText(getString(0x7f0800e3, new Object[] {
            s1
        }));
        s = getString(0x7f080100, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f2);
          goto _L19
_L18:
        dualBuyBar.setVisibility(8);
        buyBarButtonSingle.setText(0x7f0800d0);
        headerSubtitle.setText(getString(0x7f0800fd, new Object[] {
            s1
        }));
        instructionText.setText(getString(0x7f0800e4, new Object[] {
            s1
        }));
        s = getString(0x7f080102, new Object[] {
            s1
        });
        aboutTitle.setText(0x7f0800f3);
          goto _L19
    }

    public void configureSyncManager()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new CouponSyncManagerProcess(this, couponId, dbChannel));
        universalSyncManager.configurePaginatedSyncManager(null, arraylist, new CouponUpdateEvent(dbChannel, couponId));
    }

    public android.app.LoaderManager.LoaderCallbacks getLoaderCallBack()
    {
        if (loaderCallbacks == null)
        {
            loaderCallbacks = new CouponLoaderCallbacks(this, couponId, dbChannel) {

                final CouponDetails this$0;

                public void onLoadFinished(Loader loader, CouponDetail coupondetail)
                {
                    if (coupondetail != null && coupondetail.couponMerchant != null)
                    {
                        setCoupon(coupondetail);
                    }
                }

                public volatile void onLoadFinished(Loader loader, Object obj)
                {
                    onLoadFinished(loader, (CouponDetail)obj);
                }

            
            {
                this$0 = CouponDetails.this;
                super(context, s, s1);
            }
            };
        }
        return loaderCallbacks;
    }

    public GrouponPaginatedSyncManager getSyncManager()
    {
        return universalSyncManager;
    }

    public volatile SyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        configureShoppingCartIcon();
        transparentToolBarHelper.initToolBar(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03006e);
        initLoaderManager();
        configureSyncManager();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755037 2131755037: default 24
    //                   2131755037 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        openShareDialog();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onResume()
    {
        super.onResume();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.couponId = couponId;
        loggingUtils.logPageView("", getClass().getSimpleName(), coupongenericmetadata);
    }










}
