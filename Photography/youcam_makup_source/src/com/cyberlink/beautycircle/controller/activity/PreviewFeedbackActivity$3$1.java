// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkFeedback;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.g;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PreviewFeedbackActivity

class a extends m
{

    final a a;

    protected void a()
    {
        a.a.l();
        super.a();
    }

    protected void a(int i)
    {
        a.a.l();
        super.a(i);
        Globals.a(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_feedback_message_send_fail));
    }

    protected void a(com.cyberlink.beautycircle.model.network.lt lt)
    {
        a.a.l();
        if (lt != null)
        {
            lt = lt.status;
        } else
        {
            lt = "";
        }
        if (!"OK".equals(lt))
        {
            a(0x80000001);
            return;
        }
        a.a.setResult(-1);
        lt = a.a.getString(com.cyberlink.beautycircle.m.bc_feedback_title_send_ok);
        String s = a.a.getString(com.cyberlink.beautycircle.m.bc_feedback_dialog_send_ok);
        String s1 = a.a.getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok);
        if (PreviewFeedbackActivity.c(a.a).product.equals("BeautyCircle"))
        {
            Globals.a(true);
        }
        DialogUtils.a(a.a, lt, s, null, null, s1, null, true, new android.content.DialogInterface.OnDismissListener() {

            final PreviewFeedbackActivity._cls3._cls1 a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                PreviewFeedbackActivity.d(a.a.b);
            }

            
            {
                a = PreviewFeedbackActivity._cls3._cls1.this;
                super();
            }
        });
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.lt)obj);
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PreviewFeedbackActivity$3

/* anonymous class */
    class PreviewFeedbackActivity._cls3 extends j
    {

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
                if (PreviewFeedbackActivity.b(b).q == null)
                {
                    PreviewFeedbackActivity.b(b).q = new ArrayList();
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
                        PreviewFeedbackActivity.b(b).q.add(NetworkFile.a(uri, com.perfectcorp.utility.ImageUtils.CompressSetting.FeedbackSnapshot));
                    }
                } while (true);
            }
            if (PreviewFeedbackActivity.b(b).q != null)
            {
                void1 = PreviewFeedbackActivity.b(b).q.iterator();
                long l;
                for (l = 0L; void1.hasNext(); l = ((h)void1.next()).b + l) { }
                e.c(new Object[] {
                    "Attachment size: ", Long.valueOf(l)
                });
                if (l > 0x500000L)
                {
                    b.l();
                    DialogUtils.a(b, com.cyberlink.beautycircle.m.bc_feedback_dialog_file_size_excceed);
                    return null;
                }
            }
            NetworkFeedback.a(a, PreviewFeedbackActivity.b(b)).a(new PreviewFeedbackActivity._cls3._cls1(this));
            return null;
        }

            
            {
                b = previewfeedbackactivity;
                a = s;
                super();
            }
    }

}
