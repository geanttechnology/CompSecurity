// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.c.a;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.common.d:
//            m, n, f

public final class h
{
    private static final class a
    {

        public boolean a;
        public boolean b;
        public boolean c;

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }

    static final class b
    {

        b()
        {
        }
    }


    private static final List a;
    private static b b = new b();
    private static final List c;

    private static a a(Context context, Class class1)
    {
        class1 = context.getPackageManager().getActivityInfo(new ComponentName(context, class1.getName()), 0);
        a a1 = new a((byte)0);
        a1.a = com.mopub.common.d.m.a(((ActivityInfo) (class1)).configChanges, 32);
        a1.b = com.mopub.common.d.m.a(((ActivityInfo) (class1)).configChanges, 128);
        a1.c = true;
        if (com.mopub.common.d.n.a().a(n.m) && context.getApplicationInfo().targetSdkVersion >= n.m.u)
        {
            a1.c = com.mopub.common.d.m.a(((ActivityInfo) (class1)).configChanges, 1024);
        }
        return a1;
    }

    private static List a(Context context, List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        Class class1;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        class1 = (Class)list.next();
        a a1 = a(context, class1);
        if (!a1.a || !a1.b || !a1.c)
        {
            arraylist.add(class1);
        }
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private static List a(Context context, List list, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Class class1 = (Class)list.next();
            if (f.b(context, new Intent(context, class1)) == flag)
            {
                arraylist.add(class1);
            }
        } while (true);
        return arraylist;
    }

    public static void a(Context context)
    {
        if (com.mopub.common.m.a.a(context, "context is not allowed to be null"))
        {
            Object obj = a(context, a, false);
            if (!((List) (obj)).isEmpty())
            {
                b(context);
                StringBuilder stringbuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
                Class class1;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append("\n\t").append(class1.getName()))
                {
                    class1 = (Class)((Iterator) (obj)).next();
                }

                stringbuilder.append("\n\nPlease update your manifest to include them.");
                com.mopub.common.c.a.d(stringbuilder.toString());
            }
            List list = a(context, a(context, a, true));
            if (!list.isEmpty())
            {
                b(context);
                b(context, list);
                return;
            }
        }
    }

    private static void b(Context context)
    {
        if (com.mopub.common.d.m.a(context.getApplicationInfo().flags, 2))
        {
            context = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            context.setGravity(7, 0, 0);
            context.show();
        }
    }

    private static void b(Context context, List list)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        list = list.iterator();
_L2:
        Class class1;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_157;
        }
        class1 = (Class)list.next();
        a a1 = a(context, class1);
        if (!a1.a)
        {
            stringbuilder.append((new StringBuilder("\n\tThe android:configChanges param for activity ")).append(class1.getName()).append(" must include keyboardHidden.").toString());
        }
        if (!a1.b)
        {
            stringbuilder.append((new StringBuilder("\n\tThe android:configChanges param for activity ")).append(class1.getName()).append(" must include orientation.").toString());
        }
        if (!a1.c)
        {
            stringbuilder.append((new StringBuilder("\n\tThe android:configChanges param for activity ")).append(class1.getName()).append(" must include screenSize.").toString());
        }
        continue; /* Loop/switch isn't completed */
        stringbuilder.append("\n\nPlease update your manifest to include them.");
        com.mopub.common.c.a.d(stringbuilder.toString());
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        ArrayList arraylist = new ArrayList(4);
        a = arraylist;
        arraylist.add(com/mopub/mobileads/MoPubActivity);
        a.add(com/mopub/mobileads/MraidActivity);
        a.add(com/mopub/mobileads/MraidVideoPlayerActivity);
        a.add(com/mopub/common/MoPubBrowser);
        arraylist = new ArrayList(1);
        c = arraylist;
        arraylist.add(com/mopub/common/MoPubBrowser);
    }
}
