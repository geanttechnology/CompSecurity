// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            ProposeAjoutMBActivity, IdentifierPersoMinibaseActivity

class this._cls0
    implements android.view.ies.ProposeAjoutMBActivity._cls3
{

    final ProposeAjoutMBActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ProposeAjoutMBActivity.this, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
        byte byte0;
        if (perdu)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        view.putExtra("ActivityMode", byte0);
        startActivity(view);
        finish();
    }

    tivity()
    {
        this$0 = ProposeAjoutMBActivity.this;
        super();
    }
}
