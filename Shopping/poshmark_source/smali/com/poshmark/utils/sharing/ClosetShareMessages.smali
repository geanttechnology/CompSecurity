.class public Lcom/poshmark/utils/sharing/ClosetShareMessages;
.super Ljava/lang/Object;
.source "ClosetShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/ClosetShareMessages$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method

.method public static getBody(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 10
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p2, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 134
    const-string v0, ""

    .line 135
    .local v0, "body":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v1

    .line 136
    .local v1, "imgURL":Ljava/lang/String;
    invoke-static {p0}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 137
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06007b

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferrerIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    aput-object v1, v3, v8

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v9

    const/4 v4, 0x5

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 152
    :goto_0
    return-object v0

    .line 145
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06007a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v9, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    aput-object v1, v3, v7

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDescription(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 8
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p2, "closetShortURL"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v3, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 28
    const/4 v0, 0x0

    .line 29
    .local v0, "description":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ClosetShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p3}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 51
    :goto_0
    :pswitch_0
    return-object v0

    .line 37
    :pswitch_1
    invoke-static {p0}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060081

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    aput-object p2, v2, v7

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 40
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060080

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    aput-object p2, v2, v7

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 41
    goto :goto_0

    .line 29
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getImageUrl(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 55
    const/4 v0, 0x0

    .line 56
    .local v0, "url":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ClosetShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 75
    :goto_0
    :pswitch_0
    return-object v0

    .line 64
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v1

    iget-object v0, v1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 65
    goto :goto_0

    .line 56
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getMessage(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p2, "closetShortURL"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v4, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 79
    const/4 v1, 0x0

    .line 80
    .local v1, "message":Ljava/lang/String;
    invoke-static {p0}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z

    move-result v0

    .line 81
    .local v0, "isClosetOwner":Z
    sget-object v2, Lcom/poshmark/utils/sharing/ClosetShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p3}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 118
    :pswitch_0
    const-string v1, ""

    .line 121
    :goto_0
    return-object v1

    .line 83
    :pswitch_1
    const-string v1, ""

    .line 84
    goto :goto_0

    .line 86
    :pswitch_2
    if-eqz v0, :cond_0

    .line 87
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060086

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 89
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060085

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 90
    goto :goto_0

    .line 92
    :pswitch_3
    if-eqz v0, :cond_1

    .line 93
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060088

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    aput-object p2, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 95
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060087

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    aput-object p2, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 96
    goto/16 :goto_0

    .line 98
    :pswitch_4
    if-eqz v0, :cond_2

    .line 99
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060083

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    aput-object p0, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 101
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060082

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object p2, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 102
    goto/16 :goto_0

    .line 105
    :pswitch_5
    move-object v1, p2

    .line 106
    goto/16 :goto_0

    .line 109
    :pswitch_6
    invoke-static {p0, p1, p3}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getBody(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 110
    goto/16 :goto_0

    .line 112
    :pswitch_7
    if-eqz v0, :cond_3

    .line 113
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06007d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 115
    :cond_3
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06007c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 116
    goto/16 :goto_0

    .line 81
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_1
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static getPlaceHolder(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 4
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 21
    invoke-static {p0}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 22
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f06007f

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 24
    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f06007e

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getSubject(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v4, 0x0

    .line 125
    const/4 v0, 0x0

    .line 126
    .local v0, "subject":Ljava/lang/String;
    invoke-static {p0}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 127
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06007d

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 130
    :goto_0
    return-object v0

    .line 129
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06007c

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getTitle(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 4
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 16
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060084

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 17
    .local v0, "title":Ljava/lang/String;
    return-object v0
.end method

.method public static getUrl(Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 1
    .param p0, "closetShortUrl"    # Ljava/lang/String;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "url":Ljava/lang/String;
    move-object v0, p0

    .line 158
    return-object v0
.end method

.method public static isClosetOwner(Lcom/poshmark/user/UserInfoDetails;)Z
    .locals 2
    .param p0, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 162
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
