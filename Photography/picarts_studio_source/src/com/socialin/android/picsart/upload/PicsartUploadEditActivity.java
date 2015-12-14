// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.utils.c;
import com.picsart.studio.view.EditTextBackEvent;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.request.UpdateItemParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.picsart.profile.util.ab;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import com.socialin.android.util.n;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.android.views.PredicateLayout;
import com.socialin.asyncnet.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import myobfuscated.cx.a;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.upload:
//            a, e, f, d, 
//            UploadItem, b

public class PicsartUploadEditActivity extends BaseActivity
{

    private static final String a = com/socialin/android/picsart/upload/PicsartUploadEditActivity.getSimpleName();
    private g b;
    private String c;
    private SharedPreferences d;
    private a e;
    private boolean f;
    private boolean g;
    private String h;
    private String i;
    private e j;
    private ParamWithItemId k;
    private BaseSocialinApiRequestController l;
    private BaseSocialinApiRequestController m;
    private UpdateItemParams n;
    private ImageItem o;
    private long p;

    public PicsartUploadEditActivity()
    {
        b = null;
        c = null;
        f = false;
        g = false;
        k = new ParamWithItemId();
        l = RequestControllerFactory.createGetItemController();
        m = RequestControllerFactory.createUpdateItemController();
        n = new UpdateItemParams();
        o = null;
    }

    static long a(PicsartUploadEditActivity picsartuploadeditactivity, long l1)
    {
        picsartuploadeditactivity.p = l1;
        return l1;
    }

    static BaseActivity a(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        return picsartuploadeditactivity.self;
    }

    static ImageItem a(PicsartUploadEditActivity picsartuploadeditactivity, ImageItem imageitem)
    {
        picsartuploadeditactivity.o = imageitem;
        return imageitem;
    }

    static String a()
    {
        return a;
    }

    static String a(PicsartUploadEditActivity picsartuploadeditactivity, String s1)
    {
        return picsartuploadeditactivity.a(s1);
    }

    private String a(String s1)
    {
        Object obj2 = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808c0)).append("/").append(getString(0x7f0808f4)).append("/").toString();
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        int i1 = s1.lastIndexOf("?");
        int j1 = s1.lastIndexOf(".");
        String s2;
        String s3;
        if (i1 <= 0)
        {
            i1 = s1.length();
        }
        s2 = s1.substring(j1, i1);
        s3 = (new StringBuilder()).append(p).append("_orig").toString();
        obj = s.b(s1);
        obj1 = obj;
        obj2 = new File(new File(((String) (obj2))), (new StringBuilder()).append(s3).append(s2).toString());
        obj1 = obj;
        FileUtils.a(((File) (obj2)).getAbsolutePath(), ((InputStream) (obj)));
        obj1 = obj;
        if (!w.e(((File) (obj2)).getAbsolutePath())) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        s1 = ((File) (obj2)).getAbsolutePath();
_L10:
        obj1 = obj;
        x.c(((File) (obj2)).getAbsolutePath(), "picsart");
        obj1 = s1;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(a, "fetch: close stream", ((Throwable) (obj)));
                return s1;
            }
            obj1 = s1;
        }
_L6:
        return ((String) (obj1));
        Exception exception;
        exception;
        obj = null;
        s1 = null;
_L9:
        obj1 = obj;
        com.socialin.android.d.b(a, "fetch", exception);
        obj1 = s1;
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((InputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            com.socialin.android.d.b(a, "fetch: close stream", ioexception);
            return s1;
        }
        return s1;
        s1;
        obj1 = null;
_L8:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (IOException ioexception1)
            {
                com.socialin.android.d.b(a, "fetch: close stream", ioexception1);
            }
        }
        throw s1;
        s1;
        if (true) goto _L8; else goto _L7
_L7:
        exception;
        s1 = null;
          goto _L9
        exception;
          goto _L9
_L4:
        s1 = null;
        if (true) goto _L10; else goto _L2
