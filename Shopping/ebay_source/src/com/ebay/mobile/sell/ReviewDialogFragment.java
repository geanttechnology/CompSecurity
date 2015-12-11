// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseDmDialogFragment;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.util.ListingFees;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.LdsError;
import com.ebay.nautilus.domain.data.LdsFee;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.sell:
//            FormatPriceSpokeFragment, ListingFragmentActivity, PreviewListingActivity

public class ReviewDialogFragment extends BaseDmDialogFragment
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    private static final String ALL_FEES = "NONE";
    private static final String FREE_INSERTION = "FREE_INSERTION_FEE";
    private static final String FREE_LISTING = "FREE_LISTING_FEE";
    protected CheckedTextView autoRelistCheckedText;
    private RelativeLayout autoRelistContainer;
    protected TextView autoRelistDetails;
    protected View autoRelistDetailsContainer;
    private boolean autoRelistDetailsExpanded;
    protected TextView autoRelistLearnMore;
    private ListingDraftDataManager dm;
    private LinearLayout fees;
    private TextView finalValueFee;
    private View guaranteeLayout;
    private TextView guaranteeSubtext;
    private LayoutInflater inflater;
    private boolean isGuaranteeSelected;
    private com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams keyParams;
    private ListingDraft latestDraft;
    private View previewButton;
    private Button publishButton;
    private TextView publishTerms;
    private TextView sellerFeesLink;
    private TextView ship2FundNotice;
    private TextView totalFees;

    public ReviewDialogFragment()
    {
        autoRelistDetailsExpanded = false;
    }

    private void addPreviewFee(ViewGroup viewgroup, String s, String s1)
    {
        viewgroup = (LinearLayout)inflater.inflate(0x7f030211, viewgroup, false);
        fees.addView(viewgroup);
        ((TextView)viewgroup.findViewById(0x7f1000ec)).setText(s);
        ((TextView)viewgroup.findViewById(0x7f1006a7)).setText(s1);
    }

    private String cleanMessage(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "";
        } else
        {
            int i = s.indexOf("Learn more");
            if (i != -1)
            {
                return s.substring(0, i);
            }
            i = s.indexOf("En savoir plus");
            s1 = s;
            if (i != -1)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    private void setAutoRelistCheckboxText(String s, boolean flag)
    {
        String s1 = getResources().getString(0x7f07017d);
        s = new SpannableString((new StringBuilder()).append(s1).append("\n").append(s).toString());
        s.setSpan(new RelativeSizeSpan(1.1F), 0, s1.length(), 17);
        if (flag)
        {
            s.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d00e7)), s1.length(), s.length(), 34);
        }
        autoRelistCheckedText.setText(s, android.widget.TextView.BufferType.SPANNABLE);
        autoRelistCheckedText.post(new Runnable() {

            final ReviewDialogFragment this$0;

            public void run()
            {
                autoRelistCheckedText.setLines(autoRelistCheckedText.getLineCount());
            }

            
            {
                this$0 = ReviewDialogFragment.this;
                super();
            }
        });
    }

    private void setAutoRelistDetailsText(ListingDraft listingdraft, boolean flag)
    {
        String s;
        int i;
        int j;
        if (listingdraft.autoRelistFeeSetting == null || listingdraft.autoRelistCount == null || listingdraft.autoRelistMaxRelist == null || !listingdraft.autoRelistFeeSetting.hasSelection() || !listingdraft.autoRelistCount.hasSelection() || !listingdraft.autoRelistMaxRelist.hasSelection())
        {
            autoRelistContainer.setVisibility(8);
            return;
        }
        s = listingdraft.autoRelistFeeSetting.getStringValue();
        int k = listingdraft.autoRelistCount.getIntValue();
        i = listingdraft.autoRelistMaxRelist.getIntValue();
        j = i;
        if (k >= 0)
        {
            j = i - listingdraft.autoRelistCount.getIntValue();
        }
        if (j == 0)
        {
            autoRelistContainer.setVisibility(8);
            return;
        }
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 164
    //                   2402104: 278
    //                   439963939: 263
    //                   518905272: 248;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_278;
_L5:
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            autoRelistDetails.setText(getString(0x7f07007c));
            autoRelistLearnMore.setText(getString(0x7f07007b));
            setAutoRelistCheckboxText(getResources().getQuantityString(0x7f080001, j, new Object[] {
                Integer.valueOf(j)
            }), flag);
            return;

        case 1: // '\001'
            autoRelistDetails.setText(getString(0x7f070078));
            autoRelistLearnMore.setText(getString(0x7f07007a));
            setAutoRelistCheckboxText(getResources().getQuantityString(0x7f080000, j, new Object[] {
                Integer.valueOf(j)
            }), flag);
            return;

        case 2: // '\002'
            autoRelistDetails.setText(getString(0x7f070077));
            break;
        }
        break MISSING_BLOCK_LABEL_365;
