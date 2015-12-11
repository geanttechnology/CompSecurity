// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package jumiomobile:
//            hz, ii

class ia extends BroadcastReceiver
{

    final hz a;

    ia(hz hz1)
    {
        a = hz1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        for (context = intent.getAction(); intent.getIntExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_ID", 0) != hz.a(a) || !"com.jumio.netverify.sdk.ACTION_EXTRACTION_FINISHED".equals(context);)
        {
            return;
        }

        a.d.b();
    }
}
