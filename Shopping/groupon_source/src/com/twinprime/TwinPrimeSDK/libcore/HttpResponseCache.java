// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            RawHeaders

public class HttpResponseCache
{
    public static final class CacheRequestImpl extends CacheRequest
    {

        private OutputStream body;
        private OutputStream cacheOut;
        private final DiskLruCache.Editor editor;

        public void abort()
        {
            try
            {
                editor.abort();
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        public OutputStream getBody()
            throws IOException
        {
            return body;
        }

        public CacheRequestImpl(DiskLruCache.Editor editor1)
            throws IOException
        {
            editor = editor1;
            cacheOut = editor1.newOutputStream(1);
            body = cacheOut. new _cls1(editor1);
        }
    }

    public static class EntryCacheResponse extends CacheResponse
    {

        private final DiskLruCache.Entry entry;
        private final InputStream is;

        public InputStream getBody()
        {
            return is;
        }

        public Map getHeaders()
        {
            return entry.responseHeaders.toMultimap(true);
        }

        public EntryCacheResponse(DiskLruCache.Entry entry1, DiskLruCache.Snapshot snapshot)
        {
            entry = entry1;
            is = snapshot.getInputStream(1);
        }
    }

    public static class EntrySecureCacheResponse extends SecureCacheResponse
    {

        private final DiskLruCache.Entry entry;
        private final InputStream in;

        public InputStream getBody()
        {
            return in;
        }

        public String getCipherSuite()
        {
            return entry.cipherSuite;
        }

        public Map getHeaders()
        {
            return entry.responseHeaders.toMultimap(true);
        }

        public List getLocalCertificateChain()
        {
            if (entry.localCertificates == null || entry.localCertificates.length == 0)
            {
                return null;
            } else
            {
                return Arrays.asList((Object[])entry.localCertificates.clone());
            }
        }

        public Principal getLocalPrincipal()
        {
            if (entry.localCertificates == null || entry.localCertificates.length == 0)
            {
                return null;
            } else
            {
                return ((X509Certificate)entry.localCertificates[0]).getSubjectX500Principal();
            }
        }

        public Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException
        {
            if (entry.peerCertificates == null || entry.peerCertificates.length == 0)
            {
                throw new SSLPeerUnverifiedException(null);
            } else
            {
                return ((X509Certificate)entry.peerCertificates[0]).getSubjectX500Principal();
            }
        }

        public List getServerCertificateChain()
            throws SSLPeerUnverifiedException
        {
            if (entry.peerCertificates == null || entry.peerCertificates.length == 0)
            {
                throw new SSLPeerUnverifiedException(null);
            } else
            {
                return Arrays.asList((Object[])entry.peerCertificates.clone());
            }
        }

        public EntrySecureCacheResponse(DiskLruCache.Entry entry1, DiskLruCache.Snapshot snapshot)
        {
            entry = entry1;
            in = snapshot.getInputStream(1);
        }
    }


    // Unreferenced inner class com/twinprime/TwinPrimeSDK/libcore/HttpResponseCache$CacheRequestImpl$1

/* anonymous class */
    class CacheRequestImpl._cls1 extends FilterOutputStream
    {

        final CacheRequestImpl this$0;
        final DiskLruCache.Editor val$editor;

        public void close()
            throws IOException
        {
            super.close();
            editor.commit();
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
        }

            
            {
                this$0 = final_cacherequestimpl;
                editor = editor1;
                super(OutputStream.this);
            }
    }

}
