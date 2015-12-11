// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.util:
//            AttachmentContentProvider

public class EmailComposer
{

    private String mBody;
    private List mCCAddresses;
    private final Context mContext;
    private List mFileAttachments;
    private String mMIMEType;
    private String mSubject;
    private List mToAddresses;

    public EmailComposer(Context context, List list, List list1, String s, String s1)
    {
        mContext = context;
        mFileAttachments = new ArrayList();
        if (list != null)
        {
            mToAddresses = new ArrayList(list);
        }
        if (list1 != null)
        {
            mCCAddresses = new ArrayList(list1);
        }
        mSubject = s;
        mBody = s1;
        mMIMEType = "message/rfc822";
    }

    private File createTempFile(byte abyte0[], String s, String s1)
    {
        if (abyte0 == null || s == null || s1 == null)
        {
            return null;
        }
        Object obj = null;
        String s2 = obj;
        File file;
        try
        {
            file = new File(AttachmentContentProvider.getTempFilesPath(mContext));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.w("EmailComposer", abyte0.getMessage());
            return s2;
        }
        s2 = obj;
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        s2 = obj;
        file.mkdir();
        s2 = obj;
        s = File.createTempFile(s, (new StringBuilder()).append(".").append(s1).toString(), file);
        s2 = s;
        s1 = new FileOutputStream(s);
        s2 = s;
        s1.write(abyte0);
        s2 = s;
        s1.flush();
        s2 = s;
        s1.close();
        s2 = s;
        s.deleteOnExit();
        return s;
    }

    private ArrayList getAttachmentUris()
    {
        Object obj = null;
        if (mFileAttachments.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = mFileAttachments.iterator();
            do
            {
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (File)iterator.next();
                arraylist.add(Uri.parse((new StringBuilder()).append(AttachmentContentProvider.getAttachmentContentProviderAuthority(mContext)).append(((File) (obj)).getName()).toString()));
            } while (true);
        }
        return ((ArrayList) (obj));
    }

    public void attachFile(byte abyte0[], String s, String s1)
    {
        abyte0 = createTempFile(abyte0, s, s1);
        if (abyte0 != null)
        {
            mFileAttachments.add(abyte0);
        }
    }

    public void composeEmail()
    {
        Intent intent = new Intent();
        if (mToAddresses != null)
        {
            intent.putExtra("android.intent.extra.EMAIL", (String[])mToAddresses.toArray(new String[mToAddresses.size()]));
        }
        if (mCCAddresses != null)
        {
            intent.putExtra("android.intent.extra.CC", (String[])mCCAddresses.toArray(new String[mCCAddresses.size()]));
        }
        if (mSubject != null)
        {
            intent.putExtra("android.intent.extra.SUBJECT", mSubject);
        }
        if (mBody != null)
        {
            intent.putExtra("android.intent.extra.TEXT", mBody);
        }
        ArrayList arraylist = getAttachmentUris();
        intent.setType(mMIMEType);
        if (arraylist != null)
        {
            if (1 == arraylist.size())
            {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", (Parcelable)arraylist.get(0));
            } else
            {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arraylist);
            }
        } else
        {
            intent.setAction("android.intent.action.SEND");
        }
        mContext.startActivity(Intent.createChooser(intent, mContext.getString(com.amazon.mShop.android.lib.R.string.send_email)));
    }
}
