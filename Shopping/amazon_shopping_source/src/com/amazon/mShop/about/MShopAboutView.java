// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.about;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.StandardView;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.upgrade.UpgradeController;
import com.amazon.mShop.upgrade.UpgradeSubscriberAdapter;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.UpgradeInfo;

public class MShopAboutView extends StandardView
{

    private int mClickTimes;

    public MShopAboutView(Context context)
    {
        this(context, Integer.valueOf(com.amazon.mShop.android.lib.R.string.more_about_button));
    }

    public MShopAboutView(final Context c, Integer integer)
    {
        super(c, integer);
        mClickTimes = 0;
        View view = View.inflate(c, com.amazon.mShop.android.lib.R.layout.about, this);
        view.findViewById(com.amazon.mShop.android.lib.R.id.about_app_info).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopAboutView this$0;

            public void onClick(View view1)
            {
                view1 = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = MShopAboutView.this;
                super();
            }
        });
        String s = BuildUtils.getVersionName(c);
        integer = s;
        if (s == null)
        {
            integer = c.getString(com.amazon.mShop.android.lib.R.string.about_missing_placeholder);
        }
        s = String.format(c.getString(com.amazon.mShop.android.lib.R.string.about_version), new Object[] {
            integer
        });
        String s1 = BuildUtils.getPartnerName(c);
        integer = s;
        if (!Util.isEmpty(s1))
        {
            integer = (new StringBuilder()).append(s).append(" (").append(s1).append(")").toString();
        }
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.about_version)).setText(integer);
        s = BuildUtils.getRevisionNumber(c);
        integer = s;
        if (s == null)
        {
            integer = c.getString(com.amazon.mShop.android.lib.R.string.about_missing_placeholder);
        }
        s = c.getString(com.amazon.mShop.android.lib.R.string.about_build);
        s1 = AppLocale.getInstance().getDefaultLocale();
        s1 = ConfigUtils.getStringForSpecificLocale(c, com.amazon.mShop.android.lib.R.string.config_marketplace_id, s1);
        integer = (new StringBuilder()).append(String.format(s, new Object[] {
            integer
        })).append("-").append(s1).toString();
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.about_build)).setText(integer);
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.check_upgrade_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopAboutView this$0;
            final Context val$c;

            public void onClick(View view1)
            {
                UpgradeUtil.clearNewUpgradeInfo();
                view1 = new UpgradeController();
                view1.setSubscriber(new UpgradeSubscriberAdapter() {

                    final _cls2 this$1;

                    public boolean awareUniqueId()
                    {
                        return false;
                    }

                    public void onError(Exception exception, ServiceCall servicecall)
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(exception. new Runnable() {

                            final _cls1 this$2;
                            final Exception val$e;

                            public void run()
                            {
                                AmazonErrorUtils.reportMShopServerError((AmazonActivity)c, null, _fld0, e, c.getString(com.amazon.mShop.android.lib.R.string.ok));
                            }

            
            {
                this$2 = final__pcls1;
                e = Exception.this;
                super();
            }
                        });
                    }

                    public void onNoUpgrade()
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                showNoUpgradeDialog();
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public void onUpgradeAvailable(UpgradeInfo upgradeinfo)
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("upgradeShouldShowDialog", false);
                                UpgradeUtil.showUpgradeNotificationDialog(c);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                view1.checkForUpgrade((new TaskCallbackFactory(getContext())).getTaskCallback(view1, com.amazon.mShop.android.lib.R.string.checking_for_upgrade));
            }

            
            {
                this$0 = MShopAboutView.this;
                c = context;
                super();
            }
        });
    }

    public void showNoUpgradeDialog()
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = new Builder(getContext());
        builder.setMessage(com.amazon.mShop.android.lib.R.string.no_available_upgrade);
        builder.create().show();
    }



/*
    static int access$002(MShopAboutView mshopaboutview, int i)
    {
        mshopaboutview.mClickTimes = i;
        return i;
    }

*/


/*
    static int access$008(MShopAboutView mshopaboutview)
    {
        int i = mshopaboutview.mClickTimes;
        mshopaboutview.mClickTimes = i + 1;
        return i;
    }

*/
}
