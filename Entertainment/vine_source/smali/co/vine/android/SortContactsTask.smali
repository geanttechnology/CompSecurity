.class public Lco/vine/android/SortContactsTask;
.super Landroid/os/AsyncTask;
.source "SortContactsTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Landroid/database/Cursor;",
        "Ljava/lang/Void;",
        "Ljava/util/ArrayList",
        "<",
        "Lco/vine/android/ContactEntry;",
        ">;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 15
    check-cast p1, [Landroid/database/Cursor;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/SortContactsTask;->doInBackground([Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method protected final varargs doInBackground([Landroid/database/Cursor;)Ljava/util/ArrayList;
    .locals 3
    .param p1, "objects"    # [Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/ContactEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    const/4 v2, 0x0

    aget-object v0, p1, v2

    .line 21
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-virtual {p0, v0}, Lco/vine/android/SortContactsTask;->prepareEntries(Landroid/database/Cursor;)Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 24
    :goto_0
    return-object v2

    .line 22
    :catch_0
    move-exception v1

    .line 23
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "Failed to prepare entries, cursor closed?"

    invoke-static {v2, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 24
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method protected prepareEntries(Landroid/database/Cursor;)Ljava/util/ArrayList;
    .locals 12
    .param p1, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/ContactEntry;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 29
    const-string v4, "Sorting contacts."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v4

    invoke-direct {v0, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 31
    .local v0, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/ContactEntry;>;"
    :goto_0
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 33
    const/4 v2, 0x0

    .line 34
    .local v2, "lastEntry":Lco/vine/android/ContactEntry;
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 35
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "lastEntry":Lco/vine/android/ContactEntry;
    check-cast v2, Lco/vine/android/ContactEntry;

    .line 38
    .restart local v2    # "lastEntry":Lco/vine/android/ContactEntry;
    :cond_0
    const/4 v4, 0x3

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 40
    .local v3, "mimetype":Ljava/lang/String;
    if-eqz v2, :cond_2

    iget-wide v8, v2, Lco/vine/android/ContactEntry;->contactId:J

    invoke-interface {p1, v7}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    cmp-long v4, v8, v10

    if-nez v4, :cond_2

    .line 42
    move-object v1, v2

    .line 43
    .local v1, "entry":Lco/vine/android/ContactEntry;
    iget v8, v1, Lco/vine/android/ContactEntry;->typeFlag:I

    const-string v4, "vnd.android.cursor.item/email_v2"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    move v4, v5

    :goto_1
    or-int/2addr v4, v8

    iput v4, v1, Lco/vine/android/ContactEntry;->typeFlag:I

    .line 48
    :goto_2
    iget-object v9, v1, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    const/4 v4, 0x4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    const-string v4, "vnd.android.cursor.item/email_v2"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    move v4, v5

    :goto_3
    const-string v8, "vnd.android.cursor.item/phone_v2"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    move v8, v6

    :goto_4
    or-int/2addr v4, v8

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v9, v10, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_1
    move v4, v6

    .line 43
    goto :goto_1

    .line 45
    .end local v1    # "entry":Lco/vine/android/ContactEntry;
    :cond_2
    new-instance v1, Lco/vine/android/ContactEntry;

    invoke-direct {v1, p1}, Lco/vine/android/ContactEntry;-><init>(Landroid/database/Cursor;)V

    .line 46
    .restart local v1    # "entry":Lco/vine/android/ContactEntry;
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_3
    move v4, v7

    .line 48
    goto :goto_3

    :cond_4
    move v8, v7

    goto :goto_4

    .line 56
    .end local v1    # "entry":Lco/vine/android/ContactEntry;
    .end local v2    # "lastEntry":Lco/vine/android/ContactEntry;
    .end local v3    # "mimetype":Ljava/lang/String;
    :cond_5
    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 57
    const-string v4, "Sorting contacts complete."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 58
    return-object v0
.end method
