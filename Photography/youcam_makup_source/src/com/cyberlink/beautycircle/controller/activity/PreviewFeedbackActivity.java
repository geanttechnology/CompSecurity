// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.p;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkFeedback;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.model.network.g;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.i;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.t;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class PreviewFeedbackActivity extends BaseActivity
{

    private com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig e;
    private g f;
    private ArrayList g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ArrayList n;

    public PreviewFeedbackActivity()
    {
        n = new ArrayList();
    }

    static ArrayList a(PreviewFeedbackActivity previewfeedbackactivity)
    {
        return previewfeedbackactivity.g;
    }

    static g b(PreviewFeedbackActivity previewfeedbackactivity)
    {
        return previewfeedbackactivity.f;
    }

    private void b(String s, String s1)
    {
        if (e == null)
        {
            return;
        }
        f = new g(e);
        f.c = "for Android";
        f.d = TimeZone.getDefault().getID();
        f.e = "Android";
        f.f = android.os.Build.VERSION.RELEASE;
        f.h = Locale.getDefault().toString();
        f.i = Build.MODEL;
        f.j = Build.MANUFACTURER;
        f.k = Globals.A();
        f.o = s1;
        f.p = s;
        f.s = String.format("%s %s %s %s", new Object[] {
            Build.BRAND, Build.HARDWARE, Build.PRODUCT, Build.DEVICE
        });
        s1 = f;
        if (t.a())
        {
            s = "Yes";
        } else
        {
            s = "No";
        }
        s1.t = s;
        if (f.q == null)
        {
            f.q = new ArrayList();
        }
        s = new ArrayList();
        if (e != null && e.attachmentPath != null)
        {
            s1 = e.attachmentPath.iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break;
                }
                String s2 = (String)s1.next();
                if (s2 != null)
                {
                    File file = new File(s2);
                    if (file.exists())
                    {
                        s.add(file);
                    } else
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "AttachmentFile not exist: ", s2
                        });
                    }
                }
            } while (true);
        }
        s1 = com.perfectcorp.utility.e.b(false);
        if (s1 != null && e.bNeedLog)
        {
            s.add(new File(s1));
        }
        s1 = (new StringBuilder()).append("").append("version_upgrade_history: ").append(e.versionUpgradeHistory).append("\r\n").toString();
        s1 = (new StringBuilder()).append(s1).append("umaid: ").append(e.umaid).append("\r\n").toString();
        s1 = (new StringBuilder()).append(s1).append("store_name: ").append(getString(m.FN_STORE_NAME)).append("\r\n").toString();
        s1 = (new StringBuilder()).append(s1).append("installed_apps: ").append(t.a(getApplicationContext())).append("\r\n").toString();
        s1 = com.perfectcorp.utility.e.a(false, (new StringBuilder()).append(s1).append("os_upgrade_history: ").append(t.d()).append("\r\n").toString(), "moreinfo.txt");
        if (s1 != null && e.bNeedLog)
        {
            s.add(new File(s1));
        }
        s1 = NetworkManager.e();
        if (s1 != null && e.bNeedLog)
        {
            s.add(new File(s1));
        }
        s1 = t.b(getApplicationContext());
        if (s1 != null && e.bNeedLog)
        {
            Collections.addAll(s, s1);
        }
        com.perfectcorp.utility.e.a(getApplicationContext(), s);
        s = NetworkFile.a(com.perfectcorp.utility.e.d(), null);
        if (s == null)
        {
            com.perfectcorp.utility.e.d(new Object[] {
                "logfile open fail"
            });
            return;
        }
        if (((h) (s)).b < 0x500000L)
        {
            f.q.add(s);
            return;
        } else
        {
            com.perfectcorp.utility.e.d(new Object[] {
                "logfile too large: ", Long.valueOf(((h) (s)).b)
            });
            return;
        }
    }

    static com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig c(PreviewFeedbackActivity previewfeedbackactivity)
    {
        return previewfeedbackactivity.e;
    }

    static boolean d(PreviewFeedbackActivity previewfeedbackactivity)
    {
        return previewfeedbackactivity.e();
    }

    private i o()
    {
        i i1 = new i(this, true);
        n.add(i1);
        ViewGroup viewgroup = (ViewGroup)findViewById(j.bc_feedback_image_panel);
        viewgroup.addView(i1.a(LayoutInflater.from(this), viewgroup, null));
        return i1;
    }

    protected void a(Uri uri)
    {
        Object obj = findViewById(j.preview_image_mask);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(0);
        }
        obj = (ImageView)findViewById(j.preview_image);
        if (obj != null)
        {
            ((ImageView) (obj)).setImageURI(uri);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = 0L;
        setContentView(k.bc_activity_preview_feedback);
        bundle = getIntent();
        e = (com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig)bundle.getSerializableExtra("FeedbackConfig");
        String s = bundle.getStringExtra("FeedbackDesc");
        String s1 = bundle.getStringExtra("FeedbackEmail");
        g = Model.b(android/net/Uri, bundle.getStringExtra("FeedbackImage"));
        int j1 = bundle.getIntExtra("TopBarStyle", 0);
        if (j1 != 0)
        {
            b().a(j1);
        }
        b(m.bc_feedback_preview_title);
        b().a(0xe4000000, x.a, x.h, 0);
        h = (TextView)findViewById(j.bc_feedback_description);
        if (h != null)
        {
            h.setText(s);
        }
        i = (TextView)findViewById(j.bc_feedback_email);
        if (i != null)
        {
            i.setText(s1);
        }
        j = (TextView)findViewById(j.bc_feedback_appver);
        if (j != null)
        {
            bundle = getResources().getString(m.BC_BUILD_NUMBER);
            if (e != null)
            {
                bundle = e.appversion;
            }
            j.setText(bundle);
        }
        k = (TextView)findViewById(j.bc_feedback_devicemodel);
        if (k != null)
        {
            k.setText(Globals.x());
        }
        l = (TextView)findViewById(j.bc_feedback_osver);
        if (l != null)
        {
            l.setText(android.os.Build.VERSION.RELEASE);
        }
        m = (TextView)findViewById(j.bc_feedback_time);
        if (m != null)
        {
            bundle = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ssZ", Locale.US);
            bundle.setTimeZone(TimeZone.getTimeZone("GMT"));
            m.setText(bundle.format(new Date()));
        }
        if ((ViewGroup)findViewById(j.bc_feedback_image_panel) != null && g != null)
        {
            bundle = g.iterator();
            do
            {
                if (!bundle.hasNext())
                {
                    break;
                }
                Uri uri = (Uri)bundle.next();
                if (uri != null)
                {
                    i i1 = o();
                    i1.a(uri, true);
                    i1.a().setOnClickListener(new android.view.View.OnClickListener(uri) {

                        final Uri a;
                        final PreviewFeedbackActivity b;

                        public void onClick(View view)
                        {
                            b.a(a);
                        }

            
            {
                b = PreviewFeedbackActivity.this;
                a = uri;
                super();
            }
                    });
                }
            } while (true);
        }
        bundle = findViewById(j.preview_image_mask);
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final PreviewFeedbackActivity a;

                public void onClick(View view)
                {
                    view.setVisibility(8);
                }

            
            {
                a = PreviewFeedbackActivity.this;
                super();
            }
            });
        }
        b(s, s1);
    }

    public void onResume()
    {
        com.perfectcorp.a.b.a(new p("pageview_preview"));
        super.onResume();
    }

    public void onRightBtnClick(View view)
    {
        if (e == null)
        {
            return;
        } else
        {
            view = e.apiUri;
            com.perfectcorp.a.b.a(new p("click_preview"));
            k();
            (new com.perfectcorp.utility.j(view) {

                final String a;
                final PreviewFeedbackActivity b;

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

                protected Void a(Void void1)
                {
                    if (PreviewFeedbackActivity.a(b) != null && !PreviewFeedbackActivity.a(b).isEmpty())
                    {
                        if (com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b).q == null)
                        {
                            com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b).q = new ArrayList();
                        }
                        void1 = PreviewFeedbackActivity.a(b).iterator();
                        do
                        {
                            if (!void1.hasNext())
                            {
                                break;
                            }
                            Uri uri = (Uri)void1.next();
                            void1.remove();
                            if (uri != null)
                            {
                                com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b).q.add(NetworkFile.a(uri, com.perfectcorp.utility.ImageUtils.CompressSetting.FeedbackSnapshot));
                            }
                        } while (true);
                    }
                    if (com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b).q != null)
                    {
                        void1 = com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b).q.iterator();
                        long l1;
                        for (l1 = 0L; void1.hasNext(); l1 = ((h)void1.next()).b + l1) { }
                        com.perfectcorp.utility.e.c(new Object[] {
                            "Attachment size: ", Long.valueOf(l1)
                        });
                        if (l1 > 0x500000L)
                        {
                            b.l();
                            DialogUtils.a(b, m.bc_feedback_dialog_file_size_excceed);
                            return null;
                        }
                    }
                    NetworkFeedback.a(a, com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity.b(b)).a(new com.perfectcorp.utility.m(this) {

                        final _cls3 a;

                        protected void a()
                        {
                            a.b.l();
                            super.a();
                        }

                        protected void a(int i1)
                        {
                            a.b.l();
                            super.a(i1);
                            Globals.a(a.b.getResources().getString(m.bc_feedback_message_send_fail));
                        }

                        protected void a(com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackResult feedbackresult)
                        {
                            a.b.l();
                            if (feedbackresult != null)
                            {
                                feedbackresult = feedbackresult.status;
                            } else
                            {
                                feedbackresult = "";
                            }
                            if (!"OK".equals(feedbackresult))
                            {
                                a(0x80000001);
                                return;
                            }
                            a.b.setResult(-1);
                            feedbackresult = a.b.getString(m.bc_feedback_title_send_ok);
                            String s = a.b.getString(m.bc_feedback_dialog_send_ok);
                            String s1 = a.b.getString(m.bc_dialog_button_ok);
                            if (PreviewFeedbackActivity.c(a.b).product.equals("BeautyCircle"))
                            {
                                Globals.a(true);
                            }
                            DialogUtils.a(a.b, feedbackresult, s, null, null, s1, null, true, new android.content.DialogInterface.OnDismissListener(this) {

                                final _cls1 a;

                                public void onDismiss(DialogInterface dialoginterface)
                                {
                                    PreviewFeedbackActivity.d(a.a.b);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackResult)obj);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    return null;
                }

            
            {
                b = PreviewFeedbackActivity.this;
                a = s;
                super();
            }
            }).d(null);
            return;
        }
    }
}
