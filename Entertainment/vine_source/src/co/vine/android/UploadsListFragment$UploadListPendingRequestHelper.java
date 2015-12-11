// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

// Referenced classes of package co.vine.android:
//            UploadsListFragment, PendingCaptchaRequest

public class  extends 
{

    final UploadsListFragment this$0;

    public void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        if (mListView != null && mListView.getChildCount() > mListView.getHeaderViewsCount())
        {
            pendingcaptcharequest = mListView.getChildAt(mListView.getHeaderViewsCount());
            if (pendingcaptcharequest != null)
            {
                ProgressBar progressbar = (ProgressBar)pendingcaptcharequest.findViewById(0x7f0a0030);
                if (progressbar != null)
                {
                    progressbar.setVisibility(8);
                }
                pendingcaptcharequest = (ImageView)pendingcaptcharequest.findViewById(0x7f0a0229);
                if (pendingcaptcharequest != null)
                {
                    pendingcaptcharequest.setVisibility(0);
                }
            }
        }
    }

    public void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        pendingcaptcharequest = mCursorAdapter.getCursor();
        if (pendingcaptcharequest.moveToFirst())
        {
            UploadsListFragment.access$900(UploadsListFragment.this, pendingcaptcharequest, true);
        }
    }

    public volatile void hideProgress(int i)
    {
        super.ogress(i);
    }

    public volatile void showProgress(int i)
    {
        super.ogress(i);
    }

    public ()
    {
        this$0 = UploadsListFragment.this;
        super(UploadsListFragment.this);
    }
}
