// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class FrontiaPushMessageReceiver extends BroadcastReceiver
{

    public static final String TAG = com/baidu/frontia/api/FrontiaPushMessageReceiver.getSimpleName();

    public FrontiaPushMessageReceiver()
    {
    }

    public abstract void onBind(Context context, int i, String s, String s1, String s2, String s3);

    public abstract void onDelTags(Context context, int i, List list, List list1, String s);

    public abstract void onListTags(Context context, int i, List list, String s);

    public abstract void onMessage(Context context, String s, String s1);

    public abstract void onNotificationClicked(Context context, String s, String s1, String s2);

    public final void onReceive(Context context, Intent intent)
    {
        int i;
        boolean flag;
        flag = false;
        i = 0;
        if (!intent.getAction().equals("com.baidu.android.pushservice.action.MESSAGE")) goto _L2; else goto _L1
_L1:
        if (intent.getExtras() != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        onMessage(context, intent.getExtras().getString("message_string"), intent.getStringExtra("extra_extra_custom_content"));
        return;
_L2:
        Object obj;
        Object obj1;
        int j;
        if (!intent.getAction().equals("com.baidu.android.pushservice.action.RECEIVE"))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = intent.getStringExtra("method");
        j = intent.getIntExtra("error_msg", 0);
        obj = "";
        if (intent.getByteArrayExtra("content") != null)
        {
            obj = new String(intent.getByteArrayExtra("content"));
        }
        if (!((String) (obj1)).equals("method_bind"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = new JSONObject(((String) (obj)));
            intent = ((JSONObject) (obj)).getString("request_id");
            obj = ((JSONObject) (obj)).getJSONObject("response_params");
            obj1 = ((JSONObject) (obj)).getString("appid");
            String s = ((JSONObject) (obj)).getString("channel_id");
            onBind(context, j, ((String) (obj1)), ((JSONObject) (obj)).getString("user_id"), s, intent);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
        try
        {
            if (((String) (obj1)).equals("method_unbind"))
            {
                onUnbind(context, j, (new JSONObject(((String) (obj)))).getString("request_id"));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (!((String) (obj1)).equals("method_set_tags")) goto _L7; else goto _L6
_L6:
        ArrayList arraylist;
        obj = new JSONObject(((String) (obj)));
        intent = ((JSONObject) (obj)).getString("request_id");
        obj = ((JSONObject) (obj)).getJSONObject("response_params").getJSONArray("details");
        obj1 = new ArrayList();
        arraylist = new ArrayList();
_L15:
        if (i >= ((JSONArray) (obj)).length()) goto _L9; else goto _L8
_L8:
        JSONObject jsonobject;
        String s1;
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        s1 = jsonobject.getString("tag");
        if (jsonobject.getInt("result") != 0) goto _L11; else goto _L10
_L10:
        ((List) (obj1)).add(s1);
          goto _L12
_L11:
        arraylist.add(s1);
          goto _L12
_L9:
        onSetTags(context, j, ((List) (obj1)), arraylist, intent);
        return;
_L7:
        if (!((String) (obj1)).equals("method_del_tags"))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new JSONObject(((String) (obj)));
        intent = ((JSONObject) (obj)).getString("request_id");
        obj = ((JSONObject) (obj)).getJSONObject("response_params").getJSONArray("details");
        obj1 = new ArrayList();
        arraylist = new ArrayList();
        i = ((flag) ? 1 : 0);
_L16:
        if (i >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_467;
        }
        JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(i);
        s1 = jsonobject1.getString("tag");
        if (jsonobject1.getInt("result") == 0)
        {
            ((List) (obj1)).add(s1);
            break MISSING_BLOCK_LABEL_564;
        }
        arraylist.add(s1);
        break MISSING_BLOCK_LABEL_564;
        onDelTags(context, j, ((List) (obj1)), arraylist, intent);
        return;
        if (!((String) (obj1)).equals("method_listtags")) goto _L3; else goto _L13
_L13:
        obj = (new JSONObject(((String) (obj)))).getString("request_id");
        onListTags(context, j, intent.getStringArrayListExtra("tags_list"), ((String) (obj)));
        return;
        if (!intent.getAction().equals("com.baidu.android.pushservice.action.notification.CLICK")) goto _L3; else goto _L14
_L14:
        onNotificationClicked(context, intent.getStringExtra("notification_title"), intent.getStringExtra("notification_content"), intent.getStringExtra("extra_extra_custom_content"));
        return;
_L12:
        i++;
          goto _L15
        i++;
          goto _L16
    }

    public abstract void onSetTags(Context context, int i, List list, List list1, String s);

    public abstract void onUnbind(Context context, int i, String s);

}
