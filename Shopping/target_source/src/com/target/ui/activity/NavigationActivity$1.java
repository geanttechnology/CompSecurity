// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import android.content.Intent;
import android.net.Uri;
import com.target.a.a.b;
import io.branch.referral.f;
import org.json.JSONException;

// Referenced classes of package com.target.ui.activity:
//            NavigationActivity

class val.intent
    implements com.target.ui.util.deep_link.tent
{

    final NavigationActivity this$0;
    final Intent val$intent;

    public void a(Uri uri)
    {
        Intent intent1 = new Intent(val$intent);
        intent1.setData(uri);
        NavigationActivity.a(NavigationActivity.this, intent1);
    }

    public void a(f f1)
    {
        b.a(NavigationActivity.TAG, (new StringBuilder()).append("Error from Branch SDK: ").append(f1.a()).toString());
    }

    public void a(JSONException jsonexception)
    {
        b.a(NavigationActivity.TAG, "Error parsing Branch payload: ", jsonexception);
    }

    ()
    {
        this$0 = final_navigationactivity;
        val$intent = Intent.this;
        super();
    }
}