_L2:
        return null;
    }

    private void a(int i1)
    {
        Intent intent = getIntent();
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(self.getPackageName(), "com.socialin.android.picsart.profile.activity.LoginFragmentActivity");
        intent.putExtra("from", com/socialin/android/picsart/upload/PicsartUploadEditActivity.getName());
        intent.setFlags(0x24000000);
        startActivityForResult(intent, i1);
        DialogUtils.dismissDialog(self, b);
    }

    private void a(long l1)
    {
        l.setRequestCompleteListener(new com.socialin.android.picsart.upload.a(this, (byte)0));
        k.itemId = l1;
        l.setRequestParams(k);
        com.socialin.asyncnet.b.a().a(l.getRequestId());
        l.doRequest(a, k);
    }

    static void a(PicsartUploadEditActivity picsartuploadeditactivity, boolean flag)
    {
        picsartuploadeditactivity.a(flag);
    }

    private void a(boolean flag)
    {
        boolean flag1 = false;
        View view = findViewById(0x7f100989);
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = findViewById(0x7f10098a);
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        if (e != null)
        {
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            if (flag)
            {
                fragmenttransaction.show(e);
            } else
            {
                fragmenttransaction.hide(e);
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    static g b(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        return picsartuploadeditactivity.b;
    }

    private void b()
    {
        Utils.b(this, 0x7f08024e);
        setResult(0);
        finish();
    }

    static void b(PicsartUploadEditActivity picsartuploadeditactivity, String s1)
    {
        DialogUtils.dismissDialog(picsartuploadeditactivity, picsartuploadeditactivity.b);
        picsartuploadeditactivity.c = s1;
        if (TextUtils.isEmpty(picsartuploadeditactivity.c))
        {
            picsartuploadeditactivity.b();
            return;
        } else
        {
            picsartuploadeditactivity.j.b(picsartuploadeditactivity.c);
            picsartuploadeditactivity.d();
            return;
        }
    }

    private static boolean b(String s1)
    {
        return w.a(s1, null).c > 0x100000;
    }

    private void c()
    {
        setContentView(0x7f03020e);
        getWindow().setSoftInputMode(3);
        d = getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(getApplicationContext(), "app_name_short"))).toString(), 0);
        j = new e(this);
        Object obj = j;
        obj.o = false;
        if (((e) (obj)).b.getString(0x7f0808c8).equalsIgnoreCase(((e) (obj)).b.getString(0x7f0808cc)))
        {
            ((e) (obj)).b.findViewById(0x7f100988).setVisibility(8);
            ((e) (obj)).b.findViewById(0x7f100989).setVisibility(8);
            ((e) (obj)).b.findViewById(0x7f10098a).setVisibility(8);
        }
        Object obj1 = ((e) (obj)).b.findViewById(0x7f100985);
        obj.g = (TextView)((e) (obj)).b.findViewById(0x7f100986);
        obj.h = (ImageButton)((e) (obj)).b.findViewById(0x7f100987);
        ((View) (obj1)).setOnClickListener(((e) (obj)).d);
        ((e) (obj)).g.setOnClickListener(((e) (obj)).d);
        ((e) (obj)).h.setOnClickListener(((e) (obj)).d);
        obj.i = ((e) (obj)).b.findViewById(0x7f100981);
        obj.f = (CheckBox)((e) (obj)).b.findViewById(0x7f10098f);
        obj.l = (ImageView)((e) (obj)).b.findViewById(0x7f10097c);
        obj.e = (EditTextBackEvent)((e) (obj)).b.findViewById(0x7f100980);
        ((e) (obj)).e.setMaxLines(6);
        ((e) (obj)).e.setLines(6);
        obj.q = new f(((e) (obj)), ((e) (obj)).b);
        ((e) (obj)).e.addTextChangedListener(((e) (obj)).q);
        ((e) (obj)).e.setOnEditTextImeBackListener(new e._cls1(((e) (obj))));
        if (((e) (obj)).r)
        {
            ((e) (obj)).e.postDelayed(new e._cls2(((e) (obj))), 100L);
        }
        ((e) (obj)).a(((e) (obj)).e);
        obj.j = ((e) (obj)).b.findViewById(0x7f100990);
        obj1 = (PredicateLayout)((e) (obj)).b.findViewById(0x7f100996);
        obj.k = (ImageView)((e) (obj)).b.findViewById(0x7f100993);
        ((e) (obj)).k.setOnClickListener(((e) (obj)).d);
        ((e) (obj)).a(((View) (obj1)));
        ((e) (obj)).b.findViewById(0x7f100992).setOnClickListener(((e) (obj)).d);
        Activity activity = ((e) (obj)).b;
        List list = ((e) (obj)).b();
        Object obj2 = ((e) (obj)).e.getText().toString();
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            obj2 = com.socialin.android.picsart.upload.e.a(((String) (obj2)));
            if (!((List) (obj2)).isEmpty())
            {
                list.addAll(((java.util.Collection) (obj2)));
            }
        }
        obj.m = new ab(activity, list, ((PredicateLayout) (obj1)), ((e) (obj)).e);
        ((e) (obj)).m.a = (new char[] {
            '#', '@'
        });
        ((e) (obj)).a('#');
        (new e._cls3(((e) (obj)))).execute(new Void[0]);
        ((e) (obj)).b.findViewById(0x7f100983).setOnClickListener(((e) (obj)).d);
        ((e) (obj)).b.findViewById(0x7f100984).setOnClickListener(((e) (obj)).d);
        ((CheckBox)((e) (obj)).b.findViewById(0x7f10098f)).setChecked(true);
        b = new g(this);
        b.setMessage(getString(0x7f0803d8));
        b.setCancelable(true);
        if (g)
        {
            findViewById(0x7f10098a).setVisibility(8);
            findViewById(0x7f100989).setVisibility(8);
            if (o != null)
            {
                j.a(o);
                j.c(o.getMidleUrl());
                return;
            }
            if (p > 0L)
            {
                a(p);
                return;
            } else
            {
                b();
                return;
            }
        }
        if (!getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            obj = getFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj)).setTransition(8194);
            e = new a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("showFoursquare", false);
            bundle.putBoolean("showWordpress", false);
            bundle.putBoolean("showGooglePlus", false);
            bundle.putBoolean("showTumblr", true);
            bundle.putBoolean("checkColCount", true);
            bundle.putBoolean("showInstagram", true);
            bundle.putBoolean("isTransparentIcons", true);
            e.setArguments(bundle);
            ((FragmentTransaction) (obj)).replace(0x7f10098a, e);
            ((FragmentTransaction) (obj)).commit();
        }
        obj = j.f;
        ((CompoundButton) (obj)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private PicsartUploadEditActivity a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                com.socialin.android.picsart.upload.PicsartUploadEditActivity.a(a, flag);
            }

            
            {
                a = PicsartUploadEditActivity.this;
                super();
            }
        });
        a(((CompoundButton) (obj)).isChecked());
        if (!TextUtils.isEmpty(c))
        {
            j.b(c);
            return;
        }
        if (o != null)
        {
            j.c(o.getMidleUrl());
            return;
        }
        if (p > 0L)
        {
            a(p);
            return;
        } else
        {
            b();
            return;
        }
    }

    static void c(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        if (!SocialinV3.getInstance().isRegistered())
        {
            picsartuploadeditactivity.a(117);
            return;
        }
        if (!FileUtils.a())
        {
            Utils.c(picsartuploadeditactivity.self, picsartuploadeditactivity.getString(0x7f080342));
            return;
        }
        Object obj;
        Object obj1;
        List list;
        Canvas canvas;
        int i1;
        boolean flag;
        try
        {
            JSONObject jsonobject = picsartuploadeditactivity.e();
            Intent intent = new Intent();
            intent.setClassName(picsartuploadeditactivity.getApplicationContext(), "com.picsart.upload.UploadService");
            intent.setAction("picsart.upload.add.to.queue");
            intent.putExtra("extra.message", jsonobject.toString());
            intent.putExtra("uploadFilePath", picsartuploadeditactivity.c);
            intent.putExtra("origin", picsartuploadeditactivity.h);
            picsartuploadeditactivity.startService(intent);
            Utils.c(picsartuploadeditactivity.self, picsartuploadeditactivity.getString(0x7f08047c));
            picsartuploadeditactivity.setResult(-1, new Intent());
            picsartuploadeditactivity.finish();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, "startPicsartUploadService", ((Throwable) (obj)));
            picsartuploadeditactivity.setResult(0);
            picsartuploadeditactivity.finish();
        }
        if (picsartuploadeditactivity.e != null)
        {
            flag = picsartuploadeditactivity.e.a(1).f;
        } else
        {
            flag = false;
        }
        if (picsartuploadeditactivity.j.e() == 0)
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = new Intent("android.intent.action.SEND");
        ((Intent) (obj)).setPackage("com.instagram.android");
        ((Intent) (obj)).setDataAndType(null, "image/*");
        list = picsartuploadeditactivity.getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
        if (!b(picsartuploadeditactivity.c))
        {
            break MISSING_BLOCK_LABEL_566;
        }
        obj = w.f(picsartuploadeditactivity.c);
