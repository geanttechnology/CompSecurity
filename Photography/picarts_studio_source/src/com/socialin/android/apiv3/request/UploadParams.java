// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;

import com.socialin.android.apiv3.model.Adress;

// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithImage

public class UploadParams extends ParamWithImage
{

    public String apiKey;
    public String desc;
    public String id;
    public int isMature;
    public int isOriginal;
    public int isPublic;
    public Adress location;
    public String serverUrl;
    public String tags;
    public String timestamp;
    public String title;
    public String type;

    public UploadParams()
    {
        isMature = 0;
        isPublic = 0;
        id = "";
    }
}
