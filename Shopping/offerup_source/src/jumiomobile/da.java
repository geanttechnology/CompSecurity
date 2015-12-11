// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.widget.TextView;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

public class da
    implements Runnable
{

    final String a;
    final ScanCardActivity b;

    public da(ScanCardActivity scancardactivity, String s)
    {
        b = scancardactivity;
        a = s;
        super();
    }

    public void run()
    {
        ScanCardActivity.d(b).setText(a);
        ScanCardActivity.d(b).postInvalidate();
    }
}
