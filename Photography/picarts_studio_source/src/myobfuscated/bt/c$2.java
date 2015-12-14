// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import com.socialin.android.dropbox.a;
import java.util.Comparator;

// Referenced classes of package myobfuscated.bt:
//            c

final class .dropbox.a
    implements Comparator
{

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (a)obj;
        obj1 = (a)obj1;
        if (((a) (obj)).c && !((a) (obj1)).c)
        {
            return -1;
        }
        return ((a) (obj)).c || !((a) (obj1)).c ? 0 : 1;
    }

    .dropbox.a()
    {
    }
}