_L4:
        if (s.equals("FREE_LISTING_FEE"))
        {
            i = 0;
        }
          goto _L5
_L3:
        if (s.equals("FREE_INSERTION_FEE"))
        {
            i = 1;
        }
          goto _L5
        if (s.equals("NONE"))
        {
            i = 2;
        }
          goto _L5
        autoRelistLearnMore.setText(getString(0x7f070079));
        setAutoRelistCheckboxText(getResources().getQuantityString(0x7f080000, j, new Object[] {
            Integer.valueOf(j)
        }), flag);
        return;
    }

    private void setShipToFundText(final String url, String s)
    {
        if (url == null)
        {
            ship2FundNotice.setText(s);
            return;
        } else
        {
            String s1 = (new StringBuilder()).append(s).append(" ").append(getString(0x7f0709ae)).toString();
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s1);
            spannablestringbuilder.setSpan(new ClickableSpan() {

                final ReviewDialogFragment this$0;
                final String val$url;

                public void onClick(View view)
                {
                    if (MyApp.getPrefs().getUserIsPpa())
                    {
                        getActivity().showDialog(0x7f0707aa);
                        return;
                    } else
                    {
                        view = getActivity();
                        Intent intent = new Intent(view, com/ebay/mobile/activities/ShowWebViewActivity);
                        intent.putExtra("url", url);
                        intent.putExtra("android.intent.extra.TITLE", getString(0x7f070a5c));
                        intent.putExtra("use_sso", true);
                        view.startActivity(intent);
                        return;
                    }
                }

            
            {
                this$0 = ReviewDialogFragment.this;
                url = s;
                super();
            }
            }, s.length() + 1, s1.length(), 34);
            ship2FundNotice.setText(spannablestringbuilder);
            ship2FundNotice.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
    }

    private void showSellerFees()
    {
        final String url = com.ebay.common.view.util.EbayCountryManager.Default.sellerFeesUrl(keyParams.draftSite.idInt);
        if (url == null)
        {
            sellerFeesLink.setVisibility(8);
            return;
        }
        sellerFeesLink.setVisibility(0);
        String s;
        SpannableStringBuilder spannablestringbuilder;
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            s = getString(0x7f070071);
        } else
        {
            s = getString(0x7f0709f1);
        }
        spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new ClickableSpan() {

            final ReviewDialogFragment this$0;
            final String val$url;

            public void onClick(View view)
            {
                ShowWebViewActivity.start(getActivity(), url, getString(0x7f070547), "SellerFeesInfo");
            }

            
            {
                this$0 = ReviewDialogFragment.this;
                url = s;
                super();
            }
        }, 0, s.length(), 0);
        sellerFeesLink.setText(spannablestringbuilder);
        sellerFeesLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void showShipToFundNotice(ListingDraft listingdraft)
    {
        boolean flag = false;
        listingdraft = listingdraft.warnings.iterator();
        do
        {
            if (!listingdraft.hasNext())
            {
                break;
            }
            LdsError ldserror = (LdsError)listingdraft.next();
            if ("121917236".equals(ldserror.id))
            {
                setShipToFundText(ldserror.parameterPaymentHoldUrl, cleanMessage(ldserror.longMessage));
                flag = true;
            }
        } while (true);
        if (flag)
        {
            ship2FundNotice.setVisibility(0);
            return;
        } else
        {
            ship2FundNotice.setVisibility(8);
            return;
        }
    }

    private void updateState()
    {
        String s;
        int i;
        boolean flag;
        EbaySite ebaysite = keyParams.draftSite;
        s = keyParams.listingMode;
        flag = ebaysite.isEuSite();
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 64
    //                   246818852: 486
    //                   481200203: 470
    //                   1320222924: 502;
           goto _L1 _L2 _L3 _L4
_L1:
        i;
        JVM INSTR tableswitch 0 2: default 92
    //                   0 518
    //                   1 557
    //                   2 596;
           goto _L5 _L6 _L7 _L8
_L5:
        Object obj;
        Iterator iterator;
        LdsFee ldsfee;
        if (flag)
        {
            publishButton.setText(getString(0x7f070062));
        } else
        {
            publishButton.setText(getString(0x7f0701ad));
        }
        break; /* Loop/switch isn't completed */
_L3:
        if (s.equals("ReviseItem"))
        {
            i = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("RelistItem"))
        {
            i = 1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s.equals("SellSimilarItem"))
        {
            i = 2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (flag)
        {
            publishButton.setText(getString(0x7f070064));
        } else
        {
            publishButton.setText(getString(0x7f0701b4));
        }
        break MISSING_BLOCK_LABEL_111;
_L7:
        if (flag)
        {
            publishButton.setText(getString(0x7f070063));
        } else
        {
            publishButton.setText(getString(0x7f0701ad));
        }
        break MISSING_BLOCK_LABEL_111;
_L8:
        if (flag)
        {
            publishButton.setText(getString(0x7f070065));
        } else
        {
            publishButton.setText(getString(0x7f0701ad));
        }
        break MISSING_BLOCK_LABEL_111;
        if (207 == latestDraft.siteId || 216 == latestDraft.siteId || 211 == latestDraft.siteId)
        {
            finalValueFee.setVisibility(8);
        }
        if (latestDraft.feeOnTotalCost != null && latestDraft.feeOnTotalCost.hasSelection() && latestDraft.feeOnTotalCost.getBooleanValue())
        {
            if (latestDraft.siteId == 0 || 100 == latestDraft.siteId || 2 == latestDraft.siteId || 210 == latestDraft.siteId)
            {
                i = 0x7f070414;
            } else
            if (flag)
            {
                i = 0x7f07006c;
            } else
            if (203 == latestDraft.siteId)
            {
                i = 0x7f070ce2;
            } else
            {
                i = 0x7f070088;
            }
        } else
        {
            i = 0x7f070415;
        }
        finalValueFee.setText(getString(i));
        if (flag)
        {
            publishTerms.setVisibility(0);
            publishTerms.setText(Html.fromHtml(getString(0x7f07006e, new Object[] {
                (new StringBuilder()).append("<b>").append(publishButton.getText()).append("</b>").toString()
            })));
        }
        previewButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ReviewDialogFragment this$0;

            public void onClick(View view)
            {
                if (MyApp.getPrefs().getUserIsPpa())
                {
                    getActivity().showDialog(0x7f0707aa);
                    return;
                } else
                {
                    view = (new StringBuilder()).append("http://previewitem.").append(EbaySite.getInstanceFromId(latestDraft.siteId).getDomain()).append("/").append("ws/eBayISAPI.dll?PreviewItemV4&md=1&noPreviewHeader=1&SessionId=").append(latestDraft.id).toString();
                    PreviewListingActivity.start(getActivity(), view, getString(0x7f0707b0));
                    return;
                }
            }

            
            {
                this$0 = ReviewDialogFragment.this;
                super();
            }
        });
        fees.removeAllViews();
        obj = fees;
        if (latestDraft.fees.isEmpty())
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        iterator = latestDraft.fees.iterator();
        while (iterator.hasNext()) 
        {
            ldsfee = (LdsFee)iterator.next();
            obj = latestDraft.feesCurrencyCode;
            Object obj1 = new CurrencyAmount(ldsfee.value, ((String) (obj)));
            if (((CurrencyAmount) (obj1)).isZero())
            {
                obj1 = getString(0x7f070422);
            } else
            {
                obj1 = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj1)), 0);
            }
            addPreviewFee(fees, ListingFees.getCaption(getActivity(), ldsfee.type), ((String) (obj1)));
        }
        Object obj2 = latestDraft.feeTotal();
        if (obj2 != null)
        {
            if (((CurrencyAmount) (obj2)).isZero())
            {
                obj2 = getString(0x7f070422);
            } else
            {
                obj2 = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj2)), 0);
            }
            totalFees.setText(((CharSequence) (obj2)));
        }
        obj2 = DeviceConfiguration.getAsync();
        if (latestDraft.autoRelistEnabled != null && !latestDraft.autoRelistEnabled.getBmode().equals("DISABLE") && latestDraft.autoRelistFeeSetting != null && ((DeviceConfiguration) (obj2)).get(DcsBoolean.SellAutoRelist) && (!latestDraft.isGuaranteeAvailable() || !isGuaranteeSelected))
        {
            if ("FREE_LISTING_FEE".equals(latestDraft.autoRelistFeeSetting.getStringValue()) && ((DeviceConfiguration) (obj2)).get(DcsBoolean.SellAutoRelistGuidance) && !"ReviseItem".equals(s) && s != null && (s.equals("AddItem") || s.equals("SellLikeItem")))
            {
                autoRelistCheckedText.setChecked(true);
            }
            if (s == null || s.equals("ReviseItem") || s.equals("RelistItem") || s.equals("SellSimilarItem"))
            {
                autoRelistCheckedText.setChecked(latestDraft.autoRelistEnabled.getBooleanValue());
            }
            if (latestDraft.autoRelistEnabled.getBmode().equals("READ_ONLY"))
            {
                autoRelistCheckedText.setEnabled(false);
                autoRelistCheckedText.setTextColor(getResources().getColor(0x7f0d00eb));
                setAutoRelistDetailsText(latestDraft, false);
            } else
            {
                setAutoRelistDetailsText(latestDraft, true);
            }
        } else
        {
            autoRelistContainer.setVisibility(8);
        }
        if (latestDraft.isGuaranteeAvailable() && isGuaranteeSelected)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj2 = guaranteeLayout;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj2)).setVisibility(i);
        if (!latestDraft.isGuaranteeAvailable() || !isGuaranteeSelected) goto _L10; else goto _L9
