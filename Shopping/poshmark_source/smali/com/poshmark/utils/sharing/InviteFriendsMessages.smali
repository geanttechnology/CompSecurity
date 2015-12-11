.class public Lcom/poshmark/utils/sharing/InviteFriendsMessages;
.super Ljava/lang/Object;
.source "InviteFriendsMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;
    }
.end annotation


# static fields
.field private static final bitlyUrl:Ljava/lang/String; = "http://bit.ly/GetPosh-FB"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public static getBody(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 131
    const-string v0, ""

    .line 132
    .local v0, "body":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "incentiveString":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 154
    :goto_0
    :pswitch_0
    return-object v0

    .line 143
    :pswitch_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060159

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 144
    goto :goto_0

    .line 146
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v2

    iget-object v0, v2, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_body:Ljava/lang/String;

    .line 147
    goto :goto_0

    .line 133
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method public static getDescription(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 44
    const-string v0, ""

    .line 45
    .local v0, "description":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 63
    :pswitch_0
    return-object v0

    .line 45
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getImageUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 67
    const-string v0, ""

    .line 68
    .local v0, "url":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 86
    :pswitch_0
    return-object v0

    .line 68
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getMessage(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 7
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 90
    const-string v2, ""

    .line 91
    .local v2, "msg":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v1

    .line 93
    .local v1, "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    sget-object v3, Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    :goto_0
    :pswitch_0
    move-object v3, v2

    .line 120
    .end local v1    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :goto_1
    return-object v3

    .line 95
    .restart local v1    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :pswitch_1
    iget-object v2, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_desc:Ljava/lang/String;

    .line 96
    goto :goto_0

    .line 98
    :pswitch_2
    iget-object v2, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tw_share:Ljava/lang/String;

    .line 99
    goto :goto_0

    .line 101
    :pswitch_3
    iget-object v2, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tm_share:Ljava/lang/String;

    .line 102
    goto :goto_0

    .line 106
    :pswitch_4
    iget-object v2, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    .line 107
    goto :goto_0

    .line 109
    :pswitch_5
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v3

    iget-object v2, v3, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_body:Ljava/lang/String;

    .line 110
    goto :goto_0

    .line 112
    :pswitch_6
    iget-object v2, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    .line 113
    goto :goto_0

    .line 119
    .end local v1    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 120
    .local v0, "incentiveString":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060159

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 93
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public static getPlaceHolder(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 39
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, "incentiveString":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060159

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getSubject(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 125
    const/4 v0, 0x0

    .line 126
    .local v0, "subject":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v1

    iget-object v0, v1, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_subject:Ljava/lang/String;

    .line 127
    return-object v0
.end method

.method public static getTitle(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 16
    const-string v0, ""

    .line 17
    .local v0, "title":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/InviteFriendsMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 35
    :pswitch_0
    return-object v0

    .line 17
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getUrl(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "referralData"    # Lcom/poshmark/data_model/models/Referral;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 159
    if-eqz p0, :cond_1

    .line 161
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    .line 162
    .local v0, "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    if-eqz v0, :cond_0

    iget-object v2, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share_url:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 163
    iget-object v1, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share_url:Ljava/lang/String;

    .line 171
    .end local v0    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    .local v1, "url":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 166
    .end local v1    # "url":Ljava/lang/String;
    .restart local v0    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :cond_0
    const-string v1, "http://bit.ly/GetPosh-FB"

    .restart local v1    # "url":Ljava/lang/String;
    goto :goto_0

    .line 169
    .end local v0    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    .end local v1    # "url":Ljava/lang/String;
    :cond_1
    const-string v1, "https://www.poshmark.com/getapp"

    .restart local v1    # "url":Ljava/lang/String;
    goto :goto_0
.end method
