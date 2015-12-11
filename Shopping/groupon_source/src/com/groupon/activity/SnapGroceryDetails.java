// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.loader.GroceryLoaderCallbacks;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.nst.SnapGroceryGenericMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ShareHelper;
import com.groupon.view.UrlImageView;
import commonlib.manager.SyncManager;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase, SnapOfferGridActivity, IntentFactory

public class SnapGroceryDetails extends AbstractDetailsBase
    implements CustomPageViewEvent
{
    private class TriggerDeepLinkOnClickListener
        implements android.view.View.OnClickListener
    {

        final SnapGroceryDetails this$0;

        public void onClick(View view)
        {
            triggerDeeplink(doesPackageExist("com.buytopia.snap"));
        }

        private TriggerDeepLinkOnClickListener()
        {
            this$0 = SnapGroceryDetails.this;
            super();
        }

    }


    private static final String DOWNLOAD_SNAP = "download_snap";
    private static final String DOWNLOAD_SNAP_CLICK = "snap_impression";
    public static final String GROCERY_ID = "groceryId";
    private static final String OFFER_DETAILS = "offer_details";
    private static final String OFFER_IMPRESSION = "offer_impression";
    private static final String OPEN_SNAP = "open_snap";
    private static final String OPEN_SNAP_CLICK = "snap_impression";
    public static final String PRODUCT_NAME = "productName";
    private static final String SHARE_BUTTON_CLICK = "share_button_click";
    private static final String SNAP_ADDR = "com.buytopia.snap";
    private String dbChannel;
    protected WebView finePrint;
    protected TextView finePrintHeader;
    protected View finePrintSection;
    protected TextView groceryCashBack;
    protected String groceryId;
    protected UrlImageView groceryImage;
    protected TextView groceryItemTitle;
    protected WebView instructionDetails;
    protected TextView instructionHeader;
    private IntentFactory intentFactory;
    protected View intructionSection;
    private GroceryLoaderCallbacks loaderCallbacks;
    protected WebView offerDetails;
    protected TextView offerHeader;
    protected View offerSection;
    protected WebView productDetails;
    protected TextView productHeader;
    protected String productName;
    protected View productSection;
    protected Button redeemButton;
    private SnapGroceryDetail snapGroceryDetail;

    public SnapGroceryDetails()
    {
        dbChannel = Channel.SNAP_GROCERY.name();
    }

    private boolean doesPackageExist(String s)
    {
        boolean flag1 = false;
        Iterator iterator = getPackageManager().getInstalledApplications(0).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((ApplicationInfo)iterator.next()).packageName.equals(s))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    private void openShareDialog()
    {
        SnapGroceryGenericMetadata snapgrocerygenericmetadata = new SnapGroceryGenericMetadata();
        snapgrocerygenericmetadata.pageId = "offer_details";
        snapgrocerygenericmetadata.offerId = groceryId;
        logger.logClick(null, "share_button_click", "snap", null, snapgrocerygenericmetadata);
        if (snapGroceryDetail != null)
        {
            (new ShareHelper(this, snapGroceryDetail.productName, "https://snap.groupon.com/app")).shareAndLog(getString(0x7f0804e2, new Object[] {
                snapGroceryDetail.productName
            }), getString(0x7f08021a, new Object[] {
                snapGroceryDetail.cashBackPrefix, snapGroceryDetail.cashBack, snapGroceryDetail.productName
            }));
        }
    }

    private void setGrocery(SnapGroceryDetail snapgrocerydetail)
    {
        SnapOfferGridActivity.reformatPrice(snapgrocerydetail);
        snapGroceryDetail = snapgrocerydetail;
        groceryImage.setImageUrl(snapgrocerydetail.imgPath, com.groupon.view.UrlImageView.ScaleImageType.CENTER_INSIDE);
        if (Strings.notEmpty(snapgrocerydetail.productName))
        {
            groceryItemTitle.setText(Html.fromHtml(snapgrocerydetail.productName));
        }
        if (snapgrocerydetail.dateSoldOut != null)
        {
            groceryCashBack.setText(getString(0x7f08005f));
            groceryCashBack.setTextColor(getResources().getColor(0x7f0e00d7));
        } else
        if (Strings.notEmpty(snapgrocerydetail.cashBack))
        {
            groceryCashBack.setText((new StringBuilder()).append(snapgrocerydetail.cashBackPrefix).append(snapgrocerydetail.cashBack).append(" ").append(snapgrocerydetail.cashBackSuffix).toString());
        }
        if (Strings.notEmpty(snapgrocerydetail.offerDetails))
        {
            offerHeader.setText(0x7f0803af);
            offerDetails.loadData(snapgrocerydetail.offerDetails, "text/html", "UTF-8");
            offerSection.setVisibility(0);
        }
        if (Strings.notEmpty(snapgrocerydetail.productDetails))
        {
            productSection.setVisibility(0);
            productHeader.setText(0x7f0803b0);
            productDetails.loadData(snapgrocerydetail.productDetails, "text/html", "UTF-8");
        }
        if (Strings.notEmpty(snapgrocerydetail.instructions))
        {
            intructionSection.setVisibility(0);
            instructionHeader.setText(0x7f0803ab);
            instructionDetails.loadData(snapgrocerydetail.instructions, "text/html", "UTF-8");
        }
        if (Strings.notEmpty(snapgrocerydetail.offerTerms))
        {
            finePrintSection.setVisibility(0);
            finePrintHeader.setText(0x7f0803aa);
            finePrint.loadData(snapgrocerydetail.offerTerms, "text/html", "UTF-8");
        }
        if (doesPackageExist("com.buytopia.snap"))
        {
            redeemButton.setText(0x7f0802c9);
        } else
        {
            redeemButton.setText(0x7f080239);
        }
        redeemButton.setOnClickListener(new TriggerDeepLinkOnClickListener());
    }

    private void triggerDeeplink(boolean flag)
    {
        SnapGroceryGenericMetadata snapgrocerygenericmetadata;
        snapgrocerygenericmetadata = new SnapGroceryGenericMetadata();
        snapgrocerygenericmetadata.pageId = "offer_details";
        snapgrocerygenericmetadata.offerId = groceryId;
        if (flag)
        {
            try
            {
                snapgrocerygenericmetadata.buttonType = "open_snap";
                logger.logClick(null, "snap_impression", "snap", null, snapgrocerygenericmetadata);
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("snapbygroupon://snap?page=offer&offer_pk=").append(groceryId).toString())));
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.buytopia.snap")));
            }
            break MISSING_BLOCK_LABEL_149;
        }
        snapgrocerygenericmetadata.buttonType = "download_snap";
        logger.logClick(null, "snap_impression", "snap", null, snapgrocerygenericmetadata);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.buytopia.snap")));
        return;
    }

    public android.app.LoaderManager.LoaderCallbacks getLoaderCallBack()
    {
        if (loaderCallbacks == null)
        {
            loaderCallbacks = new GroceryLoaderCallbacks(this, groceryId, dbChannel) {

                final SnapGroceryDetails this$0;

                public void onLoadFinished(Loader loader, SnapGroceryDetail snapgrocerydetail)
                {
                    if (snapgrocerydetail != null)
                    {
                        setGrocery(snapgrocerydetail);
                    }
                }

                public volatile void onLoadFinished(Loader loader, Object obj)
                {
                    onLoadFinished(loader, (SnapGroceryDetail)obj);
                }

            
            {
                this$0 = SnapGroceryDetails.this;
                super(context, s, s1);
            }
            };
        }
        return loaderCallbacks;
    }

    public SyncManager getSyncManager()
    {
        return null;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(productName);
    }

    public void logPageViewEvent()
    {
        logger.logPageView("", "offer_details", new PageViewExtraInfo(null, groceryId));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03011b);
        ButterKnife.bind(this);
        initLoaderManager();
        doesPackageExist("com.buytopia.snap");
        bundle = new SnapGroceryGenericMetadata();
        bundle.offerId = groceryId;
        bundle.pageId = "offer_details";
        logger.logImpression(null, "offer_impression", "snap", "", bundle);
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

    protected boolean shouldStartAutomaticSyncsOnResume()
    {
        return false;
    }

    protected void startAutomaticSyncs()
    {
    }



}
