// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

public class qg
{

    static void a(qt qt)
    {
        if (!(qt instanceof qs))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((qs)qt).a();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("GoogleApi", (new StringBuilder()).append("Unable to release ").append(qt).toString(), runtimeexception);
        return;
    }
}
