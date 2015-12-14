// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageButton;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahi
    implements Runnable
{

    final boolean a;
    final boolean b;
    final ProEditMosaicActivity c;

    public ahi(ProEditMosaicActivity proeditmosaicactivity, boolean flag, boolean flag1)
    {
        c = proeditmosaicactivity;
        a = flag;
        b = flag1;
        super();
    }

    public void run()
    {
        ProEditMosaicActivity.e(c).setEnabled(a);
        ProEditMosaicActivity.c(c).setEnabled(b);
    }
}
