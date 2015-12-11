// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PostHomeActivity

class this._cls1
    implements android.content.ckListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/PostHomeActivity$4

/* anonymous class */
    class PostHomeActivity._cls4
        implements android.view.View.OnClickListener
    {

        final PostHomeActivity this$0;

        public void onClick(View view)
        {
            if (PostHomeActivity.access$100(PostHomeActivity.this) != null && PostHomeActivity.access$100(PostHomeActivity.this).getVisibility() == 0)
            {
                PostHomeActivity.access$100(PostHomeActivity.this).setVisibility(8);
                PostHomeActivity.access$000(PostHomeActivity.this).setVisibility(8);
            }
            view = AkConfigFactory.sharedInstance();
            boolean flag;
            if (!AkConfigFactory.sharedInstance().isChildProtectEnabled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setChildProtectEnabled(flag);
            SessionFactory.sharedInstance().SetChildrenProtect(AkConfigFactory.sharedInstance().isChildProtectEnabled());
            if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
            {
                view = new android.app.AlertDialog.Builder(PostHomeActivity.this);
                view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT_ACTIVE"));
                view.setCancelable(false);
                view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new PostHomeActivity._cls4._cls1());
                view.show();
                PostHomeActivity.access$200(PostHomeActivity.this).setImageResource(0x7f0201d9);
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(PostHomeActivity.this);
                view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT_DESACTIVE"));
                view.setCancelable(false);
                view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new PostHomeActivity._cls4._cls2());
                view.show();
                PostHomeActivity.access$200(PostHomeActivity.this).setImageResource(0x7f0201da);
                return;
            }
        }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/PostHomeActivity$4$2

/* anonymous class */
        class PostHomeActivity._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PostHomeActivity._cls4 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = PostHomeActivity._cls4.this;
                        super();
                    }
        }

    }

}
