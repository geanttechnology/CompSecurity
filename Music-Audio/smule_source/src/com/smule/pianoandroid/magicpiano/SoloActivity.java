// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.w;
import com.smule.android.f.h;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, MagicGLSurfaceView, az, MagicApplication

public class SoloActivity extends ag
    implements ab
{

    static final String a = com/smule/pianoandroid/magicpiano/SoloActivity.getName();
    public MagicGLSurfaceView b;
    Observer c;
    private SoundPoolSynth d;
    private az e;
    private boolean f;

    public SoloActivity()
    {
        f = false;
    }

    static boolean a(SoloActivity soloactivity)
    {
        return soloactivity.f;
    }

    static void b(SoloActivity soloactivity)
    {
        soloactivity.d();
    }

    private void c()
    {
        aa.c(a, "resumeCore");
        PianoCoreBridge.reloadTextures();
        PianoCoreBridge.resize(b.getRendererWidth(), b.getRendererHeight());
    }

    static void c(SoloActivity soloactivity)
    {
        soloactivity.c();
    }

    private void d()
    {
        aa.c(a, "initCore");
        PianoCoreBridge.initGfx(getApplicationContext(), b.getRendererWidth(), b.getRendererHeight());
        PianoCoreBridge.togglePianoVisuals(true);
        PianoCoreBridge.startFreeplay();
        f = true;
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "Solo";
    }

    public void onBackPressed()
    {
        o.e(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030070);
        b = (MagicGLSurfaceView)findViewById(0x7f0a0139);
        b.a(getApplicationContext());
        setVolumeControlStream(3);
        if (((AudioManager)getSystemService("audio")).isWiredHeadsetOn())
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(1);
        } else
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(0);
        }
        d = new SoundPoolSynth();
        d.onCreate(getApplicationContext());
        bundle = new IntentFilter("android.intent.action.HEADSET_PLUG");
        e = new az(this);
        registerReceiver(e, bundle);
        PianoCoreBridge.setContext(this);
        PianoCoreBridge.initSoundPoolBridge(d);
        w.b("solo_time");
        c = new Observer() {

            final SoloActivity a;

            public void update(Observable observable, Object obj)
            {
                if (!SoloActivity.a(a))
                {
                    SoloActivity.b(a);
                    return;
                } else
                {
                    SoloActivity.c(a);
                    return;
                }
            }

            
            {
                a = SoloActivity.this;
                super();
            }
        };
        q.s();
        h.a().a("RENDERER_INITIALIZED", c);
        m.a(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0003, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(e);
        h.a().b("RENDERER_INITIALIZED", c);
        PianoCoreBridge.setContext(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0a024e)
        {
            PianoCoreBridge.cycleKeyboardState();
        } else
        {
            super.onOptionsItemSelected(menuitem);
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
        w.c("solo_time");
        b.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        MagicApplication.getInstance().onResume();
        aa.c(a, "Resuming synth");
        if (d != null)
        {
            d.onResume();
            PianoCoreBridge.initSoundPoolBridge(d);
        }
        aa.c(a, "Resuming GL View");
        if (b != null)
        {
            b.onResume();
        }
        aa.c(a, "GL View Resumed");
        w.b("solo_time");
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
        if (d != null)
        {
            d.onStop();
        }
    }

}
