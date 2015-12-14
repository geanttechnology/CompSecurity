// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastMacroHelper;
import com.mopub.mobileads.VastTracker;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.network:
//            Networking, MoPubNetworkError

public class TrackingRequest extends Request
{

    private final Listener mListener;

    private TrackingRequest(String s, Listener listener)
    {
        super(0, s, listener);
        mListener = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
    }

    public static void makeTrackingHttpRequest(Iterable iterable, Context context)
    {
        makeTrackingHttpRequest(iterable, context, null, null);
    }

    public static void makeTrackingHttpRequest(Iterable iterable, Context context, com.mopub.common.event.BaseEvent.Name name)
    {
        makeTrackingHttpRequest(iterable, context, null, name);
    }

    public static void makeTrackingHttpRequest(Iterable iterable, Context context, final Listener listener, final com.mopub.common.event.BaseEvent.Name url)
    {
        if (iterable != null && context != null)
        {
            context = Networking.getRequestQueue(context);
            iterable = iterable.iterator();
            while (iterable.hasNext()) 
            {
                url = (String)iterable.next();
                if (!TextUtils.isEmpty(url))
                {
                    context.add(new TrackingRequest(url, new Listener() {

                        final Listener val$listener;
                        final String val$url;

                        public final void onErrorResponse(VolleyError volleyerror)
                        {
                            MoPubLog.d((new StringBuilder("Failed to hit tracking endpoint: ")).append(url).toString());
                            if (listener != null)
                            {
                                listener.onErrorResponse(volleyerror);
                            }
                        }

                        public final void onResponse(String s)
                        {
                            MoPubLog.d((new StringBuilder("Successfully hit tracking endpoint: ")).append(s).toString());
                            if (listener != null)
                            {
                                listener.onResponse(s);
                            }
                        }

            
            {
                listener = listener1;
                url = s;
                super();
            }

                        private class Listener
                            implements com.mopub.volley.Response.ErrorListener
                        {

                            public abstract void onResponse(String s);
                        }

                    }));
                }
            }
        }
    }

    public static void makeTrackingHttpRequest(String s, Context context)
    {
        makeTrackingHttpRequest(s, context, null, null);
    }

    public static void makeTrackingHttpRequest(String s, Context context, com.mopub.common.event.BaseEvent.Name name)
    {
        makeTrackingHttpRequest(s, context, null, name);
    }

    public static void makeTrackingHttpRequest(String s, Context context, Listener listener)
    {
        makeTrackingHttpRequest(s, context, listener, null);
    }

    public static void makeTrackingHttpRequest(String s, Context context, Listener listener, com.mopub.common.event.BaseEvent.Name name)
    {
        if (s != null)
        {
            makeTrackingHttpRequest(((Iterable) (Arrays.asList(new String[] {
                s
            }))), context, listener, name);
        }
    }

    public static void makeVastTrackingHttpRequest(List list, VastErrorCode vasterrorcode, Integer integer, String s, Context context)
    {
        Preconditions.checkNotNull(list);
        ArrayList arraylist = new ArrayList(list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            VastTracker vasttracker = (VastTracker)list.next();
            if (vasttracker != null && (!vasttracker.isTracked() || vasttracker.isRepeatable()))
            {
                arraylist.add(vasttracker.getTrackingUrl());
                vasttracker.setTracked();
            }
        } while (true);
        makeTrackingHttpRequest((new VastMacroHelper(arraylist)).withErrorCode(vasterrorcode).withContentPlayHead(integer).withAssetUri(s).getUris(), context);
    }

    public volatile void deliverResponse(Object obj)
    {
        deliverResponse((Void)obj);
    }

    public void deliverResponse(Void void1)
    {
        if (mListener != null)
        {
            mListener.onResponse(getUrl());
        }
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        if (networkresponse.statusCode != 200)
        {
            return Response.error(new MoPubNetworkError((new StringBuilder("Failed to log tracking request. Response code: ")).append(networkresponse.statusCode).append(" for url: ").append(getUrl()).toString(), MoPubNetworkError.Reason.TRACKING_FAILURE));
        } else
        {
            return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkresponse));
        }
    }
}
