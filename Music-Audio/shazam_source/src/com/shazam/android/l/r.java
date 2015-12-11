// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.shazam.b.a.a;

public final class r
    implements a
{

    public r()
    {
    }

    public final Object a(Object obj)
    {
        obj = (ResolveInfo)obj;
        return (new StringBuilder("android.resource://")).append(((ResolveInfo) (obj)).activityInfo.packageName).append("/").append(((ResolveInfo) (obj)).getIconResource()).toString();
    }
}
