// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.apps.youtube.kids.activities.WatchActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public class zz
    implements acq
{

    public zz()
    {
    }

    public void a(dre dre1, Activity activity)
    {
        b.a(dre1.e);
        cto cto1 = new cto(dre1);
        Intent intent;
        Bundle bundle;
        if (KidsApplication.a(PreferenceManager.getDefaultSharedPreferences((KidsApplication)activity.getApplicationContext()), 0xdc1f4))
        {
            intent = new Intent(activity, yw);
        } else
        {
            intent = new Intent(activity, com/google/android/apps/youtube/kids/activities/WatchActivity);
        }
        bundle = new Bundle();
        bundle.putParcelable("playbackStartDescriptor", cto1);
        bundle.putByteArray("navigation_endpoint", eun.a(dre1));
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
