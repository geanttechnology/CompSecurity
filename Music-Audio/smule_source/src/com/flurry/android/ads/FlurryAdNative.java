// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.flurry.android.impl.ads.protocol.v13.NativeAsset;
import com.flurry.sdk.av;
import com.flurry.sdk.d;
import com.flurry.sdk.fp;
import com.flurry.sdk.fx;
import com.flurry.sdk.fy;
import com.flurry.sdk.fz;
import com.flurry.sdk.gd;
import com.flurry.sdk.hq;
import com.flurry.sdk.i;
import com.flurry.sdk.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android.ads:
//            FlurryAdNativeAsset, FlurryAdNativeListener, FlurryAdTargeting, FlurryAdErrorType

public final class FlurryAdNative
{

    private static final String a = com/flurry/android/ads/FlurryAdNative.getSimpleName();
    private final List b;
    private w c;
    private final fy d;
    private FlurryAdNativeListener e;

    public FlurryAdNative(Context context, String s)
    {
        b = new ArrayList();
        d = new fy() {

            final FlurryAdNative a;

            public void a(d d1)
            {
                if (d1.a == FlurryAdNative.a(a) && d1.b != null)
                {
                    if (com.flurry.sdk.d.a.a.equals(d1.b))
                    {
                        FlurryAdNative.b(a);
                    }
                    FlurryAdNativeListener flurryadnativelistener = FlurryAdNative.c(a);
                    if (flurryadnativelistener != null)
                    {
                        fp.a().a(new hq(this, d1, flurryadnativelistener) {

                            final d a;
                            final FlurryAdNativeListener b;
                            final _cls1 c;

                            public void safeRun()
                            {
                                class _cls2
                                {

                                    static final int a[];

                                    static 
                                    {
                                        a = new int[com.flurry.sdk.d.a.values().length];
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.a.ordinal()] = 1;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror7) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.b.ordinal()] = 2;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror6) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.e.ordinal()] = 3;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror5) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.f.ordinal()] = 4;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror4) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.g.ordinal()] = 5;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror3) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.h.ordinal()] = 6;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror2) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.i.ordinal()] = 7;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror1) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.j.ordinal()] = 8;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror)
                                        {
                                            return;
                                        }
                                    }
                                }

                                switch (_cls2.a[a.b.ordinal()])
                                {
                                default:
                                    return;

                                case 1: // '\001'
                                    b.onFetched(c.a);
                                    return;

                                case 2: // '\002'
                                    b.onError(c.a, FlurryAdErrorType.FETCH, a.c.a());
                                    return;

                                case 3: // '\003'
                                    b.onShowFullscreen(c.a);
                                    return;

                                case 4: // '\004'
                                    b.onCloseFullscreen(c.a);
                                    return;

                                case 5: // '\005'
                                    b.onAppExit(c.a);
                                    return;

                                case 6: // '\006'
                                    b.onClicked(c.a);
                                    return;

                                case 7: // '\007'
                                    b.onError(c.a, FlurryAdErrorType.CLICK, a.c.a());
                                    return;

                                case 8: // '\b'
                                    b.onImpressionLogged(c.a);
                                    break;
                                }
                            }

            
            {
                c = _pcls1;
                a = d1;
                b = flurryadnativelistener;
                super();
            }
                        });
                        return;
                    }
                }
            }

            public void notify(fx fx)
            {
                a((d)fx);
            }

            
            {
                a = FlurryAdNative.this;
                super();
            }
        };
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Ad space must be specified!");
        }
        try
        {
            if (i.a() == null)
            {
                throw new IllegalStateException("Could not find FlurryAds module. Please make sure the library is included.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            gd.a(a, "Exception: ", context);
            return;
        }
        c = new w(context, s);
        context = new ArrayList();
        context.add(Integer.valueOf(1));
        c.a(context);
        fz.a().a("com.flurry.android.impl.ads.AdStateEvent", d);
        return;
    }

    static w a(FlurryAdNative flurryadnative)
    {
        return flurryadnative.c;
    }

    private void a()
    {
        if (c == null)
        {
            return;
        }
        List list = b;
        list;
        JVM INSTR monitorenter ;
        FlurryAdNativeAsset flurryadnativeasset;
        for (Iterator iterator = c.y().iterator(); iterator.hasNext(); b.add(flurryadnativeasset))
        {
            flurryadnativeasset = new FlurryAdNativeAsset((NativeAsset)iterator.next(), c.d());
        }

        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    static void b(FlurryAdNative flurryadnative)
    {
        flurryadnative.a();
    }

    static FlurryAdNativeListener c(FlurryAdNative flurryadnative)
    {
        return flurryadnative.e;
    }

    public void destroy()
    {
        try
        {
            fz.a().b("com.flurry.android.impl.ads.AdStateEvent", d);
            e = null;
            if (c != null)
            {
                c.a();
                c = null;
            }
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public void fetchAd()
    {
        try
        {
            c.v();
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public FlurryAdNativeAsset getAsset(String s)
    {
        if (i.a() == null)
        {
            return null;
        }
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        List list = b;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = b.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        FlurryAdNativeAsset flurryadnativeasset = (FlurryAdNativeAsset)iterator.next();
        if (!s.equals(flurryadnativeasset.getName())) goto _L4; else goto _L3
_L3:
        s = flurryadnativeasset;
_L6:
        list;
        JVM INSTR monitorexit ;
        return s;
        s;
        list;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gd.a(a, "Exception: ", s);
        }
        return null;
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public List getAssetList()
    {
        if (i.a() == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        synchronized (b)
        {
            arraylist.addAll(b);
        }
        list = Collections.unmodifiableList(arraylist);
        return list;
        exception;
        list;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
        return Collections.emptyList();
    }

    public int getStyle()
    {
        int j;
        try
        {
            j = c.x();
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
            return 0;
        }
        return j;
    }

    public boolean isReady()
    {
        boolean flag;
        try
        {
            flag = c.u();
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
            return false;
        }
        return flag;
    }

    public void removeTrackingView()
    {
        try
        {
            c.w();
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public void setListener(FlurryAdNativeListener flurryadnativelistener)
    {
        try
        {
            e = flurryadnativelistener;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAdNativeListener flurryadnativelistener)
        {
            gd.a(a, "Exception: ", flurryadnativelistener);
        }
    }

    public void setSupportedStyles(List list)
    {
        try
        {
            c.a(list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            gd.a(a, "Exception: ", list);
        }
    }

    public void setTargeting(FlurryAdTargeting flurryadtargeting)
    {
        try
        {
            c.a(flurryadtargeting);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAdTargeting flurryadtargeting)
        {
            gd.a(a, "Exception: ", flurryadtargeting);
        }
    }

    public void setTrackingView(View view)
    {
        try
        {
            c.a(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            gd.a(a, "Exception: ", view);
        }
    }

}
