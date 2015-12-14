// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            BaseCmd, AppInvokeCmd, AppInstallCmd

class CmdInfo
{

    private static final String TAG = com/sina/weibo/sdk/cmd/BaseCmd.getName();
    private int frequency;
    private List mInstallCmds;
    private List mInvokeCmds;

    public CmdInfo(String s)
    {
        initFromJsonStr(s);
    }

    private void initFromJsonStr(String s)
    {
        boolean flag = false;
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            s = new JSONObject(s);
            if (s.has("error") || s.has("error_code"))
            {
                LogUtil.w(TAG, "load cmd api has error !!!");
                throw new WeiboException("load cmd api has error !!!");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.d(TAG, (new StringBuilder("parse NotificationInfo error: ")).append(s.getMessage()).toString());
            return;
        }
        s = s.optJSONObject("cmd");
        if (s == null) goto _L1; else goto _L3
_L3:
        Object obj;
        frequency = s.optInt("frequency");
        obj = s.optJSONArray("app_install");
        if (obj == null) goto _L5; else goto _L4
_L4:
        mInstallCmds = new ArrayList();
        int i = 0;
_L10:
        if (i < ((JSONArray) (obj)).length()) goto _L6; else goto _L5
_L5:
        s = s.optJSONArray("app_invoke");
        if (s == null) goto _L1; else goto _L7
_L7:
        mInvokeCmds = new ArrayList();
        i = ((flag) ? 1 : 0);
_L9:
        if (i >= s.length()) goto _L1; else goto _L8
_L8:
        obj = s.getJSONObject(i);
        mInvokeCmds.add(new AppInvokeCmd(((JSONObject) (obj))));
        i++;
          goto _L9
          goto _L1
_L6:
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        mInstallCmds.add(new AppInstallCmd(jsonobject));
        i++;
          goto _L10
    }

    public int getFrequency()
    {
        return frequency;
    }

    public List getInstallCmds()
    {
        return mInstallCmds;
    }

    public List getInvokeCmds()
    {
        return mInvokeCmds;
    }

    public void setFrequency(int i)
    {
        frequency = i;
    }

    public void setInstallCmds(List list)
    {
        mInstallCmds = list;
    }

    public void setInvokeCmds(List list)
    {
        mInvokeCmds = list;
    }

}
