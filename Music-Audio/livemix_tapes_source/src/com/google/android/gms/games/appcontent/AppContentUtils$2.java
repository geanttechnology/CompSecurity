// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentUtils, AppContentAnnotationRef

static final class zzasA
    implements pContentRunner
{

    final ArrayList zzasA;

    public void zzb(ArrayList arraylist, int i)
    {
        zzasA.add(new AppContentAnnotationRef(arraylist, i));
    }

    onRef(ArrayList arraylist)
    {
        zzasA = arraylist;
        super();
    }
}
