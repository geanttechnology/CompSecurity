// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkGameFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PropositionPotionActivity2

class this._cls0
    implements Runnable
{

    final PropositionPotionActivity2 this$0;

    public void run()
    {
        String s;
        PropositionPotionActivity2.access$200(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getNomInappUltime());
        PropositionPotionActivity2.access$300(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getDescInappUltime());
        PropositionPotionActivity2.access$100(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getPriceInappUltime());
        s = getIntent().getStringExtra("potion");
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals("rayonnante")) goto _L4; else goto _L3
_L3:
        PropositionPotionActivity2.access$000(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getPriceInappNoads());
        PropositionPotionActivity2.access$400(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getDescInappNoads());
_L2:
        PropositionPotionActivity2.access$200(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getNomInappUltime());
        PropositionPotionActivity2.access$300(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getDescInappUltime());
        if (!AkGameFactory.sharedInstance().isPopularityLimited())
        {
            PropositionPotionActivity2.access$500(PropositionPotionActivity2.this);
        }
        if (AkGameFactory.sharedInstance().isUnlocked())
        {
            PropositionPotionActivity2.access$100(PropositionPotionActivity2.this).setBackgroundResource(0x7f0200e9);
            PropositionPotionActivity2.access$100(PropositionPotionActivity2.this).setEnabled(false);
            PropositionPotionActivity2.access$500(PropositionPotionActivity2.this);
        }
        return;
_L4:
        if (s.equals("survitamine"))
        {
            PropositionPotionActivity2.access$000(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getPriceInappPopu());
            PropositionPotionActivity2.access$400(PropositionPotionActivity2.this).setText(AkInappManager.getInstance().getDescInappPopu());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    ()
    {
        this$0 = PropositionPotionActivity2.this;
        super();
    }
}
