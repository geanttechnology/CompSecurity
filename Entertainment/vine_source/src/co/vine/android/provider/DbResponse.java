// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


public class DbResponse
{

    public static final int RESPONSE_CODE_ERROR = 3;
    public static final int RESPONSE_CODE_NON_CONTINGUOUS_CLEAN_MADE = 4;
    public static final int RESPONSE_CODE_NO_CHANGE = 2;
    public static final int RESPONSE_CODE_SUCCESS = 1;
    public final int code;
    public final int numInserted;
    public final int numUpdated;

    public DbResponse(int i, int j, int k)
    {
        numInserted = i;
        numUpdated = j;
        code = k;
    }

    public String toString()
    {
        return (new StringBuilder()).append("<DbResponse> inserted: ").append(numInserted).append(" updated: ").append(numUpdated).append(" responseCode: ").append(code).toString();
    }
}
