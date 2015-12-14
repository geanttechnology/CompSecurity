// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.graphics.Point;
import android.view.View;
import com.socialin.android.photo.picsinphoto.StudioActivity;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            b, SelectCanvasSizeDialog

final class a
    implements android.view..OnLongClickListener
{

    private b a;

    public final boolean onLongClick(View view)
    {
        view = SelectCanvasSizeDialog.a(a.getActivity());
        ((StudioActivity)a.getActivity()).a(((Point) (view)).x, ((Point) (view)).y);
        return true;
    }

    ioActivity(b b1)
    {
        a = b1;
        super();
    }
}
