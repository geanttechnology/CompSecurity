// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            LenticularHelper

class this._cls0
    implements FilenameFilter
{

    final LenticularHelper this$0;

    public boolean accept(File file, String s)
    {
        file = s.toLowerCase();
        return file.endsWith(".jpeg") || file.endsWith(".jpg");
    }

    ()
    {
        this$0 = LenticularHelper.this;
        super();
    }
}
