// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;
import com.jumio.netverify.sdk.activity.NetverifyActivity;

// Referenced classes of package jumiomobile:
//            ha

public class gf
    implements android.content.DialogInterface.OnClickListener
{

    final NetverifyActivity a;

    public gf(NetverifyActivity netverifyactivity)
    {
        a = netverifyactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        NetverifyActivity.a(a).j();
        dialoginterface.dismiss();
    }
}
