// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk:
//            ApiUtils

public class WeiboAppManager
{

    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String TAG = com/sina/weibo/sdk/WeiboAppManager.getName();
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
    private static WeiboAppManager sInstance;
    private Context mContext;

    private WeiboAppManager(Context context)
    {
        mContext = context.getApplicationContext();
    }

    public static WeiboAppManager getInstance(Context context)
    {
        com/sina/weibo/sdk/WeiboAppManager;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new WeiboAppManager(context);
        }
        context = sInstance;
        com/sina/weibo/sdk/WeiboAppManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private WeiboInfo queryWeiboInfoByAsset(Context context)
    {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        context = context.getPackageManager().queryIntentServices(intent, 0);
        if (context != null && !context.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((WeiboInfo) (obj));
_L2:
        Iterator iterator = context.iterator();
        context = null;
        do
        {
            obj = context;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (ResolveInfo)iterator.next();
            if (((ResolveInfo) (obj)).serviceInfo != null && ((ResolveInfo) (obj)).serviceInfo.applicationInfo != null && !TextUtils.isEmpty(((ResolveInfo) (obj)).serviceInfo.applicationInfo.packageName))
            {
                obj = parseWeiboInfoByAsset(((ResolveInfo) (obj)).serviceInfo.applicationInfo.packageName);
                if (obj != null)
                {
                    if (context == null)
                    {
                        context = ((Context) (obj));
                    } else
                    if (context.getSupportApi() < ((WeiboInfo) (obj)).getSupportApi())
                    {
                        context = ((Context) (obj));
                    }
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private WeiboInfo queryWeiboInfoByProvider(Context context)
    {
        Object obj = context.getContentResolver();
        Cursor cursor = ((ContentResolver) (obj)).query(WEIBO_NAME_URI, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        context = null;
_L11:
        return context;
_L2:
        obj = cursor;
        int i = cursor.getColumnIndex("support_api");
        obj = cursor;
        int j = cursor.getColumnIndex("package");
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        obj = cursor;
        Object obj1 = cursor.getString(i);
        obj = cursor;
        i = Integer.parseInt(((String) (obj1)));
_L5:
        obj = cursor;
        String s = cursor.getString(j);
        obj = cursor;
        if (TextUtils.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        if (!ApiUtils.validateWeiboSign(context, s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        obj1 = new WeiboInfo();
        obj = cursor;
        ((WeiboInfo) (obj1)).setPackageName(s);
        obj = cursor;
        ((WeiboInfo) (obj1)).setSupportApi(i);
        context = ((Context) (obj1));
        if (cursor != null)
        {
            cursor.close();
            return ((WeiboInfo) (obj1));
        }
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        obj = cursor;
        numberformatexception.printStackTrace();
        i = -1;
        if (true) goto _L5; else goto _L4
        context;
        cursor = null;
_L9:
        obj = cursor;
        LogUtil.e(TAG, context.getMessage());
        if (cursor != null)
        {
            cursor.close();
        }
_L6:
        return null;
        context;
        obj = null;
_L7:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L6
        context;
          goto _L7
        context;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    private WeiboInfo queryWeiboInfoInternal(Context context)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        WeiboInfo weiboinfo = queryWeiboInfoByProvider(context);
        context = queryWeiboInfoByAsset(context);
        if (weiboinfo != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (context == null)
        {
            flag1 = false;
        }
        if (!flag || !flag1) goto _L2; else goto _L1
_L1:
        if (weiboinfo.getSupportApi() < context.getSupportApi()) goto _L4; else goto _L3
_L3:
        return weiboinfo;
_L4:
        return context;
_L2:
        if (!flag)
        {
            if (flag1)
            {
                return context;
            } else
            {
                return null;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public WeiboInfo getWeiboInfo()
    {
        this;
        JVM INSTR monitorenter ;
        WeiboInfo weiboinfo = queryWeiboInfoInternal(mContext);
        this;
        JVM INSTR monitorexit ;
        return weiboinfo;
        Exception exception;
        exception;
        throw exception;
    }

    public WeiboInfo parseWeiboInfoByAsset(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        InputStream inputstream1;
        byte abyte0[];
        Context context = mContext.createPackageContext(s, 2);
        abyte0 = new byte[4096];
        inputstream1 = context.getAssets().open("weibo_for_sdk.json");
        InputStream inputstream = inputstream1;
        StringBuilder stringbuilder = new StringBuilder();
_L8:
        inputstream = inputstream1;
        int i = inputstream1.read(abyte0, 0, 4096);
        if (i != -1) goto _L4; else goto _L3
_L3:
        inputstream = inputstream1;
        if (TextUtils.isEmpty(stringbuilder.toString()))
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream = inputstream1;
        boolean flag = ApiUtils.validateWeiboSign(mContext, s);
        if (flag) goto _L6; else goto _L5
_L5:
        if (inputstream1 == null) goto _L1; else goto _L7
_L7:
        try
        {
            inputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.e(TAG, s.getMessage());
            return null;
        }
        return null;
_L4:
        inputstream = inputstream1;
        stringbuilder.append(new String(abyte0, 0, i));
          goto _L8
        s;
_L15:
        inputstream = inputstream1;
        LogUtil.e(TAG, s.getMessage());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                LogUtil.e(TAG, s.getMessage());
                return null;
            }
            return null;
        }
          goto _L1
_L6:
        inputstream = inputstream1;
        i = (new JSONObject(stringbuilder.toString())).optInt("support_api", -1);
        inputstream = inputstream1;
        WeiboInfo weiboinfo = new WeiboInfo();
        inputstream = inputstream1;
        weiboinfo.setPackageName(s);
        inputstream = inputstream1;
        weiboinfo.setSupportApi(i);
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                LogUtil.e(TAG, s.getMessage());
            }
        }
        return weiboinfo;
        s;
        inputstream1 = null;
_L14:
        inputstream = inputstream1;
        LogUtil.e(TAG, s.getMessage());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                LogUtil.e(TAG, s.getMessage());
                return null;
            }
            return null;
        }
          goto _L1
        s;
        inputstream1 = null;
_L13:
        inputstream = inputstream1;
        LogUtil.e(TAG, s.getMessage());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                LogUtil.e(TAG, s.getMessage());
                return null;
            }
            return null;
        }
          goto _L1
        s;
        inputstream1 = null;
_L12:
        inputstream = inputstream1;
        LogUtil.e(TAG, s.getMessage());
        if (inputstream1 == null) goto _L1; else goto _L9
_L9:
        try
        {
            inputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.e(TAG, s.getMessage());
            return null;
        }
        return null;
        s;
        inputstream = null;
_L11:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                LogUtil.e(TAG, ioexception.getMessage());
            }
        }
        throw s;
        s;
        if (true) goto _L11; else goto _L10
_L10:
        s;
          goto _L12
        s;
          goto _L13
        s;
          goto _L14
        s;
        inputstream1 = null;
          goto _L15
    }


    private class WeiboInfo
    {

        private String mPackageName;
        private int mSupportApi;

        private void setPackageName(String s)
        {
            mPackageName = s;
        }

        private void setSupportApi(int i)
        {
            mSupportApi = i;
        }

        public String getPackageName()
        {
            return mPackageName;
        }

        public int getSupportApi()
        {
            return mSupportApi;
        }

        public boolean isLegal()
        {
            return !TextUtils.isEmpty(mPackageName) && mSupportApi > 0;
        }

        public String toString()
        {
            return (new StringBuilder("WeiboInfo: PackageName = ")).append(mPackageName).append(", supportApi = ").append(mSupportApi).toString();
        }



        public WeiboInfo()
        {
        }
    }

}
