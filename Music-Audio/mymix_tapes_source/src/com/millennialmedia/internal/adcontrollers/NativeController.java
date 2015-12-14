// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.MMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            AdController

public class NativeController extends AdController
{
    public static class Asset
    {

        public Data data;
        public int id;
        public Image image;
        public Link link;
        public boolean required;
        public Title title;
        public Type type;
        public Video video;

        Asset(Type type1, int i, boolean flag)
        {
            required = false;
            type = type1;
            id = i;
            required = flag;
        }
    }

    public static class Asset.Data
    {

        public String label;
        public String value;

        public Asset.Data()
        {
        }
    }

    public static class Asset.Image
    {

        public Integer height;
        public String url;
        public Integer width;

        public Asset.Image()
        {
        }
    }

    public static class Asset.Title
    {

        public String value;

        public Asset.Title()
        {
        }
    }

    public static final class Asset.Type extends Enum
    {

        private static final Asset.Type $VALUES[];
        public static final Asset.Type DATA;
        public static final Asset.Type IMAGE;
        public static final Asset.Type TITLE;
        public static final Asset.Type UNKNOWN;
        public static final Asset.Type VIDEO;

        public static Asset.Type valueOf(String s)
        {
            return (Asset.Type)Enum.valueOf(com/millennialmedia/internal/adcontrollers/NativeController$Asset$Type, s);
        }

        public static Asset.Type[] values()
        {
            return (Asset.Type[])$VALUES.clone();
        }

        static 
        {
            TITLE = new Asset.Type("TITLE", 0);
            IMAGE = new Asset.Type("IMAGE", 1);
            VIDEO = new Asset.Type("VIDEO", 2);
            DATA = new Asset.Type("DATA", 3);
            UNKNOWN = new Asset.Type("UNKNOWN", 4);
            $VALUES = (new Asset.Type[] {
                TITLE, IMAGE, VIDEO, DATA, UNKNOWN
            });
        }

        private Asset.Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Asset.Video
    {

        public String vastTag;

        public Asset.Video()
        {
        }
    }

    public static class Link
    {

        public List clickTrackerUrls;
        public String fallback;
        public String url;

        public Link()
        {
        }
    }

    public static interface NativeControllerListener
    {

        public abstract void initFailed(Throwable throwable);

        public abstract void initSucceeded();
    }


    private static final String TAG = com/millennialmedia/internal/adcontrollers/NativeController.getName();
    public List assets;
    public List impTrackers;
    public String jsTracker;
    public Link link;
    private NativeControllerListener nativeControllerListener;
    public int version;

    public NativeController()
    {
        version = 1;
    }

    public NativeController(NativeControllerListener nativecontrollerlistener)
    {
        version = 1;
        nativeControllerListener = nativecontrollerlistener;
    }

    private void loadAssets(JSONArray jsonarray)
        throws JSONException
    {
        int i;
        assets = new ArrayList();
        i = 0;
_L5:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        Object obj;
        JSONObject jsonobject;
        int j;
        boolean flag;
        obj = null;
        jsonobject = jsonarray.getJSONObject(i);
        j = jsonobject.getInt("id");
        flag = false;
        if (jsonobject.optInt("required") > 0)
        {
            flag = true;
        }
        if (!jsonobject.has("title")) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject1;
        jsonobject1 = jsonobject.getJSONObject("title");
        obj = new Asset(Asset.Type.TITLE, j, flag);
        obj.title = new Asset.Title();
        ((Asset) (obj)).title.value = jsonobject1.getString("text");
_L6:
        if (obj != null)
        {
            JSONException jsonexception;
            JSONObject jsonobject2;
            try
            {
                obj.link = loadLink(jsonobject.getJSONObject("link"));
            }
            catch (JSONException jsonexception3) { }
            assets.add(obj);
        }
        i++;
          goto _L5
        obj;
_L15:
        obj = null;
          goto _L6
_L4:
        if (!jsonobject.has("img")) goto _L8; else goto _L7
_L7:
        jsonobject2 = jsonobject.getJSONObject("img");
        obj = new Asset(Asset.Type.IMAGE, j, flag);
        obj.image = new Asset.Image();
        ((Asset) (obj)).image.url = jsonobject2.getString("url");
        JSONException jsonexception1;
        try
        {
            ((Asset) (obj)).image.width = Integer.valueOf(jsonobject2.getInt("w"));
        }
        catch (JSONException jsonexception5) { }
        try
        {
            ((Asset) (obj)).image.height = Integer.valueOf(jsonobject2.getInt("h"));
        }
        catch (JSONException jsonexception4) { }
          goto _L6
        obj;
_L14:
        obj = null;
          goto _L6
_L8:
        if (!jsonobject.has("video")) goto _L10; else goto _L9
_L9:
        jsonobject2 = jsonobject.getJSONObject("video");
        obj = new Asset(Asset.Type.VIDEO, j, flag);
        obj.video = new Asset.Video();
        ((Asset) (obj)).video.vastTag = jsonobject2.getString("vasttag");
          goto _L6
        obj;
_L13:
        obj = null;
          goto _L6
_L10:
        if (!jsonobject.has("data")) goto _L6; else goto _L11
_L11:
        jsonobject2 = jsonobject.getJSONObject("data");
        obj = new Asset(Asset.Type.DATA, j, flag);
        obj.data = new Asset.Data();
        ((Asset) (obj)).data.value = jsonobject2.getString("value");
        ((Asset) (obj)).data.label = jsonobject2.optString("label", null);
          goto _L6
        jsonexception;
_L12:
        jsonexception = null;
          goto _L6
_L2:
        return;
        jsonexception1;
          goto _L12
        jsonexception1;
          goto _L13
        jsonexception1;
          goto _L14
        JSONException jsonexception2;
        jsonexception2;
          goto _L15
    }

    private Link loadLink(JSONObject jsonobject)
        throws JSONException
    {
        Link link1;
        link1 = new Link();
        link1.url = jsonobject.getString("url");
        if (!jsonobject.has("clicktrackers")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int i;
        try
        {
            jsonarray = jsonobject.getJSONArray("clicktrackers");
            link1.clickTrackerUrls = new ArrayList();
        }
        catch (JSONException jsonexception)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        link1.clickTrackerUrls.add(jsonarray.getString(i));
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L2
_L2:
        link1.fallback = jsonobject.optString("fallback", null);
        return link1;
    }

    public boolean canHandleContent(String s)
    {
        try
        {
            (new JSONObject(s)).getJSONObject("native");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public void init(String s)
    {
        JSONArray jsonarray;
        s = (new JSONObject(s)).getJSONObject("native");
        version = s.optInt("ver", version);
        loadAssets(s.getJSONArray("assets"));
        link = loadLink(s.getJSONObject("link"));
        jsonarray = s.optJSONArray("imptrackers");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        impTrackers = new ArrayList();
        int i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        impTrackers.add(jsonarray.getString(i));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            jsTracker = s.optString("jstracker", null);
            nativeControllerListener.initSucceeded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(TAG, "Initialization of the native controller instance failed", s);
        }
        nativeControllerListener.initFailed(s);
        return;
    }

}
