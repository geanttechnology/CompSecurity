// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.login;

import android.app.Activity;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;

public class Loader
{
    public static interface OnLoginListener
    {

        public abstract void onLoaderFinish();

        public abstract void onProcessFinish(Object obj);

        public abstract void onProcessStart(Object obj);
    }


    public static final int PROCESS_DATABASE = 0;
    public static final int PROCESS_FINISHED = 2;
    public static final int PROCESS_LINKS = 3;
    private Activity mActivity;
    private OnLoginListener mCallback;
    private Server mServer;

    public Loader(Activity activity, OnLoginListener onloginlistener)
    {
        mActivity = activity;
        mCallback = onloginlistener;
        mServer = ((App)mActivity.getApplication()).getServer();
    }

    public void finish()
    {
        mCallback.onLoaderFinish();
    }

    public void initLoader()
    {
        mCallback.onProcessStart("");
        mServer.updateLinks(new _cls1());
    }

    public void updatePremium()
    {
        if (mServer.getUser() != null && !mServer.getUser().isSkip())
        {
            mServer.upgradePremium(mServer.getUser().getId());
        }
    }


    /* member class not found */
    class _cls1 {}

}
