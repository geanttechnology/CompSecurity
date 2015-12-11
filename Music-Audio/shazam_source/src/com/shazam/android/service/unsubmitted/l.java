// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.service.a;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            UnsubmittedTagsSubmittingService

public final class l
    implements a
{

    public l()
    {
    }

    public final void a(Context context)
    {
        context.startService(new Intent(context, com/shazam/android/service/unsubmitted/UnsubmittedTagsSubmittingService));
    }
}
