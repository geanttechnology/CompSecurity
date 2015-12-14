// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.aviary;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.gallery.thor.aviary:
//            ThorLaunchAviary

public class FreetimeLaunchAviary extends ThorLaunchAviary
{

    public FreetimeLaunchAviary(Context context)
    {
        super(context);
    }

    protected void setOptionalExtras(Intent intent)
    {
        intent.putExtra("tools-list", new String[] {
            "CROP", "ORIENTATION", "STICKERS", "TEXT", "DRAW"
        });
    }
}
