// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;


// Referenced classes of package android.support.v4.content:
//            EditorCompatGingerbread

public class EditorHelperBaseImpl
{

    private static Helper.apply sInstance;
    private final Helper mHelper;

    public static EditorHelperBaseImpl getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new <init>();
        }
        return sInstance;
    }

    public void apply(android.content.itorCompat itorcompat)
    {
        class Helper
        {

            public abstract void apply(android.content.SharedPreferences.Editor editor);
        }

        mHelper.apply(itorcompat);
    }

    private EditorHelperBaseImpl()
    {
        if (android.os.at.EditorCompat >= 9)
        {
            class EditorHelperApi9Impl
                implements Helper
            {

                public void apply(android.content.SharedPreferences.Editor editor)
                {
                    EditorCompatGingerbread.apply(editor);
                }

            private EditorHelperApi9Impl()
            {
            }

            EditorHelperApi9Impl(SharedPreferencesCompat._cls1 _pcls1)
            {
                this();
            }
            }

            mHelper = new EditorHelperApi9Impl(null);
            return;
        } else
        {
            class EditorHelperBaseImpl
                implements Helper
            {

                public void apply(android.content.SharedPreferences.Editor editor)
                {
                    editor.commit();
                }

            private EditorHelperBaseImpl()
            {
            }

            EditorHelperBaseImpl(SharedPreferencesCompat._cls1 _pcls1)
            {
                this();
            }
            }

            mHelper = new EditorHelperBaseImpl(null);
            return;
        }
    }
}
