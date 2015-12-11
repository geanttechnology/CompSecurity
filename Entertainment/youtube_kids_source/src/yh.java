// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class yh
    implements android.view.View.OnClickListener
{

    private yg a;

    yh(yg yg1)
    {
        a = yg1;
        super();
    }

    public final void onClick(View view)
    {
        a.setResult(0);
        a.finish();
    }
}
