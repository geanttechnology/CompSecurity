// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.DialogInterface;
import com.groupon.fragment.UserMigrationDialogFragment;
import com.groupon.util.UserMigrationManager;

public interface MigrationViewListener
{

    public abstract void attachManager(UserMigrationManager usermigrationmanager);

    public abstract void detachManager();

    public abstract void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface);

    public abstract void onDialogDisplayed(String s);

    public abstract void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface);
}