_L3:
        obj1 = picsartuploadeditactivity.c;
        if (obj != null && ((Bitmap) (obj)).getWidth() != ((Bitmap) (obj)).getHeight())
        {
            i1 = Math.max(((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
            obj1 = Bitmap.createBitmap(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj1)));
            canvas.drawColor(-1);
            canvas.drawBitmap(((Bitmap) (obj)), (i1 - ((Bitmap) (obj)).getWidth()) / 2, (i1 - ((Bitmap) (obj)).getHeight()) / 2, null);
            obj = w.a(picsartuploadeditactivity.c.substring(0, picsartuploadeditactivity.c.lastIndexOf(File.separator)), (new StringBuilder()).append(picsartuploadeditactivity.c.substring(picsartuploadeditactivity.c.lastIndexOf(File.separator) + 1)).append("_insta").toString(), ((Bitmap) (obj1)), picsartuploadeditactivity.getApplicationContext(), android.graphics.Bitmap.CompressFormat.JPEG, false).getAbsolutePath();
        } else
        {
            obj = obj1;
        }
        if (list != null && !list.isEmpty())
        {
            obj1 = new Intent("android.intent.action.SEND");
            ((Intent) (obj1)).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(((String) (obj)))));
            if (TextUtils.isEmpty(picsartuploadeditactivity.j.a))
            {
                obj = "#PicsArt";
            } else
            {
                obj = picsartuploadeditactivity.j.a;
            }
            if (!((String) (obj)).contains("#PicsArt"))
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(" #PicsArt").toString();
            }
            ((Intent) (obj1)).putExtra("android.intent.extra.TEXT", ((String) (obj)));
            ((Intent) (obj1)).setType("image/*");
            ((Intent) (obj1)).setClassName(((ResolveInfo)list.get(0)).activityInfo.packageName, ((ResolveInfo)list.get(0)).activityInfo.name);
            picsartuploadeditactivity.startActivity(((Intent) (obj1)));
        }
