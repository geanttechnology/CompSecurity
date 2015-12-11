// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.callbacks.DefaultRaORequestCallback;
import com.groupon.models.hotel.RaoResponseWrapper;
import com.groupon.service.marketrate.HotelsService;
import java.util.List;
import roboguice.inject.Lazy;

public class HotelDiscountServiceFragment extends Fragment
{
    public static interface HotelDiscountServiceCallback
    {

        public abstract void onRequestRaOResult(RaoResponseWrapper raoresponsewrapper, Exception exception);
    }


    public static final String TAG = com/groupon/fragment/HotelDiscountServiceFragment.getName();
    private HotelDiscountServiceCallback callback;
    private Lazy hotelsService;
    private final Object lock = new Object();

    public HotelDiscountServiceFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (hotelsService == null)
        {
            hotelsService = new Lazy(getActivity().getApplicationContext()) {

                final HotelDiscountServiceFragment this$0;

            
            {
                this$0 = HotelDiscountServiceFragment.this;
                super(context);
            }
            };
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void requestRaOOffer(String s, List list)
    {
label0:
        {
            synchronized (lock)
            {
                if (hotelsService != null)
                {
                    break label0;
                }
            }
            return;
        }
        ((HotelsService)hotelsService.get()).requestRaOOffer(s, list, null, new DefaultRaORequestCallback() {

            final HotelDiscountServiceFragment this$0;

            public void onException(Exception exception)
            {
                if (callback != null)
                {
                    callback.onRequestRaOResult(null, exception);
                }
            }

            public void onRequestRaOSuccess(RaoResponseWrapper raoresponsewrapper)
            {
                if (callback != null)
                {
                    callback.onRequestRaOResult(raoresponsewrapper, null);
                }
            }

            
            {
                this$0 = HotelDiscountServiceFragment.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setCallback(HotelDiscountServiceCallback hoteldiscountservicecallback)
    {
        callback = hoteldiscountservicecallback;
    }

    public void skipRaOOffer(String s)
    {
label0:
        {
            synchronized (lock)
            {
                if (hotelsService != null)
                {
                    break label0;
                }
            }
            return;
        }
        ((HotelsService)hotelsService.get()).skipRaOOffer(s, null, null, null);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }


}
