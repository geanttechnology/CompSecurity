// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import java.util.Calendar;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            CvDefaultContentProvider, CvContentOptions, CvFeaturesList, CvSDK, 
//            CvUrl, CvContentResponse

private class listener extends ase
{

    private JSONObject data;
    private  listener;
    final CvDefaultContentProvider this$0;

    private void callListener(CvContentResponse cvcontentresponse,  )
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
         1 = CvDefaultContentProvider.access$000();
        if ( == null)
        {
            flag = false;
        }
        1._mth000(new Object[] {
            "Calling listener with response", Boolean.valueOf(flag)
        });
        if ( == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        .onContentLoaded(cvcontentresponse);
        cancel();
        this;
        JVM INSTR monitorexit ;
        return;
        cvcontentresponse;
        throw cvcontentresponse;
    }

    String getUri()
    {
        int ai[] = new int[3];
        int[] _tmp = ai;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        String s;
        if (options.adColony)
        {
            int i = ai[2];
            String s1;
            Object obj;
            String s2;
            String s3;
            String s4;
            byte byte0;
            long l;
            if (options.interstitial)
            {
                byte0 = 16;
            } else
            {
                byte0 = 32;
            }
            ai[2] = byte0 | i;
        }
        s1 = options.adSpaceId;
        obj = context;
        obj = CvFeaturesList.urlHex(ai, new int[] {
            0, 0, 0
        }, ((Context) (obj)));
        s2 = CvSDK.getPiKey();
        s3 = options.categories;
        s4 = options.keywords;
        l = Calendar.getInstance().getTimeInMillis();
        if (options.interstitial)
        {
            s = "&interstitial=1";
        } else
        {
            s = "";
        }
        return CvUrl.build(String.format("/cv/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s", new Object[] {
            s1, "6", obj, s2, s3, s4, Long.valueOf(l), s
        }));
    }

    void onCanceled()
    {
        this;
        JVM INSTR monitorenter ;
        listener = null;
        data = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void onComplete()
    {
        CvContentResponse cvcontentresponse = new CvContentResponse(data);
          = listener;
    /* block-local class not found */
    class _cls2 {}

        handler.post(new _cls2(cvcontentresponse, ));
    }

    void onError(String s, Exception exception, int i)
    {
        s = new CvContentResponse(s, exception, i);
        exception = listener;
    /* block-local class not found */
    class _cls1 {}

        handler.post(new _cls1(s, exception));
    }

    boolean parseContent(String s)
        throws Exception
    {
        if (s == null || s.length() == 0 || s.toLowerCase().equals("null") || s.equals("[]"))
        {
            error("Server returned empty response, possibly piKey should be refreshed.", null, 0);
            return false;
        }
        s = new JSONObject(s);
        if (s.has("size") && s.getString("size").length() > 0 && s.has("html") && s.getString("html").length() > 0)
        {
            data = s;
            return true;
        } else
        {
            error("Server returned not parsable response.", null, -2);
            return false;
        }
    }


    (Context context, CvContentOptions cvcontentoptions,  )
    {
        this$0 = CvDefaultContentProvider.this;
        super(CvDefaultContentProvider.this, context, cvcontentoptions);
        data = null;
        listener = ;
    }
}
