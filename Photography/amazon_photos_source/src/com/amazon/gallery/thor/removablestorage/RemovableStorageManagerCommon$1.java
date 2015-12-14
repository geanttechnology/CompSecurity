// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            RemovableStorageManagerCommon

class this._cls0 extends BroadcastReceiver
{

    final RemovableStorageManagerCommon this$0;

    public void onReceive(Context context, Intent intent)
    {
        RemovableStorageManagerCommon.access$002(RemovableStorageManagerCommon.this, RemovableStorageManagerCommon.access$100());
        if (isFileOnRemovableStorage(Uri.parse(intent.getDataString())))
        {
            RemovableStorageManagerCommon.access$200(RemovableStorageManagerCommon.this);
        }
    }

    ()
    {
        this$0 = RemovableStorageManagerCommon.this;
        super();
    }
}
