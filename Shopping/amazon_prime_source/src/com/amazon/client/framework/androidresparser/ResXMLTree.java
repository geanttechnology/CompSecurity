// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;


// Referenced classes of package com.amazon.client.framework.androidresparser:
//            ResXMLTree_node, ResStringPool, ResXMLParser

public class ResXMLTree
{
    public static final class Ext extends Enum
    {

        private static final Ext $VALUES[];
        public static final Ext ResXMLTree_attrExt;
        public static final Ext ResXMLTree_cdataExt;
        public static final Ext ResXMLTree_endElementExt;
        public static final Ext ResXMLTree_namespaceExt;
        private final int sizeBytes;

        public static Ext valueOf(String s)
        {
            return (Ext)Enum.valueOf(com/amazon/client/framework/androidresparser/ResXMLTree$Ext, s);
        }

        public static Ext[] values()
        {
            return (Ext[])$VALUES.clone();
        }

        static 
        {
            ResXMLTree_attrExt = new Ext("ResXMLTree_attrExt", 0, 20);
            ResXMLTree_endElementExt = new Ext("ResXMLTree_endElementExt", 1, 8);
            ResXMLTree_cdataExt = new Ext("ResXMLTree_cdataExt", 2, 8);
            ResXMLTree_namespaceExt = new Ext("ResXMLTree_namespaceExt", 3, 8);
            $VALUES = (new Ext[] {
                ResXMLTree_attrExt, ResXMLTree_endElementExt, ResXMLTree_cdataExt, ResXMLTree_namespaceExt
            });
        }


        private Ext(String s, int i, int j)
        {
            super(s, i);
            sizeBytes = j;
        }
    }


    public static final int MAX_EXT_SIZE;
    int mResIds[];
    int mRootCode;
    ResXMLTree_node mRootNode;
    ResStringPool mStrings;

    public ResXMLTree(ResXMLParser resxmlparser)
    {
    }

    public static int sizeof(Ext ext)
    {
        return ext.sizeBytes;
    }

    static 
    {
        int j = 0;
        Ext aext[] = Ext.values();
        int l = aext.length;
        for (int i = 0; i < l;)
        {
            Ext ext = aext[i];
            int k = j;
            if (ext.sizeBytes > j)
            {
                k = ext.sizeBytes;
            }
            i++;
            j = k;
        }

        MAX_EXT_SIZE = j;
    }
}
