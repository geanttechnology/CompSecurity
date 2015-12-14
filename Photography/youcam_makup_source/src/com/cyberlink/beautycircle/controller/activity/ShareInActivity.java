// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.g;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ShareInXmlParser;
import com.cyberlink.beautycircle.utility.aa;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.utility.x;
import com.cyberlink.beautycircle.utility.z;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.l;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;

public class ShareInActivity extends BaseActivity
    implements z
{

    private x A;
    private x B;
    private ArrayList C;
    private int D;
    private com.perfectcorp.utility.j E;
    private com.perfectcorp.utility.j F;
    private com.perfectcorp.utility.j G;
    private com.perfectcorp.utility.j H;
    private TreeSet I;
    private String J;
    private ShareInParam K;
    private String L;
    private WebView M;
    private com.cyberlink.beautycircle.view.widgetpool.common.g N;
    private android.view.View.OnClickListener O;
    private android.content.DialogInterface.OnClickListener P;
    private PagerAdapter Q;
    private android.support.v4.view.ViewPager.OnPageChangeListener R;
    private com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile S;
    protected android.view.View.OnClickListener e;
    protected android.view.View.OnClickListener f;
    protected android.view.View.OnClickListener g;
    protected android.view.View.OnClickListener h;
    protected android.view.View.OnLongClickListener i;
    protected android.view.View.OnClickListener j;
    private TextView k;
    private UICImageView l;
    private ImageView m;
    private View n;
    private View o;
    private View p;
    private TextView q;
    private ViewPager r;
    private View s;
    private TextView t;
    private TextView u;
    private TextView v;
    private CircleList w;
    private boolean x;
    private Uri y;
    private ShareInXmlParser z;

    public ShareInActivity()
    {
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = false;
        y = null;
        z = null;
        A = null;
        B = null;
        C = new ArrayList();
        D = -1;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = null;
        L = null;
        M = null;
        N = new com.cyberlink.beautycircle.view.widgetpool.common.g() {

            final ShareInActivity a;

            public void a()
            {
                com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
            }

            public void a(int i1)
            {
                switch (i1)
                {
                default:
                    String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new Runnable(this) {

                        final _cls18 a;

                        public void run()
                        {
                            a.a.finish();
                        }

            
            {
                a = _pcls18;
                super();
            }
                    });
                    return;

                case 32769: 
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Not logged in"
                    });
                    break;
                }
                DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new Runnable(this) {

                    final _cls18 a;

                    public void run()
                    {
                        a.a.finish();
                    }

            
            {
                a = _pcls18;
                super();
            }
                });
            }

            public void a(TreeSet treeset)
            {
                ShareInActivity.a(a, treeset);
                if (!treeset.isEmpty())
                {
                    CircleBasic circlebasic = (CircleBasic)treeset.first();
                    if (circlebasic == null)
                    {
                        return;
                    }
                    StringBuilder stringbuilder = new StringBuilder(circlebasic.circleName);
                    CircleBasic circlebasic1 = (CircleBasic)treeset.higher(circlebasic);
                    if (circlebasic1 != null)
                    {
                        stringbuilder.append(", ").append(circlebasic1.circleName);
                        if ((CircleBasic)treeset.higher(circlebasic1) != null)
                        {
                            stringbuilder.append(", ...");
                        }
                    }
                    if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a).setText(stringbuilder);
                    }
                    CircleList.a(com.cyberlink.beautycircle.controller.activity.ShareInActivity.h(a), circlebasic);
                    com.cyberlink.beautycircle.controller.activity.ShareInActivity.h(a).setVisibility(0);
                } else
                {
                    if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a).setText("");
                    }
                    com.cyberlink.beautycircle.controller.activity.ShareInActivity.h(a).setVisibility(4);
                }
                ShareInActivity.a(a, false);
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.i(a);
            }

            public void b()
            {
            }

            public void c()
            {
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        O = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                view = a;
                boolean flag;
                if (!com.cyberlink.beautycircle.controller.activity.ShareInActivity.j(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ShareInActivity.a(view, flag);
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.i(a);
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.k(a);
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.l(a) <= 0)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.ShareInActivity.m(a);
                    ShareInActivity.n(a);
                    return;
                }
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.l(a) >= ShareInActivity.o(a).size() - 1)
                {
                    return;
                } else
                {
                    ShareInActivity.p(a);
                    ShareInActivity.n(a);
                    return;
                }
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.j(a))
                {
                    if (ShareInActivity.q(a) == null || ShareInActivity.q(a).size() < 1)
                    {
                        DialogUtils.a(a, m.bc_share_in_pick_a_circle);
                        return;
                    } else
                    {
                        ShareInActivity.a(a, false);
                        com.cyberlink.beautycircle.controller.activity.ShareInActivity.i(a);
                        return;
                    }
                } else
                {
                    ShareInActivity.r(a);
                    return;
                }
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        i = new android.view.View.OnLongClickListener() {

            final ShareInActivity a;

            public boolean onLongClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, Uri.parse(com.cyberlink.beautycircle.controller.activity.ShareInActivity.c(a)));
                return false;
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final ShareInActivity a;

            public void onClick(View view)
            {
                if (ShareInActivity.q(a) == null || ShareInActivity.q(a).size() < 1)
                {
                    DialogUtils.a(a, m.bc_share_in_pick_a_circle);
                    return;
                } else
                {
                    a.a(m.bc_sharein_dialog_title, Float.valueOf(0.0F), com.cyberlink.beautycircle.controller.activity.ShareInActivity.s(a), null);
                    ShareInActivity.a(a, null);
                    return;
                }
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        P = new android.content.DialogInterface.OnClickListener() {

            final ShareInActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Click to cancel"
                });
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.t(a);
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.u(a);
                if (ShareInActivity.f(a) != null)
                {
                    a.finish();
                }
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        Q = new PagerAdapter() {

            final ShareInActivity a;

            public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
            {
            }

            public int getCount()
            {
                return ShareInActivity.o(a).size();
            }

            public Object instantiateItem(ViewGroup viewgroup, int i1)
            {
                if (i1 < ShareInActivity.o(a).size())
                {
                    x x1 = (x)ShareInActivity.o(a).get(i1);
                    ImageView imageview = (ImageView)LayoutInflater.from(a).inflate(k.bc_view_item_share_in_image, viewgroup, false);
                    imageview.setImageBitmap(x1.c);
                    imageview.setTag(x1);
                    viewgroup.addView(imageview);
                    return x1;
                } else
                {
                    return null;
                }
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return obj == view.getTag();
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        R = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final ShareInActivity a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                ShareInActivity.a(a, i1);
                ShareInActivity.y(a);
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        };
        S = null;
    }

    static com.perfectcorp.utility.j A(ShareInActivity shareinactivity)
    {
        return shareinactivity.F;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile B(ShareInActivity shareinactivity)
    {
        return shareinactivity.S;
    }

    static void C(ShareInActivity shareinactivity)
    {
        shareinactivity.r();
    }

    static String D(ShareInActivity shareinactivity)
    {
        return shareinactivity.L;
    }

    static com.perfectcorp.utility.j E(ShareInActivity shareinactivity)
    {
        return shareinactivity.H;
    }

    static void F(ShareInActivity shareinactivity)
    {
        shareinactivity.t();
    }

    static int a(ShareInActivity shareinactivity, int i1)
    {
        shareinactivity.D = i1;
        return i1;
    }

    static WebView a(ShareInActivity shareinactivity, WebView webview)
    {
        shareinactivity.M = webview;
        return webview;
    }

    static com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile a(ShareInActivity shareinactivity, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile)
    {
        shareinactivity.S = postattachmentfile;
        return postattachmentfile;
    }

    static ShareInXmlParser a(ShareInActivity shareinactivity, ShareInXmlParser shareinxmlparser)
    {
        shareinactivity.z = shareinxmlparser;
        return shareinxmlparser;
    }

    static CircleList a(ShareInActivity shareinactivity)
    {
        return shareinactivity.w;
    }

    static com.perfectcorp.utility.j a(ShareInActivity shareinactivity, com.perfectcorp.utility.j j1)
    {
        shareinactivity.F = j1;
        return j1;
    }

    static com.perfectcorp.utility.j a(ShareInActivity shareinactivity, String s1)
    {
        return shareinactivity.f(s1);
    }

    static TreeSet a(ShareInActivity shareinactivity, TreeSet treeset)
    {
        shareinactivity.I = treeset;
        return treeset;
    }

    private void a(int i1, Integer integer)
    {
        String s2 = getResources().getString(i1);
        String s1 = s2;
        if (integer != null)
        {
            s1 = (new StringBuilder()).append(s2).append(com.cyberlink.beautycircle.model.network.s.a(integer.intValue())).toString();
        }
        if (K != null)
        {
            integer = new android.content.DialogInterface.OnDismissListener() {

                final ShareInActivity a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    a.finish();
                }

            
            {
                a = ShareInActivity.this;
                super();
            }
            };
        } else
        {
            integer = null;
        }
        DialogUtils.a(this, getString(m.bc_dialog_title_warning), s1, null, null, getString(m.bc_dialog_button_ok), null, true, integer);
    }

    private void a(Uri uri)
    {
        E = (new com.perfectcorp.utility.j(uri) {

            final Uri a;
            final ShareInActivity b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Enter"
                });
                String s1 = AccountManager.b();
                if (s1 == null)
                {
                    DialogUtils.a(b, m.bc_write_post_message_must_sign_in);
                    b(0x80000001);
                    return null;
                }
                if (c())
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "The promise task is cancelled."
                    });
                    return null;
                }
                com.perfectcorp.utility.e.b(new Object[] {
                    "Get account token"
                });
                if (a == null)
                {
                    void1 = ((x)ShareInActivity.o(b).get(com.cyberlink.beautycircle.controller.activity.ShareInActivity.l(b))).c;
                } else
                {
                    void1 = ImageUtils.a(Globals.n(), a);
                }
                void1 = NetworkFile.a(void1, com.perfectcorp.utility.ImageUtils.CompressSetting.PostPhoto);
                if (void1 == null)
                {
                    b.l();
                    ShareInActivity.a(b, m.bc_write_post_message_create_post_fail, null);
                    b(0x80000001);
                    return null;
                }
                if (c())
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "The promise task is cancelled."
                    });
                    return null;
                }
                ((h) (void1)).f.redirectUrl = com.cyberlink.beautycircle.controller.activity.ShareInActivity.z(b);
                com.perfectcorp.utility.e.b(new Object[] {
                    "Create upload post cover ori task"
                });
                ShareInActivity.a(b, NetworkFile.a(s1, com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Photo, ((h) (void1)).e, ((h) (void1)).c, ((h) (void1)).f.toString(), ((h) (void1)).a));
                if (ShareInActivity.A(b) != null)
                {
                    ShareInActivity.A(b).a(new com.perfectcorp.utility.m(this, void1) {

                        final h a;
                        final _cls10 b;

                        public void a()
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "The upload post coverOri is cancelled."
                            });
                        }

                        public void a(int i1)
                        {
                            com.perfectcorp.utility.e.e(new Object[] {
                                Integer.valueOf(i1)
                            });
                            if (ShareInActivity.A(b.b) != null)
                            {
                                ShareInActivity.A(b.b).a(true);
                                ShareInActivity.a(b.b, null);
                            }
                            b.b.l();
                            ShareInActivity.a(b.b, m.bc_write_post_message_create_post_fail, Integer.valueOf(i1));
                        }

                        protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                        {
                            if (uploadfileresult == null || uploadfileresult.fileId == null)
                            {
                                b(0x80000001);
                            } else
                            {
                                com.perfectcorp.utility.e.b(new Object[] {
                                    "Upload CoverOri finish: ", uploadfileresult.fileId
                                });
                                if (!c())
                                {
                                    ShareInActivity.a(b.b, new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile());
                                    ShareInActivity.B(b.b).fileId = uploadfileresult.fileId;
                                    ShareInActivity.B(b.b).metadata = a.f.toString();
                                    ShareInActivity.a(b.b, null);
                                }
                                if (ShareInActivity.A(b.b) != null)
                                {
                                    ShareInActivity.a(b.b, null);
                                    return;
                                }
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj);
                        }

            
            {
                b = _pcls10;
                a = h1;
                super();
            }
                    });
                }
                com.perfectcorp.utility.e.b(new Object[] {
                    "Leave."
                });
                return null;
            }

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Cancel upload promise task"
                });
                ShareInActivity.C(b);
            }

            public void a(int i1)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    Integer.valueOf(i1)
                });
                b.l();
                ShareInActivity.a(b, m.bc_write_post_message_create_post_fail, null);
            }

            
            {
                b = ShareInActivity.this;
                a = uri;
                super();
            }
        }).d(null);
    }

    static void a(ShareInActivity shareinactivity, int i1, Integer integer)
    {
        shareinactivity.a(i1, integer);
    }

    static void a(ShareInActivity shareinactivity, Uri uri)
    {
        shareinactivity.a(uri);
    }

    static void a(ShareInActivity shareinactivity, Float float1)
    {
        shareinactivity.a(float1);
    }

    private void a(Float float1)
    {
        Float float2 = float1;
        if (float1 == null)
        {
            float f1;
            if (S != null)
            {
                f1 = 0.9F;
            } else
            {
                f1 = 0.0F;
            }
            float2 = Float.valueOf(f1);
        }
        a(m.bc_sharein_dialog_title, float2, P, null);
        com.perfectcorp.utility.e.b(new Object[] {
            float2, ": ", S
        });
        if (float2.floatValue() < 0.9F)
        {
            return;
        } else
        {
            v();
            return;
        }
    }

    static boolean a(ShareInActivity shareinactivity, boolean flag)
    {
        shareinactivity.x = flag;
        return flag;
    }

    static WebView b(ShareInActivity shareinactivity)
    {
        return shareinactivity.M;
    }

    static com.perfectcorp.utility.j b(ShareInActivity shareinactivity, com.perfectcorp.utility.j j1)
    {
        shareinactivity.H = j1;
        return j1;
    }

    private void b(x x1)
    {
        A = x1;
        runOnUiThread(new Runnable((TextView)findViewById(j.title)) {

            final TextView a;
            final ShareInActivity b;

            public void run()
            {
                a.setText(Html.fromHtml(com.cyberlink.beautycircle.controller.activity.ShareInActivity.v(b).b).toString());
            }

            
            {
                b = ShareInActivity.this;
                a = textview;
                super();
            }
        });
    }

    static String c(ShareInActivity shareinactivity)
    {
        return shareinactivity.J;
    }

    private void c(x x1)
    {
        B = x1;
        runOnUiThread(new Runnable((TextView)findViewById(j.description)) {

            final TextView a;
            final ShareInActivity b;

            public void run()
            {
                a.setText(Html.fromHtml(ShareInActivity.w(b).b).toString());
            }

            
            {
                b = ShareInActivity.this;
                a = textview;
                super();
            }
        });
    }

    static ShareInXmlParser d(ShareInActivity shareinactivity)
    {
        return shareinactivity.z;
    }

    private void d(x x1)
    {
        runOnUiThread(new Runnable(x1) {

            final x a;
            final ShareInActivity b;

            public void run()
            {
                ShareInActivity.o(b).add(a);
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.x(b).notifyDataSetChanged();
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.i(b);
            }

            
            {
                b = ShareInActivity.this;
                a = x1;
                super();
            }
        });
    }

    static com.cyberlink.beautycircle.view.widgetpool.common.g e(ShareInActivity shareinactivity)
    {
        return shareinactivity.N;
    }

    static ShareInParam f(ShareInActivity shareinactivity)
    {
        return shareinactivity.K;
    }

    private com.perfectcorp.utility.j f(String s1)
    {
        return (new com.perfectcorp.utility.j(s1) {

            final String a;
            final ShareInActivity b;

            protected CircleBasic a(Void void1)
            {
                Object obj;
                Long long1;
                obj = null;
                long1 = AccountManager.c();
                if (a == null || long1 == null) goto _L2; else goto _L1
_L1:
                void1 = (d)NetworkCircle.a(long1.longValue(), long1.longValue()).d();
                if (void1 == null)
                {
                    break MISSING_BLOCK_LABEL_50;
                }
                if (((d) (void1)).b != null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                a(0x80000003);
                return null;
                CircleType circletype = (CircleType)CircleType.a(a).d();
                if (circletype == null) goto _L4; else goto _L3
_L3:
                Object obj1 = circletype.id;
_L19:
                Iterator iterator = ((d) (void1)).b.iterator();
                void1 = null;
_L18:
                if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
                CircleBasic circlebasic = (CircleBasic)iterator.next();
                if (circlebasic == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (circlebasic.defaultType == null || !circlebasic.defaultType.equals(a)) goto _L8; else goto _L7
_L7:
                void1 = ((Void) (obj));
                obj = circlebasic;
                  goto _L9
_L8:
                if (obj1 == null) goto _L11; else goto _L10
_L10:
                if (circlebasic.circleTypeId == null) goto _L11; else goto _L12
_L12:
                boolean flag = circlebasic.circleTypeId.equals(obj1);
                if (!flag) goto _L11; else goto _L13
_L13:
                obj = void1;
                void1 = circlebasic;
                  goto _L9
_L6:
                if (void1 != null)
                {
                    obj = void1;
                }
                if (obj != null || circletype == null) goto _L15; else goto _L14
_L14:
                void1 = (CircleBasic)((d)NetworkCircle.a(((com.cyberlink.beautycircle.model.network.NetworkCircle.CreateCircleResult)NetworkCircle.a(AccountManager.b(), circletype.circleTypeName, null, circletype.id, Boolean.valueOf(false)).d()).circleId, long1, long1).d()).b.get(0);
_L17:
                return void1;
                obj;
                void1 = null;
_L16:
                ((Exception) (obj)).printStackTrace();
                a(0x80000001);
                continue; /* Loop/switch isn't completed */
                obj;
                continue; /* Loop/switch isn't completed */
                obj1;
                void1 = ((Void) (obj));
                obj = obj1;
                if (true) goto _L16; else goto _L15
_L15:
                void1 = ((Void) (obj));
                continue; /* Loop/switch isn't completed */
_L11:
                Void void2 = void1;
                void1 = ((Void) (obj));
                obj = void2;
                break; /* Loop/switch isn't completed */
_L2:
                void1 = null;
                if (true) goto _L17; else goto _L9
_L9:
                Object obj2 = obj;
                obj = void1;
                void1 = ((Void) (obj2));
                if (true) goto _L18; else goto _L4
_L4:
                obj1 = null;
                  goto _L19
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                b = ShareInActivity.this;
                a = s1;
                super();
            }
        }).d(null);
    }

    static TextView g(ShareInActivity shareinactivity)
    {
        return shareinactivity.k;
    }

    static UICImageView h(ShareInActivity shareinactivity)
    {
        return shareinactivity.l;
    }

    static void i(ShareInActivity shareinactivity)
    {
        shareinactivity.o();
    }

    static boolean j(ShareInActivity shareinactivity)
    {
        return shareinactivity.x;
    }

    static boolean k(ShareInActivity shareinactivity)
    {
        return shareinactivity.e();
    }

    static int l(ShareInActivity shareinactivity)
    {
        return shareinactivity.D;
    }

    static int m(ShareInActivity shareinactivity)
    {
        int i1 = shareinactivity.D - 1;
        shareinactivity.D = i1;
        return i1;
    }

    static void n(ShareInActivity shareinactivity)
    {
        shareinactivity.u();
    }

    static ArrayList o(ShareInActivity shareinactivity)
    {
        return shareinactivity.C;
    }

    private void o()
    {
        Object obj = findViewById(j.bc_sharein_main_page);
        View view = findViewById(j.bc_sharein_sub_page);
        int i1;
        if (obj != null)
        {
            if (!x)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            ((View) (obj)).setVisibility(i1);
        }
        if (view != null)
        {
            if (x)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        if (m != null)
        {
            obj = m;
            if (x)
            {
                i1 = i.bc_share_in_back;
            } else
            {
                i1 = i.bc_share_in_exit;
            }
            ((ImageView) (obj)).setImageResource(i1);
        }
        if (v != null)
        {
            obj = v;
            if (x)
            {
                i1 = m.bc_sharein_circle_pick_circle;
            } else
            {
                i1 = m.bc_sharein_circle_title;
            }
            ((TextView) (obj)).setText(i1);
        }
        if (n != null)
        {
            if (x || C.size() == 0)
            {
                n.setVisibility(8);
            } else
            {
                n.setVisibility(0);
            }
        }
        if (D == -1 && !C.isEmpty())
        {
            D = 0;
            u();
        }
        p();
    }

    static int p(ShareInActivity shareinactivity)
    {
        int i1 = shareinactivity.D + 1;
        shareinactivity.D = i1;
        return i1;
    }

    private void p()
    {
        View view = o;
        int i1;
        if (D > 0)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        view.setVisibility(i1);
        view = p;
        if (D < C.size() - 1)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        view.setVisibility(i1);
        if (D >= 0 && D < C.size())
        {
            q.setText((new StringBuilder()).append(D + 1).append(" / ").append(C.size()).toString());
            s.setVisibility(0);
            Object obj = (x)C.get(D);
            if (t != null)
            {
                String s1 = String.format(Locale.getDefault(), "%d x %d", new Object[] {
                    Integer.valueOf(((x) (obj)).c.getWidth()), Integer.valueOf(((x) (obj)).c.getHeight())
                });
                t.setText(s1);
                t.setVisibility(0);
            }
            if (u != null)
            {
                String s3 = "[null]";
                String s4 = "[null]";
                String s2 = s3;
                if (A != null)
                {
                    s2 = s3;
                    if (A.d != null)
                    {
                        s2 = A.d;
                    }
                }
                s3 = s4;
                if (B != null)
                {
                    s3 = s4;
                    if (B.d != null)
                    {
                        s3 = B.d;
                    }
                }
                if (obj != null)
                {
                    Locale locale = Locale.getDefault();
                    i1 = ((x) (obj)).c.getWidth();
                    int j1 = ((x) (obj)).c.getHeight();
                    String s5;
                    if (((x) (obj)).d != null)
                    {
                        s5 = ((x) (obj)).d;
                    } else
                    {
                        s5 = "[null]";
                    }
                    if (((x) (obj)).b != null)
                    {
                        obj = ((x) (obj)).b;
                    } else
                    {
                        obj = "[null]";
                    }
                    s2 = String.format(locale, "<b>TitleSrc: %s, DescSrc: %s<br>Image: %d x %d (%s)</b><br><small>%s</small>", new Object[] {
                        s2, s3, Integer.valueOf(i1), Integer.valueOf(j1), s5, obj
                    });
                    u.setText(Html.fromHtml(s2));
                }
            }
            return;
        } else
        {
            q.setText("");
            s.setVisibility(4);
            return;
        }
    }

    static TreeSet q(ShareInActivity shareinactivity)
    {
        return shareinactivity.I;
    }

    private void q()
    {
        if (E != null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Try to cancle upload promise task"
            });
            E.a(true);
            E = null;
        }
        r();
    }

    private void r()
    {
        if (F != null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Try to cancle upload cover ori task"
            });
            F.a(true);
            F = null;
        }
    }

    static boolean r(ShareInActivity shareinactivity)
    {
        return shareinactivity.e();
    }

    static android.content.DialogInterface.OnClickListener s(ShareInActivity shareinactivity)
    {
        return shareinactivity.P;
    }

    private void s()
    {
        if (G != null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Try to cancle create post promise task"
            });
            G.a(true);
            G = null;
        }
        t();
    }

    private void t()
    {
        if (H != null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Try to cancle create post task"
            });
            H.a(true);
            H = null;
        }
    }

    static void t(ShareInActivity shareinactivity)
    {
        shareinactivity.q();
    }

    private void u()
    {
        r.setCurrentItem(D, true);
        p();
    }

    static void u(ShareInActivity shareinactivity)
    {
        shareinactivity.s();
    }

    static x v(ShareInActivity shareinactivity)
    {
        return shareinactivity.A;
    }

    private void v()
    {
        G = (new com.perfectcorp.utility.j() {

            final ShareInActivity a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                void1 = AccountManager.b();
                if (void1 == null)
                {
                    DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
                    a.l();
                } else
                {
                    Post post = new Post();
                    post.circleIds = new ArrayList();
                    CircleBasic circlebasic;
                    for (Iterator iterator = ShareInActivity.q(a).iterator(); iterator.hasNext(); post.circleIds.add(circlebasic.id))
                    {
                        circlebasic = (CircleBasic)iterator.next();
                    }

                    post.title = ((TextView)a.findViewById(j.title)).getText().toString();
                    post.content = ((TextView)a.findViewById(j.description)).getText().toString();
                    post.attachments = new com.cyberlink.beautycircle.model.PostBase.PostAttachments();
                    post.attachments.files = new ArrayList();
                    post.attachments.files.add(ShareInActivity.B(a));
                    if (c())
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "The promise task is cancelled."
                        });
                        return null;
                    }
                    com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a, NetworkPost.a(void1, ShareInActivity.D(a), post, null));
                    if (ShareInActivity.E(a) != null)
                    {
                        ShareInActivity.E(a).a(new com.perfectcorp.utility.m(this) {

                            final _cls11 a;

                            public void a()
                            {
                                com.perfectcorp.utility.e.b(new Object[] {
                                    "The create post is canceled."
                                });
                            }

                            public void a(int i1)
                            {
                                com.perfectcorp.utility.e.e(new Object[] {
                                    Integer.valueOf(i1)
                                });
                                a.a.l();
                                ShareInActivity.a(a.a, m.bc_write_post_message_create_post_fail, null);
                            }

                            protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult createpostsresult)
                            {
                                if (!c())
                                {
                                    com.perfectcorp.utility.e.b(new Object[] {
                                        "The create post is finish."
                                    });
                                    a.a.a(m.bc_sharein_dialog_title, Float.valueOf(1.0F), com.cyberlink.beautycircle.controller.activity.ShareInActivity.s(a.a), new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.j("external"));
                                            t.b.a();
                                            a.a.a.l();
                                            if (ShareInActivity.f(a.a.a) != null)
                                            {
                                                Globals.a(a.a.a.getResources().getString(m.bc_sharein_success));
                                                com.cyberlink.beautycircle.c.a(a.a.a, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.b);
                                            }
                                            a.a.a.setResult(-1);
                                            a.a.a.finish();
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                    return;
                                } else
                                {
                                    com.perfectcorp.utility.e.b(new Object[] {
                                        "The create post is canceled. Don't show progress animation."
                                    });
                                    a.a.finish();
                                    return;
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)obj);
                            }

            
            {
                a = _pcls11;
                super();
            }
                        });
                        return null;
                    }
                }
                return null;
            }

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Cancel create post promise task"
                });
                ShareInActivity.F(a);
            }

            public void a(int i1)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    Integer.valueOf(i1)
                });
                a.l();
                ShareInActivity.a(a, m.bc_write_post_message_create_post_fail, null);
            }

            
            {
                a = ShareInActivity.this;
                super();
            }
        }).d(null);
    }

    static x w(ShareInActivity shareinactivity)
    {
        return shareinactivity.B;
    }

    static PagerAdapter x(ShareInActivity shareinactivity)
    {
        return shareinactivity.Q;
    }

    static void y(ShareInActivity shareinactivity)
    {
        shareinactivity.p();
    }

    static Uri z(ShareInActivity shareinactivity)
    {
        return shareinactivity.y;
    }

    public void a(aa aa1)
    {
        Runnable runnable = null;
        findViewById(j.image_loading_cursor).setVisibility(8);
        if (e.a)
        {
            ((TextView)findViewById(j.developer_log)).setText(aa1.d());
            ((TextView)findViewById(j.developer_log)).setVisibility(0);
        }
        if (C.isEmpty())
        {
            String s1 = getString(m.bc_sharein_message_no_photo);
            aa1 = s1;
            if (e.a)
            {
                aa1 = (new StringBuilder()).append(s1).append(String.format(Locale.getDefault(), "\n\nTitle(%d), Desc(%d), Image(%d)", new Object[] {
                    Integer.valueOf(z.a()), Integer.valueOf(z.b()), Integer.valueOf(z.c())
                })).append(String.format("\nMax Image(%dx%d)", new Object[] {
                    Integer.valueOf(z.d()), Integer.valueOf(z.e())
                })).append("\n\n").append(J).toString();
            }
            String s2 = getString(m.bc_sharein_dialog_title);
            if (e.a)
            {
                s1 = getString(m.bc_developer_go_to_web);
            } else
            {
                s1 = null;
            }
            if (e.a)
            {
                runnable = new Runnable() {

                    final ShareInActivity a;

                    public void run()
                    {
                        a.finish();
                        com.cyberlink.beautycircle.c.a(a, Uri.parse(com.cyberlink.beautycircle.controller.activity.ShareInActivity.c(a)));
                    }

            
            {
                a = ShareInActivity.this;
                super();
            }
                };
            }
            DialogUtils.a(this, s2, aa1, s1, runnable, getString(m.bc_dialog_button_ok), new Runnable() {

                final ShareInActivity a;

                public void run()
                {
                    a.finish();
                }

            
            {
                a = ShareInActivity.this;
                super();
            }
            });
        }
    }

    public boolean a(x x1)
    {
        if ("title".equals(x1.a))
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "title:", x1.b
            });
            b(x1);
        } else
        {
            if ("description".equals(x1.a))
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "description:", x1.b
                });
                c(x1);
                return false;
            }
            if ("image".equals(x1.a))
            {
                findViewById(j.no_image_loading_cursor).setVisibility(8);
                if (n != null)
                {
                    n.setVisibility(0);
                }
                d(x1);
                com.perfectcorp.utility.e.b(new Object[] {
                    "image:", x1.b
                });
                return false;
            }
        }
        return false;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_share_in);
        c = false;
        bundle = getIntent();
        String s1 = bundle.getAction();
        if (e.a)
        {
            findViewById(j.bc_sharein_text_info).setVisibility(0);
            u = (TextView)findViewById(j.bc_sharein_imageinfo);
            u.setVisibility(0);
        }
        t = (TextView)findViewById(j.bc_sharein_resolution);
        if ("android.intent.action.SEND".equals(s1))
        {
            L = "browser_app";
            J = com.perfectcorp.utility.u.a(bundle.getStringExtra("android.intent.extra.TEXT"));
            String s2 = bundle.getStringExtra("android.intent.extra.SUBJECT");
            ((TextView)findViewById(j.title)).setText(s2);
        }
        if (J == null)
        {
            L = "ui_webview";
            J = bundle.getStringExtra("ShareInUrl");
        }
        K = (ShareInParam)bundle.getSerializableExtra("ShareInParam");
        w = (CircleList)findViewById(j.circle_list);
        w.setEventListener(N);
        if (J != null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("[ShareIN]").append(J).toString()
            });
            y = Uri.parse(J);
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

                final ShareInActivity a;

                public void a()
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            DialogUtils.a(a.a, a.a.getString(m.bc_sharein_dialog_title), a.a.getString(m.bc_user_log_in_description), new Runnable(this) {

                                final _cls2 a;

                                public void run()
                                {
                                    a.a.a.finish();
                                }

            
            {
                a = _pcls2;
                super();
            }
                            });
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

                public void a(String s3)
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            ShareInActivity.a(a.a).a(true);
                            ShareInActivity.a(a.a, new WebView(a.a));
                            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(1920, 1080);
                            com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a).setLayoutParams(layoutparams);
                            ((ViewGroup)a.a.findViewById(j.bc_sharein_background)).addView(com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a));
                            com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a).setTranslationY(-1080F);
                            ShareInActivity.a(a.a, new ShareInXmlParser(a.a, a.a, com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a)));
                            com.cyberlink.beautycircle.controller.activity.ShareInActivity.d(a.a).a(com.cyberlink.beautycircle.controller.activity.ShareInActivity.c(a.a), false);
                            a.a.findViewById(j.no_image_loading_cursor).setVisibility(0);
                            a.a.findViewById(j.image_loading_cursor).setVisibility(0);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

                public void b()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Sign in abort"
                    });
                    a.finish();
                }

            
            {
                a = ShareInActivity.this;
                super();
            }
            });
        } else
        if (K != null)
        {
            AccountManager.a(this, 2, new com.cyberlink.beautycircle.utility.b() {

                final ShareInActivity a;

                public void a()
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            DialogUtils.a(a.a, a.a.getString(m.bc_sharein_dialog_title), a.a.getString(m.bc_user_log_in_description), new Runnable(this) {

                                final _cls3 a;

                                public void run()
                                {
                                    a.a.a.finish();
                                }

            
            {
                a = _pcls3;
                super();
            }
                            });
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                }

                public void a(String s3)
                {
                    ShareInActivity.a(a, Float.valueOf(0.0F));
                    ShareInActivity.a(a, ShareInActivity.f(a).categoryType).a(new l(this) {

                        final _cls12 a;

                        protected void a()
                        {
                            a.a.l();
                            super.a();
                        }

                        protected void a(int i1)
                        {
                            a.a.l();
                            ShareInActivity.a(a.a, m.bc_write_post_message_create_post_fail, null);
                            super.a(i1);
                        }

                        protected void a(CircleBasic circlebasic)
                        {
                            if (circlebasic == null)
                            {
                                b(0x80000003);
                                return;
                            }
                            TreeSet treeset = new TreeSet();
                            treeset.add(circlebasic);
                            com.cyberlink.beautycircle.controller.activity.ShareInActivity.e(a.a).a(treeset);
                            if (ShareInActivity.f(a.a).imageUri != null)
                            {
                                circlebasic = Uri.parse(ShareInActivity.f(a.a).imageUri);
                            } else
                            {
                                circlebasic = null;
                            }
                            if (circlebasic != null)
                            {
                                ShareInActivity.a(a.a, Float.valueOf(0.125F));
                                ShareInActivity.a(a.a, circlebasic);
                                return;
                            } else
                            {
                                a.a.l();
                                b(0x80000003);
                                return;
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((CircleBasic)obj);
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                    s3 = (TextView)a.findViewById(j.title);
                    TextView textview = (TextView)a.findViewById(j.description);
                    a.runOnUiThread(new Runnable(this, s3, textview) {

                        final TextView a;
                        final TextView b;
                        final _cls12 c;

                        public void run()
                        {
                            a.setText(ShareInActivity.f(c.a).title);
                            b.setText(ShareInActivity.f(c.a).description);
                        }

            
            {
                c = _pcls12;
                a = textview;
                b = textview1;
                super();
            }
                    });
                }

                public void b()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Sign in abort"
                    });
                    a.finish();
                }

            
            {
                a = ShareInActivity.this;
                super();
            }
            });
        } else
        {
            runOnUiThread(new Runnable() {

                final ShareInActivity a;

                public void run()
                {
                    DialogUtils.a(a, a.getString(m.bc_dialog_title_warning), a.getString(m.bc_error_empty_data), new Runnable(this) {

                        final _cls17 a;

                        public void run()
                        {
                            a.a.finish();
                        }

            
            {
                a = _pcls17;
                super();
            }
                    });
                }

            
            {
                a = ShareInActivity.this;
                super();
            }
            });
            return;
        }
        bundle = findViewById(j.bc_sharein_background);
        if (bundle != null)
        {
            bundle.setOnClickListener(e);
        }
        bundle = findViewById(j.bc_sharein_dialog);
        if (bundle != null && K != null)
        {
            bundle.setVisibility(8);
        }
        o = findViewById(j.bc_sharein_left_photo);
        if (o != null)
        {
            o.setOnClickListener(f);
        }
        p = findViewById(j.bc_sharein_right_photo);
        if (p != null)
        {
            p.setOnClickListener(g);
        }
        n = (ImageView)findViewById(j.bc_sharein_accept);
        if (n != null)
        {
            n.setOnClickListener(j);
        }
        m = (ImageView)findViewById(j.bc_sharein_btn);
        if (m != null)
        {
            m.setOnClickListener(h);
        }
        v = (TextView)findViewById(j.bc_sharein_dialog_title);
        q = (TextView)findViewById(j.image_count);
        s = findViewById(j.bc_sharein_count_info);
        if (e.a && s != null)
        {
            s.setOnLongClickListener(i);
        }
        r = (ViewPager)findViewById(j.bc_sharein_cover_photo_pager);
        r.setAdapter(Q);
        r.setOnPageChangeListener(R);
        bundle = findViewById(j.bc_sharein_circle);
        if (bundle != null)
        {
            bundle.setOnClickListener(O);
        }
        k = (TextView)findViewById(j.bc_goto_right_text);
        l = (UICImageView)findViewById(j.bc_sharein_selected_category_icon);
        o();
        com.perfectcorp.a.b.a(new g("external"));
    }

    public void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        if (z != null)
        {
            z.f();
            z = null;
        }
        q();
        super.onDestroy();
    }

    protected void onPause()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onStart();
    }

    private class ShareInParam
        implements Serializable
    {

        public String categoryType;
        public String description;
        public String imageUri;
        public String title;

        public ShareInParam()
        {
        }
    }

}
