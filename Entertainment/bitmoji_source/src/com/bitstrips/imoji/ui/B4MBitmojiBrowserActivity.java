// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.services.B4MService;
import java.io.File;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity, IntentCreatorService

public class B4MBitmojiBrowserActivity extends ImojiBrowserActivity
    implements com.bitstrips.imoji.services.B4MService.ReplyFriendsListener
{

    private static final String TAG = "B4MBrowserActivity";
    B4MService b4MService;
    FacebookService facebookService;

    public B4MBitmojiBrowserActivity()
    {
    }

    public void onClick(File file, Imoji imoji, int i)
    {
        if (file == null)
        {
            return;
        }
        if (imoji.isUnpurchased())
        {
            intentCreatorService.goToBitshop(this, imoji.getUniversalPackId());
            return;
        } else
        {
            shareFile(file, imoji, getCategory(i));
            return;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (b4MService.isStandaloneMode())
        {
            menu.findItem(0x7f0b0119).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void shareFile(File file, Imoji imoji, Category category)
    {
        if (!isPaused && !isFinishing())
        {
            file = Uri.fromFile(file);
            imoji = imoji.getTemplateId();
            if (intentCreatorService.createFacebookMessengerIntent(this, file, imoji))
            {
                addToRecent(imoji, false);
                if (!b4mService.isReplyMode())
                {
                    analytics.sendEvent(category, Action.SHARE, imoji);
                    return;
                }
            } else
            {
                intentCreatorService.promptUserToDownloadFacebookMessenger(this);
                return;
            }
        }
    }
}