_L2:
        picsartuploadeditactivity.j.f();
        picsartuploadeditactivity.j.g();
        return;
        obj;
        obj = BitmapFactory.decodeFile(picsartuploadeditactivity.c);
          goto _L3
    }

    private void d()
    {
        if (!TextUtils.isEmpty(c))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (o != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            b();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = o.getUrl();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            (new an(((String) (obj))) {

                private String a;
                private PicsartUploadEditActivity b;

                protected final Object doInBackground(Object aobj[])
                {
                    DialogUtils.showDialog(b, com.socialin.android.picsart.upload.PicsartUploadEditActivity.b(b));
                    return com.socialin.android.picsart.upload.PicsartUploadEditActivity.a(b, a);
                }

                protected final void onPostExecute(Object obj1)
                {
                    obj1 = (String)obj1;
                    if (!isCancelled() && !b.isFinishing())
                    {
                        com.socialin.android.picsart.upload.PicsartUploadEditActivity.b(b, ((String) (obj1)));
                    }
                }

            
            {
                b = PicsartUploadEditActivity.this;
                a = s1;
                super();
            }
            }).a(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, "doUpload", exception);
        }
        return;
        DialogUtils.dismissDialog(self, b);
        (new Thread() {

            private PicsartUploadEditActivity a;

            public final void run()
            {
                com.socialin.android.picsart.upload.PicsartUploadEditActivity.c(a);
            }

            
            {
                a = PicsartUploadEditActivity.this;
                super();
            }
        }).start();
        return;
    }

    static void d(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        picsartuploadeditactivity.b();
    }

    static e e(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        return picsartuploadeditactivity.j;
    }

    private JSONObject e()
    {
        int k1;
        boolean flag;
        int k2;
        k1 = 0;
        flag = false;
        k2 = j.e();
        if (k2 != 0) goto _L2; else goto _L1
_L1:
        int l1;
        int i2;
        int j2;
        j2 = 0;
        l1 = 0;
        i2 = 0;
_L6:
        int i1;
        int j1;
        j1 = 0;
        k1 = i2;
        i1 = l1;
_L7:
        l1 = j2;
        i2 = i1;
        i1 = j1;
        j1 = i2;
_L14:
        Object obj;
        Object obj3;
        boolean flag1;
        Object obj1;
        int ai[];
        StringBuilder stringbuilder;
        long l2;
        if (((CompoundButton)findViewById(0x7f100517)).isChecked())
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        l2 = System.currentTimeMillis();
        obj3 = new File(new File(new File(Environment.getExternalStorageDirectory(), getString(0x7f0808fb)), getString(0x7f080979)), getString(0x7f08097a));
        stringbuilder = (new StringBuilder()).append(l2).append("_uploadimage");
        obj = c;
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("/"), ((String) (obj)).length());
        if (((String) (obj)).contains("."))
        {
            obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("."), ((String) (obj)).length());
        } else
        {
            obj = "";
        }
        obj1 = obj;
        if (((String) (obj)).trim().length() == 0)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(".png").toString();
        }
        obj1 = new File(((File) (obj3)), stringbuilder.append(((String) (obj1))).toString());
        obj = ((File) (obj1)).getAbsolutePath();
        obj3 = SocialinV3.getInstance().getSettings();
        flag1 = b(c);
        if (!((Settings) (obj3)).isFeatureBandwidthUploadEnabled() || !flag1) goto _L4; else goto _L3
