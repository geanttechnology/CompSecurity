// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.groupon.activity.IntentFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.service:
//            SoftwareUpdateService

class this._cls0
    implements android.content.istener
{

    final SoftwareUpdateService this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SoftwareUpdateService.access$100(SoftwareUpdateService.this).startActivity(((IntentFactory)SoftwareUpdateService.access$000(SoftwareUpdateService.this).get()).newMarketDownloadIntent().addFlags(0x10004000));
    }

    ner()
    {
        this$0 = SoftwareUpdateService.this;
        super();
    }
}
