// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class  extends 
{

    public  setPhotoId(long l)
    {
        addParam(EventParam.PHOTO_ID, Long.valueOf(l));
        return this;
    }

    public ()
    {
        super("photo_upload_failure_dialog_close");
    }
}
