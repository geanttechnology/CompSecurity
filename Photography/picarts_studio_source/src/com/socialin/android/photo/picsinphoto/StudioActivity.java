// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import com.picsart.collages.CollagesActivity;
import com.picsart.studio.EditingData;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.activity.StandaloneCropToolActivity;
import com.picsart.studio.util.StudioManager;
import com.picsart.studio.utils.c;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.draw.DrawingActivity;
import com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog;
import com.socialin.android.photo.draw.dialog.a;
import com.socialin.android.photo.draw.dialog.b;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.template.Template;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.x;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            g

public class StudioActivity extends BaseActivity
{

    private String a;
    private int b;
    private HashMap c;
    private String d;
    private String e;
    private String f;

    public StudioActivity()
    {
    }

    static String a(StudioActivity studioactivity)
    {
        return studioactivity.a;
    }

    private void a(Intent intent)
    {
        a = intent.getExtras().getString("path");
        b = intent.getExtras().getInt("degree");
        if (intent.hasExtra("bufferData"))
        {
            c = (HashMap)intent.getSerializableExtra("bufferData");
        }
        StudioManager.checkForRecommendedSizeAndDoAction(this, a, c, new Runnable() {

            private StudioActivity a;

            public final void run()
            {
                com.socialin.android.photo.picsinphoto.StudioActivity.a(a, com.socialin.android.photo.picsinphoto.StudioActivity.a(a), com.socialin.android.photo.picsinphoto.StudioActivity.b(a), com.socialin.android.photo.picsinphoto.StudioActivity.c(a), StudioActivity.e(a));
            }

            
            {
                a = StudioActivity.this;
                super();
            }
        }, new Runnable() {

            private StudioActivity a;

            public final void run()
            {
                a.finish();
            }

            
            {
                a = StudioActivity.this;
                super();
            }
        });
    }

    static void a(StudioActivity studioactivity, String s, HashMap hashmap, int j, String s1)
    {
        Intent intent = new Intent(studioactivity, com/socialin/android/photo/draw/DrawingActivity);
        intent.putExtra("from", "default");
        intent.putExtra("extra.has.bg.image", true);
        intent.putExtra("path", s);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("editing_data", EditingData.a(com.picsart.studio.utils.c.a(studioactivity, null), s1));
        intent.putExtra("degree", j);
        intent.putExtra("comingFrom", 1);
        studioactivity.startActivityForResult(intent, 0);
    }

    private void a(String s, HashMap hashmap, int j, String s1)
    {
        a(s, hashmap, j, false, s1);
    }

    private void a(String s, HashMap hashmap, int j, boolean flag, String s1)
    {
        StudioManager.checkForRecommendedSizeAndDoAction(this, s, hashmap, new Runnable(s, j, hashmap, s1, flag) {

            private String a;
            private int b;
            private HashMap c;
            private String d;
            private boolean e;
            private StudioActivity f;

            public final void run()
            {
                Intent intent = new Intent(f, com/picsart/studio/editor/activity/EditorActivity);
                intent.putExtra("path", a);
                intent.putExtra("degree", b);
                intent.putExtra("bufferData", c);
                intent.putExtra("origin", d);
                if (e)
                {
                    intent.setAction("action.photo.for.collage");
                }
                f.startActivityForResult(intent, 0);
                f.finish();
            }

            
            {
                f = StudioActivity.this;
                a = s;
                b = j;
                c = hashmap;
                d = s1;
                e = flag;
                super();
            }
        }, new Runnable() {

            private StudioActivity a;

            public final void run()
            {
                a.finish();
            }

            
            {
                a = StudioActivity.this;
                super();
            }
        });
    }

    static HashMap b(StudioActivity studioactivity)
    {
        return studioactivity.c;
    }

    static int c(StudioActivity studioactivity)
    {
        return studioactivity.b;
    }

    static String d(StudioActivity studioactivity)
    {
        return studioactivity.d;
    }

    static String e(StudioActivity studioactivity)
    {
        return studioactivity.e;
    }

    public final void a()
    {
        AnalyticUtils.getInstance(this).trackLocalAction("start:collage_frame");
        Intent intent = new Intent(this, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "collage_frame");
        intent.putExtra("readFrom", "collage_frame.json");
        startActivityForResult(intent, 1010);
    }

