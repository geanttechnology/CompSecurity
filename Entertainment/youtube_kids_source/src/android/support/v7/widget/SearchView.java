// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import lj;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutCompat

public final class SearchView extends LinearLayoutCompat
{

    static final lj c = new lj();
    private static final boolean d;
    private final SearchAutoComplete e;
    private final View f;
    private final View g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final ImageView k;
    private final ImageView l;
    private boolean m;
    private boolean n;
    private final Runnable o;

    static void a(SearchView searchview, boolean flag)
    {
        searchview.b(false);
    }

    private void a(boolean flag)
    {
        int j1 = 1;
        boolean flag2 = false;
        m = flag;
        Object obj;
        int ai[];
        Drawable drawable;
        boolean flag1;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (!TextUtils.isEmpty(e.getText()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        h.setVisibility(i1);
        i.setVisibility(8);
        obj = f;
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((View) (obj)).setVisibility(i1);
        l.setVisibility(0);
        if (!TextUtils.isEmpty(e.getText()))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            j1 = 0;
        }
        obj = j;
        if (j1 != 0)
        {
            j1 = ((flag2) ? 1 : 0);
        } else
        {
            j1 = 8;
        }
        ((ImageView) (obj)).setVisibility(j1);
        drawable = j.getDrawable();
        if (i1 != 0)
        {
            ai = ENABLED_STATE_SET;
        } else
        {
            ai = EMPTY_STATE_SET;
        }
        drawable.setState(ai);
        if (flag1);
        k.setVisibility(8);
        g.setVisibility(8);
    }

    static boolean a(Context context)
    {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            post(null);
        } else
        {
            removeCallbacks(null);
            InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
            if (inputmethodmanager != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
                return;
            }
        }
    }

    private int c()
    {
        return getContext().getResources().getDimensionPixelSize(0x7f0a0044);
    }

    private void d()
    {
        post(o);
    }

    final void a()
    {
        a(m);
        d();
        if (e.hasFocus())
        {
            c.a(e);
            c.b(e);
        }
    }

    public final void clearFocus()
    {
        n = true;
        b(false);
        super.clearFocus();
        e.clearFocus();
        n = false;
    }

    protected final void onDetachedFromWindow()
    {
        removeCallbacks(o);
        post(null);
        super.onDetachedFromWindow();
    }

    protected final void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        if (m)
        {
            super.onMeasure(i1, j1);
            return;
        }
        l1 = android.view.View.MeasureSpec.getMode(i1);
        k1 = android.view.View.MeasureSpec.getSize(i1);
        i1 = k1;
        l1;
        JVM INSTR lookupswitch 3: default 64
    //                   -2147483648: 78
    //                   0: 90
    //                   1073741824: 66;
           goto _L1 _L2 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = k1;
_L6:
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), j1);
        return;
_L2:
        i1 = Math.min(c(), k1);
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = c();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        d();
    }

    public final boolean requestFocus(int i1, Rect rect)
    {
        while (n || !isFocusable()) 
        {
            return false;
        }
        if (!m)
        {
            boolean flag = e.requestFocus(i1, rect);
            if (flag)
            {
                a(false);
            }
            return flag;
        } else
        {
            return super.requestFocus(i1, rect);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }

    private class SearchAutoComplete extends AutoCompleteTextView
    {

        private final int a[] = {
            0x1010176
        };
        private int b;
        private final hy c;

        public boolean enoughToFilter()
        {
            return b <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean flag, int i1, Rect rect)
        {
            super.onFocusChanged(flag, i1, rect);
            throw new NullPointerException();
        }

        public boolean onKeyPreIme(int i1, KeyEvent keyevent)
        {
            if (i1 == 4)
            {
                if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
                {
                    android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
                    if (dispatcherstate != null)
                    {
                        dispatcherstate.startTracking(keyevent, this);
                    }
                    return true;
                }
                if (keyevent.getAction() == 1)
                {
                    android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
                    if (dispatcherstate1 != null)
                    {
                        dispatcherstate1.handleUpEvent(keyevent);
                    }
                    if (keyevent.isTracking() && !keyevent.isCanceled())
                    {
                        throw new NullPointerException();
                    }
                }
            }
            return super.onKeyPreIme(i1, keyevent);
        }

        public void onWindowFocusChanged(boolean flag)
        {
            super.onWindowFocusChanged(flag);
            if (flag)
            {
                throw new NullPointerException();
            } else
            {
                return;
            }
        }

        public void performCompletion()
        {
        }

        protected void replaceText(CharSequence charsequence)
        {
        }

        public void setDropDownBackgroundResource(int i1)
        {
            setDropDownBackgroundDrawable(c.a(i1));
        }

        public void setThreshold(int i1)
        {
            super.setThreshold(i1);
            b = i1;
        }

        public SearchAutoComplete(Context context)
        {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeset)
        {
            this(context, attributeset, 0x101006b);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeset, int i1)
        {
            super(context, attributeset, i1);
            b = getThreshold();
            context = ib.a(context, attributeset, a, i1, 0);
            if (context.c(0))
            {
                setDropDownBackgroundDrawable(context.a(0));
            }
            ((ib) (context)).a.recycle();
            c = context.a();
        }
    }

}
