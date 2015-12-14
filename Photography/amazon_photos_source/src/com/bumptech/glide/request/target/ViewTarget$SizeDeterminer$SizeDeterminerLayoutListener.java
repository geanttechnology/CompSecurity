// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.util.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package com.bumptech.glide.request.target:
//            ViewTarget

private static class sizeDeterminerRef
    implements android.view.rminerLayoutListener
{

    private final WeakReference sizeDeterminerRef;

    public boolean onPreDraw()
    {
        if (Log.isLoggable("ViewTarget", 2))
        {
            Log.v("ViewTarget", (new StringBuilder()).append("OnGlobalLayoutListener called listener=").append(this).toString());
        }
        sizeDeterminerRef sizedeterminerref = (sizeDeterminerRef)sizeDeterminerRef.get();
        if (sizedeterminerref != null)
        {
            sizeDeterminerRef(sizedeterminerref);
        }
        return true;
    }

    public ( )
    {
        sizeDeterminerRef = new WeakReference();
    }
}
