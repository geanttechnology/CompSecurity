// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.parse:
//            ManifestInfo, PushType, PLog, ParseCorePlugins, 
//            ParseCurrentInstallationController, ParseInstallation

class ParsePushChannelsController
{

    private static final String TAG = "com.parse.ParsePushChannelsController";
    private static boolean loggedManifestError = false;

    ParsePushChannelsController()
    {
    }

    private static void checkManifestAndLogErrorIfNecessary()
    {
        if (!loggedManifestError && ManifestInfo.getPushType() == PushType.NONE)
        {
            loggedManifestError = true;
            PLog.e("com.parse.ParsePushChannelsController", (new StringBuilder()).append("Tried to subscribe or unsubscribe from a channel, but push is not enabled correctly. ").append(ManifestInfo.getNonePushTypeLogMessage()).toString());
        }
    }

    private static ParseCurrentInstallationController getCurrentInstallationController()
    {
        return ParseCorePlugins.getInstance().getCurrentInstallationController();
    }

    public j subscribeInBackground(final String channel)
    {
        checkManifestAndLogErrorIfNecessary();
        if (channel == null)
        {
            throw new IllegalArgumentException("Can't subscribe to null channel.");
        } else
        {
            return getCurrentInstallationController().getAsync().d(new i() {

                final ParsePushChannelsController this$0;
                final String val$channel;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParseInstallation)j1.e();
                    List list = j1.getList("channels");
                    if (list == null || j1.isDirty("channels") || !list.contains(channel))
                    {
                        j1.addUnique("channels", channel);
                        return j1.saveInBackground();
                    } else
                    {
                        return j.a(null);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParsePushChannelsController.this;
                channel = s;
                super();
            }
            });
        }
    }

    public j unsubscribeInBackground(final String channel)
    {
        checkManifestAndLogErrorIfNecessary();
        if (channel == null)
        {
            throw new IllegalArgumentException("Can't unsubscribe from null channel.");
        } else
        {
            return getCurrentInstallationController().getAsync().d(new i() {

                final ParsePushChannelsController this$0;
                final String val$channel;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParseInstallation)j1.e();
                    List list = j1.getList("channels");
                    if (list != null && list.contains(channel))
                    {
                        j1.removeAll("channels", Collections.singletonList(channel));
                        return j1.saveInBackground();
                    } else
                    {
                        return j.a(null);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParsePushChannelsController.this;
                channel = s;
                super();
            }
            });
        }
    }

}
