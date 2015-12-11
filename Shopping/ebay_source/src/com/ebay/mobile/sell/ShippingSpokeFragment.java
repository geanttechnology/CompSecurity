// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ShippingDetailsDataManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, EditShippingServiceDialogFragment, PackageDetailsDialogFragment, ListingFragmentActivity

public class ShippingSpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged, EditShippingServiceDialogFragment.ShippingServiceDialogHandler, PackageDetailsDialogFragment.PackageDetailsCallback, com.ebay.mobile.viewitem.ShippingDetailsDataManager.Observer, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    private static final int DIALOG_REQUEST_CODE_PACKAGE_DETAILS = 101;
    private static final int DIALOG_REQUEST_CODE_SHIPPING = 102;
    private View addAdditionalDomesticShippingServices;
    private View addFirstShippingService;
    private View addInternationalShippingServices;
    private ListingDraftDataManager dm;
    private LinearLayout domesticService1;
    private LinearLayout domesticService2;
    private LinearLayout domesticService3;
    private LinearLayout domesticService4;
    private EbaySpinner domesticType;
    private ArrayAdapter domesticTypeAdapter;
    private View domesticTypeRow;
    private CheckedTextView freeShippingCheck;
    private CheckedTextView gspCheckedTextView;
    private View gspHelp;
    private View gspHelpTitle;
    private View gspLayout;
    private LayoutInflater inflater;
    private LinearLayout intlService1;
    private LinearLayout intlService2;
    private LinearLayout intlService3;
    private LinearLayout intlService4;
    private LinearLayout intlService5;
    private EbaySpinner intlType;
    private ArrayAdapter intlTypeAdapter;
    private View intlTypeRow;
    private ListingDraft latestDraft;
    private CheckedTextView localPickupCheckedTextView;
    private SpannableString localPickupDisabledText;
    private SpannableString localPickupEnabledText;
    private View localPickupLayout;
    private int maxDomesticShippingServices;
    private View packageDetails;
    private Button packageInfoDisplay;
    private View parent;
    private View progress;
    private final Set selectedServices = new HashSet();
    private Map serviceNameToServiceDetailsMap;
    public ArrayList shippingEstimates;
    public ShippingRecommendation shippingRecommendation;
    private View showMoreDomesticOptions;
    private View showMoreInternationalOptions;
    private boolean showingAdvancedDomesticOptions;
    private boolean showingAdvancedInternationalOptions;
    private ColorStateList textColorPrimary;
    private ColorStateList textColorSecondary;

    public ShippingSpokeFragment()
    {
        maxDomesticShippingServices = 4;
        showingAdvancedDomesticOptions = false;
        showingAdvancedInternationalOptions = false;
    }

    private void displayServiceName(String s, TextView textview)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            textview.setText(s);
            return;
        }
    }

    private boolean enableTypeSpinner(LdsField ldsfield)
    {
        boolean flag4;
label0:
        {
            boolean flag5 = false;
            String s = ldsfield.getStringValue();
            flag4 = flag5;
            if (!ldsfield.isEnabled())
            {
                break label0;
            }
            if (!s.equals("FLAT_RATE") && !s.equals("NOT_SPECIFIED"))
            {
                flag4 = flag5;
                if (!s.equals("ACTUAL_RATE"))
                {
                    break label0;
                }
            }
            ldsfield = ldsfield.options;
            boolean flag2 = false;
            boolean flag1 = false;
            boolean flag3 = false;
            boolean flag = false;
            if (ldsfield != null)
            {
                ldsfield = ldsfield.iterator();
label1:
                do
                {
                    LdsOption ldsoption;
label2:
                    {
                        flag2 = flag1;
                        flag3 = flag;
                        if (!ldsfield.hasNext())
                        {
                            break label1;
                        }
                        ldsoption = (LdsOption)ldsfield.next();
                        if (!ldsoption.value.equals("FLAT_RATE"))
                        {
                            flag2 = flag1;
                            if (!ldsoption.value.equals("ACTUAL_RATE"))
                            {
                                break label2;
                            }
                        }
                        flag2 = true;
                    }
                    flag1 = flag2;
                    if (ldsoption.value.equals("NOT_SPECIFIED"))
                    {
                        flag = true;
                        flag1 = flag2;
                    }
                } while (true);
            }
            flag4 = flag5;
            if (flag2)
            {
                flag4 = flag5;
                if (flag3)
                {
                    flag4 = true;
                }
            }
        }
        return flag4;
    }

    private int getAvailableInternationalServiceCount()
    {
        int j = 0;
        if (!"DISABLE".equals(latestDraft.intlShippingService1.getBmode()))
        {
            j = 0 + 1;
        }
        int i = j;
        if (!"DISABLE".equals(latestDraft.intlShippingService2.getBmode()))
        {
            i = j + 1;
        }
        j = i;
        if (!"DISABLE".equals(latestDraft.intlShippingService3.getBmode()))
        {
            j = i + 1;
        }
        i = j;
        if (!"DISABLE".equals(latestDraft.intlShippingService4.getBmode()))
        {
            i = j + 1;
        }
        j = i;
        if (!"DISABLE".equals(latestDraft.intlShippingService5.getBmode()))
        {
            j = i + 1;
        }
        return j;
    }

    private int getGuessedSpinnerHeight()
    {
        int j = showMoreDomesticOptions.getHeight();
        if (domesticService1.getChildCount() > 0)
        {
            View view = domesticService1.findViewById(0x7f1000ec);
            if (view != null)
            {
                return view.getHeight() + j;
            }
        }
        View view1 = getView().findViewById(0x7f1006df);
        int i = j;
        if (view1 != null)
        {
            i = j + view1.getHeight();
        }
        return i;
    }

    private static String getPackageInfoDisplay(ListingDraft listingdraft)
    {
        String s1 = "";
        if (listingdraft.packageType.getSelectedCaption() != null)
        {
            s1 = (new StringBuilder()).append("").append(listingdraft.packageType.getSelectedCaption()).toString();
        }
        String s = s1;
        if (!TextUtils.isEmpty(s1))
        {
            s = (new StringBuilder()).append(s1).append(", ").toString();
        }
        s1 = s;
        if (listingdraft.packageWeightEstimated.getSelectedCaption() != null)
        {
            s1 = (new StringBuilder()).append(s).append(listingdraft.packageWeightEstimated.getSelectedCaption()).toString();
        }
        s = s1;
        if (listingdraft.packageDepth != null)
        {
            s = s1;
            if (listingdraft.packageDepth.getStringValue() != null)
            {
                s = (new StringBuilder()).append(s1).append(", ").append((int)listingdraft.packageDepth.getDoubleValue()).toString();
            }
        }
        s1 = s;
        if (listingdraft.packageWidth != null)
        {
            s1 = s;
            if (listingdraft.packageWidth.getStringValue() != null)
            {
                s1 = (new StringBuilder()).append(s).append("x").append((int)listingdraft.packageWidth.getDoubleValue()).toString();
            }
        }
        s = s1;
        if (listingdraft.packageLength != null)
        {
            s = s1;
            if (listingdraft.packageLength.getStringValue() != null)
            {
                s = (new StringBuilder()).append(s1).append("x").append((int)listingdraft.packageLength.getDoubleValue()).toString();
            }
        }
        s1 = s;
        if (listingdraft.packageUnitOfMeasure != null)
        {
            s1 = s;
            if (listingdraft.packageUnitOfMeasure.getStringValue() != null)
            {
                if ("IMPERIAL".equals(listingdraft.packageUnitOfMeasure.getStringValue()))
                {
                    listingdraft = "inches";
                } else
                {
                    listingdraft = "cm";
                }
                s1 = (new StringBuilder()).append(s).append(" ").append(listingdraft).toString();
            }
        }
        return s1;
    }

    private void inflateIntlShippingService(LinearLayout linearlayout, String s, String s1, Double double1, ArrayList arraylist)
    {
label0:
        {
            View view = inflater.inflate(0x7f030206, linearlayout, false);
            linearlayout.addView(view);
            linearlayout = (TextView)view.findViewById(0x7f1000ed);
            if (s.equals("FLAT_RATE") && double1.doubleValue() == 0.0D)
            {
                s = getString(0x7f0705ae);
                ((TextView)view.findViewById(0x7f100644)).setText(s);
                linearlayout.setVisibility(8);
            } else
            if (s.equals("FLAT_RATE"))
            {
                s = latestDraft.getCurrencyCode();
                linearlayout.setText(EbayCurrencyUtil.formatDisplay(new CurrencyAmount(double1.doubleValue(), s), 0));
                linearlayout = getString(0x7f07052c);
                ((TextView)view.findViewById(0x7f100644)).setText(linearlayout);
            } else
            {
                linearlayout.setText(getString(0x7f0705cb).trim());
                linearlayout = getString(0x7f07052c);
                ((TextView)view.findViewById(0x7f100644)).setText(linearlayout);
            }
            displayServiceName(s1, (TextView)view.findViewById(0x7f100653));
            if (arraylist != null)
            {
                linearlayout = (TextView)view.findViewById(0x7f100654);
                linearlayout.setSingleLine(false);
                linearlayout.setPadding(0, (int)TypedValue.applyDimension(1, 4F, view.getContext().getResources().getDisplayMetrics()), 0, 0);
                if (!arraylist.isEmpty())
                {
                    break label0;
                }
                linearlayout.setText(0x7f0705bb);
            }
            return;
        }
        linearlayout.setText(TextUtils.join(", ", arraylist));
    }

    private void inflateShippingServiceCalc(LinearLayout linearlayout, LdsField ldsfield, boolean flag)
    {
        View view;
        TextView textview;
label0:
        {
            if (TextUtils.isEmpty(ldsfield.getSelectedCaption()))
            {
                return;
            }
            view = inflater.inflate(0x7f0301ff, linearlayout, false);
            linearlayout.addView(view);
            linearlayout = getString(0x7f07052c);
            if (flag)
            {
                linearlayout = getString(0x7f0705ae);
            }
            ((TextView)view.findViewById(0x7f100644)).setText(linearlayout);
            textview = (TextView)view.findViewById(0x7f1000ed);
            String s = "";
            linearlayout = s;
            if (shippingEstimates == null)
            {
                break label0;
            }
            Iterator iterator = shippingEstimates.iterator();
            do
            {
                linearlayout = s;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                linearlayout = (ShippingEstimate)iterator.next();
            } while (!((ShippingEstimate) (linearlayout)).shippingService.serviceId.equals(ldsfield.getStringValue()));
            linearlayout = linearlayout.getValueDisplay(latestDraft.getCurrencyCode());
        }
        textview.setTypeface(Typeface.DEFAULT);
        textview.setText((new StringBuilder()).append(linearlayout).append(getString(0x7f0705cb)).toString().trim());
        linearlayout = (TextView)view.findViewById(0x7f100643);
        displayServiceName(ldsfield.getSelectedCaption(), linearlayout);
    }

    private void inflateShippingServiceFlat(LinearLayout linearlayout, String s, LdsField ldsfield, boolean flag)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        View view = inflater.inflate(0x7f0301ff, linearlayout, false);
        linearlayout.addView(view);
        linearlayout = (TextView)view.findViewById(0x7f1000ed);
        if (flag || ldsfield.getDoubleValue() == 0.0D)
        {
            ldsfield = getString(0x7f0705ae);
            ((TextView)view.findViewById(0x7f100644)).setText(ldsfield);
            linearlayout.setVisibility(8);
        } else
        {
            String s1 = getString(0x7f07052c);
            ((TextView)view.findViewById(0x7f100644)).setText(s1);
            s1 = latestDraft.getCurrencyCode();
            linearlayout.setText(EbayCurrencyUtil.formatDisplay(new CurrencyAmount(ldsfield.getStringValue(), s1), 0));
            linearlayout.setVisibility(0);
        }
        displayServiceName(s, (TextView)view.findViewById(0x7f100643));
    }

    private void loadShippingServiceInfo()
    {
        boolean flag = true;
        int i;
        int j;
        boolean flag1;
        if (latestDraft.shippingFree != null && latestDraft.shippingFree.getBooleanValue())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (latestDraft.shippingService1.isEnabled())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        maxDomesticShippingServices = i;
        j = maxDomesticShippingServices;
        if (latestDraft.shippingService2.isEnabled())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        maxDomesticShippingServices = i + j;
        j = maxDomesticShippingServices;
        if (latestDraft.shippingService3.isEnabled())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        maxDomesticShippingServices = i + j;
        j = maxDomesticShippingServices;
        if (latestDraft.shippingService4.isEnabled())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        maxDomesticShippingServices = i + j;
        updateDomesticShippingCell(domesticService1, latestDraft.shippingService1, latestDraft.shippingService1fee, latestDraft.shippingType, flag1);
        updateExtraDomesticServiceUI(flag1);
        updateDomesticShippingCell(domesticService2, latestDraft.shippingService2, latestDraft.shippingService2fee, latestDraft.shippingType, false);
        updateDomesticShippingCell(domesticService3, latestDraft.shippingService3, latestDraft.shippingService3fee, latestDraft.shippingType, false);
        updateDomesticShippingCell(domesticService4, latestDraft.shippingService4, latestDraft.shippingService4fee, latestDraft.shippingType, false);
        updateIntlShippingCell(intlService1, latestDraft.intlShippingService1, latestDraft.intlShippingFee1, latestDraft.intlShippingType, latestDraft.intlShipToRegion1, latestDraft.intlShipToLocation1);
        updateIntlShippingCell(intlService2, latestDraft.intlShippingService2, latestDraft.intlShippingFee2, latestDraft.intlShippingType, latestDraft.intlShipToRegion2, latestDraft.intlShipToLocation2);
        updateIntlShippingCell(intlService3, latestDraft.intlShippingService3, latestDraft.intlShippingFee3, latestDraft.intlShippingType, latestDraft.intlShipToRegion3, latestDraft.intlShipToLocation3);
        updateIntlShippingCell(intlService4, latestDraft.intlShippingService4, latestDraft.intlShippingFee4, latestDraft.intlShippingType, latestDraft.intlShipToRegion4, latestDraft.intlShipToLocation4);
        updateIntlShippingCell(intlService5, latestDraft.intlShippingService5, latestDraft.intlShippingFee5, latestDraft.intlShippingType, latestDraft.intlShipToRegion5, latestDraft.intlShipToLocation5);
    }

    private static ArrayList locationsList(LdsField ldsfield, LdsField ldsfield1)
    {
        ArrayList arraylist = new ArrayList();
        if (ldsfield.hasSelection() && ldsfield.getStringValue().equals("Worldwide"))
        {
            arraylist.add(LdsField.getCaptionInt(ldsfield1, 1));
            return arraylist;
        }
        if (!ldsfield.hasSelection() && ldsfield1.hasSelection())
        {
            arraylist.add(LdsField.getCaptionInt(ldsfield1, ldsfield1.getIntValue()));
            return arraylist;
        } else
        {
            arraylist.addAll(ldsfield.getSelectedCaptions());
            return arraylist;
        }
    }

    private void onClickAddDomesticShippingMethod()
    {
        if (!ListingDraft.serviceIsSelected(latestDraft.shippingService1) && latestDraft.shippingService1.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig.setNewService(true).setInternational(false).setService(latestDraft.shippingService1).setFee(latestDraft.shippingService1fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(localPickupCheckedTextView.isChecked()).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig).show(getFragmentManager(), "shippingService1");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.shippingService2) && latestDraft.shippingService2.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig1 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig1.setNewService(true).setInternational(false).setService(latestDraft.shippingService2).setFee(latestDraft.shippingService2fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig1).show(getFragmentManager(), "shippingService2");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.shippingService3) && latestDraft.shippingService3.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig2 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig2.setNewService(true).setInternational(false).setService(latestDraft.shippingService3).setFee(latestDraft.shippingService3fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig2).show(getFragmentManager(), "shippingService3");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.shippingService4) && latestDraft.shippingService4.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig3 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig3.setNewService(true).setInternational(false).setService(latestDraft.shippingService4).setFee(latestDraft.shippingService4fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig3).show(getFragmentManager(), "shippingService4");
            return;
        } else
        {
            addFirstShippingService.setVisibility(8);
            return;
        }
    }

    private void onClickAddInternationalShippingMethod()
    {
        if (!ListingDraft.serviceIsSelected(latestDraft.intlShippingService1) && latestDraft.intlShippingService1.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig.setNewService(true).setInternational(true).setService(latestDraft.intlShippingService1).setFee(latestDraft.intlShippingFee1).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion1).setLocation(latestDraft.intlShipToLocation1).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig).show(getFragmentManager(), "intlShippingService1");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.intlShippingService2) && latestDraft.intlShippingService2.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig1 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig1.setNewService(true).setInternational(true).setService(latestDraft.intlShippingService2).setFee(latestDraft.intlShippingFee2).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion2).setLocation(latestDraft.intlShipToLocation2).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig1).show(getFragmentManager(), "intlShippingService2");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.intlShippingService3) && latestDraft.intlShippingService3.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig2 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig2.setNewService(true).setInternational(true).setService(latestDraft.intlShippingService3).setFee(latestDraft.intlShippingFee3).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion3).setLocation(latestDraft.intlShipToLocation3).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig2).show(getFragmentManager(), "intlShippingService3");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.intlShippingService4) && latestDraft.intlShippingService4.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig3 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig3.setNewService(true).setInternational(true).setService(latestDraft.intlShippingService4).setFee(latestDraft.intlShippingFee4).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion4).setLocation(latestDraft.intlShipToLocation4).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig3).show(getFragmentManager(), "intlShippingService4");
            return;
        }
        if (!ListingDraft.serviceIsSelected(latestDraft.intlShippingService5) && latestDraft.intlShippingService5.isEnabled())
        {
            EditShippingServiceDialogFragment.EditShippingDialogConfig editshippingdialogconfig4 = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
            editshippingdialogconfig4.setNewService(true).setInternational(true).setService(latestDraft.intlShippingService5).setFee(latestDraft.intlShippingFee5).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion5).setLocation(latestDraft.intlShipToLocation5).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
            EditShippingServiceDialogFragment.createInstance(this, 102, editshippingdialogconfig4).show(getFragmentManager(), "intlShippingService5");
            return;
        } else
        {
            addAdditionalDomesticShippingServices.setVisibility(8);
            return;
        }
    }

    private boolean serviceIsFreeLocalPickup(LdsField ldsfield, LdsField ldsfield1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (serviceIsLocalPickup(ldsfield))
        {
            flag = flag1;
            if (ldsfield1 != null)
            {
                flag = flag1;
                if (ldsfield1.hasSelection())
                {
                    flag = flag1;
                    if (Math.abs(ldsfield1.getDoubleValue()) < 9.9999999999999995E-07D)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    private boolean serviceIsLocalPickup(LdsField ldsfield)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ldsfield != null)
        {
            flag = flag1;
            if (ldsfield.hasSelection())
            {
                String s = ldsfield.getStringValue();
                flag = flag1;
                if (s != null)
                {
                    flag = flag1;
                    if (s.contains(LdsField.getLocalPickupString(latestDraft.siteId, ldsfield.options)))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    private void updateAddDomesticServicesUI()
    {
        if (latestDraft != null && latestDraft.shippingService1 != null) goto _L2; else goto _L1
_L1:
        addFirstShippingService.setVisibility(8);
        addAdditionalDomesticShippingServices.setVisibility(8);
        localPickupLayout.setEnabled(false);
        if (!localPickupCheckedTextView.isChecked()) goto _L4; else goto _L3
_L3:
        localPickupLayout.setVisibility(0);
_L6:
        return;
_L4:
        localPickupLayout.setVisibility(8);
        return;
_L2:
        int i = latestDraft.getDomesticShippingCount();
        if (i >= maxDomesticShippingServices)
        {
            addFirstShippingService.setVisibility(8);
            addAdditionalDomesticShippingServices.setVisibility(8);
            if (localPickupCheckedTextView.isChecked())
            {
                localPickupLayout.setVisibility(0);
                return;
            } else
            {
                localPickupLayout.setVisibility(8);
                return;
            }
        }
        if (i > 0)
        {
            addFirstShippingService.setVisibility(8);
            addAdditionalDomesticShippingServices.setVisibility(0);
            localPickupLayout.setVisibility(0);
            showOrHideView(domesticTypeRow, showingAdvancedDomesticOptions, -2, false);
            return;
        }
        if (i == 0)
        {
            addFirstShippingService.setVisibility(0);
            addAdditionalDomesticShippingServices.setVisibility(8);
            showMoreDomesticOptions.setVisibility(8);
            showMoreInternationalOptions.setVisibility(8);
            localPickupLayout.setVisibility(0);
            showOrHideView(domesticTypeRow, true, -2, false);
            showOrHideView(localPickupLayout, true, -2, false);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void updateAddInternationalServicesUI()
    {
        int i = latestDraft.getIntlShippingCount();
        int j = latestDraft.getDomesticShippingCount();
        if (j == 0 || latestDraft.siteId == 207 || latestDraft.siteId == 211 || latestDraft.siteId == 216)
        {
            intlTypeRow.setVisibility(8);
            addInternationalShippingServices.setVisibility(8);
            showMoreInternationalOptions.setVisibility(8);
            return;
        }
        int k = getAvailableInternationalServiceCount();
        if (j > 0 && i < k)
        {
            addInternationalShippingServices.setVisibility(0);
        } else
        {
            addInternationalShippingServices.setVisibility(8);
        }
        showMoreInternationalOptions.setVisibility(0);
        intlTypeRow.setVisibility(0);
    }

    private void updateDomesticShippingCell(LinearLayout linearlayout, LdsField ldsfield, LdsField ldsfield1, LdsField ldsfield2, boolean flag)
    {
        linearlayout.removeAllViews();
        if (!ListingDraft.serviceIsSelected(ldsfield) || "DISABLE".equals(ldsfield.getBmode())) goto _L2; else goto _L1
_L1:
        linearlayout.setVisibility(0);
        if (ldsfield2 == null) goto _L4; else goto _L3
_L3:
        ldsfield2 = ldsfield2.getStringValue();
        if (!ldsfield2.equals("ACTUAL_RATE")) goto _L6; else goto _L5
_L5:
        inflateShippingServiceCalc(linearlayout, ldsfield, flag);
_L4:
        selectedServices.add(ldsfield.getStringValue());
_L8:
        return;
_L2:
        linearlayout.setVisibility(8);
        return;
_L6:
        if (!ldsfield2.equals("FLAT_RATE") || ldsfield1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (serviceIsFreeLocalPickup(ldsfield, ldsfield1)) goto _L8; else goto _L7
_L7:
        inflateShippingServiceFlat(linearlayout, ldsfield.getSelectedCaption(), ldsfield1, flag);
        if (true) goto _L4; else goto _L9
_L9:
    }

    private void updateExtraDomesticServiceUI(boolean flag)
    {
        if (domesticService1.getChildCount() > 0)
        {
            View view = domesticService1.findViewById(0x7f100645);
            freeShippingCheck = (CheckedTextView)domesticService1.findViewById(0x7f100646);
            freeShippingCheck.setOnClickListener(this);
            if (latestDraft.shippingService1 != null)
            {
                if (view != null)
                {
                    byte byte0;
                    if (shippingRecommendation == null)
                    {
                        byte0 = 8;
                    } else
                    {
                        byte0 = 0;
                    }
                    view.setVisibility(byte0);
                }
                freeShippingCheck.setChecked(flag);
                freeShippingCheck.setVisibility(0);
            }
        }
    }

    private void updateIntlShippingCell(LinearLayout linearlayout, LdsField ldsfield, LdsField ldsfield1, LdsField ldsfield2, LdsField ldsfield3, LdsField ldsfield4)
    {
        linearlayout.removeAllViews();
        if (ListingDraft.serviceIsSelected(ldsfield) && !"DISABLE".equals(ldsfield.getBmode()))
        {
            linearlayout.setVisibility(0);
            if (ldsfield2 != null && ldsfield1 != null)
            {
                inflateIntlShippingService(linearlayout, ldsfield2.getStringValue(), ldsfield.getSelectedCaption(), Double.valueOf(ldsfield1.getDoubleValue()), locationsList(ldsfield4, ldsfield3));
            }
            selectedServices.add(ldsfield.getStringValue());
            return;
        } else
        {
            linearlayout.setVisibility(8);
            return;
        }
    }

    private void updateLocalPickupDisplay()
    {
        updateCheckedTextValue(localPickupCheckedTextView, latestDraft.localPickup);
        if (localPickupCheckedTextView.isChecked() || latestDraft.siteId == 77)
        {
            showOrHideView(localPickupLayout, true, -2, false);
        }
        if (localPickupCheckedTextView.isEnabled())
        {
            localPickupCheckedTextView.setText(localPickupEnabledText, android.widget.TextView.BufferType.SPANNABLE);
            localPickupCheckedTextView.setTextColor(textColorPrimary);
            return;
        } else
        {
            localPickupCheckedTextView.setText(localPickupDisabledText, android.widget.TextView.BufferType.SPANNABLE);
            localPickupCheckedTextView.setTextColor(textColorSecondary);
            return;
        }
    }

    private void updateShippingType(LdsField ldsfield, EbaySpinner ebayspinner, ArrayAdapter arrayadapter)
    {
label0:
        {
            boolean flag = enableTypeSpinner(ldsfield);
            ebayspinner.setEnabled(flag);
            Object obj = ldsfield.options;
            ArrayList arraylist = new ArrayList();
            arrayadapter.clear();
            if (obj != null)
            {
                Iterator iterator = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    LdsOption ldsoption = (LdsOption)iterator.next();
                    if (!flag || ldsoption.value.equals("FLAT_RATE") || ldsoption.value.equals("NOT_SPECIFIED") || ldsoption.value.equals("ACTUAL_RATE"))
                    {
                        arrayadapter.add(ldsoption);
                        arraylist.add(ldsoption);
                    }
                } while (true);
            }
            ebayspinner.setAdapter(arrayadapter);
            ldsfield = ldsfield.getStringValue();
            if (obj == null)
            {
                break label0;
            }
            arrayadapter = ((ArrayList) (obj)).iterator();
            do
            {
                if (!arrayadapter.hasNext())
                {
                    break label0;
                }
                obj = (LdsOption)arrayadapter.next();
            } while (!((LdsOption) (obj)).value.equals(ldsfield));
            ebayspinner.setSelection(arraylist.indexOf(obj));
        }
    }

    private void updateState()
    {
        selectedServices.clear();
        loadShippingServiceInfo();
        packageDetails.setVisibility(8);
        boolean flag;
        if ("FLAT_RATE".equals(latestDraft.shippingType.getStringValue()) || "ACTUAL_RATE".equals(latestDraft.shippingType.getStringValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            showMoreDomesticOptions.setVisibility(0);
            showMoreInternationalOptions.setVisibility(0);
            updateLocalPickupDisplay();
            localPickupLayout.setVisibility(0);
            if ("ACTUAL_RATE".equals(latestDraft.shippingType.getStringValue()))
            {
                packageDetails.setVisibility(0);
                String s = getPackageInfoDisplay(latestDraft);
                packageInfoDisplay.setText(s);
            }
            updateAddDomesticServicesUI();
        } else
        {
            showOrHideView(domesticTypeRow, true, -2, false);
            showMoreDomesticOptions.setVisibility(8);
            showMoreInternationalOptions.setVisibility(8);
            addFirstShippingService.setVisibility(8);
            addAdditionalDomesticShippingServices.setVisibility(8);
            localPickupLayout.setVisibility(8);
        }
        if (latestDraft.globalShipping != null)
        {
            gspLayout.setVisibility(0);
            gspHelp.setVisibility(0);
            gspHelpTitle.setVisibility(0);
            updateCheckedTextValue(gspCheckedTextView, latestDraft.globalShipping);
        } else
        {
            gspHelp.setVisibility(8);
            gspHelpTitle.setVisibility(8);
            gspLayout.setVisibility(8);
        }
        if (latestDraft.intlShippingType != null && !"DISABLE".equals(latestDraft.intlShippingType.getBmode()) && "ACTUAL_RATE".equals(latestDraft.intlShippingType.getStringValue()))
        {
            intlTypeRow.setVisibility(0);
            if (latestDraft.getIntlShippingCount() > 0 && packageDetails.getVisibility() == 8)
            {
                String s1 = getPackageInfoDisplay(latestDraft);
                packageInfoDisplay.setText(s1);
                packageDetails.setVisibility(0);
            }
        } else
        if (latestDraft.intlShippingType != null && !"DISABLE".equals(latestDraft.intlShippingType.getBmode()) && "FLAT_RATE".equals(latestDraft.intlShippingType.getStringValue()))
        {
            intlTypeRow.setVisibility(0);
        } else
        {
            if (latestDraft.intlShippingType != null && !"DISABLE".equals(latestDraft.intlShippingType.getBmode()))
            {
                intlTypeRow.setVisibility(0);
            } else
            {
                intlTypeRow.setVisibility(8);
            }
            addInternationalShippingServices.setVisibility(8);
        }
        if (flag)
        {
            updateAddInternationalServicesUI();
        }
        updateShippingType(latestDraft.shippingType, domesticType, domesticTypeAdapter);
        updateShippingType(latestDraft.intlShippingType, intlType, intlTypeAdapter);
    }

    protected int getLayoutResource()
    {
        return 0x7f030215;
    }

    public ListingDraft getListingDraft()
    {
        return latestDraft;
    }

    public int getTitleRes()
    {
        return 0x7f0709d9;
    }

    public boolean isDataAvailable()
    {
        return latestDraft != null;
    }

    public void onChange(int i, Object obj)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   2131756778: 29
    //                   2131756790: 72;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        obj = ((LdsOption)obj).value;
        dm.updateShippingDomesticType(((String) (obj)));
        if (((String) (obj)).equals("ACTUAL_RATE") && localPickupCheckedTextView.isChecked())
        {
            localPickupCheckedTextView.toggle();
            return;
        }
          goto _L1
_L3:
        obj = ((LdsOption)obj).value;
        dm.updateShippingIntlType(((String) (obj)));
        return;
    }

    public void onClick(View view)
    {
        boolean flag = false;
        view.getId();
        JVM INSTR lookupswitch 18: default 160
    //                   2131756614: 1709
    //                   2131756768: 1731
    //                   2131756770: 1298
    //                   2131756771: 161
    //                   2131756772: 286
    //                   2131756773: 405
    //                   2131756774: 524
    //                   2131756776: 1687
    //                   2131756779: 1303
    //                   2131756780: 1313
    //                   2131756782: 643
    //                   2131756783: 774
    //                   2131756784: 905
    //                   2131756785: 1036
    //                   2131756786: 1167
    //                   2131756788: 1665
    //                   2131756791: 1308
    //                   2131756792: 1537;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L1:
        return;
_L5:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(false).setService(latestDraft.shippingService1).setFee(latestDraft.shippingService1fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(localPickupCheckedTextView.isChecked()).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "shippingService1");
        return;
_L6:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(false).setService(latestDraft.shippingService2).setFee(latestDraft.shippingService2fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "shippingService2");
        return;
_L7:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(false).setService(latestDraft.shippingService3).setFee(latestDraft.shippingService3fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "shippingService3");
        return;
_L8:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(false).setService(latestDraft.shippingService4).setFee(latestDraft.shippingService4fee).setShippingType(latestDraft.shippingType).setRegion(null).setLocation(null).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "shippingService4");
        return;
_L12:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(true).setService(latestDraft.intlShippingService1).setFee(latestDraft.intlShippingFee1).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion1).setLocation(latestDraft.intlShipToLocation1).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "intlShippingService1");
        return;
_L13:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(true).setService(latestDraft.intlShippingService2).setFee(latestDraft.intlShippingFee2).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion2).setLocation(latestDraft.intlShipToLocation2).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "intlShippingService2");
        return;
_L14:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(true).setService(latestDraft.intlShippingService3).setFee(latestDraft.intlShippingFee3).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion3).setLocation(latestDraft.intlShipToLocation3).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "intlShippingService3");
        return;
_L15:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(true).setService(latestDraft.intlShippingService4).setFee(latestDraft.intlShippingFee4).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion4).setLocation(latestDraft.intlShipToLocation4).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "intlShippingService4");
        return;
