// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fitbit.activity.ui.activitylog;

import android.content.Context;
import com.fitbit.data.bl.ActivityBusinessLogic;
import com.fitbit.data.domain.ActivityLogEntry;
import com.fitbit.util.bf;
import java.util.UUID;

// Referenced classes of package com.fitbit.activity.ui.activitylog:
//            UpdateRecordedExerciseActivity

private static class a extends bf
{

    private final UUID a;

    protected ActivityLogEntry a()
    {
        return ActivityBusinessLogic.a().a(a);
    }

    protected Object f_()
    {
        return a();
    }

    public I(Context context, UUID uuid)
    {
        super(context);
        a = uuid;
    }
}
