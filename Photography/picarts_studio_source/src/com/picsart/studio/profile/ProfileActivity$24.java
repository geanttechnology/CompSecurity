// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;


// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements Runnable
{

    private ProfileActivity a;

    public final void run()
    {
        ProfileActivity.f(a);
    }

    (ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
