// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.bumptech.glide.load.e;
import myobfuscated.v.ac;
import myobfuscated.v.ae;
import myobfuscated.w.a;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinApiV3

public class StringModelLoader extends a
{

    public StringModelLoader(ae ae, ac ac)
    {
        super(ae, ac);
    }

    protected volatile String getUrl(Object obj, int i, int j, e e)
    {
        return getUrl((String)obj, i, j, e);
    }

    protected String getUrl(String s, int i, int j, e e)
    {
        return SocialinApiV3.getPhotoURL(s, i, j);
    }

    public volatile boolean handles(Object obj)
    {
        return handles((String)obj);
    }

    public boolean handles(String s)
    {
        return false;
    }
}
