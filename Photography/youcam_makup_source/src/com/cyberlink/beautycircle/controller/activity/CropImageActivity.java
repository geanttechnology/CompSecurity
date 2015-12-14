// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.r;
import com.edmodo.cropper.CropImageView;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.e;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Locale;

public class CropImageActivity extends BaseActivity
{

    private d e;
    private CropImageView f;
    private TextView g;
    private ArrayList h;
    private Bitmap i;
    private com.cyberlink.beautycircle.Globals.CropSettings j;
    private int k;
    private PointF l;
    private int m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;

    public CropImageActivity()
    {
        e = (new e()).a(android.graphics.Bitmap.Config.ARGB_8888).b(false).c(false).d(true).a();
        g = null;
        l = new PointF();
        m = 0;
        n = new android.view.View.OnClickListener() {

            final CropImageActivity a;

            public void onClick(View view)
            {
                CropImageActivity.a(a, CropImageActivity.a(a));
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final CropImageActivity a;

            public void onClick(View view)
            {
                CropImageActivity.a(a, CropImageActivity.b(a));
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        };
    }

    static int a(CropImageActivity cropimageactivity)
    {
        int i1 = cropimageactivity.m - 1;
        cropimageactivity.m = i1;
        return i1;
    }

    static Bitmap a(CropImageActivity cropimageactivity, Bitmap bitmap)
    {
        cropimageactivity.i = bitmap;
        return bitmap;
    }

    static PointF a(CropImageActivity cropimageactivity, PointF pointf)
    {
        cropimageactivity.l = pointf;
        return pointf;
    }

    private void a(int i1, Bitmap bitmap)
    {
        Intent intent = new Intent();
        if (bitmap != null)
        {
            bitmap = NetworkFile.a(bitmap, j.compressSetting);
            if (bitmap != null)
            {
                intent.putExtra("CroppedImageFile", ((h) (bitmap)).g);
                intent.putExtra("CroppedImageMetadata", ((h) (bitmap)).f.toString());
            }
        }
        intent.putExtra("SelectedPhotoIndex", m);
        setResult(i1, intent);
        super.e();
    }

    private void a(long l1)
    {
        NetworkUser.a(l1, AccountManager.c(), AccountManager.b()).a(new com.perfectcorp.utility.m() {

            final CropImageActivity a;

            protected void a()
            {
                a.l();
                Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
            }

            protected void a(int i1)
            {
                a.l();
                if (i1 == 401 || i1 == 420)
                {
                    CropImageActivity.a(a, 48258, null);
                    return;
                } else
                {
                    Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
                    return;
                }
            }

            protected void a(UserInfo userinfo)
            {
                String s;
                UserInfo userinfo1;
                s = AccountManager.b();
                userinfo1 = AccountManager.d();
                if (userinfo == null)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.d(a) != 48135)
                {
                    break MISSING_BLOCK_LABEL_70;
                }
                userinfo1.avatarUrl = userinfo.avatarUrl;
                r.a(userinfo.avatarUrl, com.cyberlink.beautycircle.controller.activity.CropImageActivity.e(a));
_L1:
                AccountManager.a(s, userinfo1, false);
                CropImageActivity.a(a, -1, null);
                a.l();
                return;
                userinfo1.coverUrl = userinfo.coverUrl;
                r.a(userinfo.coverUrl, com.cyberlink.beautycircle.controller.activity.CropImageActivity.e(a));
                  goto _L1
                userinfo;
                userinfo.printStackTrace();
                Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
                a.l();
                return;
                userinfo;
                a.l();
                throw userinfo;
            }

            protected void b(Object obj)
            {
                a((UserInfo)obj);
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        });
    }

    static void a(CropImageActivity cropimageactivity, int i1)
    {
        cropimageactivity.c(i1);
    }

    static void a(CropImageActivity cropimageactivity, int i1, Bitmap bitmap)
    {
        cropimageactivity.a(i1, bitmap);
    }

    static void a(CropImageActivity cropimageactivity, long l1)
    {
        cropimageactivity.a(l1);
    }

    static void a(CropImageActivity cropimageactivity, h h1)
    {
        cropimageactivity.a(h1);
    }

    static void a(CropImageActivity cropimageactivity, String s)
    {
        cropimageactivity.f(s);
    }

    private void a(h h1)
    {
        String s = AccountManager.b();
        if (h1.e == null || h1.d == null)
        {
            Globals.a(getResources().getString(m.bc_change_photo_upload_avatar_fail));
            return;
        } else
        {
            k();
            NetworkFile.a(s, j.fileType, h1.e, h1.c, h1.f.toString(), h1.a).a(new com.perfectcorp.utility.m() {

                final CropImageActivity a;

                protected void a(int i1)
                {
                    a.l();
                    if (i1 == 401 || i1 == 420)
                    {
                        CropImageActivity.a(a, 48258, null);
                        return;
                    } else
                    {
                        Globals.a(a.getResources().getString(m.bc_change_photo_upload_avatar_fail));
                        return;
                    }
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                {
                    if (uploadfileresult == null || uploadfileresult.fileId == null)
                    {
                        b(0x80000001);
                    } else
                    {
                        if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.d(a) == 48135)
                        {
                            CropImageActivity.a(a, uploadfileresult.fileId, null);
                            return;
                        }
                        if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.d(a) == 48132)
                        {
                            CropImageActivity.a(a, null, uploadfileresult.fileId);
                            return;
                        }
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj);
                }

            
            {
                a = CropImageActivity.this;
                super();
            }
            });
            return;
        }
    }

    static boolean a(CropImageActivity cropimageactivity, Long long1, Long long2)
    {
        return cropimageactivity.a(long1, long2);
    }

    private boolean a(Long long1, Long long2)
    {
        NetworkUser.a(AccountManager.b(), null, long1, long2, null, null, null, null, null, null, null, null, null, null).a(new com.perfectcorp.utility.m() {

            final CropImageActivity a;

            protected void a()
            {
                a.l();
                Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
            }

            protected void a(int i1)
            {
                a.l();
                if (i1 == 401 || i1 == 420)
                {
                    CropImageActivity.a(a, 48258, null);
                    return;
                } else
                {
                    Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
                    return;
                }
            }

            protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
            {
                try
                {
                    CropImageActivity.a(a, updateuserresponse.userId);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    updateuserresponse.printStackTrace();
                }
                a.l();
                Globals.a(a.getResources().getString(m.bc_change_photo_update_user_info));
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        });
        return true;
    }

    static int b(CropImageActivity cropimageactivity)
    {
        int i1 = cropimageactivity.m + 1;
        cropimageactivity.m = i1;
        return i1;
    }

    static CropImageView c(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.f;
    }

    private void c(int i1)
    {
        m = m % h.size();
        if (m < 0)
        {
            m = m + h.size();
        }
        g.setText((new StringBuilder()).append(m + 1).append(" / ").append(h.size()).toString());
        k();
        (new AsyncTask() {

            final CropImageActivity a;

            protected transient Bitmap a(Void avoid[])
            {
                String s = com.perfectcorp.utility.h.a(a.getBaseContext(), (Uri)com.cyberlink.beautycircle.controller.activity.CropImageActivity.h(a).get(CropImageActivity.g(a)));
                Object obj = null;
                avoid = obj;
                if (s != null)
                {
                    avoid = obj;
                    if (!s.isEmpty())
                    {
                        avoid = (new StringBuilder()).append("file://").append(s).toString();
                        Bitmap bitmap = com.nostra13.universalimageloader.core.f.b().a(avoid, CropImageActivity.i(a));
                        avoid = bitmap;
                        if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).faceDetection)
                        {
                            avoid = bitmap;
                            if (bitmap != null)
                            {
                                CropImageActivity.a(a, r.a(bitmap));
                                avoid = bitmap;
                            }
                        }
                    }
                }
                return avoid;
            }

            protected void a(Bitmap bitmap)
            {
                a.l();
                if (bitmap != null) goto _L2; else goto _L1
_L1:
                CropImageActivity.a(a, a.getResources().getString(m.bc_crop_no_bitmap));
_L4:
                if (bitmap != null && bitmap.isRecycled())
                {
                    bitmap.recycle();
                    System.gc();
                }
                return;
_L2:
                if (bitmap.getWidth() < 160 || bitmap.getHeight() < 160)
                {
                    String s = a.getResources().getString(m.bc_crop_size_limit);
                    s = String.format(Locale.getDefault(), s, new Object[] {
                        Integer.valueOf(160)
                    });
                    CropImageActivity.a(a, s);
                } else
                {
                    CropImageActivity.c(a).a(bitmap, 0);
                    CropImageActivity.c(a).a(com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).aspectRatio.x, com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).aspectRatio.y);
                    CropImageActivity.c(a).setCircleBackground(com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).useCircle);
                    CropImageActivity.c(a).setFixedAspectRatio(true);
                    if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).faceDetection)
                    {
                        CropImageActivity.c(a).setEyeMidPoint(com.cyberlink.beautycircle.controller.activity.CropImageActivity.j(a));
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Bitmap)obj);
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    static int d(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.k;
    }

    static Bitmap e(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.i;
    }

    static com.cyberlink.beautycircle.Globals.CropSettings f(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.j;
    }

    private void f(String s)
    {
        (new LinearLayout(this)).setOrientation(1);
        (new android.widget.LinearLayout.LayoutParams(-1, -2)).setMargins(60, 0, 60, 0);
        DialogUtils.a(this, null, s, null, null, getResources().getString(m.bc_dialog_button_ok), new Runnable() {

            final CropImageActivity a;

            public void run()
            {
                com.cyberlink.beautycircle.controller.activity.CropImageActivity.k(a);
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        });
    }

    static int g(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.m;
    }

    static ArrayList h(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.h;
    }

    static d i(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.e;
    }

    static PointF j(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.l;
    }

    static boolean k(CropImageActivity cropimageactivity)
    {
        return cropimageactivity.BaseActivity.e();
    }

    protected boolean e()
    {
        a(48259, ((Bitmap) (null)));
        return true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2 || configuration.orientation == 1)
        {
            f.a(j.aspectRatio.x, j.aspectRatio.y);
            f.setFixedAspectRatio(true);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        setContentView(k.bc_activity_crop_image);
        bundle = getIntent();
        h = bundle.getParcelableArrayListExtra("PhotoUriList");
        j = (com.cyberlink.beautycircle.Globals.CropSettings)Model.a(com/cyberlink/beautycircle/Globals$CropSettings, bundle.getStringExtra("CropSettings"));
        if (j == null || j.aspectRatio == null || j.compressSetting == null || j.fileType == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "CropSettings: ", j
            });
            DialogUtils.a(this, m.bc_dialog_title_warning, m.bc_crop_create_bitmap_failed, new Runnable() {

                final CropImageActivity a;

                public void run()
                {
                    a.e();
                }

            
            {
                a = CropImageActivity.this;
                super();
            }
            });
            return;
        }
        k = bundle.getIntExtra("RequestCode", 48147);
        f = (CropImageView)findViewById(com.cyberlink.beautycircle.j.bc_crop_image_view);
        if (j.fileType.toString().equals(com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Avatar.toString()))
        {
            b(m.bc_change_photo_title_avatar);
        } else
        {
            b(m.bc_change_photo_title);
        }
        b().a(0xe4000000, x.a, x.d, 0);
        if (h == null || h.isEmpty())
        {
            super.e();
            return;
        }
        bundle = findViewById(com.cyberlink.beautycircle.j.bc_photo_selector);
        int i1;
        if (h.size() > 1)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        bundle.setVisibility(i1);
        bundle = findViewById(com.cyberlink.beautycircle.j.bc_photo_selector_up_padding);
        if (h.size() > 1)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        bundle.setVisibility(i1);
        findViewById(com.cyberlink.beautycircle.j.bc_photo_selector_prev_btn).setOnClickListener(n);
        findViewById(com.cyberlink.beautycircle.j.bc_photo_selector_next_btn).setOnClickListener(o);
        g = (TextView)findViewById(com.cyberlink.beautycircle.j.bc_photo_selector_count);
        c(1);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (i != null && !i.isRecycled())
        {
            i.recycle();
            System.gc();
        }
    }

    public void onRightBtnClick(View view)
    {
        (new AsyncTask() {

            final CropImageActivity a;

            protected transient Void a(Void avoid[])
            {
                CropImageActivity.a(a, CropImageActivity.c(a).getCroppedImage());
                if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.d(a) == 48135 || com.cyberlink.beautycircle.controller.activity.CropImageActivity.d(a) == 48132)
                {
                    avoid = NetworkFile.a(com.cyberlink.beautycircle.controller.activity.CropImageActivity.e(a), com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).compressSetting);
                    CropImageActivity.a(a, avoid);
                } else
                {
                    CropImageActivity.a(a, -1, com.cyberlink.beautycircle.controller.activity.CropImageActivity.e(a));
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = CropImageActivity.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }
}
