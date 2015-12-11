// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Process;

// Referenced classes of package android.support.v4.content:
//            ContextCompatApi21

public class ContextCompat
{

    public ContextCompat()
    {
    }

    public static int checkSelfPermission(Context context, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("permission is null");
        } else
        {
            return context.checkPermission(s, Process.myPid(), Process.myUid());
        }
    }

    public static final Drawable getDrawable(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return ContextCompatApi21.getDrawable(context, i);
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }
}
