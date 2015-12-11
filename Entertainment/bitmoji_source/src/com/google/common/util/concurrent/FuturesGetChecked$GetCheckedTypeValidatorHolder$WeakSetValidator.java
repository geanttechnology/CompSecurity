// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.google.common.util.concurrent:
//            FuturesGetChecked

static final class  extends Enum
    implements 
{

    private static final INSTANCE $VALUES[];
    public static final INSTANCE INSTANCE;
    private static final Set validClasses = new CopyOnWriteArraySet();

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public void validateClass(Class class1)
    {
        for (Iterator iterator = validClasses.iterator(); iterator.hasNext();)
        {
            if (class1.equals(((WeakReference)iterator.next()).get()))
            {
                return;
            }
        }

        FuturesGetChecked.checkExceptionClassValidity(class1);
        if (validClasses.size() > 1000)
        {
            validClasses.clear();
        }
        validClasses.add(new WeakReference(class1));
    }

    static 
    {
        INSTANCE = new <init>("INSTANCE", 0);
        $VALUES = (new .VALUES[] {
            INSTANCE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
