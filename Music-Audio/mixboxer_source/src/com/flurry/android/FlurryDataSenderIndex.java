// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.flurry.android:
//            q, cy, an, fl, 
//            FlurryDataSenderBlockInfo

public class FlurryDataSenderIndex
{

    private static Integer eB = Integer.valueOf(50);
    private HashMap eC;
    private ExecutorService eD;
    private Context mContext;

    public FlurryDataSenderIndex(Context context, String s)
    {
        mContext = null;
        mContext = context;
        eD = Executors.newSingleThreadExecutor();
        eC = new HashMap();
        if (!TextUtils.equals(s, mContext.getSharedPreferences("flurry_data_sender_preferences", 0).getString("flurry_data_sender_preferences", "")))
        {
            discardOutdatedBlocksForDataKey(s);
            context = mContext.getSharedPreferences("flurry_data_sender_preferences", 0).edit();
            context.putString("flurry_data_sender_preferences", s);
            context.commit();
        } else
        {
            context = o(s);
            eC.put(s, context);
        }
        if (eC.get(s) == null)
        {
            context = new LinkedList();
            eC.put(s, context);
        }
    }

    private void a(String s, List list)
    {
        eD.submit(new q(this, s, list));
    }

    static boolean a(FlurryDataSenderIndex flurrydatasenderindex, String s, List list)
    {
        return flurrydatasenderindex.b(s, list);
    }

    private boolean b(String s, List list)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSenderIndex", "saveToFile(byte[], ID) running on the MAIN thread!");
        }
        s = mContext.getFileStreamPath((new StringBuilder()).append(".FlurrySenderIndex.info.").append(s).toString());
        boolean flag1 = an.a(s);
        if (flag1) goto _L2; else goto _L1
_L1:
        fl.a(null);
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s));
        s = dataoutputstream;
        dataoutputstream.writeShort(list.size());
        int i = 0;
_L4:
        s = dataoutputstream;
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s = dataoutputstream;
        byte abyte0[] = ((String)list.get(i)).getBytes();
        s = dataoutputstream;
        int j = abyte0.length;
        s = dataoutputstream;
        cy.e("FlurryDataSenderIndex", (new StringBuilder()).append("write iter ").append(i).append(" dataLength = ").append(j).toString());
        s = dataoutputstream;
        dataoutputstream.writeShort(j);
        s = dataoutputstream;
        dataoutputstream.write(abyte0);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        s = dataoutputstream;
        dataoutputstream.writeShort(0);
        flag = true;
        fl.a(dataoutputstream);
          goto _L5
        Throwable throwable;
        throwable;
        list = null;
_L7:
        s = list;
        cy.b("FlurryDataSenderIndex", "", throwable);
        fl.a(list);
        flag = false;
          goto _L5
_L6:
        fl.a(s);
        throw list;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        list;
          goto _L6
        throwable;
        list = dataoutputstream;
          goto _L7
        list;
        s = null;
          goto _L6
    }

    private boolean n(String s)
    {
        return (new FlurryDataSenderBlockInfo(mContext, s)).deletePersistentData();
    }

    private List o(String s)
    {
        byte abyte0[] = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSenderIndex", "readFromFile(byte[], ID) running on the MAIN thread!");
        }
        s = mContext.getFileStreamPath((new StringBuilder()).append(".FlurrySenderIndex.info.").append(s).toString());
        flag = s.exists();
        if (!flag) goto _L2; else goto _L1
_L1:
        DataInputStream datainputstream1 = new DataInputStream(new FileInputStream(s));
        DataInputStream datainputstream = datainputstream1;
        int j = datainputstream1.readUnsignedShort();
        if (j != 0) goto _L4; else goto _L3
_L3:
        fl.a(datainputstream1);
        s = abyte0;
_L7:
        this;
        JVM INSTR monitorexit ;
        return s;
_L4:
        datainputstream = datainputstream1;
        s = new ArrayList(j);
        int i = 0;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        datainputstream = datainputstream1;
        int k = datainputstream1.readUnsignedShort();
        datainputstream = datainputstream1;
        cy.e("FlurryDataSenderIndex", (new StringBuilder()).append("read iter ").append(i).append(" dataLength = ").append(k).toString());
        datainputstream = datainputstream1;
        abyte0 = new byte[k];
        datainputstream = datainputstream1;
        datainputstream1.readFully(abyte0);
        datainputstream = datainputstream1;
        s.add(new String(abyte0));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        datainputstream = datainputstream1;
        datainputstream1.readUnsignedShort();
        fl.a(datainputstream1);
          goto _L7
        Throwable throwable;
        throwable;
        datainputstream1 = null;
        s = null;
_L9:
        datainputstream = datainputstream1;
        cy.b("FlurryDataSenderIndex", "Error when loading persistent file", throwable);
        fl.a(datainputstream1);
          goto _L7
        s;
        throw s;
        s;
        datainputstream = null;
_L8:
        fl.a(datainputstream);
        throw s;
_L2:
        cy.e("FlurryDataSenderIndex", "Agent cache file doesn't exist.");
        s = null;
          goto _L7
        s;
          goto _L8
        throwable;
        s = null;
          goto _L9
        throwable;
          goto _L9
    }

    public void addBlockInfo(FlurryDataSenderBlockInfo flurrydatasenderblockinfo, String s)
    {
        String s1 = flurrydatasenderblockinfo.getIdentifier();
        flurrydatasenderblockinfo = (List)eC.get(s);
        if (flurrydatasenderblockinfo == null)
        {
            cy.g("FlurryDataSenderIndex", "New Data Key");
            flurrydatasenderblockinfo = new LinkedList();
        }
        flurrydatasenderblockinfo.add(s1);
        if (flurrydatasenderblockinfo.size() > eB.intValue())
        {
            n((String)flurrydatasenderblockinfo.get(0));
            flurrydatasenderblockinfo.remove(0);
        }
        eC.put(s, flurrydatasenderblockinfo);
        a(s, flurrydatasenderblockinfo);
    }

    public boolean discardOutdatedBlocksForDataKey(String s)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
        }
        File file = mContext.getFileStreamPath((new StringBuilder()).append(".FlurrySenderIndex.info.").append(s).toString());
        List list = (List)eC.get(s);
        if (list != null)
        {
            List list1 = getNotSentBlocksForDataKey(s);
            for (int i = 0; i < list1.size(); i++)
            {
                n((String)list1.get(i));
            }

            list.clear();
            eC.put(s, list);
            if (file != null && file.exists())
            {
                if (file.delete())
                {
                    cy.c("FlurryDataSenderIndex", "Deleted persistence file");
                    return true;
                } else
                {
                    cy.d("FlurryDataSenderIndex", "Cannot delete persistence file");
                    return false;
                }
            }
        }
        return false;
    }

    public List getNotSentBlocksForDataKey(String s)
    {
        return (List)eC.get(s);
    }

    public boolean removeBlockInfoWithIdentifier(String s, String s1)
    {
        List list = (List)eC.get(s1);
        if (list == null)
        {
            return false;
        }
        n(s);
        boolean flag = list.remove(s);
        eC.put(s1, list);
        if (!flag)
        {
            return false;
        } else
        {
            a(s1, list);
            return true;
        }
    }

}
