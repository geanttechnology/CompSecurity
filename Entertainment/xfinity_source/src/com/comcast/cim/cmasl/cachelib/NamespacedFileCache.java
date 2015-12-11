// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.cachelib;

import android.content.Context;
import android.support.v4.util.LruCache;
import com.comcast.cim.cmasl.utils.StorageCache;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.cachelib:
//            NormalizerFactory, Normalizer

public class NamespacedFileCache
    implements StorageCache
{
    private static class DefaultNormalizer
        implements Normalizer
    {

        private final LruCache keyCache;
        private final String namespace;

        public String normalize(String s)
        {
            LruCache lrucache = keyCache;
            lrucache;
            JVM INSTR monitorenter ;
            String s2 = (String)keyCache.get(s);
            String s1;
            s1 = s2;
            if (s2 != null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            s1 = new String(Hex.encodeHex(DigestUtils.sha(s)));
            keyCache.put(s, s1);
            s = (new StringBuilder()).append(namespace).append(".").append(s1).toString();
            lrucache;
            JVM INSTR monitorexit ;
            return s;
            s;
            lrucache;
            JVM INSTR monitorexit ;
            throw s;
        }

        private DefaultNormalizer(String s)
        {
            keyCache = new LruCache(30);
            namespace = s;
        }

    }

    private static class DefaultNormalizerFactory
        implements NormalizerFactory
    {

        public Normalizer get(String s)
        {
            return new DefaultNormalizer(s);
        }

        private DefaultNormalizerFactory()
        {
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/cachelib/NamespacedFileCache);
    private final Context context;
    private final String namespace;
    private final Normalizer normalizer;

    public NamespacedFileCache(Context context1, String s)
    {
        this(context1, s, ((NormalizerFactory) (new DefaultNormalizerFactory())));
    }

    public NamespacedFileCache(Context context1, String s, NormalizerFactory normalizerfactory)
    {
        Validate.notNull(context1);
        Validate.notBlank(s);
        context = context1;
        namespace = s;
        normalizer = normalizerfactory.get(s);
    }

    public void remove(String s)
    {
        s = normalizer.normalize(s);
        context.deleteFile(s);
    }

    public void removeAll()
    {
        LOG.debug("Removing all entries for namespace {}", namespace);
        File afile[] = context.getFilesDir().listFiles(new FilenameFilter() {

            final NamespacedFileCache this$0;

            public boolean accept(File file1, String s)
            {
                return s.startsWith(namespace);
            }

            
            {
                this$0 = NamespacedFileCache.this;
                super();
            }
        });
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            context.deleteFile(file.getName());
        }

    }

    public InputStream retrieve(String s)
    {
        s = normalizer.normalize(s);
        try
        {
            s = context.openFileInput(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void store(InputStream inputstream, String s)
    {
        java.io.FileOutputStream fileoutputstream;
        java.io.FileOutputStream fileoutputstream1;
        Object obj;
        obj = normalizer.normalize(s);
        fileoutputstream1 = null;
        fileoutputstream = null;
        java.io.FileOutputStream fileoutputstream2 = context.openFileOutput(((String) (obj)), 0);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        IOUtils.copy(inputstream, fileoutputstream2);
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream2);
        return;
        IOException ioexception;
        ioexception;
        fileoutputstream1 = fileoutputstream;
        boolean flag = context.deleteFile(((String) (obj)));
        fileoutputstream1 = fileoutputstream;
        obj = (new StringBuilder()).append("Failed to store stream with key ").append(s).append(", cache file was ");
        if (flag)
        {
            s = "deleted";
        } else
        {
            s = "not deleted";
        }
        fileoutputstream1 = fileoutputstream;
        throw new CimException(((StringBuilder) (obj)).append(s).toString(), ioexception);
        s;
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream1);
        throw s;
    }


}
