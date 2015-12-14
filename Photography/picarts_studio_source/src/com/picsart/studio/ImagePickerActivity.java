// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.b;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.multiselect.FoldersActivity;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.a;
import com.socialin.android.util.aa;
import com.socialin.android.util.ae;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio:
//            f, e

public class ImagePickerActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = com/picsart/studio/ImagePickerActivity.getSimpleName();
    private String b;
    private String c;
    private ImageItem d;
    private File e;
    private g f;
    private List g;
    private ArrayList h;
    private RecyclerView i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private a o;
    private boolean p;
    private volatile boolean q;

    public ImagePickerActivity()
    {
        e = null;
        f = null;
        h = null;
        k = true;
        l = true;
        m = false;
        n = -1;
        o = null;
    }

    static int a(ImagePickerActivity imagepickeractivity, int i1)
    {
        imagepickeractivity.j = i1;
        return i1;
    }

    private ActivityInfo a(Intent intent, String s1)
    {
label0:
        {
            intent = getPackageManager().queryIntentActivities(intent, 0);
            if (intent == null)
            {
                break label0;
            }
            intent = intent.iterator();
            ActivityInfo activityinfo;
            do
            {
                if (!intent.hasNext())
                {
                    break label0;
                }
                activityinfo = ((ResolveInfo)intent.next()).activityInfo;
            } while (activityinfo == null || activityinfo.packageName == null || !activityinfo.packageName.contains(s1) || activityinfo.name == null);
            return activityinfo;
        }
        return null;
    }

    static String a()
    {
        return a;
    }

    static ArrayList a(String s1, String as[], ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        if (as != null)
        {
            int i1 = 0;
            for (int j1 = as.length; i1 < j1; i1++)
            {
                String s2 = as[i1];
                if (arraylist != null)
                {
                    arraylist.get(i1);
                }
                arraylist1.add(x.b(s1, myobfuscated.f.m.c(s2)));
            }

        }
        return arraylist1;
    }

    static List a(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.g;
    }

    static void a(ImagePickerActivity imagepickeractivity, String s1, int i1, int j1, HashMap hashmap, String s2, String s3)
    {
        imagepickeractivity.a(s1, i1, j1, hashmap, s2, s3);
    }

    static void a(ImagePickerActivity imagepickeractivity, String s1, ImageItem imageitem, String s2, String s3)
    {
        imagepickeractivity.a(s1, 0, 3, ((HashMap) (null)), imageitem, s2, s3);
    }

    static void a(ImagePickerActivity imagepickeractivity, String as[], int ai[], ArrayList arraylist)
    {
        Intent intent = new Intent();
        if (as != null)
        {
            intent.putExtra("selectedItems", as);
        }
        if (ai != null)
        {
            intent.putExtra("selectedItemsDegrees", ai);
        }
        if (arraylist != null)
        {
            intent.putStringArrayListExtra("selectedItemsSources", arraylist);
        }
        imagepickeractivity.setResult(-1, intent);
        imagepickeractivity.finish();
    }

    private void a(String s1, int i1, int j1, HashMap hashmap, ImageItem imageitem, String s2, String s3)
    {
        a(s1, 0, 3, null, imageitem, s2, s3, null);
    }

    private void a(String s1, int i1, int j1, HashMap hashmap, ImageItem imageitem, String s2, String s3, 
            String s4)
    {
        String s5;
        if (hashmap == null && s1 != null && !w.e(s1))
        {
            runOnUiThread(new Runnable() {

                private ImagePickerActivity a;

                public final void run()
                {
                    Toast.makeText(a, 0x7f08023f, 1).show();
                }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
            });
            setResult(0);
            finish();
            return;
        }
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.PhotoChooseEvent(s3));
        s4 = s2;
        s5 = s3;
        if (TextUtils.isEmpty(s2)) goto _L2; else goto _L1
_L1:
        s4 = new JSONObject(s2);
        if (!s4.has("from")) goto _L4; else goto _L3
