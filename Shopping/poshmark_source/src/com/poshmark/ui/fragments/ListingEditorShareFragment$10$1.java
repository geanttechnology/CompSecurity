// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.ListingManager;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment, PartyGuidelinesFragment

class val.partyEvent
    implements android.content.ment._cls10._cls1
{

    final val.partyEvent this$1;
    final PartyEvent val$partyEvent;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, val$partyEvent);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$partyEvent = PartyEvent.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingEditorShareFragment$10

/* anonymous class */
    class ListingEditorShareFragment._cls10
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ListingEditorShareFragment this$0;

        public void onCheckedChanged(final CompoundButton partySwitch, boolean flag)
        {
            String s;
label0:
            {
label1:
                {
                    partySwitch = (Switch)partySwitch;
                    s = (String)partySwitch.getTag();
                    Object obj = GlobalPartiesController.getGlobalPartiesController();
                    List list = ((GlobalPartiesController) (obj)).getCurrentParties();
                    if (!partySwitch.isChecked())
                    {
                        break label0;
                    }
                    if (list != null && list.size() > 0)
                    {
                        obj = ((GlobalPartiesController) (obj)).getParty(s);
                        if (((PartyEvent) (obj)).isListingEligibleForParty(ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).getNewListing()))
                        {
                            break label1;
                        }
                        String s1 = String.format(new String(getString(0x7f060149)), new Object[] {
                            ((PartyEvent) (obj)).getTitle()
                        });
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
                        builder.setIcon(0x1080027);
                        builder.setTitle(getString(0x7f0600d0));
                        builder.setMessage(s1);
                        builder.setPositiveButton(getString(0x7f0602be), ((ListingEditorShareFragment._cls10._cls1) (obj)). new ListingEditorShareFragment._cls10._cls1());
                        builder.setNegativeButton(getString(0x7f0601e1), new ListingEditorShareFragment._cls10._cls2());
                        builder.show();
                        partySwitch.performClick();
                        partySwitch.setChecked(false);
                        ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).removeEventId(s);
                    }
                    return;
                }
                ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).addEventId(s);
                return;
            }
            ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).removeEventId(s);
        }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/ListingEditorShareFragment$10$2

/* anonymous class */
        class ListingEditorShareFragment._cls10._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ListingEditorShareFragment._cls10 this$1;
            final Switch val$partySwitch;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                partySwitch.setChecked(false);
            }

                    
                    {
                        this$1 = ListingEditorShareFragment._cls10.this;
                        partySwitch = switch1;
                        super();
                    }
        }

    }

}