_L3:
        w.a(((File) (obj1)), w.f(c), android.graphics.Bitmap.CompressFormat.JPEG, this);
        j2 = ((flag) ? 1 : 0);
_L9:
        obj3 = new android.graphics.BitmapFactory.Options();
        obj3.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(((File) (obj1)).getAbsolutePath(), ((android.graphics.BitmapFactory.Options) (obj3)));
        ai = new int[2];
        ai[0] = ((android.graphics.BitmapFactory.Options) (obj3)).outWidth;
        ai[1] = ((android.graphics.BitmapFactory.Options) (obj3)).outHeight;
        obj3 = new com.socialin.android.picsart.upload.d();
        obj3.k = j2;
        obj3.a = l1;
        obj3.b = j1;
        obj3.c = k1;
        obj3.d = 0;
        obj3.e = i1;
        obj3.f = 0;
        obj3.g = k2;
        obj3.h = i2;
        obj3.l = ((String) (obj));
        obj3.n = "desc";
        obj3.o = "photo";
        obj3.m = j.a;
        obj3.p = j.d();
        obj3.q = j.c;
        obj3.i = ai[0];
        obj3.j = ai[1];
        obj = com.socialin.android.picsart.upload.UploadItem.a(((com.socialin.android.picsart.upload.d) (obj3)), SocialinApiV3.getInstance().getApiKey(), FacebookUtils.getTokenString(), String.valueOf(l2));
        if (l1 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_613;
        }
        d.edit().putBoolean("enable_fb_action_add", flag1).apply();
        ai = d.edit();
        if (j.c != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ai.putBoolean("showLocation", flag1).apply();
        flag1 = false;
        if (e.a(4) != null)
        {
            flag1 = e.a(4).f;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_613;
        }
        d.edit().putBoolean("enable_gp_action_add", flag1).apply();
        return ((JSONObject) (obj));
_L2:
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_795;
        }
        if (f())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (g())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (h())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        j2 = j1;
        l1 = i1;
        i2 = k1;
        if (!i()) goto _L6; else goto _L5
_L5:
        j2 = j1;
        j1 = 1;
          goto _L7
_L4:
        FileUtils.b(c, ((String) (obj)));
        j2 = ((flag) ? 1 : 0);
        if (!flag1) goto _L9; else goto _L8
_L8:
        flag1 = ((Settings) (obj3)).isuploadOptimizationeEnabled();
        j2 = ((flag) ? 1 : 0);
        if (flag1)
        {
            j2 = 1;
        }
          goto _L9
        Object obj2;
        obj2;
        obj = null;
_L13:
        com.socialin.android.d.b(a, "build upload JSON", ((Throwable) (obj2)));
        return ((JSONObject) (obj));
        obj2;
        obj = null;
