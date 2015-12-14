// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SendNotificationOperation extends AbstractHttpPostMessage
{
    public static final class NotificationMode extends Enum
    {

        private static final NotificationMode $VALUES[];
        public static final NotificationMode EMAIL;
        public static final NotificationMode SMS;
        private final String value;

        public static NotificationMode valueOf(String s)
        {
            return (NotificationMode)Enum.valueOf(com/amazon/gallery/framework/network/http/senna/operations/SendNotificationOperation$NotificationMode, s);
        }

        public static NotificationMode[] values()
        {
            return (NotificationMode[])$VALUES.clone();
        }

        public String toString()
        {
            return value;
        }

        static 
        {
            EMAIL = new NotificationMode("EMAIL", 0, "email");
            SMS = new NotificationMode("SMS", 1, "sms");
            $VALUES = (new NotificationMode[] {
                EMAIL, SMS
            });
        }

        private NotificationMode(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class NotificationType extends Enum
    {

        private static final NotificationType $VALUES[];
        public static final NotificationType DESKTOP_INSTALL_HELP;
        public static final NotificationType FIRETV_INSTALL_HELP;
        public static final NotificationType MOBILE_INSTALL_HELP;
        public static final NotificationType MOBILE_INSTALL_HELP_EMAIL;
        private final NotificationMode notificationMode;
        private final String value;

        public static NotificationType valueOf(String s)
        {
            return (NotificationType)Enum.valueOf(com/amazon/gallery/framework/network/http/senna/operations/SendNotificationOperation$NotificationType, s);
        }

        public static NotificationType[] values()
        {
            return (NotificationType[])$VALUES.clone();
        }

        public NotificationMode getNotificationMode()
        {
            return notificationMode;
        }

        public String toString()
        {
            return value;
        }

        static 
        {
            DESKTOP_INSTALL_HELP = new NotificationType("DESKTOP_INSTALL_HELP", 0, "desktopInstallHelp", NotificationMode.EMAIL);
            MOBILE_INSTALL_HELP = new NotificationType("MOBILE_INSTALL_HELP", 1, "mobileInstallHelp", NotificationMode.SMS);
            MOBILE_INSTALL_HELP_EMAIL = new NotificationType("MOBILE_INSTALL_HELP_EMAIL", 2, "mobileInstallHelpEmail", NotificationMode.EMAIL);
            FIRETV_INSTALL_HELP = new NotificationType("FIRETV_INSTALL_HELP", 3, "firetvInstallHelp", NotificationMode.SMS);
            $VALUES = (new NotificationType[] {
                DESKTOP_INSTALL_HELP, MOBILE_INSTALL_HELP, MOBILE_INSTALL_HELP_EMAIL, FIRETV_INSTALL_HELP
            });
        }

        private NotificationType(String s, int i, String s1, NotificationMode notificationmode)
        {
            super(s, i);
            value = s1;
            notificationMode = notificationmode;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/SendNotificationOperation.getName();
    private final CharSequence destination;
    private final String locale = Locale.getDefault().toString();
    private final NotificationMode notificationMode;
    private final NotificationType notificationType;

    public SendNotificationOperation(HttpFactory httpfactory, NotificationMode notificationmode, NotificationType notificationtype, CharSequence charsequence)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.SendNotification);
        notificationMode = notificationmode;
        notificationType = notificationtype;
        destination = charsequence;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public Void buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return null;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("notificationType", notificationType.toString());
            jsonobject.put("locale", locale.toString());
            if (destination != null && notificationType != NotificationType.MOBILE_INSTALL_HELP_EMAIL)
            {
                jsonobject.put("destination", destination);
            }
        }
        catch (JSONException jsonexception)
        {
            throw new InvalidParameterException("Error creating request post body", jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append(String.format("social/%s/notify/CUSTOMER_ID", new Object[] {
            notificationMode
        })).toString());
    }

}
