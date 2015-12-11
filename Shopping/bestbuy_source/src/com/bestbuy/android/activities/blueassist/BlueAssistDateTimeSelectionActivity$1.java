// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.widget.DatePicker;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.Calendar;
import ne;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistDateTimeSelectionActivity

class a
    implements android.app.stDateTimeSelectionActivity._cls1
{

    final BBYTextView a;
    final BlueAssistDateTimeSelectionActivity b;

    private void a()
    {
        a.setText(ne.a("EEE, MMM dd", BlueAssistDateTimeSelectionActivity.a(b).getTime()));
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        BlueAssistDateTimeSelectionActivity.a(b).set(1, i);
        BlueAssistDateTimeSelectionActivity.a(b).set(2, j);
        BlueAssistDateTimeSelectionActivity.a(b).set(5, k);
        a();
        BlueAssistDateTimeSelectionActivity.a(b, ne.a("MM/dd/yyyy", BlueAssistDateTimeSelectionActivity.a(b).getTime()));
        BlueAssistDateTimeSelectionActivity.b(b, BlueAssistDateTimeSelectionActivity.b(b));
        BlueAssistDateTimeSelectionActivity.a(b, BlueAssistDateTimeSelectionActivity.c(b), BlueAssistDateTimeSelectionActivity.b(b));
    }

    (BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity, BBYTextView bbytextview)
    {
        b = blueassistdatetimeselectionactivity;
        a = bbytextview;
        super();
    }
}
