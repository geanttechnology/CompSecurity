// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


// Referenced classes of package com.shazam.android.advert:
//            AdBinderStrategyType

public final class h
{

    public h()
    {
    }

    // Unreferenced inner class com/shazam/android/advert/h$1

/* anonymous class */
    public static final class _cls1
    {

        public static final int a[];

        static 
        {
            a = new int[AdBinderStrategyType.values().length];
            try
            {
                a[AdBinderStrategyType.RESUMING.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[AdBinderStrategyType.DEFERRED_REQUEST_RESUMING.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[AdBinderStrategyType.SELECTION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[AdBinderStrategyType.PASSIVE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
