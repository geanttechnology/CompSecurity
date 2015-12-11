// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.widget.ImageView;

// Referenced classes of package jumiomobile:
//            kj, kn

class kl
    implements Runnable
{

    final kj a;

    kl(kj kj1)
    {
        a = kj1;
        super();
    }

    public void run()
    {
        a.f.setVisibility(0);
        a.f.setEnabled(true);
        a.f.setOnClickListener(new kn(a));
    }
}
