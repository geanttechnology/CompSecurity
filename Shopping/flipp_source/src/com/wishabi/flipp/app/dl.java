// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Fragment;
import android.os.Bundle;

// Referenced classes of package com.wishabi.flipp.app:
//            dm

public abstract class dl extends Fragment
{

    dm b;

    public dl()
    {
    }

    protected final void a(Class class1, Bundle bundle)
    {
        if (b != null)
        {
            b.a(class1, bundle);
        }
    }

    protected final boolean a()
    {
        if (b == null)
        {
            return false;
        } else
        {
            return b.a();
        }
    }

    protected final void b(String s)
    {
        if (b != null)
        {
            b.a(s);
        }
    }
}
