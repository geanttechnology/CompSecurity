// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.util.an;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserAvatarUploadActivity

final class a extends an
{

    private UserAvatarUploadActivity a;

    protected final Object doInBackground(Object aobj[])
    {
        return a.a(UserAvatarUploadActivity.e(a));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        UserAvatarUploadActivity.c(a, ((String) (obj)));
    }

    (UserAvatarUploadActivity useravataruploadactivity)
    {
        a = useravataruploadactivity;
        super();
    }
}
