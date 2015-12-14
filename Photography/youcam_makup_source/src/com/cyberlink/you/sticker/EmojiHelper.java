// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cyberlink.you.n;
import com.rockerhieu.emojicon.EmojiconHandler;
import com.rockerhieu.emojicon.emoji.Emojicon;
import com.rockerhieu.emojicon.emoji.Nature;
import com.rockerhieu.emojicon.emoji.Objects;
import com.rockerhieu.emojicon.emoji.People;
import com.rockerhieu.emojicon.emoji.Places;
import com.rockerhieu.emojicon.emoji.Symbols;

public class EmojiHelper
{

    public static Bitmap a(Context context, EmojiCategory emojicategory)
    {
        if (emojicategory.equals(EmojiCategory.a))
        {
            return BitmapFactory.decodeResource(context.getResources(), n.emoji_1f600);
        }
        if (emojicategory.equals(EmojiCategory.b))
        {
            return BitmapFactory.decodeResource(context.getResources(), n.emoji_1f436);
        }
        if (emojicategory.equals(EmojiCategory.c))
        {
            return BitmapFactory.decodeResource(context.getResources(), n.emoji_1f38d);
        }
        if (emojicategory.equals(EmojiCategory.d))
        {
            return BitmapFactory.decodeResource(context.getResources(), n.emoji_1f3e0);
        }
        if (emojicategory.equals(EmojiCategory.e))
        {
            return BitmapFactory.decodeResource(context.getResources(), n.emoji_0031);
        } else
        {
            return null;
        }
    }

    public static Bitmap a(Context context, Emojicon emojicon)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeResource(context.getResources(), EmojiconHandler.getOtherEmojiResource(context, emojicon.getEmoji()));
        }
    }

    public static boolean a(Context context, String s)
    {
        while (context == null || EmojiconHandler.getOtherEmojiResource(context, s) == 0) 
        {
            return false;
        }
        return true;
    }

    public static Emojicon[] a(EmojiCategory emojicategory)
    {
        if (emojicategory.equals(EmojiCategory.a))
        {
            return People.DATA;
        }
        if (emojicategory.equals(EmojiCategory.b))
        {
            return Nature.DATA;
        }
        if (emojicategory.equals(EmojiCategory.c))
        {
            return Objects.DATA;
        }
        if (emojicategory.equals(EmojiCategory.d))
        {
            return Places.DATA;
        }
        if (emojicategory.equals(EmojiCategory.e))
        {
            return Symbols.DATA;
        } else
        {
            return null;
        }
    }

    private class EmojiCategory extends Enum
    {

        public static final EmojiCategory a;
        public static final EmojiCategory b;
        public static final EmojiCategory c;
        public static final EmojiCategory d;
        public static final EmojiCategory e;
        private static final EmojiCategory f[];

        public static EmojiCategory valueOf(String s)
        {
            return (EmojiCategory)Enum.valueOf(com/cyberlink/you/sticker/EmojiHelper$EmojiCategory, s);
        }

        public static EmojiCategory[] values()
        {
            return (EmojiCategory[])f.clone();
        }

        static 
        {
            a = new EmojiCategory("People", 0);
            b = new EmojiCategory("Nature", 1);
            c = new EmojiCategory("Objects", 2);
            d = new EmojiCategory("Cars", 3);
            e = new EmojiCategory("Punctuation", 4);
            f = (new EmojiCategory[] {
                a, b, c, d, e
            });
        }

        private EmojiCategory(String s, int i)
        {
            super(s, i);
        }
    }

}
