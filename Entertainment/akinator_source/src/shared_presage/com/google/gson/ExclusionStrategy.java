// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;


// Referenced classes of package shared_presage.com.google.gson:
//            FieldAttributes

public interface ExclusionStrategy
{

    public abstract boolean shouldSkipClass(Class class1);

    public abstract boolean shouldSkipField(FieldAttributes fieldattributes);
}
