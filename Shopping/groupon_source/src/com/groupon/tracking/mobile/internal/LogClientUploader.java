// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.app.Application;
import com.groupon.network.HttpResponseException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogFileSpec, LogPurger

public class LogClientUploader
{
    private static class GrouponNoSuccessHttpException extends Exception
    {

        public GrouponNoSuccessHttpException(String s)
        {
            super(s);
        }
    }


    private static final long DELAY_SERVICES_FOR_STARTUP_IN_MS = 5000L;
    private static final MediaType MEDIA_TYPE = MediaType.parse("binary/messagepack");
    private static ScheduledExecutorService uploadExecutor = Executors.newScheduledThreadPool(1);
    private Application application;
    private ContextScopedProvider httpClient;
    private boolean loggingEnabled;
    private LogFileSpec spec;
    protected String url;

    public LogClientUploader()
    {
    }

    protected URI getUploadUri(String s)
    {
        try
        {
            s = new URI((new StringBuilder()).append(url).append("&fileName=").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public void uploadFiles()
    {
        if (loggingEnabled)
        {
            uploadExecutor.schedule(new Runnable() {

                final LogClientUploader this$0;

                public void run()
                {
                    uploadFilesSynchronously();
                }

            
            {
                this$0 = LogClientUploader.this;
                super();
            }
            }, 5000L, TimeUnit.MILLISECONDS);
        }
    }

    public void uploadFilesSynchronously()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        boolean flag;
        i = 0;
        flag = false;
        Iterator iterator = Arrays.asList(application.fileList()).iterator();
_L2:
        if (!iterator.hasNext() || flag || i >= 3)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        Object obj2;
        boolean flag1;
        obj2 = (String)iterator.next();
        flag1 = spec.matchesSpec(((String) (obj2)));
        if (!flag1) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = new File(application.getFilesDir().getPath(), ((String) (obj2)));
        obj2 = (new com.squareup.okhttp.Request.Builder()).url(getUploadUri(((String) (obj2))).toURL()).post(RequestBody.create(MEDIA_TYPE, ((File) (obj)))).build();
        j = ((OkHttpClient)httpClient.get(application)).newCall(((com.squareup.okhttp.Request) (obj2))).execute().code();
        if (j == 200 || j == 201)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        throw new GrouponNoSuccessHttpException("Client received a 2xx code which is not 200/201");
        obj;
        Ln.d("NST_Logging: Log upload failed. Client received %s", new Object[] {
            Integer.valueOf(((HttpResponseException) (obj)).getStatusCode())
        });
        flag = true;
          goto _L2
        ((File) (obj)).delete();
        i = 0;
          goto _L2
        Object obj1;
        obj1;
        Ln.d((new StringBuilder()).append("NST_Logging: Log upload failed.").append(((GrouponNoSuccessHttpException) (obj1)).getMessage()).toString(), new Object[0]);
        flag = true;
          goto _L2
        obj1;
        i++;
        Ln.d("NST_Logging: Log upload failed. Attempting retry. Attempt: %s", new Object[] {
            Integer.valueOf(i)
        });
          goto _L2
        Exception exception;
        exception;
        throw exception;
        (new LogPurger(application, spec)).purge();
        this;
        JVM INSTR monitorexit ;
    }

}
