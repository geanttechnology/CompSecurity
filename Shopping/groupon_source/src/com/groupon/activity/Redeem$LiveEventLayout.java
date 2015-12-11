// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.groupon.db.models.mygroupons.MyGrouponItem;

// Referenced classes of package com.groupon.activity:
//            Redeem

public class  extends 
{

    final Redeem this$0;

    public void onCreate(Bundle bundle)
    {
        setContentView(0x7f0301db);
    }

    public void refresh()
    {
        event.setText(Redeem.access$000(Redeem.this).ticketEvent);
        account.setText(Redeem.access$000(Redeem.this).ticketAccount);
        moreInfo.setText(Redeem.access$000(Redeem.this).ticketEntrance);
        section.setText(Redeem.access$000(Redeem.this).ticketSection);
        row.setText(Redeem.access$000(Redeem.this).ticketRow);
        seat.setText(Redeem.access$000(Redeem.this).ticketSeat);
    }

    public em()
    {
        this$0 = Redeem.this;
        super(Redeem.this);
    }
}
