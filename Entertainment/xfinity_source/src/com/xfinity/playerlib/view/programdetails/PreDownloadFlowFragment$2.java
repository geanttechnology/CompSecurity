// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls0
    implements android.content.istener
{

    final PreDownloadFlowFragment this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        abortFlow();
    }

    I()
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
    }
}
