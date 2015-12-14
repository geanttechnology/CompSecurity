// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.CmdObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IVersionCheckHandler

public class VersionCheckHandler
    implements IVersionCheckHandler
{

    private static final String TAG = com/sina/weibo/sdk/api/share/VersionCheckHandler.getName();

    public VersionCheckHandler()
    {
    }

    public boolean checkRequest(Context context, com.sina.weibo.sdk.WeiboAppManager.WeiboInfo weiboinfo, WeiboMessage weibomessage)
    {
        if (weiboinfo == null || !weiboinfo.isLegal())
        {
            return false;
        }
        LogUtil.d(TAG, (new StringBuilder("WeiboMessage WeiboInfo package : ")).append(weiboinfo.getPackageName()).toString());
        LogUtil.d(TAG, (new StringBuilder("WeiboMessage WeiboInfo supportApi : ")).append(weiboinfo.getSupportApi()).toString());
        if (weiboinfo.getSupportApi() < 10351 && weibomessage.mediaObject != null && (weibomessage.mediaObject instanceof VoiceObject))
        {
            weibomessage.mediaObject = null;
        }
        if (weiboinfo.getSupportApi() < 10352 && weibomessage.mediaObject != null && (weibomessage.mediaObject instanceof CmdObject))
        {
            weibomessage.mediaObject = null;
        }
        return true;
    }

    public boolean checkRequest(Context context, com.sina.weibo.sdk.WeiboAppManager.WeiboInfo weiboinfo, WeiboMultiMessage weibomultimessage)
    {
        if (weiboinfo != null && weiboinfo.isLegal())
        {
            LogUtil.d(TAG, (new StringBuilder("WeiboMultiMessage WeiboInfo package : ")).append(weiboinfo.getPackageName()).toString());
            LogUtil.d(TAG, (new StringBuilder("WeiboMultiMessage WeiboInfo supportApi : ")).append(weiboinfo.getSupportApi()).toString());
            if (weiboinfo.getSupportApi() >= 10351)
            {
                if (weiboinfo.getSupportApi() < 10352 && weibomultimessage.mediaObject != null && (weibomultimessage.mediaObject instanceof CmdObject))
                {
                    weibomultimessage.mediaObject = null;
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkResponse(Context context, String s, WeiboMessage weibomessage)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return checkRequest(context, WeiboAppManager.getInstance(context).parseWeiboInfoByAsset(s), weibomessage);
        }
    }

    public boolean checkResponse(Context context, String s, WeiboMultiMessage weibomultimessage)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return checkRequest(context, WeiboAppManager.getInstance(context).parseWeiboInfoByAsset(s), weibomultimessage);
        }
    }

}
