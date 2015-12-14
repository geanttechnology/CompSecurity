// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Context;
import java.io.IOException;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory

public static abstract class 
{

    public final String download(Context context, long l)
        throws IOException, AssertionError
    {
        return download(context, l, true);
    }

    public abstract String download(Context context, long l, boolean flag)
        throws IOException, AssertionError;

    public ()
    {
    }
}
