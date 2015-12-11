// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.comcast.playerplatform.drm.java.util:
//            ThreadManager

public class MetadataUtil
{

    public MetadataUtil()
    {
    }

    public static void attachMetadata(String s, AbstractResponseEventListener abstractresponseeventlistener, HttpClient httpclient)
    {
        URI uri = URI.create(s);
        if (uri.getScheme() == null || uri.getScheme().equals("file"))
        {
            ThreadManager.getInstance().executeRunnable(new Runnable(uri, abstractresponseeventlistener, s) {

                final String val$manifestUri;
                final AbstractResponseEventListener val$responseEventListener;
                final URI val$uri;

                public void run()
                {
                    String s1;
                    if (uri.getScheme() != null)
                    {
                        break MISSING_BLOCK_LABEL_42;
                    }
                    s1 = MetadataUtil.readFile(URI.create("file:/").resolve(uri));
_L1:
                    ThreadManager.getInstance().executeOnUIThread(s1. new Runnable() {

                        final _cls1 this$0;
                        final String val$manifestString;

                        public void run()
                        {
                            responseEventListener.responseReceived(manifestString);
                        }

            
            {
                this$0 = final__pcls1;
                manifestString = String.this;
                super();
            }
                    });
                    return;
                    try
                    {
                        s1 = MetadataUtil.readFile(uri);
                    }
                    catch (Exception exception)
                    {
                        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                            final _cls1 this$0;

                            public void run()
                            {
                                responseEventListener.requestFailed((new StringBuilder()).append("manifest not found:").append(manifestUri).toString());
                            }

            
            {
                this$0 = _cls1.this;
                super();
            }
                        });
                        return;
                    }
                      goto _L1
                }

            
            {
                uri = uri1;
                responseEventListener = abstractresponseeventlistener;
                manifestUri = s;
                super();
            }
            });
            return;
        }
        if (uri.getScheme().equals("http") || uri.getScheme().equals("https"))
        {
            ThreadManager.getInstance().executeRunnable(new XrestHelper("", s, "GET", null, abstractresponseeventlistener, httpclient));
            return;
        } else
        {
            ThreadManager.getInstance().executeOnUIThread(new Runnable(abstractresponseeventlistener, s) {

                final String val$manifestUri;
                final AbstractResponseEventListener val$responseEventListener;

                public void run()
                {
                    responseEventListener.requestFailed((new StringBuilder()).append("manifest not found:").append(manifestUri).toString());
                }

            
            {
                responseEventListener = abstractresponseeventlistener;
                manifestUri = s;
                super();
            }
            });
            return;
        }
    }

    private static String readFile(URI uri)
        throws IOException
    {
        Object obj = null;
        uri = new FileInputStream(new File(uri));
        obj = IOUtils.toString(uri, "UTF-8");
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (URI uri)
            {
                return ((String) (obj));
            }
        }
        return ((String) (obj));
        uri;
_L2:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw uri;
        Exception exception;
        exception;
        obj = uri;
        uri = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
