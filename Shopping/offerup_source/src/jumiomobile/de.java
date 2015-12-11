// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            dm

public class de
    implements android.content.DialogInterface.OnClickListener
{

    final ScanCardActivity a;

    public de(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ScanCardActivity.f(a).a(true, false);
        ScanCardActivity.a(a, null);
    }
}
