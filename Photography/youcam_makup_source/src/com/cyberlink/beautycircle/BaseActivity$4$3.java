// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.animation.DecelerateInterpolator;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class a
    implements android.animation.Listener
{

    final a a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (a.a != null)
        {
            a.a.run();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ner(ner ner)
    {
        a = ner;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/BaseActivity$4

/* anonymous class */
    class BaseActivity._cls4
        implements Runnable
    {

        final Float a;
        final int b;
        final android.content.DialogInterface.OnClickListener c;
        final Runnable d;
        final BaseActivity e;

        public void run()
        {
            if (BaseActivity.a(e) != null)
            {
                ObjectAnimator objectanimator;
                boolean flag;
                boolean flag1;
                if (a != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!((ProgressDialog)BaseActivity.a(e)).isIndeterminate())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1 ^ flag)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "dismiss current ProgressDialog"
                    });
                    BaseActivity.a(e).dismiss();
                    BaseActivity.a(e, null);
                }
            }
            if (BaseActivity.a(e) == null)
            {
                BaseActivity.a(e, new ProgressDialog(e));
                ((ProgressDialog)BaseActivity.a(e)).setMessage(e.getString(b));
                BaseActivity.a(e).setOnDismissListener(new BaseActivity._cls4._cls1());
                if (a != null)
                {
                    ((ProgressDialog)BaseActivity.a(e)).setIndeterminate(false);
                    ((ProgressDialog)BaseActivity.a(e)).setProgressStyle(1);
                    ((ProgressDialog)BaseActivity.a(e)).setProgressNumberFormat(null);
                } else
                {
                    ((ProgressDialog)BaseActivity.a(e)).setIndeterminate(true);
                    ((ProgressDialog)BaseActivity.a(e)).setProgressStyle(0);
                }
                if (c != null)
                {
                    BaseActivity.a(e).setCancelable(true);
                    ((ProgressDialog)BaseActivity.a(e)).setButton(-2, e.getResources().getText(0x1040000), c);
                    BaseActivity.a(e).setOnCancelListener(new BaseActivity._cls4._cls2());
                } else
                {
                    BaseActivity.a(e).setCancelable(false);
                }
                ((ProgressDialog)BaseActivity.a(e)).setMax(10000);
                BaseActivity.a(e).show();
            }
            if (a != null)
            {
                objectanimator = ObjectAnimator.ofInt(BaseActivity.a(e), "progress", new int[] {
                    (int)(10000F * a.floatValue())
                }).setDuration(1000L);
                objectanimator.addListener(new BaseActivity._cls4._cls3(this));
                objectanimator.setInterpolator(new DecelerateInterpolator());
                objectanimator.start();
            }
        }

            
            {
                e = baseactivity;
                a = float1;
                b = i;
                c = onclicklistener;
                d = runnable;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/BaseActivity$4$1

/* anonymous class */
        class BaseActivity._cls4._cls1
            implements android.content.DialogInterface.OnDismissListener
        {

            final BaseActivity._cls4 a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                BaseActivity.a(a.e, null);
            }

                    
                    {
                        a = BaseActivity._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/BaseActivity$4$2

/* anonymous class */
        class BaseActivity._cls4._cls2
            implements android.content.DialogInterface.OnCancelListener
        {

            final BaseActivity._cls4 a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.c.onClick(BaseActivity.a(a.e), -2);
            }

                    
                    {
                        a = BaseActivity._cls4.this;
                        super();
                    }
        }

    }

}
