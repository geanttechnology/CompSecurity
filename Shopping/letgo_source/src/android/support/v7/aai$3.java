// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

// Referenced classes of package android.support.v7:
//            aai

class a
    implements ComponentCallbacks2
{

    final aai a;

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
    }

    public void onTrimMemory(int i)
    {
        if (i == 20)
        {
            a.b();
        }
    }

    guration(aai aai1)
    {
        a = aai1;
        super();
    }
}
