// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;

// Referenced classes of package android.support.v4.app:
//            ay, Fragment, r

final class s
    implements ay
{

    final Fragment a;
    final r b;

    s(r r, Fragment fragment)
    {
        b = r;
        a = fragment;
        super();
    }

    public final View a()
    {
        return a.getView();
    }
}
