// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.o;
import com.cyberlink.you.p;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView

public class PeopleCompleteView extends TokenCompleteTextView
{

    public PeopleCompleteView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    private void d()
    {
        a(false);
        setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.c);
    }

    protected View a(Friend friend)
    {
        RelativeLayout relativelayout = (RelativeLayout)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.view_people_complete_token, (ViewGroup)getParent(), false);
        ((TextView)relativelayout.findViewById(o.txt_token)).setText(friend.b());
        return relativelayout;
    }

    protected volatile View a(Object obj)
    {
        return a((Friend)obj);
    }

    protected Friend a(String s)
    {
        return new Friend();
    }

    protected void a(View view)
    {
        ImageView imageview = (ImageView)view.findViewById(o.imageViewDelete);
        if (imageview != null)
        {
            int i;
            if (view.isSelected())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            imageview.setVisibility(i);
        }
    }

    protected Object b(String s)
    {
        return a(s);
    }
}