_L3:
        s5 = s4.getString("from");
        s4 = s2;
_L2:
        s2 = new Intent();
        s2.putExtra("path", s1);
        s2.putExtra("bufferData", hashmap);
        s2.putExtra("degree", i1);
        s2.putExtra("type", j1);
        s2.putExtra("origin", s5);
        if (s4 != null)
        {
            s2.putExtra("source", s4);
        }
        if (imageitem != null)
        {
            s2.putExtra("item", imageitem);
        }
        setResult(-1, s2);
        finish();
        return;
_L4:
        s4.put("from", s3);
        s4 = s4.toString();
        s5 = s3;
        continue; /* Loop/switch isn't completed */
        s4;
        s4.printStackTrace();
        s4 = s2;
        s5 = s3;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(String s1, int i1, int j1, HashMap hashmap, String s2, String s3)
    {
        a(s1, i1, j1, hashmap, null, s2, s3, null);
    }

    private void b()
    {
        Object obj = new Intent("android.intent.action.GET_CONTENT", null);
        ((Intent) (obj)).setType("image/*");
        obj = a(((Intent) (obj)), "gallery3d");
        if (obj != null)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setClassName(((ActivityInfo) (obj)).packageName, ((ActivityInfo) (obj)).name);
            startActivityForResult(intent, 1);
            return;
        } else
        {
            c();
            return;
        }
    }

    static void b(ImagePickerActivity imagepickeractivity)
    {
        imagepickeractivity.d();
    }

    private void c()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    static void c(ImagePickerActivity imagepickeractivity)
    {
        imagepickeractivity.b();
    }

    private void d()
    {
        findViewById(0x7f10052d).setVisibility(8);
        x x1 = x.a();
        File afile[] = (new File(x.d())).listFiles();
        Object obj;
        if (afile != null)
        {
            Arrays.sort(afile, x.a);
            LinkedList linkedlist = new LinkedList();
            int j1 = afile.length;
            int i1 = 0;
            do
            {
                obj = linkedlist;
                if (i1 >= j1)
                {
                    break;
                }
                File file = afile[i1];
                if (file.isDirectory())
                {
                    obj = file.listFiles(new com.socialin.android.util.x._cls2());
                    if (obj != null && obj.length != 0)
                    {
                        obj = obj[0].getPath();
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null && (new File(((String) (obj)))).canRead())
                    {
                        linkedlist.add(obj);
                    } else
                    if (obj == null)
                    {
                        obj = x1.a(file);
                        if (obj != null && (new File(((String) (obj)))).canRead())
                        {
                            linkedlist.add(obj);
                        }
                    } else
                    {
                        file.delete();
                    }
                }
                i1++;
            } while (true);
        } else
        {
            obj = Collections.emptyList();
        }
        g = ((List) (obj));
        h = new ArrayList();
        if (g.size() == 0)
        {
            findViewById(0x7f10052b).setVisibility(8);
            findViewById(0x7f100354).setVisibility(4);
            return;
        } else
        {
            findViewById(0x7f10052b).setVisibility(0);
            findViewById(0x7f100354).setVisibility(0);
            f f1 = new f(this);
            i.setAdapter(f1);
            return;
        }
    }

    static void d(ImagePickerActivity imagepickeractivity)
    {
        Intent intent = new Intent(imagepickeractivity, com/socialin/android/multiselect/FoldersActivity);
        if (imagepickeractivity.n != 0)
        {
            intent.putExtra("itemsCount", imagepickeractivity.n);
        }
        imagepickeractivity.startActivityForResult(intent, 4);
    }

    static boolean e(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.q;
    }

    static g f(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.f;
    }

    static boolean g(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.p;
    }

    static boolean h(ImagePickerActivity imagepickeractivity)
    {
        imagepickeractivity.q = false;
        return false;
    }

    static String i(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.b;
    }

    static ImageItem j(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.d;
    }

    static String k(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.c;
    }

    static ArrayList l(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.h;
    }

    static int m(ImagePickerActivity imagepickeractivity)
    {
        return imagepickeractivity.j;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        boolean flag;
        flag = true;
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 21: default 196
    //                   1: 197
    //                   2: 490
    //                   4: 252
    //                   5: 712
    //                   1221: 880
    //                   1222: 880
    //                   1223: 880
    //                   1224: 880
    //                   1225: 880
    //                   1235: 880
    //                   1236: 880
    //                   1238: 785
    //                   1334: 275
    //                   1335: 275
    //                   1336: 275
    //                   1337: 275
    //                   1338: 275
    //                   1339: 275
    //                   1340: 718
    //                   1341: 880
    //                   1342: 275;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L8 _L9 _L9 _L9 _L9 _L9 _L9 _L10 _L7 _L9
_L2:
        return;
_L3:
        AnalyticUtils.getInstance(this).trackLocalAction("first:imgFromGallery");
        q = true;
        (new Handler()).postDelayed(new Runnable() {

            private ImagePickerActivity a;

            public final void run()
            {
                if (ImagePickerActivity.e(a))
                {
                    boolean flag1;
                    if (Looper.getMainLooper().getThread() != Thread.currentThread())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    myobfuscated.f.m.a(a, ImagePickerActivity.f(a), flag1);
                }
            }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
        }, 500L);
        (new ModernAsyncTask(intent) {

            final ImagePickerActivity a;
            private Intent b;

            private transient Void a()
            {
                Object obj1;
                obj1 = w.a(a, b);
                if (obj1 == null || !((String) (obj1)).startsWith("http"))
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                Object obj2;
                obj2 = s.b(((String) (obj1)));
                if (!com.picsart.studio.ImagePickerActivity.g(a))
                {
                    break MISSING_BLOCK_LABEL_73;
                }
                x.a();
                obj2 = x.a(((java.io.InputStream) (obj2)));
                String s5;
                ae ae1;
                if (obj2 != null)
                {
                    try
                    {
                        a.runOnUiThread(new Runnable(this, ((String) (obj2)), ((String) (obj1))) {

                            private String a;
                            private String b;
                            private _cls7 c;

                            public final void run()
                            {
                                myobfuscated.f.m.b(c.a, ImagePickerActivity.f(c.a));
                                ImagePickerActivity.h(c.a);
                                com.picsart.studio.ImagePickerActivity.a(c.a, a, 0, 3, null, x.a("Remote album", b), "Remote album");
                            }

            
            {
                c = _pcls7;
                a = s1;
                b = s2;
                super();
            }
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        com.socialin.android.d.b(com.picsart.studio.ImagePickerActivity.a(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
                        });
                    }
                }
                break MISSING_BLOCK_LABEL_335;
                s5 = (new StringBuilder()).append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f08096a)).toString();
                ae1 = b.a;
                obj1 = FileUtils.a(s5, ae.a(((String) (obj1))), ((java.io.InputStream) (obj2)));
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_335;
                }
                obj1 = ((File) (obj1)).getPath();
                if (w.e(((String) (obj1))))
                {
                    a.runOnUiThread(new Runnable(this, ((String) (obj1))) {

                        private String a;
                        private _cls7 b;

                        public final void run()
                        {
                            myobfuscated.f.m.b(b.a, ImagePickerActivity.f(b.a));
                            ImagePickerActivity.h(b.a);
                            com.picsart.studio.ImagePickerActivity.a(b.a, a, 0, 3, null, x.c("Remote album"), "Remote album");
                        }

            
            {
                b = _pcls7;
                a = s1;
                super();
            }
                    });
                }
                break MISSING_BLOCK_LABEL_335;
                if (w.e(((String) (obj1))))
                {
                    if (com.picsart.studio.ImagePickerActivity.g(a))
                    {
                        int k1 = w.a(a, b, ((String) (obj1)));
                        x.a();
                        String s4 = x.a(((String) (obj1)), true);
                        a.runOnUiThread(new Runnable(this, s4, k1, ((String) (obj1))) {

                            private String a;
                            private int b;
                            private String c;
                            private _cls7 d;

                            public final void run()
                            {
                                myobfuscated.f.m.b(d.a, ImagePickerActivity.f(d.a));
                                ImagePickerActivity.h(d.a);
                                com.picsart.studio.ImagePickerActivity.a(d.a, a, b, 2, null, x.a("gallery", c), "gallery");
                            }

            
            {
                d = _pcls7;
                a = s1;
                b = i1;
                c = s2;
                super();
            }
                        });
                    } else
                    {
                        int l1 = w.a(a, b, ((String) (obj1)));
                        a.runOnUiThread(new Runnable(this, ((String) (obj1)), l1) {

                            private String a;
                            private int b;
                            private _cls7 c;

                            public final void run()
                            {
                                myobfuscated.f.m.b(c.a, ImagePickerActivity.f(c.a));
                                ImagePickerActivity.h(c.a);
                                com.picsart.studio.ImagePickerActivity.a(c.a, a, b, 2, null, x.a("gallery", a), "gallery");
                            }

            
            {
                c = _pcls7;
                a = s1;
                b = i1;
                super();
            }
                        });
                    }
                } else
                {
                    myobfuscated.f.m.b(a, ImagePickerActivity.f(a));
                    ImagePickerActivity.h(a);
                    a.runOnUiThread(new Runnable(this) {

                        private _cls7 a;

                        public final void run()
                        {
                            Toast.makeText(a.a, 0x7f08039c, 0).show();
                        }

            
            {
                a = _pcls7;
                super();
            }
                    });
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            
            {
                a = ImagePickerActivity.this;
                b = intent;
                super();
            }
        }).execute(new Void[0]);
        return;
_L5:
        AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_multy_gallery");
        (new Thread(intent) {

            private Intent a;
            private ImagePickerActivity b;

            public final void run()
            {
                ArrayList arraylist = null;
                int ai[];
                String as[];
                if (a != null && a.hasExtra("selectedItems"))
                {
                    as = a.getStringArrayExtra("selectedItems");
                    ai = a.getIntArrayExtra("selectedItemsDegrees");
                    arraylist = a.getStringArrayListExtra("extra.orig.urls");
                    if (d.b)
                    {
                        for (int k1 = 0; k1 < as.length; k1++)
                        {
                            (new StringBuilder("selected pic ")).append(k1).append(" -- ").append(as[k1]);
                            (new StringBuilder("selected pic degree")).append(k1).append(" -- ").append(ai[k1]);
                        }

                    }
                } else
                {
                    ai = null;
                    as = null;
                }
                com.picsart.studio.ImagePickerActivity.a(b, as, ai, com.picsart.studio.ImagePickerActivity.a("gallery", as, arraylist));
            }

            
            {
                b = ImagePickerActivity.this;
                a = intent;
                super();
            }
        }).start();
        return;
_L9:
        String s1;
        if (i1 == 1334)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_flickr_multy");
            s1 = "flickr";
        } else
        if (i1 == 1335)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_google_multy");
            s1 = "google";
        } else
        if (i1 == 1336)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_picasa_multy");
            s1 = "picasa";
        } else
        if (i1 == 1337)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_picsart_multy");
            s1 = "picsart";
        } else
        if (i1 == 1338)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_facebook_multy");
            s1 = "facebook";
        } else
        if (i1 == 1339)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_dropbox_multy");
            s1 = "dropbox";
        } else
        {
            AnalyticUtils.getInstance(this).trackLocalAction("first:image_from_instagram_multy");
            s1 = "instagram";
        }
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageMultiEvent(s1, "home"));
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.PhotoChooseEvent(s1));
        (new Thread(intent, s1) {

            private Intent a;
            private String b;
            private ImagePickerActivity c;

            public final void run()
            {
                ArrayList arraylist = null;
                boolean flag1 = false;
                int ai[];
                String as[];
                if (a != null && a.hasExtra("selectedItems"))
                {
                    as = a.getStringArrayExtra("selectedItems");
                    arraylist = a.getStringArrayListExtra("extra.orig.urls");
                    ai = new int[as.length];
                    for (int k1 = 0; k1 < ai.length; k1++)
                    {
                        ai[k1] = 0;
                    }

                    if (d.b)
                    {
                        for (int l1 = ((flag1) ? 1 : 0); l1 < as.length; l1++)
                        {
                            (new StringBuilder("selected pic ")).append(l1).append(" -- ").append(as[l1]);
                        }

                    }
                } else
                {
                    ai = null;
                    as = null;
                }
                com.picsart.studio.ImagePickerActivity.a(c, as, ai, com.picsart.studio.ImagePickerActivity.a(b, as, arraylist));
            }

            
            {
                c = ImagePickerActivity.this;
                a = intent;
                b = s1;
                super();
            }
        }).start();
        return;
