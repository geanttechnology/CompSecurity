// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Groupon, IntentFactory

class this._cls0
    implements android.view.kListener
{

    final Groupon this$0;

    public void onClick(View view)
    {
        view = Groupon.access$000(Groupon.this).dealId;
        String s = Groupon.access$000(Groupon.this).dealOptionId;
        if (Strings.notEmpty(view))
        {
            if (Strings.notEmpty(s))
            {
                view = Groupon.access$500(Groupon.this).newDealIntentWithOption(view, s, true);
            } else
            {
                view = Groupon.access$500(Groupon.this).newDealIntent(view, null, false, true);
            }
            startActivity(view);
        }
    }

    ry()
    {
        this$0 = Groupon.this;
        super();
    }
}
