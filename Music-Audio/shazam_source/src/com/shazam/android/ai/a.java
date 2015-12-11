// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ai;

import android.content.Context;
import com.moodstocks.android.MoodstocksError;
import com.moodstocks.android.Scanner;
import com.shazam.android.persistence.n.b;
import com.shazam.model.visual.moodstocks.MoodstocksApiInfo;
import java.io.IOException;

// Referenced classes of package com.shazam.android.ai:
//            b

public final class a
    implements com.shazam.android.ai.b
{

    private final Context a;
    private final b b;

    public a(Context context, b b1)
    {
        a = context;
        b = b1;
    }

    public final boolean a(Scanner scanner, MoodstocksApiInfo moodstocksapiinfo)
    {
        if (b.b("pk_moodstocks_bundle_loaded"))
        {
            return true;
        }
        String s = moodstocksapiinfo.bundle;
        if (!com.shazam.b.e.a.c(s))
        {
            break MISSING_BLOCK_LABEL_70;
        }
        s = String.format("ms-%s.bundle", new Object[] {
            s
        });
        scanner.importBundle(a, moodstocksapiinfo.apiKey, s);
        b.b("pk_moodstocks_bundle_loaded", true);
        return true;
        scanner;
_L2:
        return false;
        scanner;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
