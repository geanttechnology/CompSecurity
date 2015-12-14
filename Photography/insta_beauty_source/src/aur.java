// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class aur
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final InstagramPhotoShareActivity a;

    public aur(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        int j = seekbar.getProgress();
        int i = j;
        if (j <= 0)
        {
            i = 1;
        }
        InstagramPhotoShareActivity.a(a, i);
    }
}
