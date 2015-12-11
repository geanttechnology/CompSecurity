// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            dm, ep

public class dc
    implements android.view.View.OnClickListener
{

    final ScanCardActivity a;

    public dc(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void onClick(View view)
    {
label0:
        {
            synchronized (ScanCardActivity.f(a).u())
            {
                if (ScanCardActivity.f(a).v() != null)
                {
                    break label0;
                }
            }
            return;
        }
        ScanCardActivity.g(a).a(ScanCardActivity.f(a).v());
        view;
        JVM INSTR monitorexit ;
        ScanCardActivity.f(a).a(false, false);
        a.finish();
        return;
        exception;
        view;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
