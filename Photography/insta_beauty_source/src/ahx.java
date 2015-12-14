// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

public class ahx
    implements all
{

    final ProEditNewStretchActivity a;

    public ahx(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void a()
    {
        a.g = false;
        a.f.setProgress(0);
    }

    public void b()
    {
        a.d.setEnabled(true);
        a.e.setTextColor(-1);
    }

    public void c()
    {
        Toast.makeText(a, a.getResources().getString(0x7f0600f5), 0).show();
        a.e();
    }
}
