// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.igexin.sdk:
//            SdkService

class this._cls0
    implements FilenameFilter
{

    final SdkService this$0;

    public boolean accept(File file, String s)
    {
        return s.endsWith(".db");
    }

    ()
    {
        this$0 = SdkService.this;
        super();
    }
}
