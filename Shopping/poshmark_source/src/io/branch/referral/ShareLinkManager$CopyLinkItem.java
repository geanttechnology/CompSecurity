// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager

private class <init> extends ResolveInfo
{

    final ShareLinkManager this$0;

    public Drawable loadIcon(PackageManager packagemanager)
    {
        return ShareLinkManager.access$600(ShareLinkManager.this).yUrlIcon();
    }

    public CharSequence loadLabel(PackageManager packagemanager)
    {
        return ShareLinkManager.access$600(ShareLinkManager.this).yURlText();
    }

    private ()
    {
        this$0 = ShareLinkManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
