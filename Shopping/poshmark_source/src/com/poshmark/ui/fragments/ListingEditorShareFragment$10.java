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

class this._cls0
    implements android.widget.Listener
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
                final PartyEvent partyEvent = GlobalPartiesController.getGlobalPartiesController();
                List list = partyEvent.getCurrentParties();
                if (!partySwitch.isChecked())
                {
                    break label0;
                }
                if (list != null && list.size() > 0)
                {
                    partyEvent = partyEvent.getParty(s);
                    if (partyEvent.isListingEligibleForParty(ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).getNewListing()))
                    {
                        break label1;
                    }
                    String s1 = String.format(new String(getString(0x7f060149)), new Object[] {
                        partyEvent.getTitle()
                    });
                    android.app.reFragment refragment = new android.app.getTitle(getActivity());
                    refragment.getActivity(0x1080027);
                    refragment.getActivity(getString(0x7f0600d0));
                    refragment.(s1);
                    refragment.eButton(getString(0x7f0602be), new android.content.DialogInterface.OnClickListener() {

                        final ListingEditorShareFragment._cls10 this$1;
                        final PartyEvent val$partyEvent;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, partyEvent);
                        }

            
            {
                this$1 = ListingEditorShareFragment._cls10.this;
                partyEvent = partyevent;
                super();
            }
                    });
                    refragment.eButton(getString(0x7f0601e1), new android.content.DialogInterface.OnClickListener() {

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
                    });
                    refragment._mth10();
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

    _cls2.val.partySwitch()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
