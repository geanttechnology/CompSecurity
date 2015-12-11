// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.mobile.activities.BaseDialogFragment;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import java.util.ArrayList;
import java.util.Iterator;

public class ShippingLocationDialogFragment extends BaseDialogFragment
    implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener
{
    public static interface ShippingLocationCallback
    {

        public abstract void onShipToDialogLocationsResult(int i, ArrayList arraylist);

        public abstract void onShipToDialogRegionResult(int i, LdsOption ldsoption);
    }


    public static final String ADDITIONAL_LOCATIONS = "additional_locations";
    public static final String CALLBACK_ID = "callbackId";
    public static final String MAIN_REGIONS = "regions";
    private ShippingLocationCallback callback;
    private int callbackId;
    boolean checkedLocations[];
    private View customLocationLabel;
    private LdsField location;
    private ContainerLayout locationLayout;
    private LdsField region;
    private ContainerLayout regionLayout;

    public ShippingLocationDialogFragment()
    {
    }

    public static ShippingLocationDialogFragment createInstance(Fragment fragment, int i, LdsField ldsfield, LdsField ldsfield1)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("regions", ldsfield);
        bundle.putParcelable("additional_locations", ldsfield1);
        ldsfield = new ShippingLocationDialogFragment();
        ldsfield.setTargetFragment(fragment, i);
        ldsfield.setArguments(bundle);
        return ldsfield;
    }

    private void createUI(View view)
    {
        regionLayout = (ContainerLayout)view.findViewById(0x7f100702);
        locationLayout = (ContainerLayout)view.findViewById(0x7f100704);
        customLocationLabel = view.findViewById(0x7f100703);
    }

    private void fillLocationOptions()
    {
        locationLayout.removeAllViews();
        Iterator iterator = location.options.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsOption ldsoption = (LdsOption)iterator.next();
            if (ldsoption.caption == null || ldsoption.value.equals("None"))
            {
                continue;
            }
            CheckedTextView checkedtextview = (CheckedTextView)getActivity().getLayoutInflater().inflate(0x7f03021e, locationLayout, false);
            checkedtextview.setText(ldsoption.caption);
            checkedtextview.setTag(ldsoption);
            checkedtextview.setOnClickListener(this);
            boolean flag1 = false;
            int i = location.options.indexOf(ldsoption);
            Iterator iterator1 = location.getSelectedValues().iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                if (!((String)iterator1.next()).equals(ldsoption.value))
                {
                    continue;
                }
                flag = true;
                checkedtextview.setChecked(true);
                break;
            } while (true);
            checkedLocations[i] = flag;
            locationLayout.addView(checkedtextview);
            checkedtextview.setPadding(20, 0, 10, 0);
        } while (true);
    }

    private boolean fillRegionOptions()
    {
        boolean flag = false;
        regionLayout.removeAllViews();
        Iterator iterator = region.options.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsOption ldsoption = (LdsOption)iterator.next();
            if (ldsoption.getIntValue() != 0)
            {
                CheckedTextView checkedtextview = (CheckedTextView)getActivity().getLayoutInflater().inflate(0x7f03021e, regionLayout, false);
                checkedtextview.setText(ldsoption.caption);
                checkedtextview.setTag(ldsoption);
                checkedtextview.setOnClickListener(this);
                Iterator iterator1 = region.getSelectedValues().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    if (Integer.parseInt((String)iterator1.next()) == ldsoption.getIntValue())
                    {
                        checkedtextview.setChecked(true);
                        if (ldsoption.getIntValue() == 2)
                        {
                            flag = true;
                        }
                    }
                } while (true);
                regionLayout.addView(checkedtextview);
                checkedtextview.setPadding(20, 0, 10, 0);
            }
        } while (true);
        return flag;
    }

    private void saveCustomLocation()
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            if (i >= location.options.size())
            {
                break;
            }
            if (!((LdsOption)location.options.get(i)).value.equals("None") && checkedLocations[i])
            {
                arraylist.add(location.options.get(i));
            }
            i++;
        } while (true);
        callback.onShipToDialogLocationsResult(callbackId, arraylist);
    }

    private void updateUI()
    {
        boolean flag = false;
        checkedLocations = new boolean[location.options.size()];
        boolean flag1 = fillRegionOptions();
        fillLocationOptions();
        Object obj = locationLayout;
        int i;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ContainerLayout) (obj)).setVisibility(i);
        obj = customLocationLabel;
        if (flag1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            callback = (ShippingLocationCallback)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch -2 -1: default 24
    //                   -2 24
    //                   -1 29;
           goto _L1 _L1 _L2
_L1:
        dismiss();
        return;
_L2:
        int j;
        j = regionLayout.getChildCount();
        i = 0;
_L8:
        if (i >= j) goto _L1; else goto _L3
_L3:
        dialoginterface = (CheckedTextView)regionLayout.getChildAt(i);
        if (!dialoginterface.isChecked()) goto _L5; else goto _L4
_L4:
        dialoginterface = (LdsOption)dialoginterface.getTag();
        if (dialoginterface.getIntValue() != 2) goto _L7; else goto _L6
_L6:
        saveCustomLocation();
          goto _L1
_L7:
        callback.onShipToDialogRegionResult(callbackId, dialoginterface);
_L5:
        i++;
          goto _L8
    }

    public void onClick(View view)
    {
        LdsOption ldsoption;
label0:
        {
label1:
            {
                if ((view instanceof CheckedTextView) && (view.getTag() instanceof LdsOption))
                {
                    ldsoption = (LdsOption)view.getTag();
                    if (((ContainerLayout)view.getParent()).getId() != 0x7f100702)
                    {
                        break label0;
                    }
                    ContainerLayout containerlayout = (ContainerLayout)view.getParent();
                    int k = containerlayout.getChildCount();
                    for (int i = 0; i < k; i++)
                    {
                        CheckedTextView checkedtextview = (CheckedTextView)containerlayout.getChildAt(i);
                        if (checkedtextview != view)
                        {
                            checkedtextview.setChecked(false);
                        }
                    }

                    ((CheckedTextView)view).toggle();
                    if (ldsoption.getIntValue() != 2)
                    {
                        break label1;
                    }
                    locationLayout.setVisibility(0);
                    customLocationLabel.setVisibility(0);
                }
                return;
            }
            customLocationLabel.setVisibility(8);
            locationLayout.setVisibility(8);
            return;
        }
        view = (CheckedTextView)view;
        view.toggle();
        int j = location.options.indexOf(ldsoption);
        checkedLocations[j] = view.isChecked();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(0, 0);
        setRetainInstance(true);
        bundle = getArguments();
        if (bundle != null)
        {
            callbackId = bundle.getInt("callbackId");
            location = (LdsField)bundle.getParcelable("additional_locations");
            region = (LdsField)bundle.getParcelable("regions");
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = LayoutInflater.from(getActivity()).inflate(0x7f03021c, null);
        createUI(bundle);
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(0x7f0709ec).setView(bundle).setCancelable(true).setPositiveButton(0x7f070738, this).setNegativeButton(0x7f0701cc, this).create();
    }

    public void onResume()
    {
        super.onResume();
        try
        {
            callback = (ShippingLocationCallback)getTargetFragment();
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException("Your target fragment or activity need to implement the ShippingLocationCallback interface to use this dialog.");
        }
        updateUI();
    }
}
