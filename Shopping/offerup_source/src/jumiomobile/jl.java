// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package jumiomobile:
//            jk, ii

class jl extends BroadcastReceiver
{

    final jk a;

    jl(jk jk1)
    {
        a = jk1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        for (context = intent.getAction(); intent.getIntExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_ID", 0) != jk.a(a) || !"com.jumio.netverify.sdk.ACTION_EXTRACTION_FINISHED".equals(context);)
        {
            return;
        }

        jk.b(a).b();
    }
}
