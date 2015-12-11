// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import co.vine.android.widget.DotIndicators;
import co.vine.android.widget.TypefacesTextView;

// Referenced classes of package co.vine.android:
//            ProfileHeaderAdapter

static class dropDownHolder
{

    public final DotIndicators dots;
    public final dropDownHolder dropDownHolder;
    public final Button follow;
    public final TypefacesTextView likesLabel;
    public final View likesParent;
    public final Button messageButton;
    public final ViewPager pager;
    public final TypefacesTextView postsLabel;
    public final View postsParent;
    public final ViewGroup profileActions;
    public final RelativeLayout profileBackground;
    public final ViewGroup profileTabArrow;
    public final ImageView profileTabArrowImage;
    public final ProgressBar progress;
    public final Button settings;
    public long userId;

    public (View view)
    {
        pager = (ViewPager)view.findViewById(0x7f0a00da);
        profileBackground = (RelativeLayout)view.findViewById(0x7f0a018a);
        follow = (Button)view.findViewById(0x7f0a018d);
        settings = (Button)view.findViewById(0x7f0a018c);
        messageButton = (Button)view.findViewById(0x7f0a018e);
        postsParent = view.findViewById(0x7f0a0190);
        postsLabel = (TypefacesTextView)view.findViewById(0x7f0a0191);
        likesParent = view.findViewById(0x7f0a0194);
        likesLabel = (TypefacesTextView)view.findViewById(0x7f0a0195);
        progress = (ProgressBar)view.findViewById(0x7f0a019a);
        profileTabArrow = (ViewGroup)view.findViewById(0x7f0a0192);
        profileTabArrowImage = (ImageView)view.findViewById(0x7f0a0193);
        dots = (DotIndicators)view.findViewById(0x7f0a00db);
        profileActions = (ViewGroup)view.findViewById(0x7f0a018b);
        view = view.findViewById(0x7f0a0196);
        dropDownHolder = new it>(view);
        view.setTag(dropDownHolder);
    }
}
