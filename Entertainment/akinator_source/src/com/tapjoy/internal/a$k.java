// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            a, b

static final class 
    implements 
{

    public final Notification a( )
    {
        b b1;
        b1 = new b(.a, .r, .b, .c, .h, .f, .i, .d, .e, .g, .n, .o, .p, .k, .j, .m);
        CharSequence charsequence;
        Object obj3;
        int i;
        for (Iterator iterator = .q.iterator(); iterator.hasNext(); b1.a.addAction(i, charsequence, ((android.app.PendingIntent) (obj3))))
        {
            obj3 = (t)iterator.next();
            i = ((t) (obj3)).a;
            charsequence = ((a) (obj3)).b;
            obj3 = ((b) (obj3)).c;
        }

        if (.l == null) goto _L2; else goto _L1
_L1:
        if (!(.l instanceof l)) goto _L4; else goto _L3
_L3:
        Object obj1 = (l).l;
        Object obj = ((l) (obj1)).e;
        boolean flag = ((e) (obj1)).g;
         = ((g) (obj1)).f;
        obj1 = ((f) (obj1)).a;
        obj = (new android.app.fication.BigTextStyle(b1.a)).setBigContentTitle(((CharSequence) (obj))).bigText(((CharSequence) (obj1)));
        if (flag)
        {
            ((android.app.fication.BigTextStyle) (obj)).setSummaryText();
        }
_L2:
        return b1.a.build();
_L4:
        if (.l instanceof l)
        {
             = (l).l;
            b1.a(((l) ()).e, ((e) ()).g, ((g) ()).f, ((f) ()).a);
        } else
        if (.l instanceof l)
        {
            Object obj2 = (l).l;
            CharSequence charsequence1 = ((l) (obj2)).e;
            boolean flag1 = ((e) (obj2)).g;
             = ((g) (obj2)).f;
            android.graphics.Bitmap bitmap1 = ((f) (obj2)).a;
            android.graphics.Bitmap bitmap = ((a) (obj2)).b;
            boolean flag2 = ((b) (obj2)).c;
            obj2 = (new android.app.fication.BigPictureStyle(b1.a)).setBigContentTitle(charsequence1).bigPicture(bitmap1);
            if (flag2)
            {
                ((android.app.fication.BigPictureStyle) (obj2)).bigLargeIcon(bitmap);
            }
            if (flag1)
            {
                ((android.app.fication.BigPictureStyle) (obj2)).setSummaryText();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    ()
    {
    }
}
