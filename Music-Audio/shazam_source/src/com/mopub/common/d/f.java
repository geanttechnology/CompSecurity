// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.a.b;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.c.a;
import com.mopub.common.m;
import com.mopub.common.n;
import java.util.List;

public final class f
{

    public static Intent a(Context context, Class class1, Bundle bundle)
    {
        class1 = new Intent(context, class1);
        if (!(context instanceof Activity))
        {
            class1.addFlags(0x10000000);
        }
        class1.putExtras(bundle);
        return class1;
    }

    public static Intent a(Uri uri)
    {
        m.a(uri);
        if (!n.d.a(uri))
        {
            throw new b("URL does not have mopubnativebrowser:// scheme.");
        }
        if (!"navigate".equals(uri.getHost()))
        {
            throw new b("URL missing 'navigate' host parameter.");
        }
        Object obj;
        try
        {
            obj = uri.getQueryParameter("url");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.mopub.common.c.a.d((new StringBuilder("Could not handle url: ")).append(uri).toString());
            throw new b("Passed-in URL did not create a hierarchical URI.");
        }
        if (obj == null)
        {
            throw new b("URL missing 'url' query parameter.");
        } else
        {
            return new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
        }
    }

    public static void a(Context context, Intent intent)
    {
        m.a(context);
        m.a(intent);
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        try
        {
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new com.mopub.a.a(context);
        }
    }

    public static void a(Context context, Intent intent, String s)
    {
        com.mopub.common.m.a.a(context);
        com.mopub.common.m.a.a(intent);
        try
        {
            a(context, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new com.mopub.a.a((new StringBuilder()).append(s).append("\n").append(context.getMessage()).toString());
        }
    }

    public static void a(Context context, Uri uri)
    {
        m.a(context);
        m.a(uri);
        com.mopub.common.c.a.b((new StringBuilder("Final URI to show in browser: ")).append(uri).toString());
        Bundle bundle = new Bundle();
        bundle.putString("URL", uri.toString());
        a(context, a(context, com/mopub/common/MoPubBrowser, bundle), (new StringBuilder("Could not show MoPubBrowser for url: ")).append(uri).append("\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.").toString());
    }

    public static void a(Context context, Uri uri, String s)
    {
        uri = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity))
        {
            uri.addFlags(0x10000000);
        }
        a(context, ((Intent) (uri)), s);
    }

    public static Intent b(Uri uri)
    {
        if (!n.g.a(uri))
        {
            throw new b("URL does not have mopubshare://tweet? format.");
        }
        Object obj;
        String s;
        try
        {
            obj = uri.getQueryParameter("screen_name");
            s = uri.getQueryParameter("tweet_id");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.mopub.common.c.a.d((new StringBuilder("Could not handle url: ")).append(uri).toString());
            throw new b("Passed-in URL did not create a hierarchical URI.");
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new b("URL missing non-empty 'screen_name' query parameter.");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new b("URL missing non-empty 'tweet_id' query parameter.");
        } else
        {
            uri = String.format("Check out @%s's Tweet: %s", new Object[] {
                obj, String.format("https://twitter.com/%s/status/%s", new Object[] {
                    obj, s
                })
            });
            obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("text/plain");
            ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", uri);
            ((Intent) (obj)).putExtra("android.intent.extra.TEXT", uri);
            return ((Intent) (obj));
        }
    }

    public static void b(Context context, Uri uri)
    {
        boolean flag;
        if (!b(context, new Intent("android.intent.action.VIEW", uri)))
        {
            com.mopub.common.c.a.d((new StringBuilder("Could not handle application specific action: ")).append(uri).append(". You may be running in the emulator or another device which does not have the required application.").toString());
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            a(context, uri, (new StringBuilder("Unable to open intent for: ")).append(uri).toString());
            return;
        } else
        {
            throw new com.mopub.a.a((new StringBuilder("Could not handle application specific action: ")).append(uri).append("\n\tYou may be running in the emulator or another device which does not have the required application.").toString());
        }
    }

    public static boolean b(Context context, Intent intent)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (!flag1)
        {
            flag = true;
        }
        return flag;
    }
}
