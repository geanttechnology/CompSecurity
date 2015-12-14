// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.StandaloneCropToolActivity;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.d;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.view.ColorView;
import com.socialin.android.util.AnimUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateView, TemplateImage, h, Template, 
//            SelectCustomCollageActivity

public class TemplateActivity extends AdBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String b = com/socialin/android/photo/template/TemplateActivity.getSimpleName();
    public com.socialin.android.dialog.g a;
    private f c;
    private com.socialin.android.colorpicker.c d;
    private View e;
    private TemplateView f;
    private String g;
    private int h;
    private HashMap i;
    private int j;
    private Template k;

    public TemplateActivity()
    {
        a = null;
        e = null;
        f = null;
        g = null;
        h = 0;
        i = null;
        j = 1;
        k = null;
    }

    static int a(TemplateActivity templateactivity)
    {
        return templateactivity.j;
    }

    static CallbackManager a(CallbackManager callbackmanager)
    {
        return callbackmanager;
    }

    private void a(com.socialin.android.colorpicker.c c1, int l)
    {
        g g1 = new g();
        g1.a = c1;
        g1.e = l;
        g1.f = l;
        g1.c = true;
        c = g1.a(this);
        new WeakReference(c);
        if (!c.isShowing())
        {
            c.show();
        }
    }

    static TemplateView b(TemplateActivity templateactivity)
    {
        return templateactivity.f;
    }

    private void c()
    {
        d();
        ((RelativeLayout)findViewById(0x7f100a94)).addView(f);
        findViewById(0x7f100296).setOnClickListener(this);
        findViewById(0x7f100a9b).setOnClickListener(this);
        findViewById(0x7f100298).setOnClickListener(this);
        findViewById(0x7f100299).setOnClickListener(this);
        findViewById(0x7f10029a).setOnClickListener(this);
        findViewById(0x7f1002ac).setOnClickListener(this);
        findViewById(0x7f1002ae).setOnClickListener(this);
        findViewById(0x7f100a96).setOnClickListener(this);
        findViewById(0x7f100a97).setOnClickListener(this);
        findViewById(0x7f100a99).setOnClickListener(this);
        findViewById(0x7f100a98).setOnClickListener(this);
        findViewById(0x7f100a9a).setOnClickListener(this);
        e = findViewById(0x7f100a95);
        ((SeekBar)findViewById(0x7f1002ab)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private TemplateActivity a;

            public final void onProgressChanged(SeekBar seekbar, int l, boolean flag)
            {
                if (TemplateActivity.a(a) == 0)
                {
                    com.socialin.android.photo.template.TemplateActivity.b(a).setBorder(l);
                    ((TextView)a.findViewById(0x7f1002aa)).setText((new StringBuilder(" ")).append(l).toString());
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = TemplateActivity.this;
                super();
            }
        });
        ((SeekBar)findViewById(0x7f1002a7)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private TemplateActivity a;

            public final void onProgressChanged(SeekBar seekbar, int l, boolean flag)
            {
                if (TemplateActivity.a(a) == 0)
                {
                    com.socialin.android.photo.template.TemplateActivity.b(a).setCornerRadius(l);
                    ((TextView)a.findViewById(0x7f1002a6)).setText((new StringBuilder(" ")).append(l).append("%").toString());
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = TemplateActivity.this;
                super();
            }
        });
        h();
    }

    static void c(TemplateActivity templateactivity)
    {
        templateactivity.h();
    }

    static BaseActivity d(TemplateActivity templateactivity)
    {
        return templateactivity.self;
    }

    private void d()
    {
        if (j == 0)
        {
            SlidingDrawer slidingdrawer = (SlidingDrawer)findViewById(0x7f1002a2);
            slidingdrawer.setVisibility(0);
            slidingdrawer.open();
            return;
        } else
        {
            findViewById(0x7f1002a2).setVisibility(8);
            return;
        }
    }

    private void e()
    {
        TemplateView templateview = f;
        com.socialin.android.util.c.a(templateview.q.k);
        templateview.q.k = null;
        for (int l = 0; l < templateview.x.size(); l++)
        {
            if (((h)templateview.x.get(l)).b == null || ((h)templateview.x.get(l)).b.isRecycled())
            {
                templateview.x.remove(l);
            }
        }

        templateview.a();
        templateview.t.set((int)templateview.q.g.left, (int)templateview.q.g.top, (int)templateview.q.g.right, (int)templateview.q.g.bottom);
        templateview.invalidate(templateview.t);
    }

    private void f()
    {
        m.a(this, a);
        (new Thread() {

            private TemplateActivity a;

            public final void run()
            {
                String s = com.socialin.android.photo.template.TemplateActivity.b(a).a(android.graphics.Bitmap.CompressFormat.PNG);
                if (s == null)
                {
                    return;
                } else
                {
                    x.a();
                    s = x.a(s);
                    Intent intent = new Intent();
                    intent.putExtra("raw.data", s);
                    a.setResult(-1, intent);
                    a.finish();
                    m.b(a, a.a);
                    return;
                }
            }

            
            {
                a = TemplateActivity.this;
                super();
            }
        }).start();
    }

    private void g()
    {
        if (f != null)
        {
            TemplateView templateview = f;
            int l;
            if (templateview.x != null)
            {
                l = templateview.x.size();
            } else
            {
                l = 0;
            }
            if (l != 0)
            {
                startActivityForResult(new Intent(this, com/socialin/android/dialog/CancelDialogActivity), 230);
                return;
            }
        }
        finish();
    }

    private void h()
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f1002ac);
        linearlayout.removeAllViews();
        linearlayout.addView(new ColorView(this, f.w.getColor()));
    }

    public final void a()
    {
        if (getResources().getConfiguration().orientation == 1)
        {
            if (e.getVisibility() == 8)
            {
                AnimUtils.a(this, e, 0x7f040047, 0);
            }
        } else
        if (e.getVisibility() == 8)
        {
            AnimUtils.a(this, e, 0x7f040045, 0);
            return;
        }
    }

    public final void b()
    {
        if (getResources().getConfiguration().orientation == 1)
        {
            if (e.getVisibility() == 0)
            {
                AnimUtils.a(this, e, 0x7f04004b, 8);
            }
        } else
        if (e.getVisibility() == 0)
        {
            AnimUtils.a(this, e, 0x7f040049, 8);
            return;
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void onActivityResult(int l, int i1, Intent intent)
    {
        Object obj;
        obj = null;
        super.onActivityResult(l, i1, intent);
        if (i1 != -1) goto _L2; else goto _L1
_L1:
        if (intent == null) goto _L4; else goto _L3
_L3:
        Object obj1 = intent.getExtras();
        l;
        JVM INSTR lookupswitch 9: default 108
    //                   224: 361
    //                   225: 147
    //                   226: 501
    //                   227: 617
    //                   228: 733
    //                   229: 787
    //                   230: 891
    //                   231: 1268
    //                   1231: 133;
           goto _L2 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L2:
        if (i1 != 0) goto _L4; else goto _L14
_L14:
        l;
        JVM INSTR tableswitch 226 226: default 132
    //                   226 1359;
           goto _L4 _L15
_L4:
        return;
_L13:
        Utils.c(this, getString(0x7f0805e9));
        continue; /* Loop/switch isn't completed */
_L6:
        if (intent.hasExtra("selectedItems"))
        {
            AnalyticUtils.getInstance(this).trackLocalAction("template:multy_pic_result");
            intent = ((Bundle) (obj1)).getStringArray("selectedItems");
            obj = ((Bundle) (obj1)).getIntArray("selectedItemsDegrees");
            obj1 = ((Bundle) (obj1)).getStringArrayList("selectedItemsSources");
            a = com.socialin.android.dialog.g.a(this, getString(0x7f080679), true);
            (new Thread(intent, ((int []) (obj)), ((ArrayList) (obj1))) {

                final TemplateActivity a;
                private String b[];
                private int c[];
                private ArrayList d;

                public final void run()
                {
                    com.socialin.android.photo.template.TemplateActivity.b(a).setImages(b, c, d);
                    a.runOnUiThread(new Runnable(this) {

                        private _cls2 a;

                        public final void run()
                        {
                            com.socialin.android.photo.template.TemplateActivity.b(a.a).invalidate();
                            a.a.a.dismiss();
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }

            
            {
                a = TemplateActivity.this;
                b = as;
                c = ai;
                d = arraylist;
                super();
            }
            }).start();
        } else
        {
            g = ((Bundle) (obj1)).getString("path");
            h = ((Bundle) (obj1)).getInt("degree");
            obj = ((Bundle) (obj1)).getString("source");
            if (intent.hasExtra("bufferData"))
            {
                i = (HashMap)((Bundle) (obj1)).getSerializable("bufferData");
            }
            try
            {
                f.setTemplateImage(g, i, h, ((String) (obj)), 1, false);
                f.invalidate();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                com.socialin.android.d.b(b, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
                });
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        AnalyticUtils.getInstance(this).trackLocalAction("template:replace");
        g = ((Bundle) (obj1)).getString("path");
        h = ((Bundle) (obj1)).getInt("degree");
        obj = ((Bundle) (obj1)).getString("source");
        if (intent.hasExtra("bufferData"))
        {
            i = (HashMap)((Bundle) (obj1)).getSerializable("bufferData");
        }
        try
        {
            f.setTemplateImage(g, i, h, ((String) (obj)), 1, false);
            f.invalidate();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
            });
        }
        continue; /* Loop/switch isn't completed */
_L7:
        AnalyticUtils.getInstance(this).trackLocalAction("template:crop");
        obj = ((Bundle) (obj1)).getString("path");
        String s;
        Bitmap bitmap;
        int j1;
        boolean flag;
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)((Bundle) (obj1)).getSerializable("bufferData");
        } else
        {
            intent = null;
        }
        try
        {
            f.setTemplateImage(((String) (obj)), intent, 0, f.c, f.h, false);
            f.invalidate();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
            });
        }
        continue; /* Loop/switch isn't completed */
_L8:
        AnalyticUtils.getInstance(this).trackLocalAction("template:effect");
        obj = ((Bundle) (obj1)).getString("path");
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)((Bundle) (obj1)).getSerializable("bufferData");
        } else
        {
            intent = null;
        }
        try
        {
            f.setTemplateImage(((String) (obj)), intent, 0, f.c, f.h, true);
            f.invalidate();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
            });
        }
        continue; /* Loop/switch isn't completed */
