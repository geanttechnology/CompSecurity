// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;

// Referenced classes of package com.facebook.share.model:
//            ShareMedia

public static abstract class params
{

    private Bundle params;

    public params readFrom(ShareMedia sharemedia)
    {
        if (sharemedia == null)
        {
            return this;
        } else
        {
            return setParameters(sharemedia.getParameters());
        }
    }

    public eters setParameters(Bundle bundle)
    {
        params.putAll(bundle);
        return this;
    }


    public ()
    {
        params = new Bundle();
    }
}
