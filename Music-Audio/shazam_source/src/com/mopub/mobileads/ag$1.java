// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.widget.ImageView;
import com.mopub.common.c.a;
import com.mopub.d.s;

// Referenced classes of package com.mopub.mobileads:
//            ag

final class a
    implements com.mopub.d.a..ag._cls1
{

    final String a;
    final ag b;

    public final void a(com.mopub.d.a. )
    {
         = .;
        if ( != null)
        {
            com.mopub.mobileads.ag.a(b).setImageBitmap();
            return;
        } else
        {
            com.mopub.common.c.a.b(String.format("%s returned null bitmap", new Object[] {
                a
            }));
            return;
        }
    }

    public final void a(s s)
    {
        com.mopub.common.c.a.b("Failed to load image.", s);
    }

    (ag ag1, String s)
    {
        b = ag1;
        a = s;
        super();
    }
}
