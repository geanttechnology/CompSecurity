// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShareFragment

class this._cls0
    implements android.content.nClickListener
{

    final ShareFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.facebook.orca")));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.facebook.orca")));
        }
    }

    ener()
    {
        this$0 = ShareFragment.this;
        super();
    }
}
