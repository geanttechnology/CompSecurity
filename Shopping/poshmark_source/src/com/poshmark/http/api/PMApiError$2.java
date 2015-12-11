// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.data_model.models.PMErrorType;

// Referenced classes of package com.poshmark.http.api:
//            PMApiError

static class rorType
{

    static final int $SwitchMap$com$poshmark$data_model$models$PMErrorType[];

    static 
    {
        $SwitchMap$com$poshmark$data_model$models$PMErrorType = new int[PMErrorType.values().length];
        try
        {
            $SwitchMap$com$poshmark$data_model$models$PMErrorType[PMErrorType.CONNECTION_FAILURE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$data_model$models$PMErrorType[PMErrorType.CONNECTION_TIMEOUT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
