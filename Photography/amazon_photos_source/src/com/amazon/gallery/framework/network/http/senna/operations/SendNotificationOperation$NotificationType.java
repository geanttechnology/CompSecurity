// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;


// Referenced classes of package com.amazon.gallery.framework.network.http.senna.operations:
//            SendNotificationOperation

public static final class notificationMode extends Enum
{

    private static final FIRETV_INSTALL_HELP $VALUES[];
    public static final FIRETV_INSTALL_HELP DESKTOP_INSTALL_HELP;
    public static final FIRETV_INSTALL_HELP FIRETV_INSTALL_HELP;
    public static final FIRETV_INSTALL_HELP MOBILE_INSTALL_HELP;
    public static final FIRETV_INSTALL_HELP MOBILE_INSTALL_HELP_EMAIL;
    private final FIRETV_INSTALL_HELP notificationMode;
    private final String value;

    public static notificationMode valueOf(String s)
    {
        return (notificationMode)Enum.valueOf(com/amazon/gallery/framework/network/http/senna/operations/SendNotificationOperation$NotificationType, s);
    }

    public static notificationMode[] values()
    {
        return (notificationMode[])$VALUES.clone();
    }

    public e_3B_.clone getNotificationMode()
    {
        return notificationMode;
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        DESKTOP_INSTALL_HELP = new <init>("DESKTOP_INSTALL_HELP", 0, "desktopInstallHelp", EMAIL);
        MOBILE_INSTALL_HELP = new <init>("MOBILE_INSTALL_HELP", 1, "mobileInstallHelp", SMS);
        MOBILE_INSTALL_HELP_EMAIL = new <init>("MOBILE_INSTALL_HELP_EMAIL", 2, "mobileInstallHelpEmail", EMAIL);
        FIRETV_INSTALL_HELP = new <init>("FIRETV_INSTALL_HELP", 3, "firetvInstallHelp", SMS);
        $VALUES = (new .VALUES[] {
            DESKTOP_INSTALL_HELP, MOBILE_INSTALL_HELP, MOBILE_INSTALL_HELP_EMAIL, FIRETV_INSTALL_HELP
        });
    }

    private (String s, int i, String s1,  )
    {
        super(s, i);
        value = s1;
        notificationMode = ;
    }
}
