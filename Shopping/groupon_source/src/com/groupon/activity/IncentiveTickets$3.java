// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            IncentiveTickets

class this._cls0
    implements android.widget.lickListener
{

    final IncentiveTickets this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
label0:
        {
            if (isComingFromCheckout.booleanValue())
            {
                if (isUsingGiftCodes == null || !isUsingGiftCodes.booleanValue())
                {
                    break label0;
                }
                adapterview = new GrouponDialogFragment();
                view = new Bundle();
                view.putInt("dialog_title_res_id", 0x7f080315);
                view.putInt("dialog_message_res_id", 0x7f080316);
                view.putInt("dialog_positive_button_text_res_id", 0x7f080426);
                view.putInt("dialog_negative_button_text_res_id", 0x7f0802a6);
                view.putInt("selected_ticket_position", i);
                adapterview.setArguments(view);
                adapterview.setCancelable(false);
                GrouponDialogFragment.show(getFragmentManager(), adapterview, "incentive_tickets_remove");
            }
            return;
        }
        IncentiveTickets.access$400(IncentiveTickets.this, i, false);
    }

    stener()
    {
        this$0 = IncentiveTickets.this;
        super();
    }
}
