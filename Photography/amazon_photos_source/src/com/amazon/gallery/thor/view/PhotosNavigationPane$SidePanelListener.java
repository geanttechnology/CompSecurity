// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.view;

import android.view.MenuItem;

// Referenced classes of package com.amazon.gallery.thor.view:
//            PhotosNavigationPane

public static interface I
{

    public abstract void onClosed();

    public abstract void onDragged();

    public abstract void onNavigate(MenuItem menuitem);

    public abstract void onOpened();
}
