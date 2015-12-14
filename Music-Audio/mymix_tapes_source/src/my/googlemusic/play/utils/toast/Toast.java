// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.toast;

import android.content.Context;

// Referenced classes of package my.googlemusic.play.utils.toast:
//            ToastCreator

public class Toast
{

    public Toast()
    {
    }

    public static ToastCreator with(Context context)
    {
        return new ToastCreator(context);
    }
}
