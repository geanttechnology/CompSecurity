// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public final class b
    implements ResultCallback
{

    private String a;

    public b(String s)
    {
        a = s;
        super();
    }

    public final void onResult(Result result)
    {
        result = (Status)result;
        if (result.isSuccess())
        {
            (new StringBuilder("App Indexing API: Recorded ")).append(a).append(" view end successfully.");
            return;
        } else
        {
            Log.e("AppIndexing", (new StringBuilder("App Indexing API: There was an error recording the view.")).append(result.toString()).toString());
            return;
        }
    }
}
