// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static interface 
{

    public abstract void onAuthorizationFailure(VPMedia vpmedia, String s);

    public abstract void onAuthorizationSuccess(VPMedia vpmedia);

    public abstract void onAuthorizationTokenRequest(VPMedia vpmedia);
}
