// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import android.content.Context;
import com.offerup.android.gson.GsonManager;
import com.squareup.okhttp.OkHttpClient;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

// Referenced classes of package com.offerup.android.network:
//            SearchService, q, UserRelationService, ToSService, 
//            p, MessagingService, UserService, WatchListService, 
//            OfferService, RatingService, ArchiveService, MyOffersService, 
//            PaymentService, ItemService, AlertService, GoogleMapsService, 
//            PhotosService, PhotosUploadService

public final class o
{

    private static RequestInterceptor a;
    private static Context b;
    private static final GsonConverter c = new GsonConverter(GsonManager.getGson());
    private static String d;

    public o()
    {
    }

    public static SearchService a(RestAdapter restadapter)
    {
        return (SearchService)restadapter.create(com/offerup/android/network/SearchService);
    }

    public static Object a(Class class1, RestAdapter restadapter)
    {
        return restadapter.create(class1);
    }

    public static String a()
    {
        return d;
    }

    public static RestAdapter a(ExecutorService executorservice)
    {
        com/offerup/android/network/o;
        JVM INSTR monitorenter ;
        executorservice = a(executorservice, new OkClient());
        com/offerup/android/network/o;
        JVM INSTR monitorexit ;
        return executorservice;
        executorservice;
        throw executorservice;
    }

    public static RestAdapter a(ExecutorService executorservice, String s)
    {
        com/offerup/android/network/o;
        JVM INSTR monitorenter ;
        OkHttpClient okhttpclient = new OkHttpClient();
        Object obj;
        obj = SSLContext.getInstance("TLS");
        ((SSLContext) (obj)).init(null, null, null);
        okhttpclient.setSslSocketFactory(((SSLContext) (obj)).getSocketFactory());
        okhttpclient.setConnectTimeout(20L, TimeUnit.SECONDS);
        okhttpclient.networkInterceptors().add(new q());
        obj = retrofit.RestAdapter.LogLevel.NONE;
        executorservice = (new retrofit.RestAdapter.Builder()).setExecutors(executorservice, new MainThreadExecutor()).setClient(new OkClient(okhttpclient)).setEndpoint(s).setLogLevel(((retrofit.RestAdapter.LogLevel) (obj))).build();
        com/offerup/android/network/o;
        JVM INSTR monitorexit ;
        return executorservice;
        executorservice;
        throw new AssertionError();
        executorservice;
        com/offerup/android/network/o;
        JVM INSTR monitorexit ;
        throw executorservice;
    }

    private static RestAdapter a(ExecutorService executorservice, OkClient okclient)
    {
        retrofit.RestAdapter.LogLevel loglevel = retrofit.RestAdapter.LogLevel.NONE;
        return (new retrofit.RestAdapter.Builder()).setExecutors(executorservice, new MainThreadExecutor()).setClient(okclient).setEndpoint(d).setRequestInterceptor(c()).setConverter(c).setLogLevel(loglevel).build();
    }

    public static void a(Context context)
    {
        b = context;
    }

    public static void a(String s)
    {
        d = s;
    }

    static Context b()
    {
        return b;
    }

    public static UserRelationService b(RestAdapter restadapter)
    {
        return (UserRelationService)restadapter.create(com/offerup/android/network/UserRelationService);
    }

    public static RestAdapter b(ExecutorService executorservice)
    {
        Object obj = new OkHttpClient();
        SSLContext sslcontext;
        try
        {
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            throw new AssertionError();
        }
        ((OkHttpClient) (obj)).setSslSocketFactory(sslcontext.getSocketFactory());
        obj = new OkClient(((OkHttpClient) (obj)));
        return (new retrofit.RestAdapter.Builder()).setExecutors(executorservice, new MainThreadExecutor()).setClient(((retrofit.client.Client) (obj))).setEndpoint("https://maps.googleapis.com").setRequestInterceptor(c()).build();
    }

    public static ToSService c(RestAdapter restadapter)
    {
        return (ToSService)restadapter.create(com/offerup/android/network/ToSService);
    }

    private static RequestInterceptor c()
    {
        com/offerup/android/network/o;
        JVM INSTR monitorenter ;
        RequestInterceptor requestinterceptor;
        if (a == null)
        {
            a = new p();
        }
        requestinterceptor = a;
        com/offerup/android/network/o;
        JVM INSTR monitorexit ;
        return requestinterceptor;
        Exception exception;
        exception;
        throw exception;
    }

    public static RestAdapter c(ExecutorService executorservice)
    {
        com/offerup/android/network/o;
        JVM INSTR monitorenter ;
        OkHttpClient okhttpclient = new OkHttpClient();
        okhttpclient.setConnectTimeout(20L, TimeUnit.SECONDS);
        executorservice = a(executorservice, new OkClient(okhttpclient));
        com/offerup/android/network/o;
        JVM INSTR monitorexit ;
        return executorservice;
        executorservice;
        throw executorservice;
    }

    public static MessagingService d(RestAdapter restadapter)
    {
        return (MessagingService)restadapter.create(com/offerup/android/network/MessagingService);
    }

    public static UserService e(RestAdapter restadapter)
    {
        return (UserService)restadapter.create(com/offerup/android/network/UserService);
    }

    public static WatchListService f(RestAdapter restadapter)
    {
        return (WatchListService)restadapter.create(com/offerup/android/network/WatchListService);
    }

    public static OfferService g(RestAdapter restadapter)
    {
        return (OfferService)restadapter.create(com/offerup/android/network/OfferService);
    }

    public static RatingService h(RestAdapter restadapter)
    {
        return (RatingService)restadapter.create(com/offerup/android/network/RatingService);
    }

    public static ArchiveService i(RestAdapter restadapter)
    {
        return (ArchiveService)restadapter.create(com/offerup/android/network/ArchiveService);
    }

    public static MyOffersService j(RestAdapter restadapter)
    {
        return (MyOffersService)restadapter.create(com/offerup/android/network/MyOffersService);
    }

    public static PaymentService k(RestAdapter restadapter)
    {
        return (PaymentService)restadapter.create(com/offerup/android/network/PaymentService);
    }

    public static ItemService l(RestAdapter restadapter)
    {
        return (ItemService)restadapter.create(com/offerup/android/network/ItemService);
    }

    public static AlertService m(RestAdapter restadapter)
    {
        return (AlertService)restadapter.create(com/offerup/android/network/AlertService);
    }

    public static GoogleMapsService n(RestAdapter restadapter)
    {
        return (GoogleMapsService)restadapter.create(com/offerup/android/network/GoogleMapsService);
    }

    public static PhotosService o(RestAdapter restadapter)
    {
        return (PhotosService)restadapter.create(com/offerup/android/network/PhotosService);
    }

    public static PhotosUploadService p(RestAdapter restadapter)
    {
        return (PhotosUploadService)restadapter.create(com/offerup/android/network/PhotosUploadService);
    }

}
