// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Filter;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumDialog, AlbumPickerAdapter

class this._cls0
    implements TextWatcher
{

    final AddToAlbumDialog this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        charsequence = charsequence.toString().trim();
        AddToAlbumDialog.access$000(AddToAlbumDialog.this).getFilter().filter(charsequence);
        AddToAlbumDialog.access$000(AddToAlbumDialog.this).setFilterText(charsequence);
        AddToAlbumDialog.access$100(AddToAlbumDialog.this).setError(null);
    }

    ()
    {
        this$0 = AddToAlbumDialog.this;
        super();
    }
}
