// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.httpcomponentsandroid.client.cache.InputLimit;
import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            FileResourceFactory, ResourceReference, FileResource

public class ManagedFileResourceFactory
    implements ResourceFactory
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory);
    private boolean cacheDirInitialized;
    private final FileResourceFactory _flddelegate;
    private final File resourceDirectory;
    private final List resourceReferences = new ArrayList();
    private final ReferenceQueue unusedResourceQueue = new ReferenceQueue();

    public ManagedFileResourceFactory(File file)
    {
        cacheDirInitialized = false;
        resourceDirectory = file;
        _flddelegate = new FileResourceFactory(resourceDirectory);
    }

    private void initializeResourceDirOnce()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = cacheDirInitialized;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!resourceDirectory.exists() && !resourceDirectory.mkdir())
        {
            throw new CimIOException("Failed to create resource directory");
        }
        break MISSING_BLOCK_LABEL_49;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        FileUtils.cleanDirectory(resourceDirectory);
        cacheDirInitialized = true;
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw new CimIOException(((IOException) (obj)));
    }

    private void registerResourceReference(Resource resource)
    {
        if (resource != null)
        {
            resourceReferences.add(new ResourceReference(((FileResource)resource).getFile(), resource, unusedResourceQueue));
        }
    }

    public void cleanUnusedResources()
    {
        do
        {
            ResourceReference resourcereference = (ResourceReference)unusedResourceQueue.poll();
            if (resourcereference != null)
            {
                File file = resourcereference.getBackingFile();
                if (!file.delete())
                {
                    LOG.warn("Failed to delete unused backing file {}", file);
                } else
                {
                    LOG.debug("Deleted an unused backing file {}", file);
                }
                resourceReferences.remove(resourcereference);
            } else
            {
                return;
            }
        } while (true);
    }

    public Resource copy(String s, Resource resource)
        throws IOException
    {
        initializeResourceDirOnce();
        s = _flddelegate.copy(s, resource);
        registerResourceReference(s);
        cleanUnusedResources();
        return s;
    }

    public Resource generate(String s, InputStream inputstream, InputLimit inputlimit)
        throws IOException
    {
        initializeResourceDirOnce();
        s = _flddelegate.generate(s, inputstream, inputlimit);
        registerResourceReference(s);
        cleanUnusedResources();
        return s;
    }

}
