// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.viewitem.fragments.ViewItemActionsFragment;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.NautilusKernel;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class AfterSalesWebViewActivity extends ShowWebViewActivity
{
    public static final class AfterSalesType extends Enum
    {

        private static final AfterSalesType $VALUES[];
        public static final AfterSalesType CANCEL;
        public static final AfterSalesType CANCEL_ENTRY;
        public static final AfterSalesType CASE;
        public static final AfterSalesType INQUIRY;
        public static final AfterSalesType NOT_APPLICABLE;
        public static final AfterSalesType RETURN;

        public static AfterSalesType valueOf(String s)
        {
            return (AfterSalesType)Enum.valueOf(com/ebay/mobile/activities/AfterSalesWebViewActivity$AfterSalesType, s);
        }

        public static AfterSalesType[] values()
        {
            return (AfterSalesType[])$VALUES.clone();
        }

        static 
        {
            RETURN = new AfterSalesType("RETURN", 0);
            CASE = new AfterSalesType("CASE", 1);
            CANCEL = new AfterSalesType("CANCEL", 2);
            CANCEL_ENTRY = new AfterSalesType("CANCEL_ENTRY", 3);
            INQUIRY = new AfterSalesType("INQUIRY", 4);
            NOT_APPLICABLE = new AfterSalesType("NOT_APPLICABLE", 5);
            $VALUES = (new AfterSalesType[] {
                RETURN, CASE, CANCEL, CANCEL_ENTRY, INQUIRY, NOT_APPLICABLE
            });
        }

        private AfterSalesType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String AFTER_SALES_STATUS = "ebay-after-sales-status";
    private static final String CANCEL_ENTRY_URL_FMT = "http://postorder.%s/Cancel/Start?itemId=%s&transId=%s&srcAppId=%s&rmvHdr=true";
    private static final String CANCEL_URL_FMT = "http://postorder.%s/Cancel/Detail?itemId=%s&transId=%s&srcAppId=%s&rmvHdr=true";
    private static final String CASE_URL_FMT = "http://postorder.%s/Case/ViewCase?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true";
    private static final String ENTRY_URL_FMT = "http://asqfaqui.%s/asqfaquiweb/ViewOptions?itemId=%s&transactionId=%s&sRecipient=%s&srcAppId=%s&rmvHdr=true";
    public static final String EXTRA_ITEM_ID = "item_id";
    public static final String EXTRA_SELLER_NAME = "pt_sn";
    public static final String EXTRA_TRANSACTION_ID = "trans_id";
    public static final String EXTRA_TYPE = "pt_type";
    private static final String INR_URL_FMT = "http://postorder.%s/ItemNotReceived/ViewRequest?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true";
    private static final String RETURN_URL_FMT = "http://returns.%s/Return/ReturnsDetail?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true";
    public static final int UNKNOWN_HEADER_RESOURCE_FOR_STATUS = -1;

    public AfterSalesWebViewActivity()
    {
    }

    public static void startActivity(ViewItemActionsFragment viewitemactionsfragment, Item item, AfterSalesType aftersalestype)
    {
        Intent intent = new Intent(viewitemactionsfragment.getActivity(), com/ebay/mobile/activities/AfterSalesWebViewActivity);
        intent.putExtra("item_id", String.valueOf(item.id));
        intent.putExtra("trans_id", item.iTransaction.transactionId);
        intent.putExtra("pt_sn", item.sellerUserId);
        intent.putExtra("pt_type", aftersalestype);
        viewitemactionsfragment.startActivityForResult(intent, 114);
    }

    public void onStart()
    {
        super.onStart();
        View view = findViewById(0x7f1003a1);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    protected void readAdditionalQueryParameters(Uri uri, Intent intent)
    {
        if (uri != null && uri.isHierarchical())
        {
            uri = uri.getQueryParameter("ebay-after-sales-status");
            if (!TextUtils.isEmpty(uri))
            {
                intent.putExtra("ebay-after-sales-status", uri);
            }
        }
    }

    protected void readIntent()
    {
        super.readIntent();
        useBackStack = true;
        useSso = true;
        impression = "SeeRequestDetails";
        backgroundColor = getResources().getColor(0x7f0d00b5);
        Object obj = getIntent();
        String s1 = ((Intent) (obj)).getStringExtra("item_id");
        String s2 = ((Intent) (obj)).getStringExtra("trans_id");
        String s3 = ((Intent) (obj)).getStringExtra("pt_sn");
        AfterSalesType aftersalestype = (AfterSalesType)((Intent) (obj)).getSerializableExtra("pt_type");
        String s = MyApp.getPrefs().getCurrentSite().getDomain();
        obj = s;
        if (NautilusKernel.isQaMode())
        {
            obj = "qa.".concat(s);
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType = new int[AfterSalesType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.RETURN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.CASE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.CANCEL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.CANCEL_ENTRY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.INQUIRY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[AfterSalesType.NOT_APPLICABLE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType[aftersalestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            url = String.format("http://returns.%s/Return/ReturnsDetail?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, "2571"
            });
            return;

        case 2: // '\002'
            url = String.format("http://postorder.%s/Case/ViewCase?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, "2571"
            });
            return;

        case 3: // '\003'
            url = String.format("http://postorder.%s/Cancel/Detail?itemId=%s&transId=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, "2571"
            });
            return;

        case 4: // '\004'
            url = String.format("http://postorder.%s/Cancel/Start?itemId=%s&transId=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, "2571"
            });
            return;

        case 5: // '\005'
            url = String.format("http://postorder.%s/ItemNotReceived/ViewRequest?itemId=%s&transactionId=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, "2571"
            });
            return;

        case 6: // '\006'
            url = String.format("http://asqfaqui.%s/asqfaquiweb/ViewOptions?itemId=%s&transactionId=%s&sRecipient=%s&srcAppId=%s&rmvHdr=true", new Object[] {
                obj, s1, s2, s3, "2571"
            });
            break;
        }
        impression = "ClosedItemOptions";
    }

    protected void showProgress(boolean flag)
    {
        show(progressView, false);
    }
}
