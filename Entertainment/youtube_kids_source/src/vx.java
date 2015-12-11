// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class vx
    implements android.view.View.OnClickListener
{

    private vq a;

    vx(vq vq1)
    {
        a = vq1;
        super();
    }

    public final void onClick(View view)
    {
        a.g.b(0x7f080015);
        a.finish();
    }
}
