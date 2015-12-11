// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager

private class <init> extends BaseAdapter
{

    public int selectedPos;
    final ShareLinkManager this$0;

    public int getCount()
    {
        return ShareLinkManager.access$300(ShareLinkManager.this).size();
    }

    public Object getItem(int i)
    {
        return ShareLinkManager.access$300(ShareLinkManager.this).get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag;
        if (view == null)
        {
            view = new (ShareLinkManager.this, context_);
        } else
        {
            view = (this._cls0)view;
        }
        viewgroup = (ResolveInfo)ShareLinkManager.access$300(ShareLinkManager.this).get(i);
        if (i == selectedPos)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.el(viewgroup.loadLabel(context_.getPackageManager()).toString(), viewgroup.loadIcon(context_.getPackageManager()), flag);
        view.(viewgroup);
        view.ckable(false);
        return view;
    }

    public boolean isEnabled(int i)
    {
        return selectedPos < 0;
    }

    private ()
    {
        this$0 = ShareLinkManager.this;
        super();
        selectedPos = -1;
    }

    selectedPos(selectedPos selectedpos)
    {
        this();
    }
}
