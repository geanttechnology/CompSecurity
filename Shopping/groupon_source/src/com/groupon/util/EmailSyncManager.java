// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.db.dao.DaoBugReportEmail;
import com.groupon.db.models.BugReportEmail;
import com.groupon.service.operations.ReportABugEmailSender;
import commonlib.manager.SyncManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            CacheUtils

public class EmailSyncManager extends SyncManager
{

    private DaoBugReportEmail bugReportEmailDao;

    public EmailSyncManager(Context context)
    {
        super(context);
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(Void void1)
        throws Exception
    {
        Iterator iterator = bugReportEmailDao.queryForAll().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BugReportEmail bugreportemail = (BugReportEmail)iterator.next();
            int i = bugreportemail.sendCount;
            String s = bugreportemail.screenshotFileName;
            bugreportemail.sendCount = i + 1;
            bugReportEmailDao.update(bugreportemail);
            if (i < 10)
            {
                ReportABugEmailSender reportabugemailsender = new ReportABugEmailSender(context);
                String s1 = bugreportemail.emailBody;
                if (Strings.notEmpty(s))
                {
                    void1 = CacheUtils.getScreenshotCacheDirWithNewFile(s, context);
                } else
                {
                    void1 = null;
                }
                reportabugemailsender.setEmailBody(s1).addAttachment(void1).setEmailSubject(bugreportemail.emailSubject).sendMail();
            }
            bugReportEmailDao.delete(bugreportemail);
            if (Strings.notEmpty(s))
            {
                CacheUtils.getScreenshotCacheDirWithNewFile(s, context).delete();
            }
        } while (true);
    }

    protected long lastUpdated()
        throws Exception
    {
        return 0L;
    }
}