    public final void a(int j, int k)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/draw/DrawingActivity);
        intent.putExtra("comingFrom", 1);
        intent.putExtra("extra.has.bg.image", false);
        intent.putExtra("extra.canvas.width", j);
        intent.putExtra("extra.canvas.height", k);
        intent.putExtra("editing_data", EditingData.a(com.picsart.studio.utils.c.a(this, null), "blank"));
        intent.putExtra("comingFrom", 1);
        intent.setFlags(0x20000);
        startActivityForResult(intent, 0);
        finish();
    }

    public final void a(int j, String s)
    {
        Intent intent = new Intent(this, com/picsart/studio/ImagePickerActivity);
        intent.setFlags(0x20000);
        intent.putExtra("from", s);
        intent.putExtra("showCameraEffects", true);
        intent.putExtra("extra.for.main.activity", true);
        myobfuscated.cv.c.a(intent, this);
        startActivityForResult(intent, j);
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        if (k != -1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR lookupswitch 9: default 88
    //                   101: 93
    //                   102: 182
    //                   107: 556
    //                   108: 734
    //                   109: 348
    //                   1010: 286
    //                   1011: 440
    //                   1012: 478
    //                   1013: 339;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
        finish();
_L14:
        return;
_L4:
        a = intent.getExtras().getString("path");
        b = intent.getExtras().getInt("degree");
        HashMap hashmap;
        if (intent.hasExtra("bufferData"))
        {
            hashmap = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            hashmap = null;
        }
        c = hashmap;
        e = intent.getStringExtra("origin");
        a(a, c, b, e);
        return;
_L5:
        a = intent.getExtras().getString("path");
        b = intent.getExtras().getInt("degree");
        d = intent.getStringExtra("origin");
        String s = intent.getStringExtra("origFile");
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            intent = null;
        }
        c = intent;
        StudioManager.checkForRecommendedSizeAndDoAction(this, a, c, new Runnable(s) {

            private StudioActivity a;

            public final void run()
            {
                StudioActivity studioactivity = a;
                String s3 = com.socialin.android.photo.picsinphoto.StudioActivity.a(a);
                HashMap hashmap2 = com.socialin.android.photo.picsinphoto.StudioActivity.b(a);
                int l = com.socialin.android.photo.picsinphoto.StudioActivity.c(a);
                studioactivity.startActivityForResult(EffectsActivityNew.a(studioactivity, StudioActivity.d(a), null, hashmap2, s3, l, PicsartContext.a(studioactivity), null, false, false, false, true), 0);
                studioactivity.finish();
            }

            
            {
                a = StudioActivity.this;
                super();
            }
        }, new Runnable() {

            private StudioActivity a;

            public final void run()
            {
                a.finish();
            }

            
            {
                a = StudioActivity.this;
                super();
            }
        });
        return;
_L9:
        intent = (Template)intent.getExtras().getParcelable("template");
        Intent intent1 = new Intent(this, com/picsart/collages/CollagesActivity);
        intent1.putExtra("collageTemplate", intent);
        intent1.putExtra("cType", 2);
        startActivityForResult(intent1, 1011);
        return;
_L12:
        startActivityForResult(intent, 1011);
        return;
_L8:
        a = intent.getExtras().getString("path");
        b = intent.getExtras().getInt("degree");
        x.a();
        String s1 = x.a(a, false);
        e = intent.getStringExtra("origin");
        i.a(getApplicationContext()).edit().putBoolean("invite_new_user_redeem_dialog_stop", true).apply();
        a(s1, ((HashMap) (null)), b, true, e);
        return;
_L10:
        a = intent.getExtras().getString("path");
        e = intent.getStringExtra("origin");
        a(a, null, 0, e);
        return;
_L11:
        if (isFinishing()) goto _L14; else goto _L13
_L13:
        a = intent.getExtras().getString("path");
        getIntent().putExtra("path", a);
        intent = new g(this, a);
        if ((SelectCanvasSizeDialog)getFragmentManager().findFragmentByTag("select.canvas.size.for.bg.dialog") != null) goto _L14; else goto _L15
_L15:
        SelectCanvasSizeDialog.a(intent).show(getFragmentManager(), "select.canvas.size.for.bg.dialog");
        return;
_L6:
        a = intent.getExtras().getString("path");
        b = intent.getExtras().getInt("degree");
        HashMap hashmap1;
        String s2;
        Intent intent2;
        if (intent.hasExtra("bufferData"))
        {
            hashmap1 = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            hashmap1 = null;
        }
        c = hashmap1;
        d = intent.getStringExtra("source");
        e = intent.getStringExtra("origin");
        intent = a;
        j = b;
        hashmap1 = c;
        s2 = d;
        intent2 = new Intent(this, com/picsart/studio/editor/activity/StandaloneCropToolActivity);
        intent2.putExtra("imagePath", intent);
        intent2.putExtra("bufferData", hashmap1);
        intent2.putExtra("degree", j);
        intent2.putExtra("source", s2);
        intent2.putExtra("maxPixel", PicsartContext.a.getMaxImageSizePixel());
        startActivityForResult(intent2, 108);
        return;
_L7:
        a(intent);
        return;
_L2:
        if (k == 0 && intent != null)
        {
            switch (j)
            {
            default:
                finish();
                return;

            case 108: // 'l'
                a(intent);
                break;
            }
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setLayout(-2, -2);
        Object obj = getIntent();
        int j;
        if (((Intent) (obj)).hasExtra("dialog.type"))
        {
            j = ((Intent) (obj)).getIntExtra("dialog.type", 0);
        } else
        {
            j = 0;
        }
        if (bundle == null)
        {
            if (((Intent) (obj)).getExtras() != null)
            {
                f = ((Intent) (obj)).getExtras().getString("session_id");
            }
        } else
        {
            f = bundle.getString("session_id");
        }
        PicsartContext.a(this);
        j;
        JVM INSTR tableswitch 1 7: default 112
    //                   1 131
    //                   2 262
    //                   3 112
    //                   4 310
    //                   5 368
    //                   6 432
    //                   7 441;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L7
_L1:
        finish();
_L9:
        return;
_L2:
        bundle = (SelectCanvasSizeDialog)getFragmentManager().findFragmentByTag("select.canvas.size.dialog");
        obj = (SelectCanvasSizeDialog)getFragmentManager().findFragmentByTag("select.canvas.size.for.bg.dialog");
        if (bundle == null && obj == null)
        {
            obj = (b)getFragmentManager().findFragmentByTag("drawing_pop_up");
            bundle = ((Bundle) (obj));
            if (obj == null)
            {
                bundle = new b();
                bundle.show(getFragmentManager(), "drawing_pop_up");
            }
            bundle.a = f;
            return;
        }
        if (bundle != null)
        {
            bundle.d = new myobfuscated.bj.b() {

                private StudioActivity a;

                public final void a(int k, int l)
                {
                    a.a(k, l);
                }

            
            {
                a = StudioActivity.this;
                super();
            }
            };
            return;
        } else
        {
            a = getIntent().getStringExtra("path");
            obj.d = new g(this, a);
            return;
        }
_L3:
        obj = (a)getFragmentManager().findFragmentByTag("collage_pop_up");
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            bundle = new a();
            bundle.show(getFragmentManager(), "collage_pop_up");
        }
        bundle.a = f;
        return;
_L4:
        bundle = (com.socialin.android.dialog.a)getFragmentManager().findFragmentByTag("dialogChoosePhotoSize");
        if (bundle == null)
        {
            a(102, "effect");
            getIntent().putExtra("openEffect", false);
            return;
        }
        getFragmentManager().beginTransaction().remove(bundle).commit();
        continue; /* Loop/switch isn't completed */
_L5:
        if (bundle != null) goto _L9; else goto _L8
_L8:
        bundle = (com.socialin.android.dialog.a)getFragmentManager().findFragmentByTag("dialogChoosePhotoSize");
        if (bundle == null)
        {
            a(101, "photo");
            getIntent().putExtra("openEdit", false);
            return;
        } else
        {
            getFragmentManager().beginTransaction().remove(bundle).commit();
            finish();
            return;
        }
_L6:
        if (bundle != null) goto _L9; else goto _L10
_L10:
        a();
        return;
_L7:
        if (bundle != null) goto _L9; else goto _L11
_L11:
        bundle = SelectCanvasSizeDialog.a(this);
        a(((Point) (bundle)).x, ((Point) (bundle)).y);
        return;
        if (true) goto _L1; else goto _L12
_L12:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("session_id", f);
    }

    // Unreferenced inner class com/socialin/android/photo/picsinphoto/StudioActivity$6

/* anonymous class */
    public final class _cls6
        implements myobfuscated.bj.b
    {

        private StudioActivity a;

        public final void a(int j, int k)
        {
            a.a(j, k);
        }

            public 
            {
                a = StudioActivity.this;
                super();
            }
    }

}
