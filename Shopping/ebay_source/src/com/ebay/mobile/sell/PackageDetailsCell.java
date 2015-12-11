// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import java.util.Iterator;

public class PackageDetailsCell
{

    private final String IMPERIAL_LENGTH;
    private final String IMPERIAL_WEIGHT_MAJOR;
    private final String IMPERIAL_WEIGHT_MINOR;
    private final String METRIC_LENGTH;
    private final String METRIC_WEIGHT_MAJOR;
    private final String METRIC_WEIGHT_MINOR;
    private EditText dimDepth;
    private EditText dimLength;
    private TextView dimUnit1;
    private TextView dimUnit2;
    private TextView dimUnit3;
    private EditText dimWidth;
    private CheckedTextView irregularCheckBox;
    private LinearLayout packageCustomLayout;
    private final EbaySpinner packageType;
    private final ArrayAdapter packageTypeAdapter;
    private EbaySpinner packageWeight;
    private ArrayAdapter packageWeightAdapter;
    private EditText packageWeightMajor;
    private EditText packageWeightMinor;
    private TextView packageWeightUnitMajor;
    private TextView packageWeightUnitMinor;

    public PackageDetailsCell(Fragment fragment)
    {
        IMPERIAL_LENGTH = fragment.getString(0x7f070756);
        IMPERIAL_WEIGHT_MAJOR = fragment.getString(0x7f070758);
        IMPERIAL_WEIGHT_MINOR = fragment.getString(0x7f07075a);
        METRIC_LENGTH = fragment.getString(0x7f070757);
        METRIC_WEIGHT_MAJOR = fragment.getString(0x7f070759);
        METRIC_WEIGHT_MINOR = fragment.getString(0x7f07075b);
        packageType = (EbaySpinner)fragment.getView().findViewById(0x7f100662);
        packageTypeAdapter = new ArrayAdapter(fragment.getView().getContext(), 0x7f030223);
        packageTypeAdapter.setDropDownViewResource(0x7f030217);
        dimLength = (EditText)fragment.getView().findViewById(0x7f100663);
        dimWidth = (EditText)fragment.getView().findViewById(0x7f100664);
        dimDepth = (EditText)fragment.getView().findViewById(0x7f100666);
        dimUnit1 = (TextView)fragment.getView().findViewById(0x7f100665);
        dimUnit2 = (TextView)fragment.getView().findViewById(0x7f100667);
        dimUnit3 = (TextView)fragment.getView().findViewById(0x7f100668);
        irregularCheckBox = (CheckedTextView)fragment.getView().findViewById(0x7f10066a);
        irregularCheckBox.setOnClickListener((android.view.View.OnClickListener)fragment);
        packageWeight = (EbaySpinner)fragment.getView().findViewById(0x7f10066b);
        packageWeight.setChangeListener((com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged)fragment);
        packageWeightAdapter = new ArrayAdapter(fragment.getView().getContext(), 0x7f030223);
        packageWeightAdapter.setDropDownViewResource(0x7f030217);
        packageCustomLayout = (LinearLayout)fragment.getView().findViewById(0x7f10066c);
        packageWeightMajor = (EditText)fragment.getView().findViewById(0x7f10066d);
        packageWeightMinor = (EditText)fragment.getView().findViewById(0x7f10066e);
        packageWeightUnitMajor = (TextView)fragment.getView().findViewById(0x7f10066f);
        packageWeightUnitMinor = (TextView)fragment.getView().findViewById(0x7f100670);
    }

