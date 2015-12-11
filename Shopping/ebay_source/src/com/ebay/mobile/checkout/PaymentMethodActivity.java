// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity

public final class PaymentMethodActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener, android.widget.ExpandableListView.OnChildClickListener, android.widget.ExpandableListView.OnGroupClickListener
{
    private class OtherPaymentMethodAdapter extends BaseExpandableListAdapter
    {

        private final Context context;
        private final ArrayList otherPaymentMethods;
        final PaymentMethodActivity this$0;

        public Object getChild(int i, int j)
        {
            if (j < otherPaymentMethods.size())
            {
                return otherPaymentMethods.get(j);
            } else
            {
                return null;
            }
        }

        public long getChildId(int i, int j)
        {
            return (long)j;
        }

        public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0302ce, null);
            }
            Object obj = (TextView)viewgroup.findViewById(0x7f10053a);
            view = (String)otherPaymentMethods.get(j);
            ((TextView) (obj)).setText(view);
            obj = (ImageView)viewgroup.findViewById(0x7f1009a0);
            if (selectedPaymentMethod != null)
            {
                if (selectedPaymentMethod.equals("CashOnPickup") && view.equals(context.getString(0x7f070c4d)))
                {
                    ((ImageView) (obj)).setVisibility(0);
                } else
                if (selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout") && view.equals(context.getString(0x7f070c51)))
                {
                    ((ImageView) (obj)).setVisibility(0);
                } else
                {
                    ((ImageView) (obj)).setVisibility(8);
                }
            } else
            {
                ((ImageView) (obj)).setVisibility(8);
            }
            viewgroup.setTag(otherPaymentMethods.get(j));
            return viewgroup;
        }

        public int getChildrenCount(int i)
        {
            return otherPaymentMethods.size();
        }

        public Object getGroup(int i)
        {
            return Integer.valueOf(0);
        }

        public int getGroupCount()
        {
            return 1;
        }

        public long getGroupId(int i)
        {
            return 0L;
        }

        public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0302cd, null);
            }
            ((TextView)viewgroup.findViewById(0x7f10099d)).setText(context.getString(0x7f070c4b));
            return viewgroup;
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public boolean isChildSelectable(int i, int j)
        {
            return true;
        }

        public OtherPaymentMethodAdapter(Context context1, ArrayList arraylist)
        {
            this$0 = PaymentMethodActivity.this;
            super();
            context = context1;
            otherPaymentMethods = arraylist;
        }
    }


    public static final int RESULT_PAYMENT_METHOD_COP = 3;
    public static final int RESULT_PAYMENT_METHOD_EFT = 2;
    public static final int RESULT_PAYMENT_METHOD_PAYPAL = 1;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private final ArrayList otherPaymentMethodsAvailable = new ArrayList();
    private ExpandableListView otherPaymentMethodsList;
    private boolean pendingPaymentMethodToSelect;

    public PaymentMethodActivity()
    {
        pendingPaymentMethodToSelect = false;
    }

    private String getBuyerProtectionUrl()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        if (isTopRatedSellerAvailable())
        {
            return dcshelper.topRatedSeller3XOUrl();
        } else
        {
            return dcshelper.buyerProtectionUrl();
        }
    }

    private void showIncentivesRequirePayPalAlert()
    {
        String s;
        int i;
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            i = 0x7f070c38;
        } else
        {
            i = 0x7f0700ea;
        }
        s = getString(i);
        dialogManager.showDynamicAlertDialog(getString(0x7f070c39), s, false);
    }

    private boolean userHasIncentivesAndDisplayAlert()
    {
        List list = cart.getIncentives();
        if (list != null && list.size() > 0)
        {
            showIncentivesRequirePayPalAlert();
            return true;
        } else
        {
            return false;
        }
    }

    void createUI()
    {
        int i;
        int j;
label0:
        {
            byte byte0 = 8;
            boolean flag1 = isTopRatedSellerAvailable();
            boolean flag = false;
            j = 0;
            View view;
            if (flag1)
            {
                i = 0x7f0302cc;
            } else
            {
                i = 0x7f0302cb;
            }
            setContentView(i);
            hideCloseButton();
            showBackButton();
            findViewById(0x7f1009a8).setOnClickListener(this);
            findViewById(0x7f1009ab).setOnClickListener(this);
            findViewById(0x7f1009a1).setOnClickListener(this);
            findViewById(0x7f1009a3).setOnClickListener(this);
            if (getBuyerProtectionUrl() != null)
            {
                findViewById(0x7f1009a6).setOnClickListener(this);
                findViewById(0x7f1009a7).setVisibility(0);
            } else
            {
                findViewById(0x7f1009a6).setVisibility(8);
            }
            if (isPayPalAvailable())
            {
                findViewById(0x7f1009a8).setVisibility(0);
            } else
            {
                findViewById(0x7f1009a8).setVisibility(8);
            }
            if (isPayPalGuestXoAvailable())
            {
                DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
                findViewById(0x7f1009ab).setVisibility(0);
                if (deviceconfiguration.get(DcsBoolean.MecBankTransfer))
                {
                    ((TextView)findViewById(0x7f1009ac)).setText(0x7f0700ef);
                }
            } else
            {
                findViewById(0x7f1009ab).setVisibility(8);
            }
            if (isEftAvailable())
            {
                if (isPayPalAvailable() && !flag1)
                {
                    i = 1;
                    otherPaymentMethodsAvailable.add(getString(0x7f070c51));
                    findViewById(0x7f1009a1).setVisibility(8);
                } else
                {
                    findViewById(0x7f1009a1).setVisibility(0);
                    i = j;
                }
            } else
            {
                findViewById(0x7f1009a1).setVisibility(8);
                i = j;
            }
            if (isCopAvailable())
            {
                if (isPayPalAvailable() && !flag1)
                {
                    i = 1;
                    otherPaymentMethodsAvailable.add(getString(0x7f070c4d));
                    findViewById(0x7f1009a3).setVisibility(8);
                } else
                {
                    findViewById(0x7f1009a3).setVisibility(0);
                }
            } else
            {
                findViewById(0x7f1009a3).setVisibility(8);
            }
            j = ((flag) ? 1 : 0);
            if (i == 0)
            {
                break label0;
            }
            otherPaymentMethodsList = (ExpandableListView)findViewById(0x7f1009a5);
            otherPaymentMethodsList.setAdapter(new OtherPaymentMethodAdapter(this, otherPaymentMethodsAvailable));
            otherPaymentMethodsList.setBackgroundDrawable(null);
            otherPaymentMethodsList.setGroupIndicator(null);
            otherPaymentMethodsList.setOnGroupClickListener(this);
            otherPaymentMethodsList.setOnChildClickListener(this);
            if (!isPayPalAvailable())
            {
                j = ((flag) ? 1 : 0);
                if (!isPayPalGuestXoAvailable())
                {
                    break label0;
                }
            }
            j = 1;
        }
        if (!flag1)
        {
            view = findViewById(0x7f100999);
            if (j != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            view = findViewById(0x7f100998);
            if (isPayPalAvailable() || isPayPalGuestXoAvailable())
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            view = findViewById(0x7f10099b);
            if (i != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            view = findViewById(0x7f10099a);
            if (i != 0)
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            view.setVisibility(i);
        }
        if (selectedPaymentMethod == null) goto _L2; else goto _L1
_L1:
        if (!selectedPaymentMethod.equals("PayPal")) goto _L4; else goto _L3
_L3:
        if (!useGuestXo) goto _L6; else goto _L5
_L5:
        findViewById(0x7f1009ad).setVisibility(0);
_L2:
        return;
_L6:
        findViewById(0x7f1009a9).setVisibility(0);
        return;
_L4:
        if (selectedPaymentMethod.equals("CashOnPickup"))
        {
            findViewById(0x7f1009a4).setVisibility(0);
            return;
        }
        if (selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout"))
        {
            findViewById(0x7f1009a2).setVisibility(0);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        pendingPaymentMethodToSelect = false;
    }

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        if (pendingPaymentMethodToSelect)
        {
            return true;
        }
        pendingPaymentMethodToSelect = true;
        expandablelistview = (String)view.getTag();
        if (expandablelistview != null)
        {
            if (expandablelistview.equals(getString(0x7f070c4d)) && !userHasIncentivesAndDisplayAlert())
            {
                useGuestXo = false;
                setCheckoutResult(3, new Intent());
                finish();
                return true;
            }
            if (expandablelistview.equals(getString(0x7f070c51)) && !userHasIncentivesAndDisplayAlert())
            {
                useGuestXo = false;
                setCheckoutResult(2, new Intent());
                finish();
                return true;
            }
        }
        pendingPaymentMethodToSelect = false;
        return false;
    }

    public void onClick(View view)
    {
        if (pendingPaymentMethodToSelect)
        {
            return;
        }
        pendingPaymentMethodToSelect = true;
        switch (view.getId())
        {
        case 2131757474: 
        case 2131757476: 
        case 2131757477: 
        case 2131757479: 
        case 2131757481: 
        case 2131757482: 
        default:
            return;

        case 2131757473: 
            if (!userHasIncentivesAndDisplayAlert())
            {
                useGuestXo = false;
                setCheckoutResult(2, new Intent());
                finish();
            }
            pendingPaymentMethodToSelect = false;
            return;

        case 2131757480: 
            useGuestXo = false;
            setCheckoutResult(1, new Intent());
            finish();
            return;

        case 2131757483: 
            useGuestXo = true;
            setCheckoutResult(1, new Intent());
            finish();
            return;

        case 2131757475: 
            if (!userHasIncentivesAndDisplayAlert())
            {
                useGuestXo = false;
                setCheckoutResult(3, new Intent());
                finish();
            }
            pendingPaymentMethodToSelect = false;
            return;

        case 2131757478: 
            pendingPaymentMethodToSelect = false;
            ShowFileWebViewActivity.startActivity(this, getBuyerProtectionUrl(), Integer.valueOf(EbayCountryManager.getBuyerProtectionPageTitle()), "EBayBuyerProtection");
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        createUI();
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
    }

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        boolean flag = otherPaymentMethodsList.isGroupExpanded(0);
        expandablelistview = (ImageView)view.findViewById(0x7f10099e);
        if (!flag)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        expandablelistview.setImageResource(i);
        return false;
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData("PaymentOptions", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
    }
}