_L9:
        AnalyticUtils.getInstance(this).trackLocalAction("template:new");
        intent = (Template)intent.getExtras().getParcelable("template");
        j = ((Template) (intent)).e;
        d();
        if (f != null)
        {
            f.a(intent);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        obj1 = intent.getExtras();
        intent = ((Bundle) (obj1)).getString("selectedFolderName");
        obj = ((Bundle) (obj1)).getString("selectedFileName");
        obj1 = ((Bundle) (obj1)).getString("fileExtension");
        s = (new StringBuilder()).append(intent).append("/").append(((String) (obj))).append(((String) (obj1))).toString();
        bitmap = f.c();
        if (bitmap != null)
        {
            m.a(this, bitmap, intent, ((String) (obj)), ((String) (obj1)), new Observer(s) {

                private String a;

                public final void update(Observable observable, Object obj2)
                {
                    if (SocialinV3.getInstance().getSettings().isExifEnabled())
                    {
                        obj2 = a;
                        if (SocialinV3.getInstance().isRegistered())
                        {
                            observable = SocialinV3.getInstance().getUser().username;
                        } else
                        {
                            observable = null;
                        }
                        m.a(((String) (obj2)), observable, null);
                    }
                }

            
            {
                a = s;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L11:
        intent = intent.getExtras().getString("button");
        if (intent.equals("button_ok"))
        {
            AnalyticUtils.getInstance(this).trackLocalAction("collage:cancel_dialog_ok");
            finish();
        } else
        {
            if (intent.equals("button_saveSD"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("collage:cancel_dialog_save");
                intent = new Intent(this, com/socialin/android/activity/SaveToSdCardDialogActivity);
                intent.putExtra("subFolderName", getString(0x7f0808fb));
                intent.putExtra("isReturnResult", true);
                startActivityForResult(intent, 229);
                return;
            }
            if (intent.equals("button_uploadToPicsinId"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("collage:cancel_dialog_upload_picsin");
                m.a(this, a);
                (new Thread() {

                    private TemplateActivity a;

                    public final void run()
                    {
                        String s1 = com.socialin.android.photo.template.TemplateActivity.b(a).a(android.graphics.Bitmap.CompressFormat.JPEG);
                        myobfuscated.cv.c.a(a, s1);
                        m.b(a, a.a);
                    }

            
            {
                a = TemplateActivity.this;
                super();
            }
                }).start();
                return;
            }
            if (intent.equals("button_postFB"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("collage:cancel_dialog_post_fb");
                m.a(this, a);
                (new Thread() {

                    private TemplateActivity a;

                    public final void run()
                    {
                        TemplateActivity.a(com.facebook.CallbackManager.Factory.create());
                        String s1 = com.socialin.android.photo.template.TemplateActivity.b(a).a(android.graphics.Bitmap.CompressFormat.JPEG);
                        FacebookUtils.startAdapterActivity(a, s1);
                        m.b(a, a.a);
                    }

            
            {
                a = TemplateActivity.this;
                super();
            }
                }).start();
                return;
            }
            if (intent.equals("button_tweet"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("collage:cancel_dialog_tweet");
                m.a(this, a);
                (new Thread() {

                    private TemplateActivity a;

                    public final void run()
                    {
                        myobfuscated.cv.c.a(com.socialin.android.photo.template.TemplateActivity.b(a).a(android.graphics.Bitmap.CompressFormat.JPEG), a);
                        m.b(a, a.a);
                    }

            
            {
                a = TemplateActivity.this;
                super();
            }
                }).start();
                return;
            }
            if (intent.equals("button_share"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("effect:cancel_dialog_export");
                m.a(this, a);
                (new Thread() {

                    private TemplateActivity a;

                    public final void run()
                    {
                        String s1 = com.socialin.android.photo.template.TemplateActivity.b(a).a(android.graphics.Bitmap.CompressFormat.JPEG);
                        myobfuscated.cv.c.a(a, s1, com.socialin.android.photo.template.TemplateActivity.b(a).n, com.socialin.android.photo.template.TemplateActivity.b(a).o);
                        m.b(a, a.a);
                    }

            
            {
                a = TemplateActivity.this;
                super();
            }
                }).start();
                return;
            }
            if (intent.equals("button_picsartEdit"))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("effect:cancel_dialog_picsartEdit");
                f();
                return;
            }
            if ("button_postInstagram".equals(intent))
            {
                AnalyticUtils.getInstance(this).trackLocalAction("effect:cancel_dialog_instagram_share");
                intent = new Intent("android.intent.action.SEND", null);
                intent.setPackage("com.instagram.android");
                intent.setDataAndType(null, "image/*");
                intent = getPackageManager().queryIntentActivities(intent, 0x10000);
                if (intent != null && intent.size() > 0)
                {
                    (new Thread(intent) {

                        private List a;
                        private TemplateActivity b;

                        public final void run()
                        {
                            String s1 = com.socialin.android.photo.template.TemplateActivity.b(b).a(android.graphics.Bitmap.CompressFormat.JPEG);
                            Intent intent1 = new Intent("android.intent.action.SEND");
                            intent1.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(s1).toString()));
                            intent1.setType("image/*");
                            intent1.putExtra("android.intent.extra.TEXT", "#PicsArt");
                            intent1.putExtra("subject", b.getString(0x7f08040b));
                            intent1.setClassName(((ResolveInfo)a.get(0)).activityInfo.packageName, ((ResolveInfo)a.get(0)).activityInfo.name);
                            com.socialin.android.photo.template.TemplateActivity.d(b).startActivity(intent1);
                            m.b(b, b.a);
                        }

            
            {
                b = TemplateActivity.this;
                a = list;
                super();
            }
                    }).start();
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L12:
        obj1 = intent.getExtras().getString("path");
        j1 = intent.getExtras().getInt("degree");
        flag = intent.getExtras().getBoolean("fromGallery", false);
        if (intent.hasExtra("bufferData"))
        {
            obj = (HashMap)intent.getSerializableExtra("bufferData");
        }
        if (f != null)
        {
            f.setCollageBg(((String) (obj1)), flag, ((HashMap) (obj)), j1);
            f.invalidate();
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (f == null) goto _L4; else goto _L16
_L16:
        f.setTemplateImage(g, i, h, f.c, f.h, false);
        f.invalidate();
        return;
        if (true) goto _L2; else goto _L17
_L17:
    }

    public void onClick(View view)
    {
        if (f != null && f.s)
        {
            f.b();
        }
        view.getId();
        JVM INSTR lookupswitch 12: default 136
    //                   2131755670: 137
    //                   2131755672: 191
    //                   2131755673: 244
    //                   2131755674: 152
    //                   2131755692: 836
    //                   2131755694: 867
    //                   2131757718: 303
    //                   2131757719: 364
    //                   2131757720: 656
    //                   2131757721: 513
    //                   2131757722: 821
    //                   2131757723: 273;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L6:
        break MISSING_BLOCK_LABEL_836;
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_867;
_L14:
        return;
_L2:
        AnalyticUtils.getInstance(this).trackLocalAction("template:cancel");
        g();
        return;
_L5:
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CollageDoneEvent());
        AnalyticUtils.getInstance(this).trackLocalAction("template:done");
        AnalyticUtils.getInstance(this).trackLocalAction("effect:cancel_dialog_picsartEdit");
        f();
        return;
_L3:
        view = new Intent(this, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        view.putExtra("category", "collage_frame");
        view.putExtra("readFrom", "collage_frame.json");
        startActivityForResult(view, 228);
        AnalyticUtils.getInstance(this).trackLocalAction("template:chooseFrame");
        return;
_L4:
        startActivityForResult(new Intent(this, com/socialin/android/photo/template/SelectCustomCollageActivity), 228);
        AnalyticUtils.getInstance(this).trackLocalAction("template:chooseGrid");
        return;
_L13:
        m.a(this, a);
        (new Thread() {

            final TemplateActivity a;

            public final void run()
            {
                TemplateView templateview = com.socialin.android.photo.template.TemplateActivity.b(a);
                Collections.shuffle(templateview.x);
                int j2 = 0;
                int i2 = 0;
                do
                {
label0:
                    {
                        if (j2 >= templateview.p.f.size())
                        {
                            break label0;
                        }
                        TemplateImage templateimage = (TemplateImage)templateview.p.f.get(j2);
                        if (i2 < templateview.x.size() && templateimage.k != null)
                        {
                            if (((h)templateview.x.get(i2)).d != null)
                            {
                                templateimage.k = w.b(((h)templateview.x.get(i2)).d, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)templateview.x.get(i2)).e);
                            } else
                            {
                                try
                                {
                                    templateimage.k = w.a(((h)templateview.x.get(i2)).c, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)templateview.x.get(i2)).e);
                                }
                                catch (Exception exception)
                                {
                                    com.socialin.android.d.b(TemplateView.a, new Object[] {
                                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                    });
                                }
                            }
                            if (templateimage.k == null)
                            {
                                break label0;
                            }
                            templateimage.k = com.socialin.android.brushlib.util.b.a(new Matrix(), templateimage.k, (int)templateimage.d, (int)templateimage.e);
                            if (templateimage.o != 1)
                            {
                                templateimage.k = w.a(templateimage.k, templateimage.o);
                            }
                            ((h)templateview.x.get(i2)).b = templateimage.k;
                            templateimage.l = ((h)templateview.x.get(i2)).c;
                            templateimage.n = ((h)templateview.x.get(i2)).e;
                            templateimage.o = ((h)templateview.x.get(i2)).f;
                            templateimage.p = ((h)templateview.x.get(i2)).a;
                            templateimage.j = null;
                            templateimage.m = ((h)templateview.x.get(i2)).d;
                            i2++;
                        }
                        j2++;
                        continue;
                    }
                    a.runOnUiThread(new Runnable(this) {

                        private _cls11 a;

                        public final void run()
                        {
                            com.socialin.android.photo.template.TemplateActivity.b(a.a).invalidate();
                            com.socialin.android.photo.template.TemplateActivity.b(a.a).a();
                            m.b(a.a, a.a.a);
                        }

            
            {
                a = _pcls11;
                super();
            }
                    });
                    return;
                } while (true);
            }

            
            {
                a = TemplateActivity.this;
                super();
            }
        }).start();
        AnalyticUtils.getInstance(this).trackLocalAction("template:shuffle");
        return;
_L8:
        AnalyticUtils.getInstance(this).trackLocalAction("template:effect");
        view = f.i;
        int l = PicsartContext.a.getCollageImageMaxSize();
        startActivityForResult(EffectsActivityNew.a(this, "collage", view, f.f, f.g, l * l), 227);
        return;
_L9:
        AnalyticUtils.getInstance(this).trackLocalAction("template:crop");
        view = f.f;
        HashMap hashmap = f.i;
        int i1 = f.g;
        g = view;
        i = hashmap;
        Intent intent = new Intent(this, com/picsart/studio/editor/activity/StandaloneCropToolActivity);
        intent.putExtra("imagePath", view);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("degree", i1);
        intent.putExtra("maxPixel", PicsartContext.a.getMaxImageSizePixel());
        intent.putExtra("source", "collage");
        intent.putExtra("outputX", f.d);
        intent.putExtra("outputY", f.e);
        startActivityForResult(intent, 226);
        return;
_L11:
        AnalyticUtils.getInstance(this).trackLocalAction("template:flip");
        view = f;
        if (((TemplateView) (view)).q.k != null && !((TemplateView) (view)).q.k.isRecycled())
        {
            int j1 = -((TemplateView) (view)).q.o;
            view.setTemplateImage(((TemplateView) (view)).q.l, ((TemplateView) (view)).q.m, ((TemplateView) (view)).q.n, ((TemplateView) (view)).q.p, j1, false);
            ((TemplateView) (view)).t.set((int)((TemplateView) (view)).q.g.left, (int)((TemplateView) (view)).q.g.top, (int)((TemplateView) (view)).q.g.right, (int)((TemplateView) (view)).q.g.bottom);
            view.invalidate(((TemplateView) (view)).t);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        AnalyticUtils.getInstance(this).trackLocalAction("template:rotate");
        view = f;
        if (((TemplateView) (view)).q.k != null && !((TemplateView) (view)).q.k.isRecycled())
        {
            int l1 = ((TemplateView) (view)).q.n + 90;
            int k1 = l1;
            if (l1 > 360)
            {
                k1 = l1 - 360;
            }
            view.setTemplateImage(((TemplateView) (view)).q.l, ((TemplateView) (view)).q.m, k1, ((TemplateView) (view)).q.p, ((TemplateView) (view)).q.o, false);
            ((TemplateView) (view)).t.set((int)((TemplateView) (view)).q.g.left, (int)((TemplateView) (view)).q.g.top, (int)((TemplateView) (view)).q.g.right, (int)((TemplateView) (view)).q.g.bottom);
            view.invalidate(((TemplateView) (view)).t);
            return;
        }
        if (true) goto _L14; else goto _L12
_L12:
        AnalyticUtils.getInstance(this).trackLocalAction("template:delete");
        e();
        return;
        d = new com.socialin.android.colorpicker.c() {

            private TemplateActivity a;

            public final void a(int i2)
            {
                com.socialin.android.photo.template.TemplateActivity.b(a).setBorderColor(i2);
                com.socialin.android.photo.template.TemplateActivity.c(a);
            }

            
            {
                a = TemplateActivity.this;
                super();
            }
        };
        a(d, f.w.getColor());
        return;
        AnalyticUtils.getInstance(this).trackLocalAction("template:choose_bg");
        view = new Intent(this, com/socialin/android/photo/collage/SelectCollageBgActivity);
        view.putExtra("showColorPanel", false);
        view.putExtra("showGalleryPanel", true);
        startActivityForResult(view, 231);
        return;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (f != null)
        {
            ((RelativeLayout)findViewById(0x7f100a94)).removeView(f);
            setContentView(0x7f030251);
            c();
            ((TextView)findViewById(0x7f1002aa)).setText((new StringBuilder(" ")).append((int)f.u).toString());
            ((TextView)findViewById(0x7f1002a6)).setText((new StringBuilder(" ")).append(f.v).append("%").toString());
            f.setCurrentBorderbg();
            configuration = (LinearLayout)findViewById(0x7f1002ac);
            configuration.removeAllViews();
            configuration.addView(new ColorView(this, f.w.getColor()));
            ((SeekBar)findViewById(0x7f1002ab)).setProgress((int)f.u);
            ((SeekBar)findViewById(0x7f1002a7)).setProgress(f.v);
            int l;
            if (f.b)
            {
                a();
            } else
            {
                b();
            }
            initAd();
        }
        if (c != null && c.isShowing())
        {
            l = c.b();
            c.dismiss();
            a(d, l);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030251);
        AnalyticUtils.getInstance(this).trackLocalAction("template:onCreate");
        if (bundle != null)
        {
            k = (Template)bundle.getParcelable("template");
            int l = bundle.getInt("selectedImageNum");
            int i1 = bundle.getInt("borderColor");
            boolean flag = bundle.getBoolean("isEditModeActive");
            int j1 = bundle.getInt("viewWidth");
            int k1 = bundle.getInt("viewHeight");
            int l1 = bundle.getInt("imageDegree");
            bundle = bundle.getString("realPath");
            if (k != null)
            {
                f = new TemplateView(this, k, j1, k1, l, i1, flag);
                if (bundle != null)
                {
                    f.setTemplateImage(bundle, null, l1, "", 1, false);
                }
            }
        }
        if (k == null)
        {
            k = (Template)getIntent().getExtras().getParcelable("template");
        }
        j = k.e;
        if (f == null)
        {
            f = new TemplateView(this, k);
        }
        a = new com.socialin.android.dialog.g(this);
        a.setMessage(getString(0x7f080679));
        a.setCancelable(true);
        c();
        initAd();
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CollageOpenEvent(m.a(getIntent(), "from")));
    }

    protected void onDestroy()
    {
        boolean flag = false;
        super.onDestroy();
        TemplateView templateview = f;
        if (templateview.l != null)
        {
            com.socialin.android.util.c.a(templateview.l);
            templateview.l = null;
        }
        if (templateview.m != null)
        {
            com.socialin.android.util.c.a(templateview.m);
            templateview.m = null;
        }
        if (templateview.y != null)
        {
            com.socialin.android.util.c.a(templateview.y);
            templateview.y = null;
        }
        if (templateview.z != null)
        {
            com.socialin.android.util.c.a(templateview.z);
            templateview.z = null;
        }
        int l = 0;
        int i1;
        do
        {
            i1 = ((flag) ? 1 : 0);
            if (l >= templateview.p.f.size())
            {
                break;
            }
            TemplateImage templateimage = (TemplateImage)templateview.p.f.get(l);
            if (templateimage.k != null)
            {
                com.socialin.android.util.c.a(templateimage.k);
                templateimage.k = null;
            }
            l++;
        } while (true);
        for (; i1 < templateview.x.size(); i1++)
        {
            if (((h)templateview.x.get(i1)).b != null)
            {
                com.socialin.android.util.c.a(((h)templateview.x.get(i1)).b);
                ((h)templateview.x.get(i1)).b = null;
            }
        }

    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 4)
        {
            g();
            return true;
        } else
        {
            return super.onKeyDown(l, keyevent);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("template", f.p);
        bundle.putInt("selectedImageNum", f.r);
        bundle.putInt("borderColor", f.w.getColor());
        bundle.putBoolean("isEditModeActive", f.b);
        bundle.putInt("viewWidth", f.j);
        bundle.putInt("viewHeight", f.k);
        bundle.putInt("imageDegree", h);
        bundle.putString("realPath", f.f);
        super.onSaveInstanceState(bundle);
    }

}
