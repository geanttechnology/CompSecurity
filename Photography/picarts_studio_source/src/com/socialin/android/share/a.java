// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsLogger;
import com.flurry.android.tumblr.PhotoPost;
import com.flurry.android.tumblr.PostListener;
import com.flurry.android.tumblr.TumblrShare;
import com.picsart.studio.EditingData;
import com.picsart.studio.ads.h;
import com.picsart.studio.mp4encoder.MP4WriterFactory;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddPhotoController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.c;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import com.socialin.android.util.e;
import com.socialin.android.util.o;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.share:
//            SaveExportActivity, b, MP4EncoderDexLoader

public final class a extends Fragment
{

    private static int A = 10;
    private static int B = 3;
    private static boolean D;
    private static String h = (new StringBuilder()).append(com/socialin/android/share/SaveExportActivity.getSimpleName()).append(" - ").toString();
    private static h i = null;
    private ImageView C;
    private PostListener E;
    boolean a;
    boolean b;
    String c;
    Bitmap d;
    long e;
    g f;
    ImageItem g;
    private boolean j;
    private PopupWindow k;
    private LayoutInflater l;
    private List m;
    private GridLayout n;
    private String o;
    private String p;
    private int q;
    private int r;
    private String s;
    private SharedPreferences t;
    private boolean u;
    private AddPhotoController v;
    private boolean w;
    private String x;
    private String y;
    private an z;

    public a()
    {
        j = true;
        k = null;
        a = true;
        b = true;
        l = null;
        o = null;
        c = null;
        p = null;
        e = -1L;
        s = "";
        f = null;
        t = null;
        u = false;
        v = new AddPhotoController();
        w = false;
        x = "";
        C = null;
        E = new PostListener() {

            private a a;

            public final void onPostFailure(String s1)
            {
                if (!TextUtils.isEmpty(s1))
                {
                    String s2 = s1;
                    if (s1.trim().toLowerCase().equals("internalerror"))
                    {
                        s2 = a.getString(0x7f08047d);
                    }
                    Utils.a(a.getActivity(), s2, 0);
                    return;
                } else
                {
                    Utils.a(a.getActivity(), a.getString(0x7f0805ca), 0);
                    return;
                }
            }

            public final void onPostSuccess(Long long1)
            {
                Utils.a(a.getActivity(), a.getString(0x7f0805e9), 0);
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    private static Rect a(View view)
    {
        int ai[] = new int[2];
        if (view == null)
        {
            return null;
        }
        Rect rect;
        try
        {
            view.getLocationOnScreen(ai);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return null;
        }
        rect = new Rect();
        rect.left = ai[0];
        rect.top = ai[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    static an a(a a1)
    {
        return a1.z;
    }

    static an a(a a1, an an1)
    {
        a1.z = an1;
        return an1;
    }

    private static String a(long l1)
    {
        String s1;
        if (l1 > 0L)
        {
            s1 = (new StringBuilder("/i/")).append(l1).toString();
        } else
        {
            s1 = "";
        }
        return (new StringBuilder("http://picsart.com")).append(s1).toString();
    }

    private String a(String s1)
    {
        String s2 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s2 = getString(0x7f0808b3);
        }
        String s3 = getString(0x7f08040f);
        s1 = s3;
        if (e > 0L)
        {
            String s4 = a(e);
            if (a)
            {
                s1 = (new StringBuilder()).append(s3).append(" ").append(s4).toString();
            } else
            {
                if (g == null || g.user == null)
                {
                    s1 = "user";
                } else
                {
                    s1 = (new StringBuilder("@")).append(g.user.username).append("'s").toString();
                }
                s1 = (new StringBuilder()).append(getString(0x7f080412, new Object[] {
                    s1
                })).append(" ").append(getString(0x7f080437)).append(" ").append(getString(0x7f080413, new Object[] {
                    "#PicsArt", (new StringBuilder(" ")).append(s4).toString()
                })).toString();
            }
        }
        s3 = (new StringBuilder()).append(s1).append("\n").append(getString(0x7f08046f)).append(" ").toString();
        s1 = s3;
        if (s3.length() < 142 - s2.length())
        {
            s1 = (new StringBuilder()).append(s3).append(s2).toString();
        }
        com.socialin.android.d.b(h, new Object[] {
            (new StringBuilder("Whatsapp text= ")).append(s1).toString()
        });
        return s1;
    }

    static String a(List list, String s1)
    {
        if (list.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = list.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        list = (ResolveInfo)iterator.next();
        if (!s1.equals(((ResolveInfo) (list)).activityInfo.applicationInfo.packageName)) goto _L6; else goto _L5
_L5:
        if (list != null)
        {
            return ((ResolveInfo) (list)).activityInfo.name;
        }
_L2:
        return null;
_L4:
        list = null;
        if (true) goto _L5; else goto _L7
_L7:
    }

    private void a(GridLayout gridlayout, List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.socialin.android.share.b b1 = (com.socialin.android.share.b)list.next();
            if (b1 != null)
            {
                ViewGroup viewgroup = (ViewGroup)l.inflate(0x7f030245, null, false);
                ((ImageView)viewgroup.findViewById(0x7f100a6b)).setImageDrawable(b1.a);
                ((TextView)viewgroup.findViewById(0x7f100a6c)).setText(b1.b);
                viewgroup.setTag(b1.c);
                if (b1.d != null)
                {
                    viewgroup.findViewById(0x7f100a6a).setOnClickListener(b1.d);
                }
                if ("instagramTag".equals(b1.c) && j)
                {
                    RelativeLayout relativelayout = (RelativeLayout)getActivity().getLayoutInflater().inflate(0x7f030247, null, false);
                    k = new PopupWindow(relativelayout, -2, -2);
                    k.setAnimationStyle(0x7f0c00b1);
                    relativelayout.setOnClickListener(new android.view.View.OnClickListener() {

                        private a a;

                        public final void onClick(View view)
                        {
                            com.socialin.android.share.a.b(a);
                        }

            
            {
                a = a.this;
                super();
            }
                    });
                    C = (ImageView)relativelayout.findViewById(0x7f10064b);
                    viewgroup.postDelayed(new Runnable(viewgroup) {

                        private ViewGroup a;
                        private a b;

                        public final void run()
                        {
                            a.a(b, a);
                        }

            
            {
                b = a.this;
                a = viewgroup;
                super();
            }
                    }, 450L);
                }
                gridlayout.addView(viewgroup);
            }
        } while (true);
    }

    static void a(a a1, View view)
    {
        int k1 = a1.i();
        Activity activity = a1.getActivity();
        int i1;
        if (a1.t == null && activity == null)
        {
            i1 = 0;
        } else
        if (!a1.h().getBoolean("instagramOpened", false))
        {
            i1 = A;
        } else
        {
            i1 = B;
        }
        if (k1 <= i1 && (a1.q <= 0 || a1.q != a1.r) && (SocialinV3.getInstance() == null || SocialinV3.getInstance().getSettings().isSquareFitOnInstagramShareEnabled()))
        {
            Handler handler = new Handler();
            Rect rect = a(view);
            Rect rect1 = a(a1.getView());
            if (rect != null && rect1 != null)
            {
                rect.offset(-rect1.left, 0);
                int j1;
                if (rect1.right - rect.right < rect.width())
                {
                    j1 = (rect.width() * 3) / 2;
                } else
                {
                    j1 = rect.width() / 2;
                }
                a1.k.showAtLocation(view, 51, rect.left, rect.top - rect1.top - (int)Utils.a(5F, a1.getActivity().getApplicationContext()));
                a1.C.setTranslationX(j1);
                view = a1.getActivity();
                if (a1.t != null || view != null)
                {
                    a1.h().edit().putInt("shownCount", a1.i() + 1).apply();
                }
                handler.postDelayed(a1. new Runnable() {

                    private a a;

                    public final void run()
                    {
                        try
                        {
                            a.r(a).dismiss();
                            return;
                        }
                        catch (IllegalArgumentException illegalargumentexception)
                        {
                            return;
                        }
                    }

            
            {
                a = a.this;
                super();
            }
                }, 4000L);
                return;
            }
        }
    }

    static void a(a a1, Runnable runnable)
    {
        a1.a(runnable);
    }

    static void a(a a1, String s1)
    {
        a1.c(s1);
    }

    static void a(a a1, String s1, String s2, String s3)
    {
        if (a1.getActivity() != null && !a1.getActivity().isFinishing())
        {
            g g1 = new g(a1.getActivity());
            Intent intent = new Intent("android.intent.action.SEND");
            Bundle bundle = new Bundle();
            bundle.putString("gifDir", (new File(s1)).getParentFile().getAbsolutePath());
            bundle.putString("gifName", (new File(a1.c)).getName().replace(".gif", ""));
            (a1. new ModernAsyncTask(g1, bundle, intent, s2, s3) {

                private g a;
                private Bundle b;
                private Intent c;
                private String d;
                private String e;
                private a f;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = MP4EncoderDexLoader.loadDexEncoder(f.getActivity(), b);
                    File file = new File(((MP4WriterFactory) (aobj)).getOutputAbsolutePath());
                    if (file.exists())
                    {
                        file.delete();
                    }
                    ((MP4WriterFactory) (aobj)).createGifMovie();
                    c.setPackage("com.instagram.android");
                    c.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(((MP4WriterFactory) (aobj)).getOutputAbsolutePath()).toString()));
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    super.onPostExecute((Void)obj);
                    if (a.isShowing())
                    {
                        a.dismiss();
                    }
                    c.putExtra("android.intent.extra.SUBJECT", f.getString(0x7f0808af));
                    c.setType(d);
                    c.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(f, e));
                    f.getActivity().startActivity(c);
                }

                protected final void onPreExecute()
                {
                    super.onPreExecute();
                    a.show();
                }

            
            {
                f = a.this;
                a = g1;
                b = bundle;
                c = intent;
                d = s1;
                e = s2;
                super();
            }
            }).execute(new Void[0]);
        }
    }

