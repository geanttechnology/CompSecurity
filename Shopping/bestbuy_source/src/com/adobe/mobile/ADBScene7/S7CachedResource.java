// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;

import android.graphics.Bitmap;

// Referenced classes of package com.adobe.mobile.ADBScene7:
//            S7ResourceType

public class S7CachedResource
{

    private static final String S7_PARAM_BASE = "?fmt=jpg&wid=%d&hei=%d&fit=crop,1";
    private static final String S7_URL_BASE = "http://testvipd2.scene7.com/is/%s/%s/%s%s";

    public S7CachedResource()
    {
    }

    private String GetDefaultS7Params(int i, int j)
    {
        return String.format("?fmt=jpg&wid=%d&hei=%d&fit=crop,1", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void GetS7CachedResource(String s, S7ResourceType s7resourcetype, int i, int j, String s1, final S7Callback callback)
    {
        (new Thread(new DownloadImageTask(String.format("http://testvipd2.scene7.com/is/%s/%s/%s%s", new Object[] {
            s7resourcetype.getTypeName(), s, s1, GetDefaultS7Params(j, i)
        }), new S7Callback() {

            final S7CachedResource this$0;
            final S7Callback val$callback;

            public void call(Bitmap bitmap)
            {
                if (callback != null)
                {
                    callback.call(bitmap);
                }
            }

            public volatile void call(Object obj)
            {
                call((Bitmap)obj);
            }

            
            {
                this$0 = S7CachedResource.this;
                callback = s7callback;
                super();
            }

            private class S7Callback
            {

                public abstract void call(Object obj);
            }

        }))).start();
    }

    private class DownloadImageTask
        implements Runnable
    {

        private S7Callback _callback;
        private String _url;
        final S7CachedResource this$0;

        public void run()
        {
            Object obj = null;
            Bitmap bitmap;
            Log.d("ADBMobile", String.format("Scene 7 - About to get image %s", new Object[] {
                _url
            }));
            bitmap = BitmapFactory.decodeStream((new URL(_url)).openStream());
_L2:
            if (_callback != null)
            {
                _callback.call(bitmap);
            }
            return;
            Exception exception;
            exception;
            Log.e("ADBMobile", String.format("Scene 7 - %s", new Object[] {
                exception.getLocalizedMessage()
            }));
            exception.printStackTrace();
            exception = obj;
            if (_callback != null)
            {
                _callback.call(null);
                exception = obj;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public DownloadImageTask(String s, S7Callback s7callback)
        {
            this$0 = S7CachedResource.this;
            super();
            _url = s;
            _callback = s7callback;
        }
    }

}
