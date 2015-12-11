.class Lco/vine/android/util/ContactsHelper$ContactCursorLoader;
.super Landroid/support/v4/content/CursorLoader;
.source "ContactsHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ContactsHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ContactCursorLoader"
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "projection"    # [Ljava/lang/String;
    .param p4, "selection"    # Ljava/lang/String;
    .param p5, "selectionArgs"    # [Ljava/lang/String;
    .param p6, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-direct/range {p0 .. p6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    return-void
.end method


# virtual methods
.method public loadInBackground()Landroid/database/Cursor;
    .locals 2

    .prologue
    .line 131
    :try_start_0
    invoke-super {p0}, Landroid/support/v4/content/CursorLoader;->loadInBackground()Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 134
    :goto_0
    return-object v1

    .line 132
    :catch_0
    move-exception v0

    .line 133
    .local v0, "e":Ljava/lang/Throwable;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 134
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 122
    invoke-virtual {p0}, Lco/vine/android/util/ContactsHelper$ContactCursorLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method
