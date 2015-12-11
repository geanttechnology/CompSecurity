// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

final class aeo
    implements Runnable
{

    private aen a;

    aeo(aen aen1)
    {
        a = aen1;
        super();
    }

    public final void run()
    {
        a.a.setImageDrawable(a.b);
        a.a.animate().alpha(1.0F).setDuration(650L);
    }
}
