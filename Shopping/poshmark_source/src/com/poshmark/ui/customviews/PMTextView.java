// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.UserListFragment;
import com.poshmark.utils.CustomLinkMovementMethod;
import com.poshmark.utils.TextClickListener;
import com.poshmark.utils.TextFormatter;
import com.poshmark.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class PMTextView extends TextView
{

    private int fontColor;
    private String fontName;
    CustomLinkMovementMethod link;
    TextClickListener linkClickListener;
    TextClickListener multipleCommentslinkClickListener;
    TextClickListener multipleLikesClickListener;
    TextClickListener nameClickListener;
    View parentLayout;
    TextFormatter textFormatter;
    TextClickListener urlLinkClickListener;

    public PMTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        nameClickListener = new TextClickListener() {

            final PMTextView this$0;

            public void onClick(String s)
            {
                Bundle bundle = new Bundle();
                bundle.putString("NAME", s);
                s = (PMActivity)getContext();
                if (s != null && s.isActivityInForeground())
                {
                    s.launchFragment(bundle, com/poshmark/ui/fragments/ClosetFragment, null);
                }
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        };
        urlLinkClickListener = new TextClickListener() {

            final PMTextView this$0;

            public void onClick(String s)
            {
                s = Uri.parse(s);
                PMActivity pmactivity = (PMActivity)getContext();
                if (pmactivity instanceof MainActivity)
                {
                    ((MainActivity)pmactivity).handleDeepLinkLaunch(s, false);
                }
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        };
        multipleLikesClickListener = new TextClickListener() {

            final PMTextView this$0;

            public void onClick(String s)
            {
                Bundle bundle = new Bundle();
                bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.LIKES_MODE.name());
                bundle.putString("ID", s);
                ((PMActivity)getContext()).launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, null);
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        };
        linkClickListener = new TextClickListener() {

            final PMTextView this$0;

            public void onClick(String s)
            {
                new Bundle();
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        };
        multipleCommentslinkClickListener = new TextClickListener() {

            final PMTextView this$0;

            public void onClick(String s)
            {
                Bundle bundle = new Bundle();
                bundle.putString("ID", s);
                ((PMActivity)getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        };
        textFormatter = new TextFormatter();
        fontColor = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMTextView).getColor(0, 0);
        fontName = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMCommon).getString(0);
        if (fontName != null)
        {
            ViewUtils.setTypefaceForView(context, fontName, this);
        }
    }

    public int getFontColor()
    {
        return fontColor;
    }

    public String getFontName()
    {
        return fontName;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = super.onTouchEvent(motionevent);
        boolean flag = flag1;
        if (link != null)
        {
            flag = flag1;
            if (link.didUserTapOnNonLinkSpan())
            {
                flag = false;
            }
        }
        return flag;
    }

    public boolean performLongClick()
    {
        return false;
    }

    public void setComment(String s)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        link = (CustomLinkMovementMethod)CustomLinkMovementMethod.getInstance();
        link.setOnTextClickListener(new com.poshmark.utils.CustomLinkMovementMethod.TextClickedListener() {

            final PMTextView this$0;

            public void onTextClicked(int i, int j)
            {
            }

            
            {
                this$0 = PMTextView.this;
                super();
            }
        });
        setMovementMethod(link);
        setText(textFormatter.getClickableCommentString(this, nameClickListener, s));
    }

    public void setLikesMessage(List list, String s)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(textFormatter.getClickableLikesString(this, nameClickListener, multipleLikesClickListener, list, s));
    }

    public void setLinkString(String s, ArrayList arraylist)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(textFormatter.getClickableLinkString(this, linkClickListener, s, arraylist));
    }

    public void setMultipleCommentsLinkString(String s, String s1)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(textFormatter.getClickableSimpleString(this, multipleCommentslinkClickListener, s, s1));
    }

    public void setParentLayout(View view)
    {
        parentLayout = view;
    }

    public void setTitleWithHtmlString(String s, String s1)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(textFormatter.getHtmlStringWithClickableLinks(this, urlLinkClickListener, s, s1));
    }

    public void setUserName(String s)
    {
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(textFormatter.getClickableUserNameString(this, nameClickListener, s));
    }
}
