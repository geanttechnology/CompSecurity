// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.AsyncTask;
import android.os.Build;

// Referenced classes of package com.livemixtapes:
//            MainActivity

class this._cls0 extends AsyncTask
{

    final MainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!"generic".equals(Build.BRAND.toLowerCase()))
        {
            MainActivity.access$0(MainActivity.this, getApplicationContext());
        }
        return null;
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
