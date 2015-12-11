// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.TextUtils;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            TagSearchFragment, PendingRequest

private class <init> extends AppSessionListener
{

    final TagSearchFragment this$0;

    public void onTagSearchComplete(String s, int i, String s1, int j, int k, int l)
    {
        s = removeRequest(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        hideProgress(((PendingRequest) (s)).fetchType);
        i;
        JVM INSTR tableswitch 200 200: default 44
    //                   200 76;
           goto _L3 _L4
_L3:
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getString(0x7f0e00cf);
        }
        Util.showCenteredToast(getActivity(), s);
_L2:
        return;
_L4:
        if (j < 1)
        {
            cleanSearchResults();
            showSadface(true, false);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private ()
    {
        this$0 = TagSearchFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
