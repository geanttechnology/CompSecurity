// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import acd;
import agw;
import ahf;
import aho;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.voice.MicrophoneView;
import vq;
import zq;
import zr;

public class VoiceSearchActivity extends vq
{

    private static final String j = com/google/android/apps/youtube/kids/activities/VoiceSearchActivity.getSimpleName();
    public ahf h;
    public MicrophoneView i;
    private TextView k;
    private SoundPool l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private final aho s = new zr(this);

    public VoiceSearchActivity()
    {
        r = false;
    }

    public static String a(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.m;
    }

    public static String a(VoiceSearchActivity voicesearchactivity, String s1)
    {
        voicesearchactivity.m = s1;
        return s1;
    }

    public static void a(VoiceSearchActivity voicesearchactivity, int i1)
    {
        voicesearchactivity.l.play(i1, 1.0F, 1.0F, 0, 1, 1.0F);
    }

    public static ahf b(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.h;
    }

    public static void b(VoiceSearchActivity voicesearchactivity, String s1)
    {
        Intent intent = new Intent();
        intent.putExtra("RecognizedText", s1);
        voicesearchactivity.setResult(-1, intent);
        voicesearchactivity.finish();
    }

    public static int c(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.p;
    }

    public static int d(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.n;
    }

    public static MicrophoneView e(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.i;
    }

    public static TextView f(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.k;
    }

    public static int g(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.o;
    }

    public static int h(VoiceSearchActivity voicesearchactivity)
    {
        return voicesearchactivity.q;
    }

    public static String j()
    {
        return j;
    }

    protected final void g()
    {
        g.a(false);
    }

    public final void h()
    {
        r = false;
        h.d().b = false;
        h.a();
        i.a();
    }

    public final void i()
    {
        h.c();
        i.c();
    }

    public void onCreate(Bundle bundle)
    {
        setContentView(0x7f040069);
        super.onCreate(bundle);
        l = new SoundPool(5, 3, 0);
        n = l.load(this, 0x7f080008, 1);
        o = l.load(this, 0x7f08000c, 1);
        p = l.load(this, 0x7f080007, 1);
        q = l.load(this, 0x7f080004, 1);
        i = (MicrophoneView)findViewById(0x7f1001c3);
        i.setOnClickListener(new zq(this));
        k = (TextView)findViewById(0x7f1001c9);
        h = ahf.a(getApplicationContext());
        h.a = s;
        r = true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        l.release();
    }

    public void onPause()
    {
        super.onPause();
        i();
    }

    public void onResume()
    {
        super.onResume();
        if (r)
        {
            h();
        }
    }

}
