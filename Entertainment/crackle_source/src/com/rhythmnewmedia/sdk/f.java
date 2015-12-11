// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public abstract class f extends Activity
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a h[];

        static Animation a(a a1)
        {
            static final class _cls3
            {

                static final int a[];

                static 
                {
                    a = new int[a.values().length];
                    try
                    {
                        a[a.c.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[a.d.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[a.e.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[a.f.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[a.g.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3.a[a1.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);

            case 2: // '\002'
                return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);

            case 3: // '\003'
                return new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);

            case 4: // '\004'
                return new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F);

            case 5: // '\005'
                return new AlphaAnimation(0.0F, 1.0F);
            }
        }

        static Animation b(a a1)
        {
            switch (_cls3.a[a1.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1F);

            case 2: // '\002'
                return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);

            case 3: // '\003'
                return new TranslateAnimation(2, 0.0F, 2, -1F, 2, 0.0F, 2, 0.0F);

            case 4: // '\004'
                return new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);

            case 5: // '\005'
                return new AlphaAnimation(1.0F, 0.0F);
            }
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/rhythmnewmedia/sdk/f$a, s);
        }

        public static a[] values()
        {
            return (a[])h.clone();
        }

        static 
        {
            a = new a("system", 0);
            b = new a("none", 1);
            c = new a("slideUp", 2);
            d = new a("slideDown", 3);
            e = new a("slideLeft", 4);
            f = new a("slideRight", 5);
            g = new a("fade", 6);
            h = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface b
    {

        public abstract void b();
    }


    private boolean a;
    protected View contentView;
    protected a entryTransition;
    protected a exitTransition;
    protected int transitionDuration;

    public f()
    {
        entryTransition = a.c;
        exitTransition = a.d;
        transitionDuration = 500;
        a = false;
    }

    private void a()
    {
        Method method = null;
        Object obj;
        obj = Integer.TYPE;
        Class class1 = Integer.TYPE;
        obj = Class.forName("android.app.Activity").getDeclaredMethod("overridePendingTransition", new Class[] {
            obj, class1
        });
        method = ((Method) (obj));
_L2:
        super.finish();
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        method.invoke(this, new Object[] {
            Integer.valueOf(0), Integer.valueOf(0)
        });
        return;
        Exception exception;
        exception;
        return;
        Exception exception1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void a(f f1)
    {
        f1.a();
    }

    public void finish()
    {
        boolean flag = true;
        if (!a) goto _L2; else goto _L1
_L1:
        return;
_L2:
        a = true;
        if (exitTransition == a.a)
        {
            super.finish();
            return;
        }
        Object obj;
        obj = Integer.TYPE;
        Class class1 = Integer.TYPE;
        obj = Class.forName("android.app.Activity").getDeclaredMethod("overridePendingTransition", new Class[] {
            obj, class1
        });
        if (obj == null)
        {
            flag = false;
        }
_L4:
        if (flag)
        {
            Animation animation = a.b(exitTransition);
            Exception exception;
            if (animation != null)
            {
                animation.setDuration(transitionDuration);
                animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final f a;

                    public final void onAnimationEnd(Animation animation1)
                    {
                        f.a(a);
                    }

                    public final void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public final void onAnimationStart(Animation animation1)
                    {
                    }

            
            {
                a = f.this;
                super();
            }
                });
                contentView.startAnimation(animation);
                return;
            } else
            {
                a();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        super.finish();
        flag = false;
          goto _L4
    }

    protected abstract View getContentView();

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        contentView = getContentView();
        bundle = a.a(entryTransition);
        if (bundle != null)
        {
            FrameLayout framelayout = new FrameLayout(this);
            framelayout.setBackgroundColor(0);
            setContentView(framelayout);
            if (contentView != null)
            {
                framelayout.addView(contentView);
                bundle.setDuration(transitionDuration);
                if (contentView instanceof b)
                {
                    bundle.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                        final f a;

                        public final void onAnimationEnd(Animation animation)
                        {
                            ((b)a.contentView).b();
                        }

                        public final void onAnimationRepeat(Animation animation)
                        {
                        }

                        public final void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                a = f.this;
                super();
            }
                    });
                }
                contentView.startAnimation(bundle);
            }
        } else
        {
            setContentView(contentView);
            if (contentView instanceof b)
            {
                ((b)contentView).b();
                return;
            }
        }
    }

    public void setEntryTransition(a a1)
    {
        entryTransition = a1;
    }

    public void setExitTransition(a a1)
    {
        exitTransition = a1;
    }

    public void setTransitionDuration(int i)
    {
        transitionDuration = i;
    }
}
