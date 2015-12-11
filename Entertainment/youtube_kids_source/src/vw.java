// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.view.View;
import com.google.android.apps.youtube.kids.activities.SearchActivity;

final class vw
    implements android.view.View.OnClickListener
{

    private vq a;

    vw(vq vq1)
    {
        a = vq1;
        super();
    }

    public final void onClick(View view)
    {
        a.startActivity(new Intent(a, com/google/android/apps/youtube/kids/activities/SearchActivity));
    }
}
