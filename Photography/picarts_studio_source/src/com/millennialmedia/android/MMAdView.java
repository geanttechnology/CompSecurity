// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, MMLog, MMAdImpl, MMRequest, 
//            MMAdImplController, MMWebView, MMSDK, DTOResizeParameters, 
//            RequestListener

public final class MMAdView extends MMLayout
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{

    public static final int TRANSITION_DOWN = 3;
    public static final int TRANSITION_FADE = 1;
    public static final int TRANSITION_NONE = 0;
    public static final int TRANSITION_RANDOM = 4;
    public static final int TRANSITION_UP = 2;
    ImageView a;
    int b;
    int c;
    int d;
    private int j;
    private int k;
    private ResizeView l;

    public MMAdView(Context context)
    {
        super(context);
        b = 4;
        c = 0;
        d = 0;
        j = -50;
        k = -50;
        e = new MMAdViewMMAdImpl(context);
        a(context);
    }

    public MMAdView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MMAdView(Context context, AttributeSet attributeset, int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        ImageView imageview;
        obj1 = null;
        obj2 = null;
        obj = null;
        super(context, attributeset, i);
        b = 4;
        c = 0;
        d = 0;
        j = -50;
        k = -50;
        if (!isInEditMode())
        {
            MMLog.b("MMAdView", "Creating MMAdView from XML layout.");
            e = new MMAdViewMMAdImpl(context);
            if (attributeset != null)
            {
                setApid(attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "apid"));
                e.c = attributeset.getAttributeBooleanValue("http://millennialmedia.com/android/schema", "ignoreDensityScaling", false);
                obj = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "height");
                obj1 = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "width");
                try
                {
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        c = Integer.parseInt(((String) (obj)));
                    }
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        d = Integer.parseInt(((String) (obj1)));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MMLog.a("MMAdView", "Error reading attrs file from xml", ((Throwable) (obj)));
                }
                if (e.a != null)
                {
                    e.a.a = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "age");
                    e.a.b = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "children");
                    e.a.c = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "education");
                    e.a.d = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "ethnicity");
                    e.a.e = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "gender");
                    e.a.f = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "income");
                    e.a.g = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "keywords");
                    e.a.h = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "marital");
                    e.a.i = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "politics");
                    e.a.j = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "vendor");
                    e.a.k = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "zip");
                }
                attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "goalId");
            }
            a(context);
            return;
        }
        imageview = new ImageView(context);
        attributeset = System.getProperty("java.io.tmpdir");
        context = attributeset;
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_480;
        }
        context = attributeset;
        if (!attributeset.endsWith(File.separator))
        {
            context = (new StringBuilder()).append(attributeset).append(File.separator).toString();
        }
        File file;
        file = new File((new StringBuilder()).append(context).append("millenial355jns6u3l1nmedia.png").toString());
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_799;
        }
        context = (HttpURLConnection)(new URL("http://images.millennialmedia.com/9513/192134.gif")).openConnection();
        context.setDoOutput(true);
        context.setConnectTimeout(10000);
        context.connect();
        context = context.getInputStream();
        attributeset = new FileOutputStream(file);
        obj = new byte[1024];
_L3:
        i = context.read(((byte []) (obj)));
        if (i <= 0) goto _L2; else goto _L1
_L1:
        attributeset.write(((byte []) (obj)), 0, i);
          goto _L3
        obj1;
        obj = attributeset;
        attributeset = ((AttributeSet) (obj1));
_L10:
        obj2 = obj;
        obj1 = context;
        MMLog.a("MMAdView", "Error with eclipse xml image display: ", attributeset);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_624;
        }
        context.close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_634;
        }
        ((OutputStream) (obj)).close();
_L7:
        addView(imageview);
        return;
_L2:
        obj = attributeset;
_L11:
        obj2 = obj;
        obj1 = context;
        attributeset = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_677;
        }
        obj2 = obj;
        obj1 = context;
        imageview.setImageBitmap(attributeset);
        if (context == null) goto _L5; else goto _L4
_L4:
        context.close();
_L5:
        if (obj == null) goto _L7; else goto _L6
_L6:
        ((OutputStream) (obj)).close();
          goto _L7
        context;
_L8:
        MMLog.a("MMAdView", "Error closing file", context);
          goto _L7
        context;
        attributeset = null;
