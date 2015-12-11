.class public Lcom/poshmark/utils/sharing/ShowroomShareMessages;
.super Ljava/lang/Object;
.source "ShowroomShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/ShowroomShareMessages$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    return-void
.end method

.method public static getBody(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 123
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06026f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getWebURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "body":Ljava/lang/String;
    return-object v0
.end method

.method public static getDescription(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const v3, 0x7f06010c

    .line 44
    const-string v0, ""

    .line 45
    .local v0, "description":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ShowroomShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 66
    :goto_0
    :pswitch_0
    return-object v0

    .line 47
    :pswitch_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 48
    goto :goto_0

    .line 54
    :pswitch_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060209

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 55
    goto :goto_0

    .line 61
    :pswitch_3
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 62
    goto :goto_0

    .line 45
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public static getImageUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 70
    const-string v0, ""

    .line 71
    .local v0, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v1

    iget-object v0, v1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 72
    return-object v0
.end method

.method public static getMessage(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 76
    const-string v0, ""

    .line 78
    .local v0, "message":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ShowroomShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 109
    const-string v0, ""

    .line 112
    :goto_0
    return-object v0

    .line 80
    :pswitch_0
    const-string v0, ""

    .line 81
    goto :goto_0

    .line 83
    :pswitch_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060273

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 84
    goto :goto_0

    .line 86
    :pswitch_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060274

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 87
    goto :goto_0

    .line 89
    :pswitch_3
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060272

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 90
    goto :goto_0

    .line 92
    :pswitch_4
    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 93
    goto :goto_0

    .line 95
    :pswitch_5
    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getBody(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 96
    goto :goto_0

    .line 98
    :pswitch_6
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060270

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getFullName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 101
    goto/16 :goto_0

    .line 103
    :pswitch_7
    const-string v0, ""

    .line 104
    goto/16 :goto_0

    .line 106
    :pswitch_8
    invoke-static {p0, p1}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getSubject(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 107
    goto/16 :goto_0

    .line 78
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_2
        :pswitch_1
        :pswitch_7
        :pswitch_3
        :pswitch_8
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public static getPlaceHolder(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 20
    const-string v0, ""

    .line 21
    .local v0, "placeHolder":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ShowroomShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 40
    :goto_0
    :pswitch_0
    return-object v0

    .line 37
    :pswitch_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060271

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 21
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static getSubject(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 116
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060270

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFullName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 119
    .local v0, "msg":Ljava/lang/String;
    return-object v0
.end method

.method public static getTitle(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v0

    .line 16
    .local v0, "title":Ljava/lang/String;
    return-object v0
.end method

.method public static getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "showRoom"    # Lcom/poshmark/data_model/models/Showroom;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 133
    const-string v0, ""

    .line 134
    .local v0, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Showroom;->getShortURL()Ljava/lang/String;

    move-result-object v0

    .line 135
    return-object v0
.end method
