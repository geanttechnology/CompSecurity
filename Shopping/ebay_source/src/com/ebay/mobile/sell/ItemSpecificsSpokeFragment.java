// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.mobile.sell.util.ItemSpecificsValueProcessor;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.ItemSpecific;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ItemSpecificsDialogFragment, ListingFragmentActivity

public class ItemSpecificsSpokeFragment extends BaseSpokeFragment
    implements android.content.DialogInterface.OnCancelListener, android.view.View.OnClickListener, com.ebay.mobile.util.ContentSyncManager.ContentSync, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{
    public static final class ItemSpecificsDialogAction extends Enum
    {

        private static final ItemSpecificsDialogAction $VALUES[];
        public static final ItemSpecificsDialogAction SAVE_CUSTOM;
        public static final ItemSpecificsDialogAction SAVE_MULTIPLE;
        public static final ItemSpecificsDialogAction SAVE_SINGLE;

        public static ItemSpecificsDialogAction valueOf(String s)
        {
            return (ItemSpecificsDialogAction)Enum.valueOf(com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogAction, s);
        }

        public static ItemSpecificsDialogAction[] values()
        {
            return (ItemSpecificsDialogAction[])$VALUES.clone();
        }

        static 
        {
            SAVE_SINGLE = new ItemSpecificsDialogAction("SAVE_SINGLE", 0);
            SAVE_MULTIPLE = new ItemSpecificsDialogAction("SAVE_MULTIPLE", 1);
            SAVE_CUSTOM = new ItemSpecificsDialogAction("SAVE_CUSTOM", 2);
            $VALUES = (new ItemSpecificsDialogAction[] {
                SAVE_SINGLE, SAVE_MULTIPLE, SAVE_CUSTOM
            });
        }

        private ItemSpecificsDialogAction(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ItemSpecificsDialogData
    {

        public final ItemSpecificsDialogAction action;
        boolean checkedSpecificOptions[];
        public String customValue;
        public ItemSpecificsValueProcessor processor;
        public ItemSpecific specifics;
        public int which;

        public ItemSpecificsDialogData(ItemSpecificsDialogAction itemspecificsdialogaction)
        {
            action = itemspecificsdialogaction;
        }
    }


    protected static final int DIALOG_CHOOSE_VALUE = 0;
    protected static final int DIALOG_CUSTOM_VALUE = 1;
    static final String DIALOG_ID = "dialog_id";
    protected static final String SPECIFICS_DIALOG = "specificsDialog";
    private final ArrayList disabledDependents = new ArrayList();
    private ListingDraftDataManager dm;
    private ListingDraft draftSnapshot;
    private View emptyView;
    private boolean firstLoad;
    private ArrayList loadedSpecifics;
    private View loadingView;
    private ContainerLayout productContainer;
    private ContainerLayout recommendedContainer;
    private ContainerLayout requiredContainer;

    public ItemSpecificsSpokeFragment()
    {
        firstLoad = true;
        loadedSpecifics = new ArrayList();
    }

    private void clearDependentSpecificsSelection(ItemSpecific itemspecific)
    {
        ArrayList arraylist = new ArrayList();
        disabledDependents.clear();
        for (Iterator iterator = draftSnapshot.selectedItemSpecifics.iterator(); iterator.hasNext();)
        {
            LdsField ldsfield = (LdsField)iterator.next();
            if (!ldsfield.getIdIndex().equals(itemspecific.name))
            {
                Iterator iterator1 = loadedSpecifics.iterator();
                while (iterator1.hasNext()) 
                {
                    ItemSpecific itemspecific1 = (ItemSpecific)iterator1.next();
                    if (itemspecific1.name.equals(ldsfield.getIdIndex()))
                    {
                        Iterator iterator2 = itemspecific1.dependencies.iterator();
                        while (iterator2.hasNext()) 
                        {
                            if (((String)iterator2.next()).equals(itemspecific.name))
                            {
                                arraylist.add(ldsfield);
                                disabledDependents.add(itemspecific1.name);
                            }
                        }
                    }
                }
            }
        }

        draftSnapshot.selectedItemSpecifics.removeAll(arraylist);
    }

    private LdsField initializeFieldForSpecific(ItemSpecific itemspecific)
    {
        LdsField ldsfield1 = null;
        Iterator iterator = draftSnapshot.selectedItemSpecifics.iterator();
        LdsField ldsfield;
        do
        {
            ldsfield = ldsfield1;
            if (!iterator.hasNext())
            {
                break;
            }
            ldsfield = (LdsField)iterator.next();
            if (!ldsfield.getIdIndex().equals(itemspecific.name))
            {
                continue;
            }
            ldsfield.clearSelections();
            clearDependentSpecificsSelection(itemspecific);
            break;
        } while (true);
        ldsfield1 = ldsfield;
        if (ldsfield == null)
        {
            ldsfield1 = new LdsField();
            ldsfield1.id = (new StringBuilder()).append("Listing.Item.ItemSpecific[").append(itemspecific.name).append("]").toString();
            draftSnapshot.selectedItemSpecifics.add(ldsfield1);
        }
        return ldsfield1;
    }

    private boolean isCustom(LdsField ldsfield, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            if (((ItemSpecific)arraylist.next()).name.equals(ldsfield.getIdIndex()))
            {
                return false;
            }
        }

        return true;
    }

    private boolean meetsDependency(String s)
    {
        for (Iterator iterator = draftSnapshot.selectedItemSpecifics.iterator(); iterator.hasNext();)
        {
            LdsField ldsfield = (LdsField)iterator.next();
            if (s.equals(ldsfield.getIdIndex()) && ldsfield.hasSelection())
            {
                return true;
            }
        }

        return false;
    }

    private ArrayList processSpecifics(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        Iterator iterator = arraylist.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ItemSpecific itemspecific = (ItemSpecific)iterator.next();
            arraylist1.add(itemspecific);
            Iterator iterator1 = itemspecific.dependencies.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
            } while (meetsDependency((String)iterator1.next()));
            arraylist1.remove(itemspecific);
        } while (true);
        iterator = draftSnapshot.selectedItemSpecifics.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsField ldsfield = (LdsField)iterator.next();
            if (isCustom(ldsfield, arraylist) && ldsfield.getStringValue() != null)
            {
                ItemSpecific itemspecific1 = new ItemSpecific();
                itemspecific1.maxValues = 1;
                itemspecific1.name = ldsfield.getIdIndex();
                com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue itemspecificvalue = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue();
                itemspecificvalue.name = ldsfield.getStringValue();
                itemspecific1.values.add(itemspecificvalue);
                arraylist1.add(itemspecific1);
            }
        } while (true);
        return arraylist1;
    }

    private void refreshSpecifics()
    {
        requiredContainer.removeAllViews();
        requiredContainer.setVisibility(8);
        getView().findViewById(0x7f100657).setVisibility(8);
        recommendedContainer.removeAllViews();
        recommendedContainer.setVisibility(8);
        getView().findViewById(0x7f10065b).setVisibility(8);
        productContainer.removeAllViews();
        productContainer.setVisibility(8);
        getView().findViewById(0x7f100659).setVisibility(8);
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        ArrayList arraylist = processSpecifics(loadedSpecifics);
        ArrayList arraylist1 = draftSnapshot.selectedItemSpecifics;
        ArrayList arraylist2 = draftSnapshot.productSpecifics;
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ItemSpecific itemspecific = (ItemSpecific)iterator.next();
            Object obj = null;
            Object obj2 = arraylist2.iterator();
            Object obj1;
            do
            {
                obj1 = obj;
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                obj1 = (LdsField)((Iterator) (obj2)).next();
                if (!((LdsField) (obj1)).getIdIndex().equals(itemspecific.name))
                {
                    continue;
                }
                obj = new StringBuilder();
                obj1 = ((LdsField) (obj1)).getSelectedValues().iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    ((StringBuilder) (obj)).append((String)((Iterator) (obj1)).next());
                    if (((Iterator) (obj1)).hasNext())
                    {
                        ((StringBuilder) (obj)).append(", ");
                    }
                } while (true);
                obj1 = ((StringBuilder) (obj)).toString();
                break;
            } while (true);
            Object obj3;
            TextView textview;
            Iterator iterator1;
            if (obj1 != null)
            {
                obj = layoutinflater.inflate(0x7f030207, productContainer, false);
            } else
            if (itemspecific.isRequired())
            {
                obj = layoutinflater.inflate(0x7f030207, requiredContainer, false);
            } else
            {
                obj = layoutinflater.inflate(0x7f030207, recommendedContainer, false);
            }
            if (disabledDependents.contains(itemspecific.name))
            {
                ((View) (obj)).setEnabled(false);
            }
            ((View) (obj)).setTag(itemspecific);
            obj2 = (TextView)((View) (obj)).findViewById(0x7f1000ec);
            textview = (TextView)((View) (obj)).findViewById(0x7f100135);
            ((TextView) (obj2)).setText(itemspecific.name);
            obj3 = "";
            iterator1 = arraylist1.iterator();
            do
            {
                obj2 = obj3;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj2 = (LdsField)iterator1.next();
                if (!((LdsField) (obj2)).getIdIndex().equals(itemspecific.name))
                {
                    continue;
                }
                obj3 = new StringBuilder();
                obj2 = ((LdsField) (obj2)).getSelectedValues().iterator();
                do
                {
                    if (!((Iterator) (obj2)).hasNext())
                    {
                        break;
                    }
                    ((StringBuilder) (obj3)).append((String)((Iterator) (obj2)).next());
                    if (((Iterator) (obj2)).hasNext())
                    {
                        ((StringBuilder) (obj3)).append(", ");
                    }
                } while (true);
                obj2 = ((StringBuilder) (obj3)).toString();
                break;
            } while (true);
            textview.setVisibility(0);
            if (obj1 != null)
            {
                textview.setText(((CharSequence) (obj1)));
                textview.setTextColor(ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010212));
            } else
            if (itemspecific.minValues > 0 && TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                textview.setText(getActivity().getText(0x7f07059e));
                textview.setTextColor(ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010038));
            } else
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                textview.setText(((CharSequence) (obj2)));
                textview.setTextColor(ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010212));
            } else
            {
                textview.setVisibility(8);
            }
            if (obj1 != null)
            {
                flag2 = true;
                productContainer.addView(((View) (obj)));
                ((View) (obj)).setOnClickListener(this);
                ((View) (obj)).setClickable(false);
                ((View) (obj)).setEnabled(false);
            } else
            if (itemspecific.isRequired())
            {
                flag = true;
                requiredContainer.addView(((View) (obj)));
                ((View) (obj)).setOnClickListener(this);
            } else
            {
                flag1 = true;
                recommendedContainer.addView(((View) (obj)));
                ((View) (obj)).setOnClickListener(this);
            }
        } while (true);
        if (flag || flag1 || flag2)
        {
            emptyView.setVisibility(8);
            if (flag)
            {
                requiredContainer.setVisibility(0);
                getView().findViewById(0x7f100657).setVisibility(0);
            }
            if (flag1)
            {
                recommendedContainer.setVisibility(0);
                getView().findViewById(0x7f10065b).setVisibility(0);
            }
            if (flag2)
            {
                productContainer.setVisibility(0);
                getView().findViewById(0x7f100659).setVisibility(0);
            }
            return;
        } else
        {
            emptyView.setVisibility(0);
            loadingView.setVisibility(8);
            return;
        }
    }

    private void saveSingleSelectValue(int i, ItemSpecific itemspecific, ItemSpecificsValueProcessor itemspecificsvalueprocessor)
    {
        LdsField ldsfield1 = null;
        Iterator iterator = draftSnapshot.selectedItemSpecifics.iterator();
        LdsField ldsfield;
        do
        {
            ldsfield = ldsfield1;
            if (!iterator.hasNext())
            {
                break;
            }
            ldsfield = (LdsField)iterator.next();
            if (!ldsfield.getIdIndex().equals(itemspecific.name))
            {
                continue;
            }
            ldsfield.clearSelections();
            clearDependentSpecificsSelection(itemspecific);
            break;
        } while (true);
        if (!itemspecific.isRequired() && i == 0)
        {
            return;
        }
        ldsfield1 = ldsfield;
        if (ldsfield == null)
        {
            ldsfield1 = new LdsField();
            ldsfield1.id = (new StringBuilder()).append("Listing.Item.ItemSpecific[").append(itemspecific.name).append("]").toString();
            draftSnapshot.selectedItemSpecifics.add(ldsfield1);
        }
        ldsfield1.replaceSelectedValue(((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)itemspecificsvalueprocessor.values.get(i)).name);
    }

    protected int getLayoutResource()
    {
        return 0x7f030208;
    }

    public int getTitleRes()
    {
        return 0x7f070554;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
    }

    public void onClick(View view)
    {
        view = (ItemSpecific)view.getTag();
        FragmentManager fragmentmanager = getFragmentManager();
        ItemSpecificsDialogFragment itemspecificsdialogfragment = new ItemSpecificsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_id", 0);
        bundle.putParcelableArrayList("selected_specifics", draftSnapshot.selectedItemSpecifics);
        bundle.putParcelable("specifics", view);
        itemspecificsdialogfragment.setArguments(bundle);
        itemspecificsdialogfragment.show(fragmentmanager, "specificsDialog");
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (!listingdraftcontent.getStatus().hasError())
        {
            draftSnapshot = (ListingDraft)listingdraftcontent.getData();
            if (firstLoad)
            {
                firstLoad = false;
                disabledDependents.clear();
                if (listingdraftcontent.itemSpecificsForCategory == null)
                {
                    loadedSpecifics = new ArrayList();
                } else
                {
                    loadedSpecifics = new ArrayList(listingdraftcontent.itemSpecificsForCategory);
                }
                refreshSpecifics();
                loadingView.setVisibility(8);
                listingdraftdatamanager.clearSpecificsGuidanceFlag();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        dm = (ListingDraftDataManager)getDataManagerContainer().initialize(datamanagercontainer, this);
    }

    public void onPause()
    {
        ContentSyncManager.unregister(this, new String[] {
            com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName()
        });
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ContentSyncManager.register(this, new String[] {
            com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName()
        });
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingItemSpecifics");
        if (draftSnapshot == null)
        {
            DialogFragment dialogfragment = (DialogFragment)getFragmentManager().findFragmentByTag("specificsDialog");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        loadingView = view.findViewById(0x7f100655);
        emptyView = view.findViewById(0x1020004);
        requiredContainer = (ContainerLayout)view.findViewById(0x7f100658);
        productContainer = (ContainerLayout)view.findViewById(0x7f10065a);
        recommendedContainer = (ContainerLayout)view.findViewById(0x7f10065c);
        ((LinearLayout)view.findViewById(0x7f100656)).setMotionEventSplittingEnabled(false);
        requiredContainer.setMotionEventSplittingEnabled(false);
        productContainer.setMotionEventSplittingEnabled(false);
        recommendedContainer.setMotionEventSplittingEnabled(false);
        emptyView.setVisibility(8);
        loadingView.setVisibility(0);
    }

    void saveCustomValue(String s, ItemSpecific itemspecific)
    {
        initializeFieldForSpecific(itemspecific).replaceSelectedValue(s);
    }

    void saveMultiSelectValues(ItemSpecificsValueProcessor itemspecificsvalueprocessor, ItemSpecific itemspecific, boolean aflag[])
    {
        itemspecific = initializeFieldForSpecific(itemspecific);
        for (int i = 0; i < aflag.length; i++)
        {
            if (aflag[i])
            {
                itemspecific.addSelectedValue(((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)itemspecificsvalueprocessor.values.get(i)).name);
            }
        }

    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (flag)
        {
            dm.validateDraft();
        }
    }

    public void updateContent(String s, Object obj)
    {
        if (!s.equals(com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName())) goto _L2; else goto _L1
_L1:
        s = (ItemSpecificsDialogData)obj;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$sell$ItemSpecificsSpokeFragment$ItemSpecificsDialogAction[];

            static 
            {
                $SwitchMap$com$ebay$mobile$sell$ItemSpecificsSpokeFragment$ItemSpecificsDialogAction = new int[ItemSpecificsDialogAction.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ItemSpecificsSpokeFragment$ItemSpecificsDialogAction[ItemSpecificsDialogAction.SAVE_SINGLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ItemSpecificsSpokeFragment$ItemSpecificsDialogAction[ItemSpecificsDialogAction.SAVE_MULTIPLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ItemSpecificsSpokeFragment$ItemSpecificsDialogAction[ItemSpecificsDialogAction.SAVE_CUSTOM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.sell.ItemSpecificsSpokeFragment.ItemSpecificsDialogAction[((ItemSpecificsDialogData) (s)).action.ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 57
    //                   2 92
    //                   3 127;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        saveSingleSelectValue(((ItemSpecificsDialogData) (s)).which, ((ItemSpecificsDialogData) (s)).specifics, ((ItemSpecificsDialogData) (s)).processor);
        refreshSpecifics();
        dm.updateItemSpecificSelections(draftSnapshot.selectedItemSpecifics);
        return;
_L4:
        saveMultiSelectValues(((ItemSpecificsDialogData) (s)).processor, ((ItemSpecificsDialogData) (s)).specifics, ((ItemSpecificsDialogData) (s)).checkedSpecificOptions);
        refreshSpecifics();
        dm.updateItemSpecificSelections(draftSnapshot.selectedItemSpecifics);
        return;
_L5:
        saveCustomValue(((ItemSpecificsDialogData) (s)).customValue, ((ItemSpecificsDialogData) (s)).specifics);
        refreshSpecifics();
        dm.updateItemSpecificSelections(draftSnapshot.selectedItemSpecifics);
        return;
    }
}
