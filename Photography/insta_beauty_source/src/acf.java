// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import com.fotoable.fotobeauty.ShareEditActivity;

public class acf
    implements TextWatcher
{

    final ShareEditActivity a;

    public acf(ShareEditActivity shareeditactivity)
    {
        a = shareeditactivity;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ShareEditActivity.a(a);
    }
}
