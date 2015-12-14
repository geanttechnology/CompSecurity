// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapperAbstract

class this._cls0 extends ContentObserver
{

    final AviaryStoreWrapperAbstract this$0;

    public void onChange(boolean flag)
    {
        onChange(flag, null);
    }

    public void onChange(boolean flag, Uri uri)
    {
        AviaryStoreWrapperAbstract.logger.gger("mServiceFinishedContentObserver::onChange");
        if (isActive())
        {
            AviaryStoreWrapperAbstract.access$000(AviaryStoreWrapperAbstract.this).onServiceFinished();
        }
    }

    llback(Handler handler)
    {
        this$0 = AviaryStoreWrapperAbstract.this;
        super(handler);
    }
}
