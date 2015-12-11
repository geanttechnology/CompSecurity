// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class acd
{

    MediaPlayer a;
    AudioManager b;
    SharedPreferences c;
    public boolean d;
    boolean e;
    public ack f;
    List g;
    android.media.AudioManager.OnAudioFocusChangeListener h;
    private Context i;
    private SoundPool j;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener k;
    private int l;
    private Map m;
    private PhoneStateListener n;
    private BroadcastReceiver o;

    public acd(Context context)
    {
        k = new ace(this);
        l = 0;
        m = new HashMap();
        h = new acf(this);
        n = new acg(this);
        o = new ach(this);
        i = context;
        j = new SoundPool(1, 3, 0);
        g = new ArrayList();
        g.add(Integer.valueOf(0x7f080014));
        g.add(Integer.valueOf(0x7f080013));
        g.add(Integer.valueOf(0x7f080010));
        g.add(Integer.valueOf(0x7f08001b));
        g.add(Integer.valueOf(0x7f080012));
        g.add(Integer.valueOf(0x7f080011));
        g.add(Integer.valueOf(0x7f08000f));
        g.add(Integer.valueOf(0x7f080018));
        g.add(Integer.valueOf(0x7f08001a));
        g.add(Integer.valueOf(0x7f080019));
        g.add(Integer.valueOf(0x7f080015));
        g.add(Integer.valueOf(0x7f080016));
        g.add(Integer.valueOf(0x7f080017));
        g.add(Integer.valueOf(0x7f08001c));
        g.add(Integer.valueOf(0x7f08001d));
        j.setOnLoadCompleteListener(new acj(this));
        a(((Integer)g.remove(0)).intValue());
        f = new ack(this);
        a = new MediaPlayer();
        c = PreferenceManager.getDefaultSharedPreferences(context);
        c.registerOnSharedPreferenceChangeListener(k);
        d = c.getBoolean("background_music", true);
        e = c.getBoolean("sound_effects", true);
        b = (AudioManager)context.getSystemService("audio");
        AssetFileDescriptor assetfiledescriptor = i.getResources().openRawResourceFd(0x7f08000e);
        if (assetfiledescriptor != null)
        {
            try
            {
                a.setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength());
                a.prepare();
                a.setLooping(true);
            }
            catch (IOException ioexception)
            {
                Log.e("backgroundMusic", ioexception.getMessage());
            }
        }
        ((TelephonyManager)context.getSystemService("phone")).listen(n, 32);
        context.registerReceiver(o, new IntentFilter("android.intent.action.SCREEN_OFF"));
        context = (AccessibilityManager)context.getSystemService("accessibility");
        if (context.isEnabled())
        {
            f.a(true);
        }
        context.addAccessibilityStateChangeListener(new aci(this));
    }

    float a()
    {
        return (float)b.getStreamVolume(3) / (float)b.getStreamMaxVolume(3);
    }

    void a(int i1)
    {
        int j1 = j.load(i, i1, 1);
        m.put(Integer.valueOf(i1), Integer.valueOf(j1));
    }

    public final void a(boolean flag)
    {
        ack ack1 = f;
        ack1.d = flag;
        if (ack1.a != 1 && !flag)
        {
            ack1.a(4);
        }
    }

    public final void b(int i1)
    {
        Integer integer;
        if (e)
        {
            if ((integer = (Integer)m.get(Integer.valueOf(i1))) != null)
            {
                i1 = integer.intValue();
                float f1 = a();
                j.play(i1, f1, f1, 1, 0, 1.0F);
                return;
            }
        }
    }

    public final void b(boolean flag)
    {
        if (flag)
        {
            l = l + 1;
        } else
        {
            l = l - 1;
        }
        if (l <= 0)
        {
            ack ack1 = f;
            if (ack1.a != 1)
            {
                ack1.a(6);
            }
        } else
        {
            ack ack2 = f;
            if (ack2.a != 1)
            {
                if (ack2.f.d && ack2.d && !ack2.e)
                {
                    ack2.a(3);
                    return;
                } else
                {
                    ack2.a(2);
                    return;
                }
            }
        }
    }

    public final void c(boolean flag)
    {
        ack ack1 = f;
        if (!flag || ack1.a != 1) goto _L2; else goto _L1
_L1:
        if (!ack1.f.d || ack1.e) goto _L4; else goto _L3
_L3:
        ack1.a(3);
_L6:
        return;
_L4:
        ack1.a(2);
        return;
_L2:
        if (!flag)
        {
            ack1.a(1);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
