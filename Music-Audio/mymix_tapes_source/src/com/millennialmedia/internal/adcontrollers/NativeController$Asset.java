// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;


// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            NativeController

public static class required
{
    public static class Data
    {

        public String label;
        public String value;

        public Data()
        {
        }
    }

    public static class Image
    {

        public Integer height;
        public String url;
        public Integer width;

        public Image()
        {
        }
    }

    public static class Title
    {

        public String value;

        public Title()
        {
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type DATA;
        public static final Type IMAGE;
        public static final Type TITLE;
        public static final Type UNKNOWN;
        public static final Type VIDEO;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/millennialmedia/internal/adcontrollers/NativeController$Asset$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            TITLE = new Type("TITLE", 0);
            IMAGE = new Type("IMAGE", 1);
            VIDEO = new Type("VIDEO", 2);
            DATA = new Type("DATA", 3);
            UNKNOWN = new Type("UNKNOWN", 4);
            $VALUES = (new Type[] {
                TITLE, IMAGE, VIDEO, DATA, UNKNOWN
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Video
    {

        public String vastTag;

        public Video()
        {
        }
    }


    public Data data;
    public int id;
    public Image image;
    public Image link;
    public boolean required;
    public Title title;
    public Type type;
    public Video video;

    Type(Type type1, int i, boolean flag)
    {
        required = false;
        type = type1;
        id = i;
        required = flag;
    }
}
