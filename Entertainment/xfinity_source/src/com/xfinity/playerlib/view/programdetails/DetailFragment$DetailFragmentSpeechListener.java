// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.widget.LinearLayout;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment

protected class this._cls0 extends DefaultSpeechListener
{

    final DetailFragment this$0;

    public boolean onSpeechResponsePlay(String as[])
    {
        if (as.length == 0)
        {
            as = getFirstPlayButton();
            if (as != null)
            {
                as.callOnClick();
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected ()
    {
        this$0 = DetailFragment.this;
        super();
    }
}