_L9:
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_722;
        }
        attributeset.close();
        if (obj2 != null)
        {
            try
            {
                ((OutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (AttributeSet attributeset)
            {
                MMLog.a("MMAdView", "Error closing file", attributeset);
            }
        }
        throw context;
        context;
          goto _L8
        obj;
        attributeset = context;
        context = ((Context) (obj));
          goto _L9
        obj1;
        obj = context;
        context = ((Context) (obj1));
        obj2 = attributeset;
        attributeset = ((AttributeSet) (obj));
          goto _L9
        context;
        attributeset = ((AttributeSet) (obj1));
          goto _L9
        attributeset;
        context = null;
          goto _L10
        attributeset;
          goto _L10
        attributeset;
          goto _L10
        context = null;
        obj = obj1;
          goto _L11
    }

    private void a(int i)
    {
        try
        {
            android/view/View.getMethod("setTranslationX", new Class[] {
                Float.TYPE
            }).invoke(this, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        catch (Exception exception)
        {
            MMLog.a("MMAdView", "Unable to call setTranslationX", exception);
        }
    }

    private void a(Context context)
    {
        setBackgroundColor(0);
        e.e = "b";
        setOnClickListener(this);
        setFocusable(true);
        a = new ImageView(context);
        a.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        a.setVisibility(8);
        addView(a, new android.widget.RelativeLayout.LayoutParams(-2, -2));
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
    }

    private void a(View view)
    {
        this;
        JVM INSTR monitorenter ;
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        Object obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (obj instanceof ViewGroup)
        {
            obj = (ViewGroup)obj;
            if (view.getParent() != null)
            {
                ((ViewGroup) (obj)).removeView(view);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    static void a(MMAdView mmadview, View view)
    {
        mmadview.b(view);
    }

    private void b(int i)
    {
        try
        {
            android/view/View.getMethod("setTranslationY", new Class[] {
                Float.TYPE
            }).invoke(this, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        catch (Exception exception)
        {
            MMLog.a("MMAdView", "Unable to call setTranslationY", exception);
        }
    }

    private void b(View view)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a(view);
        obj = getContext();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!(obj instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((Activity)obj).getWindow();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((Window) (obj)).getDecorView();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (obj instanceof ViewGroup)
        {
            ((ViewGroup)obj).addView(view);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    static void b(MMAdView mmadview, View view)
    {
        mmadview.a(view);
    }

    private void d()
    {
        if (e != null)
        {
            e.f();
        }
    }

    private boolean j()
    {
        return k == -50 && j == -50;
    }

    final void a()
    {
        Object obj = e;
        if (((MMAdImpl) (obj)).h != null)
        {
            obj = ((MMAdImpl) (obj)).h;
            if (((MMAdImplController) (obj)).a != null)
            {
                ((MMAdImplController) (obj)).a.a((MMAdImpl)((MMAdImplController) (obj)).b.get());
            }
        }
    }

    final void a(DTOResizeParameters dtoresizeparameters)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a.setImageBitmap(null);
        if (!MMSDK.c())
        {
            break MISSING_BLOCK_LABEL_409;
        }
        if (l == null)
        {
            l = new ResizeView(getContext());
            l.setId(0x121f0dbe);
            l.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(1, 1));
            l.setBackgroundColor(0);
        }
        if (l.getParent() != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        if (obj instanceof ViewGroup)
        {
            ((ViewGroup)obj).addView(l);
        }
        int ai1[];
        int ai2[];
        obj = new BannerBounds(dtoresizeparameters);
        if (!dtoresizeparameters.f)
        {
            int ai[] = new int[2];
            ((BannerBounds) (obj)).d.getLocationInWindow(ai);
            BannerBounds.BoundsResult boundsresult = ((BannerBounds) (obj)).a(ai[0], ((BannerBounds) (obj)).c.d, ((BannerBounds) (obj)).c.a, ((BannerBounds) (obj)).c.g);
            class BannerBounds.BoundsResult
            {

                int a;
                int b;

            private BannerBounds.BoundsResult()
            {
            }

            BannerBounds.BoundsResult(BannerBounds bannerbounds)
            {
                this();
            }
            }

            ((BannerBounds) (obj)).c.a = boundsresult.b;
            obj.a = boundsresult.a;
            boundsresult = new int[2];
            ((BannerBounds) (obj)).d.getLocationInWindow(boundsresult);
            boundsresult = ((BannerBounds) (obj)).a(boundsresult[1], ((BannerBounds) (obj)).c.e, ((BannerBounds) (obj)).c.b, ((BannerBounds) (obj)).c.h);
            ((BannerBounds) (obj)).c.b = boundsresult.b;
            obj.b = boundsresult.a;
        }
        ai1 = new int[2];
        getLocationInWindow(ai1);
        b(this);
        ai2 = new int[2];
        getLocationInWindow(ai2);
        if (j())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            k = layoutparams.width;
            j = layoutparams.height;
            if (k <= 0)
            {
                k = getWidth();
            }
            if (j <= 0)
            {
                j = getHeight();
            }
        }
        int i;
        int i1;
        int j1;
        int k1;
        i = ai1[0];
        i1 = ai2[0];
        j1 = ai1[1];
        k1 = ai2[1];
        ((BannerBounds) (obj)).a(getLayoutParams());
        a(((BannerBounds) (obj)).a + (i - i1));
        b(((BannerBounds) (obj)).b + (j1 - k1));
        post(new MMLayout._cls1(this, dtoresizeparameters.c));
        this;
        JVM INSTR monitorexit ;
        return;
        dtoresizeparameters;
        throw dtoresizeparameters;
    }

    public final volatile void addBlackView()
    {
        super.addBlackView();
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (!MMSDK.c())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (super.g != null && super.g.getParent() != null && (super.g.getParent() instanceof ViewGroup))
        {
            ((ViewGroup)super.g.getParent()).removeView(super.g);
            super.g = null;
        }
        if (!j())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            layoutparams.width = k;
            layoutparams.height = j;
            a(0);
            b(0);
            k = -50;
            j = -50;
        }
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        f = true;
        l.a(this);
        obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (obj instanceof ViewGroup)
        {
            obj = (ViewGroup)obj;
            if (l.getParent() != null)
            {
                ((ViewGroup) (obj)).removeView(l);
            }
        }
        f = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void getAd()
    {
        if (e != null && e.b != null)
        {
            getAd(e.b);
            return;
        } else
        {
            d();
            return;
        }
    }

    public final void getAd(RequestListener requestlistener)
    {
        if (e != null)
        {
            e.b = requestlistener;
        }
        d();
    }

    public final volatile String getApid()
    {
        return super.getApid();
    }

    public final volatile boolean getIgnoresDensityScaling()
    {
        return super.getIgnoresDensityScaling();
    }

    public final volatile RequestListener getListener()
    {
        return super.getListener();
    }

    public final volatile MMRequest getMMRequest()
    {
        return super.getMMRequest();
    }

    public final void onAnimationEnd(Animation animation)
    {
        a.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onClick(View view)
    {
        MMLog.b("MMAdView", (new StringBuilder("On click for ")).append(view.getId()).append(" view, ").append(view).append(" adimpl").append(e).toString());
        onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
    }

    protected final void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        super.onLayout(flag, i, i1, j1, k1);
        Utils.ThreadUtils.a(new Runnable() {

            private MMAdView a;

            public void run()
            {
                float f = a.getContext().getResources().getDisplayMetrics().density;
                if (a.d <= 0)
                {
                    a.d = (int)((float)a.getWidth() / f);
                }
                if (a.c <= 0)
                {
                    a.c = (int)((float)a.getHeight() / f);
                }
            }

            
            {
                a = MMAdView.this;
                super();
            }
        });
    }

    public final volatile boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public final void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && e != null && e.h != null)
        {
            if (e.h.a == null)
            {
                e.h.a = MMAdImplController.c(e);
            }
            MMWebView mmwebview = e.h.a;
            if (mmwebview != null && !mmwebview.a(e.f) && !mmwebview.c.equals("expanded"))
            {
                mmwebview.o();
                addView(mmwebview);
                return;
            }
        }
    }

    public final volatile void removeBlackView()
    {
        super.removeBlackView();
    }

    public final volatile void setApid(String s)
    {
        super.setApid(s);
    }

    public final void setBackgroundColor(int i)
    {
        super.setBackgroundColor(i);
        if (e != null && e.h != null && e.h.a != null)
        {
            e.h.a.setBackgroundColor(i);
        }
    }

    public final void setHeight(int i)
    {
        c = i;
    }

    public final volatile void setIgnoresDensityScaling(boolean flag)
    {
        super.setIgnoresDensityScaling(flag);
    }

    public final volatile void setListener(RequestListener requestlistener)
    {
        super.setListener(requestlistener);
    }

    public final volatile void setMMRequest(MMRequest mmrequest)
    {
        super.setMMRequest(mmrequest);
    }

    public final void setTransitionType(int i)
    {
        b = i;
    }

    public final void setWidth(int i)
    {
        d = i;
    }

    private class MMAdViewMMAdImpl extends MMLayout.MMLayoutMMAdImpl
    {
        private class MMAdViewWebViewClientListener extends MMAdImpl.BasicWebViewClientListener
        {

            public void onPageFinished(String s)
            {
                super.onPageFinished(s);
                s = (MMAdImpl)a.get();
                if (s != null && s.g())
                {
                    s.h();
                }
            }

            MMAdViewWebViewClientListener(MMAdImpl mmadimpl)
            {
                super(mmadimpl);
            }
        }


        final MMAdView k;

        final void a(Bitmap bitmap)
        {
            k.a.setImageBitmap(bitmap);
            k.a.setVisibility(0);
            k.a.bringToFront();
        }

        final void a(Map map)
        {
            if (k.c > 0)
            {
                map.put("hsht", String.valueOf(k.c));
            }
            if (k.d > 0)
            {
                map.put("hswd", String.valueOf(k.d));
            }
            super.a(map);
        }

        final boolean g()
        {
            return k.b != 0;
        }

        final void h()
        {
            if (k.a.getDrawable() == null) goto _L2; else goto _L1
_L1:
            int i;
            int i1 = k.b;
            i = i1;
            if (i1 == 4)
            {
                i = (new Random()).nextInt(4);
            }
            i;
            JVM INSTR tableswitch 2 3: default 64
        //                       2 117
        //                       3 140;
               goto _L3 _L4 _L5
_L3:
            Object obj = new AlphaAnimation(1.0F, 0.0F);
_L7:
            ((Animation) (obj)).setDuration(1000L);
            ((Animation) (obj)).setAnimationListener(k);
            ((Animation) (obj)).setFillEnabled(true);
            ((Animation) (obj)).setFillBefore(true);
            ((Animation) (obj)).setFillAfter(true);
            MMSDK.a(new Runnable(((Animation) (obj))) {

                private Animation a;
                private MMAdViewMMAdImpl b;

                public void run()
                {
                    b.k.a.startAnimation(a);
                }

                
                {
                    b = MMAdViewMMAdImpl.this;
                    a = animation;
                    super();
                }
            });
_L2:
            return;
_L4:
            obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)k.getHeight());
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, k.getHeight());
            if (true) goto _L7; else goto _L6
_L6:
        }

        public boolean hasCachedVideoSupport()
        {
            return false;
        }

        public boolean isBanner()
        {
            return true;
        }

        final String l()
        {
            return "millennialmedia.action.ACTION_GETAD_FAILED";
        }

        final String m()
        {
            return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
        }

        final String n()
        {
            return "getad";
        }

        final boolean o()
        {
            return k.getWindowToken() != null;
        }

        public MMAdViewMMAdImpl(Context context)
        {
            k = MMAdView.this;
            super(MMAdView.this, context);
            i = new MMAdViewWebViewClientListener(this);
        }
    }


    private class ResizeView extends View
    {

        private MMAdView a;

        final void a(View view)
        {
            this;
            JVM INSTR monitorenter ;
            MMAdView.b(a, view);
            if (getParent() != null && (getParent() instanceof ViewGroup))
            {
                ((ViewGroup)getParent()).addView(view);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            view;
            throw view;
        }

        protected void onRestoreInstanceState(Parcelable parcelable)
        {
            MMLog.b("MMAdView", "onRestoreInstanceState");
            MMAdView.a(a, a);
            super.onRestoreInstanceState(parcelable);
        }

        protected Parcelable onSaveInstanceState()
        {
            MMLog.b("MMAdView", "onSaveInstanceState");
            a(a);
            return super.onSaveInstanceState();
        }

        public ResizeView(Context context)
        {
            a = MMAdView.this;
            super(context);
        }
    }


    private class BannerBounds
    {

        int a;
        int b;
        DTOResizeParameters c;
        final MMAdView d;

        final android.view.ViewGroup.LayoutParams a(android.view.ViewGroup.LayoutParams layoutparams)
        {
            layoutparams.width = c.a;
            layoutparams.height = c.b;
            return layoutparams;
        }

        final BoundsResult a(int i, int i1, int j1, int k1)
        {
            if (i + j1 + i1 <= k1) goto _L2; else goto _L1
_L1:
            i1 += k1 - j1;
            if (i1 >= 0) goto _L4; else goto _L3
_L3:
            int l1;
            int i2;
            l1 = 0;
            i2 = k1;
_L6:
            BoundsResult boundsresult = new BoundsResult(this);
            boundsresult.a = l1 - i;
            boundsresult.b = i2;
            return boundsresult;
_L4:
            l1 = i1;
            i2 = j1;
            if (i1 + j1 > k1)
            {
                l1 = k1 - j1;
                i2 = j1;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            l1 = i1;
            i2 = j1;
            if (i1 <= 0)
            {
                l1 = i;
                i2 = j1;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        BannerBounds(DTOResizeParameters dtoresizeparameters)
        {
            d = MMAdView.this;
            super();
            c = dtoresizeparameters;
            a = dtoresizeparameters.d;
            b = dtoresizeparameters.e;
        }
    }

}
