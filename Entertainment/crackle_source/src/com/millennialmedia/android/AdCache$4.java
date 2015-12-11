// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.ObjectInputStream;
import java.util.Date;

// Referenced classes of package com.millennialmedia.android:
//            AdCache, CachedAd

static final class erator extends erator
{

    final Context val$context;

    boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
    {
        if (date != null && date.getTime() <= System.currentTimeMillis())
        {
            try
            {
                date = (CachedAd)objectinputstream.readObject();
                d("Deleting expired ad %s.", new Object[] {
                    date.getId()
                });
                date.delete(val$context);
            }
            // Misplaced declaration of an exception variable
            catch (Date date)
            {
                d("There was a problem reading the cached ad %s.", new Object[] {
                    s
                });
                d(date);
                return true;
            }
        }
        return true;
    }

    erator(Context context1)
    {
        val$context = context1;
        super();
    }
}
