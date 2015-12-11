// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.deeplink;

import android.net.Uri;

// Referenced classes of package com.shazam.android.activities.deeplink:
//            a

public final class b
    implements a
{

    public b()
    {
    }

    public final transient boolean a(Uri auri[])
    {
        boolean flag1 = false;
        int j = auri.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    Uri uri = auri[i];
                    if (uri == null || !uri.isHierarchical() || !uri.getBooleanQueryParameter("launchedfromdeeplink", false))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }
}
