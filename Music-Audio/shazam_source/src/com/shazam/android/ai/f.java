// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ai;

import com.moodstocks.android.MoodstocksError;
import com.moodstocks.android.Scanner;
import com.shazam.android.persistence.n.b;
import com.shazam.model.configuration.MoodstocksConfiguration;
import com.shazam.model.visual.moodstocks.MoodstocksApiInfo;
import com.shazam.n.k;

// Referenced classes of package com.shazam.android.ai:
//            d

public final class f
    implements d
{
    private final class a
        implements com.moodstocks.android.Scanner.SyncListener
    {

        final f a;

        public final void onSyncComplete()
        {
            a.a.a("pk_last_moodstocks_sync", System.currentTimeMillis());
        }

        public final void onSyncFailed(MoodstocksError moodstockserror)
        {
            (new StringBuilder("Sync error #")).append(moodstockserror.getErrorCode()).append(" : ").append(moodstockserror.getMessage());
        }

        public final void onSyncProgress(int i, int j)
        {
            i = (int)(((float)j / (float)i) * 100F);
            (new StringBuilder("Sync progressing: ")).append(i).append("%");
        }

        public final void onSyncStart()
        {
        }

        private a()
        {
            a = f.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    final b a;
    private final k b;
    private final MoodstocksConfiguration c;

    public f(b b1, k k, MoodstocksConfiguration moodstocksconfiguration)
    {
        a = b1;
        b = k;
        c = moodstocksconfiguration;
    }

    public final void a()
    {
        boolean flag = false;
        long l = a.f("pk_last_moodstocks_sync");
        if (System.currentTimeMillis() - l > c.a().expiry)
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        Scanner scanner = Scanner.get();
        scanner.setSyncListener(new a((byte)0));
        scanner.sync();
        return;
        MoodstocksError moodstockserror;
        moodstockserror;
    }
}
