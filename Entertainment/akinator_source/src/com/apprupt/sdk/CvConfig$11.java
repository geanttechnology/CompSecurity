// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import java.io.FileOutputStream;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig, SimpleJSON

class this._cls0
    implements this._cls0
{

    final CvConfig this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        obj = (SimpleJSON)obj;
        try
        {
            FileOutputStream fileoutputstream = CvConfig.access$100(CvConfig.this).openFileOutput(getConfigFilename(), 0);
            fileoutputstream.write(((SimpleJSON) (obj)).toString().getBytes());
            fileoutputstream.close();
        }
        catch (Exception exception)
        {
            CvConfig.access$000(CvConfig.this).(new Object[] {
                "Cannot write config file, skipping"
            });
        }
        _pcls0.esolve(obj);
    }

    ()
    {
        this$0 = CvConfig.this;
        super();
    }
}
