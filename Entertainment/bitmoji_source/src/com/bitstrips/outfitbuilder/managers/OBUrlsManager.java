// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.managers;

import com.bitstrips.outfitbuilder.models.OBAvatarData;

public class OBUrlsManager
{

    private static String BODY_URL = "%s/render/%s/AVATAR_ID-v1.png?scale=2&split_render=%%22body%%22&split_layer=1&body=BODY_JSON&colours=COLOUR_JSON";
    private static final int FEMALE_UNDERWEAR_OUTFIT = 0xda71c;
    private static final String FITTING_ROOM_TEMPLATE_ID = "9121772";
    private static String HEAD_URL = "%s/render/%s/AVATAR_ID-v1.png?scale=2&split_render=%%22head%%22&split_layer=LAYER_ID";
    private static final int MALE_UNDERWEAR_OUTFIT = 0xda71c;
    private static OBUrlsManager instance = null;
    private static String renderHost = null;

    public OBUrlsManager()
    {
        if (renderHost == null)
        {
            throw new UnsupportedOperationException("OBUrlsManager has not been initialized");
        } else
        {
            BODY_URL = String.format(BODY_URL, new Object[] {
                renderHost, "9121772"
            });
            HEAD_URL = String.format(HEAD_URL, new Object[] {
                renderHost, "9121772"
            });
            return;
        }
    }

    public static OBUrlsManager getInstance()
    {
        if (instance == null)
        {
            instance = new OBUrlsManager();
        }
        return instance;
    }

    public static void initialize(String s)
    {
        renderHost = s;
    }

    public String getFloatingOutfitUrl(int i, OBAvatarData obavatardata)
    {
        return (new StringBuilder()).append(getOutfitUrl(i, obavatardata)).append("&outfit_mode=1").toString();
    }

    public String getHeadBackUrl(String s)
    {
        return HEAD_URL.replace("AVATAR_ID", s).replace("LAYER_ID", "1");
    }

    public String getHeadFrontUrl(String s)
    {
        return HEAD_URL.replace("AVATAR_ID", s).replace("LAYER_ID", "0");
    }

    public String getNakedOutfit(OBAvatarData obavatardata)
    {
        if (obavatardata.getGender() != OBAvatarData.FEMALE);
        return getOutfitUrl(0xda71c, obavatardata);
    }

    public String getOutfitUrl(int i, OBAvatarData obavatardata)
    {
        obavatardata = BODY_URL.replace("AVATAR_ID", obavatardata.getDefaultAvatar()).replace("COLOUR_JSON", obavatardata.getColourJSONString()).replace("BODY_JSON", obavatardata.getBodyJSONString());
        return (new StringBuilder()).append(obavatardata).append("&outfit=").append(i).toString();
    }

}
