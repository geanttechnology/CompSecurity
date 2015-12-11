// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import android.content.Context;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.util.ListUtils;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.bitstrips.imoji.manager:
//            TemplatesManager

public class RecentImojiesManager
{
    public static interface Callback
    {

        public abstract void success();
    }


    private static final Type RECENT_DATA_TYPE = (new TypeToken() {

    }).getType();
    private static final int RECENT_LIST_MAX_SIZE = 6;
    private Gson gson;
    PreferenceUtils preferenceUtils;
    TemplatesManager templatesManager;
    private Map usersRecentData;

    public RecentImojiesManager(Context context)
    {
        ((InjectorApplication)context).inject(this);
        gson = (new GsonBuilder()).enableComplexMapKeySerialization().create();
        processLegacyCSV();
        usersRecentData = initUsersRecentData();
    }

    private String generateUserRecentKey()
    {
        String s = preferenceUtils.getString(0x7f06002a, "");
        return (String)Splitter.on("_").splitToList(s).get(0);
    }

    private List getRecentTemplateIds()
    {
        if (!usersRecentData.containsKey(generateUserRecentKey()))
        {
            return Lists.newArrayList();
        } else
        {
            return (List)usersRecentData.get(generateUserRecentKey());
        }
    }

    private Function imojiToTemplateId()
    {
        return new Function() {

            final RecentImojiesManager this$0;

            public volatile Object apply(Object obj)
            {
                return apply((Imoji)obj);
            }

            public String apply(Imoji imoji)
            {
                return imoji.getTemplateId();
            }

            
            {
                this$0 = RecentImojiesManager.this;
                super();
            }
        };
    }

    private Map initUsersRecentData()
    {
        Map map = (Map)gson.fromJson(preferenceUtils.getString(0x7f0600cb, null), RECENT_DATA_TYPE);
        Object obj = map;
        if (map == null)
        {
            obj = Maps.newHashMap();
        }
        return ((Map) (obj));
    }

    private List limitCountOfRecentImojis(List list)
    {
        return list.subList(0, Math.min(list.size(), 6));
    }

    private void processLegacyCSV()
    {
        String s = preferenceUtils.getString(0x7f0600cb, "");
        if (s.matches("^[\\d,]+$"))
        {
            java.util.HashMap hashmap = Maps.newHashMap();
            hashmap.put(generateUserRecentKey(), ListUtils.asList(s));
            preferenceUtils.putString(0x7f0600cb, gson.toJson(hashmap, RECENT_DATA_TYPE));
        }
    }

    private void writeRecentImojisToPref(List list)
    {
        usersRecentData.put(generateUserRecentKey(), list);
        preferenceUtils.putString(0x7f0600cb, gson.toJson(usersRecentData, RECENT_DATA_TYPE));
    }

    public void addRecentTemplateId(String s, Callback callback)
    {
        List list = getRecentTemplateIds();
        list.remove(s);
        list.add(0, s);
        writeRecentImojisToPref(list);
        if (callback != null)
        {
            callback.success();
        }
    }

    public List getRecentImojies()
    {
        List list = getRecentTemplateIds();
        if (list.isEmpty())
        {
            return new ArrayList();
        } else
        {
            list = limitCountOfRecentImojis(templatesManager.getTemplates().getImojiById(list));
            writeRecentImojisToPref(new ArrayList(Lists.transform(list, imojiToTemplateId())));
            return list;
        }
    }

}
