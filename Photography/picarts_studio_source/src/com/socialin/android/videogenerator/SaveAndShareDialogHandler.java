// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.picsart.studio.mp4encoder.MP4Writer;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.an;
import com.socialin.android.youtube.YouTubeUploadActivity;
import io.branch.referral.m;
import java.io.File;
import myobfuscated.cv.c;
import myobfuscated.cy.d;

public final class SaveAndShareDialogHandler
{

    public Button a;
    public Button b;
    public Button c;
    public Button d;
    public Button e;
    public Button f;
    public final boolean g;
    public boolean h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ImageItem n;
    public long o;
    public String p;
    public boolean q;
    public int r;
    public Intent s;
    public String t;
    public boolean u;

    public SaveAndShareDialogHandler()
    {
        boolean flag = false;
        super();
        g = Build.MODEL.contains("I9192");
        k = false;
        l = false;
        m = false;
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            flag = true;
        }
        u = flag;
    }

    public static boolean a(String s1, Context context)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return true;
    }

    public final void a(Button button, Activity activity)
    {
        button.setOnClickListener(new android.view.View.OnClickListener(activity) {

            private Activity a;
            private SaveAndShareDialogHandler b;

            public final void onClick(View view)
            {
                if (!a.isFinishing())
                {
                    Intent intent = new Intent(a, com/socialin/android/activity/SaveToSdCardDialogActivity);
                    myobfuscated.cv.c.a(intent, a);
                    intent.setData(Uri.parse(b.i));
                    Object obj = a.getString(0x7f0808fb);
                    view = ((View) (obj));
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        view = a.getString(0x7f0808fb);
                    }
                    intent.putExtra("isReturnResult", b.q);
                    intent.putExtra("subFolderName", view);
                    intent.putExtra("gifPath", b.l);
                    intent.putExtra("vidPath", b.k);
                    intent.putExtra("videoMP4", b.h);
                    if (b.p != null)
                    {
                        intent.putExtra("imageUrl", b.p);
                    }
                    obj = AnalyticUtils.getInstance(a);
                    com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent drawexportvideoevent = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(b.r, b.t)).setDest("gallery");
                    if (b.l)
                    {
                        view = MediaType.GIF;
                    } else
                    {
                        view = MediaType.MPG;
                    }
                    ((AnalyticUtils) (obj)).track(drawexportvideoevent.setType(MediaType.getType(view)));
                    a.startActivityForResult(intent, 92);
                }
            }

            
            {
                b = SaveAndShareDialogHandler.this;
                a = activity;
                super();
            }

            private class MediaType extends Enum
            {

                private static final MediaType $VALUES[];
                public static final MediaType GIF;
                public static final MediaType MPG;

                public static String getType(MediaType mediatype)
                {
                    if (mediatype == GIF)
                    {
                        return "gif";
                    } else
                    {
                        return "mpg";
                    }
                }

                public static MediaType valueOf(String s1)
                {
                    return (MediaType)Enum.valueOf(com/socialin/android/videogenerator/SaveAndShareDialogHandler$MediaType, s1);
                }

                public static MediaType[] values()
                {
                    return (MediaType[])$VALUES.clone();
                }

                static 
                {
                    GIF = new MediaType("GIF", 0);
                    MPG = new MediaType("MPG", 1);
                    $VALUES = (new MediaType[] {
                        GIF, MPG
                    });
                }

                private MediaType(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        });
    }

    public final void a(Button button, Context context)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        if (k)
        {
            intent.setType("video/*");
            intent.putExtra("android.intent.extra.SUBJECT", context.getString(0x7f08040c));
            intent.putExtra("android.intent.extra.TEXT", context.getString(0x7f080486));
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(i)));
        } else
        {
            intent.setType("image/gif");
            intent.putExtra("android.intent.extra.SUBJECT", context.getString(0x7f08040a));
            intent.putExtra("android.intent.extra.TEXT", context.getString(0x7f08042f));
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(i)));
        }
        button.setOnClickListener(new android.view.View.OnClickListener(context, intent) {

            private Context a;
            private Intent b;
            private SaveAndShareDialogHandler c;

            public final void onClick(View view)
            {
                a.startActivity(b);
                AnalyticUtils analyticutils = AnalyticUtils.getInstance(a);
                com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent drawexportvideoevent = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(c.r, c.t)).setDest("more");
                if (c.l)
                {
                    view = MediaType.GIF;
                } else
                {
                    view = MediaType.MPG;
                }
                analyticutils.track(drawexportvideoevent.setType(MediaType.getType(view)));
            }

            
            {
                c = SaveAndShareDialogHandler.this;
                a = context;
                b = intent;
                super();
            }
        });
    }

    public final void a(Button button, Context context, String s1, String s2)
    {
        button.setOnClickListener(new android.view.View.OnClickListener(context, s1, s2) {

            final Context a;
            final String b;
            final String c;
            final SaveAndShareDialogHandler d;

            public final void onClick(View view)
            {
                view = new g(a);
                Intent intent = new Intent("android.intent.action.SEND");
                (new ModernAsyncTask(this, view, d.s.getExtras(), intent) {

                    private g a;
                    private Bundle b;
                    private Intent c;
                    private _cls3 d;

                    protected final Object doInBackground(Object aobj[])
                    {
                        if (d.d.l)
                        {
                            aobj = MP4Writer.initWithParams(b);
                            for (int i1 = 0; i1 < 2; i1++)
                            {
                                File file = new File(((MP4Writer) (aobj)).getOutputAbsolutePath());
                                if (file.exists())
                                {
                                    file.delete();
                                }
                                ((MP4Writer) (aobj)).createGifMovie();
                            }

                        }
                        c.setPackage("com.instagram.android");
                        c.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(d.b).toString()));
                        c.setType(d.c);
                        c.putExtra("android.intent.extra.SUBJECT", d.a.getString(0x7f0808af));
                        Object obj = c;
                        aobj = d.d;
                        Object obj1 = d.a;
                        if (((SaveAndShareDialogHandler) (aobj)).n == null || ((SaveAndShareDialogHandler) (aobj)).n.user == null)
                        {
                            aobj = ((Context) (obj1)).getString(0x7f0802ff).toLowerCase();
                        } else
                        {
                            aobj = (new StringBuilder("@")).append(((SaveAndShareDialogHandler) (aobj)).n.user.username).toString();
                        }
                        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", ((Context) (obj1)).getString(0x7f08040d, new Object[] {
                            aobj
                        }));
                        obj = AnalyticUtils.getInstance(d.a);
                        obj1 = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(d.d.r, d.d.t)).setDest("instagram");
                        if (d.d.l)
                        {
                            aobj = MediaType.GIF;
                        } else
                        {
                            aobj = MediaType.MPG;
                        }
                        ((AnalyticUtils) (obj)).track(((com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent) (obj1)).setType(MediaType.getType(((MediaType) (aobj)))));
                        return null;
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        super.onPostExecute((Void)obj);
                        if (a.isShowing())
                        {
                            a.dismiss();
                        }
                        d.a.startActivity(c);
                    }

                    protected final void onPreExecute()
                    {
                        super.onPreExecute();
                        a.show();
                    }

            
            {
                d = _pcls3;
                a = g1;
                b = bundle;
                c = intent;
                super();
            }
                }).execute(new Void[0]);
            }

            
            {
                d = SaveAndShareDialogHandler.this;
                a = context;
                b = s1;
                c = s2;
                super();
            }
        });
    }

    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$2

