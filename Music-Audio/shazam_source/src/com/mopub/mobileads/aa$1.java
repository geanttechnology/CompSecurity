// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import com.mopub.a.a;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.d.f;
import com.mopub.common.n;

// Referenced classes of package com.mopub.mobileads:
//            aa

final class a
    implements com.mopub.common.._cls1
{

    final Context a;
    final aa b;

    public final void a(String s, n n1)
    {
        if (n1 != n.f)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        n1 = new Bundle();
        n1.putString("URL", s);
        s = f.a(a, com/mopub/common/MoPubBrowser, n1);
        f.a(a, s);
        return;
        s;
        com.mopub.common.c.a.b(s.getMessage());
        return;
    }

    wser(aa aa1, Context context)
    {
        b = aa1;
        a = context;
        super();
    }
}
