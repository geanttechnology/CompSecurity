// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            b, DocumentSection, RegisterSectionInfo

public class DocumentContents
    implements SafeParcelable
{

    public static final b CREATOR = new b();
    final int a;
    final DocumentSection b[];
    public final String c;
    public final boolean d;
    public final Account e;

    DocumentContents(int i, DocumentSection adocumentsection[], String s, boolean flag, Account account)
    {
        a = i;
        b = adocumentsection;
        c = s;
        d = flag;
        e = account;
    }

    public final DocumentSection a(String s)
    {
        w.a(s);
        if (b != null)
        {
            DocumentSection adocumentsection[] = b;
            int j = adocumentsection.length;
            int i = 0;
            while (i < j) 
            {
                DocumentSection documentsection = adocumentsection[i];
                if (s.equals(documentsection.d.b))
                {
                    return documentsection;
                }
                i++;
            }
        }
        return null;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.appdatasearch.b.a(this, parcel, i);
    }

}
