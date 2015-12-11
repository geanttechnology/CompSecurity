// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.InputLimit;
import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            BasicIdGenerator, FileResource

public class FileResourceFactory
    implements ResourceFactory
{

    private final File cacheDir;
    private final BasicIdGenerator idgen = new BasicIdGenerator();

    public FileResourceFactory(File file)
    {
        cacheDir = file;
    }

    private File generateUniqueCacheFile(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        idgen.generate(stringbuilder);
        stringbuilder.append('.');
        int j = Math.min(s.length(), 100);
        int i = 0;
        while (i < j) 
        {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c) || c == '.')
            {
                stringbuilder.append(c);
            } else
            {
                stringbuilder.append('-');
            }
            i++;
        }
        return new File(cacheDir, stringbuilder.toString());
    }

    public Resource copy(String s, Resource resource)
        throws IOException
    {
        File file = generateUniqueCacheFile(s);
        if (!(resource instanceof FileResource)) goto _L2; else goto _L1
_L1:
        FileUtils.copyFile(((FileResource)resource).getFile(), file);
_L4:
        return new FileResource(file);
_L2:
        s = new FileOutputStream(file);
        resource = resource.getInputStream();
        IOUtils.copy(resource, s);
        IOUtils.closeQuietly(resource);
        IOUtils.closeQuietly(s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        IOUtils.closeQuietly(resource);
        IOUtils.closeQuietly(s);
        throw exception;
    }

    public Resource generate(String s, InputStream inputstream, InputLimit inputlimit)
        throws IOException
    {
        File file;
        file = generateUniqueCacheFile(s);
        s = new FileOutputStream(file);
        byte abyte0[] = new byte[2048];
        long l = 0L;
_L2:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        s.write(abyte0, 0, i);
        long l1;
        l1 = l + (long)i;
        l = l1;
        if (inputlimit == null) goto _L2; else goto _L1
_L1:
        l = l1;
        if (l1 <= inputlimit.getValue()) goto _L2; else goto _L3
_L3:
        inputlimit.reached();
        s.close();
        return new FileResource(file);
        inputstream;
        s.close();
        throw inputstream;
    }
}
