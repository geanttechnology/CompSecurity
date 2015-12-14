// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content;

import android.net.Uri;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.library.content:
//            SessionDatabaseHelper

public static final class creationTime
{

    public final long creationTime;
    public final Uri data;
    public final long id;
    public final int megapixels;
    public final int orientation;

    public String toString()
    {
        return String.format(Locale.US, "SessionWrapper{id: %d, data: %s, mp: %d, orientation: %d, time: %d", new Object[] {
            Long.valueOf(id), data, Integer.valueOf(megapixels), Integer.valueOf(orientation), Long.valueOf(creationTime)
        });
    }

    public (long l, Uri uri, int i, int j, long l1)
    {
        id = l;
        data = uri;
        megapixels = i;
        orientation = j;
        creationTime = l1;
    }
}
