// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import java.io.IOException;
import java.io.InputStream;
import uq;
import uu;

// Referenced classes of package com.wantu.model.res:
//            FacebookShareInfo, EResType, InstagramShareInfo, QQShareInfo, 
//            SinaweiboShareInfo, TencentweiboShareInfo, TumblrShareInfo, TwitterShareInfo, 
//            WechatShareInfo, WXMomentsShareInfo, EResProcessType, ShareButtonInfo

public class TResInfo
{

    public boolean bRetainFirst;
    public String dlUrl;
    public long downloadTime;
    public long expireTime;
    public long expiredTime;
    public FacebookShareInfo facebookShareInfo;
    public String folderName;
    public String icon;
    public InstagramShareInfo instagramShareInfo;
    public boolean isCartoon;
    public boolean isDirectDownload;
    public Boolean isVip;
    public String name;
    public boolean needReviewing;
    public boolean needSharing;
    public String otherAppStoreId;
    public String previewUrl;
    public int price;
    public QQShareInfo qqShareInfo;
    public int resId;
    public EResProcessType resProcessType;
    public EResType resType;
    public int retainDays;
    public ShareButtonInfo shareButtonInfo;
    public String shareStyleID;
    public String shareTag;
    public uq sinadlShareInfo;
    public SinaweiboShareInfo sinaweiboShareInfo;
    public TencentweiboShareInfo tencentweiboShareInfo;
    public TumblrShareInfo tumblrShareInfo;
    public TwitterShareInfo twitterShareInfo;
    public int useCount;
    public String version;
    public WechatShareInfo wechatShareInfo;
    public WXMomentsShareInfo wxMomentsShareInfo;
    public uu wxdlShareInfo;
    public String zipUrl;

    public TResInfo()
    {
        needReviewing = false;
    }

    protected Bitmap getBitmapByAssetPath(String s)
    {
        Object obj;
        Bitmap bitmap;
        Object obj1;
        obj1 = null;
        obj = null;
        bitmap = ((Bitmap) (obj));
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        bitmap = ((Bitmap) (obj));
_L2:
        return bitmap;
_L4:
        obj = PIPCameraApplication.a.getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L6:
        bitmap = ((Bitmap) (obj));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
        if (true) goto _L2; else goto _L5
_L5:
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        ioexception.printStackTrace();
        ioexception = obj1;
        s1 = s;
          goto _L6
        ioexception;
          goto _L7
    }

    public long getExpireTime()
    {
        return expireTime;
    }

    public FacebookShareInfo getFacebookShareInfo()
    {
        if (facebookShareInfo != null)
        {
            return null;
        } else
        {
            FacebookShareInfo facebookshareinfo = new FacebookShareInfo();
            facebookshareinfo.CheckInfoWidthShareKey("facebookBackUrl");
            return facebookshareinfo;
        }
    }

    public String getIcon()
    {
        return icon;
    }

    public Bitmap getIconBitmap()
    {
        Object obj = null;
        if (resType == EResType.ASSET)
        {
            InputStream inputstream = PIPCameraApplication.a.getAssets().open(icon);
            obj = BitmapFactory.decodeStream(inputstream);
            inputstream.close();
        }
        if (resType == EResType.RES)
        {
            obj = PIPCameraApplication.a;
            int i = Integer.parseInt(icon);
            obj = BitmapFactory.decodeResource(((Context) (obj)).getResources(), i);
        }
        return ((Bitmap) (obj));
    }

    public CollageType getInfoCollageType()
    {
        if (isCartoon)
        {
            return CollageType.COLLAGE_COMIC;
        } else
        {
            return CollageType.COLLAGE_MAGZINE;
        }
    }

    public InstagramShareInfo getInstagramShareInfo()
    {
        if (instagramShareInfo != null)
        {
            return null;
        } else
        {
            InstagramShareInfo instagramshareinfo = new InstagramShareInfo();
            instagramshareinfo.CheckInfoWidthShareKey("instagramBackUrl");
            return instagramshareinfo;
        }
    }

    public String getName()
    {
        return name;
    }

    public QQShareInfo getQQShareInfo()
    {
        if (qqShareInfo != null)
        {
            return null;
        } else
        {
            QQShareInfo qqshareinfo = new QQShareInfo();
            qqshareinfo.CheckInfoWidthShareKey("qqBackUrl");
            return qqshareinfo;
        }
    }

    public EResProcessType getResProcessType()
    {
        return resProcessType;
    }

    public EResType getResType()
    {
        return resType;
    }

    public String getShareTag()
    {
        return shareTag;
    }

    public SinaweiboShareInfo getSinaweiboShareInfo()
    {
        if (sinadlShareInfo != null)
        {
            return null;
        } else
        {
            SinaweiboShareInfo sinaweiboshareinfo = new SinaweiboShareInfo();
            sinaweiboshareinfo.CheckInfoWidthShareKey("sinaweiboBackUrl");
            return sinaweiboshareinfo;
        }
    }

    public TencentweiboShareInfo getTencentweiboShareInfo()
    {
        if (tencentweiboShareInfo != null)
        {
            return null;
        } else
        {
            TencentweiboShareInfo tencentweiboshareinfo = new TencentweiboShareInfo();
            tencentweiboshareinfo.CheckInfoWidthShareKey("tencenweiboBackUrl");
            return tencentweiboshareinfo;
        }
    }

    public TumblrShareInfo getTumblrShareInfo()
    {
        if (tumblrShareInfo != null)
        {
            return null;
        } else
        {
            TumblrShareInfo tumblrshareinfo = new TumblrShareInfo();
            tumblrshareinfo.CheckInfoWidthShareKey("tumblrBackUrl");
            return tumblrshareinfo;
        }
    }

    public TwitterShareInfo getTwitterShareInfo()
    {
        if (twitterShareInfo != null)
        {
            return null;
        } else
        {
            (new TwitterShareInfo()).CheckInfoWidthShareKey("twitterBackUrl");
            return null;
        }
    }

    public WechatShareInfo getWechatShareInfo()
    {
        if (wechatShareInfo != null)
        {
            return null;
        } else
        {
            WechatShareInfo wechatshareinfo = new WechatShareInfo();
            wechatshareinfo.CheckInfoWidthShareKey("wechatBackUrl");
            return wechatshareinfo;
        }
    }

    public WXMomentsShareInfo getWxMomentsShareInfo()
    {
        if (wxMomentsShareInfo != null)
        {
            return null;
        } else
        {
            WXMomentsShareInfo wxmomentsshareinfo = new WXMomentsShareInfo();
            wxmomentsshareinfo.CheckInfoWidthShareKey("wxmoentsBackUrl");
            return wxmomentsshareinfo;
        }
    }

    public boolean hasSharedInfo()
    {
        while (shareStyleID == null || shareStyleID.equalsIgnoreCase("") || shareStyleID.equalsIgnoreCase("0")) 
        {
            return false;
        }
        return PIPCameraApplication.a.getSharedPreferences("shareStyleID", 0).getBoolean((new StringBuilder()).append("hasSharedID_").append(shareStyleID).toString(), false);
    }

    public void setExpireTime(long l)
    {
        expireTime = l;
    }

    public void setIcon(String s)
    {
        icon = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setResProcessType(EResProcessType eresprocesstype)
    {
        resProcessType = eresprocesstype;
    }

    public void setResType(EResType erestype)
    {
        resType = erestype;
    }

    public void setShareTag(String s)
    {
        shareTag = s;
    }
}
