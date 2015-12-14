// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkFeedback;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.g;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PreviewFeedbackActivity

class a extends j
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
                    PreviewFeedbackActivity.b(b).q.add(NetworkFile.a(uri, com.perfectcorp.utility..FeedbackSnapshot));
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
                DialogUtils.a(b, m.bc_feedback_dialog_file_size_excceed);
                return null;
            }
        }
        NetworkFeedback.a(a, PreviewFeedbackActivity.b(b)).a(new com.perfectcorp.utility.m() {

            final PreviewFeedbackActivity._cls3 a;

            protected void a()
            {
                a.b.l();
                super.a();
            }

            protected void a(int i)
            {
                a.b.l();
                super.a(i);
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
                a = PreviewFeedbackActivity._cls3.this;
                super();
            }
        });
        return null;
    }

    _cls1.a(PreviewFeedbackActivity previewfeedbackactivity, String s)
    {
        b = previewfeedbackactivity;
        a = s;
        super();
    }
}
