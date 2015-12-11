// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.View;

// Referenced classes of package netswipe:
//            r

class s
    implements Runnable
{

    final View a;
    final r b;

    s(r r, View view)
    {
        b = r;
        a = view;
        super();
    }

    public void run()
    {
        a.setEnabled(true);
    }
}
