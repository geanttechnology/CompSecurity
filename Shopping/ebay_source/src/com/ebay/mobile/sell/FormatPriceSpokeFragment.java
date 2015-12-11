// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.widget.CustomScrollView;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ListingFragmentActivity

public class FormatPriceSpokeFragment extends BaseSpokeFragment
    implements android.app.DatePickerDialog.OnDateSetListener, android.app.TimePickerDialog.OnTimeSetListener, android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    private static final String DATE_DIALOG = "dateDialog";
    private static final int DIALOG_SCHEDULE_DATE = 1;
    private static final int DIALOG_SCHEDULE_TIME = 2;
    private static final String TIME_DIALOG = "timeDialog";
    private TextView auctionPriceGuidance;
    private TextView autoAccept;
    private View autoAcceptLayout;
    private PriceView autoAcceptValue;
    private TextView autoDecline;
    private View autoDeclineLayout;
    private PriceView autoDeclineValue;
    private CheckedTextView bestOffer;
    private View bestOfferLabel;
    protected LinearLayout bestOfferLayout;
    private TextView binPriceGuidance;
    private LinearLayout binPriceRow;
    private PriceView binPriceView;
    private ArrayAdapter currencyAdapter;
    private View currencyParent;
    private EbaySpinner currencySpinner;
    private DateFormat dateFormatter;
    private ListingDraftDataManager dm;
    private View doItMyselfButton;
    private View doItMyselfLayout;
    private ArrayAdapter durationAdapter;
    private EbaySpinner durationSpinner;
    private View durationStartTimeLayout;
    private TextView endDate;
    private TextView fixedPriceGuidance;
    private LinearLayout fixedPriceRow;
    private PriceView fixedPriceView;
    private ContainerLayout formatList;
    private CheckedTextView guaranteeCheckBox;
    private TextView guaranteeHeading;
    private View guaranteeLayout;
    private TextView guaranteeSimilarItems;
    private TextView guaranteeSubtext;
    private boolean hasUserClickedDoItMyself;
    private View helpLayout;
    private LayoutInflater inflater;
    private boolean isGuaranteeAvailable;
    private boolean isGuaranteeSelectedThisSession;
    private com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams keyParams;
    private int lastFormatPosition;
    private ListingDraft latestDraft;
    private View listAuctionView;
    private View listFixedPriceView;
    private ImageView moreOptionsArrow;
    private TextView moreOptionsText;
    protected CustomScrollView parent;
    private View progress;
    private EditText quantityEditText;
    private LinearLayout quantityRow;
    private LinearLayout reservePriceRow;
    private PriceView reservePriceView;
    protected View scheduleButtonsLayout;
    private Button scheduleDateButton;
    private EbaySpinner scheduleSpinner;
    private Button scheduleTimeButton;
    private boolean showingAdvancedOptions;
    private LinearLayout startPriceRow;
    private PriceView startPriceView;
    private DateFormat timeFormatter;

    public FormatPriceSpokeFragment()
    {
        lastFormatPosition = -1;
        showingAdvancedOptions = false;
        isGuaranteeAvailable = false;
        isGuaranteeSelectedThisSession = false;
        hasUserClickedDoItMyself = false;
    }

    protected static void appendGuaranteeTermsLink(SpannableStringBuilder spannablestringbuilder, Activity activity, int i, String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            int j = spannablestringbuilder.length();
            String s1 = activity.getString(i);
            spannablestringbuilder.append(s1);
            spannablestringbuilder.setSpan(new ClickableSpan(activity, s) {

                final Activity val$activity;
                final String val$termsUrl;

                public void onClick(View view)
                {
                    ShowWebViewActivity.start(activity, termsUrl, "", "spgLearnMore");
                }

                public void updateDrawState(TextPaint textpaint)
                {
                    textpaint.setColor(textpaint.linkColor);
                    textpaint.setUnderlineText(false);
                }

            
            {
                activity = activity1;
                termsUrl = s;
                super();
            }
            }, j, s1.length() + j, 0);
            return;
        }
    }

    private static boolean areDoubleValuesEqual(double d, double d1)
    {
        return Math.abs(d - d1) < 9.9999999999999995E-07D;
    }

    private void buildFormatList()
    {
        formatList.removeAllViews();
        if (latestDraft.format != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        int k;
        boolean flag;
        flag = latestDraft.format.isEnabled();
        TypedArray typedarray = getView().getContext().obtainStyledAttributes(0x101004d, new int[] {
            0x101004d
        });
        k = typedarray.getDimensionPixelSize(0, -1);
        typedarray.recycle();
        j = 0;
_L6:
        if (j >= latestDraft.format.options.size()) goto _L1; else goto _L3
_L3:
        Object obj = (LdsOption)latestDraft.format.options.get(j);
        if (((LdsOption) (obj)).value != null) goto _L5; else goto _L4
_L4:
        j++;
          goto _L6
_L5:
        String s;
        LinearLayout linearlayout;
        CheckedTextView checkedtextview;
        int i;
        linearlayout = (LinearLayout)inflater.inflate(0x7f030220, formatList, false);
        checkedtextview = (CheckedTextView)linearlayout.findViewById(0x1020014);
        s = ((LdsOption) (obj)).value;
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 204
    //                   -958976089: 400
    //                   -607502763: 384
    //                   1448981437: 416
    //                   1471919286: 368;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        i;
        JVM INSTR tableswitch 0 3: default 236
    //                   0 432
    //                   1 457
    //                   2 457
    //                   3 482;
           goto _L12 _L13 _L14 _L14 _L15
_L12:
        obj = s;
        checkedtextview.setEnabled(false);
_L16:
        checkedtextview.setText(((CharSequence) (obj)));
        linearlayout.setTag(Integer.valueOf(j));
        if (checkedtextview.isEnabled())
        {
            linearlayout.setClickable(true);
            linearlayout.setOnClickListener(this);
        }
        i = (int)TypedValue.applyDimension(1, 6F, getResources().getDisplayMetrics());
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(i, 0, i, 0);
        checkedtextview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        checkedtextview.setMinHeight(k);
        if (s.equals(latestDraft.format.getStringValue()))
        {
            checkedtextview.setChecked(true);
            lastFormatPosition = j;
        }
        formatList.addView(linearlayout);
          goto _L4
_L11:
        if (s.equals("ChineseAuction"))
        {
            i = 0;
        }
          goto _L7
_L9:
        if (s.equals("FixedPrice"))
        {
            i = 1;
        }
          goto _L7
_L8:
        if (s.equals("StoresFixedPrice"))
        {
            i = 2;
        }
          goto _L7
_L10:
        if (s.equals("ClassfiedAd"))
        {
            i = 3;
        }
          goto _L7
_L13:
        obj = getString(0x7f0701a3);
        listAuctionView = linearlayout;
        listAuctionView.setEnabled(flag);
          goto _L16
_L14:
        obj = getString(0x7f0701a5);
        listFixedPriceView = linearlayout;
        listFixedPriceView.setEnabled(flag);
          goto _L16
_L15:
        obj = getString(0x7f0701a4);
        checkedtextview.setEnabled(false);
          goto _L16
    }

    private void currencyUpdateOptions(LdsField ldsfield)
    {
        currencyAdapter.clear();
        LdsOption ldsoption;
        for (ldsfield = ldsfield.options.iterator(); ldsfield.hasNext(); currencyAdapter.add(ldsoption))
        {
            ldsoption = (LdsOption)ldsfield.next();
        }

        currencyAdapter.notifyDataSetChanged();
    }

    private void currencyUpdateSelection(LdsField ldsfield)
    {
        String s = latestDraft.getCurrencyCode();
        Iterator iterator = ldsfield.options.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsOption ldsoption = (LdsOption)iterator.next();
            if (!ldsoption.value.equals(s))
            {
                continue;
            }
            currencySpinner.setSelection(ldsfield.options.indexOf(ldsoption));
            break;
        } while (true);
    }

    private void durationUpdateOptions(LdsField ldsfield)
    {
        durationAdapter.clear();
        LdsOption ldsoption;
        for (ldsfield = ldsfield.options.iterator(); ldsfield.hasNext(); durationAdapter.add(ldsoption))
        {
            ldsoption = (LdsOption)ldsfield.next();
        }

        durationAdapter.notifyDataSetChanged();
    }

    private void durationUpdateSelection(LdsField ldsfield)
    {
        String s = ldsfield.getStringValue();
        Iterator iterator = ldsfield.options.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsOption ldsoption = (LdsOption)iterator.next();
            if (!ldsoption.value.equals(s))
            {
                continue;
            }
            durationSpinner.setSelection(ldsfield.options.indexOf(ldsoption));
            break;
        } while (true);
    }

    private com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.FormatPriceTextFields getTextFields()
    {
        com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.FormatPriceTextFields formatpricetextfields = new com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.FormatPriceTextFields();
        formatpricetextfields.startPrice = String.valueOf(startPriceView.getPrice());
        formatpricetextfields.binPrice = String.valueOf(binPriceView.getPrice());
        formatpricetextfields.reservePrice = String.valueOf(reservePriceView.getPrice());
        formatpricetextfields.fixedPrice = String.valueOf(fixedPriceView.getPrice());
        formatpricetextfields.quantity = quantityEditText.getText().toString();
        formatpricetextfields.autoAcceptValue = String.valueOf(autoAcceptValue.getPrice());
        formatpricetextfields.autoDeclineValue = String.valueOf(autoDeclineValue.getPrice());
        return formatpricetextfields;
    }

    private void initializeInputFieldValues()
    {
        guaranteeCheckBox.setChecked(isGuaranteeSelectedThisSession);
        Object obj = latestDraft.getCurrencyCode();
        if (latestDraft.startPrice != null)
        {
            updatePriceValue(startPriceView, latestDraft.startPrice, ((String) (obj)));
        }
        if (latestDraft.variationItems.isEmpty() && latestDraft.price != null)
        {
            updatePriceValue(binPriceView, latestDraft.price, ((String) (obj)));
        }
        if (latestDraft.variationItems.isEmpty() && latestDraft.price != null)
        {
            updatePriceValue(fixedPriceView, latestDraft.price, ((String) (obj)));
        }
        if (latestDraft.reservePrice != null)
        {
            updatePriceValue(reservePriceView, latestDraft.reservePrice, ((String) (obj)));
        }
        if (latestDraft.quantity != null)
        {
            updateTextValue(quantityEditText, latestDraft.quantity);
        }
        if (latestDraft.startDateEnabled != null)
        {
            boolean flag = latestDraft.startDateEnabled.getBooleanValue();
            EbaySpinner ebayspinner = scheduleSpinner;
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            ebayspinner.setSelection(i);
        }
        if (latestDraft.bestOfferEnabled != null)
        {
            flag = latestDraft.bestOfferEnabled.getBooleanValue();
            bestOffer.setChecked(flag);
        }
        if (latestDraft.bestOfferAutoAcceptValue != null)
        {
            updatePriceValue(autoAcceptValue, latestDraft.bestOfferAutoAcceptValue, ((String) (obj)));
        }
        if (latestDraft.bestOfferAutoDeclineValue != null)
        {
            updatePriceValue(autoDeclineValue, latestDraft.bestOfferAutoDeclineValue, ((String) (obj)));
        }
        obj = latestDraft.getCurrencyUnsafe();
        if (obj != null)
        {
            currencyUpdateOptions(((LdsField) (obj)));
            currencyUpdateSelection(((LdsField) (obj)));
        }
        if (latestDraft.duration != null)
        {
            durationUpdateOptions(latestDraft.duration);
            durationUpdateSelection(latestDraft.duration);
        }
    }

    private void sendPriceRecommendationTracking()
    {
        String s = null;
        if (latestDraft != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!"ChineseAuction".equals(latestDraft.format.getStringValue()))
        {
            continue; /* Loop/switch isn't completed */
        }
        Double double1 = Double.valueOf(startPriceView.getPrice());
        double d = binPriceView.getPrice();
        if (latestDraft.recommendedStartPrice != null && !startPriceView.isEmpty() && double1.doubleValue() > 0.0D)
        {
            TrackingData trackingdata = new TrackingData("SellingPriceRecommendation", TrackingType.EVENT);
            if (latestDraft.recommendedPrice != null)
            {
                double d3 = latestDraft.recommendedPrice.getDoubleValue();
                trackingdata.addKeyValuePair("recbprice", (new StringBuilder()).append(d3).append("").toString());
                if (!areDoubleValuesEqual(Double.valueOf(d).doubleValue(), d3))
                {
                    double d1;
                    if (binPriceView.isEmpty())
                    {
                        s = "0.0";
                    } else
                    {
                        s = binPriceView.getPriceAsString();
                    }
                    trackingdata.addKeyValuePair("actbprice", s);
                }
            }
            if (latestDraft.recommendedStartPrice != null)
            {
                d1 = latestDraft.recommendedStartPrice.getDoubleValue();
                trackingdata.addKeyValuePair("recsprice", (new StringBuilder()).append(d1).append("").toString());
                if (!areDoubleValuesEqual(double1.doubleValue(), d1))
                {
                    trackingdata.addKeyValuePair("actsprice", startPriceView.getPriceAsString());
                }
            }
            trackingdata.addKeyValuePair("smd", ListingFragmentActivity.listingModeToTrackingMode(keyParams.listingMode, false));
            trackingdata.addKeyValuePair("draft_id", latestDraft.id);
            if (latestDraft.category != null)
            {
                s = latestDraft.category.getStringValue();
            } else
            {
                s = null;
            }
            trackingdata.addKeyValuePair("leaf", s);
            trackingdata.send(getActivity());
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!"FixedPrice".equals(latestDraft.format.getStringValue()) && !"StoresFixedPrice".equals(latestDraft.format.getStringValue())) goto _L1; else goto _L3
_L3:
        Double double2 = Double.valueOf(fixedPriceView.getPrice());
        if (latestDraft.recommendedPrice != null && !fixedPriceView.isEmpty() && double2.doubleValue() > 0.0D)
        {
            double d2 = latestDraft.recommendedPrice.getDoubleValue();
            TrackingData trackingdata1 = new TrackingData("SellingPriceRecommendation", TrackingType.EVENT);
            trackingdata1.addKeyValuePair("recbprice", (new StringBuilder()).append(d2).append("").toString());
            if (!areDoubleValuesEqual(double2.doubleValue(), d2))
            {
                trackingdata1.addKeyValuePair("actbprice", fixedPriceView.getPriceAsString());
            }
            trackingdata1.addKeyValuePair("smd", ListingFragmentActivity.listingModeToTrackingMode(keyParams.listingMode, false));
            trackingdata1.addKeyValuePair("draft_id", latestDraft.id);
            if (latestDraft.category != null)
            {
                s = latestDraft.category.getStringValue();
            }
            trackingdata1.addKeyValuePair("leaf", s);
            trackingdata1.send(getActivity());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void updateBestOfferChildVisibility(boolean flag)
    {
        boolean flag1 = false;
        View view = autoAcceptLayout;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = autoDeclineLayout;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void updateEndDate(Date date, String s)
    {
        if (s == null)
        {
            endDate.setText(null);
            return;
        }
        if (s.equals("GTC"))
        {
            endDate.setText(getResources().getString(0x7f0703b9));
            return;
        }
        Object obj = date;
        date = ((Date) (obj));
        if (obj == null)
        {
            date = new Date();
        }
        int i = Integer.parseInt(s.substring("Days_".length()));
        s = Calendar.getInstance();
        s.setTime(date);
        s.add(5, i);
        date = (new SimpleDateFormat("EEE", Locale.getDefault())).format(s.getTime());
        obj = dateFormatter.format(s.getTime());
        s = timeFormatter.format(s.getTime());
        endDate.setText((new StringBuilder()).append(date).append("  ").append(((String) (obj))).append("  ").append(s).toString());
    }

    private void updateFormatGuidanceDisplay()
    {
label0:
        {
            Object obj = DeviceConfiguration.getAsync();
            Object obj1;
            boolean flag;
            boolean flag1;
            if (latestDraft.productId != null && !TextUtils.isEmpty(latestDraft.productId.getStringValue()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                flag1 = ((DeviceConfiguration) (obj)).get(DcsBoolean.SellHardGoodsPriceGuidance);
            } else
            {
                flag1 = ((DeviceConfiguration) (obj)).get(DcsBoolean.SellSoftGoodsPriceGuidance);
            }
            obj1 = latestDraft.recommendedFormat;
            obj = latestDraft.format.getStringValue();
            if (obj1 != null && !TextUtils.isEmpty(((CharSequence) (obj))) && flag1)
            {
                obj1 = ((LdsField) (obj1)).getStringValue();
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    if (((String) (obj1)).equals("ChineseAuction") && listAuctionView != null)
                    {
                        if (!((String) (obj)).equals("ChineseAuction"))
                        {
                            TextView textview = (TextView)listAuctionView.findViewById(0x7f10070a);
                            textview.setText(getString(0x7f0705e7));
                            textview.setVisibility(0);
                        } else
                        {
                            listAuctionView.findViewById(0x7f10070a).setVisibility(8);
                        }
                    }
                    if ((((String) (obj1)).equals("FixedPrice") || ((String) (obj1)).equals("StoresFixedPrice")) && listFixedPriceView != null)
                    {
                        if (((String) (obj)).equals("FixedPrice") || ((String) (obj)).equals("StoresFixedPrice"))
                        {
                            break label0;
                        }
                        obj = (TextView)listFixedPriceView.findViewById(0x7f10070a);
                        ((TextView) (obj)).setText(getString(0x7f0705e8));
                        ((TextView) (obj)).setVisibility(0);
                    }
                }
            }
            return;
        }
        listFixedPriceView.findViewById(0x7f10070a).setVisibility(8);
    }

    private void updateGuaranteeText()
    {
        if (!isGuaranteeAvailable)
        {
            return;
        }
        String s = latestDraft.getCurrencyCode();
        Object obj = latestDraft.recommendedDuration.getStringValue();
        String s1 = LdsField.getStringValueSafe(latestDraft.guaranteeStartPrice);
        int i;
        if (TextUtils.isEmpty(s1))
        {
            obj = "";
        } else
        {
            obj = getString(0x7f070445, new Object[] {
                obj, EbayCurrencyUtil.formatDisplay(s, Double.valueOf(s1).doubleValue(), 2)
            });
        }
        guaranteeCheckBox.setText(((CharSequence) (obj)));
        guaranteeCheckBox.setTypeface(guaranteeCheckBox.getTypeface(), 1);
        obj = EbayCurrencyUtil.formatDisplay(latestDraft.getCurrencyCode(), latestDraft.guaranteeSalePrice.getDoubleValue(), 2);
        guaranteeHeading.setText(getString(0x7f0707b3, new Object[] {
            obj
        }));
        obj = new SpannableStringBuilder((new StringBuilder()).append(getString(0x7f0707bc, new Object[] {
            obj
        })).append("\n").toString());
        i = 0x7f0707ba;
        if (keyParams.draftSite.equals(EbaySite.US))
        {
            i = 0x7f0707bb;
        } else
        if (keyParams.draftSite.equals(EbaySite.DE))
        {
            i = 0x7f0707b9;
        }
        appendGuaranteeTermsLink(((SpannableStringBuilder) (obj)), getActivity(), i, latestDraft.getGuaranteeTerms());
        guaranteeSubtext.setText(((CharSequence) (obj)));
        guaranteeSubtext.setMovementMethod(LinkMovementMethod.getInstance());
        if (latestDraft.similarListingPriceMin != null && latestDraft.similarListingPriceMax != null)
        {
            obj = EbayCurrencyUtil.formatDisplay(s, latestDraft.similarListingPriceMin.getDoubleValue(), 2);
            String s2 = EbayCurrencyUtil.formatDisplay(s, latestDraft.similarListingPriceMax.getDoubleValue(), 2);
            obj = getString(0x7f070444, new Object[] {
                EbayCurrencyUtil.formatDisplay(s, Double.valueOf(s1).doubleValue(), 2), obj, s2
            });
            guaranteeSimilarItems.setText(((CharSequence) (obj)));
            guaranteeSimilarItems.setVisibility(0);
            return;
        } else
        {
            guaranteeSimilarItems.setVisibility(8);
            return;
        }
    }

    private void updateInputFieldEnabledState()
    {
        if (!latestDraft.listingMode.equals("ReviseItem"))
        {
            startPriceView.setShowHintTextForZero(true);
            binPriceView.setShowHintTextForZero(true);
            fixedPriceView.setShowHintTextForZero(true);
            reservePriceView.setShowHintTextForZero(true);
        }
        viewUpdate(startPriceView, latestDraft.startPrice);
        viewUpdateBinPrice(binPriceView, latestDraft.price, latestDraft.variationItems);
        viewUpdateBinPrice(fixedPriceView, latestDraft.price, latestDraft.variationItems);
        viewUpdate(reservePriceView, latestDraft.reservePrice);
        viewUpdate(quantityEditText, latestDraft.quantity);
        viewUpdate(currencySpinner, latestDraft.getCurrencyUnsafe());
        viewUpdate(bestOffer, latestDraft.bestOfferEnabled);
        viewUpdate(autoAccept, latestDraft.bestOfferAutoAccept);
        viewUpdate(autoAcceptValue, latestDraft.bestOfferAutoAcceptValue);
        viewUpdate(autoDecline, latestDraft.bestOfferAutoDecline);
        viewUpdate(autoDeclineValue, latestDraft.bestOfferAutoDeclineValue);
        viewUpdate(durationSpinner, latestDraft.duration);
        viewUpdate(scheduleSpinner, latestDraft.startDateEnabled);
        viewUpdate(scheduleDateButton, latestDraft.startDateEnabled);
        viewUpdate(scheduleTimeButton, latestDraft.startDateEnabled);
    }

    private void updateInputFieldValuesForDisabled()
    {
        Object obj = latestDraft.getCurrencyCode();
        if (latestDraft.startPrice != null && !startPriceView.isEnabled())
        {
            updatePriceValue(startPriceView, latestDraft.startPrice, ((String) (obj)));
        }
        if (latestDraft.variationItems.isEmpty() && latestDraft.price != null && !binPriceView.isEnabled())
        {
            updatePriceValue(binPriceView, latestDraft.price, ((String) (obj)));
        }
        if (latestDraft.variationItems.isEmpty() && latestDraft.price != null && !fixedPriceView.isEnabled())
        {
            updatePriceValue(fixedPriceView, latestDraft.price, ((String) (obj)));
        }
        if (latestDraft.reservePrice != null && !reservePriceView.isEnabled())
        {
            updatePriceValue(reservePriceView, latestDraft.reservePrice, ((String) (obj)));
        }
        if (latestDraft.quantity != null && !quantityEditText.isEnabled())
        {
            updateTextValue(quantityEditText, latestDraft.quantity);
        }
        if (latestDraft.startDateEnabled != null && !latestDraft.startDateEnabled.isEnabled())
        {
            boolean flag = latestDraft.startDateEnabled.getBooleanValue();
            EbaySpinner ebayspinner = scheduleSpinner;
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            ebayspinner.setSelection(i);
        }
        if (latestDraft.bestOfferEnabled != null && !latestDraft.bestOfferEnabled.isEnabled())
        {
            flag = latestDraft.bestOfferEnabled.getBooleanValue();
            bestOffer.setChecked(flag);
        }
        if (latestDraft.bestOfferAutoAcceptValue != null && !autoAcceptValue.isEnabled())
        {
            updatePriceValue(autoAcceptValue, latestDraft.bestOfferAutoAcceptValue, ((String) (obj)));
        }
        if (latestDraft.bestOfferAutoDeclineValue != null && !autoDeclineValue.isEnabled())
        {
            updatePriceValue(autoDeclineValue, latestDraft.bestOfferAutoDeclineValue, ((String) (obj)));
        }
        obj = latestDraft.getCurrencyUnsafe();
        if (obj != null)
        {
            currencyUpdateOptions(((LdsField) (obj)));
            currencyUpdateSelection(((LdsField) (obj)));
        }
        if (latestDraft.duration != null)
        {
            durationUpdateOptions(latestDraft.duration);
            durationUpdateSelection(latestDraft.duration);
        }
    }

    private void updateInputFieldVisibility()
    {
        Object obj;
        int i;
        boolean flag;
        byte byte0;
        flag = false;
        byte0 = 8;
        obj = guaranteeLayout;
        LdsField ldsfield;
        if (isGuaranteeAvailable)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        if (!isGuaranteeAvailable)
        {
            doItMyselfButton.setVisibility(8);
            doItMyselfLayout.setVisibility(0);
            helpLayout.setVisibility(0);
        } else
        if (isGuaranteeSelectedThisSession)
        {
            doItMyselfButton.setVisibility(8);
            doItMyselfLayout.setVisibility(8);
            helpLayout.setVisibility(8);
        } else
        if (hasUserClickedDoItMyself)
        {
            doItMyselfButton.setVisibility(8);
            doItMyselfLayout.setVisibility(0);
            helpLayout.setVisibility(0);
        } else
        {
            doItMyselfButton.setVisibility(0);
            doItMyselfLayout.setVisibility(8);
            helpLayout.setVisibility(8);
        }
        obj = latestDraft.format.getStringValue();
        ldsfield = latestDraft.getCurrencyUnsafe();
        if (ldsfield != null && !"DISABLE".equals(ldsfield.getBmode()) && ldsfield.options.size() > 1)
        {
            currencyParent.setVisibility(0);
        } else
        {
            currencyParent.setVisibility(8);
        }
        if (latestDraft.bestOfferEnabled != null)
        {
            updateBestOfferChildVisibility(latestDraft.bestOfferEnabled.getBooleanValue());
        } else
        {
            updateBestOfferChildVisibility(false);
        }
        if (latestDraft.startDateEnabled != null && latestDraft.startDateEnabled.getBooleanValue())
        {
            scheduleButtonsLayout.setVisibility(0);
        } else
        {
            scheduleButtonsLayout.setVisibility(8);
        }
        i = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 216
    //                   -958976089: 418
    //                   -607502763: 403
    //                   1448981437: 433
    //                   1471919286: 388;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_433;
_L6:
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            startPriceRow.setVisibility(0);
            LinearLayout linearlayout = binPriceRow;
            int j;
            if (showingAdvancedOptions || !binPriceView.isEmpty())
            {
                j = 0;
            } else
            {
                j = 8;
            }
            linearlayout.setVisibility(j);
            fixedPriceRow.setVisibility(8);
            if (dm.isReservePriceSupported())
            {
                Object obj1 = reservePriceRow;
                if (showingAdvancedOptions || !reservePriceView.isEmpty())
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                ((LinearLayout) (obj1)).setVisibility(j);
            } else
            {
                reservePriceRow.setVisibility(8);
            }
            quantityRow.setVisibility(8);
            obj1 = durationStartTimeLayout;
            if (showingAdvancedOptions)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 8;
            }
            ((View) (obj1)).setVisibility(j);
            bestOfferLabel.setVisibility(8);
            bestOfferLayout.setVisibility(8);
            return;

        case 1: // '\001'
        case 2: // '\002'
            startPriceRow.setVisibility(8);
            reservePriceRow.setVisibility(8);
            binPriceRow.setVisibility(8);
            fixedPriceRow.setVisibility(0);
            Object obj2 = quantityRow;
            int k;
            if (showingAdvancedOptions || !quantityEditText.getText().toString().trim().equals("1"))
            {
                k = 0;
            } else
            {
                k = 8;
            }
            ((LinearLayout) (obj2)).setVisibility(k);
            obj2 = durationStartTimeLayout;
            k = byte0;
            if (showingAdvancedOptions)
            {
                k = 0;
            }
            ((View) (obj2)).setVisibility(k);
            bestOfferLabel.setVisibility(0);
            bestOfferLayout.setVisibility(0);
            return;

        case 3: // '\003'
            startPriceRow.setVisibility(0);
            fixedPriceRow.setVisibility(8);
            binPriceRow.setVisibility(8);
            reservePriceRow.setVisibility(8);
            bestOfferLabel.setVisibility(8);
            bestOfferLayout.setVisibility(8);
            quantityRow.setVisibility(8);
            durationStartTimeLayout.setVisibility(8);
            return;
        }
_L5:
        if (((String) (obj)).equals("ChineseAuction"))
        {
            i = 0;
        }
          goto _L6
_L3:
        if (((String) (obj)).equals("FixedPrice"))
        {
            i = 1;
        }
          goto _L6
_L2:
        if (((String) (obj)).equals("StoresFixedPrice"))
        {
            i = 2;
        }
          goto _L6
        if (((String) (obj)).equals("ClassfiedAd"))
        {
            i = 3;
        }
          goto _L6
    }

    private void updatePriceGuidanceDisplay()
    {
        Object obj = DeviceConfiguration.getAsync();
        String s;
        boolean flag;
        boolean flag1;
        if (latestDraft.productId != null && !TextUtils.isEmpty(latestDraft.productId.getStringValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag1 = ((DeviceConfiguration) (obj)).get(DcsBoolean.SellHardGoodsPriceGuidance);
        } else
        {
            flag1 = ((DeviceConfiguration) (obj)).get(DcsBoolean.SellSoftGoodsPriceGuidance);
        }
        auctionPriceGuidance.setVisibility(8);
        fixedPriceGuidance.setVisibility(8);
        binPriceGuidance.setVisibility(8);
        s = latestDraft.format.getStringValue();
        if (s != null && flag1)
        {
            if (s.equals("FixedPrice") || s.equals("StoresFixedPrice"))
            {
                LdsField ldsfield = latestDraft.recommendedPrice;
                String s1 = latestDraft.getCurrencyCode();
                Object obj1 = "";
                obj = obj1;
                if (ldsfield != null)
                {
                    double d = ldsfield.getDoubleValue();
                    obj = obj1;
                    if (d > 0.0D)
                    {
                        obj = getString(0x7f0705eb, new Object[] {
                            EbayCurrencyUtil.formatDisplay(s1, d, 0)
                        });
                    }
                }
                obj1 = obj;
                if (latestDraft.similarListingPriceMax != null)
                {
                    obj1 = obj;
                    if (latestDraft.similarListingPriceMin != null)
                    {
                        double d1 = latestDraft.similarListingPriceMax.getDoubleValue();
                        double d6 = latestDraft.similarListingPriceMin.getDoubleValue();
                        obj1 = obj;
                        if (d1 > 0.0D)
                        {
                            obj1 = obj;
                            if (d6 > 0.0D)
                            {
                                obj1 = obj;
                                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                                {
                                    obj1 = (new StringBuilder()).append(((String) (obj))).append("\n\n").toString();
                                }
                                obj1 = (new StringBuilder()).append(((String) (obj1))).append(getString(0x7f0705ed, new Object[] {
                                    EbayCurrencyUtil.formatDisplay(s1, d6, 0), EbayCurrencyUtil.formatDisplay(s1, d1, 0)
                                })).toString();
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    fixedPriceGuidance.setText(((CharSequence) (obj1)));
                    fixedPriceGuidance.setVisibility(0);
                }
            }
            if (s.equals("ChineseAuction"))
            {
                LdsField ldsfield1 = latestDraft.recommendedPrice;
                LdsField ldsfield2 = latestDraft.recommendedStartPrice;
                String s2 = latestDraft.getCurrencyCode();
                Object obj3 = "";
                obj = "";
                Object obj2 = obj;
                if (ldsfield2 != null)
                {
                    double d2 = ldsfield2.getDoubleValue();
                    obj2 = obj;
                    if (d2 > 0.0D)
                    {
                        obj2 = getString(0x7f0705e9, new Object[] {
                            EbayCurrencyUtil.formatDisplay(s2, d2, 0)
                        });
                    }
                }
                obj = obj3;
                if (ldsfield1 != null)
                {
                    double d3 = ldsfield1.getDoubleValue();
                    obj = obj3;
                    if (d3 > 0.0D)
                    {
                        obj = getString(0x7f0705ea, new Object[] {
                            EbayCurrencyUtil.formatDisplay(s2, d3, 0)
                        });
                    }
                }
                obj3 = obj2;
                if (latestDraft.similarListingStartPriceMax != null)
                {
                    obj3 = obj2;
                    if (latestDraft.similarListingStartPriceMin != null)
                    {
                        double d4 = latestDraft.similarListingStartPriceMax.getDoubleValue();
                        double d7 = latestDraft.similarListingStartPriceMin.getDoubleValue();
                        obj3 = obj2;
                        if (d4 > 0.0D)
                        {
                            obj3 = obj2;
                            if (d7 > 0.0D)
                            {
                                obj3 = obj2;
                                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                                {
                                    obj3 = (new StringBuilder()).append(((String) (obj2))).append("\n\n").toString();
                                }
                                obj3 = (new StringBuilder()).append(((String) (obj3))).append(getString(0x7f0705ec, new Object[] {
                                    EbayCurrencyUtil.formatDisplay(s2, d7, 0), EbayCurrencyUtil.formatDisplay(s2, d4, 0)
                                })).toString();
                            }
                        }
                    }
                }
                obj2 = obj;
                if (latestDraft.similarListingPriceMax != null)
                {
                    obj2 = obj;
                    if (latestDraft.similarListingPriceMin != null)
                    {
                        double d5 = latestDraft.similarListingPriceMax.getDoubleValue();
                        double d8 = latestDraft.similarListingPriceMin.getDoubleValue();
                        obj2 = obj;
                        if (d5 > 0.0D)
                        {
                            obj2 = obj;
                            if (d8 > 0.0D)
                            {
                                obj2 = obj;
                                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                                {
                                    obj2 = (new StringBuilder()).append(((String) (obj))).append("\n\n").toString();
                                }
                                obj2 = (new StringBuilder()).append(((String) (obj2))).append(getString(0x7f0705ed, new Object[] {
                                    EbayCurrencyUtil.formatDisplay(s2, d8, 0), EbayCurrencyUtil.formatDisplay(s2, d5, 0)
                                })).toString();
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    binPriceGuidance.setText(((CharSequence) (obj2)));
                    binPriceGuidance.setVisibility(0);
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj3))))
                {
                    auctionPriceGuidance.setText(((CharSequence) (obj3)));
                    auctionPriceGuidance.setVisibility(0);
                }
            }
        }
    }

    private void updatePriceViewCurrency(String s)
    {
        startPriceView.setCurrency(s);
        binPriceView.setCurrency(s);
        fixedPriceView.setCurrency(s);
        reservePriceView.setCurrency(s);
        autoAcceptValue.setCurrency(s);
        autoDeclineValue.setCurrency(s);
        startPriceView.invalidate();
        binPriceView.invalidate();
        fixedPriceView.invalidate();
        reservePriceView.invalidate();
        autoAcceptValue.invalidate();
        autoDeclineValue.invalidate();
    }

    private void updateScheduleButtons(Date date)
    {
        Date date1 = date;
        if (date == null)
        {
            date1 = new Date();
        }
        scheduleDateButton.setText(dateFormatter.format(Long.valueOf(date1.getTime())));
        scheduleTimeButton.setText(timeFormatter.format(Long.valueOf(date1.getTime())));
    }

    private void viewUpdateBinPrice(View view, LdsField ldsfield, ArrayList arraylist)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ldsfield != null)
        {
            flag = flag1;
            if (ldsfield.isEnabled())
            {
                flag = flag1;
                if (arraylist.isEmpty())
                {
                    flag = true;
                }
            }
        }
        viewEnable(view, flag);
    }

    protected int getLayoutResource()
    {
        return 0x7f030212;
    }

    public int getTitleRes()
    {
        return 0x7f0709d8;
    }

    protected void handleValidationError(String s)
    {
        if ("Listing.BestOffer.AutodeclineAmount".equals(s))
        {
            parent.post(new Runnable() {

                final FormatPriceSpokeFragment this$0;

                public void run()
                {
                    parent.scrollTo(0, bestOfferLayout.getBottom());
                }

            
            {
                this$0 = FormatPriceSpokeFragment.this;
                super();
            }
            });
        } else
        if ("Listing.StartDateDay".equals(s))
        {
            parent.post(new Runnable() {

                final FormatPriceSpokeFragment this$0;

                public void run()
                {
                    parent.scrollTo(0, scheduleButtonsLayout.getBottom() + scheduleButtonsLayout.getHeight());
                }

            
            {
                this$0 = FormatPriceSpokeFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void onChange(int i, Object obj)
    {
        boolean flag;
        switch (i)
        {
        default:
            return;

        case 2131756722: 
            obj = ((LdsOption)obj).value;
            dm.updateCurrency(((String) (obj)));
            return;

        case 2131756736: 
            obj = (LdsOption)obj;
            dm.updateDuration(((LdsOption) (obj)).value);
            return;

        case 2131756737: 
            flag = obj.equals(getResources().getStringArray(0x7f0e0019)[1]);
            break;
        }
        dm.updateIsScheduled(flag);
    }

    public void onClick(View view)
    {
        Util.hideSoftInput(view.getContext(), view);
        view.getId();
        JVM INSTR lookupswitch 6: default 72
    //                   2131756712: 80
    //                   2131756716: 108
    //                   2131756739: 174
    //                   2131756740: 247
    //                   2131756746: 146
    //                   2131756805: 310;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        if (view.getTag() != null) goto _L9; else goto _L8
_L8:
        return;
_L2:
        guaranteeCheckBox.toggle();
        boolean flag = guaranteeCheckBox.isChecked();
        dm.updateGuarantee(flag);
        continue; /* Loop/switch isn't completed */
_L3:
        Activity activity = getActivity();
        if (activity != null)
        {
            (new TrackingData("SelectMyOwnFP", TrackingType.EVENT)).send(activity);
        }
        hasUserClickedDoItMyself = true;
        updateInputFieldVisibility();
        continue; /* Loop/switch isn't completed */
_L6:
        bestOffer.toggle();
        boolean flag1 = bestOffer.isChecked();
        dm.updateBestOffer(flag1);
        continue; /* Loop/switch isn't completed */
_L4:
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestDraft.getStartDateValue());
        int i = calendar.get(1);
        int i1 = calendar.get(2);
        int k1 = calendar.get(5);
        (new com.ebay.app.DatePickerDialogFragment.Builder()).setYear(i).setMonth(i1).setDay(k1).createFromFragment(1, this).show(getFragmentManager(), "dateDialog");
        continue; /* Loop/switch isn't completed */
_L5:
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(latestDraft.getStartDateValue());
        int j = calendar1.get(11);
        int j1 = calendar1.get(12);
        (new com.ebay.app.TimePickerDialogFragment.Builder()).setHour(j).setMinute(j1).createFromFragment(2, this).show(getFragmentManager(), "timeDialog");
        continue; /* Loop/switch isn't completed */
_L7:
        Object obj;
        int k;
        boolean flag2;
        if (!showingAdvancedOptions)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        showingAdvancedOptions = flag2;
        obj = moreOptionsArrow;
        if (showingAdvancedOptions)
        {
            k = 0x7f020256;
        } else
        {
            k = 0x7f020252;
        }
        ((ImageView) (obj)).setImageResource(k);
        obj = moreOptionsText;
        if (showingAdvancedOptions)
        {
            k = 0x7f0705c1;
        } else
        {
            k = 0x7f0705c2;
        }
        ((TextView) (obj)).setText(k);
        updateInputFieldVisibility();
        continue; /* Loop/switch isn't completed */
_L9:
        int l;
        l = ((Integer)view.getTag()).intValue();
        view = (CheckedTextView)view.findViewById(0x1020014);
        if (l == lastFormatPosition) goto _L8; else goto _L10
_L10:
        View view1 = getView();
        if (lastFormatPosition != -1 && view1 != null)
        {
            ((CheckedTextView)view1.findViewWithTag(Integer.valueOf(lastFormatPosition)).findViewById(0x1020014)).setChecked(false);
        }
        lastFormatPosition = l;
        view.setChecked(true);
        view = (LdsOption)latestDraft.format.options.get(l);
        dm.updateFormat(((LdsOption) (view)).value, getTextFields());
        return;
        if (true) goto _L1; else goto _L11
_L11:
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        }
        if (listingdraftdatamanager != null)
        {
            listingdraftdatamanager.canOverrideFormatWithRecommendation = false;
        }
        if (latestDraft == null)
        {
            progress.setVisibility(8);
            parent.setVisibility(0);
        }
        dispatchtype = latestDraft;
        latestDraft = (ListingDraft)listingdraftcontent.getData();
        dm = listingdraftdatamanager;
        updateInputFieldEnabledState();
        boolean flag = false;
        if (dispatchtype == null || !((ListingDraft) (dispatchtype)).format.getStringValue().equals(latestDraft.format.getStringValue()) || listingdraftcontent.isGuaranteeSelectedThisSession != isGuaranteeSelectedThisSession)
        {
            flag = true;
        }
        isGuaranteeAvailable = latestDraft.isGuaranteeAvailable();
        isGuaranteeSelectedThisSession = listingdraftcontent.isGuaranteeSelectedThisSession;
        if (flag)
        {
            initializeInputFieldValues();
        } else
        {
            updateInputFieldValuesForDisabled();
        }
        updateInputFieldVisibility();
        buildFormatList();
        updatePriceViewCurrency(latestDraft.getCurrencyCode());
        if (latestDraft.startDate != null)
        {
            listingdraftdatamanager = latestDraft.startDate.getDateValue();
            updateScheduleButtons(listingdraftdatamanager);
            updateEndDate(listingdraftdatamanager, latestDraft.duration.getStringValue());
        }
        updateFormatGuidanceDisplay();
        updatePriceGuidanceDisplay();
        updateGuaranteeText();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        keyParams = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        initDataManagers();
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        datepicker = Calendar.getInstance();
        datepicker.setTime(latestDraft.getStartDateValue());
        datepicker.set(1, i);
        datepicker.set(2, j);
        datepicker.set(5, k);
        datepicker.set(14, 0);
        datepicker.set(13, 0);
        datepicker = datepicker.getTime();
        dm.updateScheduledStartDate(datepicker);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)getDataManagerContainer().initialize(keyParams, this);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingItemFormatAndPrice");
        if (latestDraft == null)
        {
            DialogFragment dialogfragment = (DialogFragment)getFragmentManager().findFragmentByTag("timeDialog");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
            dialogfragment = (DialogFragment)getFragmentManager().findFragmentByTag("dateDialog");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
        }
    }

    public void onStop()
    {
        super.onStop();
        sendPriceRecommendationTracking();
    }

    public void onTimeSet(TimePicker timepicker, int i, int j)
    {
        timepicker = Calendar.getInstance();
        timepicker.setTime(latestDraft.getStartDateValue());
        timepicker.set(11, i);
        timepicker.set(12, j);
        timepicker.set(14, 0);
        timepicker.set(13, 0);
        timepicker = timepicker.getTime();
        dm.updateScheduledStartDate(timepicker);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        inflater = (LayoutInflater)view.getContext().getSystemService("layout_inflater");
        ((TextView)view.findViewById(0x7f1006d1)).setText(Html.fromHtml(view.getContext().getString(0x7f0709bd)));
        ((TextView)view.findViewById(0x7f1006d2)).setText(Html.fromHtml(view.getContext().getString(0x7f0709be)));
        ((TextView)view.findViewById(0x7f1006d3)).setText(Html.fromHtml(view.getContext().getString(0x7f0709c4)));
        ((TextView)view.findViewById(0x7f1006d4)).setText(Html.fromHtml(view.getContext().getString(0x7f0709bf)));
        ((TextView)view.findViewById(0x7f1006d5)).setText(Html.fromHtml(view.getContext().getString(0x7f0709c5)));
        ((TextView)view.findViewById(0x7f1006d6)).setText(Html.fromHtml(view.getContext().getString(0x7f0709c8)));
        progress = view.findViewById(0x7f100143);
        parent = (CustomScrollView)view.findViewById(0x7f1004bc);
        guaranteeHeading = (TextView)view.findViewById(0x7f1006a9);
        guaranteeLayout = view.findViewById(0x7f1006a8);
        guaranteeCheckBox = (CheckedTextView)view.findViewById(0x7f1006aa);
        guaranteeSubtext = (TextView)view.findViewById(0x7f100631);
        guaranteeSimilarItems = (TextView)view.findViewById(0x7f1006ab);
        guaranteeLayout.setOnClickListener(this);
        doItMyselfButton = view.findViewById(0x7f1006ac);
        doItMyselfButton.setOnClickListener(this);
        doItMyselfLayout = view.findViewById(0x7f1006ad);
        helpLayout = view.findViewById(0x7f1004bd);
        formatList = (ContainerLayout)view.findViewById(0x7f1006ae);
        startPriceRow = (LinearLayout)view.findViewById(0x7f1006b3);
        fixedPriceRow = (LinearLayout)view.findViewById(0x7f1006b6);
        binPriceRow = (LinearLayout)view.findViewById(0x7f1006b9);
        reservePriceRow = (LinearLayout)view.findViewById(0x7f1006bc);
        quantityRow = (LinearLayout)view.findViewById(0x7f1006be);
        fixedPriceGuidance = (TextView)view.findViewById(0x7f1006b8);
        binPriceGuidance = (TextView)view.findViewById(0x7f1006bb);
        auctionPriceGuidance = (TextView)view.findViewById(0x7f1006b5);
        startPriceView = (PriceView)view.findViewById(0x7f1006b4);
        binPriceView = (PriceView)view.findViewById(0x7f1006ba);
        fixedPriceView = (PriceView)view.findViewById(0x7f1006b7);
        reservePriceView = (PriceView)view.findViewById(0x7f1006bd);
        quantityEditText = (EditText)view.findViewById(0x7f100496);
        currencySpinner = (EbaySpinner)view.findViewById(0x7f1006b2);
        currencyAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        currencyAdapter.setDropDownViewResource(0x1090009);
        currencySpinner.setAdapter(currencyAdapter);
        currencySpinner.setChangeListener(this);
        currencyParent = view.findViewById(0x7f1006b0);
        bestOfferLabel = view.findViewById(0x7f1006c7);
        bestOfferLayout = (LinearLayout)view.findViewById(0x7f1006c8);
        bestOffer = (CheckedTextView)view.findViewById(0x7f1006ca);
        autoAccept = (TextView)view.findViewById(0x7f1006cc);
        autoAcceptLayout = view.findViewById(0x7f1006cb);
        autoAcceptValue = (PriceView)view.findViewById(0x7f1006cd);
        autoAcceptValue.setShowHintTextForZero(true);
        autoDecline = (TextView)view.findViewById(0x7f1006cf);
        autoDeclineLayout = view.findViewById(0x7f1006ce);
        autoDeclineValue = (PriceView)view.findViewById(0x7f1006d0);
        autoDeclineValue.setShowHintTextForZero(true);
        durationStartTimeLayout = view.findViewById(0x7f1006bf);
        scheduleSpinner = (EbaySpinner)view.findViewById(0x7f1006c1);
        bundle = ArrayAdapter.createFromResource(view.getContext(), 0x7f0e0019, 0x7f030223);
        bundle.setDropDownViewResource(0x1090009);
        scheduleSpinner.setAdapter(bundle);
        scheduleSpinner.setChangeListener(this);
        scheduleButtonsLayout = view.findViewById(0x7f1006c2);
        scheduleDateButton = (Button)view.findViewById(0x7f1006c3);
        scheduleDateButton.setOnClickListener(this);
        scheduleTimeButton = (Button)view.findViewById(0x7f1006c4);
        scheduleTimeButton.setOnClickListener(this);
        endDate = (TextView)view.findViewById(0x7f1006c6);
        durationSpinner = (EbaySpinner)view.findViewById(0x7f1006c0);
        durationAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        durationAdapter.setDropDownViewResource(0x1090009);
        durationSpinner.setAdapter(durationAdapter);
        durationSpinner.setChangeListener(this);
        view.findViewById(0x7f100705).setOnClickListener(this);
        moreOptionsArrow = (ImageView)view.findViewById(0x7f100707);
        moreOptionsText = (TextView)view.findViewById(0x7f100706);
        dateFormatter = android.text.format.DateFormat.getDateFormat(view.getContext());
        timeFormatter = android.text.format.DateFormat.getTimeFormat(view.getContext());
        bestOffer.setOnClickListener(this);
        parent.setVisibility(8);
        progress.setVisibility(0);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (flag && isGuaranteeSelectedThisSession)
        {
            dm.validateDraft();
        } else
        if (!isGuaranteeSelectedThisSession)
        {
            dm.updateFormatPriceTextFields(getTextFields(), flag);
            return;
        }
    }
}
