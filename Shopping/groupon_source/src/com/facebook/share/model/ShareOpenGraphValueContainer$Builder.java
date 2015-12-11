// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;

// Referenced classes of package com.facebook.share.model:
//            ShareOpenGraphValueContainer

public static abstract class bundle
{

    private Bundle bundle;

    public bundle putString(String s, String s1)
    {
        bundle.putString(s, s1);
        return this;
    }

    public bundle readFrom(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
    {
        if (shareopengraphvaluecontainer != null)
        {
            bundle.putAll(shareopengraphvaluecontainer.getBundle());
        }
        return this;
    }


    public ()
    {
        bundle = new Bundle();
    }
}
