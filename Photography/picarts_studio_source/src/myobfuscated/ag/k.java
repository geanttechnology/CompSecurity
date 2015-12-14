// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.util.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package myobfuscated.ag:
//            j

final class k
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private final WeakReference a;

    public k(j j1)
    {
        a = new WeakReference(j1);
    }

    public final boolean onPreDraw()
    {
        if (Log.isLoggable("ViewTarget", 2))
        {
            (new StringBuilder("OnGlobalLayoutListener called listener=")).append(this);
        }
        j j1 = (j)a.get();
        if (j1 != null)
        {
            j.a(j1);
        }
        return true;
    }
}
