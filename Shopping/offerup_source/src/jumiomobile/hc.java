// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;

// Referenced classes of package jumiomobile:
//            ha, ht, hf, gs

class hc extends BroadcastReceiver
{

    final ha a;

    hc(ha ha1)
    {
        a = ha1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if (!"com.jumio.netverify.sdk.ACTION_CONTROLLER_LOADED".equals(s)) goto _L2; else goto _L1
_L1:
        ha.a(a);
_L4:
        return;
_L2:
        if ("com.jumio.netverify.sdk.ACTION_UPLOAD_FINISHED".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!"com.jumio.netverify.sdk.ACTION_SHOW_ERROR".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.hasExtra("ErrorCase")) goto _L4; else goto _L3
_L3:
        ha.a(a, ht.valueOf(intent.getStringExtra("ErrorCase")));
        if (ha.d(a) == hf.b && ha.e(a) != null)
        {
            ha.e(a).v();
        }
        ha.c(a).onNetverifyError(ha.f(a).a(), ha.f(a).a(context), ha.f(a).b(), ha.b(a).j);
        return;
        if (!"com.jumio.netverify.sdk.ACTION_SEND_DATA_FINISHED".equals(s) || ha.b(a).F || intent.getIntExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_ID", 0) != ha.g(a)) goto _L4; else goto _L5
_L5:
        ha.c(a).onNetverifyFinished(ha.b(a).I, ha.b(a).j);
        return;
    }
}
