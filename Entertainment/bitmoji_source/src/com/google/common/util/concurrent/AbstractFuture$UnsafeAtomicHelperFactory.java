// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static abstract class <init> extends Enum
{

    private static final DONT_EVEN_TRY_TO_CREATE $VALUES[];
    public static final DONT_EVEN_TRY_TO_CREATE DONT_EVEN_TRY_TO_CREATE;
    public static final DONT_EVEN_TRY_TO_CREATE REALLY_TRY_TO_CREATE;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/common/util/concurrent/AbstractFuture$UnsafeAtomicHelperFactory, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    abstract y_3B_.clone tryCreateUnsafeAtomicHelper();

    static 
    {
        REALLY_TRY_TO_CREATE = new AbstractFuture.UnsafeAtomicHelperFactory("REALLY_TRY_TO_CREATE", 0) {

            AbstractFuture.AtomicHelper tryCreateUnsafeAtomicHelper()
            {
                return new AbstractFuture.UnsafeAtomicHelper(null);
            }

        };
        DONT_EVEN_TRY_TO_CREATE = new AbstractFuture.UnsafeAtomicHelperFactory("DONT_EVEN_TRY_TO_CREATE", 1) {

            AbstractFuture.AtomicHelper tryCreateUnsafeAtomicHelper()
            {
                return null;
            }

        };
        $VALUES = (new .VALUES[] {
            REALLY_TRY_TO_CREATE, DONT_EVEN_TRY_TO_CREATE
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
