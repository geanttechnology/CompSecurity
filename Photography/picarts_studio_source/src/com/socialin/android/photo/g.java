// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.shop.ShopActivity;
import com.socialin.android.util.s;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import myobfuscated.cv.c;

public final class g
{

    private static String a = null;

    public static Dialog a(Activity activity)
    {
        return DialogUtils.showNoNetworkDialog(activity, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
    }

    public static String a(Context context)
    {
        if (a == null)
        {
            a = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808c0)).append("/").toString();
        }
        return a;
    }

    public static void a(Activity activity, Map map)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/picsart/shop/ShopActivity);
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); intent.putExtra((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        c.a(intent, activity);
        activity.startActivity(intent);
    }

    public static void b(Activity activity)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        } else
        {
            Intent intent = new Intent(activity, com/picsart/shop/ShopActivity);
            c.a(intent, activity);
            activity.startActivityForResult(intent, 93);
            return;
        }
    }

}
