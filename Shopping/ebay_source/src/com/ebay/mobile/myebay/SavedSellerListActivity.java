// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.android.widget.MaxSizeLinearLayout;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.net.api.favseller.GetFavSellersNetLoader;
import com.ebay.common.util.ImageCache;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseListActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.net.URL;
import java.util.ArrayList;

public class SavedSellerListActivity extends BaseListActivity
{
    private class FavoriteSellerAdapter extends ArrayAdapter
    {

        private ArrayList sellerList;
        final SavedSellerListActivity this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (sellerList == null)
            {
                break MISSING_BLOCK_LABEL_302;
            }
            viewgroup = view;
            view = viewgroup;
            if (viewgroup == null)
            {
                view = m_inflater.inflate(0x7f0300a5, null);
            }
            viewgroup = (FavoriteSeller)sellerList.get(i);
            if (userCache.isFavSeller(((FavoriteSeller) (viewgroup)).sellerId)) goto _L2; else goto _L1
_L1:
            return view;
_L2:
            Object obj;
            i = ((FavoriteSeller) (viewgroup)).feedbackScore;
            obj = ((FavoriteSeller) (viewgroup)).sellerId;
            obj = (new StringBuilder()).append(((String) (obj))).append("  (").append(i).append(") ").toString();
            ImageView imageview = (ImageView)view.findViewById(0x7f1001ae);
            imageview.setOnClickListener(((FavoriteSeller) (viewgroup)).feedbackRatingStar. new android.view.View.OnClickListener() {

                final FavoriteSellerAdapter this$1;
                final String val$ratingStar;
                final String val$strSellerId;

                public void onClick(View view)
                {
                    if (!isProgressOn())
                    {
                        selectedPosition = getListView().getFirstVisiblePosition();
                        UserDetailActivity.StartActivity(_fld0, strSellerId, null, ratingStar, true);
                    }
                }

            
            {
                this$1 = final_favoriteselleradapter;
                strSellerId = s;
                ratingStar = String.this;
                super();
            }
            });
            if (((FavoriteSeller) (viewgroup)).myWorldSmallImg != null)
            {
                imageCache.setImage(imageview, ((FavoriteSeller) (viewgroup)).myWorldSmallImg.toString());
            }
            ((TextView)view.findViewById(0x7f1001af)).setText(((CharSequence) (obj)));
            ((TextView)view.findViewById(0x7f1001b2)).setText(((FavoriteSeller) (viewgroup)).notes);
            obj = (TextView)view.findViewById(0x7f1001b1);
            if (!TextUtils.isEmpty(((FavoriteSeller) (viewgroup)).positiveFeedbackPercent))
            {
                ((TextView) (obj)).setText(Util.getFeedbackPercentString(getApplicationContext(), ((FavoriteSeller) (viewgroup)).positiveFeedbackPercent));
            }
            boolean flag = false;
            obj = (ImageView)view.findViewById(0x7f1001b0);
            i = ((flag) ? 1 : 0);
            if (!TextUtils.isEmpty(((FavoriteSeller) (viewgroup)).feedbackRatingStar))
            {
                int j = Util.getRatingStarResId(((FavoriteSeller) (viewgroup)).feedbackRatingStar);
                i = ((flag) ? 1 : 0);
                if (j != 0)
                {
                    i = 1;
                    ((ImageView) (obj)).setImageResource(j);
                }
            }
            if (i != 0) goto _L1; else goto _L3
_L3:
            ((ImageView) (obj)).setEnabled(false);
            return view;
            return null;
        }

