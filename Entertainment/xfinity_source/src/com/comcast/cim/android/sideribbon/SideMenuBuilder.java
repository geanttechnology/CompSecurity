// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SlideClosedRequestListener

public interface SideMenuBuilder
{

    public abstract View build(Activity activity, ViewGroup viewgroup, SlideClosedRequestListener slideclosedrequestlistener);
}
