// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.bumptech.glide.signature:
//            StringSignature

public final class ApplicationVersionSignature
{

    private static final ConcurrentHashMap PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();

    public static Key obtain(Context context)
    {
        String s = context.getPackageName();
        Key key = (Key)PACKAGE_NAME_TO_KEY.get(s);
        Object obj = key;
        if (key == null)
        {
            context = obtainVersionSignature(context);
            Key key1 = (Key)PACKAGE_NAME_TO_KEY.putIfAbsent(s, context);
            obj = key1;
            if (key1 == null)
            {
                obj = context;
            }
        }
        return ((Key) (obj));
    }

    private static Key obtainVersionSignature(Context context)
    {
        Object obj = null;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = obj;
        }
        if (context != null)
        {
            context = String.valueOf(((PackageInfo) (context)).versionCode);
        } else
        {
            context = UUID.randomUUID().toString();
        }
        return new StringSignature(context);
    }

}
