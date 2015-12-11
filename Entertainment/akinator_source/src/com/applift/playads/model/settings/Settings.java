// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.model.settings;

import com.applift.playads.model.JSONModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.droidparts.util.L;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applift.playads.model.settings:
//            Colors, Strings, Assets, SubmitSpec, 
//            TypeSpec

public class Settings extends JSONModel
{

    private static final long serialVersionUID = 1L;
    public final SubmitSpec appListSubmit;
    public final int appSubmitFrequencyDays;
    public final Assets assets;
    public final boolean backgroundRedirectEnabled;
    public final Colors colors;
    public final Strings strings;
    public final List typeSpecs;
    private final int videoSkipTime;

    public Settings(JSONObject jsonobject)
        throws JSONException
    {
        super(jsonobject);
        colors = new Colors(jsonobject.getJSONObject("colors"));
        strings = new Strings(jsonobject.getJSONObject("strings"));
        assets = new Assets(jsonobject.getJSONObject("assets"));
        typeSpecs = getTypeSpecs(jsonobject.getJSONArray("ad_formats"));
        jsonobject = jsonobject.getJSONObject("settings");
        backgroundRedirectEnabled = jsonobject.getBoolean("background_redirect_enabled");
        appListSubmit = SubmitSpec.fromString(jsonobject.getString("apps_detection_status"));
        appSubmitFrequencyDays = jsonobject.getInt("apps_detection_frequency");
        videoSkipTime = jsonobject.getInt("video_skip_time");
    }

    private static List getTypeSpecs(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                arraylist.add(new TypeSpec(jsonarray.getJSONObject(i)));
            }
            catch (Exception exception)
            {
                L.w(exception);
            }
            i++;
        }
        return Collections.unmodifiableList(arraylist);
    }

    public int getVideoSkipTimeMs()
    {
        return videoSkipTime * 1000;
    }
}
