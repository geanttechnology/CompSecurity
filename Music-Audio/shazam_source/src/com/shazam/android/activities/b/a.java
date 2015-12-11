// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import com.shazam.android.activities.MainActivity;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.util.n;
import com.shazam.android.util.s;
import com.shazam.b.a.d;
import com.shazam.f.i;
import com.shazam.i.b.c;
import com.shazam.sig.b;

public final class a
{

    static final com.shazam.android.av.a a = new com.shazam.android.av.a();

    public static Intent a(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.setClass(context, com/shazam/android/activities/MainActivity);
        intent.setFlags(0x4000000);
        intent.setData((new p()).d());
        return intent;
    }

    public static void a(Context context, TaggingOrigin taggingorigin)
    {
        n n1 = new n(context, LayoutInflater.from(c.a()));
        taggingorigin = b(context, taggingorigin);
        try
        {
            if (!com.shazam.sig.b.getLibraryLoadingDiagnostics().a())
            {
                throw new i();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = new com.shazam.android.util.q.a();
            context.a = 0x7f09011d;
            context.c = 1;
            n1.a(context.a());
            return;
        }
        context.startActivity(taggingorigin);
        return;
    }

    public static void a(Context context, boolean flag)
    {
        context.startActivity(b(context, flag));
    }

    public static Intent b(Context context, TaggingOrigin taggingorigin)
    {
        d.a(context);
        context = new Intent("com.shazam.android.intent.actions.START_TAGGING");
        context.putExtra("origin", taggingorigin.getOrigin());
        context.setFlags(0x4000000);
        return context;
    }

    public static Intent b(Context context, boolean flag)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(context, com/shazam/android/activities/MainActivity);
        intent.setFlags(0x4000000);
        if (!(context instanceof Activity))
        {
            intent.setFlags(0x10000000);
        }
        intent.putExtra("fromAppLaunchToTriggerAutotaggingIfConfigured", flag);
        return intent;
    }

}