    static void a(a a1, String s1, String s2, String s3, String s4)
    {
        if (a1.getActivity() != null && !a1.getActivity().isFinishing())
        {
            s1 = new PhotoPost(s1);
            s1.setAndroidDeeplink(s3);
            s1.setIOSDeepLink(s3);
            s1.setWebLink(s4);
            s1.setCaption(s2);
            s1.setPostListener(a1.E);
            TumblrShare.post(a1.getActivity(), s1);
        }
    }

    static void a(a a1, List list, boolean flag, boolean flag1, String s1, String s2)
    {
        if (a1.getActivity() != null && !a1.getActivity().isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s4;
        ArrayList arraylist;
        String s5;
        Iterator iterator;
        s5 = (new StringBuilder()).append(a1.d()).append(" ").toString();
        s4 = a(a1.e);
        arraylist = new ArrayList();
        iterator = list.iterator();
        list = null;
_L4:
        ResolveInfo resolveinfo;
        Intent intent;
        String s6;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_1470;
        }
        resolveinfo = (ResolveInfo)iterator.next();
        intent = new Intent("android.intent.action.SEND");
        s6 = resolveinfo.activityInfo.packageName;
        String s3 = a1.c;
        boolean flag2 = s6.startsWith("com.instagram.android");
        boolean flag3 = s6.startsWith("com.google.android.apps.plus");
        if ("instagramTag".equals(s1) || flag2)
        {
            list = a1.e();
        }
        Object obj;
        if (flag)
        {
            if (("instagramTag".equals(s1) || flag2) && !TextUtils.isEmpty(list))
            {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(list)));
            } else
            {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(s3)));
            }
            intent.setType("image/*");
        } else
        {
            intent.setType("text/*");
        }
        obj = (new StringBuilder()).append(s5);
        if (TextUtils.isEmpty(s2))
        {
            s3 = s4;
        } else
        {
            s3 = s2;
        }
        intent.putExtra("android.intent.extra.TEXT", ((StringBuilder) (obj)).append(s3).toString());
        if (flag2 || flag3 && flag)
        {
            intent.putExtra("android.intent.extra.TEXT", "#PicsArt");
        }
        if ("instagramTag".equals(s1))
        {
            s3 = "";
            if (a1.a)
            {
                if (a1.g != null)
                {
                    s3 = a1.g.title;
                } else
                {
                    s3 = "";
                }
            }
            obj = s3;
            if (!s3.contains("#PicsArt"))
            {
                obj = (new StringBuilder()).append(s3).append(" #PicsArt").toString();
            }
            intent.putExtra("android.intent.extra.TEXT", ((String) (obj)));
        }
        intent.putExtra("subject", a1.getString(0x7f0808af));
        if ("emailTag".equals(s1))
        {
            intent.setType("text/html");
            intent.putExtra("subject", a1.getString(0x7f08040e));
            s3 = a(a1.e);
            obj = (new StringBuilder("<a href=\"")).append(s3).append("\"> ").append(a1.getString(0x7f080437)).append(" </a>").toString();
            if (a1.g != null)
            {
                if (a1.a)
                {
                    s3 = (new StringBuilder("<p>")).append(a1.getString(0x7f080410)).append(((String) (obj))).append(a1.getString(0x7f080411)).append("</p>").toString();
                } else
                {
                    if (a1.g.user == null)
                    {
                        s3 = "user";
                    } else
                    {
                        s3 = (new StringBuilder("@")).append(a1.g.user.username).toString();
                        s3 = (new StringBuilder("<a href=\"http://")).append(a1.g.user.username).append(".picsart.com\">").append(s3).append("</a>'s").toString();
                    }
                    s3 = (new StringBuilder()).append(a1.getString(0x7f080412, new Object[] {
                        s3
                    })).append(((String) (obj))).append(a1.getString(0x7f080413, new Object[] {
                        a1.getString(0x7f080324), ""
                    })).toString();
                }
            } else
            {
                s3 = (new StringBuilder()).append(a1.getResources().getString(0x7f080410)).append(" ").append(a1.getString(0x7f080437)).append(" ").append(a1.getString(0x7f080411)).toString();
            }
            if (TextUtils.isEmpty(s2))
            {
                obj = a1.getString(0x7f0808b3);
            } else
            {
                obj = s2;
            }
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder("<html>")).append(s3).append("<br>").append(a1.getString(0x7f08046f)).append(" ").append(((String) (obj))).append("</html>").toString()));
        }
        if (s6.startsWith("com.twitter"))
        {
            if (TextUtils.isEmpty(s2))
            {
                s3 = a1.getString(0x7f0808b3);
            } else
            {
                s3 = s2;
            }
            if (a1.e > 0L)
            {
                if (TextUtils.isEmpty(s2))
                {
                    s3 = a(a1.e);
                } else
                {
                    s3 = s2;
                }
                if (a1.a)
                {
                    if (a1.g != null)
                    {
                        obj = a1.g.title;
                    } else
                    {
                        obj = "";
                    }
                    obj = TwitterSessionManager.trimTweetMessage(((String) (obj)), 94);
                    s3 = (new StringBuilder()).append(((String) (obj))).append("\n").append(s3).toString();
                } else
                {
                    byte byte0;
                    if (a1.g == null || a1.g.user == null)
                    {
                        obj = "";
                    } else
                    {
                        obj = (new StringBuilder("@")).append(a1.g.user.username).append("'s").toString();
                    }
                    s3 = (new StringBuilder()).append(a1.getString(0x7f080412, new Object[] {
                        obj
                    })).append(" ").append(a1.getString(0x7f080437)).append(" ").append(a1.getString(0x7f080413, new Object[] {
                        "#PicsArt", s3
                    })).toString();
                    if (s3.contains("https"))
                    {
                        byte0 = 94;
                    } else
                    {
                        byte0 = 95;
                    }
                    s3 = TwitterSessionManager.trimTweetMessage(s3, "", byte0);
                }
            } else
            {
                s3 = TwitterSessionManager.trimTweetMessage((new StringBuilder("#PicsArt\n")).append(s3).toString(), "", 140);
            }
            try
            {
                obj = String.format("ttps://twitter.com/intent/tweet?text=%s&url=%s", new Object[] {
                    URLEncoder.encode(s3, e.a.name()), URLEncoder.encode(s4, e.a.name())
                });
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b(h, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                exception = null;
            }
            intent.setData(Uri.parse(((String) (obj))));
            intent.putExtra("android.intent.extra.TEXT", s3);
        }
        obj = (new StringBuilder()).append(s5);
        if (TextUtils.isEmpty(s2))
        {
            s3 = "";
        } else
        {
            s3 = s2;
        }
        intent.putExtra("sms_body", ((StringBuilder) (obj)).append(s3).toString());
        if (a1.getActivity() == null || a1.getActivity().isFinishing()) goto _L1; else goto _L3
_L3:
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        intent.setClassName(s6, resolveinfo.activityInfo.name);
_L6:
        arraylist.add(intent);
          goto _L4
        if (s6.equalsIgnoreCase("com.picsart.studio")) goto _L4; else goto _L5
_L5:
        intent.setClassName(s6, resolveinfo.activityInfo.name);
          goto _L6
        byte byte1 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 1520
    //                   -59005913: 1691
    //                   761136734: 1640
    //                   1239863301: 1674
    //                   2066205320: 1657;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        byte1;
        JVM INSTR tableswitch 0 3: default 1552
    //                   0 1708
    //                   1 1718
    //                   2 1729
    //                   3 1739;
           goto _L12 _L13 _L14 _L15 _L16
_L12:
        if (arraylist.size() > 1)
        {
            list = Intent.createChooser((Intent)arraylist.remove(0), a1.getString(0x7f08068f));
            if (arraylist.size() > 0)
            {
                list.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arraylist.toArray(new Parcelable[0]));
            }
        } else
        {
            list = (Intent)arraylist.remove(0);
        }
        a1.getActivity().startActivity(list);
        if (a1.j)
        {
            a1.getActivity().finish();
            return;
        }
          goto _L1
