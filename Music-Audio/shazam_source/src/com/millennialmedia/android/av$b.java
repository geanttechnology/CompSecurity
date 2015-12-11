// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            av, MMActivity, OverlaySettings

static final class ivity.b extends ivity.b
{

    WeakReference f;

    public final boolean a(Uri uri)
    {
        av av1 = (av)f.get();
        if (av1 != null)
        {
            av1.a(new Runnable(av1) {

                final av a;
                final av.b b;

                public final void run()
                {
                }

            
            {
                b = av.b.this;
                a = av1;
                super();
            }
            });
            if (uri != null && av.a(uri))
            {
                av1.a(new <init>(av1, uri.getHost()));
                return true;
            }
        }
        return false;
    }

    public final OverlaySettings b()
    {
        av av1 = (av)f.get();
        if (av1 != null && av1.g != null)
        {
            OverlaySettings overlaysettings = new OverlaySettings();
            overlaysettings.g = av1.g;
            return overlaysettings;
        } else
        {
            return null;
        }
    }

    public _cls1.a(av av1)
    {
        if (av1 != null)
        {
            f = new WeakReference(av1);
            if (av1.d != null)
            {
                e = av1.d.b;
            }
        }
    }
}
