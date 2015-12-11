// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            fr, fx, fz

public class gd
{
    public static final class a
    {

        public IBinder HD;
        public int HE;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        public Bundle fQ()
        {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", gravity);
            bundle.putInt("popupLocationInfo.displayId", HE);
            bundle.putInt("popupLocationInfo.left", left);
            bundle.putInt("popupLocationInfo.top", top);
            bundle.putInt("popupLocationInfo.right", right);
            bundle.putInt("popupLocationInfo.bottom", bottom);
            return bundle;
        }

        private a(int i, IBinder ibinder)
        {
            HE = -1;
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
            gravity = i;
            HD = ibinder;
        }

    }

    private static final class b extends gd
        implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private boolean GA;
        private WeakReference HF;

        private void g(View view)
        {
            int j = -1;
            int i = j;
            if (fr.eO())
            {
                Display display = view.getDisplay();
                i = j;
                if (display != null)
                {
                    i = display.getDisplayId();
                }
            }
            IBinder ibinder = view.getWindowToken();
            int ai[] = new int[2];
            view.getLocationInWindow(ai);
            j = view.getWidth();
            int k = view.getHeight();
            HC.HE = i;
            HC.HD = ibinder;
            HC.left = ai[0];
            HC.top = ai[1];
            HC.right = ai[0] + j;
            HC.bottom = ai[1] + k;
            if (GA)
            {
                fN();
                GA = false;
            }
        }

        protected void aV(int i)
        {
            HC = new a(i, null);
        }

        public void f(View view)
        {
            HB.fH();
            if (HF != null)
            {
                View view1 = (View)HF.get();
                android.content.Context context1 = HB.getContext();
                Object obj = view1;
                if (view1 == null)
                {
                    obj = view1;
                    if (context1 instanceof Activity)
                    {
                        obj = ((Activity)context1).getWindow().getDecorView();
                    }
                }
                if (obj != null)
                {
                    ((View) (obj)).removeOnAttachStateChangeListener(this);
                    obj = ((View) (obj)).getViewTreeObserver();
                    android.content.Context context;
                    if (fr.eN())
                    {
                        ((ViewTreeObserver) (obj)).removeOnGlobalLayoutListener(this);
                    } else
                    {
                        ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(this);
                    }
                }
            }
            HF = null;
            context = HB.getContext();
            obj = view;
            if (view == null)
            {
                obj = view;
                if (context instanceof Activity)
                {
                    obj = ((Activity)context).findViewById(0x1020002);
                    view = ((View) (obj));
                    if (obj == null)
                    {
                        view = ((Activity)context).getWindow().getDecorView();
                    }
                    fz.g("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                    obj = view;
                }
            }
            if (obj != null)
            {
                g(((View) (obj)));
                HF = new WeakReference(obj);
                ((View) (obj)).addOnAttachStateChangeListener(this);
                ((View) (obj)).getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            } else
            {
                fz.h("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
        }

        public void fN()
        {
            if (HC.HD != null)
            {
                fN();
                return;
            }
            boolean flag;
            if (HF != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            GA = flag;
        }

        public void onGlobalLayout()
        {
            View view;
            if (HF != null)
            {
                if ((view = (View)HF.get()) != null)
                {
                    g(view);
                    return;
                }
            }
        }

        public void onViewAttachedToWindow(View view)
        {
            g(view);
        }

        public void onViewDetachedFromWindow(View view)
        {
            HB.fH();
            view.removeOnAttachStateChangeListener(this);
        }

        protected b(fx fx1, int i)
        {
            super(fx1, i, null);
            GA = false;
        }
    }


    protected fx HB;
    protected a HC;

    private gd(fx fx1, int i)
    {
        HB = fx1;
        aV(i);
    }


    public static gd a(fx fx1, int i)
    {
        if (fr.eK())
        {
            return new b(fx1, i);
        } else
        {
            return new gd(fx1, i);
        }
    }

    protected void aV(int i)
    {
        HC = new a(i, new Binder());
    }

    public void f(View view)
    {
    }

    public void fN()
    {
        HB.a(HC.HD, HC.fQ());
    }

    public Bundle fO()
    {
        return HC.fQ();
    }

    public IBinder fP()
    {
        return HC.HD;
    }

    public void setGravity(int i)
    {
        HC.gravity = i;
    }
}
