// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.widget.Toast;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PopPedagogiqueActivity

class this._cls0
    implements Runnable
{

    final PopPedagogiqueActivity this$0;

    public void run()
    {
        Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR_CONNEXION_GOOGLE_PLAY"), 1).show();
    }

    ()
    {
        this$0 = PopPedagogiqueActivity.this;
        super();
    }
}
