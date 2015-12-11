// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import com.jumio.netverify.sdk.NetverifyDocumentData;
import java.util.HashMap;

// Referenced classes of package com.jumio.netverify.sdk.custom:
//            NetverifyDocumentPart

public interface NetverifyCustomSDKInterface
{

    public abstract void onNetverifyCountriesReceived(HashMap hashmap, String s);

    public abstract void onNetverifyError(int i, String s, boolean flag, String s1);

    public abstract void onNetverifyFinished(NetverifyDocumentData netverifydocumentdata, String s);

    public abstract void onNetverifyResourcesLoaded();

    public abstract void onNetverifyScanForPartFinished(NetverifyDocumentPart netverifydocumentpart, String s, boolean flag);
}