        FavoriteSellerAdapter(Activity activity, ArrayList arraylist)
        {
            this$0 = SavedSellerListActivity.this;
            super(activity, 0x7f0300a5, arraylist);
            sellerList = null;
            sellerList = arraylist;
            m_inflater = activity.getLayoutInflater();
        }
    }


    private static final int GET_FAV_SELLERS_LOADER_ID = 1;
    private boolean icsCrashHackIgnoreBack;
    private ImageCache imageCache;
    private LayoutInflater m_inflater;
    private int selectedPosition;
    private UserCache userCache;

    public SavedSellerListActivity()
    {
        selectedPosition = 0;
    }

    private void get_favorite_sellers()
    {
        com.ebay.nautilus.domain.EbaySite ebaysite = MyApp.getPrefs().getCurrentSite();
        Object obj = null;
        Object obj1 = MyApp.getPrefs().getAuthentication();
        if (obj1 != null)
        {
            obj = ((Authentication) (obj1)).iafToken;
        }
        obj1 = NautilusKernel.getAppVersionWithoutBuildNumber(this);
        setProgressOn();
        obj = new GetFavSellersNetLoader(getEbayContext(), ((String) (obj)), ebaysite, ((String) (obj1)));
        getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
    }

    private boolean isProgressOn()
    {
        View view = findViewById(0x7f100120);
        return view != null && view.getVisibility() == 0;
    }

    private void setProgressOff()
    {
        findViewById(0x7f100120).setVisibility(8);
    }

    private void setProgressOn()
    {
        findViewById(0x7f100120).setVisibility(0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (icsCrashHackIgnoreBack)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public String getTrackingEventName()
    {
        return "FavoriteSellers";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 65 65: default 20
    //                   65 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j != -1)
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ((MaxSizeLinearLayout)findViewById(0x7f1003de)).setMaxWidth((int)getResources().getDimension(0x7f0900cf));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030178);
        imageCache = new ImageCache(this);
        userCache = new UserCache(this);
    }

    protected void onDestroy()
    {
        imageCache.clearImageFetching();
        super.onDestroy();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        icsCrashHackIgnoreBack = true;
        selectedPosition = getListView().getFirstVisiblePosition();
        ActivityStarter.startSellerItemsSearchResultList(this, ((FavoriteSeller)((FavoriteSellerAdapter)getListAdapter()).getItem(i)).sellerId, new SourceIdentification(getTrackingEventName()));
    }

    protected void onResume()
    {
        super.onResume();
        icsCrashHackIgnoreBack = false;
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        } else
        {
            get_favorite_sellers();
        }
        Util.setAppStatus(this, getString(0x7f07094c));
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
_L2:
        return;
        if (isFinishing() || i != 1) goto _L2; else goto _L1
_L1:
        Object obj;
        GetFavSellersNetLoader getfavsellersnetloader;
        obj = null;
        getfavsellersnetloader = (GetFavSellersNetLoader)fwloader;
        fwloader = obj;
        if (getfavsellersnetloader.isError()) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 1 1: default 52
    //                   1 119;
           goto _L5 _L6
_L5:
        fwloader = obj;
_L4:
        setProgressOff();
        FavoriteSellers favoritesellers;
        if (fwloader == null || fwloader.size() == 0)
        {
            findViewById(0x7f1003df).setVisibility(0);
            getListView().setVisibility(8);
        } else
        {
            findViewById(0x7f1003df).setVisibility(8);
            getListView().setVisibility(0);
            getListView().requestFocus();
        }
        if (getfavsellersnetloader.isError())
        {
            (new EbayErrorHandler(this, true, true)).handleEbayError(getfavsellersnetloader.getServiceErrorsAndWarnings(), getfavsellersnetloader);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
        favoritesellers = ((com.ebay.common.net.api.favseller.GetFavoriteSellers.GetResponse)getfavsellersnetloader.getResponse()).fs;
        fwloader = obj;
        if (favoritesellers != null)
        {
            fwloader = favoritesellers.favSellersList;
            setListAdapter(new FavoriteSellerAdapter(this, fwloader));
            userCache.assignFavSellers(favoritesellers.favSellersList);
            getListView().setSelectionFromTop(selectedPosition, 0);
            setProgressOff();
        }
          goto _L4
    }



/*
    static LayoutInflater access$002(SavedSellerListActivity savedsellerlistactivity, LayoutInflater layoutinflater)
    {
        savedsellerlistactivity.m_inflater = layoutinflater;
        return layoutinflater;
    }

*/




/*
    static int access$302(SavedSellerListActivity savedsellerlistactivity, int i)
    {
        savedsellerlistactivity.selectedPosition = i;
        return i;
    }

*/

}
