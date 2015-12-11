// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.f2prateek.dart;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.f2prateek.dart:
//            Dart

static final class nit> extends nit>
{

    public Object getExtra(Object obj, String s)
    {
        obj = ((Activity)obj).getIntent();
        if (obj == null)
        {
            return null;
        } else
        {
            return NDLE.tExtra(((Intent) (obj)).getExtras(), s);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
