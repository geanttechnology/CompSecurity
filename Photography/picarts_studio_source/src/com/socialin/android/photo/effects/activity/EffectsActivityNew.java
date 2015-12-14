// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.c;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.invite.i;
import java.util.HashMap;
import myobfuscated.ck.a;
import myobfuscated.ck.e;

// Referenced classes of package com.socialin.android.photo.effects.activity:
//            a

public class EffectsActivityNew extends AdBaseActivity
{

    public static boolean a = false;
    private static Bitmap c = null;
    private com.socialin.android.photo.effects.activity.a b;

    public EffectsActivityNew()
    {
    }

    public static Intent a(Context context, String s, Bitmap bitmap, HashMap hashmap, String s1, int j, int k, HashMap hashmap1, 
            boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        context = new Intent(context, com/socialin/android/photo/effects/activity/EffectsActivityNew);
        context.putExtra("origin", s);
        context.putExtra("path", s1);
        if (hashmap != null)
        {
            context.putExtra("bufferData", hashmap);
        }
        context.putExtra("degree", j);
        context.putExtra("pixelsMaxCount", k);
        if (hashmap1 != null)
        {
            context.putExtra("maskBufferData", hashmap1);
        }
        context.putExtra("closeAfterEdit", flag3);
        context.putExtra("isReturn", flag);
        context.putExtra("FX_SAVE_RESULT_AS_BUFFER", flag1);
        context.putExtra("FX_SAVE_RESULT_TO_RECENTS", false);
        c = bitmap;
        return context;
    }

    public static Intent a(Context context, String s, HashMap hashmap, String s1, int j, int k)
    {
        return a(context, s, null, hashmap, s1, j, k, null, true, true, false, false);
    }

    private boolean a()
    {
        String s;
        if (getIntent() != null && getIntent().hasExtra("from"))
        {
            s = getIntent().getStringExtra("from");
        } else
        {
            s = "";
        }
        return s != null && "editor".equals(s);
    }

    protected void checkForInviteDialogs(Boolean boolean1)
    {
        if (!a())
        {
            showEnjoyDialog = i.a(this, boolean1);
        }
    }

    public void executeInviteNotificaionAction()
    {
        if (!a())
        {
            i.a(this);
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void hideAdWithAnimation()
    {
        i.a(this, getAdLayout(), true);
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (k == -1 && j == 1124)
        {
            initAd();
        }
    }

    public void onBackPressed()
    {
        Object obj = getFragmentManager().findFragmentByTag(a.a);
        if (obj != null)
        {
            obj = (a)obj;
            boolean flag;
            if (((a) (obj)).i())
            {
                flag = true;
            } else
            if (((a) (obj)).b.j())
            {
                ((a) (obj)).b.i();
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return;
            }
        }
        i.a(this).edit().putBoolean("is_editor_active", false).apply();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030022);
        b = new com.socialin.android.photo.effects.activity.a(this, (byte)0);
        registerReceiver(b, new IntentFilter("update.adds.enabled.action"));
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager.findFragmentByTag(a.a) == null)
        {
            a = false;
            Intent intent = getIntent();
            String s = "unknown";
            AnalyticUtils.getInstance(this).trackLocalAction("effect:onCreate");
            if (intent.hasExtra("origin"))
            {
                s = intent.getStringExtra("origin");
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.EffectOpenEvent(s));
            }
            a a1 = new a();
            Bundle bundle1 = new Bundle();
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (intent.hasExtra("editing_data"))
            {
                bundle = (EditingData)intent.getParcelableExtra("editing_data");
                Log.e("ex1", (new StringBuilder("editingData uid = ")).append(((EditingData) (bundle)).a).toString());
            } else
            {
                bundle = null;
            }
            if (bundle == null)
            {
                bundle = EditingData.a(com.picsart.studio.utils.c.a(this, null), s);
            }
            if (intent.hasExtra("bufferData"))
            {
                bundle1.putSerializable("bufferData", (HashMap)intent.getSerializableExtra("bufferData"));
            }
            bundle1.putParcelable("editing_data", bundle);
            bundle1.putString("path", intent.getStringExtra("path"));
            bundle1.putInt("degree", intent.getIntExtra("degree", 0));
            bundle1.putInt("pixelsMaxCount", intent.getIntExtra("pixelsMaxCount", PicsartContext.a(this)));
            flag = intent.getBooleanExtra("isReturn", false);
            flag1 = intent.getBooleanExtra("closeAfterEdit", false);
            flag2 = intent.getBooleanExtra("FX_SAVE_RESULT_AS_BUFFER", false);
            flag3 = intent.getBooleanExtra("FX_SAVE_RESULT_TO_RECENTS", false);
            bundle1.putBoolean("isReturn", flag);
            bundle1.putBoolean("closeAfterEdit", flag1);
            bundle1.putBoolean("FX_SAVE_RESULT_AS_BUFFER", flag2);
            bundle1.putBoolean("FX_SAVE_RESULT_TO_RECENTS", flag3);
            if (intent.hasExtra("maskBufferData"))
            {
                bundle1.putSerializable("maskBufferData", (HashMap)intent.getSerializableExtra("maskBufferData"));
            }
            a1.setArguments(bundle1);
            a1.c = c;
            c = null;
            a1.setRetainInstance(true);
            bundle = fragmentmanager.beginTransaction();
            bundle.replace(0x7f100143, a1, a.a);
            bundle.commit();
        }
        i.b(this);
    }

    protected void onDestroy()
    {
        if (b != null)
        {
            unregisterReceiver(b);
        }
        super.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
        i.a(this).edit().putBoolean("is_editor_active", true).apply();
    }

    protected void onStart()
    {
        super.onStart();
        initAd();
    }

}
