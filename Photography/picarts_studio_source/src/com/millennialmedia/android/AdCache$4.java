// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.ObjectInputStream;
import java.util.Date;

// Referenced classes of package com.millennialmedia.android:
//            AdCache, CachedAd, MMLog

final class erator extends erator
{

    final boolean a(String s, Date date, ObjectInputStream objectinputstream)
    {
        if (date != null && date.getTime() <= System.currentTimeMillis())
        {
            try
            {
                MMLog.e("AdCache", String.format("Deleting expired ad %s.", new Object[] {
                    ((CachedAd)objectinputstream.readObject()).getId()
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Date date)
            {
                MMLog.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
                    s
                }), date);
                return true;
            }
        }
        return true;
    }

    erator()
    {
    }
}
