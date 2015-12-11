// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            FuturesGetChecked

static final class _cls1 extends Enum
    implements _cls1
{

    private static final INSTANCE $VALUES[];
    public static final INSTANCE INSTANCE;
    private static final ClassValue isValidClass = new ClassValue() {

        protected Boolean computeValue(Class class1)
        {
            FuturesGetChecked.checkExceptionClassValidity(class1.asSubclass(java/lang/Exception));
            return Boolean.valueOf(true);
        }

        protected volatile Object computeValue(Class class1)
        {
            return computeValue(class1);
        }

    };

    public static _cls1 valueOf(String s)
    {
        return (_cls1)Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator, s);
    }

    public static _cls1[] values()
    {
        return (_cls1[])$VALUES.clone();
    }

    public void validateClass(Class class1)
    {
        isValidClass.get(class1);
    }

    static 
    {
        INSTANCE = new <init>("INSTANCE", 0);
        $VALUES = (new .VALUES[] {
            INSTANCE
        });
    }

    private _cls1(String s, int i)
    {
        super(s, i);
    }
}
