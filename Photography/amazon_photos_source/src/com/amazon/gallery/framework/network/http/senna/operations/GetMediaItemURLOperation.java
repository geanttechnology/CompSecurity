// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.image.ImageUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.network.exceptions.InvalidMediaItemException;
import com.amazon.gallery.framework.network.exceptions.MediaItemIdErrorHandler;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMediaItemURLOperation
    implements com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/GetMediaItemURLOperation.getName();
    private String downloadUrl;
    private int downloadedHeight;
    private int downloadedWidth;
    private com.amazon.gallery.framework.network.http.rest.RestClient.Operation getMediaItemOperation;
    private MediaItemIdErrorHandler mediaItemIdErrorHandler;
    private SennaMediaType mediaType;
    private long originalFileSizeBytes;
    private int requestedHeight;
    private int requestedWidth;
    private ScaleMode scaleMode;
    private final boolean useOriginal = false;

    public GetMediaItemURLOperation(SennaMediaType sennamediatype, int i, int j, ScaleMode scalemode, com.amazon.gallery.framework.network.http.rest.RestClient.Operation operation, MediaItemIdErrorHandler mediaitemiderrorhandler)
    {
        mediaType = sennamediatype;
        requestedWidth = i;
        requestedHeight = j;
        scaleMode = scalemode;
        getMediaItemOperation = operation;
        mediaItemIdErrorHandler = mediaitemiderrorhandler;
    }

    public volatile Object get()
        throws TerminalException, TransientException
    {
        return get();
    }

    public String get()
        throws TerminalException, TransientException
    {
        if (downloadUrl != null) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        int j;
        try
        {
            obj = (JSONObject)getMediaItemOperation.get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            mediaItemIdErrorHandler.handleMediaItemIdError();
            throw obj;
        }
        if (obj == null) goto _L2; else goto _L3
_L3:
        originalFileSizeBytes = ((JSONObject) (obj)).getLong("size");
        i = ((JSONObject) (obj)).getInt("width");
        j = ((JSONObject) (obj)).getInt("height");
        if (!useOriginal) goto _L5; else goto _L4
_L4:
        downloadUrl = ((JSONObject) (obj)).getString("downloadOriginal");
        downloadedWidth = i;
        downloadedHeight = j;
_L6:
        if (downloadUrl == null)
        {
            throw new TerminalException("Failed to get download url.");
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = getAssets(((JSONObject) (obj)).getJSONArray("images"));
        if (obj != null)
        {
            try
            {
                downloadUrl = processImageURLs(((List) (obj)), i, j);
            }
            catch (JSONException jsonexception)
            {
                GLogger.e(TAG, "Failed to get media item download urls", new Object[] {
                    jsonexception
                });
            }
        }
        if (true) goto _L6; else goto _L2
_L2:
        return downloadUrl;
    }

    public List getAssets(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
_L2:
        Object obj;
label0:
        {
            obj = arraylist;
            try
            {
                if (i < jsonarray.length())
                {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    obj = new HashMap();
                    String s1;
                    for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((Map) (obj)).put(s1, jsonobject.get(s1)))
                    {
                        s1 = (String)iterator.next();
                    }

                    break label0;
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                GLogger.e(TAG, jsonarray.getMessage(), new Object[] {
                    jsonarray
                });
                obj = null;
            }
            return ((List) (obj));
        }
        String s = (String)((Map) (obj)).get("mediaType");
        GLogger.d(TAG, "mediaType=[%s]", new Object[] {
            s
        });
        if (mediaType == SennaMediaType.valueOf(s))
        {
            arraylist.add(obj);
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String processImageURLs(List list, int i, int j)
    {
        Collections.sort(list, new Comparator() {

            final GetMediaItemURLOperation this$0;

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Map)obj, (Map)obj1);
            }

            public int compare(Map map, Map map1)
            {
                return ImageUtils.objectToInt(map.get("width")) - ImageUtils.objectToInt(map1.get("width"));
            }

            
            {
                this$0 = GetMediaItemURLOperation.this;
                super();
            }
        });
        list = ImageUtils.getMatchJSONImage(list, requestedWidth, requestedHeight, scaleMode, i, j);
        if (list != null)
        {
            downloadedWidth = ImageUtils.objectToInt(list.get("width"));
            downloadedHeight = ImageUtils.objectToInt(list.get("height"));
            return (String)list.get("url");
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("GetMediaItemURLOperation{requestedWidth=").append(requestedWidth).append(", requestedHeight=").append(requestedHeight).append(", downloadUrl='").append(downloadUrl).append('\'').append(", downloadedWidth=").append(downloadedWidth).append(", downloadedHeight=").append(downloadedHeight).append(", mediaType=").append(mediaType).append(", originalFileSizeBytes=").append(originalFileSizeBytes).append('}').toString();
    }

}