_L11:
        ((Exception) (obj2)).printStackTrace();
        return ((JSONObject) (obj));
        obj2;
        if (true) goto _L11; else goto _L10
_L10:
        obj2;
        if (true) goto _L13; else goto _L12
_L12:
        l1 = 0;
        j1 = 0;
        i1 = 0;
          goto _L14
    }

    static ImageItem f(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        return picsartuploadeditactivity.o;
    }

    private boolean f()
    {
        return e.a(0).f;
    }

    private boolean g()
    {
        return e.a(2).f;
    }

    static boolean g(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        return picsartuploadeditactivity.g;
    }

    private boolean h()
    {
        return e.a(5).f;
    }

    private boolean i()
    {
        return e.a(6).f;
    }

    private void j()
    {
        boolean flag = true;
        if (y.c(this))
        {
            boolean flag1 = ((CheckBox)findViewById(0x7f10098f)).isChecked();
            boolean flag2 = ((CheckBox)findViewById(0x7f100517)).isChecked();
            n.itemId = p;
            n.title = j.a;
            n.tags = j.d();
            UpdateItemParams updateitemparams = n;
            int i1;
            if (flag2)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            updateitemparams.isMature = i1;
            if (flag1 && !o.isPublic || !flag1 && o.isPublic)
            {
                Object obj = n;
                if (flag1)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                obj.isPublic = i1;
            }
            n.address = j.c;
            m.setRequestParams(n);
            m.setRequestCompleteListener(new com.socialin.android.picsart.upload.b(this, flag1, flag2));
            com.socialin.asyncnet.b.a().a(m.getRequestId());
            obj = b;
            if (Thread.currentThread() == Looper.getMainLooper().getThread())
            {
                flag = false;
            }
            DialogUtils.showDialog(this, ((android.app.Dialog) (obj)), flag);
            m.doRequest("updateItem", n);
        }
    }

    public boolean isDestroyed()
    {
        return f || isFinishing();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        boolean flag1;
        flag1 = true;
        super.onActivityResult(i1, j1, intent);
        DialogUtils.dismissDialog(self, b);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 4: default 68
    //                   117: 157
    //                   167: 192
    //                   168: 283
    //                   4538: 168;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        boolean flag = false;
_L14:
        if (j1 != 0 && j1 != 1) goto _L9; else goto _L8
_L8:
        if (i1 != 167) goto _L11; else goto _L10
_L10:
        Object obj1 = j;
        Object obj;
        TextView textview;
        if (((e) (obj1)).c == null || TextUtils.isEmpty(((e) (obj1)).c.place))
        {
            obj = "";
        } else
        {
            obj = ((e) (obj1)).c.place;
        }
        ((e) (obj1)).g.setText(((CharSequence) (obj)));
        flag = flag1;
_L9:
        if (!flag && e != null)
        {
            e.onActivityResult(i1, j1, intent);
        }
        return;
_L4:
        if (g)
        {
            j();
        } else
        {
            d();
        }
_L7:
        if (!isFinishing())
        {
            c();
        }
_L12:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        obj1 = j;
        obj1.c = com.picsart.studio.utils.c.a(intent, this);
        if (((e) (obj1)).c != null)
        {
            ((e) (obj1)).c();
            if (((e) (obj1)).c == null || TextUtils.isEmpty(((e) (obj1)).c.place))
            {
                obj = "";
            } else
            {
                obj = ((e) (obj1)).c.place;
            }
            ((e) (obj1)).g.setText(((CharSequence) (obj)));
            ((e) (obj1)).h.setVisibility(0);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj = j;
        obj1 = intent.getExtras().getString("text");
        if (((e) (obj)).c == null)
        {
            obj.c = new Adress();
        }
        ((e) (obj)).c.place = ((String) (obj1));
        textview = ((e) (obj)).g;
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = "";
        }
        textview.setText(((CharSequence) (obj)));
        if (true) goto _L12; else goto _L11
_L11:
        if (i1 == 4538)
        {
            self.setResult(1);
            self.finish();
            flag = flag1;
        }
        if (true) goto _L9; else goto _L2
_L2:
        flag = false;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (j != null)
        {
            j.b.findViewById(0x7f10097d).scrollTo(0, 0);
        }
    }

    public void onCreate(Bundle bundle)
    {
        Intent intent;
        super.onCreate(bundle);
        supportRequestWindowFeature(9);
        f = false;
        intent = getIntent();
        h = intent.getExtras().getString("origin");
        i = intent.getExtras().getString("action");
        g = intent.getBooleanExtra("is_edit_mode", false);
        String s1 = a;
        StringBuilder stringbuilder = new StringBuilder("mode: ");
        if (g)
        {
            bundle = "EDIT !!!";
        } else
        {
            bundle = "UPLOAD !!!";
        }
        com.socialin.android.d.b(s1, new Object[] {
            stringbuilder.append(bundle).toString()
        });
        if (!intent.hasExtra("item")) goto _L2; else goto _L1
_L1:
        o = (ImageItem)intent.getParcelableExtra("item");
        if (o != null)
        {
            p = o.id;
        }
_L9:
        if (!g)
        {
            if (intent.hasExtra("path"))
            {
                c = intent.getStringExtra("path");
            } else
            if (p <= 0L)
            {
                b();
            }
        }
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("itemId: ")).append(p).toString()
        });
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("path: ")).append(c).toString()
        });
        invalidateOptionsMenu();
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            bundle = getSupportActionBar();
            int i1;
            if (g)
            {
                i1 = 0x7f080084;
            } else
            {
                i1 = 0x7f080603;
            }
            bundle.setTitle(getString(i1));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(0x7f0f0010)));
        }
        if (SocialinV3.getInstance().isRegistered()) goto _L4; else goto _L3
