// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.UpdateAvatarController;
import com.socialin.android.apiv3.controllers.UpdateUserCoverController;
import com.socialin.android.apiv3.request.ParamWithImage;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import myobfuscated.cv.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            o, n

public class UserAvatarUploadActivity extends BaseActivity
{

    private static final String a = com/socialin/android/picsart/profile/activity/UserAvatarUploadActivity.getSimpleName();
    private String b;
    private UpdateAvatarController c;
    private UpdateUserCoverController d;
    private com.socialin.asyncnet.d e;
    private com.socialin.asyncnet.d f;
    private ParamWithImage g;
    private g h;
    private String i;
    private File j;
    private String k;
    private int l;
    private int m;
    private Bitmap n;
    private Bitmap o;
    private boolean p;

    public UserAvatarUploadActivity()
    {
        b = null;
        c = new UpdateAvatarController();
        d = new UpdateUserCoverController();
        e = new o(this, (byte)0);
        f = new n(this, (byte)0);
        g = new ParamWithImage();
        i = "jpeg";
        k = "profile_image";
        l = -1;
        m = -1;
        p = true;
    }

    static BaseActivity a(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.self;
    }

    static String a(UserAvatarUploadActivity useravataruploadactivity, String s1)
    {
        useravataruploadactivity.b = s1;
        return s1;
    }

    private void a()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    static void a(UserAvatarUploadActivity useravataruploadactivity, Intent intent)
    {
        if (intent == null)
        {
            intent = useravataruploadactivity.getIntent();
        }
        useravataruploadactivity.setResult(-1, intent);
        useravataruploadactivity.finish();
    }

