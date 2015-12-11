// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


// Referenced classes of package org.apache.james.mime4j.stream:
//            MimeEntity, EntityState

static class 
{

    static final int $SwitchMap$org$apache$james$mime4j$stream$EntityState[];

    static 
    {
        $SwitchMap$org$apache$james$mime4j$stream$EntityState = new int[EntityState.values().length];
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MESSAGE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_BODYPART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_HEADER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_FIELD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_HEADER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MULTIPART.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_PREAMBLE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_EPILOGUE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_BODY.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MULTIPART.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_OF_STREAM.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MESSAGE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_RAW_ENTITY.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_BODYPART.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
