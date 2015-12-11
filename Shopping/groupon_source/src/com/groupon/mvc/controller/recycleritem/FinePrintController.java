// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.models.CommonOptions;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Division;
import com.groupon.db.models.LegalDisclosure;
import com.groupon.db.models.Option;
import com.groupon.models.country.Country;
import com.groupon.models.support.SupportInfo;
import com.groupon.mvc.model.FinePrint;
import com.groupon.service.core.SupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DealUtils;
import com.groupon.util.ExpirationFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class FinePrintController extends RecyclerItemViewController
{

    private Channel channel;
    private CommonOptions commonOptions;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private ExpirationFormat expirationFormat;
    private Option option;
    private SupportInfoService supportInfoService;

    public FinePrintController(Context context)
    {
        super(context);
    }

    private String formatExpirationDateINTL(Date date)
    {
        int i;
        i = 1;
        if (date == null)
        {
            return "";
        }
        boolean flag1 = false;
        ArrayList arraylist = deal.getOptions();
        Division division;
        boolean flag;
        if (arraylist.size() <= 1)
        {
            i = 0;
        }
        flag = flag1;
        if (i == 0) goto _L2; else goto _L1
_L1:
        i = 1;
_L7:
        flag = flag1;
        if (i >= arraylist.size()) goto _L2; else goto _L3
_L3:
        if (date.equals(((Option)arraylist.get(i)).getExpiresAt())) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        division = deal.division;
        String s;
        if (division != null)
        {
            s = division.timezoneIdentifier;
        } else
        {
            s = "";
        }
        if (division != null)
        {
            i = division.timezoneOffsetInSeconds;
        } else
        {
            i = 0;
        }
        expirationFormat.shouldDisplayUSFriendlyDateFormat(false);
        if (flag)
        {
            return context.getString(0x7f0801ad);
        } else
        {
            return expirationFormat.format(date, s, Integer.valueOf(i));
        }
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String getExpirationUSCA()
    {
        String s = null;
        LegalDisclosure legaldisclosure = getLegalDisclosure();
        if (legaldisclosure != null)
        {
            s = legaldisclosure.line1;
        }
        return s;
    }

    private LegalDisclosure getLegalDisclosure()
    {
        if (!commonOptions.getLegalDisclosures().isEmpty())
        {
            return (LegalDisclosure)commonOptions.getLegalDisclosures().get(0);
        }
        if (deal.getLegalDisclosures().size() > 0)
        {
            return (LegalDisclosure)deal.getLegalDisclosures().get(0);
        } else
        {
            return null;
        }
    }

    private String getLegalDisclosureString()
    {
        String s = null;
        LegalDisclosure legaldisclosure = getLegalDisclosure();
        if (legaldisclosure != null)
        {
            s = legaldisclosure.line2;
        }
        return s;
    }

    private boolean shouldShowExpirationView(Date date, Channel channel1)
    {
        boolean flag;
        if (Channel.GETAWAYS == channel1 || Channel.HOTELS == channel1 || Channel.TRAVEL == channel1 || !DealUtils.isG1Deal(deal))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return date != null && !flag && currentCountryManager.getCurrentCountry().isFinePrintEnabledCountry();
    }

    private boolean shouldShowUniversalRules()
    {
        String s = supportInfoService.getSupportInfo().contents.finePrint;
        return currentCountryManager.getCurrentCountry().isUSACompatible() || Strings.notEmpty(s) && !currentCountryManager.getCurrentCountry().isSweden();
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
        Object obj;
        String s;
        String s1;
        Date date;
        boolean flag;
        if (option != null)
        {
            obj = option;
        } else
        {
            obj = deal;
        }
        commonOptions = ((CommonOptions) (obj));
        if (option != null)
        {
            obj = option.details;
        } else
        {
            obj = null;
        }
        date = commonOptions.getExpiresAt();
        flag = currentCountryManager.getCurrentCountry().isUSACompatible();
        if (flag)
        {
            s = getExpirationUSCA();
        } else
        {
            s = formatExpirationDateINTL(date);
        }
        if (flag)
        {
            s1 = getLegalDisclosureString();
        } else
        {
            s1 = "";
        }
        model = new FinePrint();
        ((FinePrint)model).finePrint = ((String) (obj));
        ((FinePrint)model).expiration = s;
        ((FinePrint)model).legalDisclosure = s1;
        ((FinePrint)model).webViewCSSStyling = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
        ((FinePrint)model).shouldShowExpirationView = shouldShowExpirationView(date, channel);
        ((FinePrint)model).shouldShowUniversalRules = shouldShowUniversalRules();
        setState(2);
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }
}
