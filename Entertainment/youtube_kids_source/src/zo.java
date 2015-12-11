// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.SeekBar;

final class zo
    implements android.view.View.OnClickListener
{

    private zl a;

    zo(zl zl1)
    {
        a = zl1;
        super();
    }

    public final void onClick(View view)
    {
        if (a.g.getProgress() < a.g.getMax())
        {
            a.g.setProgress(a.g.getProgress() + 1);
        }
    }
}
