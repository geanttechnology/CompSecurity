// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.boldchat.sdk.BoldChatSession;
import com.boldchat.sdk.BoldChatView;
import com.groupon.service.LoginService;
import com.groupon.util.livechat.LiveChatUtil;
import com.groupon.util.livechat.OnLiveChatSessionFinishListener;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class LiveChatActivity extends GrouponActivity
{
    private class OnLiveChatActivitySessionCloseListener
        implements OnLiveChatSessionFinishListener
    {

        final LiveChatActivity this$0;

        public void onLiveChatSessionFinish()
        {
            liveChatUtil.onLiveChatActivitySessionCloseListener = null;
            finish();
        }

        private OnLiveChatActivitySessionCloseListener()
        {
            this$0 = LiveChatActivity.this;
            super();
        }

    }

    private class OnLiveChatActivitySessionEndListener
        implements OnLiveChatSessionFinishListener
    {

        final LiveChatActivity this$0;

        public void onLiveChatSessionFinish()
        {
            liveChatUtil.onLiveChatActivitySessionEndListener = null;
            chatEnded = true;
            invalidateOptionsMenu();
        }

        private OnLiveChatActivitySessionEndListener()
        {
            this$0 = LiveChatActivity.this;
            super();
        }

    }


    protected BoldChatView boldChatView;
    private boolean chatEnded;
    private BoldChatSession liveChatSession;
    private LiveChatUtil liveChatUtil;
    private LoginService loginService;

    public LiveChatActivity()
    {
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080252));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03014f);
        liveChatUtil.setupLiveChatSessionWithUI(boldChatView, loginService.getFullName(), loginService.getEmail());
        liveChatSession = liveChatUtil.liveChatSession;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (!chatEnded)
        {
            liveChatSession.addMenuItems(getMenuInflater(), menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (liveChatSession.menuItemSelected(menuitem))
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        if (liveChatUtil.isChatActive())
        {
            liveChatUtil.startLiveChatNotification();
        }
        liveChatUtil.onLiveChatActivitySessionEndListener = null;
        liveChatUtil.onLiveChatActivitySessionCloseListener = null;
        liveChatSession.removeListener();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        liveChatSession.start();
        liveChatUtil.onLiveChatActivitySessionEndListener = new OnLiveChatActivitySessionEndListener();
        liveChatUtil.onLiveChatActivitySessionCloseListener = new OnLiveChatActivitySessionCloseListener();
        liveChatUtil.pauseLiveChatNotification();
    }



/*
    static boolean access$302(LiveChatActivity livechatactivity, boolean flag)
    {
        livechatactivity.chatEnded = flag;
        return flag;
    }

*/
}
