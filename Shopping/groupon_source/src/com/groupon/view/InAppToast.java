// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.inject.Provider;
import com.groupon.Channel;
import com.groupon.animation.DropDownAnimation;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.models.LoggingNSTExtras;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.service.DeepLinkManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import com.groupon.util.GrouponPointsUtil;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            InAppToastRoot

public class InAppToast
{

    private static final int ANIMATION_DURATION = 500;
    public static final String IN_APP_MESSAGE = "in_app_message";
    private int contentHeight;
    private View contentView;
    private DeepLinkData deepLink;
    private DeepLinkManager deepLinkManager;
    private ImageView dismiss;
    private GrouponPointsUtil grouponPointsUtil;
    private View layoutView;
    private Logger logger;
    private Provider loggerProvider;
    private TextView message;
    private InAppMessage model;
    private ObjectMapper objectMapper;
    private InAppToastRoot rootView;
    private TextView title;

    public InAppToast(Context context)
    {
        contentHeight = -1;
        rootView = (InAppToastRoot)View.inflate(context, 0x7f030144, null);
        rootView.setToast(this);
        RoboGuice.getInjector(context).injectMembers(this);
        layoutView = rootView.findViewById(0x7f1003c7);
        contentView = rootView.findViewById(0x7f1003c8);
        dismiss = (ImageView)rootView.findViewById(0x7f1003cb);
        message = (TextView)rootView.findViewById(0x7f1003ca);
        title = (TextView)rootView.findViewById(0x7f1003c9);
        updateModel(InAppMessage.getNoOpModel());
        contentView.setOnClickListener(new android.view.View.OnClickListener() {

            final InAppToast this$0;

            public void onClick(View view)
            {
                try
                {
                    logger.logClick("", "in_app_message", "view", model.getId());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Ln.e(view);
                }
                model.onClicked();
                if (deepLink != null)
                {
                    view = new LoggingNSTExtras();
                    view.referrer = "in_app";
                    try
                    {
                        view = objectMapper.writeValueAsString(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view = "";
                    }
                    ((Logger)loggerProvider.get()).logDeepLinking("", deepLink.toString(), deepLink.getAttributionCid(), deepLink.getAttributionLinkId(), deepLink.getUtmMediumAttribution(), view);
                    if (Uri.parse(deepLink.getParam("url")).getPath().startsWith("/points"))
                    {
                        grouponPointsUtil.appendQueryParams(deepLink);
                        grouponPointsUtil.logPointsNotificationClink(Channel.FEATURED.toString());
                        grouponPointsUtil.logPointsDeepLinking(deepLink.toString(), deepLink.getAttributionCid(), deepLink.getAttributionLinkId());
                    }
                    deepLinkManager.followDeepLink(rootView.getContext(), deepLink);
                }
                animateOut(0);
            }

            
            {
                this$0 = InAppToast.this;
                super();
            }
        });
        dismiss.setOnClickListener(new android.view.View.OnClickListener() {

            final InAppToast this$0;

            public void onClick(View view)
            {
                try
                {
                    logger.logClick("", "in_app_message", "close", model.getId());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Ln.e(view);
                }
                model.onDismissed();
                animateOut(0);
            }

            
            {
                this$0 = InAppToast.this;
                super();
            }
        });
    }

    private void animateIn()
    {
        if (contentHeight == -1 && rootView.getParent() != null)
        {
            contentView.measure(android.view.View.MeasureSpec.makeMeasureSpec(rootView.getWidth(), 0x40000000), 0);
            contentHeight = contentView.getMeasuredHeight();
        }
        if (contentHeight == -1)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        layoutView.setVisibility(0);
        Logger logger1 = logger;
        String s;
        if (Strings.equals(model.getId(), "7834"))
        {
            s = "localization_switch_confirm";
        } else
        {
            s = "";
        }
        try
        {
            logger1.logInAppMessage(s, model.getMessage(), model.getTarget(), model.getId(), Logger.NULL_NST_FIELD);
        }
        catch (Exception exception)
        {
            Ln.e(exception);
        }
        model.onViewed();
    }

    private void animateOut(int i)
    {
        if (layoutView.getVisibility() == 0)
        {
            doAnimation(i, 1, new Function0() {

                final InAppToast this$0;

                public void execute()
                {
                    layoutView.setVisibility(8);
                }

            
            {
                this$0 = InAppToast.this;
                super();
            }
            });
        }
    }

    protected void doAnimation(int i, int j, final Function0 endCallback)
    {
        if (layoutView.getLayoutParams().height == j)
        {
            return;
        } else
        {
            endCallback = new android.view.animation.Animation.AnimationListener() {

                final InAppToast this$0;
                final Function0 val$endCallback;

                public void onAnimationEnd(Animation animation)
                {
                    if (endCallback != null)
                    {
                        endCallback.execute();
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = InAppToast.this;
                endCallback = function0;
                super();
            }
            };
            DropDownAnimation dropdownanimation = new DropDownAnimation(layoutView, j, 500);
            dropdownanimation.setStartOffset(i);
            dropdownanimation.setAnimationListener(endCallback);
            contentView.startAnimation(dropdownanimation);
            return;
        }
    }

    public View getView()
    {
        return rootView;
    }

    public boolean isEnabled()
    {
        return model != null && model.isEnabled();
    }

    public void refresh()
    {
        refresh(0);
    }

    public void refresh(int i)
    {
        if (isEnabled())
        {
            animateIn();
            return;
        } else
        {
            animateOut(i);
            return;
        }
    }

    public void refreshIfNeeded(int i)
    {
        if (contentHeight == -1)
        {
            refresh(i);
        }
    }

    public void setDeepLink(DeepLinkData deeplinkdata)
    {
        deepLink = deeplinkdata;
    }

    public InAppToast updateModel(InAppMessage inappmessage)
    {
        model = inappmessage;
        if (isEnabled())
        {
            if (!Strings.isEmpty(inappmessage.getTitle()))
            {
                title.setVisibility(0);
                title.setText(inappmessage.getTitle());
            } else
            {
                title.setVisibility(8);
                int i = (int)(9F * getView().getResources().getDisplayMetrics().density + 0.5F);
                message.setPadding(0, i, 0, i);
            }
            message.setText(inappmessage.getMessage());
        }
        return this;
    }










}
