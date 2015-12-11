// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class GiftingImages
{
    protected static class ImageBackground
    {

        public String url;

        protected ImageBackground()
        {
            url = "";
        }
    }

    protected static class ImageThumbnail
    {

        public String url;

        protected ImageThumbnail()
        {
            url = "";
        }
    }


    public ImageBackground imageBackground;
    public ImageThumbnail imageThumbnail;

    public GiftingImages()
    {
        imageBackground = new ImageBackground();
        imageThumbnail = new ImageThumbnail();
    }
}
