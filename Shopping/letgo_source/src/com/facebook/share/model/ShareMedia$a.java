// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;

// Referenced classes of package com.facebook.share.model:
//            ShareMedia

public static abstract class a
{

    private Bundle a;

    static Bundle a(a a1)
    {
        return a1.a;
    }

    public a a(Bundle bundle)
    {
        a.putAll(bundle);
        return this;
    }

    public a a(ShareMedia sharemedia)
    {
        if (sharemedia == null)
        {
            return this;
        } else
        {
            return a(sharemedia.a());
        }
    }

    public ()
    {
        a = new Bundle();
    }
}
