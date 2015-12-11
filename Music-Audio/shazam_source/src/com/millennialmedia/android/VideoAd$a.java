// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            VideoAd, r

private static final class a
    implements FilenameFilter
{

    private WeakReference a;

    public final boolean accept(File file, String s)
    {
        file = (VideoAd)a.get();
        if (file != null)
        {
            file = ((r) (file)).a;
            if (file == null)
            {
                return false;
            } else
            {
                return s.startsWith(file);
            }
        } else
        {
            return false;
        }
    }

    public (VideoAd videoad)
    {
        a = new WeakReference(videoad);
    }
}
