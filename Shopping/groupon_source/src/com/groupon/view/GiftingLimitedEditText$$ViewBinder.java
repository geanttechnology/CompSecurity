// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            GiftingLimitedEditText

public class _cls9
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, GiftingLimitedEditText giftinglimitededittext, Object obj)
    {
        giftinglimitededittext.editField = (EditText)nder.ld((View)nder.(obj, 0x7f1002f5, "field 'editField'"), 0x7f1002f5, "field 'editField'");
        giftinglimitededittext.counter = (TextView)nder.((View)nder.(obj, 0x7f1002f6, "field 'counter'"), 0x7f1002f6, "field 'counter'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (GiftingLimitedEditText)obj, obj1);
    }

    public void unbind(GiftingLimitedEditText giftinglimitededittext)
    {
        giftinglimitededittext.editField = null;
        giftinglimitededittext.counter = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GiftingLimitedEditText)obj);
    }

    public _cls9()
    {
    }
}
