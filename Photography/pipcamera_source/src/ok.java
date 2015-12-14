// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.FacebookShareInfo;
import com.wantu.model.res.InstagramShareInfo;
import com.wantu.model.res.QQShareInfo;
import com.wantu.model.res.ShareButtonInfo;
import com.wantu.model.res.SinaweiboShareInfo;
import com.wantu.model.res.TencentweiboShareInfo;
import com.wantu.model.res.TumblrShareInfo;
import com.wantu.model.res.TwitterShareInfo;
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

public class ok
{

    static String a = "tiezhi_style";

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
                    obj = kv.a(jsonobject, "iconUrl");
                } else
                {
                    obj = null;
                }
                if (jsonobject.has("src"))
                {
                    obj2 = kv.a(jsonobject, "src");
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
                        obj2.version = kv.a(jsonobject, "version");
                        ((TTieZhiInfo) (obj2)).setResType(EResType.NETWORK);
                        obj2.icon = ((String) (obj));
                        obj2.downloadTime = System.currentTimeMillis();
                        obj2.expiredTime = kv.e(jsonobject, "expiredTime");
                        obj2.src = kv.a(jsonobject, "src");
                        obj2.margin = kv.f(jsonobject, "margin");
                        obj2.position = TTieZhiInfo.positionFromInt(kv.e(jsonobject, "position"));
                        obj2.faceType = TTieZhiInfo.faceTypeFromInt(kv.e(jsonobject, "faceType"));
                        obj2.faceAlign = TTieZhiInfo.faceAlignFromInt(kv.e(jsonobject, "faceAlign"));
                        if (jsonobject.has("tencentweiboShareInfo"))
                        {
                            obj = kv.c(jsonobject, "tencentweiboShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TencentweiboShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.tencentweiboShareInfo = ((TencentweiboShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("sinaweiboShareInfo"))
                        {
                            obj = kv.c(jsonobject, "sinaweiboShareInfo");
                            if (obj != null)
                            {
                                obj1 = new SinaweiboShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.sinaweiboShareInfo = ((SinaweiboShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("wechatShareInfo"))
                        {
                            obj = kv.c(jsonobject, "wechatShareInfo");
                            if (obj != null)
                            {
                                obj1 = new WechatShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.wechatShareInfo = ((WechatShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("wxMomentsShareInfo"))
                        {
                            obj = kv.c(jsonobject, "wxMomentsShareInfo");
                            if (obj != null)
                            {
                                obj1 = new WXMomentsShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.wxMomentsShareInfo = ((WXMomentsShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("facebookShareInfo"))
                        {
                            obj = kv.c(jsonobject, "facebookShareInfo");
                            if (obj != null)
                            {
                                obj1 = new FacebookShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.facebookShareInfo = ((FacebookShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("twitterShareInfo"))
                        {
                            obj = kv.c(jsonobject, "twitterShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TwitterShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expriedTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.twitterShareInfo = ((TwitterShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("qqShareInfo"))
                        {
                            obj = kv.c(jsonobject, "qqShareInfo");
                            if (obj != null)
                            {
                                obj1 = new QQShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("bcakUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.qqShareInfo = ((QQShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("instagramShareInfo"))
                        {
                            obj = kv.c(jsonobject, "instagramShareInfo");
                            if (obj != null)
                            {
                                obj1 = new InstagramShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
                                }
                                obj2.instagramShareInfo = ((InstagramShareInfo) (obj1));
                            }
                        }
                        if (jsonobject.has("tumblrShareInfo"))
                        {
                            obj = kv.c(jsonobject, "tumblrShareInfo");
                            if (obj != null)
                            {
                                obj1 = new TumblrShareInfo();
                                if (((JSONObject) (obj)).has("shareTag"))
                                {
                                    obj1.shareTag = kv.a(((JSONObject) (obj)), "shareTag");
                                }
                                if (((JSONObject) (obj)).has("backUrl"))
                                {
                                    obj1.backUrl = kv.a(((JSONObject) (obj)), "backUrl");
                                }
                                if (((JSONObject) (obj)).has("alertText"))
                                {
                                    obj1.alertText = kv.a(((JSONObject) (obj)), "alertText");
                                }
                                if (((JSONObject) (obj)).has("okText"))
                                {
                                    obj1.okText = kv.a(((JSONObject) (obj)), "okText");
                                }
                                if (((JSONObject) (obj)).has("cancelText"))
                                {
                                    obj1.cancelText = kv.a(((JSONObject) (obj)), "cancelText");
                                }
                                if (((JSONObject) (obj)).has("expiredTime"))
                                {
                                    obj1.expiredTime = kv.e(((JSONObject) (obj)), "expiredTime");
                                }
                                if (((JSONObject) (obj)).has("backUrlID"))
                                {
                                    obj1.backUrlID = kv.e(((JSONObject) (obj)), "backUrlID");
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
            abyte0 = oo.a().c().a();
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

    public static or a(JSONObject jsonobject)
    {
        or or1;
        int i;
        or1 = new or();
        or1.a = kv.e(jsonobject, "typeId");
        or1.b = kv.a(jsonobject, "typeNameCN");
        or1.c = kv.a(jsonobject, "typeNameZH");
        or1.d = kv.a(jsonobject, "typeNameEN");
        or1.e = new ArrayList();
        jsonobject = kv.b(jsonobject, "typeArray");
        if (jsonobject == null || jsonobject.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        i = 0;
_L3:
        if (i >= jsonobject.length()) goto _L2; else goto _L1
_L1:
        oq oq1 = b((JSONObject)jsonobject.get(i));
        if (oq1 != null)
        {
            try
            {
                oq1.f = or1.a;
                or1.e.add(oq1);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        i++;
          goto _L3
_L2:
        return or1;
    }

    public static oq b(JSONObject jsonobject)
    {
        oq oq1;
        JSONArray jsonarray;
        int i;
        boolean flag;
        flag = false;
        oq1 = new oq();
        oq1.a = kv.e(jsonobject, "listId");
        oq1.b = kv.a(jsonobject, "listNameCN");
        oq1.c = kv.a(jsonobject, "listNameZH");
        oq1.d = kv.a(jsonobject, "listNameEN");
        oq1.e = new ArrayList();
        jsonarray = kv.b(jsonobject, "listArray");
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
                oq1.e.add(ttiezhiinfo);
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
        jsonobject = kv.b(jsonobject, "recommendIds");
        oq1.g = new ArrayList();
        int j = ((flag) ? 1 : 0);
        do
        {
            try
            {
                if (j >= jsonobject.length())
                {
                    break;
                }
                oq1.g.add(Integer.valueOf(jsonobject.getInt(j)));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                break;
            }
            j++;
        } while (true);
_L5:
        return oq1;
    }

    private static boolean b(byte abyte0[], int i)
    {
        Object obj = oo.a().c().a();
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
        flag = gc.a(abyte0, s);
        flag1 = flag;
        if (flag)
        {
            try
            {
                gc.a(((File) (obj)), s1);
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
        obj = new of(PIPCameraApplication.b().getApplicationContext());
        if (jsonobject == null) goto _L1; else goto _L3
_L3:
        if (jsonobject.has("id"))
        {
            ttiezhiinfo.resId = kv.e(jsonobject, "id");
        }
        if (jsonobject.has("version"))
        {
            ttiezhiinfo.version = kv.a(jsonobject, "version");
        }
        if (jsonobject.has("name"))
        {
            ttiezhiinfo.name = kv.a(jsonobject, "name");
        }
        if (jsonobject.has("iconUrl"))
        {
            ttiezhiinfo.icon = kv.a(jsonobject, "iconUrl");
        }
        if (jsonobject.has("previewUrl"))
        {
            ttiezhiinfo.previewUrl = kv.a(jsonobject, "previewUrl");
        }
        if (jsonobject.has("dlurl"))
        {
            ttiezhiinfo.dlUrl = kv.a(jsonobject, "dlurl");
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
        ttiezhiinfo.zipUrl = kv.a(jsonobject, "zipUrl");
        ttiezhiinfo.shareStyleID = kv.a(jsonobject, "shareStyleID");
        ttiezhiinfo.otherAppStoreId = kv.a(jsonobject, "otherAppStoreId");
        if (!jsonobject.has("WXMomentsShareInfo") || jsonobject.isNull("WXMomentsShareInfo"))
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj1 = kv.c(jsonobject, "WXMomentsShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        boolean flag;
        if (!ttiezhiinfo.needSharing && !((of) (obj)).b())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        ttiezhiinfo.needSharing = flag;
        ttiezhiinfo.wxdlShareInfo = new uu();
        if (((JSONObject) (obj1)).has("title"))
        {
            ttiezhiinfo.wxdlShareInfo.a = ((JSONObject) (obj1)).getString("title");
        }
        if (((JSONObject) (obj1)).has("thumbUrl"))
        {
            ttiezhiinfo.wxdlShareInfo.c = ((JSONObject) (obj1)).getString("thumbUrl");
        }
        if (((JSONObject) (obj1)).has("description"))
        {
            ttiezhiinfo.wxdlShareInfo.b = ((JSONObject) (obj1)).getString("description");
        }
        if (((JSONObject) (obj1)).has("webpageUrl"))
        {
            ttiezhiinfo.wxdlShareInfo.d = ((JSONObject) (obj1)).getString("webpageUrl");
        }
        if (((JSONObject) (obj1)).has("message"))
        {
            ttiezhiinfo.wxdlShareInfo.f = ((JSONObject) (obj1)).getString("message");
        }
        if (!jsonobject.has("SinaDLShareInfo") || jsonobject.isNull("SinaDLShareInfo"))
        {
            break MISSING_BLOCK_LABEL_562;
        }
        obj = kv.c(jsonobject, "SinaDLShareInfo");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_562;
        }
        ttiezhiinfo.needSharing = ttiezhiinfo.needSharing;
        ttiezhiinfo.sinadlShareInfo = new uq();
        if (((JSONObject) (obj)).has("imageUrl"))
        {
            ttiezhiinfo.sinadlShareInfo.a = ((JSONObject) (obj)).getString("imageUrl");
        }
        if (((JSONObject) (obj)).has("message"))
        {
            ttiezhiinfo.sinadlShareInfo.b = ((JSONObject) (obj)).getString("message");
        }
        ttiezhiinfo.needReviewing = kv.d(jsonobject, "needReviewing");
_L8:
        return ttiezhiinfo;
        jsonobject;
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        if (true) goto _L8; else goto _L7
_L7:
    }

}
