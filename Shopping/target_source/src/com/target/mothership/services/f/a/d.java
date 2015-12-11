// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;


public class d
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a DELETE;
        public static final a GET;
        public static final a POST;
        public static final a PUT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/services/f/a/d$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            DELETE = new a("DELETE", 0);
            GET = new a("GET", 1);
            POST = new a("POST", 2);
            PUT = new a("PUT", 3);
            $VALUES = (new a[] {
                DELETE, GET, POST, PUT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static int a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method[];

            static 
            {
                $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method[a.DELETE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method[a.GET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method[a.POST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$endpoint$MethodProvider$Method[a.PUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.services.url.endpoint.MethodProvider.Method[a1.ordinal()])
        {
        default:
            throw new IllegalArgumentException("Unknown method");

        case 1: // '\001'
            return 3;

        case 2: // '\002'
            return 0;

        case 3: // '\003'
            return 1;

        case 4: // '\004'
            return 2;
        }
    }

    public static a a(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Unknown method");

        case 3: // '\003'
            return a.DELETE;

        case 0: // '\0'
            return a.GET;

        case 1: // '\001'
            return a.POST;

        case 2: // '\002'
            return a.PUT;
        }
    }
}
