// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.AsyncTask;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTV, SmartTVDiscovery

class this._cls0 extends AsyncTask
{

    final SmartTV this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!SmartTV.access$100(SmartTV.this))
        {
            SmartTV.access$200(SmartTV.this).init();
            SmartTV.access$102(SmartTV.this, true);
        }
        SmartTV.access$200(SmartTV.this).search();
        return null;
    }

    ()
    {
        this$0 = SmartTV.this;
        super();
    }
}
