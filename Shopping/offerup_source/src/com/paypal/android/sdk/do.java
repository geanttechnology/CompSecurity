// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashMap;

final class do extends HashMap
{

    do()
    {
        put(Integer.valueOf(2), "ANDROIDCDMA_PHONE");
        put(Integer.valueOf(1), "ANDROIDGSM_PHONE");
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            put(Integer.valueOf(3), "ANDROIDGSM_UNDEFINED");
        }
        put(Integer.valueOf(0), "ANDROIDGSM_UNDEFINED");
    }
}
