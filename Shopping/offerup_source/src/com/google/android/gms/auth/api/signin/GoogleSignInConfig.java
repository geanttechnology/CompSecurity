// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            zze

public class GoogleSignInConfig
    implements com.google.android.gms.common.api.Api.ApiOptions.Optional, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    public static final Scope zzTe = new Scope("profile");
    public static final Scope zzTf = new Scope("email");
    public static final Scope zzTg = new Scope("openid");
    public static final GoogleSignInConfig zzTh = (new zza()).zzmc();
    final int versionCode;
    private Account zzQd;
    private final ArrayList zzSX;
    private boolean zzTi;
    private final boolean zzTj;
    private final boolean zzTk;
    private String zzTl;

    GoogleSignInConfig(int i, ArrayList arraylist, Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        versionCode = i;
        zzSX = arraylist;
        zzQd = account;
        zzTi = flag;
        zzTj = flag1;
        zzTk = flag2;
        zzTl = s;
    }

    private GoogleSignInConfig(Set set, Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        this(1, new ArrayList(set), account, flag, flag1, flag2, s);
    }

    GoogleSignInConfig(Set set, Account account, boolean flag, boolean flag1, boolean flag2, String s, _cls1 _pcls1)
    {
        this(set, account, flag, flag1, flag2, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (zzSX.size() != ((GoogleSignInConfig) (obj = (GoogleSignInConfig)obj)).zzlS().size() || !zzSX.containsAll(((GoogleSignInConfig) (obj)).zzlS())) goto _L1; else goto _L3
_L3:
        if (zzQd != null) goto _L5; else goto _L4
_L4:
        if (((GoogleSignInConfig) (obj)).getAccount() != null) goto _L1; else goto _L6
_L6:
        if (!TextUtils.isEmpty(zzTl)) goto _L8; else goto _L7
_L7:
        if (!TextUtils.isEmpty(((GoogleSignInConfig) (obj)).zzmb()))
        {
            break; /* Loop/switch isn't completed */
        }
_L10:
        if (zzTk == ((GoogleSignInConfig) (obj)).zzma() && zzTi == ((GoogleSignInConfig) (obj)).zzlY() && zzTj == ((GoogleSignInConfig) (obj)).zzlZ())
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (!zzQd.equals(((GoogleSignInConfig) (obj)).getAccount())) goto _L9; else goto _L6
_L9:
        break; /* Loop/switch isn't completed */
_L8:
        boolean flag;
        try
        {
            flag = zzTl.equals(((GoogleSignInConfig) (obj)).zzmb());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (!flag) goto _L1; else goto _L10
    }

    public Account getAccount()
    {
        return zzQd;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = zzSX.iterator(); iterator.hasNext(); arraylist.add(((Scope)iterator.next()).zznG())) { }
        Collections.sort(arraylist);
        return (new zzc()).zzl(arraylist).zzl(zzQd).zzl(zzTl).zzP(zzTk).zzP(zzTi).zzP(zzTj).zzmd();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public ArrayList zzlS()
    {
        return new ArrayList(zzSX);
    }

    public boolean zzlY()
    {
        return zzTi;
    }

    public boolean zzlZ()
    {
        return zzTj;
    }

    public boolean zzma()
    {
        return zzTk;
    }

    public String zzmb()
    {
        return zzTl;
    }


    private class zza
    {

        private Account zzQd;
        private boolean zzTi;
        private boolean zzTj;
        private boolean zzTk;
        private String zzTl;
        private Set zzTm;

        public final GoogleSignInConfig zzmc()
        {
            return new GoogleSignInConfig(zzTm, zzQd, zzTi, zzTj, zzTk, zzTl, null);
        }

        public zza()
        {
            zzTm = new HashSet(Arrays.asList(new Scope[] {
                GoogleSignInConfig.zzTg
            }));
        }
    }

}
