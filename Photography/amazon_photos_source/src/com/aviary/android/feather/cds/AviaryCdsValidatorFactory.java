// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Context;
import com.aviary.android.feather.common.log.LoggerFactory;
import java.io.File;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsPreviewValidator, AviaryCdsContentValidator

public final class AviaryCdsValidatorFactory
{
    public static abstract class Validator
    {

        com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
        final AviaryCds.PackType mPackType;

        AviaryCds.PackType getPackType()
        {
            return mPackType;
        }

        public abstract boolean validate(Context context, long l, File file, boolean flag)
            throws AssertionError;

        public Validator(AviaryCds.PackType packtype)
        {
            logger = LoggerFactory.getLogger(com/aviary/android/feather/cds/AviaryCdsValidatorFactory.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
            mPackType = packtype;
        }
    }


    private AviaryCdsValidatorFactory()
    {
    }

    public static Validator create(AviaryCds.ContentType contenttype, AviaryCds.PackType packtype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType = new int[AviaryCds.ContentType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.PREVIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.CONTENT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.ContentType[contenttype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new AviaryCdsPreviewValidator(packtype);

        case 2: // '\002'
            return new AviaryCdsContentValidator(packtype);
        }
    }
}
