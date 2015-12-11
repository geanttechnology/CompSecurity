// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import android.content.Context;
import android.content.Intent;
import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            j

public final class b
    implements j
{

    private final Context a;
    private int b;

    public b(Context context)
    {
        a = context;
        b = 0;
    }

    public final void a(Tag tag)
    {
        tag = new Intent("com.shazam.android.intent.actions.UNSUBMITTED_TAG_MATCHED");
        a.sendOrderedBroadcast(tag, null);
    }

    public final void b(Tag tag)
    {
        tag = new Intent("com.shazam.android.intent.actions.UNSUBMITTED_TAG_NOT_MATCHED");
        int i = b + 1;
        b = i;
        tag.putExtra("NumNoMatches", i);
        a.sendOrderedBroadcast(tag, null);
    }
}
