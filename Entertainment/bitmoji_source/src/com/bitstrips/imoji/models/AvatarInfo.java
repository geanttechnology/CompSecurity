// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.text.TextUtils;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.models.OBAvatarData;

public class AvatarInfo
{

    int bodyType;
    int breastType;
    boolean bsauth;
    int gender;
    String id;
    String id_hash;
    boolean isDressed;
    int skinTone;
    int style;

    public AvatarInfo(String s, boolean flag)
    {
        id = s;
        bsauth = flag;
        gender = gender;
        style = style;
    }

    public static OBAvatarData getAvatarDataFromPreferences(PreferenceUtils preferenceutils)
    {
        String s = preferenceutils.getString(0x7f06002a, null);
        int i = preferenceutils.getInt(0x7f060028, -1).intValue();
        int j = preferenceutils.getInt(0x7f060021, -1).intValue();
        int k = preferenceutils.getInt(0x7f060022, -1).intValue();
        int l = preferenceutils.getInt(0x7f06002c, -1).intValue();
        if (s == null || i < 0 || j < 0 || k < 0 || l < 0)
        {
            return null;
        } else
        {
            return new OBAvatarData(s, i, j, k, l);
        }
    }

    public static String getIdHash(PreferenceUtils preferenceutils)
    {
        return preferenceutils.getString(0x7f060029, null);
    }

    public String getId()
    {
        return id;
    }

    public boolean getIsDressed()
    {
        return isDressed;
    }

    public int getStyle()
    {
        return style;
    }

    public boolean hasAvatar()
    {
        return !TextUtils.isEmpty(id);
    }

    public boolean hasBSAuthAccount()
    {
        return bsauth;
    }

    public void saveToPreferences(PreferenceUtils preferenceutils)
    {
        preferenceutils.putString(0x7f06002a, id);
        preferenceutils.putInt(0x7f060028, gender);
        preferenceutils.putInt(0x7f060021, bodyType);
        preferenceutils.putInt(0x7f060022, breastType);
        preferenceutils.putInt(0x7f06002c, skinTone);
        preferenceutils.putString(0x7f060029, id_hash);
    }
}
