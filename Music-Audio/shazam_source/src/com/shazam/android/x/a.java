// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.x;

import android.content.Intent;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;
import java.net.URISyntaxException;

public final class a
    implements k
{

    public a()
    {
    }

    private static Intent a(l l1)
    {
        l1 = l1.h().b();
        try
        {
            l1 = Intent.parseUri(l1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            return null;
        }
        return l1;
    }

    public final Object deserialize(l l1, Type type, j j)
    {
        return a(l1);
    }
}
