// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import android.content.DialogInterface;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class val.e
    implements android.content.stener
{

    final DownloadServiceManager this$0;
    final Exception val$e;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        throw new RuntimeException(val$e);
    }

    ()
    {
        this$0 = final_downloadservicemanager;
        val$e = Exception.this;
        super();
    }
}
