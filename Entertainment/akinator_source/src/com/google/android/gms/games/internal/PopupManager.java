// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl, GamesLog

public class PopupManager
{
    public static final class PopupLocationInfo
    {

        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzawO;
        public int zzawP;

        public Bundle zzve()
        {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", gravity);
            bundle.putInt("popupLocationInfo.displayId", zzawP);
            bundle.putInt("popupLocationInfo.left", left);
            bundle.putInt("popupLocationInfo.top", top);
            bundle.putInt("popupLocationInfo.right", right);
            bundle.putInt("popupLocationInfo.bottom", bottom);
            return bundle;
        }

        private PopupLocationInfo(int i, IBinder ibinder)
        {
            zzawP = -1;
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
            gravity = i;
            zzawO = ibinder;
        }

    }

    private static final class PopupManagerHCMR1 extends PopupManager
        implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private boolean zzavm;
        private WeakReference zzawQ;

        private void zzp(View view)
        {
            int j = -1;
            int i = j;
            if (zzmx.zzqz())
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
            zzawN.zzawP = i;
            zzawN.zzawO = ibinder;
            zzawN.left = ai[0];
            zzawN.top = ai[1];
            zzawN.right = ai[0] + j;
            zzawN.bottom = ai[1] + k;
            if (zzavm)
            {
                zzvf();
                zzavm = false;
            }
        }

        public void onGlobalLayout()
        {
            View view;
            if (zzawQ != null)
            {
                if ((view = (View)zzawQ.get()) != null)
                {
                    zzp(view);
                    return;
                }
            }
        }

        public void onViewAttachedToWindow(View view)
        {
            zzp(view);
        }

        public void onViewDetachedFromWindow(View view)
        {
            zzawM.zzuT();
            view.removeOnAttachStateChangeListener(this);
        }

        protected void zzfY(int i)
        {
            zzawN = new PopupLocationInfo(i, null);
        }

        public void zzo(View view)
        {
            zzawM.zzuT();
            if (zzawQ != null)
            {
                View view1 = (View)zzawQ.get();
                android.content.Context context1 = zzawM.getContext();
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
                    if (zzmx.zzqy())
                    {
                        ((ViewTreeObserver) (obj)).removeOnGlobalLayoutListener(this);
                    } else
                    {
                        ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(this);
                    }
                }
            }
            zzawQ = null;
            context = zzawM.getContext();
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
                    GamesLog.zzy("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                    obj = view;
                }
            }
            if (obj != null)
            {
                zzp(((View) (obj)));
                zzawQ = new WeakReference(obj);
                ((View) (obj)).addOnAttachStateChangeListener(this);
                ((View) (obj)).getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            } else
            {
                GamesLog.zzz("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
        }

        public void zzvf()
        {
            if (zzawN.zzawO != null)
            {
                zzvf();
                return;
            }
            boolean flag;
            if (zzawQ != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzavm = flag;
        }

        protected PopupManagerHCMR1(GamesClientImpl gamesclientimpl, int i)
        {
            super(gamesclientimpl, i, null);
            zzavm = false;
        }
    }


    protected GamesClientImpl zzawM;
    protected PopupLocationInfo zzawN;

    private PopupManager(GamesClientImpl gamesclientimpl, int i)
    {
        zzawM = gamesclientimpl;
        zzfY(i);
    }


    public static PopupManager zza(GamesClientImpl gamesclientimpl, int i)
    {
        if (zzmx.zzqv())
        {
            return new PopupManagerHCMR1(gamesclientimpl, i);
        } else
        {
            return new PopupManager(gamesclientimpl, i);
        }
    }

    public void setGravity(int i)
    {
        zzawN.gravity = i;
    }

    protected void zzfY(int i)
    {
        zzawN = new PopupLocationInfo(i, new Binder());
    }

    public void zzo(View view)
    {
    }

    public void zzvf()
    {
        zzawM.zza(zzawN.zzawO, zzawN.zzve());
    }

    public Bundle zzvg()
    {
        return zzawN.zzve();
    }

    public IBinder zzvh()
    {
        return zzawN.zzawO;
    }

    public PopupLocationInfo zzvi()
    {
        return zzawN;
    }
}
