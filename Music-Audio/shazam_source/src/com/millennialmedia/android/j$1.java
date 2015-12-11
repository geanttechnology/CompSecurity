// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            j, VideoAd, r

final class <init> extends <init>
{

    final Context a;
    final JSONArray b;
    final j c;

    final boolean a(r r1)
    {
        if ((r1 instanceof VideoAd) && r1.c(a) && !r1.a())
        {
            b.put(r1.a);
        }
        return true;
    }

    oAd(j j1, Context context, JSONArray jsonarray)
    {
        c = j1;
        a = context;
        b = jsonarray;
        super();
    }
}
