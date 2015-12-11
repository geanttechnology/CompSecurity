// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import com.google.a.a.g;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.util:
//            ai

public class n
{

    private static final String PLAY_STORE_LOOKUP_FORMAT_STRING = "market://details?id=%s";

    public static void a(Context context, Uri uri, String s)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        if (!a(context, intent))
        {
            if (s == null)
            {
                ai.a(context, (new StringBuilder()).append("Sorry, we could not find an app to open the link : ").append(uri.toString()).toString());
                return;
            } else
            {
                intent.setData(Uri.parse(String.format("market://details?id=%s", new Object[] {
                    s
                })));
                b(context, intent);
                return;
            }
        }
        if (o.g(s))
        {
            intent.setPackage(s);
        }
        if (a(context, intent))
        {
            b(context, intent);
            return;
        } else
        {
            intent.setPackage(null);
            b(context, intent);
            return;
        }
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        a(context, s, s1, s2, "");
    }

    public static void a(Context context, String s, String s1, String s2, g g1)
    {
        Object obj = new Intent("android.intent.action.SEND");
        ((Intent) (obj)).setType("text/plain");
        ((Intent) (obj)).addFlags(0x80000);
        ArrayList arraylist = new ArrayList();
        obj = context.getPackageManager().queryIntentActivities(((Intent) (obj)), 0);
        if (!((List) (obj)).isEmpty())
        {
            Collections.sort(((List) (obj)), new Comparator(context) {

                final Context val$context;

                public int a(ResolveInfo resolveinfo1, ResolveInfo resolveinfo2)
                {
                    resolveinfo1 = resolveinfo1.loadLabel(context.getPackageManager());
                    resolveinfo2 = resolveinfo2.loadLabel(context.getPackageManager());
                    if (resolveinfo1 != null)
                    {
                        resolveinfo1 = resolveinfo1.toString();
                    } else
                    {
                        resolveinfo1 = "";
                    }
                    if (resolveinfo2 != null)
                    {
                        resolveinfo2 = resolveinfo2.toString();
                    } else
                    {
                        resolveinfo2 = "";
                    }
                    return resolveinfo1.compareTo(resolveinfo2);
                }

                public int compare(Object obj1, Object obj2)
                {
                    return a((ResolveInfo)obj1, (ResolveInfo)obj2);
                }

            
            {
                context = context1;
                super();
            }
            });
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
                String s3 = resolveinfo.activityInfo.packageName;
                if (g1 == null || !g1.a(resolveinfo))
                {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.setPackage(s3);
                    intent.setComponent(new ComponentName(s3, resolveinfo.activityInfo.name));
                    intent.addFlags(0x80000);
                    intent.putExtra("android.intent.extra.SUBJECT", s);
                    if (o.d(s1))
                    {
                        intent.putExtra("android.intent.extra.TEXT", s1);
                    }
                    arraylist.add(intent);
                }
            } while (true);
        }
        if (arraylist.isEmpty())
        {
            return;
        } else
        {
            s = Intent.createChooser((Intent)arraylist.remove(arraylist.size() - 1), s2);
            s.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arraylist.toArray(new Parcelable[0]));
            b(context, s);
            return;
        }
    }

    public static void a(Context context, String s, String s1, String s2, String s3)
    {
        if (o.d(s3))
        {
            s3 = new g(s3) {

                final String val$packageNameFilter;

                public boolean a(ResolveInfo resolveinfo)
                {
                    return resolveinfo.activityInfo.packageName.equals(packageNameFilter);
                }

                public volatile boolean a(Object obj)
                {
                    return a((ResolveInfo)obj);
                }

            
            {
                packageNameFilter = s;
                super();
            }
            };
        } else
        {
            s3 = null;
        }
        a(context, s, s1, s2, ((g) (s3)));
    }

    private static boolean a(Context context, Intent intent)
    {
        boolean flag = false;
        if (!context.getPackageManager().queryIntentActivities(intent, 0).isEmpty())
        {
            flag = true;
        }
        return flag;
    }

    private static void b(Context context, Intent intent)
    {
        try
        {
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            ai.b(context, "Sorry, we could not find an app to open");
        }
    }
}
