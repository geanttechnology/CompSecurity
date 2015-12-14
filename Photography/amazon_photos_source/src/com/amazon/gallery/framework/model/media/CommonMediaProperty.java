// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


// Referenced classes of package com.amazon.gallery.framework.model.media:
//            MediaProperty

public class CommonMediaProperty
{

    public static MediaProperty BLOB = new MediaProperty() {

        public String getName()
        {
            return "blob";
        }

    };
    public static MediaProperty CAMERA = new MediaProperty() {

        public String getName()
        {
            return "camera";
        }

    };
    public static MediaProperty FAVORITE = new MediaProperty() {

        public String getName()
        {
            return "favorite";
        }

    };
    public static MediaProperty LOCAL = new MediaProperty() {

        public String getName()
        {
            return "local";
        }

    };
    public static MediaProperty REMOVABLE = new MediaProperty() {

        public String getName()
        {
            return "removable";
        }

    };
    public static MediaProperty THISDAY = new MediaProperty() {

        public String getName()
        {
            return "thisDay";
        }

    };

}
