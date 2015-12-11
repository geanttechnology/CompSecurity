// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.g;

import android.content.Intent;
import com.shazam.android.k.h;
import com.shazam.android.k.i;
import com.shazam.model.store.Store;

public final class e
{

    public static Intent a(Store store, i i)
    {
        Intent intent = store.validIntent;
        if (intent != null)
        {
            return intent;
        } else
        {
            return h.a(store.intents, i);
        }
    }
}
