// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Merchant;
import com.groupon.mvc.model.MoreInfo;
import com.groupon.util.DeviceInfoUtil;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class MoreInfoController extends RecyclerItemViewController
{

    private Deal deal;
    private DeviceInfoUtil deviceInfoUtil;
    private String pitchHtml;

    public MoreInfoController(Context context)
    {
        super(context);
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public Void getCallback()
    {
        return null;
    }

    public void processData()
    {
        String s;
        Object obj;
        boolean flag;
        if (deal != null && deal.merchant != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s = deal.merchant.name;
        } else
        {
            s = "";
        }
        if (flag)
        {
            obj = deal.merchant.profileHtml;
        } else
        {
            obj = "";
        }
        if (Strings.isEmpty(s) && Strings.isEmpty(obj))
        {
            setState(0);
            return;
        }
        model = new MoreInfo();
        ((MoreInfo)model).merchantName = s;
        ((MoreInfo)model).profileHtml = ((String) (obj));
        ((MoreInfo)model).pitchHtml = pitchHtml;
        obj = (MoreInfo)model;
        if (deviceInfoUtil.isRTLLanguage())
        {
            s = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
        } else
        {
            s = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
        }
        obj.webViewCSSStyling = s;
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setPitchHtml(String s)
    {
        setState(1);
        pitchHtml = s;
    }
}
