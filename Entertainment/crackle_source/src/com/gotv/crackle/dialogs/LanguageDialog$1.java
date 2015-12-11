// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.view.View;
import android.widget.Spinner;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.RelatedItem;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.gotv.crackle.dialogs:
//            LanguageDialog

class this._cls0
    implements android.view.ner
{

    final LanguageDialog this$0;

    public void onClick(View view)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s;
        String s1;
        dismiss();
        view = null;
        obj1 = null;
        obj = null;
        s1 = (String)LanguageDialog.access$000(LanguageDialog.this).getSelectedItem();
        s = (String)LanguageDialog.access$100(LanguageDialog.this).getSelectedItem();
        obj2 = "";
        if (LanguageDialog.access$200(LanguageDialog.this)) goto _L2; else goto _L1
_L1:
        obj2 = LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getMediaUrls();
        view = ((View) (obj));
        if (s != null)
        {
            view = (List)LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getClosedCaptionFiles().get(s);
        }
        obj = LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getCaptionLocaleFromLanguage(s);
        obj1 = view;
_L4:
        view = s;
        if (s == null)
        {
            view = getString(0x7f0b00d5);
        }
        if (LanguageDialog.access$400(LanguageDialog.this) != null)
        {
            LanguageDialog.access$400(LanguageDialog.this).updateLanguageSettings(((Map) (obj2)), s1, view, ((List) (obj1)), ((String) (obj)));
        }
        return;
_L2:
        int i = 0;
        obj = obj2;
        do
        {
            obj2 = view;
            if (i >= LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems().length)
            {
                continue;
            }
            if (LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getLocalizedLanguage().equalsIgnoreCase(s1))
            {
                view = LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getMediaUrls();
            }
            obj1 = (List)LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getClosedCaptionFiles().get(s);
            obj = LanguageDialog.access$300(LanguageDialog.this).getCurrentItem().getRelatedItems()[i].getCaptionLocaleFromLanguage(s);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    nguageDialogListener()
    {
        this$0 = LanguageDialog.this;
        super();
    }
}
