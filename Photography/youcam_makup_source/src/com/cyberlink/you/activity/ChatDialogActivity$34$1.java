// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.DialogInterface;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;
import com.cyberlink.you.r;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements android.content.istener
{

    final a a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
    }

    ialogMode(ialogMode ialogmode)
    {
        a = ialogmode;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$34

/* anonymous class */
    class ChatDialogActivity._cls34
        implements android.view.View.OnClickListener
    {

        final ChatDialogActivity a;

        public void onClick(View view)
        {
            SparseBooleanArray sparsebooleanarray;
            int i;
            int j;
            view = new ArrayList();
            sparsebooleanarray = ChatDialogActivity.c(a).getCheckedItemPositions();
            j = ChatDialogActivity.c(a).getHeaderViewsCount();
            i = 0;
_L8:
            if (i < ChatDialogActivity.a(a).getCount() && sparsebooleanarray.size() > 0 && view.size() != sparsebooleanarray.size()) goto _L2; else goto _L1
_L1:
            if (!ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.b)) goto _L4; else goto _L3
_L3:
            view = new android.app.AlertDialog.Builder(ChatDialogActivity.g(a), 3);
            view.setTitle(a.getString(r.u_delete_message_title));
            view.setMessage(a.getString(r.u_delete_message_content));
            view.setNegativeButton(a.getString(r.u_cancel_text), new ChatDialogActivity._cls34._cls1(this));
            view.show();
_L6:
            return;
_L2:
            if (sparsebooleanarray.get(i + j))
            {
                view.add(ChatDialogActivity.a(a).b(i));
            }
            i++;
            continue; /* Loop/switch isn't completed */
_L4:
            if (!ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.c)) goto _L6; else goto _L5
_L5:
            return;
            if (true) goto _L8; else goto _L7
_L7:
        }

            
            {
                a = chatdialogactivity;
                super();
            }
    }

}
