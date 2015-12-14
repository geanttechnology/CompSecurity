// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.CompoundButton;
import com.fotoable.photoselector.uicomp.EncryptItemView;

public class asu
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final EncryptItemView a;

    public asu(EncryptItemView encryptitemview)
    {
        a = encryptitemview;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (EncryptItemView.access$000(a) != null)
        {
            EncryptItemView.access$000(a).c(flag);
        }
    }
}
