// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v7.widget:
//            SearchView

private static final class c
{

    Method a;
    Method b;
    Method c;
    private Method d;

    final void a(AutoCompleteTextView autocompletetextview)
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        d.invoke(autocompletetextview, new Object[] {
            Boolean.valueOf(true)
        });
        return;
        autocompletetextview;
    }

    ager()
    {
        try
        {
            a = android/widget/AutoCompleteTextView.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            a.setAccessible(true);
        }
        catch (NoSuchMethodException nosuchmethodexception3) { }
        try
        {
            b = android/widget/AutoCompleteTextView.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            b.setAccessible(true);
        }
        catch (NoSuchMethodException nosuchmethodexception2) { }
        try
        {
            d = android/widget/AutoCompleteTextView.getMethod("ensureImeVisible", new Class[] {
                Boolean.TYPE
            });
            d.setAccessible(true);
        }
        catch (NoSuchMethodException nosuchmethodexception1) { }
        try
        {
            c = android/view/inputmethod/InputMethodManager.getMethod("showSoftInputUnchecked", new Class[] {
                Integer.TYPE, android/os/ResultReceiver
            });
            c.setAccessible(true);
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
    }
}
