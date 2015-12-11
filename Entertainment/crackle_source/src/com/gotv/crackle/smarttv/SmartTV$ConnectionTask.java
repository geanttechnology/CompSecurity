// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.AsyncTask;
import org.cybergarage.upnp.Device;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTV, SmartTVConnection

class this._cls0 extends AsyncTask
{

    final SmartTV this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Device[])aobj);
    }

    protected transient Void doInBackground(Device adevice[])
    {
        SmartTV.access$000(SmartTV.this).connect(adevice[0].getLocation(), adevice[0].getFriendlyName());
        return null;
    }

    ()
    {
        this$0 = SmartTV.this;
        super();
    }
}
