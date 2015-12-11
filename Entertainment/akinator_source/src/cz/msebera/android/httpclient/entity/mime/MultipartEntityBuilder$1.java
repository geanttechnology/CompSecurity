// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity.mime;


// Referenced classes of package cz.msebera.android.httpclient.entity.mime:
//            MultipartEntityBuilder, HttpMultipartMode

static class 
{

    static final int $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[];

    static 
    {
        $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode = new int[HttpMultipartMode.values().length];
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[HttpMultipartMode.RFC6532.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
