// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.graphics.Bitmap;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Action, Picasso, Request

class GetAction extends Action
{

    GetAction(Picasso picasso, Request request, boolean flag, String s, Object obj, long l)
    {
        super(picasso, null, request, flag, l, 0, null, s, obj);
    }

    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
    }

    public void error()
    {
    }
}
