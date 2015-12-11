// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.c.p;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.c.a;
import com.mopub.common.d.f;
import com.mopub.common.m;
import com.mopub.common.n;
import com.mopub.common.o;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            ad

public final class x
    implements Serializable
{

    final int a;
    final int b;
    final ad c;
    final List d;
    private final String e;
    private final List f;

    final void a(Context context, int i)
    {
        m.a(context);
        p.a(f, null, Integer.valueOf(i), null, context);
    }

    final void a(Context context, String s)
    {
        m.a(context);
        m.a(context instanceof Activity, true, "context must be an activity", new Object[] {
            ""
        });
        s = c.a(e, s);
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            com.mopub.common.o.a a1 = (new com.mopub.common.o.a()).a(n.b, new n[] {
                n.e, n.d, n.f, n.g, n.h, n.i
            });
            a1.a = new com.mopub.common.o.c(context) {

                final Context a;
                final int b = 1;
                final x c;

                public final void a(String s1, n n1)
                {
                    if (n1 != n.f)
                    {
                        break MISSING_BLOCK_LABEL_48;
                    }
                    n1 = new Bundle();
                    n1.putString("URL", s1);
                    s1 = com.mopub.common.d.f.a(a, com/mopub/common/MoPubBrowser, n1);
                    ((Activity)a).startActivityForResult(s1, b);
                    return;
                    s1;
                    com.mopub.common.c.a.b((new StringBuilder("Activity ")).append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you declare it in your AndroidManifest.xml?").toString());
                    return;
                }

            
            {
                c = x.this;
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
