// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class os
    implements Runnable
{

    final AkActivity this$0;
    final com.digidust.elokence.akinator.db..DefiInfos val$infos;

    public void run()
    {
        View view = getLayoutInflater().inflate(0x7f03004f, null);
        Object obj = (TextView)view.findViewById(0x7f0d021d);
        ((TextView) (obj)).setTypeface(AkApplication.getTypeFace());
        ((TextView) (obj)).setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TITRE"));
        obj = (TextView)view.findViewById(0x7f0d00cf);
        ((TextView) (obj)).setTypeface(AkApplication.getTypeFace());
        ((TextView) (obj)).setText(val$infos.getTitle());
        obj = new Toast(getApplicationContext());
        ((Toast) (obj)).setGravity(49, 0, 0);
        ((Toast) (obj)).setDuration(1);
        ((Toast) (obj)).setView(view);
        ((Toast) (obj)).show();
    }

    os()
    {
        this$0 = final_akactivity;
        val$infos = com.digidust.elokence.akinator.db..DefiInfos.this;
        super();
    }
}
