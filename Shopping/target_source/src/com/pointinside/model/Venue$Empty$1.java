// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.pointinside.model:
//            Venue

class this._cls0
    implements FilenameFilter
{

    final tUUID this$0;

    public boolean accept(File file, String s)
    {
        file = tUUID().toLowerCase();
        if (s.length() > 32)
        {
            String s1 = s.substring(0, 32);
            s = s.substring(32, s.length());
            if (s1.equals(file) || s.equals(file))
            {
                return true;
            }
        }
        return false;
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
