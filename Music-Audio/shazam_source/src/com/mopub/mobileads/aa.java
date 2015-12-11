// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.a.a;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.d.f;
import com.mopub.common.m;
import com.mopub.common.n;
import com.mopub.common.o;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            ad

final class aa
    implements Serializable
{

    final int a;
    final int b;
    final int c;
    final Integer d;
    final ad e;
    final List f;
    final List g;
    private final String h;

    final void a(Context context, String s)
    {
        m.a(context);
        s = e.a(h, s);
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            com.mopub.common.o.a a1 = (new com.mopub.common.o.a()).a(n.b, new n[] {
                n.d, n.f
            });
            a1.a = new com.mopub.common.o.c(context) {

                final Context a;
                final aa b;

                public final void a(String s1, n n1)
                {
                    if (n1 != n.f)
                    {
                        break MISSING_BLOCK_LABEL_41;
                    }
                    n1 = new Bundle();
                    n1.putString("URL", s1);
                    s1 = com.mopub.common.d.f.a(a, com/mopub/common/MoPubBrowser, n1);
                    com.mopub.common.d.f.a(a, s1);
                    return;
                    s1;
                    com.mopub.common.c.a.b(s1.getMessage());
                    return;
                }

            
            {
                b = aa.this;
                a = context;
                super();
            }
            };
            a1.c = true;
            a1.a().a(context, s);
            return;
        }
    }
}
