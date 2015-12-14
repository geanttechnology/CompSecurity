// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.View;
import android.widget.GridView;

// Referenced classes of package com.picsart.studio:
//            c, DrawingGalleryActivity

final class 
    implements android.view..OnLongClickListener
{

    private int a;
    private c b;

    public final boolean onLongClick(View view)
    {
        DrawingGalleryActivity.g(b.a).setItemChecked(a, true);
        return true;
    }

    (c c1, int i)
    {
        b = c1;
        a = i;
        super();
    }
}
