// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.target.ui.util.ai;
import java.util.List;

public class c
{

    private static final String INTENT_TYPE_PLAIN_TEXT = "plain/text";

    public static void a(Context context, String s)
    {
        boolean flag = true;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            s
        });
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0)
        {
            flag = false;
        }
        if (!flag)
        {
            ai.a(context, "No email app installed!");
            return;
        } else
        {
            context.startActivity(intent);
            return;
        }
    }
}
