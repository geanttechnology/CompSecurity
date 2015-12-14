// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils

class a
    implements android.view.ener
{

    final Dialog a;
    final a b;

    public void onClick(View view)
    {
        if (b.b != null)
        {
            b.b.run();
        }
        a.dismiss();
    }

    a(a a1, Dialog dialog)
    {
        b = a1;
        a = dialog;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/utility/DialogUtils$1

/* anonymous class */
    final class DialogUtils._cls1
        implements Runnable
    {

        final Activity a;
        final String b;
        final String c;
        final Runnable d;
        final String e;
        final Runnable f;
        final boolean g;
        final android.content.DialogInterface.OnDismissListener h;

        public void run()
        {
            if (a.isFinishing())
            {
                return;
            }
            Dialog dialog = new Dialog(a);
            dialog.requestWindowFeature(1);
            dialog.setContentView(k.bc_dialog_prototype);
            ((TextView)dialog.findViewById(j.bc_dialog_desc)).setText(Html.fromHtml(u.d(b)));
            Object obj = (TextView)dialog.findViewById(j.bc_dialog_negative);
            if (obj != null)
            {
                ((TextView) (obj)).setVisibility(8);
                if (c != null)
                {
                    ((TextView) (obj)).setText(c);
                    ((TextView) (obj)).setVisibility(0);
                    ((TextView) (obj)).setOnClickListener(new DialogUtils._cls1._cls1(dialog));
                }
            }
            obj = (TextView)dialog.findViewById(j.bc_dialog_positive);
            if (obj != null)
            {
                ((TextView) (obj)).setVisibility(8);
                if (e != null)
                {
                    ((TextView) (obj)).setText(e);
                    ((TextView) (obj)).setVisibility(0);
                    ((TextView) (obj)).setOnClickListener(new DialogUtils._cls1._cls2(this, dialog));
                }
            }
            obj = new DisplayMetrics();
            a.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            dialog.getWindow().getAttributes().width = ((DisplayMetrics) (obj)).widthPixels;
            dialog.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
            dialog.setCanceledOnTouchOutside(g);
            dialog.setCancelable(g);
            dialog.setOnDismissListener(h);
            dialog.show();
        }

            
            {
                a = activity;
                b = s;
                c = s1;
                d = runnable;
                e = s2;
                f = runnable1;
                g = flag;
                h = ondismisslistener;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/utility/DialogUtils$1$1

/* anonymous class */
        class DialogUtils._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final Dialog a;
            final DialogUtils._cls1 b;

            public void onClick(View view)
            {
                if (b.d != null)
                {
                    b.d.run();
                }
                a.dismiss();
            }

                    
                    {
                        b = DialogUtils._cls1.this;
                        a = dialog;
                        super();
                    }
        }

    }

}
