// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import com.digidust.elokence.akinator.factories.AkGameFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PostHomeActivity

class this._cls0
    implements android.content.ickListener
{

    final PostHomeActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        AkGameFactory.sharedInstance().disableDiscoverMyWorld();
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = PostHomeActivity.this;
        super();
    }
}
