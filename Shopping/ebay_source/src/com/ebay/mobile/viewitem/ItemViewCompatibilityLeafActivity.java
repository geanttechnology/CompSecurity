// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Vehicle;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewCommonProgressAndError, ViewItemViewData, ViewItemDataManager

public class ItemViewCompatibilityLeafActivity extends ItemViewBaseActivity
{

    private static String PARAM_VEHICLE = "vehicle";
    private LayoutInflater inflater;
    private Vehicle vehicle;
    private ViewItemDataManager viewItemDataManager;

    public ItemViewCompatibilityLeafActivity()
    {
    }

    public static void StartActivityForResult(Activity activity, int i, ViewItemViewData viewitemviewdata, Vehicle vehicle1)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewCompatibilityLeafActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        intent.putExtra(PARAM_VEHICLE, vehicle1);
        activity.startActivityForResult(intent, i);
    }

    private void appendLayout(ViewGroup viewgroup, String s, String s1)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f03013e, viewgroup, false);
        ((TextView)viewgroup1.findViewById(0x7f1000ec)).setText(s);
        ((TextView)viewgroup1.findViewById(0x7f1000ed)).setText(s1);
        viewgroup.addView(viewgroup1);
    }

    private void createUI()
    {
        ((TextView)findViewById(0x7f100302)).setText(vehicle.getName());
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100303);
        NameValue namevalue;
        for (Iterator iterator = vehicle.attributes.iterator(); iterator.hasNext(); appendLayout(viewgroup, namevalue.getName(), namevalue.getValue()))
        {
            namevalue = (NameValue)iterator.next();
        }

        ((Button)findViewById(0x7f10018c)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewCompatibilityLeafActivity this$0;

            public void onClick(View view)
            {
                setResult(-1);
                finish();
            }

            
            {
                this$0 = ItemViewCompatibilityLeafActivity.this;
                super();
            }
        });
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
    }

    public String getTrackingEventName()
    {
        return "CompatibilityBrowsedVehicle";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getResources().getString(0x7f070497));
        setContentView(0x7f030135);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        if (bundle != null)
        {
            vehicle = (Vehicle)bundle.getParcelable(PARAM_VEHICLE);
        } else
        {
            vehicle = (Vehicle)getIntent().getParcelableExtra(PARAM_VEHICLE);
        }
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
                    headerStart(0x7f03012f);
                    createUI();
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
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(PARAM_VEHICLE, vehicle);
    }

}
