// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ActionHandler extends Activity
{

    private HashMap a;
    private RelativeLayout b;

    public ActionHandler()
    {
        a = new HashMap();
    }

    private MraidPlayer a(Bundle bundle, MraidView.Action action)
    {
        com.tapjoy.mraid.controller.Abstract.PlayerProperties playerproperties = (com.tapjoy.mraid.controller.Abstract.PlayerProperties)bundle.getParcelable("player_properties");
        com.tapjoy.mraid.controller.Abstract.Dimensions dimensions = (com.tapjoy.mraid.controller.Abstract.Dimensions)bundle.getParcelable("expand_dimensions");
        MraidPlayer mraidplayer = new MraidPlayer(this);
        mraidplayer.setPlayData(playerproperties, Utils.getData("expand_url", bundle));
        if (!playerproperties.inline && playerproperties.startStyle.equals("fullscreen"))
        {
            getWindow().setFlags(1024, 1024);
            getWindow().setFlags(0x1000000, 0x1000000);
            bundle = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            bundle.addRule(13);
        } else
        {
            bundle = new android.widget.RelativeLayout.LayoutParams(dimensions.width, dimensions.height);
            bundle.topMargin = dimensions.y;
            bundle.leftMargin = dimensions.x;
        }
        mraidplayer.setLayoutParams(bundle);
        b.addView(mraidplayer);
        a.put(action, mraidplayer);
        mraidplayer.setListener(new Player() {

            final ActionHandler a;

            public final void onComplete()
            {
                a.finish();
            }

            public final void onError()
            {
                a.finish();
            }

            public final void onPrepared()
            {
            }

            
            {
                a = ActionHandler.this;
                super();
            }
        });
        return mraidplayer;
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        requestWindowFeature(1);
        bundle = getIntent().getExtras();
        b = new RelativeLayout(this);
        b.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        b.setBackgroundColor(0xff000000);
        setContentView(b);
        obj = bundle.getString("action");
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = MraidView.Action.valueOf(((String) (obj)));
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[MraidView.Action.values().length];
                try
                {
                    a[MraidView.Action.PLAY_AUDIO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MraidView.Action.PLAY_VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[((MraidView.Action) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 112
    //                   1 113
    //                   2 123;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        a(bundle, ((MraidView.Action) (obj))).playAudio();
        return;
_L4:
        a(bundle, ((MraidView.Action) (obj))).playVideo();
        return;
    }

    protected void onStop()
    {
        Iterator iterator = a.entrySet().iterator();
        do
        {
            if (iterator.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                switch (_cls2.a[((MraidView.Action)entry.getKey()).ordinal()])
                {
                case 1: // '\001'
                case 2: // '\002'
                    ((MraidPlayer)entry.getValue()).releasePlayer();
                    break;
                }
            } else
            {
                super.onStop();
                return;
            }
        } while (true);
    }
}
