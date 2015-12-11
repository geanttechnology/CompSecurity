// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.groupon.activity.Carousel;
import com.groupon.activity.Countries;
import com.groupon.callbacks.MigrationViewListener;
import com.groupon.events.EventAcceptor;
import com.groupon.events.UserMigrationClickEvent;
import com.groupon.events.UserMigrationViewEvent;
import com.groupon.fragment.UserMigrationDialogFragment;
import com.groupon.util.UserMigrationManager;
import java.lang.ref.WeakReference;

public abstract class UserMigrationController
    implements MigrationViewListener
{
    protected static class ForcedMigrationController extends UserMigrationController
    {

        protected Intent createDownloadIntent(UserMigrationManager usermigrationmanager)
        {
            return usermigrationmanager.createForcedMigrationDownloadIntent();
        }

        public boolean hasNotificationsDisabled()
        {
            return true;
        }

        public void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
        {
            negativeButtonClicked(usermigrationdialogfragment, dialoginterface);
            notifyManager(UserMigrationClickEvent.CHANGE_COUNTRY);
        }

        public void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
        {
            positiveButtonClicked(usermigrationdialogfragment, dialoginterface);
            notifyManager(UserMigrationClickEvent.FORCED_DOWNLOAD);
            gotoDownload(usermigrationdialogfragment.getActivity());
        }

        public com.groupon.fragment.UserMigrationDialogFragment.Builder setup(com.groupon.fragment.UserMigrationDialogFragment.Builder builder)
        {
            builder.attachController(this).setTag(MigrationControllerType.FORCED_MIGRATION.name()).showableOn(com/groupon/activity/Countries).redirectIfNotOnCountries().setupAsForced();
            return builder;
        }

        protected ForcedMigrationController()
        {
        }
    }

    public static abstract class MigrationControllerType extends Enum
    {

        private static final MigrationControllerType $VALUES[];
        public static final MigrationControllerType FORCED_MIGRATION;
        public static final MigrationControllerType NOT_APPLICABLE;
        public static final MigrationControllerType SUGGESTED_MIGRATION;

        public static MigrationControllerType from(String s)
        {
            MigrationControllerType amigrationcontrollertype[] = values();
            int j = amigrationcontrollertype.length;
            for (int i = 0; i < j; i++)
            {
                MigrationControllerType migrationcontrollertype = amigrationcontrollertype[i];
                if (migrationcontrollertype.name().equals(s))
                {
                    return migrationcontrollertype;
                }
            }

            return NOT_APPLICABLE;
        }

        public static MigrationControllerType valueOf(String s)
        {
            return (MigrationControllerType)Enum.valueOf(com/groupon/service/UserMigrationController$MigrationControllerType, s);
        }

        public static MigrationControllerType[] values()
        {
            return (MigrationControllerType[])$VALUES.clone();
        }

        public abstract UserMigrationController instance();

        static 
        {
            FORCED_MIGRATION = new MigrationControllerType("FORCED_MIGRATION", 0) {

                public UserMigrationController instance()
                {
                    return new ForcedMigrationController();
                }

            };
            SUGGESTED_MIGRATION = new MigrationControllerType("SUGGESTED_MIGRATION", 1) {

                public UserMigrationController instance()
                {
                    return new SuggestedMigrationController();
                }

            };
            NOT_APPLICABLE = new MigrationControllerType("NOT_APPLICABLE", 2) {

                public UserMigrationController instance()
                {
                    return new NoOperationController();
                }

            };
            $VALUES = (new MigrationControllerType[] {
                FORCED_MIGRATION, SUGGESTED_MIGRATION, NOT_APPLICABLE
            });
        }

        private MigrationControllerType(String s, int i)
        {
            super(s, i);
        }

    }

    protected static class NoOperationController extends UserMigrationController
    {

        public boolean isEnabled()
        {
            return false;
        }

        public com.groupon.fragment.UserMigrationDialogFragment.Builder setup(com.groupon.fragment.UserMigrationDialogFragment.Builder builder)
        {
            return builder;
        }

        protected NoOperationController()
        {
        }
    }

    protected static class SuggestedMigrationController extends UserMigrationController
    {

        protected Intent createDownloadIntent(UserMigrationManager usermigrationmanager)
        {
            return usermigrationmanager.createSuggestedMigrationDownloadIntent();
        }

        public void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
        {
            negativeButtonClicked(usermigrationdialogfragment, dialoginterface);
            notifyManager(UserMigrationClickEvent.POSTPONED);
            postpone(0xf731400L);
        }

        public void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
        {
            positiveButtonClicked(usermigrationdialogfragment, dialoginterface);
            notifyManager(UserMigrationClickEvent.SUGGESTED_DOWNLOAD);
            postpone(0xf731400L);
            gotoDownload(usermigrationdialogfragment.getActivity());
        }

        public com.groupon.fragment.UserMigrationDialogFragment.Builder setup(com.groupon.fragment.UserMigrationDialogFragment.Builder builder)
        {
            builder.attachController(this).setTag(MigrationControllerType.SUGGESTED_MIGRATION.name()).showableOn(com/groupon/activity/Carousel).setupAsSuggestion();
            return builder;
        }

        protected SuggestedMigrationController()
        {
        }
    }


    public static final long REMIND_INTERVAL_MS = 0xf731400L;
    protected WeakReference managerRef;

    public UserMigrationController()
    {
    }

    public static UserMigrationController instantiate(String s)
    {
        return MigrationControllerType.from(s).instance();
    }

    private void notifyDialogDismissal()
    {
        UserMigrationManager usermigrationmanager = (UserMigrationManager)managerRef.get();
        if (usermigrationmanager != null)
        {
            usermigrationmanager.onDialogDismissed();
        }
    }

    public void attachManager(UserMigrationManager usermigrationmanager)
    {
        if (usermigrationmanager != null)
        {
            managerRef = new WeakReference(usermigrationmanager);
        }
    }

    protected Intent createDownloadIntent(UserMigrationManager usermigrationmanager)
    {
        return null;
    }

    public void detachManager()
    {
        if (managerRef != null)
        {
            managerRef.clear();
            managerRef = null;
        }
    }

    protected void gotoDownload(Activity activity)
    {
        if (activity != null)
        {
            UserMigrationManager usermigrationmanager = (UserMigrationManager)managerRef.get();
            if (usermigrationmanager != null)
            {
                activity.startActivity(createDownloadIntent(usermigrationmanager));
            }
        }
    }

    public boolean hasNotificationsDisabled()
    {
        return false;
    }

    public boolean isEnabled()
    {
        return true;
    }

    public void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
        notifyDialogDismissal();
    }

    protected void notifyManager(EventAcceptor eventacceptor)
    {
        UserMigrationManager usermigrationmanager = (UserMigrationManager)managerRef.get();
        if (usermigrationmanager != null)
        {
            usermigrationmanager.notifyOnEvent(eventacceptor);
        }
    }

    public void onDialogDisplayed(String s)
    {
        UserMigrationManager usermigrationmanager = (UserMigrationManager)managerRef.get();
        if (usermigrationmanager == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$service$UserMigrationController$MigrationControllerType[];

            static 
            {
                $SwitchMap$com$groupon$service$UserMigrationController$MigrationControllerType = new int[MigrationControllerType.values().length];
                try
                {
                    $SwitchMap$com$groupon$service$UserMigrationController$MigrationControllerType[MigrationControllerType.SUGGESTED_MIGRATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$service$UserMigrationController$MigrationControllerType[MigrationControllerType.FORCED_MIGRATION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.service.UserMigrationController.MigrationControllerType[MigrationControllerType.from(s).ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 49
    //                   2 57;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        usermigrationmanager.notifyOnEvent(UserMigrationViewEvent.SUGGESTED);
        return;
_L4:
        usermigrationmanager.notifyOnEvent(UserMigrationViewEvent.FORCED);
        return;
    }

    public void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
        notifyDialogDismissal();
    }

    protected void postpone(long l)
    {
        UserMigrationManager usermigrationmanager = (UserMigrationManager)managerRef.get();
        if (usermigrationmanager != null)
        {
            usermigrationmanager.postpone(l);
        }
    }

    public abstract com.groupon.fragment.UserMigrationDialogFragment.Builder setup(com.groupon.fragment.UserMigrationDialogFragment.Builder builder);
}
