// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class bln
{

    private static final Set a = Collections.newSetFromMap(new ConcurrentHashMap());

    private static blt a(Iterator iterator)
    {
        for (; iterator.hasNext(); iterator.remove())
        {
            blt blt1 = (blt)((bmy)iterator.next()).get();
            if (blt1 != null)
            {
                return blt1;
            }
        }

        return null;
    }

    static void a(ImageView imageview)
    {
        Iterator iterator = a.iterator();
        do
        {
            blt blt1 = a(iterator);
            if (blt1 != null)
            {
                blt1.a(imageview);
            } else
            {
                return;
            }
        } while (true);
    }

    static void a(ImageView imageview, Bitmap bitmap)
    {
        Iterator iterator = a.iterator();
        do
        {
            blt blt1 = a(iterator);
            if (blt1 != null)
            {
                blt1.a(imageview, bitmap);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void a(blu blu1, blr blr, Uri uri, ImageView imageview, blt blt1)
    {
        b.a(blu1);
        b.a(uri);
        b.a(imageview);
        blp blp1 = new blp(imageview, blr, blt1);
        blt1 = imageview.getHandler();
        blr = blt1;
        if (blt1 == null)
        {
            blr = new Handler(Looper.getMainLooper());
        }
        blu1.a(uri, bhy.a(blr, blp1));
        c(imageview);
    }

    static void b(ImageView imageview)
    {
        for (imageview = a.iterator(); a(imageview) != null;) { }
    }

    private static void c(ImageView imageview)
    {
        for (imageview = a.iterator(); a(imageview) != null;) { }
    }

}
