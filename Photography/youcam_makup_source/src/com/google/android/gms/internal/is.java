// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public class is
{

    public static final e KA = new e("sharedWithMe", 0x3e8fa0);
    public static final a Kw = new a("created", 0x3e8fa0);
    public static final b Kx = new b("lastOpenedTime", 0x419ce0);
    public static final d Ky = new d("modified", 0x3e8fa0);
    public static final c Kz = new c("modifiedByMe", 0x3e8fa0);


    private class a extends com.google.android.gms.drive.metadata.internal.d
        implements SortableMetadataField
    {

        public a(String s, int i)
        {
            super(s, i);
        }
    }


    private class b extends com.google.android.gms.drive.metadata.internal.d
        implements SearchableOrderedMetadataField, SortableMetadataField
    {

        public b(String s, int i)
        {
            super(s, i);
        }
    }


    private class d extends com.google.android.gms.drive.metadata.internal.d
        implements SearchableOrderedMetadataField, SortableMetadataField
    {

        public d(String s, int i)
        {
            super(s, i);
        }
    }


    private class c extends com.google.android.gms.drive.metadata.internal.d
        implements SortableMetadataField
    {

        public c(String s, int i)
        {
            super(s, i);
        }
    }


    private class e extends com.google.android.gms.drive.metadata.internal.d
        implements SearchableOrderedMetadataField, SortableMetadataField
    {

        public e(String s, int i)
        {
            super(s, i);
        }
    }

}
