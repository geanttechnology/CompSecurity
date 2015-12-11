// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceButton;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceEditText;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceTextView;
import com.xfinity.playerlib.config.PlayerConfiguration;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements android.view.ory
{

    final PlayerContainer this$0;

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        String s1 = getConfiguration().getXfinitySansFamilyName();
        if (TextUtils.equals(s, "TextView"))
        {
            s = new CustomTypefaceTextView(context, attributeset);
            s.setupDelegate(context, attributeset, 0, getTypefaceManager());
            s.setTypefaceFamilyName(s1);
            return s;
        }
        if (TextUtils.equals(s, "EditText"))
        {
            s = new CustomTypefaceEditText(context, attributeset);
            s.setupDelegate(context, attributeset, 0, getTypefaceManager());
            s.setTypefaceFamilyName(s1);
            return s;
        }
        if (TextUtils.equals(s, "Button"))
        {
            s = new CustomTypefaceButton(context, attributeset);
            s.setupDelegate(context, attributeset, 0, getTypefaceManager());
            s.setTypefaceFamilyName(s1);
            return s;
        } else
        {
            return null;
        }
    }

    mTypefaceButton()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
