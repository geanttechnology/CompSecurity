// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;

public class fileType extends Model
{

    public static final fileType AfterLook = new <init>("AfterLook");
    public static final <init> Avatar = new <init>("Avatar");
    public static final <init> BeforeLook = new <init>("BeforeLook");
    public static final <init> DefaultUserCover = new <init>("DefaultUserCover");
    public static final <init> LookEffect = new <init>("LookEffect");
    public static final <init> Photo = new <init>("Photo");
    public static final <init> PostCover = new <init>("PostCover");
    public static final <init> PostCoverOri = new <init>("PostCoverOri");
    public static final <init> Video = new <init>("Video");
    public String fileType;

    public String toString()
    {
        return fileType;
    }


    public ()
    {
        fileType = null;
    }

    public fileType(String s)
    {
        fileType = null;
        fileType = s;
    }
}
