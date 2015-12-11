// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.os.AsyncTask;
import java.io.File;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity

class this._cls0 extends AsyncTask
{

    final ImojiBrowserActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = getExternalCacheDir();
        if (avoid != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((avoid = avoid.listFiles()) != null)
        {
            int j = avoid.length;
            int i = 0;
            while (i < j) 
            {
                Void void1 = avoid[i];
                if (void1.isFile() && void1.getName().endsWith(".png"))
                {
                    void1.delete();
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$0 = ImojiBrowserActivity.this;
        super();
    }
}
