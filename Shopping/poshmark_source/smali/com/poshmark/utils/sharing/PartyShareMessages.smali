.class public Lcom/poshmark/utils/sharing/PartyShareMessages;
.super Ljava/lang/Object;
.source "PartyShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/PartyShareMessages$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    return-void
.end method

.method public static getBody(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 7
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 105
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 106
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0601f7

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "body":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    const-string v2, "https://www.poshmark.com"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 113
    :goto_0
    return-object v0

    .line 110
    .end local v0    # "body":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0601f2

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 111
    .restart local v0    # "body":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    const-string v2, "https://www.poshmark.com"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDescription(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getImageUrl(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getMessage(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 41
    const-string v1, ""

    .line 42
    .local v1, "message":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 43
    .local v0, "c":Landroid/content/Context;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 44
    .local v3, "title":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "shareURL":Ljava/lang/String;
    sget-object v4, Lcom/poshmark/utils/sharing/PartyShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 93
    :goto_0
    :pswitch_0
    return-object v1

    .line 50
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 51
    const v4, 0x7f0601fb

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 53
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 54
    const v4, 0x7f06009f

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 57
    :cond_1
    const v4, 0x7f0602b2

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 59
    goto :goto_0

    .line 61
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 62
    const v4, 0x7f06009e

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 64
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 65
    const v4, 0x7f0601fa

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 68
    :cond_3
    const v4, 0x7f0602b1

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 70
    goto/16 :goto_0

    .line 74
    :pswitch_3
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 75
    const v4, 0x7f06009d

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 77
    :cond_4
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 78
    const v4, 0x7f0601f9

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 81
    :cond_5
    const v4, 0x7f0602b0

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v3, v5, v6

    aput-object v2, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 83
    goto/16 :goto_0

    .line 85
    :pswitch_4
    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getBody(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 86
    goto/16 :goto_0

    .line 46
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_0
    .end packed-switch
.end method

.method public static getPlaceHolder(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 22
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0601f6

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 28
    :goto_0
    return-object v0

    .line 24
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 25
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f06009c

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 28
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0602af

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getSubject(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 4
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 97
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0601f8

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 100
    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0601f3

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getTitle(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUrl(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "party"    # Lcom/poshmark/data_model/models/PartyEvent;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
