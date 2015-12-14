// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.c;
import com.cyberlink.beautycircle.controller.fragment.d;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.controller.fragment.y;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.SubPost;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.model.network.q;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.r;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.UUID;

public class WritePostActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private TreeSet A;
    private ArrayList B;
    private j C;
    private j D;
    private j E;
    private android.view.View.OnClickListener F;
    private u G;
    private g H;
    private android.view.View.OnClickListener I;
    private ObjectAnimator J;
    private d K;
    private android.content.DialogInterface.OnClickListener L;
    private c M;
    private boolean f;
    private com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile g;
    private com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile h;
    private boolean i;
    private EmojiconEditText j;
    private ScrollView k;
    private TextView l;
    private View m;
    private UICImageView n;
    private View o;
    private View p;
    private boolean q;
    private View r;
    private CirclePager s;
    private boolean t;
    private Long u;
    private boolean v;
    private CompletePost w;
    private boolean x;
    private Comparator y;
    private TreeSet z;

    public WritePostActivity()
    {
        f = false;
        g = null;
        h = null;
        i = false;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = false;
        r = null;
        s = null;
        t = false;
        u = null;
        v = false;
        w = null;
        x = false;
        y = new Comparator() {

            final WritePostActivity a;

            public int a(c c1, c c2)
            {
                return c1.hashCode() - c2.hashCode();
            }

            public int compare(Object obj, Object obj1)
            {
                return a((c)obj, (c)obj1);
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        z = new TreeSet(y);
        A = new TreeSet(y);
        B = new ArrayList();
        F = new android.view.View.OnClickListener() {

            final WritePostActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.WritePostActivity.b(a);
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        G = new u() {

            final WritePostActivity a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnNewCircle"
                });
                WritePostActivity.a(a, false, false);
                Intent intent = a.getIntent();
                if (intent != null)
                {
                    intent.removeExtra("CategoryId");
                }
                CircleList.a(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls11 a;

                    protected void a(Void void1)
                    {
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.e(a.a).a();
                    }

                    protected void b(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                a = _pcls11;
                super();
            }
                });
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        H = new g() {

            final WritePostActivity a;

            public void a()
            {
                com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
            }

            public void a(int i1)
            {
                if (i1 == 32769)
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            WritePostActivity.f(a.a);
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                    return;
                } else
                {
                    String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.g(a.a);
                        }

            
            {
                a = _pcls12;
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
                    WritePostActivity.a(a, (CircleBasic)treeset.first());
                    WritePostActivity.a(a, false, true);
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
                if (!com.cyberlink.beautycircle.controller.activity.WritePostActivity.h(a) && WritePostActivity.i(a).isEmpty())
                {
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.j(a);
                    Object obj = a.getIntent();
                    if (obj != null)
                    {
                        String s1 = ((Intent) (obj)).getStringExtra("FilePath");
                        if (s1 != null && !s1.isEmpty())
                        {
                            ((c)WritePostActivity.i(a).get(0)).a(s1);
                        }
                        obj = ((Intent) (obj)).getStringExtra("Content");
                        if (obj != null)
                        {
                            ((c)WritePostActivity.i(a).get(0)).b(((String) (obj)));
                        }
                    }
                }
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        I = new android.view.View.OnClickListener() {

            final WritePostActivity a;

            public void onClick(View view)
            {
                view = a;
                boolean flag;
                if (!com.cyberlink.beautycircle.controller.activity.WritePostActivity.k(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                WritePostActivity.a(view, flag, true);
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        J = null;
        K = new d() {

            final WritePostActivity a;

            public void a(c c1)
            {
                while (WritePostActivity.o(a) || c1 != WritePostActivity.i(a).get(WritePostActivity.i(a).size() - 1)) 
                {
                    return;
                }
                com.cyberlink.beautycircle.controller.activity.WritePostActivity.j(a);
                WritePostActivity.p(a).addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(this) {

                    final _cls15 a;

                    public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                            int k2, int l2)
                    {
                        WritePostActivity.p(a.a).removeOnLayoutChangeListener(this);
                        WritePostActivity.p(a.a).fullScroll(130);
                    }

            
            {
                a = _pcls15;
                super();
            }
                });
            }

            public void a(c c1, boolean flag)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "isCompleted: ", Boolean.valueOf(flag), ", ", c1
                });
                if (flag)
                {
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.q(a).add(c1);
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.r(a).remove(c1);
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.s(a);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.q(a).remove(c1);
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.r(a).add(c1);
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.s(a);
                    return;
                }
            }

            public void b(c c1)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    c1
                });
                com.cyberlink.beautycircle.controller.activity.WritePostActivity.t(a);
            }

            public void c(c c1)
            {
                if (WritePostActivity.i(a).get(WritePostActivity.i(a).size() - 1) == c1)
                {
                    return;
                } else
                {
                    ((ViewGroup)a.findViewById(com.cyberlink.beautycircle.j.write_post_layout)).removeView(c1.b());
                    WritePostActivity.i(a).remove(c1);
                    ((c)WritePostActivity.i(a).get(0)).a();
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.r(a).remove(c1);
                    return;
                }
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        L = new android.content.DialogInterface.OnClickListener() {

            final WritePostActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                WritePostActivity.a(a, false);
                if (!com.cyberlink.beautycircle.controller.activity.WritePostActivity.h(a) && com.cyberlink.beautycircle.controller.activity.WritePostActivity.v(a))
                {
                    WritePostActivity.w(a);
                }
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        };
        M = null;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile A(WritePostActivity writepostactivity)
    {
        return writepostactivity.h;
    }

    static j B(WritePostActivity writepostactivity)
    {
        return writepostactivity.C;
    }

    static CompletePost a(WritePostActivity writepostactivity, CompletePost completepost)
    {
        writepostactivity.w = completepost;
        return completepost;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile a(WritePostActivity writepostactivity, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        writepostactivity.g = postattachmentfile;
        return postattachmentfile;
    }

    private j a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        Object obj = AccountManager.b();
        if (obj == null)
        {
            DialogUtils.a(this, m.bc_write_post_message_must_sign_in);
            return null;
        }
        uri = NetworkFile.a(uri, com.perfectcorp.utility.ImageUtils.CompressSetting.PostPhoto);
        if (uri == null)
        {
            return null;
        } else
        {
            obj = NetworkFile.a(((String) (obj)), com.cyberlink.beautycircle.model.network.NetworkFile.FileType.PostCoverOri, ((h) (uri)).e, ((h) (uri)).c, ((h) (uri)).f.toString(), ((h) (uri)).a);
            ((j) (obj)).a(new com.perfectcorp.utility.m(uri) {

                final h a;
                final WritePostActivity b;

                private void e()
                {
                    if (WritePostActivity.B(b) == this)
                    {
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.c(b, null);
                    }
                }

                public void a()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "uploadCoverOri cancelled"
                    });
                    e();
                }

                public void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "uploadCoverOri error: ", Integer.valueOf(i1)
                    });
                    e();
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                {
                    if (uploadfileresult == null || uploadfileresult.fileId == null)
                    {
                        b(0x80000001);
                        return;
                    } else
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "uploadCoverOri done"
                        });
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.b(b, new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile());
                        WritePostActivity.A(b).fileId = uploadfileresult.fileId;
                        WritePostActivity.A(b).metadata = a.f.toString();
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.s(b);
                        e();
                        return;
                    }
                }

                protected void b(Object obj1)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj1);
                }

            
            {
                b = WritePostActivity.this;
                a = h1;
                super();
            }
            });
            return ((j) (obj));
        }
    }

    static j a(WritePostActivity writepostactivity, j j1)
    {
        writepostactivity.D = j1;
        return j1;
    }

    static j a(WritePostActivity writepostactivity, String s1, FileMetadata filemetadata)
    {
        return writepostactivity.a(s1, filemetadata);
    }

    private j a(String s1, FileMetadata filemetadata)
    {
        if (s1 != null && filemetadata != null)
        {
            String s2 = AccountManager.b();
            if (s2 == null)
            {
                DialogUtils.a(this, m.bc_write_post_message_must_sign_in);
                return null;
            }
            s1 = NetworkFile.a(s1, filemetadata);
            if (s1 != null)
            {
                NetworkFile.a(s2, com.cyberlink.beautycircle.model.network.NetworkFile.FileType.PostCover, ((h) (s1)).e, ((h) (s1)).c, ((h) (s1)).f.toString(), ((h) (s1)).a).a(new com.perfectcorp.utility.m(s1) {

                    final h a;
                    final WritePostActivity b;

                    private void e()
                    {
                        if (WritePostActivity.z(b) == this)
                        {
                            WritePostActivity.a(b, null);
                        }
                    }

                    public void a()
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "uploadCover cancelled"
                        });
                        e();
                    }

                    public void a(int i1)
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "uploadCover error: ", Integer.valueOf(i1)
                        });
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.t(b);
                        e();
                    }

                    protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                    {
                        if (uploadfileresult == null || uploadfileresult.fileId == null)
                        {
                            b(0x80000001);
                            return;
                        } else
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "uploadCover done"
                            });
                            WritePostActivity.a(b, new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile());
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.y(b).fileId = uploadfileresult.fileId;
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.y(b).metadata = a.f.toString();
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.s(b);
                            e();
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj);
                    }

            
            {
                b = WritePostActivity.this;
                a = h1;
                super();
            }
                });
                return null;
            }
        }
        return null;
    }

    private void a(long l1)
    {
        k();
        NetworkPost.a(AccountManager.c(), l1).a(new com.perfectcorp.utility.m() {

            final WritePostActivity a;

            protected void a()
            {
                a(0x80000005);
            }

            protected void a(int i1)
            {
                a.l();
                String s1 = a.getResources().getString(m.bc_dialog_title_error);
                String s2 = a.getResources().getString(m.bc_dialog_message_post_not_existed);
                DialogUtils.a(Globals.d, s1, s2, new Runnable(this) {

                    final _cls8 a;

                    public void run()
                    {
                        WritePostActivity.a(a.a);
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
            }

            protected void a(CompletePost completepost)
            {
                if (completepost != null)
                {
                    WritePostActivity.a(a, completepost);
                    WritePostActivity.a(a, completepost, true);
                }
            }

            protected void b(Object obj)
            {
                a((CompletePost)obj);
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        });
    }

    static void a(WritePostActivity writepostactivity, CircleBasic circlebasic)
    {
        writepostactivity.a(circlebasic);
    }

    static void a(WritePostActivity writepostactivity, CompletePost completepost, boolean flag)
    {
        writepostactivity.a(completepost, flag);
    }

    static void a(WritePostActivity writepostactivity, boolean flag, boolean flag1)
    {
        writepostactivity.a(flag, flag1);
    }

    private void a(CircleBasic circlebasic)
    {
        l.setText(circlebasic.circleName);
        CircleList.a(n, circlebasic);
    }

    private void a(CompletePost completepost, boolean flag)
    {
        if (completepost == null)
        {
            return;
        }
        x = true;
        Post post = completepost.mainPost;
        if (post != null)
        {
            u = post.postId;
            j.setText(post.title);
            if (post.circles != null && !post.circles.isEmpty() && post.circles.get(0) != null)
            {
                s.setDefaultCircleId(((com.cyberlink.beautycircle.model.Post.PostCircle)post.circles.get(0)).circleId);
            }
            boolean flag1 = post.e();
            p().a(post, flag1);
            if (completepost.subPosts != null)
            {
                SubPost subpost;
                for (completepost = completepost.subPosts.iterator(); completepost.hasNext(); p().a(subpost, flag1))
                {
                    subpost = (SubPost)completepost.next();
                }

            }
            if (!flag1 && flag)
            {
                p();
            }
        }
        x = false;
    }

    private void a(boolean flag)
    {
        f = false;
        if (flag)
        {
            if (t)
            {
                com.cyberlink.beautycircle.c.a(this, "");
            }
            setResult(-1);
            l(this);
            return;
        }
        if (v)
        {
            setResult(0);
            m(this);
            return;
        } else
        {
            DialogUtils.a(this, "", getResources().getString(m.bc_write_post_cancel_desc), getResources().getString(m.bc_write_post_cancel_nagtive_option), null, getResources().getString(m.bc_write_post_cancel_postive_option), new Runnable() {

                final WritePostActivity a;

                public void run()
                {
                    a.setResult(0);
                    WritePostActivity.n(a);
                }

            
            {
                a = WritePostActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void a(boolean flag, boolean flag1)
    {
        byte byte1 = 4;
        if (q == flag)
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
        s.setVisibility(byte0);
        if (J != null)
        {
            J.cancel();
            J = null;
        }
        if (flag1)
        {
            J = ObjectAnimator.ofFloat(o, "rotation", new float[] {
                f1
            });
            J.setDuration(300L);
            J.start();
        } else
        {
            o.setRotation(f1);
        }
        if (l != null)
        {
            Object obj = l;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            ((TextView) (obj)).setVisibility(byte0);
        }
        if (m != null)
        {
            obj = m;
            if (flag)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            ((View) (obj)).setVisibility(byte0);
        }
        q = flag;
    }

    static boolean a(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static boolean a(WritePostActivity writepostactivity, boolean flag)
    {
        writepostactivity.f = flag;
        return flag;
    }

    private CompletePost b(boolean flag)
    {
        Post post = null;
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = B.iterator(); iterator.hasNext();)
        {
            SubPost subpost = ((c)iterator.next()).a(flag);
            if (subpost == null)
            {
                com.perfectcorp.utility.e.d(new Object[] {
                    "subPost == null"
                });
            } else
            if (post == null)
            {
                post = new Post();
                post.postId = u;
                post.title = j.getText().toString();
                post.content = subpost.content;
                post.attachments = subpost.attachments;
                if (g != null)
                {
                    post.attachments.files.add(g);
                }
                if (h != null)
                {
                    post.attachments.files.add(h);
                }
                post.circleIds = new ArrayList();
                CircleBasic circlebasic;
                for (Iterator iterator1 = s.getSelectedCircles().iterator(); iterator1.hasNext(); post.circleIds.add(circlebasic.id))
                {
                    circlebasic = (CircleBasic)iterator1.next();
                }

                post.tags = subpost.tags;
            } else
            {
                arraylist.add(subpost);
            }
        }

        CompletePost completepost = new CompletePost();
        completepost.mainPost = post;
        completepost.subPosts = arraylist;
        return completepost;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile b(WritePostActivity writepostactivity, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        writepostactivity.h = postattachmentfile;
        return postattachmentfile;
    }

    static j b(WritePostActivity writepostactivity, j j1)
    {
        writepostactivity.E = j1;
        return j1;
    }

    static void b(WritePostActivity writepostactivity)
    {
        writepostactivity.o();
    }

    static void b(WritePostActivity writepostactivity, boolean flag)
    {
        writepostactivity.a(flag);
    }

    static j c(WritePostActivity writepostactivity, j j1)
    {
        writepostactivity.C = j1;
        return j1;
    }

    static boolean c(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static Long d(WritePostActivity writepostactivity)
    {
        return writepostactivity.u;
    }

    static CirclePager e(WritePostActivity writepostactivity)
    {
        return writepostactivity.s;
    }

    static boolean f(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static boolean g(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static boolean h(WritePostActivity writepostactivity)
    {
        return writepostactivity.v;
    }

    static ArrayList i(WritePostActivity writepostactivity)
    {
        return writepostactivity.B;
    }

    static c j(WritePostActivity writepostactivity)
    {
        return writepostactivity.p();
    }

    static boolean k(WritePostActivity writepostactivity)
    {
        return writepostactivity.q;
    }

    static boolean l(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static boolean m(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    static boolean n(WritePostActivity writepostactivity)
    {
        return writepostactivity.BaseActivity.e();
    }

    private void o()
    {
        AccountManager.a(this, new b() {

            final WritePostActivity a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(a, "", a.getResources().getString(m.bc_post_delete_confirm_text), a.getResources().getString(m.bc_post_cancel), null, a.getResources().getString(m.bc_post_delete), new Runnable(this, s1) {

                        final String a;
                        final _cls10 b;

                        public void run()
                        {
                            b.a.k();
                            NetworkPost.a(a, com.cyberlink.beautycircle.controller.activity.WritePostActivity.d(b.a)).a(new com.perfectcorp.utility.m(this) {

                                final _cls1 a;

                                protected void a()
                                {
                                    a.b.a.l();
                                }

                                protected void a(int i1)
                                {
                                    a.b.a.l();
                                    Globals.a(a.b.a.getResources().getString(m.bc_server_connect_fail));
                                    com.perfectcorp.utility.e.e(new Object[] {
                                        "DeletePost: ", Integer.valueOf(i1)
                                    });
                                }

                                protected void a(Void void1)
                                {
                                    a.b.a.l();
                                    t.b.a();
                                    a.b.a.setResult(48257);
                                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.c(a.b.a);
                                }

                                protected void b(Object obj)
                                {
                                    a((Void)obj);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

            
            {
                b = _pcls10;
                a = s1;
                super();
            }
                    });
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                a = WritePostActivity.this;
                super();
            }
        });
    }

    static boolean o(WritePostActivity writepostactivity)
    {
        return writepostactivity.x;
    }

    static ScrollView p(WritePostActivity writepostactivity)
    {
        return writepostactivity.k;
    }

    private c p()
    {
        c c1 = new c(this, B.isEmpty());
        B.add(c1);
        A.add(c1);
        c1.a(K);
        ViewGroup viewgroup = (ViewGroup)findViewById(com.cyberlink.beautycircle.j.write_post_layout);
        viewgroup.addView(c1.a(LayoutInflater.from(this), viewgroup, null));
        return c1;
    }

    static TreeSet q(WritePostActivity writepostactivity)
    {
        return writepostactivity.z;
    }

    private boolean q()
    {
        float f1;
        boolean flag;
        boolean flag1;
        if (!v && i)
        {
            int i1;
            int j1;
            if (g != null)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (h != null)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            f1 = (float)((i1 + j1 + B.size()) - A.size()) / (float)(B.size() + 2);
        } else
        {
            f1 = (float)(B.size() - A.size()) / (float)B.size();
        }
        f1 *= 0.9F;
        i1 = A.size();
        if (g != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (h != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        com.perfectcorp.utility.e.b(new Object[] {
            Integer.valueOf(i1), ", ", Boolean.valueOf(flag), ", ", Boolean.valueOf(flag1), ", ", Float.valueOf(f1)
        });
        if (f)
        {
            a(m.bc_write_post_dialog_title, Float.valueOf(f1), L, null);
            if (f1 >= 0.9F)
            {
                if (v)
                {
                    v();
                    return true;
                } else
                {
                    u();
                    return true;
                }
            }
        }
        return false;
    }

    static TreeSet r(WritePostActivity writepostactivity)
    {
        return writepostactivity.A;
    }

    private void r()
    {
        l();
        if (f)
        {
            DialogUtils.a(this, m.bc_write_post_message_upload_photo_fail);
        }
        f = false;
    }

    private void s()
    {
        if (D != null)
        {
            D.a(true);
            D = null;
        }
        if (C != null)
        {
            C.a(true);
            C = null;
        }
        if (E != null)
        {
            E.a(true);
            E = null;
        }
        g = null;
        h = null;
    }

    static boolean s(WritePostActivity writepostactivity)
    {
        return writepostactivity.q();
    }

    private q t()
    {
        q q1;
        Iterator iterator;
        CompletePost completepost;
        iterator = null;
        completepost = b(false);
        q1 = iterator;
        if (completepost == null) goto _L2; else goto _L1
_L1:
        q1 = iterator;
        if (completepost.mainPost == null) goto _L2; else goto _L3
_L3:
        q1 = new q();
        q1.a = completepost.mainPost;
        if (completepost.mainPost.e()) goto _L2; else goto _L4
_L4:
        if (completepost.subPosts != null)
        {
            iterator = completepost.subPosts.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                SubPost subpost = (SubPost)iterator.next();
                if (subpost != null && subpost.subPostId == null)
                {
                    iterator.remove();
                    if (q1.c == null)
                    {
                        q1.c = new ArrayList();
                    }
                    q1.c.add(subpost);
                }
            } while (true);
            if (completepost.subPosts != null && !completepost.subPosts.isEmpty())
            {
                q1.b = completepost.subPosts;
            }
        }
        if (w == null || w.subPosts == null) goto _L2; else goto _L5
_L5:
        iterator = w.subPosts.iterator();
_L6:
        SubPost subpost1;
        boolean flag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        subpost1 = (SubPost)iterator.next();
        if (subpost1 == null || subpost1.subPostId == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (completepost.subPosts == null)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        Iterator iterator1 = completepost.subPosts.iterator();
        SubPost subpost3;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_339;
            }
            subpost3 = (SubPost)iterator1.next();
        } while (subpost3 == null || !subpost1.subPostId.equals(subpost3.subPostId));
        flag = true;
_L7:
        if (!flag)
        {
            if (q1.d == null)
            {
                q1.d = new ArrayList();
            }
            SubPost subpost2 = new SubPost();
            subpost2.subPostId = subpost1.subPostId;
            q1.d.add(subpost2);
        }
        if (true) goto _L6; else goto _L2
_L2:
        return q1;
        flag = false;
          goto _L7
    }

    static void t(WritePostActivity writepostactivity)
    {
        writepostactivity.r();
    }

    static j u(WritePostActivity writepostactivity)
    {
        return writepostactivity.E;
    }

    private void u()
    {
        com.perfectcorp.utility.e.a(new Object[] {
            "Check is posting"
        });
        if (!f)
        {
            return;
        }
        com.perfectcorp.utility.e.a(new Object[] {
            "Check is sign in"
        });
        String s1 = AccountManager.b();
        if (s1 == null)
        {
            l();
            DialogUtils.a(this, m.bc_write_post_message_must_sign_in);
            f = false;
            return;
        } else
        {
            com.perfectcorp.utility.e.a(new Object[] {
                "Start sending creatPosts request"
            });
            CompletePost completepost = b(false);
            com.perfectcorp.utility.e.b(new Object[] {
                "Sending createPosts"
            });
            j();
            NetworkPost.a(s1, "native_posting", completepost.mainPost, completepost.subPosts).a(new com.perfectcorp.utility.m() {

                final WritePostActivity a;

                protected void a()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Requesting createPosts cancelled."
                    });
                    a.l();
                    WritePostActivity.a(a, false);
                }

                protected void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Requesting createPosts error:", Integer.valueOf(i1)
                    });
                    String s2 = (new StringBuilder()).append(a.getResources().getString(m.bc_write_post_message_create_post_fail)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    DialogUtils.a(a, s2);
                    a.l();
                    WritePostActivity.a(a, false);
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult createpostsresult)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "createPosts success"
                    });
                    a.a(m.bc_write_post_dialog_title, Float.valueOf(1.0F), com.cyberlink.beautycircle.controller.activity.WritePostActivity.x(a), new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            a.a.l();
                            WritePostActivity.a(a.a, false);
                            Globals.a(a.a.getResources().getString(m.bc_write_post_success));
                            t.b.a();
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.b(a.a, true);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)obj);
                }

            
            {
                a = WritePostActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void v()
    {
        com.perfectcorp.utility.e.a(new Object[] {
            "Check is posting"
        });
        if (!f)
        {
            return;
        }
        com.perfectcorp.utility.e.a(new Object[] {
            "Check is sign in"
        });
        String s1 = AccountManager.b();
        if (s1 == null)
        {
            l();
            DialogUtils.a(this, m.bc_write_post_message_must_sign_in);
            f = false;
            return;
        } else
        {
            com.perfectcorp.utility.e.a(new Object[] {
                "Start sending updatePosts request"
            });
            q q1 = t();
            com.perfectcorp.utility.e.b(new Object[] {
                "Sending updatePosts"
            });
            j();
            NetworkPost.a(s1, null, q1).a(new com.perfectcorp.utility.m() {

                final WritePostActivity a;

                protected void a()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Requesting updatePosts cancelled."
                    });
                    a.l();
                    WritePostActivity.a(a, false);
                }

                protected void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Requesting updatePosts error:", Integer.valueOf(i1)
                    });
                    String s2 = (new StringBuilder()).append(a.getResources().getString(m.bc_write_post_message_edit_post_fail)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    DialogUtils.a(a, s2);
                    a.l();
                    WritePostActivity.a(a, false);
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult createpostsresult)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "updatePosts success"
                    });
                    a.a(m.bc_write_post_dialog_title, Float.valueOf(1.0F), com.cyberlink.beautycircle.controller.activity.WritePostActivity.x(a), new Runnable(this) {

                        final _cls5 a;

                        public void run()
                        {
                            a.a.l();
                            WritePostActivity.a(a.a, false);
                            Globals.a(a.a.getResources().getString(m.bc_write_post_edit_success));
                            t.b.a();
                            com.cyberlink.beautycircle.controller.activity.WritePostActivity.b(a.a, true);
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)obj);
                }

            
            {
                a = WritePostActivity.this;
                super();
            }
            });
            return;
        }
    }

    static boolean v(WritePostActivity writepostactivity)
    {
        return writepostactivity.i;
    }

    static void w(WritePostActivity writepostactivity)
    {
        writepostactivity.s();
    }

    static android.content.DialogInterface.OnClickListener x(WritePostActivity writepostactivity)
    {
        return writepostactivity.L;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile y(WritePostActivity writepostactivity)
    {
        return writepostactivity.g;
    }

    static j z(WritePostActivity writepostactivity)
    {
        return writepostactivity.D;
    }

    public void a(c c1, Uri uri, ArrayList arraylist)
    {
        M = c1;
        com.cyberlink.beautycircle.c.a(this, uri, arraylist);
    }

    public void a(c c1, String s1)
    {
        M = c1;
        DialogUtils.a(this, 48138, 48139, s1);
    }

    protected boolean e()
    {
        a(false);
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        super.onActivityResult(i1, j1, intent);
        if (M != null)
        {
            M.a(i1, j1, intent);
            M = null;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj = null;
        super.onCreate(bundle);
        setContentView(k.bc_activity_write_post);
        Object obj1 = getIntent();
        int i1;
        long l1;
        long l2;
        if (obj1 != null)
        {
            l2 = ((Intent) (obj1)).getLongExtra("CategoryId", -1L);
            t = ((Intent) (obj1)).getBooleanExtra("IsForceToFeed", false);
            String s1 = ((Intent) (obj1)).getStringExtra("CategoryType");
            l1 = ((Intent) (obj1)).getLongExtra("PostId", -1L);
            obj1 = ((Intent) (obj1)).getStringExtra("CompletePost");
            if (obj1 != null)
            {
                obj = (CompletePost)Model.a(com/cyberlink/beautycircle/model/CompletePost, ((String) (obj1)));
                v = true;
                w = ((CompletePost) (obj));
            }
            if (l1 != -1L)
            {
                v = true;
            }
            obj1 = obj;
            obj = s1;
        } else
        {
            l1 = -1L;
            obj = null;
            obj1 = null;
            l2 = -1L;
        }
        if (v)
        {
            i1 = m.bc_edit_post_title;
        } else
        {
            i1 = m.bc_write_post_title;
        }
        b(i1);
        b().a(0xc1000000, x.b, 0, y.a);
        if (v)
        {
            b().c(m.bc_top_bar_save_btn);
        }
        j = (EmojiconEditText)findViewById(com.cyberlink.beautycircle.j.write_post_title);
        k = (ScrollView)findViewById(com.cyberlink.beautycircle.j.scroller);
        l = (TextView)findViewById(com.cyberlink.beautycircle.j.bc_goto_right_text);
        m = findViewById(com.cyberlink.beautycircle.j.bc_sharein_selected_category_icon_panel);
        n = (UICImageView)findViewById(com.cyberlink.beautycircle.j.bc_sharein_selected_category_icon);
        p = findViewById(com.cyberlink.beautycircle.j.bc_sharein_circle);
        p.setOnClickListener(I);
        o = findViewById(com.cyberlink.beautycircle.j.bc_goto_image);
        s = (CirclePager)findViewById(com.cyberlink.beautycircle.j.circle_pager);
        s.setCreateCircleBtnPos(com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.CreateCircleBtnPos.b);
        s.setDefaultCircleId(l2);
        s.setDefaultCircleType(((String) (obj)));
        s.setEventListener(H);
        s.a();
        t.a.a(G);
        r = findViewById(com.cyberlink.beautycircle.j.bc_delete_post_btn);
        if (v)
        {
            r.setVisibility(0);
            r.setOnClickListener(F);
        }
        if (e.a)
        {
            j.getText().append("[Developer] ").append((new Date()).toString());
        }
        if (obj1 != null && bundle == null)
        {
            a(((CompletePost) (obj1)), true);
        } else
        if (obj1 == null && l1 != -1L && bundle == null)
        {
            a(l1);
            return;
        }
    }

    public void onDestroy()
    {
        t.a.b(G);
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "savedInstanceState: ", bundle
        });
        super.onRestoreInstanceState(bundle);
        Object obj = null;
        if (bundle != null)
        {
            String s1 = bundle.getString("CompletePost");
            bundle = obj;
            if (s1 != null)
            {
                bundle = (CompletePost)Model.a(com/cyberlink/beautycircle/model/CompletePost, s1);
            }
            if (bundle != null)
            {
                a(bundle, false);
            }
        }
    }

    public void onRightBtnClick(View view)
    {
        if (!f) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            f = true;
            if (s.getSelectedCircles().isEmpty())
            {
                view = findViewById(com.cyberlink.beautycircle.j.circles_label);
                k.smoothScrollTo((int)view.getX(), (int)view.getY());
                DialogUtils.a(this, m.bc_write_post_message_need_circle);
                f = false;
                return;
            }
            if (j.getText().toString().isEmpty())
            {
                view = findViewById(com.cyberlink.beautycircle.j.title_label);
                k.smoothScrollTo((int)view.getX(), (int)view.getY());
                DialogUtils.a(this, m.bc_write_post_message_need_title);
                f = false;
                return;
            }
            view = new ArrayList();
            c c1;
label1:
            do
            {
                Uri uri;
                for (Iterator iterator = B.iterator(); iterator.hasNext(); view.add(uri))
                {
                    c1 = (c)iterator.next();
                    uri = c1.d();
                    if (uri == null)
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (!c1.e());
            k.smoothScrollTo((int)c1.b().getX(), (int)c1.b().getY());
            DialogUtils.a(this, m.bc_write_post_message_need_photo_for_description);
            f = false;
            return;
        }
        if (view.isEmpty())
        {
            DialogUtils.a(this, m.bc_write_post_message_need_photo);
            f = false;
            return;
        }
        if (!v && i)
        {
            g = null;
            h = null;
            q();
            view = ((c)B.get(0)).d();
            C = a(view);
            E = (new j() {

                final WritePostActivity a;

                private void e()
                {
                    if (com.cyberlink.beautycircle.controller.activity.WritePostActivity.u(a) == this)
                    {
                        com.cyberlink.beautycircle.controller.activity.WritePostActivity.b(a, null);
                    }
                }

                protected volatile Object a(Object obj)
                {
                    return a((Uri)obj);
                }

                protected Void a(Uri uri1)
                {
                    if (uri1 == null)
                    {
                        b(0x80000004);
                        return null;
                    }
                    uri1 = ImageUtils.a(Globals.n(), uri1);
                    if (uri1 == null)
                    {
                        b(0x80000001);
                        return null;
                    }
                    com.cyberlink.beautycircle.Globals.AspectRatio aspectratio = com.cyberlink.beautycircle.Globals.CropSettings.PostCover.aspectRatio;
                    uri1 = com.cyberlink.beautycircle.utility.r.a(a, uri1, aspectratio.x, aspectratio.y);
                    if (uri1 == null)
                    {
                        b(0x80000001);
                        return null;
                    }
                    uri1 = NetworkFile.a(uri1, com.perfectcorp.utility.ImageUtils.CompressSetting.PostCover);
                    if (uri1 == null)
                    {
                        b(0x80000001);
                        return null;
                    } else
                    {
                        WritePostActivity.a(a, WritePostActivity.a(a, ((h) (uri1)).g, ((h) (uri1)).f));
                        e();
                        return null;
                    }
                }

                protected void a()
                {
                    a(0x80000005);
                }

                protected void a(int i1)
                {
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.t(a);
                    e();
                }

            
            {
                a = WritePostActivity.this;
                super();
            }
            }).d(view);
        }
        if (A.isEmpty())
        {
            q();
            return;
        }
        view = A.iterator();
        while (view.hasNext()) 
        {
            ((c)view.next()).c();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "outState before super: ", bundle
        });
        super.onSaveInstanceState(bundle);
        com.perfectcorp.utility.e.c(new Object[] {
            "outState after super: ", bundle
        });
        bundle.putString("CompletePost", b(true).toString());
    }

}
