// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.jayway.jsonpath.InvalidPathException;
import com.playhaven.android.cache.Cache;
import com.playhaven.android.cache.CacheResponseHandler;
import com.playhaven.android.cache.CachedInfo;
import com.playhaven.android.data.ContentUnitType;
import com.playhaven.android.data.JsonUrlExtractor;
import com.playhaven.android.req.ContentDispatchRequest;
import com.playhaven.android.req.ContentDispatchType;
import com.playhaven.android.req.ContentRequest;
import com.playhaven.android.req.NoContentException;
import com.playhaven.android.req.RequestListener;
import com.playhaven.android.util.JsonUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

// Referenced classes of package com.playhaven.android:
//            PlacementListener, PlayHavenException, PlayHaven

public class Placement
    implements Parcelable, CacheResponseHandler, RequestListener
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected Cache cache;
    private String contentModel;
    private JSONObject customDimensions;
    private String dispatchModel;
    protected boolean isLoading;
    private PlacementListener listener;
    protected String placementTag;

    public Placement(Parcel parcel)
    {
        isLoading = false;
        readFromParcel(parcel);
    }

    public Placement(String s)
    {
        isLoading = false;
        placementTag = s;
    }

    public void addDimension(String s, Object obj)
    {
        if (customDimensions == null)
        {
            customDimensions = new JSONObject();
        }
        customDimensions.put(s, obj);
    }

    public void addDimensions(Map map)
    {
        if (customDimensions == null)
        {
            customDimensions = new JSONObject();
        }
        customDimensions.putAll(map);
    }

    public void cacheFail(URL url, PlayHavenException playhavenexception)
    {
        contentFailed(playhavenexception);
    }

    public transient void cacheSuccess(CachedInfo acachedinfo[])
    {
        contentLoaded();
    }

    protected void contentFailed(PlayHavenException playhavenexception)
    {
        isLoading = false;
        if (listener != null)
        {
            listener.contentFailed(this, playhavenexception);
        }
    }

    protected void contentLoaded()
    {
        if (contentModel != null || dispatchModel != null)
        {
            isLoading = false;
            if (listener != null)
            {
                listener.contentLoaded(this);
                return;
            }
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDispatchModel()
    {
        return dispatchModel;
    }

    public PlacementListener getListener()
    {
        return listener;
    }

    public String getModel()
    {
        if (contentModel == null && dispatchModel != null)
        {
            return getDispatchModel();
        } else
        {
            return contentModel;
        }
    }

    public String getPlacementTag()
    {
        return placementTag;
    }

    protected void handleContentDispatchResponse(Context context, String s)
    {
        setDispatchModel(s);
        try
        {
            switch (_cls2..SwitchMap.com.playhaven.android.req.ContentDispatchType[ContentDispatchType.getType(dispatchModel).ordinal()])
            {
            case 1: // '\001'
                s = new ContentDispatchRequest(dispatchModel);
                if (customDimensions != null && customDimensions.size() > 0)
                {
                    s.addDimensions(customDimensions);
                }
                s.setPreload(true);
                s.setResponseHandler(this);
                s.send(context);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            contentFailed(context);
            return;
        }
    }

    protected void handleContentResponse(Context context, String s)
    {
        try
        {
            processContentResponse(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (dispatchModel != null && !dispatchModel.equals(s))
        {
            try
            {
                processContentResponse(dispatchModel);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                PlayHaven.e(s);
            }
        }
        contentFailed(context);
    }

    public void handleResponse(Context context, PlayHavenException playhavenexception)
    {
        contentFailed(playhavenexception);
    }

    public void handleResponse(Context context, String s)
    {
        switch (_cls2..SwitchMap.com.playhaven.android.data.ContentUnitType[ContentUnitType.getType(s).ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            handleContentResponse(context, s);
            return;

        case 2: // '\002'
            handleContentDispatchResponse(context, s);
            break;
        }
    }

    public boolean isDisplayable()
    {
        return isLoaded() && !isEmpty();
    }

    public boolean isEmpty()
    {
        while (!isLoaded() || JsonUtil.getPath(contentModel, "$.response") == null) 
        {
            return true;
        }
        return false;
    }

    public boolean isFullscreenCompatible()
    {
        Integer integer1 = Integer.valueOf(1);
        Integer integer = integer1;
        if (contentModel != null)
        {
            try
            {
                integer = JsonUtil.asInteger(contentModel, "$.response.resizable");
            }
            catch (ClassCastException classcastexception)
            {
                PlayHaven.v("Unable to ascertain fullscreen compatibility from JSON, invalid value.", new Object[0]);
                classcastexception = integer1;
            }
            catch (InvalidPathException invalidpathexception)
            {
                PlayHaven.v("Unable to ascertain fullscreen compatibility from JSON, missing value.", new Object[0]);
                invalidpathexception = integer1;
            }
        }
        return integer.intValue() == 1;
    }

    public boolean isLoaded()
    {
        return contentModel != null;
    }

    public boolean isLoading()
    {
        return isLoading;
    }

    public void preload(Context context)
    {
        if (isLoading)
        {
            return;
        }
        if (placementTag == null)
        {
            PlayHaven.d("Skipping 'null' placement", new Object[0]);
            return;
        }
        PlayHaven.d("Start server call: %s", new Object[] {
            placementTag
        });
        isLoading = true;
        ContentRequest contentrequest;
        try
        {
            if (cache == null)
            {
                cache = new Cache(context);
            }
        }
        catch (PlayHavenException playhavenexception)
        {
            contentFailed(playhavenexception);
        }
        contentrequest = new ContentRequest(placementTag);
        if (customDimensions != null && customDimensions.size() > 0)
        {
            contentrequest.addDimensions(customDimensions);
        }
        contentrequest.setPreload(true);
        contentrequest.setResponseHandler(this);
        contentrequest.send(context);
    }

    protected void preloadContent(String s)
        throws PlayHavenException
    {
        try
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(JsonUrlExtractor.getContentTemplates(s));
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                arraylist.addAll(JsonUrlExtractor.getImages(s));
            }
            cache.bulkRequest(this, arraylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new PlayHavenException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new PlayHavenException(s.getMessage());
        }
    }

    protected void processContentResponse(String s)
        throws PlayHavenException
    {
        validateModel(s);
        setModel(s);
        preloadContent(s);
    }

    protected void readFromParcel(Parcel parcel)
    {
        setPlacementTag(parcel.readString());
        contentModel = parcel.readString();
        dispatchModel = parcel.readString();
        parcel = parcel.readString();
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        customDimensions = (JSONObject)(new JSONParser(448)).parse(parcel);
        return;
        parcel;
        PlayHaven.d(parcel.getMessage(), new Object[0]);
        return;
    }

    public void reset()
    {
        isLoading = false;
        contentModel = null;
    }

    public void setDispatchModel(String s)
    {
        dispatchModel = s;
    }

    public void setListener(PlacementListener placementlistener)
    {
        listener = placementlistener;
    }

    public void setModel(String s)
    {
        contentModel = s;
    }

    public void setPlacementTag(String s)
    {
        placementTag = s;
    }

    protected void validateModel(String s)
        throws PlayHavenException
    {
        if (s == null)
        {
            throw new PlayHavenException("No returned model");
        }
        String s1 = (String)JsonUtil.getPath(s, "$.error");
        if (s1 != null)
        {
            throw new PlayHavenException(s1);
        }
        if (!JsonUtil.hasPath(s, "$.response.context.content"))
        {
            throw new NoContentException();
        } else
        {
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(placementTag);
        if (contentModel == null)
        {
            parcel.writeString(null);
        } else
        {
            try
            {
                parcel.writeString(contentModel);
            }
            catch (Exception exception)
            {
                PlayHaven.w(exception);
                parcel.writeString(null);
            }
        }
        if (dispatchModel == null)
        {
            parcel.writeString(null);
        } else
        {
            try
            {
                parcel.writeString(dispatchModel);
            }
            catch (Exception exception1)
            {
                PlayHaven.w(exception1);
                parcel.writeString(null);
            }
        }
        if (customDimensions == null)
        {
            parcel.writeString(null);
            return;
        } else
        {
            parcel.writeString(customDimensions.toString());
            return;
        }
    }


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
