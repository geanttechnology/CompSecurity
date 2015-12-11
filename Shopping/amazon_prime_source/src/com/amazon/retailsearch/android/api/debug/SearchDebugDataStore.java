// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            ServiceUrlType

public class SearchDebugDataStore
{

    private static final String CUSTOM_SERVICE_URL = "customServiceUrl";
    private static final String DATASTORE_FILENAME = "SXDataStore";
    private static final String SEARCH_CONFIG_ID = "searchConfigId";
    private static final String SEARCH_REALM = "searchRealm";
    private static final String SERVICE_CALL_DEBUG_OPTIONS = "serviceCallDebugOptions";
    private static final String SERVICE_URL_TYPE_NAME = "serviceUrlTypeName";
    private final Context context;
    private CollectionMap cookies;

    public SearchDebugDataStore(Context context1)
    {
        cookies = new CollectionMap();
        context = context1;
    }

    private String getString(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = context.getSharedPreferences("SXDataStore", 0).getString(s, null);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    private void putString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("SXDataStore", 0).edit();
        editor.putString(s, s1);
        editor.apply();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private SearchRealm realmFromString(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (SearchRealm)(new ObjectInputStream(new ByteArrayInputStream(Base64.decode(s, 0)))).readObject();
_L2:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        Log.e(com/amazon/retailsearch/android/api/debug/SearchDebugDataStore.getSimpleName(), "Could not de-serialize realm", s);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    private String realmToString(SearchRealm searchrealm)
    {
        this;
        JVM INSTR monitorenter ;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
        objectoutputstream.writeObject(searchrealm);
        objectoutputstream.flush();
        searchrealm = Base64.encodeToString(bytearrayoutputstream.toByteArray(), 0);
_L2:
        this;
        JVM INSTR monitorexit ;
        return searchrealm;
        searchrealm;
        Log.e(com/amazon/retailsearch/android/api/debug/SearchDebugDataStore.getSimpleName(), "Could not serialize realm", searchrealm);
        searchrealm = "";
        if (true) goto _L2; else goto _L1
_L1:
        searchrealm;
        throw searchrealm;
    }

    public void addCookies(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        cookies.add(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public CollectionMap getCookies()
    {
        this;
        JVM INSTR monitorenter ;
        CollectionMap collectionmap = cookies;
        this;
        JVM INSTR monitorexit ;
        return collectionmap;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCustomServiceUrl()
    {
        this;
        JVM INSTR monitorenter ;
        String s = getString("customServiceUrl");
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSearchConfigId()
    {
        this;
        JVM INSTR monitorenter ;
        String s = getString("searchConfigId");
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public SearchRealm getSearchRealm()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        boolean flag;
        obj = getString("searchRealm");
        flag = TextUtils.isEmpty(((CharSequence) (obj)));
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((SearchRealm) (obj));
_L2:
        obj = realmFromString(((String) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getServiceCallDebugOptions()
    {
        this;
        JVM INSTR monitorenter ;
        String s = getString("serviceCallDebugOptions");
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public ServiceUrlType getServiceUrlType()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        boolean flag;
        obj = getString("serviceUrlTypeName");
        flag = TextUtils.isEmpty(((CharSequence) (obj)));
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((ServiceUrlType) (obj));
_L2:
        obj = ServiceUrlType.valueOf(((String) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setCustomServiceUrl(String s)
    {
        this;
        JVM INSTR monitorenter ;
        putString("customServiceUrl", s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSearchConfigId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        putString("searchConfigId", s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSearchRealm(SearchRealm searchrealm)
    {
        this;
        JVM INSTR monitorenter ;
        putString("searchRealm", realmToString(searchrealm));
        this;
        JVM INSTR monitorexit ;
        return;
        searchrealm;
        throw searchrealm;
    }

    public void setServiceCallDebugOptions(String s)
    {
        this;
        JVM INSTR monitorenter ;
        putString("serviceCallDebugOptions", s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setServiceUrlType(ServiceUrlType serviceurltype)
    {
        this;
        JVM INSTR monitorenter ;
        if (serviceurltype != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        putString("serviceUrlTypeName", serviceurltype.name());
        if (true) goto _L1; else goto _L3
_L3:
        serviceurltype;
        throw serviceurltype;
    }
}
