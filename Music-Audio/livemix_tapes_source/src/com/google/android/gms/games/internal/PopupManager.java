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
import com.google.android.gms.internal.zzlv;
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
        public IBinder zzauq;
        public int zzaur;

        public Bundle zzuo()
        {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", gravity);
            bundle.putInt("popupLocationInfo.displayId", zzaur);
            bundle.putInt("popupLocationInfo.left", left);
            bundle.putInt("popupLocationInfo.top", top);
            bundle.putInt("popupLocationInfo.right", right);
            bundle.putInt("popupLocationInfo.bottom", bottom);
            return bundle;
        }

        private PopupLocationInfo(int i, IBinder ibinder)
        {
            zzaur = -1;
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
            gravity = i;
            zzauq = ibinder;
        }

    }

    private static final class PopupManagerHCMR1 extends PopupManager
        implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private boolean zzasO;
        private WeakReference zzaus;

        private void zzo(View view)
        {
            int j = -1;
            int i = j;
            if (zzlv.zzpT())
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
            zzaup.zzaur = i;
            zzaup.zzauq = ibinder;
            zzaup.left = ai[0];
            zzaup.top = ai[1];
            zzaup.right = ai[0] + j;
            zzaup.bottom = ai[1] + k;
            if (zzasO)
            {
                zzup();
                zzasO = false;
            }
        }

        public void onGlobalLayout()
        {
            View view;
            if (zzaus != null)
            {
                if ((view = (View)zzaus.get()) != null)
                {
                    zzo(view);
                    return;
                }
            }
        }

        public void onViewAttachedToWindow(View view)
        {
            zzo(view);
        }

        public void onViewDetachedFromWindow(View view)
        {
            zzauo.zzud();
            view.removeOnAttachStateChangeListener(this);
        }

        protected void zzfP(int i)
        {
            zzaup = new PopupLocationInfo(i, null);
        }

        public void zzn(View view)
        {
            zzauo.zzud();
            if (zzaus != null)
            {
                View view1 = (View)zzaus.get();
                android.content.Context context1 = zzauo.getContext();
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
                    if (zzlv.zzpS())
                    {
                        ((ViewTreeObserver) (obj)).removeOnGlobalLayoutListener(this);
                    } else
                    {
                        ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(this);
                    }
                }
            }
            zzaus = null;
            context = zzauo.getContext();
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
                    GamesLog.zzw("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                    obj = view;
                }
            }
            if (obj != null)
            {
                zzo(((View) (obj)));
                zzaus = new WeakReference(obj);
                ((View) (obj)).addOnAttachStateChangeListener(this);
                ((View) (obj)).getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            } else
            {
                GamesLog.zzx("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
        }

        public void zzup()
        {
            if (zzaup.zzauq != null)
            {
                zzup();
                return;
            }
            boolean flag;
            if (zzaus != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzasO = flag;
        }

        protected PopupManagerHCMR1(GamesClientImpl gamesclientimpl, int i)
        {
            super(gamesclientimpl, i, null);
            zzasO = false;
        }
    }


    protected GamesClientImpl zzauo;
    protected PopupLocationInfo zzaup;

    private PopupManager(GamesClientImpl gamesclientimpl, int i)
    {
        zzauo = gamesclientimpl;
        zzfP(i);
    }


    public static PopupManager zza(GamesClientImpl gamesclientimpl, int i)
    {
        if (zzlv.zzpP())
        {
            return new PopupManagerHCMR1(gamesclientimpl, i);
        } else
        {
            return new PopupManager(gamesclientimpl, i);
        }
    }

    public void setGravity(int i)
    {
        zzaup.gravity = i;
    }

    protected void zzfP(int i)
    {
        zzaup = new PopupLocationInfo(i, new Binder());
    }

    public void zzn(View view)
    {
    }

    public void zzup()
    {
        zzauo.zza(zzaup.zzauq, zzaup.zzuo());
    }

    public Bundle zzuq()
    {
        return zzaup.zzuo();
    }

    public IBinder zzur()
    {
        return zzaup.zzauq;
    }

    public PopupLocationInfo zzus()
    {
        return zzaup;
    }
}
