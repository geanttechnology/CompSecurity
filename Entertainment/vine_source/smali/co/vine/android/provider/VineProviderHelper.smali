.class public Lco/vine/android/provider/VineProviderHelper;
.super Ljava/lang/Object;
.source "VineProviderHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getConversationRecipients(Landroid/content/ContentResolver;J)Ljava/util/ArrayList;
    .locals 19
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "conversationRowId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "J)",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 19
    .local v18, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-static/range {p0 .. p2}, Lco/vine/android/provider/VineProviderHelper;->queryConversationRecipientsUsersView(Landroid/content/ContentResolver;J)Landroid/database/Cursor;

    move-result-object v17

    .line 20
    .local v17, "cursor":Landroid/database/Cursor;
    if-eqz v17, :cond_4

    .line 21
    :cond_0
    :goto_0
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 23
    const/4 v4, 0x2

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    .line 24
    .local v5, "userRowId":J
    const/4 v4, 0x6

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 25
    .local v2, "userId":J
    const/4 v4, 0x5

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 26
    .local v10, "email":Ljava/lang/String;
    const/4 v4, 0x4

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v14

    .line 27
    .local v14, "phone":Ljava/lang/String;
    const/4 v4, 0x3

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 28
    .local v1, "display":Ljava/lang/String;
    const-wide/16 v7, 0x0

    cmp-long v4, v2, v7

    if-lez v4, :cond_1

    .line 29
    const/4 v4, 0x0

    invoke-static/range {v1 .. v6}, Lco/vine/android/api/VineRecipient;->fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 30
    :cond_1
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 31
    const-wide/16 v8, -0x1

    move-object v7, v1

    move-wide v11, v5

    invoke-static/range {v7 .. v12}, Lco/vine/android/api/VineRecipient;->fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 32
    :cond_2
    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 33
    const-wide/16 v12, -0x1

    move-object v11, v1

    move-wide v15, v5

    invoke-static/range {v11 .. v16}, Lco/vine/android/api/VineRecipient;->fromPhone(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 36
    .end local v1    # "display":Ljava/lang/String;
    .end local v2    # "userId":J
    .end local v5    # "userRowId":J
    .end local v10    # "email":Ljava/lang/String;
    .end local v14    # "phone":Ljava/lang/String;
    :cond_3
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    .line 38
    :cond_4
    return-object v18
.end method

.method public static queryConversationRecipientsUsersView(Landroid/content/ContentResolver;J)Landroid/database/Cursor;
    .locals 7
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "conversationRowId"    # J

    .prologue
    const/4 v3, 0x0

    .line 45
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    .line 46
    .local v6, "conversationRowIdString":Ljava/lang/String;
    sget-object v0, Lco/vine/android/provider/Vine$ConversationRecipientsUsersView;->CONTENT_URI_CONVERSATION:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "conversation_row_id"

    invoke-virtual {v0, v2, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 50
    .local v1, "contentUri":Landroid/net/Uri;
    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$ConversationRecipientsUsersViewQuery;->PROJECTION:[Ljava/lang/String;

    move-object v0, p0

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method