_L9:
        obj2 = EbayCurrencyUtil.formatDisplay(latestDraft.getCurrencyCode(), latestDraft.guaranteeSalePrice.getDoubleValue(), 2);
        obj2 = new SpannableStringBuilder((new StringBuilder()).append(getString(0x7f0707bd, new Object[] {
            obj2
        })).append("\n").toString());
        i = 0x7f0707ba;
        if (!keyParams.draftSite.equals(EbaySite.US)) goto _L12; else goto _L11
_L11:
        i = 0x7f0707bb;
_L14:
        FormatPriceSpokeFragment.appendGuaranteeTermsLink(((SpannableStringBuilder) (obj2)), getActivity(), i, latestDraft.getGuaranteeTerms());
        guaranteeSubtext.setText(((CharSequence) (obj2)));
        guaranteeSubtext.setMovementMethod(LinkMovementMethod.getInstance());
        guaranteeSubtext.setTypeface(guaranteeSubtext.getTypeface(), 1);
_L10:
        showShipToFundNotice(latestDraft);
        showSellerFees();
        return;
_L12:
        if (keyParams.draftSite.equals(EbaySite.DE))
        {
            i = 0x7f0707b9;
        }
        if (true) goto _L14; else goto _L13
_L13:
        if (true) goto _L1; else goto _L15
