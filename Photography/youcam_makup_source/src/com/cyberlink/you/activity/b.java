// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.TextView;
import com.cyberlink.you.k;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class b
    implements android.widget.AbsListView.OnScrollListener
{

    final ChatDialogActivity a;
    private int b;
    private boolean c;

    private b(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
        b = -1;
        c = true;
    }

    b(ChatDialogActivity chatdialogactivity, ChatDialogActivity._cls1 _pcls1)
    {
        this(chatdialogactivity);
    }

    private void a(AbsListView abslistview)
    {
label0:
        {
            if (ChatDialogActivity.h(a))
            {
                if (abslistview.getLastVisiblePosition() < abslistview.getCount() - 1)
                {
                    break label0;
                }
                c = true;
            }
            return;
        }
        c = false;
    }

    static boolean a(b b1)
    {
        return b1.c;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int l)
    {
        a(abslistview);
        if (l > 0)
        {
            b = i;
        }
        if (ChatDialogActivity.e(a) != j)
        {
            ChatDialogActivity.a(a, j);
        }
        if (abslistview.getLastVisiblePosition() == l - 1 && ChatDialogActivity.f(a).getVisibility() == 0)
        {
            ChatDialogActivity.f(a).startAnimation(AnimationUtils.loadAnimation(ChatDialogActivity.g(a), k.exit_to_bottom));
            ChatDialogActivity.f(a).setVisibility(4);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0)
        {
            ChatDialogActivity.a(a, false);
            if (b == 0)
            {
                ChatDialogActivity.d(a);
            }
        } else
        {
            if (i == 1)
            {
                ChatDialogActivity.a(a, true);
                return;
            }
            if (i == 2)
            {
                return;
            }
        }
    }
}
