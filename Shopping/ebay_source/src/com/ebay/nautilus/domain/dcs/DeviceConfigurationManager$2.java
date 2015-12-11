// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.os.AsyncTask;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfigurationManager

class this._cls0 extends AsyncTask
{

    final DeviceConfigurationManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((operties[])aobj);
    }

    protected transient Void doInBackground(operties aoperties[])
    {
        updateSynchronously(aoperties[0]);
        return null;
    }

    operties()
    {
        this$0 = DeviceConfigurationManager.this;
        super();
    }
}