_L4:
        AnalyticUtils.getInstance(this).trackLocalAction("first:imgFromCam");
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageMultiEvent("imgFromCam", "home"));
        if (e == null)
        {
            a a1 = o;
            e = new File(a1.a.getSharedPreferences(a1.b, 0).getString("cameraTmpImagePath", null));
        }
        String s3 = w.a(this, intent, e);
        Object obj;
        String s2;
        if (intent != null && intent.hasExtra("degree"))
        {
            i1 = intent.getIntExtra("degree", 0);
        } else
        if (s3 != null)
        {
            i1 = w.a(this, Uri.parse((new File(s3)).toString()), s3);
        } else
        {
            i1 = 0;
        }
        s2 = "{'from':'camera'}";
        obj = s2;
        if (intent != null)
        {
            obj = s2;
            if (intent.hasExtra("imageSource"))
            {
                obj = intent.getStringExtra("imageSource");
            }
        }
        if (p)
        {
            x.a();
            a(x.a(s3, false), i1, 1, null, ((String) (obj)), "camera");
            return;
        } else
        {
            a(s3, i1, 1, null, ((String) (obj)), "camera");
            return;
        }
_L6:
        myobfuscated.cv.c.a(this, intent);
        return;
_L10:
        b = intent.getExtras().getString("path");
        c = "google";
        if (intent.hasExtra("item"))
        {
            intent = (ImageItem)intent.getExtras().getParcelable("item");
        } else
        {
            intent = null;
        }
        d = intent;
        (new Thread() {

            private ImagePickerActivity a;

            public final void run()
            {
label0:
                {
                    if (ImagePickerActivity.i(a) != null)
                    {
                        com.picsart.studio.ImagePickerActivity.a(a, ImagePickerActivity.i(a), ImagePickerActivity.j(a), null, null);
                        if (!com.picsart.studio.ImagePickerActivity.g(a))
                        {
                            break label0;
                        }
                        x.a();
                        String s4 = ImagePickerActivity.i(a);
                        ImagePickerActivity.k(a);
                        s4 = x.a(s4, true);
                        com.picsart.studio.ImagePickerActivity.a(a, s4, 0, 2, null, x.a("Google Drive", ImagePickerActivity.i(a)), "Google Drive");
                    }
                    return;
                }
                com.picsart.studio.ImagePickerActivity.a(a, ImagePickerActivity.i(a), 0, 2, null, x.c("Google Drive"), "Google Drive");
            }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
        }).start();
        return;
