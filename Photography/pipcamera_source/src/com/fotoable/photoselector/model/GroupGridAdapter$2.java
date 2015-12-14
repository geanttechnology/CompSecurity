// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.model;

import android.view.View;

// Referenced classes of package com.fotoable.photoselector.model:
//            GroupGridAdapter

class a
    implements android.view.r
{

    final GroupGridAdapter a;

    public void onClick(View view)
    {
        a.MulttSelectCancel();
    }

    _cls9(GroupGridAdapter groupgridadapter)
    {
        a = groupgridadapter;
        super();
    }
}
