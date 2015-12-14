// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            PrepareMediaItemsHelper

class val.latch
    implements com.amazon.gallery.framework.network.ler
{

    final PrepareMediaItemsHelper this$0;
    final CountDownLatch val$latch;
    final ArrayList val$links;

    public void onFailure(TerminalException terminalexception)
    {
        GLogger.ex(PrepareMediaItemsHelper.access$000(), "Execute ShareOperation failed", terminalexception);
        val$latch.countDown();
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("contacts");
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        if (jsonobject.getJSONObject(0) != null) goto _L3; else goto _L2
_L2:
        GLogger.e(PrepareMediaItemsHelper.access$000(), "No contacts found while getting the share url", new Object[0]);
_L7:
        val$latch.countDown();
        return;
_L3:
        int i = 0;
_L5:
        if (i >= jsonobject.length())
        {
            continue; /* Loop/switch isn't completed */
        }
        val$links.add(Uri.parse(jsonobject.getJSONObject(i).getString("extension")));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        jsonobject;
        GLogger.e(PrepareMediaItemsHelper.access$000(), "Can't parse result page to get share url", new Object[0]);
        if (true) goto _L7; else goto _L6
_L6:
    }

    ()
    {
        this$0 = final_preparemediaitemshelper;
        val$links = arraylist;
        val$latch = CountDownLatch.this;
        super();
    }
}
