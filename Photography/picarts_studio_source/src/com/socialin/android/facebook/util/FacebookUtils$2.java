// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.socialin.android.activity.ActivityResultListener;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class r
    implements ActivityResultListener
{

    public final void onActivityResult(int i, int j, Intent intent)
    {
        if (FacebookUtils.access$800() != null && FacebookSdk.isFacebookRequestCode(i))
        {
            FacebookUtils.access$800().onActivityResult(i, j, intent);
        }
    }

    r()
    {
    }
}
