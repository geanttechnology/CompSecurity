// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.util.Log;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import java.text.MessageFormat;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            n

public class e
{

    private static final String a = com/smule/pianoandroid/magicpiano/e.getName();

    public e()
    {
    }

    public static Dialog a(Activity activity, ListingV2 listingv2, Runnable runnable)
    {
        if (listingv2 == null || listingv2.song == null)
        {
            Log.e(a, "empty listing or product!");
        }
        String s1 = listingv2.song.title;
        String s;
        if (listingv2.b())
        {
            s = activity.getString(0x7f0c01c7);
        } else
        {
            s = null;
        }
        return n.a(activity, 0x7f020120, s1, s, MessageFormat.format(activity.getResources().getString(0x7f0c00f9), new Object[] {
            Integer.valueOf(listingv2.price)
        }), activity.getString(0x7f0c01a9), activity.getString(0x7f0c02e5), null, runnable);
    }

}
