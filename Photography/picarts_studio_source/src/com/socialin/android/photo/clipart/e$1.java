// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.socialin.android.photo.clipart:
//            e

final class 
    implements FilenameFilter
{

    public final boolean accept(File file, String s)
    {
        return (new File((new StringBuilder()).append(file.getPath()).append("/").append(s).toString())).isDirectory() && !"icons".equals(s) && !String.valueOf(SocialinV3.getInstance().getUser().id).equals(s);
    }

    ()
    {
    }
}
