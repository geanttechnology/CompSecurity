// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.Context;
import android.widget.Toast;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.b:
//            e, b

final class 
    implements a
{

    final Context a;
    final Context b;
    final e c;

    public final void a()
    {
        com.mopub.common.c.a.b("Image successfully saved.");
    }

    public final void b()
    {
        Toast.makeText(a, "Image failed to download.", 0).show();
        com.mopub.common.c.a.b("Error downloading and saving image file.");
        b.a(new b("Error downloading and saving image file."));
    }

    Context(e e1, Context context, Context context1)
    {
        c = e1;
        a = context;
        b = context1;
        super();
    }
}
