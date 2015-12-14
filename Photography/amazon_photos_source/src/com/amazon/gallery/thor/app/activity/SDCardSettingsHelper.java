// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;

public interface SDCardSettingsHelper
{

    public abstract void setupSDCardSettings(PreferenceScreen preferencescreen, PreferenceGroup preferencegroup, RemovableStorageManager removablestoragemanager);
}