_L16:
        view = new EditShippingServiceDialogFragment.EditShippingDialogConfig();
        view.setNewService(false).setInternational(true).setService(latestDraft.intlShippingService5).setFee(latestDraft.intlShippingFee5).setShippingType(latestDraft.intlShippingType).setRegion(latestDraft.intlShipToRegion5).setLocation(latestDraft.intlShipToLocation5).setFreeShipping(latestDraft.shippingFree).setCurrency(latestDraft.getCurrencyCode()).setAllowDelete(false).setEstimates(shippingEstimates).setShippingServices(serviceNameToServiceDetailsMap).setSelectedShippingServices(selectedServices);
        EditShippingServiceDialogFragment.createInstance(this, 102, view).show(getFragmentManager(), "intlShippingService5");
        return;
_L4:
        onClickAddDomesticShippingMethod();
        return;
_L10:
        onClickAddDomesticShippingMethod();
        return;
_L18:
        onClickAddInternationalShippingMethod();
        return;
_L11:
        int i;
        if (!showingAdvancedDomesticOptions)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showingAdvancedDomesticOptions = flag;
        view = (ImageView)showMoreDomesticOptions.findViewById(0x7f100707);
        if (showingAdvancedDomesticOptions)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        view.setImageResource(i);
        view = (TextView)showMoreDomesticOptions.findViewById(0x7f100706);
        if (showingAdvancedDomesticOptions)
        {
            i = 0x7f0705c1;
        } else
        {
            i = 0x7f0705c2;
        }
        view.setText(i);
        i = getGuessedSpinnerHeight();
        showOrHideView(domesticTypeRow, showingAdvancedDomesticOptions, -2, i, true);
        showOrHideView(addAdditionalDomesticShippingServices, showingAdvancedDomesticOptions, -2, showMoreDomesticOptions.getHeight(), true);
        if (!localPickupCheckedTextView.isChecked() && latestDraft.siteId != 77)
        {
            if (showingAdvancedDomesticOptions && localPickupLayout.getHeight() <= 0 || !showingAdvancedDomesticOptions && localPickupLayout.getHeight() > 0)
            {
                showOrHideView(localPickupLayout, showingAdvancedDomesticOptions, -2, showMoreDomesticOptions.getHeight(), true);
                return;
            }
        } else
        {
            showOrHideView(localPickupLayout, true, -2, false);
            return;
        }
          goto _L1
