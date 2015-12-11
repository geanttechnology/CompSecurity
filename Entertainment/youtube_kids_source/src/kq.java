// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class kq
    implements Runnable
{

    private kt a;
    private kn b;

    public final void run()
    {
        Object obj = b.b;
        obj = b;
        obj = (View)null;
        if (obj != null && ((View) (obj)).getWindowToken() != null && a.b())
        {
            b.d = a;
        }
        b.f = null;
    }
}
