// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.content.DialogInterface;
import android.location.Address;
import java.util.List;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerAutocompleteDialogFragment

class this._cls0
    implements android.content.ragment._cls1
{

    final StorePickerAutocompleteDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (StorePickerAutocompleteDialogFragment.access$000(StorePickerAutocompleteDialogFragment.this) != null && StorePickerAutocompleteDialogFragment.access$000(StorePickerAutocompleteDialogFragment.this).size() > i)
        {
            StorePickerAutocompleteDialogFragment.access$102(StorePickerAutocompleteDialogFragment.this, (Address)StorePickerAutocompleteDialogFragment.access$000(StorePickerAutocompleteDialogFragment.this).get(i));
        }
        StorePickerAutocompleteDialogFragment.access$200(StorePickerAutocompleteDialogFragment.this).onAutocompleteItemSelected(StorePickerAutocompleteDialogFragment.this);
    }

    orePickerAutocompleteDialogListener()
    {
        this$0 = StorePickerAutocompleteDialogFragment.this;
        super();
    }
}
