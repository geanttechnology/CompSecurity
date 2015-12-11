// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.Date;

public class il
{

    public static File a(Context context)
    {
        context = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
        if (!context.exists())
        {
            context.mkdir();
        }
        long l = (new Date()).getTime();
        return new File(context, (new StringBuilder()).append("AmbatanaImage_").append(String.valueOf(l)).append(".tmp").toString());
    }
}
