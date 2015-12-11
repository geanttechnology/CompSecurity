// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.AsyncTask;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTV, SmartTVConnection

class this._cls0 extends AsyncTask
{

    final SmartTV this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        SmartTV.access$000(SmartTV.this).sendData(as[0]);
        return null;
    }

    ()
    {
        this$0 = SmartTV.this;
        super();
    }
}
