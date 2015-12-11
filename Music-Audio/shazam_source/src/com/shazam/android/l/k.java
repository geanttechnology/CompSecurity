// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import android.net.Uri;
import com.shazam.android.ab.d;
import com.shazam.b.a.a;
import com.shazam.model.Action;
import java.net.URISyntaxException;

public final class k
    implements a
{

    private final a a;
    private final d b;

    public k(a a1, d d1)
    {
        a = a1;
        b = d1;
    }

    private Intent a(Action action)
    {
        Uri uri;
        try
        {
            action = b.a(action.uri);
            uri = action.getData();
        }
        // Misplaced declaration of an exception variable
        catch (Action action)
        {
            (new StringBuilder("Could not convert action to intent: ")).append(action);
            return null;
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        action.setData((Uri)a.a(uri));
        return action;
    }

    public final volatile Object a(Object obj)
    {
        return a((Action)obj);
    }
}
