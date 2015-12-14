// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.zzlv;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.games.internal:
//            PopupManager, GamesClientImpl, GamesLog

private static final class zzasO extends PopupManager
    implements android.view.r, android.view.Listener
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
        android.os.IBinder ibinder = view.getWindowToken();
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
        zzaup = new <init>(i, null, null);
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
            super.zzup();
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

    protected (GamesClientImpl gamesclientimpl, int i)
    {
        super(gamesclientimpl, i, null);
        zzasO = false;
    }
}
