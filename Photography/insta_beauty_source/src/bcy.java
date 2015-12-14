// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import android.graphics.RectF;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.model.TResTypeManager;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.ResourceOnlineLibrary.compose.TDecorateInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.model.res.EResType;
import com.wantu.model.res.FacebookShareInfo;
import com.wantu.model.res.InstagramShareInfo;
import com.wantu.model.res.QQShareInfo;
import com.wantu.model.res.SINADLShareInfo;
import com.wantu.model.res.ShareButtonInfo;
import com.wantu.model.res.SinaweiboShareInfo;
import com.wantu.model.res.TencentweiboShareInfo;
import com.wantu.model.res.TumblrShareInfo;
import com.wantu.model.res.TwitterShareInfo;
import com.wantu.model.res.WXDLShareInfo;
import com.wantu.model.res.WXMomentsShareInfo;
import com.wantu.model.res.WechatShareInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bcy
{

    public static int a(int i)
    {
        if (i != 0)
        {
            if (i == 1)
            {
                return 17;
            }
            if (i == 2)
            {
                return 5;
            }
        }
        return 3;
    }

    public static TPhotoComposeInfo a(JSONObject jsonobject)
    {
        Object obj = new atz(InstaBeautyApplication.a().getApplicationContext());
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        jsonobject = null;
_L12:
        return jsonobject;
_L2:
        TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
        if (jsonobject.has("rid"))
        {
            tphotocomposeinfo.rid = aqn.e(jsonobject, "rid");
            tphotocomposeinfo.resId = aqn.e(jsonobject, "rid");
        }
        if (jsonobject.has("version"))
        {
            tphotocomposeinfo.version = aqn.a(jsonobject, "version");
        }
        if (jsonobject.has("name"))
        {
            tphotocomposeinfo.name = aqn.a(jsonobject, "name");
        }
        if (jsonobject.has("icon"))
        {
            tphotocomposeinfo.icon = aqn.a(jsonobject, "icon");
        }
        if (jsonobject.has("previewUrl"))
        {
            tphotocomposeinfo.previewUrl = aqn.a(jsonobject, "previewUrl");
        }
        if (jsonobject.has("imageCount"))
        {
            tphotocomposeinfo.imageCount = aqn.e(jsonobject, "imageCount");
        }
        if (jsonobject.has("width"))
        {
            tphotocomposeinfo.width = aqn.f(jsonobject, "width");
        }
        if (jsonobject.has("height"))
        {
            tphotocomposeinfo.height = aqn.f(jsonobject, "height");
        }
        if (jsonobject.has("isUpdate"))
        {
            tphotocomposeinfo.isUpdate = aqn.d(jsonobject, "isUpdate");
        }
        if (jsonobject.has("dlurl"))
        {
            tphotocomposeinfo.dlUrl = aqn.a(jsonobject, "dlurl");
        }
        if (!jsonobject.has("typeId")) goto _L4; else goto _L3
_L3:
        tphotocomposeinfo.typeId = aqn.e(jsonobject, "typeId");
_L13:
        tphotocomposeinfo.zipUrl = aqn.a(jsonobject, "zipUrl");
        tphotocomposeinfo.shareStyleID = aqn.a(jsonobject, "shareStyleID");
        tphotocomposeinfo.isOnline = true;
        tphotocomposeinfo.otherAppStoreId = aqn.a(jsonobject, "otherAppStoreId");
        if (!jsonobject.has("WXMomentsShareInfo") || jsonobject.isNull("WXMomentsShareInfo")) goto _L6; else goto _L5
_L5:
        JSONObject jsonobject1 = aqn.c(jsonobject, "WXMomentsShareInfo");
        if (jsonobject1 == null) goto _L6; else goto _L7
_L7:
        boolean flag;
        if (!tphotocomposeinfo.needSharing && !((atz) (obj)).b())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        tphotocomposeinfo.needSharing = flag;
        tphotocomposeinfo.wxdlShareInfo = new WXDLShareInfo();
        if (jsonobject1.has("title"))
        {
            tphotocomposeinfo.wxdlShareInfo.title = jsonobject1.getString("title");
        }
        if (jsonobject1.has("thumbUrl"))
        {
            tphotocomposeinfo.wxdlShareInfo.thumbUrl = jsonobject1.getString("thumbUrl");
        }
        if (jsonobject1.has("description"))
        {
            tphotocomposeinfo.wxdlShareInfo.description = jsonobject1.getString("description");
        }
        if (jsonobject1.has("webpageUrl"))
        {
            tphotocomposeinfo.wxdlShareInfo.webpageUrl = jsonobject1.getString("webpageUrl");
        }
        if (jsonobject1.has("message"))
        {
            tphotocomposeinfo.wxdlShareInfo.message = jsonobject1.getString("message");
        }
_L6:
        if (!jsonobject.has("SinaDLShareInfo") || jsonobject.isNull("SinaDLShareInfo")) goto _L9; else goto _L8
_L8:
        obj = aqn.c(jsonobject, "SinaDLShareInfo");
        if (obj == null) goto _L9; else goto _L10
_L10:
        tphotocomposeinfo.needSharing = tphotocomposeinfo.needSharing;
        tphotocomposeinfo.sinadlShareInfo = new SINADLShareInfo();
        if (((JSONObject) (obj)).has("imageUrl"))
        {
            tphotocomposeinfo.sinadlShareInfo.imageUrl = ((JSONObject) (obj)).getString("imageUrl");
        }
        if (((JSONObject) (obj)).has("message"))
        {
            tphotocomposeinfo.sinadlShareInfo.message = ((JSONObject) (obj)).getString("message");
        }
_L9:
        tphotocomposeinfo.needReviewing = aqn.d(jsonobject, "needReviewing");
        if (tphotocomposeinfo.width == 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = tphotocomposeinfo;
        if (tphotocomposeinfo.height != 0.0F) goto _L12; else goto _L11
_L11:
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 480F;
        return tphotocomposeinfo;
        jsonobject;
_L14:
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        return tphotocomposeinfo;
_L4:
        tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
          goto _L13
        jsonobject;
        tphotocomposeinfo = null;
          goto _L14
    }

    public static TPhotoComposeInfo a(JSONObject jsonobject, int i)
    {
        TPhotoComposeInfo tphotocomposeinfo;
        String s;
        boolean flag;
        flag = false;
        if (jsonobject == null || i == 0)
        {
            return null;
        }
        tphotocomposeinfo = new TPhotoComposeInfo();
        s = String.format("instamag_style_%d", new Object[] {
            Integer.valueOf(i)
        });
        tphotocomposeinfo.folderName = s;
        JSONObject jsonobject1;
        Object obj1;
        if (jsonobject.has("typeId"))
        {
            tphotocomposeinfo.typeId = aqn.e(jsonobject, "typeId");
        } else
        {
            tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        }
        tphotocomposeinfo.resId = i;
        tphotocomposeinfo.rid = i;
        tphotocomposeinfo.version = aqn.a(jsonobject, "version");
        tphotocomposeinfo.name = aqn.a(jsonobject, "name");
        tphotocomposeinfo.icon = aqn.a(jsonobject, "iconUrl");
        tphotocomposeinfo.previewUrl = aqn.a(jsonobject, "previewUrl");
        tphotocomposeinfo.price = aqn.e(jsonobject, "price");
        tphotocomposeinfo.imageCount = aqn.e(jsonobject, "imageCount");
        tphotocomposeinfo.width = aqn.f(jsonobject, "width");
        tphotocomposeinfo.height = aqn.f(jsonobject, "height");
        tphotocomposeinfo.isOnline = true;
        tphotocomposeinfo.setResType(EResType.NETWORK);
        tphotocomposeinfo.isUpdate = aqn.d(jsonobject, "isUpdate");
        tphotocomposeinfo.otherAppStoreId = aqn.a(jsonobject, "otherAppStoreId");
        tphotocomposeinfo.bRetainFirst = aqn.d(jsonobject, "bRetainFirst");
        tphotocomposeinfo.downloadTime = System.currentTimeMillis();
        tphotocomposeinfo.expiredTime = aqn.e(jsonobject, "expiredTime");
        tphotocomposeinfo.shareTag = aqn.a(jsonobject, "shareTag");
        tphotocomposeinfo.zipUrl = aqn.a(jsonobject, "zipUrl");
        tphotocomposeinfo.needReviewing = false;
        if (jsonobject.has("isFlip")) goto _L2; else goto _L1
_L1:
        tphotocomposeinfo.isHFlip = true;
_L5:
        if (jsonobject.has("isVFlip")) goto _L4; else goto _L3
_L3:
        tphotocomposeinfo.isVFlip = true;
_L6:
        tphotocomposeinfo.backgoundImagePath = aqn.a(jsonobject, "backgroundImageUrl");
        jsonobject1 = aqn.c(jsonobject, "backgroundColor");
        if (jsonobject1 != null)
        {
            tphotocomposeinfo.backgroundColor = b(jsonobject1);
        }
        tphotocomposeinfo.foregroundImagePath = aqn.a(jsonobject, "foregroundImageUrl");
        jsonobject1 = aqn.c(jsonobject, "foregroundColor");
        if (jsonobject1 != null)
        {
            tphotocomposeinfo.foregroundColor = b(jsonobject1);
        }
        if (tphotocomposeinfo.width == 0.0F || tphotocomposeinfo.height == 0.0F)
        {
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
        }
        if (jsonobject.has("tencentweiboShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "tencentweiboShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new TencentweiboShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.tencentweiboShareInfo = ((TencentweiboShareInfo) (obj1));
            }
        }
        if (jsonobject.has("sinaweiboShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "sinaweiboShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new SinaweiboShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.sinaweiboShareInfo = ((SinaweiboShareInfo) (obj1));
            }
        }
        if (jsonobject.has("wechatShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "wechatShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new WechatShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.wechatShareInfo = ((WechatShareInfo) (obj1));
            }
        }
        if (jsonobject.has("wxMomentsShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "wxMomentsShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new WXMomentsShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.wxMomentsShareInfo = ((WXMomentsShareInfo) (obj1));
            }
        }
        if (jsonobject.has("facebookShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "facebookShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new FacebookShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.facebookShareInfo = ((FacebookShareInfo) (obj1));
            }
        }
        if (jsonobject.has("twitterShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "twitterShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new TwitterShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expriedTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.twitterShareInfo = ((TwitterShareInfo) (obj1));
            }
        }
        if (jsonobject.has("qqShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "qqShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new QQShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("bcakUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.qqShareInfo = ((QQShareInfo) (obj1));
            }
        }
        if (jsonobject.has("instagramShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "instagramShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new InstagramShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.instagramShareInfo = ((InstagramShareInfo) (obj1));
            }
        }
        if (jsonobject.has("tumblrShareInfo"))
        {
            jsonobject1 = aqn.c(jsonobject, "tumblrShareInfo");
            if (jsonobject1 != null)
            {
                obj1 = new TumblrShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    obj1.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    obj1.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    obj1.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    obj1.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    obj1.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    obj1.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    obj1.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                tphotocomposeinfo.tumblrShareInfo = ((TumblrShareInfo) (obj1));
            }
        }
        if (!jsonobject.isNull("shareButtonInfo"))
        {
            tphotocomposeinfo.shareButtonInfo = new ShareButtonInfo();
            Exception exception;
            try
            {
                jsonobject1 = jsonobject.getJSONObject("shareButtonInfo");
                if (!jsonobject1.isNull("adUrl"))
                {
                    tphotocomposeinfo.shareButtonInfo.adUrl = jsonobject1.getString("adUrl");
                }
                if (!jsonobject1.isNull("imgUrl"))
                {
                    tphotocomposeinfo.shareButtonInfo.imgUrl = jsonobject1.getString("imgUrl");
                }
                if (!jsonobject1.isNull("expiredTime"))
                {
                    tphotocomposeinfo.shareButtonInfo.expiredTime = jsonobject1.getLong("expiredTime");
                }
                tphotocomposeinfo.shareButtonInfo.setFolderName(s);
                tphotocomposeinfo.shareButtonInfo.setEOnlineResType(EOnlineResType.MAG_MASK_INFO);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        obj1 = aqn.b(jsonobject, "masks");
        i = 0;
        do
        {
            if (i >= ((JSONArray) (obj1)).length())
            {
                break;
            }
            Object obj;
            try
            {
                obj = ((JSONArray) (obj1)).getJSONObject(i);
            }
            catch (JSONException jsonexception1)
            {
                jsonexception1.printStackTrace();
                jsonexception1 = null;
            }
            if (obj != null)
            {
                TPhotoMaskInfo tphotomaskinfo = new TPhotoMaskInfo();
                tphotomaskinfo.resType = EResType.NETWORK;
                tphotomaskinfo.folderName = s;
                tphotomaskinfo.backgroundFrame = d(aqn.c(((JSONObject) (obj)), "backgroundFrame"));
                tphotomaskinfo.innerFrame = d(aqn.c(((JSONObject) (obj)), "innerFrame"));
                tphotomaskinfo.foregroundFrame = d(aqn.c(((JSONObject) (obj)), "foregroundFrame"));
                tphotomaskinfo.foregroundImagePath = aqn.a(((JSONObject) (obj)), "foregroundImageUrl");
                tphotomaskinfo.foregroundColor = b(aqn.c(((JSONObject) (obj)), "foregroundColor"));
                tphotomaskinfo.rotation = aqn.f(((JSONObject) (obj)), "rotation");
                tphotomaskinfo.backgroundImagePath = aqn.a(((JSONObject) (obj)), "backgroundImageUrl");
                tphotomaskinfo.backgroundColor = b(aqn.c(((JSONObject) (obj)), "backgroundColor"));
                tphotomaskinfo.rotation = aqn.f(((JSONObject) (obj)), "rotation");
                tphotomaskinfo.maskImagePath = aqn.a(((JSONObject) (obj)), "maskImageUrl");
                tphotomaskinfo.filterName = aqn.a(((JSONObject) (obj)), "filterName");
                tphotomaskinfo.isBackgroundShadow = aqn.d(((JSONObject) (obj)), "isBackgroundShadow");
                if (((JSONObject) (obj)).has("transform3D"))
                {
                    tphotomaskinfo.transforms = c(aqn.c(((JSONObject) (obj)), "transform3D"));
                }
                if (((JSONObject) (obj)).has("grainPath"))
                {
                    String s2 = aqn.a(((JSONObject) (obj)), "grainPath");
                    if (s2 != null && s2.length() > 0)
                    {
                        if (!s2.startsWith("MaskGrains"))
                        {
                            tphotomaskinfo.grainPath = s2;
                        } else
                        {
                            tphotomaskinfo.grainPath = s2;
                        }
                    }
                }
                tphotomaskinfo.isPIP = aqn.d(((JSONObject) (obj)), "isPIP");
                tphotomaskinfo.backmaskImagePath = aqn.a(((JSONObject) (obj)), "backmaskImagePath");
                tphotomaskinfo.backFilterName = aqn.a(((JSONObject) (obj)), "backFilterName");
                tphotomaskinfo.gaussianFilterName = aqn.a(((JSONObject) (obj)), "gaussianFilterName");
                tphotomaskinfo.gaussianBlur = aqn.f(((JSONObject) (obj)), "gaussianBlur");
                tphotomaskinfo.saturation = aqn.f(((JSONObject) (obj)), "saturation");
                tphotomaskinfo.downsampling = aqn.f(((JSONObject) (obj)), "downsampling");
                tphotomaskinfo.rangeReductionFactor = aqn.f(((JSONObject) (obj)), "rangeReductionFactor");
                tphotomaskinfo.backScaleFactor = aqn.f(((JSONObject) (obj)), "backScaleFactor");
                if (tphotocomposeinfo.photoMaskInfoArray == null)
                {
                    tphotocomposeinfo.photoMaskInfoArray = new ArrayList(1);
                }
                tphotocomposeinfo.photoMaskInfoArray.add(tphotomaskinfo);
            }
            i++;
        } while (true);
        break MISSING_BLOCK_LABEL_2704;
_L2:
        tphotocomposeinfo.isHFlip = aqn.d(jsonobject, "isFlip");
          goto _L5
_L4:
        try
        {
            tphotocomposeinfo.isVFlip = aqn.d(jsonobject, "isVFlip");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
        }
          goto _L6
        JSONArray jsonarray = aqn.b(jsonobject, "decorates");
        i = ((flag) ? 1 : 0);
        do
        {
            if (i >= jsonarray.length())
            {
                break;
            }
            try
            {
                jsonobject = jsonarray.getJSONObject(i);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                jsonobject = null;
            }
            if (jsonobject != null)
            {
                TDecorateInfo tdecorateinfo = new TDecorateInfo();
                tdecorateinfo.resType = EResType.NETWORK;
                tdecorateinfo.folderName = s;
                tdecorateinfo.frame = d(aqn.c(jsonobject, "frame"));
                tdecorateinfo.rotation = (float)(((double)aqn.f(jsonobject, "rotation") * 3.1415926535897931D) / 180D);
                tdecorateinfo.imagePath = aqn.a(jsonobject, "imageUrl");
                tdecorateinfo.type = aqn.e(jsonobject, "type");
                tdecorateinfo.textColor = b(aqn.c(jsonobject, "textColor"));
                tdecorateinfo.backgroundColor = b(aqn.c(jsonobject, "backgroundColor"));
                tdecorateinfo.fontSize = aqn.e(jsonobject, "fontSize");
                String s1 = aqn.a(jsonobject, "androidFontFamily");
                if (s1 != null && s1.length() > 0)
                {
                    tdecorateinfo.fontFamily = s1;
                } else
                {
                    tdecorateinfo.fontFamily = aqn.a(jsonobject, "fontFamily");
                }
                tdecorateinfo.isBold = aqn.d(jsonobject, "isBold");
                tdecorateinfo.isShadow = aqn.d(jsonobject, "isShadow");
                tdecorateinfo.isOutline = aqn.d(jsonobject, "isOutline");
                tdecorateinfo.isItalic = aqn.d(jsonobject, "isItalic");
                tdecorateinfo.fontMaxCount = aqn.e(jsonobject, "fontMaxCount");
                tdecorateinfo.text = aqn.a(jsonobject, "text");
                tdecorateinfo.textAlignment = a(aqn.e(jsonobject, "textAlignment"));
                tdecorateinfo.movable = aqn.d(jsonobject, "movable");
                tdecorateinfo.editable = aqn.d(jsonobject, "editable");
                tdecorateinfo.lines = aqn.e(jsonobject, "lines");
                tdecorateinfo.letterSpace = aqn.e(jsonobject, "letterSpace");
                tdecorateinfo.bubbleTextFrame = d(aqn.c(jsonobject, "txtFrame"));
                tdecorateinfo.isFlipH = aqn.d(jsonobject, "isFlipH");
                tdecorateinfo.isFlipV = aqn.d(jsonobject, "isFlipV");
                tdecorateinfo.scale = aqn.f(jsonobject, "scale");
                if (tdecorateinfo.scale == 0.0F)
                {
                    tdecorateinfo.scale = 1.0F;
                }
                tdecorateinfo.dynamicGifPath = a(s, aqn.a(jsonobject, "dynamicGifPath"));
                if (tphotocomposeinfo.decorateInfoArray == null)
                {
                    tphotocomposeinfo.decorateInfoArray = new ArrayList(1);
                }
                tphotocomposeinfo.decorateInfoArray.add(tdecorateinfo);
            }
            i++;
        } while (true);
        return tphotocomposeinfo;
          goto _L5
    }

    public static TPhotoComposeInfo a(byte abyte0[], int i)
    {
        if (abyte0 != null && i > 0 && b(abyte0, i))
        {
            abyte0 = FileManager.getInstance().getInstaMagFileCache().a();
            String s = String.format("instamag_style_%d", new Object[] {
                Integer.valueOf(i)
            });
            abyte0 = (new StringBuilder()).append(abyte0).append("/").append(s).append("/conf.json").toString();
            if ((new File(abyte0)).exists())
            {
                try
                {
                    abyte0 = a(((String) (abyte0)));
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    abyte0.printStackTrace();
                    abyte0 = null;
                }
                if (abyte0 != null && abyte0.length() > 0)
                {
                    try
                    {
                        abyte0 = new JSONObject(abyte0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        abyte0 = null;
                    }
                } else
                {
                    abyte0 = null;
                }
                if (abyte0 != null)
                {
                    return a(((JSONObject) (abyte0)), i);
                }
            }
        }
        return null;
    }

    public static String a(String s)
    {
        s = new FileReader(s);
        BufferedReader bufferedreader = new BufferedReader(s);
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 != null)
            {
                stringbuffer.append(s1);
            } else
            {
                bufferedreader.close();
                s.close();
                return stringbuffer.toString();
            }
        } while (true);
    }

    public static String a(String s, String s1)
    {
        try
        {
            String s2 = FileManager.getInstance().getInstaMagFileCache().a();
            s = (new StringBuilder()).append(s2).append("/").append(s).append("/").append(s1).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private static int b(JSONObject jsonobject)
    {
        float f3 = 0.0F;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        float f2 = aqn.f(jsonobject, "R");
        float f;
        float f1;
        float f4;
        try
        {
            f1 = aqn.f(jsonobject, "G");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            f1 = 0.0F;
            f = 0.0F;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            f = aqn.f(jsonobject, "B");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            f = 0.0F;
            continue; /* Loop/switch isn't completed */
        }
        f4 = aqn.f(jsonobject, "alpha");
        f3 = f4;
_L5:
        return Color.argb((int)(f3 * 255F), (int)f2, (int)f1, (int)f);
        jsonobject;
        f1 = 0.0F;
        f2 = 0.0F;
        f = 0.0F;
_L3:
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        continue; /* Loop/switch isn't completed */
        jsonobject;
        if (true) goto _L3; else goto _L2
_L2:
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static boolean b(byte abyte0[], int i)
    {
        Object obj = FileManager.getInstance().getInstaMagFileCache().a();
        String s1 = String.format("instamag_style_%d", new Object[] {
            Integer.valueOf(i)
        });
        String s = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).append(".zip").toString();
        s1 = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).toString();
        Log.v("TParseMagUtils", (new StringBuilder()).append("TParseMagUtils zipFilePath:").append(s).append(" folderFilePath").append(s1).toString());
        obj = new File(s);
        boolean flag;
        boolean flag1;
        if (!((File) (obj)).exists())
        {
            try
            {
                ((File) (obj)).createNewFile();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
                return false;
            }
        }
        flag = aak.a(abyte0, s);
        Log.v("TParseMagUtils", (new StringBuilder()).append("TParseMagUtils zipDatatoFile:").append(flag).append("").toString());
        flag1 = flag;
        if (flag)
        {
            try
            {
                aak.a(((File) (obj)), s1);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                flag1 = flag;
                if (((File) (obj)).exists())
                {
                    ((File) (obj)).delete();
                    flag1 = flag;
                }
            }
        }
        return flag1;
    }

    private static List c(JSONObject jsonobject)
    {
        Object obj1 = null;
        Object obj;
        if (jsonobject == null)
        {
            obj = obj1;
        } else
        {
            obj = obj1;
            if (jsonobject.has("X"))
            {
                obj = obj1;
                if (jsonobject.has("Y"))
                {
                    obj = obj1;
                    if (jsonobject.has("Z"))
                    {
                        ArrayList arraylist = new ArrayList();
                        obj = arraylist;
                        if (jsonobject != null)
                        {
                            try
                            {
                                float f = aqn.f(jsonobject, "scale");
                                float f1 = aqn.f(jsonobject, "m34");
                                float f2 = aqn.f(jsonobject, "X");
                                float f3 = aqn.f(jsonobject, "Y");
                                float f4 = aqn.f(jsonobject, "Z");
                                arraylist.add(Float.valueOf(f));
                                arraylist.add(Float.valueOf(f1));
                                arraylist.add(Float.valueOf(f2));
                                arraylist.add(Float.valueOf(f3));
                                arraylist.add(Float.valueOf(f4));
                            }
                            // Misplaced declaration of an exception variable
                            catch (JSONObject jsonobject)
                            {
                                jsonobject.printStackTrace();
                                Crashlytics.logException(jsonobject);
                                return arraylist;
                            }
                            return arraylist;
                        }
                    }
                }
            }
        }
        return ((List) (obj));
    }

    private static RectF d(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        float f2 = aqn.f(jsonobject, "x");
        float f1 = aqn.f(jsonobject, "y");
        float f = aqn.f(jsonobject, "w");
        float f3 = aqn.f(jsonobject, "h");
_L4:
        if (f != 0.0F && f3 != 0.0F)
        {
            return new RectF(f2, f1, f + f2, f3 + f1);
        }
        if (true) goto _L1; else goto _L3
_L3:
        jsonobject;
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
_L5:
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        f3 = 0.0F;
          goto _L4
        jsonobject;
        f = 0.0F;
        f1 = 0.0F;
          goto _L5
        jsonobject;
        f = 0.0F;
          goto _L5
        jsonobject;
          goto _L5
    }
}
