// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gen_binder;

import android.content.Context;
import icu;
import java.util.HashMap;
import olm;
import olv;

public final class 
    implements olv
{

    private HashMap a;

    public final void a(Context context, Class class1, olm olm)
    {
        if (a == null)
        {
            a = new HashMap(3);
            a.put(icu.a, Integer.valueOf(0));
            a.put(icu.b, Integer.valueOf(1));
            a.put(icu.c, Integer.valueOf(2));
        }
        class1 = (Integer)a.get(class1.getName());
        if (class1 == null)
        {
            return;
        }
        switch (class1.intValue())
        {
        default:
            return;

        case 0: // '\0'
            icu.a(context, olm);
            return;

        case 1: // '\001'
            icu.b(context, olm);
            return;

        case 2: // '\002'
            icu.c(context, olm);
            break;
        }
    }

    public ()
    {
    }
}
