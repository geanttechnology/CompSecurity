// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import java.io.File;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerFragment

class val.filePath
    implements Runnable
{

    final PhotoManagerFragment this$0;
    final String val$filePath;

    public void run()
    {
        (new File(val$filePath)).delete();
    }

    _cls9()
    {
        this$0 = final_photomanagerfragment;
        val$filePath = String.this;
        super();
    }
}