_L3:
        if (!TextUtils.isEmpty(i))
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent(h, i));
        }
        a(4538);
_L6:
        return;
_L2:
        if (intent.hasExtra("item_id"))
        {
            p = intent.getLongExtra("item_id", -1L);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (isFinishing()) goto _L6; else goto _L5
_L5:
        c();
        if (!SocialinV3.getInstance().getSettings().isMatureContentEnabled()) goto _L6; else goto _L7
_L7:
        findViewById(0x7f10098c).setVisibility(0);
        findViewById(0x7f100518).setOnClickListener(new android.view.View.OnClickListener() {

            private PicsartUploadEditActivity a;

            public final void onClick(View view)
            {
                DialogUtils.openInfoDialog(0x7f020392, a.getResources().getString(0x7f080417), "", a.getResources().getString(0x7f080418), com.socialin.android.picsart.upload.PicsartUploadEditActivity.a(a), Integer.valueOf(0));
            }

            
            {
                a = PicsartUploadEditActivity.this;
                super();
            }
        });
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuinflater = getMenuInflater();
        int i1;
        if (g)
        {
            i1 = 0x7f110002;
        } else
        {
            i1 = 0x7f110013;
        }
        menuinflater.inflate(i1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (g || d == null || e == null) goto _L2; else goto _L1
_L1:
        android.content.SharedPreferences.Editor editor;
        boolean flag = f();
        boolean flag1 = g();
        boolean flag2 = h();
        boolean flag3 = i();
        editor = d.edit();
        editor.putBoolean("postToFacebook", flag);
        editor.putBoolean("postToDropbox", flag2);
        editor.putBoolean("postToTwitter", flag1);
        editor.putBoolean("postToDeviantart", flag3);
        if (!getIntent().hasExtra("accessToken")) goto _L4; else goto _L3
_L3:
        String s1 = getIntent().getStringExtra("accessToken");
_L5:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        editor.putBoolean((new StringBuilder("postToFacebook_")).append(s1).toString(), true);
        editor.apply();
_L2:
        f = true;
        return;
_L4:
        s1 = null;
          goto _L5
        Exception exception;
        exception;
        com.socialin.android.d.b(a, "onDestroy", exception);
          goto _L2
    }

    public void onInstagramTokenResult()
    {
        e.a(true);
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (j != null)
            {
                e e1 = j;
                boolean flag;
                if (e1.o)
                {
                    e1.a();
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return false;
                }
            }
            if (getFragmentManager().getBackStackEntryCount() == 0)
            {
                setResult(1);
                finish();
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            setResult(1);
            finish();
        } else
        {
            if (menuitem.getItemId() == 0x7f100af6)
            {
                d();
                return true;
            }
            if (menuitem.getItemId() == 0x7f100ae4)
            {
                j();
                return true;
            }
        }
        return true;
    }

}
