// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public interface 
{

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract boolean isConnected();

    public abstract void zza(iClient.zza zza1);

    public abstract void zza(zzo zzo);

    public abstract void zza(zzo zzo, Set set);

    public abstract boolean zzjM();
}