    static void a(UserAvatarUploadActivity useravataruploadactivity, String s1, int i1, Intent intent)
    {
        Intent intent1;
        intent1 = new Intent();
        intent1.addCategory("android.intent.category.DEFAULT");
        intent1.setClassName(useravataruploadactivity.getPackageName(), "com.picsart.studio.editor.activity.StandaloneCropToolActivity");
        if (TextUtils.isEmpty(useravataruploadactivity.i)) goto _L2; else goto _L1
_L1:
        android.graphics.Bitmap.CompressFormat compressformat;
        compressformat = android.graphics.Bitmap.CompressFormat.JPEG;
        useravataruploadactivity.i = useravataruploadactivity.i.toUpperCase();
        if (!"JPG".equals(useravataruploadactivity.i) && !"GIF".equals(useravataruploadactivity.i)) goto _L4; else goto _L3
_L3:
        useravataruploadactivity.i = "JPEG";
        compressformat = android.graphics.Bitmap.CompressFormat.JPEG;
_L6:
        intent1.putExtra("outputFormat", compressformat);
_L2:
        if (intent != null && intent.hasExtra("bufferData"))
        {
            intent1.putExtra("bufferData", intent.getSerializableExtra("bufferData"));
        }
        intent1.putExtra("imagePath", s1);
        intent1.putExtra("noFaceDetection", false);
        intent1.putExtra("degree", i1);
        intent1.putExtra("scale", true);
        intent1.putExtra("maxPixel", PicsartContext.a());
        if (useravataruploadactivity.l > 0)
        {
            intent1.putExtra("outputX", useravataruploadactivity.l);
        }
        if (useravataruploadactivity.m > 0)
        {
            intent1.putExtra("outputY", useravataruploadactivity.m);
        }
        intent1.putExtra("aspectRatio", 1.0F);
        useravataruploadactivity.startActivityForResult(intent1, 2);
        return;
_L4:
        if ("PNG".equals(useravataruploadactivity.i))
        {
            compressformat = android.graphics.Bitmap.CompressFormat.PNG;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(String s1)
    {
        g.imagePath = s1;
        d.setRequestParams(g);
        d.setRequestCompleteListener(e);
        d.doRequest("updateUserCover", g);
    }

    private void a(String s1, Map map)
    {
        if (s1 == null) goto _L2; else goto _L1
_L1:
        myobfuscated.f.m.a(this, h);
        if (!"profile_image".equals(k)) goto _L4; else goto _L3
_L3:
        if (s.a(this)) goto _L6; else goto _L5
_L5:
        y.a(this);
_L2:
        return;
_L6:
        if (map != null)
        {
            try
            {
                o = w.a((HashMap)map, 0, 0, 0);
                (new an() {

                    private UserAvatarUploadActivity a;

                    protected final Object doInBackground(Object aobj[])
                    {
                        return a.a(UserAvatarUploadActivity.f(a));
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (String)obj;
                        com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.d(a, ((String) (obj)));
                    }

            
            {
                a = UserAvatarUploadActivity.this;
                super();
            }
                }).a(new Void[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.socialin.android.d.a(a, s1);
            }
            return;
        } else
        {
            b(s1);
            return;
        }
_L4:
        if (k.equals("cover_image"))
        {
            if (!s.a(this))
            {
                y.a(this);
                return;
            }
            if (map != null)
            {
                try
                {
                    n = w.a((HashMap)map, 0, 0, 0);
                    (new an() {

                        private UserAvatarUploadActivity a;

                        protected final Object doInBackground(Object aobj[])
                        {
                            return a.a(UserAvatarUploadActivity.e(a));
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (String)obj;
                            com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.c(a, ((String) (obj)));
                        }

            
            {
                a = UserAvatarUploadActivity.this;
                super();
            }
                    }).a(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.socialin.android.d.c(new Object[] {
                        a, (new StringBuilder("updateCover: ")).append(s1).toString()
                    });
                }
                return;
            } else
            {
                a(s1);
                return;
            }
        }
        if (k.equals("temp_image"))
        {
            Intent intent = getIntent();
            intent.putExtra("path", s1);
            intent.putExtra("bufferData", (HashMap)map);
            setResult(-1, intent);
            finish();
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    static String b(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.b;
    }

    static String b(UserAvatarUploadActivity useravataruploadactivity, String s1)
    {
        useravataruploadactivity.i = s1;
        return s1;
    }

    private void b(String s1)
    {
        g.imagePath = s1;
        c.setRequestParams(g);
        c.setRequestCompleteListener(f);
        c.doRequest("updateAvatar", g);
    }

    static File c(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.j;
    }

    static void c(UserAvatarUploadActivity useravataruploadactivity, String s1)
    {
        useravataruploadactivity.a(s1);
    }

    static g d(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.h;
    }

    static void d(UserAvatarUploadActivity useravataruploadactivity, String s1)
    {
        useravataruploadactivity.b(s1);
    }

    static Bitmap e(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.n;
    }

    static void e(UserAvatarUploadActivity useravataruploadactivity, String s1)
    {
        String s2 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s2 = useravataruploadactivity.getString(0x7f08024e);
        }
        Utils.c(useravataruploadactivity, s2);
        useravataruploadactivity.finish();
    }

    static Bitmap f(UserAvatarUploadActivity useravataruploadactivity)
    {
        return useravataruploadactivity.o;
    }

    public final String a(Bitmap bitmap)
    {
        if (bitmap != null && w.a(this))
        {
            String s1 = UUID.randomUUID().toString();
            String s2 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096d)).toString();
            (new File(s2)).mkdirs();
            w.a(new File(s2, s1), bitmap, android.graphics.Bitmap.CompressFormat.JPEG, this);
            return (new StringBuilder()).append(s2).append("/").append(s1).toString();
        } else
        {
            return null;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        boolean flag1;
        flag1 = false;
        super.onActivityResult(i1, j1, intent);
        myobfuscated.f.m.b(this, h);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 1 4: default 56
    //                   1 57
    //                   2 70
    //                   3 143
    //                   4 156;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        return;
_L4:
        (new Thread(intent) {

            private Intent a;
            private UserAvatarUploadActivity b;

            public final void run()
            {
                UserAvatarUploadActivity.a(b, w.a(UserAvatarUploadActivity.a(b), a));
                if (UserAvatarUploadActivity.b(b).contains("."))
                {
                    UserAvatarUploadActivity.b(b, UserAvatarUploadActivity.b(b).substring(UserAvatarUploadActivity.b(b).lastIndexOf(".") + 1, UserAvatarUploadActivity.b(b).length()));
                }
                int l1;
                if (a == null)
                {
                    l1 = myobfuscated.f.m.d(UserAvatarUploadActivity.b(b));
                } else
                {
                    l1 = w.a(b, a, UserAvatarUploadActivity.b(b));
                }
                UserAvatarUploadActivity.a(b, UserAvatarUploadActivity.b(b), l1, a);
            }

            
            {
                b = UserAvatarUploadActivity.this;
                a = intent;
                super();
            }
        }).start();
        return;
_L5:
        Object obj = intent.getExtras();
        if (((Bundle) (obj)).getString("path") != null)
        {
            obj = ((Bundle) (obj)).getString("path");
        } else
        {
            obj = b;
        }
        if (intent != null && intent.hasExtra("bufferData"))
        {
            a(((String) (obj)), (HashMap)intent.getSerializableExtra("bufferData"));
            return;
        } else
        {
            a(((String) (obj)), ((Map) (null)));
            return;
        }
_L6:
        (new Thread(intent) {

            private Intent a;
            private UserAvatarUploadActivity b;

            public final void run()
            {
                UserAvatarUploadActivity.a(b, w.a(b, a, com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.c(b)));
                if (TextUtils.isEmpty(UserAvatarUploadActivity.b(b)))
                {
                    myobfuscated.f.m.b(b, com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.d(b));
                    b.finish();
                    return;
                }
                int l1;
                if (a == null)
                {
                    l1 = myobfuscated.f.m.d(UserAvatarUploadActivity.b(b));
                } else
                {
                    l1 = w.a(b, a, UserAvatarUploadActivity.b(b));
                }
                UserAvatarUploadActivity.a(b, UserAvatarUploadActivity.b(b), l1, a);
            }

            
            {
                b = UserAvatarUploadActivity.this;
                a = intent;
                super();
            }
        }).start();
        return;
_L7:
        (new Thread(intent) {

            private Intent a;
            private UserAvatarUploadActivity b;

            public final void run()
            {
                UserAvatarUploadActivity.a(b, a.getExtras().getString("path"));
                int l1 = a.getExtras().getInt("degree");
                UserAvatarUploadActivity.a(b, UserAvatarUploadActivity.b(b), l1, a);
            }

            
            {
                b = UserAvatarUploadActivity.this;
                a = intent;
                super();
            }
        }).start();
        return;
_L2:
        int k1;
        if (j1 != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        k1 = 0;
_L13:
        boolean flag = flag1;
        if (k1 >= 4) goto _L9; else goto _L8
_L8:
        if (i1 != (new int[] {
            2, 1, 3, 4
        })[k1]) goto _L11; else goto _L10
_L10:
        flag = true;
_L9:
        if (flag)
        {
            myobfuscated.f.m.b(this, h);
            finish();
            return;
        }
        break; /* Loop/switch isn't completed */
_L11:
        k1++;
        if (true) goto _L13; else goto _L12
_L12:
        if (j1 != 111) goto _L3; else goto _L14
_L14:
        Utils.b(this, 0x7f08023f);
        a();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        String s1;
        super.onCreate(bundle);
        h = new g(this);
        h.setMessage(getString(0x7f08043d));
        h.setCancelable(true);
        h.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private UserAvatarUploadActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
                a.setResult(0);
                a.finish();
            }

            
            {
                a = UserAvatarUploadActivity.this;
                super();
            }
        });
        p = SocialinV3.getInstance().isRegistered();
        if (getIntent().hasExtra("imgaeType"))
        {
            s1 = getIntent().getStringExtra("imgaeType");
        } else
        {
            s1 = "profile_image";
        }
        k = s1;
        l = getIntent().getIntExtra("imageWIdth", -1);
        m = getIntent().getIntExtra("imageHeight", -1);
        if (getIntent().hasExtra("getImgFrom"))
        {
            s1 = getIntent().getStringExtra("getImgFrom");
        } else
        {
            s1 = null;
        }
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        if (!TextUtils.isEmpty(s1) && !s1.equals("gallery")) goto _L2; else goto _L1
_L1:
        a();
_L4:
        return;
_L2:
        if (s1.equals("camera"))
        {
            w.a(getResources().getString(0x7f08096a), this);
            j = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getResources().getString(0x7f0808fb)).append("/").append(getResources().getString(0x7f08096a)).toString(), String.valueOf(System.currentTimeMillis()));
            bundle = new Intent("android.media.action.IMAGE_CAPTURE");
            bundle.putExtra("return-data", true);
            bundle.putExtra("output", Uri.fromFile(j));
            startActivityForResult(bundle, 3);
            return;
        }
        if (!s1.equals("image_chooser")) goto _L4; else goto _L3
_L3:
        bundle = new Intent();
        bundle.setClassName(getPackageName(), "com.picsart.studio.ImagePickerActivity");
        bundle.putExtra("showCameraEffects", true);
        bundle.putExtra("showPicsart", p);
        bundle.putExtra("extra.for.main.activity", false);
        myobfuscated.cv.c.a(bundle, this);
        startActivityForResult(bundle, 4);
        return;
        b = bundle.getString("path");
        return;
    }

    protected void onDestroy()
    {
        try
        {
            c.setRequestCompleteListener(null);
            d.setRequestCompleteListener(null);
            if (n != null)
            {
                com.socialin.android.util.c.a(n);
                n = null;
            }
            if (o != null)
            {
                com.socialin.android.util.c.a(o);
                o = null;
            }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(a, exception);
        }
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("path", b);
    }

}
