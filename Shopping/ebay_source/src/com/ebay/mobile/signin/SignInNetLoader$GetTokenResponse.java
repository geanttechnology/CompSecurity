// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.signin:
//            SignInNetLoader

public static final class Exception extends EbayResponse
{

    public String actorId;
    public String email;
    public String machineGroupId;
    public String token;
    public String userId;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ion
    {
        arser arser = new arser(this);
        SaxHandler.parseXml(inputstream, arser);
        if (arser.response.ackCode == 1 && TextUtils.isEmpty(token))
        {
            setAckCode(-1);
            inputstream = new EbayResponseError();
            inputstream.longMessage = "Missing IAF token";
            inputstream.category = 1;
            inputstream.severity = 1;
            inputstream.userDisplay = false;
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(inputstream);
            setErrors(arraylist);
        }
    }

    public Exception()
    {
    }
}
