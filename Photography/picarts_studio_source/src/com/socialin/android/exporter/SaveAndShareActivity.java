// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.exporter;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.videogenerator.SaveAndShareDialogHandler;

public class SaveAndShareActivity extends BaseActivity
{

    private float a;

    public SaveAndShareActivity()
    {
        a = 0.0F;
    }

    public void finish()
    {
        super.finish();
        overridePendingTransition(0, 0x7f040048);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("fixOrientation") && getIntent().getBooleanExtra("fixOrientation", false))
        {
            setRequestedOrientation(4);
        }
        bundle = getWindow().getAttributes();
        bundle.width = Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        bundle.gravity = 81;
        setContentView(0x7f030198);
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getBoolean("videoAndGif", false))
        {
            setContentView(0x7f03019b);
            bundle = (new b()).a(0, 0x7f0c0181);
            bundle.a = getResources().getString(0x7f080596);
            bundle.f = 0x7f030194;
            bundle.p = new c() {

                private SaveAndShareActivity a;

                public final void onViewCreated(View view, DialogFragment dialogfragment)
                {
                    SaveAndShareDialogHandler saveandsharedialoghandler = new SaveAndShareDialogHandler();
                    Object obj = a.getIntent();
                    saveandsharedialoghandler.s = ((Intent) (obj));
                    if (((Intent) (obj)).getExtras().getString("vidPath") != null)
                    {
                        if (TextUtils.isEmpty(saveandsharedialoghandler.i))
                        {
                            saveandsharedialoghandler.i = ((Intent) (obj)).getExtras().getString("vidPath");
                            saveandsharedialoghandler.k = true;
                        }
                    } else
                    if (obj != null && ((Intent) (obj)).getExtras().getString("gifPath") != null)
                    {
                        saveandsharedialoghandler.i = ((Intent) (obj)).getExtras().getString("gifPath");
                        saveandsharedialoghandler.l = true;
                    }
                    if (obj != null && ((Intent) (obj)).getExtras().getString("gifVideoPath") != null)
                    {
                        saveandsharedialoghandler.j = ((Intent) (obj)).getExtras().getString("gifVideoPath");
                        saveandsharedialoghandler.m = true;
                    }
                    if (((Intent) (obj)).hasExtra("item"))
                    {
                        try
                        {
                            saveandsharedialoghandler.n = (ImageItem)((Intent) (obj)).getParcelableExtra("item");
                            saveandsharedialoghandler.o = saveandsharedialoghandler.n.id;
                            saveandsharedialoghandler.p = saveandsharedialoghandler.n.url;
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    if (((Intent) (obj)).hasExtra("isReturnResult"))
                    {
                        saveandsharedialoghandler.q = ((Intent) (obj)).getBooleanExtra("isReturnResult", false);
                    }
                    if (((Intent) (obj)).hasExtra("videoMP4"))
                    {
                        saveandsharedialoghandler.h = true;
                    }
                    if (saveandsharedialoghandler.k)
                    {
                        saveandsharedialoghandler.r = ((Intent) (obj)).getExtras().getInt("vidDur", 0);
                    } else
                    {
                        ((Intent) (obj)).getExtras().getDouble("gifDelay", 0.0D);
                    }
                    saveandsharedialoghandler.t = ((Intent) (obj)).getExtras().getString("draw_export_video_uid");
                    obj = dialogfragment.getActivity();
                    saveandsharedialoghandler.c = (Button)view.findViewById(0x7f1007ae);
                    saveandsharedialoghandler.d = (Button)view.findViewById(0x7f1007af);
                    saveandsharedialoghandler.b = (Button)view.findViewById(0x7f1007b2);
                    saveandsharedialoghandler.a = (Button)view.findViewById(0x7f1007b0);
                    saveandsharedialoghandler.e = (Button)view.findViewById(0x7f1007b1);
                    saveandsharedialoghandler.f = (Button)view.findViewById(0x7f1007b3);
                    if (saveandsharedialoghandler.l)
                    {
                        saveandsharedialoghandler.a.setVisibility(8);
                        saveandsharedialoghandler.e.setVisibility(8);
                    } else
                    {
                        saveandsharedialoghandler.d.setVisibility(8);
                    }
                    if (!SaveAndShareDialogHandler.a("com.instagram.android", ((android.content.Context) (obj))) || saveandsharedialoghandler.g || !saveandsharedialoghandler.u)
                    {
                        saveandsharedialoghandler.b.setVisibility(8);
                        saveandsharedialoghandler.b = null;
                    }
                    saveandsharedialoghandler.a(saveandsharedialoghandler.c, ((android.app.Activity) (obj)));
                    if (saveandsharedialoghandler.l)
                    {
                        saveandsharedialoghandler.a(saveandsharedialoghandler.c, ((android.app.Activity) (obj)));
                        view = saveandsharedialoghandler.d;
                        myobfuscated.cv.c.a(new Intent(), ((android.app.Activity) (obj)));
                        view.setOnClickListener(new com.socialin.android.videogenerator.SaveAndShareDialogHandler._cls2(saveandsharedialoghandler, ((android.app.Activity) (obj))));
                        if (saveandsharedialoghandler.b != null)
                        {
                            Button button = saveandsharedialoghandler.b;
                            if (saveandsharedialoghandler.m)
                            {
                                view = saveandsharedialoghandler.j;
                            } else
                            {
                                view = saveandsharedialoghandler.i;
                            }
                            if (saveandsharedialoghandler.m)
                            {
                                dialogfragment = "video/*";
                            } else
                            {
                                dialogfragment = "image/gif";
                            }
                            saveandsharedialoghandler.a(button, ((android.content.Context) (obj)), view, dialogfragment);
                        }
                        saveandsharedialoghandler.a(saveandsharedialoghandler.f, ((android.content.Context) (obj)));
                        return;
                    }
                    saveandsharedialoghandler.a(saveandsharedialoghandler.c, ((android.app.Activity) (obj)));
                    saveandsharedialoghandler.a.setOnClickListener(new com.socialin.android.videogenerator.SaveAndShareDialogHandler._cls5(saveandsharedialoghandler, ((android.content.Context) (obj))));
                    if (!SaveAndShareDialogHandler.a("com.facebook.katana", ((android.content.Context) (obj))))
                    {
                        saveandsharedialoghandler.e.setVisibility(8);
                        saveandsharedialoghandler.e = null;
                    } else
                    {
                        saveandsharedialoghandler.e.setOnClickListener(new com.socialin.android.videogenerator.SaveAndShareDialogHandler._cls6(saveandsharedialoghandler, ((android.app.Activity) (obj)), saveandsharedialoghandler.i));
                    }
                    if (saveandsharedialoghandler.b != null && saveandsharedialoghandler.h)
                    {
                        saveandsharedialoghandler.a(saveandsharedialoghandler.b, ((android.content.Context) (obj)), saveandsharedialoghandler.i, "video/*");
                    }
                    saveandsharedialoghandler.a(saveandsharedialoghandler.f, ((android.content.Context) (obj)));
                }

            
            {
                a = SaveAndShareActivity.this;
                super();
            }
            };
            bundle.m = new android.content.DialogInterface.OnCancelListener() {

                private SaveAndShareActivity a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    a.finish();
                }

            
            {
                a = SaveAndShareActivity.this;
                super();
            }
            };
            bundle.h = false;
            bundle.g = false;
            bundle.a().show(getFragmentManager(), "export_fragmentvid_tag");
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 49;
           goto _L1 _L2 _L1 _L3
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        a = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        if (motionevent.getY() - a > 20F)
        {
            finish();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
