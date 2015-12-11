// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.ebay.common.DevLogicException;
import com.ebay.mobile.activities.BaseDialogFragment;
import com.ebay.mobile.sell.util.ItemSpecificsValueProcessor;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.data.ItemSpecific;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemSpecificsDialogFragment extends BaseDialogFragment
{

    public ItemSpecificsDialogFragment()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        getDialog().dismiss();
    }

    public Dialog onCreateDialog(final Bundle specifics)
    {
        switch (getArguments().getInt("dialog_id"))
        {
        default:
            throw new DevLogicException("Unknown dialog type.");

        case 0: // '\0'
            specifics = (ItemSpecific)getArguments().getParcelable("specifics");
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
            builder.setTitle(((ItemSpecific) (specifics)).name);
            final ItemSpecificsValueProcessor processor = getArguments().getParcelableArrayList("selected_specifics");
            processor = new ItemSpecificsValueProcessor(getActivity(), specifics, processor);
            CharSequence acharsequence[] = processor.stringValues;
            if (((ItemSpecific) (specifics)).maxValues > 1)
            {
                final boolean checkedSpecificOptions[] = new boolean[processor.values.size()];
                for (Iterator iterator = processor.selectedPositions.iterator(); iterator.hasNext();)
                {
                    checkedSpecificOptions[((Integer)iterator.next()).intValue()] = true;
                }

                builder.setMultiChoiceItems(acharsequence, checkedSpecificOptions, new android.content.DialogInterface.OnMultiChoiceClickListener() {

                    final ItemSpecificsDialogFragment this$0;
                    final boolean val$checkedSpecificOptions[];

                    public void onClick(DialogInterface dialoginterface, int j, boolean flag)
                    {
                        checkedSpecificOptions[j] = flag;
                    }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                checkedSpecificOptions = aflag;
                super();
            }
                });
                builder.setNegativeButton(getResources().getString(0x7f0701cc), new android.content.DialogInterface.OnClickListener() {

                    final ItemSpecificsDialogFragment this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        getDialog().dismiss();
                    }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                super();
            }
                });
                builder.setPositiveButton(getResources().getString(0x7f070738), new android.content.DialogInterface.OnClickListener() {

                    final ItemSpecificsDialogFragment this$0;
                    final boolean val$checkedSpecificOptions[];
                    final ItemSpecificsValueProcessor val$processor;
                    final ItemSpecific val$specifics;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        getDialog().dismiss();
                        dialoginterface = new ItemSpecificsSpokeFragment.ItemSpecificsDialogData(ItemSpecificsSpokeFragment.ItemSpecificsDialogAction.SAVE_MULTIPLE);
                        dialoginterface.specifics = specifics;
                        dialoginterface.processor = processor;
                        dialoginterface.checkedSpecificOptions = checkedSpecificOptions;
                        ContentSyncManager.notifyUpdate(dialoginterface, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
                    }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                specifics = itemspecific;
                processor = itemspecificsvalueprocessor;
                checkedSpecificOptions = aflag;
                super();
            }
                });
            } else
            {
                int i = -1;
                if (!processor.selectedPositions.isEmpty())
                {
                    i = ((Integer)processor.selectedPositions.get(0)).intValue();
                }
                builder.setSingleChoiceItems(acharsequence, i, new android.content.DialogInterface.OnClickListener() {

                    final ItemSpecificsDialogFragment this$0;
                    final ItemSpecificsValueProcessor val$processor;
                    final ItemSpecific val$specifics;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        getDialog().dismiss();
                        if (((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)processor.values.get(j)).custom)
                        {
                            dialoginterface = new ItemSpecificsDialogFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("dialog_id", 1);
                            bundle.putParcelable("specifics", specifics);
                            dialoginterface.setArguments(bundle);
                            dialoginterface.show(getFragmentManager(), "specificsDialog");
                            return;
                        } else
                        {
                            dialoginterface = new ItemSpecificsSpokeFragment.ItemSpecificsDialogData(ItemSpecificsSpokeFragment.ItemSpecificsDialogAction.SAVE_SINGLE);
                            dialoginterface.which = j;
                            dialoginterface.specifics = specifics;
                            dialoginterface.processor = processor;
                            ContentSyncManager.notifyUpdate(dialoginterface, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
                            return;
                        }
                    }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                processor = itemspecificsvalueprocessor;
                specifics = itemspecific;
                super();
            }
                });
            }
            return builder.create();

        case 1: // '\001'
            specifics = new android.support.v7.app.AlertDialog.Builder(getActivity());
            final ItemSpecific specific = (ItemSpecific)getArguments().getParcelable("specifics");
            specifics.setTitle(specific.name);
            specifics.setNegativeButton(getResources().getString(0x7f0701cc), new android.content.DialogInterface.OnClickListener() {

                final ItemSpecificsDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                super();
            }
            });
            specifics.setPositiveButton(getResources().getString(0x7f070738), new android.content.DialogInterface.OnClickListener() {

                final ItemSpecificsDialogFragment this$0;
                final ItemSpecific val$specific;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    dialoginterface = ((EditText)getDialog().findViewById(0x7f100641)).getText().toString();
                    ItemSpecificsSpokeFragment.ItemSpecificsDialogData itemspecificsdialogdata = new ItemSpecificsSpokeFragment.ItemSpecificsDialogData(ItemSpecificsSpokeFragment.ItemSpecificsDialogAction.SAVE_CUSTOM);
                    itemspecificsdialogdata.customValue = dialoginterface;
                    itemspecificsdialogdata.specifics = specific;
                    ContentSyncManager.notifyUpdate(itemspecificsdialogdata, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
                }

            
            {
                this$0 = ItemSpecificsDialogFragment.this;
                specific = itemspecific;
                super();
            }
            });
            specifics.setView(getActivity().getLayoutInflater().inflate(0x7f0301fe, null));
            return specifics.create();
        }
    }
}
