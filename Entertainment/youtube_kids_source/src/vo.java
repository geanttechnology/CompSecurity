// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

public final class vo
{

    public static boolean a(Context context, Intent intent)
    {
        context = context.getPackageManager().queryIntentActivities(intent, 0x10000);
        return context != null && !context.isEmpty();
    }

    static 
    {
        Uri.parse("http://youtube.com/my_purchases");
        Uri.parse("http://play.google.com/store/");
    }
}
