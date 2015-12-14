// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.SubPost;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class AutoPostActivity extends BaseActivity
{

    private u A;
    private TextView e;
    private TextView f;
    private Button g;
    private Button h;
    private ImageView i;
    private TextView j;
    private View k;
    private UICImageView l;
    private View m;
    private View n;
    private boolean o;
    private CirclePager p;
    private String q;
    private ArrayList r;
    private int s;
    private int t;
    private boolean u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private ObjectAnimator y;
    private g z;

    public AutoPostActivity()
    {
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = false;
        p = null;
        q = (new StringBuilder()).append(com.perfectcorp.utility.e.a()).append("AutoPost").toString();
        s = 0;
        t = 0;
        u = false;
        v = new android.view.View.OnClickListener() {

            final AutoPostActivity a;

            public void onClick(View view)
            {
                if (AccountManager.b() == null)
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_must_sign_in), null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            AutoPostActivity.a(a.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
                if (AutoPostActivity.b(a).getSelectedCircles().isEmpty())
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_need_circle), null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.AutoPostActivity.c(a.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                } else
                {
                    AutoPostActivity.d(a).setVisibility(8);
                    com.cyberlink.beautycircle.controller.activity.AutoPostActivity.e(a).setVisibility(0);
                    AutoPostActivity.a(a, false, false);
                    AutoPostActivity.f(a);
                    return;
                }
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final AutoPostActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.AutoPostActivity.g(a);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final AutoPostActivity a;

            public void onClick(View view)
            {
                view = a;
                boolean flag;
                if (!AutoPostActivity.r(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                AutoPostActivity.a(view, flag, true);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        };
        y = null;
        z = new g() {

            final AutoPostActivity a;

            public void a()
            {
                com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
            }

            public void a(int i1)
            {
                if (i1 == 32769)
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_must_sign_in), null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.AutoPostActivity.s(a.a);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                } else
                {
                    String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    DialogUtils.a(a, null, s1, null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.AutoPostActivity.t(a.a);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                }
            }

            public void a(TreeSet treeset)
            {
                if (treeset == null || treeset.isEmpty())
                {
                    return;
                } else
                {
                    AutoPostActivity.a(a, (CircleBasic)treeset.first());
                    AutoPostActivity.a(a, false, true);
                    return;
                }
            }

            public void b()
            {
                a.k();
            }

            public void c()
            {
                a.l();
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        };
        A = new u() {

            final AutoPostActivity a;

            public void a()
            {
                AutoPostActivity.a(a, false, false);
                CircleList.a(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls3 a;

                    protected void a(Void void1)
                    {
                        AutoPostActivity.b(a.a).a();
                    }

                    protected void b(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        };
    }

    static int a(AutoPostActivity autopostactivity, int i1)
    {
        autopostactivity.t = i1;
        return i1;
    }

    static CompletePost a(AutoPostActivity autopostactivity, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        return autopostactivity.b(postattachmentfile);
    }

    static ArrayList a(AutoPostActivity autopostactivity, ArrayList arraylist)
    {
        autopostactivity.r = arraylist;
        return arraylist;
    }

    private void a(int i1, int j1)
    {
        String s1 = getResources().getString(m.bc_developer_progress_title, new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1)
        });
        f.post(new Runnable(s1) {

            final String a;
            final AutoPostActivity b;

            public void run()
            {
                AutoPostActivity.p(b).setText(a);
            }

            
            {
                b = AutoPostActivity.this;
                a = s1;
                super();
            }
        });
    }

    private void a(Bitmap bitmap)
    {
        i.post(new Runnable(bitmap) {

            final Bitmap a;
            final AutoPostActivity b;

            public void run()
            {
                AutoPostActivity.q(b).setImageBitmap(a);
            }

            
            {
                b = AutoPostActivity.this;
                a = bitmap;
                super();
            }
        });
    }

    static void a(AutoPostActivity autopostactivity, int i1, int j1)
    {
        autopostactivity.a(i1, j1);
    }

    static void a(AutoPostActivity autopostactivity, Bitmap bitmap)
    {
        autopostactivity.a(bitmap);
    }

    static void a(AutoPostActivity autopostactivity, CircleBasic circlebasic)
    {
        autopostactivity.a(circlebasic);
    }

    static void a(AutoPostActivity autopostactivity, boolean flag, boolean flag1)
    {
        autopostactivity.a(flag, flag1);
    }

    private void a(CircleBasic circlebasic)
    {
        j.setText(circlebasic.circleName);
        CircleList.a(l, circlebasic);
    }

    private void a(boolean flag, boolean flag1)
    {
        byte byte1 = 4;
        if (o == flag)
        {
            return;
        }
        byte byte0 = 8;
        float f1 = 0.0F;
        if (flag)
        {
            f1 = -90F;
            byte0 = 0;
        }
        p.setVisibility(byte0);
        if (y != null)
        {
            y.cancel();
            y = null;
        }
        if (flag1)
        {
            y = ObjectAnimator.ofFloat(m, "rotation", new float[] {
                f1
            });
            y.setDuration(300L);
            y.start();
        } else
        {
            m.setRotation(f1);
        }
        if (j != null)
        {
            Object obj = j;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            ((TextView) (obj)).setVisibility(byte0);
        }
        if (k != null)
        {
            obj = k;
            if (flag)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            ((View) (obj)).setVisibility(byte0);
        }
        o = flag;
    }

    static boolean a(AutoPostActivity autopostactivity)
    {
        return autopostactivity.BaseActivity.e();
    }

    static boolean a(AutoPostActivity autopostactivity, boolean flag)
    {
        autopostactivity.u = flag;
        return flag;
    }

    private CompletePost b(com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        Object obj = a(postattachmentfile);
        postattachmentfile = new Post();
        postattachmentfile.postId = null;
        postattachmentfile.title = (new StringBuilder()).append("[Developer] ").append((new Date()).toString()).toString();
        postattachmentfile.content = ((SubPost) (obj)).content;
        postattachmentfile.attachments = ((SubPost) (obj)).attachments;
        postattachmentfile.circleIds = new ArrayList();
        CircleBasic circlebasic;
        for (Iterator iterator = p.getSelectedCircles().iterator(); iterator.hasNext(); ((Post) (postattachmentfile)).circleIds.add(circlebasic.id))
        {
            circlebasic = (CircleBasic)iterator.next();
        }

        postattachmentfile.tags = ((SubPost) (obj)).tags;
        obj = new CompletePost();
        obj.mainPost = postattachmentfile;
        obj.subPosts = new ArrayList();
        return ((CompletePost) (obj));
    }

    static CirclePager b(AutoPostActivity autopostactivity)
    {
        return autopostactivity.p;
    }

    static boolean c(AutoPostActivity autopostactivity)
    {
        return autopostactivity.BaseActivity.e();
    }

    static Button d(AutoPostActivity autopostactivity)
    {
        return autopostactivity.g;
    }

    static Button e(AutoPostActivity autopostactivity)
    {
        return autopostactivity.h;
    }

    static void f(AutoPostActivity autopostactivity)
    {
        autopostactivity.p();
    }

    static void g(AutoPostActivity autopostactivity)
    {
        autopostactivity.o();
    }

    static int h(AutoPostActivity autopostactivity)
    {
        return autopostactivity.s;
    }

    static void i(AutoPostActivity autopostactivity)
    {
        autopostactivity.q();
    }

    static ArrayList j(AutoPostActivity autopostactivity)
    {
        return autopostactivity.r;
    }

    static String k(AutoPostActivity autopostactivity)
    {
        return autopostactivity.q;
    }

    static boolean l(AutoPostActivity autopostactivity)
    {
        return autopostactivity.u;
    }

    static int m(AutoPostActivity autopostactivity)
    {
        return autopostactivity.t;
    }

    static int n(AutoPostActivity autopostactivity)
    {
        int i1 = autopostactivity.s;
        autopostactivity.s = i1 + 1;
        return i1;
    }

    static int o(AutoPostActivity autopostactivity)
    {
        int i1 = autopostactivity.s;
        autopostactivity.s = i1 - 1;
        return i1;
    }

    private void o()
    {
        g.setVisibility(0);
        g.setEnabled(false);
        h.setVisibility(8);
        u = true;
    }

    static TextView p(AutoPostActivity autopostactivity)
    {
        return autopostactivity.f;
    }

    private void p()
    {
        (new j() {

            final AutoPostActivity a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected ArrayList a(Void void1)
            {
                if (com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a) != null) goto _L2; else goto _L1
_L1:
                AutoPostActivity.a(a, new ArrayList());
                File file;
                String s1;
                int i1;
                int j1;
                try
                {
                    void1 = (new File(com.cyberlink.beautycircle.controller.activity.AutoPostActivity.k(a))).listFiles();
                    j1 = void1.length;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    break; /* Loop/switch isn't completed */
                }
                i1 = 0;
_L3:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                file = void1[i1];
                s1 = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
                if (s1 == null)
                {
                    break MISSING_BLOCK_LABEL_142;
                }
                s1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s1.toLowerCase(Locale.US));
                if (s1.equals("image/jpeg") || s1.equals("image/png"))
                {
                    com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).add(Uri.parse((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString()));
                }
                i1++;
                continue; /* Loop/switch isn't completed */
                if (true) goto _L3; else goto _L2
_L2:
                return com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final AutoPostActivity a;

            protected void a(ArrayList arraylist)
            {
                int i1;
                if (arraylist != null)
                {
                    i1 = arraylist.size();
                } else
                {
                    i1 = 0;
                }
                AutoPostActivity.a(a, com.cyberlink.beautycircle.controller.activity.AutoPostActivity.h(a), i1);
                Globals.b("Query file finished, stat to auto post.");
                AutoPostActivity.i(a);
            }

            protected void b(Object obj)
            {
                a((ArrayList)obj);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        });
    }

    static ImageView q(AutoPostActivity autopostactivity)
    {
        return autopostactivity.i;
    }

    private void q()
    {
        (new j() {

            final AutoPostActivity a;

            protected Boolean a(Void void1)
            {
                int i1;
                int j1;
                boolean flag;
                j1 = com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).size();
                i1 = com.cyberlink.beautycircle.controller.activity.AutoPostActivity.m(a);
                flag = false;
_L3:
                if (i1 < com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).size() && !AutoPostActivity.l(a)) goto _L2; else goto _L1
_L1:
                return Boolean.valueOf(flag);
_L2:
                AutoPostActivity.a(a, i1);
                AutoPostActivity.n(a);
                AutoPostActivity.a(a, com.cyberlink.beautycircle.controller.activity.AutoPostActivity.h(a), j1);
                void1 = (Uri)com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).get(i1);
                if (void1 == null)
                {
                    Globals.b("Photo url is null");
                } else
                {
label0:
                    {
                        void1 = ImageUtils.a(Globals.n(), void1);
                        if (void1 != null && void1.getWidth() >= 160 && void1.getHeight() >= 160)
                        {
                            break label0;
                        }
                        Globals.b("The bitmap is invalid");
                    }
                }
_L4:
                i1++;
                  goto _L3
label1:
                {
                    AutoPostActivity.a(a, void1);
                    if (!AutoPostActivity.l(a))
                    {
                        break label1;
                    }
                    AutoPostActivity.o(a);
                }
                  goto _L1
                Object obj;
label2:
                {
                    obj = NetworkFile.a(void1, com.perfectcorp.utility.ImageUtils.CompressSetting.PostPhoto);
                    if (obj != null)
                    {
                        break label2;
                    }
                    Globals.b("Upload file is null");
                }
                  goto _L4
label3:
                {
                    if (!AutoPostActivity.l(a))
                    {
                        break label3;
                    }
                    AutoPostActivity.o(a);
                }
                  goto _L1
                void1 = AccountManager.b();
                void1 = (com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)NetworkFile.a(void1, com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Photo, ((h) (obj)).e, ((h) (obj)).c, ((h) (obj)).f.toString(), ((h) (obj)).a).d();
                if (void1 == null)
                {
                    break MISSING_BLOCK_LABEL_325;
                }
                void1 = ((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult) (void1)).fileId;
_L5:
                if (!AutoPostActivity.l(a))
                {
                    break MISSING_BLOCK_LABEL_330;
                }
                AutoPostActivity.o(a);
                  goto _L1
                void1;
                void1.printStackTrace();
                void1 = null;
                  goto _L5
                void1;
                void1.printStackTrace();
                void1 = null;
                  goto _L5
                void1;
                void1.printStackTrace();
                void1 = null;
                  goto _L5
label4:
                {
                    if (void1 != null)
                    {
                        break label4;
                    }
                    Globals.b("Upload file failed.");
                }
                  goto _L4
label5:
                {
                    com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile = new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile();
                    postattachmentfile.fileId = void1;
                    postattachmentfile.metadata = ((h) (obj)).f.toString();
                    void1 = AutoPostActivity.a(a, postattachmentfile);
                    obj = AccountManager.b();
                    if (obj != null)
                    {
                        break label5;
                    }
                    Globals.b("Upload file failed.");
                    AutoPostActivity.o(a);
                }
                  goto _L1
                try
                {
                    void1 = (com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)NetworkPost.a(((String) (obj)), "native_posting", ((CompletePost) (void1)).mainPost, ((CompletePost) (void1)).subPosts).d();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    void1 = null;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    void1 = null;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    void1 = null;
                }
                if (void1 == null)
                {
                    Globals.b("Create post failed.");
                } else
                {
                    Globals.b("Create post success.");
                    flag = true;
                }
                  goto _L4
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final AutoPostActivity a;

            protected void a(Boolean boolean1)
            {
                if (com.cyberlink.beautycircle.controller.activity.AutoPostActivity.h(a) != com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).size()) goto _L2; else goto _L1
_L1:
                Globals.b("Auto post finished.");
                AutoPostActivity.d(a).setVisibility(8);
                com.cyberlink.beautycircle.controller.activity.AutoPostActivity.e(a).setVisibility(8);
_L4:
                if (boolean1.booleanValue())
                {
                    t.b.a();
                }
                return;
_L2:
                AutoPostActivity.d(a).setVisibility(0);
                com.cyberlink.beautycircle.controller.activity.AutoPostActivity.e(a).setVisibility(8);
                if (AutoPostActivity.l(a))
                {
                    AutoPostActivity.a(a, false);
                    Globals.b("Stop auto post.");
                    AutoPostActivity.d(a).setEnabled(true);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = AutoPostActivity.this;
                super();
            }
        });
    }

    static boolean r(AutoPostActivity autopostactivity)
    {
        return autopostactivity.o;
    }

    static boolean s(AutoPostActivity autopostactivity)
    {
        return autopostactivity.BaseActivity.e();
    }

    static boolean t(AutoPostActivity autopostactivity)
    {
        return autopostactivity.BaseActivity.e();
    }

    public SubPost a(com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        SubPost subpost = new SubPost();
        subpost.subPostId = null;
        subpost.content = "This post is created by auto post.";
        subpost.attachments = new com.cyberlink.beautycircle.model.PostBase.PostAttachments();
        subpost.attachments.files = new ArrayList();
        subpost.attachments.files.add(postattachmentfile);
        subpost.tags = new Tags();
        subpost.tags.productTags = new ArrayList();
        return subpost;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_auto_post);
        b(m.bc_developer_auto_post);
        e = (TextView)findViewById(com.cyberlink.beautycircle.j.auto_post_folder_path);
        e.setText(getResources().getString(m.bc_developer_folder_path, new Object[] {
            q
        }));
        f = (TextView)findViewById(com.cyberlink.beautycircle.j.auto_post_progress);
        bundle = getResources().getString(m.bc_developer_progress_title, new Object[] {
            Integer.valueOf(0), Integer.valueOf(0)
        });
        f.setText(bundle);
        g = (Button)findViewById(com.cyberlink.beautycircle.j.auto_post_start);
        g.setOnClickListener(v);
        h = (Button)findViewById(com.cyberlink.beautycircle.j.auto_post_stop);
        h.setOnClickListener(w);
        i = (ImageView)findViewById(com.cyberlink.beautycircle.j.auto_post_image);
        j = (TextView)findViewById(com.cyberlink.beautycircle.j.bc_goto_right_text);
        k = findViewById(com.cyberlink.beautycircle.j.bc_sharein_selected_category_icon_panel);
        l = (UICImageView)findViewById(com.cyberlink.beautycircle.j.bc_sharein_selected_category_icon);
        n = findViewById(com.cyberlink.beautycircle.j.bc_sharein_circle);
        n.setOnClickListener(x);
        m = findViewById(com.cyberlink.beautycircle.j.bc_goto_image);
        p = (CirclePager)findViewById(com.cyberlink.beautycircle.j.circle_pager);
        p.setCreateCircleBtnPos(com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.CreateCircleBtnPos.b);
        p.setEventListener(z);
        p.a();
        t.a.a(A);
    }

    public void onDestroy()
    {
        t.a.b(A);
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        o();
    }
}
