// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.perfectcorp.model.Model;

public class aspectRatio extends Model
{

    public static final ostCover Avatar;
    public static final ostCover PostCover;
    public static final ostCover ProfileCover;
    public ostCover aspectRatio;
    public com.perfectcorp.utility.tting compressSetting;
    public boolean faceDetection;
    public com.cyberlink.beautycircle.model.network.PostCover fileType;
    public boolean useCircle;

    static 
    {
        Avatar = new <init>(com.perfectcorp.utility.tting.Avatar, true, true, com.cyberlink.beautycircle.model.network.Avatar, vatar);
        ProfileCover = new <init>(com.perfectcorp.utility.tting.ProfileCover, false, true, com.cyberlink.beautycircle.model.network.PostCover, rofileCover);
        PostCover = new <init>(com.perfectcorp.utility.tting.PostCover, false, false, com.cyberlink.beautycircle.model.network.PostCover, ostCover);
    }

    public File.FileType()
    {
    }

    public File.FileType(com.perfectcorp.utility.tting tting, boolean flag, boolean flag1, com.cyberlink.beautycircle.model.network. , File.FileType filetype)
    {
        compressSetting = tting;
        useCircle = flag;
        faceDetection = flag1;
        fileType = ;
        aspectRatio = filetype;
    }
}
