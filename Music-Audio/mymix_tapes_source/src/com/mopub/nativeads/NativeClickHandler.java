// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

// Referenced classes of package com.mopub.nativeads:
//            SpinningProgressView, ClickInterface

public class NativeClickHandler
{

    private boolean mClickInProgress;
    private final Context mContext;

    public NativeClickHandler(Context context)
    {
        Preconditions.checkNotNull(context);
        mContext = context.getApplicationContext();
    }

    private void setOnClickListener(View view, android.view.View.OnClickListener onclicklistener)
    {
        view.setOnClickListener(onclicklistener);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i = 0; i < view.getChildCount(); i++)
            {
                setOnClickListener(view.getChildAt(i), onclicklistener);
            }

        }
    }

    public void clearOnClickListener(View view)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(view, "Cannot clear click listener from a null view"))
        {
            return;
        } else
        {
            setOnClickListener(view, (android.view.View.OnClickListener)null);
            return;
        }
    }

    public void openClickDestinationUrl(String s, View view)
    {
        openClickDestinationUrl(s, view, new SpinningProgressView(mContext));
    }

    void openClickDestinationUrl(String s, final View view, final SpinningProgressView spinningProgressView)
    {
        if (com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "Cannot open a null click destination url"))
        {
            Preconditions.checkNotNull(spinningProgressView);
            if (!mClickInProgress)
            {
                mClickInProgress = true;
                if (view != null)
                {
                    spinningProgressView.addToRoot(view);
                }
                (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                    UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
                }).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

                    final NativeClickHandler this$0;
                    final SpinningProgressView val$spinningProgressView;
                    final View val$view;

                    private void removeSpinningProgressView()
                    {
                        if (view != null)
                        {
                            spinningProgressView.removeFromRoot();
                        }
                    }

                    public void urlHandlingFailed(String s1, UrlAction urlaction)
                    {
                        removeSpinningProgressView();
                        mClickInProgress = false;
                    }

                    public void urlHandlingSucceeded(String s1, UrlAction urlaction)
                    {
                        removeSpinningProgressView();
                        mClickInProgress = false;
                    }

            
            {
                this$0 = NativeClickHandler.this;
                view = view1;
                spinningProgressView = spinningprogressview;
                super();
            }
                }).build().handleUrl(mContext, s);
                return;
            }
        }
    }

    public void setOnClickListener(View view, final ClickInterface clickInterface)
    {
        while (!com.mopub.common.Preconditions.NoThrow.checkNotNull(view, "Cannot set click listener on a null view") || !com.mopub.common.Preconditions.NoThrow.checkNotNull(clickInterface, "Cannot set click listener with a null ClickInterface")) 
        {
            return;
        }
        setOnClickListener(view, new android.view.View.OnClickListener() {

            final NativeClickHandler this$0;
            final ClickInterface val$clickInterface;

            public void onClick(View view1)
            {
                clickInterface.handleClick(view1);
            }

            
            {
                this$0 = NativeClickHandler.this;
                clickInterface = clickinterface;
                super();
            }
        });
    }


/*
    static boolean access$002(NativeClickHandler nativeclickhandler, boolean flag)
    {
        nativeclickhandler.mClickInProgress = flag;
        return flag;
    }

*/
}
