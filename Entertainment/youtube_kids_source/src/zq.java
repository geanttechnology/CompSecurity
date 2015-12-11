// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.VoiceSearchActivity;

public final class zq
    implements android.view.View.OnClickListener
{

    private VoiceSearchActivity a;

    public zq(VoiceSearchActivity voicesearchactivity)
    {
        a = voicesearchactivity;
        super();
    }

    public final void onClick(View view)
    {
label0:
        {
            if (VoiceSearchActivity.a(a) == null || VoiceSearchActivity.a(a).isEmpty())
            {
                if (!VoiceSearchActivity.b(a).b)
                {
                    break label0;
                }
                VoiceSearchActivity.a(a, VoiceSearchActivity.c(a));
                a.i();
            }
            return;
        }
        a.h();
    }
}
