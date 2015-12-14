// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.ProgressDialog;
import android.view.View;
import com.cyberlink.you.c.c;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.r;
import com.cyberlink.you.sticker.StickerFragment;
import com.cyberlink.you.sticker.StickerObj;

// Referenced classes of package com.cyberlink.you.activity:
//            g, e, ChatDialogActivity, c

class a
    implements g
{

    final ProgressDialog a;
    final rPackObj b;

    public void a(StickerPackObj stickerpackobj)
    {
        if (a != null && a.isShowing())
        {
            a.dismiss();
        }
        if (stickerpackobj == null)
        {
            return;
        } else
        {
            e.i().a(stickerpackobj);
            ChatDialogActivity.a(b.b.a, stickerpackobj);
            return;
        }
    }

    Fragment(Fragment fragment, ProgressDialog progressdialog)
    {
        b = fragment;
        a = progressdialog;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/e$5

/* anonymous class */
    class e._cls5
        implements android.view.View.OnClickListener
    {

        final com.cyberlink.you.activity.e a;

        public void onClick(View view)
        {
            view = (Integer)view.getTag();
            if (view != null)
            {
                int i = view.intValue();
                view = a.b(i);
                if (view != null && view.g() != null)
                {
                    view = ChatDialogActivity.b(a.a, view);
                    if (view != null)
                    {
                        long l = view.c();
                        StickerPackObj stickerpackobj = e.i().a(l);
                        if (stickerpackobj != null)
                        {
                            if (stickerpackobj.q() && !stickerpackobj.j().equals(com.cyberlink.you.database.StickerPackObj.Status.a))
                            {
                                if (!ChatDialogActivity.o(a.a).d().isVisible())
                                {
                                    ChatDialogActivity.o(a.a).a(true);
                                }
                                ChatDialogActivity.o(a.a).d().a(view.c());
                                return;
                            } else
                            {
                                ChatDialogActivity.a(a.a, stickerpackobj);
                                return;
                            }
                        } else
                        {
                            view = ProgressDialog.show(ChatDialogActivity.g(a.a), "", a.a.getString(r.u_loading), true);
                            (new com.cyberlink.you.activity.c(a.a, l, new e._cls5._cls1(this, view))).executeOnExecutor(ChatDialogActivity.b, new Void[0]);
                            return;
                        }
                    }
                }
            }
        }

            
            {
                a = e1;
                super();
            }
    }

}
