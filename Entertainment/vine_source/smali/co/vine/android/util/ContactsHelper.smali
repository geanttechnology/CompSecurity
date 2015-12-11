.class public Lco/vine/android/util/ContactsHelper;
.super Ljava/lang/Object;
.source "ContactsHelper.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/ContactsHelper$ContactCursorLoader;,
        Lco/vine/android/util/ContactsHelper$ContactHelperListener;,
        Lco/vine/android/util/ContactsHelper$ProfileQuery;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final GOOGLE_ACCOUNT:Ljava/lang/String; = "com.google"

.field private static final LOADER_ID_CONTACTS_DATA:I = 0x2

.field private static final LOADER_ID_CONTACTS_PROFILE:I = 0x1


# instance fields
.field private mFragment:Landroid/support/v4/app/Fragment;

.field private mListener:Lco/vine/android/util/ContactsHelper$ContactHelperListener;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/Fragment;Lco/vine/android/util/ContactsHelper$ContactHelperListener;)V
    .locals 0
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "listener"    # Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    iput-object p1, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    .line 84
    iput-object p2, p0, Lco/vine/android/util/ContactsHelper;->mListener:Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    .line 85
    return-void
.end method

.method public static loadContacts(Landroid/support/v4/app/Fragment;Lco/vine/android/util/ContactsHelper$ContactHelperListener;)V
    .locals 1
    .param p0, "fragment"    # Landroid/support/v4/app/Fragment;
    .param p1, "listener"    # Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    .prologue
    .line 72
    new-instance v0, Lco/vine/android/util/ContactsHelper;

    invoke-direct {v0, p0, p1}, Lco/vine/android/util/ContactsHelper;-><init>(Landroid/support/v4/app/Fragment;Lco/vine/android/util/ContactsHelper$ContactHelperListener;)V

    .line 73
    .local v0, "helper":Lco/vine/android/util/ContactsHelper;
    invoke-virtual {v0}, Lco/vine/android/util/ContactsHelper;->init()V

    .line 74
    return-void
.end method


# virtual methods
.method public init()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 88
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v3

    if-nez v3, :cond_0

    .line 89
    iget-object v3, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v1

    .line 90
    .local v1, "lm":Landroid/support/v4/app/LoaderManager;
    const/4 v3, 0x1

    invoke-virtual {v1, v3, v4, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 91
    const/4 v3, 0x2

    invoke-virtual {v1, v3, v4, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 93
    iget-object v3, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 94
    .local v2, "manager":Landroid/accounts/AccountManager;
    const-string v3, "com.google"

    invoke-virtual {v2, v3}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v0

    .line 95
    .local v0, "accounts":[Landroid/accounts/Account;
    if-eqz v0, :cond_0

    array-length v3, v0

    if-lez v3, :cond_0

    .line 96
    iget-object v3, p0, Lco/vine/android/util/ContactsHelper;->mListener:Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    const/4 v4, 0x0

    aget-object v4, v0, v4

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-interface {v3, v4}, Lco/vine/android/util/ContactsHelper$ContactHelperListener;->onEmailLoaded(Ljava/lang/String;)V

    .line 99
    .end local v0    # "accounts":[Landroid/accounts/Account;
    .end local v1    # "lm":Landroid/support/v4/app/LoaderManager;
    .end local v2    # "manager":Landroid/accounts/AccountManager;
    :cond_0
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 12
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v11, 0x0

    const/4 v4, 0x0

    .line 103
    packed-switch p1, :pswitch_data_0

    move-object v0, v4

    .line 117
    :goto_0
    return-object v0

    .line 105
    :pswitch_0
    new-instance v0, Lco/vine/android/util/ContactsHelper$ContactCursorLoader;

    iget-object v1, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Landroid/provider/ContactsContract$Profile;->CONTENT_URI:Landroid/net/Uri;

    new-array v3, v3, [Ljava/lang/String;

    const-string v5, "display_name"

    aput-object v5, v3, v11

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Lco/vine/android/util/ContactsHelper$ContactCursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 109
    :pswitch_1
    new-instance v5, Lco/vine/android/util/ContactsHelper$ContactCursorLoader;

    iget-object v0, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    sget-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_URI:Landroid/net/Uri;

    const-string v1, "data"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    sget-object v8, Lco/vine/android/util/ContactsHelper$ProfileQuery;->PROJECTION:[Ljava/lang/String;

    const-string v9, "mimetype=?"

    new-array v10, v3, [Ljava/lang/String;

    const-string v0, "vnd.android.cursor.item/phone_v2"

    aput-object v0, v10, v11

    move-object v11, v4

    invoke-direct/range {v5 .. v11}, Lco/vine/android/util/ContactsHelper$ContactCursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    goto :goto_0

    .line 103
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 6
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 141
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 143
    :pswitch_0
    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 144
    const-string v4, "display_name"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "name":Ljava/lang/String;
    iget-object v4, p0, Lco/vine/android/util/ContactsHelper;->mListener:Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    invoke-interface {v4, v1}, Lco/vine/android/util/ContactsHelper$ContactHelperListener;->onNameLoaded(Ljava/lang/String;)V

    goto :goto_0

    .line 151
    .end local v1    # "name":Ljava/lang/String;
    :pswitch_1
    const/4 v2, 0x0

    .line 152
    .local v2, "phone":Ljava/lang/String;
    if-eqz p2, :cond_1

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 153
    const/4 v4, 0x2

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 154
    .local v0, "mimeType":Ljava/lang/String;
    const-string v4, "vnd.android.cursor.item/phone_v2"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 155
    const/4 v4, 0x1

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 158
    .end local v0    # "mimeType":Ljava/lang/String;
    :cond_1
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 160
    iget-object v4, p0, Lco/vine/android/util/ContactsHelper;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v4}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "phone"

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/telephony/TelephonyManager;

    .line 162
    .local v3, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual {v3}, Landroid/telephony/TelephonyManager;->getLine1Number()Ljava/lang/String;

    move-result-object v2

    .line 164
    .end local v3    # "tm":Landroid/telephony/TelephonyManager;
    :cond_2
    iget-object v4, p0, Lco/vine/android/util/ContactsHelper;->mListener:Lco/vine/android/util/ContactsHelper$ContactHelperListener;

    invoke-interface {v4, v2}, Lco/vine/android/util/ContactsHelper$ContactHelperListener;->onPhoneNumberLoaded(Ljava/lang/String;)V

    goto :goto_0

    .line 141
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/util/ContactsHelper;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 176
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method
