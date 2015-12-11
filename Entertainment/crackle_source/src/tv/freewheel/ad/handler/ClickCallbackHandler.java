// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.ad.AdContext;
import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.CreativeRendition;
import tv.freewheel.ad.EventCallback;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.handler:
//            EventCallbackHandler

public class ClickCallbackHandler extends EventCallbackHandler
{

    public ClickCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
    }

    private void openLink(String s)
    {
        if (adInstance.getActivity() != null)
        {
            logger.debug((new StringBuilder()).append("will open: ").append(s).toString());
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            adInstance.getActivity().startActivity(s);
        }
    }

    public void send(Bundle bundle)
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        int i;
        int j;
        boolean flag;
        boolean flag1;
        if (adInstance != null && adInstance.getActiveCreativeRendition() != null)
        {
            setParameter("reid", String.valueOf(adInstance.getActiveCreativeRendition().creativeRenditionId));
        }
        j = 0;
        s4 = getUrlParameter("cr");
        s = bundle.getString("url");
        s3 = super.getCallbackUrl();
        flag1 = isShowBrowser();
        s1 = s3;
        flag = flag1;
        s2 = s4;
        i = j;
        if (s == null) goto _L2; else goto _L1
_L1:
        s1 = s3;
        flag = flag1;
        s2 = s4;
        i = j;
        if (s.isEmpty()) goto _L2; else goto _L3
_L3:
        flag = true;
        s2 = ".fwmrm.net";
        s1 = s2;
        String s5;
        MalformedURLException malformedurlexception1;
        try
        {
            if (adInstance.getAdContext().serverUrl.startsWith("http"))
            {
                s1 = (new URL(adInstance.getAdContext().serverUrl)).getHost();
            }
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception = s2;
        }
        s2 = "";
        s5 = (new URL(s)).getHost();
        s2 = s5;
_L5:
        if (s2.contains(s1) && s.contains("ad/l/1"))
        {
            i = 1;
            s1 = s;
            j = s1.lastIndexOf("&cr=");
            if (j != -1)
            {
                s2 = Uri.decode(s1.substring("&cr=".length() + j));
            } else
            {
                s2 = "";
            }
            logger.debug((new StringBuilder()).append("Click through overridden by value: ").append(s).toString());
        } else
        if (s.contains(s1) && s.contains("ad/l/1"))
        {
            i = 1;
            s1 = s;
            s2 = s;
            logger.debug((new StringBuilder()).append("Click through overridden by value: ").append(s).toString());
        } else
        {
            i = s3.lastIndexOf("&cr=");
            s1 = s3;
            if (i != -1)
            {
                s1 = s3.substring(0, i);
            }
            s1 = (new StringBuilder()).append(s1).append("&cr=").append(Uri.encode(s)).toString();
            logger.debug((new StringBuilder()).append("Click through CR: original value: ").append(s4).append(", overridden by value: ").append(s).toString());
            s2 = s;
            i = j;
        }
_L2:
        flag = bundle.getBoolean("showBrowser", flag);
        if (!s1.startsWith("http://") && !s1.startsWith("https://"))
        {
            try
            {
                openLink(s1);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                logger.warn((new StringBuilder()).append("unknown uri schema:").append(s1).toString());
            }
        } else
        if (!flag || s2 == null || s2.isEmpty())
        {
            sendRequest(s1);
        } else
        if (s2.startsWith("http://") || s2.startsWith("https://"))
        {
            openLink(s1);
        } else
        {
            sendRequest(s1);
            try
            {
                openLink(s2);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                logger.warn((new StringBuilder()).append("unknown uri schema:").append(s2).toString());
            }
        }
        if (i == 0)
        {
            sendTrackingCallback();
        }
        return;
        malformedurlexception1;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
