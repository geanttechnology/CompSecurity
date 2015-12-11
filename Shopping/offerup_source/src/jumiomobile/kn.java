// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            kj, gm

public class kn
    implements android.view.View.OnClickListener
{

    final kj a;

    protected kn(kj kj1)
    {
        a = kj1;
        super();
    }

    public void onClick(View view)
    {
        view.setEnabled(false);
        a.b().p();
    }
}