_L19:
        if (!showingAdvancedInternationalOptions)
        {
            flag = true;
        }
        showingAdvancedInternationalOptions = flag;
        view = (ImageView)showMoreInternationalOptions.findViewById(0x7f100707);
        int j;
        if (showingAdvancedInternationalOptions)
        {
            j = 0x7f020256;
        } else
        {
            j = 0x7f020252;
        }
        view.setImageResource(j);
        view = (TextView)showMoreInternationalOptions.findViewById(0x7f100706);
        if (showingAdvancedInternationalOptions)
        {
            j = 0x7f0705c1;
        } else
        {
            j = 0x7f0705c2;
        }
        view.setText(j);
        j = getGuessedSpinnerHeight();
        showOrHideView(intlTypeRow, showingAdvancedInternationalOptions, -2, j, true);
        showOrHideView(addInternationalShippingServices, showingAdvancedInternationalOptions, showMoreInternationalOptions.getHeight(), true);
        return;
_L17:
        gspCheckedTextView.toggle();
        dm.updateShippingGsp(gspCheckedTextView.isChecked());
        return;
_L9:
        localPickupCheckedTextView.toggle();
        dm.updateShippingLocalPickup(localPickupCheckedTextView.isChecked());
        return;
_L2:
        freeShippingCheck.toggle();
        dm.updateShippingFree(freeShippingCheck.isChecked());
        return;
