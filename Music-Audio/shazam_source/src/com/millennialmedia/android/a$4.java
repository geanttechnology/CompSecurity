// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.ObjectInputStream;
import java.util.Date;

// Referenced classes of package com.millennialmedia.android:
//            a, r, al

static final class  extends 
{

    final boolean a(String s, Date date, ObjectInputStream objectinputstream)
    {
        if (date != null && date.getTime() <= System.currentTimeMillis())
        {
            try
            {
                al.a("AdCache", String.format("Deleting expired ad %s.", new Object[] {
                    ((r)objectinputstream.readObject()).a
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Date date)
            {
                al.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
                    s
                }), date);
                return true;
            }
        }
        return true;
    }

    ()
    {
    }
}