_L9:
        if (s1.equals("emailTag"))
        {
            byte1 = 0;
        }
          goto _L7
_L11:
        if (s1.equals("instagramTag"))
        {
            byte1 = 1;
        }
          goto _L7
_L10:
        if (s1.equals("moreTag"))
        {
            byte1 = 2;
        }
          goto _L7
_L8:
        if (s1.equals("twitterTag"))
        {
            byte1 = 3;
        }
          goto _L7
_L13:
        a1.c("email");
          goto _L12
_L14:
        a1.b("instagram", list);
          goto _L12
_L15:
        a1.c("other");
          goto _L12
_L16:
        a1.c("twitter");
          goto _L12
    }

    private void a(Runnable runnable)
    {
        if (runnable == null)
        {
            return;
        }
        if (c == null || !(new File(c)).exists())
        {
            (new ModernAsyncTask(runnable) {

                private Runnable a;
                private a b;

                protected final Object doInBackground(Object aobj[])
                {
                    return Integer.valueOf(com.socialin.android.share.a.c(b));
                }

                protected final void onPostExecute(Object obj)
                {
                    obj = (Integer)obj;
                    super.onPostExecute(obj);
                    if (!isCancelled() && b.getActivity() != null && !b.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
                    {
                        a.run();
                    }
                }

            
            {
                b = a.this;
                a = runnable;
                super();
            }
            }).execute(new Void[0]);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    private void a(String s1, String s2)
    {
        Intent intent = new Intent("android.intent.action.SEND", null);
        if ("com.instagram.android".equals(s1))
        {
            intent.setPackage("com.instagram.android");
        }
        if ("com.twitter.android".equals(s1))
        {
            intent.setPackage("com.twitter.android");
        }
        com.socialin.android.d.b(h, new Object[] {
            "initOtherAppShare", (new StringBuilder("show apps only with ")).append(s2).append(" mimeType").toString()
        });
        intent.setDataAndType(null, s2);
        s2 = getActivity().getPackageManager().queryIntentActivities(intent, 0x10000);
        if (s2 == null || s2.size() <= 0) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 160
    //                   -662003450: 291
    //                   10619783: 275;
           goto _L3 _L4 _L5
_L3:
        byte0;
        JVM INSTR tableswitch 0 1: default 184
    //                   0 307
    //                   1 463;
           goto _L6 _L7 _L8
_L6:
        s1 = new com.socialin.android.share.b(getResources().getDrawable(0x7f02064b), getString(0x7f080303), "moreTag");
        a(((List) (s2)), b, true, ((com.socialin.android.share.b) (s1)), "more");
        AnalyticUtils.getInstance(getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("more", "bin")).setOwner(a).setFreeToEdit(b));
        m.add(s1);
_L2:
        return;
_L5:
        if (s1.equals("com.twitter.android"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s1.equals("com.instagram.android"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        s2 = s2.iterator();
        do
        {
            if (!s2.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s1 = (ResolveInfo)s2.next();
        } while (((ResolveInfo) (s1)).activityInfo.packageName == null || !((ResolveInfo) (s1)).activityInfo.packageName.toLowerCase().startsWith("com.twitter"));
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L9
_L9:
        s2 = new com.socialin.android.share.b(getResources().getDrawable(0x7f02064d), getString(0x7f080360), "twitterTag");
        a(Arrays.asList(new ResolveInfo[] {
            s1
        }), b, false, ((com.socialin.android.share.b) (s2)), "twitter");
        AnalyticUtils.getInstance(getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("twitter", "bin")).setOwner(a).setFreeToEdit(b));
        m.add(s2);
        return;
_L8:
        s1 = new com.socialin.android.share.b(getResources().getDrawable(0x7f02064a), getString(0x7f0802e2), "instagramTag");
        if (q > 0 && q == r || SocialinV3.getInstance() != null && !SocialinV3.getInstance().getSettings().isSquareFitOnInstagramShareEnabled())
        {
            a(Arrays.asList(new ResolveInfo[] {
                (ResolveInfo)s2.get(0)
            }), true, false, ((com.socialin.android.share.b) (s1)), "instagram");
        } else
        {
            s1.d = new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view)
                {
                    if (a.j(a))
                    {
                        com.socialin.android.share.a.b(a);
                    }
                }

            
            {
                a = a.this;
                super();
            }
            };
        }
        AnalyticUtils.getInstance(getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("instagram", "bin")).setOwner(a).setFreeToEdit(b));
        m.add(s1);
        return;
        if (true) goto _L3; else goto _L10
_L10:
    }

    private void a(List list, boolean flag, boolean flag1, com.socialin.android.share.b b1, String s1)
    {
        b1.d = new android.view.View.OnClickListener(b1, s1, list, flag, flag1) {

            final com.socialin.android.share.b a;
            final String b;
            final List c;
            final boolean d;
            final boolean e;
            final a f;

            public final void onClick(View view)
            {
                a.a(f, new Runnable(this) {

                    final _cls18 a;

                    public final void run()
                    {
                        String s5 = a.a.c;
                        String s4 = a.b;
                        String s3 = "photo_share_other";
                        String s1 = s4;
                        String s2 = s3;
                        if (TextUtils.isEmpty(s4))
                        {
                            if ("instagramTag".equals(s5))
                            {
                                s1 = "instagram";
                                s2 = "photo_share_instagram";
                            } else
                            if ("emailTag".equals(s5))
                            {
                                s1 = "email";
                                s2 = "photo_share_emaill";
                            } else
                            if ("twitterTag".equals(s5))
                            {
                                s1 = "twitter";
                                s2 = "photo_share_twitter";
                            } else
                            {
                                s1 = "other";
                                s2 = s3;
                            }
                        }
                        myobfuscated.cy.d.a(a.f.getActivity(), s1, s2, com.socialin.android.share.a.h(a.f), new io.branch.referral.g(this, s5) {

                            private String a;
                            private _cls1 b;

                            public final void a(String s1, io.branch.referral.m m1)
                            {
                                a.a(b.a.f, b.a.c, b.a.d, b.a.e, a, s1);
                            }

            
            {
                b = _pcls1;
                a = s1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls18;
                super();
            }
                });
            }

            
            {
                f = a.this;
                a = b1;
                b = s1;
                c = list;
                d = flag;
                e = flag1;
                super();
            }
        };
    }

    static String b(a a1, String s1)
    {
        return a1.a(s1);
    }

    private void b()
    {
        Object obj = new Intent("android.intent.action.SEND", null);
        int i1 = 0;
        do
        {
label0:
            {
                String as[] = c.e;
                if (i1 < 2)
                {
                    ((Intent) (obj)).setPackage(c.e[i1]);
                    ((Intent) (obj)).setDataAndType(null, "image/*");
                    List list = getActivity().getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
                    if (list == null || list.size() <= 0)
                    {
                        break label0;
                    }
                    obj = new com.socialin.android.share.b(getResources().getDrawable(0x7f020646), getString(0x7f0802bf), "emailTag");
                    a(Arrays.asList(new ResolveInfo[] {
                        (ResolveInfo)list.get(0)
                    }), b, false, ((com.socialin.android.share.b) (obj)), "email");
                    AnalyticUtils.getInstance(getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("email", "bin")).setOwner(a).setFreeToEdit(b));
                    m.add(obj);
                }
                return;
            }
            i1++;
        } while (true);
    }

    static void b(a a1)
    {
        a1.a(a1. new Runnable() {

            private a a;

            public final void run()
            {
                com.socialin.android.share.a.d(a);
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void b(String s1)
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        }
        b("instagram", s1);
        Object obj = "";
        String s2;
        String s3;
        String s4;
        if (a)
        {
            if (g != null)
            {
                obj = g.title;
            } else
            {
                obj = "";
            }
        }
        s2 = ((String) (obj));
        if (!((String) (obj)).contains("#PicsArt"))
        {
            s2 = (new StringBuilder()).append(((String) (obj))).append(" #PicsArt").toString();
        }
        s3 = (new StringBuilder()).append(d()).append(" ").toString();
        s4 = a(e);
        obj = new Intent("android.intent.action.SEND");
        if (b)
        {
            ((Intent) (obj)).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(s1)));
            ((Intent) (obj)).setType("image/*");
        } else
        {
            ((Intent) (obj)).setType("text/*");
        }
        ((Intent) (obj)).setPackage("com.instagram.android");
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s3).append(s4).toString());
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", "#PicsArt");
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", s2);
        s1 = getActivity();
        if (t != null || s1 != null)
        {
            h().edit().putBoolean("instagramOpened", true).apply();
        }
        getActivity().startActivity(((Intent) (obj)));
        getActivity().finish();
    }

    private void b(String s1, String s2)
    {
        String s3;
        int j1 = 0;
        android.location.Location location = com.picsart.studio.utils.c.a(getActivity(), null);
        EditingData editingdata;
        int i1;
        if (j)
        {
            editingdata = EditingData.a(s2);
            if (!s2.isEmpty())
            {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(s2, options);
                i1 = options.outHeight;
                j1 = options.outWidth;
            } else
            {
                i1 = r;
                j1 = q;
            }
        } else
        {
            editingdata = EditingData.a(location);
            i1 = 0;
        }
        s3 = FileUtils.d(s2).toString();
        if (s3 == null) goto _L2; else goto _L1
_L1:
        if (!s3.equalsIgnoreCase("jpeg") && !s3.equalsIgnoreCase("jpg")) goto _L4; else goto _L3
_L3:
        s2 = "jpg";
_L6:
        AnalyticUtils.trackImageExport(getActivity(), s1, editingdata, s2, i1, j1, location);
        return;
_L4:
        if (s3.equals("png"))
        {
            s2 = "png";
        } else
        {
            s2 = s3;
            if (s3.equals("gif"))
            {
                s2 = "gif";
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s2 = "";
        if (true) goto _L6; else goto _L5
_L5:
    }

    private int c()
    {
        boolean flag = false;
        if (getActivity() != null && !getActivity().isFinishing()) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
_L4:
        return byte0;
_L2:
        if (d == null)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = flag;
        if (!d.isRecycled()) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        Object obj2;
        String s1;
        myobfuscated.f.m.a(getActivity(), f);
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_566;
        }
        if (!com.socialin.android.util.s.a(getActivity()))
        {
            myobfuscated.cv.c.a(getActivity());
            return -1;
        }
        obj2 = s.substring(s.lastIndexOf("."), s.length());
        s1 = (new StringBuilder()).append(e).append("_orig").toString();
        obj1 = null;
        obj = null;
        InputStream inputstream = com.socialin.android.util.s.b(s);
        obj = inputstream;
        obj1 = inputstream;
        obj2 = new File(new File(y), (new StringBuilder()).append(s1).append(((String) (obj2))).toString());
        obj = inputstream;
        obj1 = inputstream;
        FileUtils.a(((File) (obj2)).getAbsolutePath(), inputstream);
        obj = inputstream;
        obj1 = inputstream;
        boolean flag1 = com.socialin.android.util.w.e(((File) (obj2)).getAbsolutePath());
        if (!flag1)
        {
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.socialin.android.d.b(h, new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                    });
                }
            }
            return -1;
        }
        obj = inputstream;
        obj1 = inputstream;
        c = ((File) (obj2)).getAbsolutePath();
        obj = inputstream;
        obj1 = inputstream;
        com.socialin.android.util.x.c(c, "picsart");
        obj = inputstream;
        obj1 = inputstream;
        d = com.socialin.android.util.c.a(c);
        obj = inputstream;
        obj1 = inputstream;
        new o(getActivity(), ((File) (obj2)).getAbsolutePath(), "image/*");
        obj = inputstream;
        obj1 = inputstream;
        myobfuscated.f.m.b(getActivity(), f);
        byte0 = flag;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(h, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
                return 0;
            }
            return 0;
        }
          goto _L4
        Exception exception1;
        exception1;
        obj1 = obj;
        com.socialin.android.d.b(h, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception1.getMessage()).toString()
        });
        obj1 = obj;
        myobfuscated.f.m.b(getActivity(), f);
        obj1 = obj;
        Utils.a(getActivity(), 0x7f0805ca);
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(h, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        return -1;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (IOException ioexception1)
            {
                com.socialin.android.d.b(h, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
                });
            }
        }
        throw exception;
        if (c != null)
        {
            d = com.socialin.android.util.c.a(c);
            myobfuscated.f.m.b(getActivity(), f);
            return 0;
        } else
        {
            Utils.a(getActivity(), 0x7f0805ca);
            myobfuscated.f.m.b(getActivity(), f);
            return -1;
        }
    }

    static int c(a a1)
    {
        return a1.c();
    }

    static void c(a a1, String s1)
    {
        if (a1.getActivity() != null && !a1.getActivity().isFinishing())
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.whatsapp");
            if (a1.b || a1.a)
            {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(a1.c).toString()));
                intent.setType("image/*");
            } else
            {
                intent.setType("text/*");
            }
            intent.putExtra("android.intent.extra.SUBJECT", a1.getString(0x7f0808af));
            intent.putExtra("android.intent.extra.TEXT", a1.a(s1));
            a1.startActivity(intent);
            a1.c("whatsapp");
        }
    }

    private void c(String s1)
    {
        String s2;
        if (j && p != null)
        {
            s2 = p;
        } else
        {
            s2 = c;
        }
        b(s1, s2);
    }

    private String d()
    {
        String s1;
        if (g == null || g.user == null)
        {
            s1 = getString(0x7f0802ff).toLowerCase();
        } else
        {
            s1 = (new StringBuilder("@")).append(g.user.username).toString();
        }
        return getString(0x7f080408, new Object[] {
            s1
        });
    }

    static void d(a a1)
    {
        Intent intent = new Intent();
        intent.setClassName(a1.getActivity().getApplicationContext(), "com.picsart.studio.editor.activity.SquareFitStandaloneActivity");
        intent.putExtra("imagePath", a1.c);
        intent.putExtra("degree", myobfuscated.f.m.d(a1.c));
        intent.putExtra("defaultEffect", "color");
        intent.putExtra("shareToInstagramOnApply", true);
        a1.startActivityForResult(intent, 1001);
    }

    static void d(a a1, String s1)
    {
        if (a1.getActivity() != null && !a1.getActivity().isFinishing())
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.facebook.orca");
            if (a1.e < 0L)
            {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(a1.c).toString()));
                intent.setType("image/*");
            } else
            {
                intent.setType("text/*");
            }
            intent.putExtra("android.intent.extra.SUBJECT", a1.getString(0x7f0808af));
            intent.putExtra("android.intent.extra.TEXT", a1.a(s1));
            a1.startActivity(intent);
            a1.c("fb_messenger");
        }
    }

    private String e()
    {
        String s1 = c;
        Object obj = BitmapFactory.decodeFile(c);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        Object obj1;
        String s2;
        String s3;
        if (((Bitmap) (obj)).getWidth() == ((Bitmap) (obj)).getHeight())
        {
            break MISSING_BLOCK_LABEL_180;
        }
        obj1 = com.socialin.android.util.w.a(((Bitmap) (obj)));
        s2 = c.substring(0, c.lastIndexOf(File.separator));
        s3 = (new StringBuilder()).append(c.substring(c.lastIndexOf(File.separator) + 1)).append("_insta").toString();
        if (FileUtils.d(c) != com.socialin.android.util.FileUtils.ImageFileFormat.JPEG || ExifTool.b(c) == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = ExifTool.b(c);
_L3:
        obj1 = com.socialin.android.util.w.a(s2, s3, ((Bitmap) (obj1)), getActivity(), android.graphics.Bitmap.CompressFormat.JPEG, false).getAbsolutePath();
        s1 = ((String) (obj1));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        ExifTool.a(s1, ((byte []) (obj)));
        return s1;
        obj;
_L2:
        com.socialin.android.d.b(h, "createSquareImageForInstagram", ((Throwable) (obj)));
        return s1;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj = null;
          goto _L3
        return s1;
    }

    static String e(a a1)
    {
        return a1.c;
    }

    static String e(a a1, String s1)
    {
        a1.o = s1;
        return s1;
    }

    static ImageItem f(a a1)
    {
        return a1.g;
    }

    private void f()
    {
        com.socialin.android.share.b b1 = new com.socialin.android.share.b(getResources().getDrawable(0x7f0201fb), getString(0x7f080340), "saveToSdCardTag");
        b1.d = new android.view.View.OnClickListener() {

            final a a;

            public final void onClick(View view)
            {
                a.a(a, new Runnable(this) {

                    private _cls19 a;

                    public final void run()
                    {
                        Intent intent = new Intent(a.a.getActivity(), com/socialin/android/activity/SaveToSdCardDialogActivity);
                        myobfuscated.cv.c.a(intent, a.a.getActivity());
                        if (!com.socialin.android.share.a.m(a.a))
                        {
                            intent.setData(Uri.parse(com.socialin.android.share.a.e(a.a)));
                        }
                        if (TextUtils.isEmpty(a.n(a.a)))
                        {
                            com.socialin.android.share.a.e(a.a, a.a.getActivity().getString(0x7f0808fb));
                        }
                        intent.putExtra("subFolderName", a.n(a.a));
                        boolean flag;
                        if (!a.j(a.a))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        intent.putExtra("gifPath", flag);
                        intent.putExtra("isReturnResult", com.socialin.android.share.a.m(a.a));
                        if (com.socialin.android.share.a.o(a.a) != null)
                        {
                            intent.putExtra("imageUrl", com.socialin.android.share.a.o(a.a));
                        }
                        a.a.startActivityForResult(intent, 92);
                    }

            
            {
                a = _pcls19;
                super();
            }
                });
            }

            
            {
                a = a.this;
                super();
            }
        };
        m.add(b1);
    }

    private void g()
    {
        com.socialin.android.share.b b1 = new com.socialin.android.share.b(getResources().getDrawable(0x7f02064c), getString(0x7f080324), "picsartShareTag");
        myobfuscated.cv.c.a(new Intent(), getActivity());
        b1.d = new android.view.View.OnClickListener() {

            final a a;

            public final void onClick(View view)
            {
                long l1;
                if (a.f(a) != null)
                {
                    l1 = a.f(a).id;
                } else
                {
                    l1 = com.socialin.android.share.a.h(a);
                }
                if (l1 > 0L)
                {
                    view = a.getActivity();
                    ImageItem imageitem = a.f(a);
                    String s1 = myobfuscated.f.m.a(a.getActivity().getIntent(), "from");
                    a.j(a);
                    myobfuscated.cv.c.a(view, imageitem, l1, null, s1, myobfuscated.f.m.a(a.getActivity().getIntent(), "action"));
                    AnalyticUtils.getInstance(a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("picsart", "url")).setOwner(a.a).setFreeToEdit(a.b).setDestSection("page"));
                    if (a.j(a))
                    {
                        a.getActivity().finish();
                    }
                    return;
                } else
                {
                    a.a(a, new Runnable(this) {

                        private _cls20 a;

                        public final void run()
                        {
                            Activity activity = a.a.getActivity();
                            String s1 = com.socialin.android.share.a.e(a.a);
                            a.j(a.a);
                            myobfuscated.cv.c.a(activity, s1, myobfuscated.f.m.a(a.a.getActivity().getIntent(), "from"), myobfuscated.f.m.a(a.a.getActivity().getIntent(), "action"));
                            AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("picsart", "url")).setOwner(a.a.a).setFreeToEdit(a.a.b).setDestSection("page"));
                            if (a.j(a.a))
                            {
                                a.a.getActivity().finish();
                            }
                        }

            
            {
                a = _pcls20;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        m.add(b1);
    }

    static void g(a a1)
    {
        a1.c("tumblr");
        TumblrShare.setOAuthConfig(a1.getString(0x7f080970), a1.getString(0x7f080971));
        String s1;
        String s2;
        String s3;
        if (a1.g == null && a1.c != null && (new File(a1.c)).exists())
        {
            s1 = a1.c;
            s2 = "http://picsart.com";
            s3 = "picsart://";
        } else
        {
            s3 = (new StringBuilder("picsart://photos?id=")).append(a1.g.id).toString();
            s1 = a1.g.getLargeUrl();
            s2 = (new StringBuilder("http://picsart.com/i/")).append(a1.e).toString();
        }
        myobfuscated.cy.d.a(a1.getActivity(), "tumblr", "photo_share_tumblr", a1.e, a1. new io.branch.referral.g(s1, s3, s2) {

            private String a;
            private String b;
            private String c;
            private a d;

            public final void a(String s4, io.branch.referral.m m1)
            {
                a.a(d, a, com.socialin.android.share.a.b(d, s4), b, c);
            }

            
            {
                d = a.this;
                a = s1;
                b = s2;
                c = s3;
                super();
            }
        });
    }

    static long h(a a1)
    {
        return a1.e;
    }

    private SharedPreferences h()
    {
        if (t == null)
        {
            t = getActivity().getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(getActivity().getApplicationContext(), "app_name_short"))).toString(), 0);
        }
        return t;
    }

    private int i()
    {
        Activity activity = getActivity();
        if (t == null && activity == null)
        {
            return A + 1;
        } else
        {
            return h().getInt("shownCount", 0);
        }
    }

    static void i(a a1)
    {
        String as[] = new String[2];
        as[0] = a1.getString(0x7f080264);
        as[1] = a1.getString(0x7f080263);
        a1 = (new android.app.AlertDialog.Builder(a1.getActivity())).setItems(as, a1. new android.content.DialogInterface.OnClickListener(as) {

            private String a[];
            private a b;

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
                if (com.socialin.android.util.s.a(b.getActivity())) goto _L2; else goto _L1
_L1:
                myobfuscated.cv.c.a(b.getActivity());
_L6:
                return;
_L2:
                dialoginterface = "";
                String s1 = a[i1];
                dialoginterface = s1;
_L4:
                if (dialoginterface.equals(b.getString(0x7f080264)))
                {
                    dialoginterface = b;
                    com.facebook.CallbackManager callbackmanager = com.facebook.CallbackManager.Factory.create();
                    FacebookUtils.postOnFbWall(((a) (dialoginterface)).c, dialoginterface.a(), ((a) (dialoginterface)).g, ((a) (dialoginterface)).e, dialoginterface.getActivity(), ((a) (dialoginterface)).b, callbackmanager, false);
                    AnalyticUtils.getInstance(b.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("facebook", "url")).setOwner(b.a).setFreeToEdit(b.b).setDestSection("timeline"));
                    return;
                }
                break; /* Loop/switch isn't completed */
                IndexOutOfBoundsException indexoutofboundsexception;
                indexoutofboundsexception;
                myobfuscated.f.m.b(b.getActivity(), a.l(b));
                if (true) goto _L4; else goto _L3
_L3:
                if (!dialoginterface.equals(b.getString(0x7f080263))) goto _L6; else goto _L5
_L5:
                dialoginterface = b;
                if (!com.socialin.android.util.s.a(dialoginterface.getActivity()))
                {
                    myobfuscated.cv.c.a(dialoginterface.getActivity());
                } else
                {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("item", ((a) (dialoginterface)).g);
                    bundle.putString("path", ((a) (dialoginterface)).c);
                    bundle.putString("postMessage", dialoginterface.a());
                    bundle.putBoolean("freeToEdit", ((a) (dialoginterface)).b);
                    FacebookUtils.openPostToPageScreen(dialoginterface.getActivity(), com.facebook.CallbackManager.Factory.create(), bundle);
                }
                AnalyticUtils.getInstance(b.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("facebook", "url")).setOwner(b.a).setFreeToEdit(b.b).setDestSection("page"));
                return;
            }

            
            {
                b = a.this;
                a = as;
                super();
            }
        }).setCancelable(true).create();
        if (a1 != null)
        {
            a1.show();
        }
    }

    static boolean j(a a1)
    {
        return a1.j;
    }

    static Bitmap k(a a1)
    {
        return a1.d;
    }

    static g l(a a1)
    {
        return a1.f;
    }

    static boolean m(a a1)
    {
        return a1.u;
    }

    static String n(a a1)
    {
        return a1.o;
    }

    static String o(a a1)
    {
        return a1.s;
    }

    static void p(a a1)
    {
        if (!com.socialin.android.util.s.a(a1.getActivity()))
        {
            myobfuscated.cv.c.a(a1.getActivity());
        } else
        if (SocialinV3.getInstance().isRegistered())
        {
            if (!a1.g.isReposted)
            {
                Object obj1 = AnalyticUtils.getInstance(a1.getActivity());
                long l3 = a1.g.id;
                Object obj;
                long l1;
                boolean flag;
                if (a1.g.user != null)
                {
                    l1 = a1.g.user.id;
                } else
                {
                    l1 = -1L;
                }
                flag = a1.g.isMature;
                if (a1.g.tags == null)
                {
                    obj = new JSONArray();
                } else
                {
                    obj = new JSONArray(Arrays.asList(a1.g.tags));
                }
                ((AnalyticUtils) (obj1)).track(new com.socialin.android.apiv3.events.EventsFactory.PhotoRepostEvent(l3, "more", l1, flag, ((JSONArray) (obj))));
                obj = RequestControllerFactory.createRepostItemController();
                obj1 = (ParamWithItemId)((BaseSocialinApiRequestController) (obj)).getRequestParams();
                if (a1.g.origin != null)
                {
                    l1 = a1.g.origin.id;
                } else
                {
                    l1 = a1.g.id;
                }
                obj1.itemId = l1;
                myobfuscated.f.m.a(a1.getActivity(), a1.f);
                ((BaseSocialinApiRequestController) (obj)).setRequestCompleteListener(a1. new com.socialin.asyncnet.d() {

                    private a a;

                    public final volatile void onCancelRequest(Object obj2, Request request)
                    {
                    }

                    public final void onFailure(Exception exception, Request request)
                    {
                        myobfuscated.f.m.b(a.getActivity(), a.l(a));
                        Utils.a(a.getActivity(), 0x7f0802c9);
                        a.getActivity().finish();
                    }

                    public final transient void onProgressUpdate(Integer ainteger[])
                    {
                    }

                    public final void onSuccess(Object obj2, Request request)
                    {
                        a.getActivity().sendBroadcast((new Intent()).setAction("com.picsart.studio.action.repost").putExtra("extra.item.id", a.f(a).id));
                        request = a.q(a).findViewWithTag("picsartRepost");
                        if (request != null)
                        {
                            obj2 = (ImageView)request.findViewById(0x7f100a6b);
                            request = (TextView)request.findViewById(0x7f100a6c);
                            if (obj2 != null)
                            {
                                ((ImageView) (obj2)).setImageDrawable(a.getResources().getDrawable(0x7f0205f1));
                            }
                            if (request != null)
                            {
                                request.setText(a.getString(0x7f08033a));
                            }
                        }
                        a.f(a).isReposted = true;
                        myobfuscated.f.m.b(a.getActivity(), a.l(a));
                        Utils.a(a.getActivity(), 0x7f080564);
                        a.getActivity().finish();
                    }

            
            {
                a = a.this;
                super();
            }
                });
                ((BaseSocialinApiRequestController) (obj)).doRequest("repost");
                return;
            }
            BaseSocialinApiRequestController basesocialinapirequestcontroller = RequestControllerFactory.createUnpostItemController();
            ParamWithItemId paramwithitemid = (ParamWithItemId)basesocialinapirequestcontroller.getRequestParams();
            long l2;
            if (a1.g.origin != null)
            {
                l2 = a1.g.origin.id;
            } else
            {
                l2 = a1.g.id;
            }
            paramwithitemid.itemId = l2;
            myobfuscated.f.m.a(a1.getActivity(), a1.f);
            basesocialinapirequestcontroller.setRequestCompleteListener(a1. new com.socialin.asyncnet.d() {

                private a a;

                public final volatile void onCancelRequest(Object obj2, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    myobfuscated.f.m.b(a.getActivity(), a.l(a));
                    Utils.a(a.getActivity(), 0x7f0802c9);
                    a.getActivity().finish();
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj2, Request request)
                {
                    a.getActivity().sendBroadcast((new Intent()).setAction("com.picsart.studio.action.unrepost").putExtra("extra.item.id", a.f(a).id));
                    obj2 = a.q(a).findViewWithTag("picsartRepost");
                    if (obj2 != null)
                    {
                        obj2 = (ImageView)((View) (obj2)).findViewById(0x7f100a6b);
                        if (obj2 != null)
                        {
                            ((ImageView) (obj2)).setImageDrawable(a.getResources().getDrawable(0x7f0205f2));
                        }
                    }
                    a.f(a).isReposted = false;
                    myobfuscated.f.m.b(a.getActivity(), a.l(a));
                    Utils.a(a.getActivity(), 0x7f080650);
                    a.getActivity().finish();
                }

            
            {
                a = a.this;
                super();
            }
            });
            basesocialinapirequestcontroller.doRequest("unpost");
            return;
        }
    }

    static GridLayout q(a a1)
    {
        return a1.n;
    }

    static PopupWindow r(a a1)
    {
        return a1.k;
    }

    final String a()
    {
        if (g != null)
        {
            return g.title;
        } else
        {
            return "";
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        boolean flag = true;
        super.onActivityCreated(bundle);
        n = (GridLayout)getView().findViewById(0x7f1007bb);
        y = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getActivity().getString(0x7f0808fb)).append("/").append(getActivity().getString(0x7f0808c0)).append("/").append(getActivity().getString(0x7f0808f4)).append("/").toString();
        x = getString(0x7f0808c8);
        f = new g(getActivity());
        f.setCancelable(true);
        f.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private a a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                if (a.a(a) != null)
                {
                    a.a(a).cancel(true);
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        bundle = getActivity().getIntent();
        Object obj;
        boolean flag1;
        boolean flag2;
        if (bundle.hasExtra("item"))
        {
            try
            {
                g = (ImageItem)bundle.getParcelableExtra("item");
                e = g.id;
                s = g.url;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (g == null && bundle.hasExtra("item_id"))
        {
            e = bundle.getLongExtra("item_id", -1L);
        }
        com.socialin.android.d.b(h, new Object[] {
            "onCreate() - itemId:", Long.valueOf(e)
        });
        if (bundle.hasExtra("isReturnResult"))
        {
            u = bundle.getBooleanExtra("isReturnResult", false);
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - isReturnResult:", Boolean.valueOf(u)
            });
        }
        if (bundle.hasExtra("subFolderName"))
        {
            o = bundle.getStringExtra("subFolderName");
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - subFolderName:", o
            });
        }
        if (bundle.hasExtra("imageWidth"))
        {
            q = bundle.getIntExtra("imageWidth", 0);
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - imageWidth:", Integer.valueOf(q)
            });
        }
        if (bundle.hasExtra("imageHeight"))
        {
            r = bundle.getIntExtra("imageHeight", 0);
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - imageHeight:", Integer.valueOf(r)
            });
        }
        if (!TextUtils.isEmpty(s))
        {
            String s1 = s.substring(s.lastIndexOf("."), s.length());
            String s3 = (new StringBuilder()).append(e).append("_orig").toString();
            c = (new StringBuilder()).append(y).append(s3).append(s1).toString();
        } else
        if (bundle.hasExtra("fileAbsolutePath"))
        {
            c = bundle.getStringExtra("fileAbsolutePath");
        }
        if (bundle.getData() != null)
        {
            if (TextUtils.isEmpty(c))
            {
                c = bundle.getData().getPath();
            }
            p = bundle.getData().getPath();
        } else
        if (bundle.hasExtra("path"))
        {
            if (TextUtils.isEmpty(c))
            {
                c = bundle.getStringExtra("path");
            }
            p = bundle.getStringExtra("path");
        }
        if (bundle.getExtras().getString("gifPath") != null && TextUtils.isEmpty(c))
        {
            c = bundle.getExtras().getString("gifPath");
            j = false;
        }
        com.socialin.android.d.b(h, new Object[] {
            "onCreate() - fileAbsolutePath:", c
        });
        com.socialin.android.d.b(h, new Object[] {
            "onCreate() - fileCachePath:", p
        });
        if (bundle.hasExtra("fbAppId"))
        {
            String s2 = bundle.getStringExtra("fbAppId");
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - fbAppId: ", s2
            });
        } else
        if (getString(0x7f0808e2) == null)
        {
            throw new IllegalStateException();
        }
        if (bundle.hasExtra("fbAppName"))
        {
            bundle = bundle.getStringExtra("fbAppName");
            com.socialin.android.d.b(h, new Object[] {
                "onCreate() - fbAppName: ", bundle
            });
        } else
        if (getString(0x7f0808ad) == null)
        {
            throw new IllegalStateException();
        }
        bundle = null;
        if (g != null && g.user != null)
        {
            if (g.tags != null)
            {
                bundle = Arrays.asList(g.tags);
            }
            long l1 = g.user.id;
            if (SocialinV3.getInstance().getUser() != null && SocialinV3.getInstance().getUser().id == l1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a = flag1;
            if (a || bundle != null && bundle.contains("freetoedit"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            b = flag1;
        }
        flag1 = b;
        flag2 = j;
        i = SocialinAdManager.a(getActivity(), com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.EXPORT);
        obj = SocialinV3.getInstance().getSettings();
        if (flag1 && flag2)
        {
            f();
            bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f02061f), getResources().getString(0x7f0805f6), "saveWallpaperTag");
            bundle.d = new android.view.View.OnClickListener() {

                final a a;

                public final void onClick(View view)
                {
                    a.a(a, new an(this) {

                        private _cls16 a;

                        protected final Object doInBackground(Object aobj[])
                        {
                            return Integer.valueOf(com.socialin.android.share.a.c(a.a));
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (Integer)obj;
                            if (!isCancelled() && a.a.getActivity() != null && !a.a.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
                            {
                                obj = a.a;
                                if (((a) (obj)).d != null)
                                {
                                    ((a) (obj)).f.setMessage(((a) (obj)).getString(0x7f080679));
                                    myobfuscated.f.m.a(((a) (obj)).getActivity(), ((a) (obj)).f);
                                    (new Thread(((_cls17) (obj)). new Runnable() {

                                        private a a;

                                        public final void run()
                                        {
                                            Utils.a(a.getActivity(), a.k(a));
                                            Utils.a(a.getActivity(), 0x7f080473);
                                            myobfuscated.f.m.b(a.getActivity(), a.l(a));
                                            if (a.getActivity() != null && !a.getActivity().isFinishing())
                                            {
                                                a.getActivity().finish();
                                            }
                                        }

            
            {
                a = a.this;
                super();
            }
                                    })).start();
                                } else
                                {
                                    myobfuscated.f.m.b(((a) (obj)).getActivity(), ((a) (obj)).f);
                                    Utils.a(((a) (obj)).getActivity(), 0x7f0805ca);
                                }
                                a.a(a.a, "wallpaper");
                                AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("wallpaper", "bin")).setOwner(a.a.a).setFreeToEdit(a.a.b));
                            }
                        }

            
            {
                a = _pcls16;
                super();
            }
                    });
                    a.a(a).a(new Void[0]);
                }

            
            {
                a = a.this;
                super();
            }
            };
            m.add(bundle);
            g();
            b();
            bundle = getActivity().getPackageManager();
            try
            {
                bundle.getPackageInfo("com.whatsapp", 1);
                bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f02064e), getString(0x7f080372), "whatsappTag");
                bundle.d = new android.view.View.OnClickListener() {

                    final a a;

                    public final void onClick(View view)
                    {
                        a.a(a, new Runnable(this) {

                            final _cls11 a;

                            public final void run()
                            {
                                myobfuscated.cy.d.a(a.a.getActivity(), "whatsapp", "photo_share_whatsapp", com.socialin.android.share.a.h(a.a), new io.branch.referral.g(this) {

                                    private _cls1 a;

                                    public final void a(String s1, io.branch.referral.m m1)
                                    {
                                        com.socialin.android.share.a.c(a.a.a, s1);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                            }

            
            {
                a = _pcls11;
                super();
            }
                        });
                    }

            
            {
                a = a.this;
                super();
            }
                };
                m.add(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(h, "WhatsApp is not installed !!!!! ", bundle);
            }
        } else
        if (flag1 && !flag2)
        {
            f();
            g();
            b();
            if (D)
            {
                bundle = c;
                PackageManager packagemanager = getActivity().getPackageManager();
                try
                {
                    packagemanager.getPackageInfo("com.instagram.android", 1);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    flag = false;
                }
                if (flag)
                {
                    com.socialin.android.share.b b1 = new com.socialin.android.share.b(getResources().getDrawable(0x7f020533), getString(0x7f0802e2), "instagramTag");
                    b1.d = new android.view.View.OnClickListener(bundle, "video/*") {

                        final String a;
                        final String b;
                        final a c;

                        public final void onClick(View view)
                        {
                            myobfuscated.cy.d.a(c.getActivity(), "instagram", "photo_share_instagram", com.socialin.android.share.a.h(c), new io.branch.referral.g(this) {

                                private _cls9 a;

                                public final void a(String s1, io.branch.referral.m m1)
                                {
                                    a.a(a.c, a.a, a.b, s1);
                                }

            
            {
                a = _pcls9;
                super();
            }
                            });
                        }

            
            {
                c = a.this;
                a = s1;
                b = s2;
                super();
            }
                    };
                    m.add(b1);
                }
            }
        } else
        if (!a)
        {
            int i1;
            int j1;
            if (g != null)
            {
                if (g.isReposted)
                {
                    i1 = 0x7f0205f1;
                } else
                {
                    i1 = 0x7f0205f2;
                }
                if (g.isReposted)
                {
                    j1 = 0x7f08033a;
                } else
                {
                    j1 = 0x7f080339;
                }
            } else
            {
                i1 = 0x7f0207a1;
                j1 = 0x7f080339;
            }
            bundle = new com.socialin.android.share.b(getResources().getDrawable(i1), getString(j1), "picsartRepost");
            bundle.d = new android.view.View.OnClickListener() {

                final a a;

                public final void onClick(View view)
                {
                    a.a(a, new an(this) {

                        private _cls21 a;

                        protected final Object doInBackground(Object aobj[])
                        {
                            if (!myobfuscated.cv.c.b(a.a.getActivity()))
                            {
                                return Integer.valueOf(-1);
                            } else
                            {
                                return Integer.valueOf(0);
                            }
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (Integer)obj;
                            if (!isCancelled() && a.a.getActivity() != null && !a.a.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
                            {
                                a.p(a.a);
                                AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("picsart", "url")).setOwner(a.a.a).setFreeToEdit(a.a.b).setDestSection("page"));
                            }
                        }

            
            {
                a = _pcls21;
                super();
            }
                    });
                    a.a(a).a(new Void[0]);
                }

            
            {
                a = a.this;
                super();
            }
            };
            m.add(bundle);
        }
        if (!x.equals(getString(0x7f0808cc)))
        {
            bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f020647), getString(0x7f0802c7), "facebookTag");
            bundle.d = new android.view.View.OnClickListener() {

                final a a;

                public final void onClick(View view)
                {
                    a.a(a, new Runnable(this) {

                        private _cls13 a;

                        public final void run()
                        {
                            a.a(a.a, "facebook");
                            a.i(a.a);
                        }

            
            {
                a = _pcls13;
                super();
            }
                    });
                }

            
            {
                a = a.this;
                super();
            }
            };
            m.add(bundle);
            bundle = getActivity().getPackageManager();
            try
            {
                bundle.getPackageInfo("com.facebook.orca", 1);
                bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f020203), getString(0x7f0802c8), "messengerTag");
                bundle.d = new android.view.View.OnClickListener() {

                    final a a;

                    public final void onClick(View view)
                    {
                        myobfuscated.cy.d.a(a.getActivity(), "fb_messenger", "photo_share_facebook_massenger", com.socialin.android.share.a.h(a), new io.branch.referral.g(this) {

                            private _cls14 a;

                            public final void a(String s1, io.branch.referral.m m1)
                            {
                                com.socialin.android.share.a.d(a.a, s1);
                            }

            
            {
                a = _pcls14;
                super();
            }
                        });
                    }

            
            {
                a = a.this;
                super();
            }
                };
                m.add(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(h, "Messenger is not installed !!!!! ", bundle);
            }
            if ((a || e < 0L) && j)
            {
                if (flag2)
                {
                    bundle = "image/*";
                } else
                {
                    bundle = "video/*";
                }
                a("com.instagram.android", bundle);
            }
            if (j)
            {
                bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f0205c3), getString(0x7f080325), "pinterestTag");
                bundle.d = new android.view.View.OnClickListener() {

                    private a a;

                    public final void onClick(View view)
                    {
                        a.a(a, "pinterest");
                        myobfuscated.cu.a a1 = new myobfuscated.cu.a(a.getActivity());
                        Activity activity = a.getActivity();
                        String s4 = com.socialin.android.share.a.e(a);
                        ImageItem imageitem = a.f(a);
                        boolean flag3;
                        long l2;
                        if (imageitem != null && imageitem.user != null && imageitem.user.id == SocialinV3.getInstance().getUser().id)
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                        if (imageitem != null && imageitem.user != null)
                        {
                            view = (new StringBuilder()).append(imageitem.user.username).append("'s ").toString();
                        } else
                        {
                            view = "";
                        }
                        view = (new StringBuilder()).append(activity.getString(0x7f080412, new Object[] {
                            view
                        })).append(" ").append(activity.getString(0x7f080437)).append(" ").append(activity.getString(0x7f080413, new Object[] {
                            "#PicsArt", ""
                        })).toString();
                        if (flag3)
                        {
                            view = activity.getString(0x7f08040f);
                        }
                        view = (new StringBuilder()).append(view).append("\n").append(activity.getString(0x7f08046f)).append(" ").toString();
                        if (imageitem != null)
                        {
                            l2 = imageitem.id;
                        } else
                        {
                            l2 = -1L;
                        }
                        myobfuscated.cy.d.a(activity, "pinterest", "photo_share_pinterest", l2, new myobfuscated.cu._cls1(a1, activity, s4, imageitem, view));
                    }

            
            {
                a = a.this;
                super();
            }
                };
                m.add(bundle);
            }
            a("com.twitter.android", "image/*");
            if (((Settings) (obj)).isTumblrEnabled())
            {
                bundle = new com.socialin.android.share.b(getResources().getDrawable(0x7f020729), getString(0x7f08035e), "tumblrTag");
                bundle.d = new android.view.View.OnClickListener() {

                    final a a;

                    public final void onClick(View view)
                    {
                        a.a(a, new Runnable(this) {

                            private _cls6 a;

                            public final void run()
                            {
                                com.socialin.android.share.a.g(a.a);
                            }

            
            {
                a = _pcls6;
                super();
            }
                        });
                    }

            
            {
                a = a.this;
                super();
            }
                };
                m.add(bundle);
            }
        } else
        if (flag2)
        {
            if (((Settings) (obj)).isWeiboEnabled())
            {
                bundle = getActivity().getPackageManager();
                com.socialin.android.share.b b4;
                try
                {
                    bundle.getPackageInfo("com.sina.weibo", 1);
                    com.socialin.android.share.b b2 = new com.socialin.android.share.b(getResources().getDrawable(0x7f0206be), getString(0x7f0807d7), "sinWeiboTag");
                    b2.d = new android.view.View.OnClickListener(bundle) {

                        final PackageManager a;
                        final a b;

                        public final void onClick(View view)
                        {
                            a.a(b, new Runnable(this) {

                                private _cls32 a;

                                public final void run()
                                {
                                    a.a(a.b, "sina_weibo");
                                    a a1 = a.b;
                                    PackageManager packagemanager = a.a;
                                    myobfuscated.cy.d.a(a1.getActivity(), "SinaWeibo", a1.e, a1. new io.branch.referral.g(packagemanager) {

                                        private PackageManager a;
                                        private a b;

                                        public final void a(String s1, io.branch.referral.m m1)
                                        {
                                            m1 = new Intent("android.intent.action.SEND");
                                            m1.setType("image/*");
                                            m1.putExtra("android.intent.extra.SUBJECT", b.getResources().getString(0x7f0808af));
                                            m1.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(b, s1));
                                            m1.setFlags(0x10000000);
                                            m1.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(com.socialin.android.share.a.e(b)).toString()));
                                            m1.setType("image/*");
                                            s1 = a.a(a.queryIntentActivities(m1, 0x10000), "com.sina.weibo");
                                            if (!TextUtils.isEmpty(s1))
                                            {
                                                m1.setClassName("com.sina.weibo", s1);
                                                b.startActivity(m1);
                                            }
                                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls32;
                super();
            }
                            });
                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                    };
                    m.add(b2);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(h, "sinaweibo is not installed !!!!! ", bundle);
                }
                bundle = getActivity().getPackageManager();
                try
                {
                    bundle.getPackageInfo("com.tencent.WBlog", 1);
                    com.socialin.android.share.b b3 = new com.socialin.android.share.b(getResources().getDrawable(0x7f0206f8), getString(0x7f0807db), "tenWeiboTag");
                    b3.d = new android.view.View.OnClickListener(bundle) {

                        final PackageManager a;
                        final a b;

                        public final void onClick(View view)
                        {
                            a.a(b, new Runnable(this) {

                                private _cls34 a;

                                public final void run()
                                {
                                    a.a(a.b, "tencent_weibo");
                                    a a1 = a.b;
                                    PackageManager packagemanager = a.a;
                                    myobfuscated.cy.d.a(a1.getActivity(), "TencentWeibo", a1.e, a1. new io.branch.referral.g(packagemanager) {

                                        private PackageManager a;
                                        private a b;

                                        public final void a(String s1, io.branch.referral.m m1)
                                        {
                                            m1 = new Intent("android.intent.action.SEND");
                                            m1.setType("image/*");
                                            m1.putExtra("android.intent.extra.SUBJECT", b.getResources().getString(0x7f0808af));
                                            m1.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(b, s1));
                                            m1.setFlags(0x10000000);
                                            m1.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(com.socialin.android.share.a.e(b)).toString()));
                                            m1.setType("image/*");
                                            s1 = a.a(a.queryIntentActivities(m1, 0x10000), "com.tencent.WBlog");
                                            if (!TextUtils.isEmpty(s1))
                                            {
                                                m1.setClassName("com.tencent.WBlog", s1);
                                                b.startActivity(m1);
                                            }
                                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls34;
                super();
            }
                            });
                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                    };
                    m.add(b3);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(h, "tenweibo is not installed !!!!! ", bundle);
                }
            }
            if (((Settings) (obj)).isWeChatEnabled())
            {
                bundle = getActivity().getPackageManager();
                try
                {
                    bundle.getPackageInfo("com.tencent.mm", 1);
                    b4 = new com.socialin.android.share.b(getResources().getDrawable(0x7f020755), getString(0x7f0807da), "weChatTag");
                    b4.d = new android.view.View.OnClickListener(bundle) {

                        final PackageManager a;
                        final a b;

                        public final void onClick(View view)
                        {
                            a.a(b, new Runnable(this) {

                                private _cls36 a;

                                public final void run()
                                {
                                    a.a(a.b, "wechat");
                                    a a1 = a.b;
                                    PackageManager packagemanager = a.a;
                                    myobfuscated.cy.d.a(a1.getActivity(), "wechat", a1.e, a1. new io.branch.referral.g(packagemanager) {

                                        private PackageManager a;
                                        private a b;

                                        public final void a(String s1, io.branch.referral.m m1)
                                        {
                                            m1 = new Intent("android.intent.action.SEND");
                                            m1.setType("image/*");
                                            m1.putExtra("android.intent.extra.SUBJECT", b.getString(0x7f0808af));
                                            m1.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(b, s1));
                                            m1.setFlags(0x10000000);
                                            s1 = a.a(a.queryIntentActivities(m1, 0x10000), "com.tencent.mm");
                                            if (!TextUtils.isEmpty(s1))
                                            {
                                                m1.setClassName("com.tencent.mm", s1);
                                                b.startActivity(m1);
                                            }
                                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls36;
                super();
            }
                            });
                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                    };
                    m.add(b4);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(h, "wechat is not installed !!!!! ", bundle);
                }
            }
            if (((Settings) (obj)).isQQEnabled())
            {
                bundle = getActivity().getPackageManager();
                try
                {
                    bundle.getPackageInfo("com.tencent.mobileqqi", 1);
                    obj = new com.socialin.android.share.b(getResources().getDrawable(0x7f0205e1), getString(0x7f0807d9), "qqTag");
                    obj.d = new android.view.View.OnClickListener(bundle) {

                        final PackageManager a;
                        final a b;

                        public final void onClick(View view)
                        {
                            a.a(b, new Runnable(this) {

                                private _cls3 a;

                                public final void run()
                                {
                                    a.a(a.b, "qq");
                                    a a1 = a.b;
                                    PackageManager packagemanager = a.a;
                                    myobfuscated.cy.d.a(a1.getActivity(), "qq", a1.e, a1. new io.branch.referral.g(packagemanager) {

                                        private PackageManager a;
                                        private a b;

                                        public final void a(String s1, io.branch.referral.m m1)
                                        {
                                            m1 = new Intent("android.intent.action.SEND");
                                            m1.setType("text/*");
                                            m1.putExtra("android.intent.extra.SUBJECT", b.getString(0x7f0808af));
                                            m1.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(b, s1));
                                            m1.setFlags(0x10000000);
                                            s1 = a.a(a.queryIntentActivities(m1, 0x10000), "com.tencent.mobileqqi");
                                            if (!TextUtils.isEmpty(s1))
                                            {
                                                m1.setClassName("com.tencent.mobileqqi", s1);
                                                b.startActivity(m1);
                                            }
                                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls3;
                super();
            }
                            });
                        }

            
            {
                b = a.this;
                a = packagemanager;
                super();
            }
                    };
                    m.add(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(h, "QQ is not installed !!!!! ", bundle);
                }
            }
        }
        if (e < 0L || a || b)
        {
            bundle = "image/*";
        } else
        {
            bundle = "text/*";
        }
        a("More", bundle);
        a(n, m);
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ExportOpenEvent(myobfuscated.f.m.a(getActivity().getIntent(), "from"), a, b));
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (getActivity() != null && !getActivity().isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j1 != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        if (intent != null)
        {
            obj = intent.getExtras();
        } else
        {
            obj = null;
        }
        switch (i1)
        {
        default:
            return;

        case 74: // 'J'
            getActivity().runOnUiThread(new Runnable() {

                private a a;

                public final void run()
                {
                    Utils.c(a.getActivity(), a.getString(0x7f0805a7));
                    a.a(a, "dropbox");
                    a.getActivity().finish();
                }

            
            {
                a = a.this;
                super();
            }
            });
            return;

        case 92: // '\\'
            intent = ((Bundle) (obj)).getString("selectedFolderName");
            String s1 = ((Bundle) (obj)).getString("selectedFileName");
            obj = ((Bundle) (obj)).getString("fileExtension");
            Intent intent1 = new Intent();
            intent1.putExtra("selectedFolderName", intent);
            intent1.putExtra("selectedFileName", s1);
            intent1.putExtra("fileExtension", ((String) (obj)));
            intent1.putExtra("dstPath", (new StringBuilder()).append(intent).append("/").append(s1).append(((String) (obj))).toString());
            getActivity().setResult(-1, intent1);
            if (j)
            {
                getActivity().finish();
                return;
            }
            break;

        case 97: // 'a'
            getActivity().runOnUiThread(new Runnable() {

                private a a;

                public final void run()
                {
                    Utils.c(a.getActivity(), a.getString(0x7f0805e9));
                    if (a.j(a))
                    {
                        a.getActivity().finish();
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
            return;

        case 91: // '['
            getActivity().runOnUiThread(new Runnable() {

                private a a;

                public final void run()
                {
                    Utils.a(a.getActivity(), 0x7f080483);
                    if (a.j(a))
                    {
                        a.getActivity().finish();
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
            return;

        case 1001: 
            b(intent.getStringExtra("path"));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (i1 == 1001)
        {
            b(c);
        }
        if (j)
        {
            getActivity().finish();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        l = LayoutInflater.from(getActivity());
        m = new ArrayList();
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030199, viewgroup, false);
        if (getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().getString("gifPath") != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1007ba)).setText(0x7f08086a);
        }
        return layoutinflater;
    }

    public final void onDestroy()
    {
        if (z != null)
        {
            z.cancel(true);
        }
        com.socialin.asyncnet.b.a().a(h);
        v.setRequestCompleteListener(null);
        com.socialin.android.util.c.b(h);
        if (i != null)
        {
            i.c();
        }
        super.onDestroy();
    }

    public final void onResume()
    {
        super.onResume();
        try
        {
            AppEventsLogger.activateApp(getActivity());
            if (!w)
            {
                w = SocialinAdManager.a(com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.EXPORT);
            }
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(h, "onResume", exception);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        D = flag;
    }
}