_L8:
        b = intent.getExtras().getString("path");
        if (w.e(b))
        {
            if (p)
            {
                x.a();
                a(x.a(b, true), 0, 2, null, x.a("Dropbox", b), "Dropbox");
            } else
            {
                a(b, 0, 2, null, x.c("dropbox"), "dropbox");
            }
        }
        myobfuscated.f.m.b(this, f);
        return;
_L7:
        if (intent == null) goto _L2; else goto _L11
_L11:
        i1;
        JVM INSTR lookupswitch 8: default 960
    //                   1221: 1096
    //                   1222: 1096
    //                   1223: 1111
    //                   1224: 1127
    //                   1225: 1061
    //                   1235: 1143
    //                   1236: 1159
    //                   1341: 1080;
           goto _L12 _L13 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L12:
        c = "unknown";
        obj = "unknown";
_L20:
        b = intent.getExtras().getString("path");
        if (intent.hasExtra("item"))
        {
            intent = (ImageItem)intent.getExtras().getParcelable("item");
        } else
        {
            intent = null;
        }
        d = intent;
        if (!flag)
        {
            intent = new JSONObject();
            try
            {
                intent.put("from", c);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((JSONException) (obj)).printStackTrace();
            }
            a(((String) (null)), 0, 3, ((HashMap) (null)), d, intent.toString(), c);
            return;
        } else
        {
            (new Handler()).postDelayed(new Runnable() {

                private ImagePickerActivity a;

                public final void run()
                {
                    myobfuscated.f.m.a(a, ImagePickerActivity.f(a), true);
                }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
            }, 500L);
            (new Thread(((String) (obj))) {

                private String a;
                private ImagePickerActivity b;

                public final void run()
                {
                    Object obj1;
                    obj1 = s.b(ImagePickerActivity.i(b));
                    if (!com.picsart.studio.ImagePickerActivity.g(b))
                    {
                        break MISSING_BLOCK_LABEL_110;
                    }
                    x.a();
                    ImagePickerActivity.k(b);
                    ImagePickerActivity.i(b);
                    obj1 = x.a(((java.io.InputStream) (obj1)));
                    Object obj2;
                    Object obj3;
                    String s5;
                    if (obj1 != null)
                    {
                        try
                        {
                            ImagePickerActivity imagepickeractivity = b;
                            ImageItem imageitem = ImagePickerActivity.j(b);
                            String s4 = ImagePickerActivity.k(b);
                            ImagePickerActivity.i(b);
                            com.picsart.studio.ImagePickerActivity.a(imagepickeractivity, ((String) (obj1)), imageitem, x.c(s4), a);
                            myobfuscated.f.m.b(b, ImagePickerActivity.f(b));
                            return;
                        }
                        catch (IOException ioexception)
                        {
                            com.socialin.android.d.b(com.picsart.studio.ImagePickerActivity.a(), new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                            });
                        }
                    }
                    break MISSING_BLOCK_LABEL_274;
                    obj2 = (new StringBuilder()).append(b.getString(0x7f0808fb)).append("/").append(b.getString(0x7f08096a)).toString();
                    obj3 = b.a;
                    obj1 = FileUtils.a(((String) (obj2)), ae.a(ImagePickerActivity.i(b)), ((java.io.InputStream) (obj1)));
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_274;
                    }
                    obj1 = ((File) (obj1)).getPath();
                    obj2 = b;
                    obj3 = ImagePickerActivity.j(b);
                    s5 = ImagePickerActivity.k(b);
                    ImagePickerActivity.i(b);
                    com.picsart.studio.ImagePickerActivity.a(((ImagePickerActivity) (obj2)), ((String) (obj1)), ((ImageItem) (obj3)), x.a(s5, ((String) (obj1))), a);
                    myobfuscated.f.m.b(b, ImagePickerActivity.f(b));
                    return;
                }

            
            {
                b = ImagePickerActivity.this;
                a = s1;
                super();
            }
            }).start();
            return;
        }
