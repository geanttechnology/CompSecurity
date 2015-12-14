// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


// Referenced classes of package com.amazon.gallery.framework.model.tags:
//            TagProperty

public class CommonTagProperty
{
    public static final class AutoSave extends Enum
        implements TagProperty
    {

        private static final AutoSave $VALUES[];
        public static final AutoSave NO;
        public static final AutoSave YES;

        public static AutoSave valueOf(String s)
        {
            return (AutoSave)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$AutoSave, s);
        }

        public static AutoSave[] values()
        {
            return (AutoSave[])$VALUES.clone();
        }

        static 
        {
            NO = new AutoSave("NO", 0);
            YES = new AutoSave("YES", 1);
            $VALUES = (new AutoSave[] {
                NO, YES
            });
        }

        private AutoSave(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Misc extends Enum
        implements TagProperty
    {

        private static final Misc $VALUES[];
        public static final Misc CAMERA;
        public static final Misc FREETIME;
        public static final Misc NOT_SET;
        public static final Misc YOUR_CLOUD_DRIVE;

        public static Misc valueOf(String s)
        {
            return (Misc)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Misc, s);
        }

        public static Misc[] values()
        {
            return (Misc[])$VALUES.clone();
        }

        static 
        {
            NOT_SET = new Misc("NOT_SET", 0);
            CAMERA = new Misc("CAMERA", 1);
            YOUR_CLOUD_DRIVE = new Misc("YOUR_CLOUD_DRIVE", 2);
            FREETIME = new Misc("FREETIME", 3);
            $VALUES = (new Misc[] {
                NOT_SET, CAMERA, YOUR_CLOUD_DRIVE, FREETIME
            });
        }

        private Misc(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NewContent extends Enum
        implements TagProperty
    {

        private static final NewContent $VALUES[];
        public static final NewContent NO;
        public static final NewContent YES;

        public static NewContent valueOf(String s)
        {
            return (NewContent)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$NewContent, s);
        }

        public static NewContent[] values()
        {
            return (NewContent[])$VALUES.clone();
        }

        static 
        {
            NO = new NewContent("NO", 0);
            YES = new NewContent("YES", 1);
            $VALUES = (new NewContent[] {
                NO, YES
            });
        }

        private NewContent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RemovableStorage extends Enum
        implements TagProperty
    {

        private static final RemovableStorage $VALUES[];
        public static final RemovableStorage NO;
        public static final RemovableStorage YES;

        public static RemovableStorage valueOf(String s)
        {
            return (RemovableStorage)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$RemovableStorage, s);
        }

        public static RemovableStorage[] values()
        {
            return (RemovableStorage[])$VALUES.clone();
        }

        static 
        {
            NO = new RemovableStorage("NO", 0);
            YES = new RemovableStorage("YES", 1);
            $VALUES = (new RemovableStorage[] {
                NO, YES
            });
        }

        private RemovableStorage(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Status extends Enum
        implements TagProperty
    {

        private static final Status $VALUES[];
        public static final Status NOT_UPLOADED;
        public static final Status NO_UPLOAD_STATE;
        public static final Status UPLOADED;
        public static final Status UPLOADING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            NO_UPLOAD_STATE = new Status("NO_UPLOAD_STATE", 0);
            NOT_UPLOADED = new Status("NOT_UPLOADED", 1);
            UPLOADING = new Status("UPLOADING", 2);
            UPLOADED = new Status("UPLOADED", 3);
            $VALUES = (new Status[] {
                NO_UPLOAD_STATE, NOT_UPLOADED, UPLOADING, UPLOADED
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Storage extends Enum
        implements TagProperty
    {

        private static final Storage $VALUES[];
        public static final Storage CLOUD;
        public static final Storage LOCAL;
        public static final Storage NOT_SET;

        public static Storage valueOf(String s)
        {
            return (Storage)Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Storage, s);
        }

        public static Storage[] values()
        {
            return (Storage[])$VALUES.clone();
        }

        static 
        {
            NOT_SET = new Storage("NOT_SET", 0);
            LOCAL = new Storage("LOCAL", 1);
            CLOUD = new Storage("CLOUD", 2);
            $VALUES = (new Storage[] {
                NOT_SET, LOCAL, CLOUD
            });
        }

        private Storage(String s, int i)
        {
            super(s, i);
        }
    }

}
