// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// Referenced classes of package com.google.tagmanager:
//            Log, JsonUtils, ProtoExtensionRegistry, LoadCallback, 
//            PreviewManager

class ResourceStorageImpl
    implements Container.ResourceStorage
{

    private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
    private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
    private LoadCallback mCallback;
    private final String mContainerId;
    private final Context mContext;
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    ResourceStorageImpl(Context context, String s)
    {
        mContext = context;
        mContainerId = s;
    }

    private String stringFromInputStream(InputStream inputstream)
        throws IOException
    {
        StringWriter stringwriter = new StringWriter();
        char ac[] = new char[1024];
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        do
        {
            int i = inputstream.read(ac);
            if (i != -1)
            {
                stringwriter.write(ac, 0, i);
            } else
            {
                return stringwriter.toString();
            }
        } while (true);
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        mExecutor.shutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    File getResourceFile()
    {
        String s = (new StringBuilder()).append("resource_").append(mContainerId).toString();
        return new File(mContext.getDir("google_tagmanager", 0), s);
    }

    public ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String s)
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        Log.v((new StringBuilder()).append("loading default container from ").append(s).toString());
        obj1 = mContext.getAssets();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Log.w("Looking for default JSON container in package, but no assets were found.");
        s = obj2;
_L3:
        return s;
_L2:
        Object obj;
        InputStream inputstream;
        InputStream inputstream1;
        inputstream1 = null;
        obj = null;
        inputstream = null;
        obj1 = ((AssetManager) (obj1)).open(s);
        inputstream = ((InputStream) (obj1));
        inputstream1 = ((InputStream) (obj1));
        obj = obj1;
        ResourceUtil.ExpandedResource expandedresource = JsonUtils.expandedResourceFromJsonString(stringFromInputStream(((InputStream) (obj1))));
        obj = expandedresource;
        s = ((String) (obj));
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return ((ResourceUtil.ExpandedResource) (obj));
            }
            return ((ResourceUtil.ExpandedResource) (obj));
        }
          goto _L3
        obj;
        obj = inputstream;
        Log.w((new StringBuilder()).append("No asset file: ").append(s).append(" found (or errors reading it).").toString());
        s = obj2;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return null;
        }
          goto _L3
        JSONException jsonexception;
        jsonexception;
        obj = inputstream1;
        Log.w((new StringBuilder()).append("Error parsing JSON file").append(s).append(" : ").append(jsonexception).toString());
        s = obj2;
        if (inputstream1 == null) goto _L3; else goto _L4
_L4:
        try
        {
            inputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return null;
        s;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception) { }
        }
        throw s;
    }

    public com.google.analytics.containertag.proto.Serving.Resource loadResourceFromContainerAsset(String s)
    {
        Object obj;
        Log.v((new StringBuilder()).append("Loading default container from ").append(s).toString());
        obj = mContext.getAssets();
        if (obj == null)
        {
            Log.e("No assets found in package");
            return null;
        }
        com.google.analytics.containertag.proto.Serving.Resource resource;
        try
        {
            obj = ((AssetManager) (obj)).open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w((new StringBuilder()).append("No asset file: ").append(s).append(" found.").toString());
            return null;
        }
        resource = com.google.analytics.containertag.proto.Serving.Resource.parseFrom(((InputStream) (obj)), ProtoExtensionRegistry.getRegistry());
        Log.v((new StringBuilder()).append("Parsed default container: ").append(resource).toString());
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return resource;
        }
        return resource;
        IOException ioexception1;
        ioexception1;
        Log.w((new StringBuilder()).append("Error when parsing: ").append(s).toString());
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        return null;
        s;
        try
        {
            ((InputStream) (obj)).close();
        }
        catch (IOException ioexception) { }
        throw s;
    }

    void loadResourceFromDisk()
    {
        Object obj;
        if (mCallback == null)
        {
            throw new IllegalStateException("callback must be set before execute");
        }
        mCallback.startLoad();
        Log.v("Start loading resource from disk ...");
        if ((PreviewManager.getInstance().getPreviewMode() == PreviewManager.PreviewMode.CONTAINER || PreviewManager.getInstance().getPreviewMode() == PreviewManager.PreviewMode.CONTAINER_DEBUG) && mContainerId.equals(PreviewManager.getInstance().getContainerId()))
        {
            mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
            return;
        }
        try
        {
            obj = new FileInputStream(getResourceFile());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.d("resource not on disk");
            mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
            return;
        }
        mCallback.onSuccess(com.google.tagmanager.proto.Resource.ResourceWithMetadata.parseFrom(((InputStream) (obj)), ProtoExtensionRegistry.getRegistry()));
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w("error closing stream for reading resource from disk");
        }
_L2:
        Log.v("Load resource from disk finished.");
        return;
        Object obj1;
        obj1;
        Log.w("error reading resource from disk");
        mCallback.onFailure(LoadCallback.Failure.IO_ERROR);
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w("error closing stream for reading resource from disk");
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            Log.w("error closing stream for reading resource from disk");
        }
        throw obj1;
    }

    public void loadResourceFromDiskInBackground()
    {
        mExecutor.execute(new Runnable() {

            final ResourceStorageImpl this$0;

            public void run()
            {
                loadResourceFromDisk();
            }

            
            {
                this$0 = ResourceStorageImpl.this;
                super();
            }
        });
    }

    boolean saveResourceToDisk(com.google.tagmanager.proto.Resource.ResourceWithMetadata resourcewithmetadata)
    {
        FileOutputStream fileoutputstream;
        File file;
        file = getResourceFile();
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.tagmanager.proto.Resource.ResourceWithMetadata resourcewithmetadata)
        {
            Log.e("Error opening resource file for writing");
            return false;
        }
        resourcewithmetadata.writeTo(fileoutputstream);
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.tagmanager.proto.Resource.ResourceWithMetadata resourcewithmetadata)
        {
            Log.w("error closing stream for writing resource to disk");
        }
        return true;
        resourcewithmetadata;
        Log.w("Error writing resource to disk. Removing resource from disk.");
        file.delete();
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.tagmanager.proto.Resource.ResourceWithMetadata resourcewithmetadata)
        {
            Log.w("error closing stream for writing resource to disk");
        }
        return false;
        resourcewithmetadata;
        try
        {
            fileoutputstream.close();
        }
        catch (IOException ioexception)
        {
            Log.w("error closing stream for writing resource to disk");
        }
        throw resourcewithmetadata;
    }

    public void saveResourceToDiskInBackground(final com.google.tagmanager.proto.Resource.ResourceWithMetadata resource)
    {
        mExecutor.execute(new Runnable() {

            final ResourceStorageImpl this$0;
            final com.google.tagmanager.proto.Resource.ResourceWithMetadata val$resource;

            public void run()
            {
                saveResourceToDisk(resource);
            }

            
            {
                this$0 = ResourceStorageImpl.this;
                resource = resourcewithmetadata;
                super();
            }
        });
    }

    public void setLoadCallback(LoadCallback loadcallback)
    {
        mCallback = loadcallback;
    }
}
