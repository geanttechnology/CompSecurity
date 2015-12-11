// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.activities.VoiceSearchActivity;
import com.google.android.apps.youtube.kids.voice.BitmapSoundLevelsView;
import com.google.android.apps.youtube.kids.voice.MicrophoneView;

public final class zr
    implements aho
{

    private VoiceSearchActivity a;

    public zr(VoiceSearchActivity voicesearchactivity)
    {
        a = voicesearchactivity;
        super();
    }

    public final void a()
    {
        VoiceSearchActivity.a(a, VoiceSearchActivity.d(a));
        VoiceSearchActivity.e(a).a();
    }

    public final void a(dap dap1)
    {
        String s = VoiceSearchActivity.j();
        dap1 = String.valueOf(dap1.getMessage());
        if (dap1.length() != 0)
        {
            dap1 = "onRecognitionError:".concat(dap1);
        } else
        {
            dap1 = new String("onRecognitionError:");
        }
        Log.e(s, dap1);
        VoiceSearchActivity.a(a, VoiceSearchActivity.h(a));
        a.i();
    }

    public final void a(dax dax)
    {
        VoiceSearchActivity.e(a).a.a = dax;
        VoiceSearchActivity.f(a).setText("");
        VoiceSearchActivity.a(a, "");
    }

    public final void a(String s)
    {
        VoiceSearchActivity.e(a).d();
        VoiceSearchActivity.a(a, s);
        if (VoiceSearchActivity.a(a) == null || VoiceSearchActivity.a(a).isEmpty())
        {
            VoiceSearchActivity.a(a, VoiceSearchActivity.c(a));
            return;
        } else
        {
            VoiceSearchActivity.a(a, VoiceSearchActivity.g(a));
            VoiceSearchActivity.b(a, VoiceSearchActivity.a(a));
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            VoiceSearchActivity voicesearchactivity = a;
            voicesearchactivity.h.b();
            voicesearchactivity.i.c();
        }
    }

    public final void b()
    {
        VoiceSearchActivity.e(a).b();
    }

    public final void c()
    {
        VoiceSearchActivity.e(a).c();
    }
}
