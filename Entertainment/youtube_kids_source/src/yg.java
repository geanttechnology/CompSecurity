// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class yg extends vq
{

    private static final String h = yg.getSimpleName();
    private adw i;
    private aec j;
    private View k;
    private View l;
    private VideoView m;
    private aei n;

    public yg()
    {
    }

    static adw a(yg yg1)
    {
        return yg1.i;
    }

    public static Intent a(Context context, aei aei1)
    {
        context = new Intent(context, yg);
        context.putExtra("review_sing_along_recording", aei1);
        return context;
    }

    static aei b(yg yg1)
    {
        return yg1.n;
    }

    static String h()
    {
        return h;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04005b);
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.getParcelable("review_sing_along_recording") != null)
        {
            n = (aei)bundle.getParcelable("review_sing_along_recording");
        } else
        {
            finish();
        }
        m = (VideoView)findViewById(0x7f100195);
        k = findViewById(0x7f100196);
        k.setOnClickListener(new yh(this));
        l = findViewById(0x7f100197);
        l.setOnClickListener(new yi(this));
        m.setVideoPath(n.getRecordingPath());
        i = new adw(this);
        j = new aec(i, m, null);
        ((ViewGroup)findViewById(0x7f100190)).addView(i);
    }

    protected void onDestroy()
    {
        i.onActivityDestroy();
        super.onDestroy();
    }

    protected void onPause()
    {
        m.pause();
        i.setControlsState(cuv.c);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        j.startRecordingPlayback();
    }

}
