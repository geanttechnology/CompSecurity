// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bumptech.glide.request.target:
//            BaseTarget, SizeReadyCallback

public abstract class ViewTarget extends BaseTarget
{
    private static class SizeDeterminer
    {

        private final List cbs = new ArrayList();
        private Point displayDimens;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;

        private void checkCurrentDimens()
        {
            if (!cbs.isEmpty())
            {
                int i = getViewWidthOrParam();
                int j = getViewHeightOrParam();
                if (isSizeValid(i) && isSizeValid(j))
                {
                    notifyCbs(i, j);
                    ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
                    if (viewtreeobserver.isAlive())
                    {
                        viewtreeobserver.removeOnPreDrawListener(layoutListener);
                    }
                    layoutListener = null;
                    return;
                }
            }
        }

        private Point getDisplayDimens()
        {
            if (displayDimens != null)
            {
                return displayDimens;
            }
            Display display = ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
            if (android.os.Build.VERSION.SDK_INT >= 13)
            {
                displayDimens = new Point();
                display.getSize(displayDimens);
            } else
            {
                displayDimens = new Point(display.getWidth(), display.getHeight());
            }
            return displayDimens;
        }

        private int getSizeForParam(int i, boolean flag)
        {
            if (i == -2)
            {
                Point point = getDisplayDimens();
                if (flag)
                {
                    return point.y;
                } else
                {
                    return point.x;
                }
            } else
            {
                return i;
            }
        }

        private int getViewHeightOrParam()
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            if (isSizeValid(view.getHeight()))
            {
                return view.getHeight();
            }
            if (layoutparams != null)
            {
                return getSizeForParam(layoutparams.height, true);
            } else
            {
                return 0;
            }
        }

        private int getViewWidthOrParam()
        {
            int i = 0;
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            if (isSizeValid(view.getWidth()))
            {
                i = view.getWidth();
            } else
            if (layoutparams != null)
            {
                return getSizeForParam(layoutparams.width, false);
            }
            return i;
        }

        private boolean isSizeValid(int i)
        {
            return i > 0 || i == -2;
        }

        private void notifyCbs(int i, int j)
        {
            for (Iterator iterator = cbs.iterator(); iterator.hasNext(); ((SizeReadyCallback)iterator.next()).onSizeReady(i, j)) { }
            cbs.clear();
        }

        public void getSize(SizeReadyCallback sizereadycallback)
        {
            int i = getViewWidthOrParam();
            int j = getViewHeightOrParam();
            if (isSizeValid(i) && isSizeValid(j))
            {
                sizereadycallback.onSizeReady(i, j);
            } else
            {
                if (!cbs.contains(sizereadycallback))
                {
                    cbs.add(sizereadycallback);
                }
                if (layoutListener == null)
                {
                    sizereadycallback = view.getViewTreeObserver();
                    layoutListener = new SizeDeterminerLayoutListener(this);
                    sizereadycallback.addOnPreDrawListener(layoutListener);
                    return;
                }
            }
        }


        public SizeDeterminer(View view1)
        {
            view = view1;
        }
    }

    private static class SizeDeterminer.SizeDeterminerLayoutListener
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        private final WeakReference sizeDeterminerRef;

        public boolean onPreDraw()
        {
            if (Log.isLoggable("ViewTarget", 2))
            {
                Log.v("ViewTarget", (new StringBuilder()).append("OnGlobalLayoutListener called listener=").append(this).toString());
            }
            SizeDeterminer sizedeterminer = (SizeDeterminer)sizeDeterminerRef.get();
            if (sizedeterminer != null)
            {
                sizedeterminer.checkCurrentDimens();
            }
            return true;
        }

        public SizeDeterminer.SizeDeterminerLayoutListener(SizeDeterminer sizedeterminer)
        {
            sizeDeterminerRef = new WeakReference(sizedeterminer);
        }
    }


    private final SizeDeterminer sizeDeterminer;
    protected final View view;

    public ViewTarget(View view1)
    {
        if (view1 == null)
        {
            throw new NullPointerException("View must not be null!");
        } else
        {
            view = view1;
            sizeDeterminer = new SizeDeterminer(view1);
            return;
        }
    }

    public Request getRequest()
    {
label0:
        {
            Object obj = view.getTag();
            Request request = null;
            if (obj != null)
            {
                if (!(obj instanceof Request))
                {
                    break label0;
                }
                request = (Request)obj;
            }
            return request;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(SizeReadyCallback sizereadycallback)
    {
        sizeDeterminer.getSize(sizereadycallback);
    }

    public View getView()
    {
        return view;
    }

    public void setRequest(Request request)
    {
        view.setTag(request);
    }

    public String toString()
    {
        return (new StringBuilder()).append("Target for: ").append(view).toString();
    }
}
