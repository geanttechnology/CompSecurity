// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p.a;

import android.content.ContentResolver;
import android.database.Cursor;

// Referenced classes of package com.shazam.android.p.a:
//            g, c

public final class e
    implements g
{

    private final c a;
    private final ContentResolver b;

    public e(ContentResolver contentresolver, c c1)
    {
        a = c1;
        b = contentresolver;
    }

    public final String a()
    {
        Object obj = (new android.net.Uri.Builder()).scheme("content").authority("com.shazam.android.preloadinfo.provider").appendPath("channel").build();
        if (!a.a("com.shazam.android.preloadinfo.provider")) goto _L2; else goto _L1
_L1:
        Cursor cursor = b.query(((android.net.Uri) (obj)), null, null, null, null);
        if (cursor == null) goto _L2; else goto _L3
_L3:
        if (!cursor.moveToFirst()) goto _L5; else goto _L4
_L4:
        obj = cursor.getString(0);
_L7:
        try
        {
            cursor.close();
        }
        catch (SecurityException securityexception)
        {
            return ((String) (obj));
        }
        return ((String) (obj));
        obj;
        try
        {
            cursor.close();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
_L2:
        return null;
_L5:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
