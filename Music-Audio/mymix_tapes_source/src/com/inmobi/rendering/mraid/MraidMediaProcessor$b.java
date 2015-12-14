// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor

public final class c extends ContentObserver
{

    final MraidMediaProcessor a;
    private Context b;
    private int c;
    private String d;

    public void onChange(boolean flag)
    {
        super.onChange(flag);
        if (b != null)
        {
            int i = ((AudioManager)b.getSystemService("audio")).getStreamVolume(3);
            if (i != c)
            {
                c = i;
                MraidMediaProcessor.a(a, d, i);
            }
        }
    }

    public (MraidMediaProcessor mraidmediaprocessor, String s, Context context, Handler handler)
    {
        a = mraidmediaprocessor;
        super(handler);
        d = s;
        b = context;
        c = -1;
    }
}
