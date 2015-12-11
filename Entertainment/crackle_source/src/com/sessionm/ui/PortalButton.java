// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.sessionm.api.Activity;
import com.sessionm.api.User;
import com.sessionm.core.Drawables;
import com.sessionm.core.f;
import java.util.Locale;

// Referenced classes of package com.sessionm.ui:
//            ButtonManager, BadgeView

public class PortalButton extends FrameLayout
{

    private BadgeView badge;
    private int badgePosition;
    private ImageButton button;
    private BitmapDrawable enabledDrawable;
    private int resourceId;
    private boolean shouldShowBadge;
    private boolean useDefaultImages;

    protected PortalButton(Context context)
    {
        super(context);
        useDefaultImages = true;
        enabledDrawable = null;
        shouldShowBadge = true;
        resourceId = 0;
        badgePosition = 2;
        button = new ImageButton(getContext(), null);
        setupButton(context);
    }

    protected PortalButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        useDefaultImages = true;
        enabledDrawable = null;
        shouldShowBadge = true;
        resourceId = 0;
        badgePosition = 2;
        setupButton(context, attributeset);
    }

    protected PortalButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        useDefaultImages = true;
        enabledDrawable = null;
        shouldShowBadge = true;
        resourceId = 0;
        badgePosition = 2;
        setupButton(context, attributeset, i);
    }

    private void setupButton(Context context)
    {
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final PortalButton this$0;

            public void onClick(View view)
            {
                ButtonManager.getInstance().buttonPressed();
                view = f.E().F();
                view = String.format(Locale.US, "apps/%s/portal?origin=portal_button&z=%d", new Object[] {
                    view, Long.valueOf(System.currentTimeMillis())
                });
                f.E().b(new Activity(com.sessionm.api.SessionM.ActivityType.PORTAL), new Object[] {
                    view
                });
            }

            
            {
                this$0 = PortalButton.this;
                super();
            }
        });
        if (isInEditMode())
        {
            return;
        } else
        {
            ButtonManager.getInstance().registerButton(this);
            enabledDrawable = Drawables.av.e(context);
            (new Handler(getContext().getMainLooper())).post(new Runnable() {

                final PortalButton this$0;

                public void run()
                {
                    addView(button, new android.widget.FrameLayout.LayoutParams(-1, -1));
                    updateButton();
                }

            
            {
                this$0 = PortalButton.this;
                super();
            }
            });
            return;
        }
    }

    private void setupButton(Context context, AttributeSet attributeset)
    {
        button = new ImageButton(getContext(), attributeset);
        setupButton(context);
    }

    private void setupButton(Context context, AttributeSet attributeset, int i)
    {
        button = new ImageButton(getContext(), attributeset);
        setupButton(context);
    }

    private void showBadge()
    {
        badge.setBadgePosition(badgePosition);
        badge.setBadgeMargin(0, -3);
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 8F);
        translateanimation.setRepeatMode(2);
        translateanimation.setInterpolator(new BounceInterpolator());
        translateanimation.setFillAfter(true);
        translateanimation.setDuration(400L);
        badge.show(translateanimation);
    }

    private void updateButtonImage()
    {
        button.setEnabled(true);
        button.setBackgroundResource(0);
        button.setImageBitmap(null);
        if (useDefaultImages)
        {
            button.setImageDrawable(enabledDrawable);
            return;
        } else
        {
            button.setBackgroundResource(resourceId);
            return;
        }
    }

    private void updateLabelWithState(ButtonManager.LabelState labelstate)
    {
        if (button == null || getParent() == null || button.getParent() == null || !shouldShowBadge)
        {
            return;
        }
        if (badge == null)
        {
            badge = new BadgeView(getContext(), button);
        }
        if (labelstate.equals(ButtonManager.LabelState.LABEL_STATE_NORMAL))
        {
            int i = f.E().D().getUnclaimedAchievementCount();
            badge.setText(String.valueOf(i));
            showBadge();
            return;
        } else
        {
            badge.setText(null);
            badge.hide();
            return;
        }
    }

    protected int getBadgePosition()
    {
        return badgePosition;
    }

    protected ImageButton getButton()
    {
        return button;
    }

    protected int getResourceId()
    {
        return resourceId;
    }

    protected void onDisplayHint(int i)
    {
        updateButton();
    }

    protected void setBadgePosition(int i)
    {
        badgePosition = i;
        updateButton();
    }

    protected void setResourceId(int i)
    {
        useDefaultImages = false;
        resourceId = i;
        updateButtonImage();
    }

    protected void setShouldShowBadge(boolean flag)
    {
        shouldShowBadge = flag;
        updateButtonImage();
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        if (button != null)
        {
            button.setVisibility(i);
        }
        if (badge != null)
        {
            badge.setVisibility(i);
        }
    }

    protected boolean shouldShowBadge()
    {
        return shouldShowBadge;
    }

    void updateButton()
    {
        final ButtonManager.LabelState state = ButtonManager.getInstance().getLabelState();
        (new Handler(getContext().getMainLooper())).post(new Runnable() {

            final PortalButton this$0;
            final ButtonManager.LabelState val$state;

            public void run()
            {
                updateButtonImage();
                updateLabelWithState(state);
            }

            
            {
                this$0 = PortalButton.this;
                state = labelstate;
                super();
            }
        });
    }



}
