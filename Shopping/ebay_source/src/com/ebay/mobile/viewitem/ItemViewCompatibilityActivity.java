// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.Vehicle;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.ItemCompatibilty;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemViewData, ViewItemDataManager, ItemViewCompatibilityLeafActivity

public class ItemViewCompatibilityActivity extends ItemViewBaseActivity
{

    private static final int LEAF_ACTIVITY = 2;
    private static final String PARAM_CHOSEN_SECTIONS = "chosen_sections";
    private ArrayList chosenSections;
    private LayoutInflater inflater;
    private TextView sectionHeader;
    private ArrayList sections;
    private ViewGroup sectionsLayout;

    public ItemViewCompatibilityActivity()
    {
        chosenSections = new ArrayList();
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewCompatibilityActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivity(intent);
    }

    private View appendLayout(ViewGroup viewgroup, String s)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f03012a, viewgroup, false);
        ((TextView)viewgroup1.findViewById(0x7f1000ec)).setText(s);
        viewgroup.addView(viewgroup1);
        return viewgroup1;
    }

    private ArrayList getValuesBasedOnChoices()
    {
        ArrayList arraylist = new ArrayList();
        String s = (String)sections.get(chosenSections.size());
        Iterator iterator = item.itemCompatibiltyList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (ItemCompatibilty)iterator.next();
            if (((ItemCompatibilty) (obj)).matches(sections, chosenSections))
            {
                obj = ((ItemCompatibilty) (obj)).getValueForName(s);
                if (obj != null && !arraylist.contains(obj))
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        return arraylist;
    }

    private void handleBackOrTop()
    {
        for (; !chosenSections.isEmpty() && TextUtils.isEmpty((CharSequence)chosenSections.get(chosenSections.size() - 1)); chosenSections.remove(chosenSections.size() - 1)) { }
        if (!chosenSections.isEmpty())
        {
            chosenSections.remove(chosenSections.size() - 1);
            setSectionsList();
            return;
        } else
        {
            finish();
            return;
        }
    }

    private boolean setSectionsList()
    {
        boolean flag = false;
        boolean flag1;
label0:
        do
        {
            Object obj;
            do
            {
                flag1 = flag;
                if (chosenSections.size() >= sections.size())
                {
                    break label0;
                }
                obj = getValuesBasedOnChoices();
                if (!((ArrayList) (obj)).isEmpty())
                {
                    break;
                }
                chosenSections.add("");
            } while (true);
            String s = (String)sections.get(chosenSections.size());
            sectionHeader.setText(getResources().getString(0x7f0704ae, new Object[] {
                s
            }));
            sectionsLayout.removeAllViews();
            obj = ((ArrayList) (obj)).iterator();
            for (flag1 = flag; ((Iterator) (obj)).hasNext(); flag1 = true)
            {
                final String value = (String)((Iterator) (obj)).next();
                appendLayout(sectionsLayout, value).setOnClickListener(new android.view.View.OnClickListener() {

                    final ItemViewCompatibilityActivity this$0;
                    final String val$value;

                    public void onClick(View view)
                    {
                        chosenSections.add(value);
                        if (!setSectionsList())
                        {
                            view = new Vehicle();
                            Iterator iterator = item.itemCompatibiltyList.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                ItemCompatibilty itemcompatibilty = (ItemCompatibilty)iterator.next();
                                if (!itemcompatibilty.matches(sections, chosenSections))
                                {
                                    continue;
                                }
                                for (Iterator iterator1 = itemcompatibilty.nameValueList.iterator(); iterator1.hasNext();)
                                {
                                    Object obj1 = (NameValue)iterator1.next();
                                    String s1 = ((NameValue) (obj1)).getName();
                                    obj1 = ((NameValue) (obj1)).getValue();
                                    if (!TextUtils.isEmpty(value))
                                    {
                                        Iterator iterator2 = sections.iterator();
                                        while (iterator2.hasNext()) 
                                        {
                                            String s2 = (String)iterator2.next();
                                            if (s2.equalsIgnoreCase(s1))
                                            {
                                                ((Vehicle) (view)).attributes.add(new NameValue(s2, ((String) (obj1))));
                                            }
                                        }
                                    }
                                }

                                break;
                            } while (true);
                            ItemViewCompatibilityLeafActivity.StartActivityForResult(ItemViewCompatibilityActivity.this, 2, viewData, view);
                        }
                    }

            
            {
                this$0 = ItemViewCompatibilityActivity.this;
                value = s;
                super();
            }
                });
            }

            flag = flag1;
        } while (!flag1);
        return flag1;
    }

    public String getTrackingEventName()
    {
        return "CompatibilityList";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            break;
        }
        if (-1 == j)
        {
            finish();
            return;
        } else
        {
            onBackPressed();
            return;
        }
    }

    public void onBackPressed()
    {
        handleBackOrTop();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getResources().getString(0x7f0704af));
        setContentView(0x7f030134);
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        if (bundle != null)
        {
            chosenSections = bundle.getStringArrayList("chosen_sections");
        }
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, final ViewItemDataManager.ActionHandled matchingVehicles, boolean flag)
    {
        if (!isFinishing())
        {
            super.onDataChanged(viewitemdatamanager, content, matchingVehicles, flag);
            if (!content.getStatus().hasError())
            {
                if (matchingVehicles == ViewItemDataManager.ActionHandled.INITIAL_LOAD)
                {
                    headerStart(0x7f03012f);
                    sections = new ArrayList();
                    for (viewitemdatamanager = item.itemCompatibiltyList.iterator(); viewitemdatamanager.hasNext();)
                    {
                        content = ((ItemCompatibilty)viewitemdatamanager.next()).nameValueList;
                        if (content != null)
                        {
                            content = content.iterator();
                            while (content.hasNext()) 
                            {
                                matchingVehicles = ((NameValue)content.next()).getName();
                                if (!TextUtils.isEmpty(matchingVehicles) && !sections.contains(matchingVehicles))
                                {
                                    sections.add(matchingVehicles);
                                }
                            }
                        }
                    }

                    viewitemdatamanager = (ViewGroup)findViewById(0x7f1002fe);
                    content = (ViewGroup)viewitemdatamanager.findViewById(0x7f1002ff);
                    matchingVehicles = item.getMatchingVehicles();
                    ArrayList arraylist = new ArrayList();
                    for (final int pos = 0; pos < matchingVehicles.size(); pos++)
                    {
                        Vehicle vehicle = (Vehicle)matchingVehicles.get(pos);
                        arraylist.add(vehicle.name);
                        appendLayout(content, vehicle.name).setOnClickListener(new android.view.View.OnClickListener() {

                            final ItemViewCompatibilityActivity this$0;
                            final ArrayList val$matchingVehicles;
                            final int val$pos;

                            public void onClick(View view)
                            {
                                view = (Vehicle)matchingVehicles.get(pos);
                                ItemViewCompatibilityLeafActivity.StartActivityForResult(ItemViewCompatibilityActivity.this, 2, viewData, view);
                            }

            
            {
                this$0 = ItemViewCompatibilityActivity.this;
                matchingVehicles = arraylist;
                pos = i;
                super();
            }
                        });
                    }

                    byte byte0;
                    if (matchingVehicles.isEmpty())
                    {
                        byte0 = 8;
                    } else
                    {
                        byte0 = 0;
                    }
                    viewitemdatamanager.setVisibility(byte0);
                    sectionHeader = (TextView)findViewById(0x7f100300);
                    sectionsLayout = (ViewGroup)findViewById(0x7f100301);
                    setSectionsList();
                    return;
                }
            } else
            {
                EbayErrorHandler.handleResultStatus(this, matchingVehicles.ordinal(), content.getStatus());
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        ((ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this)).loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (false) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 28
    //                   16908332 30;
           goto _L2 _L3
_L2:
        return false;
_L3:
        handleBackOrTop();
        return true;
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("chosen_sections", chosenSections);
    }



}
