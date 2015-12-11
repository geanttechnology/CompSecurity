// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

class TaskStackBuilderHelper
{

    TaskStackBuilderHelper()
    {
    }

    public static void startActivities(Context context, Class class1, Intent intent)
    {
        context = TaskStackBuilder.create(context);
        context.addParentStack(class1);
        context.addNextIntent(intent);
        context.startActivities();
    }
}
