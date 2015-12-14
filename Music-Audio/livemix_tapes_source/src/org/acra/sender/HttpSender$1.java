// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;


// Referenced classes of package org.acra.sender:
//            HttpSender

static class pe
{

    static final int $SwitchMap$org$acra$sender$HttpSender$Method[];
    static final int $SwitchMap$org$acra$sender$HttpSender$Type[];

    static 
    {
        $SwitchMap$org$acra$sender$HttpSender$Method = new int[thod.values().length];
        try
        {
            $SwitchMap$org$acra$sender$HttpSender$Method[thod.POST.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$org$acra$sender$HttpSender$Method[thod.PUT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$org$acra$sender$HttpSender$Type = new int[pe.values().length];
        try
        {
            $SwitchMap$org$acra$sender$HttpSender$Type[pe.JSON.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$acra$sender$HttpSender$Type[pe.FORM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
