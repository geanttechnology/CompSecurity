// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorCollectionListActivity, ThorChooserActivity, RequestCode

public class CollectionListPickActivity extends ThorCollectionListActivity
{

    private boolean isOnResumeCalled;

    public CollectionListPickActivity()
    {
    }

    protected int getActionMenuId()
    {
        return -1;
    }

    public Class getLauncherActivityClass()
    {
        return com/amazon/gallery/thor/app/activity/ThorChooserActivity;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i != RequestCode.CHOOSER.ordinal())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (j != -1 || intent == null) goto _L2; else goto _L1
_L1:
        setResult(j, intent);
        finish();
_L4:
        return;
_L2:
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (intent != null && intent.hasExtra("tagType"))
        {
            setTagType((TagType)intent.getSerializableExtra("tagType"));
            return;
        }
        if (isOnResumeCalled) goto _L4; else goto _L5
_L5:
        finish();
        return;
        super.onActivityResult(i, j, intent);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onLongClick(View view, int i)
    {
    }

    public void onResume()
    {
        super.onResume();
        isOnResumeCalled = true;
    }

    public void startPhotosIntent(Intent intent)
    {
        Intent intent1 = getIntent();
        String s1 = intent1.getType();
        String s = s1;
        if (s1 == null)
        {
            android.net.Uri uri = intent1.getData();
            s = s1;
            if (uri != null)
            {
                s = getContentResolver().getType(uri);
            }
        }
        intent.putExtra("imageMediaType", intent1.getStringExtra("imageMediaType"));
        intent.putExtra("CHOOSER_ACTION", intent1.getAction());
        intent.setAction(intent1.getAction());
        intent.setType(s);
        startActivityForResult(intent, RequestCode.CHOOSER.ordinal());
        overridePendingTransition(0x7f04001c, 0x7f04001d);
    }
}
