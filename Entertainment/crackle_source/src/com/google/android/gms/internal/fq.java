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
//            fg, fl, fn

public class fq
{
    public static final class a
    {

        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder uJ;
        public int uK;

        public Bundle _mthdo()
        {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", gravity);
            bundle.putInt("popupLocationInfo.displayId", uK);
            bundle.putInt("popupLocationInfo.left", left);
            bundle.putInt("popupLocationInfo.top", top);
            bundle.putInt("popupLocationInfo.right", right);
            bundle.putInt("popupLocationInfo.bottom", bottom);
            return bundle;
        }

        private a(int i, IBinder ibinder)
        {
            uK = -1;
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
            gravity = i;
            uJ = ibinder;
        }

    }

    private static final class b extends fq
        implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private boolean tT;
        private WeakReference uL;

        private void f(View view)
        {
            int j = -1;
            int i = j;
            if (fg.cI())
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
            uI.uK = i;
            uI.uJ = ibinder;
            uI.left = ai[0];
            uI.top = ai[1];
            uI.right = ai[0] + j;
            uI.bottom = ai[1] + k;
            if (tT)
            {
                dl();
                tT = false;
            }
        }

        protected void aF(int i)
        {
            uI = new a(i, null);
        }

        public void dl()
        {
            if (uI.uJ != null)
            {
                dl();
                return;
            }
            boolean flag;
            if (uL != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            tT = flag;
        }

        public void e(View view)
        {
            te.df();
            if (uL != null)
            {
                View view1 = (View)uL.get();
                android.content.Context context1 = te.getContext();
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
                    if (fg.cH())
                    {
                        ((ViewTreeObserver) (obj)).removeOnGlobalLayoutListener(this);
                    } else
                    {
                        ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(this);
                    }
                }
            }
            uL = null;
            context = te.getContext();
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
                    fn.c("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                    obj = view;
                }
            }
            if (obj != null)
            {
                f(((View) (obj)));
                uL = new WeakReference(obj);
                ((View) (obj)).addOnAttachStateChangeListener(this);
                ((View) (obj)).getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            } else
            {
                fn.d("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
        }

        public void onGlobalLayout()
        {
            View view;
            if (uL != null)
            {
                if ((view = (View)uL.get()) != null)
                {
                    f(view);
                    return;
                }
            }
        }

        public void onViewAttachedToWindow(View view)
        {
            f(view);
        }

        public void onViewDetachedFromWindow(View view)
        {
            te.df();
            view.removeOnAttachStateChangeListener(this);
        }

        protected b(fl fl1, int i)
        {
            super(fl1, i, null);
            tT = false;
        }
    }


    protected fl te;
    protected a uI;

    private fq(fl fl1, int i)
    {
        te = fl1;
        aF(i);
    }


    public static fq a(fl fl1, int i)
    {
        if (fg.cE())
        {
            return new b(fl1, i);
        } else
        {
            return new fq(fl1, i);
        }
    }

    protected void aF(int i)
    {
        uI = new a(i, new Binder());
    }

    public void dl()
    {
        te.a(uI.uJ, uI._mthdo());
    }

    public Bundle dm()
    {
        return uI._mthdo();
    }

    public IBinder dn()
    {
        return uI.uJ;
    }

    public void e(View view)
    {
    }

    public void setGravity(int i)
    {
        uI.gravity = i;
    }
}