_L3:
        view = new PackageDetailsDialogFragment();
        view.setTargetFragment(this, 101);
        view.show(getFragmentManager(), "package_details");
        return;
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (!listingdraftcontent.getStatus().hasError())
        {
            boolean flag = false;
            if (latestDraft == null)
            {
                flag = true;
            }
            latestDraft = (ListingDraft)listingdraftcontent.getData();
            shippingEstimates = listingdraftcontent.shippingEstimates;
            shippingRecommendation = listingdraftcontent.shippingRecommendation;
            updateState();
            if (flag)
            {
                progress.setVisibility(8);
                parent.setVisibility(0);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = super.onCreateView(layoutinflater, viewgroup, bundle);
        inflater = layoutinflater;
        return viewgroup;
    }

    public void onDeleteShippingService(String s, boolean flag)
    {
        dm.deleteShippingService(s, flag);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams keyparams = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        dm = (ListingDraftDataManager)datamanagercontainer.initialize(keyparams, this);
        datamanagercontainer = (ShippingDetailsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.viewitem.ShippingDetailsDataManager.KeyParams(keyparams.draftSite), this);
        if (datamanagercontainer != null)
        {
            datamanagercontainer.loadData(null, EbayApiUtil.getTradingApi(keyparams.draftSite, getView().getContext(), MyApp.getPrefs().getAuthentication()));
        }
    }

    public void onPackageDetailsResult(com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PackageDetailFields packagedetailfields)
    {
        dm.updatePackageDetails(packagedetailfields);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingShippingService");
    }

    public void onSaveDomesticShippingService(String s, String s1, String s2, String s3, String s4)
    {
        dm.updateShippingDomesticService(s, s1, s2, s3, s4);
    }

    public void onSaveInternationalShippingService(String s, String s1, String s2, String s3, String s4, boolean flag, String s5, 
            ArrayList arraylist)
    {
        dm.updateShippingIntlService(s, s1, s2, s3, s4, s5, arraylist);
    }

    public void onShippingDetailsChanged(ShippingDetailsDataManager shippingdetailsdatamanager, Content content)
    {
        if (content != null && content.getData() != null)
        {
            serviceNameToServiceDetailsMap = (Map)content.getData();
        }
        if (latestDraft != null)
        {
            updateState();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        textColorPrimary = ThemeUtil.resolveThemeColorStateList(view.getContext().getResources(), view.getContext().getTheme(), 0x1010036);
        textColorSecondary = ThemeUtil.resolveThemeColorStateList(view.getContext().getResources(), view.getContext().getTheme(), 0x1010036);
        bundle = getString(0x7f070548);
        Object obj = getString(0x7f070561);
        String s = getString(0x7f070560);
        localPickupEnabledText = new SpannableString((new StringBuilder()).append(bundle).append("\n").append(((String) (obj))).toString());
        localPickupDisabledText = new SpannableString((new StringBuilder()).append(bundle).append("\n").append(s).toString());
        obj = new RelativeSizeSpan(0.9F);
        localPickupEnabledText.setSpan(obj, bundle.length(), localPickupEnabledText.length(), 34);
        localPickupDisabledText.setSpan(obj, bundle.length(), localPickupDisabledText.length(), 34);
        obj = new ForegroundColorSpan(view.getContext().getResources().getColor(0x7f0d00e7));
        localPickupEnabledText.setSpan(obj, bundle.length(), localPickupEnabledText.length(), 34);
        packageDetails = view.findViewById(0x7f1006de);
        packageInfoDisplay = (Button)view.findViewById(0x7f1006e0);
        packageInfoDisplay.setOnClickListener(this);
        addFirstShippingService = view.findViewById(0x7f1006e2);
        addFirstShippingService.setOnClickListener(this);
        addAdditionalDomesticShippingServices = view.findViewById(0x7f1006eb);
        addAdditionalDomesticShippingServices.setOnClickListener(this);
        addInternationalShippingServices = view.findViewById(0x7f1006f7);
        addInternationalShippingServices.setOnClickListener(this);
        domesticType = (EbaySpinner)view.findViewById(0x7f1006ea);
        domesticType.setChangeListener(this);
        domesticTypeAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        domesticTypeAdapter.setDropDownViewResource(0x7f030217);
        domesticTypeRow = view.findViewById(0x7f1006e9);
        intlType = (EbaySpinner)view.findViewById(0x7f1006f6);
        intlType.setChangeListener(this);
        intlTypeAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        intlTypeAdapter.setDropDownViewResource(0x7f030217);
        intlTypeRow = view.findViewById(0x7f1006f5);
        gspLayout = view.findViewById(0x7f1006f3);
        gspCheckedTextView = (CheckedTextView)view.findViewById(0x7f1006f4);
        gspCheckedTextView.setOnClickListener(this);
        gspHelpTitle = view.findViewById(0x7f1006f9);
        gspHelp = view.findViewById(0x7f1006fa);
        localPickupLayout = view.findViewById(0x7f1006e7);
        localPickupCheckedTextView = (CheckedTextView)view.findViewById(0x7f1006e8);
        localPickupCheckedTextView.setOnClickListener(this);
        domesticService1 = (LinearLayout)view.findViewById(0x7f1006e3);
        domesticService2 = (LinearLayout)view.findViewById(0x7f1006e4);
        domesticService3 = (LinearLayout)view.findViewById(0x7f1006e5);
        domesticService4 = (LinearLayout)view.findViewById(0x7f1006e6);
        intlService1 = (LinearLayout)view.findViewById(0x7f1006ee);
        intlService2 = (LinearLayout)view.findViewById(0x7f1006ef);
        intlService3 = (LinearLayout)view.findViewById(0x7f1006f0);
        intlService4 = (LinearLayout)view.findViewById(0x7f1006f1);
        intlService5 = (LinearLayout)view.findViewById(0x7f1006f2);
        domesticService1.setOnClickListener(this);
        domesticService2.setOnClickListener(this);
        domesticService3.setOnClickListener(this);
        domesticService4.setOnClickListener(this);
        intlService1.setOnClickListener(this);
        intlService2.setOnClickListener(this);
        intlService3.setOnClickListener(this);
        intlService4.setOnClickListener(this);
        intlService5.setOnClickListener(this);
        showMoreDomesticOptions = view.findViewById(0x7f1006ec);
        showMoreDomesticOptions.setOnClickListener(this);
        showMoreInternationalOptions = view.findViewById(0x7f1006f8);
        showMoreInternationalOptions.setOnClickListener(this);
        progress = view.findViewById(0x7f100143);
        parent = view.findViewById(0x7f1004bc);
        parent.setVisibility(8);
        progress.setVisibility(0);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (flag)
        {
            dm.validateDraft();
        }
    }
}
