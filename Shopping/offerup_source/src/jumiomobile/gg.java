// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;
import com.jumio.netverify.sdk.activity.NetverifyActivity;

public class gg
    implements android.content.DialogInterface.OnClickListener
{

    final int a;
    final String b;
    final NetverifyActivity c;

    public gg(NetverifyActivity netverifyactivity, int i, String s)
    {
        c = netverifyactivity;
        a = i;
        b = s;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        c.finishSDK(NetverifyActivity.a(c, a, b), 101);
    }
}
