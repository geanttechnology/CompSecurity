// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.models.country.Country;
import com.groupon.models.nst.ThankYouScreenExtraInfo;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.GrouponRatingPrompter;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ShareHelper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class MarketRateThanks extends GrouponActivity
    implements CustomPageViewEvent, GrouponDialogListener
{

    Channel channel;
    private CurrentCountryManager currentCountryManager;
    String dealId;
    String hotelName;
    private IntentFactory intentFactory;
    protected LoggingUtils loggingUtils;
    Button myGrouponsButton;
    boolean orderStillProcessing;
    Button shareButton;
    TextView subtitle;
    TextView title;
    ImageView topLogo;

    public MarketRateThanks()
    {
        channel = Channel.UNKNOWN;
    }

    private void setUserRated()
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences("GRP.ratingsDictionary", 0).edit();
        editor.putBoolean("GRP.alreadyRated", true);
        editor.apply();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    public void logPageViewEvent()
    {
        loggingUtils.logPageView(channel.toString(), getClass().getSimpleName(), new ThankYouScreenExtraInfo(dealId, null, null));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030213);
        setupViews();
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "rating_dialog"))
        {
            setUserRated();
        }
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "rating_dialog"))
        {
            setUserRated();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(getPackageName()).toString())));
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void setupViews()
    {
        (new GrouponRatingPrompter(this)).maybeShowPrompt();
        Object obj = topLogo;
        int i;
        if (orderStillProcessing)
        {
            i = 0x7f02030c;
        } else
        {
            i = 0x7f02030b;
        }
        ((ImageView) (obj)).setImageResource(i);
        obj = title;
        if (orderStillProcessing)
        {
            i = 0x7f08052f;
        } else
        {
            i = 0x7f0803d9;
        }
        ((TextView) (obj)).setText(i);
        obj = subtitle;
        if (orderStillProcessing)
        {
            i = 0x7f08052e;
        } else
        {
            i = 0x7f0803d1;
        }
        ((TextView) (obj)).setText(i);
        shareButton.setText(0x7f0803ce);
        shareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MarketRateThanks this$0;

            public void onClick(View view)
            {
                (new ShareHelper(MarketRateThanks.this, hotelName, String.format("https://www.groupon.com/dispatch/%s/channel/%s", new Object[] {
                    "US".toLowerCase(), Channel.GETAWAYS.toString()
                }))).shareDeal();
            }

            
            {
                this$0 = MarketRateThanks.this;
                super();
            }
        });
        obj = myGrouponsButton;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            i = 0x7f080284;
        } else
        {
            i = 0x7f08027e;
        }
        ((Button) (obj)).setText(i);
        myGrouponsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MarketRateThanks this$0;

            public void onClick(View view)
            {
                startActivity(intentFactory.newMyGrouponIntent(Channel.GETAWAYS));
                finish();
            }

            
            {
                this$0 = MarketRateThanks.this;
                super();
            }
        });
    }

}
