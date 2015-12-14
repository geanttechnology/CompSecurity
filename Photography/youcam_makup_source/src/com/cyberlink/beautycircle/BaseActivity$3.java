// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.animation.DecelerateInterpolator;
import com.cyberlink.beautycircle.view.widgetpool.common.UploadProgressDialog;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class d
    implements Runnable
{

    final Float a;
    final int b;
    final android.content..OnClickListener c;
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
            if (!((UploadProgressDialog)BaseActivity.a(e)).a())
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
            BaseActivity.a(e, new UploadProgressDialog(e));
            ((UploadProgressDialog)BaseActivity.a(e)).a(e.getString(b));
            BaseActivity.a(e).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final BaseActivity._cls3 a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    BaseActivity.a(a.e, null);
                }

            
            {
                a = BaseActivity._cls3.this;
                super();
            }
            });
            if (c != null)
            {
                BaseActivity.a(e).setCancelable(true);
                ((UploadProgressDialog)BaseActivity.a(e)).a(c);
                BaseActivity.a(e).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final BaseActivity._cls3 a;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        a.c.onClick(BaseActivity.a(a.e), 0);
                    }

            
            {
                a = BaseActivity._cls3.this;
                super();
            }
                });
            } else
            {
                BaseActivity.a(e).setCancelable(false);
            }
            ((UploadProgressDialog)BaseActivity.a(e)).a(10000);
            if (!e.isFinishing())
            {
                BaseActivity.a(e).show();
            }
            if (BaseActivity.b(e))
            {
                e.j();
            }
        }
        if (a != null)
        {
            objectanimator = ObjectAnimator.ofInt(BaseActivity.a(e), "Progress", new int[] {
                (int)(10000F * a.floatValue())
            }).setDuration(1000L);
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.addListener(new android.animation.Animator.AnimatorListener() {

                final BaseActivity._cls3 a;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (a.d != null)
                    {
                        a.d.run();
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                a = BaseActivity._cls3.this;
                super();
            }
            });
            objectanimator.start();
        }
    }

    tener(BaseActivity baseactivity, Float float1, int i, android.content..OnClickListener onclicklistener, Runnable runnable)
    {
        e = baseactivity;
        a = float1;
        b = i;
        c = onclicklistener;
        d = runnable;
        super();
    }
}
