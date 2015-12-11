// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bb, ad

class a extends AsyncTask
{

    final bb a;

    protected transient Void a(bb abb[])
    {
        if (abb.length > 0)
        {
            abb = abb[0];
            if (abb != null)
            {
                try
                {
                    abb.a();
                }
                // Misplaced declaration of an exception variable
                catch (bb abb[])
                {
                    ad.a(abb);
                }
            }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((bb[])aobj);
    }

    (bb bb1)
    {
        a = bb1;
        super();
    }
}