    private void updateControls(LdsField ldsfield, LdsField ldsfield1, LdsField ldsfield2, LdsField ldsfield3, LdsField ldsfield4, LdsField ldsfield5, LdsField ldsfield6, 
            LdsField ldsfield7, LdsField ldsfield8)
    {
label0:
        {
            if ("IMPERIAL".equals(ldsfield8.getStringValue()))
            {
                dimUnit1.setText(IMPERIAL_LENGTH);
                dimUnit2.setText(IMPERIAL_LENGTH);
                dimUnit3.setText(IMPERIAL_LENGTH);
                packageWeightUnitMajor.setText(IMPERIAL_WEIGHT_MAJOR);
                packageWeightUnitMinor.setText(IMPERIAL_WEIGHT_MINOR);
            } else
            {
                dimUnit1.setText(METRIC_LENGTH);
                dimUnit2.setText(METRIC_LENGTH);
                dimUnit3.setText(METRIC_LENGTH);
                packageWeightUnitMajor.setText(METRIC_WEIGHT_MAJOR);
                packageWeightUnitMinor.setText(METRIC_WEIGHT_MINOR);
            }
            packageType.setEnabled(ldsfield.isEnabled());
            ldsfield8 = ldsfield.options;
            packageTypeAdapter.clear();
            if (ldsfield8 != null)
            {
                LdsOption ldsoption;
                for (Iterator iterator = ldsfield8.iterator(); iterator.hasNext(); packageTypeAdapter.add(ldsoption))
                {
                    ldsoption = (LdsOption)iterator.next();
                }

            }
            packageType.setAdapter(packageTypeAdapter);
            ldsfield = ldsfield.getStringValue();
            if (ldsfield8 == null)
            {
                break label0;
            }
            Iterator iterator1 = ldsfield8.iterator();
            LdsOption ldsoption1;
            do
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                ldsoption1 = (LdsOption)iterator1.next();
            } while (!ldsoption1.value.equals(ldsfield));
            packageType.setSelection(ldsfield8.indexOf(ldsoption1));
        }
label1:
        {
            if (ldsfield1 != null && !ldsfield1.getBmode().equals("DISABLE"))
            {
                dimLength.setEnabled(ldsfield2.isEnabled());
                dimLength.setText((new StringBuilder()).append("").append((int)ldsfield2.getDoubleValue()).toString());
                dimWidth.setEnabled(ldsfield1.isEnabled());
                dimWidth.setText((new StringBuilder()).append("").append((int)ldsfield1.getDoubleValue()).toString());
                dimDepth.setEnabled(ldsfield3.isEnabled());
                dimDepth.setText((new StringBuilder()).append("").append((int)ldsfield3.getDoubleValue()).toString());
            }
            if (ldsfield4 == null || ldsfield4.getBmode().equals("DISABLE"))
            {
                irregularCheckBox.setVisibility(8);
            } else
            {
                irregularCheckBox.setVisibility(0);
                irregularCheckBox.setEnabled(ldsfield4.isEnabled());
                ldsfield = ldsfield4.getStringValue();
                if (ldsfield == null)
                {
                    irregularCheckBox.setChecked(false);
                } else
                {
                    irregularCheckBox.setChecked(Boolean.valueOf(ldsfield).booleanValue());
                }
            }
            packageWeight.setEnabled(ldsfield5.isEnabled());
            ldsfield = ldsfield5.options;
            packageWeightAdapter.clear();
            if (ldsfield != null)
            {
                for (ldsfield1 = ldsfield.iterator(); ldsfield1.hasNext(); packageWeightAdapter.add(ldsfield2))
                {
                    ldsfield2 = (LdsOption)ldsfield1.next();
                }

            }
            packageWeight.setAdapter(packageWeightAdapter);
            ldsfield1 = ldsfield5.getStringValue();
            if (ldsfield == null)
            {
                break label1;
            }
            ldsfield2 = ldsfield.iterator();
            do
            {
                if (!ldsfield2.hasNext())
                {
                    break label1;
                }
                ldsfield3 = (LdsOption)ldsfield2.next();
            } while (!((LdsOption) (ldsfield3)).value.equals(ldsfield1));
            packageWeight.setSelection(ldsfield.indexOf(ldsfield3));
        }
        packageWeightMajor.setEnabled(ldsfield6.isEnabled());
        packageWeightMinor.setEnabled(ldsfield7.isEnabled());
        packageWeightMajor.setText((new StringBuilder()).append("").append(ldsfield6.getIntValue()).toString());
        packageWeightMinor.setText((new StringBuilder()).append("").append(ldsfield7.getIntValue()).toString());
        if ("CUSTOM_WEIGHT".equals(ldsfield5.getStringValue()))
        {
            packageCustomLayout.setVisibility(0);
            packageWeightUnitMajor.setVisibility(0);
            packageWeightMajor.setVisibility(0);
            return;
        }
        if ("ONE_LB_OR_LESS".equals(ldsfield5.getStringValue()))
        {
            packageCustomLayout.setVisibility(0);
            packageWeightUnitMajor.setVisibility(4);
            packageWeightMajor.setVisibility(4);
            return;
        } else
        {
            packageCustomLayout.setVisibility(8);
            return;
        }
    }

    public com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PackageDetailFields getFields()
    {
        com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PackageDetailFields packagedetailfields = new com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PackageDetailFields();
        packagedetailfields.packageTypeStr = ((LdsOption)packageType.getSelectedItem()).value;
        packagedetailfields.dimLengthStr = dimLength.getText().toString();
        packagedetailfields.dimWidthStr = dimWidth.getText().toString();
        packagedetailfields.dimDepthStr = dimDepth.getText().toString();
        packagedetailfields.irregular = irregularCheckBox.isChecked();
        packagedetailfields.estimatedWeightStr = ((LdsOption)packageWeight.getSelectedItem()).value;
        packagedetailfields.packageWeightMajorStr = packageWeightMajor.getText().toString();
        packagedetailfields.packageWeightMinorStr = packageWeightMinor.getText().toString();
        return packagedetailfields;
    }

    public boolean toggleIrregularPackageValue()
    {
        irregularCheckBox.toggle();
        return irregularCheckBox.isChecked();
    }

    public void updateControls(ListingDraft listingdraft)
    {
        updateControls(listingdraft.packageType, listingdraft.packageWidth, listingdraft.packageLength, listingdraft.packageDepth, listingdraft.packageIrregular, listingdraft.packageWeightEstimated, listingdraft.packageWeightMajor, listingdraft.packageWeightMinor, listingdraft.packageUnitOfMeasure);
    }

    public void weightSelectionChanged(LdsOption ldsoption)
    {
        byte byte0;
        if (ldsoption == null)
        {
            return;
        }
        ldsoption = ldsoption.value;
        byte0 = -1;
        ldsoption.hashCode();
        JVM INSTR lookupswitch 2: default 44
    //                   -1573739770: 78
    //                   -478743483: 93;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_93;
_L4:
        switch (byte0)
        {
        default:
            packageCustomLayout.setVisibility(8);
            return;

        case 0: // '\0'
            packageCustomLayout.setVisibility(0);
            packageWeightUnitMajor.setVisibility(0);
            packageWeightMajor.setVisibility(0);
            return;

        case 1: // '\001'
            packageCustomLayout.setVisibility(0);
            break;
        }
        break MISSING_BLOCK_LABEL_141;
_L2:
        if (ldsoption.equals("CUSTOM_WEIGHT"))
        {
            byte0 = 0;
        }
          goto _L4
        if (ldsoption.equals("ONE_LB_OR_LESS"))
        {
            byte0 = 1;
        }
          goto _L4
        packageWeightUnitMajor.setVisibility(4);
        packageWeightMajor.setVisibility(4);
        return;
    }
}
