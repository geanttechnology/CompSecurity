// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.f2prateek.dart;

import android.app.Fragment;

// Referenced classes of package com.f2prateek.dart:
//            Dart

static final class nit> extends nit>
{

    public Object getExtra(Object obj, String s)
    {
        obj = ((Fragment)obj).getArguments();
        return NDLE.tExtra(obj, s);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
