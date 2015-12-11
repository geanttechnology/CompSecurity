// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemViewData, ViewItemDataManager

public class ItemViewSellersLegalInfoActivity extends ItemViewBaseActivity
{

    public ItemViewSellersLegalInfoActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewSellersLegalInfoActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivity(intent);
    }

    private void appendString(SpannableStringBuilder spannablestringbuilder, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            spannablestringbuilder.append(s).append("\n");
        }
    }

    private void appendString(SpannableStringBuilder spannablestringbuilder, String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            spannablestringbuilder.append(s).append(s1).append("\n");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getResources().getString(0x7f0705da));
        setContentView(0x7f030143);
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing())
        {
            super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
            if (!content.getStatus().hasError())
            {
                if (actionhandled == ViewItemDataManager.ActionHandled.INITIAL_LOAD)
                {
                    viewitemdatamanager = (TextView)findViewById(0x7f10032d);
                    content = new SpannableStringBuilder();
                    if (!TextUtils.isEmpty(item.bsFirstName) && !TextUtils.isEmpty(item.bsLastName))
                    {
                        appendString(content, (new StringBuilder()).append(item.bsFirstName).append(" ").append(item.bsLastName).toString());
                    }
                    appendString(content, item.bsCompanyName);
                    appendString(content, item.bsStreet1);
                    appendString(content, item.bsStreet2);
                    appendString(content, item.bsCityName);
                    appendString(content, item.bsPostalCode);
                    appendString(content, item.bsCountryName);
                    content.append("\n");
                    appendString(content, (new StringBuilder()).append(getString(0x7f0704ea)).append(" ").toString(), item.bsPhone);
                    appendString(content, (new StringBuilder()).append(getString(0x7f0704e8)).append(" ").toString(), item.bsFax);
                    appendString(content, (new StringBuilder()).append(getString(0x7f0704e7)).append(" ").toString(), item.bsEmail);
                    content.append("\n");
                    appendString(content, (new StringBuilder()).append(getString(0x7f0704ed)).append(" ").toString(), item.bsVatId);
                    content.append("\n");
                    appendString(content, (new StringBuilder()).append(getString(0x7f07010c)).append(" ").toString(), item.bsTradeRegistrationNumber);
                    content.append("\n");
                    if (item.bsLegalInvoice)
                    {
                        content.append(getString(0x7f0700b6)).append('\n');
                    }
                    appendString(content, getString(0x7f0700b5), item.bsAdditionalContactInformation);
                    actionhandled = content.toString();
                    int i;
                    if (!TextUtils.isEmpty(actionhandled))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        viewitemdatamanager.setText(actionhandled);
                    }
                    viewitemdatamanager = (ViewGroup)findViewById(0x7f10032c);
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    viewitemdatamanager.setVisibility(i);
                    content.clear();
                    actionhandled = (TextView)findViewById(0x7f10032f);
                    if (item.isReturnsNotAccepted)
                    {
                        viewitemdatamanager = getString(0x7f07092b);
                    } else
                    if (item.isReturnsAccepted)
                    {
                        viewitemdatamanager = getString(0x7f070928);
                    } else
                    {
                        viewitemdatamanager = item.rpReturnsAccepted;
                    }
                    appendString(content, viewitemdatamanager);
                    appendString(content, getString(0x7f0700a7), item.rpReturnsWithin);
                    appendString(content, getString(0x7f070b16), item.rpRefund);
                    appendString(content, getString(0x7f070b18), item.rpShippingCostPaidBy);
                    appendString(content, getString(0x7f0700a6), item.rpDescription);
                    appendString(content, getString(0x7f070b14), item.rpEAN);
                    appendString(content, getString(0x7f070b17), item.rpRestockingFee);
                    appendString(content, getString(0x7f070b1a), item.rpWarrantyOffered);
                    appendString(content, getString(0x7f070b19), item.rpWarrantyDuration);
                    appendString(content, getString(0x7f070b1b), item.rpWarrantyType);
                    viewitemdatamanager = content.toString();
                    if (!TextUtils.isEmpty(viewitemdatamanager))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        actionhandled.setText(viewitemdatamanager);
                    }
                    viewitemdatamanager = (ViewGroup)findViewById(0x7f10032e);
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    viewitemdatamanager.setVisibility(i);
                    content.clear();
                    viewitemdatamanager = (TextView)findViewById(0x7f100331);
                    appendString(content, item.bsTermsAndConditions);
                    content = content.toString();
                    if (!TextUtils.isEmpty(content))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        viewitemdatamanager.setText(content);
                    }
                    viewitemdatamanager = (ViewGroup)findViewById(0x7f100330);
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    viewitemdatamanager.setVisibility(i);
                    return;
                }
            } else
            {
                EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        ((ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this)).loadData(this, viewData);
    }
}
