// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.groupon.db.models:
//            Card

public class UnsupportedCard extends Card
{

    private static final String TAG = "UNSUPPORTED_CARD_TYPE";

    public UnsupportedCard()
    {
        Log.d("UNSUPPORTED_CARD_TYPE", "Card type is unsupported!  Check RAPI response for details");
    }

    public void save(String s, Context context, int i, int j)
    {
    }

    public boolean skipWhenCalculatingTrackingPosition()
    {
        return true;
    }
}
