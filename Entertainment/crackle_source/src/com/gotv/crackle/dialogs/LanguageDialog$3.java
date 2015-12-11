// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.RelatedItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.gotv.crackle.dialogs:
//            LanguageDialog

class this._cls0
    implements android.widget.mSelectedListener
{

    final LanguageDialog this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (LanguageDialog.access$200(LanguageDialog.this))
        {
            adapterview = (String)LanguageDialog.access$000(LanguageDialog.this).getSelectedItem();
            for (i = 0; i < LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems().length; i++)
            {
                if (LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getLocalizedLanguage().equalsIgnoreCase(adapterview))
                {
                    view = new ArrayList(LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getClosedCaptionFiles().keySet());
                    view.add(0, getString(0x7f0b00d5));
                    ArrayAdapter arrayadapter = new ArrayAdapter(LanguageDialog.access$500(LanguageDialog.this), 0x1090008, view.toArray(new String[view.size()]));
                    arrayadapter.setDropDownViewResource(0x1090009);
                    LanguageDialog.access$100(LanguageDialog.this).setAdapter(arrayadapter);
                    int j = view.indexOf(LanguageDialog.access$300(LanguageDialog.this).getCurrentCaptions());
                    LanguageDialog.access$100(LanguageDialog.this).setSelection(j);
                }
            }

        } else
        {
            adapterview = new ArrayList(LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getClosedCaptionFiles().keySet());
            adapterview.add(0, getString(0x7f0b00d5));
            view = new ArrayAdapter(LanguageDialog.access$500(LanguageDialog.this), 0x1090008, adapterview.toArray(new String[adapterview.size()]));
            view.setDropDownViewResource(0x1090009);
            LanguageDialog.access$100(LanguageDialog.this).setAdapter(view);
            i = adapterview.indexOf(LanguageDialog.access$300(LanguageDialog.this).getCurrentCaptions());
            LanguageDialog.access$100(LanguageDialog.this).setSelection(i);
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    essor()
    {
        this$0 = LanguageDialog.this;
        super();
    }
}
