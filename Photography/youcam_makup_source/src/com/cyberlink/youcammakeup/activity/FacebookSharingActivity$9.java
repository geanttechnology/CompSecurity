// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.facebook.Response;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements com.facebook.ebookSharingActivity._cls9
{

    final FacebookSharingActivity a;

    public void onCompleted(GraphUser graphuser, Response response)
    {
        if (graphuser != null)
        {
            FacebookSharingActivity.f(a).setProfileId(graphuser.getId());
            FacebookSharingActivity.a(a, true);
        }
        FacebookSharingActivity.a(a, null);
    }

    (FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