/* anonymous class */
    public final class _cls2
        implements android.view.View.OnClickListener
    {

        final Activity a;
        final SaveAndShareDialogHandler b;

        public final void onClick(View view)
        {
            (new an(this) {

                private _cls2 a;

                protected final Object doInBackground(Object aobj[])
                {
    public final class _cls2
        implements android.view.View.OnClickListener
    {
                    if (!isCancelled() && a.a != null && !a.a.isFinishing())
                    {
                        myobfuscated.cv.c.a(a.a, a.b.i);
                        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.a);
                        com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent drawexportvideoevent = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(a.b.r, a.b.t)).setDest("picsart");
                        if (a.b.l)
                        {
                            aobj = MediaType.GIF;
                        } else
                        {
                            aobj = MediaType.MPG;
                        }
                        analyticutils.track(drawexportvideoevent.setType(MediaType.getType(((MediaType) (aobj)))));
                        a.a.finish();
                    }
                    return null;
                }

            
            {
                a = _pcls2;
                super();
            }
            }).a(new Void[0]);
        }

            public 
            {
                b = SaveAndShareDialogHandler.this;
                a = activity;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$5

/* anonymous class */
    public final class _cls5
        implements android.view.View.OnClickListener
    {

        private Context a;
        private SaveAndShareDialogHandler b;

        public final void onClick(View view)
        {
            view = new Intent(a, com/socialin/android/youtube/YouTubeUploadActivity);
            view.putExtra("android.intent.extra.SUBJECT", a.getString(0x7f08040c));
            view.putExtra("android.intent.extra.TEXT", a.getString(0x7f080486));
            view.putExtra("fileUri", b.i);
            a.startActivity(view);
            AnalyticUtils.getInstance(a).track((new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(b.r, b.t)).setDest("youtube").setType(MediaType.getType(MediaType.MPG)));
        }

            public 
            {
                b = SaveAndShareDialogHandler.this;
                a = context;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$6

/* anonymous class */
    public final class _cls6
        implements android.view.View.OnClickListener
    {

        final Activity a;
        final String b;
        final SaveAndShareDialogHandler c;

        public final void onClick(View view)
        {
            myobfuscated.cy.d.a(a, "facebook", "photo_share_facebook", c.o, new io.branch.referral.g(this) {

                private _cls6 a;

                public final void a(String s1, m m1)
                {
    public final class _cls6
        implements android.view.View.OnClickListener
    {
                    m1 = a.c;
                    Object obj = a.a;
                    Object obj1 = a.b;
                    s1 = FacebookUtils.createFacebookMessage(a.a, a.c.n, a.c.o, s1);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setPackage("com.facebook.katana");
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(((String) (obj1))).toString()));
                    intent.setType("video/*");
                    intent.putExtra("android.intent.extra.SUBJECT", ((Context) (obj)).getString(0x7f0808af));
                    intent.putExtra("android.intent.extra.TEXT", s1);
                    ((Context) (obj)).startActivity(intent);
                    obj = AnalyticUtils.getInstance(((Context) (obj)));
                    obj1 = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(((SaveAndShareDialogHandler) (m1)).r, ((SaveAndShareDialogHandler) (m1)).t)).setDest("facebook");
                    if (((SaveAndShareDialogHandler) (m1)).l)
                    {
                        s1 = MediaType.GIF;
                    } else
                    {
                        s1 = MediaType.MPG;
                    }
                    ((AnalyticUtils) (obj)).track(((com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent) (obj1)).setType(MediaType.getType(s1)));
                }

            
            {
                a = _pcls6;
                super();
            }
            });
        }

            public 
            {
                c = SaveAndShareDialogHandler.this;
                a = activity;
                b = s1;
                super();
            }
    }

}
