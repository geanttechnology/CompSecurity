// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.g;


// Referenced classes of package com.target.ui.adapter.g:
//            a

static class nResultItem.a
{

    static final int $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[];

    static 
    {
        $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus = new int[com.target.ui.model.scan.ResultItem.a.values().length];
        try
        {
            $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ResultItem.a.UPC_RESULT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ResultItem.a.PRODUCT_RESULT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ResultItem.a.CONNECTION_ISSUE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ResultItem.a.PRODUCT_NOT_FOUND.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ResultItem.a.NO_RESULT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
