// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignupFormFragment, CameraPreviewFragment

class this._cls0
    implements android.view.rmFragment._cls3
{

    final SignupFormFragment this$0;

    public void onClick(View view)
    {
        SignupFormFragment.access$102(SignupFormFragment.this, SignupFormFragment.access$200(SignupFormFragment.this).getHeight());
        SignupFormFragment.access$302(SignupFormFragment.this, SignupFormFragment.access$200(SignupFormFragment.this).getWidth());
        view = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        view.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraPreviewFragment);
        Bundle bundle = new Bundle();
        bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
        view.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(view, SignupFormFragment.access$400(SignupFormFragment.this));
    }

    ()
    {
        this$0 = SignupFormFragment.this;
        super();
    }
}
