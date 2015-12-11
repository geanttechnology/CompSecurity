// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import com.groupon.fragment.BusinessTipsFragment;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class BusinessTipsPage extends GrouponActivity
    implements GrouponDialogListener
{

    String businessId;
    private BusinessTipsFragment businessTipsFragment;
    private LoggingUtils loggingUtils;

    public BusinessTipsPage()
    {
        businessId = "";
    }

    public String getBusinessId()
    {
        return businessId;
    }

    public String getPaginationChannelId()
    {
        return (new StringBuilder()).append(businessId).append("Tip").toString();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getApplicationContext().getString(0x7f08044d));
    }

    protected void initializeTipsFragment()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        String s = com/groupon/fragment/BusinessTipsFragment.getName();
        if (fragmentmanager.findFragmentById(0x7f100171) == null)
        {
            businessTipsFragment = (BusinessTipsFragment)BusinessTipsFragment.instantiate(this, s, null);
            businessTipsFragment.setHasOptionsMenu(true);
            fragmenttransaction.setCustomAnimations(0x10b0000, 0x10b0001);
            fragmenttransaction.replace(0x7f100171, businessTipsFragment, s);
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030056);
        initializeTipsFragment();
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
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
        finish();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        super.onResume();
        loggingUtils.logPageView("", "merchant_tips_page", new MerchantPageMerchantIdMetadata(businessId));
    }
}
