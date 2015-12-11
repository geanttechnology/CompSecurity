// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class PackageInfoFragment extends ShippingLabelBaseFragment
{

    private static String INCH = "IN";
    private static String OUNCE = "OZ";
    private static String POUND = "LB";
    private static String STATE_HEIGHT = "HEIGHT";
    private static String STATE_LENGTH = "LENGTH";
    private static String STATE_WEIGHT_MAJOR = "WEIGHT_MAJOR";
    private static String STATE_WEIGHT_MINOR = "WEIGHT_MINOR";
    private static String STATE_WIDTH = "WIDTH";
    private String draftHeight;
    private String draftLength;
    private String draftWeightMajor;
    private String draftWeightMinor;
    private String draftWidth;

    public PackageInfoFragment()
    {
    }

    private boolean isEqual(double d, double d1)
    {
        return Math.abs(d - d1) < 0.0001D;
    }

    private static double safeParseDouble(String s)
    {
        double d;
        try
        {
            d = Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0.0D;
        }
        return d;
    }

    private boolean specChanges(double d, double d1, double d2, double d3, double d4)
    {
        ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
        if (!isEqual(d, shippinglabeldraft.labelDetails.pkg.spec.dimensionMeasure.length))
        {
            return true;
        }
        if (!isEqual(d1, shippinglabeldraft.labelDetails.pkg.spec.dimensionMeasure.width))
        {
            return true;
        }
        if (!isEqual(d2, shippinglabeldraft.labelDetails.pkg.spec.dimensionMeasure.height))
        {
            return true;
        }
        String s = shippinglabeldraft.labelDetails.pkg.spec.weight.unit;
        if (s.equals(OUNCE))
        {
            if (!isEqual(d3 + 16D * d4, shippinglabeldraft.labelDetails.pkg.spec.weight.value))
            {
                return true;
            }
        } else
        if (s.equals(POUND) && (!isEqual(d4, shippinglabeldraft.labelDetails.pkg.spec.weight.value) || !isEqual(d3, 0.0D)))
        {
            return true;
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey(STATE_WEIGHT_MAJOR))
        {
            draftWeightMajor = bundle.getString(STATE_WEIGHT_MAJOR);
            draftWeightMinor = bundle.getString(STATE_WEIGHT_MINOR);
            draftLength = bundle.getString(STATE_LENGTH);
            draftWidth = bundle.getString(STATE_WIDTH);
            draftHeight = bundle.getString(STATE_HEIGHT);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return (ViewGroup)layoutinflater.inflate(0x7f03023d, viewgroup, false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString(STATE_WEIGHT_MAJOR, draftWeightMajor);
        bundle.putString(STATE_WEIGHT_MINOR, draftWeightMinor);
        bundle.putString(STATE_LENGTH, draftLength);
        bundle.putString(STATE_HEIGHT, draftHeight);
        bundle.putString(STATE_WIDTH, draftWidth);
        super.onSaveInstanceState(bundle);
    }

    public void sendUpdates()
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
        double d = safeParseDouble(((EditText)getView().findViewById(0x7f1007a8)).getText().toString());
        double d1 = safeParseDouble(((EditText)getView().findViewById(0x7f1007aa)).getText().toString());
        double d2 = safeParseDouble(((EditText)getView().findViewById(0x7f1007ac)).getText().toString());
        String s = ((EditText)getView().findViewById(0x7f1007a4)).getText().toString();
        double d3 = safeParseDouble(s);
        String s1 = ((EditText)getView().findViewById(0x7f1007a2)).getText().toString();
        double d4 = safeParseDouble(s1);
        if (specChanges(d, d1, d2, d3, d4))
        {
            ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
            Object obj = ((ShippingLabelActivity)getActivity()).selectedShippingService;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((ShippingOption) (obj)).shippingKey;
            }
            obj = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippinglabeldraft, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingKey) (obj)));
            obj.spec = new com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs();
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.dimensionMeasure = new com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs.Dimension();
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.packageShape = com.ebay.nautilus.domain.data.ShippingLabelPackage.PackageShapeType.REGULAR;
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight = new com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs.Weight();
            if (!s1.isEmpty() && !s.isEmpty())
            {
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.unit = OUNCE;
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.value = d3 + 16D * d4;
            } else
            if (s1.isEmpty())
            {
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.unit = OUNCE;
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.value = d3;
            } else
            {
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.unit = POUND;
                ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.weight.value = d4;
            }
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.dimensionMeasure.unit = INCH;
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.dimensionMeasure.length = d;
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.dimensionMeasure.width = d1;
            ((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)).spec.dimensionMeasure.height = d2;
            ((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.updateDraftPackage(((com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams) (obj)), shippinglabeldraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
        }
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f070857);
    }

    public void updateUI()
    {
        double d;
        double d1;
        double d2;
        Object obj;
        Object obj1;
        obj1 = (ShippingLabelActivity)getActivity();
        obj = ((ShippingLabelActivity) (obj1)).shippingLabelDraft;
        View view = getView();
        view.setVisibility(0);
        obj1 = ((ShippingLabelActivity) (obj1)).selectedShippingService;
        if (obj1 != null)
        {
            if (!((ShippingOption) (obj1)).attributes.weightSupported)
            {
                view.findViewById(0x7f10079f).setVisibility(8);
                view.findViewById(0x7f1007a0).setVisibility(8);
            } else
            {
                view.findViewById(0x7f10079f).setVisibility(0);
                view.findViewById(0x7f1007a0).setVisibility(0);
            }
            if (!((ShippingOption) (obj1)).attributes.dimensionSupported)
            {
                view.findViewById(0x7f1007a5).setVisibility(8);
                view.findViewById(0x7f1007a6).setVisibility(8);
            } else
            {
                view.findViewById(0x7f1007a5).setVisibility(0);
                view.findViewById(0x7f1007a6).setVisibility(0);
            }
        }
        obj1 = Double.toString(((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.dimensionMeasure.length);
        if (draftLength == null || !draftLength.equals(obj1))
        {
            draftLength = ((String) (obj1));
            ((EditText)view.findViewById(0x7f1007a8)).setText(draftLength);
        }
        obj1 = Double.toString(((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.dimensionMeasure.width);
        if (draftWidth == null || !draftWidth.equals(obj1))
        {
            draftWidth = ((String) (obj1));
            ((EditText)view.findViewById(0x7f1007aa)).setText(draftWidth);
        }
        obj1 = Double.toString(((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.dimensionMeasure.height);
        if (draftHeight == null || !draftHeight.equals(obj1))
        {
            draftHeight = ((String) (obj1));
            ((EditText)view.findViewById(0x7f1007ac)).setText(((CharSequence) (obj1)));
        }
        obj1 = ((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.weight;
        d1 = 0.0D;
        d2 = 0.0D;
        if (!((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs.Weight) (obj1)).unit.equals(OUNCE)) goto _L2; else goto _L1
_L1:
        d = ((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.weight.value;
_L4:
        d2 = d;
        if (d > 15D)
        {
            d1 = (int)(d / 16D);
            d2 = d % 16D;
        }
        obj = Double.toString(d1);
        if (draftWeightMajor == null || !draftWeightMajor.equals(obj))
        {
            draftWeightMajor = ((String) (obj));
            ((EditText)view.findViewById(0x7f1007a2)).setText(((CharSequence) (obj)));
        }
        obj = Double.toString(d2);
        if (draftWeightMinor == null || !draftWeightMinor.equals(obj))
        {
            draftWeightMinor = ((String) (obj));
            ((EditText)view.findViewById(0x7f1007a4)).setText(((CharSequence) (obj)));
        }
        return;
_L2:
        d = d2;
        if (((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs.Weight) (obj1)).unit.equals(POUND))
        {
            d1 = ((ShippingLabelDraft) (obj)).labelDetails.pkg.spec.weight.value;
            d = d2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