_L16:
        c = "facebook";
        obj = intent.getStringExtra("source_tab");
          goto _L20
_L19:
        c = "instagram";
        obj = c;
          goto _L20
_L13:
        c = "flickr";
        obj = "flicker_public";
          goto _L20
_L14:
        c = "picasa";
        obj = c;
          goto _L20
_L15:
        c = "picasa";
        obj = c;
          goto _L20
_L17:
        c = "google";
        obj = c;
          goto _L20
_L18:
        flag = getIntent().getBooleanExtra("getPath", true);
        c = "picsart";
        obj = intent.getStringExtra("source_tab");
          goto _L20
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131756321: 
        case 2131756326: 
        default:
            return;

        case 2131756319: 
            if (m)
            {
                (new Runnable() {

                    private ImagePickerActivity a;

                    public final void run()
                    {
                        com.picsart.studio.ImagePickerActivity.d(a);
                    }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
                }).run();
                return;
            } else
            {
                b();
                return;
            }

        case 2131756320: 
            view = new Intent("android.media.action.IMAGE_CAPTURE");
            view.putExtra("return-data", true);
            e = new File(x.a(this), String.valueOf(System.currentTimeMillis()));
            Object obj = o;
            String s1 = e.getPath();
            obj = ((a) (obj)).a.getSharedPreferences(((a) (obj)).b, 0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("cameraTmpImagePath", s1);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            view.putExtra("output", Uri.fromFile(e));
            view.putExtra("showCameraEffects", l);
            startActivityForResult(view, 2);
            return;

        case 2131756323: 
            if (!s.a(this))
            {
                myobfuscated.cv.c.a(this);
            } else
            {
                view = getIntent();
                view.putExtra("fbAppId", getString(0x7f0808e2));
                view.putExtra("fbToken", SocialinV3.getInstance().getUserFbToken());
                view.putExtra("method", "main");
                view.putExtra("multipleCheckMode", m);
                view.putExtra("multipleCheckPhotoCount", n);
                view.putExtra("savedUserId", SocialinV3.getInstance().getUserFbId());
                FacebookUtils.openPhotoChooser(this, com.facebook.CallbackManager.Factory.create());
            }
            AnalyticUtils.getInstance(this).trackLocalAction("first:fb");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("facebook", "home"));
            return;

        case 2131756324: 
            myobfuscated.cv.c.e(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:flickr");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("flickr", "home"));
            return;

        case 2131756327: 
            myobfuscated.cv.c.b(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:picasa");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("picasa", "home"));
            return;

        case 2131756328: 
            myobfuscated.cv.c.d(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:google");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("google", "home"));
            return;

        case 2131756329: 
            myobfuscated.cv.c.a(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:dropbox");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("dropbox", "home"));
            return;

        case 2131756330: 
            c();
            AnalyticUtils.getInstance(this).trackLocalAction("first:moreLayout");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("moreApps", "home"));
            return;

        case 2131756322: 
            myobfuscated.cv.c.f(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:picsartGallery");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("picsartGallery", "home"));
            return;

        case 2131756325: 
            myobfuscated.cv.c.c(this, m, n);
            AnalyticUtils.getInstance(this).trackLocalAction("first:instagram");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ChooseImageEvent("instagram", "home"));
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        byte byte0 = 8;
        super.onCreate(bundle);
        j = (int)Utils.a(70F, this);
        o = new a(this);
        Object obj = getIntent().getExtras();
        bundle = getString(0x7f0808c8);
        if (obj != null && ((Bundle) (obj)).containsKey("showPicsart"))
        {
            k = ((Bundle) (obj)).getBoolean("showPicsart", true);
        }
        if (obj != null && ((Bundle) (obj)).containsKey("showCameraEffects"))
        {
            l = ((Bundle) (obj)).getBoolean("showCameraEffects", true);
        }
        if (obj != null && ((Bundle) (obj)).containsKey("multipleCheckMode"))
        {
            m = ((Bundle) (obj)).getBoolean("multipleCheckMode", false);
            n = ((Bundle) (obj)).getInt("itemsCount");
        }
        if (obj != null)
        {
            p = ((Bundle) (obj)).getBoolean("extra.for.main.activity", false);
        }
        setContentView(0x7f0300fe);
        myobfuscated.f.m.a(this).setText(0x7f0805fd);
        AnalyticUtils.getInstance(this).trackLocalAction("first:onCreate");
        f = new g(this);
        f.setMessage(getString(0x7f0803d8));
        findViewById(0x7f10051f).setOnClickListener(this);
        findViewById(0x7f100520).setOnClickListener(this);
        findViewById(0x7f100524).setOnClickListener(this);
        findViewById(0x7f100522).setOnClickListener(this);
        findViewById(0x7f100529).setOnClickListener(this);
        obj = findViewById(0x7f100522);
        int i1;
        if (k)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
        if (bundle.equals(getString(0x7f0808cc)))
        {
            bundle = findViewById(0x7f100523);
            View view = findViewById(0x7f10052a);
            ViewGroup viewgroup = (ViewGroup)bundle.getParent();
            viewgroup.removeView(bundle);
            ((ViewGroup)view.getParent()).removeView(view);
            viewgroup.addView(view);
            bundle = findViewById(0x7f100525);
            view = findViewById(0x7f100529);
            viewgroup = (ViewGroup)bundle.getParent();
            viewgroup.removeView(bundle);
            ((ViewGroup)view.getParent()).removeView(view);
            viewgroup.addView(view);
            findViewById(0x7f100527).setVisibility(8);
            findViewById(0x7f100528).setVisibility(8);
            if (!k)
            {
                i1 = (int)Utils.a(5F, getApplicationContext());
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f100529).getLayoutParams()).leftMargin = i1;
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f100524).getLayoutParams()).leftMargin = i1;
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f10052a).getLayoutParams()).leftMargin = i1;
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f100529).getLayoutParams()).rightMargin = i1;
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f100524).getLayoutParams()).rightMargin = i1;
                ((android.widget.LinearLayout.LayoutParams)findViewById(0x7f10052a).getLayoutParams()).rightMargin = i1;
            }
        } else
        {
            findViewById(0x7f100523).setOnClickListener(this);
            findViewById(0x7f100527).setOnClickListener(this);
            findViewById(0x7f100528).setOnClickListener(this);
            findViewById(0x7f100525).setOnClickListener(this);
        }
        findViewById(0x7f10052a).setOnClickListener(this);
        w.a(this);
        bundle = findViewById(0x7f100520);
        i1 = byte0;
        if (aa.a(this))
        {
            i1 = 0;
        }
        bundle.setVisibility(i1);
        i = (RecyclerView)findViewById(0x7f10052e);
        bundle = new LinearLayoutManager(this, 0, false);
        i.setLayoutManager(bundle);
        if (getResources().getConfiguration().orientation == 1)
        {
            i1 = (int)Utils.a(140F, this);
        } else
        {
            i1 = (int)Utils.a(210F, this);
        }
        i.addItemDecoration(new e((int)getResources().getDimension(0x7f0b0103), i1));
        d();
        findViewById(0x7f100354).setOnClickListener(new android.view.View.OnClickListener() {

            private ImagePickerActivity a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.ImagePickerActivity.a(a).size() != 1 || com.picsart.studio.ImagePickerActivity.a(a).size() == 1 && !((String)com.picsart.studio.ImagePickerActivity.a(a).get(0)).contains("current"))
                {
                    x.a();
                    x.b();
                    com.picsart.studio.ImagePickerActivity.b(a);
                }
                AnalyticUtils.getInstance(a).trackLocalAction("first:clearRecents");
            }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
        });
        bundle = (com.socialin.android.dialog.a)getFragmentManager().findFragmentByTag("dialog.select.type");
        if (bundle != null)
        {
            bundle.a(new com.socialin.android.dialog.c() {

                final ImagePickerActivity a;

                public final void onViewCreated(View view1, DialogFragment dialogfragment)
                {
                    view1.findViewById(0x7f10037e).setOnClickListener(new android.view.View.OnClickListener(this) {

                        private _cls4 a;

                        public final void onClick(View view)
                        {
                            com.picsart.studio.ImagePickerActivity.c(a.a);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    view1.findViewById(0x7f10037d).setOnClickListener(new android.view.View.OnClickListener(this) {

                        private _cls4 a;

                        public final void onClick(View view)
                        {
                            com.picsart.studio.ImagePickerActivity.d(a.a);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                }

            
            {
                a = ImagePickerActivity.this;
                super();
            }
            });
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

}
