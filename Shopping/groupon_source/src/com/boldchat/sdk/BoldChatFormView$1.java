// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.FormFieldType;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatFormView

static class pe
{

    static final int $SwitchMap$com$boldchat$visitor$api$FormFieldType[];

    static 
    {
        $SwitchMap$com$boldchat$visitor$api$FormFieldType = new int[FormFieldType.values().length];
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Text.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Email.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Phone.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Select.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Radio.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Rating.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
