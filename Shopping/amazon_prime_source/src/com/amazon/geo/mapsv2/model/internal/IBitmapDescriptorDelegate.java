// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

public interface IBitmapDescriptorDelegate
    extends IObjectDelegate
{
    public static final class BitmapSource extends Enum
    {

        private static final BitmapSource $VALUES[];
        public static final BitmapSource ABS_PATH;
        public static final BitmapSource ASSET;
        public static final BitmapSource BITMAP;
        public static final BitmapSource DEFAULT;
        public static final BitmapSource DEFAULT_HUE;
        public static final BitmapSource FILE_NAME;
        public static final BitmapSource RSRC_ID;

        public static BitmapSource valueOf(String s)
        {
            return (BitmapSource)Enum.valueOf(com/amazon/geo/mapsv2/model/internal/IBitmapDescriptorDelegate$BitmapSource, s);
        }

        public static BitmapSource[] values()
        {
            return (BitmapSource[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new BitmapSource("DEFAULT", 0);
            DEFAULT_HUE = new BitmapSource("DEFAULT_HUE", 1);
            ASSET = new BitmapSource("ASSET", 2);
            BITMAP = new BitmapSource("BITMAP", 3);
            FILE_NAME = new BitmapSource("FILE_NAME", 4);
            ABS_PATH = new BitmapSource("ABS_PATH", 5);
            RSRC_ID = new BitmapSource("RSRC_ID", 6);
            $VALUES = (new BitmapSource[] {
                DEFAULT, DEFAULT_HUE, ASSET, BITMAP, FILE_NAME, ABS_PATH, RSRC_ID
            });
        }

        private BitmapSource(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract BitmapSource getBitmapSource();

    public abstract Object getData();
}
