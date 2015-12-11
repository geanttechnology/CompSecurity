// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.eps;

import android.text.TextUtils;

public final class GetImage
{
    public static final class Size extends Enum
    {

        private static final Size $VALUES[];
        public static final Size D200x200;
        public static final Size D300x300;
        public static final Size D32x32;
        public static final Size D400x400;
        public static final Size D500x500;
        public static final Size D64x64;
        public static final Size D800x800;
        public static final Size D96x96;

        public static Size valueOf(String s)
        {
            return (Size)Enum.valueOf(com/ebay/common/net/api/eps/GetImage$Size, s);
        }

        public static Size[] values()
        {
            return (Size[])$VALUES.clone();
        }

        static 
        {
            D32x32 = new Size("D32x32", 0);
            D64x64 = new Size("D64x64", 1);
            D96x96 = new Size("D96x96", 2);
            D200x200 = new Size("D200x200", 3);
            D300x300 = new Size("D300x300", 4);
            D400x400 = new Size("D400x400", 5);
            D500x500 = new Size("D500x500", 6);
            D800x800 = new Size("D800x800", 7);
            $VALUES = (new Size[] {
                D32x32, D64x64, D96x96, D200x200, D300x300, D400x400, D500x500, D800x800
            });
        }

        private Size(String s, int i)
        {
            super(s, i);
        }
    }


    static final String TAG = "GetImage";

    public GetImage()
    {
    }

    public static String convertUrl(String s, Size size)
    {
        while (TextUtils.isEmpty(s) || !s.contains("_") || !s.contains(".JPG") && !s.contains(".jpg")) 
        {
            return s;
        }
        int k = s.indexOf('_');
        int j = s.indexOf(".JPG");
        int i = j;
        if (j == -1)
        {
            i = s.indexOf(".jpg");
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s.substring(0, k + 1));
        stringbuilder.append(sizeToID(size));
        stringbuilder.append(s.substring(i));
        return stringbuilder.toString();
    }

    private static final int sizeToID(Size size)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[];

            static 
            {
                $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size = new int[Size.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D96x96.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D400x400.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D200x200.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D800x800.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D500x500.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D64x64.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D300x300.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$eps$GetImage$Size[Size.D32x32.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.common.net.api.eps.GetImage.Size[size.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;

        case 5: // '\005'
            return 12;

        case 6: // '\006'
            return 14;

        case 7: // '\007'
            return 35;

        case 8: // '\b'
            return 39;
        }
    }
}
