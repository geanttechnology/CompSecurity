// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.activity.link.view.LinkBaseView;
import com.wantu.activity.link.view.LinkBodyDouble1;
import com.wantu.activity.link.view.LinkBodyDouble2;
import com.wantu.activity.link.view.LinkBodyRight5;
import com.wantu.activity.link.view.LinkBodySingle1;
import com.wantu.activity.link.view.LinkBodySingle2;
import com.wantu.activity.link.view.LinkBodySingle3;
import com.wantu.activity.link.view.LinkBodySingle4;
import com.wantu.activity.link.view.LinkBodySingle5;
import com.wantu.activity.link.view.LinkBodySingle6;
import com.wantu.activity.link.view.LinkFooter1;
import com.wantu.activity.link.view.LinkFooter2;
import com.wantu.activity.link.view.LinkFooter3;
import com.wantu.activity.link.view.LinkFooter4;
import com.wantu.activity.link.view.LinkFooter5;
import com.wantu.activity.link.view.LinkFooter6;
import com.wantu.activity.link.view.LinkHeader1;
import com.wantu.activity.link.view.LinkHeader2;
import com.wantu.activity.link.view.LinkHeader3;
import com.wantu.activity.link.view.LinkHeader4;
import com.wantu.activity.link.view.LinkHeader5;
import com.wantu.activity.link.view.LinkHeader6;

public class bip
{

    public static LinkBaseView a(String s, Context context)
    {
        LinkHeader1 linkheader1 = null;
        if (s.equalsIgnoreCase("LinkHeader1"))
        {
            linkheader1 = new LinkHeader1(context);
        } else
        {
            if (s.equalsIgnoreCase("LinkFooter1"))
            {
                return new LinkFooter1(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle1"))
            {
                return new LinkBodySingle1(context);
            }
            if (s.equalsIgnoreCase("LinkBodyDouble1"))
            {
                return new LinkBodyDouble1(context);
            }
            if (s.equalsIgnoreCase("LinkHeader2"))
            {
                return new LinkHeader2(context);
            }
            if (s.equalsIgnoreCase("LinkFooter2"))
            {
                return new LinkFooter2(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle2"))
            {
                return new LinkBodySingle2(context);
            }
            if (s.equalsIgnoreCase("LinkBodyDouble2"))
            {
                return new LinkBodyDouble2(context);
            }
            if (s.equalsIgnoreCase("LinkHeader3"))
            {
                return new LinkHeader3(context);
            }
            if (s.equalsIgnoreCase("LinkFooter3"))
            {
                return new LinkFooter3(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle3"))
            {
                return new LinkBodySingle3(context);
            }
            if (s.equalsIgnoreCase("LinkHeader4"))
            {
                return new LinkHeader4(context);
            }
            if (s.equalsIgnoreCase("LinkFooter4"))
            {
                return new LinkFooter4(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle4"))
            {
                return new LinkBodySingle4(context);
            }
            if (s.equalsIgnoreCase("LinkHeader5"))
            {
                return new LinkHeader5(context);
            }
            if (s.equalsIgnoreCase("LinkFooter5"))
            {
                return new LinkFooter5(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle5"))
            {
                return new LinkBodySingle5(context);
            }
            if (s.equalsIgnoreCase("LinkBodyRight5"))
            {
                return new LinkBodyRight5(context);
            }
            if (s.equalsIgnoreCase("LinkHeader6"))
            {
                return new LinkHeader6(context);
            }
            if (s.equalsIgnoreCase("LinkFooter6"))
            {
                return new LinkFooter6(context);
            }
            if (s.equalsIgnoreCase("LinkBodySingle6"))
            {
                return new LinkBodySingle6(context);
            }
        }
        return linkheader1;
    }
}
