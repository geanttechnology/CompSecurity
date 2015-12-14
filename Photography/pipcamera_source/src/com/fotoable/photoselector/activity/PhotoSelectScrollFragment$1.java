// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.view.View;
import ne;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectScrollFragment

class a
    implements android.view.SelectScrollFragment._cls1
{

    final PhotoSelectScrollFragment a;

    public void onClick(View view)
    {
        if (PhotoSelectScrollFragment.a(a) != null)
        {
            PhotoSelectScrollFragment.a(a).d();
        }
    }

    (PhotoSelectScrollFragment photoselectscrollfragment)
    {
        a = photoselectscrollfragment;
        super();
    }
}
