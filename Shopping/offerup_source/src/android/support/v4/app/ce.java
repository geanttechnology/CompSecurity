// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            cb, d, bf

final class ce
{

    private static final Object a = new Object();
    private static Field b;
    private static boolean c;

    public static Bundle a(android.app.Notification.Builder builder, cb cb1)
    {
        builder.addAction(cb1.a(), cb1.b(), cb1.c());
        builder = new Bundle(cb1.d());
        if (cb1.e() != null)
        {
            builder.putParcelableArray("android.support.remoteInputs", d.b(cb1.e()));
        }
        return builder;
    }

    public static Bundle a(Notification notification)
    {
label0:
        {
            synchronized (a)
            {
                if (!c)
                {
                    break label0;
                }
            }
            return null;
        }
        Object obj;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = android/app/Notification.getDeclaredField("extras");
        if (android/os/Bundle.isAssignableFrom(((Field) (obj)).getType()))
        {
            break MISSING_BLOCK_LABEL_58;
        }
        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
        c = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        ((Field) (obj)).setAccessible(true);
        b = ((Field) (obj));
        Bundle bundle = (Bundle)b.get(notification);
        obj = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = new Bundle();
        b.set(notification, obj);
        obj1;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj));
        notification;
        obj1;
        JVM INSTR monitorexit ;
        throw notification;
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
_L1:
        c = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
          goto _L1
    }

    public static SparseArray a(List list)
    {
        SparseArray sparsearray = null;
        int j = list.size();
        for (int i = 0; i < j;)
        {
            Bundle bundle = (Bundle)list.get(i);
            SparseArray sparsearray1 = sparsearray;
            if (bundle != null)
            {
                sparsearray1 = sparsearray;
                if (sparsearray == null)
                {
                    sparsearray1 = new SparseArray();
                }
                sparsearray1.put(i, bundle);
            }
            i++;
            sparsearray = sparsearray1;
        }

        return sparsearray;
    }

    public static ArrayList a(cb acb[])
    {
        if (acb != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ArrayList) (obj));
_L2:
        ArrayList arraylist = new ArrayList(acb.length);
        int j = acb.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            obj = acb[i];
            Bundle bundle = new Bundle();
            bundle.putInt("icon", ((cb) (obj)).a());
            bundle.putCharSequence("title", ((cb) (obj)).b());
            bundle.putParcelable("actionIntent", ((cb) (obj)).c());
            bundle.putBundle("extras", ((cb) (obj)).d());
            bundle.putParcelableArray("remoteInputs", d.b(((cb) (obj)).e()));
            arraylist.add(bundle);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(bf bf1, CharSequence charsequence, boolean flag, CharSequence charsequence1, Bitmap bitmap, Bitmap bitmap1, boolean flag1)
    {
        bf1 = (new android.app.Notification.BigPictureStyle(bf1.a())).setBigContentTitle(charsequence).bigPicture(bitmap);
        if (flag1)
        {
            bf1.bigLargeIcon(bitmap1);
        }
        if (flag)
        {
            bf1.setSummaryText(charsequence1);
        }
    }

    public static void a(bf bf1, CharSequence charsequence, boolean flag, CharSequence charsequence1, CharSequence charsequence2)
    {
        bf1 = (new android.app.Notification.BigTextStyle(bf1.a())).setBigContentTitle(charsequence).bigText(charsequence2);
        if (flag)
        {
            bf1.setSummaryText(charsequence1);
        }
    }

    public static void a(bf bf1, CharSequence charsequence, boolean flag, CharSequence charsequence1, ArrayList arraylist)
    {
        bf1 = (new android.app.Notification.InboxStyle(bf1.a())).setBigContentTitle(charsequence);
        if (flag)
        {
            bf1.setSummaryText(charsequence1);
        }
        for (charsequence = arraylist.iterator(); charsequence.hasNext(); bf1.addLine((CharSequence)charsequence.next())) { }
    }

    static 
    {
        new Object();
    }
}
