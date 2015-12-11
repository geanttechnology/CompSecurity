// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import com.gotv.crackle.Application;
import com.gotv.crackle.data.SubtitlesParser;
import com.gotv.crackle.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

// Referenced classes of package com.gotv.crackle.model:
//            MediaUrlItem

public class RelatedItem
{

    private static final String PORTUGUESE_CODE = "pt-BR";
    private static final String SPANISH_CODE = "es-MX";
    String id;
    String localizedLanguage;
    private Map mClosedCaptionFileUrls;
    private Map mClosedCaptionFiles;
    private Map mClosedCaptionLangauges;
    private Map mClosedCaptionLocales;
    private String mDefaultLang;
    Map mMediaUrls;
    String title;

    public RelatedItem(JSONObject jsonobject)
    {
        mMediaUrls = new HashMap();
        mClosedCaptionFiles = new TreeMap();
        mClosedCaptionFileUrls = new TreeMap();
        mClosedCaptionLocales = new TreeMap();
        mClosedCaptionLangauges = new TreeMap();
        JSONArray jsonarray;
        id = jsonobject.optString("ID");
        title = jsonobject.optString("Title");
        localizedLanguage = jsonobject.optString("LocalizedLanguage");
        jsonarray = jsonobject.getJSONArray("MediaURLs");
        Log.d("MEDIA URL", (new StringBuilder()).append("MEDIA URL = ").append(jsonarray.toString()).toString());
        int i = 0;
_L10:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new MediaUrlItem();
        obj.path = jsonarray.getJSONObject(i).optString("Path").trim().replace(" ", "");
        obj.useDrm = jsonarray.getJSONObject(i).getBoolean("UseDRM");
_L8:
        Object obj1;
        JSONException jsonexception;
        JSONArray jsonarray1;
        String s;
        int j;
        try
        {
            obj.drmPath = jsonarray.getJSONObject(i).optString("DRMPath").trim().replace(" ", "");
        }
        catch (JSONException jsonexception1) { }
        obj1 = jsonarray.getJSONObject(i).optString("Type");
        mMediaUrls.put(obj1, obj);
        obj1 = new SubtitlesParser();
        jsonarray1 = jsonobject.optJSONArray("ClosedCaptionFiles");
        if (jsonarray1 == null) goto _L4; else goto _L3
_L3:
        j = 0;
_L12:
        if (j >= jsonarray1.length()) goto _L4; else goto _L5
_L5:
        s = ((JSONObject)jsonarray1.get(j)).optString("Locale");
        if (!s.equalsIgnoreCase("es-MX")) goto _L7; else goto _L6
_L6:
        obj = Application.getInstance().getString(0x7f0b00d2);
_L9:
        String s1 = ((JSONObject)jsonarray1.get(j)).optString("Path");
        java.util.List list = ((SubtitlesParser) (obj1)).parseDFXP(s1);
        mClosedCaptionFiles.put(obj, list);
        mClosedCaptionFileUrls.put(obj, s1);
        mClosedCaptionLocales.put(obj, s);
        mClosedCaptionLangauges.put(s, obj);
        if (((JSONObject)jsonarray1.get(j)).getBoolean("Default"))
        {
            mDefaultLang = ((String) (obj));
        }
        break MISSING_BLOCK_LABEL_485;
        jsonexception;
        obj.useDrm = false;
          goto _L8
        jsonobject;
_L11:
        jsonobject.printStackTrace();
_L2:
        return;
_L7:
label0:
        {
            if (!s.equalsIgnoreCase("pt-BR"))
            {
                break label0;
            }
            obj = Application.getInstance().getString(0x7f0b00d3);
        }
          goto _L9
        obj = Application.getInstance().getString(0x7f0b00d1);
          goto _L9
_L4:
        i++;
          goto _L10
        jsonobject;
          goto _L11
        jsonobject;
          goto _L11
        jsonobject;
          goto _L11
        j++;
          goto _L12
    }

    public String getCaptionLocaleFromLanguage(String s)
    {
        return (String)mClosedCaptionLocales.get(s);
    }

    public Map getClosedCaptionFiles()
    {
        return mClosedCaptionFiles;
    }

    public String getId()
    {
        return id;
    }

    public String getLocalizedLanguage()
    {
        return localizedLanguage;
    }

    public Map getMediaUrls()
    {
        return mMediaUrls;
    }

    public String getTitle()
    {
        return title;
    }
}
