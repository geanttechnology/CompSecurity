// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import java.io.FileInputStream;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig

class this._cls0
    implements this._cls0
{

    final CvConfig this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        obj = CvConfig.access$100(CvConfig.this).openFileInput(getConfigFilename());
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            int i = ((FileInputStream) (obj)).read();
            if (i != -1)
            {
                stringbuilder.append((char)i);
            } else
            {
                ((FileInputStream) (obj)).close();
                _pcls0.esolve(stringbuilder.toString());
                return;
            }
        } while (true);
    }

    ()
    {
        this$0 = CvConfig.this;
        super();
    }
}
