// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

private static final class  extends Enum
{

    private static final ReferredAppFirstSignIn $VALUES[];
    public static final ReferredAppFirstSignIn NewUserNoSSO;
    public static final ReferredAppFirstSignIn NewUserSSO;
    public static final ReferredAppFirstSignIn OpenSignIn;
    public static final ReferredAppFirstSignIn ReferredAppFirstSignIn;
    public static final ReferredAppFirstSignIn SignInFailure;
    public static final ReferredAppFirstSignIn SignInSuccess;
    public static final ReferredAppFirstSignIn UseDifferentAccount;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/SignInActivity$MetricEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OpenSignIn = new <init>("OpenSignIn", 0);
        NewUserSSO = new <init>("NewUserSSO", 1);
        NewUserNoSSO = new <init>("NewUserNoSSO", 2);
        UseDifferentAccount = new <init>("UseDifferentAccount", 3);
        SignInSuccess = new <init>("SignInSuccess", 4);
        SignInFailure = new <init>("SignInFailure", 5);
        ReferredAppFirstSignIn = new <init>("ReferredAppFirstSignIn", 6);
        $VALUES = (new .VALUES[] {
            OpenSignIn, NewUserSSO, NewUserNoSSO, UseDifferentAccount, SignInSuccess, SignInFailure, ReferredAppFirstSignIn
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
