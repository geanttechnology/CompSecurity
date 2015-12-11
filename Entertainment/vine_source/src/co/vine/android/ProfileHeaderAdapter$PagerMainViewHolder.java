// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;
import co.vine.android.widget.TypefacesTextView;

// Referenced classes of package co.vine.android:
//            ProfileHeaderAdapter

static class following
{

    public final TypefacesTextView followers;
    public final TypefacesTextView following;
    public ImageView imageAction;
    public ImageView imageFrame;
    public ImageView imageView;
    public ImageKey userImageKey;
    public TextView username;
    public ImageView verified;

    public (View view)
    {
        imageFrame = (ImageView)view.findViewById(0x7f0a022a);
        username = (TextView)view.findViewById(0x7f0a00c4);
        verified = (ImageView)view.findViewById(0x7f0a01a2);
        imageView = (ImageView)view.findViewById(0x7f0a0063);
        imageAction = (ImageView)view.findViewById(0x7f0a022b);
        followers = (TypefacesTextView)view.findViewById(0x7f0a01a3);
        following = (TypefacesTextView)view.findViewById(0x7f0a01a4);
    }
}
