// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.apps.youtube.kids.activities.BrowseActivity;

public final class wf
    implements acq
{

    public wf()
    {
    }

    public final void a(dre dre1, Activity activity)
    {
        b.a(dre1.c);
        Intent intent = new Intent(activity, com/google/android/apps/youtube/kids/activities/BrowseActivity);
        intent.putExtra("browseId", dre1.c.a);
        Bundle bundle = new Bundle();
        bundle.putByteArray("navigation_endpoint", eun.a(dre1));
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
