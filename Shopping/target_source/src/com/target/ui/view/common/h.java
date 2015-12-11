// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.f.a.c.d;
import com.f.a.f;
import com.google.a.a.e;
import com.target.ui.util.a;
import java.lang.ref.WeakReference;

// Referenced classes of package com.target.ui.view.common:
//            g

public class h extends g
{
    protected class a extends d
    {

        final h this$0;

        public void a(f f1)
        {
            com.target.ui.view.common.h.a(h.this);
            if (mViewReference == null || h.b(h.this))
            {
                return;
            } else
            {
                com.target.ui.view.common.h.a(h.this, (View)mViewReference.get(), f1.getHeight());
                return;
            }
        }

        public void d(f f1)
        {
            h.c(h.this);
            if (mViewReference == null || com.target.ui.view.common.h.d(h.this) > 0)
            {
                return;
            } else
            {
                h.b(h.this, (View)mViewReference.get(), f1.getHeight());
                return;
            }
        }

        protected a()
        {
            this$0 = h.this;
            super();
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void b();
    }


    public static final long TALK_BACK_SNACKBAR_DURATION = 15000L;
    private String mContentDescription;
    private final int mDefaultActionColor;
    private boolean mIsAnimated;
    private int mSnackBarCounter;
    protected WeakReference mViewReference;

    public h(Activity activity)
    {
        this(activity, activity.getResources().getColor(0x7f0f00fd));
    }

    public h(Activity activity, int i)
    {
        super(activity);
        mSnackBarCounter = 0;
        mDefaultActionColor = i;
    }

    static int a(h h1)
    {
        int i = h1.mSnackBarCounter;
        h1.mSnackBarCounter = i + 1;
        return i;
    }

    private void a(View view, int i)
    {
        if (view == null)
        {
            return;
        } else
        {
            int j = view.getResources().getDimensionPixelSize(0x7f0a0176);
            view.animate().setListener(new AnimatorListenerAdapter() {

                final h this$0;

                public void onAnimationStart(Animator animator)
                {
                    com.target.ui.view.common.h.a(h.this, true);
                }

            
            {
                this$0 = h.this;
                super();
            }
            });
            view.animate().yBy(-(j + i)).start();
            return;
        }
    }

    private void a(f f1)
    {
        if (mContentDescription == null)
        {
            return;
        } else
        {
            f1.setContentDescription(mContentDescription);
            f1.setFocusable(true);
            f1.setFocusableInTouchMode(true);
            f1.requestFocus();
            return;
        }
    }

    static void a(h h1, View view, int i)
    {
        h1.a(view, i);
    }

    static boolean a(h h1, boolean flag)
    {
        h1.mIsAnimated = flag;
        return flag;
    }

    private void b(View view, int i)
    {
        if (view == null)
        {
            return;
        } else
        {
            int j = view.getResources().getDimensionPixelSize(0x7f0a0176);
            view.animate().setListener(new AnimatorListenerAdapter() {

                final h this$0;

                public void onAnimationEnd(Animator animator)
                {
                    com.target.ui.view.common.h.a(h.this, false);
                }

            
            {
                this$0 = h.this;
                super();
            }
            });
            view.animate().yBy(j + i).start();
            return;
        }
    }

    static void b(h h1, View view, int i)
    {
        h1.b(view, i);
    }

    static boolean b(h h1)
    {
        return h1.mIsAnimated;
    }

    static int c(h h1)
    {
        int i = h1.mSnackBarCounter;
        h1.mSnackBarCounter = i - 1;
        return i;
    }

    private long c()
    {
        if (com.target.ui.util.a.a(((Activity)b().c()).getApplicationContext()))
        {
            return 15000L;
        } else
        {
            return com.f.a.f.a.b.a();
        }
    }

    static int d(h h1)
    {
        return h1.mSnackBarCounter;
    }

    public void a(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            mViewReference = new WeakReference(view);
            return;
        }
    }

    public void a(String s, String s1, int i, final b listener)
    {
        final boolean isActionClicked[] = new boolean[1];
        isActionClicked[0] = false;
        s = a(s);
        e e1 = b();
        if (!s.b() || !e1.b())
        {
            return;
        } else
        {
            ((f)s.c()).b(s1).a(i).a(new com.f.a.c.a() {

                final h this$0;
                final boolean val$isActionClicked[];

                public void a(f f1)
                {
                    isActionClicked[0] = true;
                }

            
            {
                this$0 = h.this;
                isActionClicked = aflag;
                super();
            }
            }).a(new a() {

                final h this$0;
                final boolean val$isActionClicked[];
                final b val$listener;

                public void d(f f1)
                {
                    super.d(f1);
                    if (listener == null)
                    {
                        return;
                    }
                    if (isActionClicked[0])
                    {
                        listener.a();
                        return;
                    } else
                    {
                        listener.b();
                        return;
                    }
                }

            
            {
                this$0 = h.this;
                listener = b1;
                isActionClicked = aflag;
                super();
            }
            }).a(c()).a((Activity)e1.c());
            a((f)s.c());
            return;
        }
    }

    public void a(String s, String s1, b b1)
    {
        a(s, s1, mDefaultActionColor, b1);
    }

    public void b(String s)
    {
        mContentDescription = s;
    }

    public void c(String s)
    {
        s = a(s);
        e e1 = b();
        if (!s.b() || !e1.b())
        {
            return;
        } else
        {
            ((f)s.c()).a(new a()).a((Activity)e1.c());
            return;
        }
    }
}
