// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.givingworks.NonProfitDataManager;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.SignInActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GivingWorksCharityActivity extends BaseActivity
    implements android.widget.CompoundButton.OnCheckedChangeListener, com.ebay.common.net.api.givingworks.NonProfitDataManager.Observer
{

    public static final String CHARITY_NONPROFIT = "charity_nonprofit";
    private com.ebay.common.model.givingworks.NonprofitData.Nonprofit charity;
    private ImageCache imageCache;
    private NonProfitDataManager nonprofitDataManager;
    private Set userFavorites;

    public GivingWorksCharityActivity()
    {
    }

    private void updateUI()
    {
        ImageView imageview = (ImageView)findViewById(0x7f1001cb);
        TextView textview = (TextView)findViewById(0x7f1001cc);
        TextView textview1 = (TextView)findViewById(0x7f1001cd);
        TextView textview2 = (TextView)findViewById(0x7f1001ce);
        TextView textview3 = (TextView)findViewById(0x7f1001cf);
        TextView textview4 = (TextView)findViewById(0x7f1001d0);
        CheckBox checkbox = (CheckBox)findViewById(0x7f1001d1);
        checkbox.setOnCheckedChangeListener(null);
        if (userFavorites != null && userFavorites.contains(charity.externalId))
        {
            checkbox.setChecked(true);
        } else
        {
            checkbox.setChecked(false);
        }
        imageCache.setImage(imageview, charity.getLogoUrl());
        textview.setText(charity.name);
        textview3.setText(charity.mission);
        if (!TextUtils.isEmpty(charity.getLocationString()))
        {
            textview2.setText(charity.getLocationString());
        } else
        {
            textview2.setVisibility(8);
            textview1.setVisibility(8);
        }
        if (charity.favoriteCount > 0)
        {
            textview4.setText(getResources().getQuantityString(0x7f080016, charity.favoriteCount, new Object[] {
                Integer.valueOf(charity.favoriteCount)
            }));
        } else
        {
            textview4.setVisibility(8);
        }
        checkbox.setOnCheckedChangeListener(this);
    }

    public String getTrackingEventName()
    {
        return "GivingWorksCharityDetail";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1 && i == 11)
        {
            nonprofitDataManager.forceReloadData();
        }
        updateUI();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (!isFinishing())
        {
            if (!networkAvailable())
            {
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                compoundbutton.setChecked(flag);
                return;
            }
            if (!MyApp.getPrefs().isSignedIn())
            {
                flag = DeviceConfiguration.getAsync().get(DcsBoolean.connectSignInModalDialog);
                if (flag)
                {
                    compoundbutton = com/ebay/mobile/activities/SignInModalActivity;
                } else
                {
                    compoundbutton = com/ebay/mobile/activities/SignInActivity;
                }
                compoundbutton = new Intent(this, compoundbutton);
                if (flag)
                {
                    compoundbutton.setFlags(0x20000);
                }
                compoundbutton.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
                startActivityForResult(compoundbutton, 11);
                return;
            }
            if (nonprofitDataManager != null)
            {
                if (flag)
                {
                    nonprofitDataManager.addNonprofit(charity);
                    return;
                } else
                {
                    nonprofitDataManager.removeNonprofit(charity);
                    return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b5);
        setTitle(0x7f07042d);
        imageCache = new ImageCache(this);
        userFavorites = new HashSet();
        bundle = getIntent();
        if (!bundle.hasExtra("charity_nonprofit"))
        {
            Log.e(getClass().getSimpleName(), "Activity requires a nonprofit extra. None found.");
            finish();
            return;
        }
        charity = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)bundle.getParcelableExtra("charity_nonprofit");
        if (charity == null)
        {
            Log.e(getClass().getSimpleName(), "Nonprofit given in intent was null, cannot continue.");
            finish();
            return;
        } else
        {
            initDataManagers();
            updateUI();
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        nonprofitDataManager = (NonProfitDataManager)datamanagercontainer.initialize(NonProfitDataManager.KEY, this);
    }

    public void onNonProfitsChanged(NonProfitDataManager nonprofitdatamanager, Content content)
    {
        if (isFinishing())
        {
            return;
        }
        nonprofitdatamanager = content.getStatus();
        content = (List)content.getData();
        if (nonprofitdatamanager.hasError())
        {
            content = MyApp.getDisplayableServiceError(getEbayContext(), nonprofitdatamanager);
            nonprofitdatamanager = content;
            if (TextUtils.isEmpty(content))
            {
                nonprofitdatamanager = getString(0x7f07024a);
            }
            showErrorToast(nonprofitdatamanager);
            return;
        }
        if (userFavorites == null)
        {
            userFavorites = new HashSet();
        } else
        {
            userFavorites.clear();
        }
        if (content != null)
        {
            for (nonprofitdatamanager = content.iterator(); nonprofitdatamanager.hasNext(); userFavorites.add(((com.ebay.common.model.givingworks.NonprofitData.Nonprofit) (content)).externalId))
            {
                content = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)nonprofitdatamanager.next();
            }

        }
        updateUI();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.findItem(0x7f1009e6).setVisible(false);
        return false;
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }
}
