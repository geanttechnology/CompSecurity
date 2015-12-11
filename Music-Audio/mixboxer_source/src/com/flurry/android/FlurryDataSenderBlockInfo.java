// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

// Referenced classes of package com.flurry.android:
//            cy, fl, an

public class FlurryDataSenderBlockInfo
{

    private File au;
    private String gh;
    private long gi;
    private int gj;

    public FlurryDataSenderBlockInfo(Context context)
    {
        gh = null;
        gi = -1L;
        gj = -1;
        au = null;
        gh = UUID.randomUUID().toString();
        au = context.getFileStreamPath((new StringBuilder()).append(".flurrydatasenderblock.").append(gh).toString());
    }

    public FlurryDataSenderBlockInfo(Context context, String s)
    {
        gh = null;
        gi = -1L;
        gj = -1;
        au = null;
        gh = s;
        au = context.getFileStreamPath((new StringBuilder()).append(".flurrydatasenderblock.").append(gh).toString());
    }

    public boolean deletePersistentData()
    {
        if (au.exists())
        {
            if (au.delete())
            {
                cy.c("FlurryDataSenderBlockInfo", "Deleted persistence file");
                gi = -1L;
                gj = -1;
                return true;
            }
            cy.d("FlurryDataSenderBlockInfo", "Cannot delete persistence file");
        }
        return false;
    }

    public boolean exists()
    {
        while (TextUtils.isEmpty(gh) || au == null || !au.exists()) 
        {
            return false;
        }
        return true;
    }

    public long getCreationDate()
    {
        return gi;
    }

    public byte[] getData()
    {
        byte abyte0[];
        Object obj3;
        obj3 = null;
        abyte0 = null;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSenderBlockInfo", "getData() running on the MAIN thread!");
        }
        if (!au.exists()) goto _L2; else goto _L1
_L1:
        cy.e("FlurryDataSenderBlockInfo", (new StringBuilder()).append("Reading FlurryDataSenderBlockInfo: ").append(au.getAbsolutePath()).toString());
        Object obj2 = new DataInputStream(new FileInputStream(au));
        Object obj;
        Object obj1;
        obj = obj2;
        obj1 = obj3;
        int i = ((DataInputStream) (obj2)).readUnsignedShort();
        if (i == 0)
        {
            fl.a(((java.io.Closeable) (obj2)));
            return null;
        }
        obj = obj2;
        obj1 = obj3;
        abyte0 = new byte[i];
        obj = obj2;
        obj1 = abyte0;
        ((DataInputStream) (obj2)).readFully(abyte0);
        obj = obj2;
        obj1 = abyte0;
        ((DataInputStream) (obj2)).readUnsignedShort();
        fl.a(((java.io.Closeable) (obj2)));
        return abyte0;
        Throwable throwable;
        throwable;
        obj1 = null;
_L6:
        obj = obj1;
        cy.b("FlurryDataSenderBlockInfo", "Error when loading persistent file", throwable);
        fl.a(((java.io.Closeable) (obj1)));
        return abyte0;
        obj;
        obj2 = null;
        obj1 = obj;
_L4:
        fl.a(((java.io.Closeable) (obj2)));
        throw obj1;
_L2:
        cy.e("FlurryDataSenderBlockInfo", "Agent cache file doesn't exist.");
        return null;
        obj1;
        obj2 = obj;
        if (true) goto _L4; else goto _L3
_L3:
        throwable;
        abyte0 = ((byte []) (obj1));
        obj1 = obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getDataSize()
    {
        return gj;
    }

    public String getIdentifier()
    {
        return gh;
    }

    public boolean setData(byte abyte0[])
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSenderBlockInfo", "setData(byte[]) running on the MAIN thread!");
        }
        cy.e("FlurryDataSenderBlockInfo", (new StringBuilder()).append("Writing FlurryDataSenderBlockInfo: ").append(au.getAbsolutePath()).toString());
        boolean flag2 = an.a(au);
        if (!flag2)
        {
            fl.a(null);
            return false;
        }
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(au));
        Object obj;
        obj = dataoutputstream;
        flag = flag1;
        int i = abyte0.length;
        obj = dataoutputstream;
        flag = flag1;
        dataoutputstream.writeShort(i);
        obj = dataoutputstream;
        flag = flag1;
        dataoutputstream.write(abyte0);
        obj = dataoutputstream;
        flag = flag1;
        dataoutputstream.writeShort(0);
        flag1 = true;
        obj = dataoutputstream;
        flag = flag1;
        gj = i;
        obj = dataoutputstream;
        flag = flag1;
        gi = System.currentTimeMillis();
        fl.a(dataoutputstream);
        return true;
        Throwable throwable;
        throwable;
        abyte0 = null;
_L4:
        obj = abyte0;
        cy.b("FlurryDataSenderBlockInfo", "", throwable);
        fl.a(abyte0);
        return flag;
        abyte0;
        obj = null;
_L2:
        fl.a(((java.io.Closeable) (obj)));
        throw abyte0;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
        throwable;
        abyte0 = dataoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
