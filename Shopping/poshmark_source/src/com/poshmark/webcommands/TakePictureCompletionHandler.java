// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.poshmark.ui.fragments.MappPageFragment;
import com.poshmark.utils.ImageUtils;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler, WebCommand

public class TakePictureCompletionHandler extends CommandCompletionHandler
{

    public TakePictureCompletionHandler()
    {
        type = CommandCompletionHandler.HandlerType.PICTURE;
    }

    public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand, Intent intent)
    {
        intent = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
        String s = (String)webcommand.parameters.get("Quality");
        int i;
        if (s != null)
        {
            i = (int)(Float.parseFloat(s) * 100F);
        } else
        {
            i = 60;
        }
        intent = ImageUtils.getBitmapAsBase64String(intent, i);
        if (mapppagefragment instanceof MappPageFragment)
        {
            mapppagefragment.fireJSCallback((new StringBuilder()).append((String)webcommand.parameters.get("OnSuccess")).append("('").append(intent).append("')").toString());
        }
    }
}
