// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util;

import android.util.Log;
import android.view.View;
import it.sephiroth.android.library.util.v14.ViewHelper14;
import it.sephiroth.android.library.util.v16.ViewHelper16;

public class ViewHelperFactory
{
    public static abstract class ViewHelper
    {

        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected ViewHelper(View view1)
        {
            view = view1;
        }
    }

    public static class ViewHelperDefault extends ViewHelper
    {

        public boolean isHardwareAccelerated()
        {
            return false;
        }

        public void postOnAnimation(Runnable runnable)
        {
            view.post(runnable);
        }

        public void setScrollX(int i)
        {
            Log.d("ViewHelper", (new StringBuilder()).append("setScrollX: ").append(i).toString());
            view.scrollTo(i, view.getScrollY());
        }

        public ViewHelperDefault(View view)
        {
            super(view);
        }
    }


    private static final String LOG_TAG = "ViewHelper";

    public ViewHelperFactory()
    {
    }

    public static final ViewHelper create(View view)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 16)
        {
            return new ViewHelper16(view);
        }
        if (i >= 14)
        {
            return new ViewHelper14(view);
        } else
        {
            return new ViewHelperDefault(view);
        }
    }
}
