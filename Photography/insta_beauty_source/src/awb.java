// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
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

public class awb
{

    static String a = "tiezhi_style";

    public static awk a(JSONObject jsonobject)
    {
        awk awk1;
        int i;
        awk1 = new awk();
        awk1.a = aqn.e(jsonobject, "typeId");
        awk1.b = aqn.a(jsonobject, "typeNameCN");
        awk1.c = aqn.a(jsonobject, "typeNameZH");
        awk1.d = aqn.a(jsonobject, "typeNameEN");
        awk1.e = new ArrayList();
        jsonobject = aqn.b(jsonobject, "typeArray");
        if (jsonobject == null || jsonobject.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        i = 0;
_L3:
        if (i >= jsonobject.length()) goto _L2; else goto _L1
_L1:
        awj awj1 = b((JSONObject)jsonobject.get(i));
        if (awj1 != null)
        {
            try
            {
                awj1.f = awk1.a;
                awk1.e.add(awj1);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        i++;
          goto _L3
_L2:
        return awk1;
    }

    public static TTieZhiInfo a(String s, int i)
    {
        Object obj1 = null;
        Object obj = String.format("%s_%d", new Object[] {
            a, Integer.valueOf(i)
        });
        s = (new StringBuilder()).append(s).append("/").append(((String) (obj))).append("/conf.json").toString();
        obj = obj1;
        if ((new File(s)).exists())
        {
            try
            {
                s = a(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = null;
            }
            if (s != null && s.length() > 0)
            {
                try
                {
                    s = new JSONObject(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s = null;
                }
            } else
            {
                s = null;
            }
            obj = obj1;
            if (s != null)
            {
                obj = a(((JSONObject) (s)), i);
            }
        }
        return ((TTieZhiInfo) (obj));
    }

    public static TTieZhiInfo a(JSONObject jsonobject, int i)
    {
        Object obj3 = null;
        Object obj1 = obj3;
        if (jsonobject != null)
        {
            if (i == 0)
            {
                obj1 = obj3;
            } else
            {
                Object obj;
                Object obj2;
                if (jsonobject.has("iconUrl"))
                {
                    obj = aqn.a(jsonobject, "iconUrl");
                } else
                {
                    obj = null;
                }
                if (jsonobject.has("src"))
                {
                    obj2 = aqn.a(jsonobject, "src");
                } else
                {
                    obj2 = null;
                }
                obj1 = obj3;
                if (obj != null)
                {
                    obj1 = obj3;
                    if (obj2 != null)
                    {
                        obj2 = new TTieZhiInfo();
                        String s = String.format("%s_%d", new Object[] {
                            a, Integer.valueOf(i)
                        });
                        obj2.folderName = s;
                        obj2.resId = i;
                        obj2.version = aqn.a(jsonobject, "version");
                        ((TTieZhiInfo) (obj2)).setResType(EResType.NETWORK);
                        obj2.icon = ((String) (obj));
                        obj2.downloadTime = System.currentTimeMillis();
                        obj2.expiredTime = aqn.e(jsonobject, "expiredTime");
                        obj2.src = aqn.a(jsonobject, "src");
                        obj2.margin = aqn.f(jsonobject, "margin");
                        obj2.position = TTieZhiInfo.positionFromInt(aqn.e(jsonobject, "position"));
                        obj2.faceType = TTieZhiInfo.faceTypeFromInt(aqn.e(jsonobject, "faceType"));
                        obj2.faceAlign = TTieZhiInfo.faceAlignFromInt(aqn.e(jsonobject, "faceAlign"));
                        if (jsonobject.has("tencentweiboShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "tencentweiboShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TencentweiboShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.tencentweiboShareInfo = ((TencentweiboShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("sinaweiboShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "sinaweiboShareInfo");
                            if (obj != null)
                            {
                                obj1 = new SinaweiboShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.sinaweiboShareInfo = ((SinaweiboShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("wechatShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "wechatShareInfo");
                            if (obj != null)
                            {
                                obj1 = new WechatShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.wechatShareInfo = ((WechatShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("wxMomentsShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "wxMomentsShareInfo");
                            if (obj != null)
                            {
                                obj1 = new WXMomentsShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.wxMomentsShareInfo = ((WXMomentsShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("facebookShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "facebookShareInfo");
                            if (obj != null)
                            {
                                obj1 = new FacebookShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.facebookShareInfo = ((FacebookShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("twitterShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "twitterShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TwitterShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expriedTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.twitterShareInfo = ((TwitterShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("qqShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "qqShareInfo");
                            if (obj != null)
                            {
                                obj1 = new QQShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("bcakUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.qqShareInfo = ((QQShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("instagramShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "instagramShareInfo");
                            if (obj != null)
                            {
                                obj1 = new InstagramShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.instagramShareInfo = ((InstagramShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("tumblrShareInfo"))
                        {
                            obj = aqn.c(jsonobject, "tumblrShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TumblrShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = aqn.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = aqn.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = aqn.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = aqn.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = aqn.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = aqn.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = aqn.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.tumblrShareInfo = ((TumblrShareInfo) (obj1));
                            }
                        }
                        obj1 = obj2;
                        if (!jsonobject.isNull("shareButtonInfo"))
                        {
                            obj2.shareButtonInfo = new ShareButtonInfo();
                            try
                            {
                                jsonobject = jsonobject.getJSONObject("shareButtonInfo");
                                if (!jsonobject.isNull("adUrl"))
                                {
                                    ((TTieZhiInfo) (obj2)).shareButtonInfo.adUrl = jsonobject.getString("adUrl");
                                }
                                if (!jsonobject.isNull("imgUrl"))
                                {
                                    ((TTieZhiInfo) (obj2)).shareButtonInfo.imgUrl = jsonobject.getString("imgUrl");
                                }
                                if (!jsonobject.isNull("expiredTime"))
                                {
                                    ((TTieZhiInfo) (obj2)).shareButtonInfo.expiredTime = jsonobject.getLong("expiredTime");
                                }
                                ((TTieZhiInfo) (obj2)).shareButtonInfo.setFolderName(s);
                                ((TTieZhiInfo) (obj2)).shareButtonInfo.setEOnlineResType(EOnlineResType.TIEZHI);
                            }
                            // Misplaced declaration of an exception variable
                            catch (JSONObject jsonobject)
                            {
                                jsonobject.printStackTrace();
                                return ((TTieZhiInfo) (obj2));
                            }
                            return ((TTieZhiInfo) (obj2));
                        }
                    }
                }
            }
        }
        return ((TTieZhiInfo) (obj1));
    }

    public static TTieZhiInfo a(byte abyte0[], int i)
    {
        if (abyte0 != null && i > 0 && b(abyte0, i))
        {
            abyte0 = awg.a().c().a();
            String s = String.format("%s_%d", new Object[] {
                a, Integer.valueOf(i)
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

    public static awj b(JSONObject jsonobject)
    {
        awj awj1;
        JSONArray jsonarray;
        int i;
        boolean flag;
        flag = false;
        awj1 = new awj();
        awj1.a = aqn.e(jsonobject, "listId");
        awj1.b = aqn.a(jsonobject, "listNameCN");
        awj1.c = aqn.a(jsonobject, "listNameZH");
        awj1.d = aqn.a(jsonobject, "listNameEN");
        awj1.e = new ArrayList();
        jsonarray = aqn.b(jsonobject, "listArray");
        if (jsonarray == null || jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        i = 0;
_L3:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        TTieZhiInfo ttiezhiinfo = c((JSONObject)jsonarray.get(i));
        if (ttiezhiinfo != null)
        {
            try
            {
                awj1.e.add(ttiezhiinfo);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        i++;
          goto _L3
_L2:
        if (!jsonobject.has("recommendIds")) goto _L5; else goto _L4
_L4:
        jsonobject = aqn.b(jsonobject, "recommendIds");
        awj1.g = new ArrayList();
        int j = ((flag) ? 1 : 0);
        do
        {
            try
            {
                if (j >= jsonobject.length())
                {
                    break;
                }
                awj1.g.add(Integer.valueOf(jsonobject.getInt(j)));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                break;
            }
            j++;
        } while (true);
_L5:
        return awj1;
    }

    private static boolean b(byte abyte0[], int i)
    {
        Object obj = awg.a().c().a();
        String s1 = String.format("%s_%d", new Object[] {
            a, Integer.valueOf(i)
        });
        String s = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).append(".zip").toString();
        s1 = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).toString();
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

    public static TTieZhiInfo c(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        TTieZhiInfo ttiezhiinfo;
        Object obj;
        ttiezhiinfo = new TTieZhiInfo();
        obj = new atz(InstaBeautyApplication.a().getApplicationContext());
        if (jsonobject == null) goto _L1; else goto _L3
_L3:
        if (jsonobject.has("id"))
        {
            ttiezhiinfo.resId = aqn.e(jsonobject, "id");
        }
        if (jsonobject.has("version"))
        {
            ttiezhiinfo.version = aqn.a(jsonobject, "version");
        }
        if (jsonobject.has("name"))
        {
            ttiezhiinfo.name = aqn.a(jsonobject, "name");
        }
        if (jsonobject.has("iconUrl"))
        {
            ttiezhiinfo.icon = aqn.a(jsonobject, "iconUrl");
        }
        if (jsonobject.has("previewUrl"))
        {
            ttiezhiinfo.previewUrl = aqn.a(jsonobject, "previewUrl");
        }
        if (jsonobject.has("dlurl"))
        {
            ttiezhiinfo.dlUrl = aqn.a(jsonobject, "dlurl");
        }
        if (jsonobject.has("bgroup"))
        {
            ttiezhiinfo.isGroupEnable = jsonobject.getBoolean("bgroup");
        }
        if (!jsonobject.has("groupIds")) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj1 = jsonobject.getJSONArray("groupIds");
        ttiezhiinfo.groupIds = new ArrayList();
        int i = 0;
_L6:
        if (i >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ttiezhiinfo.groupIds.add(Integer.valueOf(((JSONArray) (obj1)).getInt(i)));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        ttiezhiinfo.zipUrl = aqn.a(jsonobject, "zipUrl");
        ttiezhiinfo.shareStyleID = aqn.a(jsonobject, "shareStyleID");
        ttiezhiinfo.otherAppStoreId = aqn.a(jsonobject, "otherAppStoreId");
        if (!jsonobject.has("WXMomentsShareInfo") || jsonobject.isNull("WXMomentsShareInfo"))
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj1 = aqn.c(jsonobject, "WXMomentsShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        boolean flag;
        if (!ttiezhiinfo.needSharing && !((atz) (obj)).b())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        ttiezhiinfo.needSharing = flag;
        ttiezhiinfo.wxdlShareInfo = new WXDLShareInfo();
        if (((JSONObject) (obj1)).has("title"))
        {
            ttiezhiinfo.wxdlShareInfo.title = ((JSONObject) (obj1)).getString("title");
        }
        if (((JSONObject) (obj1)).has("thumbUrl"))
        {
            ttiezhiinfo.wxdlShareInfo.thumbUrl = ((JSONObject) (obj1)).getString("thumbUrl");
        }
        if (((JSONObject) (obj1)).has("description"))
        {
            ttiezhiinfo.wxdlShareInfo.description = ((JSONObject) (obj1)).getString("description");
        }
        if (((JSONObject) (obj1)).has("webpageUrl"))
        {
            ttiezhiinfo.wxdlShareInfo.webpageUrl = ((JSONObject) (obj1)).getString("webpageUrl");
        }
        if (((JSONObject) (obj1)).has("message"))
        {
            ttiezhiinfo.wxdlShareInfo.message = ((JSONObject) (obj1)).getString("message");
        }
        if (!jsonobject.has("SinaDLShareInfo") || jsonobject.isNull("SinaDLShareInfo"))
        {
            break MISSING_BLOCK_LABEL_562;
        }
        obj = aqn.c(jsonobject, "SinaDLShareInfo");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_562;
        }
        ttiezhiinfo.needSharing = ttiezhiinfo.needSharing;
        ttiezhiinfo.sinadlShareInfo = new SINADLShareInfo();
        if (((JSONObject) (obj)).has("imageUrl"))
        {
            ttiezhiinfo.sinadlShareInfo.imageUrl = ((JSONObject) (obj)).getString("imageUrl");
        }
        if (((JSONObject) (obj)).has("message"))
        {
            ttiezhiinfo.sinadlShareInfo.message = ((JSONObject) (obj)).getString("message");
        }
        ttiezhiinfo.needReviewing = aqn.d(jsonobject, "needReviewing");
_L8:
        return ttiezhiinfo;
        jsonobject;
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        if (true) goto _L8; else goto _L7
_L7:
    }

}