_L15:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756707: 
            Object obj = null;
            view = obj;
            if (autoRelistCheckedText.isEnabled())
            {
                view = obj;
                if (autoRelistContainer.getVisibility() == 0)
                {
                    view = (new StringBuilder()).append(autoRelistCheckedText.isChecked()).append("").toString();
                }
            }
            dm.publishDraft(view);
            return;

        case 2131756760: 
            autoRelistCheckedText.toggle();
            return;

        case 2131756761: 
            autoRelistDetailsContainer.setVisibility(0);
            autoRelistDetailsExpanded = true;
            autoRelistLearnMore.setVisibility(8);
            return;

        case 2131756762: 
            autoRelistDetailsContainer.setVisibility(8);
            autoRelistDetailsExpanded = false;
            autoRelistLearnMore.setVisibility(0);
            return;

        case 2131755946: 
        case 2131755947: 
            dismiss();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        autoRelistDetailsContainer.setVisibility(0);
        autoRelistLearnMore.setVisibility(0);
        autoRelistDetailsContainer.post(new Runnable() {

            final ReviewDialogFragment this$0;

            public void run()
            {
                autoRelistDetails.setLines(autoRelistDetails.getLineCount());
                autoRelistLearnMore.setLines(autoRelistLearnMore.getLineCount());
                autoRelistCheckedText.setLines(autoRelistCheckedText.getLineCount());
                if (autoRelistDetailsExpanded)
                {
                    autoRelistLearnMore.setVisibility(8);
                    return;
                } else
                {
                    autoRelistDetailsContainer.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = ReviewDialogFragment.this;
                super();
            }
        });
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        } else
        {
            latestDraft = (ListingDraft)listingdraftcontent.getData();
            isGuaranteeSelected = listingdraftcontent.isGuaranteeSelectedThisSession;
            updateState();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a0282);
        keyParams = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        return layoutinflater.inflate(0x7f030210, viewgroup, false);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)datamanagercontainer.initialize(keyParams, this);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellVerifyAddItemSuccess");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        fees = (LinearLayout)view.findViewById(0x7f10069c);
        totalFees = (TextView)view.findViewById(0x7f10069d);
        publishButton = (Button)view.findViewById(0x7f1006a3);
        publishButton.setOnClickListener(this);
        finalValueFee = (TextView)view.findViewById(0x7f10069e);
        ship2FundNotice = (TextView)view.findViewById(0x7f1006a6);
        sellerFeesLink = (TextView)view.findViewById(0x7f10069f);
        autoRelistCheckedText = (CheckedTextView)view.findViewById(0x7f1006d8);
        autoRelistCheckedText.setOnClickListener(this);
        autoRelistContainer = (RelativeLayout)view.findViewById(0x7f1006d7);
        autoRelistLearnMore = (TextView)view.findViewById(0x7f1006d9);
        autoRelistLearnMore.setOnClickListener(this);
        autoRelistDetailsContainer = view.findViewById(0x7f1006da);
        autoRelistDetails = (TextView)view.findViewById(0x7f1006db);
        autoRelistDetailsContainer.setOnClickListener(this);
        autoRelistDetailsContainer.post(new Runnable() {

            final ReviewDialogFragment this$0;

            public void run()
            {
                autoRelistDetails.setLines(autoRelistDetails.getLineCount());
                autoRelistLearnMore.setLines(autoRelistLearnMore.getLineCount());
                autoRelistDetailsContainer.setVisibility(8);
            }

            
            {
                this$0 = ReviewDialogFragment.this;
                super();
            }
        });
        publishTerms = (TextView)view.findViewById(0x7f1006a5);
        previewButton = view.findViewById(0x7f1006a4);
        ((TextView)view.findViewById(0x7f1003a5)).setText(getString(0x7f070b67));
        guaranteeLayout = view.findViewById(0x7f1006a0);
        guaranteeSubtext = (TextView)view.findViewById(0x7f1006a2);
        if (view.getContext().getResources().getBoolean(0x7f0b0006))
        {
            view.findViewById(0x7f1003ab).setOnClickListener(this);
            return;
        } else
        {
            view.findViewById(0x7f1003ab).setVisibility(8);
            view.findViewById(0x7f1003aa).setVisibility(0);
            view.findViewById(0x7f1003aa).setOnClickListener(this);
            return;
        }
    }


}
