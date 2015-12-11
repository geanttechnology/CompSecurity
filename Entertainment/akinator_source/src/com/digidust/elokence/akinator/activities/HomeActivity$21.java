// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.widget.Toast;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements Runnable
{

    final HomeActivity this$0;

    public void run()
    {
        Toast.makeText(HomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_RESTAURATION_ACHATS"), 1).show();
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
